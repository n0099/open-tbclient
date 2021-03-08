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
/* loaded from: classes7.dex */
public class j implements ImageViewerBottomLayout.b, ImageViewerBottomLayout.c {
    private com.baidu.tbadk.core.dialog.g iJV;
    private com.baidu.tbadk.core.dialog.i izy;
    private k izz;
    private MultiImageView kWX;
    private final ImageViewerActivity kWa;
    private a kXX;
    private com.baidu.tieba.ueg.c kXZ;
    private com.baidu.tbadk.core.dialog.g kYa;
    private com.baidu.tbadk.core.dialog.g kYb;
    private com.baidu.tbadk.core.dialog.g kYc;
    private com.baidu.tbadk.core.dialog.g kYd;
    private com.baidu.tbadk.core.dialog.g kYe;
    private h kYf;
    private PermissionJudgePolicy mPermissionJudgement;
    private String kXY = null;
    private List<com.baidu.tbadk.core.dialog.g> izD = null;
    private CustomMessageListener kYg = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            q qVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof q) && !j.this.kWa.isFinishing() && (qVar = (q) customResponsedMessage.getData()) != null) {
                qVar.nAo = null;
                if (!TextUtils.isEmpty(qVar.nAq) && !TextUtils.isEmpty(qVar.nAn) && qVar.nAn.equals(j.this.kXY)) {
                    j.this.kWX.setCurrentImageQRInfo(qVar.nAq);
                    j.this.NE(qVar.nAq);
                }
            }
        }
    };
    private k.b kYh = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.kWX.qJ(j.this.kWa.cUD());
            j.this.csC();
        }
    };
    private k.b kYi = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            f.aU(j.this.kWa.getPageContext().getPageActivity(), j.this.kWX.getCurrentImageUrl());
            j.this.csC();
            j.this.DO(1);
        }
    };
    private k.b kYj = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.kWX.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.csC();
            j.this.DO(2);
        }
    };
    private k.b iJW = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.kWa.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.csC();
                j.this.DO(3);
            }
        }
    };
    private k.b kYk = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.daF();
            j.this.csC();
            j.this.DO(4);
            j.this.daG();
        }
    };
    private k.b kYl = new AnonymousClass8();
    private View.OnClickListener onWeChatEmotionShareListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.j.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.kWX != null && (currentUrlDragImageView = j.this.kWX.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.b.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.kWX.getCurrentImageUrl();
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
                new com.baidu.tbadk.coreExtra.share.g(j.this.kWa, null).e(shareItem);
            }
        }
    };

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.kWa = imageViewerActivity;
        this.kWa.registerListener(this.kYg);
        this.kYf = new h(imageViewerActivity);
    }

    public void k(@Nullable MultiImageView multiImageView) {
        this.kWX = multiImageView;
        if (this.izy == null) {
            this.izz = new k(this.kWa);
        }
        if (this.izD == null) {
            this.izD = new ArrayList();
        }
        cvJ();
        this.izy = new com.baidu.tbadk.core.dialog.i(this.kWa.getPageContext(), this.izz);
    }

    public void cvJ() {
        this.izD.clear();
        String qI = this.kWX.qI(this.kWa.cUD());
        if (qI != null) {
            this.kYa = new com.baidu.tbadk.core.dialog.g(qI, this.izz);
            this.kYa.a(this.kYh);
            this.izD.add(this.kYa);
        }
        this.iJV = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.izz);
        this.iJV.a(this.iJW);
        this.izD.add(this.iJV);
        if (this.kWa != null && !this.kWa.daA()) {
            this.kYc = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.izz);
            this.kYc.a(this.kYj);
            this.izD.add(this.kYc);
        }
        this.kYb = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.izz);
        this.kYb.a(this.kYi);
        this.izD.add(this.kYb);
        String currentImageQRInfo = this.kWX.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.kYe = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.izz);
            this.kYe.a(this.kYl);
            this.izD.add(this.kYe);
        }
        this.kYd = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.izz);
        this.kYd.a(this.kYk);
        this.izD.add(this.kYd);
        this.izz.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.csC();
            }
        });
        this.izz.bw(this.izD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.kWa.getString(i);
    }

    public void csC() {
        if (this.izy != null && this.izy.isShowing()) {
            this.izy.dismiss();
        }
    }

    public void show() {
        if (this.izy != null && !this.kWa.isFinishing()) {
            this.izy.QH();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.kWX.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.kWa.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.kXZ != null && !j.this.kXZ.isCancelled()) {
                    j.this.kXZ.cancel();
                }
                j.this.kXZ = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void daI() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void daJ() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kWa.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.AA(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.AB(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.b(j.this.kWa.getPageContext()).bqz();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void daK() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kWa.getPageContext().getPageActivity());
                        aVar.AA(null);
                        aVar.setMessageShowCenter(true);
                        aVar.AB(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.jF(false);
                        aVar.jG(false);
                        aVar.b(j.this.kWa.getPageContext()).bqz();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.kWa.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.kXZ.setPriority(3);
                j.this.kXZ.execute(new String[0]);
                j.this.csC();
                j.this.DO(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.kWa.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.kXX = new a(this.kWX.getCurrentImageUrl(), this.kWX.getCurrentImageData());
            this.kXX.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.kWa.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    public void daF() {
        UrlDragImageView currentUrlDragImageView;
        boolean z = true;
        if (this.kWX != null && (currentUrlDragImageView = this.kWX.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.d.b.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.kWX.getCurrentImageUrl();
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
            shareItem.fww = 23;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.kWa, shareItem, false);
            if (com.baidu.tbadk.a.d.bju()) {
                shareDialogConfig.isImageViewerDialog = true;
                shareDialogConfig.originImgText = this.kWX.qI(this.kWa.cUD());
                shareDialogConfig.showAddEmotion = (this.kWa == null || this.kWa.daA()) ? false : true;
                String currentImageQRInfo = this.kWX.getCurrentImageQRInfo();
                if (TextUtils.isEmpty(currentImageQRInfo) || currentImageQRInfo.equals("qr_none")) {
                    z = false;
                }
                shareDialogConfig.showQRCode = z;
                shareDialogConfig.dialogSaveToDiskListener = this.iJW;
                shareDialogConfig.dialogAddToExpressionListener = this.kYj;
                shareDialogConfig.dialogDownloadOriginListener = this.kYh;
                shareDialogConfig.dialogRecognizePicListener = this.kYi;
                shareDialogConfig.qrCodeClickListener = this.kYl;
                shareDialogConfig.onWeChatEmotionShareListener = this.onWeChatEmotionShareListener;
            }
            this.kWa.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void bzy() {
        String currentImageUrl = this.kWX.getCurrentImageUrl();
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
        } else {
            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
            intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
        DO(2);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void bzx() {
        Activity pageActivity = this.kWa.getPageContext().getPageActivity();
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
            Map<String, ImageUrlData> dar = j.this.kWa.dar();
            if (this.mUrl != null && dar != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = dar.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + at.bsS().Bl(nameMd5FromUrl) + "/" + aw.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = o.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && o.copyImageFile(str, this.mUrl, j.this.kWa.getPageContext().getPageActivity()) == 0) {
                        return j.this.kWa.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (o.saveImageFileByUser(this.mUrl, this.mData, j.this.kWa.getPageContext().getPageActivity())) {
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
            if (!com.baidu.tbadk.a.d.bjv() || j.this.getString(R.string.save_fail).equals(str)) {
                j.this.kWa.showToast(str);
            } else if (j.this.kYf != null) {
                j.this.kYf.a(j.this.kWX, j.this.kWX.getBottomHeight(), j.this.onWeChatEmotionShareListener);
            }
            j.this.kXX = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.kXX = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DO(int i) {
        TiebaStatic.log(new ar("c13270").dR("uid", this.kWa.getUserId()).aq("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daG() {
    }

    public void NE(String str) {
        int i;
        boolean z = false;
        if (this.izy != null && !this.kWa.isFinishing() && this.izy.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.kYe = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.izz);
            this.kYe.a(this.kYl);
            int i2 = 0;
            while (true) {
                if (i2 < this.izD.size()) {
                    if (this.kYb == null || this.izD.get(i2) != this.kYb || (i = i2 + 1) > this.izD.size()) {
                        i2++;
                    } else {
                        this.izD.add(i, this.kYe);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.izD.add(this.kYe);
            }
            this.izz.bw(this.izD);
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
                qVar.nAo = imageBitmap;
                String currentImageUrl = this.kWX.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    qVar.nAn = String.valueOf(System.currentTimeMillis()) + aw.getNameMd5FromUrl(currentImageUrl);
                } else {
                    qVar.nAn = String.valueOf(BdUniqueId.gen().getId());
                }
                this.kXY = qVar.nAn;
                this.kWa.sendMessage(new CustomMessage(2921403, qVar));
            }
        }
    }

    public void daH() {
        this.kXY = null;
    }

    public void release() {
        if (this.kXX != null) {
            this.kXX.cancel();
            this.kXX = null;
        }
        if (this.kXZ != null) {
            this.kXZ.cancel();
            this.kXZ = null;
        }
        if (this.kYf != null) {
            this.kYf.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.izz != null) {
            this.izz.onChangeSkinType();
        }
    }
}
