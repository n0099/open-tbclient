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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private String gkE;
    private View gkG;
    private View gkH;
    private RadioButton gkO;
    private RadioButton gkP;
    private LinearLayout gkZ;
    private HashMap<String, Bitmap> glb;
    private HashMap<String, ImageView> glc;
    private View gld;
    private TextView gle;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String gkB = "change";
    public static String FILE_NAME = "file_name";
    private static String[] gkD = null;
    private float gkC = 1.0f;
    private EditHeadsImageView gkF = null;
    private Bitmap mBitmap = null;
    private int eNA = 0;
    private Button gkI = null;
    private Button gkJ = null;
    private HorizontalScrollView gkK = null;
    private com.baidu.tbadk.core.view.b gkL = null;
    private b gkM = null;
    private a gkN = null;
    private LinearLayout gkQ = null;
    private LinearLayout gkR = null;
    private d gkS = null;
    private TextView mTitle = null;
    private Bitmap gkT = null;
    private c gkU = null;
    private int gkV = 0;
    private int gkW = 0;
    private boolean gkX = true;
    private String gkY = null;
    private boolean gla = false;
    private boolean bCL = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.mA().an("motu_sdk") == 1 || PluginPackageManager.qS().bA(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gkX = false;
        } else {
            this.gkX = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.edit_head_activity);
        Intent intent = getIntent();
        this.eNA = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        this.bCL = intent.getBooleanExtra("need_upload", true);
        this.gkC = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.gkE = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), ao.De().Dk());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, ao.De().Dk(), 0, stringExtra);
            }
            aFq();
        } else {
            initUI();
            initData();
        }
        gkD = getResources().getStringArray(d.b.fiter_name);
        if (this.gkX) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bjd();
    }

    private void bjd() {
        aj.t(this.mNavigationBar, d.C0140d.common_color_10222);
        getLayoutMode().aM(this.gkG);
        getLayoutMode().aM(this.gkH);
        aj.e(this.mTitle, d.C0140d.cp_cont_g, 1);
        aj.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_s, 0);
        aj.e(this.gle, d.C0140d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.gkM != null) {
            this.gkM.cancel();
        }
        this.gkF.setImageDrawable(null);
        bje();
    }

    private void bje() {
        if (this.glc != null) {
            for (Map.Entry<String, ImageView> entry : this.glc.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.glc.clear();
            this.glc = null;
        }
        if (this.glb != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.glb.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.glb.clear();
            this.glb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.gkM != null) {
            this.gkM.cancel();
        }
        this.gkM = new b();
        this.gkM.execute(new Object[0]);
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
        this.gkF.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.gkS != null) {
            this.gkS.cancel();
        }
        if (this.gkT != null && !this.gkT.isRecycled()) {
            this.gkT.recycle();
            this.gkT = null;
        }
        if (this.gkM != null) {
            this.gkM.cancel();
            this.gkM = null;
        }
        this.gkL.bq(false);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.gkU);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjf() {
        if (this.gkS != null) {
            this.gkS.cancel();
        }
        this.gkS = new d();
        this.gkS.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.gkL = new com.baidu.tbadk.core.view.b(getPageContext());
        this.gkL.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.gkL.bq(false);
            }
        });
        this.gkL.bq(false);
        this.gkF = (EditHeadsImageView) findViewById(d.g.image);
        this.gkF.setCutImageHeightScale(this.gkC);
        if (this.mBitmap != null) {
            this.gkF.setImageBitmap(this.mBitmap);
        }
        this.gkK = (HorizontalScrollView) findViewById(d.g.filters_layout);
        this.gkG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.gkJ = (Button) findViewById(d.g.show_button);
        this.gkJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gkR.setVisibility(0);
                EditHeadActivity.this.gkJ.setVisibility(8);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.gkX) {
                    EditHeadActivity.this.gkP.setPadding(0, EditHeadActivity.this.gkP.getPaddingTop(), EditHeadActivity.this.gkP.getPaddingRight(), EditHeadActivity.this.gkP.getPaddingBottom());
                    EditHeadActivity.this.gkP.setChecked(true);
                    EditHeadActivity.this.gkK.setVisibility(8);
                    EditHeadActivity.this.gkO.setVisibility(8);
                }
            }
        });
        this.gkI = (Button) findViewById(d.g.hide_button);
        this.gkI.setVisibility(0);
        this.gkI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gkR.setVisibility(8);
                EditHeadActivity.this.gkJ.setVisibility(0);
            }
        });
        this.gkH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, (View.OnClickListener) null);
        this.gkH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.eNA == 0) {
                    if (!EditHeadActivity.this.bCL) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap lu = EditHeadActivity.this.gkF.lu(EditHeadActivity.this.eNA == 0 || EditHeadActivity.this.eNA == 3);
                if (lu != null && EditHeadActivity.this.b(str, lu)) {
                    if (EditHeadActivity.this.eNA == 0) {
                        if (EditHeadActivity.this.bCL) {
                            EditHeadActivity.this.bjf();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.k.dB(str), "head");
                    aVar.ME();
                    aVar.a(new a.c() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5.1
                        @Override // com.baidu.tbadk.img.a.c
                        public void a(String str2, ImageUploadResult imageUploadResult) {
                            EditHeadActivity.this.closeLoadingDialog();
                            Intent intent2 = EditHeadActivity.this.getIntent();
                            if (imageUploadResult != null) {
                                if (imageUploadResult.error_code != 0) {
                                    EditHeadActivity.this.showToast(d.j.upload_pic_error, false);
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.gkE)) {
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
                    aVar.cp(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(d.j.uploading));
                }
            }
        });
        this.gkH.setEnabled(false);
        this.gle = (TextView) this.gkH.findViewById(d.g.save);
        this.gle.setText(d.j.done);
        this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(d.j.beautify));
        if ("from_photo_live".equals(this.gkE)) {
            this.mTitle.setText(d.j.choose_picture);
        }
        this.gkZ = (LinearLayout) findViewById(d.g.filters);
        this.gkV = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.gkR = (LinearLayout) findViewById(d.g.beautify_rotate);
        this.gkQ = (LinearLayout) findViewById(d.g.rotate);
        this.gkO = (RadioButton) findViewById(d.g.beautify_btn);
        this.gkP = (RadioButton) findViewById(d.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.gkO) {
                        EditHeadActivity.this.gkK.setVisibility(0);
                        EditHeadActivity.this.gkQ.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.gkP) {
                        EditHeadActivity.this.gkK.setVisibility(8);
                        EditHeadActivity.this.gkQ.setVisibility(0);
                    }
                }
            }
        };
        this.gkO.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gkP.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gkO.setChecked(true);
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
                if (!EditHeadActivity.this.gkL.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.gkT != null) && view.getTag() != null) {
                        EditHeadActivity.this.gla = false;
                        EditHeadActivity.this.T(view.getTag().toString(), false);
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
    public void T(String str, boolean z) {
        if (this.gkN != null) {
            this.gkN.cancel();
        }
        this.gkN = new a(z);
        this.gkN.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap X = com.baidu.tbadk.core.util.k.X(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (X.getWidth() > 1800 || X.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(X, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            X.recycle();
                            X = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && X != null && !X.isRecycled()) {
                        X.recycle();
                        return null;
                    }
                    int dip2px = l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.gkX) {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(X, dip2px);
                        Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), X != resizedBitmap);
                        EditHeadActivity.this.glb = new HashMap();
                        EditHeadActivity.this.glc = new HashMap();
                        EditHeadActivity.this.glb.put("normal", roundedCornerBitmap);
                    }
                    return X;
                } catch (Exception e2) {
                    bitmap = X;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.gkL.bq(true);
            EditHeadActivity.this.gkH.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.gkM = null;
            EditHeadActivity.this.gkL.bq(false);
            EditHeadActivity.this.gkH.setClickable(true);
            EditHeadActivity.this.gkH.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.gkM = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.gkL.bq(false);
            EditHeadActivity.this.gkH.setClickable(true);
            EditHeadActivity.this.gkH.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.gkF.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.gkF.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.gkX) {
                    EditHeadActivity.this.x(EditHeadActivity.gkD);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.k.a((String) null, str, bitmap, 80);
            if (this.gla) {
                new ag("motu_pic", String.valueOf(this.gkW)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String[] strArr) {
        if (this.glb != null && strArr != null) {
            this.gkZ.removeAllViews();
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(d.g.filter_immage);
            TextView textView = (TextView) inflate.findViewById(d.g.filter_text);
            int length = strArr.length;
            int i = 0;
            final int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                final String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(d.g.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(d.g.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.a.fH(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gkL.isShowing()) {
                                EditHeadActivity.this.gkF.m(EditHeadActivity.this.mBitmap);
                                EditHeadActivity.this.gla = false;
                                EditHeadActivity.this.qV(substring);
                                EditHeadActivity.this.gkW = i2;
                            }
                        }
                    });
                    this.gld = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gkL.isShowing() && !substring.equals(EditHeadActivity.this.gkY)) {
                                EditHeadActivity.this.T(substring, true);
                                EditHeadActivity.this.qV(substring);
                                EditHeadActivity.this.gkW = i2;
                            }
                        }
                    });
                }
                this.gkZ.addView(inflate2);
                if (this.glc != null) {
                    this.glc.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            qV("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qV(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.glc == null) {
                this.glc = new HashMap<>();
            }
            if (this.gkY != null && (imageView = this.glc.get(this.gkY)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.gkV, this.gkV, this.gkV, this.gkV);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.glc.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(d.f.round_corner);
                imageView2.setPadding(this.gkV, this.gkV, this.gkV, this.gkV);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.gkY = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean glh;
        private Boolean gli = false;
        private Boolean glj = false;
        private String mLabel;

        public a(boolean z) {
            this.glh = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.glh || Je()) {
                EditHeadActivity.this.gkL.bq(true);
                EditHeadActivity.this.gkH.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.gkT == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.gli = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals("3")) {
                this.glj = true;
            }
            if (this.gli.booleanValue() || this.glj.booleanValue()) {
                if (EditHeadActivity.this.gkT != null) {
                    this.bitmap = EditHeadActivity.this.gkT.copy(EditHeadActivity.this.gkT.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.gli.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.glj.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean Je() {
            PluginPackageManager.PluginStatus bA = PluginPackageManager.qS().bA(PluginCenter.NAME_MOTUSDK);
            if (bA == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (bA == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), d.j.plugin_config_not_found);
                return false;
            } else if (bA == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.qS().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (bA == PluginPackageManager.PluginStatus.FORBIDDEN) {
                com.baidu.tbadk.coreExtra.d.a.a(EditHeadActivity.this.getPageContext(), d.j.plugin_muto_not_install, new a.b() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.a.1
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.gkT != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.gkL.bq(false);
            EditHeadActivity.this.gkH.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.gkL.bq(false);
            EditHeadActivity.this.gkH.setClickable(true);
            EditHeadActivity.this.gkH.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.gla = true;
                if (this.gli.booleanValue() || this.glj.booleanValue()) {
                    EditHeadActivity.this.gkF.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.gli.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.glj.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.gkF.m(bitmap);
                }
                if (EditHeadActivity.this.gkT != null && !EditHeadActivity.this.gkT.isRecycled()) {
                    EditHeadActivity.this.gkT.recycle();
                }
                EditHeadActivity.this.gkT = bitmap;
            }
        }
    }

    private void aFq() {
        this.gkU = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.gkU, intentFilter);
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
            if (EditHeadActivity.this.gkH != null) {
                EditHeadActivity.this.gkH.setEnabled(false);
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
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(d.j.upload_head));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            String str;
            Exception e;
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
            try {
                str = this.mNetwork.ei(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
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
            EditHeadActivity.this.gkS = null;
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 1);
                    EditHeadActivity.this.setResult(-1, intent);
                    EditHeadActivity.this.finish();
                    EditHeadActivity.this.showToast(EditHeadActivity.this.getPageContext().getString(d.j.upload_head_ok));
                    return;
                }
                EditHeadActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }
    }
}
