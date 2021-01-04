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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private int kGs;
    private HashMap<String, Bitmap> mrF;
    private HashMap<String, ImageView> mrG;
    private RadioButton mrx;
    private RadioButton mry;
    private View ogG;
    private View ogH;
    private String ogO;
    private ImageView giH = null;
    private Bitmap mBitmap = null;
    private TextView giF = null;
    private View mParent = null;
    private HorizontalScrollView ogI = null;
    private ProgressBar mProgress = null;
    private b ogJ = null;
    private a ogK = null;
    private RadioGroup ogL = null;
    private LinearLayout mrz = null;
    private LinearLayout mrA = null;
    private TextView bNi = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap bKK = null;
    private c ogM = null;
    private int ogN = 0;
    private int mDisplaySize = 0;
    private boolean mtg = false;
    private boolean eWc = false;
    private final Handler mHandler = new Handler();
    private final Object ogP = new Object();
    private final View.OnClickListener ogQ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.eWc) {
                if (WriteImageActivity.this.kGs == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                        if (WriteImageActivity.this.mtg && WriteImageActivity.this.bKK != null && !WriteImageActivity.this.bKK.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            if (WriteImageActivity.this.VA(str)) {
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
        this.kGs = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.ogO = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.eWc = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.kGs == 12002 || this.kGs == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.kGs, intent.getData(), au.bwr().getPostImageSize(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.kGs, null, au.bwr().getPostImageSize(), this.mDisplaySize, stringExtra);
            }
            cWn();
            return;
        }
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.ogJ != null) {
            this.ogJ.cancel();
        }
        this.giH.setImageDrawable(null);
        dyN();
    }

    private void dyN() {
        synchronized (this.ogP) {
            if (this.mrG != null) {
                for (Map.Entry<String, ImageView> entry : this.mrG.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.mrG.clear();
                this.mrG = null;
            }
            if (this.mrF != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.mrF.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.mrF.clear();
                this.mrF = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.ogJ != null) {
            this.ogJ.cancel();
        }
        this.ogJ = new b();
        this.ogJ.execute(new Object[0]);
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
        if (this.bKK != null && !this.bKK.isRecycled()) {
            this.bKK.recycle();
            this.bKK = null;
        }
        if (this.ogJ != null) {
            this.ogJ.cancel();
            this.ogJ = null;
        }
        this.mProgress.setVisibility(8);
        if (this.kGs == 12002 || this.kGs == 12001) {
            unregisterReceiver(this.ogM);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.ogQ.onClick(null);
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
        ao.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        ao.setViewTextColor(this.bNi, R.color.CAM_X0111, 1);
        if (this.ogH.isEnabled()) {
            this.giF.setTextColor(getResources().getColor(R.color.navi_done_text));
        } else {
            this.giF.setTextColor(getResources().getColor(R.color.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        ao.setNavbarIconSrc((ImageView) ((ViewGroup) this.ogG).getChildAt(0), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s);
    }

    private void initUI() {
        this.mParent = findViewById(R.id.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgress.setVisibility(8);
        this.giH = (ImageView) findViewById(R.id.image);
        this.giH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mNavigationBar.getVisibility() == 0) {
                    WriteImageActivity.this.mNavigationBar.setVisibility(8);
                    WriteImageActivity.this.mrA.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mNavigationBar.setVisibility(0);
                WriteImageActivity.this.mrA.setVisibility(0);
            }
        });
        if (this.mBitmap != null) {
            this.giH.setImageBitmap(this.mBitmap);
        }
        this.ogI = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.ogG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.eWc) {
                    if (WriteImageActivity.this.kGs == 12003) {
                        Intent intent = new Intent();
                        if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                            if (WriteImageActivity.this.mtg && WriteImageActivity.this.bKK != null && !WriteImageActivity.this.bKK.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.VA(str)) {
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
        this.ogH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.ogH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.eWc) {
                    if (WriteImageActivity.this.kGs == 12003) {
                        Intent intent = new Intent();
                        intent.putExtra("delete", true);
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        if (WriteImageActivity.this.mtg) {
                            if (WriteImageActivity.this.bKK != null && !WriteImageActivity.this.bKK.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.VA(str)) {
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
                if (WriteImageActivity.this.mtg && WriteImageActivity.this.bKK != null && !WriteImageActivity.this.bKK.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    if (WriteImageActivity.this.VA(str2)) {
                        intent3.putExtra("filename", str2);
                    }
                }
                WriteImageActivity.this.setResult(-1, intent3);
                WriteImageActivity.this.finish();
            }
        });
        this.giF = (TextView) this.ogH.findViewById(R.id.save);
        if (TextUtils.isEmpty(this.ogO)) {
            if (this.eWc || this.kGs != 12003) {
                this.giF.setText(getPageContext().getString(R.string.done));
            } else {
                this.giF.setText(getPageContext().getString(R.string.delete));
            }
        } else {
            this.giF.setText(this.ogO);
        }
        this.ogN = l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.bNi = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        this.mrA = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.mrz = (LinearLayout) findViewById(R.id.rotate);
        this.mrx = (RadioButton) findViewById(R.id.beautify_btn);
        this.mry = (RadioButton) findViewById(R.id.rotate_btn);
        this.ogL = (RadioGroup) findViewById(R.id.beautify_tabs);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == WriteImageActivity.this.mrx) {
                        WriteImageActivity.this.ogI.setVisibility(0);
                        WriteImageActivity.this.mrz.setVisibility(8);
                        WriteImageActivity.this.bNi.setText(WriteImageActivity.this.getPageContext().getString(R.string.beautify));
                    } else if (compoundButton == WriteImageActivity.this.mry) {
                        WriteImageActivity.this.ogI.setVisibility(8);
                        WriteImageActivity.this.mrz.setVisibility(0);
                        WriteImageActivity.this.bNi.setText(WriteImageActivity.this.getPageContext().getString(R.string.rotate));
                    }
                }
            }
        };
        this.mrx.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mry.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mrx.setChecked(true);
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
                    if ((WriteImageActivity.this.mBitmap != null || WriteImageActivity.this.bKK != null) && view.getTag() != null) {
                        WriteImageActivity.this.mtg = false;
                        WriteImageActivity.this.QD(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.mrA.setVisibility(0);
        this.mry.setPadding(0, this.mry.getPaddingTop(), this.mry.getPaddingRight(), this.mry.getPaddingBottom());
        this.mry.setChecked(true);
        this.ogI.setVisibility(8);
        this.mrx.setVisibility(8);
        this.ogL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QD(String str) {
        if (this.ogK != null) {
            this.ogK.cancel();
        }
        this.ogK = new a();
        this.ogK.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Object, Integer, Bitmap> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public Bitmap doInBackground(Object... objArr) {
            Exception e;
            Bitmap image;
            Bitmap bitmap = null;
            try {
                image = n.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
            } catch (Exception e2) {
                e = e2;
            }
            try {
                if (!isCancelled() || image == null || image.isRecycled()) {
                    return image;
                }
                image.recycle();
                return null;
            } catch (Exception e3) {
                e = e3;
                bitmap = image;
                e.printStackTrace();
                BdLog.e(e.toString());
                return bitmap;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.ogH.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.ogJ = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.ogH.setEnabled(true);
            WriteImageActivity.this.ogJ = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.giH.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean VA(String str) {
        try {
            n.a(TbConfig.LOCAL_PIC_DIR, str, this.bKK, 90);
            this.giH.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.bKK, i);
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
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private String mrI;
        private Boolean mrJ;
        private Boolean mrK;

        private a() {
            this.mrJ = false;
            this.mrK = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.ogH.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: S */
        public Bitmap doInBackground(String... strArr) {
            this.mrI = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.bKK == null) {
                return null;
            }
            if (this.mrI.equals("0") || this.mrI.equals("1")) {
                this.mrJ = true;
            } else if (this.mrI.equals("2") || this.mrI.equals("3")) {
                this.mrK = true;
            }
            if (this.mrJ.booleanValue() || this.mrK.booleanValue()) {
                if (WriteImageActivity.this.bKK == null || WriteImageActivity.this.bKK.isRecycled()) {
                    if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                        this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                    }
                } else {
                    this.bitmap = WriteImageActivity.this.bKK.copy(WriteImageActivity.this.bKK.getConfig(), true);
                }
            } else if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 2000 || this.bitmap.getHeight() > 2000) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, 2000);
                }
                if (this.mrJ.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mrI));
                } else if (this.mrK.booleanValue()) {
                    this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mrI));
                }
                return this.bitmap;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.bKK != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.ogH.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.ogH.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.mtg = true;
                WriteImageActivity.this.giH.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.mrJ.booleanValue() || this.mrK.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 2000 || WriteImageActivity.this.mBitmap.getHeight() > 2000) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, 2000);
                    }
                    if (this.mrJ.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mrI));
                    } else if (this.mrK.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mrI));
                    }
                }
                if (WriteImageActivity.this.bKK != null && !WriteImageActivity.this.bKK.isRecycled()) {
                    WriteImageActivity.this.bKK.recycle();
                }
                WriteImageActivity.this.bKK = bitmap;
            }
        }
    }

    private void cWn() {
        this.ogM = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.ogM, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
            if (WriteImageActivity.this.ogH != null) {
                WriteImageActivity.this.ogH.setEnabled(false);
            }
        }
    }
}
