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
import com.baidu.a.a.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0000a {
    private com.baidu.tbadk.img.b azb;
    private e gzR;
    private com.baidu.tieba.write.album.a gzS;
    private h gzV;
    private ForumWriteData gzv;
    private int mCurrentPage = 0;
    private boolean gzT = false;
    private int gzU = 0;
    private String from = "";
    private String fid = "";
    private boolean gzW = false;
    private AlertDialog gzX = null;
    private a gzY = null;
    private boolean gzZ = false;
    private String bni = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.album_activity);
        setSwipeBackEnabled(false);
        this.azb = new com.baidu.tbadk.img.b();
        this.gzS = new com.baidu.tieba.write.album.a(this);
        this.gzS.aLD();
        initData(bundle);
        uc(0);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.h.oX().pb() != 0) && z && bxN()) {
            bxO();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        public int aql;
        private TextView cAC;
        private TextView gAb;
        private TextView gAc;

        public a(View view) {
            super(view);
            this.aql = 3;
            this.cAC = (TextView) view.findViewById(d.h.img_water_setting_title);
            this.gAb = (TextView) view.findViewById(d.h.img_water_setting_content);
            this.gAc = (TextView) view.findViewById(d.h.goto_setting);
            this.gAc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(AlbumActivity.this.getPageContext().getPageActivity())));
                }
            });
            bxW();
        }

        private void bxW() {
            ai.c(this.cAC, d.e.cp_cont_g, 1);
            ai.c(this.gAb, d.e.cp_cont_g, 1);
            ai.c(this.gAc, d.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aql != i) {
                bxW();
                this.aql = i;
            }
        }
    }

    private boolean bxN() {
        return 2 == this.gzU || 3 == this.gzU || 1 == this.gzU || 3 == this.gzU || "frs".equals(this.from) || "pb".equals(this.from) || AlbumActivityConfig.FROM_WRITE.equals(this.from) || "main_tab".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bxO() {
        if (this.gzY == null) {
            this.gzY = new a(LayoutInflater.from(getActivity()).inflate(d.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.gzX = new AlertDialog.Builder(getActivity()).create();
        this.gzX.show();
        Window window = this.gzX.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.ah(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.gzY.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gzX != null) {
            com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    AlbumActivity.this.gzX.dismiss();
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gzX != null) {
            this.gzX.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.gzR.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.gzZ);
    }

    private void initData(Bundle bundle) {
        this.gzR = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gzR.setWriteImagesInfo(writeImagesInfo);
            this.gzR.sT(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gzZ = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gzR.setWriteImagesInfo(writeImagesInfo2);
            this.gzR.setOriginalImg(writeImagesInfo2.isOriginalImg());
            this.gzR.sT(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gzU = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            this.gzv = (ForumWriteData) intent.getSerializableExtra(AlbumActivityConfig.KEY_FORUM_WRITE_DATA);
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.gzW = true;
            } else {
                this.gzW = false;
            }
            if (this.gzU == 2) {
                this.gzV = new h() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
                    @Override // com.baidu.tieba.write.album.h
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
                        AlbumActivity.this.showToastWithIcon(AlbumActivity.this.getPageContext().getPageActivity().getString(d.l.uploade_attation), d.g.icon_toast_game_error);
                        return false;
                    }
                };
            }
            this.gzR.na(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.gzZ = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gzS.onChangeSkinType(i);
        if (this.gzY != null) {
            this.gzY.onChangeSkinType(i);
        }
    }

    public void bxP() {
        if (this.gzU == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.gzU == 5) {
            showLoadingDialog("正在上传");
            new b().execute(new String[0]);
        } else if ("main_tab".equals(this.from)) {
            String str = "0";
            String str2 = null;
            PostPrefixData postPrefixData = null;
            AntiData antiData = null;
            if (this.gzv != null) {
                str = this.gzv.forumId;
                str2 = this.gzv.forumName;
                postPrefixData = this.gzv.prefixData;
                antiData = this.gzv.antiData;
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 0, str, str2, null, null, 0, antiData, 0, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.setCallFrom("1");
            if (writeActivityConfig.getIntent() != null && this.gzR.getWriteImagesInfo() != null) {
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.gzR.getWriteImagesInfo().toJsonString());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            finish();
        } else if ("frs".equals(this.from)) {
            if (this.gzv != null) {
                WriteActivityConfig writeActivityConfig2 = new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.gzv.forumId, this.gzv.forumName, null, null, 0, this.gzv.antiData, 0, false, false, null, false, false, null, null, this.gzv.prefixData, this.gzv.mem_type);
                if (this.gzv.categoryId > 0) {
                    writeActivityConfig2.setCategroyId(this.gzv.categoryId);
                }
                writeActivityConfig2.addHotTopicInfo(this.gzv.topicData);
                if (writeActivityConfig2.getIntent() != null && this.gzR.getWriteImagesInfo() != null) {
                    writeActivityConfig2.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.gzR.getWriteImagesInfo().toJsonString());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig2));
            }
            finish();
        } else {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gzR.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gzU);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int currentIndex;
        if (view == this.gzS.bxZ()) {
            bxP();
        } else if (view == this.gzS.byb()) {
            if (this.gzR.getWriteImagesInfo() != null && this.gzR.getWriteImagesInfo().getChosedFiles() != null && this.gzR.getWriteImagesInfo().getChosedFiles().size() == 0 && this.gzS.byd() != null && u.u(this.gzR.byk()) > 0 && (currentIndex = this.gzS.byd().getCurrentIndex()) >= 0) {
                e(this.gzR.byk().get(currentIndex));
            }
            bxP();
        } else if (view == this.gzS.bxY()) {
            if (this.gzR != null) {
                this.gzR.setLastAlbumId(null);
            }
            bxU();
        } else if (view == this.gzS.bya()) {
            uc(0);
        } else if (view == this.gzS.byc()) {
            bxQ();
        }
    }

    private void bxQ() {
        if (this.gzS != null && this.gzR != null && this.gzS.byd() != null) {
            this.gzR.setOriginalImg(!this.gzR.isOriginalImg());
            if (this.gzR.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new aj("c10349").aa("fid", this.fid).aa("obj_type", this.from));
                }
                bxV();
                return;
            }
            this.gzS.byd().d(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e bxR() {
        return this.gzR;
    }

    public com.baidu.tbadk.img.b amK() {
        return this.azb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uc(int i) {
        if (!this.gzT) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.gzS.ue(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.azb.EH();
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.gzS.ue(i)) != null) {
                beginTransaction.show(this.gzS.ud(i));
            } else {
                beginTransaction.add(d.h.fragment, this.gzS.ud(i), this.gzS.ue(i));
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
        int maxImagesAllowed = this.gzR.getMaxImagesAllowed();
        if (this.gzR.size() < maxImagesAllowed) {
            if (this.gzV == null || this.gzV.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                this.gzR.addChooseFile(imageFileInfo2);
                bxV();
                return true;
            }
            return false;
        } else if (bxS()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bxS() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.gzR.getMaxImagesAllowed();
            if (this.gzR.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.gzR.getWriteImagesInfo().getChosedFiles().get(0);
                    if (f(imageFileInfo)) {
                        e(imageFileInfo, false);
                        f(imageFileInfo, false);
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
        this.gzR.delChooseFile(imageFileInfo);
        bxV();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.gzS.bye() != null && !this.gzS.bye().byu()) {
                    this.gzS.bye().byq();
                    this.gzS.bye().nd(true);
                    this.gzS.bye().bqi();
                    return true;
                }
                if (this.gzR != null) {
                    this.gzR.setLastAlbumId(null);
                }
                bxU();
                return true;
            } else if (this.mCurrentPage == 1) {
                uc(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        Fragment ud;
        int i2 = i + 3;
        if (this.gzS != null && (ud = this.gzS.ud(0)) != null && (ud instanceof l)) {
            ((l) ud).J(i2, z);
        }
    }

    void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ud;
        if (this.gzS != null && (ud = this.gzS.ud(0)) != null && (ud instanceof l)) {
            ((l) ud).g(imageFileInfo, z);
        }
    }

    private void bxT() {
        Fragment ud;
        if (this.gzS != null && (ud = this.gzS.ud(0)) != null && (ud instanceof l)) {
            ((l) ud).refresh();
        }
    }

    void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ud;
        if (this.gzS != null && (ud = this.gzS.ud(1)) != null && (ud instanceof com.baidu.tieba.write.album.b)) {
            ((com.baidu.tieba.write.album.b) ud).g(imageFileInfo, z);
        }
    }

    private void bxU() {
        Intent intent = new Intent();
        String lastAlbumId = this.gzR.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gzU);
        setResult(0, intent);
        finish();
    }

    public void bqf() {
        sR(this.gzR.byn());
    }

    private void sR(String str) {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ah(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    if (z) {
                        com.baidu.tbadk.core.util.k.a(null, str, rotateBitmapBydegree, 100);
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
            if (this.gzR.byk() != null && this.gzR.byk().size() > 0) {
                this.gzR.byk().add(0, imageFileInfo);
                e(imageFileInfo);
                this.gzR.ub(this.gzR.byk().indexOf(imageFileInfo));
                bxT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gzT = true;
        if (this.gzS != null) {
            this.gzS.onDestroy();
        }
        this.azb.EH();
        f.byp().destory();
    }

    public void bxV() {
        if (this.gzS != null && this.gzR != null && this.gzR.byi() != null && this.gzR.isOriginalImg() && this.gzS.byd() != null) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.gzR.byi()) {
                if (imageFileInfo != null) {
                    j = com.baidu.tbadk.core.util.k.getFileSize(imageFileInfo.getFilePath()) + j;
                }
            }
            this.gzS.byd().d(true, j);
        }
    }

    public void iw(String str) {
        this.bni = str;
        g.a(getPageContext(), this.bni, this.gzS.bxX());
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (aa.aE(getApplicationContext())) {
                ah.b(getPageContext(), this.bni);
            } else {
                showToast(d.l.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = aa.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.d(null).c(AlbumActivity.this.gzR.getWriteImagesInfo(), true);
            return AlbumActivity.this.gzR.getWriteImagesInfo().toJsonString();
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
