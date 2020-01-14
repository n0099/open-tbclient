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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.n;
import com.baidu.tieba.ueg.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class j {
    private com.baidu.tbadk.core.dialog.i fHQ;
    private k fHR;
    private com.baidu.tbadk.core.dialog.g fSa;
    private MultiImageView hPU;
    private final ImageViewerActivity hQE;
    private a hQF;
    private com.baidu.tieba.ueg.c hQH;
    private com.baidu.tbadk.core.dialog.g hQI;
    private com.baidu.tbadk.core.dialog.g hQJ;
    private com.baidu.tbadk.core.dialog.g hQK;
    private com.baidu.tbadk.core.dialog.g hQL;
    private com.baidu.tbadk.core.dialog.g hQM;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String hQG = null;
    private List<com.baidu.tbadk.core.dialog.g> fHV = null;
    private CustomMessageListener hQN = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !j.this.hQE.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.kgy = null;
                if (!TextUtils.isEmpty(nVar.kgA) && !TextUtils.isEmpty(nVar.kgx) && nVar.kgx.equals(j.this.hQG)) {
                    j.this.hPU.setCurrentImageQRInfo(nVar.kgA);
                    j.this.DB(nVar.kgA);
                }
            }
        }
    };
    private k.b hQO = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.hPU.lL(j.this.hQE.bPY());
            j.this.btv();
        }
    };
    private k.b hQP = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aW(j.this.hQE.getPageContext().getPageActivity(), j.this.hPU.getCurrentImageUrl());
            j.this.btv();
            j.this.xd(1);
        }
    };
    private k.b hQQ = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.hPU.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.btv();
            j.this.xd(2);
        }
    };
    private k.b fSb = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.hQE.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.btv();
                j.this.xd(3);
            }
        }
    };
    private k.b hQR = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.hPU != null && (currentUrlDragImageView = j.this.hPU.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.c.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.hPU.getCurrentImageUrl();
                    str2 = as.getNameMd5FromUrl(str);
                }
                ShareItem shareItem = new ShareItem();
                if (imageUrlData != null) {
                    long j = imageUrlData.threadId;
                    if (j > 0) {
                        shareItem.linkUrl = "http://tieba.baidu.com/p/" + j + "?fr=share";
                    }
                }
                if (!aq.isEmpty(str)) {
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
                j.this.hQE.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(j.this.hQE, shareItem, false)));
                j.this.btv();
                j.this.xd(4);
            }
        }
    };
    private k.b hQS = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.hQE = imageViewerActivity;
        this.hQE.registerListener(this.hQN);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.hPU = multiImageView;
        if (this.fHQ == null) {
            this.fHR = new k(this.hQE);
        }
        if (this.fHV == null) {
            this.fHV = new ArrayList();
        }
        bwx();
        this.fHQ = new com.baidu.tbadk.core.dialog.i(this.hQE.getPageContext(), this.fHR);
    }

    public void bwx() {
        this.fHV.clear();
        String lK = this.hPU.lK(this.hQE.bPY());
        if (lK != null) {
            this.hQI = new com.baidu.tbadk.core.dialog.g(lK, this.fHR);
            this.hQI.a(this.hQO);
            this.fHV.add(this.hQI);
        }
        this.fSa = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.fHR);
        this.fSa.a(this.fSb);
        this.fHV.add(this.fSa);
        if (this.hQE != null && !this.hQE.bZe()) {
            this.hQK = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.fHR);
            this.hQK.a(this.hQQ);
            this.fHV.add(this.hQK);
        }
        this.hQJ = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.fHR);
        this.hQJ.a(this.hQP);
        this.fHV.add(this.hQJ);
        String currentImageQRInfo = this.hPU.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.hQM = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.fHR);
            this.hQM.a(this.hQS);
            this.fHV.add(this.hQM);
        }
        this.hQL = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.fHR);
        this.hQL.a(this.hQR);
        this.fHV.add(this.hQL);
        this.fHR.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.btv();
            }
        });
        this.fHR.az(this.fHV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.hQE.getString(i);
    }

    public void btv() {
        if (this.fHQ != null && this.fHQ.isShowing()) {
            this.fHQ.dismiss();
        }
    }

    public void show() {
        if (this.fHQ != null && !this.hQE.isFinishing()) {
            this.fHQ.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.hPU.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.hQE.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.hQH != null && !j.this.hQH.isCancelled()) {
                    j.this.hQH.cancel();
                }
                j.this.hQH = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void bZj() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void bZk() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.hQE.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.sB(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.sC(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.fz(false);
                        aVar.fA(false);
                        aVar.b(j.this.hQE.getPageContext()).aCp();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void bZl() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.hQE.getPageContext().getPageActivity());
                        aVar.sB(null);
                        aVar.setMessageShowCenter(true);
                        aVar.sC(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.fz(false);
                        aVar.fA(false);
                        aVar.b(j.this.hQE.getPageContext()).aCp();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.hQE.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.hQH.setPriority(3);
                j.this.hQH.execute(new String[0]);
                j.this.btv();
                j.this.xd(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.hQE.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.hQF = new a(this.hPU.getCurrentImageUrl(), this.hPU.getCurrentImageData());
            this.hQF.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.hQE.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
            Map<String, ImageUrlData> bYW = j.this.hQE.bYW();
            if (this.mUrl != null && bYW != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = bYW.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.aEn().tg(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = m.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && m.copyImageFile(str, this.mUrl, j.this.hQE.getPageContext().getPageActivity()) == 0) {
                        return j.this.hQE.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.saveImageFileByUser(this.mUrl, this.mData, j.this.hQE.getPageContext().getPageActivity())) {
                    case -2:
                        return m.getSdErrorString();
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
            j.this.hQE.showToast(str);
            j.this.hQF = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.hQF = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(int i) {
        TiebaStatic.log(new an("c13270").cp("uid", this.hQE.getUserId()).Z("obj_type", i));
    }

    public void DB(String str) {
        int i;
        boolean z = false;
        if (this.fHQ != null && !this.hQE.isFinishing() && this.fHQ.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.hQM = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.fHR);
            this.hQM.a(this.hQS);
            int i2 = 0;
            while (true) {
                if (i2 < this.fHV.size()) {
                    if (this.hQJ == null || this.fHV.get(i2) != this.hQJ || (i = i2 + 1) > this.fHV.size()) {
                        i2++;
                    } else {
                        this.fHV.add(i, this.hQM);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.fHV.add(this.hQM);
            }
            this.fHR.az(this.fHV);
        }
    }

    public void ch(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                n nVar = new n();
                nVar.type = 0;
                nVar.kgy = imageBitmap;
                String currentImageUrl = this.hPU.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.kgx = String.valueOf(System.currentTimeMillis()) + as.getNameMd5FromUrl(currentImageUrl);
                } else {
                    nVar.kgx = String.valueOf(BdUniqueId.gen().getId());
                }
                this.hQG = nVar.kgx;
                this.hQE.sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    public void bZi() {
        this.hQG = null;
    }

    public void release() {
        if (this.hQF != null) {
            this.hQF.cancel();
            this.hQF = null;
        }
        if (this.hQH != null) {
            this.hQH.cancel();
            this.hQH = null;
        }
    }
}
