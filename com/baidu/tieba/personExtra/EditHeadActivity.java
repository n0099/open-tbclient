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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View bhK;
    private View bhL;
    private TextView bhO;
    private int jhU;
    private String kRe;
    private ImageView kRh;
    private FrameLayout kRi;
    private RadioButton kRo;
    private RadioButton kRp;
    private int kRv;
    private HashMap<String, Bitmap> kRw;
    private HashMap<String, ImageView> kRx;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = "delete";
    public static String kRd = "change";
    public static String FILE_NAME = "file_name";
    private float bhG = 1.0f;
    private EditHeadsImageView kRf = null;
    private EditHeadsImageTopLayerView kRg = null;
    private Bitmap mBitmap = null;
    private int jks = 0;
    private Button kRj = null;
    private Button kRk = null;
    private com.baidu.tbadk.core.view.a kRl = null;
    private b kRm = null;
    private a kRn = null;
    private LinearLayout kRq = null;
    private LinearLayout kRr = null;
    private d kRs = null;
    private TextView mTitle = null;
    private Bitmap bhN = null;
    private c kRt = null;
    private boolean eJO = true;
    private boolean kRu = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.jks = intent.getIntExtra("edit_type", 0);
        this.jhU = intent.getIntExtra("request", 0);
        this.eJO = intent.getBooleanExtra("need_upload", true);
        this.kRu = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
        this.kRv = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
        this.bhG = intent.getFloatExtra("cut_image_height_scale", 1.0f);
        this.kRe = intent.getStringExtra("from_where");
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.jhU == 12002 || this.jhU == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.jhU, intent.getData(), at.baS().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.jhU, null, at.baS().getPostImageSize(), 0, stringExtra);
            }
            cqv();
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
        cWi();
    }

    private void cWi() {
        ao.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.bhK);
        getLayoutMode().onModeChanged(this.bhL);
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1);
        ao.setNavbarIconSrc(this.mNavigationBar.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
        ao.setViewTextColor(this.bhO, R.color.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.kRm != null) {
            this.kRm.cancel();
        }
        this.kRf.setImageDrawable(null);
        cWj();
    }

    private void cWj() {
        if (this.kRx != null) {
            for (Map.Entry<String, ImageView> entry : this.kRx.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.kRx.clear();
            this.kRx = null;
        }
        if (this.kRw != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.kRw.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.kRw.clear();
            this.kRw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.kRm != null) {
            this.kRm.cancel();
        }
        this.kRm = new b();
        this.kRm.execute(new Object[0]);
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
        this.kRf.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.kRs != null) {
            this.kRs.cancel();
        }
        if (this.bhN != null && !this.bhN.isRecycled()) {
            this.bhN.recycle();
            this.bhN = null;
        }
        if (this.kRm != null) {
            this.kRm.cancel();
            this.kRm = null;
        }
        this.kRl.setDialogVisiable(false);
        if (this.jhU == 12002 || this.jhU == 12001) {
            unregisterReceiver(this.kRt);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWk() {
        if (this.kRs != null) {
            this.kRs.cancel();
        }
        this.kRs = new d();
        this.kRs.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.kRl = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kRl.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.kRl.setDialogVisiable(false);
            }
        });
        this.kRl.setDialogVisiable(false);
        this.kRg = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.kRe) && this.bhG != 1.0f) {
            this.kRg.setmCutHeightScale(this.bhG);
        }
        this.kRh = (ImageView) findViewById(R.id.preview_image);
        this.kRi = (FrameLayout) findViewById(R.id.preview_layout);
        int[] screenDimensions = l.getScreenDimensions(getPageContext().getPageActivity());
        this.kRi.setY((int) (screenDimensions[0] + ((screenDimensions[1] - screenDimensions[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.kRf = (EditHeadsImageView) findViewById(R.id.image);
        this.kRf.setCutImageHeightScale(this.bhG);
        if (this.mBitmap != null) {
            this.kRf.setImageBitmap(this.mBitmap);
        }
        this.kRf.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.kRi != null && EditHeadActivity.this.kRi.getVisibility() == 0) {
                    EditHeadActivity.this.kRh.setImageBitmap(EditHeadActivity.this.kRf.ci(false));
                }
            }
        });
        this.kRf.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.kRi != null && EditHeadActivity.this.kRi.getVisibility() == 0) {
                    EditHeadActivity.this.kRh.setImageBitmap(EditHeadActivity.this.kRf.ci(false));
                }
            }
        });
        this.bhK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.kRk = (Button) findViewById(R.id.show_button);
        this.kRk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.kRr.setVisibility(0);
                EditHeadActivity.this.kRk.setVisibility(8);
                EditHeadActivity.this.kRp.setPadding(0, EditHeadActivity.this.kRp.getPaddingTop(), EditHeadActivity.this.kRp.getPaddingRight(), EditHeadActivity.this.kRp.getPaddingBottom());
                EditHeadActivity.this.kRp.setChecked(true);
                EditHeadActivity.this.kRo.setVisibility(8);
            }
        });
        this.kRj = (Button) findViewById(R.id.hide_button);
        this.kRj.setVisibility(0);
        this.kRj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.kRr.setVisibility(8);
                EditHeadActivity.this.kRk.setVisibility(0);
            }
        });
        this.bhL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.bhL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.jks == 0) {
                    if (!EditHeadActivity.this.eJO) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap ci = EditHeadActivity.this.kRf.ci(EditHeadActivity.this.jks == 0 || EditHeadActivity.this.jks == 3);
                if (ci != null && EditHeadActivity.this.c(str, ci)) {
                    if (EditHeadActivity.this.jks == 0) {
                        if (EditHeadActivity.this.eJO) {
                            EditHeadActivity.this.cWk();
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
                                    if ("from_misson_set_cover".equals(EditHeadActivity.this.kRe)) {
                                        EditHeadActivity.this.c(photoUrlData);
                                    }
                                    intent2.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                                    intent2.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
                                    Intent intent3 = new Intent();
                                    intent3.setAction("com.tieba.action.ImagePickerPlugin");
                                    intent3.putExtra("pic_info", photoUrlData);
                                    EditHeadActivity.this.sendBroadcast(intent3);
                                }
                            }
                            EditHeadActivity.this.setResult(-1, intent2);
                            EditHeadActivity.this.finish();
                        }
                    });
                    aVar.of(EditHeadActivity.this.kRv);
                    aVar.loadPic(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.bhL.setEnabled(false);
        this.bhO = (TextView) this.bhL.findViewById(R.id.save);
        this.bhO.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.kRe)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.kRe)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.kRr = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.kRq = (LinearLayout) findViewById(R.id.rotate);
        this.kRo = (RadioButton) findViewById(R.id.beautify_btn);
        this.kRp = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.kRo) {
                        EditHeadActivity.this.kRq.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.kRp) {
                        EditHeadActivity.this.kRq.setVisibility(0);
                    }
                }
            }
        };
        this.kRo.setOnCheckedChangeListener(onCheckedChangeListener);
        this.kRp.setOnCheckedChangeListener(onCheckedChangeListener);
        this.kRo.setChecked(true);
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
                if (!EditHeadActivity.this.kRl.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.bhN != null) && view.getTag() != null) {
                        EditHeadActivity.this.Lu(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.kRe)) {
            this.kRi.setVisibility(0);
            this.kRk.setVisibility(8);
            this.kRg.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.kRg.setLineWidth(2);
        }
        if (!this.kRu) {
            this.kRk.setVisibility(8);
            this.mTitle.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lu(String str) {
        if (this.kRn != null) {
            this.kRn.cancel();
        }
        this.kRn = new a();
        this.kRn.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
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
            EditHeadActivity.this.kRl.setDialogVisiable(true);
            EditHeadActivity.this.bhL.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.kRm = null;
            EditHeadActivity.this.kRl.setDialogVisiable(false);
            EditHeadActivity.this.bhL.setClickable(true);
            EditHeadActivity.this.bhL.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.kRm = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.kRl.setDialogVisiable(false);
            EditHeadActivity.this.bhL.setClickable(true);
            EditHeadActivity.this.bhL.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.kRf.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.kRf.setImageBitmap(bitmap);
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
    /* loaded from: classes18.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean kRA = false;
        private Boolean kRB = false;
        private String kRz;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.kRl.setDialogVisiable(true);
            EditHeadActivity.this.bhL.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public Bitmap doInBackground(String... strArr) {
            this.kRz = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.bhN == null) {
                return null;
            }
            if (this.kRz.equals("0") || this.kRz.equals("1")) {
                this.kRA = true;
            } else if (this.kRz.equals("2") || this.kRz.equals("3")) {
                this.kRB = true;
            }
            if (this.kRA.booleanValue() || this.kRB.booleanValue()) {
                if (EditHeadActivity.this.bhN != null) {
                    this.bitmap = EditHeadActivity.this.bhN.copy(EditHeadActivity.this.bhN.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.kRA.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.kRz));
            } else if (this.kRB.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.kRz));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.bhN != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.kRl.setDialogVisiable(false);
            EditHeadActivity.this.bhL.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.kRl.setDialogVisiable(false);
            EditHeadActivity.this.bhL.setClickable(true);
            EditHeadActivity.this.bhL.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.kRA.booleanValue() || this.kRB.booleanValue()) {
                    EditHeadActivity.this.kRf.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, 1800);
                    }
                    if (this.kRA.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.kRz));
                    } else if (this.kRB.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.kRz));
                    }
                } else {
                    EditHeadActivity.this.kRf.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.bhN != null && !EditHeadActivity.this.bhN.isRecycled()) {
                    EditHeadActivity.this.bhN.recycle();
                }
                EditHeadActivity.this.bhN = bitmap;
            }
        }
    }

    private void cqv() {
        this.kRt = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.kRt, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
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
            if (EditHeadActivity.this.bhL != null) {
                EditHeadActivity.this.bhL.setEnabled(false);
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
    /* loaded from: classes18.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        private z mNetwork;

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
            this.mNetwork = new z(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.xL(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.bav().baX().isRequestSuccess()) {
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
            EditHeadActivity.this.kRs = null;
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
                if (this.mNetwork.bav().baX().isRequestSuccess()) {
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
