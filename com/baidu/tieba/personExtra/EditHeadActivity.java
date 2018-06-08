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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.view.FiltersView;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private int ese;
    private String fRC;
    private View fRE;
    private View fRF;
    private RadioButton fRM;
    private RadioButton fRN;
    private LinearLayout fRX;
    private HashMap<String, Bitmap> fRZ;
    private HashMap<String, ImageView> fSa;
    private View fSb;
    private TextView fSc;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String fRz = "change";
    public static String FILE_NAME = "file_name";
    private static String[] fRB = null;
    private float fRA = 1.0f;
    private EditHeadsImageView fRD = null;
    private Bitmap mBitmap = null;
    private int euF = 0;
    private Button fRG = null;
    private Button fRH = null;
    private HorizontalScrollView fRI = null;
    private com.baidu.tbadk.core.view.a fRJ = null;
    private b fRK = null;
    private a fRL = null;
    private LinearLayout fRO = null;
    private LinearLayout fRP = null;
    private d fRQ = null;
    private TextView mTitle = null;
    private Bitmap fRR = null;
    private c fRS = null;
    private int fRT = 0;
    private int fRU = 0;
    private boolean fRV = true;
    private String fRW = null;
    private boolean fRY = false;
    private boolean aVa = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.hv().aw("motu_sdk") == 1 || PluginPackageManager.lL().bJ(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fRV = false;
        } else {
            this.fRV = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.edit_head_activity);
        Intent intent = getIntent();
        this.euF = intent.getIntExtra("edit_type", 0);
        this.ese = intent.getIntExtra("request", 0);
        this.aVa = intent.getBooleanExtra("need_upload", true);
        this.fRA = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.fRC = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.ese == 12002 || this.ese == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.ese, intent.getData(), aq.zq().zw());
            } else {
                TiebaPrepareImageService.StartService(this.ese, null, aq.zq().zw(), 0, stringExtra);
            }
            aFj();
        } else {
            initUI();
            initData();
        }
        fRB = getResources().getStringArray(d.b.fiter_name);
        if (this.fRV) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bje();
    }

    private void bje() {
        al.j(this.mNavigationBar, d.C0141d.common_color_10222);
        getLayoutMode().onModeChanged(this.fRE);
        getLayoutMode().onModeChanged(this.fRF);
        al.c(this.mTitle, d.C0141d.cp_cont_g, 1);
        al.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_s, 0);
        al.c(this.fSc, d.C0141d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.fRK != null) {
            this.fRK.cancel();
        }
        this.fRD.setImageDrawable(null);
        bjf();
    }

    private void bjf() {
        if (this.fSa != null) {
            for (Map.Entry<String, ImageView> entry : this.fSa.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.fSa.clear();
            this.fSa = null;
        }
        if (this.fRZ != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.fRZ.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.fRZ.clear();
            this.fRZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.fRK != null) {
            this.fRK.cancel();
        }
        this.fRK = new b();
        this.fRK.execute(new Object[0]);
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
        this.fRD.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.fRQ != null) {
            this.fRQ.cancel();
        }
        if (this.fRR != null && !this.fRR.isRecycled()) {
            this.fRR.recycle();
            this.fRR = null;
        }
        if (this.fRK != null) {
            this.fRK.cancel();
            this.fRK = null;
        }
        this.fRJ.aM(false);
        if (this.ese == 12002 || this.ese == 12001) {
            unregisterReceiver(this.fRS);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjg() {
        if (this.fRQ != null) {
            this.fRQ.cancel();
        }
        this.fRQ = new d();
        this.fRQ.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.fRJ = new com.baidu.tbadk.core.view.a(getPageContext());
        this.fRJ.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.fRJ.aM(false);
            }
        });
        this.fRJ.aM(false);
        this.fRD = (EditHeadsImageView) findViewById(d.g.image);
        this.fRD.setCutImageHeightScale(this.fRA);
        if (this.mBitmap != null) {
            this.fRD.setImageBitmap(this.mBitmap);
        }
        this.fRI = (HorizontalScrollView) findViewById(d.g.filters_layout);
        this.fRE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.fRH = (Button) findViewById(d.g.show_button);
        this.fRH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.fRP.setVisibility(0);
                EditHeadActivity.this.fRH.setVisibility(8);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.fRV) {
                    EditHeadActivity.this.fRN.setPadding(0, EditHeadActivity.this.fRN.getPaddingTop(), EditHeadActivity.this.fRN.getPaddingRight(), EditHeadActivity.this.fRN.getPaddingBottom());
                    EditHeadActivity.this.fRN.setChecked(true);
                    EditHeadActivity.this.fRI.setVisibility(8);
                    EditHeadActivity.this.fRM.setVisibility(8);
                }
            }
        });
        this.fRG = (Button) findViewById(d.g.hide_button);
        this.fRG.setVisibility(0);
        this.fRG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.fRP.setVisibility(8);
                EditHeadActivity.this.fRH.setVisibility(0);
            }
        });
        this.fRF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, (View.OnClickListener) null);
        this.fRF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.euF == 0) {
                    if (!EditHeadActivity.this.aVa) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap lf = EditHeadActivity.this.fRD.lf(EditHeadActivity.this.euF == 0 || EditHeadActivity.this.euF == 3);
                if (lf != null && EditHeadActivity.this.c(str, lf)) {
                    if (EditHeadActivity.this.euF == 0) {
                        if (EditHeadActivity.this.aVa) {
                            EditHeadActivity.this.bjg();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(l.dT(str), "head");
                    aVar.IK();
                    aVar.a(new a.c() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5.1
                        @Override // com.baidu.tbadk.img.a.c
                        public void a(String str2, ImageUploadResult imageUploadResult) {
                            EditHeadActivity.this.closeLoadingDialog();
                            Intent intent2 = EditHeadActivity.this.getIntent();
                            if (imageUploadResult != null) {
                                if (imageUploadResult.error_code != 0) {
                                    EditHeadActivity.this.showToast(d.k.upload_pic_error, false);
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.fRC)) {
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
                    aVar.bL(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(d.k.uploading));
                }
            }
        });
        this.fRF.setEnabled(false);
        this.fSc = (TextView) this.fRF.findViewById(d.g.save);
        this.fSc.setText(d.k.done);
        this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(d.k.beautify));
        if ("from_photo_live".equals(this.fRC)) {
            this.mTitle.setText(d.k.choose_picture);
        }
        this.fRX = (LinearLayout) findViewById(d.g.filters);
        this.fRT = com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.fRP = (LinearLayout) findViewById(d.g.beautify_rotate);
        this.fRO = (LinearLayout) findViewById(d.g.rotate);
        this.fRM = (RadioButton) findViewById(d.g.beautify_btn);
        this.fRN = (RadioButton) findViewById(d.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.fRM) {
                        EditHeadActivity.this.fRI.setVisibility(0);
                        EditHeadActivity.this.fRO.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.fRN) {
                        EditHeadActivity.this.fRI.setVisibility(8);
                        EditHeadActivity.this.fRO.setVisibility(0);
                    }
                }
            }
        };
        this.fRM.setOnCheckedChangeListener(onCheckedChangeListener);
        this.fRN.setOnCheckedChangeListener(onCheckedChangeListener);
        this.fRM.setChecked(true);
        Button button = (Button) findViewById(d.g.rotate_left);
        Button button2 = (Button) findViewById(d.g.rotate_right);
        Button button3 = (Button) findViewById(d.g.rotate_left_right);
        Button button4 = (Button) findViewById(d.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!EditHeadActivity.this.fRJ.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.fRR != null) && view.getTag() != null) {
                        EditHeadActivity.this.fRY = false;
                        EditHeadActivity.this.O(view.getTag().toString(), false);
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(String str, boolean z) {
        if (this.fRL != null) {
            this.fRL.cancel();
        }
        this.fRL = new a(z);
        this.fRL.execute(str);
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
                Bitmap ab = l.ab(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (ab.getWidth() > 1800 || ab.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(ab, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            ab.recycle();
                            ab = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && ab != null && !ab.isRecycled()) {
                        ab.recycle();
                        return null;
                    }
                    int dip2px = com.baidu.adp.lib.util.l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.fRV) {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(ab, dip2px);
                        Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), ab != resizedBitmap);
                        EditHeadActivity.this.fRZ = new HashMap();
                        EditHeadActivity.this.fSa = new HashMap();
                        EditHeadActivity.this.fRZ.put("normal", roundedCornerBitmap);
                    }
                    return ab;
                } catch (Exception e2) {
                    bitmap = ab;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.fRJ.aM(true);
            EditHeadActivity.this.fRF.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.fRK = null;
            EditHeadActivity.this.fRJ.aM(false);
            EditHeadActivity.this.fRF.setClickable(true);
            EditHeadActivity.this.fRF.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.fRK = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.fRJ.aM(false);
            EditHeadActivity.this.fRF.setClickable(true);
            EditHeadActivity.this.fRF.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.fRD.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.fRD.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.fRV) {
                    EditHeadActivity.this.z(EditHeadActivity.fRB);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            l.a((String) null, str, bitmap, 80);
            if (this.fRY) {
                new ah("motu_pic", String.valueOf(this.fRU)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String[] strArr) {
        if (this.fRZ != null && strArr != null) {
            this.fRX.removeAllViews();
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(d.g.filter_immage);
            TextView textView = (TextView) inflate.findViewById(d.g.filter_text);
            int length = strArr.length;
            int i = 0;
            final int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                final String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(d.g.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(d.g.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(FiltersView.fY(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.fRJ.isShowing()) {
                                EditHeadActivity.this.fRD.i(EditHeadActivity.this.mBitmap);
                                EditHeadActivity.this.fRY = false;
                                EditHeadActivity.this.rU(substring);
                                EditHeadActivity.this.fRU = i2;
                            }
                        }
                    });
                    this.fSb = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.fRJ.isShowing() && !substring.equals(EditHeadActivity.this.fRW)) {
                                EditHeadActivity.this.O(substring, true);
                                EditHeadActivity.this.rU(substring);
                                EditHeadActivity.this.fRU = i2;
                            }
                        }
                    });
                }
                this.fRX.addView(inflate2);
                if (this.fSa != null) {
                    this.fSa.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            rU("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rU(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.fSa == null) {
                this.fSa = new HashMap<>();
            }
            if (this.fRW != null && (imageView = this.fSa.get(this.fRW)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.fRT, this.fRT, this.fRT, this.fRT);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.fSa.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(d.f.round_corner);
                imageView2.setPadding(this.fRT, this.fRT, this.fRT, this.fRT);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.fRW = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean fSf;
        private Boolean fSg = false;
        private Boolean fSh = false;
        private String mLabel;

        public a(boolean z) {
            this.fSf = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.fSf || bji()) {
                EditHeadActivity.this.fRJ.aM(true);
                EditHeadActivity.this.fRF.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.fRR == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.fSg = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals("3")) {
                this.fSh = true;
            }
            if (this.fSg.booleanValue() || this.fSh.booleanValue()) {
                if (EditHeadActivity.this.fRR != null) {
                    this.bitmap = EditHeadActivity.this.fRR.copy(EditHeadActivity.this.fRR.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.fSg.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.fSh.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean bji() {
            PluginPackageManager.PluginStatus bJ = PluginPackageManager.lL().bJ(PluginCenter.NAME_MOTUSDK);
            if (bJ == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (bJ == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), d.k.plugin_config_not_found);
                return false;
            } else if (bJ == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lL().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (bJ == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.d.a.a(EditHeadActivity.this.getPageContext(), d.k.plugin_muto_not_install, new a.b() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.a.1
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.fRR != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.fRJ.aM(false);
            EditHeadActivity.this.fRF.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.fRJ.aM(false);
            EditHeadActivity.this.fRF.setClickable(true);
            EditHeadActivity.this.fRF.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.fRY = true;
                if (this.fSg.booleanValue() || this.fSh.booleanValue()) {
                    EditHeadActivity.this.fRD.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.fSg.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.fSh.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.fRD.i(bitmap);
                }
                if (EditHeadActivity.this.fRR != null && !EditHeadActivity.this.fRR.isRecycled()) {
                    EditHeadActivity.this.fRR.recycle();
                }
                EditHeadActivity.this.fRR = bitmap;
            }
        }
    }

    private void aFj() {
        this.fRS = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.fRS, intentFilter);
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
            if (EditHeadActivity.this.fRF != null) {
                EditHeadActivity.this.fRF.setEnabled(false);
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
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(d.k.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.mNetwork = new y(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.eA(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
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
            EditHeadActivity.this.fRQ = null;
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
                if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(d.k.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }
    }
}
