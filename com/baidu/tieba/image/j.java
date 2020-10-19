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
    private com.baidu.tbadk.core.dialog.i hGm;
    private k hGn;
    private com.baidu.tbadk.core.dialog.g hQB;
    private MultiImageView kfQ;
    private final ImageViewerActivity kgD;
    private a kgE;
    private com.baidu.tieba.ueg.c kgG;
    private com.baidu.tbadk.core.dialog.g kgH;
    private com.baidu.tbadk.core.dialog.g kgI;
    private com.baidu.tbadk.core.dialog.g kgJ;
    private com.baidu.tbadk.core.dialog.g kgK;
    private com.baidu.tbadk.core.dialog.g kgL;
    private PermissionJudgePolicy mPermissionJudgement;
    private String kgF = null;
    private List<com.baidu.tbadk.core.dialog.g> hGr = null;
    private CustomMessageListener kgM = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o) && !j.this.kgD.isFinishing() && (oVar = (o) customResponsedMessage.getData()) != null) {
                oVar.mFq = null;
                if (!TextUtils.isEmpty(oVar.mFs) && !TextUtils.isEmpty(oVar.mFp) && oVar.mFp.equals(j.this.kgF)) {
                    j.this.kfQ.setCurrentImageQRInfo(oVar.mFs);
                    j.this.MO(oVar.mFs);
                }
            }
        }
    };
    private k.b kgN = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.kfQ.qD(j.this.kgD.cIy());
            j.this.ciE();
        }
    };
    private k.b kgO = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aO(j.this.kgD.getPageContext().getPageActivity(), j.this.kfQ.getCurrentImageUrl());
            j.this.ciE();
            j.this.Dm(1);
        }
    };
    private k.b kgP = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.kfQ.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.ciE();
            j.this.Dm(2);
        }
    };
    private k.b hQC = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.kgD.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.ciE();
                j.this.Dm(3);
            }
        }
    };
    private k.b kgQ = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.btu();
            j.this.ciE();
            j.this.Dm(4);
            j.this.cSj();
        }
    };
    private k.b kgR = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.kgD = imageViewerActivity;
        this.kgD.registerListener(this.kgM);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.kfQ = multiImageView;
        if (this.hGm == null) {
            this.hGn = new k(this.kgD);
        }
        if (this.hGr == null) {
            this.hGr = new ArrayList();
        }
        clI();
        this.hGm = new com.baidu.tbadk.core.dialog.i(this.kgD.getPageContext(), this.hGn);
    }

    public void clI() {
        this.hGr.clear();
        String qC = this.kfQ.qC(this.kgD.cIy());
        if (qC != null) {
            this.kgH = new com.baidu.tbadk.core.dialog.g(qC, this.hGn);
            this.kgH.a(this.kgN);
            this.hGr.add(this.kgH);
        }
        this.hQB = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.hGn);
        this.hQB.a(this.hQC);
        this.hGr.add(this.hQB);
        if (this.kgD != null && !this.kgD.cSf()) {
            this.kgJ = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.hGn);
            this.kgJ.a(this.kgP);
            this.hGr.add(this.kgJ);
        }
        this.kgI = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.hGn);
        this.kgI.a(this.kgO);
        this.hGr.add(this.kgI);
        String currentImageQRInfo = this.kfQ.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.kgL = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hGn);
            this.kgL.a(this.kgR);
            this.hGr.add(this.kgL);
        }
        this.kgK = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.hGn);
        this.kgK.a(this.kgQ);
        this.hGr.add(this.kgK);
        this.hGn.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.ciE();
            }
        });
        this.hGn.ba(this.hGr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.kgD.getString(i);
    }

    public void ciE() {
        if (this.hGm != null && this.hGm.isShowing()) {
            this.hGm.dismiss();
        }
    }

    public void show() {
        if (this.hGm != null && !this.kgD.isFinishing()) {
            this.hGm.Pd();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.kfQ.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.kgD.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.kgG != null && !j.this.kgG.isCancelled()) {
                    j.this.kgG.cancel();
                }
                j.this.kgG = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void cSl() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cSm() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kgD.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.AG(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.AH(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.iz(false);
                        aVar.iA(false);
                        aVar.b(j.this.kgD.getPageContext()).bkJ();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cSn() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kgD.getPageContext().getPageActivity());
                        aVar.AG(null);
                        aVar.setMessageShowCenter(true);
                        aVar.AH(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.iz(false);
                        aVar.iA(false);
                        aVar.b(j.this.kgD.getPageContext()).bkJ();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.kgD.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.kgG.setPriority(3);
                j.this.kgG.execute(new String[0]);
                j.this.ciE();
                j.this.Dm(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.kgD.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.kgE = new a(this.kfQ.getCurrentImageUrl(), this.kfQ.getCurrentImageData());
            this.kgE.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.kgD.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void btu() {
        UrlDragImageView currentUrlDragImageView;
        if (this.kfQ != null && (currentUrlDragImageView = this.kfQ.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.kfQ.getCurrentImageUrl();
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
            shareItem.eSJ = 14;
            this.kgD.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.kgD, shareItem, false)));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void btt() {
        Activity pageActivity = this.kgD.getPageContext().getPageActivity();
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
            Map<String, ImageUrlData> cRW = j.this.kgD.cRW();
            if (this.mUrl != null && cRW != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = cRW.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + as.bmS().Bn(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = n.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && n.copyImageFile(str, this.mUrl, j.this.kgD.getPageContext().getPageActivity()) == 0) {
                        return j.this.kgD.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (n.saveImageFileByUser(this.mUrl, this.mData, j.this.kgD.getPageContext().getPageActivity())) {
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
            j.this.kgD.showToast(str);
            j.this.kgE = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.kgE = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dm(int i) {
        TiebaStatic.log(new aq("c13270").dK("uid", this.kgD.getUserId()).aj("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSj() {
    }

    public void MO(String str) {
        int i;
        boolean z = false;
        if (this.hGm != null && !this.kgD.isFinishing() && this.hGm.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.kgL = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hGn);
            this.kgL.a(this.kgR);
            int i2 = 0;
            while (true) {
                if (i2 < this.hGr.size()) {
                    if (this.kgI == null || this.hGr.get(i2) != this.kgI || (i = i2 + 1) > this.hGr.size()) {
                        i2++;
                    } else {
                        this.hGr.add(i, this.kgL);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.hGr.add(this.kgL);
            }
            this.hGn.ba(this.hGr);
        }
    }

    public void cN(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                o oVar = new o();
                oVar.type = 0;
                oVar.mFq = imageBitmap;
                String currentImageUrl = this.kfQ.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    oVar.mFp = String.valueOf(System.currentTimeMillis()) + av.getNameMd5FromUrl(currentImageUrl);
                } else {
                    oVar.mFp = String.valueOf(BdUniqueId.gen().getId());
                }
                this.kgF = oVar.mFp;
                this.kgD.sendMessage(new CustomMessage(2921403, oVar));
            }
        }
    }

    public void cSk() {
        this.kgF = null;
    }

    public void release() {
        if (this.kgE != null) {
            this.kgE.cancel();
            this.kgE = null;
        }
        if (this.kgG != null) {
            this.kgG.cancel();
            this.kgG = null;
        }
    }

    public void onChangeSkinType() {
        if (this.hGn != null) {
            this.hGn.onChangeSkinType();
        }
    }
}
