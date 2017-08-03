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
    private com.baidu.tbadk.img.b axK;
    private e gyG;
    private com.baidu.tieba.write.album.a gyH;
    private h gyK;
    private ForumWriteData gyk;
    private int mCurrentPage = 0;
    private boolean gyI = false;
    private int gyJ = 0;
    private String from = "";
    private String fid = "";
    private boolean gyL = false;
    private AlertDialog gyM = null;
    private a gyN = null;
    private boolean gyO = false;
    private String blY = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.album_activity);
        setSwipeBackEnabled(false);
        this.axK = new com.baidu.tbadk.img.b();
        this.gyH = new com.baidu.tieba.write.album.a(this);
        this.gyH.aLs();
        initData(bundle);
        uc(0);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.h.oN().oR() != 0) && z && bxG()) {
            bxH();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        public int aoR;
        private TextView czh;
        private TextView gyQ;
        private TextView gyR;

        public a(View view) {
            super(view);
            this.aoR = 3;
            this.czh = (TextView) view.findViewById(d.h.img_water_setting_title);
            this.gyQ = (TextView) view.findViewById(d.h.img_water_setting_content);
            this.gyR = (TextView) view.findViewById(d.h.goto_setting);
            this.gyR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(AlbumActivity.this.getPageContext().getPageActivity())));
                }
            });
            bxP();
        }

        private void bxP() {
            ai.c(this.czh, d.e.cp_cont_g, 1);
            ai.c(this.gyQ, d.e.cp_cont_g, 1);
            ai.c(this.gyR, d.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aoR != i) {
                bxP();
                this.aoR = i;
            }
        }
    }

    private boolean bxG() {
        return 2 == this.gyJ || 3 == this.gyJ || 1 == this.gyJ || 3 == this.gyJ || "frs".equals(this.from) || "pb".equals(this.from) || AlbumActivityConfig.FROM_WRITE.equals(this.from) || "main_tab".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bxH() {
        if (this.gyN == null) {
            this.gyN = new a(LayoutInflater.from(getActivity()).inflate(d.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.gyM = new AlertDialog.Builder(getActivity()).create();
        this.gyM.show();
        Window window = this.gyM.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.ag(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.gyN.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gyM != null) {
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    AlbumActivity.this.gyM.dismiss();
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gyM != null) {
            this.gyM.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.gyG.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.gyO);
    }

    private void initData(Bundle bundle) {
        this.gyG = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gyG.setWriteImagesInfo(writeImagesInfo);
            this.gyG.sO(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gyO = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gyG.setWriteImagesInfo(writeImagesInfo2);
            this.gyG.setOriginalImg(writeImagesInfo2.isOriginalImg());
            this.gyG.sO(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gyJ = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            this.gyk = (ForumWriteData) intent.getSerializableExtra(AlbumActivityConfig.KEY_FORUM_WRITE_DATA);
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.gyL = true;
            } else {
                this.gyL = false;
            }
            if (this.gyJ == 2) {
                this.gyK = new h() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
            this.gyG.na(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.gyO = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gyH.onChangeSkinType(i);
        if (this.gyN != null) {
            this.gyN.onChangeSkinType(i);
        }
    }

    public void bxI() {
        if (this.gyJ == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.gyJ == 5) {
            showLoadingDialog("正在上传");
            new b().execute(new String[0]);
        } else if ("main_tab".equals(this.from)) {
            String str = "0";
            String str2 = null;
            PostPrefixData postPrefixData = null;
            AntiData antiData = null;
            if (this.gyk != null) {
                str = this.gyk.forumId;
                str2 = this.gyk.forumName;
                postPrefixData = this.gyk.prefixData;
                antiData = this.gyk.antiData;
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 0, str, str2, null, null, 0, antiData, 0, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.setCallFrom("1");
            if (writeActivityConfig.getIntent() != null && this.gyG.getWriteImagesInfo() != null) {
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.gyG.getWriteImagesInfo().toJsonString());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            finish();
        } else if ("frs".equals(this.from)) {
            if (this.gyk != null) {
                WriteActivityConfig writeActivityConfig2 = new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.gyk.forumId, this.gyk.forumName, null, null, 0, this.gyk.antiData, 0, false, false, null, false, false, null, null, this.gyk.prefixData, this.gyk.mem_type);
                if (this.gyk.categoryId > 0) {
                    writeActivityConfig2.setCategroyId(this.gyk.categoryId);
                }
                writeActivityConfig2.addHotTopicInfo(this.gyk.topicData);
                if (writeActivityConfig2.getIntent() != null && this.gyG.getWriteImagesInfo() != null) {
                    writeActivityConfig2.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.gyG.getWriteImagesInfo().toJsonString());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig2));
            }
            finish();
        } else {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gyG.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gyJ);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int currentIndex;
        if (view == this.gyH.bxS()) {
            bxI();
        } else if (view == this.gyH.bxU()) {
            if (this.gyG.getWriteImagesInfo() != null && this.gyG.getWriteImagesInfo().getChosedFiles() != null && this.gyG.getWriteImagesInfo().getChosedFiles().size() == 0 && this.gyH.bxW() != null && u.u(this.gyG.byd()) > 0 && (currentIndex = this.gyH.bxW().getCurrentIndex()) >= 0) {
                e(this.gyG.byd().get(currentIndex));
            }
            bxI();
        } else if (view == this.gyH.bxR()) {
            if (this.gyG != null) {
                this.gyG.setLastAlbumId(null);
            }
            bxN();
        } else if (view == this.gyH.bxT()) {
            uc(0);
        } else if (view == this.gyH.bxV()) {
            bxJ();
        }
    }

    private void bxJ() {
        if (this.gyH != null && this.gyG != null && this.gyH.bxW() != null) {
            this.gyG.setOriginalImg(!this.gyG.isOriginalImg());
            if (this.gyG.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new aj("c10349").aa("fid", this.fid).aa("obj_type", this.from));
                }
                bxO();
                return;
            }
            this.gyH.bxW().d(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e bxK() {
        return this.gyG;
    }

    public com.baidu.tbadk.img.b amx() {
        return this.axK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uc(int i) {
        if (!this.gyI) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.gyH.ue(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.axK.Ez();
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.gyH.ue(i)) != null) {
                beginTransaction.show(this.gyH.ud(i));
            } else {
                beginTransaction.add(d.h.fragment, this.gyH.ud(i), this.gyH.ue(i));
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
        int maxImagesAllowed = this.gyG.getMaxImagesAllowed();
        if (this.gyG.size() < maxImagesAllowed) {
            if (this.gyK == null || this.gyK.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                this.gyG.addChooseFile(imageFileInfo2);
                bxO();
                return true;
            }
            return false;
        } else if (bxL()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bxL() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.gyG.getMaxImagesAllowed();
            if (this.gyG.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.gyG.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.gyG.delChooseFile(imageFileInfo);
        bxO();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.gyH.bxX() != null && !this.gyH.bxX().byn()) {
                    this.gyH.bxX().byj();
                    this.gyH.bxX().nd(true);
                    this.gyH.bxX().bqb();
                    return true;
                }
                if (this.gyG != null) {
                    this.gyG.setLastAlbumId(null);
                }
                bxN();
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
    public void H(int i, boolean z) {
        Fragment ud;
        int i2 = i + 3;
        if (this.gyH != null && (ud = this.gyH.ud(0)) != null && (ud instanceof l)) {
            ((l) ud).I(i2, z);
        }
    }

    void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ud;
        if (this.gyH != null && (ud = this.gyH.ud(0)) != null && (ud instanceof l)) {
            ((l) ud).g(imageFileInfo, z);
        }
    }

    private void bxM() {
        Fragment ud;
        if (this.gyH != null && (ud = this.gyH.ud(0)) != null && (ud instanceof l)) {
            ((l) ud).refresh();
        }
    }

    void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ud;
        if (this.gyH != null && (ud = this.gyH.ud(1)) != null && (ud instanceof com.baidu.tieba.write.album.b)) {
            ((com.baidu.tieba.write.album.b) ud).g(imageFileInfo, z);
        }
    }

    private void bxN() {
        Intent intent = new Intent();
        String lastAlbumId = this.gyG.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gyJ);
        setResult(0, intent);
        finish();
    }

    public void bpY() {
        sM(this.gyG.byg());
    }

    private void sM(String str) {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity())));
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
            if (this.gyG.byd() != null && this.gyG.byd().size() > 0) {
                this.gyG.byd().add(0, imageFileInfo);
                e(imageFileInfo);
                this.gyG.ub(this.gyG.byd().indexOf(imageFileInfo));
                bxM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gyI = true;
        if (this.gyH != null) {
            this.gyH.onDestroy();
        }
        this.axK.Ez();
        f.byi().destory();
    }

    public void bxO() {
        if (this.gyH != null && this.gyG != null && this.gyG.byb() != null && this.gyG.isOriginalImg() && this.gyH.bxW() != null) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.gyG.byb()) {
                if (imageFileInfo != null) {
                    j = com.baidu.tbadk.core.util.k.getFileSize(imageFileInfo.getFilePath()) + j;
                }
            }
            this.gyH.bxW().d(true, j);
        }
    }

    public void ir(String str) {
        this.blY = str;
        g.a(getPageContext(), this.blY, this.gyH.bxQ());
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (aa.aD(getApplicationContext())) {
                ah.b(getPageContext(), this.blY);
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
            new com.baidu.tbadk.img.d(null).c(AlbumActivity.this.gyG.getWriteImagesInfo(), true);
            return AlbumActivity.this.gyG.getWriteImagesInfo().toJsonString();
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
