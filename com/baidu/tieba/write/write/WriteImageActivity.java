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
    private int jFC;
    private RadioButton lqg;
    private RadioButton lqh;
    private HashMap<String, Bitmap> lqo;
    private HashMap<String, ImageView> lqp;
    private String ngE;
    private View ngw;
    private View ngx;
    private ImageView fqJ = null;
    private Bitmap mBitmap = null;
    private TextView fqG = null;
    private View mParent = null;
    private HorizontalScrollView ngy = null;
    private ProgressBar mProgress = null;
    private b ngz = null;
    private a ngA = null;
    private RadioGroup ngB = null;
    private LinearLayout lqi = null;
    private LinearLayout lqj = null;
    private TextView bsJ = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap bqt = null;
    private c ngC = null;
    private int ngD = 0;
    private int mDisplaySize = 0;
    private boolean lrM = false;
    private boolean egs = false;
    private final Handler mHandler = new Handler();
    private final Object writeLock = new Object();
    private final View.OnClickListener ngF = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.egs) {
                if (WriteImageActivity.this.jFC == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                        if (WriteImageActivity.this.lrM && WriteImageActivity.this.bqt != null && !WriteImageActivity.this.bqt.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            if (WriteImageActivity.this.Ty(str)) {
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
        this.jFC = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.ngE = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.egs = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.jFC == 12002 || this.jFC == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.jFC, intent.getData(), au.bkm().getPostImageSize(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.jFC, null, au.bkm().getPostImageSize(), this.mDisplaySize, stringExtra);
            }
            cEV();
            return;
        }
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.ngz != null) {
            this.ngz.cancel();
        }
        this.fqJ.setImageDrawable(null);
        dkM();
    }

    private void dkM() {
        synchronized (this.writeLock) {
            if (this.lqp != null) {
                for (Map.Entry<String, ImageView> entry : this.lqp.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.lqp.clear();
                this.lqp = null;
            }
            if (this.lqo != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.lqo.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.lqo.clear();
                this.lqo = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.ngz != null) {
            this.ngz.cancel();
        }
        this.ngz = new b();
        this.ngz.execute(new Object[0]);
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
        if (this.bqt != null && !this.bqt.isRecycled()) {
            this.bqt.recycle();
            this.bqt = null;
        }
        if (this.ngz != null) {
            this.ngz.cancel();
            this.ngz = null;
        }
        this.mProgress.setVisibility(8);
        if (this.jFC == 12002 || this.jFC == 12001) {
            unregisterReceiver(this.ngC);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.ngF.onClick(null);
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
        ap.setViewTextColor(this.bsJ, R.color.cp_cont_g, 1);
        if (this.ngx.isEnabled()) {
            this.fqG.setTextColor(getResources().getColor(R.color.navi_done_text));
        } else {
            this.fqG.setTextColor(getResources().getColor(R.color.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        ap.setNavbarIconSrc((ImageView) ((ViewGroup) this.ngw).getChildAt(0), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s);
    }

    private void initUI() {
        this.mParent = findViewById(R.id.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgress.setVisibility(8);
        this.fqJ = (ImageView) findViewById(R.id.image);
        this.fqJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mNavigationBar.getVisibility() == 0) {
                    WriteImageActivity.this.mNavigationBar.setVisibility(8);
                    WriteImageActivity.this.lqj.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mNavigationBar.setVisibility(0);
                WriteImageActivity.this.lqj.setVisibility(0);
            }
        });
        if (this.mBitmap != null) {
            this.fqJ.setImageBitmap(this.mBitmap);
        }
        this.ngy = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.ngw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.egs) {
                    if (WriteImageActivity.this.jFC == 12003) {
                        Intent intent = new Intent();
                        if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                            if (WriteImageActivity.this.lrM && WriteImageActivity.this.bqt != null && !WriteImageActivity.this.bqt.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.Ty(str)) {
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
        this.ngx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.ngx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.egs) {
                    if (WriteImageActivity.this.jFC == 12003) {
                        Intent intent = new Intent();
                        intent.putExtra("delete", true);
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        if (WriteImageActivity.this.lrM) {
                            if (WriteImageActivity.this.bqt != null && !WriteImageActivity.this.bqt.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.Ty(str)) {
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
                if (WriteImageActivity.this.lrM && WriteImageActivity.this.bqt != null && !WriteImageActivity.this.bqt.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    if (WriteImageActivity.this.Ty(str2)) {
                        intent3.putExtra("filename", str2);
                    }
                }
                WriteImageActivity.this.setResult(-1, intent3);
                WriteImageActivity.this.finish();
            }
        });
        this.fqG = (TextView) this.ngx.findViewById(R.id.save);
        if (TextUtils.isEmpty(this.ngE)) {
            if (this.egs || this.jFC != 12003) {
                this.fqG.setText(getPageContext().getString(R.string.done));
            } else {
                this.fqG.setText(getPageContext().getString(R.string.delete));
            }
        } else {
            this.fqG.setText(this.ngE);
        }
        this.ngD = com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.bsJ = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        this.lqj = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.lqi = (LinearLayout) findViewById(R.id.rotate);
        this.lqg = (RadioButton) findViewById(R.id.beautify_btn);
        this.lqh = (RadioButton) findViewById(R.id.rotate_btn);
        this.ngB = (RadioGroup) findViewById(R.id.beautify_tabs);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == WriteImageActivity.this.lqg) {
                        WriteImageActivity.this.ngy.setVisibility(0);
                        WriteImageActivity.this.lqi.setVisibility(8);
                        WriteImageActivity.this.bsJ.setText(WriteImageActivity.this.getPageContext().getString(R.string.beautify));
                    } else if (compoundButton == WriteImageActivity.this.lqh) {
                        WriteImageActivity.this.ngy.setVisibility(8);
                        WriteImageActivity.this.lqi.setVisibility(0);
                        WriteImageActivity.this.bsJ.setText(WriteImageActivity.this.getPageContext().getString(R.string.rotate));
                    }
                }
            }
        };
        this.lqg.setOnCheckedChangeListener(onCheckedChangeListener);
        this.lqh.setOnCheckedChangeListener(onCheckedChangeListener);
        this.lqg.setChecked(true);
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
                    if ((WriteImageActivity.this.mBitmap != null || WriteImageActivity.this.bqt != null) && view.getTag() != null) {
                        WriteImageActivity.this.lrM = false;
                        WriteImageActivity.this.OP(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.lqj.setVisibility(0);
        this.lqh.setPadding(0, this.lqh.getPaddingTop(), this.lqh.getPaddingRight(), this.lqh.getPaddingBottom());
        this.lqh.setChecked(true);
        this.ngy.setVisibility(8);
        this.lqg.setVisibility(8);
        this.ngB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OP(String str) {
        if (this.ngA != null) {
            this.ngA.cancel();
        }
        this.ngA = new a();
        this.ngA.execute(str);
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
            WriteImageActivity.this.ngx.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.ngz = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.ngx.setEnabled(true);
            WriteImageActivity.this.ngz = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.fqJ.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ty(String str) {
        try {
            n.a(TbConfig.LOCAL_PIC_DIR, str, this.bqt, 90);
            this.fqJ.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.bqt, i);
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
        private String lqr;
        private Boolean lqs;
        private Boolean lqt;

        private a() {
            this.lqs = false;
            this.lqt = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.ngx.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public Bitmap doInBackground(String... strArr) {
            this.lqr = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.bqt == null) {
                return null;
            }
            if (this.lqr.equals("0") || this.lqr.equals("1")) {
                this.lqs = true;
            } else if (this.lqr.equals("2") || this.lqr.equals("3")) {
                this.lqt = true;
            }
            if (this.lqs.booleanValue() || this.lqt.booleanValue()) {
                if (WriteImageActivity.this.bqt == null || WriteImageActivity.this.bqt.isRecycled()) {
                    if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                        this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                    }
                } else {
                    this.bitmap = WriteImageActivity.this.bqt.copy(WriteImageActivity.this.bqt.getConfig(), true);
                }
            } else if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 2000 || this.bitmap.getHeight() > 2000) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, 2000);
                }
                if (this.lqs.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.lqr));
                } else if (this.lqt.booleanValue()) {
                    this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.lqr));
                }
                return this.bitmap;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.bqt != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.ngx.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.ngx.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.lrM = true;
                WriteImageActivity.this.fqJ.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.lqs.booleanValue() || this.lqt.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 2000 || WriteImageActivity.this.mBitmap.getHeight() > 2000) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, 2000);
                    }
                    if (this.lqs.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.lqr));
                    } else if (this.lqt.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.lqr));
                    }
                }
                if (WriteImageActivity.this.bqt != null && !WriteImageActivity.this.bqt.isRecycled()) {
                    WriteImageActivity.this.bqt.recycle();
                }
                WriteImageActivity.this.bqt = bitmap;
            }
        }
    }

    private void cEV() {
        this.ngC = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.ngC, intentFilter);
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
            if (WriteImageActivity.this.ngx != null) {
                WriteImageActivity.this.ngx.setEnabled(false);
            }
        }
    }
}
