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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes15.dex */
public class j implements ImageViewerBottomLayout.b, ImageViewerBottomLayout.c {
    private com.baidu.tbadk.core.dialog.i gXs;
    private k gXt;
    private com.baidu.tbadk.core.dialog.g hhC;
    private final ImageViewerActivity jtQ;
    private a jtR;
    private com.baidu.tieba.ueg.c jtT;
    private com.baidu.tbadk.core.dialog.g jtU;
    private com.baidu.tbadk.core.dialog.g jtV;
    private com.baidu.tbadk.core.dialog.g jtW;
    private com.baidu.tbadk.core.dialog.g jtX;
    private com.baidu.tbadk.core.dialog.g jtY;
    private MultiImageView jte;
    private PermissionJudgePolicy mPermissionJudgement;
    private String jtS = null;
    private List<com.baidu.tbadk.core.dialog.g> gXx = null;
    private CustomMessageListener jtZ = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o) && !j.this.jtQ.isFinishing() && (oVar = (o) customResponsedMessage.getData()) != null) {
                oVar.lOi = null;
                if (!TextUtils.isEmpty(oVar.lOk) && !TextUtils.isEmpty(oVar.lOh) && oVar.lOh.equals(j.this.jtS)) {
                    j.this.jte.setCurrentImageQRInfo(oVar.lOk);
                    j.this.IE(oVar.lOk);
                }
            }
        }
    };
    private k.b jua = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.jte.nH(j.this.jtQ.cqp());
            j.this.bRG();
        }
    };
    private k.b jub = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aF(j.this.jtQ.getPageContext().getPageActivity(), j.this.jte.getCurrentImageUrl());
            j.this.bRG();
            j.this.zM(1);
        }
    };
    private k.b juc = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.jte.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.bRG();
            j.this.zM(2);
        }
    };
    private k.b hhD = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.jtQ.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.bRG();
                j.this.zM(3);
            }
        }
    };
    private k.b jud = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.bhd();
            j.this.bRG();
            j.this.zM(4);
            j.this.cAe();
        }
    };
    private k.b jue = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.jtQ = imageViewerActivity;
        this.jtQ.registerListener(this.jtZ);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.jte = multiImageView;
        if (this.gXs == null) {
            this.gXt = new k(this.jtQ);
        }
        if (this.gXx == null) {
            this.gXx = new ArrayList();
        }
        bUO();
        this.gXs = new com.baidu.tbadk.core.dialog.i(this.jtQ.getPageContext(), this.gXt);
    }

    public void bUO() {
        this.gXx.clear();
        String nG = this.jte.nG(this.jtQ.cqp());
        if (nG != null) {
            this.jtU = new com.baidu.tbadk.core.dialog.g(nG, this.gXt);
            this.jtU.a(this.jua);
            this.gXx.add(this.jtU);
        }
        this.hhC = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.gXt);
        this.hhC.a(this.hhD);
        this.gXx.add(this.hhC);
        if (this.jtQ != null && !this.jtQ.cAa()) {
            this.jtW = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.gXt);
            this.jtW.a(this.juc);
            this.gXx.add(this.jtW);
        }
        this.jtV = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.gXt);
        this.jtV.a(this.jub);
        this.gXx.add(this.jtV);
        String currentImageQRInfo = this.jte.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.jtY = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.gXt);
            this.jtY.a(this.jue);
            this.gXx.add(this.jtY);
        }
        this.jtX = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.gXt);
        this.jtX.a(this.jud);
        this.gXx.add(this.jtX);
        this.gXt.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.bRG();
            }
        });
        this.gXt.aS(this.gXx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.jtQ.getString(i);
    }

    public void bRG() {
        if (this.gXs != null && this.gXs.isShowing()) {
            this.gXs.dismiss();
        }
    }

    public void show() {
        if (this.gXs != null && !this.jtQ.isFinishing()) {
            this.gXs.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.jte.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.jtQ.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.jtT != null && !j.this.jtT.isCancelled()) {
                    j.this.jtT.cancel();
                }
                j.this.jtT = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void cAg() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cAh() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.jtQ.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.xk(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.xl(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.hJ(false);
                        aVar.hK(false);
                        aVar.b(j.this.jtQ.getPageContext()).aYL();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cAi() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.jtQ.getPageContext().getPageActivity());
                        aVar.xk(null);
                        aVar.setMessageShowCenter(true);
                        aVar.xl(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.hJ(false);
                        aVar.hK(false);
                        aVar.b(j.this.jtQ.getPageContext()).aYL();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.jtQ.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.jtT.setPriority(3);
                j.this.jtT.execute(new String[0]);
                j.this.bRG();
                j.this.zM(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.jtQ.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.jtR = new a(this.jte.getCurrentImageUrl(), this.jte.getCurrentImageData());
            this.jtR.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.jtQ.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void bhd() {
        UrlDragImageView currentUrlDragImageView;
        if (this.jte != null && (currentUrlDragImageView = this.jte.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.jte.getCurrentImageUrl();
                str2 = au.getNameMd5FromUrl(str);
            }
            ShareItem shareItem = new ShareItem();
            if (imageUrlData != null) {
                long j = imageUrlData.threadId;
                if (j > 0) {
                    shareItem.linkUrl = "http://tieba.baidu.com/p/" + j + "?fr=share";
                }
            }
            if (!as.isEmpty(str)) {
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
            shareItem.etS = 14;
            this.jtQ.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.jtQ, shareItem, false)));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void bhc() {
        Activity pageActivity = this.jtQ.getPageContext().getPageActivity();
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
    /* loaded from: classes15.dex */
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
            Map<String, ImageUrlData> czR = j.this.jtQ.czR();
            if (this.mUrl != null && czR != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = czR.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ar.baP().xQ(nameMd5FromUrl) + "/" + au.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = n.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && n.copyImageFile(str, this.mUrl, j.this.jtQ.getPageContext().getPageActivity()) == 0) {
                        return j.this.jtQ.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (n.saveImageFileByUser(this.mUrl, this.mData, j.this.jtQ.getPageContext().getPageActivity())) {
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
            j.this.jtQ.showToast(str);
            j.this.jtR = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.jtR = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zM(int i) {
        TiebaStatic.log(new ap("c13270").dn("uid", this.jtQ.getUserId()).ah("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAe() {
    }

    public void IE(String str) {
        int i;
        boolean z = false;
        if (this.gXs != null && !this.jtQ.isFinishing() && this.gXs.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.jtY = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.gXt);
            this.jtY.a(this.jue);
            int i2 = 0;
            while (true) {
                if (i2 < this.gXx.size()) {
                    if (this.jtV == null || this.gXx.get(i2) != this.jtV || (i = i2 + 1) > this.gXx.size()) {
                        i2++;
                    } else {
                        this.gXx.add(i, this.jtY);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.gXx.add(this.jtY);
            }
            this.gXt.aS(this.gXx);
        }
    }

    public void cw(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                o oVar = new o();
                oVar.type = 0;
                oVar.lOi = imageBitmap;
                String currentImageUrl = this.jte.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    oVar.lOh = String.valueOf(System.currentTimeMillis()) + au.getNameMd5FromUrl(currentImageUrl);
                } else {
                    oVar.lOh = String.valueOf(BdUniqueId.gen().getId());
                }
                this.jtS = oVar.lOh;
                this.jtQ.sendMessage(new CustomMessage(2921403, oVar));
            }
        }
    }

    public void cAf() {
        this.jtS = null;
    }

    public void release() {
        if (this.jtR != null) {
            this.jtR.cancel();
            this.jtR = null;
        }
        if (this.jtT != null) {
            this.jtT.cancel();
            this.jtT = null;
        }
    }

    public void onChangeSkinType() {
        if (this.gXt != null) {
            this.gXt.onChangeSkinType();
        }
    }
}
