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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
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
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0055a {
    private boolean apD;
    private com.baidu.tieba.c.d hUJ;
    private i jOA;
    private c jOw;
    private com.baidu.tieba.write.album.a jOx;
    private e jOy;
    private Intent jOz;
    private int ZN = 0;
    private boolean apv = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int apx = 0;
    private int apy = 0;
    private boolean apz = false;
    private boolean apA = false;
    private int apB = 0;
    private View apC = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.apC = findViewById(R.id.statebar_view);
        this.apD = UtilHelper.canUseStyleImmersiveSticky();
        vz();
        initData(bundle);
        this.jOx = new com.baidu.tieba.write.album.a(this);
        this.jOx.vJ();
        cd(0);
    }

    public void showTip(View view) {
        if (this.hUJ == null && view != null) {
            this.hUJ = new com.baidu.tieba.c.d(getPageContext(), view);
            this.hUJ.bB(R.drawable.bg_tip_blue_up_left);
            this.hUJ.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.hUJ.uP();
                }
            });
            this.hUJ.bA(16);
            this.hUJ.bC(5000);
        }
        if (this.hUJ != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.hUJ.R(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void vz() {
        if (this.apC != null) {
            if (this.apD && this.apC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.apC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.apC.setLayoutParams(layoutParams);
                aP(true);
                return;
            }
            aP(false);
        }
    }

    private void aP(boolean z) {
        if (this.apC != null) {
            if (this.apD && z && this.apC.getVisibility() != 0) {
                this.apC.setVisibility(0);
            } else if (!z && this.apC.getVisibility() != 8) {
                this.apC.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.jOw.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.apz);
        bundle.putInt("camera_request_from", this.apx);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.apy);
        bundle.putBoolean("from_write", this.apA);
    }

    private void initData(Bundle bundle) {
        this.jOw = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.jOw.setWriteImagesInfo(writeImagesInfo);
            this.apz = bundle.getBoolean("use_original_img", false);
            this.apx = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.apy = bundle.getInt("album_thread");
            this.apA = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.apB = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.jOw.setWriteImagesInfo(writeImagesInfo2);
                this.jOw.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.apz = intent.getBooleanExtra("use_original_img", false);
                this.apx = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.apy = intent.getIntExtra("album_thread", 0);
                this.apA = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.apB = intent.getIntExtra("from_type", 0);
            }
        }
        vA();
    }

    private void vA() {
        if (this.apx == 2) {
            this.jOy = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.jOx != null) {
            this.jOx.onChangeSkinType(i);
        }
        am.setBackgroundColor(this.apC, R.color.cp_bg_line_d, i);
    }

    public void vB() {
        if (this.apx == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.apx == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.jOw != null) {
            if (this.jOA == null || !this.jOA.cyp()) {
                if (this.jOw.vW()) {
                    VideoFileInfo cyh = this.jOw.cyh();
                    if (this.jOA == null) {
                        this.jOA = new i(this, this.forumName, this.forumId, "");
                        if (this.jOx != null) {
                            this.jOx.a(this.jOA);
                        }
                    }
                    if (getIntent() != null) {
                        this.jOA.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.jOA.a(cyh, this.callFrom);
                } else if (cyd()) {
                    vC();
                } else {
                    z(null);
                }
            }
        }
    }

    private boolean cyd() {
        if (this.jOw == null || v.getCount(this.jOw.vY()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.jOw.vY()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void z(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.jOw.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.apx);
        intent2.putExtra("from_type", this.apB);
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
            this.jOw.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.jOw.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.apx);
            intent.putExtra("from_type", this.apB);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean aST() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.c.a aVar = new com.baidu.tbadk.core.util.c.a();
        aVar.clearRequestPermissionList();
        aVar.appendRequestPermission(pageActivity, "android.permission.CAMERA");
        aVar.appendRequestPermission(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.startRequestPermission(pageActivity);
    }

    public void c(TbPageContext tbPageContext) {
        if (!aST() && com.baidu.tieba.write.i.cxW()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.apA ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.jOw.getWriteImagesInfo(), "", this.apB)));
            TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).O("obj_locate", 5).O("obj_type", 2));
        }
    }

    private void vC() {
        WriteImagesInfo writeImagesInfo;
        if (this.jOw != null && (writeImagesInfo = this.jOw.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, cye())));
        }
    }

    private int cye() {
        if (this.jOw == null || v.getCount(this.jOw.vY()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.getCount(this.jOw.vY()); i++) {
            ImageFileInfo imageFileInfo = this.jOw.vY().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void A(Intent intent) {
        this.jOz = intent;
        if (intent == null || this.jOw == null) {
            z(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.jOw.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            z(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            A(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jOx.vL()) {
            vB();
        } else if (view == this.jOx.vN()) {
            vB();
        } else if (view == this.jOx.vK()) {
            if (this.jOw != null) {
                this.jOw.setLastAlbumId(null);
            }
            vI();
        } else if (view == this.jOx.vM()) {
            cd(0);
        } else if (view == this.jOx.vO()) {
            cb(2);
        } else if (view == this.jOx.vP()) {
            cb(1);
        }
    }

    private void cb(int i) {
        if (this.jOx != null && this.jOw != null) {
            this.jOw.setOriginalImg(!this.jOw.isOriginalImg());
            vD();
            cc(i);
        }
    }

    private void cc(int i) {
        if (this.jOw != null && this.jOw.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").bS("fid", this.forumId).bS("obj_type", this.from).O("obj_locate", i));
        }
    }

    public void vD() {
        if (this.jOw != null && this.jOx != null) {
            this.jOx.aQ(this.jOw.isOriginalImg());
        }
    }

    public View vE() {
        return this.apC;
    }

    public int vF() {
        return this.apy;
    }

    public c cyf() {
        return this.jOw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cd(int i) {
        if (!this.apv) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.jOx.cf(this.ZN));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.ZN = i;
            if (getSupportFragmentManager().findFragmentByTag(this.jOx.cf(i)) != null) {
                beginTransaction.show(this.jOx.ce(i));
            } else {
                beginTransaction.add(R.id.fragment, this.jOx.ce(i), this.jOx.cf(i));
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
        int maxImagesAllowed = this.jOw.getMaxImagesAllowed();
        if (this.jOw.size() < maxImagesAllowed) {
            if (this.jOy == null || this.jOy.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.jOw.a(null);
                this.jOw.addChooseFile(imageFileInfo2);
                vD();
                return true;
            }
            return false;
        } else if (vH()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean vH() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.jOw.getMaxImagesAllowed();
            if (this.jOw.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.jOw.vY(), 0);
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
        this.jOw.a(null);
        this.jOw.delChooseFile(imageFileInfo);
        vD();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.ZN == 0) {
                if (this.jOw != null) {
                    this.jOw.setLastAlbumId(null);
                }
                vI();
                return true;
            } else if (this.ZN == 1) {
                cd(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ce;
        if (this.jOx != null && (ce = this.jOx.ce(0)) != null && (ce instanceof ImageListFragment)) {
            ((ImageListFragment) ce).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ce;
        if (this.jOx != null && (ce = this.jOx.ce(1)) != null && (ce instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) ce).h(imageFileInfo, z);
        }
    }

    private void vI() {
        Intent intent = new Intent();
        String lastAlbumId = this.jOw.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.apx);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.jOx != null) {
            this.jOx.stopCamera();
        }
    }

    private void aZD() {
        if (this.jOx != null) {
            this.jOx.aZD();
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
        this.apv = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cyi().destory();
        if (this.apC != null) {
            this.apC.setBackgroundDrawable(null);
        }
        if (this.jOx != null) {
            this.jOx.onDestroy();
        }
        if (this.jOA != null) {
            this.jOA.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.jOw.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.apx);
        intent.putExtra("from_type", this.apB);
        if (this.jOz != null && !StringUtils.isNull(this.jOz.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.jOz.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.jOw.getWriteImagesInfo(), true);
            return AlbumActivity.this.jOw.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra("album_result", str);
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
        if (this.jOA != null) {
            this.jOA.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aZD();
        if (this.jOA != null) {
            this.jOA.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jOA != null) {
            this.jOA.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
