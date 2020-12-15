package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes24.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View bFS;
    private View bFT;
    private TextView bFW;
    private int kBe;
    private NavigationBar mNavigationBar;
    private String mmd;
    private ImageView mmg;
    private FrameLayout mmh;
    private RadioButton mmn;
    private RadioButton mmo;
    private int mmu;
    private HashMap<String, Bitmap> mmv;
    private HashMap<String, ImageView> mmw;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = "delete";
    public static String mmc = "change";
    public static String FILE_NAME = "file_name";
    private float bFO = 1.0f;
    private EditHeadsImageView mme = null;
    private EditHeadsImageTopLayerView mmf = null;
    private Bitmap mBitmap = null;
    private int kDA = 0;
    private Button mmi = null;
    private Button mmj = null;
    private com.baidu.tbadk.core.view.a mmk = null;
    private b mml = null;
    private a mmm = null;
    private LinearLayout mmp = null;
    private LinearLayout mmq = null;
    private d mmr = null;
    private TextView mTitle = null;
    private Bitmap bFV = null;
    private c mms = null;
    private boolean fEV = true;
    private boolean mmt = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.kDA = intent.getIntExtra("edit_type", 0);
        this.kBe = intent.getIntExtra("request", 0);
        this.fEV = intent.getBooleanExtra("need_upload", true);
        this.mmt = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
        this.mmu = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
        this.bFO = intent.getFloatExtra("cut_image_height_scale", 1.0f);
        this.mmd = intent.getStringExtra("from_where");
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.kBe == 12002 || this.kBe == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.kBe, intent.getData(), av.btX().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.kBe, null, av.btX().getPostImageSize(), 0, stringExtra);
            }
            cTh();
            return;
        }
        initUI();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        dyX();
    }

    private void dyX() {
        ap.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.bFS);
        getLayoutMode().onModeChanged(this.bFT);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1);
        ap.setNavbarIconSrc(this.mNavigationBar.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
        ap.setViewTextColor(this.bFW, R.color.CAM_X0111, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.mml != null) {
            this.mml.cancel();
        }
        this.mme.setImageDrawable(null);
        dyY();
    }

    private void dyY() {
        if (this.mmw != null) {
            for (Map.Entry<String, ImageView> entry : this.mmw.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.mmw.clear();
            this.mmw = null;
        }
        if (this.mmv != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.mmv.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.mmv.clear();
            this.mmv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.mml != null) {
            this.mml.cancel();
        }
        this.mml = new b();
        this.mml.execute(new Object[0]);
        AccountData accountData = (AccountData) getIntent().getSerializableExtra(EditHeadActivityConfig.ACCOUNTDATA);
        if (accountData != null) {
            TbadkCoreApplication.setCurrentAccountFromRemoteProcessInUIThread(accountData, getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.mme.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.mmr != null) {
            this.mmr.cancel();
        }
        if (this.bFV != null && !this.bFV.isRecycled()) {
            this.bFV.recycle();
            this.bFV = null;
        }
        if (this.mml != null) {
            this.mml.cancel();
            this.mml = null;
        }
        this.mmk.setDialogVisiable(false);
        if (this.kBe == 12002 || this.kBe == 12001) {
            unregisterReceiver(this.mms);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyZ() {
        if (this.mmr != null) {
            this.mmr.cancel();
        }
        this.mmr = new d();
        this.mmr.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mmk = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mmk.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.mmk.setDialogVisiable(false);
            }
        });
        this.mmk.setDialogVisiable(false);
        this.mmf = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.mmd) && this.bFO != 1.0f) {
            this.mmf.setmCutHeightScale(this.bFO);
        }
        this.mmg = (ImageView) findViewById(R.id.preview_image);
        this.mmh = (FrameLayout) findViewById(R.id.preview_layout);
        int[] screenDimensions = l.getScreenDimensions(getPageContext().getPageActivity());
        this.mmh.setY((int) (screenDimensions[0] + ((screenDimensions[1] - screenDimensions[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.mme = (EditHeadsImageView) findViewById(R.id.image);
        this.mme.setCutImageHeightScale(this.bFO);
        if (this.mBitmap != null) {
            this.mme.setImageBitmap(this.mBitmap);
        }
        this.mme.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.mmh != null && EditHeadActivity.this.mmh.getVisibility() == 0) {
                    EditHeadActivity.this.mmg.setImageBitmap(EditHeadActivity.this.mme.cZ(false));
                }
            }
        });
        this.mme.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.mmh != null && EditHeadActivity.this.mmh.getVisibility() == 0) {
                    EditHeadActivity.this.mmg.setImageBitmap(EditHeadActivity.this.mme.cZ(false));
                }
            }
        });
        this.bFS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.mmj = (Button) findViewById(R.id.show_button);
        this.mmj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.mmq.setVisibility(0);
                EditHeadActivity.this.mmj.setVisibility(8);
                EditHeadActivity.this.mmo.setPadding(0, EditHeadActivity.this.mmo.getPaddingTop(), EditHeadActivity.this.mmo.getPaddingRight(), EditHeadActivity.this.mmo.getPaddingBottom());
                EditHeadActivity.this.mmo.setChecked(true);
                EditHeadActivity.this.mmn.setVisibility(8);
            }
        });
        this.mmi = (Button) findViewById(R.id.hide_button);
        this.mmi.setVisibility(0);
        this.mmi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.mmq.setVisibility(8);
                EditHeadActivity.this.mmj.setVisibility(0);
            }
        });
        this.bFT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.bFT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.kDA == 0) {
                    if (!EditHeadActivity.this.fEV) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap cZ = EditHeadActivity.this.mme.cZ(EditHeadActivity.this.kDA == 0 || EditHeadActivity.this.kDA == 3);
                if (cZ != null && EditHeadActivity.this.c(str, cZ)) {
                    if (EditHeadActivity.this.kDA == 0) {
                        if (EditHeadActivity.this.fEV) {
                            EditHeadActivity.this.dyZ();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(n.getFileDireciory(str), "head");
                    aVar.setServerResizeForIMImage();
                    aVar.a(new a.c() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7.1
                        @Override // com.baidu.tbadk.img.a.c
                        public void a(String str2, ImageUploadResult imageUploadResult) {
                            EditHeadActivity.this.closeLoadingDialog();
                            Intent intent2 = EditHeadActivity.this.getIntent();
                            if (imageUploadResult != null) {
                                if (imageUploadResult.error_code != 0) {
                                    EditHeadActivity.this.showToast(R.string.upload_pic_error, false);
                                } else {
                                    PhotoUrlData photoUrlData = new PhotoUrlData();
                                    photoUrlData.setPicId(String.valueOf(imageUploadResult.picId));
                                    if (imageUploadResult.picInfo != null) {
                                        if (imageUploadResult.picInfo.bigPic != null) {
                                            photoUrlData.setBigurl(imageUploadResult.picInfo.bigPic.picUrl);
                                        }
                                        if (imageUploadResult.picInfo.smallPic != null) {
                                            photoUrlData.setSmallurl(imageUploadResult.picInfo.smallPic.picUrl);
                                        }
                                        if (imageUploadResult.picInfo.originPic != null) {
                                            photoUrlData.setOriginPic(imageUploadResult.picInfo.originPic.picUrl);
                                        }
                                        if (imageUploadResult.getUploadedPicInfo() != null && !StringUtils.isNull(imageUploadResult.getUploadedPicInfo().toPostString())) {
                                            photoUrlData.setToServerPhotoInfo(imageUploadResult.getUploadedPicInfo().toPostString());
                                        }
                                    }
                                    if ("from_misson_set_cover".equals(EditHeadActivity.this.mmd)) {
                                        EditHeadActivity.this.c(photoUrlData);
                                    }
                                    intent2.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                                    intent2.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
                                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.mmd)) {
                                        Intent intent3 = new Intent();
                                        intent3.setAction("com.tieba.action.ImagePickerPlugin");
                                        intent3.putExtra("pic_info", photoUrlData);
                                        EditHeadActivity.this.sendBroadcast(intent3);
                                    }
                                }
                            }
                            EditHeadActivity.this.setResult(-1, intent2);
                            EditHeadActivity.this.finish();
                        }
                    });
                    aVar.sz(EditHeadActivity.this.mmu);
                    aVar.loadPic(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.bFT.setEnabled(false);
        this.bFW = (TextView) this.bFT.findViewById(R.id.save);
        this.bFW.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.mmd)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.mmd)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.mmq = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.mmp = (LinearLayout) findViewById(R.id.rotate);
        this.mmn = (RadioButton) findViewById(R.id.beautify_btn);
        this.mmo = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.mmn) {
                        EditHeadActivity.this.mmp.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.mmo) {
                        EditHeadActivity.this.mmp.setVisibility(0);
                    }
                }
            }
        };
        this.mmn.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mmo.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mmn.setChecked(true);
        Button button = (Button) findViewById(R.id.rotate_left);
        Button button2 = (Button) findViewById(R.id.rotate_right);
        Button button3 = (Button) findViewById(R.id.rotate_left_right);
        Button button4 = (Button) findViewById(R.id.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!EditHeadActivity.this.mmk.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.bFV != null) && view.getTag() != null) {
                        EditHeadActivity.this.QX(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.mmd)) {
            this.mmh.setVisibility(0);
            this.mmj.setVisibility(8);
            this.mmf.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.mmf.setLineWidth(2);
        }
        if (!this.mmt) {
            this.mmj.setVisibility(8);
            this.mTitle.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QX(String str) {
        if (this.mmm != null) {
            this.mmm.cancel();
        }
        this.mmm = new a();
        this.mmm.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap image = n.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (image.getWidth() > 1800 || image.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(image, 1800);
                        try {
                            image.recycle();
                            image = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (!isCancelled() || image == null || image.isRecycled()) {
                        return image;
                    }
                    image.recycle();
                    return null;
                } catch (Exception e2) {
                    bitmap = image;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.mmk.setDialogVisiable(true);
            EditHeadActivity.this.bFT.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.mml = null;
            EditHeadActivity.this.mmk.setDialogVisiable(false);
            EditHeadActivity.this.bFT.setClickable(true);
            EditHeadActivity.this.bFT.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.mml = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.mmk.setDialogVisiable(false);
            EditHeadActivity.this.bFT.setClickable(true);
            EditHeadActivity.this.bFT.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.mme.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.mme.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            n.a(null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String mmy;
        private Boolean mmz = false;
        private Boolean mmA = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.mmk.setDialogVisiable(true);
            EditHeadActivity.this.bFT.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public Bitmap doInBackground(String... strArr) {
            this.mmy = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.bFV == null) {
                return null;
            }
            if (this.mmy.equals("0") || this.mmy.equals("1")) {
                this.mmz = true;
            } else if (this.mmy.equals("2") || this.mmy.equals("3")) {
                this.mmA = true;
            }
            if (this.mmz.booleanValue() || this.mmA.booleanValue()) {
                if (EditHeadActivity.this.bFV != null) {
                    this.bitmap = EditHeadActivity.this.bFV.copy(EditHeadActivity.this.bFV.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.mmz.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mmy));
            } else if (this.mmA.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mmy));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.bFV != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.mmk.setDialogVisiable(false);
            EditHeadActivity.this.bFT.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.mmk.setDialogVisiable(false);
            EditHeadActivity.this.bFT.setClickable(true);
            EditHeadActivity.this.bFT.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.mmz.booleanValue() || this.mmA.booleanValue()) {
                    EditHeadActivity.this.mme.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, 1800);
                    }
                    if (this.mmz.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mmy));
                    } else if (this.mmA.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mmy));
                    }
                } else {
                    EditHeadActivity.this.mme.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.bFV != null && !EditHeadActivity.this.bFV.isRecycled()) {
                    EditHeadActivity.this.bFV.recycle();
                }
                EditHeadActivity.this.bFV = bitmap;
            }
        }
    }

    private void cTh() {
        this.mms = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.mms, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            EditHeadActivity.this.releaseResouce();
            if (intent.getBooleanExtra("result", false)) {
                EditHeadActivity.this.initData();
                return;
            }
            EditHeadActivity.this.showToast(intent.getStringExtra(BdStatsConstant.StatsType.ERROR));
            if (EditHeadActivity.this.bFT != null) {
                EditHeadActivity.this.bFT.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PhotoUrlData photoUrlData) {
        Intent intent = new Intent(EditHeadActivityConfig.ACTION_UPLOAD_SUCCESS);
        intent.putExtra(EditHeadActivityConfig.PIC_INFO, photoUrlData);
        getPageContext().getPageActivity().sendBroadcast(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        private aa mNetwork;

        private d() {
            this.mNetwork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.BV(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.btv().buf().isRequestSuccess()) {
                    return str;
                }
                return null;
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                return str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.closeLoadingDialog();
            EditHeadActivity.this.mmr = null;
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                if (this.mNetwork.btv().buf().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.mmd)) {
                        Intent intent2 = new Intent();
                        intent2.setAction("com.tieba.action.ImagePickerPlugin");
                        intent2.putExtra("isHeadImage", true);
                        EditHeadActivity.this.sendBroadcast(intent2);
                    }
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(R.string.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }
    }
}
