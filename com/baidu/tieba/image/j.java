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
    private com.baidu.tbadk.core.dialog.i fKp;
    private k fKq;
    private com.baidu.tbadk.core.dialog.g fUw;
    private MultiImageView hRU;
    private final ImageViewerActivity hSE;
    private a hSF;
    private com.baidu.tieba.ueg.c hSH;
    private com.baidu.tbadk.core.dialog.g hSI;
    private com.baidu.tbadk.core.dialog.g hSJ;
    private com.baidu.tbadk.core.dialog.g hSK;
    private com.baidu.tbadk.core.dialog.g hSL;
    private com.baidu.tbadk.core.dialog.g hSM;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String hSG = null;
    private List<com.baidu.tbadk.core.dialog.g> fKu = null;
    private CustomMessageListener hSN = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !j.this.hSE.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.khB = null;
                if (!TextUtils.isEmpty(nVar.khD) && !TextUtils.isEmpty(nVar.khA) && nVar.khA.equals(j.this.hSG)) {
                    j.this.hRU.setCurrentImageQRInfo(nVar.khD);
                    j.this.DR(nVar.khD);
                }
            }
        }
    };
    private k.b hSO = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.hRU.md(j.this.hSE.bRB());
            j.this.bvb();
        }
    };
    private k.b hSP = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aW(j.this.hSE.getPageContext().getPageActivity(), j.this.hRU.getCurrentImageUrl());
            j.this.bvb();
            j.this.xj(1);
        }
    };
    private k.b hSQ = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.hRU.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.bvb();
            j.this.xj(2);
        }
    };
    private k.b fUx = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.hSE.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.bvb();
                j.this.xj(3);
            }
        }
    };
    private k.b hSR = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.hRU != null && (currentUrlDragImageView = j.this.hRU.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.c.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.hRU.getCurrentImageUrl();
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
                shareItem.dpW = true;
                shareItem.dqe = 14;
                j.this.hSE.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(j.this.hSE, shareItem, false)));
                j.this.bvb();
                j.this.xj(4);
            }
        }
    };
    private k.b hSS = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.hSE = imageViewerActivity;
        this.hSE.registerListener(this.hSN);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.hRU = multiImageView;
        if (this.fKp == null) {
            this.fKq = new k(this.hSE);
        }
        if (this.fKu == null) {
            this.fKu = new ArrayList();
        }
        byd();
        this.fKp = new com.baidu.tbadk.core.dialog.i(this.hSE.getPageContext(), this.fKq);
    }

    public void byd() {
        this.fKu.clear();
        String mc = this.hRU.mc(this.hSE.bRB());
        if (mc != null) {
            this.hSI = new com.baidu.tbadk.core.dialog.g(mc, this.fKq);
            this.hSI.a(this.hSO);
            this.fKu.add(this.hSI);
        }
        this.fUw = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.fKq);
        this.fUw.a(this.fUx);
        this.fKu.add(this.fUw);
        if (this.hSE != null && !this.hSE.caH()) {
            this.hSK = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.fKq);
            this.hSK.a(this.hSQ);
            this.fKu.add(this.hSK);
        }
        this.hSJ = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.fKq);
        this.hSJ.a(this.hSP);
        this.fKu.add(this.hSJ);
        String currentImageQRInfo = this.hRU.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.hSM = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.fKq);
            this.hSM.a(this.hSS);
            this.fKu.add(this.hSM);
        }
        this.hSL = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.fKq);
        this.hSL.a(this.hSR);
        this.fKu.add(this.hSL);
        this.fKq.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.bvb();
            }
        });
        this.fKq.az(this.fKu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.hSE.getString(i);
    }

    public void bvb() {
        if (this.fKp != null && this.fKp.isShowing()) {
            this.fKp.dismiss();
        }
    }

    public void show() {
        if (this.fKp != null && !this.hSE.isFinishing()) {
            this.fKp.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.hRU.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.hSE.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.hSH != null && !j.this.hSH.isCancelled()) {
                    j.this.hSH.cancel();
                }
                j.this.hSH = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void caM() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void caN() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.hSE.getPageContext().getPageActivity());
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
                        aVar.b(j.this.hSE.getPageContext()).aEC();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void caO() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.hSE.getPageContext().getPageActivity());
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
                        aVar.b(j.this.hSE.getPageContext()).aEC();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.hSE.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.hSH.setPriority(3);
                j.this.hSH.execute(new String[0]);
                j.this.bvb();
                j.this.xj(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.hSE.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.hSF = new a(this.hRU.getCurrentImageUrl(), this.hRU.getCurrentImageData());
            this.hSF.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.hSE.getFrom())) {
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
            Map<String, ImageUrlData> caz = j.this.hSE.caz();
            if (this.mUrl != null && caz != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = caz.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.aGA().tw(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = m.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && m.copyImageFile(str, this.mUrl, j.this.hSE.getPageContext().getPageActivity()) == 0) {
                        return j.this.hSE.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.saveImageFileByUser(this.mUrl, this.mData, j.this.hSE.getPageContext().getPageActivity())) {
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
            j.this.hSE.showToast(str);
            j.this.hSF = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.hSF = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i) {
        TiebaStatic.log(new an("c13270").cy("uid", this.hSE.getUserId()).X("obj_type", i));
    }

    public void DR(String str) {
        int i;
        boolean z = false;
        if (this.fKp != null && !this.hSE.isFinishing() && this.fKp.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.hSM = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.fKq);
            this.hSM.a(this.hSS);
            int i2 = 0;
            while (true) {
                if (i2 < this.fKu.size()) {
                    if (this.hSJ == null || this.fKu.get(i2) != this.hSJ || (i = i2 + 1) > this.fKu.size()) {
                        i2++;
                    } else {
                        this.fKu.add(i, this.hSM);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.fKu.add(this.hSM);
            }
            this.fKq.az(this.fKu);
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
                nVar.khB = imageBitmap;
                String currentImageUrl = this.hRU.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.khA = String.valueOf(System.currentTimeMillis()) + as.getNameMd5FromUrl(currentImageUrl);
                } else {
                    nVar.khA = String.valueOf(BdUniqueId.gen().getId());
                }
                this.hSG = nVar.khA;
                this.hSE.sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    public void caL() {
        this.hSG = null;
    }

    public void release() {
        if (this.hSF != null) {
            this.hSF.cancel();
            this.hSF = null;
        }
        if (this.hSH != null) {
            this.hSH.cancel();
            this.hSH = null;
        }
    }
}
