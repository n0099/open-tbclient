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
/* loaded from: classes5.dex */
public class j {
    private com.baidu.tbadk.core.dialog.i fEG;
    private k fEH;
    private com.baidu.tbadk.core.dialog.g fOR;
    private MultiImageView hMr;
    private final ImageViewerActivity hNb;
    private a hNc;
    private com.baidu.tieba.ueg.c hNe;
    private com.baidu.tbadk.core.dialog.g hNf;
    private com.baidu.tbadk.core.dialog.g hNg;
    private com.baidu.tbadk.core.dialog.g hNh;
    private com.baidu.tbadk.core.dialog.g hNi;
    private com.baidu.tbadk.core.dialog.g hNj;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String hNd = null;
    private List<com.baidu.tbadk.core.dialog.g> fEL = null;
    private CustomMessageListener hNk = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !j.this.hNb.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.kcQ = null;
                if (!TextUtils.isEmpty(nVar.kcS) && !TextUtils.isEmpty(nVar.kcP) && nVar.kcP.equals(j.this.hNd)) {
                    j.this.hMr.setCurrentImageQRInfo(nVar.kcS);
                    j.this.Dr(nVar.kcS);
                }
            }
        }
    };
    private k.b hNl = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.hMr.lL(j.this.hNb.bOP());
            j.this.bst();
        }
    };
    private k.b hNm = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aV(j.this.hNb.getPageContext().getPageActivity(), j.this.hMr.getCurrentImageUrl());
            j.this.bst();
            j.this.wY(1);
        }
    };
    private k.b hNn = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.hMr.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.bst();
            j.this.wY(2);
        }
    };
    private k.b fOS = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.hNb.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.bst();
                j.this.wY(3);
            }
        }
    };
    private k.b hNo = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.hMr != null && (currentUrlDragImageView = j.this.hMr.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.c.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.hMr.getCurrentImageUrl();
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
                j.this.hNb.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(j.this.hNb, shareItem, false)));
                j.this.bst();
                j.this.wY(4);
            }
        }
    };
    private k.b hNp = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.hNb = imageViewerActivity;
        this.hNb.registerListener(this.hNk);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.hMr = multiImageView;
        if (this.fEG == null) {
            this.fEH = new k(this.hNb);
        }
        if (this.fEL == null) {
            this.fEL = new ArrayList();
        }
        bvv();
        this.fEG = new com.baidu.tbadk.core.dialog.i(this.hNb.getPageContext(), this.fEH);
    }

    public void bvv() {
        this.fEL.clear();
        String lK = this.hMr.lK(this.hNb.bOP());
        if (lK != null) {
            this.hNf = new com.baidu.tbadk.core.dialog.g(lK, this.fEH);
            this.hNf.a(this.hNl);
            this.fEL.add(this.hNf);
        }
        this.fOR = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.fEH);
        this.fOR.a(this.fOS);
        this.fEL.add(this.fOR);
        if (this.hNb != null && !this.hNb.bXV()) {
            this.hNh = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.fEH);
            this.hNh.a(this.hNn);
            this.fEL.add(this.hNh);
        }
        this.hNg = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.fEH);
        this.hNg.a(this.hNm);
        this.fEL.add(this.hNg);
        String currentImageQRInfo = this.hMr.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.hNj = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.fEH);
            this.hNj.a(this.hNp);
            this.fEL.add(this.hNj);
        }
        this.hNi = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.fEH);
        this.hNi.a(this.hNo);
        this.fEL.add(this.hNi);
        this.fEH.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.bst();
            }
        });
        this.fEH.aA(this.fEL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.hNb.getString(i);
    }

    public void bst() {
        if (this.fEG != null && this.fEG.isShowing()) {
            this.fEG.dismiss();
        }
    }

    public void show() {
        if (this.fEG != null && !this.hNb.isFinishing()) {
            this.fEG.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.hMr.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.hNb.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.hNe != null && !j.this.hNe.isCancelled()) {
                    j.this.hNe.cancel();
                }
                j.this.hNe = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void bYa() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void bYb() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.hNb.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.sy(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.sz(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.fu(false);
                        aVar.fv(false);
                        aVar.b(j.this.hNb.getPageContext()).aBW();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void bYc() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.hNb.getPageContext().getPageActivity());
                        aVar.sy(null);
                        aVar.setMessageShowCenter(true);
                        aVar.sz(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.fu(false);
                        aVar.fv(false);
                        aVar.b(j.this.hNb.getPageContext()).aBW();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.hNb.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.hNe.setPriority(3);
                j.this.hNe.execute(new String[0]);
                j.this.bst();
                j.this.wY(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.hNb.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.hNc = new a(this.hMr.getCurrentImageUrl(), this.hMr.getCurrentImageData());
            this.hNc.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.hNb.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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
            Map<String, ImageUrlData> bXN = j.this.hNb.bXN();
            if (this.mUrl != null && bXN != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = bXN.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.aDU().tc(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = m.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && m.copyImageFile(str, this.mUrl, j.this.hNb.getPageContext().getPageActivity()) == 0) {
                        return j.this.hNb.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.saveImageFileByUser(this.mUrl, this.mData, j.this.hNb.getPageContext().getPageActivity())) {
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
            j.this.hNb.showToast(str);
            j.this.hNc = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.hNc = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wY(int i) {
        TiebaStatic.log(new an("c13270").cp("uid", this.hNb.getUserId()).Z("obj_type", i));
    }

    public void Dr(String str) {
        int i;
        boolean z = false;
        if (this.fEG != null && !this.hNb.isFinishing() && this.fEG.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.hNj = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.fEH);
            this.hNj.a(this.hNp);
            int i2 = 0;
            while (true) {
                if (i2 < this.fEL.size()) {
                    if (this.hNg == null || this.fEL.get(i2) != this.hNg || (i = i2 + 1) > this.fEL.size()) {
                        i2++;
                    } else {
                        this.fEL.add(i, this.hNj);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.fEL.add(this.hNj);
            }
            this.fEH.aA(this.fEL);
        }
    }

    public void cc(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                n nVar = new n();
                nVar.type = 0;
                nVar.kcQ = imageBitmap;
                String currentImageUrl = this.hMr.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.kcP = String.valueOf(System.currentTimeMillis()) + as.getNameMd5FromUrl(currentImageUrl);
                } else {
                    nVar.kcP = String.valueOf(BdUniqueId.gen().getId());
                }
                this.hNd = nVar.kcP;
                this.hNb.sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    public void bXZ() {
        this.hNd = null;
    }

    public void release() {
        if (this.hNc != null) {
            this.hNc.cancel();
            this.hNc = null;
        }
        if (this.hNe != null) {
            this.hNe.cancel();
            this.hNe = null;
        }
    }
}
