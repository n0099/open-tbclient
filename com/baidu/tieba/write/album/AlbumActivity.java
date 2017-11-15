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
    private com.baidu.tbadk.img.b ayc;
    private ForumWriteData gQO;
    private e gRn;
    private com.baidu.tieba.write.album.a gRo;
    private h gRr;
    private int mCurrentPage = 0;
    private boolean gRp = false;
    private int gRq = 0;
    private String from = "";
    private String fid = "0";
    private boolean gRs = false;
    private AlertDialog bLN = null;
    private a gRt = null;
    private boolean gRu = false;
    private String gRv = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.album_activity);
        setSwipeBackEnabled(false);
        this.ayc = new com.baidu.tbadk.img.b();
        this.gRo = new com.baidu.tieba.write.album.a(this);
        this.gRo.aOS();
        initData(bundle);
        vj(0);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.h.oT().oX() != 0) && z && bCI()) {
            bCJ();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes2.dex */
    public class a extends j.a {
        public int aph;
        private TextView cTS;
        private TextView gRx;
        private TextView gRy;

        public a(View view) {
            super(view);
            this.aph = 3;
            this.cTS = (TextView) view.findViewById(d.g.img_water_setting_title);
            this.gRx = (TextView) view.findViewById(d.g.img_water_setting_content);
            this.gRy = (TextView) view.findViewById(d.g.goto_setting);
            this.gRy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(AlbumActivity.this.getPageContext().getPageActivity())));
                }
            });
            initResource();
        }

        private void initResource() {
            aj.c(this.cTS, d.C0080d.cp_cont_g, 1);
            aj.c(this.gRx, d.C0080d.cp_cont_g, 1);
            aj.c(this.gRy, d.C0080d.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aph != i) {
                initResource();
                this.aph = i;
            }
        }
    }

    private boolean bCI() {
        return 2 == this.gRq || 3 == this.gRq || 1 == this.gRq || 3 == this.gRq || "frs".equals(this.from) || "pb".equals(this.from) || AlbumActivityConfig.FROM_WRITE.equals(this.from) || "main_tab".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bCJ() {
        if (this.gRt == null) {
            this.gRt = new a(LayoutInflater.from(getActivity()).inflate(d.h.dialog_img_water_setting, (ViewGroup) null));
        }
        this.bLN = new AlertDialog.Builder(getActivity()).create();
        this.bLN.show();
        Window window = this.bLN.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.l.ae(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.gRt.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bLN != null) {
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    AlbumActivity.this.bLN.dismiss();
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.bLN != null) {
            this.bLN.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.gRn.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.gRu);
    }

    private void initData(Bundle bundle) {
        this.gRn = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gRn.setWriteImagesInfo(writeImagesInfo);
            this.gRn.tT(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gRu = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gRn.setWriteImagesInfo(writeImagesInfo2);
            this.gRn.setOriginalImg(writeImagesInfo2.isOriginalImg());
            this.gRn.tT(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gRq = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            this.gQO = (ForumWriteData) intent.getSerializableExtra(AlbumActivityConfig.KEY_FORUM_WRITE_DATA);
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.gRs = true;
            } else {
                this.gRs = false;
            }
            if (this.gRq == 2) {
                this.gRr = new h() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
            this.gRn.nv(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.gRu = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gRo.onChangeSkinType(i);
        if (this.gRt != null) {
            this.gRt.onChangeSkinType(i);
        }
    }

    public void bCK() {
        if (this.gRq == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.gRq == 5) {
            showLoadingDialog("正在上传");
            new b().execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gRn.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gRq);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int currentIndex;
        if (view == this.gRo.bCS()) {
            bCK();
        } else if (view == this.gRo.bCU()) {
            if (this.gRn.getWriteImagesInfo() != null && this.gRn.getWriteImagesInfo().getChosedFiles() != null && this.gRn.getWriteImagesInfo().getChosedFiles().size() == 0 && this.gRo.bCX() != null && v.u(this.gRn.bDe()) > 0 && (currentIndex = this.gRo.bCX().getCurrentIndex()) >= 0) {
                d(this.gRn.bDe().get(currentIndex));
            }
            bCK();
        } else if (view == this.gRo.bCR()) {
            if (this.gRn != null) {
                this.gRn.setLastAlbumId(null);
            }
            bCP();
        } else if (view == this.gRo.bCT()) {
            vj(0);
        } else if (view == this.gRo.bCV()) {
            vi(2);
        } else if (view == this.gRo.bCW()) {
            vi(1);
        }
    }

    private void vi(int i) {
        if (this.gRo != null && this.gRn != null) {
            this.gRn.setOriginalImg(!this.gRn.isOriginalImg());
            if (this.gRn.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new ak("c10349").ac(ImageViewerConfig.FORUM_ID, this.fid).ac("obj_type", this.from).r("obj_locate", i));
                }
                bCL();
                return;
            }
            if (this.gRo.bCX() != null) {
                this.gRo.bCX().nu(false);
            }
            if (this.gRo.bCY() != null) {
                this.gRo.bCY().nu(false);
            }
        }
    }

    public void bCL() {
        if (this.gRo != null && this.gRn != null && this.gRn.bDc() != null && this.gRn.isOriginalImg()) {
            if (this.gRo.bCX() != null) {
                this.gRo.bCX().nu(true);
            }
            if (this.gRo.bCY() != null) {
                this.gRo.bCY().nu(true);
            }
        }
    }

    public void iU(String str) {
        this.gRv = str;
        g.a(getPageContext(), this.gRv, this.gRo.bCQ());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e bCM() {
        return this.gRn;
    }

    public com.baidu.tbadk.img.b aOP() {
        return this.ayc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vj(int i) {
        if (!this.gRp) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.gRo.vl(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.ayc.ED();
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.gRo.vl(i)) != null) {
                beginTransaction.show(this.gRo.vk(i));
            } else {
                beginTransaction.add(d.g.fragment, this.gRo.vk(i), this.gRo.vl(i));
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
        int maxImagesAllowed = this.gRn.getMaxImagesAllowed();
        if (this.gRn.size() < maxImagesAllowed) {
            if (this.gRr == null || this.gRr.f(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.gRn.addChooseFile(imageFileInfo2);
                bCL();
                return true;
            }
            return false;
        } else if (bCN()) {
            return d(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bCN() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.gRn.getMaxImagesAllowed();
            if (this.gRn.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.gRn.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.gRn.delChooseFile(imageFileInfo);
        bCL();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.gRo.bCY() != null && !this.gRo.bCY().bDo()) {
                    this.gRo.bCY().bDk();
                    this.gRo.bCY().ny(true);
                    this.gRo.bCY().bsl();
                    return true;
                }
                if (this.gRn != null) {
                    this.gRn.setLastAlbumId(null);
                }
                bCP();
                return true;
            } else if (this.mCurrentPage == 1) {
                vj(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(int i, boolean z) {
        Fragment vk;
        int i2 = i + 3;
        if (this.gRo != null && (vk = this.gRo.vk(0)) != null && (vk instanceof l)) {
            ((l) vk).I(i2, z);
        }
    }

    void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vk;
        if (this.gRo != null && (vk = this.gRo.vk(0)) != null && (vk instanceof l)) {
            ((l) vk).h(imageFileInfo, z);
        }
    }

    private void bCO() {
        Fragment vk;
        if (this.gRo != null && (vk = this.gRo.vk(0)) != null && (vk instanceof l)) {
            ((l) vk).refresh();
        }
    }

    void g(ImageFileInfo imageFileInfo, boolean z) {
        Fragment vk;
        if (this.gRo != null && (vk = this.gRo.vk(1)) != null && (vk instanceof com.baidu.tieba.write.album.b)) {
            ((com.baidu.tieba.write.album.b) vk).h(imageFileInfo, z);
        }
    }

    private void bCP() {
        Intent intent = new Intent();
        String lastAlbumId = this.gRn.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gRq);
        setResult(0, intent);
        finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.gRo != null && this.gRo.bCY() != null && this.gRo.bCY().bCQ() != null) {
            this.gRo.bCY().bCQ().stopCamera();
        }
        super.finish();
    }

    public void bsi() {
        tR(this.gRn.bDh());
    }

    private void tR(String str) {
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
            if (this.gRn.bDe() != null && this.gRn.bDe().size() > 0) {
                this.gRn.bDe().add(0, imageFileInfo);
                d(imageFileInfo);
                this.gRn.setCurrentIndex(this.gRn.bDe().indexOf(imageFileInfo));
                bCO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gRp = true;
        if (this.gRo != null) {
            this.gRo.onDestroy();
        }
        this.ayc.ED();
        f.bDj().destory();
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aJ(getApplicationContext())) {
                ai.b(getPageContext(), this.gRv);
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
            new com.baidu.tbadk.img.f(null).c(AlbumActivity.this.gRn.getWriteImagesInfo(), true);
            return AlbumActivity.this.gRn.getWriteImagesInfo().toJsonString();
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
