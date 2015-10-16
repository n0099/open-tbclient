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
    private com.baidu.tbadk.img.b amg;
    private l djP;
    private q djQ;
    private int bax = 0;
    private boolean djR = false;
    private int djS = 0;
    private String from = "";
    private String fid = "";
    private boolean djT = false;
    private boolean djU = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.amg = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        aBa();
        lG(0);
        aBb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.djP.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.djU);
    }

    private void initData(Bundle bundle) {
        this.djP = new l(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.djP.setWriteImagesInfo(writeImagesInfo);
            this.djP.mn(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.djU = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.djP.setWriteImagesInfo(writeImagesInfo2);
            this.djP.mn(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.djS = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if (WriteActivity.dqc.equals(this.from)) {
                this.djT = true;
            } else {
                this.djT = false;
            }
            this.djP.gQ(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.djU = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.djQ = new q(this);
        this.djQ.aBA();
    }

    private void aBa() {
        if (this.djQ != null && this.djP != null) {
            this.djQ.lM(this.djP.getMaxImagesAllowed());
            if (this.djP.aBs() != null) {
                for (ImageFileInfo imageFileInfo : this.djP.aBs()) {
                    this.djQ.f(imageFileInfo);
                }
            }
            aBi();
        }
    }

    private void aBb() {
        int size = this.djP.size();
        this.djQ.n(size != 0, getPageContext().getPageActivity().getString(this.djT ? i.h.live_album_finish_btn : i.h.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.djQ.onChangeSkinType(i);
    }

    private void aBc() {
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.djP.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.djS);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.djQ.aBB()) {
            aBc();
        } else if (view == this.djQ.aBC()) {
            if (this.djP != null) {
                this.djP.setLastAlbumId(null);
            }
            aBh();
        } else if (view == this.djQ.aBD()) {
            lG(0);
        } else if (view == this.djQ.aBE()) {
            aBd();
        }
    }

    private void aBd() {
        if (this.djQ != null && this.djP != null) {
            this.djP.setOriginalImg(!this.djP.isOriginalImg());
            if (this.djP.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new aq("c10349").ae(ImageViewerConfig.FORUM_ID, this.fid).ae("obj_type", this.from));
                }
                aBj();
                return;
            }
            this.djQ.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l aBe() {
        return this.djP;
    }

    public com.baidu.tbadk.img.b aBf() {
        return this.amg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lG(int i) {
        t(i, true);
    }

    void t(int i, boolean z) {
        if (!this.djR) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.djU) {
                    this.djQ.q(false, this.djP.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.djU) {
                    this.djQ.q(true, this.djP.isOriginalImg());
                    aBj();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.djQ.lO(this.bax));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.amg.Cm();
                }
            }
            this.bax = i;
            if (this.djQ != null) {
                this.djQ.lP(this.bax);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.djQ.lO(i)) != null) {
                beginTransaction.show(this.djQ.lN(i));
            } else {
                beginTransaction.add(i.f.fragment, this.djQ.lN(i), this.djQ.lO(i));
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
        int maxImagesAllowed = this.djP.getMaxImagesAllowed();
        if (this.djP.size() < maxImagesAllowed) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.djP.addChooseFile(imageFileInfo2);
            aBb();
            aBi();
            this.djQ.f(imageFileInfo2);
            aBj();
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
        this.djP.delChooseFile(imageFileInfo);
        aBb();
        aBi();
        this.djQ.g(imageFileInfo);
        aBj();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bax == 0) {
                if (this.djP != null) {
                    this.djP.setLastAlbumId(null);
                }
                aBh();
                return true;
            } else if (this.bax == 1) {
                lG(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i, boolean z) {
        Fragment lN;
        if (this.djQ != null && (lN = this.djQ.lN(0)) != null && (lN instanceof ac)) {
            ((ac) lN).v(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment lN;
        if (this.djQ != null && (lN = this.djQ.lN(0)) != null && (lN instanceof ac)) {
            ((ac) lN).f(imageFileInfo, z);
        }
    }

    private void aBg() {
        Fragment lN;
        if (this.djQ != null && (lN = this.djQ.lN(0)) != null && (lN instanceof ac)) {
            ((ac) lN).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment lN;
        if (this.djQ != null && (lN = this.djQ.lN(1)) != null && (lN instanceof b)) {
            ((b) lN).f(imageFileInfo, z);
        }
    }

    private void aBh() {
        Intent intent = new Intent();
        String lastAlbumId = this.djP.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.djS);
        setResult(0, intent);
        finish();
    }

    private void aBi() {
        if (this.djP != null && this.djQ != null) {
            if (this.djP.size() == this.djP.getMaxImagesAllowed()) {
                this.djQ.gT(false);
            } else {
                this.djQ.gT(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            mi(this.djP.aBx());
            t(1, false);
        }
    }

    private void mi(String str) {
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
            if (this.djP.aBu() != null && this.djP.aBu().size() > 0) {
                this.djP.aBu().add(1, imageFileInfo);
                c(imageFileInfo);
                this.djP.lL(this.djP.aBu().indexOf(imageFileInfo));
                aBg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.djR = true;
        if (this.djQ != null) {
            this.djQ.onDestroy();
        }
        this.amg.Cm();
        m.aBz().destory();
    }

    public void aBj() {
        if (this.djQ != null && this.djP != null && this.djP.aBs() != null && this.djP.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.djP.aBs()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.n.cS(imageFileInfo.getFilePath());
                }
            }
            this.djQ.a(true, j);
        }
    }
}
