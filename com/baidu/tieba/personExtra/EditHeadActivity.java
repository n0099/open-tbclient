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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.as;
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
/* loaded from: classes6.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private int gOJ;
    private String imJ;
    private ImageView imM;
    private FrameLayout imN;
    private View imO;
    private View imP;
    private RadioButton imV;
    private RadioButton imW;
    private HashMap<String, Bitmap> inc;
    private HashMap<String, ImageView> ind;
    private TextView ine;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String imH = "change";
    public static String FILE_NAME = "file_name";
    private float imI = 1.0f;
    private EditHeadsImageView imK = null;
    private EditHeadsImageTopLayerView imL = null;
    private Bitmap mBitmap = null;
    private int gRh = 0;
    private Button imQ = null;
    private Button imR = null;
    private com.baidu.tbadk.core.view.b imS = null;
    private b imT = null;
    private a imU = null;
    private LinearLayout imX = null;
    private LinearLayout imY = null;
    private d imZ = null;
    private TextView mTitle = null;
    private Bitmap ina = null;
    private c inb = null;
    private boolean cCu = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.gRh = intent.getIntExtra("edit_type", 0);
        this.gOJ = intent.getIntExtra("request", 0);
        this.cCu = intent.getBooleanExtra("need_upload", true);
        this.imI = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.imJ = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.gOJ == 12002 || this.gOJ == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.gOJ, intent.getData(), as.ajq().ajw());
            } else {
                TiebaPrepareImageService.StartService(this.gOJ, null, as.ajq().ajw(), 0, stringExtra);
            }
            bAh();
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
        cbW();
    }

    private void cbW() {
        am.l(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.imO);
        getLayoutMode().onModeChanged(this.imP);
        am.f(this.mTitle, R.color.cp_cont_g, 1);
        am.a(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_topbar_return_s, (int) R.drawable.icon_topbar_return_s, 0);
        am.f(this.ine, R.color.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.imT != null) {
            this.imT.cancel();
        }
        this.imK.setImageDrawable(null);
        cbX();
    }

    private void cbX() {
        if (this.ind != null) {
            for (Map.Entry<String, ImageView> entry : this.ind.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.ind.clear();
            this.ind = null;
        }
        if (this.inc != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.inc.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.inc.clear();
            this.inc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.imT != null) {
            this.imT.cancel();
        }
        this.imT = new b();
        this.imT.execute(new Object[0]);
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
        this.imK.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.imZ != null) {
            this.imZ.cancel();
        }
        if (this.ina != null && !this.ina.isRecycled()) {
            this.ina.recycle();
            this.ina = null;
        }
        if (this.imT != null) {
            this.imT.cancel();
            this.imT = null;
        }
        this.imS.ej(false);
        if (this.gOJ == 12002 || this.gOJ == 12001) {
            unregisterReceiver(this.inb);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbY() {
        if (this.imZ != null) {
            this.imZ.cancel();
        }
        this.imZ = new d();
        this.imZ.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.imS = new com.baidu.tbadk.core.view.b(getPageContext());
        this.imS.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.imS.ej(false);
            }
        });
        this.imS.ej(false);
        this.imL = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        this.imM = (ImageView) findViewById(R.id.preview_image);
        this.imN = (FrameLayout) findViewById(R.id.preview_layout);
        int[] aj = l.aj(getPageContext().getPageActivity());
        this.imN.setY((int) (aj[0] + ((aj[1] - aj[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.imK = (EditHeadsImageView) findViewById(R.id.image);
        this.imK.setCutImageHeightScale(this.imI);
        if (this.mBitmap != null) {
            this.imK.setImageBitmap(this.mBitmap);
        }
        this.imK.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.imN != null && EditHeadActivity.this.imN.getVisibility() == 0) {
                    EditHeadActivity.this.imM.setImageBitmap(EditHeadActivity.this.imK.pH(false));
                }
            }
        });
        this.imK.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.imN != null && EditHeadActivity.this.imN.getVisibility() == 0) {
                    EditHeadActivity.this.imM.setImageBitmap(EditHeadActivity.this.imK.pH(false));
                }
            }
        });
        this.imO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.imR = (Button) findViewById(R.id.show_button);
        this.imR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.imY.setVisibility(0);
                EditHeadActivity.this.imR.setVisibility(8);
                EditHeadActivity.this.imW.setPadding(0, EditHeadActivity.this.imW.getPaddingTop(), EditHeadActivity.this.imW.getPaddingRight(), EditHeadActivity.this.imW.getPaddingBottom());
                EditHeadActivity.this.imW.setChecked(true);
                EditHeadActivity.this.imV.setVisibility(8);
            }
        });
        this.imQ = (Button) findViewById(R.id.hide_button);
        this.imQ.setVisibility(0);
        this.imQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.imY.setVisibility(8);
                EditHeadActivity.this.imR.setVisibility(0);
            }
        });
        this.imP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.imP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.gRh == 0) {
                    if (!EditHeadActivity.this.cCu) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap pH = EditHeadActivity.this.imK.pH(EditHeadActivity.this.gRh == 0 || EditHeadActivity.this.gRh == 3);
                if (pH != null && EditHeadActivity.this.f(str, pH)) {
                    if (EditHeadActivity.this.gRh == 0) {
                        if (EditHeadActivity.this.cCu) {
                            EditHeadActivity.this.cbY();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(m.nj(str), "head");
                    aVar.atF();
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.imJ)) {
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
                    aVar.fr(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.imP.setEnabled(false);
        this.ine = (TextView) this.imP.findViewById(R.id.save);
        this.ine.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.imJ)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.imJ)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.imY = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.imX = (LinearLayout) findViewById(R.id.rotate);
        this.imV = (RadioButton) findViewById(R.id.beautify_btn);
        this.imW = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.imV) {
                        EditHeadActivity.this.imX.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.imW) {
                        EditHeadActivity.this.imX.setVisibility(0);
                    }
                }
            }
        };
        this.imV.setOnCheckedChangeListener(onCheckedChangeListener);
        this.imW.setOnCheckedChangeListener(onCheckedChangeListener);
        this.imV.setChecked(true);
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
                if (!EditHeadActivity.this.imS.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.ina != null) && view.getTag() != null) {
                        EditHeadActivity.this.CF(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.imJ)) {
            this.imN.setVisibility(0);
            this.imR.setVisibility(8);
            this.imL.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.imL.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CF(String str) {
        if (this.imU != null) {
            this.imU.cancel();
        }
        this.imU = new a();
        this.imU.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap bP = m.bP(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (bP.getWidth() > 1800 || bP.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(bP, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            bP.recycle();
                            bP = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (!isCancelled() || bP == null || bP.isRecycled()) {
                        return bP;
                    }
                    bP.recycle();
                    return null;
                } catch (Exception e2) {
                    bitmap = bP;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.imS.ej(true);
            EditHeadActivity.this.imP.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.imT = null;
            EditHeadActivity.this.imS.ej(false);
            EditHeadActivity.this.imP.setClickable(true);
            EditHeadActivity.this.imP.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.imT = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.imS.ej(false);
            EditHeadActivity.this.imP.setClickable(true);
            EditHeadActivity.this.imP.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.imK.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.imK.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(String str, Bitmap bitmap) {
        try {
            m.a((String) null, str, bitmap, 80);
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String ing;
        private Boolean inh = false;
        private Boolean ini = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.imS.ej(true);
            EditHeadActivity.this.imP.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.ing = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.ina == null) {
                return null;
            }
            if (this.ing.equals("0") || this.ing.equals("1")) {
                this.inh = true;
            } else if (this.ing.equals("2") || this.ing.equals("3")) {
                this.ini = true;
            }
            if (this.inh.booleanValue() || this.ini.booleanValue()) {
                if (EditHeadActivity.this.ina != null) {
                    this.bitmap = EditHeadActivity.this.ina.copy(EditHeadActivity.this.ina.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.inh.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.ing));
            } else if (this.ini.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.ing));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.ina != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.imS.ej(false);
            EditHeadActivity.this.imP.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.imS.ej(false);
            EditHeadActivity.this.imP.setClickable(true);
            EditHeadActivity.this.imP.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.inh.booleanValue() || this.ini.booleanValue()) {
                    EditHeadActivity.this.imK.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.inh.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.ing));
                    } else if (this.ini.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.ing));
                    }
                } else {
                    EditHeadActivity.this.imK.q(bitmap);
                }
                if (EditHeadActivity.this.ina != null && !EditHeadActivity.this.ina.isRecycled()) {
                    EditHeadActivity.this.ina.recycle();
                }
                EditHeadActivity.this.ina = bitmap;
            }
        }
    }

    private void bAh() {
        this.inb = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.inb, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
            EditHeadActivity.this.showToast(intent.getStringExtra("error"));
            if (EditHeadActivity.this.imP != null) {
                EditHeadActivity.this.imP.setEnabled(false);
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
    /* loaded from: classes6.dex */
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
                str = this.mNetwork.nR(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.aiG().ajH().isRequestSuccess()) {
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
            EditHeadActivity.this.imZ = null;
            if (this.mNetwork != null) {
                this.mNetwork.ik();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                if (this.mNetwork.aiG().ajH().isRequestSuccess()) {
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
