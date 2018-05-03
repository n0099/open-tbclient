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
    private int efH;
    private HashMap<String, Bitmap> fFA;
    private HashMap<String, ImageView> fFB;
    private View fFC;
    private TextView fFD;
    private String fFd;
    private View fFf;
    private View fFg;
    private RadioButton fFn;
    private RadioButton fFo;
    private LinearLayout fFy;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String fFa = "change";
    public static String FILE_NAME = "file_name";
    private static String[] fFc = null;
    private float fFb = 1.0f;
    private EditHeadsImageView fFe = null;
    private Bitmap mBitmap = null;
    private int eih = 0;
    private Button fFh = null;
    private Button fFi = null;
    private HorizontalScrollView fFj = null;
    private com.baidu.tbadk.core.view.a fFk = null;
    private b fFl = null;
    private a fFm = null;
    private LinearLayout fFp = null;
    private LinearLayout fFq = null;
    private d fFr = null;
    private TextView mTitle = null;
    private Bitmap fFs = null;
    private c fFt = null;
    private int fFu = 0;
    private int fFv = 0;
    private boolean fFw = true;
    private String fFx = null;
    private boolean fFz = false;
    private boolean aNb = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.eE().ak("motu_sdk") == 1 || PluginPackageManager.iX().bx(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fFw = false;
        } else {
            this.fFw = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.edit_head_activity);
        Intent intent = getIntent();
        this.eih = intent.getIntExtra("edit_type", 0);
        this.efH = intent.getIntExtra("request", 0);
        this.aNb = intent.getBooleanExtra("need_upload", true);
        this.fFb = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.fFd = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.efH == 12002 || this.efH == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.efH, intent.getData(), ap.vQ().vW());
            } else {
                TiebaPrepareImageService.StartService(this.efH, null, ap.vQ().vW(), 0, stringExtra);
            }
            aAq();
        } else {
            initUI();
            initData();
        }
        fFc = getResources().getStringArray(d.b.fiter_name);
        if (this.fFw) {
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
        getLayoutMode().u(this.fFf);
        getLayoutMode().u(this.fFg);
        ak.c(this.mTitle, d.C0126d.cp_cont_g, 1);
        ak.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_s, 0);
        ak.c(this.fFD, d.C0126d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.fFl != null) {
            this.fFl.cancel();
        }
        this.fFe.setImageDrawable(null);
        bef();
    }

    private void bef() {
        if (this.fFB != null) {
            for (Map.Entry<String, ImageView> entry : this.fFB.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.fFB.clear();
            this.fFB = null;
        }
        if (this.fFA != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.fFA.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.fFA.clear();
            this.fFA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.fFl != null) {
            this.fFl.cancel();
        }
        this.fFl = new b();
        this.fFl.execute(new Object[0]);
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
        this.fFe.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.fFr != null) {
            this.fFr.cancel();
        }
        if (this.fFs != null && !this.fFs.isRecycled()) {
            this.fFs.recycle();
            this.fFs = null;
        }
        if (this.fFl != null) {
            this.fFl.cancel();
            this.fFl = null;
        }
        this.fFk.aI(false);
        if (this.efH == 12002 || this.efH == 12001) {
            unregisterReceiver(this.fFt);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beg() {
        if (this.fFr != null) {
            this.fFr.cancel();
        }
        this.fFr = new d();
        this.fFr.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.fFk = new com.baidu.tbadk.core.view.a(getPageContext());
        this.fFk.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.fFk.aI(false);
            }
        });
        this.fFk.aI(false);
        this.fFe = (EditHeadsImageView) findViewById(d.g.image);
        this.fFe.setCutImageHeightScale(this.fFb);
        if (this.mBitmap != null) {
            this.fFe.setImageBitmap(this.mBitmap);
        }
        this.fFj = (HorizontalScrollView) findViewById(d.g.filters_layout);
        this.fFf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.fFi = (Button) findViewById(d.g.show_button);
        this.fFi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EditHeadActivity.this.fFq.setVisibility(0);
                EditHeadActivity.this.fFi.setVisibility(8);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.fFw) {
                    EditHeadActivity.this.fFo.setPadding(0, EditHeadActivity.this.fFo.getPaddingTop(), EditHeadActivity.this.fFo.getPaddingRight(), EditHeadActivity.this.fFo.getPaddingBottom());
                    EditHeadActivity.this.fFo.setChecked(true);
                    EditHeadActivity.this.fFj.setVisibility(8);
                    EditHeadActivity.this.fFn.setVisibility(8);
                }
            }
        });
        this.fFh = (Button) findViewById(d.g.hide_button);
        this.fFh.setVisibility(0);
        this.fFh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EditHeadActivity.this.fFq.setVisibility(8);
                EditHeadActivity.this.fFi.setVisibility(0);
            }
        });
        this.fFg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, (View.OnClickListener) null);
        this.fFg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.eih == 0) {
                    if (!EditHeadActivity.this.aNb) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap kY = EditHeadActivity.this.fFe.kY(EditHeadActivity.this.eih == 0 || EditHeadActivity.this.eih == 3);
                if (kY != null && EditHeadActivity.this.c(str, kY)) {
                    if (EditHeadActivity.this.eih == 0) {
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.fFd)) {
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
        this.fFg.setEnabled(false);
        this.fFD = (TextView) this.fFg.findViewById(d.g.save);
        this.fFD.setText(d.k.done);
        this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(d.k.beautify));
        if ("from_photo_live".equals(this.fFd)) {
            this.mTitle.setText(d.k.choose_picture);
        }
        this.fFy = (LinearLayout) findViewById(d.g.filters);
        this.fFu = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.fFq = (LinearLayout) findViewById(d.g.beautify_rotate);
        this.fFp = (LinearLayout) findViewById(d.g.rotate);
        this.fFn = (RadioButton) findViewById(d.g.beautify_btn);
        this.fFo = (RadioButton) findViewById(d.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.fFn) {
                        EditHeadActivity.this.fFj.setVisibility(0);
                        EditHeadActivity.this.fFp.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.fFo) {
                        EditHeadActivity.this.fFj.setVisibility(8);
                        EditHeadActivity.this.fFp.setVisibility(0);
                    }
                }
            }
        };
        this.fFn.setOnCheckedChangeListener(onCheckedChangeListener);
        this.fFo.setOnCheckedChangeListener(onCheckedChangeListener);
        this.fFn.setChecked(true);
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
                if (!EditHeadActivity.this.fFk.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.fFs != null) && view2.getTag() != null) {
                        EditHeadActivity.this.fFz = false;
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
        if (this.fFm != null) {
            this.fFm.cancel();
        }
        this.fFm = new a(z);
        this.fFm.execute(str);
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
                    if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.fFw) {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(Y, dip2px);
                        Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), Y != resizedBitmap);
                        EditHeadActivity.this.fFA = new HashMap();
                        EditHeadActivity.this.fFB = new HashMap();
                        EditHeadActivity.this.fFA.put("normal", roundedCornerBitmap);
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
            EditHeadActivity.this.fFk.aI(true);
            EditHeadActivity.this.fFg.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.fFl = null;
            EditHeadActivity.this.fFk.aI(false);
            EditHeadActivity.this.fFg.setClickable(true);
            EditHeadActivity.this.fFg.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.fFl = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.fFk.aI(false);
            EditHeadActivity.this.fFg.setClickable(true);
            EditHeadActivity.this.fFg.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.fFe.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.fFe.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.fFw) {
                    EditHeadActivity.this.z(EditHeadActivity.fFc);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            k.a((String) null, str, bitmap, 80);
            if (this.fFz) {
                new ag("motu_pic", String.valueOf(this.fFv)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String[] strArr) {
        if (this.fFA != null && strArr != null) {
            this.fFy.removeAllViews();
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
                            if (!EditHeadActivity.this.fFk.isShowing()) {
                                EditHeadActivity.this.fFe.j(EditHeadActivity.this.mBitmap);
                                EditHeadActivity.this.fFz = false;
                                EditHeadActivity.this.rb(substring);
                                EditHeadActivity.this.fFv = i2;
                            }
                        }
                    });
                    this.fFC = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (!EditHeadActivity.this.fFk.isShowing() && !substring.equals(EditHeadActivity.this.fFx)) {
                                EditHeadActivity.this.O(substring, true);
                                EditHeadActivity.this.rb(substring);
                                EditHeadActivity.this.fFv = i2;
                            }
                        }
                    });
                }
                this.fFy.addView(inflate2);
                if (this.fFB != null) {
                    this.fFB.put(substring, imageView2);
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
            if (this.fFB == null) {
                this.fFB = new HashMap<>();
            }
            if (this.fFx != null && (imageView = this.fFB.get(this.fFx)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.fFu, this.fFu, this.fFu, this.fFu);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.fFB.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(d.f.round_corner);
                imageView2.setPadding(this.fFu, this.fFu, this.fFu, this.fFu);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.fFx = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean fFG;
        private Boolean fFH = false;
        private Boolean fFI = false;
        private String mLabel;

        public a(boolean z) {
            this.fFG = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.fFG || bei()) {
                EditHeadActivity.this.fFk.aI(true);
                EditHeadActivity.this.fFg.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.fFs == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.fFH = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals("3")) {
                this.fFI = true;
            }
            if (this.fFH.booleanValue() || this.fFI.booleanValue()) {
                if (EditHeadActivity.this.fFs != null) {
                    this.bitmap = EditHeadActivity.this.fFs.copy(EditHeadActivity.this.fFs.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.fFH.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.fFI.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.fFs != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.fFk.aI(false);
            EditHeadActivity.this.fFg.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.fFk.aI(false);
            EditHeadActivity.this.fFg.setClickable(true);
            EditHeadActivity.this.fFg.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.fFz = true;
                if (this.fFH.booleanValue() || this.fFI.booleanValue()) {
                    EditHeadActivity.this.fFe.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.fFH.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.fFI.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.fFe.j(bitmap);
                }
                if (EditHeadActivity.this.fFs != null && !EditHeadActivity.this.fFs.isRecycled()) {
                    EditHeadActivity.this.fFs.recycle();
                }
                EditHeadActivity.this.fFs = bitmap;
            }
        }
    }

    private void aAq() {
        this.fFt = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.fFt, intentFilter);
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
            if (EditHeadActivity.this.fFg != null) {
                EditHeadActivity.this.fFg.setEnabled(false);
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
            EditHeadActivity.this.fFr = null;
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
