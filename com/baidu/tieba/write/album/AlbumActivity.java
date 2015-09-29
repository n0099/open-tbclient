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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.write.WriteActivity;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener {
    private com.baidu.tbadk.img.b amf;
    private l djp;
    private q djq;
    private int bal = 0;
    private boolean djr = false;
    private int djs = 0;
    private String from = "";
    private String fid = "";
    private boolean djt = false;
    private boolean dju = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.amf = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        aAQ();
        lE(0);
        aAR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.djp.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.dju);
    }

    private void initData(Bundle bundle) {
        this.djp = new l(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.djp.setWriteImagesInfo(writeImagesInfo);
            this.djp.mk(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.dju = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.djp.setWriteImagesInfo(writeImagesInfo2);
            this.djp.mk(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.djs = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if (WriteActivity.dpC.equals(this.from)) {
                this.djt = true;
            } else {
                this.djt = false;
            }
            this.djp.gQ(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.dju = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.djq = new q(this);
        this.djq.aBq();
    }

    private void aAQ() {
        if (this.djq != null && this.djp != null) {
            this.djq.lK(this.djp.getMaxImagesAllowed());
            if (this.djp.aBi() != null) {
                for (ImageFileInfo imageFileInfo : this.djp.aBi()) {
                    this.djq.f(imageFileInfo);
                }
            }
            aAY();
        }
    }

    private void aAR() {
        int size = this.djp.size();
        this.djq.n(size != 0, getPageContext().getPageActivity().getString(this.djt ? i.h.live_album_finish_btn : i.h.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.djq.onChangeSkinType(i);
    }

    private void aAS() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.djp.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.djs);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.djq.aBr()) {
            aAS();
        } else if (view == this.djq.aBs()) {
            if (this.djp != null) {
                this.djp.setLastAlbumId(null);
            }
            aAX();
        } else if (view == this.djq.aBt()) {
            lE(0);
        } else if (view == this.djq.aBu()) {
            aAT();
        }
    }

    private void aAT() {
        if (this.djq != null && this.djp != null) {
            this.djp.setOriginalImg(!this.djp.isOriginalImg());
            if (this.djp.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new ap("c10349").ae(ImageViewerConfig.FORUM_ID, this.fid).ae("obj_type", this.from));
                }
                aAZ();
                return;
            }
            this.djq.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l aAU() {
        return this.djp;
    }

    public com.baidu.tbadk.img.b aAV() {
        return this.amf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lE(int i) {
        t(i, true);
    }

    void t(int i, boolean z) {
        if (!this.djr) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.dju) {
                    this.djq.q(false, this.djp.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.dju) {
                    this.djq.q(true, this.djp.isOriginalImg());
                    aAZ();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.djq.lM(this.bal));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.amf.Cm();
                }
            }
            this.bal = i;
            if (this.djq != null) {
                this.djq.lN(this.bal);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.djq.lM(i)) != null) {
                beginTransaction.show(this.djq.lL(i));
            } else {
                beginTransaction.add(i.f.fragment, this.djq.lL(i), this.djq.lM(i));
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
        int maxImagesAllowed = this.djp.getMaxImagesAllowed();
        if (this.djp.size() < maxImagesAllowed) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.djp.addChooseFile(imageFileInfo2);
            aAR();
            aAY();
            this.djq.f(imageFileInfo2);
            aAZ();
            return true;
        }
        showToast(String.format(getPageContext().getContext().getString(i.h.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.djp.delChooseFile(imageFileInfo);
        aAR();
        aAY();
        this.djq.g(imageFileInfo);
        aAZ();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bal == 0) {
                if (this.djp != null) {
                    this.djp.setLastAlbumId(null);
                }
                aAX();
                return true;
            } else if (this.bal == 1) {
                lE(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i, boolean z) {
        Fragment lL;
        if (this.djq != null && (lL = this.djq.lL(0)) != null && (lL instanceof ac)) {
            ((ac) lL).v(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment lL;
        if (this.djq != null && (lL = this.djq.lL(0)) != null && (lL instanceof ac)) {
            ((ac) lL).f(imageFileInfo, z);
        }
    }

    private void aAW() {
        Fragment lL;
        if (this.djq != null && (lL = this.djq.lL(0)) != null && (lL instanceof ac)) {
            ((ac) lL).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment lL;
        if (this.djq != null && (lL = this.djq.lL(1)) != null && (lL instanceof b)) {
            ((b) lL).f(imageFileInfo, z);
        }
    }

    private void aAX() {
        Intent intent = new Intent();
        String lastAlbumId = this.djp.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.djs);
        setResult(0, intent);
        finish();
    }

    private void aAY() {
        if (this.djp != null && this.djq != null) {
            if (this.djp.size() == this.djp.getMaxImagesAllowed()) {
                this.djq.gT(false);
            } else {
                this.djq.gT(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            mf(this.djp.aBn());
            t(1, false);
        }
    }

    private void mf(String str) {
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
                int cB = com.baidu.tbadk.core.util.c.cB(str2);
                if (cB != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cB);
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
            if (this.djp.aBk() != null && this.djp.aBk().size() > 0) {
                this.djp.aBk().add(1, imageFileInfo);
                c(imageFileInfo);
                this.djp.lJ(this.djp.aBk().indexOf(imageFileInfo));
                aAW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.djr = true;
        if (this.djq != null) {
            this.djq.onDestroy();
        }
        this.amf.Cm();
        m.aBp().destory();
    }

    public void aAZ() {
        if (this.djq != null && this.djp != null && this.djp.aBi() != null && this.djp.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.djp.aBi()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.n.cR(imageFileInfo.getFilePath());
                }
            }
            this.djq.a(true, j);
        }
    }
}
