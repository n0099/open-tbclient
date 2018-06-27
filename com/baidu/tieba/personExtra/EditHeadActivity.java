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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
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
    private int evV;
    private String fVE;
    private View fVG;
    private View fVH;
    private RadioButton fVO;
    private RadioButton fVP;
    private LinearLayout fVZ;
    private HashMap<String, Bitmap> fWb;
    private HashMap<String, ImageView> fWc;
    private View fWd;
    private TextView fWe;
    private NavigationBar mNavigationBar;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String fVB = "change";
    public static String FILE_NAME = "file_name";
    private static String[] fVD = null;
    private float fVC = 1.0f;
    private EditHeadsImageView fVF = null;
    private Bitmap mBitmap = null;
    private int eyw = 0;
    private Button fVI = null;
    private Button fVJ = null;
    private HorizontalScrollView fVK = null;
    private com.baidu.tbadk.core.view.a fVL = null;
    private b fVM = null;
    private a fVN = null;
    private LinearLayout fVQ = null;
    private LinearLayout fVR = null;
    private d fVS = null;
    private TextView mTitle = null;
    private Bitmap fVT = null;
    private c fVU = null;
    private int fVV = 0;
    private int fVW = 0;
    private boolean fVX = true;
    private String fVY = null;
    private boolean fWa = false;
    private boolean aVV = true;
    private final Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.hv().aw("motu_sdk") == 1 || PluginPackageManager.lL().bL(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fVX = false;
        } else {
            this.fVX = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.edit_head_activity);
        Intent intent = getIntent();
        this.eyw = intent.getIntExtra("edit_type", 0);
        this.evV = intent.getIntExtra("request", 0);
        this.aVV = intent.getBooleanExtra("need_upload", true);
        this.fVC = intent.getFloatExtra(EditHeadActivityConfig.CUT_IMAGE_HEIGHT_SCALE, 1.0f);
        this.fVE = intent.getStringExtra(EditHeadActivityConfig.FROM_WHERE);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.evV == 12002 || this.evV == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.evV, intent.getData(), ar.zF().zL());
            } else {
                TiebaPrepareImageService.StartService(this.evV, null, ar.zF().zL(), 0, stringExtra);
            }
            aFR();
        } else {
            initUI();
            initData();
        }
        fVD = getResources().getStringArray(d.b.fiter_name);
        if (this.fVX) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bjK();
    }

    private void bjK() {
        am.j(this.mNavigationBar, d.C0142d.common_color_10222);
        getLayoutMode().onModeChanged(this.fVG);
        getLayoutMode().onModeChanged(this.fVH);
        am.c(this.mTitle, d.C0142d.cp_cont_g, 1);
        am.b(this.mNavigationBar.getBackImageView(), d.f.icon_topbar_return_s, d.f.icon_topbar_return_s, 0);
        am.c(this.fWe, d.C0142d.cp_cont_g, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.fVM != null) {
            this.fVM.cancel();
        }
        this.fVF.setImageDrawable(null);
        bjL();
    }

    private void bjL() {
        if (this.fWc != null) {
            for (Map.Entry<String, ImageView> entry : this.fWc.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.fWc.clear();
            this.fWc = null;
        }
        if (this.fWb != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.fWb.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.fWb.clear();
            this.fWb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.fVM != null) {
            this.fVM.cancel();
        }
        this.fVM = new b();
        this.fVM.execute(new Object[0]);
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
        this.fVF.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.fVS != null) {
            this.fVS.cancel();
        }
        if (this.fVT != null && !this.fVT.isRecycled()) {
            this.fVT.recycle();
            this.fVT = null;
        }
        if (this.fVM != null) {
            this.fVM.cancel();
            this.fVM = null;
        }
        this.fVL.aO(false);
        if (this.evV == 12002 || this.evV == 12001) {
            unregisterReceiver(this.fVU);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjM() {
        if (this.fVS != null) {
            this.fVS.cancel();
        }
        this.fVS = new d();
        this.fVS.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.fVL = new com.baidu.tbadk.core.view.a(getPageContext());
        this.fVL.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                EditHeadActivity.this.fVL.aO(false);
            }
        });
        this.fVL.aO(false);
        this.fVF = (EditHeadsImageView) findViewById(d.g.image);
        this.fVF.setCutImageHeightScale(this.fVC);
        if (this.mBitmap != null) {
            this.fVF.setImageBitmap(this.mBitmap);
        }
        this.fVK = (HorizontalScrollView) findViewById(d.g.filters_layout);
        this.fVG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.setResult(0);
                EditHeadActivity.this.finish();
            }
        });
        this.fVJ = (Button) findViewById(d.g.show_button);
        this.fVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.fVR.setVisibility(0);
                EditHeadActivity.this.fVJ.setVisibility(8);
                if (Build.VERSION.SDK_INT < 7 || !EditHeadActivity.this.fVX) {
                    EditHeadActivity.this.fVP.setPadding(0, EditHeadActivity.this.fVP.getPaddingTop(), EditHeadActivity.this.fVP.getPaddingRight(), EditHeadActivity.this.fVP.getPaddingBottom());
                    EditHeadActivity.this.fVP.setChecked(true);
                    EditHeadActivity.this.fVK.setVisibility(8);
                    EditHeadActivity.this.fVO.setVisibility(8);
                }
            }
        });
        this.fVI = (Button) findViewById(d.g.hide_button);
        this.fVI.setVisibility(0);
        this.fVI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditHeadActivity.this.fVR.setVisibility(8);
                EditHeadActivity.this.fVJ.setVisibility(0);
            }
        });
        this.fVH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, (View.OnClickListener) null);
        this.fVH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = TbConfig.PERSON_HEAD_FILE;
                if (EditHeadActivity.this.eyw == 0) {
                    if (!EditHeadActivity.this.aVV) {
                        str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
                    }
                } else {
                    str = TbConfig.GROUP_HEAD_FILE;
                }
                Bitmap lp = EditHeadActivity.this.fVF.lp(EditHeadActivity.this.eyw == 0 || EditHeadActivity.this.eyw == 3);
                if (lp != null && EditHeadActivity.this.c(str, lp)) {
                    if (EditHeadActivity.this.eyw == 0) {
                        if (EditHeadActivity.this.aVV) {
                            EditHeadActivity.this.bjM();
                            return;
                        }
                        Intent intent = EditHeadActivity.this.getIntent();
                        intent.putExtra("upload_image_type", 2);
                        EditHeadActivity.this.setResult(-1, intent);
                        EditHeadActivity.this.closeActivity();
                        return;
                    }
                    com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(l.dW(str), "head");
                    aVar.Jc();
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
                                    if (EditHeadActivityConfig.FROM_MISSON_SET_COVER.equals(EditHeadActivity.this.fVE)) {
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
                    aVar.bO(false);
                    EditHeadActivity.this.showLoadingDialog(EditHeadActivity.this.getPageContext().getString(d.k.uploading));
                }
            }
        });
        this.fVH.setEnabled(false);
        this.fWe = (TextView) this.fVH.findViewById(d.g.save);
        this.fWe.setText(d.k.done);
        this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(d.k.beautify));
        if ("from_photo_live".equals(this.fVE)) {
            this.mTitle.setText(d.k.choose_picture);
        }
        this.fVZ = (LinearLayout) findViewById(d.g.filters);
        this.fVV = com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.fVR = (LinearLayout) findViewById(d.g.beautify_rotate);
        this.fVQ = (LinearLayout) findViewById(d.g.rotate);
        this.fVO = (RadioButton) findViewById(d.g.beautify_btn);
        this.fVP = (RadioButton) findViewById(d.g.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == EditHeadActivity.this.fVO) {
                        EditHeadActivity.this.fVK.setVisibility(0);
                        EditHeadActivity.this.fVQ.setVisibility(8);
                    } else if (compoundButton == EditHeadActivity.this.fVP) {
                        EditHeadActivity.this.fVK.setVisibility(8);
                        EditHeadActivity.this.fVQ.setVisibility(0);
                    }
                }
            }
        };
        this.fVO.setOnCheckedChangeListener(onCheckedChangeListener);
        this.fVP.setOnCheckedChangeListener(onCheckedChangeListener);
        this.fVO.setChecked(true);
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
                if (!EditHeadActivity.this.fVL.isShowing()) {
                    if ((EditHeadActivity.this.mBitmap != null || EditHeadActivity.this.fVT != null) && view.getTag() != null) {
                        EditHeadActivity.this.fWa = false;
                        EditHeadActivity.this.P(view.getTag().toString(), false);
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
    public void P(String str, boolean z) {
        if (this.fVN != null) {
            this.fVN.cancel();
        }
        this.fVN = new a(z);
        this.fVN.execute(str);
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
                    if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.fVX) {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(ab, dip2px);
                        Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, com.baidu.adp.lib.util.l.dip2px(EditHeadActivity.this.getPageContext().getPageActivity(), 5.0f), ab != resizedBitmap);
                        EditHeadActivity.this.fWb = new HashMap();
                        EditHeadActivity.this.fWc = new HashMap();
                        EditHeadActivity.this.fWb.put("normal", roundedCornerBitmap);
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
            EditHeadActivity.this.fVL.aO(true);
            EditHeadActivity.this.fVH.setClickable(false);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            EditHeadActivity.this.fVM = null;
            EditHeadActivity.this.fVL.aO(false);
            EditHeadActivity.this.fVH.setClickable(true);
            EditHeadActivity.this.fVH.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            EditHeadActivity.this.fVM = null;
            EditHeadActivity.this.mBitmap = bitmap;
            EditHeadActivity.this.fVL.aO(false);
            EditHeadActivity.this.fVH.setClickable(true);
            EditHeadActivity.this.fVH.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                EditHeadActivity.this.fVF.setImageDrawable(null);
            } else if (bitmap != null) {
                EditHeadActivity.this.fVF.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && EditHeadActivity.this.fVX) {
                    EditHeadActivity.this.A(EditHeadActivity.fVD);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, Bitmap bitmap) {
        try {
            l.a((String) null, str, bitmap, 80);
            if (this.fWa) {
                new ah("motu_pic", String.valueOf(this.fVW)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String[] strArr) {
        if (this.fWb != null && strArr != null) {
            this.fVZ.removeAllViews();
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
                imageView2.setImageResource(FiltersView.gc(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.fVL.isShowing()) {
                                EditHeadActivity.this.fVF.i(EditHeadActivity.this.mBitmap);
                                EditHeadActivity.this.fWa = false;
                                EditHeadActivity.this.rT(substring);
                                EditHeadActivity.this.fVW = i2;
                            }
                        }
                    });
                    this.fWd = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.EditHeadActivity.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!EditHeadActivity.this.fVL.isShowing() && !substring.equals(EditHeadActivity.this.fVY)) {
                                EditHeadActivity.this.P(substring, true);
                                EditHeadActivity.this.rT(substring);
                                EditHeadActivity.this.fVW = i2;
                            }
                        }
                    });
                }
                this.fVZ.addView(inflate2);
                if (this.fWc != null) {
                    this.fWc.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            rT("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rT(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.fWc == null) {
                this.fWc = new HashMap<>();
            }
            if (this.fVY != null && (imageView = this.fWc.get(this.fVY)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.fVV, this.fVV, this.fVV, this.fVV);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.fWc.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(d.f.round_corner);
                imageView2.setPadding(this.fVV, this.fVV, this.fVV, this.fVV);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.fVY = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private boolean fWh;
        private Boolean fWi = false;
        private Boolean fWj = false;
        private String mLabel;

        public a(boolean z) {
            this.fWh = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (!this.fWh || bjO()) {
                EditHeadActivity.this.fVL.aO(true);
                EditHeadActivity.this.fVH.setEnabled(false);
                return;
            }
            cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (EditHeadActivity.this.mBitmap == null && EditHeadActivity.this.fVT == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.fWi = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals("3")) {
                this.fWj = true;
            }
            if (this.fWi.booleanValue() || this.fWj.booleanValue()) {
                if (EditHeadActivity.this.fVT != null) {
                    this.bitmap = EditHeadActivity.this.fVT.copy(EditHeadActivity.this.fVT.getConfig(), true);
                } else {
                    this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
                }
            } else {
                this.bitmap = EditHeadActivity.this.mBitmap.copy(EditHeadActivity.this.mBitmap.getConfig(), true);
            }
            if (this.fWi.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.fWj.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                if (motuPlugin != null) {
                    this.bitmap = motuPlugin.createOneKeyFilterAndApply(EditHeadActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                }
            }
            return this.bitmap;
        }

        private boolean bjO() {
            PluginPackageManager.PluginStatus bL = PluginPackageManager.lL().bL(PluginCenter.NAME_MOTUSDK);
            if (bL == PluginPackageManager.PluginStatus.NROMAL) {
                return true;
            }
            if (bL == PluginPackageManager.PluginStatus.DISABLE) {
                UtilHelper.showToast(EditHeadActivity.this.getPageContext().getPageActivity(), d.k.plugin_config_not_found);
                return false;
            } else if (bL == PluginPackageManager.PluginStatus.UNINSTALLED) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(EditHeadActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lL().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                return false;
            } else if (bL == PluginPackageManager.PluginStatus.FORBIDDEN) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && EditHeadActivity.this.fVT != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            EditHeadActivity.this.fVL.aO(false);
            EditHeadActivity.this.fVH.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            EditHeadActivity.this.fVL.aO(false);
            EditHeadActivity.this.fVH.setClickable(true);
            EditHeadActivity.this.fVH.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                EditHeadActivity.this.fWa = true;
                if (this.fWi.booleanValue() || this.fWj.booleanValue()) {
                    EditHeadActivity.this.fVF.setImageBitmap(bitmap);
                    if (EditHeadActivity.this.mBitmap.getWidth() > 1800 || EditHeadActivity.this.mBitmap.getHeight() > 1800) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.resizeBitmap(EditHeadActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_MIDDLE);
                    }
                    if (this.fWi.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.rotateBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.fWj.booleanValue()) {
                        EditHeadActivity.this.mBitmap = BitmapHelper.reversalBitmap(EditHeadActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                } else {
                    EditHeadActivity.this.fVF.i(bitmap);
                }
                if (EditHeadActivity.this.fVT != null && !EditHeadActivity.this.fVT.isRecycled()) {
                    EditHeadActivity.this.fVT.recycle();
                }
                EditHeadActivity.this.fVT = bitmap;
            }
        }
    }

    private void aFR() {
        this.fVU = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.fVU, intentFilter);
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
            if (EditHeadActivity.this.fVH != null) {
                EditHeadActivity.this.fVH.setEnabled(false);
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
                str = this.mNetwork.eD(TbConfig.PERSON_HEAD_FILE);
            } catch (Exception e2) {
                str = null;
                e = e2;
            }
            try {
                if (this.mNetwork.yX().zY().isRequestSuccess()) {
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
            EditHeadActivity.this.fVS = null;
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
                if (this.mNetwork.yX().zY().isRequestSuccess()) {
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
