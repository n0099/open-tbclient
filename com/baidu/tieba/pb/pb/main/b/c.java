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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class c {
    public a lGI = new a() { // from class: com.baidu.tieba.pb.pb.main.b.c.1
        @Override // com.baidu.tieba.pb.pb.main.b.c.a
        public void a(f fVar, bx bxVar, PostData postData, com.baidu.tbadk.widget.richText.a aVar) {
            String shareImageUrl;
            String tid;
            String str;
            if ((fVar != null || bxVar != null) && postData != null && c.this.mPageContext != null) {
                if (fVar == null) {
                    shareImageUrl = c.this.getShareImageUrl(bxVar);
                } else {
                    shareImageUrl = fVar.r(c.this.mPageContext.getPageActivity(), false)[0];
                    if (!StringUtils.isNull(shareImageUrl) && shareImageUrl.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        shareImageUrl = shareImageUrl.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    bxVar = fVar.dhH();
                    if (bxVar == null) {
                        return;
                    }
                }
                m mVar = new m();
                mVar.setContent(bxVar.getAbstract());
                if (!StringUtils.isNull(shareImageUrl)) {
                    mVar.OP(shareImageUrl);
                }
                mVar.setThreadType(bxVar.getThreadType());
                mVar.b(aVar);
                mVar.g(postData);
                String title = bxVar.getTitle();
                if (StringUtils.isNull(title)) {
                    title = bxVar.getAbstract();
                }
                mVar.setContent(title);
                if (bxVar.bkm()) {
                    tid = bxVar.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&dtype=" + bxVar.getBaijiahaoData().oriUgcType + "&dvid=" + bxVar.getBaijiahaoData().oriUgcVid + "&nid=" + bxVar.getBaijiahaoData().oriUgcNid;
                } else {
                    tid = bxVar.getTid();
                    str = "?share=9105&fr=share";
                }
                mVar.E(c.this.Pw("http://tieba.baidu.com/p/" + tid + (str + "&post_id=" + postData.getId() + "&share_from=comment&post_sort=1")));
                ShareItem shareItem = new ShareItem();
                shareItem.shareType = 1;
                shareItem.ffV = true;
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
                ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar.dR("tid", tid);
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (bxVar.bns() != null) {
                    arVar.dR("fid", bxVar.bns().forumId);
                }
                if (bxVar.bnh() != null) {
                    arVar.dR("post_id", postData.getId());
                }
                arVar.ak("obj_locate", 21);
                TiebaStatic.log(arVar);
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes21.dex */
    public interface a {
        void a(f fVar, bx bxVar, PostData postData, com.baidu.tbadk.widget.richText.a aVar);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap Pw(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return null;
        }
        return (Bitmap) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getShareImageUrl(bx bxVar) {
        String str;
        if (bxVar == null) {
            return null;
        }
        if (bxVar.blW() != null && !TextUtils.isEmpty(bxVar.blW().cover)) {
            return bxVar.blW().cover;
        }
        if (bxVar.blL() == null) {
            return null;
        }
        ArrayList<MediaData> blL = bxVar.blL();
        int size = blL.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = blL.get(i);
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
        if (str == null && bxVar.blU() != null && !TextUtils.isEmpty(bxVar.blU().thumbnail_url)) {
            return bxVar.blU().thumbnail_url;
        }
        return str;
    }
}
