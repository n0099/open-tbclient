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
    private com.baidu.tbadk.core.dialog.g iIm;
    private com.baidu.tbadk.core.dialog.i ixP;
    private k ixQ;
    private final ImageViewerActivity kTY;
    private MultiImageView kUV;
    private a kVV;
    private com.baidu.tieba.ueg.c kVX;
    private com.baidu.tbadk.core.dialog.g kVY;
    private com.baidu.tbadk.core.dialog.g kVZ;
    private com.baidu.tbadk.core.dialog.g kWa;
    private com.baidu.tbadk.core.dialog.g kWb;
    private com.baidu.tbadk.core.dialog.g kWc;
    private h kWd;
    private PermissionJudgePolicy mPermissionJudgement;
    private String kVW = null;
    private List<com.baidu.tbadk.core.dialog.g> ixU = null;
    private CustomMessageListener kWe = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            q qVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof q) && !j.this.kTY.isFinishing() && (qVar = (q) customResponsedMessage.getData()) != null) {
                qVar.nyj = null;
                if (!TextUtils.isEmpty(qVar.nyl) && !TextUtils.isEmpty(qVar.nyi) && qVar.nyi.equals(j.this.kVW)) {
                    j.this.kUV.setCurrentImageQRInfo(qVar.nyl);
                    j.this.Ny(qVar.nyl);
                }
            }
        }
    };
    private k.b kWf = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.kUV.qI(j.this.kTY.cUw());
            j.this.csw();
        }
    };
    private k.b kWg = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            f.aU(j.this.kTY.getPageContext().getPageActivity(), j.this.kUV.getCurrentImageUrl());
            j.this.csw();
            j.this.DL(1);
        }
    };
    private k.b kWh = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.kUV.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.csw();
            j.this.DL(2);
        }
    };
    private k.b iIn = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.kTY.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.csw();
                j.this.DL(3);
            }
        }
    };
    private k.b kWi = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.daw();
            j.this.csw();
            j.this.DL(4);
            j.this.dax();
        }
    };
    private k.b kWj = new AnonymousClass8();
    private View.OnClickListener onWeChatEmotionShareListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.j.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.kUV != null && (currentUrlDragImageView = j.this.kUV.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.b.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.kUV.getCurrentImageUrl();
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
                new com.baidu.tbadk.coreExtra.share.g(j.this.kTY, null).e(shareItem);
            }
        }
    };

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.kTY = imageViewerActivity;
        this.kTY.registerListener(this.kWe);
        this.kWd = new h(imageViewerActivity);
    }

    public void k(@Nullable MultiImageView multiImageView) {
        this.kUV = multiImageView;
        if (this.ixP == null) {
            this.ixQ = new k(this.kTY);
        }
        if (this.ixU == null) {
            this.ixU = new ArrayList();
        }
        cvD();
        this.ixP = new com.baidu.tbadk.core.dialog.i(this.kTY.getPageContext(), this.ixQ);
    }

    public void cvD() {
        this.ixU.clear();
        String qH = this.kUV.qH(this.kTY.cUw());
        if (qH != null) {
            this.kVY = new com.baidu.tbadk.core.dialog.g(qH, this.ixQ);
            this.kVY.a(this.kWf);
            this.ixU.add(this.kVY);
        }
        this.iIm = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.ixQ);
        this.iIm.a(this.iIn);
        this.ixU.add(this.iIm);
        if (this.kTY != null && !this.kTY.dar()) {
            this.kWa = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.ixQ);
            this.kWa.a(this.kWh);
            this.ixU.add(this.kWa);
        }
        this.kVZ = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.ixQ);
        this.kVZ.a(this.kWg);
        this.ixU.add(this.kVZ);
        String currentImageQRInfo = this.kUV.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.kWc = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.ixQ);
            this.kWc.a(this.kWj);
            this.ixU.add(this.kWc);
        }
        this.kWb = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.ixQ);
        this.kWb.a(this.kWi);
        this.ixU.add(this.kWb);
        this.ixQ.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.csw();
            }
        });
        this.ixQ.bw(this.ixU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.kTY.getString(i);
    }

    public void csw() {
        if (this.ixP != null && this.ixP.isShowing()) {
            this.ixP.dismiss();
        }
    }

    public void show() {
        if (this.ixP != null && !this.kTY.isFinishing()) {
            this.ixP.QE();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.kUV.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.kTY.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.kVX != null && !j.this.kVX.isCancelled()) {
                    j.this.kVX.cancel();
                }
                j.this.kVX = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void daz() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void daA() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kTY.getPageContext().getPageActivity());
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
                        aVar.b(j.this.kTY.getPageContext()).bqx();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void daB() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kTY.getPageContext().getPageActivity());
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
                        aVar.b(j.this.kTY.getPageContext()).bqx();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.kTY.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.kVX.setPriority(3);
                j.this.kVX.execute(new String[0]);
                j.this.csw();
                j.this.DL(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.kTY.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.kVV = new a(this.kUV.getCurrentImageUrl(), this.kUV.getCurrentImageData());
            this.kVV.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.kTY.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    public void daw() {
        UrlDragImageView currentUrlDragImageView;
        boolean z = true;
        if (this.kUV != null && (currentUrlDragImageView = this.kUV.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.d.b.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.kUV.getCurrentImageUrl();
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
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.kTY, shareItem, false);
            if (com.baidu.tbadk.a.d.bjs()) {
                shareDialogConfig.isImageViewerDialog = true;
                shareDialogConfig.originImgText = this.kUV.qH(this.kTY.cUw());
                shareDialogConfig.showAddEmotion = (this.kTY == null || this.kTY.dar()) ? false : true;
                String currentImageQRInfo = this.kUV.getCurrentImageQRInfo();
                if (TextUtils.isEmpty(currentImageQRInfo) || currentImageQRInfo.equals("qr_none")) {
                    z = false;
                }
                shareDialogConfig.showQRCode = z;
                shareDialogConfig.dialogSaveToDiskListener = this.iIn;
                shareDialogConfig.dialogAddToExpressionListener = this.kWh;
                shareDialogConfig.dialogDownloadOriginListener = this.kWf;
                shareDialogConfig.dialogRecognizePicListener = this.kWg;
                shareDialogConfig.qrCodeClickListener = this.kWj;
                shareDialogConfig.onWeChatEmotionShareListener = this.onWeChatEmotionShareListener;
            }
            this.kTY.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void bzv() {
        String currentImageUrl = this.kUV.getCurrentImageUrl();
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
        Activity pageActivity = this.kTY.getPageContext().getPageActivity();
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
            Map<String, ImageUrlData> dai = j.this.kTY.dai();
            if (this.mUrl != null && dai != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = dai.entrySet().iterator();
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
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && o.copyImageFile(str, this.mUrl, j.this.kTY.getPageContext().getPageActivity()) == 0) {
                        return j.this.kTY.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (o.saveImageFileByUser(this.mUrl, this.mData, j.this.kTY.getPageContext().getPageActivity())) {
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
                j.this.kTY.showToast(str);
            } else if (j.this.kWd != null) {
                j.this.kWd.a(j.this.kUV, j.this.kUV.getBottomHeight(), j.this.onWeChatEmotionShareListener);
            }
            j.this.kVV = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.kVV = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DL(int i) {
        TiebaStatic.log(new ar("c13270").dR("uid", this.kTY.getUserId()).ap("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dax() {
    }

    public void Ny(String str) {
        int i;
        boolean z = false;
        if (this.ixP != null && !this.kTY.isFinishing() && this.ixP.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.kWc = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.ixQ);
            this.kWc.a(this.kWj);
            int i2 = 0;
            while (true) {
                if (i2 < this.ixU.size()) {
                    if (this.kVZ == null || this.ixU.get(i2) != this.kVZ || (i = i2 + 1) > this.ixU.size()) {
                        i2++;
                    } else {
                        this.ixU.add(i, this.kWc);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.ixU.add(this.kWc);
            }
            this.ixQ.bw(this.ixU);
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
                qVar.nyj = imageBitmap;
                String currentImageUrl = this.kUV.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    qVar.nyi = String.valueOf(System.currentTimeMillis()) + aw.getNameMd5FromUrl(currentImageUrl);
                } else {
                    qVar.nyi = String.valueOf(BdUniqueId.gen().getId());
                }
                this.kVW = qVar.nyi;
                this.kTY.sendMessage(new CustomMessage(2921403, qVar));
            }
        }
    }

    public void day() {
        this.kVW = null;
    }

    public void release() {
        if (this.kVV != null) {
            this.kVV.cancel();
            this.kVV = null;
        }
        if (this.kVX != null) {
            this.kVX.cancel();
            this.kVX = null;
        }
        if (this.kWd != null) {
            this.kWd.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.ixQ != null) {
            this.ixQ.onChangeSkinType();
        }
    }
}
