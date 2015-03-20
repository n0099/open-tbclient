package com.baidu.tieba.write.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener {
    private n ctp;
    private t ctq;
    private com.baidu.tbadk.img.e cts;
    private int aUl = 0;
    private boolean ctr = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cts = new com.baidu.tbadk.img.e(getPageContext().getPageActivity());
        initView();
        initData(bundle);
        apv();
        iL(0);
        apw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.ctp.getWriteImagesInfo().toJsonString());
    }

    private void initData(Bundle bundle) {
        this.ctp = new n();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.ctp.setWriteImagesInfo(writeImagesInfo);
            this.ctp.jc(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.ctp.setWriteImagesInfo(writeImagesInfo2);
            this.ctp.jc(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
        }
    }

    private void initView() {
        this.ctq = new t(this);
        this.ctq.apP();
    }

    private void apv() {
        if (this.ctq != null && this.ctp != null) {
            this.ctq.iQ(this.ctp.getMaxImagesAllowed());
            if (this.ctp.apI() != null) {
                for (ImageFileInfo imageFileInfo : this.ctp.apI()) {
                    this.ctq.f(imageFileInfo);
                }
            }
            apA();
        }
    }

    private void apw() {
        int size = this.ctp.size();
        this.ctq.k(size != 0, getPageContext().getPageActivity().getString(com.baidu.tieba.y.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.ctq.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ctq.apQ()) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.ctp.getWriteImagesInfo().toJsonString());
            setResult(-1, intent);
            finish();
        } else if (view == this.ctq.apR()) {
            if (this.ctp != null) {
                this.ctp.setLastAlbumId(null);
            }
            apz();
        } else if (view == this.ctq.apS()) {
            iL(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n apx() {
        return this.ctp;
    }

    public com.baidu.tbadk.img.e apy() {
        return this.cts;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iL(int i) {
        if (!this.ctr) {
            if (i == 0) {
                setSwipeBackEnabled(true);
            } else {
                setSwipeBackEnabled(false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.ctq.iS(this.aUl));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.cts.zA();
            }
            this.aUl = i;
            if (this.ctq != null) {
                this.ctq.iT(this.aUl);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.ctq.iS(i)) != null) {
                beginTransaction.show(this.ctq.iR(i));
            } else {
                beginTransaction.add(com.baidu.tieba.v.fragment, this.ctq.iR(i), this.ctq.iS(i));
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
        int maxImagesAllowed = this.ctp.getMaxImagesAllowed();
        if (this.ctp.size() < maxImagesAllowed) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.ctp.addChooseFile(imageFileInfo2);
            apw();
            apA();
            this.ctq.f(imageFileInfo2);
            return true;
        }
        showToast(String.format(getPageContext().getContext().getString(com.baidu.tieba.y.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.ctp.delChooseFile(imageFileInfo);
        apw();
        apA();
        this.ctq.g(imageFileInfo);
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aUl == 0) {
                if (this.ctp != null) {
                    this.ctp.setLastAlbumId(null);
                }
                apz();
                return true;
            } else if (this.aUl == 1) {
                iL(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i, boolean z) {
        Fragment iR;
        if (this.ctq != null && (iR = this.ctq.iR(0)) != null && (iR instanceof ah)) {
            ((ah) iR).u(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImageFileInfo imageFileInfo, boolean z) {
        Fragment iR;
        if (this.ctq != null && (iR = this.ctq.iR(0)) != null && (iR instanceof ah)) {
            ((ah) iR).e(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment iR;
        if (this.ctq != null && (iR = this.ctq.iR(1)) != null && (iR instanceof b)) {
            ((b) iR).e(imageFileInfo, z);
        }
    }

    private void apz() {
        Intent intent = new Intent();
        String lastAlbumId = this.ctp.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        setResult(0, intent);
        finish();
    }

    private void apA() {
        if (this.ctp != null && this.ctq != null) {
            if (this.ctp.size() == this.ctp.getMaxImagesAllowed()) {
                this.ctq.fe(false);
            } else {
                this.ctq.fe(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.ctp.getWriteImagesInfo().toJsonString());
            intent2.putExtra(AlbumActivityConfig.CAMERA_RESULT, true);
            intent2.putExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME, this.ctp.apN());
            setResult(-1, intent2);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ctr = true;
        if (this.ctq != null) {
            this.ctq.onDestroy();
        }
        this.cts.zA();
        o.apO().destory();
    }
}
