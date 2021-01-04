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
/* loaded from: classes8.dex */
public class j implements ImageViewerBottomLayout.b, ImageViewerBottomLayout.c {
    private com.baidu.tbadk.core.dialog.g iGV;
    private com.baidu.tbadk.core.dialog.i iwA;
    private k iwB;
    private final ImageViewerActivity kQm;
    private MultiImageView kRj;
    private a kSj;
    private com.baidu.tieba.ueg.c kSl;
    private com.baidu.tbadk.core.dialog.g kSm;
    private com.baidu.tbadk.core.dialog.g kSn;
    private com.baidu.tbadk.core.dialog.g kSo;
    private com.baidu.tbadk.core.dialog.g kSp;
    private com.baidu.tbadk.core.dialog.g kSq;
    private h kSr;
    private PermissionJudgePolicy mPermissionJudgement;
    private String kSk = null;
    private List<com.baidu.tbadk.core.dialog.g> iwF = null;
    private CustomMessageListener kSs = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            p pVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof p) && !j.this.kQm.isFinishing() && (pVar = (p) customResponsedMessage.getData()) != null) {
                pVar.nsE = null;
                if (!TextUtils.isEmpty(pVar.nsG) && !TextUtils.isEmpty(pVar.nsD) && pVar.nsD.equals(j.this.kSk)) {
                    j.this.kRj.setCurrentImageQRInfo(pVar.nsG);
                    j.this.NR(pVar.nsG);
                }
            }
        }
    };
    private k.b kSt = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.kRj.sj(j.this.kQm.cWh());
            j.this.cuV();
        }
    };
    private k.b kSu = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            f.aX(j.this.kQm.getPageContext().getPageActivity(), j.this.kRj.getCurrentImageUrl());
            j.this.cuV();
            j.this.EZ(1);
        }
    };
    private k.b kSv = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.kRj.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.cuV();
            j.this.EZ(2);
        }
    };
    private k.b iGW = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.kQm.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.cuV();
                j.this.EZ(3);
            }
        }
    };
    private k.b kSw = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.dci();
            j.this.cuV();
            j.this.EZ(4);
            j.this.dcj();
        }
    };
    private k.b kSx = new AnonymousClass8();
    private View.OnClickListener onWeChatEmotionShareListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.j.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.kRj != null && (currentUrlDragImageView = j.this.kRj.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.d.b.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.kRj.getCurrentImageUrl();
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
                new com.baidu.tbadk.coreExtra.share.g(j.this.kQm, null).e(shareItem);
            }
        }
    };

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.kQm = imageViewerActivity;
        this.kQm.registerListener(this.kSs);
        this.kSr = new h(imageViewerActivity);
    }

    public void k(@Nullable MultiImageView multiImageView) {
        this.kRj = multiImageView;
        if (this.iwA == null) {
            this.iwB = new k(this.kQm);
        }
        if (this.iwF == null) {
            this.iwF = new ArrayList();
        }
        cyb();
        this.iwA = new com.baidu.tbadk.core.dialog.i(this.kQm.getPageContext(), this.iwB);
    }

    public void cyb() {
        this.iwF.clear();
        String si = this.kRj.si(this.kQm.cWh());
        if (si != null) {
            this.kSm = new com.baidu.tbadk.core.dialog.g(si, this.iwB);
            this.kSm.a(this.kSt);
            this.iwF.add(this.kSm);
        }
        this.iGV = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.iwB);
        this.iGV.a(this.iGW);
        this.iwF.add(this.iGV);
        if (this.kQm != null && !this.kQm.dcd()) {
            this.kSo = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.iwB);
            this.kSo.a(this.kSv);
            this.iwF.add(this.kSo);
        }
        this.kSn = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.iwB);
        this.kSn.a(this.kSu);
        this.iwF.add(this.kSn);
        String currentImageQRInfo = this.kRj.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.kSq = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.iwB);
            this.kSq.a(this.kSx);
            this.iwF.add(this.kSq);
        }
        this.kSp = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.iwB);
        this.kSp.a(this.kSw);
        this.iwF.add(this.kSp);
        this.iwB.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.cuV();
            }
        });
        this.iwB.bB(this.iwF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.kQm.getString(i);
    }

    public void cuV() {
        if (this.iwA != null && this.iwA.isShowing()) {
            this.iwA.dismiss();
        }
    }

    public void show() {
        if (this.iwA != null && !this.kQm.isFinishing()) {
            this.iwA.SY();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.kRj.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.kQm.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.kSl != null && !j.this.kSl.isCancelled()) {
                    j.this.kSl.cancel();
                }
                j.this.kSl = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void dcl() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void dcm() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kQm.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.Bo(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.Bp(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.jH(false);
                        aVar.jI(false);
                        aVar.b(j.this.kQm.getPageContext()).btX();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void dcn() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.kQm.getPageContext().getPageActivity());
                        aVar.Bo(null);
                        aVar.setMessageShowCenter(true);
                        aVar.Bp(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.jH(false);
                        aVar.jI(false);
                        aVar.b(j.this.kQm.getPageContext()).btX();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.kQm.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.kSl.setPriority(3);
                j.this.kSl.execute(new String[0]);
                j.this.cuV();
                j.this.EZ(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.kQm.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.kSj = new a(this.kRj.getCurrentImageUrl(), this.kRj.getCurrentImageData());
            this.kSj.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.kQm.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    public void dci() {
        UrlDragImageView currentUrlDragImageView;
        boolean z = true;
        if (this.kRj != null && (currentUrlDragImageView = this.kRj.getCurrentUrlDragImageView()) != null) {
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str = "";
            String str2 = "";
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = com.baidu.tbadk.core.util.d.b.getNameMd5FromUrl(str);
            }
            if (TextUtils.isEmpty(str)) {
                str = this.kRj.getCurrentImageUrl();
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
            shareItem.fxo = 14;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.kQm, shareItem, false);
            if (com.baidu.tbadk.a.d.bmZ()) {
                shareDialogConfig.isImageViewerDialog = true;
                shareDialogConfig.originImgText = this.kRj.si(this.kQm.cWh());
                shareDialogConfig.showAddEmotion = (this.kQm == null || this.kQm.dcd()) ? false : true;
                String currentImageQRInfo = this.kRj.getCurrentImageQRInfo();
                if (TextUtils.isEmpty(currentImageQRInfo) || currentImageQRInfo.equals("qr_none")) {
                    z = false;
                }
                shareDialogConfig.showQRCode = z;
                shareDialogConfig.dialogSaveToDiskListener = this.iGW;
                shareDialogConfig.dialogAddToExpressionListener = this.kSv;
                shareDialogConfig.dialogDownloadOriginListener = this.kSt;
                shareDialogConfig.dialogRecognizePicListener = this.kSu;
                shareDialogConfig.qrCodeClickListener = this.kSx;
                shareDialogConfig.onWeChatEmotionShareListener = this.onWeChatEmotionShareListener;
            }
            this.kQm.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void bCW() {
        String currentImageUrl = this.kRj.getCurrentImageUrl();
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
        } else {
            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
            intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
        EZ(2);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void bCV() {
        Activity pageActivity = this.kQm.getPageContext().getPageActivity();
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
            Map<String, ImageUrlData> dbU = j.this.kQm.dbU();
            if (this.mUrl != null && dbU != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = dbU.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + as.bwo().BZ(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = n.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && n.copyImageFile(str, this.mUrl, j.this.kQm.getPageContext().getPageActivity()) == 0) {
                        return j.this.kQm.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (n.saveImageFileByUser(this.mUrl, this.mData, j.this.kQm.getPageContext().getPageActivity())) {
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
            if (!com.baidu.tbadk.a.d.bna() || j.this.getString(R.string.save_fail).equals(str)) {
                j.this.kQm.showToast(str);
            } else if (j.this.kSr != null) {
                j.this.kSr.a(j.this.kRj, j.this.kRj.getBottomHeight(), j.this.onWeChatEmotionShareListener);
            }
            j.this.kSj = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.kSj = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EZ(int i) {
        TiebaStatic.log(new aq("c13270").dX("uid", this.kQm.getUserId()).an("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcj() {
    }

    public void NR(String str) {
        int i;
        boolean z = false;
        if (this.iwA != null && !this.kQm.isFinishing() && this.iwA.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.kSq = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.iwB);
            this.kSq.a(this.kSx);
            int i2 = 0;
            while (true) {
                if (i2 < this.iwF.size()) {
                    if (this.kSn == null || this.iwF.get(i2) != this.kSn || (i = i2 + 1) > this.iwF.size()) {
                        i2++;
                    } else {
                        this.iwF.add(i, this.kSq);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.iwF.add(this.kSq);
            }
            this.iwB.bB(this.iwF);
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
                pVar.nsE = imageBitmap;
                String currentImageUrl = this.kRj.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    pVar.nsD = String.valueOf(System.currentTimeMillis()) + av.getNameMd5FromUrl(currentImageUrl);
                } else {
                    pVar.nsD = String.valueOf(BdUniqueId.gen().getId());
                }
                this.kSk = pVar.nsD;
                this.kQm.sendMessage(new CustomMessage(2921403, pVar));
            }
        }
    }

    public void dck() {
        this.kSk = null;
    }

    public void release() {
        if (this.kSj != null) {
            this.kSj.cancel();
            this.kSj = null;
        }
        if (this.kSl != null) {
            this.kSl.cancel();
            this.kSl = null;
        }
        if (this.kSr != null) {
            this.kSr.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.iwB != null) {
            this.iwB.onChangeSkinType();
        }
    }
}
