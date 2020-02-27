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
/* loaded from: classes8.dex */
public class j {
    private com.baidu.tbadk.core.dialog.i fKn;
    private k fKo;
    private com.baidu.tbadk.core.dialog.g fUu;
    private MultiImageView hRS;
    private final ImageViewerActivity hSC;
    private a hSD;
    private com.baidu.tieba.ueg.c hSF;
    private com.baidu.tbadk.core.dialog.g hSG;
    private com.baidu.tbadk.core.dialog.g hSH;
    private com.baidu.tbadk.core.dialog.g hSI;
    private com.baidu.tbadk.core.dialog.g hSJ;
    private com.baidu.tbadk.core.dialog.g hSK;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String hSE = null;
    private List<com.baidu.tbadk.core.dialog.g> fKs = null;
    private CustomMessageListener hSL = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !j.this.hSC.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.khz = null;
                if (!TextUtils.isEmpty(nVar.khB) && !TextUtils.isEmpty(nVar.khy) && nVar.khy.equals(j.this.hSE)) {
                    j.this.hRS.setCurrentImageQRInfo(nVar.khB);
                    j.this.DR(nVar.khB);
                }
            }
        }
    };
    private k.b hSM = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.hRS.md(j.this.hSC.bRz());
            j.this.buZ();
        }
    };
    private k.b hSN = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aW(j.this.hSC.getPageContext().getPageActivity(), j.this.hRS.getCurrentImageUrl());
            j.this.buZ();
            j.this.xj(1);
        }
    };
    private k.b hSO = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.hRS.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.buZ();
            j.this.xj(2);
        }
    };
    private k.b fUv = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.hSC.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.buZ();
                j.this.xj(3);
            }
        }
    };
    private k.b hSP = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.hRS != null && (currentUrlDragImageView = j.this.hRS.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.c.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.hRS.getCurrentImageUrl();
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
                shareItem.dpV = true;
                shareItem.dqd = 14;
                j.this.hSC.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(j.this.hSC, shareItem, false)));
                j.this.buZ();
                j.this.xj(4);
            }
        }
    };
    private k.b hSQ = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.hSC = imageViewerActivity;
        this.hSC.registerListener(this.hSL);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.hRS = multiImageView;
        if (this.fKn == null) {
            this.fKo = new k(this.hSC);
        }
        if (this.fKs == null) {
            this.fKs = new ArrayList();
        }
        byb();
        this.fKn = new com.baidu.tbadk.core.dialog.i(this.hSC.getPageContext(), this.fKo);
    }

    public void byb() {
        this.fKs.clear();
        String mc = this.hRS.mc(this.hSC.bRz());
        if (mc != null) {
            this.hSG = new com.baidu.tbadk.core.dialog.g(mc, this.fKo);
            this.hSG.a(this.hSM);
            this.fKs.add(this.hSG);
        }
        this.fUu = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.fKo);
        this.fUu.a(this.fUv);
        this.fKs.add(this.fUu);
        if (this.hSC != null && !this.hSC.caF()) {
            this.hSI = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.fKo);
            this.hSI.a(this.hSO);
            this.fKs.add(this.hSI);
        }
        this.hSH = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.fKo);
        this.hSH.a(this.hSN);
        this.fKs.add(this.hSH);
        String currentImageQRInfo = this.hRS.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.hSK = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.fKo);
            this.hSK.a(this.hSQ);
            this.fKs.add(this.hSK);
        }
        this.hSJ = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.fKo);
        this.hSJ.a(this.hSP);
        this.fKs.add(this.hSJ);
        this.fKo.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.buZ();
            }
        });
        this.fKo.az(this.fKs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.hSC.getString(i);
    }

    public void buZ() {
        if (this.fKn != null && this.fKn.isShowing()) {
            this.fKn.dismiss();
        }
    }

    public void show() {
        if (this.fKn != null && !this.hSC.isFinishing()) {
            this.fKn.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.hRS.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.hSC.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.hSF != null && !j.this.hSF.isCancelled()) {
                    j.this.hSF.cancel();
                }
                j.this.hSF = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void caK() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void caL() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.hSC.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.sR(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.sS(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.fG(false);
                        aVar.fH(false);
                        aVar.b(j.this.hSC.getPageContext()).aEA();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void caM() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.hSC.getPageContext().getPageActivity());
                        aVar.sR(null);
                        aVar.setMessageShowCenter(true);
                        aVar.sS(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.fG(false);
                        aVar.fH(false);
                        aVar.b(j.this.hSC.getPageContext()).aEA();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.hSC.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.hSF.setPriority(3);
                j.this.hSF.execute(new String[0]);
                j.this.buZ();
                j.this.xj(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.hSC.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.hSD = new a(this.hRS.getCurrentImageUrl(), this.hRS.getCurrentImageData());
            this.hSD.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.hSC.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
            Map<String, ImageUrlData> cax = j.this.hSC.cax();
            if (this.mUrl != null && cax != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = cax.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.aGy().tw(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = m.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && m.copyImageFile(str, this.mUrl, j.this.hSC.getPageContext().getPageActivity()) == 0) {
                        return j.this.hSC.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.saveImageFileByUser(this.mUrl, this.mData, j.this.hSC.getPageContext().getPageActivity())) {
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
            j.this.hSC.showToast(str);
            j.this.hSD = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.hSD = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i) {
        TiebaStatic.log(new an("c13270").cy("uid", this.hSC.getUserId()).X("obj_type", i));
    }

    public void DR(String str) {
        int i;
        boolean z = false;
        if (this.fKn != null && !this.hSC.isFinishing() && this.fKn.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.hSK = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.fKo);
            this.hSK.a(this.hSQ);
            int i2 = 0;
            while (true) {
                if (i2 < this.fKs.size()) {
                    if (this.hSH == null || this.fKs.get(i2) != this.hSH || (i = i2 + 1) > this.fKs.size()) {
                        i2++;
                    } else {
                        this.fKs.add(i, this.hSK);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.fKs.add(this.hSK);
            }
            this.fKo.az(this.fKs);
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
                nVar.khz = imageBitmap;
                String currentImageUrl = this.hRS.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.khy = String.valueOf(System.currentTimeMillis()) + as.getNameMd5FromUrl(currentImageUrl);
                } else {
                    nVar.khy = String.valueOf(BdUniqueId.gen().getId());
                }
                this.hSE = nVar.khy;
                this.hSC.sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    public void caJ() {
        this.hSE = null;
    }

    public void release() {
        if (this.hSD != null) {
            this.hSD.cancel();
            this.hSD = null;
        }
        if (this.hSF != null) {
            this.hSF.cancel();
            this.hSF = null;
        }
    }
}
