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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    private TbPageContext mPageContext;
    public a mgG = new a() { // from class: com.baidu.tieba.pb.pb.main.b.c.1
        @Override // com.baidu.tieba.pb.pb.main.b.c.a
        public void a(f fVar, cb cbVar, PostData postData, com.baidu.tbadk.widget.richText.a aVar) {
            String shareImageUrl;
            String tid;
            String str;
            if ((fVar != null || cbVar != null) && postData != null && c.this.mPageContext != null) {
                if (fVar == null) {
                    shareImageUrl = c.this.getShareImageUrl(cbVar);
                } else {
                    shareImageUrl = fVar.t(c.this.mPageContext.getPageActivity(), false)[0];
                    if (!StringUtils.isNull(shareImageUrl) && shareImageUrl.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        shareImageUrl = shareImageUrl.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    cbVar = fVar.dlp();
                    if (cbVar == null) {
                        return;
                    }
                }
                n nVar = new n();
                nVar.setContent(cbVar.getAbstract());
                if (!StringUtils.isNull(shareImageUrl)) {
                    nVar.Pt(shareImageUrl);
                }
                nVar.setThreadType(cbVar.getThreadType());
                nVar.b(aVar);
                nVar.g(postData);
                String title = cbVar.getTitle();
                if (StringUtils.isNull(title)) {
                    title = cbVar.getAbstract();
                }
                nVar.setContent(title);
                if (cbVar.bmB()) {
                    tid = cbVar.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&dtype=" + cbVar.getBaijiahaoData().oriUgcType + "&dvid=" + cbVar.getBaijiahaoData().oriUgcVid + "&nid=" + cbVar.getBaijiahaoData().oriUgcNid;
                } else {
                    tid = cbVar.getTid();
                    str = "?share=9105&fr=share";
                }
                nVar.E(c.this.Qa("http://tieba.baidu.com/p/" + tid + (str + "&post_id=" + postData.getId() + "&share_from=comment&post_sort=1")));
                ShareItem shareItem = new ShareItem();
                shareItem.shareType = 1;
                shareItem.fwn = true;
                shareItem.extData = tid;
                shareItem.pid = postData.getId();
                Bundle bundle = new Bundle();
                bundle.putString("tid", tid);
                bundle.putString("pid", postData.getId());
                bundle.putInt("source", 1);
                shareItem.ae(bundle);
                PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(c.this.mPageContext.getPageActivity(), shareItem, true, nVar);
                pbPostShareDialogConfig.setIsCopyLink(false);
                pbPostShareDialogConfig.setHideMode(pbPostShareDialogConfig.hideMode | 32);
                c.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, pbPostShareDialogConfig));
                ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar.dR("tid", tid);
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (cbVar.bpI() != null) {
                    arVar.dR("fid", cbVar.bpI().forumId);
                }
                if (cbVar.bpx() != null) {
                    arVar.dR("post_id", postData.getId());
                }
                arVar.aq("obj_locate", 21);
                TiebaStatic.log(arVar);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(f fVar, cb cbVar, PostData postData, com.baidu.tbadk.widget.richText.a aVar);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap Qa(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return null;
        }
        return (Bitmap) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getShareImageUrl(cb cbVar) {
        String str;
        if (cbVar == null) {
            return null;
        }
        if (cbVar.bol() != null && !TextUtils.isEmpty(cbVar.bol().cover)) {
            return cbVar.bol().cover;
        }
        if (cbVar.bob() == null) {
            return null;
        }
        ArrayList<MediaData> bob = cbVar.bob();
        int size = bob.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = bob.get(i);
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
        if (str == null && cbVar.boj() != null && !TextUtils.isEmpty(cbVar.boj().thumbnail_url)) {
            return cbVar.boj().thumbnail_url;
        }
        return str;
    }
}
