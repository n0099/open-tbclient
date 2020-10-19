package com.baidu.tieba.pb.pb.main.b;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbPostShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class c {
    public a lnS = new a() { // from class: com.baidu.tieba.pb.pb.main.b.c.1
        @Override // com.baidu.tieba.pb.pb.main.b.c.a
        public void a(f fVar, bw bwVar, PostData postData, com.baidu.tbadk.widget.richText.a aVar) {
            String shareImageUrl;
            String tid;
            String str;
            if ((fVar != null || bwVar != null) && postData != null && c.this.mPageContext != null) {
                if (fVar == null) {
                    shareImageUrl = c.this.getShareImageUrl(bwVar);
                } else {
                    shareImageUrl = fVar.r(c.this.mPageContext.getPageActivity(), false)[0];
                    if (!StringUtils.isNull(shareImageUrl) && shareImageUrl.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        shareImageUrl = shareImageUrl.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    bwVar = fVar.dcA();
                    if (bwVar == null) {
                        return;
                    }
                }
                m mVar = new m();
                mVar.setContent(bwVar.getAbstract());
                if (!StringUtils.isNull(shareImageUrl)) {
                    mVar.OE(shareImageUrl);
                }
                mVar.setThreadType(bwVar.getThreadType());
                mVar.b(aVar);
                mVar.g(postData);
                String title = bwVar.getTitle();
                if (StringUtils.isNull(title)) {
                    title = bwVar.getAbstract();
                }
                mVar.setContent(title);
                if (bwVar.bgR()) {
                    tid = bwVar.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&dtype=" + bwVar.getBaijiahaoData().oriUgcType + "&dvid=" + bwVar.getBaijiahaoData().oriUgcVid + "&nid=" + bwVar.getBaijiahaoData().oriUgcNid;
                } else {
                    tid = bwVar.getTid();
                    str = "?share=9105&fr=share";
                }
                mVar.E(c.this.Pl("http://tieba.baidu.com/p/" + tid + (str + "&post_id=" + postData.getId() + "&share_from=comment&post_sort=1")));
                ShareItem shareItem = new ShareItem();
                shareItem.shareType = 1;
                shareItem.eSA = true;
                shareItem.extData = tid;
                shareItem.pid = postData.getId();
                Bundle bundle = new Bundle();
                bundle.putString("tid", tid);
                bundle.putString("pid", postData.getId());
                bundle.putInt("source", 1);
                shareItem.ae(bundle);
                PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(c.this.mPageContext.getPageActivity(), shareItem, true, mVar);
                pbPostShareDialogConfig.setIsCopyLink(false);
                pbPostShareDialogConfig.setHideMode(pbPostShareDialogConfig.hideMode | 32);
                c.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, pbPostShareDialogConfig));
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar.dK("tid", tid);
                aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                if (bwVar.bjV() != null) {
                    aqVar.dK("fid", bwVar.bjV().forumId);
                }
                if (bwVar.bjK() != null) {
                    aqVar.dK("post_id", postData.getId());
                }
                aqVar.aj("obj_locate", 21);
                TiebaStatic.log(aqVar);
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes22.dex */
    public interface a {
        void a(f fVar, bw bwVar, PostData postData, com.baidu.tbadk.widget.richText.a aVar);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap Pl(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return null;
        }
        return (Bitmap) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getShareImageUrl(bw bwVar) {
        String str;
        if (bwVar == null) {
            return null;
        }
        if (bwVar.biB() != null && !TextUtils.isEmpty(bwVar.biB().cover)) {
            return bwVar.biB().cover;
        }
        if (bwVar.biq() == null) {
            return null;
        }
        ArrayList<MediaData> biq = bwVar.biq();
        int size = biq.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = biq.get(i);
            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    str = mediaData.getThumbnails_url();
                    break;
                } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    str = mediaData.getPicUrl();
                    break;
                }
            }
            i++;
        }
        if (str == null && bwVar.biz() != null && !TextUtils.isEmpty(bwVar.biz().thumbnail_url)) {
            return bwVar.biz().thumbnail_url;
        }
        return str;
    }
}
