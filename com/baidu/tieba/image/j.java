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
/* loaded from: classes20.dex */
public class j implements ImageViewerBottomLayout.b, ImageViewerBottomLayout.c {
    private com.baidu.tbadk.core.dialog.g hBG;
    private com.baidu.tbadk.core.dialog.i hrs;
    private k hrt;
    private MultiImageView jQR;
    private final ImageViewerActivity jRE;
    private a jRF;
    private com.baidu.tieba.ueg.c jRH;
    private com.baidu.tbadk.core.dialog.g jRI;
    private com.baidu.tbadk.core.dialog.g jRJ;
    private com.baidu.tbadk.core.dialog.g jRK;
    private com.baidu.tbadk.core.dialog.g jRL;
    private com.baidu.tbadk.core.dialog.g jRM;
    private PermissionJudgePolicy mPermissionJudgement;
    private String jRG = null;
    private List<com.baidu.tbadk.core.dialog.g> hrx = null;
    private CustomMessageListener jRN = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o) && !j.this.jRE.isFinishing() && (oVar = (o) customResponsedMessage.getData()) != null) {
                oVar.mpJ = null;
                if (!TextUtils.isEmpty(oVar.mpL) && !TextUtils.isEmpty(oVar.mpI) && oVar.mpI.equals(j.this.jRG)) {
                    j.this.jQR.setCurrentImageQRInfo(oVar.mpL);
                    j.this.LZ(oVar.mpL);
                }
            }
        }
    };
    private k.b jRO = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.jQR.qf(j.this.jRE.cEP());
            j.this.cfi();
        }
    };
    private k.b jRP = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aM(j.this.jRE.getPageContext().getPageActivity(), j.this.jQR.getCurrentImageUrl());
            j.this.cfi();
            j.this.CG(1);
        }
    };
    private k.b jRQ = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.jQR.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.cfi();
            j.this.CG(2);
        }
    };
    private k.b hBH = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.jRE.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.cfi();
                j.this.CG(3);
            }
        }
    };
    private k.b jRR = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.bqK();
            j.this.cfi();
            j.this.CG(4);
            j.this.cOB();
        }
    };
    private k.b jRS = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.jRE = imageViewerActivity;
        this.jRE.registerListener(this.jRN);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.jQR = multiImageView;
        if (this.hrs == null) {
            this.hrt = new k(this.jRE);
        }
        if (this.hrx == null) {
            this.hrx = new ArrayList();
        }
        cim();
        this.hrs = new com.baidu.tbadk.core.dialog.i(this.jRE.getPageContext(), this.hrt);
    }

    public void cim() {
        this.hrx.clear();
        String qe = this.jQR.qe(this.jRE.cEP());
        if (qe != null) {
            this.jRI = new com.baidu.tbadk.core.dialog.g(qe, this.hrt);
            this.jRI.a(this.jRO);
            this.hrx.add(this.jRI);
        }
        this.hBG = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.hrt);
        this.hBG.a(this.hBH);
        this.hrx.add(this.hBG);
        if (this.jRE != null && !this.jRE.cOx()) {
            this.jRK = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.hrt);
            this.jRK.a(this.jRQ);
            this.hrx.add(this.jRK);
        }
        this.jRJ = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.hrt);
        this.jRJ.a(this.jRP);
        this.hrx.add(this.jRJ);
        String currentImageQRInfo = this.jQR.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.jRM = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hrt);
            this.jRM.a(this.jRS);
            this.hrx.add(this.jRM);
        }
        this.jRL = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.hrt);
        this.jRL.a(this.jRR);
        this.hrx.add(this.jRL);
        this.hrt.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.cfi();
            }
        });
        this.hrt.aX(this.hrx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.jRE.getString(i);
    }

    public void cfi() {
        if (this.hrs != null && this.hrs.isShowing()) {
            this.hrs.dismiss();
        }
    }

    public void show() {
        if (this.hrs != null && !this.jRE.isFinishing()) {
            this.hrs.NY();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.jQR.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.jRE.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.jRH != null && !j.this.jRH.isCancelled()) {
                    j.this.jRH.cancel();
                }
                j.this.jRH = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void cOD() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cOE() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.jRE.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.zU(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.zV(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.id(false);
                        aVar.ie(false);
                        aVar.b(j.this.jRE.getPageContext()).bia();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cOF() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.jRE.getPageContext().getPageActivity());
                        aVar.zU(null);
                        aVar.setMessageShowCenter(true);
                        aVar.zV(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.id(false);
                        aVar.ie(false);
                        aVar.b(j.this.jRE.getPageContext()).bia();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.jRE.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.jRH.setPriority(3);
                j.this.jRH.execute(new String[0]);
                j.this.cfi();
                j.this.CG(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.jRE.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.jRF = new a(this.jQR.getCurrentImageUrl(), this.jQR.getCurrentImageData());
            this.jRF.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.jRE.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void bqK() {
        UrlDragImageView currentUrlDragImageView;
        if (this.jQR != null && (currentUrlDragImageView = this.jQR.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.jQR.getCurrentImageUrl();
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
            shareItem.eGC = 14;
            this.jRE.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.jRE, shareItem, false)));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void bqJ() {
        Activity pageActivity = this.jRE.getPageContext().getPageActivity();
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
    /* loaded from: classes20.dex */
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
            Map<String, ImageUrlData> cOo = j.this.jRE.cOo();
            if (this.mUrl != null && cOo != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = cOo.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + as.bkj().AB(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = n.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && n.copyImageFile(str, this.mUrl, j.this.jRE.getPageContext().getPageActivity()) == 0) {
                        return j.this.jRE.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (n.saveImageFileByUser(this.mUrl, this.mData, j.this.jRE.getPageContext().getPageActivity())) {
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
            j.this.jRE.showToast(str);
            j.this.jRF = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.jRF = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CG(int i) {
        TiebaStatic.log(new aq("c13270").dF("uid", this.jRE.getUserId()).ai("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOB() {
    }

    public void LZ(String str) {
        int i;
        boolean z = false;
        if (this.hrs != null && !this.jRE.isFinishing() && this.hrs.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.jRM = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hrt);
            this.jRM.a(this.jRS);
            int i2 = 0;
            while (true) {
                if (i2 < this.hrx.size()) {
                    if (this.jRJ == null || this.hrx.get(i2) != this.jRJ || (i = i2 + 1) > this.hrx.size()) {
                        i2++;
                    } else {
                        this.hrx.add(i, this.jRM);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.hrx.add(this.jRM);
            }
            this.hrt.aX(this.hrx);
        }
    }

    public void cJ(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                o oVar = new o();
                oVar.type = 0;
                oVar.mpJ = imageBitmap;
                String currentImageUrl = this.jQR.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    oVar.mpI = String.valueOf(System.currentTimeMillis()) + av.getNameMd5FromUrl(currentImageUrl);
                } else {
                    oVar.mpI = String.valueOf(BdUniqueId.gen().getId());
                }
                this.jRG = oVar.mpI;
                this.jRE.sendMessage(new CustomMessage(2921403, oVar));
            }
        }
    }

    public void cOC() {
        this.jRG = null;
    }

    public void release() {
        if (this.jRF != null) {
            this.jRF.cancel();
            this.jRF = null;
        }
        if (this.jRH != null) {
            this.jRH.cancel();
            this.jRH = null;
        }
    }

    public void onChangeSkinType() {
        if (this.hrt != null) {
            this.hrt.onChangeSkinType();
        }
    }
}
