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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.n;
import com.baidu.tieba.ueg.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class j {
    private com.baidu.tbadk.core.dialog.i fKC;
    private k fKD;
    private com.baidu.tbadk.core.dialog.g fUJ;
    private final ImageViewerActivity hSQ;
    private a hSR;
    private com.baidu.tieba.ueg.c hST;
    private com.baidu.tbadk.core.dialog.g hSU;
    private com.baidu.tbadk.core.dialog.g hSV;
    private com.baidu.tbadk.core.dialog.g hSW;
    private com.baidu.tbadk.core.dialog.g hSX;
    private com.baidu.tbadk.core.dialog.g hSY;
    private MultiImageView hSg;
    private PermissionJudgePolicy mPermissionJudgement;
    private String hSS = null;
    private List<com.baidu.tbadk.core.dialog.g> fKH = null;
    private CustomMessageListener hSZ = new CustomMessageListener(2921403) { // from class: com.baidu.tieba.image.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && !j.this.hSQ.isFinishing() && (nVar = (n) customResponsedMessage.getData()) != null) {
                nVar.khN = null;
                if (!TextUtils.isEmpty(nVar.khP) && !TextUtils.isEmpty(nVar.khM) && nVar.khM.equals(j.this.hSS)) {
                    j.this.hSg.setCurrentImageQRInfo(nVar.khP);
                    j.this.DS(nVar.khP);
                }
            }
        }
    };
    private k.b hTa = new k.b() { // from class: com.baidu.tieba.image.j.3
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            j.this.hSg.md(j.this.hSQ.bRC());
            j.this.bvc();
        }
    };
    private k.b hTb = new k.b() { // from class: com.baidu.tieba.image.j.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            g.aW(j.this.hSQ.getPageContext().getPageActivity(), j.this.hSg.getCurrentImageUrl());
            j.this.bvc();
            j.this.xj(1);
        }
    };
    private k.b hTc = new k.b() { // from class: com.baidu.tieba.image.j.5
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            String currentImageUrl = j.this.hSg.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, currentImageUrl));
            } else {
                Intent intent = new Intent(com.baidu.tbadk.imageManager.d.ADD_USER_COLLECT_EMOTION_ACTION);
                intent.putExtra(com.baidu.tbadk.imageManager.d.IMAGE_URL, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            j.this.bvc();
            j.this.xj(2);
        }
    };
    private k.b fUK = new k.b() { // from class: com.baidu.tieba.image.j.6
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            Activity pageActivity = j.this.hSQ.getPageContext().getPageActivity();
            if (j.this.mPermissionJudgement == null) {
                j.this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            j.this.mPermissionJudgement.clearRequestPermissionList();
            j.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!j.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                j.this.saveImage();
                j.this.bvc();
                j.this.xj(3);
            }
        }
    };
    private k.b hTd = new k.b() { // from class: com.baidu.tieba.image.j.7
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            UrlDragImageView currentUrlDragImageView;
            if (j.this.hSg != null && (currentUrlDragImageView = j.this.hSg.getCurrentUrlDragImageView()) != null) {
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                String str = "";
                String str2 = "";
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = com.baidu.tbadk.core.util.c.c.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = j.this.hSg.getCurrentImageUrl();
                    str2 = as.getNameMd5FromUrl(str);
                }
                ShareItem shareItem = new ShareItem();
                if (imageUrlData != null) {
                    long j = imageUrlData.threadId;
                    if (j > 0) {
                        shareItem.linkUrl = "http://tieba.baidu.com/p/" + j + "?fr=share";
                    }
                }
                if (!aq.isEmpty(str)) {
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
                shareItem.dqj = true;
                shareItem.dqr = 14;
                j.this.hSQ.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(j.this.hSQ, shareItem, false)));
                j.this.bvc();
                j.this.xj(4);
            }
        }
    };
    private k.b hTe = new AnonymousClass8();

    public j(@Nullable ImageViewerActivity imageViewerActivity) {
        this.hSQ = imageViewerActivity;
        this.hSQ.registerListener(this.hSZ);
    }

    public void j(@Nullable MultiImageView multiImageView) {
        this.hSg = multiImageView;
        if (this.fKC == null) {
            this.fKD = new k(this.hSQ);
        }
        if (this.fKH == null) {
            this.fKH = new ArrayList();
        }
        bye();
        this.fKC = new com.baidu.tbadk.core.dialog.i(this.hSQ.getPageContext(), this.fKD);
    }

    public void bye() {
        this.fKH.clear();
        String mc = this.hSg.mc(this.hSQ.bRC());
        if (mc != null) {
            this.hSU = new com.baidu.tbadk.core.dialog.g(mc, this.fKD);
            this.hSU.a(this.hTa);
            this.fKH.add(this.hSU);
        }
        this.fUJ = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_local), this.fKD);
        this.fUJ.a(this.fUK);
        this.fKH.add(this.fUJ);
        if (this.hSQ != null && !this.hSQ.caI()) {
            this.hSW = new com.baidu.tbadk.core.dialog.g(getString(R.string.save_to_emotion), this.fKD);
            this.hSW.a(this.hTc);
            this.fKH.add(this.hSW);
        }
        this.hSV = new com.baidu.tbadk.core.dialog.g(getString(R.string.identify_image), this.fKD);
        this.hSV.a(this.hTb);
        this.fKH.add(this.hSV);
        String currentImageQRInfo = this.hSg.getCurrentImageQRInfo();
        if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
            this.hSY = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.fKD);
            this.hSY.a(this.hTe);
            this.fKH.add(this.hSY);
        }
        this.hSX = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_share), this.fKD);
        this.hSX.a(this.hTd);
        this.fKH.add(this.hSX);
        this.fKD.a(new k.a() { // from class: com.baidu.tieba.image.j.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                j.this.bvc();
            }
        });
        this.fKD.az(this.fKH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i) {
        return this.hSQ.getString(i);
    }

    public void bvc() {
        if (this.fKC != null && this.fKC.isShowing()) {
            this.fKC.dismiss();
        }
    }

    public void show() {
        if (this.fKC != null && !this.hSQ.isFinishing()) {
            this.fKC.showDialog();
        }
    }

    /* renamed from: com.baidu.tieba.image.j$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass8 implements k.b {
        AnonymousClass8() {
        }

        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            final String currentImageQRInfo = j.this.hSg.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                if (!l.isNetOk()) {
                    l.showToast(j.this.hSQ.getPageContext().getPageActivity(), j.this.getString(R.string.network_not_available));
                    return;
                }
                if (j.this.hST != null && !j.this.hST.isCancelled()) {
                    j.this.hST.cancel();
                }
                j.this.hST = new com.baidu.tieba.ueg.c(currentImageQRInfo, new c.a() { // from class: com.baidu.tieba.image.j.8.1
                    @Override // com.baidu.tieba.ueg.c.a
                    public void caN() {
                        j.this.openUrl(currentImageQRInfo);
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void caO() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.hSQ.getPageContext().getPageActivity());
                        aVar.setTitleShowCenter(true);
                        aVar.sR(j.this.getString(R.string.qr_url_jump_external_title));
                        aVar.setMessageShowCenter(true);
                        aVar.sS(j.this.getString(R.string.qr_url_jump_external_message));
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
                        aVar.fG(false);
                        aVar.fH(false);
                        aVar.b(j.this.hSQ.getPageContext()).aEC();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void caP() {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(j.this.hSQ.getPageContext().getPageActivity());
                        aVar.sR(null);
                        aVar.setMessageShowCenter(true);
                        aVar.sS(j.this.getString(R.string.qr_url_risk_forbid));
                        aVar.a(j.this.getString(R.string.qr_url_risk_forbid_button), new a.b() { // from class: com.baidu.tieba.image.j.8.1.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.fG(false);
                        aVar.fH(false);
                        aVar.b(j.this.hSQ.getPageContext()).aEC();
                    }

                    @Override // com.baidu.tieba.ueg.c.a
                    public void onError(String str) {
                        l.showToast(j.this.hSQ.getPageContext().getPageActivity(), j.this.getString(R.string.qr_scan_error));
                    }
                });
                j.this.hST.setPriority(3);
                j.this.hST.execute(new String[0]);
                j.this.bvc();
                j.this.xj(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.hSQ.getPageContext().getPageActivity(), null, str, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        try {
            this.hSR = new a(this.hSg.getCurrentImageUrl(), this.hSg.getCurrentImageData());
            this.hSR.execute(new String[0]);
            if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.hSQ.getFrom())) {
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
            Map<String, ImageUrlData> caA = j.this.hSQ.caA();
            if (this.mUrl != null && caA != null) {
                Iterator<Map.Entry<String, ImageUrlData>> it = caA.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ap.aGA().tw(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(imageUrlData.originalUrl);
                    int[] imageFileWH = m.getImageFileWH(str);
                    if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && m.copyImageFile(str, this.mUrl, j.this.hSQ.getPageContext().getPageActivity()) == 0) {
                        return j.this.hSQ.getPageContext().getString(R.string.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (m.saveImageFileByUser(this.mUrl, this.mData, j.this.hSQ.getPageContext().getPageActivity())) {
                    case -2:
                        return m.getSdErrorString();
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
            j.this.hSQ.showToast(str);
            j.this.hSR = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.hSR = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i) {
        TiebaStatic.log(new an("c13270").cy("uid", this.hSQ.getUserId()).X("obj_type", i));
    }

    public void DS(String str) {
        int i;
        boolean z = false;
        if (this.fKC != null && !this.hSQ.isFinishing() && this.fKC.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            this.hSY = new com.baidu.tbadk.core.dialog.g(getString(R.string.image_qr_code), this.fKD);
            this.hSY.a(this.hTe);
            int i2 = 0;
            while (true) {
                if (i2 < this.fKH.size()) {
                    if (this.hSV == null || this.fKH.get(i2) != this.hSV || (i = i2 + 1) > this.fKH.size()) {
                        i2++;
                    } else {
                        this.fKH.add(i, this.hSY);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.fKH.add(this.hSY);
            }
            this.fKD.az(this.fKH);
        }
    }

    public void ch(View view) {
        Bitmap imageBitmap;
        if (view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
                n nVar = new n();
                nVar.type = 0;
                nVar.khN = imageBitmap;
                String currentImageUrl = this.hSg.getCurrentImageUrl();
                if (!TextUtils.isEmpty(currentImageUrl)) {
                    nVar.khM = String.valueOf(System.currentTimeMillis()) + as.getNameMd5FromUrl(currentImageUrl);
                } else {
                    nVar.khM = String.valueOf(BdUniqueId.gen().getId());
                }
                this.hSS = nVar.khM;
                this.hSQ.sendMessage(new CustomMessage(2921403, nVar));
            }
        }
    }

    public void caM() {
        this.hSS = null;
    }

    public void release() {
        if (this.hSR != null) {
            this.hSR.cancel();
            this.hSR = null;
        }
        if (this.hST != null) {
            this.hST.cancel();
            this.hST = null;
        }
    }
}
