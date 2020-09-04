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
    private com.baidu.tbadk.core.dialog.i hkp;
    private k hkq;
    private com.baidu.tbadk.core.dialog.g huB;
    private MultiImageView jIp;
    private final ImageViewerActivity jJe;
    private a jJf;
    private com.baidu.tieba.ueg.c jJh;
    private com.baidu.tbadk.core.dialog.g jJi;
    private com.baidu.tbadk.core.dialog.g jJj;
    private com.baidu.tbadk.core.dialog.g jJk;
    private com.baidu.tbadk.core.dialog.g jJl;
    private com.baidu.tbadk.core.dialog.g jJm;
    private PermissionJudgePolicy mPermissionJudgement;
    private String jJg = null;
    private List<com.baidu.tbadk.core.dialog.g> hku = null;
    private CustomMessageListener jJn = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o) && !j.this.jJe.isFinishing() && (oVar = (o) customResponsedMessage.getData()) != null) {
                oVar.mgj = null;
                if (!TextUtils.isEmpty(oVar.mgl) && !TextUtils.isEmpty(oVar.mgi) && oVar.mgi.equals(j.this.jJg)) {
                    j.this.jIp.setCurrentImageQRInfo(oVar.mgl);
                    j.this.Lx(oVar.mgl);
                }
            }
        }
    };
    private k.b jJo = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.jIp.pS(j.this.jJe.cBi());
            j.this.cbT();
        }
    };
    private k.b jJp = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aJ(j.this.jJe.getPageContext().getPageActivity(), j.this.jIp.getCurrentImageUrl());
            j.this.cbT();
            j.this.Cf(1);
        }
    };
    private k.b jJq = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.jIp.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.cbT();
            j.this.Cf(2);
        }
    };
    private k.b huC = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.jJe.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.cbT();
                j.this.Cf(3);
            }
        }
    };
    private k.b jJr = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.bpQ();
            j.this.cbT();
            j.this.Cf(4);
            j.this.cKV();
        }
    };
    private k.b jJs = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.jJe = imageViewerActivity;
        this.jJe.registerListener(this.jJn);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.jIp = multiImageView;
        if (this.hkp == null) {
            this.hkq = new k(this.jJe);
        }
        if (this.hku == null) {
            this.hku = new ArrayList();
        }
        ceX();
        this.hkp = new com.baidu.tbadk.core.dialog.i(this.jJe.getPageContext(), this.hkq);
    }

    public void ceX() {
        this.hku.clear();
        String pR = this.jIp.pR(this.jJe.cBi());
        if (pR != null) {
            this.jJi = new com.baidu.tbadk.core.dialog.g(pR, this.hkq);
            this.jJi.a(this.jJo);
            this.hku.add(this.jJi);
        }
        this.huB = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.hkq);
        this.huB.a(this.huC);
        this.hku.add(this.huB);
        if (this.jJe != null && !this.jJe.cKR()) {
            this.jJk = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.hkq);
            this.jJk.a(this.jJq);
            this.hku.add(this.jJk);
        }
        this.jJj = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.hkq);
        this.jJj.a(this.jJp);
        this.hku.add(this.jJj);
        String currentImageQRInfo = this.jIp.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.jJm = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hkq);
            this.jJm.a(this.jJs);
            this.hku.add(this.jJm);
        }
        this.jJl = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.hkq);
        this.jJl.a(this.jJr);
        this.hku.add(this.jJl);
        this.hkq.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.cbT();
            }
        });
        this.hkq.aT(this.hku);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.jJe.getString(i);
    }

    public void cbT() {
        if (this.hkp != null && this.hkp.isShowing()) {
            this.hkp.dismiss();
        }
    }

    public void show() {
        if (this.hkp != null && !this.jJe.isFinishing()) {
            this.hkp.Nv();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.jIp.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.jJe.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.jJh != null && !j.this.jJh.isCancelled()) {
                    j.this.jJh.cancel();
                }
                j.this.jJh = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void cKX() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cKY() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.jJe.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.zz(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.zA(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.ig(false);
                        aVar.ih(false);
                        aVar.b(j.this.jJe.getPageContext()).bhg();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cKZ() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.jJe.getPageContext().getPageActivity());
                        aVar.zz(null);
                        aVar.setMessageShowCenter(true);
                        aVar.zA(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.ig(false);
                        aVar.ih(false);
                        aVar.b(j.this.jJe.getPageContext()).bhg();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.jJe.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.jJh.setPriority(3);
                j.this.jJh.execute(new String[0]);
                j.this.cbT();
                j.this.Cf(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.jJe.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.jJf = new a(this.jIp.getCurrentImageUrl(), this.jIp.getCurrentImageData());
            this.jJf.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.jJe.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void bpQ() {
        UrlDragImageView currentUrlDragImageView;
        if (this.jIp != null && (currentUrlDragImageView = this.jIp.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.jIp.getCurrentImageUrl();
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
            shareItem.eEw = 14;
            this.jJe.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.jJe, shareItem, false)));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void bpP() {
        Activity pageActivity = this.jJe.getPageContext().getPageActivity();
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
            Map<String, ImageUrlData> cKI = j.this.jJe.cKI();
            if (this.mUrl != null && cKI != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = cKI.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + as.bjo().Af(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = n.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && n.copyImageFile(str, this.mUrl, j.this.jJe.getPageContext().getPageActivity()) == 0) {
                        return j.this.jJe.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (n.saveImageFileByUser(this.mUrl, this.mData, j.this.jJe.getPageContext().getPageActivity())) {
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
            j.this.jJe.showToast(str);
            j.this.jJf = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.jJf = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cf(int i) {
        TiebaStatic.log(new aq("c13270").dD("uid", this.jJe.getUserId()).ai("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKV() {
    }

    public void Lx(String str) {
        int i;
        boolean z = false;
        if (this.hkp != null && !this.jJe.isFinishing() && this.hkp.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.jJm = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.hkq);
            this.jJm.a(this.jJs);
            int i2 = 0;
            while (true) {
                if (i2 < this.hku.size()) {
                    if (this.jJj == null || this.hku.get(i2) != this.jJj || (i = i2 + 1) > this.hku.size()) {
                        i2++;
                    } else {
                        this.hku.add(i, this.jJm);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.hku.add(this.jJm);
            }
            this.hkq.aT(this.hku);
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
                oVar.mgj = imageBitmap;
                String currentImageUrl = this.jIp.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    oVar.mgi = String.valueOf(System.currentTimeMillis()) + av.getNameMd5FromUrl(currentImageUrl);
                } else {
                    oVar.mgi = String.valueOf(BdUniqueId.gen().getId());
                }
                this.jJg = oVar.mgi;
                this.jJe.sendMessage(new CustomMessage(2921403, oVar));
            }
        }
    }

    public void cKW() {
        this.jJg = null;
    }

    public void release() {
        if (this.jJf != null) {
            this.jJf.cancel();
            this.jJf = null;
        }
        if (this.jJh != null) {
            this.jJh.cancel();
            this.jJh = null;
        }
    }

    public void onChangeSkinType() {
        if (this.hkq != null) {
            this.hkq.onChangeSkinType();
        }
    }
}
