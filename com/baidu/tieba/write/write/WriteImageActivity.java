package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tieba.d;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] giU = null;
    private RadioButton gjf;
    private RadioButton gjg;
    private LinearLayout gjq;
    private HashMap<String, Bitmap> gjs;
    private HashMap<String, ImageView> gjt;
    private View gju;
    private String hKD;
    private View hKy;
    private View hKz;
    private int requestCode;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private TextView dtE = null;
    private View mParent = null;
    private HorizontalScrollView gjb = null;
    private ProgressBar mProgress = null;
    private b hKA = null;
    private a hKB = null;
    private RadioGroup cyR = null;
    private LinearLayout gjh = null;
    private LinearLayout gji = null;
    private TextView mTitleText = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap gjk = null;
    private c hKC = null;
    private int gjm = 0;
    private int gjn = 0;
    private int mDisplaySize = 0;
    private boolean gjo = true;
    private String gjp = null;
    private boolean gjr = false;
    private boolean fMW = false;
    private final Handler mHandler = new Handler();
    private final Object hKE = new Object();
    private final View.OnClickListener hKF = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.fMW) {
                if (WriteImageActivity.this.requestCode == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                        if (WriteImageActivity.this.gjr && WriteImageActivity.this.gjk != null && !WriteImageActivity.this.gjk.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            if (WriteImageActivity.this.uK(str)) {
                                intent.putExtra("change", true);
                                intent.putExtra("file_name", str);
                            } else {
                                intent.putExtra("change", false);
                            }
                        } else {
                            intent.putExtra("change", false);
                        }
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        return;
                    }
                } else {
                    WriteImageActivity.this.setResult(0, new Intent());
                }
            } else {
                WriteImageActivity.this.setResult(0, new Intent());
            }
            WriteImageActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        if (com.baidu.adp.lib.b.d.mA().an("motu_sdk") == 1 || PluginPackageManager.qS().bA(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.gjo = false;
        } else {
            this.gjo = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(d.h.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.hKD = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.gjo) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.fMW = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), an.CK().CQ(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, an.CK().CQ(), this.mDisplaySize, stringExtra);
            }
            aDW();
        } else {
            initUI();
            initData();
        }
        giU = getResources().getStringArray(d.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.hKA != null) {
            this.hKA.cancel();
        }
        this.mImage.setImageDrawable(null);
        bhU();
    }

    private void bhU() {
        synchronized (this.hKE) {
            if (this.gjt != null) {
                for (Map.Entry<String, ImageView> entry : this.gjt.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.gjt.clear();
                this.gjt = null;
            }
            if (this.gjs != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.gjs.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.gjs.clear();
                this.gjs = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.hKA != null) {
            this.hKA.cancel();
        }
        this.hKA = new b();
        this.hKA.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        WriteImageActivityConfig.isActivityInStack = false;
        TiebaPrepareImageService.StopService();
        releaseResouce();
        super.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.gjk != null && !this.gjk.isRecycled()) {
            this.gjk.recycle();
            this.gjk = null;
        }
        if (this.hKA != null) {
            this.hKA.cancel();
            this.hKA = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.hKC);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.hKF.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().aN(i == 1);
        getLayoutMode().aM(this.mParent);
        aj.t(this.mNavigationBar, d.C0108d.common_color_10222);
        aj.e(this.mTitleText, d.C0108d.cp_cont_g, 1);
        if (this.hKz.isEnabled()) {
            this.dtE.setTextColor(getResources().getColor(d.C0108d.navi_done_text));
        } else {
            this.dtE.setTextColor(getResources().getColor(d.C0108d.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        aj.a((ImageView) ((ViewGroup) this.hKy).getChildAt(0), d.f.icon_topbar_return_s, d.f.icon_topbar_return_s);
    }

    private void initUI() {
        this.mParent = findViewById(d.g.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.mProgress.setVisibility(8);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mNavigationBar.getVisibility() == 0) {
                    WriteImageActivity.this.mNavigationBar.setVisibility(8);
                    WriteImageActivity.this.gji.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mNavigationBar.setVisibility(0);
                WriteImageActivity.this.gji.setVisibility(0);
            }
        });
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.gjb = (HorizontalScrollView) findViewById(d.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.hKy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.fMW) {
                    if (WriteImageActivity.this.requestCode == 12003) {
                        Intent intent = new Intent();
                        if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                            if (WriteImageActivity.this.gjr && WriteImageActivity.this.gjk != null && !WriteImageActivity.this.gjk.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.uK(str)) {
                                    intent.putExtra("change", true);
                                    intent.putExtra("file_name", str);
                                } else {
                                    intent.putExtra("change", false);
                                }
                            } else {
                                intent.putExtra("change", false);
                            }
                            WriteImageActivity.this.setResult(-1, intent);
                        } else {
                            return;
                        }
                    } else {
                        WriteImageActivity.this.setResult(0, new Intent());
                    }
                } else {
                    WriteImageActivity.this.setResult(0, new Intent());
                }
                WriteImageActivity.this.finish();
            }
        });
        this.hKz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, (View.OnClickListener) null);
        this.hKz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.fMW) {
                    if (WriteImageActivity.this.requestCode == 12003) {
                        Intent intent = new Intent();
                        intent.putExtra(WriteImageActivityConfig.DELET_FLAG, true);
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        if (WriteImageActivity.this.gjr) {
                            if (WriteImageActivity.this.gjk != null && !WriteImageActivity.this.gjk.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.uK(str)) {
                                    intent2.putExtra("change", true);
                                    intent2.putExtra("file_name", str);
                                } else {
                                    intent2.putExtra("change", false);
                                }
                            } else {
                                intent2.putExtra("change", false);
                            }
                        } else {
                            intent2.setData(WriteImageActivity.this.getIntent().getData());
                            WriteImageActivity.this.setResult(-1, intent2);
                        }
                        WriteImageActivity.this.setResult(-1, intent2);
                    }
                    WriteImageActivity.this.finish();
                    return;
                }
                Intent intent3 = new Intent();
                if (WriteImageActivity.this.gjr && WriteImageActivity.this.gjk != null && !WriteImageActivity.this.gjk.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    if (WriteImageActivity.this.uK(str2)) {
                        intent3.putExtra("filename", str2);
                    }
                }
                WriteImageActivity.this.setResult(-1, intent3);
                WriteImageActivity.this.finish();
            }
        });
        this.dtE = (TextView) this.hKz.findViewById(d.g.save);
        if (TextUtils.isEmpty(this.hKD)) {
            if (this.fMW || this.requestCode != 12003) {
                this.dtE.setText(getPageContext().getString(d.j.done));
            } else {
                this.dtE.setText(getPageContext().getString(d.j.delete));
            }
        } else {
            this.dtE.setText(this.hKD);
        }
        this.gjq = (LinearLayout) findViewById(d.g.filters);
        this.gjm = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.mTitleText = this.mNavigationBar.setTitleText(getPageContext().getString(d.j.beautify));
        this.gji = (LinearLayout) findViewById(d.g.beautify_rotate);
        this.gjh = (LinearLayout) findViewById(d.g.rotate);
        this.gjf = (RadioButton) findViewById(d.g.beautify_btn);
        this.gjg = (RadioButton) findViewById(d.g.rotate_btn);
        this.cyR = (RadioGroup) findViewById(d.g.beautify_tabs);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == WriteImageActivity.this.gjf) {
                        WriteImageActivity.this.gjb.setVisibility(0);
                        WriteImageActivity.this.gjh.setVisibility(8);
                        WriteImageActivity.this.mTitleText.setText(WriteImageActivity.this.getPageContext().getString(d.j.beautify));
                    } else if (compoundButton == WriteImageActivity.this.gjg) {
                        WriteImageActivity.this.gjb.setVisibility(8);
                        WriteImageActivity.this.gjh.setVisibility(0);
                        WriteImageActivity.this.mTitleText.setText(WriteImageActivity.this.getPageContext().getString(d.j.rotate));
                    }
                }
            }
        };
        this.gjf.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gjg.setOnCheckedChangeListener(onCheckedChangeListener);
        this.gjf.setChecked(true);
        Button button = (Button) findViewById(d.g.rotate_left);
        Button button2 = (Button) findViewById(d.g.rotate_right);
        Button button3 = (Button) findViewById(d.g.rotate_left_right);
        Button button4 = (Button) findViewById(d.g.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                    if ((WriteImageActivity.this.mBitmap != null || WriteImageActivity.this.gjk != null) && view.getTag() != null) {
                        WriteImageActivity.this.gjr = false;
                        WriteImageActivity.this.uJ(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.gji.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.gjo) {
            this.gjg.setPadding(0, this.gjg.getPaddingTop(), this.gjg.getPaddingRight(), this.gjg.getPaddingBottom());
            this.gjg.setChecked(true);
            this.gjb.setVisibility(8);
            this.gjf.setVisibility(8);
            this.cyR.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uJ(String str) {
        if (this.hKB != null) {
            this.hKB.cancel();
        }
        this.hKB = new a();
        this.hKB.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
                Bitmap W = k.W(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && W != null && !W.isRecycled()) {
                        W.recycle();
                        return null;
                    }
                    if (W != null) {
                        int dip2px = l.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.gjo) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(W, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(W)) {
                                    W = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(W, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.hKE) {
                                        WriteImageActivity.this.gjs = new HashMap();
                                        WriteImageActivity.this.gjt = new HashMap();
                                        WriteImageActivity.this.gjs.put("normal", roundedCornerBitmap);
                                    }
                                    return W;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                    return W;
                } catch (Exception e) {
                    bitmap = W;
                    e = e;
                    e.printStackTrace();
                    BdLog.e(e.toString());
                    return bitmap;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.hKz.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.hKA = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.hKz.setEnabled(true);
            WriteImageActivity.this.hKA = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.gjo) {
                    WriteImageActivity.this.z(WriteImageActivity.giU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uK(String str) {
        try {
            k.a(TbConfig.LOCAL_PIC_DIR, str, this.gjk, 90);
            this.mImage.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.gjk, i);
            if (resizeBitmap != null && k.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.gjn));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String[] strArr) {
        if (this.gjs != null && strArr != null) {
            this.gjq.removeAllViews();
            this.gji.setVisibility(0);
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.a.fy(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                                WriteImageActivity.this.mImage.setImageBitmap(WriteImageActivity.this.mBitmap);
                                WriteImageActivity.this.gjr = false;
                                WriteImageActivity.this.qP(substring);
                                WriteImageActivity.this.gjn = i2;
                            }
                        }
                    });
                    this.gju = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (WriteImageActivity.this.mProgress.getVisibility() != 0 && !substring.equals(WriteImageActivity.this.gjp)) {
                                WriteImageActivity.this.uJ(substring);
                                WriteImageActivity.this.qP(substring);
                                WriteImageActivity.this.gjn = i2;
                            }
                        }
                    });
                }
                this.gjq.addView(inflate2);
                synchronized (this.hKE) {
                    this.gjt.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            qP("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qP(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.gjp != null && (imageView = this.gjt.get(this.gjp)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.gjm, this.gjm, this.gjm, this.gjm);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.gjt != null) {
                ImageView imageView2 = this.gjt.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(d.f.bg_choose_filter);
                    imageView2.setPadding(this.gjm, this.gjm, this.gjm, this.gjm);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.gjp = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean gjA;
        private Boolean gjz;
        private String mLabel;

        private a() {
            this.gjz = false;
            this.gjA = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.gjo) {
                PluginPackageManager.PluginStatus bA = PluginPackageManager.qS().bA(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bA != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bA == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WriteImageActivity.this.qP("normal");
                            }
                        }, 500L);
                        WriteImageActivity.this.showToast(d.j.plugin_config_not_found);
                        return;
                    } else if (bA == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.qS().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.2
                            @Override // java.lang.Runnable
                            public void run() {
                                WriteImageActivity.this.qP("normal");
                            }
                        }, 500L);
                        cancel();
                        return;
                    } else if (bA == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.d.a.a(WriteImageActivity.this.getPageContext(), d.j.plugin_muto_not_install, new a.b() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginCenter.NAME_MOTUSDK)));
                                aVar.dismiss();
                            }
                        }, new a.b() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        });
                        WriteImageActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.5
                            @Override // java.lang.Runnable
                            public void run() {
                                WriteImageActivity.this.qP("normal");
                            }
                        }, 500L);
                        cancel();
                        return;
                    }
                } else {
                    return;
                }
            }
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.hKz.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.gjk == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.gjz = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals("3")) {
                this.gjA = true;
            }
            if (this.gjz.booleanValue() || this.gjA.booleanValue()) {
                if (WriteImageActivity.this.gjk == null || WriteImageActivity.this.gjk.isRecycled()) {
                    if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                        this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                    }
                } else {
                    this.bitmap = WriteImageActivity.this.gjk.copy(WriteImageActivity.this.gjk.getConfig(), true);
                }
            } else if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 2000 || this.bitmap.getHeight() > 2000) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, 2000);
                }
                if (this.gjz.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.gjA.booleanValue()) {
                    this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else {
                    MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
                    if (motuPlugin != null) {
                        this.bitmap = motuPlugin.createOneKeyFilterAndApply(WriteImageActivity.this.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
                    }
                }
                return this.bitmap;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.gjk != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.hKz.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.hKz.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.gjr = true;
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.gjz.booleanValue() || this.gjA.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 2000 || WriteImageActivity.this.mBitmap.getHeight() > 2000) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, 2000);
                    }
                    if (this.gjz.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.gjA.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.gjk != null && !WriteImageActivity.this.gjk.isRecycled()) {
                    WriteImageActivity.this.gjk.recycle();
                }
                WriteImageActivity.this.gjk = bitmap;
            }
        }
    }

    private void aDW() {
        this.hKC = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.hKC, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WriteImageActivity.this.releaseResouce();
            if (intent.getBooleanExtra("result", false)) {
                WriteImageActivity.this.initData();
                return;
            }
            WriteImageActivity.this.showToast(intent.getStringExtra("error"));
            if (WriteImageActivity.this.hKz != null) {
                WriteImageActivity.this.hKz.setEnabled(false);
            }
        }
    }
}
