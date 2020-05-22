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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class c {
    public a jWu = new a() { // from class: com.baidu.tieba.pb.pb.main.b.c.1
        @Override // com.baidu.tieba.pb.pb.main.b.c.a
        public void a(e eVar, bk bkVar, PostData postData, View view) {
            String A;
            String tid;
            String str;
            if ((eVar != null || bkVar != null) && postData != null && view != null && c.this.mPageContext != null) {
                if (eVar == null) {
                    A = c.this.A(bkVar);
                } else {
                    A = eVar.o(c.this.mPageContext.getPageActivity(), false)[0];
                    if (!StringUtils.isNull(A) && A.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        A = A.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    bkVar = eVar.cCi();
                    if (bkVar == null) {
                        return;
                    }
                }
                Bitmap cK = c.this.cK(view);
                k kVar = new k();
                kVar.B(cK);
                kVar.setContent(bkVar.getAbstract());
                if (bkVar.aQQ() != null) {
                    kVar.rc(true);
                    kVar.Je(StringUtils.translateSecondsToString(bkVar.aQQ().video_duration.intValue()));
                } else {
                    kVar.rc(false);
                }
                if (!StringUtils.isNull(A)) {
                    kVar.Jf(A);
                }
                String title = bkVar.getTitle();
                if (StringUtils.isNull(title)) {
                    title = bkVar.getAbstract();
                }
                kVar.setContent(title);
                if (bkVar.aSx()) {
                    tid = bkVar.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&dtype=" + bkVar.getBaijiahaoData().oriUgcType + "&dvid=" + bkVar.getBaijiahaoData().oriUgcVid + "&nid=" + bkVar.getBaijiahaoData().oriUgcNid;
                } else {
                    tid = bkVar.getTid();
                    str = "?share=9105&fr=share";
                }
                kVar.C(c.this.JL("http://tieba.baidu.com/p/" + tid + str));
                ShareItem shareItem = new ShareItem();
                shareItem.shareType = 1;
                PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(c.this.mPageContext.getPageActivity(), shareItem, true, kVar);
                pbPostShareDialogConfig.setIsCopyLink(false);
                pbPostShareDialogConfig.setHideMode(pbPostShareDialogConfig.hideMode | 32);
                c.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, pbPostShareDialogConfig));
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes9.dex */
    public interface a {
        void a(e eVar, bk bkVar, PostData postData, View view);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap cK(View view) {
        Bitmap createBitmap = Bitmap.createBitmap((view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight(), (view.getHeight() - view.getPaddingTop()) - view.getPaddingBottom(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap JL(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return null;
        }
        return (Bitmap) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String A(bk bkVar) {
        String str;
        if (bkVar == null) {
            return null;
        }
        if (bkVar.aQS() != null && !TextUtils.isEmpty(bkVar.aQS().cover)) {
            return bkVar.aQS().cover;
        }
        if (bkVar.aQH() == null) {
            return null;
        }
        ArrayList<MediaData> aQH = bkVar.aQH();
        int size = aQH.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aQH.get(i);
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
        if (str == null && bkVar.aQQ() != null && !TextUtils.isEmpty(bkVar.aQQ().thumbnail_url)) {
            return bkVar.aQQ().thumbnail_url;
        }
        return str;
    }
}
