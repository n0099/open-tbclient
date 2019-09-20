package com.baidu.tieba.write.album;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.e.a.a;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0049a {
    private boolean fAf;
    private com.baidu.tieba.c.d hWb;
    private c jQj;
    private com.baidu.tieba.write.album.a jQk;
    private e jQm;
    private Intent jQq;
    private i jQt;
    private int mCurrentPage = 0;
    private boolean jQl = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int jQn = 0;
    private int jQo = 0;
    private boolean jQp = false;
    private boolean jQr = false;
    private int jQs = 0;
    private View fyx = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.fyx = findViewById(R.id.statebar_view);
        this.fAf = UtilHelper.canUseStyleImmersiveSticky();
        aKG();
        initData(bundle);
        this.jQk = new com.baidu.tieba.write.album.a(this);
        this.jQk.buo();
        CW(0);
    }

    public void showTip(View view) {
        if (this.hWb == null && view != null) {
            this.hWb = new com.baidu.tieba.c.d(getPageContext(), view);
            this.hWb.qf(R.drawable.bg_tip_blue_up_left);
            this.hWb.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.hWb.bcf();
                }
            });
            this.hWb.qe(16);
            this.hWb.qg(5000);
        }
        if (this.hWb != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.hWb.cJ(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void aKG() {
        if (this.fyx != null) {
            if (this.fAf && this.fyx.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fyx.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.fyx.setLayoutParams(layoutParams);
                kq(true);
                return;
            }
            kq(false);
        }
    }

    private void kq(boolean z) {
        if (this.fyx != null) {
            if (this.fAf && z && this.fyx.getVisibility() != 0) {
                this.fyx.setVisibility(0);
            } else if (!z && this.fyx.getVisibility() != 8) {
                this.fyx.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.jQj.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.jQp);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jQn);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jQo);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.jQr);
    }

    private void initData(Bundle bundle) {
        this.jQj = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.jQj.setWriteImagesInfo(writeImagesInfo);
            this.jQp = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.jQn = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.jQo = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.jQr = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.jQs = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.jQj.setWriteImagesInfo(writeImagesInfo2);
                this.jQj.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.jQp = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.jQn = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.jQo = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.jQr = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.jQs = intent.getIntExtra("from_type", 0);
            }
        }
        cAR();
    }

    private void cAR() {
        if (this.jQn == 2) {
            this.jQm = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
                @Override // com.baidu.tieba.write.album.e
                public boolean g(ImageFileInfo imageFileInfo) {
                    if (imageFileInfo != null) {
                        String filePath = imageFileInfo.getFilePath();
                        if (!StringUtils.isNULL(filePath)) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeFile(filePath, options);
                            int i = options.outWidth;
                            if (options.outHeight >= 200 && i >= 200) {
                                return true;
                            }
                        }
                    }
                    AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(R.string.uploade_attation), R.drawable.icon_toast_game_error);
                    return false;
                }
            };
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.jQk != null) {
            this.jQk.onChangeSkinType(i);
        }
        am.h(this.fyx, R.color.cp_bg_line_d, i);
    }

    public void cAS() {
        if (this.jQn == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.jQn == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.jQj != null) {
            if (this.jQt == null || !this.jQt.cBF()) {
                if (this.jQj.cBn()) {
                    VideoFileInfo cBl = this.jQj.cBl();
                    if (this.jQt == null) {
                        this.jQt = new i(this, this.forumName, this.forumId, "");
                        if (this.jQk != null) {
                            this.jQk.a(this.jQt);
                        }
                    }
                    if (getIntent() != null) {
                        this.jQt.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.jQt.a(cBl, this.callFrom);
                } else if (cAT()) {
                    cAU();
                } else {
                    aB(null);
                }
            }
        }
    }

    private boolean cAT() {
        if (this.jQj == null || v.Z(this.jQj.cBp()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.jQj.cBp()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void aB(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jQj.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jQn);
        intent2.putExtra("from_type", this.jQs);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    public void d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            Intent intent = new Intent();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageFileInfo);
            this.jQj.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jQj.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jQn);
            intent.putExtra("from_type", this.jQs);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean aRR() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.c.a aVar = new com.baidu.tbadk.core.util.c.a();
        aVar.ake();
        aVar.e(pageActivity, "android.permission.CAMERA");
        aVar.e(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.ad(pageActivity);
    }

    public void c(TbPageContext tbPageContext) {
        if (!aRR() && com.baidu.tieba.write.i.cAL()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.jQr ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.jQj.getWriteImagesInfo(), "", this.jQs)));
            TiebaStatic.log(new an("c12611").P("obj_locate", 5).P("obj_type", 2));
        }
    }

    private void cAU() {
        WriteImagesInfo writeImagesInfo;
        if (this.jQj != null && (writeImagesInfo = this.jQj.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, writeImagesInfo, cAV())));
        }
    }

    private int cAV() {
        if (this.jQj == null || v.Z(this.jQj.cBp()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.Z(this.jQj.cBp()); i++) {
            ImageFileInfo imageFileInfo = this.jQj.cBp().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void aC(Intent intent) {
        this.jQq = intent;
        if (intent == null || this.jQj == null) {
            aB(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.jQj.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            aB(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            aC(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jQk.cBd()) {
            cAS();
        } else if (view == this.jQk.cBf()) {
            cAS();
        } else if (view == this.jQk.cBc()) {
            if (this.jQj != null) {
                this.jQj.setLastAlbumId(null);
            }
            cBa();
        } else if (view == this.jQk.cBe()) {
            CW(0);
        } else if (view == this.jQk.cBg()) {
            CU(2);
        } else if (view == this.jQk.cBh()) {
            CU(1);
        }
    }

    private void CU(int i) {
        if (this.jQk != null && this.jQj != null) {
            this.jQj.setOriginalImg(!this.jQj.isOriginalImg());
            cAW();
            CV(i);
        }
    }

    private void CV(int i) {
        if (this.jQj != null && this.jQj.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").bT("fid", this.forumId).bT("obj_type", this.from).P("obj_locate", i));
        }
    }

    public void cAW() {
        if (this.jQj != null && this.jQk != null) {
            this.jQk.si(this.jQj.isOriginalImg());
        }
    }

    public View bnv() {
        return this.fyx;
    }

    public int cAX() {
        return this.jQo;
    }

    public c cAY() {
        return this.jQj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void CW(int i) {
        if (!this.jQl) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.jQk.CY(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.jQk.CY(i)) != null) {
                beginTransaction.show(this.jQk.CX(i));
            } else {
                beginTransaction.add(R.id.fragment, this.jQk.CX(i), this.jQk.CY(i));
            }
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.jQj.getMaxImagesAllowed();
        if (this.jQj.size() < maxImagesAllowed) {
            if (this.jQm == null || this.jQm.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.jQj.a(null);
                this.jQj.addChooseFile(imageFileInfo2);
                cAW();
                return true;
            }
            return false;
        } else if (cAZ()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean cAZ() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.jQj.getMaxImagesAllowed();
            if (this.jQj.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.jQj.cBp(), 0);
                    if (f(imageFileInfo)) {
                        f(imageFileInfo, false);
                        g(imageFileInfo, false);
                        return true;
                    }
                } catch (Exception e) {
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.jQj.a(null);
        this.jQj.delChooseFile(imageFileInfo);
        cAW();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.jQj != null) {
                    this.jQj.setLastAlbumId(null);
                }
                cBa();
                return true;
            } else if (this.mCurrentPage == 1) {
                CW(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment CX;
        if (this.jQk != null && (CX = this.jQk.CX(0)) != null && (CX instanceof ImageListFragment)) {
            ((ImageListFragment) CX).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment CX;
        if (this.jQk != null && (CX = this.jQk.CX(1)) != null && (CX instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) CX).h(imageFileInfo, z);
        }
    }

    private void cBa() {
        Intent intent = new Intent();
        String lastAlbumId = this.jQj.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jQn);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.jQk != null) {
            this.jQk.stopCamera();
        }
    }

    private void aZA() {
        if (this.jQk != null) {
            this.jQk.aZA();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jQl = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cBt().destory();
        if (this.fyx != null) {
            this.fyx.setBackgroundDrawable(null);
        }
        if (this.jQk != null) {
            this.jQk.onDestroy();
        }
        if (this.jQt != null) {
            this.jQt.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.jQj.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.jQn);
        intent.putExtra("from_type", this.jQs);
        if (this.jQq != null && !StringUtils.isNull(this.jQq.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.jQq.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.jQj.getWriteImagesInfo(), true);
            return AlbumActivity.this.jQj.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, str);
            AlbumActivity.this.setResult(-1, intent);
            AlbumActivity.this.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jQt != null) {
            this.jQt.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aZA();
        if (this.jQt != null) {
            this.jQt.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jQt != null) {
            this.jQt.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
