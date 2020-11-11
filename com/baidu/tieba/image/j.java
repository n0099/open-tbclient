package com.baidu.tieba.image;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.o;
import com.baidu.tieba.ueg.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes21.dex */
public class j implements ImageViewerBottomLayout.b, ImageViewerBottomLayout.c {
    private com.baidu.tbadk.core.dialog.i hYG;
    private k hYH;
    private com.baidu.tbadk.core.dialog.g iiZ;
    private final ImageViewerActivity kyX;
    private a kyY;
    private MultiImageView kyk;
    private com.baidu.tieba.ueg.c kza;
    private com.baidu.tbadk.core.dialog.g kzb;
    private com.baidu.tbadk.core.dialog.g kzc;
    private com.baidu.tbadk.core.dialog.g kzd;
    private com.baidu.tbadk.core.dialog.g kze;
    private com.baidu.tbadk.core.dialog.g kzf;
    private PermissionJudgePolicy mPermissionJudgement;
    private String kyZ = null;
    private List<com.baidu.tbadk.core.dialog.g> hYL = null;
    private CustomMessageListener kzg = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o) && !j.this.kyX.isFinishing() && (oVar = (o) customResponsedMessage.getData()) != null) {
                oVar.mXZ = null;
                if (!TextUtils.isEmpty(oVar.mYb) && !TextUtils.isEmpty(oVar.mXY) && oVar.mXY.equals(j.this.kyZ)) {
                    j.this.kyk.setCurrentImageQRInfo(oVar.mYb);
                    j.this.ND(oVar.mYb);
                }
            }
        }
    };
    private k.b kzh = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.kyk.qY(j.this.kyX.cOg());
            j.this.com();
        }
    };
    private k.b kzi = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aQ(j.this.kyX.getPageContext().getPageActivity(), j.this.kyk.getCurrentImageUrl());
            j.this.com();
            j.this.DS(1);
        }
    };
    private k.b kzj = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.kyk.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.com();
            j.this.DS(2);
        }
    };
    private k.b ija = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.kyX.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.com();
                j.this.DS(3);
            }
        }
    };
    private k.b kzk = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.bxM();
            j.this.com();
            j.this.DS(4);
            j.this.cXR();
        }
    };
    private k.b kzl = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.kyX = imageViewerActivity;
        this.kyX.registerListener(this.kzg);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.kyk = multiImageView;
        if (this.hYG == null) {
            this.hYH = new k(this.kyX);
        }
        if (this.hYL == null) {
            this.hYL = new ArrayList();
        }
        crq();
        this.hYG = new com.baidu.tbadk.core.dialog.i(this.kyX.getPageContext(), this.hYH);
    }

    public void crq() {
        this.hYL.clear();
        String qX = this.kyk.qX(this.kyX.cOg());
        if (qX != null) {
            this.kzb = new com.baidu.tbadk.core.dialog.g(qX, this.hYH);
            this.kzb.a(this.kzh);
            this.hYL.add(this.kzb);
        }
        this.iiZ = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.hYH);
        this.iiZ.a(this.ija);
        this.hYL.add(this.iiZ);
        if (this.kyX != null && !this.kyX.cXN()) {
            this.kzd = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.hYH);
            this.kzd.a(this.kzj);
            this.hYL.add(this.kzd);
        }
        this.kzc = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.hYH);
        this.kzc.a(this.kzi);
        this.hYL.add(this.kzc);
        String currentImageQRInfo = this.kyk.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.kzf = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hYH);
            this.kzf.a(this.kzl);
            this.hYL.add(this.kzf);
        }
        this.kze = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.hYH);
        this.kze.a(this.kzk);
        this.hYL.add(this.kze);
        this.hYH.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.com();
            }
        });
        this.hYH.br(this.hYL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.kyX.getString(i);
    }

    public void com() {
        if (this.hYG != null && this.hYG.isShowing()) {
            this.hYG.dismiss();
        }
    }

    public void show() {
        if (this.hYG != null && !this.kyX.isFinishing()) {
            this.hYG.Qj();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.kyk.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.kyX.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.kza != null && !j.this.kza.isCancelled()) {
                    j.this.kza.cancel();
                }
                j.this.kza = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void cXT() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cXU() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kyX.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.Bn(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.Bo(j.this.getString(R.string.qr_url_jump_external_message));
                        aVar.a(j.this.getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.image.j.8.1.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                                j.this.openUrl(currentImageQRInfo);
                            }
                        });
                        aVar.b(j.this.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.image.j.8.1.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.iV(false);
                        aVar.iW(false);
                        aVar.b(j.this.kyX.getPageContext()).bpc();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cXV() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kyX.getPageContext().getPageActivity());
                        aVar.Bn(null);
                        aVar.setMessageShowCenter(true);
                        aVar.Bo(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.iV(false);
                        aVar.iW(false);
                        aVar.b(j.this.kyX.getPageContext()).bpc();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.kyX.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.kza.setPriority(3);
                j.this.kza.execute(new String[0]);
                j.this.com();
                j.this.DS(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.kyX.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.kyY = new a(this.kyk.getCurrentImageUrl(), this.kyk.getCurrentImageData());
            this.kyY.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.kyX.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void bxM() {
        UrlDragImageView currentUrlDragImageView;
        if (this.kyk != null && (currentUrlDragImageView = this.kyk.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.kyk.getCurrentImageUrl();
                str2 = av.getNameMd5FromUrl(str);
            }
            ShareItem shareItem = new ShareItem();
            if (imageUrlData != null) {
                long j = imageUrlData.threadId;
                if (j > 0) {
                    shareItem.linkUrl = "http://tieba.baidu.com/p/" + j + "?fr=share";
                }
            }
            if (!at.isEmpty(str)) {
                shareItem.imageUri = Uri.parse(str);
                shareItem.shareType = 1;
                Bundle bundle = new Bundle();
                bundle.putString("path", TbConfig.IMAGE_CACHE_DIR_NAME);
                bundle.putString("name", str2);
                bundle.putBoolean("formatData", true);
                bundle.putBoolean("isSubDir", true);
                bundle.putBoolean("isSdcard", false);
                bundle.putBoolean("isSavedCache", true);
                shareItem.diskPicOperate = bundle;
            }
            shareItem.isFromImageViewer = true;
            shareItem.fgW = 14;
            this.kyX.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.kyX, shareItem, false)));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void bxL() {
        Activity pageActivity = this.kyX.getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            saveImage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private byte[] mData;
        private String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = str;
            this.mData = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            ImageUrlData imageUrlData;
            String nameMd5FromUrl;
            Map<String, ImageUrlData> cXE = j.this.kyX.cXE();
            if (this.mUrl != null && cXE != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = cXE.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        imageUrlData = null;
                        break;
                    }
                    Map.Entry<String, ImageUrlData> next = it.next();
                    if (next != null && next.getKey() != null && next.getValue() != null && next.getKey().contains(this.mUrl)) {
                        imageUrlData = next.getValue();
                        break;
                    }
                }
                if (imageUrlData != null) {
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + as.brl().BU(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = n.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && n.copyImageFile(str, this.mUrl, j.this.kyX.getPageContext().getPageActivity()) == 0) {
                        return j.this.kyX.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (n.saveImageFileByUser(this.mUrl, this.mData, j.this.kyX.getPageContext().getPageActivity())) {
                    case -2:
                        return n.getSdErrorString();
                    case 0:
                        return j.this.getString(R.string.save_image_to_album);
                }
            }
            return j.this.getString(R.string.save_fail);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            j.this.kyX.showToast(str);
            j.this.kyY = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.kyY = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DS(int i) {
        TiebaStatic.log(new aq("c13270").dR("uid", this.kyX.getUserId()).al("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXR() {
    }

    public void ND(String str) {
        int i;
        boolean z = false;
        if (this.hYG != null && !this.kyX.isFinishing() && this.hYG.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.kzf = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hYH);
            this.kzf.a(this.kzl);
            int i2 = 0;
            while (true) {
                if (i2 < this.hYL.size()) {
                    if (this.kzc == null || this.hYL.get(i2) != this.kzc || (i = i2 + 1) > this.hYL.size()) {
                        i2++;
                    } else {
                        this.hYL.add(i, this.kzf);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.hYL.add(this.kzf);
            }
            this.hYH.br(this.hYL);
        }
    }

    public void cW(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                o oVar = new o();
                oVar.type = 0;
                oVar.mXZ = imageBitmap;
                String currentImageUrl = this.kyk.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    oVar.mXY = String.valueOf(System.currentTimeMillis()) + av.getNameMd5FromUrl(currentImageUrl);
                } else {
                    oVar.mXY = String.valueOf(BdUniqueId.gen().getId());
                }
                this.kyZ = oVar.mXY;
                this.kyX.sendMessage(new CustomMessage(2921403, oVar));
            }
        }
    }

    public void cXS() {
        this.kyZ = null;
    }

    public void release() {
        if (this.kyY != null) {
            this.kyY.cancel();
            this.kyY = null;
        }
        if (this.kza != null) {
            this.kza.cancel();
            this.kza = null;
        }
    }

    public void onChangeSkinType() {
        if (this.hYH != null) {
            this.hYH.onChangeSkinType();
        }
    }
}
