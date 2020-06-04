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
import com.baidu.h.a.a;
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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.write.j;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0125a {
    private boolean bdr;
    private com.baidu.tieba.c.d jSa;
    private Intent lSA;
    private i lSB;
    private FrsTabInfoData lSC;
    private c lSx;
    private com.baidu.tieba.write.album.a lSy;
    private e lSz;
    private int aIx = 0;
    private boolean bdk = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int requestFrom = 0;
    private int bdm = 0;
    private boolean bdn = false;
    private boolean bdo = false;
    private int bdp = 0;
    private View bdq = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.bdq = findViewById(R.id.statebar_view);
        this.bdr = UtilHelper.canUseStyleImmersiveSticky();
        Hc();
        initData(bundle);
        this.lSy = new com.baidu.tieba.write.album.a(this);
        this.lSy.Hp();
        dk(0);
    }

    public void showTip(View view) {
        if (this.jSa == null && view != null) {
            this.jSa = new com.baidu.tieba.c.d(getPageContext(), view);
            this.jSa.cI(R.drawable.bg_tip_blue_up_left);
            this.jSa.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.jSa.Gu();
                }
            });
            this.jSa.cH(16);
            this.jSa.cJ(5000);
        }
        if (this.jSa != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.jSa.aA(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void Hc() {
        if (this.bdq != null) {
            if (this.bdr && this.bdq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bdq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bdq.setLayoutParams(layoutParams);
                ch(true);
                return;
            }
            ch(false);
        }
    }

    private void ch(boolean z) {
        if (this.bdq != null) {
            if (this.bdr && z && this.bdq.getVisibility() != 0) {
                this.bdq.setVisibility(0);
            } else if (!z && this.bdq.getVisibility() != 8) {
                this.bdq.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.lSx.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.bdn);
        bundle.putInt("camera_request_from", this.requestFrom);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.bdm);
        bundle.putBoolean("from_write", this.bdo);
        bundle.putSerializable("tab_list", this.lSC);
    }

    private void initData(Bundle bundle) {
        this.lSx = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.lSx.setWriteImagesInfo(writeImagesInfo);
            this.bdn = bundle.getBoolean("use_original_img", false);
            this.requestFrom = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.bdm = bundle.getInt("album_thread");
            this.bdo = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.bdp = bundle.getInt("from_type");
            this.lSC = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.from = bundle.getString("from");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.lSx.setWriteImagesInfo(writeImagesInfo2);
                this.lSx.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.bdn = intent.getBooleanExtra("use_original_img", false);
                this.requestFrom = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.bdm = intent.getIntExtra("album_thread", 0);
                this.bdo = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.bdp = intent.getIntExtra("from_type", 0);
                this.lSC = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            }
        }
        Hd();
    }

    private void Hd() {
        if (this.requestFrom == 2) {
            this.lSz = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.lSy != null) {
            this.lSy.onChangeSkinType(i);
        }
        am.setBackgroundColor(this.bdq, R.color.cp_bg_line_d, i);
    }

    public void He() {
        if (this.requestFrom == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.requestFrom == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.lSx != null) {
            if (this.lSB == null || !this.lSB.dng()) {
                if (this.lSx.Hz()) {
                    VideoFileInfo dmY = this.lSx.dmY();
                    if (this.lSB == null) {
                        this.lSB = new i(this, this.forumName, this.forumId, "");
                        this.lSB.a(this.lSC);
                        if (this.lSy != null) {
                            this.lSy.a(this.lSB);
                        }
                    }
                    if (getIntent() != null) {
                        this.lSB.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.lSB.a(dmY, this.callFrom, this.from);
                } else if (dmU()) {
                    Hf();
                } else {
                    l(null);
                }
            }
        }
    }

    private boolean dmU() {
        if (this.lSx == null || v.getCount(this.lSx.HB()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.lSx.HB()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void l(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.lSx.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.requestFrom);
        intent2.putExtra("from_type", this.bdp);
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
            this.lSx.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.lSx.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.requestFrom);
            intent.putExtra("from_type", this.bdp);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean bCH() {
        Activity pageActivity = getPageContext().getPageActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(pageActivity);
    }

    public void d(TbPageContext tbPageContext) {
        if (!bCH() && j.dmM()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.bdo ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.lSx.getWriteImagesInfo(), "", this.bdp)));
            TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).ag("obj_locate", 5).ag("obj_type", 2));
        }
    }

    private void Hf() {
        WriteImagesInfo writeImagesInfo;
        if (this.lSx != null && (writeImagesInfo = this.lSx.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, dmV())));
        }
    }

    private int dmV() {
        if (this.lSx == null || v.getCount(this.lSx.HB()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.getCount(this.lSx.HB()); i++) {
            ImageFileInfo imageFileInfo = this.lSx.HB().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void m(Intent intent) {
        this.lSA = intent;
        if (intent == null || this.lSx == null) {
            l(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.lSx.getWriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            l(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            m(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lSy.Hr()) {
            He();
        } else if (view == this.lSy.Ht()) {
            He();
        } else if (view == this.lSy.Hq()) {
            if (this.lSx != null) {
                this.lSx.setLastAlbumId(null);
            }
            Hl();
        } else if (view == this.lSy.Hs()) {
            dk(0);
        } else if (view == this.lSy.Hu()) {
            di(2);
        } else if (view == this.lSy.Hv()) {
            di(1);
        }
    }

    private void di(int i) {
        if (this.lSy != null && this.lSx != null) {
            this.lSx.setOriginalImg(!this.lSx.isOriginalImg());
            Hg();
            dj(i);
        }
    }

    private void dj(int i) {
        if (this.lSx != null && this.lSx.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").dh("fid", this.forumId).dh("obj_type", this.from).ag("obj_locate", i));
        }
    }

    public void Hg() {
        if (this.lSx != null && this.lSy != null) {
            this.lSy.ci(this.lSx.isOriginalImg());
        }
    }

    public View Hh() {
        return this.bdq;
    }

    public int Hi() {
        return this.bdm;
    }

    public c dmW() {
        return this.lSx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dk(int i) {
        if (!this.bdk) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.lSy.FB(this.aIx));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.aIx = i;
            if (getSupportFragmentManager().findFragmentByTag(this.lSy.FB(i)) != null) {
                beginTransaction.show(this.lSy.FA(i));
            } else {
                beginTransaction.add(R.id.fragment, this.lSy.FA(i), this.lSy.FB(i));
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
        int maxImagesAllowed = this.lSx.getMaxImagesAllowed();
        if (this.lSx.size() < maxImagesAllowed) {
            if (this.lSz == null || this.lSz.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.lSx.a(null);
                this.lSx.addChooseFile(imageFileInfo2);
                Hg();
                return true;
            }
            return false;
        } else if (Hk()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean Hk() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.lSx.getMaxImagesAllowed();
            if (this.lSx.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.lSx.HB(), 0);
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
        this.lSx.a(null);
        this.lSx.delChooseFile(imageFileInfo);
        Hg();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.aIx == 0) {
                if (this.lSx != null) {
                    this.lSx.setLastAlbumId(null);
                }
                Hl();
                return true;
            } else if (this.aIx == 1) {
                dk(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment FA;
        if (this.lSy != null && (FA = this.lSy.FA(0)) != null && (FA instanceof ImageListFragment)) {
            ((ImageListFragment) FA).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment FA;
        if (this.lSy != null && (FA = this.lSy.FA(1)) != null && (FA instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) FA).h(imageFileInfo, z);
        }
    }

    private void Hl() {
        Intent intent = new Intent();
        String lastAlbumId = this.lSx.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.requestFrom);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.lSy != null) {
            this.lSy.stopCamera();
        }
    }

    private void PI() {
        if (this.lSy != null) {
            this.lSy.PI();
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
        this.bdk = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.dmZ().destory();
        if (this.bdq != null) {
            this.bdq.setBackgroundDrawable(null);
        }
        if (this.lSy != null) {
            this.lSy.onDestroy();
        }
        if (this.lSB != null) {
            this.lSB.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.lSx.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.requestFrom);
        intent.putExtra("from_type", this.bdp);
        if (this.lSA != null && !StringUtils.isNull(this.lSA.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.lSA.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.lSx.getWriteImagesInfo(), true);
            return AlbumActivity.this.lSx.getWriteImagesInfo().toJsonString();
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
        if (this.lSB != null) {
            this.lSB.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PI();
        if (this.lSB != null) {
            this.lSB.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.lSB != null) {
            this.lSB.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
