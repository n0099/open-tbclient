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
import com.baidu.adp.widget.ListView.y;
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
    private com.baidu.tbadk.img.b awf;
    private p fLQ;
    private d fLR;
    private v fLU;
    private ForumWriteData fLV;
    private int mCurrentPage = 0;
    private boolean fLS = false;
    private int fLT = 0;
    private String from = "";
    private String fid = "";
    private boolean fLW = false;
    private AlertDialog fLX = null;
    private a fLY = null;
    private boolean fLZ = false;
    private String beM = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.album_activity);
        setSwipeBackEnabled(false);
        this.awf = new com.baidu.tbadk.img.b();
        this.fLR = new d(this);
        this.fLR.blZ();
        initData(bundle);
        sK(0);
        boolean z = com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.r.oV().oZ() != 0) && z && blO()) {
            blP();
            com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public int ane;
        private TextView cdT;
        private TextView fMb;
        private TextView fMc;

        public a(View view) {
            super(view);
            this.ane = 3;
            this.cdT = (TextView) view.findViewById(w.h.img_water_setting_title);
            this.fMb = (TextView) view.findViewById(w.h.img_water_setting_content);
            this.fMc = (TextView) view.findViewById(w.h.goto_setting);
            this.fMc.setOnClickListener(new c(this));
            blY();
        }

        private void blY() {
            com.baidu.tbadk.core.util.aq.c(this.cdT, w.e.cp_cont_g, 1);
            com.baidu.tbadk.core.util.aq.c(this.fMb, w.e.cp_cont_g, 1);
            com.baidu.tbadk.core.util.aq.c(this.fMc, w.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.ane != i) {
                blY();
                this.ane = i;
            }
        }
    }

    private boolean blO() {
        return 2 == this.fLT || 3 == this.fLT || 1 == this.fLT || 3 == this.fLT || "frs".equals(this.from) || "pb".equals(this.from) || AlbumActivityConfig.FROM_WRITE.equals(this.from) || "main_tab".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void blP() {
        if (this.fLY == null) {
            this.fLY = new a(LayoutInflater.from(getActivity()).inflate(w.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.fLX = new AlertDialog.Builder(getActivity()).create();
        this.fLX.show();
        Window window = this.fLX.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.ag(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.fLY.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fLX != null) {
            com.baidu.adp.lib.g.h.fS().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fLX != null) {
            this.fLX.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.fLQ.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.fLZ);
    }

    private void initData(Bundle bundle) {
        this.fLQ = new p(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fLQ.setWriteImagesInfo(writeImagesInfo);
            this.fLQ.qV(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fLZ = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fLQ.setWriteImagesInfo(writeImagesInfo2);
            this.fLQ.setOriginalImg(writeImagesInfo2.isOriginalImg());
            this.fLQ.qV(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fLT = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            this.fLV = (ForumWriteData) intent.getSerializableExtra(AlbumActivityConfig.KEY_FORUM_WRITE_DATA);
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.fLW = true;
            } else {
                this.fLW = false;
            }
            if (this.fLT == 2) {
                this.fLU = new com.baidu.tieba.write.album.b(this);
            }
            this.fLQ.lA(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.fLZ = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fLR.onChangeSkinType(i);
        if (this.fLY != null) {
            this.fLY.onChangeSkinType(i);
        }
    }

    private void blQ() {
        if (this.fLT == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.fLT == 5) {
            showLoadingDialog("正在上传");
            new b(this, null).execute(new String[0]);
        } else if ("main_tab".equals(this.from)) {
            String str = "0";
            String str2 = null;
            PostPrefixData postPrefixData = null;
            AntiData antiData = null;
            if (this.fLV != null) {
                str = this.fLV.forumId;
                str2 = this.fLV.forumName;
                postPrefixData = this.fLV.prefixData;
                antiData = this.fLV.antiData;
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 0, str, str2, null, null, 0, antiData, 0, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.setCallFrom("1");
            if (writeActivityConfig.getIntent() != null && this.fLQ.getWriteImagesInfo() != null) {
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.fLQ.getWriteImagesInfo().toJsonString());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            finish();
        } else if ("frs".equals(this.from)) {
            if (this.fLV != null) {
                WriteActivityConfig writeActivityConfig2 = new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.fLV.forumId, this.fLV.forumName, null, null, 0, this.fLV.antiData, 0, false, false, null, false, false, null, null, this.fLV.prefixData, this.fLV.mem_type);
                if (this.fLV.categoryId > 0) {
                    writeActivityConfig2.setCategroyId(this.fLV.categoryId);
                }
                writeActivityConfig2.addHotTopicInfo(this.fLV.topicData);
                if (writeActivityConfig2.getIntent() != null && this.fLQ.getWriteImagesInfo() != null) {
                    writeActivityConfig2.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.fLQ.getWriteImagesInfo().toJsonString());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig2));
            }
            finish();
        } else {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fLQ.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fLT);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int currentIndex;
        if (view == this.fLR.bmc()) {
            blQ();
        } else if (view == this.fLR.bme()) {
            if (this.fLQ.getWriteImagesInfo() != null && this.fLQ.getWriteImagesInfo().getChosedFiles() != null && this.fLQ.getWriteImagesInfo().getChosedFiles().size() == 0 && this.fLR.bmg() != null && com.baidu.tbadk.core.util.x.q(this.fLQ.bms()) > 0 && (currentIndex = this.fLR.bmg().getCurrentIndex()) >= 0) {
                c(this.fLQ.bms().get(currentIndex));
            }
            blQ();
        } else if (view == this.fLR.bmb()) {
            if (this.fLQ != null) {
                this.fLQ.setLastAlbumId(null);
            }
            blV();
        } else if (view == this.fLR.bmd()) {
            sK(0);
        } else if (view == this.fLR.bmf()) {
            blR();
        }
    }

    private void blR() {
        if (this.fLR != null && this.fLQ != null && this.fLR.bmg() != null) {
            this.fLQ.setOriginalImg(!this.fLQ.isOriginalImg());
            if (this.fLQ.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10349").aa("fid", this.fid).aa("obj_type", this.from));
                }
                blX();
                return;
            }
            this.fLR.bmg().a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p blS() {
        return this.fLQ;
    }

    public com.baidu.tbadk.img.b afY() {
        return this.awf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sK(int i) {
        if (!this.fLS) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.fLR.sM(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.awf.DT();
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.fLR.sM(i)) != null) {
                beginTransaction.show(this.fLR.sL(i));
            } else {
                beginTransaction.add(w.h.fragment, this.fLR.sL(i), this.fLR.sM(i));
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
        int maxImagesAllowed = this.fLQ.getMaxImagesAllowed();
        if (this.fLQ.size() < maxImagesAllowed) {
            if (this.fLU == null || this.fLU.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.fLQ.addChooseFile(imageFileInfo2);
                blX();
                return true;
            }
            return false;
        } else if (blT()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean blT() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.fLQ.getMaxImagesAllowed();
            if (this.fLQ.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.fLQ.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.fLQ.delChooseFile(imageFileInfo);
        blX();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.fLR.bmh() != null && !this.fLR.bmh().bmE()) {
                    this.fLR.bmh().bmz();
                    this.fLR.bmh().lE(true);
                    this.fLR.bmh().bmy();
                    return true;
                }
                if (this.fLQ != null) {
                    this.fLQ.setLastAlbumId(null);
                }
                blV();
                return true;
            } else if (this.mCurrentPage == 1) {
                sK(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i, boolean z) {
        Fragment sL;
        int i2 = i + 3;
        if (this.fLR != null && (sL = this.fLR.sL(0)) != null && (sL instanceof ac)) {
            ((ac) sL).J(i2, z);
        }
    }

    void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sL;
        if (this.fLR != null && (sL = this.fLR.sL(0)) != null && (sL instanceof ac)) {
            ((ac) sL).g(imageFileInfo, z);
        }
    }

    private void blU() {
        Fragment sL;
        if (this.fLR != null && (sL = this.fLR.sL(0)) != null && (sL instanceof ac)) {
            ((ac) sL).refresh();
        }
    }

    void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sL;
        if (this.fLR != null && (sL = this.fLR.sL(1)) != null && (sL instanceof f)) {
            ((f) sL).g(imageFileInfo, z);
        }
    }

    private void blV() {
        Intent intent = new Intent();
        String lastAlbumId = this.fLQ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fLT);
        setResult(0, intent);
        finish();
    }

    public void blW() {
        qQ(this.fLQ.bmv());
    }

    private void qQ(String str) {
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
            if (this.fLQ.bms() != null && this.fLQ.bms().size() > 0) {
                this.fLQ.bms().add(0, imageFileInfo);
                c(imageFileInfo);
                this.fLQ.sJ(this.fLQ.bms().indexOf(imageFileInfo));
                blU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fLS = true;
        if (this.fLR != null) {
            this.fLR.onDestroy();
        }
        this.awf.DT();
        q.bmx().destory();
    }

    public void blX() {
        if (this.fLR != null && this.fLQ != null && this.fLQ.bmq() != null && this.fLQ.isOriginalImg() && this.fLR.bmg() != null) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.fLQ.bmq()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.l.getFileSize(imageFileInfo.getFilePath());
                }
            }
            this.fLR.bmg().a(true, j);
        }
    }

    public void hA(String str) {
        this.beM = str;
        u.a(getPageContext(), this.beM, this.fLR.bma());
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ae.aD(getApplicationContext())) {
                com.baidu.tbadk.core.util.ap.b(getPageContext(), this.beM);
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
            new com.baidu.tbadk.img.c(null).c(AlbumActivity.this.fLQ.getWriteImagesInfo(), true);
            return AlbumActivity.this.fLQ.getWriteImagesInfo().toJsonString();
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
