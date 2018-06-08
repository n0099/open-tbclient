package com.baidu.tieba.write.album;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.d.a.a;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0061a {
    private boolean dkJ;
    private com.baidu.tieba.c.d fzU;
    private c hoj;
    private com.baidu.tieba.write.album.a hok;
    private e hom;
    private i hos;
    private int mCurrentPage = 0;
    private boolean hol = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int hon = 0;
    private int hoo = 0;
    private boolean hop = false;
    private boolean hoq = false;
    private int hor = 0;
    private View djC = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.i.album_activity);
        this.djC = findViewById(d.g.statebar_view);
        this.dkJ = UtilHelper.canUseStyleImmersiveSticky();
        Ty();
        initData(bundle);
        this.hok = new com.baidu.tieba.write.album.a(this);
        this.hok.aYL();
        vf(0);
    }

    public void showTip(View view) {
        if (this.fzU == null && view != null) {
            this.fzU = new com.baidu.tieba.c.d(getPageContext(), view);
            this.fzU.jf(d.f.bg_tip_blue_up_left);
            this.fzU.j(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.fzU.akT();
                }
            });
            this.fzU.je(16);
            this.fzU.jg(5000);
        }
        if (this.fzU != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_take_photo_tip");
            this.fzU.aQ(getString(d.k.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Ty() {
        if (this.djC != null) {
            if (this.dkJ && this.djC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.djC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.djC.setLayoutParams(layoutParams);
                fJ(true);
                return;
            }
            fJ(false);
        }
    }

    private void fJ(boolean z) {
        if (this.djC != null) {
            if (this.dkJ && z && this.djC.getVisibility() != 0) {
                this.djC.setVisibility(0);
            } else if (!z && this.djC.getVisibility() != 8) {
                this.djC.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.hoj.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.hop);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hon);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hoo);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.hoq);
    }

    private void initData(Bundle bundle) {
        this.hoj = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.hoj.setWriteImagesInfo(writeImagesInfo);
            this.hop = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.hon = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.hoo = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.hoq = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.hor = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.hoj.setWriteImagesInfo(writeImagesInfo2);
                this.hoj.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.hop = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.hon = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.hoo = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.hoq = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.hor = intent.getIntExtra("from_type", 0);
            }
        }
        bGo();
    }

    private void bGo() {
        if (this.hon == 2) {
            this.hom = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
                @Override // com.baidu.tieba.write.album.e
                public boolean e(ImageFileInfo imageFileInfo) {
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
                    AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(d.k.uploade_attation), d.f.icon_toast_game_error);
                    return false;
                }
            };
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.hok != null) {
            this.hok.onChangeSkinType(i);
        }
        al.e(this.djC, d.C0141d.cp_bg_line_d, i);
    }

    public void bGp() {
        if (this.hon == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.hon == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.hoj != null) {
            if (this.hos == null || !this.hos.bHc()) {
                if (this.hoj.bGJ()) {
                    VideoFileInfo bGH = this.hoj.bGH();
                    if (this.hos == null) {
                        this.hos = new i(this, this.forumName, this.forumId, "");
                        if (this.hok != null) {
                            this.hok.a(this.hos);
                        }
                    }
                    this.hos.a(bGH, this.callFrom);
                } else if (w.y(this.hoj.bGL()) == 1 && this.hor == 0) {
                    bGq();
                } else {
                    ab(null);
                }
            }
        }
    }

    private void ab(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.hoj.getWriteImagesInfo().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hon);
        intent2.putExtra("from_type", this.hor);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        setResult(-1, intent2);
        finish();
    }

    private boolean aaO() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.zU();
        aVar.c(pageActivity, "android.permission.CAMERA");
        aVar.c(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.u(pageActivity);
    }

    public void b(TbPageContext tbPageContext) {
        if (!aaO() && com.baidu.tieba.write.e.bGi()) {
            sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.hoq ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.hoj.getWriteImagesInfo(), "", this.hor)));
            TiebaStatic.log(new am("c12611").r("obj_locate", 5).r("obj_type", 2));
        }
    }

    private void bGq() {
        WriteImagesInfo writeImagesInfo;
        if (this.hoj != null && (writeImagesInfo = this.hoj.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, writeImagesInfo, 0)));
        }
    }

    private void ac(Intent intent) {
        if (intent == null || this.hoj == null) {
            ab(null);
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.hoj.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            ab(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            ac(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hok.bGz()) {
            bGp();
        } else if (view == this.hok.bGB()) {
            bGp();
        } else if (view == this.hok.bGy()) {
            if (this.hoj != null) {
                this.hoj.setLastAlbumId(null);
            }
            bGv();
        } else if (view == this.hok.bGA()) {
            vf(0);
        } else if (view == this.hok.bGC()) {
            vd(2);
        } else if (view == this.hok.bGD()) {
            vd(1);
        }
    }

    private void vd(int i) {
        if (this.hok != null && this.hoj != null) {
            this.hoj.setOriginalImg(!this.hoj.isOriginalImg());
            bGr();
            ve(i);
        }
    }

    private void ve(int i) {
        if (this.hoj != null && this.hoj.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new am("c10349").ah(ImageViewerConfig.FORUM_ID, this.forumId).ah("obj_type", this.from).r("obj_locate", i));
        }
    }

    public void bGr() {
        if (this.hoj != null && this.hok != null) {
            this.hok.nw(this.hoj.isOriginalImg());
        }
    }

    public View atU() {
        return this.djC;
    }

    public int bGs() {
        return this.hoo;
    }

    public c bGt() {
        return this.hoj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vf(int i) {
        if (!this.hol) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.hok.vh(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.hok.vh(i)) != null) {
                beginTransaction.show(this.hok.vg(i));
            } else {
                beginTransaction.add(d.g.fragment, this.hok.vg(i), this.hok.vh(i));
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
        int maxImagesAllowed = this.hoj.getMaxImagesAllowed();
        if (this.hoj.size() < maxImagesAllowed) {
            if (this.hom == null || this.hom.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.hoj.a(null);
                this.hoj.addChooseFile(imageFileInfo2);
                bGr();
                return true;
            }
            return false;
        } else if (bGu()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.k.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bGu() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.hoj.getMaxImagesAllowed();
            if (this.hoj.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) w.c(this.hoj.bGL(), 0);
                    if (d(imageFileInfo)) {
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
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.hoj.a(null);
        this.hoj.delChooseFile(imageFileInfo);
        bGr();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.mCurrentPage == 0) {
                if (this.hoj != null) {
                    this.hoj.setLastAlbumId(null);
                }
                bGv();
                return true;
            } else if (this.mCurrentPage == 1) {
                vf(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vg;
        if (this.hok != null && (vg = this.hok.vg(0)) != null && (vg instanceof ImageListFragment)) {
            ((ImageListFragment) vg).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vg;
        if (this.hok != null && (vg = this.hok.vg(1)) != null && (vg instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) vg).h(imageFileInfo, z);
        }
    }

    private void bGv() {
        Intent intent = new Intent();
        String lastAlbumId = this.hoj.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.hon);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.hok != null) {
            this.hok.stopCamera();
        }
    }

    private void bGw() {
        if (this.hok != null) {
            this.hok.bGw();
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
        this.hol = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.bGP().destory();
        if (this.djC != null) {
            this.djC.setBackgroundDrawable(null);
        }
        if (this.hok != null) {
            this.hok.onDestroy();
        }
        if (this.hos != null) {
            this.hos.onDestroy();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (!ac.aN(getApplicationContext())) {
                showToast(d.k.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.hoj.getWriteImagesInfo(), true);
            return AlbumActivity.this.hoj.getWriteImagesInfo().toJsonString();
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
        if (this.hos != null) {
            this.hos.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        bGw();
        if (this.hos != null) {
            this.hos.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hos != null) {
            this.hos.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
