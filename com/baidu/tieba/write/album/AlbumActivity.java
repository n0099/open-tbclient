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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0000a {
    private com.baidu.tbadk.img.b amz;
    private y eXA;
    private o eXw;
    private t eXx;
    private int brH = 0;
    private boolean eXy = false;
    private int eXz = 0;
    private String from = "";
    private String fid = "";
    private boolean eXB = false;
    private AlertDialog eXC = null;
    private a eXD = null;
    private boolean eXE = false;
    private String eXF = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.amz = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        bbq();
        qI(0);
        bbr();
        boolean z = com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.l.ob().of() != 0) && z && bbo()) {
            bbp();
            com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public int aej;
        private TextView bxj;
        private TextView eXH;
        private TextView eXI;

        public a(View view) {
            super(view);
            this.aej = 3;
            this.bxj = (TextView) view.findViewById(t.g.img_water_setting_title);
            this.eXH = (TextView) view.findViewById(t.g.img_water_setting_content);
            this.eXI = (TextView) view.findViewById(t.g.goto_setting);
            this.eXI.setOnClickListener(new c(this));
            anL();
        }

        private void anL() {
            at.c(this.bxj, t.d.cp_cont_g, 1);
            at.c(this.eXH, t.d.cp_cont_g, 1);
            at.c(this.eXI, t.d.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aej != i) {
                anL();
                this.aej = i;
            }
            if (AlbumActivity.this.eXx != null) {
                AlbumActivity.this.eXx.qQ(AlbumActivity.this.brH);
            }
        }
    }

    private boolean bbo() {
        return 2 == this.eXz || 3 == this.eXz || 1 == this.eXz || 3 == this.eXz || "frs".equals(this.from) || "pb".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bbp() {
        if (this.eXD == null) {
            this.eXD = new a(LayoutInflater.from(getActivity()).inflate(t.h.dialog_img_water_setting, (ViewGroup) null));
        }
        this.eXC = new AlertDialog.Builder(getActivity()).create();
        this.eXC.show();
        Window window = this.eXC.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.C(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.eXD.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eXC != null) {
            com.baidu.adp.lib.h.h.dL().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.eXC != null) {
            this.eXC.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.eXw.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.eXE);
    }

    private void initData(Bundle bundle) {
        this.eXw = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.eXw.setWriteImagesInfo(writeImagesInfo);
            this.eXw.pc(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.eXE = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.eXw.setWriteImagesInfo(writeImagesInfo2);
            this.eXw.pc(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.eXz = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.eXB = true;
            } else {
                this.eXB = false;
            }
            if (this.eXz == 2) {
                this.eXA = new b(this);
            }
            this.eXw.ks(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.eXE = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.eXx = new t(this);
        this.eXx.bbL();
    }

    private void bbq() {
        if (this.eXx != null && this.eXw != null) {
            this.eXx.qN(this.eXw.getMaxImagesAllowed());
            if (this.eXw.bbE() != null) {
                for (ImageFileInfo imageFileInfo : this.eXw.bbE()) {
                    this.eXx.g(imageFileInfo);
                }
            }
            bbx();
        }
    }

    private void bbr() {
        int size = this.eXw.size();
        this.eXx.p(size != 0, getPageContext().getPageActivity().getString(this.eXB ? t.j.live_album_finish_btn : t.j.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.eXx.onChangeSkinType(i);
        if (this.eXD != null) {
            this.eXD.onChangeSkinType(i);
        }
    }

    private void bbs() {
        if (this.eXz == 3) {
            TiebaStatic.log("c10489");
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.eXw.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.eXz);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eXx.bbM()) {
            bbs();
        } else if (view == this.eXx.bbN()) {
            if (this.eXw != null) {
                this.eXw.setLastAlbumId(null);
            }
            bbw();
        } else if (view == this.eXx.bbO()) {
            qI(0);
        } else if (view == this.eXx.bbP()) {
            bbt();
        }
    }

    private void bbt() {
        if (this.eXx != null && this.eXw != null) {
            this.eXw.setOriginalImg(!this.eXw.isOriginalImg());
            if (this.eXw.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new aw("c10349").ac("fid", this.fid).ac("obj_type", this.from));
                }
                bby();
                return;
            }
            this.eXx.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o bbu() {
        return this.eXw;
    }

    public com.baidu.tbadk.img.b YK() {
        return this.amz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qI(int i) {
        B(i, true);
    }

    void B(int i, boolean z) {
        if (!this.eXy) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.eXE) {
                    this.eXx.y(false, this.eXw.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.eXE) {
                    this.eXx.y(true, this.eXw.isOriginalImg());
                    bby();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.eXx.qP(this.brH));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.amz.CO();
                }
            }
            this.brH = i;
            if (this.eXx != null) {
                this.eXx.qQ(this.brH);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.eXx.qP(i)) != null) {
                beginTransaction.show(this.eXx.qO(i));
            } else {
                beginTransaction.add(t.g.fragment, this.eXx.qO(i), this.eXx.qP(i));
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
        int maxImagesAllowed = this.eXw.getMaxImagesAllowed();
        if (this.eXw.size() < maxImagesAllowed) {
            if (this.eXA == null || this.eXA.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.eXw.addChooseFile(imageFileInfo2);
                bbr();
                bbx();
                this.eXx.g(imageFileInfo2);
                bby();
                return true;
            }
            return false;
        }
        showToast(String.format(getPageContext().getContext().getString(t.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.eXw.delChooseFile(imageFileInfo);
        bbr();
        bbx();
        this.eXx.h(imageFileInfo);
        bby();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.brH == 0) {
                if (this.eXw != null) {
                    this.eXw.setLastAlbumId(null);
                }
                bbw();
                return true;
            } else if (this.brH == 1) {
                qI(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int i, boolean z) {
        Fragment qO;
        if (this.eXx != null && (qO = this.eXx.qO(0)) != null && (qO instanceof ag)) {
            ((ag) qO).D(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment qO;
        if (this.eXx != null && (qO = this.eXx.qO(0)) != null && (qO instanceof ag)) {
            ((ag) qO).g(imageFileInfo, z);
        }
    }

    private void bbv() {
        Fragment qO;
        if (this.eXx != null && (qO = this.eXx.qO(0)) != null && (qO instanceof ag)) {
            ((ag) qO).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment qO;
        if (this.eXx != null && (qO = this.eXx.qO(1)) != null && (qO instanceof e)) {
            ((e) qO).g(imageFileInfo, z);
        }
    }

    private void bbw() {
        Intent intent = new Intent();
        String lastAlbumId = this.eXw.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.eXz);
        setResult(0, intent);
        finish();
    }

    private void bbx() {
        if (this.eXw != null && this.eXx != null) {
            if (this.eXw.size() == this.eXw.getMaxImagesAllowed()) {
                this.eXx.kv(false);
            } else {
                this.eXx.kv(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            oY(this.eXw.bbI());
            B(1, false);
        }
    }

    private void oY(String str) {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.C(getPageContext().getPageActivity())));
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
            if (this.eXw.bbG() != null && this.eXw.bbG().size() > 0) {
                this.eXw.bbG().add(1, imageFileInfo);
                c(imageFileInfo);
                this.eXw.qG(this.eXw.bbG().indexOf(imageFileInfo));
                bbv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eXy = true;
        if (this.eXx != null) {
            this.eXx.onDestroy();
        }
        this.amz.CO();
        p.bbK().destory();
    }

    public void bby() {
        if (this.eXx != null && this.eXw != null && this.eXw.bbE() != null && this.eXw.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.eXw.bbE()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.m.dc(imageFileInfo.getFilePath());
                }
            }
            this.eXx.a(true, j);
        }
    }

    public void oZ(String str) {
        this.eXF = str;
        if (!com.baidu.tbadk.core.util.ag.b(getPageContext().getPageActivity(), 1)) {
            if (StringUtils.isNull(this.eXF)) {
                as.c(getPageContext());
            } else {
                as.b(getPageContext(), this.eXF);
            }
        }
    }

    @Override // com.baidu.a.a.a.InterfaceC0000a
    public void a(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ag.R(getApplicationContext())) {
                if (StringUtils.isNull(this.eXF)) {
                    as.c(getPageContext());
                } else {
                    as.b(getPageContext(), this.eXF);
                }
            } else {
                showToast(t.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(t.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
