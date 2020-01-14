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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private int hFu;
    private RadioButton jir;
    private RadioButton jis;
    private HashMap<String, Bitmap> jix;
    private HashMap<String, ImageView> jiy;
    private View kTf;
    private View kTg;
    private String kTn;
    private ImageView dTY = null;
    private Bitmap mBitmap = null;
    private TextView dTV = null;
    private View mParent = null;
    private HorizontalScrollView kTh = null;
    private ProgressBar mProgress = null;
    private b kTi = null;
    private a kTj = null;
    private RadioGroup kTk = null;
    private LinearLayout jit = null;
    private LinearLayout jiu = null;
    private TextView ayC = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap awE = null;
    private c kTl = null;
    private int kTm = 0;
    private int mDisplaySize = 0;
    private boolean jjU = false;
    private boolean cQn = false;
    private final Handler mHandler = new Handler();
    private final Object writeLock = new Object();
    private final View.OnClickListener kTo = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.cQn) {
                if (WriteImageActivity.this.hFu == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                        if (WriteImageActivity.this.jjU && WriteImageActivity.this.awE != null && !WriteImageActivity.this.awE.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            if (WriteImageActivity.this.KT(str)) {
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
        this.hFu = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.kTn = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.cQn = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.hFu == 12002 || this.hFu == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.hFu, intent.getData(), ar.aEq().getPostImageSize(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.hFu, null, ar.aEq().getPostImageSize(), this.mDisplaySize, stringExtra);
            }
            bQe();
            return;
        }
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.kTi != null) {
            this.kTi.cancel();
        }
        this.dTY.setImageDrawable(null);
        cup();
    }

    private void cup() {
        synchronized (this.writeLock) {
            if (this.jiy != null) {
                for (Map.Entry<String, ImageView> entry : this.jiy.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.jiy.clear();
                this.jiy = null;
            }
            if (this.jix != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.jix.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.jix.clear();
                this.jix = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.kTi != null) {
            this.kTi.cancel();
        }
        this.kTi = new b();
        this.kTi.execute(new Object[0]);
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
        if (this.awE != null && !this.awE.isRecycled()) {
            this.awE.recycle();
            this.awE = null;
        }
        if (this.kTi != null) {
            this.kTi.cancel();
            this.kTi = null;
        }
        this.mProgress.setVisibility(8);
        if (this.hFu == 12002 || this.hFu == 12001) {
            unregisterReceiver(this.kTl);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.kTo.onClick(null);
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
        am.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        am.setViewTextColor(this.ayC, R.color.cp_cont_g, 1);
        if (this.kTg.isEnabled()) {
            this.dTV.setTextColor(getResources().getColor(R.color.navi_done_text));
        } else {
            this.dTV.setTextColor(getResources().getColor(R.color.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        am.setNavbarIconSrc((ImageView) ((ViewGroup) this.kTf).getChildAt(0), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s);
    }

    private void initUI() {
        this.mParent = findViewById(R.id.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgress.setVisibility(8);
        this.dTY = (ImageView) findViewById(R.id.image);
        this.dTY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mNavigationBar.getVisibility() == 0) {
                    WriteImageActivity.this.mNavigationBar.setVisibility(8);
                    WriteImageActivity.this.jiu.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mNavigationBar.setVisibility(0);
                WriteImageActivity.this.jiu.setVisibility(0);
            }
        });
        if (this.mBitmap != null) {
            this.dTY.setImageBitmap(this.mBitmap);
        }
        this.kTh = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.kTf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.cQn) {
                    if (WriteImageActivity.this.hFu == 12003) {
                        Intent intent = new Intent();
                        if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                            if (WriteImageActivity.this.jjU && WriteImageActivity.this.awE != null && !WriteImageActivity.this.awE.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.KT(str)) {
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
        this.kTg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.kTg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.cQn) {
                    if (WriteImageActivity.this.hFu == 12003) {
                        Intent intent = new Intent();
                        intent.putExtra("delete", true);
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        if (WriteImageActivity.this.jjU) {
                            if (WriteImageActivity.this.awE != null && !WriteImageActivity.this.awE.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.KT(str)) {
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
                if (WriteImageActivity.this.jjU && WriteImageActivity.this.awE != null && !WriteImageActivity.this.awE.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    if (WriteImageActivity.this.KT(str2)) {
                        intent3.putExtra("filename", str2);
                    }
                }
                WriteImageActivity.this.setResult(-1, intent3);
                WriteImageActivity.this.finish();
            }
        });
        this.dTV = (TextView) this.kTg.findViewById(R.id.save);
        if (TextUtils.isEmpty(this.kTn)) {
            if (this.cQn || this.hFu != 12003) {
                this.dTV.setText(getPageContext().getString(R.string.done));
            } else {
                this.dTV.setText(getPageContext().getString(R.string.delete));
            }
        } else {
            this.dTV.setText(this.kTn);
        }
        this.kTm = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.ayC = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        this.jiu = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.jit = (LinearLayout) findViewById(R.id.rotate);
        this.jir = (RadioButton) findViewById(R.id.beautify_btn);
        this.jis = (RadioButton) findViewById(R.id.rotate_btn);
        this.kTk = (RadioGroup) findViewById(R.id.beautify_tabs);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == WriteImageActivity.this.jir) {
                        WriteImageActivity.this.kTh.setVisibility(0);
                        WriteImageActivity.this.jit.setVisibility(8);
                        WriteImageActivity.this.ayC.setText(WriteImageActivity.this.getPageContext().getString(R.string.beautify));
                    } else if (compoundButton == WriteImageActivity.this.jis) {
                        WriteImageActivity.this.kTh.setVisibility(8);
                        WriteImageActivity.this.jit.setVisibility(0);
                        WriteImageActivity.this.ayC.setText(WriteImageActivity.this.getPageContext().getString(R.string.rotate));
                    }
                }
            }
        };
        this.jir.setOnCheckedChangeListener(onCheckedChangeListener);
        this.jis.setOnCheckedChangeListener(onCheckedChangeListener);
        this.jir.setChecked(true);
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
                    if ((WriteImageActivity.this.mBitmap != null || WriteImageActivity.this.awE != null) && view.getTag() != null) {
                        WriteImageActivity.this.jjU = false;
                        WriteImageActivity.this.Gt(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.jiu.setVisibility(0);
        this.jis.setPadding(0, this.jis.getPaddingTop(), this.jis.getPaddingRight(), this.jis.getPaddingBottom());
        this.jis.setChecked(true);
        this.kTh.setVisibility(8);
        this.jir.setVisibility(8);
        this.kTk.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gt(String str) {
        if (this.kTj != null) {
            this.kTj.cancel();
        }
        this.kTj = new a();
        this.kTj.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap image;
            Bitmap bitmap = null;
            try {
                image = m.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
            } catch (Exception e) {
                e = e;
            }
            try {
                if (!isCancelled() || image == null || image.isRecycled()) {
                    return image;
                }
                image.recycle();
                return null;
            } catch (Exception e2) {
                bitmap = image;
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
            WriteImageActivity.this.kTg.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.kTi = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.kTg.setEnabled(true);
            WriteImageActivity.this.kTi = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.dTY.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KT(String str) {
        try {
            m.a(TbConfig.LOCAL_PIC_DIR, str, this.awE, 90);
            this.dTY.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.awE, i);
            if (resizeBitmap != null) {
                if (m.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String jiA;
        private Boolean jiB;
        private Boolean jiC;

        private a() {
            this.jiB = false;
            this.jiC = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.kTg.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public Bitmap doInBackground(String... strArr) {
            this.jiA = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.awE == null) {
                return null;
            }
            if (this.jiA.equals("0") || this.jiA.equals("1")) {
                this.jiB = true;
            } else if (this.jiA.equals("2") || this.jiA.equals("3")) {
                this.jiC = true;
            }
            if (this.jiB.booleanValue() || this.jiC.booleanValue()) {
                if (WriteImageActivity.this.awE == null || WriteImageActivity.this.awE.isRecycled()) {
                    if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                        this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                    }
                } else {
                    this.bitmap = WriteImageActivity.this.awE.copy(WriteImageActivity.this.awE.getConfig(), true);
                }
            } else if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 2000 || this.bitmap.getHeight() > 2000) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, 2000);
                }
                if (this.jiB.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.jiA));
                } else if (this.jiC.booleanValue()) {
                    this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.jiA));
                }
                return this.bitmap;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.awE != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.kTg.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.kTg.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.jjU = true;
                WriteImageActivity.this.dTY.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.jiB.booleanValue() || this.jiC.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 2000 || WriteImageActivity.this.mBitmap.getHeight() > 2000) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, 2000);
                    }
                    if (this.jiB.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.jiA));
                    } else if (this.jiC.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.jiA));
                    }
                }
                if (WriteImageActivity.this.awE != null && !WriteImageActivity.this.awE.isRecycled()) {
                    WriteImageActivity.this.awE.recycle();
                }
                WriteImageActivity.this.awE = bitmap;
            }
        }
    }

    private void bQe() {
        this.kTl = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.kTl, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
            WriteImageActivity.this.showToast(intent.getStringExtra(BdStatsConstant.StatsType.ERROR));
            if (WriteImageActivity.this.kTg != null) {
                WriteImageActivity.this.kTg.setEnabled(false);
            }
        }
    }
}
