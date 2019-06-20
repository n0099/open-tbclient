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
import com.baidu.tieba.R;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private int gHH;
    private RadioButton ifA;
    private RadioButton ifB;
    private HashMap<String, Bitmap> ifH;
    private HashMap<String, ImageView> ifI;
    private View jNc;
    private View jNd;
    private String jNj;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private TextView cVa = null;
    private View mParent = null;
    private HorizontalScrollView jNe = null;
    private ProgressBar mProgress = null;
    private b jNf = null;
    private a jNg = null;
    private RadioGroup dYm = null;
    private LinearLayout ifC = null;
    private LinearLayout ifD = null;
    private TextView faq = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap ifF = null;
    private c jNh = null;
    private int jNi = 0;
    private int mDisplaySize = 0;
    private boolean ihk = false;
    private boolean hJE = false;
    private final Handler mHandler = new Handler();
    private final Object jNk = new Object();
    private final View.OnClickListener jNl = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.hJE) {
                if (WriteImageActivity.this.gHH == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                        if (WriteImageActivity.this.ihk && WriteImageActivity.this.ifF != null && !WriteImageActivity.this.ifF.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            if (WriteImageActivity.this.Gf(str)) {
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
        setContentView(R.layout.write_image_activity);
        Intent intent = getIntent();
        this.gHH = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.jNj = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.hJE = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.gHH == 12002 || this.gHH == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.gHH, intent.getData(), ar.ail().air(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.gHH, null, ar.ail().air(), this.mDisplaySize, stringExtra);
            }
            bxp();
            return;
        }
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.jNf != null) {
            this.jNf.cancel();
        }
        this.mImage.setImageDrawable(null);
        bYQ();
    }

    private void bYQ() {
        synchronized (this.jNk) {
            if (this.ifI != null) {
                for (Map.Entry<String, ImageView> entry : this.ifI.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.ifI.clear();
                this.ifI = null;
            }
            if (this.ifH != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.ifH.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.ifH.clear();
                this.ifH = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.jNf != null) {
            this.jNf.cancel();
        }
        this.jNf = new b();
        this.jNf.execute(new Object[0]);
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
        if (this.ifF != null && !this.ifF.isRecycled()) {
            this.ifF.recycle();
            this.ifF = null;
        }
        if (this.jNf != null) {
            this.jNf.cancel();
            this.jNf = null;
        }
        this.mProgress.setVisibility(8);
        if (this.gHH == 12002 || this.gHH == 12001) {
            unregisterReceiver(this.jNh);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.jNl.onClick(null);
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
        al.l(this.mNavigationBar, R.color.common_color_10222);
        al.f(this.faq, R.color.cp_cont_g, 1);
        if (this.jNd.isEnabled()) {
            this.cVa.setTextColor(getResources().getColor(R.color.navi_done_text));
        } else {
            this.cVa.setTextColor(getResources().getColor(R.color.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        al.a((ImageView) ((ViewGroup) this.jNc).getChildAt(0), (int) R.drawable.icon_topbar_return_s, (int) R.drawable.icon_topbar_return_s);
    }

    private void initUI() {
        this.mParent = findViewById(R.id.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgress.setVisibility(8);
        this.mImage = (ImageView) findViewById(R.id.image);
        this.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mNavigationBar.getVisibility() == 0) {
                    WriteImageActivity.this.mNavigationBar.setVisibility(8);
                    WriteImageActivity.this.ifD.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mNavigationBar.setVisibility(0);
                WriteImageActivity.this.ifD.setVisibility(0);
            }
        });
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.jNe = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.jNc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.hJE) {
                    if (WriteImageActivity.this.gHH == 12003) {
                        Intent intent = new Intent();
                        if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                            if (WriteImageActivity.this.ihk && WriteImageActivity.this.ifF != null && !WriteImageActivity.this.ifF.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.Gf(str)) {
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
        this.jNd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.jNd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.hJE) {
                    if (WriteImageActivity.this.gHH == 12003) {
                        Intent intent = new Intent();
                        intent.putExtra(WriteImageActivityConfig.DELET_FLAG, true);
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        if (WriteImageActivity.this.ihk) {
                            if (WriteImageActivity.this.ifF != null && !WriteImageActivity.this.ifF.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.Gf(str)) {
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
                if (WriteImageActivity.this.ihk && WriteImageActivity.this.ifF != null && !WriteImageActivity.this.ifF.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    if (WriteImageActivity.this.Gf(str2)) {
                        intent3.putExtra("filename", str2);
                    }
                }
                WriteImageActivity.this.setResult(-1, intent3);
                WriteImageActivity.this.finish();
            }
        });
        this.cVa = (TextView) this.jNd.findViewById(R.id.save);
        if (TextUtils.isEmpty(this.jNj)) {
            if (this.hJE || this.gHH != 12003) {
                this.cVa.setText(getPageContext().getString(R.string.done));
            } else {
                this.cVa.setText(getPageContext().getString(R.string.delete));
            }
        } else {
            this.cVa.setText(this.jNj);
        }
        this.jNi = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.faq = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        this.ifD = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.ifC = (LinearLayout) findViewById(R.id.rotate);
        this.ifA = (RadioButton) findViewById(R.id.beautify_btn);
        this.ifB = (RadioButton) findViewById(R.id.rotate_btn);
        this.dYm = (RadioGroup) findViewById(R.id.beautify_tabs);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == WriteImageActivity.this.ifA) {
                        WriteImageActivity.this.jNe.setVisibility(0);
                        WriteImageActivity.this.ifC.setVisibility(8);
                        WriteImageActivity.this.faq.setText(WriteImageActivity.this.getPageContext().getString(R.string.beautify));
                    } else if (compoundButton == WriteImageActivity.this.ifB) {
                        WriteImageActivity.this.jNe.setVisibility(8);
                        WriteImageActivity.this.ifC.setVisibility(0);
                        WriteImageActivity.this.faq.setText(WriteImageActivity.this.getPageContext().getString(R.string.rotate));
                    }
                }
            }
        };
        this.ifA.setOnCheckedChangeListener(onCheckedChangeListener);
        this.ifB.setOnCheckedChangeListener(onCheckedChangeListener);
        this.ifA.setChecked(true);
        Button button = (Button) findViewById(R.id.rotate_left);
        Button button2 = (Button) findViewById(R.id.rotate_right);
        Button button3 = (Button) findViewById(R.id.rotate_left_right);
        Button button4 = (Button) findViewById(R.id.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                    if ((WriteImageActivity.this.mBitmap != null || WriteImageActivity.this.ifF != null) && view.getTag() != null) {
                        WriteImageActivity.this.ihk = false;
                        WriteImageActivity.this.BR(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.ifD.setVisibility(0);
        this.ifB.setPadding(0, this.ifB.getPaddingTop(), this.ifB.getPaddingRight(), this.ifB.getPaddingBottom());
        this.ifB.setChecked(true);
        this.jNe.setVisibility(8);
        this.ifA.setVisibility(8);
        this.dYm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BR(String str) {
        if (this.jNg != null) {
            this.jNg.cancel();
        }
        this.jNg = new a();
        this.jNg.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bP;
            Bitmap bitmap = null;
            try {
                bP = m.bP(null, TbConfig.IMAGE_RESIZED_FILE);
            } catch (Exception e) {
                e = e;
            }
            try {
                if (!isCancelled() || bP == null || bP.isRecycled()) {
                    return bP;
                }
                bP.recycle();
                return null;
            } catch (Exception e2) {
                bitmap = bP;
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
            WriteImageActivity.this.jNd.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.jNf = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.jNd.setEnabled(true);
            WriteImageActivity.this.jNf = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Gf(String str) {
        try {
            m.a(TbConfig.LOCAL_PIC_DIR, str, this.ifF, 90);
            this.mImage.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.ifF, i);
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
        private String ifL;
        private Boolean ifM;
        private Boolean ifN;

        private a() {
            this.ifM = false;
            this.ifN = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.jNd.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            this.ifL = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.ifF == null) {
                return null;
            }
            if (this.ifL.equals("0") || this.ifL.equals("1")) {
                this.ifM = true;
            } else if (this.ifL.equals("2") || this.ifL.equals("3")) {
                this.ifN = true;
            }
            if (this.ifM.booleanValue() || this.ifN.booleanValue()) {
                if (WriteImageActivity.this.ifF == null || WriteImageActivity.this.ifF.isRecycled()) {
                    if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                        this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                    }
                } else {
                    this.bitmap = WriteImageActivity.this.ifF.copy(WriteImageActivity.this.ifF.getConfig(), true);
                }
            } else if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 2000 || this.bitmap.getHeight() > 2000) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, 2000);
                }
                if (this.ifM.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.ifL));
                } else if (this.ifN.booleanValue()) {
                    this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.ifL));
                }
                return this.bitmap;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.ifF != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.jNd.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.jNd.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.ihk = true;
                WriteImageActivity.this.mImage.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.ifM.booleanValue() || this.ifN.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 2000 || WriteImageActivity.this.mBitmap.getHeight() > 2000) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, 2000);
                    }
                    if (this.ifM.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.ifL));
                    } else if (this.ifN.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.ifL));
                    }
                }
                if (WriteImageActivity.this.ifF != null && !WriteImageActivity.this.ifF.isRecycled()) {
                    WriteImageActivity.this.ifF.recycle();
                }
                WriteImageActivity.this.ifF = bitmap;
            }
        }
    }

    private void bxp() {
        this.jNh = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.jNh, intentFilter);
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
            if (WriteImageActivity.this.jNd != null) {
                WriteImageActivity.this.jNd.setEnabled(false);
            }
        }
    }
}
