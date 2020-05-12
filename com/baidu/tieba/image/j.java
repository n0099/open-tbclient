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
    private com.baidu.tbadk.core.dialog.g gAs;
    private com.baidu.tbadk.core.dialog.i gpX;
    private k gpY;
    private MultiImageView iDD;
    private final ImageViewerActivity iEn;
    private a iEo;
    private com.baidu.tieba.ueg.c iEq;
    private com.baidu.tbadk.core.dialog.g iEr;
    private com.baidu.tbadk.core.dialog.g iEs;
    private com.baidu.tbadk.core.dialog.g iEt;
    private com.baidu.tbadk.core.dialog.g iEu;
    private com.baidu.tbadk.core.dialog.g iEv;
    private PermissionJudgePolicy mPermissionJudgement;
    private String iEp = null;
    private List<com.baidu.tbadk.core.dialog.g> gqc = null;
    private CustomMessageListener iEw = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !j.this.iEn.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.kTA = null;
                if (!TextUtils.isEmpty(nVar.kTC) && !TextUtils.isEmpty(nVar.kTz) && nVar.kTz.equals(j.this.iEp)) {
                    j.this.iDD.setCurrentImageQRInfo(nVar.kTC);
                    j.this.FD(nVar.kTC);
                }
            }
        }
    };
    private k.b iEx = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.iDD.mr(j.this.iEn.ccs());
            j.this.bES();
        }
    };
    private k.b iEy = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aF(j.this.iEn.getPageContext().getPageActivity(), j.this.iDD.getCurrentImageUrl());
            j.this.bES();
            j.this.xR(1);
        }
    };
    private k.b iEz = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.iDD.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.bES();
            j.this.xR(2);
        }
    };
    private k.b gAt = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.iEn.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.bES();
                j.this.xR(3);
            }
        }
    };
    private k.b iEA = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.iDD != null && (currentUrlDragImageView = j.this.iDD.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.iDD.getCurrentImageUrl();
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
                shareItem.dQu = true;
                shareItem.dQC = 14;
                j.this.iEn.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(j.this.iEn, shareItem, false)));
                j.this.bES();
                j.this.xR(4);
            }
        }
    };
    private k.b iEB = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.iEn = imageViewerActivity;
        this.iEn.registerListener(this.iEw);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.iDD = multiImageView;
        if (this.gpX == null) {
            this.gpY = new k(this.iEn);
        }
        if (this.gqc == null) {
            this.gqc = new ArrayList();
        }
        bId();
        this.gpX = new com.baidu.tbadk.core.dialog.i(this.iEn.getPageContext(), this.gpY);
    }

    public void bId() {
        this.gqc.clear();
        String mq = this.iDD.mq(this.iEn.ccs());
        if (mq != null) {
            this.iEr = new com.baidu.tbadk.core.dialog.g(mq, this.gpY);
            this.iEr.a(this.iEx);
            this.gqc.add(this.iEr);
        }
        this.gAs = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.gpY);
        this.gAs.a(this.gAt);
        this.gqc.add(this.gAs);
        if (this.iEn != null && !this.iEn.clB()) {
            this.iEt = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.gpY);
            this.iEt.a(this.iEz);
            this.gqc.add(this.iEt);
        }
        this.iEs = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.gpY);
        this.iEs.a(this.iEy);
        this.gqc.add(this.iEs);
        String currentImageQRInfo = this.iDD.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.iEv = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.gpY);
            this.iEv.a(this.iEB);
            this.gqc.add(this.iEv);
        }
        this.iEu = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.gpY);
        this.iEu.a(this.iEA);
        this.gqc.add(this.iEu);
        this.gpY.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.bES();
            }
        });
        this.gpY.aI(this.gqc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.iEn.getString(i);
    }

    public void bES() {
        if (this.gpX != null && this.gpX.isShowing()) {
            this.gpX.dismiss();
        }
    }

    public void show() {
        if (this.gpX != null && !this.iEn.isFinishing()) {
            this.gpX.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.iDD.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.iEn.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.iEq != null && !j.this.iEq.isCancelled()) {
                    j.this.iEq.cancel();
                }
                j.this.iEq = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void clG() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void clH() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.iEn.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.uh(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.ui(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.b(j.this.iEn.getPageContext()).aMS();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void clI() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.iEn.getPageContext().getPageActivity());
                        aVar.uh(null);
                        aVar.setMessageShowCenter(true);
                        aVar.ui(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.gE(false);
                        aVar.gF(false);
                        aVar.b(j.this.iEn.getPageContext()).aMS();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.iEn.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.iEq.setPriority(3);
                j.this.iEq.execute(new String[0]);
                j.this.bES();
                j.this.xR(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.iEn.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.iEo = new a(this.iDD.getCurrentImageUrl(), this.iDD.getCurrentImageData());
            this.iEo.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.iEn.getFrom())) {
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
            Map<String, ImageUrlData> clt = j.this.iEn.clt();
            if (this.mUrl != null && clt != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = clt.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.aOP().uM(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = m.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && m.copyImageFile(str, this.mUrl, j.this.iEn.getPageContext().getPageActivity()) == 0) {
                        return j.this.iEn.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.saveImageFileByUser(this.mUrl, this.mData, j.this.iEn.getPageContext().getPageActivity())) {
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
            j.this.iEn.showToast(str);
            j.this.iEo = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.iEo = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xR(int i) {
        TiebaStatic.log(new an("c13270").cI("uid", this.iEn.getUserId()).af("obj_type", i));
    }

    public void FD(String str) {
        int i;
        boolean z = false;
        if (this.gpX != null && !this.iEn.isFinishing() && this.gpX.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.iEv = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.gpY);
            this.iEv.a(this.iEB);
            int i2 = 0;
            while (true) {
                if (i2 < this.gqc.size()) {
                    if (this.iEs == null || this.gqc.get(i2) != this.iEs || (i = i2 + 1) > this.gqc.size()) {
                        i2++;
                    } else {
                        this.gqc.add(i, this.iEv);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.gqc.add(this.iEv);
            }
            this.gpY.aI(this.gqc);
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
                nVar.kTA = imageBitmap;
                String currentImageUrl = this.iDD.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.kTz = String.valueOf(System.currentTimeMillis()) + as.getNameMd5FromUrl(currentImageUrl);
                } else {
                    nVar.kTz = String.valueOf(BdUniqueId.gen().getId());
                }
                this.iEp = nVar.kTz;
                this.iEn.sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    public void clF() {
        this.iEp = null;
    }

    public void release() {
        if (this.iEo != null) {
            this.iEo.cancel();
            this.iEo = null;
        }
        if (this.iEq != null) {
            this.iEq.cancel();
            this.iEq = null;
        }
    }
}
