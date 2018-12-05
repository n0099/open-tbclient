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
    private int eWS;
    private String gsY;
    private View gtA;
    private TextView gtB;
    private ImageView gtb;
    private FrameLayout gtc;
    private View gtd;
    private View gte;
    private RadioButton gtl;
    private RadioButton gtm;
    private LinearLayout gtw;
    private HashMap<String, Bitmap> gty;
    private HashMap<String, ImageView> gtz;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String gsV = "change";
    public static String FILE_NAME = "file_name";
    private static String[] gsX = null;
    private float gsW = 1.0f;
    private EditHeadsImageView gsZ = null;
    private EditHeadsImageTopLayerView gta = null;
    private Bitmap mBitmap = null;
    private int eZr = 0;
    private Button gtf = null;
    private Button gtg = null;
    private HorizontalScrollView gth = null;
    private com.baidu.tbadk.core.view.d gti = null;
    private b gtj = null;
    private a gtk = null;
    private LinearLayout gtn = null;
    private LinearLayout gto = null;
    private d gtp = null;
    private TextView mTitle = null;
    private Bitmap gtq = null;
    private c gtr = null;
    private int gts = 0;
    private int gtt = 0;
    private boolean gtu = true;
    private String gtv = null;
    private boolean gtx = false;
    private boolean bia = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.iQ().aO("motu_sdk") == 1 || PluginPackageManager.na().cc(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gtu = false;
        } else {
            this.gtu = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.edit_head_activity);
        Intent intent = getIntent();
        this.eZr = intent.getIntExtra("edit_type", 0);
        this.eWS = intent.getIntExtra("request", 0);
        this.bia = intent.getBooleanExtra("need_upload", true);
        this.gsW = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.gsY = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.eWS == 12002 || this.eWS == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.eWS, intent.getData(), aq.DR().DX());
            } else {
                TiebaPrepareImageService.StartService(this.eWS, null, aq.DR().DX(), 0, stringExtra);
            }
            aNK();
        } else {
            initUI();
            initData();
        }
        gsX = getResources().getStringArray(e.b.fiter_name);
        if (this.gtu) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bpa();
    }

    private void bpa() {
        al.j(this.mNavigationBar, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.gtd);
        getLayoutMode().onModeChanged(this.gte);
        al.c(this.mTitle, e.d.cp_cont_g, 1);
        al.a(this.mNavigationBar.getBackImageView(), e.f.icon_topbar_return_s, e.f.icon_topbar_return_s, 0);
        al.c(this.gtB, e.d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.gtj != null) {
            this.gtj.cancel();
        }
        this.gsZ.setImageDrawable(null);
        bpb();
    }

    private void bpb() {
        if (this.gtz != null) {
            for (Map.Entry<String, ImageView> entry : this.gtz.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.gtz.clear();
            this.gtz = null;
        }
        if (this.gty != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.gty.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.gty.clear();
            this.gty = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.gtj != null) {
            this.gtj.cancel();
        }
        this.gtj = new b();
        this.gtj.execute(new Object[0]);
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
        this.gsZ.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.gtp != null) {
            this.gtp.cancel();
        }
        if (this.gtq != null && !this.gtq.isRecycled()) {
            this.gtq.recycle();
            this.gtq = null;
        }
        if (this.gtj != null) {
            this.gtj.cancel();
            this.gtj = null;
        }
        this.gti.bA(false);
        if (this.eWS == 12002 || this.eWS == 12001) {
            unregisterReceiver(this.gtr);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpc() {
        if (this.gtp != null) {
            this.gtp.cancel();
        }
        this.gtp = new d();
        this.gtp.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.gti = new com.baidu.tbadk.core.view.d(getPageContext());
        this.gti.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.gti.bA(false);
            }
        });
        this.gti.bA(false);
        this.gta = (EditHeadsImageTopLayerView) findViewById(e.g.image_top_layer);
        this.gtb = (ImageView) findViewById(e.g.preview_image);
        this.gtc = (FrameLayout) findViewById(e.g.preview_layout);
        int[] aS = l.aS(getPageContext().getPageActivity());
        this.gtc.setY((int) (aS[0] + ((aS[1] - aS[0]) * 0.4d) + getResources().getDimensionPixelSize(e.C0210e.ds74)));
        this.gsZ = (EditHeadsImageView) findViewById(e.g.image);
        this.gsZ.setCutImageHeightScale(this.gsW);
        if (this.mBitmap != null) {
            this.gsZ.setImageBitmap(this.mBitmap);
        }
        this.gsZ.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.gtc != null && EditHeadActivity.this.gtc.getVisibility() == 0) {
                    EditHeadActivity.this.gtb.setImageBitmap(EditHeadActivity.this.gsZ.mc(false));
                }
            }
        });
        this.gsZ.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.gtc != null && EditHeadActivity.this.gtc.getVisibility() == 0) {
                    EditHeadActivity.this.gtb.setImageBitmap(EditHeadActivity.this.gsZ.mc(false));
                }
            }
        });
        this.gth = (HorizontalScrollView) findViewById(e.g.filters_layout);
        this.gtd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.gtg = (Button) findViewById(e.g.show_button);
        this.gtg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gto.setVisibility(0);
                EditHeadActivity.this.gtg.setVisibility(8);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.gtu) {
                    EditHeadActivity.this.gtm.setPadding(0, EditHeadActivity.this.gtm.getPaddingTop(), EditHeadActivity.this.gtm.getPaddingRight(), EditHeadActivity.this.gtm.getPaddingBottom());
                    EditHeadActivity.this.gtm.setChecked(true);
                    EditHeadActivity.this.gth.setVisibility(8);
                    EditHeadActivity.this.gtl.setVisibility(8);
                }
            }
        });
        this.gtf = (Button) findViewById(e.g.hide_button);
        this.gtf.setVisibility(0);
        this.gtf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gto.setVisibility(8);
                EditHeadActivity.this.gtg.setVisibility(0);
            }
        });
        this.gte = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, (View.OnClickListener) null);
        this.gte.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.eZr == 0) {
                    if (!EditHeadActivity.this.bia) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap mc = EditHeadActivity.this.gsZ.mc(EditHeadActivity.this.eZr == 0 || EditHeadActivity.this.eZr == 3);
                if (mc != null && EditHeadActivity.this.e(str, mc)) {
                    if (EditHeadActivity.this.eZr == 0) {
                        if (EditHeadActivity.this.bia) {
                            EditHeadActivity.this.bpc();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.l.eT(str), "head");
                    aVar.NB();
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.gsY)) {
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
        this.gte.setEnabled(false);
        this.gtB = (TextView) this.gte.findViewById(e.g.save);
        this.gtB.setText(e.j.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.gsY)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(e.j.beautify));
        }
        if ("from_photo_live".equals(this.gsY)) {
            this.mTitle.setText(e.j.choose_picture);
        }
        this.gtw = (LinearLayout) findViewById(e.g.filters);
        this.gts = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.gto = (LinearLayout) findViewById(e.g.beautify_rotate);
        this.gtn = (LinearLayout) findViewById(e.g.rotate);
        this.gtl = (RadioButton) findViewById(e.g.beautify_btn);
        this.gtm = (RadioButton) findViewById(e.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.gtl) {
                        EditHeadActivity.this.gth.setVisibility(0);
                        EditHeadActivity.this.gtn.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.gtm) {
                        EditHeadActivity.this.gth.setVisibility(8);
                        EditHeadActivity.this.gtn.setVisibility(0);
                    }
                }
            }
        };
        this.gtl.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gtm.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gtl.setChecked(true);
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
                if (!EditHeadActivity.this.gti.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.gtq != null) && view.getTag() != null) {
                        EditHeadActivity.this.gtx = false;
                        EditHeadActivity.this.Y(view.getTag().toString(), false);
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.gsY)) {
            this.gtc.setVisibility(0);
            this.gtg.setVisibility(8);
            this.gta.setLinePaintColor(getResources().getColor(e.d.white_alpha50));
            this.gta.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(String str, boolean z) {
        if (this.gtk != null) {
            this.gtk.cancel();
        }
        this.gtk = new a(z);
        this.gtk.execute(str);
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
                    if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.gtu) {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(ax, dip2px);
                        Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), ax != resizedBitmap);
                        EditHeadActivity.this.gty = new HashMap();
                        EditHeadActivity.this.gtz = new HashMap();
                        EditHeadActivity.this.gty.put("normal", roundedCornerBitmap);
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
            EditHeadActivity.this.gti.bA(true);
            EditHeadActivity.this.gte.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.gtj = null;
            EditHeadActivity.this.gti.bA(false);
            EditHeadActivity.this.gte.setClickable(true);
            EditHeadActivity.this.gte.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.gtj = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.gti.bA(false);
            EditHeadActivity.this.gte.setClickable(true);
            EditHeadActivity.this.gte.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.gsZ.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.gsZ.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.gtu) {
                    EditHeadActivity.this.D(EditHeadActivity.gsX);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.l.a((String) null, str, bitmap, 80);
            if (this.gtx) {
                new ag("motu_pic", String.valueOf(this.gtt)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String[] strArr) {
        if (this.gty != null && strArr != null) {
            this.gtw.removeAllViews();
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
                imageView2.setImageResource(FiltersView.he(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gti.isShowing()) {
                                EditHeadActivity.this.gsZ.j(EditHeadActivity.this.mBitmap);
                                EditHeadActivity.this.gtx = false;
                                EditHeadActivity.this.tC(substring);
                                EditHeadActivity.this.gtt = i2;
                            }
                        }
                    });
                    this.gtA = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gti.isShowing() && !substring.equals(EditHeadActivity.this.gtv)) {
                                EditHeadActivity.this.Y(substring, true);
                                EditHeadActivity.this.tC(substring);
                                EditHeadActivity.this.gtt = i2;
                            }
                        }
                    });
                }
                this.gtw.addView(inflate2);
                if (this.gtz != null) {
                    this.gtz.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            tC("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tC(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.gtz == null) {
                this.gtz = new HashMap<>();
            }
            if (this.gtv != null && (imageView = this.gtz.get(this.gtv)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.gts, this.gts, this.gts, this.gts);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.gtz.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(e.f.round_corner);
                imageView2.setPadding(this.gts, this.gts, this.gts, this.gts);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.gtv = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean gtE;
        private String gtF;
        private Boolean gtG = false;
        private Boolean gtH = false;

        public a(boolean z) {
            this.gtE = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.gtE || bpe()) {
                EditHeadActivity.this.gti.bA(true);
                EditHeadActivity.this.gte.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.gtF = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.gtq == null) {
                return null;
            }
            if (this.gtF.equals("0") || this.gtF.equals("1")) {
                this.gtG = true;
            } else if (this.gtF.equals("2") || this.gtF.equals("3")) {
                this.gtH = true;
            }
            if (this.gtG.booleanValue() || this.gtH.booleanValue()) {
                if (EditHeadActivity.this.gtq != null) {
                    this.bitmap = EditHeadActivity.this.gtq.copy(EditHeadActivity.this.gtq.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.gtG.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.gtF));
            } else if (this.gtH.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.gtF));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.gtF, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean bpe() {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.gtq != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.gti.bA(false);
            EditHeadActivity.this.gte.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.gti.bA(false);
            EditHeadActivity.this.gte.setClickable(true);
            EditHeadActivity.this.gte.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.gtx = true;
                if (this.gtG.booleanValue() || this.gtH.booleanValue()) {
                    EditHeadActivity.this.gsZ.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.gtG.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.gtF));
                    } else if (this.gtH.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.gtF));
                    }
                } else {
                    EditHeadActivity.this.gsZ.j(bitmap);
                }
                if (EditHeadActivity.this.gtq != null && !EditHeadActivity.this.gtq.isRecycled()) {
                    EditHeadActivity.this.gtq.recycle();
                }
                EditHeadActivity.this.gtq = bitmap;
            }
        }
    }

    private void aNK() {
        this.gtr = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.gtr, intentFilter);
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
            if (EditHeadActivity.this.gte != null) {
                EditHeadActivity.this.gte.setEnabled(false);
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
            EditHeadActivity.this.gtp = null;
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
