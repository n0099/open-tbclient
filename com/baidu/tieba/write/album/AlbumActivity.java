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
import com.baidu.tieba.i;
import com.baidu.tieba.write.write.WriteActivity;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener {
    private m cYt;
    private r cYu;
    private com.baidu.tbadk.img.b cYw;
    private int bat = 0;
    private boolean cYv = false;
    private int cYx = 0;
    private String from = "";
    private boolean cYy = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cYw = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        axR();
        kP(0);
        axS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.cYt.getWriteImagesInfo().toJsonString());
    }

    private void initData(Bundle bundle) {
        this.cYt = new m();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.cYt.setWriteImagesInfo(writeImagesInfo);
            this.cYt.lF(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.cYt.setWriteImagesInfo(writeImagesInfo2);
            this.cYt.lF(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.cYx = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            if (WriteActivity.ddK.equals(this.from)) {
                this.cYy = true;
            } else {
                this.cYy = false;
            }
        }
    }

    private void initView() {
        this.cYu = new r(this);
        this.cYu.ayl();
    }

    private void axR() {
        if (this.cYu != null && this.cYt != null) {
            this.cYu.kV(this.cYt.getMaxImagesAllowed());
            if (this.cYt.aye() != null) {
                for (ImageFileInfo imageFileInfo : this.cYt.aye()) {
                    this.cYu.f(imageFileInfo);
                }
            }
            axW();
        }
    }

    private void axS() {
        int size = this.cYt.size();
        this.cYu.n(size != 0, getPageContext().getPageActivity().getString(this.cYy ? i.h.live_album_finish_btn : i.h.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.cYu.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cYu.aym()) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cYt.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.cYx);
            setResult(-1, intent);
            finish();
        } else if (view == this.cYu.ayn()) {
            if (this.cYt != null) {
                this.cYt.setLastAlbumId(null);
            }
            axV();
        } else if (view == this.cYu.ayo()) {
            kP(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m axT() {
        return this.cYt;
    }

    public com.baidu.tbadk.img.b axU() {
        return this.cYw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kP(int i) {
        if (!this.cYv) {
            if (i == 0) {
                setSwipeBackEnabled(true);
            } else {
                setSwipeBackEnabled(false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.cYu.kX(this.bat));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.cYw.Cz();
            }
            this.bat = i;
            if (this.cYu != null) {
                this.cYu.kY(this.bat);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.cYu.kX(i)) != null) {
                beginTransaction.show(this.cYu.kW(i));
            } else {
                beginTransaction.add(i.f.fragment, this.cYu.kW(i), this.cYu.kX(i));
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
        int maxImagesAllowed = this.cYt.getMaxImagesAllowed();
        if (this.cYt.size() < maxImagesAllowed) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.cYt.addChooseFile(imageFileInfo2);
            axS();
            axW();
            this.cYu.f(imageFileInfo2);
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
        this.cYt.delChooseFile(imageFileInfo);
        axS();
        axW();
        this.cYu.g(imageFileInfo);
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bat == 0) {
                if (this.cYt != null) {
                    this.cYt.setLastAlbumId(null);
                }
                axV();
                return true;
            } else if (this.bat == 1) {
                kP(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i, boolean z) {
        Fragment kW;
        if (this.cYu != null && (kW = this.cYu.kW(0)) != null && (kW instanceof ad)) {
            ((ad) kW).s(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImageFileInfo imageFileInfo, boolean z) {
        Fragment kW;
        if (this.cYu != null && (kW = this.cYu.kW(0)) != null && (kW instanceof ad)) {
            ((ad) kW).e(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment kW;
        if (this.cYu != null && (kW = this.cYu.kW(1)) != null && (kW instanceof c)) {
            ((c) kW).e(imageFileInfo, z);
        }
    }

    private void axV() {
        Intent intent = new Intent();
        String lastAlbumId = this.cYt.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.cYx);
        setResult(0, intent);
        finish();
    }

    private void axW() {
        if (this.cYt != null && this.cYu != null) {
            if (this.cYt.size() == this.cYt.getMaxImagesAllowed()) {
                this.cYu.gE(false);
            } else {
                this.cYu.gE(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cYt.getWriteImagesInfo().toJsonString());
            intent2.putExtra(AlbumActivityConfig.CAMERA_RESULT, true);
            intent2.putExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME, this.cYt.ayj());
            intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.cYx);
            setResult(-1, intent2);
            com.baidu.adp.lib.g.h.hf().postDelayed(new a(this), 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cYv = true;
        if (this.cYu != null) {
            this.cYu.onDestroy();
        }
        this.cYw.Cz();
        n.ayk().destory();
    }
}
