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
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0022a {
    private com.baidu.tbadk.img.b ayl;
    private ForumWriteData gAQ;
    private e gBq;
    private com.baidu.tieba.write.album.a gBr;
    private h gBu;
    private int mCurrentPage = 0;
    private boolean gBs = false;
    private int gBt = 0;
    private String from = "";
    private String fid = "";
    private boolean gBv = false;
    private AlertDialog bCR = null;
    private a gBw = null;
    private boolean gBx = false;
    private String bnN = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.album_activity);
        setSwipeBackEnabled(false);
        this.ayl = new com.baidu.tbadk.img.b();
        this.gBr = new com.baidu.tieba.write.album.a(this);
        this.gBr.aOd();
        initData(bundle);
        up(0);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.h.oS().oW() != 0) && z && bxP()) {
            bxQ();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes2.dex */
    public class a extends j.a {
        public int apQ;
        private TextView cJJ;
        private TextView gBA;
        private TextView gBz;

        public a(View view) {
            super(view);
            this.apQ = 3;
            this.cJJ = (TextView) view.findViewById(d.h.img_water_setting_title);
            this.gBz = (TextView) view.findViewById(d.h.img_water_setting_content);
            this.gBA = (TextView) view.findViewById(d.h.goto_setting);
            this.gBA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.AlbumActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AlbumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BrowseSettingActivityConfig(AlbumActivity.this.getPageContext().getPageActivity())));
                }
            });
            initResource();
        }

        private void initResource() {
            aj.c(this.cJJ, d.e.cp_cont_g, 1);
            aj.c(this.gBz, d.e.cp_cont_g, 1);
            aj.c(this.gBA, d.e.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.apQ != i) {
                initResource();
                this.apQ = i;
            }
        }
    }

    private boolean bxP() {
        return 2 == this.gBt || 3 == this.gBt || 1 == this.gBt || 3 == this.gBt || "frs".equals(this.from) || "pb".equals(this.from) || AlbumActivityConfig.FROM_WRITE.equals(this.from) || "main_tab".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bxQ() {
        if (this.gBw == null) {
            this.gBw = new a(LayoutInflater.from(getActivity()).inflate(d.j.dialog_img_water_setting, (ViewGroup) null));
        }
        this.bCR = new AlertDialog.Builder(getActivity()).create();
        this.bCR.show();
        Window window = this.bCR.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.af(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.gBw.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bCR != null) {
            com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.AlbumActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    AlbumActivity.this.bCR.dismiss();
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.bCR != null) {
            this.bCR.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.gBq.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.gBx);
    }

    private void initData(Bundle bundle) {
        this.gBq = new e(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gBq.setWriteImagesInfo(writeImagesInfo);
            this.gBq.sX(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gBx = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.gBq.setWriteImagesInfo(writeImagesInfo2);
            this.gBq.setOriginalImg(writeImagesInfo2.isOriginalImg());
            this.gBq.sX(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.gBt = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            this.gAQ = (ForumWriteData) intent.getSerializableExtra(AlbumActivityConfig.KEY_FORUM_WRITE_DATA);
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.gBv = true;
            } else {
                this.gBv = false;
            }
            if (this.gBt == 2) {
                this.gBu = new h() { // from class: com.baidu.tieba.write.album.AlbumActivity.2
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
            this.gBq.nk(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.gBx = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gBr.onChangeSkinType(i);
        if (this.gBw != null) {
            this.gBw.onChangeSkinType(i);
        }
    }

    public void bxR() {
        if (this.gBt == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.gBt == 5) {
            showLoadingDialog("正在上传");
            new b().execute(new String[0]);
        } else if ("main_tab".equals(this.from)) {
            String str = "0";
            String str2 = null;
            PostPrefixData postPrefixData = null;
            AntiData antiData = null;
            if (this.gAQ != null) {
                str = this.gAQ.forumId;
                str2 = this.gAQ.forumName;
                postPrefixData = this.gAQ.prefixData;
                antiData = this.gAQ.antiData;
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 0, str, str2, null, null, 0, antiData, 0, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.setCallFrom("1");
            if (writeActivityConfig.getIntent() != null && this.gBq.getWriteImagesInfo() != null) {
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.gBq.getWriteImagesInfo().toJsonString());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            finish();
        } else if ("frs".equals(this.from)) {
            if (this.gAQ != null) {
                WriteActivityConfig writeActivityConfig2 = new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.gAQ.forumId, this.gAQ.forumName, null, null, 0, this.gAQ.antiData, 0, false, false, null, false, false, null, null, this.gAQ.prefixData, this.gAQ.mem_type);
                if (this.gAQ.categoryId > 0) {
                    writeActivityConfig2.setCategroyId(this.gAQ.categoryId);
                }
                writeActivityConfig2.addHotTopicInfo(this.gAQ.topicData);
                if (writeActivityConfig2.getIntent() != null && this.gBq.getWriteImagesInfo() != null) {
                    writeActivityConfig2.getIntent().putExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.gBq.getWriteImagesInfo().toJsonString());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig2));
            }
            finish();
        } else {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.gBq.getWriteImagesInfo().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gBt);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int currentIndex;
        if (view == this.gBr.bya()) {
            bxR();
        } else if (view == this.gBr.byc()) {
            if (this.gBq.getWriteImagesInfo() != null && this.gBq.getWriteImagesInfo().getChosedFiles() != null && this.gBq.getWriteImagesInfo().getChosedFiles().size() == 0 && this.gBr.bye() != null && v.u(this.gBq.byl()) > 0 && (currentIndex = this.gBr.bye().getCurrentIndex()) >= 0) {
                e(this.gBq.byl().get(currentIndex));
            }
            bxR();
        } else if (view == this.gBr.bxZ()) {
            if (this.gBq != null) {
                this.gBq.setLastAlbumId(null);
            }
            bxW();
        } else if (view == this.gBr.byb()) {
            up(0);
        } else if (view == this.gBr.byd()) {
            bxS();
        }
    }

    private void bxS() {
        if (this.gBr != null && this.gBq != null && this.gBr.bye() != null) {
            this.gBq.setOriginalImg(!this.gBq.isOriginalImg());
            if (this.gBq.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new ak("c10349").ad("fid", this.fid).ad("obj_type", this.from));
                }
                bxX();
                return;
            }
            this.gBr.bye().d(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e bxT() {
        return this.gBq;
    }

    public com.baidu.tbadk.img.b apd() {
        return this.ayl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void up(int i) {
        if (!this.gBs) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.gBr.ur(this.mCurrentPage));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                this.ayl.EF();
            }
            this.mCurrentPage = i;
            if (getSupportFragmentManager().findFragmentByTag(this.gBr.ur(i)) != null) {
                beginTransaction.show(this.gBr.uq(i));
            } else {
                beginTransaction.add(d.h.fragment, this.gBr.uq(i), this.gBr.ur(i));
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
        int maxImagesAllowed = this.gBq.getMaxImagesAllowed();
        if (this.gBq.size() < maxImagesAllowed) {
            if (this.gBu == null || this.gBu.g(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                this.gBq.addChooseFile(imageFileInfo2);
                bxX();
                return true;
            }
            return false;
        } else if (bxU()) {
            return e(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bxU() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.gBq.getMaxImagesAllowed();
            if (this.gBq.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.gBq.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.gBq.delChooseFile(imageFileInfo);
        bxX();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCurrentPage == 0) {
                if (this.gBr.byf() != null && !this.gBr.byf().byv()) {
                    this.gBr.byf().byr();
                    this.gBr.byf().nn(true);
                    this.gBr.byf().bqj();
                    return true;
                }
                if (this.gBq != null) {
                    this.gBq.setLastAlbumId(null);
                }
                bxW();
                return true;
            } else if (this.mCurrentPage == 1) {
                up(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int i, boolean z) {
        Fragment uq;
        int i2 = i + 3;
        if (this.gBr != null && (uq = this.gBr.uq(0)) != null && (uq instanceof l)) {
            ((l) uq).F(i2, z);
        }
    }

    void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uq;
        if (this.gBr != null && (uq = this.gBr.uq(0)) != null && (uq instanceof l)) {
            ((l) uq).g(imageFileInfo, z);
        }
    }

    private void bxV() {
        Fragment uq;
        if (this.gBr != null && (uq = this.gBr.uq(0)) != null && (uq instanceof l)) {
            ((l) uq).refresh();
        }
    }

    void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment uq;
        if (this.gBr != null && (uq = this.gBr.uq(1)) != null && (uq instanceof com.baidu.tieba.write.album.b)) {
            ((com.baidu.tieba.write.album.b) uq).g(imageFileInfo, z);
        }
    }

    private void bxW() {
        Intent intent = new Intent();
        String lastAlbumId = this.gBq.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.gBt);
        setResult(0, intent);
        finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.gBr != null && this.gBr.byf() != null && this.gBr.byf().bxY() != null) {
            this.gBr.byf().bxY().stopCamera();
        }
        super.finish();
    }

    public void bqg() {
        sV(this.gBq.byo());
    }

    private void sV(String str) {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.ae(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity())));
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
            if (this.gBq.byl() != null && this.gBq.byl().size() > 0) {
                this.gBq.byl().add(0, imageFileInfo);
                e(imageFileInfo);
                this.gBq.setCurrentIndex(this.gBq.byl().indexOf(imageFileInfo));
                bxV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gBs = true;
        if (this.gBr != null) {
            this.gBr.onDestroy();
        }
        this.ayl.EF();
        f.byq().destory();
    }

    public void bxX() {
        if (this.gBr != null && this.gBq != null && this.gBq.byj() != null && this.gBq.isOriginalImg() && this.gBr.bye() != null) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.gBq.byj()) {
                if (imageFileInfo != null) {
                    j = com.baidu.tbadk.core.util.k.dy(imageFileInfo.getFilePath()) + j;
                }
            }
            this.gBr.bye().d(true, j);
        }
    }

    public void iB(String str) {
        this.bnN = str;
        g.a(getPageContext(), this.bnN, this.gBr.bxY());
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aK(getApplicationContext())) {
                ai.b(getPageContext(), this.bnN);
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
            new com.baidu.tbadk.img.d(null).c(AlbumActivity.this.gBq.getWriteImagesInfo(), true);
            return AlbumActivity.this.gBq.getWriteImagesInfo().toJsonString();
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
