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
    private com.baidu.tbadk.core.dialog.i hSJ;
    private k hSK;
    private com.baidu.tbadk.core.dialog.g icY;
    private MultiImageView kso;
    private final ImageViewerActivity ktb;
    private a ktc;
    private com.baidu.tieba.ueg.c kte;
    private com.baidu.tbadk.core.dialog.g ktf;
    private com.baidu.tbadk.core.dialog.g ktg;
    private com.baidu.tbadk.core.dialog.g kth;
    private com.baidu.tbadk.core.dialog.g kti;
    private com.baidu.tbadk.core.dialog.g ktj;
    private PermissionJudgePolicy mPermissionJudgement;
    private String ktd = null;
    private List<com.baidu.tbadk.core.dialog.g> hSO = null;
    private CustomMessageListener ktk = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o) && !j.this.ktb.isFinishing() && (oVar = (o) customResponsedMessage.getData()) != null) {
                oVar.mRW = null;
                if (!TextUtils.isEmpty(oVar.mRY) && !TextUtils.isEmpty(oVar.mRV) && oVar.mRV.equals(j.this.ktd)) {
                    j.this.kso.setCurrentImageQRInfo(oVar.mRY);
                    j.this.Nm(oVar.mRY);
                }
            }
        }
    };
    private k.b ktl = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.kso.qO(j.this.ktb.cLF());
            j.this.clL();
        }
    };
    private k.b ktm = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aQ(j.this.ktb.getPageContext().getPageActivity(), j.this.kso.getCurrentImageUrl());
            j.this.clL();
            j.this.DF(1);
        }
    };
    private k.b ktn = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.kso.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.clL();
            j.this.DF(2);
        }
    };
    private k.b icZ = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.ktb.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.clL();
                j.this.DF(3);
            }
        }
    };
    private k.b kto = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.bvn();
            j.this.clL();
            j.this.DF(4);
            j.this.cVq();
        }
    };
    private k.b ktp = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.ktb = imageViewerActivity;
        this.ktb.registerListener(this.ktk);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.kso = multiImageView;
        if (this.hSJ == null) {
            this.hSK = new k(this.ktb);
        }
        if (this.hSO == null) {
            this.hSO = new ArrayList();
        }
        coP();
        this.hSJ = new com.baidu.tbadk.core.dialog.i(this.ktb.getPageContext(), this.hSK);
    }

    public void coP() {
        this.hSO.clear();
        String qN = this.kso.qN(this.ktb.cLF());
        if (qN != null) {
            this.ktf = new com.baidu.tbadk.core.dialog.g(qN, this.hSK);
            this.ktf.a(this.ktl);
            this.hSO.add(this.ktf);
        }
        this.icY = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.hSK);
        this.icY.a(this.icZ);
        this.hSO.add(this.icY);
        if (this.ktb != null && !this.ktb.cVm()) {
            this.kth = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.hSK);
            this.kth.a(this.ktn);
            this.hSO.add(this.kth);
        }
        this.ktg = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.hSK);
        this.ktg.a(this.ktm);
        this.hSO.add(this.ktg);
        String currentImageQRInfo = this.kso.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.ktj = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hSK);
            this.ktj.a(this.ktp);
            this.hSO.add(this.ktj);
        }
        this.kti = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.hSK);
        this.kti.a(this.kto);
        this.hSO.add(this.kti);
        this.hSK.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.clL();
            }
        });
        this.hSK.bk(this.hSO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.ktb.getString(i);
    }

    public void clL() {
        if (this.hSJ != null && this.hSJ.isShowing()) {
            this.hSJ.dismiss();
        }
    }

    public void show() {
        if (this.hSJ != null && !this.ktb.isFinishing()) {
            this.hSJ.PJ();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.kso.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.ktb.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.kte != null && !j.this.kte.isCancelled()) {
                    j.this.kte.cancel();
                }
                j.this.kte = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void cVs() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cVt() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.ktb.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.AZ(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.Ba(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.iM(false);
                        aVar.iN(false);
                        aVar.b(j.this.ktb.getPageContext()).bmC();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cVu() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.ktb.getPageContext().getPageActivity());
                        aVar.AZ(null);
                        aVar.setMessageShowCenter(true);
                        aVar.Ba(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.iM(false);
                        aVar.iN(false);
                        aVar.b(j.this.ktb.getPageContext()).bmC();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.ktb.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.kte.setPriority(3);
                j.this.kte.execute(new String[0]);
                j.this.clL();
                j.this.DF(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.ktb.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.ktc = new a(this.kso.getCurrentImageUrl(), this.kso.getCurrentImageData());
            this.ktc.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.ktb.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void bvn() {
        UrlDragImageView currentUrlDragImageView;
        if (this.kso != null && (currentUrlDragImageView = this.kso.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.kso.getCurrentImageUrl();
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
            shareItem.fbf = 14;
            this.ktb.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.ktb, shareItem, false)));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void bvm() {
        Activity pageActivity = this.ktb.getPageContext().getPageActivity();
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
            Map<String, ImageUrlData> cVd = j.this.ktb.cVd();
            if (this.mUrl != null && cVd != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = cVd.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + as.boL().BG(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = n.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && n.copyImageFile(str, this.mUrl, j.this.ktb.getPageContext().getPageActivity()) == 0) {
                        return j.this.ktb.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (n.saveImageFileByUser(this.mUrl, this.mData, j.this.ktb.getPageContext().getPageActivity())) {
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
            j.this.ktb.showToast(str);
            j.this.ktc = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.ktc = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DF(int i) {
        TiebaStatic.log(new aq("c13270").dR("uid", this.ktb.getUserId()).aj("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVq() {
    }

    public void Nm(String str) {
        int i;
        boolean z = false;
        if (this.hSJ != null && !this.ktb.isFinishing() && this.hSJ.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.ktj = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hSK);
            this.ktj.a(this.ktp);
            int i2 = 0;
            while (true) {
                if (i2 < this.hSO.size()) {
                    if (this.ktg == null || this.hSO.get(i2) != this.ktg || (i = i2 + 1) > this.hSO.size()) {
                        i2++;
                    } else {
                        this.hSO.add(i, this.ktj);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.hSO.add(this.ktj);
            }
            this.hSK.bk(this.hSO);
        }
    }

    public void cR(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                o oVar = new o();
                oVar.type = 0;
                oVar.mRW = imageBitmap;
                String currentImageUrl = this.kso.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    oVar.mRV = String.valueOf(System.currentTimeMillis()) + av.getNameMd5FromUrl(currentImageUrl);
                } else {
                    oVar.mRV = String.valueOf(BdUniqueId.gen().getId());
                }
                this.ktd = oVar.mRV;
                this.ktb.sendMessage(new CustomMessage(2921403, oVar));
            }
        }
    }

    public void cVr() {
        this.ktd = null;
    }

    public void release() {
        if (this.ktc != null) {
            this.ktc.cancel();
            this.ktc = null;
        }
        if (this.kte != null) {
            this.kte.cancel();
            this.kte = null;
        }
    }

    public void onChangeSkinType() {
        if (this.hSK != null) {
            this.hSK.onChangeSkinType();
        }
    }
}
