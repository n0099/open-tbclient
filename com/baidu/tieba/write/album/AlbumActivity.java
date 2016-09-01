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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AlbumActivity extends BaseFragmentActivity implements View.OnClickListener, a.InterfaceC0000a {
    private com.baidu.tbadk.img.b arb;
    private o fZQ;
    private t fZR;
    private y fZU;
    private int ccg = 0;
    private boolean fZS = false;
    private int fZT = 0;
    private String from = "";
    private String aRv = "";
    private boolean fZV = false;
    private AlertDialog fZW = null;
    private a fZX = null;
    private boolean fZY = false;
    private String fZZ = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.arb = new com.baidu.tbadk.img.b();
        initView();
        initData(bundle);
        brw();
        sU(0);
        brx();
        boolean z = com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("add_img_water_tip_show", true);
        if (!(com.baidu.tbadk.core.l.oG().oK() != 0) && z && bru()) {
            brv();
            com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("add_img_water_tip_show", false);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public int ait;
        private TextView bqm;
        private TextView gab;
        private TextView gac;

        public a(View view) {
            super(view);
            this.ait = 3;
            this.bqm = (TextView) view.findViewById(t.g.img_water_setting_title);
            this.gab = (TextView) view.findViewById(t.g.img_water_setting_content);
            this.gac = (TextView) view.findViewById(t.g.goto_setting);
            this.gac.setOnClickListener(new c(this));
            brG();
        }

        private void brG() {
            av.c(this.bqm, t.d.cp_cont_g, 1);
            av.c(this.gab, t.d.cp_cont_g, 1);
            av.c(this.gac, t.d.cp_link_tip_a, 1);
        }

        public void onChangeSkinType(int i) {
            if (this.ait != i) {
                brG();
                this.ait = i;
            }
            if (AlbumActivity.this.fZR != null) {
                AlbumActivity.this.fZR.tc(AlbumActivity.this.ccg);
            }
        }
    }

    private boolean bru() {
        return 2 == this.fZT || 3 == this.fZT || 1 == this.fZT || 3 == this.fZT || "frs".equals(this.from) || "pb".equals(this.from) || "from_writeActivity_livePhoto".equals(this.from);
    }

    private void brv() {
        if (this.fZX == null) {
            this.fZX = new a(LayoutInflater.from(getActivity()).inflate(t.h.dialog_img_water_setting, (ViewGroup) null));
        }
        this.fZW = new AlertDialog.Builder(getActivity()).create();
        this.fZW.show();
        Window window = this.fZW.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.5f;
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = 0 - (com.baidu.adp.lib.util.k.L(getActivity()) / 5);
        window.setAttributes(attributes);
        window.setContentView(this.fZX.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fZW != null) {
            com.baidu.adp.lib.h.h.eG().postDelayed(new com.baidu.tieba.write.album.a(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fZW != null) {
            this.fZW.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.fZQ.getWriteImagesInfo().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.fZY);
    }

    private void initData(Bundle bundle) {
        this.fZQ = new o(this);
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fZQ.setWriteImagesInfo(writeImagesInfo);
            this.fZQ.sh(bundle.getString(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fZY = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.fZQ.setWriteImagesInfo(writeImagesInfo2);
            this.fZQ.sh(intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME));
            this.fZT = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.from = intent.getStringExtra("from");
            this.aRv = intent.getStringExtra("forum_id");
            if ("from_writeActivity_livePhoto".equals(this.from)) {
                this.fZV = true;
            } else {
                this.fZV = false;
            }
            if (this.fZT == 2) {
                this.fZU = new com.baidu.tieba.write.album.b(this);
            }
            this.fZQ.lH(intent.getBooleanExtra(AlbumActivityConfig.AUTO_PHOTO_NAME, false));
            this.fZY = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
        }
    }

    private void initView() {
        this.fZR = new t(this);
        this.fZR.brT();
    }

    private void brw() {
        if (this.fZR != null && this.fZQ != null) {
            this.fZR.sZ(this.fZQ.getMaxImagesAllowed());
            if (this.fZQ.brM() != null) {
                for (ImageFileInfo imageFileInfo : this.fZQ.brM()) {
                    this.fZR.h(imageFileInfo);
                }
            }
            brE();
        }
    }

    private void brx() {
        String string;
        int size = this.fZQ.size();
        boolean z = size != 0;
        if (this.fZT == 5) {
            string = getPageContext().getPageActivity().getString(t.j.album_upload_btn, new Object[]{Integer.valueOf(size)});
        } else if (this.fZV) {
            string = getPageContext().getPageActivity().getString(t.j.live_album_finish_btn, new Object[]{Integer.valueOf(size)});
        } else {
            string = getPageContext().getPageActivity().getString(t.j.album_finish_btn, new Object[]{Integer.valueOf(size)});
        }
        this.fZR.n(z, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fZR.onChangeSkinType(i);
        if (this.fZX != null) {
            this.fZX.onChangeSkinType(i);
        }
    }

    private void bry() {
        if (this.fZT == 3) {
            TiebaStatic.log("c10489");
        }
        if (this.fZT == 5) {
            showLoadingDialog("正在上传");
            new b(this, null).execute(new String[0]);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.fZQ.getWriteImagesInfo().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fZT);
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fZR.brU()) {
            bry();
        } else if (view == this.fZR.brV()) {
            if (this.fZQ != null) {
                this.fZQ.setLastAlbumId(null);
            }
            brD();
        } else if (view == this.fZR.brW()) {
            sU(0);
        } else if (view == this.fZR.brX()) {
            brz();
        }
    }

    private void brz() {
        if (this.fZR != null && this.fZQ != null) {
            this.fZQ.setOriginalImg(!this.fZQ.isOriginalImg());
            if (this.fZQ.isOriginalImg()) {
                if (!StringUtils.isNull(this.from, true) && !StringUtils.isNull(this.aRv, true)) {
                    TiebaStatic.log(new ay("c10349").ab("fid", this.aRv).ab("obj_type", this.from));
                }
                brF();
                return;
            }
            this.fZR.a(false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o brA() {
        return this.fZQ;
    }

    public com.baidu.tbadk.img.b akr() {
        return this.arb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sU(int i) {
        V(i, true);
    }

    void V(int i, boolean z) {
        if (!this.fZS) {
            if (i == 0) {
                setSwipeBackEnabled(true);
                if (this.fZY) {
                    this.fZR.C(false, this.fZQ.isOriginalImg());
                }
            } else {
                setSwipeBackEnabled(false);
                if (this.fZY) {
                    this.fZR.C(true, this.fZQ.isOriginalImg());
                    brF();
                }
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.fZR.tb(this.ccg));
            if (findFragmentByTag != null) {
                beginTransaction.hide(findFragmentByTag);
                if (z) {
                    this.arb.Eq();
                }
            }
            this.ccg = i;
            if (this.fZR != null) {
                this.fZR.tc(this.ccg);
            }
            if (getSupportFragmentManager().findFragmentByTag(this.fZR.tb(i)) != null) {
                beginTransaction.show(this.fZR.ta(i));
            } else {
                beginTransaction.add(t.g.fragment, this.fZR.ta(i), this.fZR.tb(i));
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
        int maxImagesAllowed = this.fZQ.getMaxImagesAllowed();
        if (this.fZQ.size() < maxImagesAllowed) {
            if (this.fZU == null || this.fZU.f(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                this.fZQ.addChooseFile(imageFileInfo2);
                brx();
                brE();
                this.fZR.h(imageFileInfo2);
                brF();
                return true;
            }
            return false;
        } else if (brB()) {
            return d(imageFileInfo);
        } else {
            showToast(String.format(getPageContext().getContext().getString(t.j.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
            return false;
        }
    }

    public boolean brB() {
        if (getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false)) {
            int maxImagesAllowed = this.fZQ.getMaxImagesAllowed();
            if (this.fZQ.size() == maxImagesAllowed && maxImagesAllowed == 1) {
                try {
                    ImageFileInfo imageFileInfo = this.fZQ.getWriteImagesInfo().getChosedFiles().get(0);
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
        this.fZQ.delChooseFile(imageFileInfo);
        brx();
        brE();
        this.fZR.i(imageFileInfo);
        brF();
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ccg == 0) {
                if (this.fZQ != null) {
                    this.fZQ.setLastAlbumId(null);
                }
                brD();
                return true;
            } else if (this.ccg == 1) {
                sU(0);
                return true;
            } else {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(int i, boolean z) {
        Fragment ta;
        if (this.fZR != null && (ta = this.fZR.ta(0)) != null && (ta instanceof ag)) {
            ((ag) ta).X(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ta;
        if (this.fZR != null && (ta = this.fZR.ta(0)) != null && (ta instanceof ag)) {
            ((ag) ta).g(imageFileInfo, z);
        }
    }

    private void brC() {
        Fragment ta;
        if (this.fZR != null && (ta = this.fZR.ta(0)) != null && (ta instanceof ag)) {
            ((ag) ta).refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ImageFileInfo imageFileInfo, boolean z) {
        Fragment ta;
        if (this.fZR != null && (ta = this.fZR.ta(1)) != null && (ta instanceof e)) {
            ((e) ta).g(imageFileInfo, z);
        }
    }

    private void brD() {
        Intent intent = new Intent();
        String lastAlbumId = this.fZQ.getLastAlbumId();
        if (TextUtils.isEmpty(lastAlbumId)) {
            lastAlbumId = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, lastAlbumId);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.fZT);
        setResult(0, intent);
        finish();
    }

    private void brE() {
        if (this.fZQ != null && this.fZR != null) {
            if (this.fZQ.size() == this.fZQ.getMaxImagesAllowed()) {
                this.fZR.lK(false);
            } else {
                this.fZR.lK(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12001) {
            sd(this.fZQ.brQ());
            V(1, false);
        }
    }

    private void sd(String str) {
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
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str2, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
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
            if (this.fZQ.brO() != null && this.fZQ.brO().size() > 0) {
                this.fZQ.brO().add(1, imageFileInfo);
                d(imageFileInfo);
                this.fZQ.sT(this.fZQ.brO().indexOf(imageFileInfo));
                brC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fZS = true;
        if (this.fZR != null) {
            this.fZR.onDestroy();
        }
        this.arb.Eq();
        p.brS().destory();
    }

    public void brF() {
        if (this.fZR != null && this.fZQ != null && this.fZQ.brM() != null && this.fZQ.isOriginalImg()) {
            long j = 0;
            for (ImageFileInfo imageFileInfo : this.fZQ.brM()) {
                if (imageFileInfo != null) {
                    j += com.baidu.tbadk.core.util.m.getFileSize(imageFileInfo.getFilePath());
                }
            }
            this.fZR.a(true, j);
        }
    }

    public void se(String str) {
        this.fZZ = str;
        if (!com.baidu.tbadk.core.util.ag.d(getPageContext().getPageActivity(), 1)) {
            if (StringUtils.isNull(this.fZZ)) {
                au.c(getPageContext());
            } else {
                au.b(getPageContext(), this.fZZ);
            }
        }
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ag.aa(getApplicationContext())) {
                if (StringUtils.isNull(this.fZZ)) {
                    au.c(getPageContext());
                } else {
                    au.b(getPageContext(), this.fZZ);
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
            new com.baidu.tbadk.img.c(null).c(AlbumActivity.this.fZQ.getWriteImagesInfo(), true);
            return AlbumActivity.this.fZQ.getWriteImagesInfo().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: eu */
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, str);
            AlbumActivity.this.setResult(-1, intent);
            AlbumActivity.this.finish();
        }
    }
}
