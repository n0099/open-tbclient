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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
    private com.baidu.tbadk.core.dialog.g gAm;
    private com.baidu.tbadk.core.dialog.i gpR;
    private k gpS;
    private MultiImageView iDx;
    private final ImageViewerActivity iEh;
    private a iEi;
    private com.baidu.tieba.ueg.c iEk;
    private com.baidu.tbadk.core.dialog.g iEl;
    private com.baidu.tbadk.core.dialog.g iEm;
    private com.baidu.tbadk.core.dialog.g iEn;
    private com.baidu.tbadk.core.dialog.g iEo;
    private com.baidu.tbadk.core.dialog.g iEp;
    private PermissionJudgePolicy mPermissionJudgement;
    private String iEj = null;
    private List<com.baidu.tbadk.core.dialog.g> gpW = null;
    private CustomMessageListener iEq = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !j.this.iEh.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.kTw = null;
                if (!TextUtils.isEmpty(nVar.kTy) && !TextUtils.isEmpty(nVar.kTv) && nVar.kTv.equals(j.this.iEj)) {
                    j.this.iDx.setCurrentImageQRInfo(nVar.kTy);
                    j.this.FA(nVar.kTy);
                }
            }
        }
    };
    private k.b iEr = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.iDx.mr(j.this.iEh.cct());
            j.this.bET();
        }
    };
    private k.b iEs = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aR(j.this.iEh.getPageContext().getPageActivity(), j.this.iDx.getCurrentImageUrl());
            j.this.bET();
            j.this.xR(1);
        }
    };
    private k.b iEt = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.iDx.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.bET();
            j.this.xR(2);
        }
    };
    private k.b gAn = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.iEh.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.bET();
                j.this.xR(3);
            }
        }
    };
    private k.b iEu = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.iDx != null && (currentUrlDragImageView = j.this.iDx.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.iDx.getCurrentImageUrl();
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
                shareItem.dQp = true;
                shareItem.dQx = 14;
                j.this.iEh.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(j.this.iEh, shareItem, false)));
                j.this.bET();
                j.this.xR(4);
            }
        }
    };
    private k.b iEv = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.iEh = imageViewerActivity;
        this.iEh.registerListener(this.iEq);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.iDx = multiImageView;
        if (this.gpR == null) {
            this.gpS = new k(this.iEh);
        }
        if (this.gpW == null) {
            this.gpW = new ArrayList();
        }
        bIe();
        this.gpR = new com.baidu.tbadk.core.dialog.i(this.iEh.getPageContext(), this.gpS);
    }

    public void bIe() {
        this.gpW.clear();
        String mq = this.iDx.mq(this.iEh.cct());
        if (mq != null) {
            this.iEl = new com.baidu.tbadk.core.dialog.g(mq, this.gpS);
            this.iEl.a(this.iEr);
            this.gpW.add(this.iEl);
        }
        this.gAm = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.gpS);
        this.gAm.a(this.gAn);
        this.gpW.add(this.gAm);
        if (this.iEh != null && !this.iEh.clC()) {
            this.iEn = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.gpS);
            this.iEn.a(this.iEt);
            this.gpW.add(this.iEn);
        }
        this.iEm = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.gpS);
        this.iEm.a(this.iEs);
        this.gpW.add(this.iEm);
        String currentImageQRInfo = this.iDx.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.iEp = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.gpS);
            this.iEp.a(this.iEv);
            this.gpW.add(this.iEp);
        }
        this.iEo = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.gpS);
        this.iEo.a(this.iEu);
        this.gpW.add(this.iEo);
        this.gpS.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.bET();
            }
        });
        this.gpS.aI(this.gpW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.iEh.getString(i);
    }

    public void bET() {
        if (this.gpR != null && this.gpR.isShowing()) {
            this.gpR.dismiss();
        }
    }

    public void show() {
        if (this.gpR != null && !this.iEh.isFinishing()) {
            this.gpR.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.iDx.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.iEh.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.iEk != null && !j.this.iEk.isCancelled()) {
                    j.this.iEk.cancel();
                }
                j.this.iEk = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void clH() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void clI() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.iEh.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.ue(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.uf(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.gE(false);
                        aVar.gF(false);
                        aVar.b(j.this.iEh.getPageContext()).aMU();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void clJ() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.iEh.getPageContext().getPageActivity());
                        aVar.ue(null);
                        aVar.setMessageShowCenter(true);
                        aVar.uf(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.gE(false);
                        aVar.gF(false);
                        aVar.b(j.this.iEh.getPageContext()).aMU();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.iEh.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.iEk.setPriority(3);
                j.this.iEk.execute(new String[0]);
                j.this.bET();
                j.this.xR(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.iEh.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.iEi = new a(this.iDx.getCurrentImageUrl(), this.iDx.getCurrentImageData());
            this.iEi.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.iEh.getFrom())) {
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
            Map<String, ImageUrlData> clu = j.this.iEh.clu();
            if (this.mUrl != null && clu != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = clu.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.aOS().uJ(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = m.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && m.copyImageFile(str, this.mUrl, j.this.iEh.getPageContext().getPageActivity()) == 0) {
                        return j.this.iEh.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.saveImageFileByUser(this.mUrl, this.mData, j.this.iEh.getPageContext().getPageActivity())) {
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
            j.this.iEh.showToast(str);
            j.this.iEi = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.iEi = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xR(int i) {
        TiebaStatic.log(new an("c13270").cI("uid", this.iEh.getUserId()).af("obj_type", i));
    }

    public void FA(String str) {
        int i;
        boolean z = false;
        if (this.gpR != null && !this.iEh.isFinishing() && this.gpR.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.iEp = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.gpS);
            this.iEp.a(this.iEv);
            int i2 = 0;
            while (true) {
                if (i2 < this.gpW.size()) {
                    if (this.iEm == null || this.gpW.get(i2) != this.iEm || (i = i2 + 1) > this.gpW.size()) {
                        i2++;
                    } else {
                        this.gpW.add(i, this.iEp);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.gpW.add(this.iEp);
            }
            this.gpS.aI(this.gpW);
        }
    }

    public void cp(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                n nVar = new n();
                nVar.type = 0;
                nVar.kTw = imageBitmap;
                String currentImageUrl = this.iDx.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.kTv = String.valueOf(System.currentTimeMillis()) + as.getNameMd5FromUrl(currentImageUrl);
                } else {
                    nVar.kTv = String.valueOf(BdUniqueId.gen().getId());
                }
                this.iEj = nVar.kTv;
                this.iEh.sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    public void clG() {
        this.iEj = null;
    }

    public void release() {
        if (this.iEi != null) {
            this.iEi.cancel();
            this.iEi = null;
        }
        if (this.iEk != null) {
            this.iEk.cancel();
            this.iEk = null;
        }
    }
}
