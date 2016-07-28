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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0000a {
    private com.baidu.tbadk.img.b anU;
    private o fPM;
    private t fPN;
    private y fPQ;
    private int bQX = 0;
    private boolean fPO = false;
    private int fPP = 0;
    private String from = "";
    private String aMb = "";
    private boolean fPR = false;
    private AlertDialog fPS = null;
    private a fPT = null;
    private boolean fPU = false;
    private String fPV = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.anU = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        bng();
        st(0);
        bnh();
        boolean z = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.l.nL().nP() != 0) && z && bne()) {
            bnf();
            com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public int afy;
        private TextView beS;
        private TextView fPX;
        private TextView fPY;

        public a(View view) {
            super(view);
            this.afy = 3;
            this.beS = (TextView) view.findViewById(u.g.img_water_setting_title);
            this.fPX = (TextView) view.findViewById(u.g.img_water_setting_content);
            this.fPY = (TextView) view.findViewById(u.g.goto_setting);
            this.fPY.setOnClickListener(new c(this));
            bnq();
        }

        private void bnq() {
            av.c(this.beS, u.d.cp_cont_g, 1);
            av.c(this.fPX, u.d.cp_cont_g, 1);
            av.c(this.fPY, u.d.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.afy != i) {
                bnq();
                this.afy = i;
            }
            if (AlbumActivity.this.fPN != null) {
                AlbumActivity.this.fPN.sB(AlbumActivity.this.bQX);
            }
        }
    }

    private boolean bne() {
        return 2 == this.fPP || 3 == this.fPP || 1 == this.fPP || 3 == this.fPP || "frs".equals(this.from) || "pb".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bnf() {
        if (this.fPT == null) {
            this.fPT = new a(LayoutInflater.from(getActivity()).inflate(u.h.dialog_img_water_setting, (ViewGroup) null));
        }
        this.fPS = new AlertDialog.Builder(getActivity()).create();
        this.fPS.show();
        Window window = this.fPS.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.B(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.fPT.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fPS != null) {
            com.baidu.adp.lib.h.h.dL().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fPS != null) {
            this.fPS.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.fPM.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.fPU);
    }

    private void initData(Bundle bundle) {
        this.fPM = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fPM.setWriteImagesInfo(writeImagesInfo);
            this.fPM.rx(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fPU = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fPM.setWriteImagesInfo(writeImagesInfo2);
            this.fPM.rx(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fPP = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.aMb = intent.getStringExtra("forum_id");
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.fPR = true;
            } else {
                this.fPR = false;
            }
            if (this.fPP == 2) {
                this.fPQ = new com.baidu.tieba.write.album.b(this);
            }
            this.fPM.lr(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.fPU = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.fPN = new t(this);
        this.fPN.bnD();
    }

    private void bng() {
        if (this.fPN != null && this.fPM != null) {
            this.fPN.sy(this.fPM.getMaxImagesAllowed());
            if (this.fPM.bnw() != null) {
                for (ImageFileInfo imageFileInfo : this.fPM.bnw()) {
                    this.fPN.h(imageFileInfo);
                }
            }
            bno();
        }
    }

    private void bnh() {
        String string;
        int size = this.fPM.size();
        boolean z = size != 0;
        if (this.fPP == 5) {
            string = getPageContext().getPageActivity().getString(u.j.album_upload_btn, new Object[]{Integer.valueOf(size)});
        } else if (this.fPR) {
            string = getPageContext().getPageActivity().getString(u.j.live_album_finish_btn, new Object[]{Integer.valueOf(size)});
        } else {
            string = getPageContext().getPageActivity().getString(u.j.album_finish_btn, new Object[]{Integer.valueOf(size)});
        }
        this.fPN.o(z, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fPN.onChangeSkinType(i);
        if (this.fPT != null) {
            this.fPT.onChangeSkinType(i);
        }
    }

    private void bni() {
        if (this.fPP == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.fPP == 5) {
            showLoadingDialog("正在上传");
            new b(this, null).execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fPM.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fPP);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fPN.bnE()) {
            bni();
        } else if (view == this.fPN.bnF()) {
            if (this.fPM != null) {
                this.fPM.setLastAlbumId(null);
            }
            bnn();
        } else if (view == this.fPN.bnG()) {
            st(0);
        } else if (view == this.fPN.bnH()) {
            bnj();
        }
    }

    private void bnj() {
        if (this.fPN != null && this.fPM != null) {
            this.fPM.setOriginalImg(!this.fPM.isOriginalImg());
            if (this.fPM.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.aMb, true)) {
                    TiebaStatic.log(new ay("c10349").ab("fid", this.aMb).ab("obj_type", this.from));
                }
                bnp();
                return;
            }
            this.fPN.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o bnk() {
        return this.fPM;
    }

    public com.baidu.tbadk.img.b afG() {
        return this.anU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void st(int i) {
        T(i, true);
    }

    void T(int i, boolean z) {
        if (!this.fPO) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.fPU) {
                    this.fPN.z(false, this.fPM.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.fPU) {
                    this.fPN.z(true, this.fPM.isOriginalImg());
                    bnp();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.fPN.sA(this.bQX));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.anU.CV();
                }
            }
            this.bQX = i;
            if (this.fPN != null) {
                this.fPN.sB(this.bQX);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.fPN.sA(i)) != null) {
                beginTransaction.show(this.fPN.sz(i));
            } else {
                beginTransaction.add(u.g.fragment, this.fPN.sz(i), this.fPN.sA(i));
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
        int maxImagesAllowed = this.fPM.getMaxImagesAllowed();
        if (this.fPM.size() < maxImagesAllowed) {
            if (this.fPQ == null || this.fPQ.f(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.fPM.addChooseFile(imageFileInfo2);
                bnh();
                bno();
                this.fPN.h(imageFileInfo2);
                bnp();
                return true;
            }
            return false;
        } else if (bnl()) {
            return d(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(u.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean bnl() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.fPM.getMaxImagesAllowed();
            if (this.fPM.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.fPM.getWriteImagesInfo().getChosedFiles().get(0);
                    if (e(imageFileInfo)) {
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
    public boolean e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.fPM.delChooseFile(imageFileInfo);
        bnh();
        bno();
        this.fPN.i(imageFileInfo);
        bnp();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bQX == 0) {
                if (this.fPM != null) {
                    this.fPM.setLastAlbumId(null);
                }
                bnn();
                return true;
            } else if (this.bQX == 1) {
                st(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(int i, boolean z) {
        Fragment sz;
        if (this.fPN != null && (sz = this.fPN.sz(0)) != null && (sz instanceof ag)) {
            ((ag) sz).V(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sz;
        if (this.fPN != null && (sz = this.fPN.sz(0)) != null && (sz instanceof ag)) {
            ((ag) sz).g(imageFileInfo, z);
        }
    }

    private void bnm() {
        Fragment sz;
        if (this.fPN != null && (sz = this.fPN.sz(0)) != null && (sz instanceof ag)) {
            ((ag) sz).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment sz;
        if (this.fPN != null && (sz = this.fPN.sz(1)) != null && (sz instanceof e)) {
            ((e) sz).g(imageFileInfo, z);
        }
    }

    private void bnn() {
        Intent intent = new Intent();
        String lastAlbumId = this.fPM.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fPP);
        setResult(0, intent);
        finish();
    }

    private void bno() {
        if (this.fPM != null && this.fPN != null) {
            if (this.fPM.size() == this.fPM.getMaxImagesAllowed()) {
                this.fPN.lu(false);
            } else {
                this.fPN.lu(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            rt(this.fPM.bnA());
            T(1, false);
        }
    }

    private void rt(String str) {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.A(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    if (z) {
                        com.baidu.tbadk.core.util.m.a(null, str, rotateBitmapBydegree, 100);
                    } else {
                        com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, str, rotateBitmapBydegree, 100);
                    }
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str2);
            imageFileInfo.setTempFile(true);
            if (this.fPM.bny() != null && this.fPM.bny().size() > 0) {
                this.fPM.bny().add(1, imageFileInfo);
                d(imageFileInfo);
                this.fPM.ss(this.fPM.bny().indexOf(imageFileInfo));
                bnm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fPO = true;
        if (this.fPN != null) {
            this.fPN.onDestroy();
        }
        this.anU.CV();
        p.bnC().destory();
    }

    public void bnp() {
        if (this.fPN != null && this.fPM != null && this.fPM.bnw() != null && this.fPM.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.fPM.bnw()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.m.getFileSize(imageFileInfo.getFilePath());
                }
            }
            this.fPN.a(true, j);
        }
    }

    public void ru(String str) {
        this.fPV = str;
        if (!com.baidu.tbadk.core.util.ag.c(getPageContext().getPageActivity(), 1)) {
            if (StringUtils.isNull(this.fPV)) {
                au.c(getPageContext());
            } else {
                au.b(getPageContext(), this.fPV);
            }
        }
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ag.Q(getApplicationContext())) {
                if (StringUtils.isNull(this.fPV)) {
                    au.c(getPageContext());
                } else {
                    au.b(getPageContext(), this.fPV);
                }
            } else {
                showToast(u.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(u.j.sdcard_permission_denied_advert_for_camera);
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
            new com.baidu.tbadk.img.c(null).c(AlbumActivity.this.fPM.getWriteImagesInfo(), true);
            return AlbumActivity.this.fPM.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, str);
            AlbumActivity.this.setResult(-1, intent);
            AlbumActivity.this.finish();
        }
    }
}
