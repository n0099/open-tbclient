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
    private p cxV;
    private v cxW;
    private com.baidu.tbadk.img.e cxY;
    private int aXk = 0;
    private boolean cxX = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cxY = new com.baidu.tbadk.img.e(getPageContext().getPageActivity());
        initView();
        initData(bundle);
        arB();
        jk(0);
        arC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.cxV.getWriteImagesInfo().toJsonString());
    }

    private void initData(Bundle bundle) {
        this.cxV = new p();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.cxV.setWriteImagesInfo(writeImagesInfo);
            this.cxV.jY(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.cxV.setWriteImagesInfo(writeImagesInfo2);
            this.cxV.jY(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
        }
    }

    private void initView() {
        this.cxW = new v(this);
        this.cxW.arV();
    }

    private void arB() {
        if (this.cxW != null && this.cxV != null) {
            this.cxW.jp(this.cxV.getMaxImagesAllowed());
            if (this.cxV.arO() != null) {
                for (ImageFileInfo imageFileInfo : this.cxV.arO()) {
                    this.cxW.f(imageFileInfo);
                }
            }
            arG();
        }
    }

    private void arC() {
        int size = this.cxV.size();
        this.cxW.k(size != 0, getPageContext().getPageActivity().getString(com.baidu.tieba.t.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.cxW.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cxW.arW()) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cxV.getWriteImagesInfo().toJsonString());
            setResult(-1, intent);
            finish();
        } else if (view == this.cxW.arX()) {
            if (this.cxV != null) {
                this.cxV.setLastAlbumId(null);
            }
            arF();
        } else if (view == this.cxW.arY()) {
            jk(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p arD() {
        return this.cxV;
    }

    public com.baidu.tbadk.img.e arE() {
        return this.cxY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jk(int i) {
        if (!this.cxX) {
            if (i == 0) {
                setSwipeBackEnabled(true);
            } else {
                setSwipeBackEnabled(false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.cxW.jr(this.aXk));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.cxY.At();
            }
            this.aXk = i;
            if (this.cxW != null) {
                this.cxW.js(this.aXk);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.cxW.jr(i)) != null) {
                beginTransaction.show(this.cxW.jq(i));
            } else {
                beginTransaction.add(com.baidu.tieba.q.fragment, this.cxW.jq(i), this.cxW.jr(i));
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
        int maxImagesAllowed = this.cxV.getMaxImagesAllowed();
        if (this.cxV.size() < maxImagesAllowed) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.cxV.addChooseFile(imageFileInfo2);
            arC();
            arG();
            this.cxW.f(imageFileInfo2);
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
        this.cxV.delChooseFile(imageFileInfo);
        arC();
        arG();
        this.cxW.g(imageFileInfo);
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aXk == 0) {
                if (this.cxV != null) {
                    this.cxV.setLastAlbumId(null);
                }
                arF();
                return true;
            } else if (this.aXk == 1) {
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
        if (this.cxW != null && (jq = this.cxW.jq(0)) != null && (jq instanceof aj)) {
            ((aj) jq).t(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImageFileInfo imageFileInfo, boolean z) {
        Fragment jq;
        if (this.cxW != null && (jq = this.cxW.jq(0)) != null && (jq instanceof aj)) {
            ((aj) jq).e(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment jq;
        if (this.cxW != null && (jq = this.cxW.jq(1)) != null && (jq instanceof b)) {
            ((b) jq).e(imageFileInfo, z);
        }
    }

    private void arF() {
        Intent intent = new Intent();
        String lastAlbumId = this.cxV.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        setResult(0, intent);
        finish();
    }

    private void arG() {
        if (this.cxV != null && this.cxW != null) {
            if (this.cxV.size() == this.cxV.getMaxImagesAllowed()) {
                this.cxW.fy(false);
            } else {
                this.cxW.fy(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cxV.getWriteImagesInfo().toJsonString());
            intent2.putExtra(AlbumActivityConfig.CAMERA_RESULT, true);
            intent2.putExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME, this.cxV.arT());
            setResult(-1, intent2);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cxX = true;
        if (this.cxW != null) {
            this.cxW.onDestroy();
        }
        this.cxY.At();
        q.arU().destory();
    }
}
