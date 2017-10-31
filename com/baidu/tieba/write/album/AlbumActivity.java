package com.baidu.tieba.write.album;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.b.a.a;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes2.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0022a {
    private com.baidu.tbadk.img.b axU;
    private ForumWriteData gPG;
    private e gQf;
    private com.baidu.tieba.write.album.a gQg;
    private h gQj;
    private int mCurrentPage = 0;
    private boolean gQh = false;
    private int gQi = 0;
    private String from = "";
    private String fid = "0";
    private boolean gQk = false;
    private AlertDialog bLA = null;
    private a gQl = null;
    private boolean gQm = false;
    private String gQn = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.album_activity);
        setSwipeBackEnabled(false);
        this.axU = new com.baidu.tbadk.img.b();
        this.gQg = new com.baidu.tieba.write.album.a(this);
        this.gQg.aOK();
        initData(bundle);
        vf(0);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.h.oT().oX() != 0) && z && bCw()) {
            bCx();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes2.dex */
    public class a extends j.a {
        public int api;
        private TextView cTy;
        private TextView gQp;
        private TextView gQq;

        public a(View view) {
            super(view);
            this.api = 3;
            this.cTy = (TextView) view.findViewById(d.g.img_water_setting_title);
            this.gQp = (TextView) view.findViewById(d.g.img_water_setting_content);
            this.gQq = (TextView) view.findViewById(d.g.goto_setting);
            this.gQq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(AlbumActivity.this.getPageContext().getPageActivity())));
                }
            });
            initResource();
        }

        private void initResource() {
            aj.c(this.cTy, d.C0080d.cp_cont_g, 1);
            aj.c(this.gQp, d.C0080d.cp_cont_g, 1);
            aj.c(this.gQq, d.C0080d.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.api != i) {
                initResource();
                this.api = i;
            }
        }
    }

    private boolean bCw() {
        return 2 == this.gQi || 3 == this.gQi || 1 == this.gQi || 3 == this.gQi || "frs".equals(this.from) || "pb".equals(this.from) || AlbumActivityConfig.FROM_WRITE.equals(this.from) || "main_tab".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bCx() {
        if (this.gQl == null) {
            this.gQl = new a(LayoutInflater.from(getActivity()).inflate(d.h.dialog_img_water_setting, (ViewGroup) null));
        }
        this.bLA = new AlertDialog.Builder(getActivity()).create();
        this.bLA.show();
        Window window = this.bLA.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.l.ae(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.gQl.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bLA != null) {
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    AlbumActivity.this.bLA.dismiss();
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.bLA != null) {
            this.bLA.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.gQf.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.gQm);
    }

    private void initData(Bundle bundle) {
        this.gQf = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gQf.setWriteImagesInfo(writeImagesInfo);
            this.gQf.tN(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gQm = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gQf.setWriteImagesInfo(writeImagesInfo2);
            this.gQf.setOriginalImg(writeImagesInfo2.isOriginalImg());
            this.gQf.tN(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gQi = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            this.gPG = (ForumWriteData) intent.getSerializableExtra(AlbumActivityConfig.KEY_FORUM_WRITE_DATA);
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.gQk = true;
            } else {
                this.gQk = false;
            }
            if (this.gQi == 2) {
                this.gQj = new h() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
                    @Override // com.baidu.tieba.write.album.h
                    public boolean f(ImageFileInfo imageFileInfo) {
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
                        AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(d.j.uploade_attation), d.f.icon_toast_game_error);
                        return false;
                    }
                };
            }
            this.gQf.nn(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.gQm = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gQg.onChangeSkinType(i);
        if (this.gQl != null) {
            this.gQl.onChangeSkinType(i);
        }
    }

    public void bCy() {
        if (this.gQi == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.gQi == 5) {
            showLoadingDialog("正在上传");
            new b().execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gQf.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gQi);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int currentIndex;
        if (view == this.gQg.bCG()) {
            bCy();
        } else if (view == this.gQg.bCI()) {
            if (this.gQf.getWriteImagesInfo() != null && this.gQf.getWriteImagesInfo().getChosedFiles() != null && this.gQf.getWriteImagesInfo().getChosedFiles().size() == 0 && this.gQg.bCL() != null && v.u(this.gQf.bCS()) > 0 && (currentIndex = this.gQg.bCL().getCurrentIndex()) >= 0) {
                d(this.gQf.bCS().get(currentIndex));
            }
            bCy();
        } else if (view == this.gQg.bCF()) {
            if (this.gQf != null) {
                this.gQf.setLastAlbumId(null);
            }
            bCD();
        } else if (view == this.gQg.bCH()) {
            vf(0);
        } else if (view == this.gQg.bCJ()) {
            ve(2);
        } else if (view == this.gQg.bCK()) {
            ve(1);
        }
    }

    private void ve(int i) {
        if (this.gQg != null && this.gQf != null) {
            this.gQf.setOriginalImg(!this.gQf.isOriginalImg());
            if (this.gQf.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new ak("c10349").ac(ImageViewerConfig.FORUM_ID, this.fid).ac("obj_type", this.from).r("obj_locate", i));
                }
                bCz();
                return;
            }
            if (this.gQg.bCL() != null) {
                this.gQg.bCL().nm(false);
            }
            if (this.gQg.bCM() != null) {
                this.gQg.bCM().nm(false);
            }
        }
    }

    public void bCz() {
        if (this.gQg != null && this.gQf != null && this.gQf.bCQ() != null && this.gQf.isOriginalImg()) {
            if (this.gQg.bCL() != null) {
                this.gQg.bCL().nm(true);
            }
            if (this.gQg.bCM() != null) {
                this.gQg.bCM().nm(true);
            }
        }
    }

    public void iT(String str) {
        this.gQn = str;
        g.a(getPageContext(), this.gQn, this.gQg.bCE());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e bCA() {
        return this.gQf;
    }

    public com.baidu.tbadk.img.b aOH() {
        return this.axU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vf(int i) {
        if (!this.gQh) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.gQg.vh(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.axU.Er();
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.gQg.vh(i)) != null) {
                beginTransaction.show(this.gQg.vg(i));
            } else {
                beginTransaction.add(d.g.fragment, this.gQg.vg(i), this.gQg.vh(i));
            }
            beginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int maxImagesAllowed = this.gQf.getMaxImagesAllowed();
        if (this.gQf.size() < maxImagesAllowed) {
            if (this.gQj == null || this.gQj.f(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.gQf.addChooseFile(imageFileInfo2);
                bCz();
                return true;
            }
            return false;
        } else if (bCB()) {
            return d(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bCB() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.gQf.getMaxImagesAllowed();
            if (this.gQf.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.gQf.getWriteImagesInfo().getChosedFiles().get(0);
                    if (e(imageFileInfo)) {
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
    public boolean e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.gQf.delChooseFile(imageFileInfo);
        bCz();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.gQg.bCM() != null && !this.gQg.bCM().bDc()) {
                    this.gQg.bCM().bCY();
                    this.gQg.bCM().nq(true);
                    this.gQg.bCM().bsa();
                    return true;
                }
                if (this.gQf != null) {
                    this.gQf.setLastAlbumId(null);
                }
                bCD();
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
    public void G(int i, boolean z) {
        Fragment vg;
        int i2 = i + 3;
        if (this.gQg != null && (vg = this.gQg.vg(0)) != null && (vg instanceof l)) {
            ((l) vg).H(i2, z);
        }
    }

    void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vg;
        if (this.gQg != null && (vg = this.gQg.vg(0)) != null && (vg instanceof l)) {
            ((l) vg).h(imageFileInfo, z);
        }
    }

    private void bCC() {
        Fragment vg;
        if (this.gQg != null && (vg = this.gQg.vg(0)) != null && (vg instanceof l)) {
            ((l) vg).refresh();
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vg;
        if (this.gQg != null && (vg = this.gQg.vg(1)) != null && (vg instanceof com.baidu.tieba.write.album.b)) {
            ((com.baidu.tieba.write.album.b) vg).h(imageFileInfo, z);
        }
    }

    private void bCD() {
        Intent intent = new Intent();
        String lastAlbumId = this.gQf.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gQi);
        setResult(0, intent);
        finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.gQg != null && this.gQg.bCM() != null && this.gQg.bCM().bCE() != null) {
            this.gQg.bCM().bCE().stopCamera();
        }
        super.finish();
    }

    public void brX() {
        tL(this.gQf.bCV());
    }

    private void tL(String str) {
        String str2;
        boolean z;
        if (StringUtils.isNull(str, true)) {
            str = "camera.jpg";
            str2 = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/camera.jpg";
            z = true;
        } else {
            str2 = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + str;
            z = false;
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str2);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.ac(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.ae(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    if (z) {
                        com.baidu.tbadk.core.util.k.a((String) null, str, rotateBitmapBydegree, 100);
                    } else {
                        com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, str, rotateBitmapBydegree, 100);
                    }
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str2);
            imageFileInfo.setTempFile(true);
            if (this.gQf.bCS() != null && this.gQf.bCS().size() > 0) {
                this.gQf.bCS().add(0, imageFileInfo);
                d(imageFileInfo);
                this.gQf.setCurrentIndex(this.gQf.bCS().indexOf(imageFileInfo));
                bCC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gQh = true;
        if (this.gQg != null) {
            this.gQg.onDestroy();
        }
        this.axU.Er();
        f.bCX().destory();
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aJ(getApplicationContext())) {
                ai.b(getPageContext(), this.gQn);
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.gQf.getWriteImagesInfo(), true);
            return AlbumActivity.this.gQf.getWriteImagesInfo().toJsonString();
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
}
