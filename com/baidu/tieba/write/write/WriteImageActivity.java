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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    private int kBe;
    private RadioButton mmn;
    private RadioButton mmo;
    private HashMap<String, Bitmap> mmv;
    private HashMap<String, ImageView> mmw;
    private String oeB;
    private View oet;
    private View oeu;
    private ImageView fZa = null;
    private Bitmap mBitmap = null;
    private TextView fYY = null;
    private View mParent = null;
    private HorizontalScrollView oev = null;
    private ProgressBar mProgress = null;
    private b oew = null;
    private a oex = null;
    private RadioGroup oey = null;
    private LinearLayout mmp = null;
    private LinearLayout mmq = null;
    private TextView bIt = null;
    private NavigationBar mNavigationBar = null;
    private Bitmap bFV = null;
    private c oez = null;
    private int oeA = 0;
    private int mDisplaySize = 0;
    private boolean mnT = false;
    private boolean eMh = false;
    private final Handler mHandler = new Handler();
    private final Object oeC = new Object();
    private final View.OnClickListener oeD = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.eMh) {
                if (WriteImageActivity.this.kBe == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                        if (WriteImageActivity.this.mnT && WriteImageActivity.this.bFV != null && !WriteImageActivity.this.bFV.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            if (WriteImageActivity.this.Wc(str)) {
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
        this.kBe = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra(WriteImageActivityConfig.DISPLAY_SIZE, 0);
        this.oeB = intent.getStringExtra(WriteImageActivityConfig.FINISH_TEXT);
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.eMh = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        if (this.kBe == 12002 || this.kBe == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.kBe, intent.getData(), av.btX().getPostImageSize(), this.mDisplaySize);
            } else {
                TiebaPrepareImageService.StartService(this.kBe, null, av.btX().getPostImageSize(), this.mDisplaySize, stringExtra);
            }
            cTh();
            return;
        }
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.oew != null) {
            this.oew.cancel();
        }
        this.fZa.setImageDrawable(null);
        dyY();
    }

    private void dyY() {
        synchronized (this.oeC) {
            if (this.mmw != null) {
                for (Map.Entry<String, ImageView> entry : this.mmw.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.mmw.clear();
                this.mmw = null;
            }
            if (this.mmv != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.mmv.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.mmv.clear();
                this.mmv = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.oew != null) {
            this.oew.cancel();
        }
        this.oew = new b();
        this.oew.execute(new Object[0]);
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
        if (this.bFV != null && !this.bFV.isRecycled()) {
            this.bFV.recycle();
            this.bFV = null;
        }
        if (this.oew != null) {
            this.oew.cancel();
            this.oew = null;
        }
        this.mProgress.setVisibility(8);
        if (this.kBe == 12002 || this.kBe == 12001) {
            unregisterReceiver(this.oez);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.oeD.onClick(null);
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
        ap.setViewTextColor(this.bIt, R.color.CAM_X0111, 1);
        if (this.oeu.isEnabled()) {
            this.fYY.setTextColor(getResources().getColor(R.color.navi_done_text));
        } else {
            this.fYY.setTextColor(getResources().getColor(R.color.common_color_10231));
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
        ap.setNavbarIconSrc((ImageView) ((ViewGroup) this.oet).getChildAt(0), R.drawable.icon_topbar_return_s, R.drawable.icon_topbar_return_s);
    }

    private void initUI() {
        this.mParent = findViewById(R.id.write_image_root_layout);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgress.setVisibility(8);
        this.fZa = (ImageView) findViewById(R.id.image);
        this.fZa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteImageActivity.this.mNavigationBar.getVisibility() == 0) {
                    WriteImageActivity.this.mNavigationBar.setVisibility(8);
                    WriteImageActivity.this.mmq.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mNavigationBar.setVisibility(0);
                WriteImageActivity.this.mmq.setVisibility(0);
            }
        });
        if (this.mBitmap != null) {
            this.fZa.setImageBitmap(this.mBitmap);
        }
        this.oev = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.oet = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.eMh) {
                    if (WriteImageActivity.this.kBe == 12003) {
                        Intent intent = new Intent();
                        if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                            if (WriteImageActivity.this.mnT && WriteImageActivity.this.bFV != null && !WriteImageActivity.this.bFV.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.Wc(str)) {
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
        this.oeu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.oeu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteImageActivity.this.eMh) {
                    if (WriteImageActivity.this.kBe == 12003) {
                        Intent intent = new Intent();
                        intent.putExtra("delete", true);
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        if (WriteImageActivity.this.mnT) {
                            if (WriteImageActivity.this.bFV != null && !WriteImageActivity.this.bFV.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                if (WriteImageActivity.this.Wc(str)) {
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
                if (WriteImageActivity.this.mnT && WriteImageActivity.this.bFV != null && !WriteImageActivity.this.bFV.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    if (WriteImageActivity.this.Wc(str2)) {
                        intent3.putExtra("filename", str2);
                    }
                }
                WriteImageActivity.this.setResult(-1, intent3);
                WriteImageActivity.this.finish();
            }
        });
        this.fYY = (TextView) this.oeu.findViewById(R.id.save);
        if (TextUtils.isEmpty(this.oeB)) {
            if (this.eMh || this.kBe != 12003) {
                this.fYY.setText(getPageContext().getString(R.string.done));
            } else {
                this.fYY.setText(getPageContext().getString(R.string.delete));
            }
        } else {
            this.fYY.setText(this.oeB);
        }
        this.oeA = com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.bIt = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        this.mmq = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.mmp = (LinearLayout) findViewById(R.id.rotate);
        this.mmn = (RadioButton) findViewById(R.id.beautify_btn);
        this.mmo = (RadioButton) findViewById(R.id.rotate_btn);
        this.oey = (RadioGroup) findViewById(R.id.beautify_tabs);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.write.write.WriteImageActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (compoundButton == WriteImageActivity.this.mmn) {
                        WriteImageActivity.this.oev.setVisibility(0);
                        WriteImageActivity.this.mmp.setVisibility(8);
                        WriteImageActivity.this.bIt.setText(WriteImageActivity.this.getPageContext().getString(R.string.beautify));
                    } else if (compoundButton == WriteImageActivity.this.mmo) {
                        WriteImageActivity.this.oev.setVisibility(8);
                        WriteImageActivity.this.mmp.setVisibility(0);
                        WriteImageActivity.this.bIt.setText(WriteImageActivity.this.getPageContext().getString(R.string.rotate));
                    }
                }
            }
        };
        this.mmn.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mmo.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mmn.setChecked(true);
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
                    if ((WriteImageActivity.this.mBitmap != null || WriteImageActivity.this.bFV != null) && view.getTag() != null) {
                        WriteImageActivity.this.mnT = false;
                        WriteImageActivity.this.QX(view.getTag().toString());
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        this.mmq.setVisibility(0);
        this.mmo.setPadding(0, this.mmo.getPaddingTop(), this.mmo.getPaddingRight(), this.mmo.getPaddingBottom());
        this.mmo.setChecked(true);
        this.oev.setVisibility(8);
        this.mmn.setVisibility(8);
        this.oey.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QX(String str) {
        if (this.oex != null) {
            this.oex.cancel();
        }
        this.oex = new a();
        this.oex.execute(str);
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
            WriteImageActivity.this.oeu.setEnabled(false);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.oew = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            WriteImageActivity.this.oeu.setEnabled(true);
            WriteImageActivity.this.oew = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.fZa.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Wc(String str) {
        try {
            n.a(TbConfig.LOCAL_PIC_DIR, str, this.bFV, 90);
            this.fZa.setImageDrawable(null);
            int i = 100;
            if (this.mDisplaySize > 0) {
                i = this.mDisplaySize;
            }
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.bFV, i);
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
        private Boolean mmA;
        private String mmy;
        private Boolean mmz;

        private a() {
            this.mmz = false;
            this.mmA = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.oeu.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public Bitmap doInBackground(String... strArr) {
            this.mmy = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.bFV == null) {
                return null;
            }
            if (this.mmy.equals("0") || this.mmy.equals("1")) {
                this.mmz = true;
            } else if (this.mmy.equals("2") || this.mmy.equals("3")) {
                this.mmA = true;
            }
            if (this.mmz.booleanValue() || this.mmA.booleanValue()) {
                if (WriteImageActivity.this.bFV == null || WriteImageActivity.this.bFV.isRecycled()) {
                    if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                        this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                    }
                } else {
                    this.bitmap = WriteImageActivity.this.bFV.copy(WriteImageActivity.this.bFV.getConfig(), true);
                }
            } else if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            }
            if (this.bitmap != null) {
                if (this.bitmap.getWidth() > 2000 || this.bitmap.getHeight() > 2000) {
                    this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, 2000);
                }
                if (this.mmz.booleanValue()) {
                    this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mmy));
                } else if (this.mmA.booleanValue()) {
                    this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mmy));
                }
                return this.bitmap;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.bFV != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.oeu.setEnabled(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.oeu.setEnabled(true);
            if (bitmap != null && !bitmap.isRecycled()) {
                WriteImageActivity.this.mnT = true;
                WriteImageActivity.this.fZa.setImageBitmap(bitmap);
                if (WriteImageActivity.this.mBitmap != null && (this.mmz.booleanValue() || this.mmA.booleanValue())) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 2000 || WriteImageActivity.this.mBitmap.getHeight() > 2000) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, 2000);
                    }
                    if (this.mmz.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mmy));
                    } else if (this.mmA.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mmy));
                    }
                }
                if (WriteImageActivity.this.bFV != null && !WriteImageActivity.this.bFV.isRecycled()) {
                    WriteImageActivity.this.bFV.recycle();
                }
                WriteImageActivity.this.bFV = bitmap;
            }
        }
    }

    private void cTh() {
        this.oez = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.oez, intentFilter);
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
            if (WriteImageActivity.this.oeu != null) {
                WriteImageActivity.this.oeu.setEnabled(false);
            }
        }
    }
}
