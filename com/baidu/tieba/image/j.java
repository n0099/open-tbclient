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
import com.baidu.tieba.tbadkCore.data.o;
import com.baidu.tieba.ueg.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class j {
    private com.baidu.tbadk.core.dialog.i gEM;
    private k gEN;
    private com.baidu.tbadk.core.dialog.g gPc;
    private MultiImageView iSA;
    private final ImageViewerActivity iTm;
    private a iTn;
    private com.baidu.tieba.ueg.c iTp;
    private com.baidu.tbadk.core.dialog.g iTq;
    private com.baidu.tbadk.core.dialog.g iTr;
    private com.baidu.tbadk.core.dialog.g iTs;
    private com.baidu.tbadk.core.dialog.g iTt;
    private com.baidu.tbadk.core.dialog.g iTu;
    private PermissionJudgePolicy mPermissionJudgement;
    private String iTo = null;
    private List<com.baidu.tbadk.core.dialog.g> gER = null;
    private CustomMessageListener iTv = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o) && !j.this.iTm.isFinishing() && (oVar = (o) customResponsedMessage.getData()) != null) {
                oVar.llT = null;
                if (!TextUtils.isEmpty(oVar.llV) && !TextUtils.isEmpty(oVar.llS) && oVar.llS.equals(j.this.iTo)) {
                    j.this.iSA.setCurrentImageQRInfo(oVar.llV);
                    j.this.Hn(oVar.llV);
                }
            }
        }
    };
    private k.b iTw = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.iSA.mT(j.this.iTm.ciQ());
            j.this.bLl();
        }
    };
    private k.b iTx = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aG(j.this.iTm.getPageContext().getPageActivity(), j.this.iSA.getCurrentImageUrl());
            j.this.bLl();
            j.this.yz(1);
        }
    };
    private k.b iTy = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.iSA.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.bLl();
            j.this.yz(2);
        }
    };
    private k.b gPd = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.iTm.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.bLl();
                j.this.yz(3);
            }
        }
    };
    private k.b iTz = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.iSA != null && (currentUrlDragImageView = j.this.iSA.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.iSA.getCurrentImageUrl();
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
                shareItem.isFromImageViewer = true;
                shareItem.eeV = 14;
                j.this.iTm.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(j.this.iTm, shareItem, false)));
                j.this.bLl();
                j.this.yz(4);
            }
        }
    };
    private k.b iTA = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.iTm = imageViewerActivity;
        this.iTm.registerListener(this.iTv);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.iSA = multiImageView;
        if (this.gEM == null) {
            this.gEN = new k(this.iTm);
        }
        if (this.gER == null) {
            this.gER = new ArrayList();
        }
        bOw();
        this.gEM = new com.baidu.tbadk.core.dialog.i(this.iTm.getPageContext(), this.gEN);
    }

    public void bOw() {
        this.gER.clear();
        String mS = this.iSA.mS(this.iTm.ciQ());
        if (mS != null) {
            this.iTq = new com.baidu.tbadk.core.dialog.g(mS, this.gEN);
            this.iTq.a(this.iTw);
            this.gER.add(this.iTq);
        }
        this.gPc = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.gEN);
        this.gPc.a(this.gPd);
        this.gER.add(this.gPc);
        if (this.iTm != null && !this.iTm.csd()) {
            this.iTs = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.gEN);
            this.iTs.a(this.iTy);
            this.gER.add(this.iTs);
        }
        this.iTr = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.gEN);
        this.iTr.a(this.iTx);
        this.gER.add(this.iTr);
        String currentImageQRInfo = this.iSA.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.iTu = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.gEN);
            this.iTu.a(this.iTA);
            this.gER.add(this.iTu);
        }
        this.iTt = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.gEN);
        this.iTt.a(this.iTz);
        this.gER.add(this.iTt);
        this.gEN.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.bLl();
            }
        });
        this.gEN.aD(this.gER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.iTm.getString(i);
    }

    public void bLl() {
        if (this.gEM != null && this.gEM.isShowing()) {
            this.gEM.dismiss();
        }
    }

    public void show() {
        if (this.gEM != null && !this.iTm.isFinishing()) {
            this.gEM.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.iSA.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.iTm.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.iTp != null && !j.this.iTp.isCancelled()) {
                    j.this.iTp.cancel();
                }
                j.this.iTp = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void csi() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void csj() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.iTm.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.vN(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.vO(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.gW(false);
                        aVar.gX(false);
                        aVar.b(j.this.iTm.getPageContext()).aST();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void csk() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.iTm.getPageContext().getPageActivity());
                        aVar.vN(null);
                        aVar.setMessageShowCenter(true);
                        aVar.vO(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.gW(false);
                        aVar.gX(false);
                        aVar.b(j.this.iTm.getPageContext()).aST();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.iTm.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.iTp.setPriority(3);
                j.this.iTp.execute(new String[0]);
                j.this.bLl();
                j.this.yz(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.iTm.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.iTn = new a(this.iSA.getCurrentImageUrl(), this.iSA.getCurrentImageData());
            this.iTn.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.iTm.getFrom())) {
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
            Map<String, ImageUrlData> crU = j.this.iTm.crU();
            if (this.mUrl != null && crU != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = crU.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.aUT().ws(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = m.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && m.copyImageFile(str, this.mUrl, j.this.iTm.getPageContext().getPageActivity()) == 0) {
                        return j.this.iTm.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.saveImageFileByUser(this.mUrl, this.mData, j.this.iTm.getPageContext().getPageActivity())) {
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
            j.this.iTm.showToast(str);
            j.this.iTn = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.iTn = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yz(int i) {
        TiebaStatic.log(new an("c13270").dh("uid", this.iTm.getUserId()).ag("obj_type", i));
    }

    public void Hn(String str) {
        int i;
        boolean z = false;
        if (this.gEM != null && !this.iTm.isFinishing() && this.gEM.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.iTu = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.gEN);
            this.iTu.a(this.iTA);
            int i2 = 0;
            while (true) {
                if (i2 < this.gER.size()) {
                    if (this.iTr == null || this.gER.get(i2) != this.iTr || (i = i2 + 1) > this.gER.size()) {
                        i2++;
                    } else {
                        this.gER.add(i, this.iTu);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.gER.add(this.iTu);
            }
            this.gEN.aD(this.gER);
        }
    }

    public void cp(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                o oVar = new o();
                oVar.type = 0;
                oVar.llT = imageBitmap;
                String currentImageUrl = this.iSA.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    oVar.llS = String.valueOf(System.currentTimeMillis()) + as.getNameMd5FromUrl(currentImageUrl);
                } else {
                    oVar.llS = String.valueOf(BdUniqueId.gen().getId());
                }
                this.iTo = oVar.llS;
                this.iTm.sendMessage(new CustomMessage(2921403, oVar));
            }
        }
    }

    public void csh() {
        this.iTo = null;
    }

    public void release() {
        if (this.iTn != null) {
            this.iTn.cancel();
            this.iTn = null;
        }
        if (this.iTp != null) {
            this.iTp.cancel();
            this.iTp = null;
        }
    }
}
