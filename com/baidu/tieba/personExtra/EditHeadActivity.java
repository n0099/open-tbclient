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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes23.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View bqq;
    private View bqr;
    private TextView bqu;
    private int jFC;
    private String lpW;
    private ImageView lpZ;
    private FrameLayout lqa;
    private RadioButton lqg;
    private RadioButton lqh;
    private int lqn;
    private HashMap<String, Bitmap> lqo;
    private HashMap<String, ImageView> lqp;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = "delete";
    public static String lpV = "change";
    public static String FILE_NAME = "file_name";
    private float bqm = 1.0f;
    private EditHeadsImageView lpX = null;
    private EditHeadsImageTopLayerView lpY = null;
    private Bitmap mBitmap = null;
    private int jHZ = 0;
    private Button lqb = null;
    private Button lqc = null;
    private com.baidu.tbadk.core.view.a lqd = null;
    private b lqe = null;
    private a lqf = null;
    private LinearLayout lqi = null;
    private LinearLayout lqj = null;
    private d lqk = null;
    private TextView mTitle = null;
    private Bitmap bqt = null;
    private c lql = null;
    private boolean eXo = true;
    private boolean lqm = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.jHZ = intent.getIntExtra("edit_type", 0);
        this.jFC = intent.getIntExtra("request", 0);
        this.eXo = intent.getBooleanExtra("need_upload", true);
        this.lqm = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
        this.lqn = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
        this.bqm = intent.getFloatExtra("cut_image_height_scale", 1.0f);
        this.lpW = intent.getStringExtra("from_where");
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.jFC == 12002 || this.jFC == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.jFC, intent.getData(), au.bkm().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.jFC, null, au.bkm().getPostImageSize(), 0, stringExtra);
            }
            cEV();
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
        dkL();
    }

    private void dkL() {
        ap.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.bqq);
        getLayoutMode().onModeChanged(this.bqr);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1);
        ap.setNavbarIconSrc(this.mNavigationBar.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
        ap.setViewTextColor(this.bqu, R.color.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.lqe != null) {
            this.lqe.cancel();
        }
        this.lpX.setImageDrawable(null);
        dkM();
    }

    private void dkM() {
        if (this.lqp != null) {
            for (Map.Entry<String, ImageView> entry : this.lqp.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.lqp.clear();
            this.lqp = null;
        }
        if (this.lqo != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.lqo.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.lqo.clear();
            this.lqo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.lqe != null) {
            this.lqe.cancel();
        }
        this.lqe = new b();
        this.lqe.execute(new Object[0]);
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
        this.lpX.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.lqk != null) {
            this.lqk.cancel();
        }
        if (this.bqt != null && !this.bqt.isRecycled()) {
            this.bqt.recycle();
            this.bqt = null;
        }
        if (this.lqe != null) {
            this.lqe.cancel();
            this.lqe = null;
        }
        this.lqd.setDialogVisiable(false);
        if (this.jFC == 12002 || this.jFC == 12001) {
            unregisterReceiver(this.lql);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkN() {
        if (this.lqk != null) {
            this.lqk.cancel();
        }
        this.lqk = new d();
        this.lqk.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.lqd = new com.baidu.tbadk.core.view.a(getPageContext());
        this.lqd.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.lqd.setDialogVisiable(false);
            }
        });
        this.lqd.setDialogVisiable(false);
        this.lpY = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.lpW) && this.bqm != 1.0f) {
            this.lpY.setmCutHeightScale(this.bqm);
        }
        this.lpZ = (ImageView) findViewById(R.id.preview_image);
        this.lqa = (FrameLayout) findViewById(R.id.preview_layout);
        int[] screenDimensions = l.getScreenDimensions(getPageContext().getPageActivity());
        this.lqa.setY((int) (screenDimensions[0] + ((screenDimensions[1] - screenDimensions[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.lpX = (EditHeadsImageView) findViewById(R.id.image);
        this.lpX.setCutImageHeightScale(this.bqm);
        if (this.mBitmap != null) {
            this.lpX.setImageBitmap(this.mBitmap);
        }
        this.lpX.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.lqa != null && EditHeadActivity.this.lqa.getVisibility() == 0) {
                    EditHeadActivity.this.lpZ.setImageBitmap(EditHeadActivity.this.lpX.ct(false));
                }
            }
        });
        this.lpX.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.lqa != null && EditHeadActivity.this.lqa.getVisibility() == 0) {
                    EditHeadActivity.this.lpZ.setImageBitmap(EditHeadActivity.this.lpX.ct(false));
                }
            }
        });
        this.bqq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.lqc = (Button) findViewById(R.id.show_button);
        this.lqc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.lqj.setVisibility(0);
                EditHeadActivity.this.lqc.setVisibility(8);
                EditHeadActivity.this.lqh.setPadding(0, EditHeadActivity.this.lqh.getPaddingTop(), EditHeadActivity.this.lqh.getPaddingRight(), EditHeadActivity.this.lqh.getPaddingBottom());
                EditHeadActivity.this.lqh.setChecked(true);
                EditHeadActivity.this.lqg.setVisibility(8);
            }
        });
        this.lqb = (Button) findViewById(R.id.hide_button);
        this.lqb.setVisibility(0);
        this.lqb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.lqj.setVisibility(8);
                EditHeadActivity.this.lqc.setVisibility(0);
            }
        });
        this.bqr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.bqr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.jHZ == 0) {
                    if (!EditHeadActivity.this.eXo) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap ct = EditHeadActivity.this.lpX.ct(EditHeadActivity.this.jHZ == 0 || EditHeadActivity.this.jHZ == 3);
                if (ct != null && EditHeadActivity.this.c(str, ct)) {
                    if (EditHeadActivity.this.jHZ == 0) {
                        if (EditHeadActivity.this.eXo) {
                            EditHeadActivity.this.dkN();
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
                                    if ("from_misson_set_cover".equals(EditHeadActivity.this.lpW)) {
                                        EditHeadActivity.this.c(photoUrlData);
                                    }
                                    intent2.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                                    intent2.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
                                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.lpW)) {
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
                    aVar.qH(EditHeadActivity.this.lqn);
                    aVar.loadPic(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.bqr.setEnabled(false);
        this.bqu = (TextView) this.bqr.findViewById(R.id.save);
        this.bqu.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.lpW)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.lpW)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.lqj = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.lqi = (LinearLayout) findViewById(R.id.rotate);
        this.lqg = (RadioButton) findViewById(R.id.beautify_btn);
        this.lqh = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.lqg) {
                        EditHeadActivity.this.lqi.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.lqh) {
                        EditHeadActivity.this.lqi.setVisibility(0);
                    }
                }
            }
        };
        this.lqg.setOnCheckedChangeListener(onCheckedChangeListener);
        this.lqh.setOnCheckedChangeListener(onCheckedChangeListener);
        this.lqg.setChecked(true);
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
                if (!EditHeadActivity.this.lqd.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.bqt != null) && view.getTag() != null) {
                        EditHeadActivity.this.OP(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.lpW)) {
            this.lqa.setVisibility(0);
            this.lqc.setVisibility(8);
            this.lpY.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.lpY.setLineWidth(2);
        }
        if (!this.lqm) {
            this.lqc.setVisibility(8);
            this.mTitle.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OP(String str) {
        if (this.lqf != null) {
            this.lqf.cancel();
        }
        this.lqf = new a();
        this.lqf.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
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
            EditHeadActivity.this.lqd.setDialogVisiable(true);
            EditHeadActivity.this.bqr.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.lqe = null;
            EditHeadActivity.this.lqd.setDialogVisiable(false);
            EditHeadActivity.this.bqr.setClickable(true);
            EditHeadActivity.this.bqr.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.lqe = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.lqd.setDialogVisiable(false);
            EditHeadActivity.this.bqr.setClickable(true);
            EditHeadActivity.this.bqr.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.lpX.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.lpX.setImageBitmap(bitmap);
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
    /* loaded from: classes23.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String lqr;
        private Boolean lqs = false;
        private Boolean lqt = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.lqd.setDialogVisiable(true);
            EditHeadActivity.this.bqr.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public Bitmap doInBackground(String... strArr) {
            this.lqr = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.bqt == null) {
                return null;
            }
            if (this.lqr.equals("0") || this.lqr.equals("1")) {
                this.lqs = true;
            } else if (this.lqr.equals("2") || this.lqr.equals("3")) {
                this.lqt = true;
            }
            if (this.lqs.booleanValue() || this.lqt.booleanValue()) {
                if (EditHeadActivity.this.bqt != null) {
                    this.bitmap = EditHeadActivity.this.bqt.copy(EditHeadActivity.this.bqt.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.lqs.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.lqr));
            } else if (this.lqt.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.lqr));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.bqt != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.lqd.setDialogVisiable(false);
            EditHeadActivity.this.bqr.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.lqd.setDialogVisiable(false);
            EditHeadActivity.this.bqr.setClickable(true);
            EditHeadActivity.this.bqr.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.lqs.booleanValue() || this.lqt.booleanValue()) {
                    EditHeadActivity.this.lpX.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, 1800);
                    }
                    if (this.lqs.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.lqr));
                    } else if (this.lqt.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.lqr));
                    }
                } else {
                    EditHeadActivity.this.lpX.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.bqt != null && !EditHeadActivity.this.bqt.isRecycled()) {
                    EditHeadActivity.this.bqt.recycle();
                }
                EditHeadActivity.this.bqt = bitmap;
            }
        }
    }

    private void cEV() {
        this.lql = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.lql, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
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
            if (EditHeadActivity.this.bqr != null) {
                EditHeadActivity.this.bqr.setEnabled(false);
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
    /* loaded from: classes23.dex */
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
                str = this.mNetwork.Aw(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.bjL().bkr().isRequestSuccess()) {
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
            EditHeadActivity.this.lqk = null;
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
                if (this.mNetwork.bjL().bkr().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.lpW)) {
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
