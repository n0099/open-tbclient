package com.baidu.tieba.write.album;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.write.WriteActivity;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener {
    private com.baidu.tbadk.img.b aml;
    private m dlv;
    private r dlw;
    private w dlz;
    private int baQ = 0;
    private boolean dlx = false;
    private int dly = 0;
    private String from = "";
    private String fid = "";
    private boolean dlA = false;
    private boolean dlB = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aml = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        aBM();
        lU(0);
        aBN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.dlv.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.dlB);
    }

    private void initData(Bundle bundle) {
        this.dlv = new m(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.dlv.setWriteImagesInfo(writeImagesInfo);
            this.dlv.mr(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.dlB = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.dlv.setWriteImagesInfo(writeImagesInfo2);
            this.dlv.mr(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.dly = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if (WriteActivity.drU.equals(this.from)) {
                this.dlA = true;
            } else {
                this.dlA = false;
            }
            if (this.dly == 2) {
                this.dlz = new a(this);
            }
            this.dlv.gT(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.dlB = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.dlw = new r(this);
        this.dlw.aCm();
    }

    private void aBM() {
        if (this.dlw != null && this.dlv != null) {
            this.dlw.ma(this.dlv.getMaxImagesAllowed());
            if (this.dlv.aCe() != null) {
                for (ImageFileInfo imageFileInfo : this.dlv.aCe()) {
                    this.dlw.g(imageFileInfo);
                }
            }
            aBU();
        }
    }

    private void aBN() {
        int size = this.dlv.size();
        this.dlw.n(size != 0, getPageContext().getPageActivity().getString(this.dlA ? i.h.live_album_finish_btn : i.h.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.dlw.onChangeSkinType(i);
    }

    private void aBO() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.dlv.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.dly);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dlw.aCn()) {
            aBO();
        } else if (view == this.dlw.aCo()) {
            if (this.dlv != null) {
                this.dlv.setLastAlbumId(null);
            }
            aBT();
        } else if (view == this.dlw.aCp()) {
            lU(0);
        } else if (view == this.dlw.aCq()) {
            aBP();
        }
    }

    private void aBP() {
        if (this.dlw != null && this.dlv != null) {
            this.dlv.setOriginalImg(!this.dlv.isOriginalImg());
            if (this.dlv.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new aq("c10349").ae(ImageViewerConfig.FORUM_ID, this.fid).ae("obj_type", this.from));
                }
                aBV();
                return;
            }
            this.dlw.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m aBQ() {
        return this.dlv;
    }

    public com.baidu.tbadk.img.b aBR() {
        return this.aml;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lU(int i) {
        t(i, true);
    }

    void t(int i, boolean z) {
        if (!this.dlx) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.dlB) {
                    this.dlw.q(false, this.dlv.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.dlB) {
                    this.dlw.q(true, this.dlv.isOriginalImg());
                    aBV();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.dlw.mc(this.baQ));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.aml.Cc();
                }
            }
            this.baQ = i;
            if (this.dlw != null) {
                this.dlw.md(this.baQ);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.dlw.mc(i)) != null) {
                beginTransaction.show(this.dlw.mb(i));
            } else {
                beginTransaction.add(i.f.fragment, this.dlw.mb(i), this.dlw.mc(i));
            }
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.dlv.getMaxImagesAllowed();
        if (this.dlv.size() < maxImagesAllowed) {
            if (this.dlz == null || this.dlz.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                this.dlv.addChooseFile(imageFileInfo2);
                aBN();
                aBU();
                this.dlw.g(imageFileInfo2);
                aBV();
                return true;
            }
            return false;
        }
        showToast(String.format(getPageContext().getContext().getString(i.h.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.dlv.delChooseFile(imageFileInfo);
        aBN();
        aBU();
        this.dlw.h(imageFileInfo);
        aBV();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.baQ == 0) {
                if (this.dlv != null) {
                    this.dlv.setLastAlbumId(null);
                }
                aBT();
                return true;
            } else if (this.baQ == 1) {
                lU(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i, boolean z) {
        Fragment mb;
        if (this.dlw != null && (mb = this.dlw.mb(0)) != null && (mb instanceof ae)) {
            ((ae) mb).v(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment mb;
        if (this.dlw != null && (mb = this.dlw.mb(0)) != null && (mb instanceof ae)) {
            ((ae) mb).f(imageFileInfo, z);
        }
    }

    private void aBS() {
        Fragment mb;
        if (this.dlw != null && (mb = this.dlw.mb(0)) != null && (mb instanceof ae)) {
            ((ae) mb).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment mb;
        if (this.dlw != null && (mb = this.dlw.mb(1)) != null && (mb instanceof c)) {
            ((c) mb).f(imageFileInfo, z);
        }
    }

    private void aBT() {
        Intent intent = new Intent();
        String lastAlbumId = this.dlv.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.dly);
        setResult(0, intent);
        finish();
    }

    private void aBU() {
        if (this.dlv != null && this.dlw != null) {
            if (this.dlv.size() == this.dlv.getMaxImagesAllowed()) {
                this.dlw.gW(false);
            } else {
                this.dlw.gW(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            mm(this.dlv.aCj());
            t(1, false);
        }
    }

    private void mm(String str) {
        String str2;
        boolean z;
        if (StringUtils.isNull(str, true)) {
            str = "camera.jpg";
            str2 = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/camera.jpg";
            z = true;
        } else {
            str2 = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + str;
            z = false;
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                int cC = com.baidu.tbadk.core.util.c.cC(str2);
                if (cC != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cC);
                    if (b != i) {
                        b.recycle();
                    }
                    if (z) {
                        com.baidu.tbadk.core.util.n.a(null, str, i, 100);
                    } else {
                        com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, str, i, 100);
                    }
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str2);
            imageFileInfo.setTempFile(true);
            if (this.dlv.aCg() != null && this.dlv.aCg().size() > 0) {
                this.dlv.aCg().add(1, imageFileInfo);
                c(imageFileInfo);
                this.dlv.lZ(this.dlv.aCg().indexOf(imageFileInfo));
                aBS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dlx = true;
        if (this.dlw != null) {
            this.dlw.onDestroy();
        }
        this.aml.Cc();
        n.aCl().destory();
    }

    public void aBV() {
        if (this.dlw != null && this.dlv != null && this.dlv.aCe() != null && this.dlv.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.dlv.aCe()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.n.cS(imageFileInfo.getFilePath());
                }
            }
            this.dlw.a(true, j);
        }
    }
}
