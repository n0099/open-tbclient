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
    private static String[] fte = null;
    private HashMap<String, Bitmap> ftB;
    private HashMap<String, ImageView> ftC;
    private View ftD;
    private RadioButton fto;
    private RadioButton ftp;
    private LinearLayout ftz;
    private View hjr;
    private View hjs;
    private String hjw;
    private int requestCode;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private TextView czV = null;
    private View bep = null;
    private HorizontalScrollView ftl = null;
    private ProgressBar mProgress = null;
    private b hjt = null;
    private a hju = null;
    private RadioGroup bJH = null;
    private LinearLayout ftq = null;
    private LinearLayout ftr = null;
    private TextView mTitleText = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap ftt = null;
    private c hjv = null;
    private int ftv = 0;
    private int ftw = 0;
    private int mDisplaySize = 0;
    private boolean ftx = true;
    private String fty = null;
    private boolean ftA = false;
    private boolean eXc = false;
    private final Handler mHandler = new Handler();
    private final Object hjx = new Object();
    private final View.OnClickListener hjy = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.eXc) {
                if (WriteImageActivity.this.requestCode == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                        if (WriteImageActivity.this.ftA && WriteImageActivity.this.ftt != null && !WriteImageActivity.this.ftt.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            if (WriteImageActivity.this.uW(str)) {
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
        if (com.baidu.adp.lib.b.d.eV().af("motu_sdk") == 1 || PluginPackageManager.js().bs(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.ftx = false;
        } else {
            this.ftx = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(d.h.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.hjw = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.ftx) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.eXc = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), an.vv().vB(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, an.vv().vB(), this.mDisplaySize, stringExtra);
            }
            awC();
        } else {
            initUI();
            initData();
        }
        fte = getResources().getStringArray(d.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.hjt != null) {
            this.hjt.cancel();
        }
        this.mImage.setImageDrawable(null);
        bar();
    }

    private void bar() {
        synchronized (this.hjx) {
            if (this.ftC != null) {
                for (Map.Entry<String, ImageView> entry : this.ftC.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.ftC.clear();
                this.ftC = null;
            }
            if (this.ftB != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.ftB.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.ftB.clear();
                this.ftB = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.hjt != null) {
            this.hjt.cancel();
        }
        this.hjt = new b();
        this.hjt.execute(new Object[0]);
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
        if (this.ftt != null && !this.ftt.isRecycled()) {
            this.ftt.recycle();
            this.ftt = null;
        }
        if (this.hjt != null) {
            this.hjt.cancel();
            this.hjt = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.hjv);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.hjy.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.bep);
        aj.k(this.mNavigationBar, d.C0082d.common_color_10222);
        aj.c(this.mTitleText, d.C0082d.cp_cont_g, 1);
        if (this.hjs.isEnabled()) {
            this.czV.setTextColor(getResources().getColor(d.C0082d.navi_done_text));
        } else {
            this.czV.setTextColor(getResources().getColor(d.C0082d.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        aj.a((ImageView) ((ViewGroup) this.hjr).getChildAt(0), d.f.icon_topbar_return_s, d.f.icon_topbar_return_s);
    }

    private void initUI() {
        this.bep = findViewById(d.g.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.mProgress.setVisibility(8);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mNavigationBar.getVisibility() == 0) {
                    WriteImageActivity.this.mNavigationBar.setVisibility(8);
                    WriteImageActivity.this.ftr.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mNavigationBar.setVisibility(0);
                WriteImageActivity.this.ftr.setVisibility(0);
            }
        });
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.ftl = (HorizontalScrollView) findViewById(d.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.hjr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.eXc) {
                    if (WriteImageActivity.this.requestCode == 12003) {
                        Intent intent = new Intent();
                        if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                            if (WriteImageActivity.this.ftA && WriteImageActivity.this.ftt != null && !WriteImageActivity.this.ftt.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.uW(str)) {
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
        this.hjs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, (View.OnClickListener) null);
        this.hjs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.eXc) {
                    if (WriteImageActivity.this.requestCode == 12003) {
                        Intent intent = new Intent();
                        intent.putExtra(WriteImageActivityConfig.DELET_FLAG, true);
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        if (WriteImageActivity.this.ftA) {
                            if (WriteImageActivity.this.ftt != null && !WriteImageActivity.this.ftt.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.uW(str)) {
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
                if (WriteImageActivity.this.ftA && WriteImageActivity.this.ftt != null && !WriteImageActivity.this.ftt.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    if (WriteImageActivity.this.uW(str2)) {
                        intent3.putExtra("filename", str2);
                    }
                }
                WriteImageActivity.this.setResult(-1, intent3);
                WriteImageActivity.this.finish();
            }
        });
        this.czV = (TextView) this.hjs.findViewById(d.g.save);
        if (TextUtils.isEmpty(this.hjw)) {
            if (this.eXc || this.requestCode != 12003) {
                this.czV.setText(getPageContext().getString(d.j.done));
            } else {
                this.czV.setText(getPageContext().getString(d.j.delete));
            }
        } else {
            this.czV.setText(this.hjw);
        }
        this.ftz = (LinearLayout) findViewById(d.g.filters);
        this.ftv = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.mTitleText = this.mNavigationBar.setTitleText(getPageContext().getString(d.j.beautify));
        this.ftr = (LinearLayout) findViewById(d.g.beautify_rotate);
        this.ftq = (LinearLayout) findViewById(d.g.rotate);
        this.fto = (RadioButton) findViewById(d.g.beautify_btn);
        this.ftp = (RadioButton) findViewById(d.g.rotate_btn);
        this.bJH = (RadioGroup) findViewById(d.g.beautify_tabs);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == WriteImageActivity.this.fto) {
                        WriteImageActivity.this.ftl.setVisibility(0);
                        WriteImageActivity.this.ftq.setVisibility(8);
                        WriteImageActivity.this.mTitleText.setText(WriteImageActivity.this.getPageContext().getString(d.j.beautify));
                    } else if (compoundButton == WriteImageActivity.this.ftp) {
                        WriteImageActivity.this.ftl.setVisibility(8);
                        WriteImageActivity.this.ftq.setVisibility(0);
                        WriteImageActivity.this.mTitleText.setText(WriteImageActivity.this.getPageContext().getString(d.j.rotate));
                    }
                }
            }
        };
        this.fto.setOnCheckedChangeListener(onCheckedChangeListener);
        this.ftp.setOnCheckedChangeListener(onCheckedChangeListener);
        this.fto.setChecked(true);
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
                    if ((WriteImageActivity.this.mBitmap != null || WriteImageActivity.this.ftt != null) && view.getTag() != null) {
                        WriteImageActivity.this.ftA = false;
                        WriteImageActivity.this.uV(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.ftr.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.ftx) {
            this.ftp.setPadding(0, this.ftp.getPaddingTop(), this.ftp.getPaddingRight(), this.ftp.getPaddingBottom());
            this.ftp.setChecked(true);
            this.ftl.setVisibility(8);
            this.fto.setVisibility(8);
            this.bJH.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uV(String str) {
        if (this.hju != null) {
            this.hju.cancel();
        }
        this.hju = new a();
        this.hju.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
                Bitmap X = k.X(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && X != null && !X.isRecycled()) {
                        X.recycle();
                        return null;
                    }
                    if (X != null) {
                        int dip2px = l.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.ftx) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(X, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(X)) {
                                    X = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(X, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.hjx) {
                                        WriteImageActivity.this.ftB = new HashMap();
                                        WriteImageActivity.this.ftC = new HashMap();
                                        WriteImageActivity.this.ftB.put("normal", roundedCornerBitmap);
                                    }
                                    return X;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                    return X;
                } catch (Exception e) {
                    bitmap = X;
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
            WriteImageActivity.this.hjs.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.hjt = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.hjs.setEnabled(true);
            WriteImageActivity.this.hjt = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.ftx) {
                    WriteImageActivity.this.A(WriteImageActivity.fte);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uW(String str) {
        try {
            k.a(TbConfig.LOCAL_PIC_DIR, str, this.ftt, 90);
            this.mImage.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.ftt, i);
            if (resizeBitmap != null && k.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.ftw));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String[] strArr) {
        if (this.ftB != null && strArr != null) {
            this.ftz.removeAllViews();
            this.ftr.setVisibility(0);
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
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.a.fk(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                                WriteImageActivity.this.mImage.setImageBitmap(WriteImageActivity.this.mBitmap);
                                WriteImageActivity.this.ftA = false;
                                WriteImageActivity.this.qt(substring);
                                WriteImageActivity.this.ftw = i2;
                            }
                        }
                    });
                    this.ftD = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (WriteImageActivity.this.mProgress.getVisibility() != 0 && !substring.equals(WriteImageActivity.this.fty)) {
                                WriteImageActivity.this.uV(substring);
                                WriteImageActivity.this.qt(substring);
                                WriteImageActivity.this.ftw = i2;
                            }
                        }
                    });
                }
                this.ftz.addView(inflate2);
                synchronized (this.hjx) {
                    this.ftC.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            qt("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qt(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.fty != null && (imageView = this.ftC.get(this.fty)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.ftv, this.ftv, this.ftv, this.ftv);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.ftC != null) {
                ImageView imageView2 = this.ftC.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(d.f.bg_choose_filter);
                    imageView2.setPadding(this.ftv, this.ftv, this.ftv, this.ftv);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.fty = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean ftI;
        private Boolean ftJ;
        private String mLabel;

        private a() {
            this.ftI = false;
            this.ftJ = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.ftx) {
                PluginPackageManager.PluginStatus bs = PluginPackageManager.js().bs(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bs != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bs == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WriteImageActivity.this.qt("normal");
                            }
                        }, 500L);
                        WriteImageActivity.this.showToast(d.j.plugin_config_not_found);
                        return;
                    } else if (bs == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.js().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.2
                            @Override // java.lang.Runnable
                            public void run() {
                                WriteImageActivity.this.qt("normal");
                            }
                        }, 500L);
                        cancel();
                        return;
                    } else if (bs == PluginPackageManager.PluginStatus.FORBIDDEN) {
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
                                WriteImageActivity.this.qt("normal");
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
            WriteImageActivity.this.hjs.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.ftt == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.ftI = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals("3")) {
                this.ftJ = true;
            }
            if (this.ftI.booleanValue() || this.ftJ.booleanValue()) {
                if (WriteImageActivity.this.ftt == null || WriteImageActivity.this.ftt.isRecycled()) {
                    if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                        this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                    }
                } else {
                    this.bitmap = WriteImageActivity.this.ftt.copy(WriteImageActivity.this.ftt.getConfig(), true);
                }
            } else if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 2000 || this.bitmap.getHeight() > 2000) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, 2000);
                }
                if (this.ftI.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.ftJ.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.ftt != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.hjs.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.hjs.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.ftA = true;
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.ftI.booleanValue() || this.ftJ.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 2000 || WriteImageActivity.this.mBitmap.getHeight() > 2000) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, 2000);
                    }
                    if (this.ftI.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.ftJ.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.ftt != null && !WriteImageActivity.this.ftt.isRecycled()) {
                    WriteImageActivity.this.ftt.recycle();
                }
                WriteImageActivity.this.ftt = bitmap;
            }
        }
    }

    private void awC() {
        this.hjv = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.hjv, intentFilter);
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
            if (WriteImageActivity.this.hjs != null) {
                WriteImageActivity.this.hjs.setEnabled(false);
            }
        }
    }
}
