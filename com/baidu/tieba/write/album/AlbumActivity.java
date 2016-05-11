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
    private y eXB;
    private o eXx;
    private t eXy;
    private int brH = 0;
    private boolean eXz = false;
    private int eXA = 0;
    private String from = "";
    private String fid = "";
    private boolean eXC = false;
    private AlertDialog eXD = null;
    private a eXE = null;
    private boolean eXF = false;
    private String eXG = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.amz = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        bbj();
        qJ(0);
        bbk();
        boolean z = com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.l.ob().of() != 0) && z && bbh()) {
            bbi();
            com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public int aej;
        private TextView bxj;
        private TextView eXI;
        private TextView eXJ;

        public a(View view) {
            super(view);
            this.aej = 3;
            this.bxj = (TextView) view.findViewById(t.g.img_water_setting_title);
            this.eXI = (TextView) view.findViewById(t.g.img_water_setting_content);
            this.eXJ = (TextView) view.findViewById(t.g.goto_setting);
            this.eXJ.setOnClickListener(new c(this));
            anI();
        }

        private void anI() {
            at.c(this.bxj, t.d.cp_cont_g, 1);
            at.c(this.eXI, t.d.cp_cont_g, 1);
            at.c(this.eXJ, t.d.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.aej != i) {
                anI();
                this.aej = i;
            }
            if (AlbumActivity.this.eXy != null) {
                AlbumActivity.this.eXy.qR(AlbumActivity.this.brH);
            }
        }
    }

    private boolean bbh() {
        return 2 == this.eXA || 3 == this.eXA || 1 == this.eXA || 3 == this.eXA || "frs".equals(this.from) || "pb".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void bbi() {
        if (this.eXE == null) {
            this.eXE = new a(LayoutInflater.from(getActivity()).inflate(t.h.dialog_img_water_setting, (ViewGroup) null));
        }
        this.eXD = new AlertDialog.Builder(getActivity()).create();
        this.eXD.show();
        Window window = this.eXD.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.C(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.eXE.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eXD != null) {
            com.baidu.adp.lib.h.h.dL().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.eXD != null) {
            this.eXD.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.eXx.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.eXF);
    }

    private void initData(Bundle bundle) {
        this.eXx = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.eXx.setWriteImagesInfo(writeImagesInfo);
            this.eXx.pc(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.eXF = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.eXx.setWriteImagesInfo(writeImagesInfo2);
            this.eXx.pc(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.eXA = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.fid = intent.getStringExtra("forum_id");
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.eXC = true;
            } else {
                this.eXC = false;
            }
            if (this.eXA == 2) {
                this.eXB = new b(this);
            }
            this.eXx.ks(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.eXF = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.eXy = new t(this);
        this.eXy.bbE();
    }

    private void bbj() {
        if (this.eXy != null && this.eXx != null) {
            this.eXy.qO(this.eXx.getMaxImagesAllowed());
            if (this.eXx.bbx() != null) {
                for (ImageFileInfo imageFileInfo : this.eXx.bbx()) {
                    this.eXy.g(imageFileInfo);
                }
            }
            bbq();
        }
    }

    private void bbk() {
        int size = this.eXx.size();
        this.eXy.p(size != 0, getPageContext().getPageActivity().getString(this.eXC ? t.j.live_album_finish_btn : t.j.album_finish_btn, new Object[]{Integer.valueOf(size)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.eXy.onChangeSkinType(i);
        if (this.eXE != null) {
            this.eXE.onChangeSkinType(i);
        }
    }

    private void bbl() {
        if (this.eXA == 3) {
            TiebaStatic.log("c10489");
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.eXx.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.eXA);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eXy.bbF()) {
            bbl();
        } else if (view == this.eXy.bbG()) {
            if (this.eXx != null) {
                this.eXx.setLastAlbumId(null);
            }
            bbp();
        } else if (view == this.eXy.bbH()) {
            qJ(0);
        } else if (view == this.eXy.bbI()) {
            bbm();
        }
    }

    private void bbm() {
        if (this.eXy != null && this.eXx != null) {
            this.eXx.setOriginalImg(!this.eXx.isOriginalImg());
            if (this.eXx.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.fid, true)) {
                    TiebaStatic.log(new aw("c10349").ac("fid", this.fid).ac("obj_type", this.from));
                }
                bbr();
                return;
            }
            this.eXy.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o bbn() {
        return this.eXx;
    }

    public com.baidu.tbadk.img.b YI() {
        return this.amz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qJ(int i) {
        B(i, true);
    }

    void B(int i, boolean z) {
        if (!this.eXz) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.eXF) {
                    this.eXy.y(false, this.eXx.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.eXF) {
                    this.eXy.y(true, this.eXx.isOriginalImg());
                    bbr();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.eXy.qQ(this.brH));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.amz.CN();
                }
            }
            this.brH = i;
            if (this.eXy != null) {
                this.eXy.qR(this.brH);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.eXy.qQ(i)) != null) {
                beginTransaction.show(this.eXy.qP(i));
            } else {
                beginTransaction.add(t.g.fragment, this.eXy.qP(i), this.eXy.qQ(i));
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
        int maxImagesAllowed = this.eXx.getMaxImagesAllowed();
        if (this.eXx.size() < maxImagesAllowed) {
            if (this.eXB == null || this.eXB.e(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.eXx.addChooseFile(imageFileInfo2);
                bbk();
                bbq();
                this.eXy.g(imageFileInfo2);
                bbr();
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
        this.eXx.delChooseFile(imageFileInfo);
        bbk();
        bbq();
        this.eXy.h(imageFileInfo);
        bbr();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.brH == 0) {
                if (this.eXx != null) {
                    this.eXx.setLastAlbumId(null);
                }
                bbp();
                return true;
            } else if (this.brH == 1) {
                qJ(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int i, boolean z) {
        Fragment qP;
        if (this.eXy != null && (qP = this.eXy.qP(0)) != null && (qP instanceof ag)) {
            ((ag) qP).D(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment qP;
        if (this.eXy != null && (qP = this.eXy.qP(0)) != null && (qP instanceof ag)) {
            ((ag) qP).g(imageFileInfo, z);
        }
    }

    private void bbo() {
        Fragment qP;
        if (this.eXy != null && (qP = this.eXy.qP(0)) != null && (qP instanceof ag)) {
            ((ag) qP).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment qP;
        if (this.eXy != null && (qP = this.eXy.qP(1)) != null && (qP instanceof e)) {
            ((e) qP).g(imageFileInfo, z);
        }
    }

    private void bbp() {
        Intent intent = new Intent();
        String lastAlbumId = this.eXx.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.eXA);
        setResult(0, intent);
        finish();
    }

    private void bbq() {
        if (this.eXx != null && this.eXy != null) {
            if (this.eXx.size() == this.eXx.getMaxImagesAllowed()) {
                this.eXy.kv(false);
            } else {
                this.eXy.kv(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            oY(this.eXx.bbB());
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
            if (this.eXx.bbz() != null && this.eXx.bbz().size() > 0) {
                this.eXx.bbz().add(1, imageFileInfo);
                c(imageFileInfo);
                this.eXx.qH(this.eXx.bbz().indexOf(imageFileInfo));
                bbo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eXz = true;
        if (this.eXy != null) {
            this.eXy.onDestroy();
        }
        this.amz.CN();
        p.bbD().destory();
    }

    public void bbr() {
        if (this.eXy != null && this.eXx != null && this.eXx.bbx() != null && this.eXx.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.eXx.bbx()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.m.dc(imageFileInfo.getFilePath());
                }
            }
            this.eXy.a(true, j);
        }
    }

    public void oZ(String str) {
        this.eXG = str;
        if (!com.baidu.tbadk.core.util.ag.b(getPageContext().getPageActivity(), 1)) {
            if (StringUtils.isNull(this.eXG)) {
                as.c(getPageContext());
            } else {
                as.b(getPageContext(), this.eXG);
            }
        }
    }

    @Override // com.baidu.a.a.a.InterfaceC0000a
    public void a(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ag.R(getApplicationContext())) {
                if (StringUtils.isNull(this.eXG)) {
                    as.c(getPageContext());
                } else {
                    as.b(getPageContext(), this.eXG);
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
