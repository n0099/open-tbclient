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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View awB;
    private View awC;
    private TextView awF;
    private int hFu;
    private String jib;
    private ImageView jif;
    private FrameLayout jig;
    private RadioButton jim;
    private RadioButton jin;
    private HashMap<String, Bitmap> jis;
    private HashMap<String, ImageView> jit;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = "delete";
    public static String jia = "change";
    public static String FILE_NAME = "file_name";
    private float awx = 1.0f;
    private EditHeadsImageView jic = null;
    private EditHeadsImageTopLayerView jie = null;
    private Bitmap mBitmap = null;
    private int hHR = 0;
    private Button jih = null;
    private Button jii = null;
    private com.baidu.tbadk.core.view.a jij = null;
    private b jik = null;
    private a jil = null;
    private LinearLayout jio = null;
    private LinearLayout jip = null;
    private d jiq = null;
    private TextView mTitle = null;
    private Bitmap awE = null;
    private c jir = null;
    private boolean dBQ = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.hHR = intent.getIntExtra("edit_type", 0);
        this.hFu = intent.getIntExtra("request", 0);
        this.dBQ = intent.getBooleanExtra("need_upload", true);
        this.awx = intent.getFloatExtra("cut_image_height_scale", 1.0f);
        this.jib = intent.getStringExtra("from_where");
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.hFu == 12002 || this.hFu == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.hFu, intent.getData(), ar.aEq().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.hFu, null, ar.aEq().getPostImageSize(), 0, stringExtra);
            }
            bQe();
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
        cum();
    }

    private void cum() {
        am.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.awB);
        getLayoutMode().onModeChanged(this.awC);
        am.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1);
        am.setNavbarIconSrc(this.mNavigationBar.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
        am.setViewTextColor(this.awF, R.color.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.jik != null) {
            this.jik.cancel();
        }
        this.jic.setImageDrawable(null);
        cun();
    }

    private void cun() {
        if (this.jit != null) {
            for (Map.Entry<String, ImageView> entry : this.jit.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.jit.clear();
            this.jit = null;
        }
        if (this.jis != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.jis.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.jis.clear();
            this.jis = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.jik != null) {
            this.jik.cancel();
        }
        this.jik = new b();
        this.jik.execute(new Object[0]);
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
        this.jic.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.jiq != null) {
            this.jiq.cancel();
        }
        if (this.awE != null && !this.awE.isRecycled()) {
            this.awE.recycle();
            this.awE = null;
        }
        if (this.jik != null) {
            this.jik.cancel();
            this.jik = null;
        }
        this.jij.setDialogVisiable(false);
        if (this.hFu == 12002 || this.hFu == 12001) {
            unregisterReceiver(this.jir);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuo() {
        if (this.jiq != null) {
            this.jiq.cancel();
        }
        this.jiq = new d();
        this.jiq.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.jij = new com.baidu.tbadk.core.view.a(getPageContext());
        this.jij.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.jij.setDialogVisiable(false);
            }
        });
        this.jij.setDialogVisiable(false);
        this.jie = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        this.jif = (ImageView) findViewById(R.id.preview_image);
        this.jig = (FrameLayout) findViewById(R.id.preview_layout);
        int[] screenDimensions = l.getScreenDimensions(getPageContext().getPageActivity());
        this.jig.setY((int) (screenDimensions[0] + ((screenDimensions[1] - screenDimensions[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.jic = (EditHeadsImageView) findViewById(R.id.image);
        this.jic.setCutImageHeightScale(this.awx);
        if (this.mBitmap != null) {
            this.jic.setImageBitmap(this.mBitmap);
        }
        this.jic.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.jig != null && EditHeadActivity.this.jig.getVisibility() == 0) {
                    EditHeadActivity.this.jif.setImageBitmap(EditHeadActivity.this.jic.be(false));
                }
            }
        });
        this.jic.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.jig != null && EditHeadActivity.this.jig.getVisibility() == 0) {
                    EditHeadActivity.this.jif.setImageBitmap(EditHeadActivity.this.jic.be(false));
                }
            }
        });
        this.awB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.jii = (Button) findViewById(R.id.show_button);
        this.jii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.jip.setVisibility(0);
                EditHeadActivity.this.jii.setVisibility(8);
                EditHeadActivity.this.jin.setPadding(0, EditHeadActivity.this.jin.getPaddingTop(), EditHeadActivity.this.jin.getPaddingRight(), EditHeadActivity.this.jin.getPaddingBottom());
                EditHeadActivity.this.jin.setChecked(true);
                EditHeadActivity.this.jim.setVisibility(8);
            }
        });
        this.jih = (Button) findViewById(R.id.hide_button);
        this.jih.setVisibility(0);
        this.jih.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.jip.setVisibility(8);
                EditHeadActivity.this.jii.setVisibility(0);
            }
        });
        this.awC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.awC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.hHR == 0) {
                    if (!EditHeadActivity.this.dBQ) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap be = EditHeadActivity.this.jic.be(EditHeadActivity.this.hHR == 0 || EditHeadActivity.this.hHR == 3);
                if (be != null && EditHeadActivity.this.c(str, be)) {
                    if (EditHeadActivity.this.hHR == 0) {
                        if (EditHeadActivity.this.dBQ) {
                            EditHeadActivity.this.cuo();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(m.getFileDireciory(str), "head");
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
                                        if (imageUploadResult.getUploadedPicInfo() != null && !StringUtils.isNull(imageUploadResult.getUploadedPicInfo().toPostString())) {
                                            photoUrlData.setToServerPhotoInfo(imageUploadResult.getUploadedPicInfo().toPostString());
                                        }
                                    }
                                    if ("from_misson_set_cover".equals(EditHeadActivity.this.jib)) {
                                        EditHeadActivity.this.c(photoUrlData);
                                    }
                                    intent2.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                                    intent2.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
                                }
                            }
                            EditHeadActivity.this.setResult(-1, intent2);
                            EditHeadActivity.this.finish();
                        }
                    });
                    aVar.loadPic(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.awC.setEnabled(false);
        this.awF = (TextView) this.awC.findViewById(R.id.save);
        this.awF.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.jib)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.jib)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.jip = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.jio = (LinearLayout) findViewById(R.id.rotate);
        this.jim = (RadioButton) findViewById(R.id.beautify_btn);
        this.jin = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.jim) {
                        EditHeadActivity.this.jio.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.jin) {
                        EditHeadActivity.this.jio.setVisibility(0);
                    }
                }
            }
        };
        this.jim.setOnCheckedChangeListener(onCheckedChangeListener);
        this.jin.setOnCheckedChangeListener(onCheckedChangeListener);
        this.jim.setChecked(true);
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
                if (!EditHeadActivity.this.jij.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.awE != null) && view.getTag() != null) {
                        EditHeadActivity.this.Gt(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.jib)) {
            this.jig.setVisibility(0);
            this.jii.setVisibility(8);
            this.jie.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.jie.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gt(String str) {
        if (this.jil != null) {
            this.jil.cancel();
        }
        this.jil = new a();
        this.jil.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap image = m.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
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
            EditHeadActivity.this.jij.setDialogVisiable(true);
            EditHeadActivity.this.awC.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.jik = null;
            EditHeadActivity.this.jij.setDialogVisiable(false);
            EditHeadActivity.this.awC.setClickable(true);
            EditHeadActivity.this.awC.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.jik = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.jij.setDialogVisiable(false);
            EditHeadActivity.this.awC.setClickable(true);
            EditHeadActivity.this.awC.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.jic.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.jic.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            m.a(null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String jiv;
        private Boolean jiw = false;
        private Boolean jix = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.jij.setDialogVisiable(true);
            EditHeadActivity.this.awC.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public Bitmap doInBackground(String... strArr) {
            this.jiv = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.awE == null) {
                return null;
            }
            if (this.jiv.equals("0") || this.jiv.equals("1")) {
                this.jiw = true;
            } else if (this.jiv.equals("2") || this.jiv.equals("3")) {
                this.jix = true;
            }
            if (this.jiw.booleanValue() || this.jix.booleanValue()) {
                if (EditHeadActivity.this.awE != null) {
                    this.bitmap = EditHeadActivity.this.awE.copy(EditHeadActivity.this.awE.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.jiw.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.jiv));
            } else if (this.jix.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.jiv));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.awE != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.jij.setDialogVisiable(false);
            EditHeadActivity.this.awC.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.jij.setDialogVisiable(false);
            EditHeadActivity.this.awC.setClickable(true);
            EditHeadActivity.this.awC.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.jiw.booleanValue() || this.jix.booleanValue()) {
                    EditHeadActivity.this.jic.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, 1800);
                    }
                    if (this.jiw.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.jiv));
                    } else if (this.jix.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.jiv));
                    }
                } else {
                    EditHeadActivity.this.jic.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.awE != null && !EditHeadActivity.this.awE.isRecycled()) {
                    EditHeadActivity.this.awE.recycle();
                }
                EditHeadActivity.this.awE = bitmap;
            }
        }
    }

    private void bQe() {
        this.jir = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.jir, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
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
            if (EditHeadActivity.this.awC != null) {
                EditHeadActivity.this.awC.setEnabled(false);
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
    /* loaded from: classes9.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        private x mNetwork;

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
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.tb(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.aDU().aEv().isRequestSuccess()) {
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
            EditHeadActivity.this.jiq = null;
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
                if (this.mNetwork.aDU().aEv().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(R.string.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }
    }
}
