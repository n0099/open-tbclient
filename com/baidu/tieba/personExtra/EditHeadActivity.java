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
    private String gkJ;
    private View gkL;
    private View gkM;
    private RadioButton gkT;
    private RadioButton gkU;
    private LinearLayout gle;
    private HashMap<String, Bitmap> glg;
    private HashMap<String, ImageView> glh;
    private View gli;
    private TextView glj;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String gkG = "change";
    public static String FILE_NAME = "file_name";
    private static String[] gkI = null;
    private float gkH = 1.0f;
    private EditHeadsImageView gkK = null;
    private Bitmap mBitmap = null;
    private int eNE = 0;
    private Button gkN = null;
    private Button gkO = null;
    private HorizontalScrollView gkP = null;
    private com.baidu.tbadk.core.view.b gkQ = null;
    private b gkR = null;
    private a gkS = null;
    private LinearLayout gkV = null;
    private LinearLayout gkW = null;
    private d gkX = null;
    private TextView mTitle = null;
    private Bitmap gkY = null;
    private c gkZ = null;
    private int gla = 0;
    private int glb = 0;
    private boolean glc = true;
    private String gld = null;
    private boolean glf = false;
    private boolean bCB = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.mA().an("motu_sdk") == 1 || PluginPackageManager.qS().bA(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.glc = false;
        } else {
            this.glc = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.edit_head_activity);
        Intent intent = getIntent();
        this.eNE = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        this.bCB = intent.getBooleanExtra("need_upload", true);
        this.gkH = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.gkJ = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
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
        gkI = getResources().getStringArray(d.b.fiter_name);
        if (this.glc) {
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
        aj.t(this.mNavigationBar, d.C0141d.common_color_10222);
        getLayoutMode().aM(this.gkL);
        getLayoutMode().aM(this.gkM);
        aj.e(this.mTitle, d.C0141d.cp_cont_g, 1);
        aj.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_s, 0);
        aj.e(this.glj, d.C0141d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.gkR != null) {
            this.gkR.cancel();
        }
        this.gkK.setImageDrawable(null);
        bje();
    }

    private void bje() {
        if (this.glh != null) {
            for (Map.Entry<String, ImageView> entry : this.glh.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.glh.clear();
            this.glh = null;
        }
        if (this.glg != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.glg.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.glg.clear();
            this.glg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.gkR != null) {
            this.gkR.cancel();
        }
        this.gkR = new b();
        this.gkR.execute(new Object[0]);
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
        this.gkK.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.gkX != null) {
            this.gkX.cancel();
        }
        if (this.gkY != null && !this.gkY.isRecycled()) {
            this.gkY.recycle();
            this.gkY = null;
        }
        if (this.gkR != null) {
            this.gkR.cancel();
            this.gkR = null;
        }
        this.gkQ.bq(false);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.gkZ);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjf() {
        if (this.gkX != null) {
            this.gkX.cancel();
        }
        this.gkX = new d();
        this.gkX.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.gkQ = new com.baidu.tbadk.core.view.b(getPageContext());
        this.gkQ.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.gkQ.bq(false);
            }
        });
        this.gkQ.bq(false);
        this.gkK = (EditHeadsImageView) findViewById(d.g.image);
        this.gkK.setCutImageHeightScale(this.gkH);
        if (this.mBitmap != null) {
            this.gkK.setImageBitmap(this.mBitmap);
        }
        this.gkP = (HorizontalScrollView) findViewById(d.g.filters_layout);
        this.gkL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.gkO = (Button) findViewById(d.g.show_button);
        this.gkO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gkW.setVisibility(0);
                EditHeadActivity.this.gkO.setVisibility(8);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.glc) {
                    EditHeadActivity.this.gkU.setPadding(0, EditHeadActivity.this.gkU.getPaddingTop(), EditHeadActivity.this.gkU.getPaddingRight(), EditHeadActivity.this.gkU.getPaddingBottom());
                    EditHeadActivity.this.gkU.setChecked(true);
                    EditHeadActivity.this.gkP.setVisibility(8);
                    EditHeadActivity.this.gkT.setVisibility(8);
                }
            }
        });
        this.gkN = (Button) findViewById(d.g.hide_button);
        this.gkN.setVisibility(0);
        this.gkN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.gkW.setVisibility(8);
                EditHeadActivity.this.gkO.setVisibility(0);
            }
        });
        this.gkM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, (View.OnClickListener) null);
        this.gkM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.eNE == 0) {
                    if (!EditHeadActivity.this.bCB) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap lz = EditHeadActivity.this.gkK.lz(EditHeadActivity.this.eNE == 0 || EditHeadActivity.this.eNE == 3);
                if (lz != null && EditHeadActivity.this.b(str, lz)) {
                    if (EditHeadActivity.this.eNE == 0) {
                        if (EditHeadActivity.this.bCB) {
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.gkJ)) {
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
        this.gkM.setEnabled(false);
        this.glj = (TextView) this.gkM.findViewById(d.g.save);
        this.glj.setText(d.j.done);
        this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(d.j.beautify));
        if ("from_photo_live".equals(this.gkJ)) {
            this.mTitle.setText(d.j.choose_picture);
        }
        this.gle = (LinearLayout) findViewById(d.g.filters);
        this.gla = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.gkW = (LinearLayout) findViewById(d.g.beautify_rotate);
        this.gkV = (LinearLayout) findViewById(d.g.rotate);
        this.gkT = (RadioButton) findViewById(d.g.beautify_btn);
        this.gkU = (RadioButton) findViewById(d.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.gkT) {
                        EditHeadActivity.this.gkP.setVisibility(0);
                        EditHeadActivity.this.gkV.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.gkU) {
                        EditHeadActivity.this.gkP.setVisibility(8);
                        EditHeadActivity.this.gkV.setVisibility(0);
                    }
                }
            }
        };
        this.gkT.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gkU.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gkT.setChecked(true);
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
                if (!EditHeadActivity.this.gkQ.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.gkY != null) && view.getTag() != null) {
                        EditHeadActivity.this.glf = false;
                        EditHeadActivity.this.S(view.getTag().toString(), false);
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
    public void S(String str, boolean z) {
        if (this.gkS != null) {
            this.gkS.cancel();
        }
        this.gkS = new a(z);
        this.gkS.execute(str);
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
                    if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.glc) {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(X, dip2px);
                        Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), X != resizedBitmap);
                        EditHeadActivity.this.glg = new HashMap();
                        EditHeadActivity.this.glh = new HashMap();
                        EditHeadActivity.this.glg.put("normal", roundedCornerBitmap);
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
            EditHeadActivity.this.gkQ.bq(true);
            EditHeadActivity.this.gkM.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.gkR = null;
            EditHeadActivity.this.gkQ.bq(false);
            EditHeadActivity.this.gkM.setClickable(true);
            EditHeadActivity.this.gkM.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.gkR = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.gkQ.bq(false);
            EditHeadActivity.this.gkM.setClickable(true);
            EditHeadActivity.this.gkM.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.gkK.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.gkK.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.glc) {
                    EditHeadActivity.this.x(EditHeadActivity.gkI);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.k.a((String) null, str, bitmap, 80);
            if (this.glf) {
                new ag("motu_pic", String.valueOf(this.glb)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String[] strArr) {
        if (this.glg != null && strArr != null) {
            this.gle.removeAllViews();
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
                            if (!EditHeadActivity.this.gkQ.isShowing()) {
                                EditHeadActivity.this.gkK.m(EditHeadActivity.this.mBitmap);
                                EditHeadActivity.this.glf = false;
                                EditHeadActivity.this.qV(substring);
                                EditHeadActivity.this.glb = i2;
                            }
                        }
                    });
                    this.gli = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.gkQ.isShowing() && !substring.equals(EditHeadActivity.this.gld)) {
                                EditHeadActivity.this.S(substring, true);
                                EditHeadActivity.this.qV(substring);
                                EditHeadActivity.this.glb = i2;
                            }
                        }
                    });
                }
                this.gle.addView(inflate2);
                if (this.glh != null) {
                    this.glh.put(substring, imageView2);
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
            if (this.glh == null) {
                this.glh = new HashMap<>();
            }
            if (this.gld != null && (imageView = this.glh.get(this.gld)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.gla, this.gla, this.gla, this.gla);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.glh.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(d.f.round_corner);
                imageView2.setPadding(this.gla, this.gla, this.gla, this.gla);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.gld = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean glm;
        private Boolean gln = false;
        private Boolean glo = false;
        private String mLabel;

        public a(boolean z) {
            this.glm = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.glm || Je()) {
                EditHeadActivity.this.gkQ.bq(true);
                EditHeadActivity.this.gkM.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.gkY == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.gln = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals("3")) {
                this.glo = true;
            }
            if (this.gln.booleanValue() || this.glo.booleanValue()) {
                if (EditHeadActivity.this.gkY != null) {
                    this.bitmap = EditHeadActivity.this.gkY.copy(EditHeadActivity.this.gkY.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.gln.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.glo.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.gkY != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.gkQ.bq(false);
            EditHeadActivity.this.gkM.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.gkQ.bq(false);
            EditHeadActivity.this.gkM.setClickable(true);
            EditHeadActivity.this.gkM.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.glf = true;
                if (this.gln.booleanValue() || this.glo.booleanValue()) {
                    EditHeadActivity.this.gkK.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.gln.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.glo.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.gkK.m(bitmap);
                }
                if (EditHeadActivity.this.gkY != null && !EditHeadActivity.this.gkY.isRecycled()) {
                    EditHeadActivity.this.gkY.recycle();
                }
                EditHeadActivity.this.gkY = bitmap;
            }
        }
    }

    private void aFq() {
        this.gkZ = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.gkZ, intentFilter);
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
            if (EditHeadActivity.this.gkM != null) {
                EditHeadActivity.this.gkM.setEnabled(false);
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
            EditHeadActivity.this.gkX = null;
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
