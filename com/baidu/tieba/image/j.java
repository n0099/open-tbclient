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
/* loaded from: classes15.dex */
public class j implements ImageViewerBottomLayout.b, ImageViewerBottomLayout.c {
    private com.baidu.tbadk.core.dialog.i hkl;
    private k hkm;
    private com.baidu.tbadk.core.dialog.g huv;
    private final ImageViewerActivity jIY;
    private a jIZ;
    private MultiImageView jIj;
    private com.baidu.tieba.ueg.c jJb;
    private com.baidu.tbadk.core.dialog.g jJc;
    private com.baidu.tbadk.core.dialog.g jJd;
    private com.baidu.tbadk.core.dialog.g jJe;
    private com.baidu.tbadk.core.dialog.g jJf;
    private com.baidu.tbadk.core.dialog.g jJg;
    private PermissionJudgePolicy mPermissionJudgement;
    private String jJa = null;
    private List<com.baidu.tbadk.core.dialog.g> hkq = null;
    private CustomMessageListener jJh = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o) && !j.this.jIY.isFinishing() && (oVar = (o) customResponsedMessage.getData()) != null) {
                oVar.mfU = null;
                if (!TextUtils.isEmpty(oVar.mfW) && !TextUtils.isEmpty(oVar.mfT) && oVar.mfT.equals(j.this.jJa)) {
                    j.this.jIj.setCurrentImageQRInfo(oVar.mfW);
                    j.this.Lw(oVar.mfW);
                }
            }
        }
    };
    private k.b jJi = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.jIj.pS(j.this.jIY.cBh());
            j.this.cbS();
        }
    };
    private k.b jJj = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aJ(j.this.jIY.getPageContext().getPageActivity(), j.this.jIj.getCurrentImageUrl());
            j.this.cbS();
            j.this.Cf(1);
        }
    };
    private k.b jJk = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.jIj.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.cbS();
            j.this.Cf(2);
        }
    };
    private k.b huw = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.jIY.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.cbS();
                j.this.Cf(3);
            }
        }
    };
    private k.b jJl = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.bpP();
            j.this.cbS();
            j.this.Cf(4);
            j.this.cKU();
        }
    };
    private k.b jJm = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.jIY = imageViewerActivity;
        this.jIY.registerListener(this.jJh);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.jIj = multiImageView;
        if (this.hkl == null) {
            this.hkm = new k(this.jIY);
        }
        if (this.hkq == null) {
            this.hkq = new ArrayList();
        }
        ceW();
        this.hkl = new com.baidu.tbadk.core.dialog.i(this.jIY.getPageContext(), this.hkm);
    }

    public void ceW() {
        this.hkq.clear();
        String pR = this.jIj.pR(this.jIY.cBh());
        if (pR != null) {
            this.jJc = new com.baidu.tbadk.core.dialog.g(pR, this.hkm);
            this.jJc.a(this.jJi);
            this.hkq.add(this.jJc);
        }
        this.huv = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.hkm);
        this.huv.a(this.huw);
        this.hkq.add(this.huv);
        if (this.jIY != null && !this.jIY.cKQ()) {
            this.jJe = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.hkm);
            this.jJe.a(this.jJk);
            this.hkq.add(this.jJe);
        }
        this.jJd = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.hkm);
        this.jJd.a(this.jJj);
        this.hkq.add(this.jJd);
        String currentImageQRInfo = this.jIj.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.jJg = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hkm);
            this.jJg.a(this.jJm);
            this.hkq.add(this.jJg);
        }
        this.jJf = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.hkm);
        this.jJf.a(this.jJl);
        this.hkq.add(this.jJf);
        this.hkm.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.cbS();
            }
        });
        this.hkm.aT(this.hkq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.jIY.getString(i);
    }

    public void cbS() {
        if (this.hkl != null && this.hkl.isShowing()) {
            this.hkl.dismiss();
        }
    }

    public void show() {
        if (this.hkl != null && !this.jIY.isFinishing()) {
            this.hkl.Nv();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.jIj.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.jIY.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.jJb != null && !j.this.jJb.isCancelled()) {
                    j.this.jJb.cancel();
                }
                j.this.jJb = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void cKW() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cKX() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.jIY.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.zy(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.zz(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.m39if(false);
                        aVar.ig(false);
                        aVar.b(j.this.jIY.getPageContext()).bhg();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cKY() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.jIY.getPageContext().getPageActivity());
                        aVar.zy(null);
                        aVar.setMessageShowCenter(true);
                        aVar.zz(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.m39if(false);
                        aVar.ig(false);
                        aVar.b(j.this.jIY.getPageContext()).bhg();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.jIY.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.jJb.setPriority(3);
                j.this.jJb.execute(new String[0]);
                j.this.cbS();
                j.this.Cf(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.jIY.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.jIZ = new a(this.jIj.getCurrentImageUrl(), this.jIj.getCurrentImageData());
            this.jIZ.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.jIY.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void bpP() {
        UrlDragImageView currentUrlDragImageView;
        if (this.jIj != null && (currentUrlDragImageView = this.jIj.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.jIj.getCurrentImageUrl();
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
            shareItem.eEs = 14;
            this.jIY.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.jIY, shareItem, false)));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void bpO() {
        Activity pageActivity = this.jIY.getPageContext().getPageActivity();
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
            Map<String, ImageUrlData> cKH = j.this.jIY.cKH();
            if (this.mUrl != null && cKH != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = cKH.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + as.bjo().Ae(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = n.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && n.copyImageFile(str, this.mUrl, j.this.jIY.getPageContext().getPageActivity()) == 0) {
                        return j.this.jIY.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (n.saveImageFileByUser(this.mUrl, this.mData, j.this.jIY.getPageContext().getPageActivity())) {
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
            j.this.jIY.showToast(str);
            j.this.jIZ = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.jIZ = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cf(int i) {
        TiebaStatic.log(new aq("c13270").dD("uid", this.jIY.getUserId()).ai("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKU() {
    }

    public void Lw(String str) {
        int i;
        boolean z = false;
        if (this.hkl != null && !this.jIY.isFinishing() && this.hkl.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.jJg = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hkm);
            this.jJg.a(this.jJm);
            int i2 = 0;
            while (true) {
                if (i2 < this.hkq.size()) {
                    if (this.jJd == null || this.hkq.get(i2) != this.jJd || (i = i2 + 1) > this.hkq.size()) {
                        i2++;
                    } else {
                        this.hkq.add(i, this.jJg);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.hkq.add(this.jJg);
            }
            this.hkm.aT(this.hkq);
        }
    }

    public void cA(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                o oVar = new o();
                oVar.type = 0;
                oVar.mfU = imageBitmap;
                String currentImageUrl = this.jIj.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    oVar.mfT = String.valueOf(System.currentTimeMillis()) + av.getNameMd5FromUrl(currentImageUrl);
                } else {
                    oVar.mfT = String.valueOf(BdUniqueId.gen().getId());
                }
                this.jJa = oVar.mfT;
                this.jIY.sendMessage(new CustomMessage(2921403, oVar));
            }
        }
    }

    public void cKV() {
        this.jJa = null;
    }

    public void release() {
        if (this.jIZ != null) {
            this.jIZ.cancel();
            this.jIZ = null;
        }
        if (this.jJb != null) {
            this.jJb.cancel();
            this.jJb = null;
        }
    }

    public void onChangeSkinType() {
        if (this.hkm != null) {
            this.hkm.onChangeSkinType();
        }
    }
}
