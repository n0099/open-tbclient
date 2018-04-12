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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.x;
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
    private int efK;
    private LinearLayout fFB;
    private HashMap<String, Bitmap> fFD;
    private HashMap<String, ImageView> fFE;
    private View fFF;
    private TextView fFG;
    private String fFg;
    private View fFi;
    private View fFj;
    private RadioButton fFq;
    private RadioButton fFr;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String fFd = "change";
    public static String FILE_NAME = "file_name";
    private static String[] fFf = null;
    private float fFe = 1.0f;
    private EditHeadsImageView fFh = null;
    private Bitmap mBitmap = null;
    private int eik = 0;
    private Button fFk = null;
    private Button fFl = null;
    private HorizontalScrollView fFm = null;
    private com.baidu.tbadk.core.view.a fFn = null;
    private b fFo = null;
    private a fFp = null;
    private LinearLayout fFs = null;
    private LinearLayout fFt = null;
    private d fFu = null;
    private TextView mTitle = null;
    private Bitmap fFv = null;
    private c fFw = null;
    private int fFx = 0;
    private int fFy = 0;
    private boolean fFz = true;
    private String fFA = null;
    private boolean fFC = false;
    private boolean aNb = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.eE().ak("motu_sdk") == 1 || PluginPackageManager.iX().bx(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fFz = false;
        } else {
            this.fFz = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.edit_head_activity);
        Intent intent = getIntent();
        this.eik = intent.getIntExtra("edit_type", 0);
        this.efK = intent.getIntExtra("request", 0);
        this.aNb = intent.getBooleanExtra("need_upload", true);
        this.fFe = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.fFg = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.efK == 12002 || this.efK == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.efK, intent.getData(), ap.vQ().vW());
            } else {
                TiebaPrepareImageService.StartService(this.efK, null, ap.vQ().vW(), 0, stringExtra);
            }
            aAq();
        } else {
            initUI();
            initData();
        }
        fFf = getResources().getStringArray(d.b.fiter_name);
        if (this.fFz) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bee();
    }

    private void bee() {
        ak.j(this.mNavigationBar, d.C0126d.common_color_10222);
        getLayoutMode().u(this.fFi);
        getLayoutMode().u(this.fFj);
        ak.c(this.mTitle, d.C0126d.cp_cont_g, 1);
        ak.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_s, 0);
        ak.c(this.fFG, d.C0126d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.fFo != null) {
            this.fFo.cancel();
        }
        this.fFh.setImageDrawable(null);
        bef();
    }

    private void bef() {
        if (this.fFE != null) {
            for (Map.Entry<String, ImageView> entry : this.fFE.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.fFE.clear();
            this.fFE = null;
        }
        if (this.fFD != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.fFD.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.fFD.clear();
            this.fFD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.fFo != null) {
            this.fFo.cancel();
        }
        this.fFo = new b();
        this.fFo.execute(new Object[0]);
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
        this.fFh.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.fFu != null) {
            this.fFu.cancel();
        }
        if (this.fFv != null && !this.fFv.isRecycled()) {
            this.fFv.recycle();
            this.fFv = null;
        }
        if (this.fFo != null) {
            this.fFo.cancel();
            this.fFo = null;
        }
        this.fFn.aI(false);
        if (this.efK == 12002 || this.efK == 12001) {
            unregisterReceiver(this.fFw);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beg() {
        if (this.fFu != null) {
            this.fFu.cancel();
        }
        this.fFu = new d();
        this.fFu.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.fFn = new com.baidu.tbadk.core.view.a(getPageContext());
        this.fFn.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.fFn.aI(false);
            }
        });
        this.fFn.aI(false);
        this.fFh = (EditHeadsImageView) findViewById(d.g.image);
        this.fFh.setCutImageHeightScale(this.fFe);
        if (this.mBitmap != null) {
            this.fFh.setImageBitmap(this.mBitmap);
        }
        this.fFm = (HorizontalScrollView) findViewById(d.g.filters_layout);
        this.fFi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.fFl = (Button) findViewById(d.g.show_button);
        this.fFl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EditHeadActivity.this.fFt.setVisibility(0);
                EditHeadActivity.this.fFl.setVisibility(8);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.fFz) {
                    EditHeadActivity.this.fFr.setPadding(0, EditHeadActivity.this.fFr.getPaddingTop(), EditHeadActivity.this.fFr.getPaddingRight(), EditHeadActivity.this.fFr.getPaddingBottom());
                    EditHeadActivity.this.fFr.setChecked(true);
                    EditHeadActivity.this.fFm.setVisibility(8);
                    EditHeadActivity.this.fFq.setVisibility(8);
                }
            }
        });
        this.fFk = (Button) findViewById(d.g.hide_button);
        this.fFk.setVisibility(0);
        this.fFk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EditHeadActivity.this.fFt.setVisibility(8);
                EditHeadActivity.this.fFl.setVisibility(0);
            }
        });
        this.fFj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, (View.OnClickListener) null);
        this.fFj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.eik == 0) {
                    if (!EditHeadActivity.this.aNb) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap kY = EditHeadActivity.this.fFh.kY(EditHeadActivity.this.eik == 0 || EditHeadActivity.this.eik == 3);
                if (kY != null && EditHeadActivity.this.c(str, kY)) {
                    if (EditHeadActivity.this.eik == 0) {
                        if (EditHeadActivity.this.aNb) {
                            EditHeadActivity.this.beg();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(k.dt(str), "head");
                    aVar.Fh();
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.fFg)) {
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
                    aVar.bH(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(d.k.uploading));
                }
            }
        });
        this.fFj.setEnabled(false);
        this.fFG = (TextView) this.fFj.findViewById(d.g.save);
        this.fFG.setText(d.k.done);
        this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(d.k.beautify));
        if ("from_photo_live".equals(this.fFg)) {
            this.mTitle.setText(d.k.choose_picture);
        }
        this.fFB = (LinearLayout) findViewById(d.g.filters);
        this.fFx = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.fFt = (LinearLayout) findViewById(d.g.beautify_rotate);
        this.fFs = (LinearLayout) findViewById(d.g.rotate);
        this.fFq = (RadioButton) findViewById(d.g.beautify_btn);
        this.fFr = (RadioButton) findViewById(d.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.fFq) {
                        EditHeadActivity.this.fFm.setVisibility(0);
                        EditHeadActivity.this.fFs.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.fFr) {
                        EditHeadActivity.this.fFm.setVisibility(8);
                        EditHeadActivity.this.fFs.setVisibility(0);
                    }
                }
            }
        };
        this.fFq.setOnCheckedChangeListener(onCheckedChangeListener);
        this.fFr.setOnCheckedChangeListener(onCheckedChangeListener);
        this.fFq.setChecked(true);
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
            public void onClick(View view2) {
                if (!EditHeadActivity.this.fFn.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.fFv != null) && view2.getTag() != null) {
                        EditHeadActivity.this.fFC = false;
                        EditHeadActivity.this.O(view2.getTag().toString(), false);
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
        if (this.fFp != null) {
            this.fFp.cancel();
        }
        this.fFp = new a(z);
        this.fFp.execute(str);
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
                Bitmap Y = k.Y(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (Y.getWidth() > 1800 || Y.getHeight() > 1800) {
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(Y, (int) TbConfig.POST_IMAGE_MIDDLE);
                        try {
                            Y.recycle();
                            Y = resizeBitmap;
                        } catch (Exception e) {
                            e = e;
                            bitmap = resizeBitmap;
                            BdLog.e(e.toString());
                            return bitmap;
                        }
                    }
                    if (isCancelled() && Y != null && !Y.isRecycled()) {
                        Y.recycle();
                        return null;
                    }
                    int dip2px = l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 63.5f);
                    if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.fFz) {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(Y, dip2px);
                        Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), Y != resizedBitmap);
                        EditHeadActivity.this.fFD = new HashMap();
                        EditHeadActivity.this.fFE = new HashMap();
                        EditHeadActivity.this.fFD.put("normal", roundedCornerBitmap);
                    }
                    return Y;
                } catch (Exception e2) {
                    bitmap = Y;
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            EditHeadActivity.this.fFn.aI(true);
            EditHeadActivity.this.fFj.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.fFo = null;
            EditHeadActivity.this.fFn.aI(false);
            EditHeadActivity.this.fFj.setClickable(true);
            EditHeadActivity.this.fFj.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.fFo = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.fFn.aI(false);
            EditHeadActivity.this.fFj.setClickable(true);
            EditHeadActivity.this.fFj.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.fFh.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.fFh.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.fFz) {
                    EditHeadActivity.this.z(EditHeadActivity.fFf);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            k.a((String) null, str, bitmap, 80);
            if (this.fFC) {
                new ag("motu_pic", String.valueOf(this.fFy)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String[] strArr) {
        if (this.fFD != null && strArr != null) {
            this.fFB.removeAllViews();
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
                imageView2.setImageResource(FiltersView.fA(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (!EditHeadActivity.this.fFn.isShowing()) {
                                EditHeadActivity.this.fFh.j(EditHeadActivity.this.mBitmap);
                                EditHeadActivity.this.fFC = false;
                                EditHeadActivity.this.rb(substring);
                                EditHeadActivity.this.fFy = i2;
                            }
                        }
                    });
                    this.fFF = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (!EditHeadActivity.this.fFn.isShowing() && !substring.equals(EditHeadActivity.this.fFA)) {
                                EditHeadActivity.this.O(substring, true);
                                EditHeadActivity.this.rb(substring);
                                EditHeadActivity.this.fFy = i2;
                            }
                        }
                    });
                }
                this.fFB.addView(inflate2);
                if (this.fFE != null) {
                    this.fFE.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            rb("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rb(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.fFE == null) {
                this.fFE = new HashMap<>();
            }
            if (this.fFA != null && (imageView = this.fFE.get(this.fFA)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.fFx, this.fFx, this.fFx, this.fFx);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.fFE.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(d.f.round_corner);
                imageView2.setPadding(this.fFx, this.fFx, this.fFx, this.fFx);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.fFA = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean fFJ;
        private Boolean fFK = false;
        private Boolean fFL = false;
        private String mLabel;

        public a(boolean z) {
            this.fFJ = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.fFJ || bei()) {
                EditHeadActivity.this.fFn.aI(true);
                EditHeadActivity.this.fFj.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.fFv == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.fFK = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals("3")) {
                this.fFL = true;
            }
            if (this.fFK.booleanValue() || this.fFL.booleanValue()) {
                if (EditHeadActivity.this.fFv != null) {
                    this.bitmap = EditHeadActivity.this.fFv.copy(EditHeadActivity.this.fFv.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.fFK.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.fFL.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean bei() {
            PluginPackageManager.PluginStatus bx = PluginPackageManager.iX().bx(PluginCenter.NAME_MOTUSDK);
            if (bx == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (bx == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), d.k.plugin_config_not_found);
                return false;
            } else if (bx == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.iX().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (bx == PluginPackageManager.PluginStatus.FORBIDDEN) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.fFv != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.fFn.aI(false);
            EditHeadActivity.this.fFj.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.fFn.aI(false);
            EditHeadActivity.this.fFj.setClickable(true);
            EditHeadActivity.this.fFj.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.fFC = true;
                if (this.fFK.booleanValue() || this.fFL.booleanValue()) {
                    EditHeadActivity.this.fFh.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.fFK.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.fFL.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.fFh.j(bitmap);
                }
                if (EditHeadActivity.this.fFv != null && !EditHeadActivity.this.fFv.isRecycled()) {
                    EditHeadActivity.this.fFv.recycle();
                }
                EditHeadActivity.this.fFv = bitmap;
            }
        }
    }

    private void aAq() {
        this.fFw = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.fFw, intentFilter);
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
            if (EditHeadActivity.this.fFj != null) {
                EditHeadActivity.this.fFj.setEnabled(false);
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
            EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(d.k.upload_head));
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
                str = this.mNetwork.ea(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.vj().wj().isRequestSuccess()) {
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
            EditHeadActivity.this.fFu = null;
            if (this.mNetwork != null) {
                this.mNetwork.eW();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            EditHeadActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                if (this.mNetwork.vj().wj().isRequestSuccess()) {
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
