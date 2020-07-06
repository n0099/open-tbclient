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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
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
/* loaded from: classes8.dex */
public class j {
    private com.baidu.tbadk.core.dialog.i gRN;
    private k gRO;
    private com.baidu.tbadk.core.dialog.g hbW;
    private MultiImageView jkz;
    private final ImageViewerActivity jll;
    private a jlm;
    private com.baidu.tieba.ueg.c jlo;
    private com.baidu.tbadk.core.dialog.g jlp;
    private com.baidu.tbadk.core.dialog.g jlq;
    private com.baidu.tbadk.core.dialog.g jlr;
    private com.baidu.tbadk.core.dialog.g jls;
    private com.baidu.tbadk.core.dialog.g jlt;
    private PermissionJudgePolicy mPermissionJudgement;
    private String jln = null;
    private List<com.baidu.tbadk.core.dialog.g> gRS = null;
    private CustomMessageListener jlu = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o) && !j.this.jll.isFinishing() && (oVar = (o) customResponsedMessage.getData()) != null) {
                oVar.lGU = null;
                if (!TextUtils.isEmpty(oVar.lGW) && !TextUtils.isEmpty(oVar.lGT) && oVar.lGT.equals(j.this.jln)) {
                    j.this.jkz.setCurrentImageQRInfo(oVar.lGW);
                    j.this.HP(oVar.lGW);
                }
            }
        }
    };
    private k.b jlv = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.jkz.np(j.this.jll.cmP());
            j.this.bOw();
        }
    };
    private k.b jlw = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aG(j.this.jll.getPageContext().getPageActivity(), j.this.jkz.getCurrentImageUrl());
            j.this.bOw();
            j.this.zn(1);
        }
    };
    private k.b jlx = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.jkz.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.bOw();
            j.this.zn(2);
        }
    };
    private k.b hbX = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.jll.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.bOw();
                j.this.zn(3);
            }
        }
    };
    private k.b jly = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.jkz != null && (currentUrlDragImageView = j.this.jkz.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.jkz.getCurrentImageUrl();
                    str2 = at.getNameMd5FromUrl(str);
                }
                ShareItem shareItem = new ShareItem();
                if (imageUrlData != null) {
                    long j = imageUrlData.threadId;
                    if (j > 0) {
                        shareItem.linkUrl = "http://tieba.baidu.com/p/" + j + "?fr=share";
                    }
                }
                if (!ar.isEmpty(str)) {
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
                shareItem.enG = 14;
                j.this.jll.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(j.this.jll, shareItem, false)));
                j.this.bOw();
                j.this.zn(4);
                j.this.cwg();
            }
        }
    };
    private k.b jlz = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.jll = imageViewerActivity;
        this.jll.registerListener(this.jlu);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.jkz = multiImageView;
        if (this.gRN == null) {
            this.gRO = new k(this.jll);
        }
        if (this.gRS == null) {
            this.gRS = new ArrayList();
        }
        bRC();
        this.gRN = new com.baidu.tbadk.core.dialog.i(this.jll.getPageContext(), this.gRO);
    }

    public void bRC() {
        this.gRS.clear();
        String no = this.jkz.no(this.jll.cmP());
        if (no != null) {
            this.jlp = new com.baidu.tbadk.core.dialog.g(no, this.gRO);
            this.jlp.a(this.jlv);
            this.gRS.add(this.jlp);
        }
        this.hbW = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.gRO);
        this.hbW.a(this.hbX);
        this.gRS.add(this.hbW);
        if (this.jll != null && !this.jll.cwc()) {
            this.jlr = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.gRO);
            this.jlr.a(this.jlx);
            this.gRS.add(this.jlr);
        }
        this.jlq = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.gRO);
        this.jlq.a(this.jlw);
        this.gRS.add(this.jlq);
        String currentImageQRInfo = this.jkz.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.jlt = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.gRO);
            this.jlt.a(this.jlz);
            this.gRS.add(this.jlt);
        }
        this.jls = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.gRO);
        this.jls.a(this.jly);
        this.gRS.add(this.jls);
        this.gRO.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.bOw();
            }
        });
        this.gRO.aL(this.gRS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.jll.getString(i);
    }

    public void bOw() {
        if (this.gRN != null && this.gRN.isShowing()) {
            this.gRN.dismiss();
        }
    }

    public void show() {
        if (this.gRN != null && !this.jll.isFinishing()) {
            this.gRN.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.jkz.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.jll.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.jlo != null && !j.this.jlo.isCancelled()) {
                    j.this.jlo.cancel();
                }
                j.this.jlo = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void cwi() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cwj() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.jll.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.wd(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.we(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.hf(false);
                        aVar.hg(false);
                        aVar.b(j.this.jll.getPageContext()).aUN();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void cwk() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.jll.getPageContext().getPageActivity());
                        aVar.wd(null);
                        aVar.setMessageShowCenter(true);
                        aVar.we(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.hf(false);
                        aVar.hg(false);
                        aVar.b(j.this.jll.getPageContext()).aUN();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.jll.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.jlo.setPriority(3);
                j.this.jlo.execute(new String[0]);
                j.this.bOw();
                j.this.zn(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.jll.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.jlm = new a(this.jkz.getCurrentImageUrl(), this.jkz.getCurrentImageData());
            this.jlm.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.jll.getFrom())) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
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
            Map<String, ImageUrlData> cvT = j.this.jll.cvT();
            if (this.mUrl != null && cvT != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = cvT.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + aq.aWO().wI(nameMd5FromUrl) + "/" + at.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = n.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && n.copyImageFile(str, this.mUrl, j.this.jll.getPageContext().getPageActivity()) == 0) {
                        return j.this.jll.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (n.saveImageFileByUser(this.mUrl, this.mData, j.this.jll.getPageContext().getPageActivity())) {
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
            j.this.jll.showToast(str);
            j.this.jlm = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.jlm = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zn(int i) {
        TiebaStatic.log(new ao("c13270").dk("uid", this.jll.getUserId()).ag("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwg() {
    }

    public void HP(String str) {
        int i;
        boolean z = false;
        if (this.gRN != null && !this.jll.isFinishing() && this.gRN.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.jlt = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.gRO);
            this.jlt.a(this.jlz);
            int i2 = 0;
            while (true) {
                if (i2 < this.gRS.size()) {
                    if (this.jlq == null || this.gRS.get(i2) != this.jlq || (i = i2 + 1) > this.gRS.size()) {
                        i2++;
                    } else {
                        this.gRS.add(i, this.jlt);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.gRS.add(this.jlt);
            }
            this.gRO.aL(this.gRS);
        }
    }

    public void cq(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                o oVar = new o();
                oVar.type = 0;
                oVar.lGU = imageBitmap;
                String currentImageUrl = this.jkz.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    oVar.lGT = String.valueOf(System.currentTimeMillis()) + at.getNameMd5FromUrl(currentImageUrl);
                } else {
                    oVar.lGT = String.valueOf(BdUniqueId.gen().getId());
                }
                this.jln = oVar.lGT;
                this.jll.sendMessage(new CustomMessage(2921403, oVar));
            }
        }
    }

    public void cwh() {
        this.jln = null;
    }

    public void release() {
        if (this.jlm != null) {
            this.jlm.cancel();
            this.jlm = null;
        }
        if (this.jlo != null) {
            this.jlo.cancel();
            this.jlo = null;
        }
    }
}
