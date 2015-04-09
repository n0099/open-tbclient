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
    private n ctF;
    private t ctG;
    private com.baidu.tbadk.img.e ctI;
    private int aUA = 0;
    private boolean ctH = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ctI = new com.baidu.tbadk.img.e(getPageContext().getPageActivity());
        initView();
        initData(bundle);
        apK();
        iO(0);
        apL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.ctF.getWriteImagesInfo().toJsonString());
    }

    private void initData(Bundle bundle) {
        this.ctF = new n();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.ctF.setWriteImagesInfo(writeImagesInfo);
            this.ctF.jf(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.ctF.setWriteImagesInfo(writeImagesInfo2);
            this.ctF.jf(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
        }
    }

    private void initView() {
        this.ctG = new t(this);
        this.ctG.aqe();
    }

    private void apK() {
        if (this.ctG != null && this.ctF != null) {
            this.ctG.iT(this.ctF.getMaxImagesAllowed());
            if (this.ctF.apX() != null) {
                for (ImageFileInfo imageFileInfo : this.ctF.apX()) {
                    this.ctG.f(imageFileInfo);
                }
            }
            apP();
        }
    }

    private void apL() {
        int size = this.ctF.size();
        this.ctG.k(size != 0, getPageContext().getPageActivity().getString(com.baidu.tieba.y.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.ctG.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ctG.aqf()) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.ctF.getWriteImagesInfo().toJsonString());
            setResult(-1, intent);
            finish();
        } else if (view == this.ctG.aqg()) {
            if (this.ctF != null) {
                this.ctF.setLastAlbumId(null);
            }
            apO();
        } else if (view == this.ctG.aqh()) {
            iO(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n apM() {
        return this.ctF;
    }

    public com.baidu.tbadk.img.e apN() {
        return this.ctI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iO(int i) {
        if (!this.ctH) {
            if (i == 0) {
                setSwipeBackEnabled(true);
            } else {
                setSwipeBackEnabled(false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.ctG.iV(this.aUA));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.ctI.zG();
            }
            this.aUA = i;
            if (this.ctG != null) {
                this.ctG.iW(this.aUA);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.ctG.iV(i)) != null) {
                beginTransaction.show(this.ctG.iU(i));
            } else {
                beginTransaction.add(com.baidu.tieba.v.fragment, this.ctG.iU(i), this.ctG.iV(i));
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
        int maxImagesAllowed = this.ctF.getMaxImagesAllowed();
        if (this.ctF.size() < maxImagesAllowed) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.ctF.addChooseFile(imageFileInfo2);
            apL();
            apP();
            this.ctG.f(imageFileInfo2);
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
        this.ctF.delChooseFile(imageFileInfo);
        apL();
        apP();
        this.ctG.g(imageFileInfo);
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aUA == 0) {
                if (this.ctF != null) {
                    this.ctF.setLastAlbumId(null);
                }
                apO();
                return true;
            } else if (this.aUA == 1) {
                iO(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i, boolean z) {
        Fragment iU;
        if (this.ctG != null && (iU = this.ctG.iU(0)) != null && (iU instanceof ah)) {
            ((ah) iU).u(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImageFileInfo imageFileInfo, boolean z) {
        Fragment iU;
        if (this.ctG != null && (iU = this.ctG.iU(0)) != null && (iU instanceof ah)) {
            ((ah) iU).e(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment iU;
        if (this.ctG != null && (iU = this.ctG.iU(1)) != null && (iU instanceof b)) {
            ((b) iU).e(imageFileInfo, z);
        }
    }

    private void apO() {
        Intent intent = new Intent();
        String lastAlbumId = this.ctF.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        setResult(0, intent);
        finish();
    }

    private void apP() {
        if (this.ctF != null && this.ctG != null) {
            if (this.ctF.size() == this.ctF.getMaxImagesAllowed()) {
                this.ctG.fc(false);
            } else {
                this.ctG.fc(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.ctF.getWriteImagesInfo().toJsonString());
            intent2.putExtra(AlbumActivityConfig.CAMERA_RESULT, true);
            intent2.putExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME, this.ctF.aqc());
            setResult(-1, intent2);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ctH = true;
        if (this.ctG != null) {
            this.ctG.onDestroy();
        }
        this.ctI.zG();
        o.aqd().destory();
    }
}
