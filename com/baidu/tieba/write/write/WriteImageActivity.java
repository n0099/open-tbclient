package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private int gqD;
    private RadioButton hNp;
    private RadioButton hNq;
    private HashMap<String, Bitmap> hNw;
    private HashMap<String, ImageView> hNx;
    private View juf;
    private View jug;
    private String jum;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private TextView cMK = null;
    private View mParent = null;
    private HorizontalScrollView juh = null;
    private ProgressBar mProgress = null;
    private b jui = null;
    private a juj = null;
    private RadioGroup dOu = null;
    private LinearLayout hNr = null;
    private LinearLayout hNs = null;
    private TextView eKt = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap hNu = null;
    private c juk = null;
    private int jul = 0;
    private int mDisplaySize = 0;
    private boolean hOY = false;
    private boolean hsi = false;
    private final Handler mHandler = new Handler();
    private final Object jun = new Object();
    private final View.OnClickListener juo = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.hsi) {
                if (WriteImageActivity.this.gqD == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                        if (WriteImageActivity.this.hOY && WriteImageActivity.this.hNu != null && !WriteImageActivity.this.hNu.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            if (WriteImageActivity.this.EI(str)) {
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
        TbadkCoreApplication.getInst().addRemoteActivity((BaseActivity) getPageContext().getOrignalPage());
        setContentView(d.h.write_image_activity);
        Intent intent = getIntent();
        this.gqD = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.jum = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.hsi = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.gqD == 12002 || this.gqD == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.gqD, intent.getData(), ar.adp().adv(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.gqD, null, ar.adp().adv(), this.mDisplaySize, stringExtra);
            }
            bpC();
            return;
        }
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.jui != null) {
            this.jui.cancel();
        }
        this.mImage.setImageDrawable(null);
        bQU();
    }

    private void bQU() {
        synchronized (this.jun) {
            if (this.hNx != null) {
                for (Map.Entry<String, ImageView> entry : this.hNx.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.hNx.clear();
                this.hNx = null;
            }
            if (this.hNw != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.hNw.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.hNw.clear();
                this.hNw = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.jui != null) {
            this.jui.cancel();
        }
        this.jui = new b();
        this.jui.execute(new Object[0]);
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
        if (this.hNu != null && !this.hNu.isRecycled()) {
            this.hNu.recycle();
            this.hNu = null;
        }
        if (this.jui != null) {
            this.jui.cancel();
            this.jui = null;
        }
        this.mProgress.setVisibility(8);
        if (this.gqD == 12002 || this.gqD == 12001) {
            unregisterReceiver(this.juk);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.juo.onClick(null);
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
        al.l(this.mNavigationBar, d.C0277d.common_color_10222);
        al.d(this.eKt, d.C0277d.cp_cont_g, 1);
        if (this.jug.isEnabled()) {
            this.cMK.setTextColor(getResources().getColor(d.C0277d.navi_done_text));
        } else {
            this.cMK.setTextColor(getResources().getColor(d.C0277d.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        al.a((ImageView) ((ViewGroup) this.juf).getChildAt(0), d.f.icon_topbar_return_s, d.f.icon_topbar_return_s);
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
                    WriteImageActivity.this.hNs.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mNavigationBar.setVisibility(0);
                WriteImageActivity.this.hNs.setVisibility(0);
            }
        });
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.juh = (HorizontalScrollView) findViewById(d.g.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.juf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.hsi) {
                    if (WriteImageActivity.this.gqD == 12003) {
                        Intent intent = new Intent();
                        if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                            if (WriteImageActivity.this.hOY && WriteImageActivity.this.hNu != null && !WriteImageActivity.this.hNu.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.EI(str)) {
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
        this.jug = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.image_activity_save_button, (View.OnClickListener) null);
        this.jug.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.hsi) {
                    if (WriteImageActivity.this.gqD == 12003) {
                        Intent intent = new Intent();
                        intent.putExtra(WriteImageActivityConfig.DELET_FLAG, true);
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        if (WriteImageActivity.this.hOY) {
                            if (WriteImageActivity.this.hNu != null && !WriteImageActivity.this.hNu.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.EI(str)) {
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
                if (WriteImageActivity.this.hOY && WriteImageActivity.this.hNu != null && !WriteImageActivity.this.hNu.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    if (WriteImageActivity.this.EI(str2)) {
                        intent3.putExtra("filename", str2);
                    }
                }
                WriteImageActivity.this.setResult(-1, intent3);
                WriteImageActivity.this.finish();
            }
        });
        this.cMK = (TextView) this.jug.findViewById(d.g.save);
        if (TextUtils.isEmpty(this.jum)) {
            if (this.hsi || this.gqD != 12003) {
                this.cMK.setText(getPageContext().getString(d.j.done));
            } else {
                this.cMK.setText(getPageContext().getString(d.j.delete));
            }
        } else {
            this.cMK.setText(this.jum);
        }
        this.jul = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.eKt = this.mNavigationBar.setTitleText(getPageContext().getString(d.j.beautify));
        this.hNs = (LinearLayout) findViewById(d.g.beautify_rotate);
        this.hNr = (LinearLayout) findViewById(d.g.rotate);
        this.hNp = (RadioButton) findViewById(d.g.beautify_btn);
        this.hNq = (RadioButton) findViewById(d.g.rotate_btn);
        this.dOu = (RadioGroup) findViewById(d.g.beautify_tabs);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == WriteImageActivity.this.hNp) {
                        WriteImageActivity.this.juh.setVisibility(0);
                        WriteImageActivity.this.hNr.setVisibility(8);
                        WriteImageActivity.this.eKt.setText(WriteImageActivity.this.getPageContext().getString(d.j.beautify));
                    } else if (compoundButton == WriteImageActivity.this.hNq) {
                        WriteImageActivity.this.juh.setVisibility(8);
                        WriteImageActivity.this.hNr.setVisibility(0);
                        WriteImageActivity.this.eKt.setText(WriteImageActivity.this.getPageContext().getString(d.j.rotate));
                    }
                }
            }
        };
        this.hNp.setOnCheckedChangeListener(onCheckedChangeListener);
        this.hNq.setOnCheckedChangeListener(onCheckedChangeListener);
        this.hNp.setChecked(true);
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
                    if ((WriteImageActivity.this.mBitmap != null || WriteImageActivity.this.hNu != null) && view.getTag() != null) {
                        WriteImageActivity.this.hOY = false;
                        WriteImageActivity.this.AA(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.hNs.setVisibility(0);
        this.hNq.setPadding(0, this.hNq.getPaddingTop(), this.hNq.getPaddingRight(), this.hNq.getPaddingBottom());
        this.hNq.setChecked(true);
        this.juh.setVisibility(8);
        this.hNp.setVisibility(8);
        this.dOu.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AA(String str) {
        if (this.juj != null) {
            this.juj.cancel();
        }
        this.juj = new a();
        this.juj.execute(str);
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
            Bitmap bF;
            Bitmap bitmap = null;
            try {
                bF = m.bF(null, TbConfig.IMAGE_RESIZED_FILE);
            } catch (Exception e) {
                e = e;
            }
            try {
                if (!isCancelled() || bF == null || bF.isRecycled()) {
                    return bF;
                }
                bF.recycle();
                return null;
            } catch (Exception e2) {
                bitmap = bF;
                e = e2;
                e.printStackTrace();
                BdLog.e(e.toString());
                return bitmap;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.jug.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.jui = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.jug.setEnabled(true);
            WriteImageActivity.this.jui = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean EI(String str) {
        try {
            m.a(TbConfig.LOCAL_PIC_DIR, str, this.hNu, 90);
            this.mImage.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.hNu, i);
            if (resizeBitmap != null) {
                if (m.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String hNA;
        private Boolean hNB;
        private Boolean hNC;

        private a() {
            this.hNB = false;
            this.hNC = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.jug.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.hNA = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.hNu == null) {
                return null;
            }
            if (this.hNA.equals("0") || this.hNA.equals("1")) {
                this.hNB = true;
            } else if (this.hNA.equals("2") || this.hNA.equals("3")) {
                this.hNC = true;
            }
            if (this.hNB.booleanValue() || this.hNC.booleanValue()) {
                if (WriteImageActivity.this.hNu == null || WriteImageActivity.this.hNu.isRecycled()) {
                    if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                        this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                    }
                } else {
                    this.bitmap = WriteImageActivity.this.hNu.copy(WriteImageActivity.this.hNu.getConfig(), true);
                }
            } else if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 2000 || this.bitmap.getHeight() > 2000) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, 2000);
                }
                if (this.hNB.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.hNA));
                } else if (this.hNC.booleanValue()) {
                    this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.hNA));
                }
                return this.bitmap;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.hNu != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.jug.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.jug.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.hOY = true;
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.hNB.booleanValue() || this.hNC.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 2000 || WriteImageActivity.this.mBitmap.getHeight() > 2000) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, 2000);
                    }
                    if (this.hNB.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.hNA));
                    } else if (this.hNC.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.hNA));
                    }
                }
                if (WriteImageActivity.this.hNu != null && !WriteImageActivity.this.hNu.isRecycled()) {
                    WriteImageActivity.this.hNu.recycle();
                }
                WriteImageActivity.this.hNu = bitmap;
            }
        }
    }

    private void bpC() {
        this.juk = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.juk, intentFilter);
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
            if (WriteImageActivity.this.jug != null) {
                WriteImageActivity.this.jug.setEnabled(false);
            }
        }
    }
}
