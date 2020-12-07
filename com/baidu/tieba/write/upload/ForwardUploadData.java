package com.baidu.tieba.write.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ForwardUploadData extends BaseUploadData implements Serializable {
    public static final String FORWARD_CHANNEL = "swan_details_tieba_post_share_collect_comment";
    public static final String FORWARD_NORMAL_THREAD_URL = "https://mbd.baidu.com/ma/landingpage?t=smartapp_share&appid=flFqXclepWs7RdugAszy9eERL7G5dS0I&url=/pages/pb/pb?tid=";
    public static final String FORWARD_THUMBPIC_DEFAULT = "https://b.bdstatic.com/searchbox/mappconsole/image/20180614/1528975601-43867.png";
    public ExtInfo extInfo;
    public Forward forward;
    public String forward_content;

    /* loaded from: classes.dex */
    public static final class ExtInfo implements Serializable {
        public String forward_comment_thread_id;
        public String forward_is_comment;
        public String forward_rel_id;
        public String share_type;
    }

    /* loaded from: classes.dex */
    public static class Forward implements Serializable {
        public String account_type;
        public String avatar;
        public String channel;
        public String id;
        public String nid;
        public String pic_count;
        public String ref_type;
        public String thumbpic;
        public String tid;
        public String title;
        public String url;
        public String video_duration;
    }

    public ForwardUploadData() {
        this.publishType = "5";
    }

    public void parseForwardAndExt(ShareItem.ForwardInfo forwardInfo) {
        if (forwardInfo.isShareType) {
            addParams2TransmitThread(forwardInfo);
        } else {
            addParams2NormalThread(forwardInfo);
        }
    }

    private void addParams2NormalThread(ShareItem.ForwardInfo forwardInfo) {
        this.forward_content = "";
        this.forward = new Forward();
        if (!TextUtils.isEmpty(forwardInfo.showText)) {
            this.forward.title = forwardInfo.showText;
        } else {
            this.forward.title = TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        if (!TextUtils.isEmpty(forwardInfo.showPicUrl)) {
            this.forward.thumbpic = getThumbpic(forwardInfo.showPicUrl);
        } else {
            this.forward.thumbpic = FORWARD_THUMBPIC_DEFAULT;
        }
        if (forwardInfo.isDynamic) {
            if (forwardInfo.baijiahaoData != null && !TextUtils.isEmpty(forwardInfo.baijiahaoData.oriUgcNid)) {
                if (forwardInfo.baijiahaoData.oriUgcType == 1) {
                    this.forward.account_type = "";
                    this.forward.channel = "bjh_details_share_collect_comment";
                    this.forward.id = "";
                    this.forward.nid = "news_" + forwardInfo.baijiahaoData.oriUgcNid;
                    this.forward.ref_type = "imagetext";
                    this.forward.url = forwardInfo.baijiahaoData.forwardUrl;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 2) {
                    this.forward.account_type = "";
                    this.forward.channel = "sv_shortdetails_share_collect_comment";
                    this.forward.id = "";
                    this.forward.nid = "sv_" + forwardInfo.baijiahaoData.oriUgcNid;
                    this.forward.ref_type = "video";
                    this.forward.url = forwardInfo.baijiahaoData.forwardUrl;
                    this.forward.video_duration = forwardInfo.video_duration;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 3) {
                    this.forward.account_type = "ugcsimple";
                    this.forward.channel = "ugc_user_share_collect_comment";
                    this.forward.id = forwardInfo.baijiahaoData.oriUgcNid;
                    this.forward.nid = "dt_" + forwardInfo.baijiahaoData.oriUgcNid;
                    this.forward.ref_type = "imagetext";
                    this.forward.avatar = forwardInfo.avatar;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 4) {
                    this.forward.account_type = "ugcsimple";
                    this.forward.channel = "sv_user_share_collect_comment";
                    this.forward.id = forwardInfo.baijiahaoData.oriUgcVid;
                    this.forward.nid = "dt_" + forwardInfo.baijiahaoData.oriUgcNid;
                    this.forward.ref_type = "video";
                    this.forward.avatar = forwardInfo.avatar;
                }
            }
        } else {
            this.forward.tid = forwardInfo.originalTid;
            this.forward.account_type = "swan";
            this.forward.url = FORWARD_NORMAL_THREAD_URL + forwardInfo.originalTid;
            this.forward.channel = FORWARD_CHANNEL;
            if (forwardInfo.showType == 3) {
                this.forward.ref_type = "video";
            } else {
                this.forward.ref_type = "imagetext";
            }
        }
        this.extInfo = new ExtInfo();
        this.extInfo.share_type = "forward";
        this.extInfo.forward_is_comment = "0";
    }

    private void addParams2TransmitThread(ShareItem.ForwardInfo forwardInfo) {
        if (!TextUtils.isEmpty(forwardInfo.transmitOriginThreadComment)) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                sb.append(UgcConstant.AT_RULE_TAG);
                sb.append(forwardInfo.transmitThreadAuthorNameShow);
                sb.append(" : ");
                sb.append(forwardInfo.transmitOriginThreadComment);
            } else {
                sb.append(forwardInfo.transmitOriginThreadComment);
            }
            this.forward_content = sb.toString();
        } else {
            this.forward_content = "";
        }
        this.forward = new Forward();
        if (!TextUtils.isEmpty(forwardInfo.showText)) {
            this.forward.title = forwardInfo.showText;
        } else {
            this.forward.title = TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        if (!TextUtils.isEmpty(forwardInfo.showPicUrl)) {
            this.forward.thumbpic = getThumbpic(forwardInfo.showPicUrl);
        } else {
            this.forward.thumbpic = FORWARD_THUMBPIC_DEFAULT;
        }
        if (forwardInfo.isDynamic) {
            if (forwardInfo.originalBaijiahaoData != null && !TextUtils.isEmpty(forwardInfo.originalBaijiahaoData.oriUgcNid)) {
                if (forwardInfo.originalBaijiahaoData.oriUgcType == 1) {
                    this.forward.account_type = "";
                    this.forward.channel = "bjh_details_share_collect_comment";
                    this.forward.id = "";
                    this.forward.nid = "news_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    this.forward.ref_type = "imagetext";
                    this.forward.url = forwardInfo.originalBaijiahaoData.forwardUrl;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 2) {
                    this.forward.account_type = "";
                    this.forward.channel = "sv_shortdetails_share_collect_comment";
                    this.forward.id = "";
                    this.forward.nid = "sv_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    this.forward.ref_type = "video";
                    this.forward.url = forwardInfo.originalBaijiahaoData.forwardUrl;
                    this.forward.video_duration = forwardInfo.video_duration;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 3) {
                    this.forward.account_type = "ugcsimple";
                    this.forward.channel = "ugc_user_share_collect_comment";
                    this.forward.id = forwardInfo.originalBaijiahaoData.oriUgcNid;
                    this.forward.nid = "dt_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    this.forward.ref_type = "imagetext";
                    this.forward.avatar = forwardInfo.avatar;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 4) {
                    this.forward.account_type = "ugcsimple";
                    this.forward.channel = "sv_user_share_collect_comment";
                    this.forward.id = forwardInfo.originalBaijiahaoData.oriUgcVid;
                    this.forward.nid = "dt_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    this.forward.ref_type = "video";
                    this.forward.avatar = forwardInfo.avatar;
                }
            }
        } else {
            this.forward.tid = forwardInfo.originalTid;
            this.forward.account_type = "swan";
            this.forward.url = FORWARD_NORMAL_THREAD_URL + forwardInfo.originalTid;
            this.forward.channel = FORWARD_CHANNEL;
            if (forwardInfo.showType == 3) {
                this.forward.ref_type = "video";
            } else {
                this.forward.ref_type = "imagetext";
            }
        }
        this.extInfo = new ExtInfo();
        this.extInfo.share_type = "forward";
        if (forwardInfo.baijiahaoData != null && !TextUtils.isEmpty(forwardInfo.baijiahaoData.oriUgcNid)) {
            this.extInfo.forward_rel_id = forwardInfo.baijiahaoData.oriUgcNid;
        }
        this.extInfo.forward_is_comment = "0";
    }

    public static String getThumbpic(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
            int indexOf = str.indexOf("=");
            int length = str.length();
            if (indexOf != -1 && indexOf + 1 != length) {
                String urlDecode = k.getUrlDecode(str.substring(indexOf + 1));
                return !TextUtils.isEmpty(urlDecode) ? urlDecode : str;
            }
            return str;
        }
        return str;
    }
}
