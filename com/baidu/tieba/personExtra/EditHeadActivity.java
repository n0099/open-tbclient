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
    private int jhS;
    private String kRc;
    private ImageView kRf;
    private FrameLayout kRg;
    private RadioButton kRm;
    private RadioButton kRn;
    private int kRt;
    private HashMap<String, Bitmap> kRu;
    private HashMap<String, ImageView> kRv;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = "delete";
    public static String kRb = "change";
    public static String FILE_NAME = "file_name";
    private float bhG = 1.0f;
    private EditHeadsImageView kRd = null;
    private EditHeadsImageTopLayerView kRe = null;
    private Bitmap mBitmap = null;
    private int jkq = 0;
    private Button kRh = null;
    private Button kRi = null;
    private com.baidu.tbadk.core.view.a kRj = null;
    private b kRk = null;
    private a kRl = null;
    private LinearLayout kRo = null;
    private LinearLayout kRp = null;
    private d kRq = null;
    private TextView mTitle = null;
    private Bitmap bhN = null;
    private c kRr = null;
    private boolean eJO = true;
    private boolean kRs = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.jkq = intent.getIntExtra("edit_type", 0);
        this.jhS = intent.getIntExtra("request", 0);
        this.eJO = intent.getBooleanExtra("need_upload", true);
        this.kRs = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
        this.kRt = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
        this.bhG = intent.getFloatExtra("cut_image_height_scale", 1.0f);
        this.kRc = intent.getStringExtra("from_where");
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.jhS == 12002 || this.jhS == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.jhS, intent.getData(), at.baS().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.jhS, null, at.baS().getPostImageSize(), 0, stringExtra);
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
        if (this.kRk != null) {
            this.kRk.cancel();
        }
        this.kRd.setImageDrawable(null);
        cWj();
    }

    private void cWj() {
        if (this.kRv != null) {
            for (Map.Entry<String, ImageView> entry : this.kRv.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.kRv.clear();
            this.kRv = null;
        }
        if (this.kRu != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.kRu.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.kRu.clear();
            this.kRu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.kRk != null) {
            this.kRk.cancel();
        }
        this.kRk = new b();
        this.kRk.execute(new Object[0]);
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
        this.kRd.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.kRq != null) {
            this.kRq.cancel();
        }
        if (this.bhN != null && !this.bhN.isRecycled()) {
            this.bhN.recycle();
            this.bhN = null;
        }
        if (this.kRk != null) {
            this.kRk.cancel();
            this.kRk = null;
        }
        this.kRj.setDialogVisiable(false);
        if (this.jhS == 12002 || this.jhS == 12001) {
            unregisterReceiver(this.kRr);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWk() {
        if (this.kRq != null) {
            this.kRq.cancel();
        }
        this.kRq = new d();
        this.kRq.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.kRj = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kRj.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.kRj.setDialogVisiable(false);
            }
        });
        this.kRj.setDialogVisiable(false);
        this.kRe = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.kRc) && this.bhG != 1.0f) {
            this.kRe.setmCutHeightScale(this.bhG);
        }
        this.kRf = (ImageView) findViewById(R.id.preview_image);
        this.kRg = (FrameLayout) findViewById(R.id.preview_layout);
        int[] screenDimensions = l.getScreenDimensions(getPageContext().getPageActivity());
        this.kRg.setY((int) (screenDimensions[0] + ((screenDimensions[1] - screenDimensions[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.kRd = (EditHeadsImageView) findViewById(R.id.image);
        this.kRd.setCutImageHeightScale(this.bhG);
        if (this.mBitmap != null) {
            this.kRd.setImageBitmap(this.mBitmap);
        }
        this.kRd.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.kRg != null && EditHeadActivity.this.kRg.getVisibility() == 0) {
                    EditHeadActivity.this.kRf.setImageBitmap(EditHeadActivity.this.kRd.ci(false));
                }
            }
        });
        this.kRd.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.kRg != null && EditHeadActivity.this.kRg.getVisibility() == 0) {
                    EditHeadActivity.this.kRf.setImageBitmap(EditHeadActivity.this.kRd.ci(false));
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
        this.kRi = (Button) findViewById(R.id.show_button);
        this.kRi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.kRp.setVisibility(0);
                EditHeadActivity.this.kRi.setVisibility(8);
                EditHeadActivity.this.kRn.setPadding(0, EditHeadActivity.this.kRn.getPaddingTop(), EditHeadActivity.this.kRn.getPaddingRight(), EditHeadActivity.this.kRn.getPaddingBottom());
                EditHeadActivity.this.kRn.setChecked(true);
                EditHeadActivity.this.kRm.setVisibility(8);
            }
        });
        this.kRh = (Button) findViewById(R.id.hide_button);
        this.kRh.setVisibility(0);
        this.kRh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.kRp.setVisibility(8);
                EditHeadActivity.this.kRi.setVisibility(0);
            }
        });
        this.bhL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.bhL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.jkq == 0) {
                    if (!EditHeadActivity.this.eJO) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap ci = EditHeadActivity.this.kRd.ci(EditHeadActivity.this.jkq == 0 || EditHeadActivity.this.jkq == 3);
                if (ci != null && EditHeadActivity.this.c(str, ci)) {
                    if (EditHeadActivity.this.jkq == 0) {
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
                                    if ("from_misson_set_cover".equals(EditHeadActivity.this.kRc)) {
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
                    aVar.of(EditHeadActivity.this.kRt);
                    aVar.loadPic(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.bhL.setEnabled(false);
        this.bhO = (TextView) this.bhL.findViewById(R.id.save);
        this.bhO.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.kRc)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.kRc)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.kRp = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.kRo = (LinearLayout) findViewById(R.id.rotate);
        this.kRm = (RadioButton) findViewById(R.id.beautify_btn);
        this.kRn = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.kRm) {
                        EditHeadActivity.this.kRo.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.kRn) {
                        EditHeadActivity.this.kRo.setVisibility(0);
                    }
                }
            }
        };
        this.kRm.setOnCheckedChangeListener(onCheckedChangeListener);
        this.kRn.setOnCheckedChangeListener(onCheckedChangeListener);
        this.kRm.setChecked(true);
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
                if (!EditHeadActivity.this.kRj.isShowing()) {
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
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.kRc)) {
            this.kRg.setVisibility(0);
            this.kRi.setVisibility(8);
            this.kRe.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.kRe.setLineWidth(2);
        }
        if (!this.kRs) {
            this.kRi.setVisibility(8);
            this.mTitle.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lu(String str) {
        if (this.kRl != null) {
            this.kRl.cancel();
        }
        this.kRl = new a();
        this.kRl.execute(str);
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
            EditHeadActivity.this.kRj.setDialogVisiable(true);
            EditHeadActivity.this.bhL.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.kRk = null;
            EditHeadActivity.this.kRj.setDialogVisiable(false);
            EditHeadActivity.this.bhL.setClickable(true);
            EditHeadActivity.this.bhL.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.kRk = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.kRj.setDialogVisiable(false);
            EditHeadActivity.this.bhL.setClickable(true);
            EditHeadActivity.this.bhL.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.kRd.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.kRd.setImageBitmap(bitmap);
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
        private String kRx;
        private Boolean kRy = false;
        private Boolean kRz = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.kRj.setDialogVisiable(true);
            EditHeadActivity.this.bhL.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public Bitmap doInBackground(String... strArr) {
            this.kRx = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.bhN == null) {
                return null;
            }
            if (this.kRx.equals("0") || this.kRx.equals("1")) {
                this.kRy = true;
            } else if (this.kRx.equals("2") || this.kRx.equals("3")) {
                this.kRz = true;
            }
            if (this.kRy.booleanValue() || this.kRz.booleanValue()) {
                if (EditHeadActivity.this.bhN != null) {
                    this.bitmap = EditHeadActivity.this.bhN.copy(EditHeadActivity.this.bhN.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.kRy.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.kRx));
            } else if (this.kRz.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.kRx));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.bhN != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.kRj.setDialogVisiable(false);
            EditHeadActivity.this.bhL.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.kRj.setDialogVisiable(false);
            EditHeadActivity.this.bhL.setClickable(true);
            EditHeadActivity.this.bhL.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.kRy.booleanValue() || this.kRz.booleanValue()) {
                    EditHeadActivity.this.kRd.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, 1800);
                    }
                    if (this.kRy.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.kRx));
                    } else if (this.kRz.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.kRx));
                    }
                } else {
                    EditHeadActivity.this.kRd.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.bhN != null && !EditHeadActivity.this.bhN.isRecycled()) {
                    EditHeadActivity.this.bhN.recycle();
                }
                EditHeadActivity.this.bhN = bitmap;
            }
        }
    }

    private void cqv() {
        this.kRr = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.kRr, intentFilter);
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
            EditHeadActivity.this.kRq = null;
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
