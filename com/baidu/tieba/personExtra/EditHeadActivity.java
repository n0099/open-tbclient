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
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes7.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View bFV;
    private View bFW;
    private TextView bFZ;
    private int kBN;
    private NavigationBar mNavigationBar;
    private String mmG;
    private ImageView mmJ;
    private FrameLayout mmK;
    private RadioButton mmR;
    private RadioButton mmS;
    private int mmY;
    private HashMap<String, Bitmap> mmZ;
    private HashMap<String, ImageView> mna;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = "delete";
    public static String mmF = "change";
    public static String FILE_NAME = "file_name";
    private float bFR = 1.0f;
    private EditHeadsImageView mmH = null;
    private EditHeadsImageTopLayerView mmI = null;
    private Bitmap mBitmap = null;
    private int mmL = 0;
    private Button mmM = null;
    private Button mmN = null;
    private com.baidu.tbadk.core.view.a mmO = null;
    private b mmP = null;
    private a mmQ = null;
    private LinearLayout mmT = null;
    private LinearLayout mmU = null;
    private d mmV = null;
    private TextView mTitle = null;
    private Bitmap bFY = null;
    private c mmW = null;
    private boolean fJS = true;
    private boolean mmX = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.mmL = intent.getIntExtra("edit_type", 0);
        this.kBN = intent.getIntExtra("request", 0);
        this.fJS = intent.getBooleanExtra("need_upload", true);
        this.mmX = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
        this.mmY = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
        this.bFR = intent.getFloatExtra("cut_image_height_scale", 1.0f);
        this.mmG = intent.getStringExtra("from_where");
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.kBN == 12002 || this.kBN == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.kBN, intent.getData(), au.bsy().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.kBN, null, au.bsy().getPostImageSize(), 0, stringExtra);
            }
            cSw();
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
        duV();
    }

    private void duV() {
        ao.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.bFV);
        getLayoutMode().onModeChanged(this.bFW);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1);
        ao.setNavbarIconSrc(this.mNavigationBar.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
        ao.setViewTextColor(this.bFZ, R.color.CAM_X0111, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.mmP != null) {
            this.mmP.cancel();
        }
        this.mmH.setImageDrawable(null);
        duW();
    }

    private void duW() {
        if (this.mna != null) {
            for (Map.Entry<String, ImageView> entry : this.mna.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.mna.clear();
            this.mna = null;
        }
        if (this.mmZ != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.mmZ.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.mmZ.clear();
            this.mmZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.mmP != null) {
            this.mmP.cancel();
        }
        this.mmP = new b();
        this.mmP.execute(new Object[0]);
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
        this.mmH.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.mmV != null) {
            this.mmV.cancel();
        }
        if (this.bFY != null && !this.bFY.isRecycled()) {
            this.bFY.recycle();
            this.bFY = null;
        }
        if (this.mmP != null) {
            this.mmP.cancel();
            this.mmP = null;
        }
        this.mmO.setDialogVisiable(false);
        if (this.kBN == 12002 || this.kBN == 12001) {
            unregisterReceiver(this.mmW);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duX() {
        if (this.mmV != null) {
            this.mmV.cancel();
        }
        this.mmV = new d();
        this.mmV.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mmO = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mmO.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.mmO.setDialogVisiable(false);
            }
        });
        this.mmO.setDialogVisiable(false);
        this.mmI = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(this.mmG) && this.bFR != 1.0f) {
            this.mmI.setmCutHeightScale(this.bFR);
        }
        this.mmJ = (ImageView) findViewById(R.id.preview_image);
        this.mmK = (FrameLayout) findViewById(R.id.preview_layout);
        int[] screenDimensions = l.getScreenDimensions(getPageContext().getPageActivity());
        this.mmK.setY((int) (screenDimensions[0] + ((screenDimensions[1] - screenDimensions[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.mmH = (EditHeadsImageView) findViewById(R.id.image);
        this.mmH.setCutImageHeightScale(this.bFR);
        if (this.mBitmap != null) {
            this.mmH.setImageBitmap(this.mBitmap);
        }
        this.mmH.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.mmK != null && EditHeadActivity.this.mmK.getVisibility() == 0) {
                    EditHeadActivity.this.mmJ.setImageBitmap(EditHeadActivity.this.mmH.cY(false));
                }
            }
        });
        this.mmH.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.mmK != null && EditHeadActivity.this.mmK.getVisibility() == 0) {
                    EditHeadActivity.this.mmJ.setImageBitmap(EditHeadActivity.this.mmH.cY(false));
                }
            }
        });
        this.bFV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.mmN = (Button) findViewById(R.id.show_button);
        this.mmN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.mmU.setVisibility(0);
                EditHeadActivity.this.mmN.setVisibility(8);
                EditHeadActivity.this.mmS.setPadding(0, EditHeadActivity.this.mmS.getPaddingTop(), EditHeadActivity.this.mmS.getPaddingRight(), EditHeadActivity.this.mmS.getPaddingBottom());
                EditHeadActivity.this.mmS.setChecked(true);
                EditHeadActivity.this.mmR.setVisibility(8);
            }
        });
        this.mmM = (Button) findViewById(R.id.hide_button);
        this.mmM.setVisibility(0);
        this.mmM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.mmU.setVisibility(8);
                EditHeadActivity.this.mmN.setVisibility(0);
            }
        });
        this.bFW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.bFW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.mmL == 0) {
                    if (!EditHeadActivity.this.fJS) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap cY = EditHeadActivity.this.mmH.cY(EditHeadActivity.this.mmL == 0 || EditHeadActivity.this.mmL == 3);
                if (cY != null && EditHeadActivity.this.c(str, cY)) {
                    if (EditHeadActivity.this.mmL == 0) {
                        if (EditHeadActivity.this.fJS) {
                            EditHeadActivity.this.duX();
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
                                    if ("from_misson_set_cover".equals(EditHeadActivity.this.mmG)) {
                                        EditHeadActivity.this.a(photoUrlData);
                                    }
                                    intent2.putExtra(EditHeadActivity.PHOTO_RESOURCE, String.valueOf(imageUploadResult.picId));
                                    intent2.putExtra(EditHeadActivity.PIC_INFO, photoUrlData);
                                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.mmG)) {
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
                    aVar.rf(EditHeadActivity.this.mmY);
                    aVar.loadPic(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.bFW.setEnabled(false);
        this.bFZ = (TextView) this.bFW.findViewById(R.id.save);
        this.bFZ.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.mmG)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.mmG)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.mmU = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.mmT = (LinearLayout) findViewById(R.id.rotate);
        this.mmR = (RadioButton) findViewById(R.id.beautify_btn);
        this.mmS = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.mmR) {
                        EditHeadActivity.this.mmT.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.mmS) {
                        EditHeadActivity.this.mmT.setVisibility(0);
                    }
                }
            }
        };
        this.mmR.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mmS.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mmR.setChecked(true);
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
                if (!EditHeadActivity.this.mmO.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.bFY != null) && view.getTag() != null) {
                        EditHeadActivity.this.Pv(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.mmG)) {
            this.mmK.setVisibility(0);
            this.mmN.setVisibility(8);
            this.mmI.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.mmI.setLineWidth(2);
        }
        if (!this.mmX) {
            this.mmN.setVisibility(8);
            this.mTitle.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pv(String str) {
        if (this.mmQ != null) {
            this.mmQ.cancel();
        }
        this.mmQ = new a();
        this.mmQ.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public Bitmap doInBackground(Object... objArr) {
            Exception e;
            Bitmap bitmap;
            Bitmap bitmap2 = null;
            try {
                Bitmap image = n.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (image.getWidth() > 1800 || image.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(image, 1800);
                        try {
                            image.recycle();
                            bitmap = resizeBitmap;
                        } catch (Exception e2) {
                            e = e2;
                            bitmap2 = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap2;
                        }
                    } else {
                        bitmap = image;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bitmap2 = image;
                }
                try {
                    if (!isCancelled() || bitmap == null || bitmap.isRecycled()) {
                        return bitmap;
                    }
                    bitmap.recycle();
                    return null;
                } catch (Exception e4) {
                    e = e4;
                    bitmap2 = bitmap;
                    BdLog.e(e.toString());
                    return bitmap2;
                }
            } catch (Exception e5) {
                e = e5;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.mmO.setDialogVisiable(true);
            EditHeadActivity.this.bFW.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.mmP = null;
            EditHeadActivity.this.mmO.setDialogVisiable(false);
            EditHeadActivity.this.bFW.setClickable(true);
            EditHeadActivity.this.bFW.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.mmP = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.mmO.setDialogVisiable(false);
            EditHeadActivity.this.bFW.setClickable(true);
            EditHeadActivity.this.bFW.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.mmH.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.mmH.setImageBitmap(bitmap);
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
    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String mnc;
        private Boolean mnd = false;
        private Boolean mne = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.mmO.setDialogVisiable(true);
            EditHeadActivity.this.bFW.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: S */
        public Bitmap doInBackground(String... strArr) {
            this.mnc = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.bFY == null) {
                return null;
            }
            if (this.mnc.equals("0") || this.mnc.equals("1")) {
                this.mnd = true;
            } else if (this.mnc.equals("2") || this.mnc.equals("3")) {
                this.mne = true;
            }
            if (this.mnd.booleanValue() || this.mne.booleanValue()) {
                if (EditHeadActivity.this.bFY != null) {
                    this.bitmap = EditHeadActivity.this.bFY.copy(EditHeadActivity.this.bFY.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.mnd.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mnc));
            } else if (this.mne.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mnc));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.bFY != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.mmO.setDialogVisiable(false);
            EditHeadActivity.this.bFW.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.mmO.setDialogVisiable(false);
            EditHeadActivity.this.bFW.setClickable(true);
            EditHeadActivity.this.bFW.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.mnd.booleanValue() || this.mne.booleanValue()) {
                    EditHeadActivity.this.mmH.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, 1800);
                    }
                    if (this.mnd.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mnc));
                    } else if (this.mne.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mnc));
                    }
                } else {
                    EditHeadActivity.this.mmH.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.bFY != null && !EditHeadActivity.this.bFY.isRecycled()) {
                    EditHeadActivity.this.bFY.recycle();
                }
                EditHeadActivity.this.bFY = bitmap;
            }
        }
    }

    private void cSw() {
        this.mmW = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.mmW, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
            if (EditHeadActivity.this.bFW != null) {
                EditHeadActivity.this.bFW.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PhotoUrlData photoUrlData) {
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
    /* loaded from: classes7.dex */
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
            this.mNetwork = new z(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.AI(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e) {
                e = e;
                str = null;
            }
            try {
                if (this.mNetwork.brX().bsH().isRequestSuccess()) {
                    return str;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return str;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.closeLoadingDialog();
            EditHeadActivity.this.mmV = null;
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
                if (this.mNetwork.brX().bsH().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    if (EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER.equals(EditHeadActivity.this.mmG)) {
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
