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
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0023a {
    private com.baidu.tbadk.img.b azd;
    private e gBJ;
    private com.baidu.tieba.write.album.a gBK;
    private h gBN;
    private ForumWriteData gBn;
    private int mCurrentPage = 0;
    private boolean gBL = false;
    private int gBM = 0;
    private String from = "";
    private String fid = "";
    private boolean gBO = false;
    private AlertDialog gBP = null;
    private a gBQ = null;
    private boolean gBR = false;
    private String bns = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.album_activity);
        setSwipeBackEnabled(false);
        this.azd = new com.baidu.tbadk.img.b();
        this.gBK = new com.baidu.tieba.write.album.a(this);
        this.gBK.aMf();
        initData(bundle);
        ul(0);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.h.oY().pc() != 0) && z && byn()) {
            byo();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        public int aqm;
        private TextView cCz;
        private TextView gBT;
        private TextView gBU;

        public a(View view) {
            super(view);
            this.aqm = 3;
            this.cCz = (TextView) view.findViewById(d.h.img_water_setting_title);
            this.gBT = (TextView) view.findViewById(d.h.img_water_setting_content);
            this.gBU = (TextView) view.findViewById(d.h.goto_setting);
            this.gBU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(AlbumActivity.this.getPageContext().getPageActivity())));
                }
            });
            initResource();
        }

        private void initResource() {
            ai.c(this.cCz, d.e.cp_cont_g, 1);
            ai.c(this.gBT, d.e.cp_cont_g, 1);
            ai.c(this.gBU, d.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aqm != i) {
                initResource();
                this.aqm = i;
            }
        }
    }

    private boolean byn() {
        return 2 == this.gBM || 3 == this.gBM || 1 == this.gBM || 3 == this.gBM || "frs".equals(this.from) || "pb".equals(this.from) || AlbumActivityConfig.FROM_WRITE.equals(this.from) || "main_tab".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void byo() {
        if (this.gBQ == null) {
            this.gBQ = new a(LayoutInflater.from(getActivity()).inflate(d.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.gBP = new AlertDialog.Builder(getActivity()).create();
        this.gBP.show();
        Window window = this.gBP.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.ah(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.gBQ.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gBP != null) {
            com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    AlbumActivity.this.gBP.dismiss();
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gBP != null) {
            this.gBP.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.gBJ.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.gBR);
    }

    private void initData(Bundle bundle) {
        this.gBJ = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gBJ.setWriteImagesInfo(writeImagesInfo);
            this.gBJ.ta(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gBR = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gBJ.setWriteImagesInfo(writeImagesInfo2);
            this.gBJ.setOriginalImg(writeImagesInfo2.isOriginalImg());
            this.gBJ.ta(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gBM = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            this.gBn = (ForumWriteData) intent.getSerializableExtra(AlbumActivityConfig.KEY_FORUM_WRITE_DATA);
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.gBO = true;
            } else {
                this.gBO = false;
            }
            if (this.gBM == 2) {
                this.gBN = new h() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
            this.gBJ.nd(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.gBR = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gBK.onChangeSkinType(i);
        if (this.gBQ != null) {
            this.gBQ.onChangeSkinType(i);
        }
    }

    public void byp() {
        if (this.gBM == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.gBM == 5) {
            showLoadingDialog("正在上传");
            new b().execute(new String[0]);
        } else if ("main_tab".equals(this.from)) {
            String str = "0";
            String str2 = null;
            PostPrefixData postPrefixData = null;
            AntiData antiData = null;
            if (this.gBn != null) {
                str = this.gBn.forumId;
                str2 = this.gBn.forumName;
                postPrefixData = this.gBn.prefixData;
                antiData = this.gBn.antiData;
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 0, str, str2, null, null, 0, antiData, 0, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.setCallFrom("1");
            if (writeActivityConfig.getIntent() != null && this.gBJ.getWriteImagesInfo() != null) {
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.gBJ.getWriteImagesInfo().toJsonString());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            finish();
        } else if ("frs".equals(this.from)) {
            if (this.gBn != null) {
                WriteActivityConfig writeActivityConfig2 = new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.gBn.forumId, this.gBn.forumName, null, null, 0, this.gBn.antiData, 0, false, false, null, false, false, null, null, this.gBn.prefixData, this.gBn.mem_type);
                if (this.gBn.categoryId > 0) {
                    writeActivityConfig2.setCategroyId(this.gBn.categoryId);
                }
                writeActivityConfig2.addHotTopicInfo(this.gBn.topicData);
                if (writeActivityConfig2.getIntent() != null && this.gBJ.getWriteImagesInfo() != null) {
                    writeActivityConfig2.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.gBJ.getWriteImagesInfo().toJsonString());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig2));
            }
            finish();
        } else {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gBJ.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gBM);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int currentIndex;
        if (view == this.gBK.byy()) {
            byp();
        } else if (view == this.gBK.byA()) {
            if (this.gBJ.getWriteImagesInfo() != null && this.gBJ.getWriteImagesInfo().getChosedFiles() != null && this.gBJ.getWriteImagesInfo().getChosedFiles().size() == 0 && this.gBK.byC() != null && u.u(this.gBJ.byJ()) > 0 && (currentIndex = this.gBK.byC().getCurrentIndex()) >= 0) {
                e(this.gBJ.byJ().get(currentIndex));
            }
            byp();
        } else if (view == this.gBK.byx()) {
            if (this.gBJ != null) {
                this.gBJ.setLastAlbumId(null);
            }
            byu();
        } else if (view == this.gBK.byz()) {
            ul(0);
        } else if (view == this.gBK.byB()) {
            byq();
        }
    }

    private void byq() {
        if (this.gBK != null && this.gBJ != null && this.gBK.byC() != null) {
            this.gBJ.setOriginalImg(!this.gBJ.isOriginalImg());
            if (this.gBJ.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new aj("c10349").aa("fid", this.fid).aa("obj_type", this.from));
                }
                byv();
                return;
            }
            this.gBK.byC().d(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e byr() {
        return this.gBJ;
    }

    public com.baidu.tbadk.img.b ank() {
        return this.azd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ul(int i) {
        if (!this.gBL) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.gBK.un(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.azd.EH();
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.gBK.un(i)) != null) {
                beginTransaction.show(this.gBK.um(i));
            } else {
                beginTransaction.add(d.h.fragment, this.gBK.um(i), this.gBK.un(i));
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
        int maxImagesAllowed = this.gBJ.getMaxImagesAllowed();
        if (this.gBJ.size() < maxImagesAllowed) {
            if (this.gBN == null || this.gBN.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                this.gBJ.addChooseFile(imageFileInfo2);
                byv();
                return true;
            }
            return false;
        } else if (bys()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bys() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.gBJ.getMaxImagesAllowed();
            if (this.gBJ.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.gBJ.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.gBJ.delChooseFile(imageFileInfo);
        byv();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.gBK.byD() != null && !this.gBK.byD().byT()) {
                    this.gBK.byD().byP();
                    this.gBK.byD().ng(true);
                    this.gBK.byD().bqJ();
                    return true;
                }
                if (this.gBJ != null) {
                    this.gBJ.setLastAlbumId(null);
                }
                byu();
                return true;
            } else if (this.mCurrentPage == 1) {
                ul(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        Fragment um;
        int i2 = i + 3;
        if (this.gBK != null && (um = this.gBK.um(0)) != null && (um instanceof l)) {
            ((l) um).J(i2, z);
        }
    }

    void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment um;
        if (this.gBK != null && (um = this.gBK.um(0)) != null && (um instanceof l)) {
            ((l) um).g(imageFileInfo, z);
        }
    }

    private void byt() {
        Fragment um;
        if (this.gBK != null && (um = this.gBK.um(0)) != null && (um instanceof l)) {
            ((l) um).refresh();
        }
    }

    void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment um;
        if (this.gBK != null && (um = this.gBK.um(1)) != null && (um instanceof com.baidu.tieba.write.album.b)) {
            ((com.baidu.tieba.write.album.b) um).g(imageFileInfo, z);
        }
    }

    private void byu() {
        Intent intent = new Intent();
        String lastAlbumId = this.gBJ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gBM);
        setResult(0, intent);
        finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.gBK != null && this.gBK.byD() != null && this.gBK.byD().byw() != null) {
            this.gBK.byD().byw().stopCamera();
        }
        super.finish();
    }

    public void bqG() {
        sY(this.gBJ.byM());
    }

    private void sY(String str) {
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
            if (this.gBJ.byJ() != null && this.gBJ.byJ().size() > 0) {
                this.gBJ.byJ().add(0, imageFileInfo);
                e(imageFileInfo);
                this.gBJ.setCurrentIndex(this.gBJ.byJ().indexOf(imageFileInfo));
                byt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gBL = true;
        if (this.gBK != null) {
            this.gBK.onDestroy();
        }
        this.azd.EH();
        f.byO().destory();
    }

    public void byv() {
        if (this.gBK != null && this.gBJ != null && this.gBJ.byH() != null && this.gBJ.isOriginalImg() && this.gBK.byC() != null) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.gBJ.byH()) {
                if (imageFileInfo != null) {
                    j = com.baidu.tbadk.core.util.k.getFileSize(imageFileInfo.getFilePath()) + j;
                }
            }
            this.gBK.byC().d(true, j);
        }
    }

    public void iz(String str) {
        this.bns = str;
        g.a(getPageContext(), this.bns, this.gBK.byw());
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0023a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (aa.aE(getApplicationContext())) {
                ah.b(getPageContext(), this.bns);
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
            new com.baidu.tbadk.img.d(null).c(AlbumActivity.this.gBJ.getWriteImagesInfo(), true);
            return AlbumActivity.this.gBJ.getWriteImagesInfo().toJsonString();
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
