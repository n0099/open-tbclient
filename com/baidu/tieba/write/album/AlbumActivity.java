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
    private com.baidu.tbadk.img.b awS;
    private ForumWriteData gdN;
    private p gei;
    private d gej;
    private v gem;
    private int mCurrentPage = 0;
    private boolean gek = false;
    private int gel = 0;
    private String from = "";
    private String fid = "";
    private boolean gen = false;
    private AlertDialog geo = null;
    private a gep = null;
    private boolean geq = false;
    private String biM = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.album_activity);
        setSwipeBackEnabled(false);
        this.awS = new com.baidu.tbadk.img.b();
        this.gej = new d(this);
        this.gej.brT();
        initData(bundle);
        tA(0);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.r.oK().oO() != 0) && z && brI()) {
            brJ();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends z.a {
        public int aoa;
        private TextView crY;
        private TextView ges;
        private TextView get;

        public a(View view) {
            super(view);
            this.aoa = 3;
            this.crY = (TextView) view.findViewById(w.h.img_water_setting_title);
            this.ges = (TextView) view.findViewById(w.h.img_water_setting_content);
            this.get = (TextView) view.findViewById(w.h.goto_setting);
            this.get.setOnClickListener(new c(this));
            brS();
        }

        private void brS() {
            com.baidu.tbadk.core.util.as.c(this.crY, w.e.cp_cont_g, 1);
            com.baidu.tbadk.core.util.as.c(this.ges, w.e.cp_cont_g, 1);
            com.baidu.tbadk.core.util.as.c(this.get, w.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aoa != i) {
                brS();
                this.aoa = i;
            }
        }
    }

    private boolean brI() {
        return 2 == this.gel || 3 == this.gel || 1 == this.gel || 3 == this.gel || "frs".equals(this.from) || "pb".equals(this.from) || AlbumActivityConfig.FROM_WRITE.equals(this.from) || "main_tab".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void brJ() {
        if (this.gep == null) {
            this.gep = new a(LayoutInflater.from(getActivity()).inflate(w.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.geo = new AlertDialog.Builder(getActivity()).create();
        this.geo.show();
        Window window = this.geo.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.ag(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.gep.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.geo != null) {
            com.baidu.adp.lib.g.h.fR().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.geo != null) {
            this.geo.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.gei.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.geq);
    }

    private void initData(Bundle bundle) {
        this.gei = new p(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gei.setWriteImagesInfo(writeImagesInfo);
            this.gei.sh(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.geq = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gei.setWriteImagesInfo(writeImagesInfo2);
            this.gei.setOriginalImg(writeImagesInfo2.isOriginalImg());
            this.gei.sh(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gel = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            this.gdN = (ForumWriteData) intent.getSerializableExtra(AlbumActivityConfig.KEY_FORUM_WRITE_DATA);
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.gen = true;
            } else {
                this.gen = false;
            }
            if (this.gel == 2) {
                this.gem = new com.baidu.tieba.write.album.b(this);
            }
            this.gei.mu(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.geq = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.gej.onChangeSkinType(i);
        if (this.gep != null) {
            this.gep.onChangeSkinType(i);
        }
    }

    private void brK() {
        if (this.gel == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.gel == 5) {
            showLoadingDialog("正在上传");
            new b(this, null).execute(new String[0]);
        } else if ("main_tab".equals(this.from)) {
            String str = "0";
            String str2 = null;
            PostPrefixData postPrefixData = null;
            AntiData antiData = null;
            if (this.gdN != null) {
                str = this.gdN.forumId;
                str2 = this.gdN.forumName;
                postPrefixData = this.gdN.prefixData;
                antiData = this.gdN.antiData;
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 0, str, str2, null, null, 0, antiData, 0, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.setCallFrom("1");
            if (writeActivityConfig.getIntent() != null && this.gei.getWriteImagesInfo() != null) {
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.gei.getWriteImagesInfo().toJsonString());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            finish();
        } else if ("frs".equals(this.from)) {
            if (this.gdN != null) {
                WriteActivityConfig writeActivityConfig2 = new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.gdN.forumId, this.gdN.forumName, null, null, 0, this.gdN.antiData, 0, false, false, null, false, false, null, null, this.gdN.prefixData, this.gdN.mem_type);
                if (this.gdN.categoryId > 0) {
                    writeActivityConfig2.setCategroyId(this.gdN.categoryId);
                }
                writeActivityConfig2.addHotTopicInfo(this.gdN.topicData);
                if (writeActivityConfig2.getIntent() != null && this.gei.getWriteImagesInfo() != null) {
                    writeActivityConfig2.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.gei.getWriteImagesInfo().toJsonString());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig2));
            }
            finish();
        } else {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gei.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gel);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int currentIndex;
        if (view == this.gej.brW()) {
            brK();
        } else if (view == this.gej.brY()) {
            if (this.gei.getWriteImagesInfo() != null && this.gei.getWriteImagesInfo().getChosedFiles() != null && this.gei.getWriteImagesInfo().getChosedFiles().size() == 0 && this.gej.bsa() != null && com.baidu.tbadk.core.util.z.s(this.gei.bsm()) > 0 && (currentIndex = this.gej.bsa().getCurrentIndex()) >= 0) {
                c(this.gei.bsm().get(currentIndex));
            }
            brK();
        } else if (view == this.gej.brV()) {
            if (this.gei != null) {
                this.gei.setLastAlbumId(null);
            }
            brP();
        } else if (view == this.gej.brX()) {
            tA(0);
        } else if (view == this.gej.brZ()) {
            brL();
        }
    }

    private void brL() {
        if (this.gej != null && this.gei != null && this.gej.bsa() != null) {
            this.gei.setOriginalImg(!this.gei.isOriginalImg());
            if (this.gei.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10349").Z("fid", this.fid).Z("obj_type", this.from));
                }
                brR();
                return;
            }
            this.gej.bsa().b(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p brM() {
        return this.gei;
    }

    public com.baidu.tbadk.img.b akX() {
        return this.awS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tA(int i) {
        if (!this.gek) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.gej.tC(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.awS.Ek();
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.gej.tC(i)) != null) {
                beginTransaction.show(this.gej.tB(i));
            } else {
                beginTransaction.add(w.h.fragment, this.gej.tB(i), this.gej.tC(i));
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
        int maxImagesAllowed = this.gei.getMaxImagesAllowed();
        if (this.gei.size() < maxImagesAllowed) {
            if (this.gem == null || this.gem.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                this.gei.addChooseFile(imageFileInfo2);
                brR();
                return true;
            }
            return false;
        } else if (brN()) {
            return c(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean brN() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.gei.getMaxImagesAllowed();
            if (this.gei.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.gei.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.gei.delChooseFile(imageFileInfo);
        brR();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.gej.bsb() != null && !this.gej.bsb().bsy()) {
                    this.gej.bsb().bst();
                    this.gej.bsb().my(true);
                    this.gej.bsb().bss();
                    return true;
                }
                if (this.gei != null) {
                    this.gei.setLastAlbumId(null);
                }
                brP();
                return true;
            } else if (this.mCurrentPage == 1) {
                tA(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(int i, boolean z) {
        Fragment tB;
        int i2 = i + 3;
        if (this.gej != null && (tB = this.gej.tB(0)) != null && (tB instanceof ac)) {
            ((ac) tB).H(i2, z);
        }
    }

    void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment tB;
        if (this.gej != null && (tB = this.gej.tB(0)) != null && (tB instanceof ac)) {
            ((ac) tB).g(imageFileInfo, z);
        }
    }

    private void brO() {
        Fragment tB;
        if (this.gej != null && (tB = this.gej.tB(0)) != null && (tB instanceof ac)) {
            ((ac) tB).refresh();
        }
    }

    void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment tB;
        if (this.gej != null && (tB = this.gej.tB(1)) != null && (tB instanceof f)) {
            ((f) tB).g(imageFileInfo, z);
        }
    }

    private void brP() {
        Intent intent = new Intent();
        String lastAlbumId = this.gei.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gel);
        setResult(0, intent);
        finish();
    }

    public void brQ() {
        sc(this.gei.bsp());
    }

    private void sc(String str) {
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
                        com.baidu.tbadk.core.util.n.a(null, str, rotateBitmapBydegree, 100);
                    } else {
                        com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, str, rotateBitmapBydegree, 100);
                    }
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str2);
            imageFileInfo.setTempFile(true);
            if (this.gei.bsm() != null && this.gei.bsm().size() > 0) {
                this.gei.bsm().add(0, imageFileInfo);
                c(imageFileInfo);
                this.gei.tz(this.gei.bsm().indexOf(imageFileInfo));
                brO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gek = true;
        if (this.gej != null) {
            this.gej.onDestroy();
        }
        this.awS.Ek();
        q.bsr().destory();
    }

    public void brR() {
        if (this.gej != null && this.gei != null && this.gei.bsk() != null && this.gei.isOriginalImg() && this.gej.bsa() != null) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.gei.bsk()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.n.getFileSize(imageFileInfo.getFilePath());
                }
            }
            this.gej.bsa().b(true, j);
        }
    }

    public void ia(String str) {
        this.biM = str;
        u.a(getPageContext(), this.biM, this.gej.brU());
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ag.aD(getApplicationContext())) {
                com.baidu.tbadk.core.util.ar.b(getPageContext(), this.biM);
            } else {
                showToast(w.l.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
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
            new com.baidu.tbadk.img.e(null).c(AlbumActivity.this.gei.getWriteImagesInfo(), true);
            return AlbumActivity.this.gei.getWriteImagesInfo().toJsonString();
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
