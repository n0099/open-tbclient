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
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener {
    private m cPJ;
    private r cPK;
    private com.baidu.tbadk.img.b cPM;
    private int aZY = 0;
    private boolean cPL = false;
    private int cPN = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cPM = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        aty();
        ke(0);
        atz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.cPJ.getWriteImagesInfo().toJsonString());
    }

    private void initData(Bundle bundle) {
        this.cPJ = new m();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.cPJ.setWriteImagesInfo(writeImagesInfo);
            this.cPJ.kY(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.cPJ.setWriteImagesInfo(writeImagesInfo2);
            this.cPJ.kY(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.cPN = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
        }
    }

    private void initView() {
        this.cPK = new r(this);
        this.cPK.atS();
    }

    private void aty() {
        if (this.cPK != null && this.cPJ != null) {
            this.cPK.kk(this.cPJ.getMaxImagesAllowed());
            if (this.cPJ.atL() != null) {
                for (ImageFileInfo imageFileInfo : this.cPJ.atL()) {
                    this.cPK.f(imageFileInfo);
                }
            }
            atD();
        }
    }

    private void atz() {
        int size = this.cPJ.size();
        this.cPK.k(size != 0, getPageContext().getPageActivity().getString(i.C0057i.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.cPK.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cPK.atT()) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cPJ.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.cPN);
            setResult(-1, intent);
            finish();
        } else if (view == this.cPK.atU()) {
            if (this.cPJ != null) {
                this.cPJ.setLastAlbumId(null);
            }
            atC();
        } else if (view == this.cPK.atV()) {
            ke(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m atA() {
        return this.cPJ;
    }

    public com.baidu.tbadk.img.b atB() {
        return this.cPM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ke(int i) {
        if (!this.cPL) {
            if (i == 0) {
                setSwipeBackEnabled(true);
            } else {
                setSwipeBackEnabled(false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.cPK.km(this.aZY));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.cPM.Cl();
            }
            this.aZY = i;
            if (this.cPK != null) {
                this.cPK.kn(this.aZY);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.cPK.km(i)) != null) {
                beginTransaction.show(this.cPK.kl(i));
            } else {
                beginTransaction.add(i.f.fragment, this.cPK.kl(i), this.cPK.km(i));
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
        int maxImagesAllowed = this.cPJ.getMaxImagesAllowed();
        if (this.cPJ.size() < maxImagesAllowed) {
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            this.cPJ.addChooseFile(imageFileInfo2);
            atz();
            atD();
            this.cPK.f(imageFileInfo2);
            return true;
        }
        showToast(String.format(getPageContext().getContext().getString(i.C0057i.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.cPJ.delChooseFile(imageFileInfo);
        atz();
        atD();
        this.cPK.g(imageFileInfo);
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aZY == 0) {
                if (this.cPJ != null) {
                    this.cPJ.setLastAlbumId(null);
                }
                atC();
                return true;
            } else if (this.aZY == 1) {
                ke(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i, boolean z) {
        Fragment kl;
        if (this.cPK != null && (kl = this.cPK.kl(0)) != null && (kl instanceof ad)) {
            ((ad) kl).r(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ImageFileInfo imageFileInfo, boolean z) {
        Fragment kl;
        if (this.cPK != null && (kl = this.cPK.kl(0)) != null && (kl instanceof ad)) {
            ((ad) kl).e(imageFileInfo, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImageFileInfo imageFileInfo, boolean z) {
        Fragment kl;
        if (this.cPK != null && (kl = this.cPK.kl(1)) != null && (kl instanceof c)) {
            ((c) kl).e(imageFileInfo, z);
        }
    }

    private void atC() {
        Intent intent = new Intent();
        String lastAlbumId = this.cPJ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.cPN);
        setResult(0, intent);
        finish();
    }

    private void atD() {
        if (this.cPJ != null && this.cPK != null) {
            if (this.cPJ.size() == this.cPJ.getMaxImagesAllowed()) {
                this.cPK.fT(false);
            } else {
                this.cPK.fT(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.cPJ.getWriteImagesInfo().toJsonString());
            intent2.putExtra(AlbumActivityConfig.CAMERA_RESULT, true);
            intent2.putExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME, this.cPJ.atQ());
            intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.cPN);
            setResult(-1, intent2);
            com.baidu.adp.lib.g.h.hi().postDelayed(new a(this), 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cPL = true;
        if (this.cPK != null) {
            this.cPK.onDestroy();
        }
        this.cPM.Cl();
        n.atR().destory();
    }
}
