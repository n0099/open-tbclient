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
/* loaded from: classes11.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View aBh;
    private View aBi;
    private TextView aBl;
    private int hJh;
    private String jkN;
    private ImageView jkQ;
    private FrameLayout jkR;
    private RadioButton jkX;
    private RadioButton jkY;
    private HashMap<String, Bitmap> jld;
    private HashMap<String, ImageView> jle;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = "delete";
    public static String jkM = "change";
    public static String FILE_NAME = "file_name";
    private float aBd = 1.0f;
    private EditHeadsImageView jkO = null;
    private EditHeadsImageTopLayerView jkP = null;
    private Bitmap mBitmap = null;
    private int hLE = 0;
    private Button jkS = null;
    private Button jkT = null;
    private com.baidu.tbadk.core.view.a jkU = null;
    private b jkV = null;
    private a jkW = null;
    private LinearLayout jkZ = null;
    private LinearLayout jla = null;
    private d jlb = null;
    private TextView mTitle = null;
    private Bitmap aBk = null;
    private c jlc = null;
    private boolean dGv = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.hLE = intent.getIntExtra("edit_type", 0);
        this.hJh = intent.getIntExtra("request", 0);
        this.dGv = intent.getBooleanExtra("need_upload", true);
        this.aBd = intent.getFloatExtra("cut_image_height_scale", 1.0f);
        this.jkN = intent.getStringExtra("from_where");
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.hJh == 12002 || this.hJh == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.hJh, intent.getData(), ar.aGH().getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.hJh, null, ar.aGH().getPostImageSize(), 0, stringExtra);
            }
            bSa();
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
        cwd();
    }

    private void cwd() {
        am.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        getLayoutMode().onModeChanged(this.aBh);
        getLayoutMode().onModeChanged(this.aBi);
        am.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1);
        am.setNavbarIconSrc(this.mNavigationBar.getBackImageView(), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s, 0);
        am.setViewTextColor(this.aBl, R.color.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.jkV != null) {
            this.jkV.cancel();
        }
        this.jkO.setImageDrawable(null);
        cwe();
    }

    private void cwe() {
        if (this.jle != null) {
            for (Map.Entry<String, ImageView> entry : this.jle.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.jle.clear();
            this.jle = null;
        }
        if (this.jld != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.jld.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.jld.clear();
            this.jld = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.jkV != null) {
            this.jkV.cancel();
        }
        this.jkV = new b();
        this.jkV.execute(new Object[0]);
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
        this.jkO.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.jlb != null) {
            this.jlb.cancel();
        }
        if (this.aBk != null && !this.aBk.isRecycled()) {
            this.aBk.recycle();
            this.aBk = null;
        }
        if (this.jkV != null) {
            this.jkV.cancel();
            this.jkV = null;
        }
        this.jkU.setDialogVisiable(false);
        if (this.hJh == 12002 || this.hJh == 12001) {
            unregisterReceiver(this.jlc);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwf() {
        if (this.jlb != null) {
            this.jlb.cancel();
        }
        this.jlb = new d();
        this.jlb.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.jkU = new com.baidu.tbadk.core.view.a(getPageContext());
        this.jkU.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.jkU.setDialogVisiable(false);
            }
        });
        this.jkU.setDialogVisiable(false);
        this.jkP = (EditHeadsImageTopLayerView) findViewById(R.id.image_top_layer);
        this.jkQ = (ImageView) findViewById(R.id.preview_image);
        this.jkR = (FrameLayout) findViewById(R.id.preview_layout);
        int[] screenDimensions = l.getScreenDimensions(getPageContext().getPageActivity());
        this.jkR.setY((int) (screenDimensions[0] + ((screenDimensions[1] - screenDimensions[0]) * 0.4d) + getResources().getDimensionPixelSize(R.dimen.ds74)));
        this.jkO = (EditHeadsImageView) findViewById(R.id.image);
        this.jkO.setCutImageHeightScale(this.aBd);
        if (this.mBitmap != null) {
            this.jkO.setImageBitmap(this.mBitmap);
        }
        this.jkO.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.jkR != null && EditHeadActivity.this.jkR.getVisibility() == 0) {
                    EditHeadActivity.this.jkQ.setImageBitmap(EditHeadActivity.this.jkO.bn(false));
                }
            }
        });
        this.jkO.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.jkR != null && EditHeadActivity.this.jkR.getVisibility() == 0) {
                    EditHeadActivity.this.jkQ.setImageBitmap(EditHeadActivity.this.jkO.bn(false));
                }
            }
        });
        this.aBh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.jkT = (Button) findViewById(R.id.show_button);
        this.jkT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.jla.setVisibility(0);
                EditHeadActivity.this.jkT.setVisibility(8);
                EditHeadActivity.this.jkY.setPadding(0, EditHeadActivity.this.jkY.getPaddingTop(), EditHeadActivity.this.jkY.getPaddingRight(), EditHeadActivity.this.jkY.getPaddingBottom());
                EditHeadActivity.this.jkY.setChecked(true);
                EditHeadActivity.this.jkX.setVisibility(8);
            }
        });
        this.jkS = (Button) findViewById(R.id.hide_button);
        this.jkS.setVisibility(0);
        this.jkS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.jla.setVisibility(8);
                EditHeadActivity.this.jkT.setVisibility(0);
            }
        });
        this.aBi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.aBi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.hLE == 0) {
                    if (!EditHeadActivity.this.dGv) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap bn = EditHeadActivity.this.jkO.bn(EditHeadActivity.this.hLE == 0 || EditHeadActivity.this.hLE == 3);
                if (bn != null && EditHeadActivity.this.c(str, bn)) {
                    if (EditHeadActivity.this.hLE == 0) {
                        if (EditHeadActivity.this.dGv) {
                            EditHeadActivity.this.cwf();
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
                                    if ("from_misson_set_cover".equals(EditHeadActivity.this.jkN)) {
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
        this.aBi.setEnabled(false);
        this.aBl = (TextView) this.aBi.findViewById(R.id.save);
        this.aBl.setText(R.string.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.jkN)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        }
        if ("from_photo_live".equals(this.jkN)) {
            this.mTitle.setText(R.string.choose_picture);
        }
        this.jla = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.jkZ = (LinearLayout) findViewById(R.id.rotate);
        this.jkX = (RadioButton) findViewById(R.id.beautify_btn);
        this.jkY = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.jkX) {
                        EditHeadActivity.this.jkZ.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.jkY) {
                        EditHeadActivity.this.jkZ.setVisibility(0);
                    }
                }
            }
        };
        this.jkX.setOnCheckedChangeListener(onCheckedChangeListener);
        this.jkY.setOnCheckedChangeListener(onCheckedChangeListener);
        this.jkX.setChecked(true);
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
                if (!EditHeadActivity.this.jkU.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.aBk != null) && view.getTag() != null) {
                        EditHeadActivity.this.GI(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.jkN)) {
            this.jkR.setVisibility(0);
            this.jkT.setVisibility(8);
            this.jkP.setLinePaintColor(getResources().getColor(R.color.white_alpha50));
            this.jkP.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GI(String str) {
        if (this.jkW != null) {
            this.jkW.cancel();
        }
        this.jkW = new a();
        this.jkW.execute(str);
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
            EditHeadActivity.this.jkU.setDialogVisiable(true);
            EditHeadActivity.this.aBi.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.jkV = null;
            EditHeadActivity.this.jkU.setDialogVisiable(false);
            EditHeadActivity.this.aBi.setClickable(true);
            EditHeadActivity.this.aBi.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.jkV = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.jkU.setDialogVisiable(false);
            EditHeadActivity.this.aBi.setClickable(true);
            EditHeadActivity.this.aBi.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.jkO.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.jkO.setImageBitmap(bitmap);
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
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String jlg;
        private Boolean jlh = false;
        private Boolean jli = false;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.jkU.setDialogVisiable(true);
            EditHeadActivity.this.aBi.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public Bitmap doInBackground(String... strArr) {
            this.jlg = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.aBk == null) {
                return null;
            }
            if (this.jlg.equals("0") || this.jlg.equals("1")) {
                this.jlh = true;
            } else if (this.jlg.equals("2") || this.jlg.equals("3")) {
                this.jli = true;
            }
            if (this.jlh.booleanValue() || this.jli.booleanValue()) {
                if (EditHeadActivity.this.aBk != null) {
                    this.bitmap = EditHeadActivity.this.aBk.copy(EditHeadActivity.this.aBk.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.jlh.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.jlg));
            } else if (this.jli.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.jlg));
            }
            return this.bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.aBk != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.jkU.setDialogVisiable(false);
            EditHeadActivity.this.aBi.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.jkU.setDialogVisiable(false);
            EditHeadActivity.this.aBi.setClickable(true);
            EditHeadActivity.this.aBi.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.jlh.booleanValue() || this.jli.booleanValue()) {
                    EditHeadActivity.this.jkO.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, 1800);
                    }
                    if (this.jlh.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.jlg));
                    } else if (this.jli.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.jlg));
                    }
                } else {
                    EditHeadActivity.this.jkO.replaceImageBitmap(bitmap);
                }
                if (EditHeadActivity.this.aBk != null && !EditHeadActivity.this.aBk.isRecycled()) {
                    EditHeadActivity.this.aBk.recycle();
                }
                EditHeadActivity.this.aBk = bitmap;
            }
        }
    }

    private void bSa() {
        this.jlc = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.jlc, intentFilter);
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
            if (EditHeadActivity.this.aBi != null) {
                EditHeadActivity.this.aBi.setEnabled(false);
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
                str = this.mNetwork.tr(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.aGk().aGM().isRequestSuccess()) {
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
            EditHeadActivity.this.jlb = null;
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
                if (this.mNetwork.aGk().aGM().isRequestSuccess()) {
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
