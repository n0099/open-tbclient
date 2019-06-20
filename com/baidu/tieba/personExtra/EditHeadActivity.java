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
import com.baidu.tbadk.core.util.al;
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
/* loaded from: classes6.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private int gHH;
    private RadioButton ifA;
    private RadioButton ifB;
    private HashMap<String, Bitmap> ifH;
    private HashMap<String, ImageView> ifI;
    private TextView ifJ;
    private String ifo;
    private ImageView ifr;
    private FrameLayout ifs;
    private View ift;
    private View ifu;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String ifm = "change";
    public static String FILE_NAME = "file_name";
    private float ifn = 1.0f;
    private EditHeadsImageView ifp = null;
    private EditHeadsImageTopLayerView ifq = null;
    private Bitmap mBitmap = null;
    private int gKf = 0;
    private Button ifv = null;
    private Button ifw = null;
    private com.baidu.tbadk.core.view.b ifx = null;
    private b ify = null;
    private a ifz = null;
    private LinearLayout ifC = null;
    private LinearLayout ifD = null;
    private d ifE = null;
    private TextView mTitle = null;
    private Bitmap ifF = null;
    private c ifG = null;
    private boolean cAW = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.gKf = intent.getIntExtra("edit_type", 0);
        this.gHH = intent.getIntExtra("request", 0);
        this.cAW = intent.getBooleanExtra("need_upload", true);
        this.ifn = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.ifo = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.gHH == 12002 || this.gHH == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.gHH, intent.getData(), ar.ail().air());
            } else {
                TiebaPrepareImageService.StartService(this.gHH, null, ar.ail().air(), 0, stringExtra);
            }
            bxp();
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
        bYP();
    }

    private void bYP() {
        al.l(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.ift);
        getLayoutMode().onModeChanged(this.ifu);
        al.f(this.mTitle, R.color.cp_cont_g, 1);
        al.a(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_topbar_return_s, (int) R.drawable.icon_topbar_return_s, 0);
        al.f(this.ifJ, R.color.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.ify != null) {
            this.ify.cancel();
        }
        this.ifp.setImageDrawable(null);
        bYQ();
    }

    private void bYQ() {
        if (this.ifI != null) {
            for (Map.Entry<String, ImageView> entry : this.ifI.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.ifI.clear();
            this.ifI = null;
        }
        if (this.ifH != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.ifH.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.ifH.clear();
            this.ifH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.ify != null) {
            this.ify.cancel();
        }
        this.ify = new b();
        this.ify.execute(new Object[0]);
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
        this.ifp.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.ifE != null) {
            this.ifE.cancel();
        }
        if (this.ifF != null && !this.ifF.isRecycled()) {
            this.ifF.recycle();
            this.ifF = null;
        }
        if (this.ify != null) {
            this.ify.cancel();
            this.ify = null;
        }
        this.ifx.ef(false);
        if (this.gHH == 12002 || this.gHH == 12001) {
            unregisterReceiver(this.ifG);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYR() {
        if (this.ifE != null) {
            this.ifE.cancel();
        }
        this.ifE = new d();
        this.ifE.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.ifx = new com.baidu.tbadk.core.view.b(getPageContext());
        this.ifx.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.ifx.ef(false);
            }
        });
        this.ifx.ef(false);
        this.ifq = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        this.ifr = (ImageView) findViewById(R.id.preview_image);
        this.ifs = (FrameLayout) findViewById(R.id.preview_layout);
        int[] aj = l.aj(getPageContext().getPageActivity());
        this.ifs.setY((int) (aj[0] + ((aj[1] - aj[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.ifp = (EditHeadsImageView) findViewById(R.id.image);
        this.ifp.setCutImageHeightScale(this.ifn);
        if (this.mBitmap != null) {
            this.ifp.setImageBitmap(this.mBitmap);
        }
        this.ifp.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.ifs != null && EditHeadActivity.this.ifs.getVisibility() == 0) {
                    EditHeadActivity.this.ifr.setImageBitmap(EditHeadActivity.this.ifp.ps(false));
                }
            }
        });
        this.ifp.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.ifs != null && EditHeadActivity.this.ifs.getVisibility() == 0) {
                    EditHeadActivity.this.ifr.setImageBitmap(EditHeadActivity.this.ifp.ps(false));
                }
            }
        });
        this.ift = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.ifw = (Button) findViewById(R.id.show_button);
        this.ifw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.ifD.setVisibility(0);
                EditHeadActivity.this.ifw.setVisibility(8);
                EditHeadActivity.this.ifB.setPadding(0, EditHeadActivity.this.ifB.getPaddingTop(), EditHeadActivity.this.ifB.getPaddingRight(), EditHeadActivity.this.ifB.getPaddingBottom());
                EditHeadActivity.this.ifB.setChecked(true);
                EditHeadActivity.this.ifA.setVisibility(8);
            }
        });
        this.ifv = (Button) findViewById(R.id.hide_button);
        this.ifv.setVisibility(0);
        this.ifv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.ifD.setVisibility(8);
                EditHeadActivity.this.ifw.setVisibility(0);
            }
        });
        this.ifu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.ifu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.gKf == 0) {
                    if (!EditHeadActivity.this.cAW) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap ps = EditHeadActivity.this.ifp.ps(EditHeadActivity.this.gKf == 0 || EditHeadActivity.this.gKf == 3);
                if (ps != null && EditHeadActivity.this.f(str, ps)) {
                    if (EditHeadActivity.this.gKf == 0) {
                        if (EditHeadActivity.this.cAW) {
                            EditHeadActivity.this.bYR();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(m.mX(str), "head");
                    aVar.asw();
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.ifo)) {
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
                    aVar.fn(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.ifu.setEnabled(false);
        this.ifJ = (TextView) this.ifu.findViewById(R.id.save);
        this.ifJ.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.ifo)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.ifo)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.ifD = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.ifC = (LinearLayout) findViewById(R.id.rotate);
        this.ifA = (RadioButton) findViewById(R.id.beautify_btn);
        this.ifB = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.ifA) {
                        EditHeadActivity.this.ifC.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.ifB) {
                        EditHeadActivity.this.ifC.setVisibility(0);
                    }
                }
            }
        };
        this.ifA.setOnCheckedChangeListener(onCheckedChangeListener);
        this.ifB.setOnCheckedChangeListener(onCheckedChangeListener);
        this.ifA.setChecked(true);
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
                if (!EditHeadActivity.this.ifx.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.ifF != null) && view.getTag() != null) {
                        EditHeadActivity.this.BR(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.ifo)) {
            this.ifs.setVisibility(0);
            this.ifw.setVisibility(8);
            this.ifq.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.ifq.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BR(String str) {
        if (this.ifz != null) {
            this.ifz.cancel();
        }
        this.ifz = new a();
        this.ifz.execute(str);
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
            EditHeadActivity.this.ifx.ef(true);
            EditHeadActivity.this.ifu.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.ify = null;
            EditHeadActivity.this.ifx.ef(false);
            EditHeadActivity.this.ifu.setClickable(true);
            EditHeadActivity.this.ifu.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.ify = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.ifx.ef(false);
            EditHeadActivity.this.ifu.setClickable(true);
            EditHeadActivity.this.ifu.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.ifp.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.ifp.setImageBitmap(bitmap);
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
        private String ifL;
        private Boolean ifM = false;
        private Boolean ifN = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.ifx.ef(true);
            EditHeadActivity.this.ifu.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.ifL = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.ifF == null) {
                return null;
            }
            if (this.ifL.equals("0") || this.ifL.equals("1")) {
                this.ifM = true;
            } else if (this.ifL.equals("2") || this.ifL.equals("3")) {
                this.ifN = true;
            }
            if (this.ifM.booleanValue() || this.ifN.booleanValue()) {
                if (EditHeadActivity.this.ifF != null) {
                    this.bitmap = EditHeadActivity.this.ifF.copy(EditHeadActivity.this.ifF.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.ifM.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.ifL));
            } else if (this.ifN.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.ifL));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.ifF != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.ifx.ef(false);
            EditHeadActivity.this.ifu.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.ifx.ef(false);
            EditHeadActivity.this.ifu.setClickable(true);
            EditHeadActivity.this.ifu.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.ifM.booleanValue() || this.ifN.booleanValue()) {
                    EditHeadActivity.this.ifp.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.ifM.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.ifL));
                    } else if (this.ifN.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.ifL));
                    }
                } else {
                    EditHeadActivity.this.ifp.q(bitmap);
                }
                if (EditHeadActivity.this.ifF != null && !EditHeadActivity.this.ifF.isRecycled()) {
                    EditHeadActivity.this.ifF.recycle();
                }
                EditHeadActivity.this.ifF = bitmap;
            }
        }
    }

    private void bxp() {
        this.ifG = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.ifG, intentFilter);
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
            if (EditHeadActivity.this.ifu != null) {
                EditHeadActivity.this.ifu.setEnabled(false);
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
                str = this.mNetwork.nF(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
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
            EditHeadActivity.this.ifE = null;
            if (this.mNetwork != null) {
                this.mNetwork.ia();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
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
