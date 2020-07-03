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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View bhr;
    private View bhs;
    private TextView bhv;
    private int iZz;
    private String kIb;
    private ImageView kIe;
    private FrameLayout kIf;
    private RadioButton kIl;
    private RadioButton kIm;
    private int kIs;
    private HashMap<String, Bitmap> kIt;
    private HashMap<String, ImageView> kIu;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = "delete";
    public static String kIa = "change";
    public static String FILE_NAME = "file_name";
    private float bhn = 1.0f;
    private EditHeadsImageView kIc = null;
    private EditHeadsImageTopLayerView kId = null;
    private Bitmap mBitmap = null;
    private int jbV = 0;
    private Button kIg = null;
    private Button kIh = null;
    private com.baidu.tbadk.core.view.a kIi = null;
    private b kIj = null;
    private a kIk = null;
    private LinearLayout kIn = null;
    private LinearLayout kIo = null;
    private d kIp = null;
    private TextView mTitle = null;
    private Bitmap bhu = null;
    private c kIq = null;
    private boolean eDz = true;
    private boolean kIr = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.jbV = intent.getIntExtra("edit_type", 0);
        this.iZz = intent.getIntExtra("request", 0);
        this.eDz = intent.getBooleanExtra("need_upload", true);
        this.kIr = intent.getBooleanExtra(EditHeadActivityConfig.NEED_PASTE, true);
        this.kIs = intent.getIntExtra(EditHeadActivityConfig.WATERMARK_TYPE, 0);
        this.bhn = intent.getFloatExtra("cut_image_height_scale", 1.0f);
        this.kIb = intent.getStringExtra("from_where");
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.iZz == 12002 || this.iZz == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.iZz, intent.getData(), as.aWR().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.iZz, null, as.aWR().getPostImageSize(), 0, stringExtra);
            }
            cmU();
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
        cSr();
    }

    private void cSr() {
        an.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.bhr);
        getLayoutMode().onModeChanged(this.bhs);
        an.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1);
        an.setNavbarIconSrc(this.mNavigationBar.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
        an.setViewTextColor(this.bhv, R.color.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.kIj != null) {
            this.kIj.cancel();
        }
        this.kIc.setImageDrawable(null);
        cSs();
    }

    private void cSs() {
        if (this.kIu != null) {
            for (Map.Entry<String, ImageView> entry : this.kIu.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.kIu.clear();
            this.kIu = null;
        }
        if (this.kIt != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.kIt.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.kIt.clear();
            this.kIt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.kIj != null) {
            this.kIj.cancel();
        }
        this.kIj = new b();
        this.kIj.execute(new Object[0]);
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
        this.kIc.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.kIp != null) {
            this.kIp.cancel();
        }
        if (this.bhu != null && !this.bhu.isRecycled()) {
            this.bhu.recycle();
            this.bhu = null;
        }
        if (this.kIj != null) {
            this.kIj.cancel();
            this.kIj = null;
        }
        this.kIi.setDialogVisiable(false);
        if (this.iZz == 12002 || this.iZz == 12001) {
            unregisterReceiver(this.kIq);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSt() {
        if (this.kIp != null) {
            this.kIp.cancel();
        }
        this.kIp = new d();
        this.kIp.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.kIi = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kIi.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.kIi.setDialogVisiable(false);
            }
        });
        this.kIi.setDialogVisiable(false);
        this.kId = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        this.kIe = (ImageView) findViewById(R.id.preview_image);
        this.kIf = (FrameLayout) findViewById(R.id.preview_layout);
        int[] screenDimensions = l.getScreenDimensions(getPageContext().getPageActivity());
        this.kIf.setY((int) (screenDimensions[0] + ((screenDimensions[1] - screenDimensions[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.kIc = (EditHeadsImageView) findViewById(R.id.image);
        this.kIc.setCutImageHeightScale(this.bhn);
        if (this.mBitmap != null) {
            this.kIc.setImageBitmap(this.mBitmap);
        }
        this.kIc.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.kIf != null && EditHeadActivity.this.kIf.getVisibility() == 0) {
                    EditHeadActivity.this.kIe.setImageBitmap(EditHeadActivity.this.kIc.cg(false));
                }
            }
        });
        this.kIc.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.kIf != null && EditHeadActivity.this.kIf.getVisibility() == 0) {
                    EditHeadActivity.this.kIe.setImageBitmap(EditHeadActivity.this.kIc.cg(false));
                }
            }
        });
        this.bhr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.kIh = (Button) findViewById(R.id.show_button);
        this.kIh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.kIo.setVisibility(0);
                EditHeadActivity.this.kIh.setVisibility(8);
                EditHeadActivity.this.kIm.setPadding(0, EditHeadActivity.this.kIm.getPaddingTop(), EditHeadActivity.this.kIm.getPaddingRight(), EditHeadActivity.this.kIm.getPaddingBottom());
                EditHeadActivity.this.kIm.setChecked(true);
                EditHeadActivity.this.kIl.setVisibility(8);
            }
        });
        this.kIg = (Button) findViewById(R.id.hide_button);
        this.kIg.setVisibility(0);
        this.kIg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.kIo.setVisibility(8);
                EditHeadActivity.this.kIh.setVisibility(0);
            }
        });
        this.bhs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.bhs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.jbV == 0) {
                    if (!EditHeadActivity.this.eDz) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap cg = EditHeadActivity.this.kIc.cg(EditHeadActivity.this.jbV == 0 || EditHeadActivity.this.jbV == 3);
                if (cg != null && EditHeadActivity.this.c(str, cg)) {
                    if (EditHeadActivity.this.jbV == 0) {
                        if (EditHeadActivity.this.eDz) {
                            EditHeadActivity.this.cSt();
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
                                    if ("from_misson_set_cover".equals(EditHeadActivity.this.kIb)) {
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
                    aVar.nN(EditHeadActivity.this.kIs);
                    aVar.loadPic(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(R.string.uploading));
                }
            }
        });
        this.bhs.setEnabled(false);
        this.bhv = (TextView) this.bhs.findViewById(R.id.save);
        this.bhv.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.kIb)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.kIb)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.kIo = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.kIn = (LinearLayout) findViewById(R.id.rotate);
        this.kIl = (RadioButton) findViewById(R.id.beautify_btn);
        this.kIm = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.kIl) {
                        EditHeadActivity.this.kIn.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.kIm) {
                        EditHeadActivity.this.kIn.setVisibility(0);
                    }
                }
            }
        };
        this.kIl.setOnCheckedChangeListener(onCheckedChangeListener);
        this.kIm.setOnCheckedChangeListener(onCheckedChangeListener);
        this.kIl.setChecked(true);
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
                if (!EditHeadActivity.this.kIi.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.bhu != null) && view.getTag() != null) {
                        EditHeadActivity.this.KG(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.kIb)) {
            this.kIf.setVisibility(0);
            this.kIh.setVisibility(8);
            this.kId.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.kId.setLineWidth(2);
        }
        if (!this.kIr) {
            this.kIh.setVisibility(8);
            this.mTitle.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG(String str) {
        if (this.kIk != null) {
            this.kIk.cancel();
        }
        this.kIk = new a();
        this.kIk.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
            EditHeadActivity.this.kIi.setDialogVisiable(true);
            EditHeadActivity.this.bhs.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.kIj = null;
            EditHeadActivity.this.kIi.setDialogVisiable(false);
            EditHeadActivity.this.bhs.setClickable(true);
            EditHeadActivity.this.bhs.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.kIj = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.kIi.setDialogVisiable(false);
            EditHeadActivity.this.bhs.setClickable(true);
            EditHeadActivity.this.bhs.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.kIc.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.kIc.setImageBitmap(bitmap);
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
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String kIw;
        private Boolean kIx = false;
        private Boolean kIy = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.kIi.setDialogVisiable(true);
            EditHeadActivity.this.bhs.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public Bitmap doInBackground(String... strArr) {
            this.kIw = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.bhu == null) {
                return null;
            }
            if (this.kIw.equals("0") || this.kIw.equals("1")) {
                this.kIx = true;
            } else if (this.kIw.equals("2") || this.kIw.equals("3")) {
                this.kIy = true;
            }
            if (this.kIx.booleanValue() || this.kIy.booleanValue()) {
                if (EditHeadActivity.this.bhu != null) {
                    this.bitmap = EditHeadActivity.this.bhu.copy(EditHeadActivity.this.bhu.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.kIx.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.kIw));
            } else if (this.kIy.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.kIw));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.bhu != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.kIi.setDialogVisiable(false);
            EditHeadActivity.this.bhs.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.kIi.setDialogVisiable(false);
            EditHeadActivity.this.bhs.setClickable(true);
            EditHeadActivity.this.bhs.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.kIx.booleanValue() || this.kIy.booleanValue()) {
                    EditHeadActivity.this.kIc.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, 1800);
                    }
                    if (this.kIx.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.kIw));
                    } else if (this.kIy.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.kIw));
                    }
                } else {
                    EditHeadActivity.this.kIc.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.bhu != null && !EditHeadActivity.this.bhu.isRecycled()) {
                    EditHeadActivity.this.bhu.recycle();
                }
                EditHeadActivity.this.bhu = bitmap;
            }
        }
    }

    private void cmU() {
        this.kIq = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.kIq, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
            if (EditHeadActivity.this.bhs != null) {
                EditHeadActivity.this.bhs.setEnabled(false);
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
    /* loaded from: classes11.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        private y mNetwork;

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
            this.mNetwork = new y(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.wD(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.aWu().aWW().isRequestSuccess()) {
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
            EditHeadActivity.this.kIp = null;
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
                if (this.mNetwork.aWu().aWW().isRequestSuccess()) {
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
