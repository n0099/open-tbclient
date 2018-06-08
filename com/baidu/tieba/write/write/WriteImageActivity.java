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
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.FiltersView;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tieba.d;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] fRB = null;
    private int ese;
    private RadioButton fRM;
    private RadioButton fRN;
    private LinearLayout fRX;
    private HashMap<String, Bitmap> fRZ;
    private HashMap<String, ImageView> fSa;
    private View fSb;
    private View huU;
    private View huV;
    private String huZ;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private TextView bkD = null;
    private View mParent = null;
    private HorizontalScrollView fRI = null;
    private ProgressBar mProgress = null;
    private b huW = null;
    private a huX = null;
    private RadioGroup cby = null;
    private LinearLayout fRO = null;
    private LinearLayout fRP = null;
    private TextView mTitleText = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap fRR = null;
    private c huY = null;
    private int fRT = 0;
    private int fRU = 0;
    private int mDisplaySize = 0;
    private boolean fRV = true;
    private String fRW = null;
    private boolean fRY = false;
    private boolean fwH = false;
    private final Handler mHandler = new Handler();
    private final Object hva = new Object();
    private final View.OnClickListener hvb = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.fwH) {
                if (WriteImageActivity.this.ese == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                        if (WriteImageActivity.this.fRY && WriteImageActivity.this.fRR != null && !WriteImageActivity.this.fRR.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            if (WriteImageActivity.this.vW(str)) {
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
        if (com.baidu.adp.lib.b.d.hv().aw("motu_sdk") == 1 || PluginPackageManager.lL().bJ(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fRV = false;
        } else {
            this.fRV = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(d.i.write_image_activity);
        Intent intent = getIntent();
        this.ese = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.huZ = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.fRV) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.fwH = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.ese == 12002 || this.ese == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.ese, intent.getData(), aq.zq().zw(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.ese, null, aq.zq().zw(), this.mDisplaySize, stringExtra);
            }
            aFj();
        } else {
            initUI();
            initData();
        }
        fRB = getResources().getStringArray(d.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.huW != null) {
            this.huW.cancel();
        }
        this.mImage.setImageDrawable(null);
        bjf();
    }

    private void bjf() {
        synchronized (this.hva) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.huW != null) {
            this.huW.cancel();
        }
        this.huW = new b();
        this.huW.execute(new Object[0]);
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
        if (this.fRR != null && !this.fRR.isRecycled()) {
            this.fRR.recycle();
            this.fRR = null;
        }
        if (this.huW != null) {
            this.huW.cancel();
            this.huW = null;
        }
        this.mProgress.setVisibility(8);
        if (this.ese == 12002 || this.ese == 12001) {
            unregisterReceiver(this.huY);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.hvb.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mParent);
        al.j(this.mNavigationBar, d.C0141d.common_color_10222);
        al.c(this.mTitleText, d.C0141d.cp_cont_g, 1);
        if (this.huV.isEnabled()) {
            this.bkD.setTextColor(getResources().getColor(d.C0141d.navi_done_text));
        } else {
            this.bkD.setTextColor(getResources().getColor(d.C0141d.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        al.a((ImageView) ((ViewGroup) this.huU).getChildAt(0), d.f.icon_topbar_return_s, d.f.icon_topbar_return_s);
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
                    WriteImageActivity.this.fRP.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mNavigationBar.setVisibility(0);
                WriteImageActivity.this.fRP.setVisibility(0);
            }
        });
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.fRI = (HorizontalScrollView) findViewById(d.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.huU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.fwH) {
                    if (WriteImageActivity.this.ese == 12003) {
                        Intent intent = new Intent();
                        if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                            if (WriteImageActivity.this.fRY && WriteImageActivity.this.fRR != null && !WriteImageActivity.this.fRR.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.vW(str)) {
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
        this.huV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.image_activity_save_button, (View.OnClickListener) null);
        this.huV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.fwH) {
                    if (WriteImageActivity.this.ese == 12003) {
                        Intent intent = new Intent();
                        intent.putExtra(WriteImageActivityConfig.DELET_FLAG, true);
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        if (WriteImageActivity.this.fRY) {
                            if (WriteImageActivity.this.fRR != null && !WriteImageActivity.this.fRR.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.vW(str)) {
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
                if (WriteImageActivity.this.fRY && WriteImageActivity.this.fRR != null && !WriteImageActivity.this.fRR.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    if (WriteImageActivity.this.vW(str2)) {
                        intent3.putExtra("filename", str2);
                    }
                }
                WriteImageActivity.this.setResult(-1, intent3);
                WriteImageActivity.this.finish();
            }
        });
        this.bkD = (TextView) this.huV.findViewById(d.g.save);
        if (TextUtils.isEmpty(this.huZ)) {
            if (this.fwH || this.ese != 12003) {
                this.bkD.setText(getPageContext().getString(d.k.done));
            } else {
                this.bkD.setText(getPageContext().getString(d.k.delete));
            }
        } else {
            this.bkD.setText(this.huZ);
        }
        this.fRX = (LinearLayout) findViewById(d.g.filters);
        this.fRT = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.mTitleText = this.mNavigationBar.setTitleText(getPageContext().getString(d.k.beautify));
        this.fRP = (LinearLayout) findViewById(d.g.beautify_rotate);
        this.fRO = (LinearLayout) findViewById(d.g.rotate);
        this.fRM = (RadioButton) findViewById(d.g.beautify_btn);
        this.fRN = (RadioButton) findViewById(d.g.rotate_btn);
        this.cby = (RadioGroup) findViewById(d.g.beautify_tabs);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == WriteImageActivity.this.fRM) {
                        WriteImageActivity.this.fRI.setVisibility(0);
                        WriteImageActivity.this.fRO.setVisibility(8);
                        WriteImageActivity.this.mTitleText.setText(WriteImageActivity.this.getPageContext().getString(d.k.beautify));
                    } else if (compoundButton == WriteImageActivity.this.fRN) {
                        WriteImageActivity.this.fRI.setVisibility(8);
                        WriteImageActivity.this.fRO.setVisibility(0);
                        WriteImageActivity.this.mTitleText.setText(WriteImageActivity.this.getPageContext().getString(d.k.rotate));
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
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                    if ((WriteImageActivity.this.mBitmap != null || WriteImageActivity.this.fRR != null) && view.getTag() != null) {
                        WriteImageActivity.this.fRY = false;
                        WriteImageActivity.this.vV(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.fRP.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.fRV) {
            this.fRN.setPadding(0, this.fRN.getPaddingTop(), this.fRN.getPaddingRight(), this.fRN.getPaddingBottom());
            this.fRN.setChecked(true);
            this.fRI.setVisibility(8);
            this.fRM.setVisibility(8);
            this.cby.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV(String str) {
        if (this.huX != null) {
            this.huX.cancel();
        }
        this.huX = new a();
        this.huX.execute(str);
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
                Bitmap ab = com.baidu.tbadk.core.util.l.ab(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && ab != null && !ab.isRecycled()) {
                        ab.recycle();
                        return null;
                    }
                    if (ab != null) {
                        int dip2px = l.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.fRV) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(ab, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(ab)) {
                                    ab = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(ab, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, l.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.hva) {
                                        WriteImageActivity.this.fRZ = new HashMap();
                                        WriteImageActivity.this.fSa = new HashMap();
                                        WriteImageActivity.this.fRZ.put("normal", roundedCornerBitmap);
                                    }
                                    return ab;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                    return ab;
                } catch (Exception e) {
                    bitmap = ab;
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
            WriteImageActivity.this.huV.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.huW = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.huV.setEnabled(true);
            WriteImageActivity.this.huW = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.fRV) {
                    WriteImageActivity.this.z(WriteImageActivity.fRB);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vW(String str) {
        try {
            com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_PIC_DIR, str, this.fRR, 90);
            this.mImage.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.fRR, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.l.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.fRU));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String[] strArr) {
        if (this.fRZ != null && strArr != null) {
            this.fRX.removeAllViews();
            this.fRP.setVisibility(0);
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
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                                WriteImageActivity.this.mImage.setImageBitmap(WriteImageActivity.this.mBitmap);
                                WriteImageActivity.this.fRY = false;
                                WriteImageActivity.this.rU(substring);
                                WriteImageActivity.this.fRU = i2;
                            }
                        }
                    });
                    this.fSb = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (WriteImageActivity.this.mProgress.getVisibility() != 0 && !substring.equals(WriteImageActivity.this.fRW)) {
                                WriteImageActivity.this.vV(substring);
                                WriteImageActivity.this.rU(substring);
                                WriteImageActivity.this.fRU = i2;
                            }
                        }
                    });
                }
                this.fRX.addView(inflate2);
                synchronized (this.hva) {
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
            if (this.fRW != null && (imageView = this.fSa.get(this.fRW)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.fRT, this.fRT, this.fRT, this.fRT);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.fSa != null) {
                ImageView imageView2 = this.fSa.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(d.f.bg_choose_filter);
                    imageView2.setPadding(this.fRT, this.fRT, this.fRT, this.fRT);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.fRW = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean fSg;
        private Boolean fSh;
        private String mLabel;

        private a() {
            this.fSg = false;
            this.fSh = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.fRV) {
                PluginPackageManager.PluginStatus bJ = PluginPackageManager.lL().bJ(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bJ != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bJ == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WriteImageActivity.this.rU("normal");
                            }
                        }, 500L);
                        WriteImageActivity.this.showToast(d.k.plugin_config_not_found);
                        return;
                    } else if (bJ == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.lL().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.2
                            @Override // java.lang.Runnable
                            public void run() {
                                WriteImageActivity.this.rU("normal");
                            }
                        }, 500L);
                        cancel();
                        return;
                    } else if (bJ == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.d.a.a(WriteImageActivity.this.getPageContext(), d.k.plugin_muto_not_install, new a.b() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginCenter.NAME_MOTUSDK)));
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
                                WriteImageActivity.this.rU("normal");
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
            WriteImageActivity.this.huV.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.fRR == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.fSg = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals("3")) {
                this.fSh = true;
            }
            if (this.fSg.booleanValue() || this.fSh.booleanValue()) {
                if (WriteImageActivity.this.fRR == null || WriteImageActivity.this.fRR.isRecycled()) {
                    if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                        this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                    }
                } else {
                    this.bitmap = WriteImageActivity.this.fRR.copy(WriteImageActivity.this.fRR.getConfig(), true);
                }
            } else if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 2000 || this.bitmap.getHeight() > 2000) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, 2000);
                }
                if (this.fSg.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.fSh.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.fRR != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.huV.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.huV.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.fRY = true;
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.fSg.booleanValue() || this.fSh.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 2000 || WriteImageActivity.this.mBitmap.getHeight() > 2000) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, 2000);
                    }
                    if (this.fSg.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.fSh.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.fRR != null && !WriteImageActivity.this.fRR.isRecycled()) {
                    WriteImageActivity.this.fRR.recycle();
                }
                WriteImageActivity.this.fRR = bitmap;
            }
        }
    }

    private void aFj() {
        this.huY = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.huY, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
            if (WriteImageActivity.this.huV != null) {
                WriteImageActivity.this.huV.setEnabled(false);
            }
        }
    }
}
