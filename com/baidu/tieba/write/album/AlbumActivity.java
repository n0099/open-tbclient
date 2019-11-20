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
    private boolean apk;
    private com.baidu.tieba.c.d hTS;
    private c jNF;
    private com.baidu.tieba.write.album.a jNG;
    private e jNH;
    private Intent jNI;
    private i jNJ;
    private int Zv = 0;
    private boolean apc = false;
    private String callFrom = "";
    private String from = "";
    private String forumName = "";
    private String forumId = "0";
    private int ape = 0;
    private int apf = 0;
    private boolean apg = false;
    private boolean aph = false;
    private int api = 0;
    private View apj = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.album_activity);
        this.apj = findViewById(R.id.statebar_view);
        this.apk = UtilHelper.canUseStyleImmersiveSticky();
        vA();
        initData(bundle);
        this.jNG = new com.baidu.tieba.write.album.a(this);
        this.jNG.vK();
        cd(0);
    }

    public void showTip(View view) {
        if (this.hTS == null && view != null) {
            this.hTS = new com.baidu.tieba.c.d(getPageContext(), view);
            this.hTS.bB(R.drawable.bg_tip_blue_up_left);
            this.hTS.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.hTS.uQ();
                }
            });
            this.hTS.bA(16);
            this.hTS.bC(5000);
        }
        if (this.hTS != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.hTS.R(getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private void vA() {
        if (this.apj != null) {
            if (this.apk && this.apj.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.apj.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.apj.setLayoutParams(layoutParams);
                aP(true);
                return;
            }
            aP(false);
        }
    }

    private void aP(boolean z) {
        if (this.apj != null) {
            if (this.apk && z && this.apj.getVisibility() != 0) {
                this.apj.setVisibility(0);
            } else if (!z && this.apj.getVisibility() != 8) {
                this.apj.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("write_images_info", this.jNF.getWriteImagesInfo().toJsonString());
        bundle.putBoolean("use_original_img", this.apg);
        bundle.putInt("camera_request_from", this.ape);
        bundle.putString("forum_id", this.forumId);
        bundle.putString("forum_name", this.forumName);
        bundle.putInt("album_thread", this.apf);
        bundle.putBoolean("from_write", this.aph);
    }

    private void initData(Bundle bundle) {
        this.jNF = new c(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString("write_images_info"));
            this.jNF.setWriteImagesInfo(writeImagesInfo);
            this.apg = bundle.getBoolean("use_original_img", false);
            this.ape = bundle.getInt("camera_request_from", 0);
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
            this.apf = bundle.getInt("album_thread");
            this.aph = bundle.getBoolean("from_write");
            this.callFrom = bundle.getString("KEY_CALL_FROM");
            this.api = bundle.getInt("from_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
                writeImagesInfo2.parseJson(intent.getStringExtra("write_images_info"));
                this.jNF.setWriteImagesInfo(writeImagesInfo2);
                this.jNF.setOriginalImg(writeImagesInfo2.isOriginalImg());
                this.apg = intent.getBooleanExtra("use_original_img", false);
                this.ape = intent.getIntExtra("camera_request_from", 0);
                this.from = intent.getStringExtra("from");
                this.forumId = intent.getStringExtra("forum_id");
                this.forumName = intent.getStringExtra("forum_name");
                this.apf = intent.getIntExtra("album_thread", 0);
                this.aph = intent.getBooleanExtra("from_write", false);
                this.callFrom = intent.getStringExtra("KEY_CALL_FROM");
                this.api = intent.getIntExtra("from_type", 0);
            }
        }
        vB();
    }

    private void vB() {
        if (this.ape == 2) {
            this.jNH = new e() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
        if (this.jNG != null) {
            this.jNG.onChangeSkinType(i);
        }
        am.setBackgroundColor(this.apj, R.color.cp_bg_line_d, i);
    }

    public void vC() {
        if (this.ape == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.ape == 5) {
            showLoadingDialog("正在上传");
            new a().execute(new String[0]);
        } else if (this.jNF != null) {
            if (this.jNJ == null || !this.jNJ.cyn()) {
                if (this.jNF.vX()) {
                    VideoFileInfo cyf = this.jNF.cyf();
                    if (this.jNJ == null) {
                        this.jNJ = new i(this, this.forumName, this.forumId, "");
                        if (this.jNG != null) {
                            this.jNG.a(this.jNJ);
                        }
                    }
                    if (getIntent() != null) {
                        this.jNJ.setProfessionZone(getIntent().getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
                    }
                    this.jNJ.a(cyf, this.callFrom);
                } else if (cyb()) {
                    vD();
                } else {
                    z(null);
                }
            }
        }
    }

    private boolean cyb() {
        if (this.jNF == null || v.getCount(this.jNF.vZ()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.jNF.vZ()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
            i = i;
        }
        return i == 1;
    }

    private void z(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra("album_result", this.jNF.getWriteImagesInfo().toJsonString());
        intent2.putExtra("camera_request_from", this.ape);
        intent2.putExtra("from_type", this.api);
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
            this.jNF.getWriteImagesInfo().setChosedFiles(linkedList);
            intent.putExtra("album_result", this.jNF.getWriteImagesInfo().toJsonString());
            intent.putExtra("camera_request_from", this.ape);
            intent.putExtra("from_type", this.api);
            setResult(-1, intent);
            finish();
        }
    }

    private boolean aSR() {
        Activity pageActivity = getPageContext().getPageActivity();
        com.baidu.tbadk.core.util.c.a aVar = new com.baidu.tbadk.core.util.c.a();
        aVar.clearRequestPermissionList();
        aVar.appendRequestPermission(pageActivity, "android.permission.CAMERA");
        aVar.appendRequestPermission(pageActivity, "android.permission.RECORD_AUDIO");
        aVar.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return aVar.startRequestPermission(pageActivity);
    }

    public void c(TbPageContext tbPageContext) {
        if (!aSR() && com.baidu.tieba.write.i.cxU()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.aph ? 2 : 3, new ForumWriteData(this.forumId, this.forumName, null, null), this.jNF.getWriteImagesInfo(), "", this.api)));
            TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).O("obj_locate", 5).O("obj_type", 2));
        }
    }

    private void vD() {
        WriteImagesInfo writeImagesInfo;
        if (this.jNF != null && (writeImagesInfo = this.jNF.getWriteImagesInfo()) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, writeImagesInfo, cyc())));
        }
    }

    private int cyc() {
        if (this.jNF == null || v.getCount(this.jNF.vZ()) == 0) {
            return 0;
        }
        for (int i = 0; i < v.getCount(this.jNF.vZ()); i++) {
            ImageFileInfo imageFileInfo = this.jNF.vZ().get(i);
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                return i;
            }
        }
        return 0;
    }

    private void A(Intent intent) {
        this.jNI = intent;
        if (intent == null || this.jNF == null) {
            z(null);
            return;
        }
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = this.jNF.getWriteImagesInfo();
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
        if (view == this.jNG.vM()) {
            vC();
        } else if (view == this.jNG.vO()) {
            vC();
        } else if (view == this.jNG.vL()) {
            if (this.jNF != null) {
                this.jNF.setLastAlbumId(null);
            }
            vJ();
        } else if (view == this.jNG.vN()) {
            cd(0);
        } else if (view == this.jNG.vP()) {
            cb(2);
        } else if (view == this.jNG.vQ()) {
            cb(1);
        }
    }

    private void cb(int i) {
        if (this.jNG != null && this.jNF != null) {
            this.jNF.setOriginalImg(!this.jNF.isOriginalImg());
            vE();
            cc(i);
        }
    }

    private void cc(int i) {
        if (this.jNF != null && this.jNF.isOriginalImg() && !StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.forumId, true)) {
            TiebaStatic.log(new an("c10349").bS("fid", this.forumId).bS("obj_type", this.from).O("obj_locate", i));
        }
    }

    public void vE() {
        if (this.jNF != null && this.jNG != null) {
            this.jNG.aQ(this.jNF.isOriginalImg());
        }
    }

    public View vF() {
        return this.apj;
    }

    public int vG() {
        return this.apf;
    }

    public c cyd() {
        return this.jNF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cd(int i) {
        if (!this.apc) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.jNG.cf(this.Zv));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
            }
            this.Zv = i;
            if (getSupportFragmentManager().findFragmentByTag(this.jNG.cf(i)) != null) {
                beginTransaction.show(this.jNG.ce(i));
            } else {
                beginTransaction.add(R.id.fragment, this.jNG.ce(i), this.jNG.cf(i));
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
        int maxImagesAllowed = this.jNF.getMaxImagesAllowed();
        if (this.jNF.size() < maxImagesAllowed) {
            if (this.jNH == null || this.jNH.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.jNF.a(null);
                this.jNF.addChooseFile(imageFileInfo2);
                vE();
                return true;
            }
            return false;
        } else if (vI()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean vI() {
        if (getIntent().getBooleanExtra("select_directly", false)) {
            int maxImagesAllowed = this.jNF.getMaxImagesAllowed();
            if (this.jNF.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) v.getItem(this.jNF.vZ(), 0);
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
        this.jNF.a(null);
        this.jNF.delChooseFile(imageFileInfo);
        vE();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            if (this.Zv == 0) {
                if (this.jNF != null) {
                    this.jNF.setLastAlbumId(null);
                }
                vJ();
                return true;
            } else if (this.Zv == 1) {
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
        if (this.jNG != null && (ce = this.jNG.ce(0)) != null && (ce instanceof ImageListFragment)) {
            ((ImageListFragment) ce).h(imageFileInfo, z);
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ce;
        if (this.jNG != null && (ce = this.jNG.ce(1)) != null && (ce instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) ce).h(imageFileInfo, z);
        }
    }

    private void vJ() {
        Intent intent = new Intent();
        String lastAlbumId = this.jNF.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra("last_album_id", lastAlbumId);
        intent.putExtra("camera_request_from", this.ape);
        setResult(0, intent);
        finish();
    }

    private void stopCamera() {
        if (this.jNG != null) {
            this.jNG.stopCamera();
        }
    }

    private void aZB() {
        if (this.jNG != null) {
            this.jNG.aZB();
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
        this.apc = true;
        stopCamera();
        closeLoadingDialog();
        dismissAllDialog();
        d.cyg().destory();
        if (this.apj != null) {
            this.apj.setBackgroundDrawable(null);
        }
        if (this.jNG != null) {
            this.jNG.onDestroy();
        }
        if (this.jNJ != null) {
            this.jNJ.onDestroy();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra("album_result", this.jNF.getWriteImagesInfo().toJsonString());
        intent.putExtra("camera_request_from", this.ape);
        intent.putExtra("from_type", this.api);
        if (this.jNI != null && !StringUtils.isNull(this.jNI.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.jNI.getStringExtra("file_name"));
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.jNF.getWriteImagesInfo(), true);
            return AlbumActivity.this.jNF.getWriteImagesInfo().toJsonString();
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
        if (this.jNJ != null) {
            this.jNJ.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aZB();
        if (this.jNJ != null) {
            this.jNJ.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jNJ != null) {
            this.jNJ.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        stopCamera();
        super.onPause();
    }
}
