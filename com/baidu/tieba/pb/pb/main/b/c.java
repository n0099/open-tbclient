package com.baidu.tieba.pb.pb.main.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbPostShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class c {
    public a kAo = new a() { // from class: com.baidu.tieba.pb.pb.main.b.c.1
        @Override // com.baidu.tieba.pb.pb.main.b.c.a
        public void a(f fVar, bv bvVar, PostData postData, View view) {
            String shareImageUrl;
            String tid;
            String str;
            if ((fVar != null || bvVar != null) && postData != null && view != null && c.this.mPageContext != null) {
                if (fVar == null) {
                    shareImageUrl = c.this.getShareImageUrl(bvVar);
                } else {
                    shareImageUrl = fVar.p(c.this.mPageContext.getPageActivity(), false)[0];
                    if (!StringUtils.isNull(shareImageUrl) && shareImageUrl.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        shareImageUrl = shareImageUrl.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    bvVar = fVar.cKx();
                    if (bvVar == null) {
                        return;
                    }
                }
                Bitmap cR = c.this.cR(view);
                m mVar = new m();
                mVar.E(cR);
                mVar.setContent(bvVar.getAbstract());
                if (bvVar.aWD() != null) {
                    mVar.rU(true);
                    mVar.Kt(StringUtils.translateSecondsToString(bvVar.aWD().video_duration.intValue()));
                } else {
                    mVar.rU(false);
                }
                if (!StringUtils.isNull(shareImageUrl)) {
                    mVar.Ku(shareImageUrl);
                }
                String title = bvVar.getTitle();
                if (StringUtils.isNull(title)) {
                    title = bvVar.getAbstract();
                }
                mVar.setContent(title);
                if (bvVar.aUV()) {
                    tid = bvVar.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&dtype=" + bvVar.getBaijiahaoData().oriUgcType + "&dvid=" + bvVar.getBaijiahaoData().oriUgcVid + "&nid=" + bvVar.getBaijiahaoData().oriUgcNid;
                } else {
                    tid = bvVar.getTid();
                    str = "?share=9105&fr=share";
                }
                mVar.F(c.this.Lb("http://tieba.baidu.com/p/" + tid + str));
                ShareItem shareItem = new ShareItem();
                shareItem.shareType = 1;
                PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(c.this.mPageContext.getPageActivity(), shareItem, true, mVar);
                pbPostShareDialogConfig.setIsCopyLink(false);
                pbPostShareDialogConfig.setHideMode(pbPostShareDialogConfig.hideMode | 32);
                c.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, pbPostShareDialogConfig));
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes16.dex */
    public interface a {
        void a(f fVar, bv bvVar, PostData postData, View view);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap cR(View view) {
        Bitmap createBitmap = Bitmap.createBitmap((view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight(), (view.getHeight() - view.getPaddingTop()) - view.getPaddingBottom(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap Lb(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return null;
        }
        return (Bitmap) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getShareImageUrl(bv bvVar) {
        String str;
        if (bvVar == null) {
            return null;
        }
        if (bvVar.aWF() != null && !TextUtils.isEmpty(bvVar.aWF().cover)) {
            return bvVar.aWF().cover;
        }
        if (bvVar.aWu() == null) {
            return null;
        }
        ArrayList<MediaData> aWu = bvVar.aWu();
        int size = aWu.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aWu.get(i);
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
        if (str == null && bvVar.aWD() != null && !TextUtils.isEmpty(bvVar.aWD().thumbnail_url)) {
            return bvVar.aWD().thumbnail_url;
        }
        return str;
    }
}
