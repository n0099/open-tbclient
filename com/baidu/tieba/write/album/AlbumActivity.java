package com.baidu.tieba.write.album;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
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
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0000a {
    private com.baidu.tbadk.img.b avP;
    private v fTB;
    private ForumWriteData fTC;
    private p fTx;
    private d fTy;
    private int mCurrentPage = 0;
    private boolean fTz = false;
    private int fTA = 0;
    private String from = "";
    private String fid = "";
    private boolean fTD = false;
    private AlertDialog fTE = null;
    private a fTF = null;
    private boolean fTG = false;
    private String bfO = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.album_activity);
        setSwipeBackEnabled(false);
        this.avP = new com.baidu.tbadk.img.b();
        this.fTy = new d(this);
        this.fTy.bnw();
        initData(bundle);
        tf(0);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.r.oN().oR() != 0) && z && bnl()) {
            bnm();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends z.a {
        public int ana;
        private TextView ckh;
        private TextView fTI;
        private TextView fTJ;

        public a(View view) {
            super(view);
            this.ana = 3;
            this.ckh = (TextView) view.findViewById(w.h.img_water_setting_title);
            this.fTI = (TextView) view.findViewById(w.h.img_water_setting_content);
            this.fTJ = (TextView) view.findViewById(w.h.goto_setting);
            this.fTJ.setOnClickListener(new c(this));
            bnv();
        }

        private void bnv() {
            com.baidu.tbadk.core.util.aq.c(this.ckh, w.e.cp_cont_g, 1);
            com.baidu.tbadk.core.util.aq.c(this.fTI, w.e.cp_cont_g, 1);
            com.baidu.tbadk.core.util.aq.c(this.fTJ, w.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.ana != i) {
                bnv();
                this.ana = i;
            }
        }
    }

    private boolean bnl() {
        return 2 == this.fTA || 3 == this.fTA || 1 == this.fTA || 3 == this.fTA || "frs".equals(this.from) || "pb".equals(this.from) || AlbumActivityConfig.FROM_WRITE.equals(this.from) || "main_tab".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bnm() {
        if (this.fTF == null) {
            this.fTF = new a(LayoutInflater.from(getActivity()).inflate(w.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.fTE = new AlertDialog.Builder(getActivity()).create();
        this.fTE.show();
        Window window = this.fTE.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.ag(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.fTF.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fTE != null) {
            com.baidu.adp.lib.g.h.fS().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fTE != null) {
            this.fTE.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.fTx.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.fTG);
    }

    private void initData(Bundle bundle) {
        this.fTx = new p(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fTx.setWriteImagesInfo(writeImagesInfo);
            this.fTx.ri(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fTG = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fTx.setWriteImagesInfo(writeImagesInfo2);
            this.fTx.setOriginalImg(writeImagesInfo2.isOriginalImg());
            this.fTx.ri(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fTA = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            this.fTC = (ForumWriteData) intent.getSerializableExtra(AlbumActivityConfig.KEY_FORUM_WRITE_DATA);
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.fTD = true;
            } else {
                this.fTD = false;
            }
            if (this.fTA == 2) {
                this.fTB = new com.baidu.tieba.write.album.b(this);
            }
            this.fTx.lT(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.fTG = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fTy.onChangeSkinType(i);
        if (this.fTF != null) {
            this.fTF.onChangeSkinType(i);
        }
    }

    private void bnn() {
        if (this.fTA == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.fTA == 5) {
            showLoadingDialog("正在上传");
            new b(this, null).execute(new String[0]);
        } else if ("main_tab".equals(this.from)) {
            String str = "0";
            String str2 = null;
            PostPrefixData postPrefixData = null;
            AntiData antiData = null;
            if (this.fTC != null) {
                str = this.fTC.forumId;
                str2 = this.fTC.forumName;
                postPrefixData = this.fTC.prefixData;
                antiData = this.fTC.antiData;
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 0, str, str2, null, null, 0, antiData, 0, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.setCallFrom("1");
            if (writeActivityConfig.getIntent() != null && this.fTx.getWriteImagesInfo() != null) {
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.fTx.getWriteImagesInfo().toJsonString());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            finish();
        } else if ("frs".equals(this.from)) {
            if (this.fTC != null) {
                WriteActivityConfig writeActivityConfig2 = new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.fTC.forumId, this.fTC.forumName, null, null, 0, this.fTC.antiData, 0, false, false, null, false, false, null, null, this.fTC.prefixData, this.fTC.mem_type);
                if (this.fTC.categoryId > 0) {
                    writeActivityConfig2.setCategroyId(this.fTC.categoryId);
                }
                writeActivityConfig2.addHotTopicInfo(this.fTC.topicData);
                if (writeActivityConfig2.getIntent() != null && this.fTx.getWriteImagesInfo() != null) {
                    writeActivityConfig2.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.fTx.getWriteImagesInfo().toJsonString());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig2));
            }
            finish();
        } else {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fTx.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fTA);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int currentIndex;
        if (view == this.fTy.bnz()) {
            bnn();
        } else if (view == this.fTy.bnB()) {
            if (this.fTx.getWriteImagesInfo() != null && this.fTx.getWriteImagesInfo().getChosedFiles() != null && this.fTx.getWriteImagesInfo().getChosedFiles().size() == 0 && this.fTy.bnD() != null && com.baidu.tbadk.core.util.x.q(this.fTx.bnP()) > 0 && (currentIndex = this.fTy.bnD().getCurrentIndex()) >= 0) {
                c(this.fTx.bnP().get(currentIndex));
            }
            bnn();
        } else if (view == this.fTy.bny()) {
            if (this.fTx != null) {
                this.fTx.setLastAlbumId(null);
            }
            bns();
        } else if (view == this.fTy.bnA()) {
            tf(0);
        } else if (view == this.fTy.bnC()) {
            bno();
        }
    }

    private void bno() {
        if (this.fTy != null && this.fTx != null && this.fTy.bnD() != null) {
            this.fTx.setOriginalImg(!this.fTx.isOriginalImg());
            if (this.fTx.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10349").Z("fid", this.fid).Z("obj_type", this.from));
                }
                bnu();
                return;
            }
            this.fTy.bnD().b(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p bnp() {
        return this.fTx;
    }

    public com.baidu.tbadk.img.b ahn() {
        return this.avP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tf(int i) {
        if (!this.fTz) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.fTy.th(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.avP.DN();
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.fTy.th(i)) != null) {
                beginTransaction.show(this.fTy.tg(i));
            } else {
                beginTransaction.add(w.h.fragment, this.fTy.tg(i), this.fTy.th(i));
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
        int maxImagesAllowed = this.fTx.getMaxImagesAllowed();
        if (this.fTx.size() < maxImagesAllowed) {
            if (this.fTB == null || this.fTB.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.fTx.addChooseFile(imageFileInfo2);
                bnu();
                return true;
            }
            return false;
        } else if (bnq()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bnq() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.fTx.getMaxImagesAllowed();
            if (this.fTx.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.fTx.getWriteImagesInfo().getChosedFiles().get(0);
                    if (d(imageFileInfo)) {
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
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.fTx.delChooseFile(imageFileInfo);
        bnu();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.fTy.bnE() != null && !this.fTy.bnE().bob()) {
                    this.fTy.bnE().bnW();
                    this.fTy.bnE().lX(true);
                    this.fTy.bnE().bnV();
                    return true;
                }
                if (this.fTx != null) {
                    this.fTx.setLastAlbumId(null);
                }
                bns();
                return true;
            } else if (this.mCurrentPage == 1) {
                tf(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(int i, boolean z) {
        Fragment tg;
        int i2 = i + 3;
        if (this.fTy != null && (tg = this.fTy.tg(0)) != null && (tg instanceof ac)) {
            ((ac) tg).H(i2, z);
        }
    }

    void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment tg;
        if (this.fTy != null && (tg = this.fTy.tg(0)) != null && (tg instanceof ac)) {
            ((ac) tg).g(imageFileInfo, z);
        }
    }

    private void bnr() {
        Fragment tg;
        if (this.fTy != null && (tg = this.fTy.tg(0)) != null && (tg instanceof ac)) {
            ((ac) tg).refresh();
        }
    }

    void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment tg;
        if (this.fTy != null && (tg = this.fTy.tg(1)) != null && (tg instanceof f)) {
            ((f) tg).g(imageFileInfo, z);
        }
    }

    private void bns() {
        Intent intent = new Intent();
        String lastAlbumId = this.fTx.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fTA);
        setResult(0, intent);
        finish();
    }

    public void bnt() {
        rd(this.fTx.bnS());
    }

    private void rd(String str) {
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
                        com.baidu.tbadk.core.util.l.a(null, str, rotateBitmapBydegree, 100);
                    } else {
                        com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, str, rotateBitmapBydegree, 100);
                    }
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str2);
            imageFileInfo.setTempFile(true);
            if (this.fTx.bnP() != null && this.fTx.bnP().size() > 0) {
                this.fTx.bnP().add(0, imageFileInfo);
                c(imageFileInfo);
                this.fTx.te(this.fTx.bnP().indexOf(imageFileInfo));
                bnr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fTz = true;
        if (this.fTy != null) {
            this.fTy.onDestroy();
        }
        this.avP.DN();
        q.bnU().destory();
    }

    public void bnu() {
        if (this.fTy != null && this.fTx != null && this.fTx.bnN() != null && this.fTx.isOriginalImg() && this.fTy.bnD() != null) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.fTx.bnN()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.l.getFileSize(imageFileInfo.getFilePath());
                }
            }
            this.fTy.bnD().b(true, j);
        }
    }

    public void hB(String str) {
        this.bfO = str;
        u.a(getPageContext(), this.bfO, this.fTy.bnx());
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ae.aD(getApplicationContext())) {
                com.baidu.tbadk.core.util.ap.b(getPageContext(), this.bfO);
            } else {
                showToast(w.l.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ae.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(w.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private b() {
        }

        /* synthetic */ b(AlbumActivity albumActivity, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            new com.baidu.tbadk.img.c(null).c(AlbumActivity.this.fTx.getWriteImagesInfo(), true);
            return AlbumActivity.this.fTx.getWriteImagesInfo().toJsonString();
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
