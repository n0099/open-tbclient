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
    private p cxU;
    private v cxV;
    private com.baidu.tbadk.img.e cxX;
    private int aXj = 0;
    private boolean cxW = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cxX = new com.baidu.tbadk.img.e(getPageContext().getPageActivity());
        initView();
        initData(bundle);
        arA();
        jk(0);
        arB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.cxU.getWriteImagesInfo().toJsonString());
    }

    private void initData(Bundle bundle) {
        this.cxU = new p();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.cxU.setWriteImagesInfo(writeImagesInfo);
            this.cxU.jY(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.cxU.setWriteImagesInfo(writeImagesInfo2);
            this.cxU.jY(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
        }
    }

    private void initView() {
        this.cxV = new v(this);
        this.cxV.arU();
    }

    private void arA() {
        if (this.cxV != null && this.cxU != null) {
            this.cxV.jp(this.cxU.getMaxImagesAllowed());
            if (this.cxU.arN() != null) {
                for (ImageFileInfo imageFileInfo : this.cxU.arN()) {
                    this.cxV.f(imageFileInfo);
                }
            }
            arF();
        }
    }

    private void arB() {
        int size = this.cxU.size();
        this.cxV.k(size != 0, getPageContext().getPageActivity().getString(com.baidu.tieba.t.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.cxV.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cxV.arV()) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cxU.getWriteImagesInfo().toJsonString());
            setResult(-1, intent);
            finish();
        } else if (view == this.cxV.arW()) {
            if (this.cxU != null) {
                this.cxU.setLastAlbumId(null);
            }
            arE();
        } else if (view == this.cxV.arX()) {
            jk(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p arC() {
        return this.cxU;
    }

    public com.baidu.tbadk.img.e arD() {
        return this.cxX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jk(int i) {
        if (!this.cxW) {
            if (i == 0) {
                setSwipeBackEnabled(true);
            } else {
                setSwipeBackEnabled(false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.cxV.jr(this.aXj));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.cxX.As();
            }
            this.aXj = i;
            if (this.cxV != null) {
                this.cxV.js(this.aXj);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.cxV.jr(i)) != null) {
                beginTransaction.show(this.cxV.jq(i));
            } else {
                beginTransaction.add(com.baidu.tieba.q.fragment, this.cxV.jq(i), this.cxV.jr(i));
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
        int maxImagesAllowed = this.cxU.getMaxImagesAllowed();
        if (this.cxU.size() < maxImagesAllowed) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.cxU.addChooseFile(imageFileInfo2);
            arB();
            arF();
            this.cxV.f(imageFileInfo2);
            return true;
        }
        showToast(String.format(getPageContext().getContext().getString(com.baidu.tieba.t.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.cxU.delChooseFile(imageFileInfo);
        arB();
        arF();
        this.cxV.g(imageFileInfo);
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aXj == 0) {
                if (this.cxU != null) {
                    this.cxU.setLastAlbumId(null);
                }
                arE();
                return true;
            } else if (this.aXj == 1) {
                jk(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i, boolean z) {
        Fragment jq;
        if (this.cxV != null && (jq = this.cxV.jq(0)) != null && (jq instanceof aj)) {
            ((aj) jq).t(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImageFileInfo imageFileInfo, boolean z) {
        Fragment jq;
        if (this.cxV != null && (jq = this.cxV.jq(0)) != null && (jq instanceof aj)) {
            ((aj) jq).e(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment jq;
        if (this.cxV != null && (jq = this.cxV.jq(1)) != null && (jq instanceof b)) {
            ((b) jq).e(imageFileInfo, z);
        }
    }

    private void arE() {
        Intent intent = new Intent();
        String lastAlbumId = this.cxU.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        setResult(0, intent);
        finish();
    }

    private void arF() {
        if (this.cxU != null && this.cxV != null) {
            if (this.cxU.size() == this.cxU.getMaxImagesAllowed()) {
                this.cxV.fy(false);
            } else {
                this.cxV.fy(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cxU.getWriteImagesInfo().toJsonString());
            intent2.putExtra(AlbumActivityConfig.CAMERA_RESULT, true);
            intent2.putExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME, this.cxU.arS());
            setResult(-1, intent2);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cxW = true;
        if (this.cxV != null) {
            this.cxV.onDestroy();
        }
        this.cxX.As();
        q.arT().destory();
    }
}
