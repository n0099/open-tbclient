package com.baidu.tieba.image;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
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
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.ueg.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class j implements ImageViewerBottomLayout.b, ImageViewerBottomLayout.c {
    private com.baidu.tbadk.core.dialog.g iCo;
    private com.baidu.tbadk.core.dialog.i irT;
    private k irU;
    private final ImageViewerActivity kLH;
    private MultiImageView kME;
    private a kNE;
    private com.baidu.tieba.ueg.c kNG;
    private com.baidu.tbadk.core.dialog.g kNH;
    private com.baidu.tbadk.core.dialog.g kNI;
    private com.baidu.tbadk.core.dialog.g kNJ;
    private com.baidu.tbadk.core.dialog.g kNK;
    private com.baidu.tbadk.core.dialog.g kNL;
    private h kNM;
    private PermissionJudgePolicy mPermissionJudgement;
    private String kNF = null;
    private List<com.baidu.tbadk.core.dialog.g> irY = null;
    private CustomMessageListener kNN = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            p pVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof p) && !j.this.kLH.isFinishing() && (pVar = (p) customResponsedMessage.getData()) != null) {
                pVar.nnW = null;
                if (!TextUtils.isEmpty(pVar.nnY) && !TextUtils.isEmpty(pVar.nnV) && pVar.nnV.equals(j.this.kNF)) {
                    j.this.kME.setCurrentImageQRInfo(pVar.nnY);
                    j.this.MI(pVar.nnY);
                }
            }
        }
    };
    private k.b kNO = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.kME.qD(j.this.kLH.cSq());
            j.this.cre();
        }
    };
    private k.b kNP = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            f.aX(j.this.kLH.getPageContext().getPageActivity(), j.this.kME.getCurrentImageUrl());
            j.this.cre();
            j.this.Dt(1);
        }
    };
    private k.b kNQ = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.kME.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.cre();
            j.this.Dt(2);
        }
    };
    private k.b iCp = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.kLH.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.cre();
                j.this.Dt(3);
            }
        }
    };
    private k.b kNR = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.cYr();
            j.this.cre();
            j.this.Dt(4);
            j.this.cYs();
        }
    };
    private k.b kNS = new AnonymousClass8();
    private View.OnClickListener onWeChatEmotionShareListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.j.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.kME != null && (currentUrlDragImageView = j.this.kME.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.b.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.kME.getCurrentImageUrl();
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
                    shareItem.shareType = 2;
                    shareItem.title = j.this.getString(R.string.save_to_emotion);
                    shareItem.content = j.this.getString(R.string.save_to_emotion);
                    shareItem.imageUrl = str;
                    Bundle bundle = new Bundle();
                    bundle.putString("path", TbConfig.IMAGE_CACHE_DIR_NAME);
                    bundle.putString("name", str2);
                    bundle.putBoolean("formatData", true);
                    bundle.putBoolean("isSubDir", true);
                    bundle.putBoolean("isSdcard", false);
                    bundle.putBoolean("isSavedCache", true);
                    shareItem.diskPicOperate = bundle;
                }
                new Bundle().putInt("obj_locate", 13);
                new com.baidu.tbadk.coreExtra.share.g(j.this.kLH, null).e(shareItem);
            }
        }
    };

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.kLH = imageViewerActivity;
        this.kLH.registerListener(this.kNN);
        this.kNM = new h(imageViewerActivity);
    }

    public void k(@Nullable MultiImageView multiImageView) {
        this.kME = multiImageView;
        if (this.irT == null) {
            this.irU = new k(this.kLH);
        }
        if (this.irY == null) {
            this.irY = new ArrayList();
        }
        cuk();
        this.irT = new com.baidu.tbadk.core.dialog.i(this.kLH.getPageContext(), this.irU);
    }

    public void cuk() {
        this.irY.clear();
        String qC = this.kME.qC(this.kLH.cSq());
        if (qC != null) {
            this.kNH = new com.baidu.tbadk.core.dialog.g(qC, this.irU);
            this.kNH.a(this.kNO);
            this.irY.add(this.kNH);
        }
        this.iCo = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.irU);
        this.iCo.a(this.iCp);
        this.irY.add(this.iCo);
        if (this.kLH != null && !this.kLH.cYm()) {
            this.kNJ = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.irU);
            this.kNJ.a(this.kNQ);
            this.irY.add(this.kNJ);
        }
        this.kNI = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.irU);
        this.kNI.a(this.kNP);
        this.irY.add(this.kNI);
        String currentImageQRInfo = this.kME.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.kNL = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.irU);
            this.kNL.a(this.kNS);
            this.irY.add(this.kNL);
        }
        this.kNK = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.irU);
        this.kNK.a(this.kNR);
        this.irY.add(this.kNK);
        this.irU.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.cre();
            }
        });
        this.irU.bB(this.irY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.kLH.getString(i);
    }

    public void cre() {
        if (this.irT != null && this.irT.isShowing()) {
            this.irT.dismiss();
        }
    }

    public void show() {
        if (this.irT != null && !this.kLH.isFinishing()) {
            this.irT.Pd();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.kME.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.kLH.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.kNG != null && !j.this.kNG.isCancelled()) {
                    j.this.kNG.cancel();
                }
                j.this.kNG = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void cYu() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cYv() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kLH.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.Ac(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.Ad(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.jD(false);
                        aVar.jE(false);
                        aVar.b(j.this.kLH.getPageContext()).bqe();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cYw() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kLH.getPageContext().getPageActivity());
                        aVar.Ac(null);
                        aVar.setMessageShowCenter(true);
                        aVar.Ad(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.jD(false);
                        aVar.jE(false);
                        aVar.b(j.this.kLH.getPageContext()).bqe();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.kLH.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.kNG.setPriority(3);
                j.this.kNG.execute(new String[0]);
                j.this.cre();
                j.this.Dt(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.kLH.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.kNE = new a(this.kME.getCurrentImageUrl(), this.kME.getCurrentImageData());
            this.kNE.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.kLH.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    public void cYr() {
        UrlDragImageView currentUrlDragImageView;
        boolean z = true;
        if (this.kME != null && (currentUrlDragImageView = this.kME.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.d.b.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.kME.getCurrentImageUrl();
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
            shareItem.fsF = 14;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.kLH, shareItem, false);
            if (com.baidu.tbadk.a.d.bjg()) {
                shareDialogConfig.isImageViewerDialog = true;
                shareDialogConfig.originImgText = this.kME.qC(this.kLH.cSq());
                shareDialogConfig.showAddEmotion = (this.kLH == null || this.kLH.cYm()) ? false : true;
                String currentImageQRInfo = this.kME.getCurrentImageQRInfo();
                if (TextUtils.isEmpty(currentImageQRInfo) || currentImageQRInfo.equals("qr_none")) {
                    z = false;
                }
                shareDialogConfig.showQRCode = z;
                shareDialogConfig.dialogSaveToDiskListener = this.iCp;
                shareDialogConfig.dialogAddToExpressionListener = this.kNQ;
                shareDialogConfig.dialogDownloadOriginListener = this.kNO;
                shareDialogConfig.dialogRecognizePicListener = this.kNP;
                shareDialogConfig.qrCodeClickListener = this.kNS;
                shareDialogConfig.onWeChatEmotionShareListener = this.onWeChatEmotionShareListener;
            }
            this.kLH.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void bzd() {
        String currentImageUrl = this.kME.getCurrentImageUrl();
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
        } else {
            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
            intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
        Dt(2);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void bzc() {
        Activity pageActivity = this.kLH.getPageContext().getPageActivity();
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
    /* loaded from: classes7.dex */
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
            Map<String, ImageUrlData> cYd = j.this.kLH.cYd();
            if (this.mUrl != null && cYd != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = cYd.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + as.bsv().AN(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = n.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && n.copyImageFile(str, this.mUrl, j.this.kLH.getPageContext().getPageActivity()) == 0) {
                        return j.this.kLH.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (n.saveImageFileByUser(this.mUrl, this.mData, j.this.kLH.getPageContext().getPageActivity())) {
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
            if (!com.baidu.tbadk.a.d.bjh() || j.this.getString(R.string.save_fail).equals(str)) {
                j.this.kLH.showToast(str);
            } else if (j.this.kNM != null) {
                j.this.kNM.a(j.this.kME, j.this.kME.getBottomHeight(), j.this.onWeChatEmotionShareListener);
            }
            j.this.kNE = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.kNE = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dt(int i) {
        TiebaStatic.log(new aq("c13270").dW("uid", this.kLH.getUserId()).an("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYs() {
    }

    public void MI(String str) {
        int i;
        boolean z = false;
        if (this.irT != null && !this.kLH.isFinishing() && this.irT.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.kNL = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.irU);
            this.kNL.a(this.kNS);
            int i2 = 0;
            while (true) {
                if (i2 < this.irY.size()) {
                    if (this.kNI == null || this.irY.get(i2) != this.kNI || (i = i2 + 1) > this.irY.size()) {
                        i2++;
                    } else {
                        this.irY.add(i, this.kNL);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.irY.add(this.kNL);
            }
            this.irU.bB(this.irY);
        }
    }

    public void dr(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                p pVar = new p();
                pVar.type = 0;
                pVar.nnW = imageBitmap;
                String currentImageUrl = this.kME.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    pVar.nnV = String.valueOf(System.currentTimeMillis()) + av.getNameMd5FromUrl(currentImageUrl);
                } else {
                    pVar.nnV = String.valueOf(BdUniqueId.gen().getId());
                }
                this.kNF = pVar.nnV;
                this.kLH.sendMessage(new CustomMessage(2921403, pVar));
            }
        }
    }

    public void cYt() {
        this.kNF = null;
    }

    public void release() {
        if (this.kNE != null) {
            this.kNE.cancel();
            this.kNE = null;
        }
        if (this.kNG != null) {
            this.kNG.cancel();
            this.kNG = null;
        }
        if (this.kNM != null) {
            this.kNM.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.irU != null) {
            this.irU.onChangeSkinType();
        }
    }
}
