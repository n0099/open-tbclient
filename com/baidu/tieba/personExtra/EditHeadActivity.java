package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.view.FiltersView;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private int ezK;
    private String fVR;
    private ImageView fVU;
    private FrameLayout fVV;
    private View fVW;
    private View fVX;
    private RadioButton fWe;
    private RadioButton fWf;
    private LinearLayout fWp;
    private HashMap<String, Bitmap> fWr;
    private HashMap<String, ImageView> fWs;
    private View fWt;
    private TextView fWu;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String fVO = "change";
    public static String FILE_NAME = "file_name";
    private static String[] fVQ = null;
    private float fVP = 1.0f;
    private EditHeadsImageView fVS = null;
    private EditHeadsImageTopLayerView fVT = null;
    private Bitmap mBitmap = null;
    private int eCj = 0;
    private Button fVY = null;
    private Button fVZ = null;
    private HorizontalScrollView fWa = null;
    private com.baidu.tbadk.core.view.a fWb = null;
    private b fWc = null;
    private a fWd = null;
    private LinearLayout fWg = null;
    private LinearLayout fWh = null;
    private d fWi = null;
    private TextView mTitle = null;
    private Bitmap fWj = null;
    private c fWk = null;
    private int fWl = 0;
    private int fWm = 0;
    private boolean fWn = true;
    private String fWo = null;
    private boolean fWq = false;
    private boolean aVX = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.hv().ax("motu_sdk") == 1 || PluginPackageManager.lN().bM(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fWn = false;
        } else {
            this.fWn = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(f.h.edit_head_activity);
        Intent intent = getIntent();
        this.eCj = intent.getIntExtra("edit_type", 0);
        this.ezK = intent.getIntExtra("request", 0);
        this.aVX = intent.getBooleanExtra("need_upload", true);
        this.fVP = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.fVR = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.ezK == 12002 || this.ezK == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.ezK, intent.getData(), ar.zu().zA());
            } else {
                TiebaPrepareImageService.StartService(this.ezK, null, ar.zu().zA(), 0, stringExtra);
            }
            aGO();
        } else {
            initUI();
            initData();
        }
        fVQ = getResources().getStringArray(f.b.fiter_name);
        if (this.fWn) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bia();
    }

    private void bia() {
        am.j(this.mNavigationBar, f.d.common_color_10222);
        getLayoutMode().onModeChanged(this.fVW);
        getLayoutMode().onModeChanged(this.fVX);
        am.c(this.mTitle, f.d.cp_cont_g, 1);
        am.b(this.mNavigationBar.getBackImageView(), f.C0146f.icon_topbar_return_s, f.C0146f.icon_topbar_return_s, 0);
        am.c(this.fWu, f.d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.fWc != null) {
            this.fWc.cancel();
        }
        this.fVS.setImageDrawable(null);
        bib();
    }

    private void bib() {
        if (this.fWs != null) {
            for (Map.Entry<String, ImageView> entry : this.fWs.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.fWs.clear();
            this.fWs = null;
        }
        if (this.fWr != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.fWr.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.fWr.clear();
            this.fWr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.fWc != null) {
            this.fWc.cancel();
        }
        this.fWc = new b();
        this.fWc.execute(new Object[0]);
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
        this.fVS.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.fWi != null) {
            this.fWi.cancel();
        }
        if (this.fWj != null && !this.fWj.isRecycled()) {
            this.fWj.recycle();
            this.fWj = null;
        }
        if (this.fWc != null) {
            this.fWc.cancel();
            this.fWc = null;
        }
        this.fWb.aN(false);
        if (this.ezK == 12002 || this.ezK == 12001) {
            unregisterReceiver(this.fWk);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bic() {
        if (this.fWi != null) {
            this.fWi.cancel();
        }
        this.fWi = new d();
        this.fWi.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(f.g.navigation_bar);
        this.fWb = new com.baidu.tbadk.core.view.a(getPageContext());
        this.fWb.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.fWb.aN(false);
            }
        });
        this.fWb.aN(false);
        this.fVT = (EditHeadsImageTopLayerView) findViewById(f.g.image_top_layer);
        this.fVU = (ImageView) findViewById(f.g.preview_image);
        this.fVV = (FrameLayout) findViewById(f.g.preview_layout);
        int[] al = l.al(getPageContext().getPageActivity());
        this.fVV.setY((int) (al[0] + ((al[1] - al[0]) * 0.4d) + getResources().getDimensionPixelSize(f.e.ds74)));
        this.fVS = (EditHeadsImageView) findViewById(f.g.image);
        this.fVS.setCutImageHeightScale(this.fVP);
        if (this.mBitmap != null) {
            this.fVS.setImageBitmap(this.mBitmap);
        }
        this.fVS.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.fVV != null && EditHeadActivity.this.fVV.getVisibility() == 0) {
                    EditHeadActivity.this.fVU.setImageBitmap(EditHeadActivity.this.fVS.lb(false));
                }
            }
        });
        this.fVS.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.fVV != null && EditHeadActivity.this.fVV.getVisibility() == 0) {
                    EditHeadActivity.this.fVU.setImageBitmap(EditHeadActivity.this.fVS.lb(false));
                }
            }
        });
        this.fWa = (HorizontalScrollView) findViewById(f.g.filters_layout);
        this.fVW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.fVZ = (Button) findViewById(f.g.show_button);
        this.fVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.fWh.setVisibility(0);
                EditHeadActivity.this.fVZ.setVisibility(8);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.fWn) {
                    EditHeadActivity.this.fWf.setPadding(0, EditHeadActivity.this.fWf.getPaddingTop(), EditHeadActivity.this.fWf.getPaddingRight(), EditHeadActivity.this.fWf.getPaddingBottom());
                    EditHeadActivity.this.fWf.setChecked(true);
                    EditHeadActivity.this.fWa.setVisibility(8);
                    EditHeadActivity.this.fWe.setVisibility(8);
                }
            }
        });
        this.fVY = (Button) findViewById(f.g.hide_button);
        this.fVY.setVisibility(0);
        this.fVY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.fWh.setVisibility(8);
                EditHeadActivity.this.fVZ.setVisibility(0);
            }
        });
        this.fVX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.image_activity_save_button, (View.OnClickListener) null);
        this.fVX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.eCj == 0) {
                    if (!EditHeadActivity.this.aVX) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap lb = EditHeadActivity.this.fVS.lb(EditHeadActivity.this.eCj == 0 || EditHeadActivity.this.eCj == 3);
                if (lb != null && EditHeadActivity.this.c(str, lb)) {
                    if (EditHeadActivity.this.eCj == 0) {
                        if (EditHeadActivity.this.aVX) {
                            EditHeadActivity.this.bic();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.l.dT(str), "head");
                    aVar.IX();
                    aVar.a(new a.c() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9.1
                        @Override // com.baidu.tbadk.img.a.c
                        public void a(String str2, ImageUploadResult imageUploadResult) {
                            EditHeadActivity.this.closeLoadingDialog();
                            Intent intent2 = EditHeadActivity.this.getIntent();
                            if (imageUploadResult != null) {
                                if (imageUploadResult.error_code != 0) {
                                    EditHeadActivity.this.showToast(f.j.upload_pic_error, false);
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.fVR)) {
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
                    aVar.bN(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(f.j.uploading));
                }
            }
        });
        this.fVX.setEnabled(false);
        this.fWu = (TextView) this.fVX.findViewById(f.g.save);
        this.fWu.setText(f.j.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.fVR)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(f.j.beautify));
        }
        if ("from_photo_live".equals(this.fVR)) {
            this.mTitle.setText(f.j.choose_picture);
        }
        this.fWp = (LinearLayout) findViewById(f.g.filters);
        this.fWl = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.fWh = (LinearLayout) findViewById(f.g.beautify_rotate);
        this.fWg = (LinearLayout) findViewById(f.g.rotate);
        this.fWe = (RadioButton) findViewById(f.g.beautify_btn);
        this.fWf = (RadioButton) findViewById(f.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.fWe) {
                        EditHeadActivity.this.fWa.setVisibility(0);
                        EditHeadActivity.this.fWg.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.fWf) {
                        EditHeadActivity.this.fWa.setVisibility(8);
                        EditHeadActivity.this.fWg.setVisibility(0);
                    }
                }
            }
        };
        this.fWe.setOnCheckedChangeListener(onCheckedChangeListener);
        this.fWf.setOnCheckedChangeListener(onCheckedChangeListener);
        this.fWe.setChecked(true);
        Button button = (Button) findViewById(f.g.rotate_left);
        Button button2 = (Button) findViewById(f.g.rotate_right);
        Button button3 = (Button) findViewById(f.g.rotate_left_right);
        Button button4 = (Button) findViewById(f.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!EditHeadActivity.this.fWb.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.fWj != null) && view.getTag() != null) {
                        EditHeadActivity.this.fWq = false;
                        EditHeadActivity.this.O(view.getTag().toString(), false);
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.fVR)) {
            this.fVV.setVisibility(0);
            this.fVZ.setVisibility(8);
            this.fVT.setLinePaintColor(getResources().getColor(f.d.white_alpha50));
            this.fVT.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(String str, boolean z) {
        if (this.fWd != null) {
            this.fWd.cancel();
        }
        this.fWd = new a(z);
        this.fWd.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap aa = com.baidu.tbadk.core.util.l.aa(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (aa.getWidth() > 1800 || aa.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(aa, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            aa.recycle();
                            aa = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && aa != null && !aa.isRecycled()) {
                        aa.recycle();
                        return null;
                    }
                    int dip2px = l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.fWn) {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(aa, dip2px);
                        Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), aa != resizedBitmap);
                        EditHeadActivity.this.fWr = new HashMap();
                        EditHeadActivity.this.fWs = new HashMap();
                        EditHeadActivity.this.fWr.put("normal", roundedCornerBitmap);
                    }
                    return aa;
                } catch (Exception e2) {
                    bitmap = aa;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.fWb.aN(true);
            EditHeadActivity.this.fVX.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.fWc = null;
            EditHeadActivity.this.fWb.aN(false);
            EditHeadActivity.this.fVX.setClickable(true);
            EditHeadActivity.this.fVX.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.fWc = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.fWb.aN(false);
            EditHeadActivity.this.fVX.setClickable(true);
            EditHeadActivity.this.fVX.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.fVS.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.fVS.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.fWn) {
                    EditHeadActivity.this.y(EditHeadActivity.fVQ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.l.a((String) null, str, bitmap, 80);
            if (this.fWq) {
                new ah("motu_pic", String.valueOf(this.fWm)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String[] strArr) {
        if (this.fWr != null && strArr != null) {
            this.fWp.removeAllViews();
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(f.h.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(f.g.filter_immage);
            TextView textView = (TextView) inflate.findViewById(f.g.filter_text);
            int length = strArr.length;
            int i = 0;
            final int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                final String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(f.h.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(f.g.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(f.g.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(FiltersView.ga(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.fWb.isShowing()) {
                                EditHeadActivity.this.fVS.i(EditHeadActivity.this.mBitmap);
                                EditHeadActivity.this.fWq = false;
                                EditHeadActivity.this.rQ(substring);
                                EditHeadActivity.this.fWm = i2;
                            }
                        }
                    });
                    this.fWt = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.fWb.isShowing() && !substring.equals(EditHeadActivity.this.fWo)) {
                                EditHeadActivity.this.O(substring, true);
                                EditHeadActivity.this.rQ(substring);
                                EditHeadActivity.this.fWm = i2;
                            }
                        }
                    });
                }
                this.fWp.addView(inflate2);
                if (this.fWs != null) {
                    this.fWs.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            rQ("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.fWs == null) {
                this.fWs = new HashMap<>();
            }
            if (this.fWo != null && (imageView = this.fWs.get(this.fWo)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.fWl, this.fWl, this.fWl, this.fWl);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.fWs.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(f.C0146f.round_corner);
                imageView2.setPadding(this.fWl, this.fWl, this.fWl, this.fWl);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.fWo = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean fWx;
        private String fWy;
        private Boolean fWz = false;
        private Boolean fWA = false;

        public a(boolean z) {
            this.fWx = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.fWx || bie()) {
                EditHeadActivity.this.fWb.aN(true);
                EditHeadActivity.this.fVX.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.fWy = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.fWj == null) {
                return null;
            }
            if (this.fWy.equals("0") || this.fWy.equals("1")) {
                this.fWz = true;
            } else if (this.fWy.equals("2") || this.fWy.equals("3")) {
                this.fWA = true;
            }
            if (this.fWz.booleanValue() || this.fWA.booleanValue()) {
                if (EditHeadActivity.this.fWj != null) {
                    this.bitmap = EditHeadActivity.this.fWj.copy(EditHeadActivity.this.fWj.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.fWz.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.fWy));
            } else if (this.fWA.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.fWy));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.fWy, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean bie() {
            PluginPackageManager.PluginStatus bM = PluginPackageManager.lN().bM(PluginCenter.NAME_MOTUSDK);
            if (bM == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (bM == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), f.j.plugin_config_not_found);
                return false;
            } else if (bM == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lN().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (bM == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.d.a.a(EditHeadActivity.this.getPageContext(), f.j.plugin_muto_not_install, new a.b() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginCenter.NAME_MOTUSDK)));
                        aVar.dismiss();
                    }
                }, new a.b() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                return false;
            } else {
                return true;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.fWj != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.fWb.aN(false);
            EditHeadActivity.this.fVX.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.fWb.aN(false);
            EditHeadActivity.this.fVX.setClickable(true);
            EditHeadActivity.this.fVX.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.fWq = true;
                if (this.fWz.booleanValue() || this.fWA.booleanValue()) {
                    EditHeadActivity.this.fVS.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.fWz.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.fWy));
                    } else if (this.fWA.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.fWy));
                    }
                } else {
                    EditHeadActivity.this.fVS.i(bitmap);
                }
                if (EditHeadActivity.this.fWj != null && !EditHeadActivity.this.fWj.isRecycled()) {
                    EditHeadActivity.this.fWj.recycle();
                }
                EditHeadActivity.this.fWj = bitmap;
            }
        }
    }

    private void aGO() {
        this.fWk = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.fWk, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
            if (EditHeadActivity.this.fVX != null) {
                EditHeadActivity.this.fVX.setEnabled(false);
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
    /* loaded from: classes3.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        private y mNetwork;

        private d() {
            this.mNetwork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(f.j.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.mNetwork = new y(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.eB(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.yM().zL().isRequestSuccess()) {
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
            EditHeadActivity.this.fWi = null;
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                if (this.mNetwork.yM().zL().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(f.j.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }
    }
}
