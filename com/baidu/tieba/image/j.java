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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.q;
import com.baidu.tieba.ueg.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class j implements ImageViewerBottomLayout.b, ImageViewerBottomLayout.c {
    private com.baidu.tbadk.core.dialog.g iHY;
    private com.baidu.tbadk.core.dialog.i ixB;
    private k ixC;
    private final ImageViewerActivity kTK;
    private MultiImageView kUH;
    private a kVH;
    private com.baidu.tieba.ueg.c kVJ;
    private com.baidu.tbadk.core.dialog.g kVK;
    private com.baidu.tbadk.core.dialog.g kVL;
    private com.baidu.tbadk.core.dialog.g kVM;
    private com.baidu.tbadk.core.dialog.g kVN;
    private com.baidu.tbadk.core.dialog.g kVO;
    private h kVP;
    private PermissionJudgePolicy mPermissionJudgement;
    private String kVI = null;
    private List<com.baidu.tbadk.core.dialog.g> ixG = null;
    private CustomMessageListener kVQ = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            q qVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof q) && !j.this.kTK.isFinishing() && (qVar = (q) customResponsedMessage.getData()) != null) {
                qVar.nxJ = null;
                if (!TextUtils.isEmpty(qVar.nxL) && !TextUtils.isEmpty(qVar.nxI) && qVar.nxI.equals(j.this.kVI)) {
                    j.this.kUH.setCurrentImageQRInfo(qVar.nxL);
                    j.this.Nx(qVar.nxL);
                }
            }
        }
    };
    private k.b kVR = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.kUH.qI(j.this.kTK.cUp());
            j.this.csp();
        }
    };
    private k.b kVS = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            f.aW(j.this.kTK.getPageContext().getPageActivity(), j.this.kUH.getCurrentImageUrl());
            j.this.csp();
            j.this.DL(1);
        }
    };
    private k.b kVT = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.kUH.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.csp();
            j.this.DL(2);
        }
    };
    private k.b iHZ = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.kTK.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.csp();
                j.this.DL(3);
            }
        }
    };
    private k.b kVU = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.dap();
            j.this.csp();
            j.this.DL(4);
            j.this.daq();
        }
    };
    private k.b kVV = new AnonymousClass8();
    private View.OnClickListener onWeChatEmotionShareListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.j.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.kUH != null && (currentUrlDragImageView = j.this.kUH.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.b.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.kUH.getCurrentImageUrl();
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
                new com.baidu.tbadk.coreExtra.share.g(j.this.kTK, null).e(shareItem);
            }
        }
    };

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.kTK = imageViewerActivity;
        this.kTK.registerListener(this.kVQ);
        this.kVP = new h(imageViewerActivity);
    }

    public void k(@Nullable MultiImageView multiImageView) {
        this.kUH = multiImageView;
        if (this.ixB == null) {
            this.ixC = new k(this.kTK);
        }
        if (this.ixG == null) {
            this.ixG = new ArrayList();
        }
        cvw();
        this.ixB = new com.baidu.tbadk.core.dialog.i(this.kTK.getPageContext(), this.ixC);
    }

    public void cvw() {
        this.ixG.clear();
        String qH = this.kUH.qH(this.kTK.cUp());
        if (qH != null) {
            this.kVK = new com.baidu.tbadk.core.dialog.g(qH, this.ixC);
            this.kVK.a(this.kVR);
            this.ixG.add(this.kVK);
        }
        this.iHY = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.ixC);
        this.iHY.a(this.iHZ);
        this.ixG.add(this.iHY);
        if (this.kTK != null && !this.kTK.dak()) {
            this.kVM = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.ixC);
            this.kVM.a(this.kVT);
            this.ixG.add(this.kVM);
        }
        this.kVL = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.ixC);
        this.kVL.a(this.kVS);
        this.ixG.add(this.kVL);
        String currentImageQRInfo = this.kUH.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.kVO = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.ixC);
            this.kVO.a(this.kVV);
            this.ixG.add(this.kVO);
        }
        this.kVN = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.ixC);
        this.kVN.a(this.kVU);
        this.ixG.add(this.kVN);
        this.ixC.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.csp();
            }
        });
        this.ixC.bw(this.ixG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.kTK.getString(i);
    }

    public void csp() {
        if (this.ixB != null && this.ixB.isShowing()) {
            this.ixB.dismiss();
        }
    }

    public void show() {
        if (this.ixB != null && !this.kTK.isFinishing()) {
            this.ixB.QE();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.kUH.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.kTK.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.kVJ != null && !j.this.kVJ.isCancelled()) {
                    j.this.kVJ.cancel();
                }
                j.this.kVJ = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void das() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void dat() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kTK.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.At(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.Au(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.jF(false);
                        aVar.jG(false);
                        aVar.b(j.this.kTK.getPageContext()).bqx();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void dau() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kTK.getPageContext().getPageActivity());
                        aVar.At(null);
                        aVar.setMessageShowCenter(true);
                        aVar.Au(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.jF(false);
                        aVar.jG(false);
                        aVar.b(j.this.kTK.getPageContext()).bqx();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.kTK.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.kVJ.setPriority(3);
                j.this.kVJ.execute(new String[0]);
                j.this.csp();
                j.this.DL(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.kTK.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.kVH = new a(this.kUH.getCurrentImageUrl(), this.kUH.getCurrentImageData());
            this.kVH.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.kTK.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    public void dap() {
        UrlDragImageView currentUrlDragImageView;
        boolean z = true;
        if (this.kUH != null && (currentUrlDragImageView = this.kUH.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.d.b.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.kUH.getCurrentImageUrl();
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
            shareItem.fuX = 23;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.kTK, shareItem, false);
            if (com.baidu.tbadk.a.d.bjs()) {
                shareDialogConfig.isImageViewerDialog = true;
                shareDialogConfig.originImgText = this.kUH.qH(this.kTK.cUp());
                shareDialogConfig.showAddEmotion = (this.kTK == null || this.kTK.dak()) ? false : true;
                String currentImageQRInfo = this.kUH.getCurrentImageQRInfo();
                if (TextUtils.isEmpty(currentImageQRInfo) || currentImageQRInfo.equals("qr_none")) {
                    z = false;
                }
                shareDialogConfig.showQRCode = z;
                shareDialogConfig.dialogSaveToDiskListener = this.iHZ;
                shareDialogConfig.dialogAddToExpressionListener = this.kVT;
                shareDialogConfig.dialogDownloadOriginListener = this.kVR;
                shareDialogConfig.dialogRecognizePicListener = this.kVS;
                shareDialogConfig.qrCodeClickListener = this.kVV;
                shareDialogConfig.onWeChatEmotionShareListener = this.onWeChatEmotionShareListener;
            }
            this.kTK.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void bzv() {
        String currentImageUrl = this.kUH.getCurrentImageUrl();
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
        } else {
            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
            intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
        DL(2);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void bzu() {
        Activity pageActivity = this.kTK.getPageContext().getPageActivity();
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
            Map<String, ImageUrlData> dab = j.this.kTK.dab();
            if (this.mUrl != null && dab != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = dab.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + at.bsP().Be(nameMd5FromUrl) + "/" + aw.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = o.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && o.copyImageFile(str, this.mUrl, j.this.kTK.getPageContext().getPageActivity()) == 0) {
                        return j.this.kTK.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (o.saveImageFileByUser(this.mUrl, this.mData, j.this.kTK.getPageContext().getPageActivity())) {
                    case -2:
                        return o.getSdErrorString();
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
            if (!com.baidu.tbadk.a.d.bjt() || j.this.getString(R.string.save_fail).equals(str)) {
                j.this.kTK.showToast(str);
            } else if (j.this.kVP != null) {
                j.this.kVP.a(j.this.kUH, j.this.kUH.getBottomHeight(), j.this.onWeChatEmotionShareListener);
            }
            j.this.kVH = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.kVH = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DL(int i) {
        TiebaStatic.log(new ar("c13270").dR("uid", this.kTK.getUserId()).ap("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daq() {
    }

    public void Nx(String str) {
        int i;
        boolean z = false;
        if (this.ixB != null && !this.kTK.isFinishing() && this.ixB.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.kVO = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.ixC);
            this.kVO.a(this.kVV);
            int i2 = 0;
            while (true) {
                if (i2 < this.ixG.size()) {
                    if (this.kVL == null || this.ixG.get(i2) != this.kVL || (i = i2 + 1) > this.ixG.size()) {
                        i2++;
                    } else {
                        this.ixG.add(i, this.kVO);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.ixG.add(this.kVO);
            }
            this.ixC.bw(this.ixG);
        }
    }

    public void dp(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                q qVar = new q();
                qVar.type = 0;
                qVar.nxJ = imageBitmap;
                String currentImageUrl = this.kUH.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    qVar.nxI = String.valueOf(System.currentTimeMillis()) + aw.getNameMd5FromUrl(currentImageUrl);
                } else {
                    qVar.nxI = String.valueOf(BdUniqueId.gen().getId());
                }
                this.kVI = qVar.nxI;
                this.kTK.sendMessage(new CustomMessage(2921403, qVar));
            }
        }
    }

    public void dar() {
        this.kVI = null;
    }

    public void release() {
        if (this.kVH != null) {
            this.kVH.cancel();
            this.kVH = null;
        }
        if (this.kVJ != null) {
            this.kVJ.cancel();
            this.kVJ = null;
        }
        if (this.kVP != null) {
            this.kVP.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.ixC != null) {
            this.ixC.onChangeSkinType();
        }
    }
}
