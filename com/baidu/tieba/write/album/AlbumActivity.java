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
import com.baidu.adp.framework.MessageManager;
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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
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
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0023a {
    private com.baidu.tbadk.img.b ayo;
    private h gAB;
    private e gAx;
    private com.baidu.tieba.write.album.a gAy;
    private ForumWriteData gzW;
    private int mCurrentPage = 0;
    private boolean gAz = false;
    private int gAA = 0;
    private String from = "";
    private String fid = "";
    private boolean gAC = false;
    private AlertDialog bCa = null;
    private a gAD = null;
    private boolean gAE = false;
    private String bnO = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.album_activity);
        setSwipeBackEnabled(false);
        this.ayo = new com.baidu.tbadk.img.b();
        this.gAy = new com.baidu.tieba.write.album.a(this);
        this.gAy.aNS();
        initData(bundle);
        un(0);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.h.oS().oW() != 0) && z && bxE()) {
            bxF();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes2.dex */
    public class a extends j.a {
        public int apS;
        private TextView cIP;
        private TextView gAG;
        private TextView gAH;

        public a(View view) {
            super(view);
            this.apS = 3;
            this.cIP = (TextView) view.findViewById(d.h.img_water_setting_title);
            this.gAG = (TextView) view.findViewById(d.h.img_water_setting_content);
            this.gAH = (TextView) view.findViewById(d.h.goto_setting);
            this.gAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(AlbumActivity.this.getPageContext().getPageActivity())));
                }
            });
            initResource();
        }

        private void initResource() {
            aj.c(this.cIP, d.e.cp_cont_g, 1);
            aj.c(this.gAG, d.e.cp_cont_g, 1);
            aj.c(this.gAH, d.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.apS != i) {
                initResource();
                this.apS = i;
            }
        }
    }

    private boolean bxE() {
        return 2 == this.gAA || 3 == this.gAA || 1 == this.gAA || 3 == this.gAA || "frs".equals(this.from) || "pb".equals(this.from) || AlbumActivityConfig.FROM_WRITE.equals(this.from) || "main_tab".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bxF() {
        if (this.gAD == null) {
            this.gAD = new a(LayoutInflater.from(getActivity()).inflate(d.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.bCa = new AlertDialog.Builder(getActivity()).create();
        this.bCa.show();
        Window window = this.bCa.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.ae(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.gAD.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bCa != null) {
            com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    AlbumActivity.this.bCa.dismiss();
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.bCa != null) {
            this.bCa.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.gAx.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.gAE);
    }

    private void initData(Bundle bundle) {
        this.gAx = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gAx.setWriteImagesInfo(writeImagesInfo);
            this.gAx.sV(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gAE = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gAx.setWriteImagesInfo(writeImagesInfo2);
            this.gAx.setOriginalImg(writeImagesInfo2.isOriginalImg());
            this.gAx.sV(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gAA = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            this.gzW = (ForumWriteData) intent.getSerializableExtra(AlbumActivityConfig.KEY_FORUM_WRITE_DATA);
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.gAC = true;
            } else {
                this.gAC = false;
            }
            if (this.gAA == 2) {
                this.gAB = new h() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
            this.gAx.nj(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.gAE = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gAy.onChangeSkinType(i);
        if (this.gAD != null) {
            this.gAD.onChangeSkinType(i);
        }
    }

    public void bxG() {
        if (this.gAA == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.gAA == 5) {
            showLoadingDialog("正在上传");
            new b().execute(new String[0]);
        } else if ("main_tab".equals(this.from)) {
            String str = "0";
            String str2 = null;
            PostPrefixData postPrefixData = null;
            AntiData antiData = null;
            if (this.gzW != null) {
                str = this.gzW.forumId;
                str2 = this.gzW.forumName;
                postPrefixData = this.gzW.prefixData;
                antiData = this.gzW.antiData;
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 0, str, str2, null, null, 0, antiData, 0, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.setCallFrom("1");
            if (writeActivityConfig.getIntent() != null && this.gAx.getWriteImagesInfo() != null) {
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.gAx.getWriteImagesInfo().toJsonString());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            finish();
        } else if ("frs".equals(this.from)) {
            if (this.gzW != null) {
                WriteActivityConfig writeActivityConfig2 = new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.gzW.forumId, this.gzW.forumName, null, null, 0, this.gzW.antiData, 0, false, false, null, false, false, null, null, this.gzW.prefixData, this.gzW.mem_type);
                if (this.gzW.categoryId > 0) {
                    writeActivityConfig2.setCategroyId(this.gzW.categoryId);
                }
                writeActivityConfig2.addHotTopicInfo(this.gzW.topicData);
                if (writeActivityConfig2.getIntent() != null && this.gAx.getWriteImagesInfo() != null) {
                    writeActivityConfig2.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.gAx.getWriteImagesInfo().toJsonString());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig2));
            }
            finish();
        } else {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gAx.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gAA);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int currentIndex;
        if (view == this.gAy.bxP()) {
            bxG();
        } else if (view == this.gAy.bxR()) {
            if (this.gAx.getWriteImagesInfo() != null && this.gAx.getWriteImagesInfo().getChosedFiles() != null && this.gAx.getWriteImagesInfo().getChosedFiles().size() == 0 && this.gAy.bxT() != null && v.u(this.gAx.bya()) > 0 && (currentIndex = this.gAy.bxT().getCurrentIndex()) >= 0) {
                e(this.gAx.bya().get(currentIndex));
            }
            bxG();
        } else if (view == this.gAy.bxO()) {
            if (this.gAx != null) {
                this.gAx.setLastAlbumId(null);
            }
            bxL();
        } else if (view == this.gAy.bxQ()) {
            un(0);
        } else if (view == this.gAy.bxS()) {
            bxH();
        }
    }

    private void bxH() {
        if (this.gAy != null && this.gAx != null && this.gAy.bxT() != null) {
            this.gAx.setOriginalImg(!this.gAx.isOriginalImg());
            if (this.gAx.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new ak("c10349").ad("fid", this.fid).ad("obj_type", this.from));
                }
                bxM();
                return;
            }
            this.gAy.bxT().d(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e bxI() {
        return this.gAx;
    }

    public com.baidu.tbadk.img.b aoS() {
        return this.ayo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void un(int i) {
        if (!this.gAz) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.gAy.up(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.ayo.EF();
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.gAy.up(i)) != null) {
                beginTransaction.show(this.gAy.uo(i));
            } else {
                beginTransaction.add(d.h.fragment, this.gAy.uo(i), this.gAy.up(i));
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
        int maxImagesAllowed = this.gAx.getMaxImagesAllowed();
        if (this.gAx.size() < maxImagesAllowed) {
            if (this.gAB == null || this.gAB.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                this.gAx.addChooseFile(imageFileInfo2);
                bxM();
                return true;
            }
            return false;
        } else if (bxJ()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bxJ() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.gAx.getMaxImagesAllowed();
            if (this.gAx.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.gAx.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.gAx.delChooseFile(imageFileInfo);
        bxM();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.gAy.bxU() != null && !this.gAy.bxU().byk()) {
                    this.gAy.bxU().byg();
                    this.gAy.bxU().nm(true);
                    this.gAy.bxU().bpY();
                    return true;
                }
                if (this.gAx != null) {
                    this.gAx.setLastAlbumId(null);
                }
                bxL();
                return true;
            } else if (this.mCurrentPage == 1) {
                un(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int i, boolean z) {
        Fragment uo;
        int i2 = i + 3;
        if (this.gAy != null && (uo = this.gAy.uo(0)) != null && (uo instanceof l)) {
            ((l) uo).F(i2, z);
        }
    }

    void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uo;
        if (this.gAy != null && (uo = this.gAy.uo(0)) != null && (uo instanceof l)) {
            ((l) uo).g(imageFileInfo, z);
        }
    }

    private void bxK() {
        Fragment uo;
        if (this.gAy != null && (uo = this.gAy.uo(0)) != null && (uo instanceof l)) {
            ((l) uo).refresh();
        }
    }

    void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uo;
        if (this.gAy != null && (uo = this.gAy.uo(1)) != null && (uo instanceof com.baidu.tieba.write.album.b)) {
            ((com.baidu.tieba.write.album.b) uo).g(imageFileInfo, z);
        }
    }

    private void bxL() {
        Intent intent = new Intent();
        String lastAlbumId = this.gAx.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gAA);
        setResult(0, intent);
        finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.gAy != null && this.gAy.bxU() != null && this.gAy.bxU().bxN() != null) {
            this.gAy.bxU().bxN().stopCamera();
        }
        super.finish();
    }

    public void bpV() {
        sT(this.gAx.byd());
    }

    private void sT(String str) {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ad(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ae(getPageContext().getPageActivity())));
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
            if (this.gAx.bya() != null && this.gAx.bya().size() > 0) {
                this.gAx.bya().add(0, imageFileInfo);
                e(imageFileInfo);
                this.gAx.setCurrentIndex(this.gAx.bya().indexOf(imageFileInfo));
                bxK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gAz = true;
        if (this.gAy != null) {
            this.gAy.onDestroy();
        }
        this.ayo.EF();
        f.byf().destory();
    }

    public void bxM() {
        if (this.gAy != null && this.gAx != null && this.gAx.bxY() != null && this.gAx.isOriginalImg() && this.gAy.bxT() != null) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.gAx.bxY()) {
                if (imageFileInfo != null) {
                    j = com.baidu.tbadk.core.util.k.dy(imageFileInfo.getFilePath()) + j;
                }
            }
            this.gAy.bxT().d(true, j);
        }
    }

    public void iB(String str) {
        this.bnO = str;
        g.a(getPageContext(), this.bnO, this.gAy.bxN());
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0023a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aJ(getApplicationContext())) {
                ai.b(getPageContext(), this.bnO);
            } else {
                showToast(d.l.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.l.sdcard_permission_denied_advert_for_camera);
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
            new com.baidu.tbadk.img.d(null).c(AlbumActivity.this.gAx.getWriteImagesInfo(), true);
            return AlbumActivity.this.gAx.getWriteImagesInfo().toJsonString();
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
