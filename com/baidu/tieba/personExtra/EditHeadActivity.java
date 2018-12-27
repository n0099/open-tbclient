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
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
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
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.view.FiltersView;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private int eZJ;
    private String gvP;
    private ImageView gvS;
    private FrameLayout gvT;
    private View gvU;
    private View gvV;
    private RadioButton gwc;
    private RadioButton gwd;
    private LinearLayout gwn;
    private HashMap<String, Bitmap> gwp;
    private HashMap<String, ImageView> gwq;
    private View gwr;
    private TextView gws;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String gvM = "change";
    public static String FILE_NAME = "file_name";
    private static String[] gvO = null;
    private float gvN = 1.0f;
    private EditHeadsImageView gvQ = null;
    private EditHeadsImageTopLayerView gvR = null;
    private Bitmap mBitmap = null;
    private int fci = 0;
    private Button gvW = null;
    private Button gvX = null;
    private HorizontalScrollView gvY = null;
    private com.baidu.tbadk.core.view.d gvZ = null;
    private b gwa = null;
    private a gwb = null;
    private LinearLayout gwe = null;
    private LinearLayout gwf = null;
    private d gwg = null;
    private TextView mTitle = null;
    private Bitmap gwh = null;
    private c gwi = null;
    private int gwj = 0;
    private int gwk = 0;
    private boolean gwl = true;
    private String gwm = null;
    private boolean gwo = false;
    private boolean bie = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.iQ().aO("motu_sdk") == 1 || PluginPackageManager.na().cc(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gwl = false;
        } else {
            this.gwl = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.edit_head_activity);
        Intent intent = getIntent();
        this.fci = intent.getIntExtra("edit_type", 0);
        this.eZJ = intent.getIntExtra("request", 0);
        this.bie = intent.getBooleanExtra("need_upload", true);
        this.gvN = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.gvP = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.eZJ == 12002 || this.eZJ == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.eZJ, intent.getData(), aq.DR().DX());
            } else {
                TiebaPrepareImageService.StartService(this.eZJ, null, aq.DR().DX(), 0, stringExtra);
            }
            aOx();
        } else {
            initUI();
            initData();
        }
        gvO = getResources().getStringArray(e.b.fiter_name);
        if (this.gwl) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bpL();
    }

    private void bpL() {
        al.j(this.mNavigationBar, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.gvU);
        getLayoutMode().onModeChanged(this.gvV);
        al.c(this.mTitle, e.d.cp_cont_g, 1);
        al.a(this.mNavigationBar.getBackImageView(), e.f.icon_topbar_return_s, e.f.icon_topbar_return_s, 0);
        al.c(this.gws, e.d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.gwa != null) {
            this.gwa.cancel();
        }
        this.gvQ.setImageDrawable(null);
        bpM();
    }

    private void bpM() {
        if (this.gwq != null) {
            for (Map.Entry<String, ImageView> entry : this.gwq.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.gwq.clear();
            this.gwq = null;
        }
        if (this.gwp != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.gwp.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.gwp.clear();
            this.gwp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.gwa != null) {
            this.gwa.cancel();
        }
        this.gwa = new b();
        this.gwa.execute(new Object[0]);
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
        this.gvQ.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.gwg != null) {
            this.gwg.cancel();
        }
        if (this.gwh != null && !this.gwh.isRecycled()) {
            this.gwh.recycle();
            this.gwh = null;
        }
        if (this.gwa != null) {
            this.gwa.cancel();
            this.gwa = null;
        }
        this.gvZ.bA(false);
        if (this.eZJ == 12002 || this.eZJ == 12001) {
            unregisterReceiver(this.gwi);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpN() {
        if (this.gwg != null) {
            this.gwg.cancel();
        }
        this.gwg = new d();
        this.gwg.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.gvZ = new com.baidu.tbadk.core.view.d(getPageContext());
        this.gvZ.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.gvZ.bA(false);
            }
        });
        this.gvZ.bA(false);
        this.gvR = (EditHeadsImageTopLayerView) findViewById(e.g.image_top_layer);
        this.gvS = (ImageView) findViewById(e.g.preview_image);
        this.gvT = (FrameLayout) findViewById(e.g.preview_layout);
        int[] aS = l.aS(getPageContext().getPageActivity());
        this.gvT.setY((int) (aS[0] + ((aS[1] - aS[0]) * 0.4d) + getResources().getDimensionPixelSize(e.C0210e.ds74)));
        this.gvQ = (EditHeadsImageView) findViewById(e.g.image);
        this.gvQ.setCutImageHeightScale(this.gvN);
        if (this.mBitmap != null) {
            this.gvQ.setImageBitmap(this.mBitmap);
        }
        this.gvQ.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.gvT != null && EditHeadActivity.this.gvT.getVisibility() == 0) {
                    EditHeadActivity.this.gvS.setImageBitmap(EditHeadActivity.this.gvQ.mf(false));
                }
            }
        });
        this.gvQ.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.gvT != null && EditHeadActivity.this.gvT.getVisibility() == 0) {
                    EditHeadActivity.this.gvS.setImageBitmap(EditHeadActivity.this.gvQ.mf(false));
                }
            }
        });
        this.gvY = (HorizontalScrollView) findViewById(e.g.filters_layout);
        this.gvU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.gvX = (Button) findViewById(e.g.show_button);
        this.gvX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gwf.setVisibility(0);
                EditHeadActivity.this.gvX.setVisibility(8);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.gwl) {
                    EditHeadActivity.this.gwd.setPadding(0, EditHeadActivity.this.gwd.getPaddingTop(), EditHeadActivity.this.gwd.getPaddingRight(), EditHeadActivity.this.gwd.getPaddingBottom());
                    EditHeadActivity.this.gwd.setChecked(true);
                    EditHeadActivity.this.gvY.setVisibility(8);
                    EditHeadActivity.this.gwc.setVisibility(8);
                }
            }
        });
        this.gvW = (Button) findViewById(e.g.hide_button);
        this.gvW.setVisibility(0);
        this.gvW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gwf.setVisibility(8);
                EditHeadActivity.this.gvX.setVisibility(0);
            }
        });
        this.gvV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, (View.OnClickListener) null);
        this.gvV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.fci == 0) {
                    if (!EditHeadActivity.this.bie) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap mf = EditHeadActivity.this.gvQ.mf(EditHeadActivity.this.fci == 0 || EditHeadActivity.this.fci == 3);
                if (mf != null && EditHeadActivity.this.e(str, mf)) {
                    if (EditHeadActivity.this.fci == 0) {
                        if (EditHeadActivity.this.bie) {
                            EditHeadActivity.this.bpN();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.l.eT(str), "head");
                    aVar.NC();
                    aVar.a(new a.c() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9.1
                        @Override // com.baidu.tbadk.img.a.c
                        public void a(String str2, ImageUploadResult imageUploadResult) {
                            EditHeadActivity.this.closeLoadingDialog();
                            Intent intent2 = EditHeadActivity.this.getIntent();
                            if (imageUploadResult != null) {
                                if (imageUploadResult.error_code != 0) {
                                    EditHeadActivity.this.showToast(e.j.upload_pic_error, false);
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.gvP)) {
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
                    aVar.cA(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(e.j.uploading));
                }
            }
        });
        this.gvV.setEnabled(false);
        this.gws = (TextView) this.gvV.findViewById(e.g.save);
        this.gws.setText(e.j.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.gvP)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(e.j.beautify));
        }
        if ("from_photo_live".equals(this.gvP)) {
            this.mTitle.setText(e.j.choose_picture);
        }
        this.gwn = (LinearLayout) findViewById(e.g.filters);
        this.gwj = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.gwf = (LinearLayout) findViewById(e.g.beautify_rotate);
        this.gwe = (LinearLayout) findViewById(e.g.rotate);
        this.gwc = (RadioButton) findViewById(e.g.beautify_btn);
        this.gwd = (RadioButton) findViewById(e.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.gwc) {
                        EditHeadActivity.this.gvY.setVisibility(0);
                        EditHeadActivity.this.gwe.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.gwd) {
                        EditHeadActivity.this.gvY.setVisibility(8);
                        EditHeadActivity.this.gwe.setVisibility(0);
                    }
                }
            }
        };
        this.gwc.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gwd.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gwc.setChecked(true);
        Button button = (Button) findViewById(e.g.rotate_left);
        Button button2 = (Button) findViewById(e.g.rotate_right);
        Button button3 = (Button) findViewById(e.g.rotate_left_right);
        Button button4 = (Button) findViewById(e.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!EditHeadActivity.this.gvZ.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.gwh != null) && view.getTag() != null) {
                        EditHeadActivity.this.gwo = false;
                        EditHeadActivity.this.Y(view.getTag().toString(), false);
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.gvP)) {
            this.gvT.setVisibility(0);
            this.gvX.setVisibility(8);
            this.gvR.setLinePaintColor(getResources().getColor(e.d.white_alpha50));
            this.gvR.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(String str, boolean z) {
        if (this.gwb != null) {
            this.gwb.cancel();
        }
        this.gwb = new a(z);
        this.gwb.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap ax = com.baidu.tbadk.core.util.l.ax(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (ax.getWidth() > 1800 || ax.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ax, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            ax.recycle();
                            ax = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && ax != null && !ax.isRecycled()) {
                        ax.recycle();
                        return null;
                    }
                    int dip2px = l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.gwl) {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(ax, dip2px);
                        Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), ax != resizedBitmap);
                        EditHeadActivity.this.gwp = new HashMap();
                        EditHeadActivity.this.gwq = new HashMap();
                        EditHeadActivity.this.gwp.put("normal", roundedCornerBitmap);
                    }
                    return ax;
                } catch (Exception e2) {
                    bitmap = ax;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.gvZ.bA(true);
            EditHeadActivity.this.gvV.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.gwa = null;
            EditHeadActivity.this.gvZ.bA(false);
            EditHeadActivity.this.gvV.setClickable(true);
            EditHeadActivity.this.gvV.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.gwa = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.gvZ.bA(false);
            EditHeadActivity.this.gvV.setClickable(true);
            EditHeadActivity.this.gvV.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.gvQ.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.gvQ.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.gwl) {
                    EditHeadActivity.this.D(EditHeadActivity.gvO);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.l.a((String) null, str, bitmap, 80);
            if (this.gwo) {
                new ag("motu_pic", String.valueOf(this.gwk)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String[] strArr) {
        if (this.gwp != null && strArr != null) {
            this.gwn.removeAllViews();
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(e.g.filter_immage);
            TextView textView = (TextView) inflate.findViewById(e.g.filter_text);
            int length = strArr.length;
            int i = 0;
            final int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                final String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(e.g.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(e.g.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(FiltersView.hf(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gvZ.isShowing()) {
                                EditHeadActivity.this.gvQ.j(EditHeadActivity.this.mBitmap);
                                EditHeadActivity.this.gwo = false;
                                EditHeadActivity.this.tF(substring);
                                EditHeadActivity.this.gwk = i2;
                            }
                        }
                    });
                    this.gwr = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gvZ.isShowing() && !substring.equals(EditHeadActivity.this.gwm)) {
                                EditHeadActivity.this.Y(substring, true);
                                EditHeadActivity.this.tF(substring);
                                EditHeadActivity.this.gwk = i2;
                            }
                        }
                    });
                }
                this.gwn.addView(inflate2);
                if (this.gwq != null) {
                    this.gwq.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            tF("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tF(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.gwq == null) {
                this.gwq = new HashMap<>();
            }
            if (this.gwm != null && (imageView = this.gwq.get(this.gwm)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.gwj, this.gwj, this.gwj, this.gwj);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.gwq.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(e.f.round_corner);
                imageView2.setPadding(this.gwj, this.gwj, this.gwj, this.gwj);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.gwm = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean gwv;
        private String gww;
        private Boolean gwx = false;
        private Boolean gwy = false;

        public a(boolean z) {
            this.gwv = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.gwv || bpP()) {
                EditHeadActivity.this.gvZ.bA(true);
                EditHeadActivity.this.gvV.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.gww = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.gwh == null) {
                return null;
            }
            if (this.gww.equals("0") || this.gww.equals("1")) {
                this.gwx = true;
            } else if (this.gww.equals("2") || this.gww.equals("3")) {
                this.gwy = true;
            }
            if (this.gwx.booleanValue() || this.gwy.booleanValue()) {
                if (EditHeadActivity.this.gwh != null) {
                    this.bitmap = EditHeadActivity.this.gwh.copy(EditHeadActivity.this.gwh.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.gwx.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.gww));
            } else if (this.gwy.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.gww));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.gww, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean bpP() {
            PluginPackageManager.PluginStatus cc = PluginPackageManager.na().cc(PluginCenter.NAME_MOTUSDK);
            if (cc == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (cc == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), e.j.plugin_config_not_found);
                return false;
            } else if (cc == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.na().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (cc == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.d.a.a(EditHeadActivity.this.getPageContext(), e.j.plugin_muto_not_install, new a.b() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.a.1
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.gwh != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.gvZ.bA(false);
            EditHeadActivity.this.gvV.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.gvZ.bA(false);
            EditHeadActivity.this.gvV.setClickable(true);
            EditHeadActivity.this.gvV.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.gwo = true;
                if (this.gwx.booleanValue() || this.gwy.booleanValue()) {
                    EditHeadActivity.this.gvQ.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.gwx.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.gww));
                    } else if (this.gwy.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.gww));
                    }
                } else {
                    EditHeadActivity.this.gvQ.j(bitmap);
                }
                if (EditHeadActivity.this.gwh != null && !EditHeadActivity.this.gwh.isRecycled()) {
                    EditHeadActivity.this.gwh.recycle();
                }
                EditHeadActivity.this.gwh = bitmap;
            }
        }
    }

    private void aOx() {
        this.gwi = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.gwi, intentFilter);
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
            EditHeadActivity.this.showToast(intent.getStringExtra(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
            if (EditHeadActivity.this.gvV != null) {
                EditHeadActivity.this.gvV.setEnabled(false);
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
        private x mNetwork;

        private d() {
            this.mNetwork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(e.j.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.fz(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.Dj().Ei().isRequestSuccess()) {
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
            EditHeadActivity.this.gwg = null;
            if (this.mNetwork != null) {
                this.mNetwork.jg();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                if (this.mNetwork.Dj().Ei().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(e.j.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }
    }
}
