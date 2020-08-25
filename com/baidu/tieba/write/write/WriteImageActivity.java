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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private int jwU;
    private RadioButton lhe;
    private RadioButton lhf;
    private HashMap<String, Bitmap> lhm;
    private HashMap<String, ImageView> lhn;
    private View mWf;
    private View mWg;
    private String mWn;
    private ImageView fnA = null;
    private Bitmap mBitmap = null;
    private TextView fnx = null;
    private View mParent = null;
    private HorizontalScrollView mWh = null;
    private ProgressBar mProgress = null;
    private b mWi = null;
    private a mWj = null;
    private RadioGroup mWk = null;
    private LinearLayout lhg = null;
    private LinearLayout lhh = null;
    private TextView bpx = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap bnv = null;
    private c mWl = null;
    private int mWm = 0;
    private int mDisplaySize = 0;
    private boolean liJ = false;
    private boolean eee = false;
    private final Handler mHandler = new Handler();
    private final Object writeLock = new Object();
    private final View.OnClickListener mWo = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.eee) {
                if (WriteImageActivity.this.jwU == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                        if (WriteImageActivity.this.liJ && WriteImageActivity.this.bnv != null && !WriteImageActivity.this.bnv.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            if (WriteImageActivity.this.SZ(str)) {
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
        this.jwU = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.mWn = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.eee = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.jwU == 12002 || this.jwU == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.jwU, intent.getData(), au.bjr().getPostImageSize(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.jwU, null, au.bjr().getPostImageSize(), this.mDisplaySize, stringExtra);
            }
            cBn();
            return;
        }
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.mWi != null) {
            this.mWi.cancel();
        }
        this.fnA.setImageDrawable(null);
        dhg();
    }

    private void dhg() {
        synchronized (this.writeLock) {
            if (this.lhn != null) {
                for (Map.Entry<String, ImageView> entry : this.lhn.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.lhn.clear();
                this.lhn = null;
            }
            if (this.lhm != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.lhm.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.lhm.clear();
                this.lhm = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.mWi != null) {
            this.mWi.cancel();
        }
        this.mWi = new b();
        this.mWi.execute(new Object[0]);
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
        if (this.bnv != null && !this.bnv.isRecycled()) {
            this.bnv.recycle();
            this.bnv = null;
        }
        if (this.mWi != null) {
            this.mWi.cancel();
            this.mWi = null;
        }
        this.mProgress.setVisibility(8);
        if (this.jwU == 12002 || this.jwU == 12001) {
            unregisterReceiver(this.mWl);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.mWo.onClick(null);
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
        ap.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        ap.setViewTextColor(this.bpx, R.color.cp_cont_g, 1);
        if (this.mWg.isEnabled()) {
            this.fnx.setTextColor(getResources().getColor(R.color.navi_done_text));
        } else {
            this.fnx.setTextColor(getResources().getColor(R.color.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        ap.setNavbarIconSrc((ImageView) ((ViewGroup) this.mWf).getChildAt(0), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s);
    }

    private void initUI() {
        this.mParent = findViewById(R.id.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgress.setVisibility(8);
        this.fnA = (ImageView) findViewById(R.id.image);
        this.fnA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mNavigationBar.getVisibility() == 0) {
                    WriteImageActivity.this.mNavigationBar.setVisibility(8);
                    WriteImageActivity.this.lhh.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mNavigationBar.setVisibility(0);
                WriteImageActivity.this.lhh.setVisibility(0);
            }
        });
        if (this.mBitmap != null) {
            this.fnA.setImageBitmap(this.mBitmap);
        }
        this.mWh = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mWf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.eee) {
                    if (WriteImageActivity.this.jwU == 12003) {
                        Intent intent = new Intent();
                        if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                            if (WriteImageActivity.this.liJ && WriteImageActivity.this.bnv != null && !WriteImageActivity.this.bnv.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.SZ(str)) {
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
        this.mWg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.mWg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.eee) {
                    if (WriteImageActivity.this.jwU == 12003) {
                        Intent intent = new Intent();
                        intent.putExtra("delete", true);
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        if (WriteImageActivity.this.liJ) {
                            if (WriteImageActivity.this.bnv != null && !WriteImageActivity.this.bnv.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.SZ(str)) {
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
                if (WriteImageActivity.this.liJ && WriteImageActivity.this.bnv != null && !WriteImageActivity.this.bnv.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    if (WriteImageActivity.this.SZ(str2)) {
                        intent3.putExtra("filename", str2);
                    }
                }
                WriteImageActivity.this.setResult(-1, intent3);
                WriteImageActivity.this.finish();
            }
        });
        this.fnx = (TextView) this.mWg.findViewById(R.id.save);
        if (TextUtils.isEmpty(this.mWn)) {
            if (this.eee || this.jwU != 12003) {
                this.fnx.setText(getPageContext().getString(R.string.done));
            } else {
                this.fnx.setText(getPageContext().getString(R.string.delete));
            }
        } else {
            this.fnx.setText(this.mWn);
        }
        this.mWm = com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.bpx = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        this.lhh = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.lhg = (LinearLayout) findViewById(R.id.rotate);
        this.lhe = (RadioButton) findViewById(R.id.beautify_btn);
        this.lhf = (RadioButton) findViewById(R.id.rotate_btn);
        this.mWk = (RadioGroup) findViewById(R.id.beautify_tabs);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == WriteImageActivity.this.lhe) {
                        WriteImageActivity.this.mWh.setVisibility(0);
                        WriteImageActivity.this.lhg.setVisibility(8);
                        WriteImageActivity.this.bpx.setText(WriteImageActivity.this.getPageContext().getString(R.string.beautify));
                    } else if (compoundButton == WriteImageActivity.this.lhf) {
                        WriteImageActivity.this.mWh.setVisibility(8);
                        WriteImageActivity.this.lhg.setVisibility(0);
                        WriteImageActivity.this.bpx.setText(WriteImageActivity.this.getPageContext().getString(R.string.rotate));
                    }
                }
            }
        };
        this.lhe.setOnCheckedChangeListener(onCheckedChangeListener);
        this.lhf.setOnCheckedChangeListener(onCheckedChangeListener);
        this.lhe.setChecked(true);
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
                    if ((WriteImageActivity.this.mBitmap != null || WriteImageActivity.this.bnv != null) && view.getTag() != null) {
                        WriteImageActivity.this.liJ = false;
                        WriteImageActivity.this.On(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.lhh.setVisibility(0);
        this.lhf.setPadding(0, this.lhf.getPaddingTop(), this.lhf.getPaddingRight(), this.lhf.getPaddingBottom());
        this.lhf.setChecked(true);
        this.mWh.setVisibility(8);
        this.lhe.setVisibility(8);
        this.mWk.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void On(String str) {
        if (this.mWj != null) {
            this.mWj.cancel();
        }
        this.mWj = new a();
        this.mWj.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap image;
            Bitmap bitmap = null;
            try {
                image = n.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
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
            WriteImageActivity.this.mWg.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.mWi = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.mWg.setEnabled(true);
            WriteImageActivity.this.mWi = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.fnA.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SZ(String str) {
        try {
            n.a(TbConfig.LOCAL_PIC_DIR, str, this.bnv, 90);
            this.fnA.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.bnv, i);
            if (resizeBitmap != null) {
                if (n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
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
        private String lhp;
        private Boolean lhq;
        private Boolean lhr;

        private a() {
            this.lhq = false;
            this.lhr = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.mWg.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public Bitmap doInBackground(String... strArr) {
            this.lhp = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.bnv == null) {
                return null;
            }
            if (this.lhp.equals("0") || this.lhp.equals("1")) {
                this.lhq = true;
            } else if (this.lhp.equals("2") || this.lhp.equals("3")) {
                this.lhr = true;
            }
            if (this.lhq.booleanValue() || this.lhr.booleanValue()) {
                if (WriteImageActivity.this.bnv == null || WriteImageActivity.this.bnv.isRecycled()) {
                    if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                        this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                    }
                } else {
                    this.bitmap = WriteImageActivity.this.bnv.copy(WriteImageActivity.this.bnv.getConfig(), true);
                }
            } else if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 2000 || this.bitmap.getHeight() > 2000) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, 2000);
                }
                if (this.lhq.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.lhp));
                } else if (this.lhr.booleanValue()) {
                    this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.lhp));
                }
                return this.bitmap;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.bnv != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.mWg.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.mWg.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.liJ = true;
                WriteImageActivity.this.fnA.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.lhq.booleanValue() || this.lhr.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 2000 || WriteImageActivity.this.mBitmap.getHeight() > 2000) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, 2000);
                    }
                    if (this.lhq.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.lhp));
                    } else if (this.lhr.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.lhp));
                    }
                }
                if (WriteImageActivity.this.bnv != null && !WriteImageActivity.this.bnv.isRecycled()) {
                    WriteImageActivity.this.bnv.recycle();
                }
                WriteImageActivity.this.bnv = bitmap;
            }
        }
    }

    private void cBn() {
        this.mWl = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.mWl, intentFilter);
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
            WriteImageActivity.this.showToast(intent.getStringExtra(BdStatsConstant.StatsType.ERROR));
            if (WriteImageActivity.this.mWg != null) {
                WriteImageActivity.this.mWg.setEnabled(false);
            }
        }
    }
}
