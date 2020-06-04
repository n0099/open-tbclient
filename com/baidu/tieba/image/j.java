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
    private com.baidu.tbadk.core.dialog.i gEX;
    private k gEY;
    private com.baidu.tbadk.core.dialog.g gPn;
    private final ImageViewerActivity iTZ;
    private MultiImageView iTn;
    private a iUa;
    private com.baidu.tieba.ueg.c iUc;
    private com.baidu.tbadk.core.dialog.g iUd;
    private com.baidu.tbadk.core.dialog.g iUe;
    private com.baidu.tbadk.core.dialog.g iUf;
    private com.baidu.tbadk.core.dialog.g iUg;
    private com.baidu.tbadk.core.dialog.g iUh;
    private PermissionJudgePolicy mPermissionJudgement;
    private String iUb = null;
    private List<com.baidu.tbadk.core.dialog.g> gFc = null;
    private CustomMessageListener iUi = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o) && !j.this.iTZ.isFinishing() && (oVar = (o) customResponsedMessage.getData()) != null) {
                oVar.lnc = null;
                if (!TextUtils.isEmpty(oVar.lne) && !TextUtils.isEmpty(oVar.lnb) && oVar.lnb.equals(j.this.iUb)) {
                    j.this.iTn.setCurrentImageQRInfo(oVar.lne);
                    j.this.Hn(oVar.lne);
                }
            }
        }
    };
    private k.b iUj = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.iTn.mV(j.this.iTZ.ciZ());
            j.this.bLn();
        }
    };
    private k.b iUk = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aG(j.this.iTZ.getPageContext().getPageActivity(), j.this.iTn.getCurrentImageUrl());
            j.this.bLn();
            j.this.yB(1);
        }
    };
    private k.b iUl = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.iTn.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.bLn();
            j.this.yB(2);
        }
    };
    private k.b gPo = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.iTZ.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.bLn();
                j.this.yB(3);
            }
        }
    };
    private k.b iUm = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.iTn != null && (currentUrlDragImageView = j.this.iTn.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.iTn.getCurrentImageUrl();
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
                j.this.iTZ.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(j.this.iTZ, shareItem, false)));
                j.this.bLn();
                j.this.yB(4);
            }
        }
    };
    private k.b iUn = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.iTZ = imageViewerActivity;
        this.iTZ.registerListener(this.iUi);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.iTn = multiImageView;
        if (this.gEX == null) {
            this.gEY = new k(this.iTZ);
        }
        if (this.gFc == null) {
            this.gFc = new ArrayList();
        }
        bOy();
        this.gEX = new com.baidu.tbadk.core.dialog.i(this.iTZ.getPageContext(), this.gEY);
    }

    public void bOy() {
        this.gFc.clear();
        String mU = this.iTn.mU(this.iTZ.ciZ());
        if (mU != null) {
            this.iUd = new com.baidu.tbadk.core.dialog.g(mU, this.gEY);
            this.iUd.a(this.iUj);
            this.gFc.add(this.iUd);
        }
        this.gPn = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.gEY);
        this.gPn.a(this.gPo);
        this.gFc.add(this.gPn);
        if (this.iTZ != null && !this.iTZ.csm()) {
            this.iUf = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.gEY);
            this.iUf.a(this.iUl);
            this.gFc.add(this.iUf);
        }
        this.iUe = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.gEY);
        this.iUe.a(this.iUk);
        this.gFc.add(this.iUe);
        String currentImageQRInfo = this.iTn.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.iUh = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.gEY);
            this.iUh.a(this.iUn);
            this.gFc.add(this.iUh);
        }
        this.iUg = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.gEY);
        this.iUg.a(this.iUm);
        this.gFc.add(this.iUg);
        this.gEY.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.bLn();
            }
        });
        this.gEY.aD(this.gFc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.iTZ.getString(i);
    }

    public void bLn() {
        if (this.gEX != null && this.gEX.isShowing()) {
            this.gEX.dismiss();
        }
    }

    public void show() {
        if (this.gEX != null && !this.iTZ.isFinishing()) {
            this.gEX.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.iTn.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.iTZ.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.iUc != null && !j.this.iUc.isCancelled()) {
                    j.this.iUc.cancel();
                }
                j.this.iUc = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void csr() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void css() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.iTZ.getPageContext().getPageActivity());
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
                        aVar.b(j.this.iTZ.getPageContext()).aST();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cst() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.iTZ.getPageContext().getPageActivity());
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
                        aVar.b(j.this.iTZ.getPageContext()).aST();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.iTZ.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.iUc.setPriority(3);
                j.this.iUc.execute(new String[0]);
                j.this.bLn();
                j.this.yB(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.iTZ.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.iUa = new a(this.iTn.getCurrentImageUrl(), this.iTn.getCurrentImageData());
            this.iUa.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.iTZ.getFrom())) {
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
            Map<String, ImageUrlData> csd = j.this.iTZ.csd();
            if (this.mUrl != null && csd != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = csd.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.aUU().ws(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = m.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && m.copyImageFile(str, this.mUrl, j.this.iTZ.getPageContext().getPageActivity()) == 0) {
                        return j.this.iTZ.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.saveImageFileByUser(this.mUrl, this.mData, j.this.iTZ.getPageContext().getPageActivity())) {
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
            j.this.iTZ.showToast(str);
            j.this.iUa = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.iUa = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yB(int i) {
        TiebaStatic.log(new an("c13270").dh("uid", this.iTZ.getUserId()).ag("obj_type", i));
    }

    public void Hn(String str) {
        int i;
        boolean z = false;
        if (this.gEX != null && !this.iTZ.isFinishing() && this.gEX.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.iUh = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.gEY);
            this.iUh.a(this.iUn);
            int i2 = 0;
            while (true) {
                if (i2 < this.gFc.size()) {
                    if (this.iUe == null || this.gFc.get(i2) != this.iUe || (i = i2 + 1) > this.gFc.size()) {
                        i2++;
                    } else {
                        this.gFc.add(i, this.iUh);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.gFc.add(this.iUh);
            }
            this.gEY.aD(this.gFc);
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
                oVar.lnc = imageBitmap;
                String currentImageUrl = this.iTn.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    oVar.lnb = String.valueOf(System.currentTimeMillis()) + as.getNameMd5FromUrl(currentImageUrl);
                } else {
                    oVar.lnb = String.valueOf(BdUniqueId.gen().getId());
                }
                this.iUb = oVar.lnb;
                this.iTZ.sendMessage(new CustomMessage(2921403, oVar));
            }
        }
    }

    public void csq() {
        this.iUb = null;
    }

    public void release() {
        if (this.iUa != null) {
            this.iUa.cancel();
            this.iUa = null;
        }
        if (this.iUc != null) {
            this.iUc.cancel();
            this.iUc = null;
        }
    }
}
