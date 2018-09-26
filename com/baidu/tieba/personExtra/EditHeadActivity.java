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
    private int eHb;
    private LinearLayout gdE;
    private HashMap<String, Bitmap> gdG;
    private HashMap<String, ImageView> gdH;
    private View gdI;
    private TextView gdJ;
    private String gdg;
    private ImageView gdj;
    private FrameLayout gdk;
    private View gdl;
    private View gdm;
    private RadioButton gdt;
    private RadioButton gdu;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String gdd = "change";
    public static String FILE_NAME = "file_name";
    private static String[] gdf = null;
    private float gde = 1.0f;
    private EditHeadsImageView gdh = null;
    private EditHeadsImageTopLayerView gdi = null;
    private Bitmap mBitmap = null;
    private int eJA = 0;
    private Button gdn = null;
    private Button gdo = null;
    private HorizontalScrollView gdp = null;
    private com.baidu.tbadk.core.view.d gdq = null;
    private b gdr = null;
    private a gds = null;
    private LinearLayout gdv = null;
    private LinearLayout gdw = null;
    private d gdx = null;
    private TextView mTitle = null;
    private Bitmap gdy = null;
    private c gdz = null;
    private int gdA = 0;
    private int gdB = 0;
    private boolean gdC = true;
    private String gdD = null;
    private boolean gdF = false;
    private boolean aZm = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.iB().aO("motu_sdk") == 1 || PluginPackageManager.mT().cd(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gdC = false;
        } else {
            this.gdC = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.edit_head_activity);
        Intent intent = getIntent();
        this.eJA = intent.getIntExtra("edit_type", 0);
        this.eHb = intent.getIntExtra("request", 0);
        this.aZm = intent.getBooleanExtra("need_upload", true);
        this.gde = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.gdg = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.eHb == 12002 || this.eHb == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.eHb, intent.getData(), aq.Az().AF());
            } else {
                TiebaPrepareImageService.StartService(this.eHb, null, aq.Az().AF(), 0, stringExtra);
            }
            aJd();
        } else {
            initUI();
            initData();
        }
        gdf = getResources().getStringArray(e.b.fiter_name);
        if (this.gdC) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bkB();
    }

    private void bkB() {
        al.j(this.mNavigationBar, e.d.common_color_10222);
        getLayoutMode().onModeChanged(this.gdl);
        getLayoutMode().onModeChanged(this.gdm);
        al.c(this.mTitle, e.d.cp_cont_g, 1);
        al.a(this.mNavigationBar.getBackImageView(), e.f.icon_topbar_return_s, e.f.icon_topbar_return_s, 0);
        al.c(this.gdJ, e.d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.gdr != null) {
            this.gdr.cancel();
        }
        this.gdh.setImageDrawable(null);
        bkC();
    }

    private void bkC() {
        if (this.gdH != null) {
            for (Map.Entry<String, ImageView> entry : this.gdH.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.gdH.clear();
            this.gdH = null;
        }
        if (this.gdG != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.gdG.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.gdG.clear();
            this.gdG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.gdr != null) {
            this.gdr.cancel();
        }
        this.gdr = new b();
        this.gdr.execute(new Object[0]);
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
        this.gdh.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.gdx != null) {
            this.gdx.cancel();
        }
        if (this.gdy != null && !this.gdy.isRecycled()) {
            this.gdy.recycle();
            this.gdy = null;
        }
        if (this.gdr != null) {
            this.gdr.cancel();
            this.gdr = null;
        }
        this.gdq.aZ(false);
        if (this.eHb == 12002 || this.eHb == 12001) {
            unregisterReceiver(this.gdz);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkD() {
        if (this.gdx != null) {
            this.gdx.cancel();
        }
        this.gdx = new d();
        this.gdx.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.gdq = new com.baidu.tbadk.core.view.d(getPageContext());
        this.gdq.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.gdq.aZ(false);
            }
        });
        this.gdq.aZ(false);
        this.gdi = (EditHeadsImageTopLayerView) findViewById(e.g.image_top_layer);
        this.gdj = (ImageView) findViewById(e.g.preview_image);
        this.gdk = (FrameLayout) findViewById(e.g.preview_layout);
        int[] aS = l.aS(getPageContext().getPageActivity());
        this.gdk.setY((int) (aS[0] + ((aS[1] - aS[0]) * 0.4d) + getResources().getDimensionPixelSize(e.C0141e.ds74)));
        this.gdh = (EditHeadsImageView) findViewById(e.g.image);
        this.gdh.setCutImageHeightScale(this.gde);
        if (this.mBitmap != null) {
            this.gdh.setImageBitmap(this.mBitmap);
        }
        this.gdh.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (EditHeadActivity.this.gdk != null && EditHeadActivity.this.gdk.getVisibility() == 0) {
                    EditHeadActivity.this.gdj.setImageBitmap(EditHeadActivity.this.gdh.lx(false));
                }
            }
        });
        this.gdh.setOnImageScrollListener(new DragImageView.f() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, int i, int i2) {
                if (EditHeadActivity.this.gdk != null && EditHeadActivity.this.gdk.getVisibility() == 0) {
                    EditHeadActivity.this.gdj.setImageBitmap(EditHeadActivity.this.gdh.lx(false));
                }
            }
        });
        this.gdp = (HorizontalScrollView) findViewById(e.g.filters_layout);
        this.gdl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.gdo = (Button) findViewById(e.g.show_button);
        this.gdo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gdw.setVisibility(0);
                EditHeadActivity.this.gdo.setVisibility(8);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.gdC) {
                    EditHeadActivity.this.gdu.setPadding(0, EditHeadActivity.this.gdu.getPaddingTop(), EditHeadActivity.this.gdu.getPaddingRight(), EditHeadActivity.this.gdu.getPaddingBottom());
                    EditHeadActivity.this.gdu.setChecked(true);
                    EditHeadActivity.this.gdp.setVisibility(8);
                    EditHeadActivity.this.gdt.setVisibility(8);
                }
            }
        });
        this.gdn = (Button) findViewById(e.g.hide_button);
        this.gdn.setVisibility(0);
        this.gdn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gdw.setVisibility(8);
                EditHeadActivity.this.gdo.setVisibility(0);
            }
        });
        this.gdm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.image_activity_save_button, (View.OnClickListener) null);
        this.gdm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.eJA == 0) {
                    if (!EditHeadActivity.this.aZm) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap lx = EditHeadActivity.this.gdh.lx(EditHeadActivity.this.eJA == 0 || EditHeadActivity.this.eJA == 3);
                if (lx != null && EditHeadActivity.this.c(str, lx)) {
                    if (EditHeadActivity.this.eJA == 0) {
                        if (EditHeadActivity.this.aZm) {
                            EditHeadActivity.this.bkD();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.l.el(str), "head");
                    aVar.Kn();
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.gdg)) {
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
                    aVar.bZ(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(e.j.uploading));
                }
            }
        });
        this.gdm.setEnabled(false);
        this.gdJ = (TextView) this.gdm.findViewById(e.g.save);
        this.gdJ.setText(e.j.done);
        if (!EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.gdg)) {
            this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(e.j.beautify));
        }
        if ("from_photo_live".equals(this.gdg)) {
            this.mTitle.setText(e.j.choose_picture);
        }
        this.gdE = (LinearLayout) findViewById(e.g.filters);
        this.gdA = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.gdw = (LinearLayout) findViewById(e.g.beautify_rotate);
        this.gdv = (LinearLayout) findViewById(e.g.rotate);
        this.gdt = (RadioButton) findViewById(e.g.beautify_btn);
        this.gdu = (RadioButton) findViewById(e.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.gdt) {
                        EditHeadActivity.this.gdp.setVisibility(0);
                        EditHeadActivity.this.gdv.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.gdu) {
                        EditHeadActivity.this.gdp.setVisibility(8);
                        EditHeadActivity.this.gdv.setVisibility(0);
                    }
                }
            }
        };
        this.gdt.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gdu.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gdt.setChecked(true);
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
                if (!EditHeadActivity.this.gdq.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.gdy != null) && view.getTag() != null) {
                        EditHeadActivity.this.gdF = false;
                        EditHeadActivity.this.P(view.getTag().toString(), false);
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        if (EditHeadActivityConfig.FROM_ALA_LIVE_COVER_CUT.equals(this.gdg)) {
            this.gdk.setVisibility(0);
            this.gdo.setVisibility(8);
            this.gdi.setLinePaintColor(getResources().getColor(e.d.white_alpha50));
            this.gdi.setLineWidth(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(String str, boolean z) {
        if (this.gds != null) {
            this.gds.cancel();
        }
        this.gds = new a(z);
        this.gds.execute(str);
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
                Bitmap ah = com.baidu.tbadk.core.util.l.ah(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (ah.getWidth() > 1800 || ah.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ah, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            ah.recycle();
                            ah = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && ah != null && !ah.isRecycled()) {
                        ah.recycle();
                        return null;
                    }
                    int dip2px = l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.gdC) {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(ah, dip2px);
                        Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), ah != resizedBitmap);
                        EditHeadActivity.this.gdG = new HashMap();
                        EditHeadActivity.this.gdH = new HashMap();
                        EditHeadActivity.this.gdG.put("normal", roundedCornerBitmap);
                    }
                    return ah;
                } catch (Exception e2) {
                    bitmap = ah;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.gdq.aZ(true);
            EditHeadActivity.this.gdm.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.gdr = null;
            EditHeadActivity.this.gdq.aZ(false);
            EditHeadActivity.this.gdm.setClickable(true);
            EditHeadActivity.this.gdm.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.gdr = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.gdq.aZ(false);
            EditHeadActivity.this.gdm.setClickable(true);
            EditHeadActivity.this.gdm.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.gdh.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.gdh.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.gdC) {
                    EditHeadActivity.this.A(EditHeadActivity.gdf);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.l.a((String) null, str, bitmap, 80);
            if (this.gdF) {
                new ag("motu_pic", String.valueOf(this.gdB)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String[] strArr) {
        if (this.gdG != null && strArr != null) {
            this.gdE.removeAllViews();
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
                imageView2.setImageResource(FiltersView.gx(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gdq.isShowing()) {
                                EditHeadActivity.this.gdh.j(EditHeadActivity.this.mBitmap);
                                EditHeadActivity.this.gdF = false;
                                EditHeadActivity.this.sx(substring);
                                EditHeadActivity.this.gdB = i2;
                            }
                        }
                    });
                    this.gdI = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gdq.isShowing() && !substring.equals(EditHeadActivity.this.gdD)) {
                                EditHeadActivity.this.P(substring, true);
                                EditHeadActivity.this.sx(substring);
                                EditHeadActivity.this.gdB = i2;
                            }
                        }
                    });
                }
                this.gdE.addView(inflate2);
                if (this.gdH != null) {
                    this.gdH.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            sx("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sx(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.gdH == null) {
                this.gdH = new HashMap<>();
            }
            if (this.gdD != null && (imageView = this.gdH.get(this.gdD)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.gdA, this.gdA, this.gdA, this.gdA);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.gdH.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(e.f.round_corner);
                imageView2.setPadding(this.gdA, this.gdA, this.gdA, this.gdA);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.gdD = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean gdM;
        private String gdN;
        private Boolean gdO = false;
        private Boolean gdP = false;

        public a(boolean z) {
            this.gdM = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.gdM || bkF()) {
                EditHeadActivity.this.gdq.aZ(true);
                EditHeadActivity.this.gdm.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.gdN = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.gdy == null) {
                return null;
            }
            if (this.gdN.equals("0") || this.gdN.equals("1")) {
                this.gdO = true;
            } else if (this.gdN.equals("2") || this.gdN.equals("3")) {
                this.gdP = true;
            }
            if (this.gdO.booleanValue() || this.gdP.booleanValue()) {
                if (EditHeadActivity.this.gdy != null) {
                    this.bitmap = EditHeadActivity.this.gdy.copy(EditHeadActivity.this.gdy.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.gdO.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.gdN));
            } else if (this.gdP.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.gdN));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.gdN, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean bkF() {
            PluginPackageManager.PluginStatus cd = PluginPackageManager.mT().cd(PluginCenter.NAME_MOTUSDK);
            if (cd == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (cd == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), e.j.plugin_config_not_found);
                return false;
            } else if (cd == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.mT().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (cd == PluginPackageManager.PluginStatus.FORBIDDEN) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.gdy != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.gdq.aZ(false);
            EditHeadActivity.this.gdm.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.gdq.aZ(false);
            EditHeadActivity.this.gdm.setClickable(true);
            EditHeadActivity.this.gdm.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.gdF = true;
                if (this.gdO.booleanValue() || this.gdP.booleanValue()) {
                    EditHeadActivity.this.gdh.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.gdO.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.gdN));
                    } else if (this.gdP.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.gdN));
                    }
                } else {
                    EditHeadActivity.this.gdh.j(bitmap);
                }
                if (EditHeadActivity.this.gdy != null && !EditHeadActivity.this.gdy.isRecycled()) {
                    EditHeadActivity.this.gdy.recycle();
                }
                EditHeadActivity.this.gdy = bitmap;
            }
        }
    }

    private void aJd() {
        this.gdz = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.gdz, intentFilter);
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
            if (EditHeadActivity.this.gdm != null) {
                EditHeadActivity.this.gdm.setEnabled(false);
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
                str = this.mNetwork.eT(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.zR().AQ().isRequestSuccess()) {
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
            EditHeadActivity.this.gdx = null;
            if (this.mNetwork != null) {
                this.mNetwork.iT();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                if (this.mNetwork.zR().AQ().isRequestSuccess()) {
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
