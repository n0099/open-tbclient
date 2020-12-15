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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
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
public class h implements ImageViewerBottomLayout.b, ImageViewerBottomLayout.c {
    private i ikf;
    private k ikg;
    private com.baidu.tbadk.core.dialog.g iuI;
    private MultiImageView kLT;
    private final ImageViewerActivity kMG;
    private a kMH;
    private com.baidu.tieba.ueg.c kMJ;
    private com.baidu.tbadk.core.dialog.g kMK;
    private com.baidu.tbadk.core.dialog.g kML;
    private com.baidu.tbadk.core.dialog.g kMM;
    private com.baidu.tbadk.core.dialog.g kMN;
    private com.baidu.tbadk.core.dialog.g kMO;
    private PermissionJudgePolicy mPermissionJudgement;
    private String kMI = null;
    private List<com.baidu.tbadk.core.dialog.g> ikk = null;
    private CustomMessageListener kMP = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o) && !h.this.kMG.isFinishing() && (oVar = (o) customResponsedMessage.getData()) != null) {
                oVar.nmS = null;
                if (!TextUtils.isEmpty(oVar.nmU) && !TextUtils.isEmpty(oVar.nmR) && oVar.nmR.equals(h.this.kMI)) {
                    h.this.kLT.setCurrentImageQRInfo(oVar.nmU);
                    h.this.Oj(oVar.nmU);
                }
            }
        }
    };
    private k.b kMQ = new k.b() { // from class: com.baidu.tieba.image.h.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            h.this.kLT.rX(h.this.kMG.cTb());
            h.this.csc();
        }
    };
    private k.b kMR = new k.b() { // from class: com.baidu.tieba.image.h.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            e.aR(h.this.kMG.getPageContext().getPageActivity(), h.this.kLT.getCurrentImageUrl());
            h.this.csc();
            h.this.Ff(1);
        }
    };
    private k.b kMS = new k.b() { // from class: com.baidu.tieba.image.h.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = h.this.kLT.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            h.this.csc();
            h.this.Ff(2);
        }
    };
    private k.b iuJ = new k.b() { // from class: com.baidu.tieba.image.h.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = h.this.kMG.getPageContext().getPageActivity();
            if (h.this.mPermissionJudgement == null) {
                h.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            h.this.mPermissionJudgement.clearRequestPermissionList();
            h.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!h.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                h.this.saveImage();
                h.this.csc();
                h.this.Ff(3);
            }
        }
    };
    private k.b kMT = new k.b() { // from class: com.baidu.tieba.image.h.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            h.this.bAC();
            h.this.csc();
            h.this.Ff(4);
            h.this.dcz();
        }
    };
    private k.b kMU = new AnonymousClass8();

    public h(@Nullable ImageViewerActivity imageViewerActivity) {
        this.kMG = imageViewerActivity;
        this.kMG.registerListener(this.kMP);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.kLT = multiImageView;
        if (this.ikf == null) {
            this.ikg = new k(this.kMG);
        }
        if (this.ikk == null) {
            this.ikk = new ArrayList();
        }
        cvi();
        this.ikf = new i(this.kMG.getPageContext(), this.ikg);
    }

    public void cvi() {
        this.ikk.clear();
        String rW = this.kLT.rW(this.kMG.cTb());
        if (rW != null) {
            this.kMK = new com.baidu.tbadk.core.dialog.g(rW, this.ikg);
            this.kMK.a(this.kMQ);
            this.ikk.add(this.kMK);
        }
        this.iuI = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.ikg);
        this.iuI.a(this.iuJ);
        this.ikk.add(this.iuI);
        if (this.kMG != null && !this.kMG.dcv()) {
            this.kMM = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.ikg);
            this.kMM.a(this.kMS);
            this.ikk.add(this.kMM);
        }
        this.kML = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.ikg);
        this.kML.a(this.kMR);
        this.ikk.add(this.kML);
        String currentImageQRInfo = this.kLT.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.kMO = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.ikg);
            this.kMO.a(this.kMU);
            this.ikk.add(this.kMO);
        }
        this.kMN = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.ikg);
        this.kMN.a(this.kMT);
        this.ikk.add(this.kMN);
        this.ikg.a(new k.a() { // from class: com.baidu.tieba.image.h.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                h.this.csc();
            }
        });
        this.ikg.bu(this.ikk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.kMG.getString(i);
    }

    public void csc() {
        if (this.ikf != null && this.ikf.isShowing()) {
            this.ikf.dismiss();
        }
    }

    public void show() {
        if (this.ikf != null && !this.kMG.isFinishing()) {
            this.ikf.RU();
        }
    }

    /* renamed from: com.baidu.tieba.image.h$8  reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = h.this.kLT.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(h.this.kMG.getPageContext().getPageActivity(), h.this.getString(R.string.network_not_available));
                    return;
                }
                if (h.this.kMJ != null && !h.this.kMJ.isCancelled()) {
                    h.this.kMJ.cancel();
                }
                h.this.kMJ = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.h.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void dcB() {
                        h.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void dcC() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(h.this.kMG.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.Bp(h.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.Bq(h.this.getString(R.string.qr_url_jump_external_message));
                        aVar.a(h.this.getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.image.h.8.1.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                                h.this.openUrl(currentImageQRInfo);
                            }
                        });
                        aVar.b(h.this.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.image.h.8.1.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.jl(false);
                        aVar.jm(false);
                        aVar.b(h.this.kMG.getPageContext()).brv();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void dcD() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(h.this.kMG.getPageContext().getPageActivity());
                        aVar.Bp(null);
                        aVar.setMessageShowCenter(true);
                        aVar.Bq(h.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(h.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.h.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.jl(false);
                        aVar.jm(false);
                        aVar.b(h.this.kMG.getPageContext()).brv();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(h.this.kMG.getPageContext().getPageActivity(), h.this.getString(R.string.qr_scan_error));
                    }
                });
                h.this.kMJ.setPriority(3);
                h.this.kMJ.execute(new String[0]);
                h.this.csc();
                h.this.Ff(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.kMG.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.kMH = new a(this.kLT.getCurrentImageUrl(), this.kLT.getCurrentImageData());
            this.kMH.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.kMG.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void bAC() {
        UrlDragImageView currentUrlDragImageView;
        if (this.kLT != null && (currentUrlDragImageView = this.kLT.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.kLT.getCurrentImageUrl();
                str2 = aw.getNameMd5FromUrl(str);
            }
            ShareItem shareItem = new ShareItem();
            if (imageUrlData != null) {
                long j = imageUrlData.threadId;
                if (j > 0) {
                    shareItem.linkUrl = "http://tieba.baidu.com/p/" + j + "?fr=share";
                }
            }
            if (!au.isEmpty(str)) {
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
            shareItem.fnE = 14;
            this.kMG.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.kMG, shareItem, false)));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void bAB() {
        Activity pageActivity = this.kMG.getPageContext().getPageActivity();
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
            Map<String, ImageUrlData> dcm = h.this.kMG.dcm();
            if (this.mUrl != null && dcm != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = dcm.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + at.btU().Ca(nameMd5FromUrl) + "/" + aw.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = n.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && n.copyImageFile(str, this.mUrl, h.this.kMG.getPageContext().getPageActivity()) == 0) {
                        return h.this.kMG.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (n.saveImageFileByUser(this.mUrl, this.mData, h.this.kMG.getPageContext().getPageActivity())) {
                    case -2:
                        return n.getSdErrorString();
                    case 0:
                        return h.this.getString(R.string.save_image_to_album);
                }
            }
            return h.this.getString(R.string.save_fail);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            h.this.kMG.showToast(str);
            h.this.kMH = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            h.this.kMH = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ff(int i) {
        TiebaStatic.log(new ar("c13270").dY("uid", this.kMG.getUserId()).al("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcz() {
    }

    public void Oj(String str) {
        int i;
        boolean z = false;
        if (this.ikf != null && !this.kMG.isFinishing() && this.ikf.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.kMO = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.ikg);
            this.kMO.a(this.kMU);
            int i2 = 0;
            while (true) {
                if (i2 < this.ikk.size()) {
                    if (this.kML == null || this.ikk.get(i2) != this.kML || (i = i2 + 1) > this.ikk.size()) {
                        i2++;
                    } else {
                        this.ikk.add(i, this.kMO);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.ikk.add(this.kMO);
            }
            this.ikg.bu(this.ikk);
        }
    }

    public void dh(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                o oVar = new o();
                oVar.type = 0;
                oVar.nmS = imageBitmap;
                String currentImageUrl = this.kLT.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    oVar.nmR = String.valueOf(System.currentTimeMillis()) + aw.getNameMd5FromUrl(currentImageUrl);
                } else {
                    oVar.nmR = String.valueOf(BdUniqueId.gen().getId());
                }
                this.kMI = oVar.nmR;
                this.kMG.sendMessage(new CustomMessage(2921403, oVar));
            }
        }
    }

    public void dcA() {
        this.kMI = null;
    }

    public void release() {
        if (this.kMH != null) {
            this.kMH.cancel();
            this.kMH = null;
        }
        if (this.kMJ != null) {
            this.kMJ.cancel();
            this.kMJ = null;
        }
    }

    public void onChangeSkinType() {
        if (this.ikg != null) {
            this.ikg.onChangeSkinType();
        }
    }
}
