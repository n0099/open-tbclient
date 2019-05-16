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
    private int gHE;
    private HashMap<String, Bitmap> ifD;
    private HashMap<String, ImageView> ifE;
    private TextView ifF;
    private String ifk;
    private ImageView ifn;
    private FrameLayout ifo;
    private View ifp;
    private View ifq;
    private RadioButton ifw;
    private RadioButton ifx;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String ifi = "change";
    public static String FILE_NAME = "file_name";
    private float ifj = 1.0f;
    private EditHeadsImageView ifl = null;
    private EditHeadsImageTopLayerView ifm = null;
    private Bitmap mBitmap = null;
    private int gKc = 0;
    private Button ifr = null;
    private Button ifs = null;
    private com.baidu.tbadk.core.view.b ift = null;
    private b ifu = null;
    private a ifv = null;
    private LinearLayout ify = null;
    private LinearLayout ifz = null;
    private d ifA = null;
    private TextView mTitle = null;
    private Bitmap ifB = null;
    private c ifC = null;
    private boolean cAV = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.gKc = intent.getIntExtra("edit_type", 0);
        this.gHE = intent.getIntExtra("request", 0);
        this.cAV = intent.getBooleanExtra("need_upload", true);
        this.ifj = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.ifk = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.gHE == 12002 || this.gHE == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.gHE, intent.getData(), ar.ail().air());
            } else {
                TiebaPrepareImageService.StartService(this.gHE, null, ar.ail().air(), 0, stringExtra);
            }
            bxl();
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
        bYL();
    }

    private void bYL() {
        al.l(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.ifp);
        getLayoutMode().onModeChanged(this.ifq);
        al.f(this.mTitle, R.color.cp_cont_g, 1);
        al.a(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_topbar_return_s, (int) R.drawable.icon_topbar_return_s, 0);
        al.f(this.ifF, R.color.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.ifu != null) {
            this.ifu.cancel();
        }
        this.ifl.setImageDrawable(null);
        bYM();
    }

    private void bYM() {
        if (this.ifE != null) {
            for (Map.Entry<String, ImageView> entry : this.ifE.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.ifE.clear();
            this.ifE = null;
        }
        if (this.ifD != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.ifD.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.ifD.clear();
            this.ifD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.ifu != null) {
            this.ifu.cancel();
        }
        this.ifu = new b();
        this.ifu.execute(new Object[0]);
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
        this.ifl.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.ifA != null) {
            this.ifA.cancel();
        }
        if (this.ifB != null && !this.ifB.isRecycled()) {
            this.ifB.recycle();
            this.ifB = null;
        }
        if (this.ifu != null) {
            this.ifu.cancel();
            this.ifu = null;
        }
        this.ift.ef(false);
        if (this.gHE == 12002 || this.gHE == 12001) {
            unregisterReceiver(this.ifC);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYN() {
        if (this.ifA != null) {
            this.ifA.cancel();
        }
        this.ifA = new d();
        this.ifA.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.ift = new com.baidu.tbadk.core.view.b(getPageContext());
        this.ift.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.ift.ef(false);
            }
        });
        this.ift.ef(false);
        this.ifm = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        this.ifn = (ImageView) findViewById(R.id.preview_image);
        this.ifo = (FrameLayout) findViewById(R.id.preview_layout);
        int[] aj = l.aj(getPageContext().getPageActivity());
        this.ifo.setY((int) (aj[0] + ((aj[1] - aj[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.ifl = (EditHeadsImageView) findViewById(R.id.image);
        this.ifl.setCutImageHeightScale(this.ifj);
        if (this.mBitmap != null) {
            this.ifl.setImageBitmap(this.mBitmap);
        }
        this.ifl.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.ifo != null && EditHeadActivity.this.ifo.getVisibility() == 0) {
                    EditHeadActivity.this.ifn.setImageBitmap(EditHeadActivity.this.ifl.pr(false));
                }
            }
        });
        this.ifl.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.ifo != null && EditHeadActivity.this.ifo.getVisibility() == 0) {
                    EditHeadActivity.this.ifn.setImageBitmap(EditHeadActivity.this.ifl.pr(false));
                }
            }
        });
        this.ifp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.ifs = (Button) findViewById(R.id.show_button);
        this.ifs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.ifz.setVisibility(0);
                EditHeadActivity.this.ifs.setVisibility(8);
                EditHeadActivity.this.ifx.setPadding(0, EditHeadActivity.this.ifx.getPaddingTop(), EditHeadActivity.this.ifx.getPaddingRight(), EditHeadActivity.this.ifx.getPaddingBottom());
                EditHeadActivity.this.ifx.setChecked(true);
                EditHeadActivity.this.ifw.setVisibility(8);
            }
        });
        this.ifr = (Button) findViewById(R.id.hide_button);
        this.ifr.setVisibility(0);
        this.ifr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.ifz.setVisibility(8);
                EditHeadActivity.this.ifs.setVisibility(0);
            }
        });
        this.ifq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.ifq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.gKc == 0) {
                    if (!EditHeadActivity.this.cAV) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap pr = EditHeadActivity.this.ifl.pr(EditHeadActivity.this.gKc == 0 || EditHeadActivity.this.gKc == 3);
                if (pr != null && EditHeadActivity.this.f(str, pr)) {
                    if (EditHeadActivity.this.gKc == 0) {
                        if (EditHeadActivity.this.cAV) {
                            EditHeadActivity.this.bYN();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(m.mY(str), "head");
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.ifk)) {
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
        this.ifq.setEnabled(false);
        this.ifF = (TextView) this.ifq.findViewById(R.id.save);
        this.ifF.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.ifk)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.ifk)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.ifz = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.ify = (LinearLayout) findViewById(R.id.rotate);
        this.ifw = (RadioButton) findViewById(R.id.beautify_btn);
        this.ifx = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.ifw) {
                        EditHeadActivity.this.ify.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.ifx) {
                        EditHeadActivity.this.ify.setVisibility(0);
                    }
                }
            }
        };
        this.ifw.setOnCheckedChangeListener(onCheckedChangeListener);
        this.ifx.setOnCheckedChangeListener(onCheckedChangeListener);
        this.ifw.setChecked(true);
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
                if (!EditHeadActivity.this.ift.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.ifB != null) && view.getTag() != null) {
                        EditHeadActivity.this.BP(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.ifk)) {
            this.ifo.setVisibility(0);
            this.ifs.setVisibility(8);
            this.ifm.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.ifm.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BP(String str) {
        if (this.ifv != null) {
            this.ifv.cancel();
        }
        this.ifv = new a();
        this.ifv.execute(str);
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
            EditHeadActivity.this.ift.ef(true);
            EditHeadActivity.this.ifq.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.ifu = null;
            EditHeadActivity.this.ift.ef(false);
            EditHeadActivity.this.ifq.setClickable(true);
            EditHeadActivity.this.ifq.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.ifu = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.ift.ef(false);
            EditHeadActivity.this.ifq.setClickable(true);
            EditHeadActivity.this.ifq.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.ifl.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.ifl.setImageBitmap(bitmap);
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
        private String ifH;
        private Boolean ifI = false;
        private Boolean ifJ = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.ift.ef(true);
            EditHeadActivity.this.ifq.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.ifH = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.ifB == null) {
                return null;
            }
            if (this.ifH.equals("0") || this.ifH.equals("1")) {
                this.ifI = true;
            } else if (this.ifH.equals("2") || this.ifH.equals("3")) {
                this.ifJ = true;
            }
            if (this.ifI.booleanValue() || this.ifJ.booleanValue()) {
                if (EditHeadActivity.this.ifB != null) {
                    this.bitmap = EditHeadActivity.this.ifB.copy(EditHeadActivity.this.ifB.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.ifI.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.ifH));
            } else if (this.ifJ.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.ifH));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.ifB != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.ift.ef(false);
            EditHeadActivity.this.ifq.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.ift.ef(false);
            EditHeadActivity.this.ifq.setClickable(true);
            EditHeadActivity.this.ifq.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.ifI.booleanValue() || this.ifJ.booleanValue()) {
                    EditHeadActivity.this.ifl.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.ifI.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.ifH));
                    } else if (this.ifJ.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.ifH));
                    }
                } else {
                    EditHeadActivity.this.ifl.q(bitmap);
                }
                if (EditHeadActivity.this.ifB != null && !EditHeadActivity.this.ifB.isRecycled()) {
                    EditHeadActivity.this.ifB.recycle();
                }
                EditHeadActivity.this.ifB = bitmap;
            }
        }
    }

    private void bxl() {
        this.ifC = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.ifC, intentFilter);
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
            if (EditHeadActivity.this.ifq != null) {
                EditHeadActivity.this.ifq.setEnabled(false);
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
                str = this.mNetwork.nG(TbConfig.PERSON_HEAD_FILE);
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
            EditHeadActivity.this.ifA = null;
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
