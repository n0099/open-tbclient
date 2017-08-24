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
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tieba.d;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private static String[] fhl = null;
    private LinearLayout fhG;
    private HashMap<String, Bitmap> fhI;
    private HashMap<String, ImageView> fhJ;
    private View fhK;
    private RadioButton fhv;
    private RadioButton fhw;
    private View gIT;
    private View gIU;
    private String gIY;
    private int requestCode;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private TextView cfu = null;
    private View aZi = null;
    private HorizontalScrollView fhs = null;
    private ProgressBar mProgress = null;
    private b gIV = null;
    private a gIW = null;
    private RadioGroup eRj = null;
    private LinearLayout fhx = null;
    private LinearLayout fhy = null;
    private TextView cdX = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap fhA = null;
    private c gIX = null;
    private int fhC = 0;
    private int fhD = 0;
    private int mDisplaySize = 0;
    private boolean fhE = true;
    private String fhF = null;
    private boolean fhH = false;
    private boolean eMU = false;
    private final Handler mHandler = new Handler();
    private final Object gIZ = new Object();
    private final View.OnClickListener gJa = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.eMU) {
                if (WriteImageActivity.this.requestCode == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                        if (WriteImageActivity.this.fhH && WriteImageActivity.this.fhA != null && !WriteImageActivity.this.fhA.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            if (WriteImageActivity.this.tt(str)) {
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
        if (com.baidu.adp.lib.b.d.fh().am("motu_sdk") == 1 || PluginPackageManager.jE().bw(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.fhE = false;
        } else {
            this.fhE = true;
        }
        TbadkCoreApplication.getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(d.j.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.gIY = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (this.fhE) {
            TbadkCoreApplication.getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.eMU = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), am.vR().vX(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, am.vR().vX(), this.mDisplaySize, stringExtra);
            }
            arP();
        } else {
            initUI();
            initData();
        }
        fhl = getResources().getStringArray(d.b.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.gIV != null) {
            this.gIV.cancel();
        }
        this.mImage.setImageDrawable(null);
        aXU();
    }

    private void aXU() {
        synchronized (this.gIZ) {
            if (this.fhJ != null) {
                for (Map.Entry<String, ImageView> entry : this.fhJ.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.fhJ.clear();
                this.fhJ = null;
            }
            if (this.fhI != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.fhI.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.fhI.clear();
                this.fhI = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.gIV != null) {
            this.gIV.cancel();
        }
        this.gIV = new b();
        this.gIV.execute(new Object[0]);
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
        if (this.fhA != null && !this.fhA.isRecycled()) {
            this.fhA.recycle();
            this.fhA = null;
        }
        if (this.gIV != null) {
            this.gIV.cancel();
            this.gIV = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.gIX);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.gJa.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.aZi);
        ai.k(this.mNavigationBar, d.e.common_color_10222);
        ai.c(this.cdX, d.e.cp_cont_g, 1);
        if (this.gIU.isEnabled()) {
            this.cfu.setTextColor(getResources().getColor(d.e.navi_done_text));
        } else {
            this.cfu.setTextColor(getResources().getColor(d.e.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        ai.b((ImageView) ((ViewGroup) this.gIT).getChildAt(0), d.g.icon_return_s, d.g.icon_return_s);
    }

    private void initUI() {
        this.aZi = findViewById(d.h.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.mProgress.setVisibility(8);
        this.mImage = (ImageView) findViewById(d.h.image);
        this.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mNavigationBar.getVisibility() == 0) {
                    WriteImageActivity.this.mNavigationBar.setVisibility(8);
                    WriteImageActivity.this.fhy.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mNavigationBar.setVisibility(0);
                WriteImageActivity.this.fhy.setVisibility(0);
            }
        });
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.fhs = (HorizontalScrollView) findViewById(d.h.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.gIT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.eMU) {
                    if (WriteImageActivity.this.requestCode == 12003) {
                        Intent intent = new Intent();
                        if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                            if (WriteImageActivity.this.fhH && WriteImageActivity.this.fhA != null && !WriteImageActivity.this.fhA.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.tt(str)) {
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
        this.gIU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.image_activity_save_button, (View.OnClickListener) null);
        this.gIU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.eMU) {
                    if (WriteImageActivity.this.requestCode == 12003) {
                        Intent intent = new Intent();
                        intent.putExtra(WriteImageActivityConfig.DELET_FLAG, true);
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        if (WriteImageActivity.this.fhH) {
                            if (WriteImageActivity.this.fhA != null && !WriteImageActivity.this.fhA.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.tt(str)) {
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
                if (WriteImageActivity.this.fhH && WriteImageActivity.this.fhA != null && !WriteImageActivity.this.fhA.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    if (WriteImageActivity.this.tt(str2)) {
                        intent3.putExtra("filename", str2);
                    }
                }
                WriteImageActivity.this.setResult(-1, intent3);
                WriteImageActivity.this.finish();
            }
        });
        this.cfu = (TextView) this.gIU.findViewById(d.h.save);
        if (TextUtils.isEmpty(this.gIY)) {
            if (this.eMU || this.requestCode != 12003) {
                this.cfu.setText(getPageContext().getString(d.l.done));
            } else {
                this.cfu.setText(getPageContext().getString(d.l.delete));
            }
        } else {
            this.cfu.setText(this.gIY);
        }
        this.fhG = (LinearLayout) findViewById(d.h.filters);
        this.fhC = k.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.cdX = this.mNavigationBar.setTitleText(getPageContext().getString(d.l.beautify));
        this.fhy = (LinearLayout) findViewById(d.h.beautify_rotate);
        this.fhx = (LinearLayout) findViewById(d.h.rotate);
        this.fhv = (RadioButton) findViewById(d.h.beautify_btn);
        this.fhw = (RadioButton) findViewById(d.h.rotate_btn);
        this.eRj = (RadioGroup) findViewById(d.h.beautify_tabs);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == WriteImageActivity.this.fhv) {
                        WriteImageActivity.this.fhs.setVisibility(0);
                        WriteImageActivity.this.fhx.setVisibility(8);
                        WriteImageActivity.this.cdX.setText(WriteImageActivity.this.getPageContext().getString(d.l.beautify));
                    } else if (compoundButton == WriteImageActivity.this.fhw) {
                        WriteImageActivity.this.fhs.setVisibility(8);
                        WriteImageActivity.this.fhx.setVisibility(0);
                        WriteImageActivity.this.cdX.setText(WriteImageActivity.this.getPageContext().getString(d.l.rotate));
                    }
                }
            }
        };
        this.fhv.setOnCheckedChangeListener(onCheckedChangeListener);
        this.fhw.setOnCheckedChangeListener(onCheckedChangeListener);
        this.fhv.setChecked(true);
        Button button = (Button) findViewById(d.h.rotate_left);
        Button button2 = (Button) findViewById(d.h.rotate_right);
        Button button3 = (Button) findViewById(d.h.rotate_left_right);
        Button button4 = (Button) findViewById(d.h.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                    if ((WriteImageActivity.this.mBitmap != null || WriteImageActivity.this.fhA != null) && view.getTag() != null) {
                        WriteImageActivity.this.fhH = false;
                        WriteImageActivity.this.ts(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.fhy.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.fhE) {
            this.fhw.setPadding(0, this.fhw.getPaddingTop(), this.fhw.getPaddingRight(), this.fhw.getPaddingBottom());
            this.fhw.setChecked(true);
            this.fhs.setVisibility(8);
            this.fhv.setVisibility(8);
            this.eRj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts(String str) {
        if (this.gIW != null) {
            this.gIW.cancel();
        }
        this.gIW = new a();
        this.gIW.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap = null;
            try {
                Bitmap V = com.baidu.tbadk.core.util.k.V(null, TbConfig.IMAGE_RESIZED_FILE);
                try {
                    if (isCancelled() && V != null && !V.isRecycled()) {
                        V.recycle();
                        return null;
                    }
                    if (V != null) {
                        int dip2px = k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 63.5f);
                        if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.fhE) {
                            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(V, dip2px);
                            if (resizedBitmap != null) {
                                if (resizedBitmap.equals(V)) {
                                    V = BitmapHelper.Bytes2Bitmap(BitmapHelper.Bitmap2Bytes(V, 100));
                                }
                                Bitmap roundedCornerBitmap = BitmapHelper.getRoundedCornerBitmap(resizedBitmap, k.dip2px(WriteImageActivity.this.getPageContext().getPageActivity(), 5.0f), true);
                                if (roundedCornerBitmap != null) {
                                    synchronized (WriteImageActivity.this.gIZ) {
                                        WriteImageActivity.this.fhI = new HashMap();
                                        WriteImageActivity.this.fhJ = new HashMap();
                                        WriteImageActivity.this.fhI.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, roundedCornerBitmap);
                                    }
                                    return V;
                                }
                                return null;
                            }
                            return null;
                        }
                    }
                    return V;
                } catch (Exception e) {
                    bitmap = V;
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
            WriteImageActivity.this.gIU.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.gIV = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.gIU.setEnabled(true);
            WriteImageActivity.this.gIV = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.fhE) {
                    WriteImageActivity.this.A(WriteImageActivity.fhl);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tt(String str) {
        try {
            com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_PIC_DIR, str, this.fhA, 90);
            this.mImage.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.fhA, i);
            if (resizeBitmap != null && com.baidu.tbadk.core.util.k.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 80) != null) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "motu_pic", null, 1, "st_param", String.valueOf(this.fhD));
                return true;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String[] strArr) {
        if (this.fhI != null && strArr != null) {
            this.fhG.removeAllViews();
            this.fhy.setVisibility(0);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.j.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(d.h.filter_immage);
            TextView textView = (TextView) inflate.findViewById(d.h.filter_text);
            int length = strArr.length;
            int i = 0;
            final int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                final String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.j.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(d.h.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(d.h.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.a.fj(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                                WriteImageActivity.this.mImage.setImageBitmap(WriteImageActivity.this.mBitmap);
                                WriteImageActivity.this.fhH = false;
                                WriteImageActivity.this.pW(substring);
                                WriteImageActivity.this.fhD = i2;
                            }
                        }
                    });
                    this.fhK = imageView2;
                } else {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (WriteImageActivity.this.mProgress.getVisibility() != 0 && !substring.equals(WriteImageActivity.this.fhF)) {
                                WriteImageActivity.this.ts(substring);
                                WriteImageActivity.this.pW(substring);
                                WriteImageActivity.this.fhD = i2;
                            }
                        }
                    });
                }
                this.fhG.addView(inflate2);
                synchronized (this.gIZ) {
                    this.fhJ.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            pW(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.fhF != null && (imageView = this.fhJ.get(this.fhF)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.fhC, this.fhC, this.fhC, this.fhC);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.fhJ != null) {
                ImageView imageView2 = this.fhJ.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(d.g.bg_choose_filter);
                    imageView2.setPadding(this.fhC, this.fhC, this.fhC, this.fhC);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.fhF = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean fhP;
        private Boolean fhQ;
        private String mLabel;

        private a() {
            this.fhP = false;
            this.fhQ = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (WriteImageActivity.this.fhE) {
                PluginPackageManager.PluginStatus bw = PluginPackageManager.jE().bw(PluginCenter.NAME_MOTUSDK);
                if (!PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && bw != PluginPackageManager.PluginStatus.NROMAL) {
                    if (bw == PluginPackageManager.PluginStatus.DISABLE) {
                        WriteImageActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WriteImageActivity.this.pW(WriteImageActivityConfig.FILTER_NAME_NORMAL);
                            }
                        }, 500L);
                        WriteImageActivity.this.showToast(d.l.plugin_config_not_found);
                        return;
                    } else if (bw == PluginPackageManager.PluginStatus.UNINSTALLED) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDownloadActivityConfig(WriteImageActivity.this.getPageContext().getPageActivity(), PluginPackageManager.jE().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                        WriteImageActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.2
                            @Override // java.lang.Runnable
                            public void run() {
                                WriteImageActivity.this.pW(WriteImageActivityConfig.FILTER_NAME_NORMAL);
                            }
                        }, 500L);
                        cancel();
                        return;
                    } else if (bw == PluginPackageManager.PluginStatus.FORBIDDEN) {
                        com.baidu.tbadk.coreExtra.d.a.a(WriteImageActivity.this.getPageContext(), d.l.plugin_muto_not_install, new a.b() { // from class: com.baidu.tieba.write.write.WriteImageActivity.a.3
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
                                WriteImageActivity.this.pW(WriteImageActivityConfig.FILTER_NAME_NORMAL);
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
            WriteImageActivity.this.gIU.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.mLabel = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.fhA == null) {
                return null;
            }
            if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
                this.fhP = true;
            } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                this.fhQ = true;
            }
            if (this.fhP.booleanValue() || this.fhQ.booleanValue()) {
                if (WriteImageActivity.this.fhA == null || WriteImageActivity.this.fhA.isRecycled()) {
                    if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                        this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                    }
                } else {
                    this.bitmap = WriteImageActivity.this.fhA.copy(WriteImageActivity.this.fhA.getConfig(), true);
                }
            } else if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, (int) TbConfig.POST_IMAGE_BIG);
                }
                if (this.fhP.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
                } else if (this.fhQ.booleanValue()) {
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
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.fhA != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.gIU.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.gIU.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.fhH = true;
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.fhP.booleanValue() || this.fhQ.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 900 || WriteImageActivity.this.mBitmap.getHeight() > 900) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, (int) TbConfig.POST_IMAGE_BIG);
                    }
                    if (this.fhP.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.fhQ.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.fhA != null && !WriteImageActivity.this.fhA.isRecycled()) {
                    WriteImageActivity.this.fhA.recycle();
                }
                WriteImageActivity.this.fhA = bitmap;
            }
        }
    }

    private void arP() {
        this.gIX = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.gIX, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
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
            if (WriteImageActivity.this.gIU != null) {
                WriteImageActivity.this.gIU.setEnabled(false);
            }
        }
    }
}
