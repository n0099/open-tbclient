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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class c {
    public a lUD = new a() { // from class: com.baidu.tieba.pb.pb.main.b.c.1
        @Override // com.baidu.tieba.pb.pb.main.b.c.a
        public void a(f fVar, by byVar, PostData postData, com.baidu.tbadk.widget.richText.a aVar) {
            String shareImageUrl;
            String tid;
            String str;
            if ((fVar != null || byVar != null) && postData != null && c.this.mPageContext != null) {
                if (fVar == null) {
                    shareImageUrl = c.this.getShareImageUrl(byVar);
                } else {
                    shareImageUrl = fVar.w(c.this.mPageContext.getPageActivity(), false)[0];
                    if (!StringUtils.isNull(shareImageUrl) && shareImageUrl.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        shareImageUrl = shareImageUrl.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    byVar = fVar.dmU();
                    if (byVar == null) {
                        return;
                    }
                }
                m mVar = new m();
                mVar.setContent(byVar.getAbstract());
                if (!StringUtils.isNull(shareImageUrl)) {
                    mVar.PX(shareImageUrl);
                }
                mVar.setThreadType(byVar.getThreadType());
                mVar.b(aVar);
                mVar.g(postData);
                String title = byVar.getTitle();
                if (StringUtils.isNull(title)) {
                    title = byVar.getAbstract();
                }
                mVar.setContent(title);
                if (byVar.bnz()) {
                    tid = byVar.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&dtype=" + byVar.getBaijiahaoData().oriUgcType + "&dvid=" + byVar.getBaijiahaoData().oriUgcVid + "&nid=" + byVar.getBaijiahaoData().oriUgcNid;
                } else {
                    tid = byVar.getTid();
                    str = "?share=9105&fr=share";
                }
                mVar.E(c.this.QE("http://tieba.baidu.com/p/" + tid + (str + "&post_id=" + postData.getId() + "&share_from=comment&post_sort=1")));
                ShareItem shareItem = new ShareItem();
                shareItem.shareType = 1;
                shareItem.fnv = true;
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
                arVar.dY("tid", tid);
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                if (byVar.bqF() != null) {
                    arVar.dY("fid", byVar.bqF().forumId);
                }
                if (byVar.bqu() != null) {
                    arVar.dY("post_id", postData.getId());
                }
                arVar.al("obj_locate", 21);
                TiebaStatic.log(arVar);
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes22.dex */
    public interface a {
        void a(f fVar, by byVar, PostData postData, com.baidu.tbadk.widget.richText.a aVar);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap QE(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return null;
        }
        return (Bitmap) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getShareImageUrl(by byVar) {
        String str;
        if (byVar == null) {
            return null;
        }
        if (byVar.bpj() != null && !TextUtils.isEmpty(byVar.bpj().cover)) {
            return byVar.bpj().cover;
        }
        if (byVar.boY() == null) {
            return null;
        }
        ArrayList<MediaData> boY = byVar.boY();
        int size = boY.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = boY.get(i);
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
        if (str == null && byVar.bph() != null && !TextUtils.isEmpty(byVar.bph().thumbnail_url)) {
            return byVar.bph().thumbnail_url;
        }
        return str;
    }
}
