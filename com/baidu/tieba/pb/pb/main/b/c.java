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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class c {
    public a krq = new a() { // from class: com.baidu.tieba.pb.pb.main.b.c.1
        @Override // com.baidu.tieba.pb.pb.main.b.c.a
        public void a(e eVar, bu buVar, PostData postData, View view) {
            String A;
            String tid;
            String str;
            if ((eVar != null || buVar != null) && postData != null && view != null && c.this.mPageContext != null) {
                if (eVar == null) {
                    A = c.this.A(buVar);
                } else {
                    A = eVar.o(c.this.mPageContext.getPageActivity(), false)[0];
                    if (!StringUtils.isNull(A) && A.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        A = A.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    buVar = eVar.cGO();
                    if (buVar == null) {
                        return;
                    }
                }
                Bitmap cL = c.this.cL(view);
                k kVar = new k();
                kVar.B(cL);
                kVar.setContent(buVar.getAbstract());
                if (buVar.aSH() != null) {
                    kVar.rp(true);
                    kVar.JH(StringUtils.translateSecondsToString(buVar.aSH().video_duration.intValue()));
                } else {
                    kVar.rp(false);
                }
                if (!StringUtils.isNull(A)) {
                    kVar.JI(A);
                }
                String title = buVar.getTitle();
                if (StringUtils.isNull(title)) {
                    title = buVar.getAbstract();
                }
                kVar.setContent(title);
                if (buVar.aQZ()) {
                    tid = buVar.getBaijiahaoData().oriUgcTid;
                    str = "?share=9105&fr=dshare&dtype=" + buVar.getBaijiahaoData().oriUgcType + "&dvid=" + buVar.getBaijiahaoData().oriUgcVid + "&nid=" + buVar.getBaijiahaoData().oriUgcNid;
                } else {
                    tid = buVar.getTid();
                    str = "?share=9105&fr=share";
                }
                kVar.C(c.this.Ko("http://tieba.baidu.com/p/" + tid + str));
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
        void a(e eVar, bu buVar, PostData postData, View view);
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap cL(View view) {
        Bitmap createBitmap = Bitmap.createBitmap((view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight(), (view.getHeight() - view.getPaddingTop()) - view.getPaddingBottom(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap Ko(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return null;
        }
        return (Bitmap) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String A(bu buVar) {
        String str;
        if (buVar == null) {
            return null;
        }
        if (buVar.aSJ() != null && !TextUtils.isEmpty(buVar.aSJ().cover)) {
            return buVar.aSJ().cover;
        }
        if (buVar.aSy() == null) {
            return null;
        }
        ArrayList<MediaData> aSy = buVar.aSy();
        int size = aSy.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aSy.get(i);
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
        if (str == null && buVar.aSH() != null && !TextUtils.isEmpty(buVar.aSH().thumbnail_url)) {
            return buVar.aSH().thumbnail_url;
        }
        return str;
    }
}
