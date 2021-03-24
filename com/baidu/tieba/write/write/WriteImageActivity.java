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
import com.baidu.searchbox.bddownload.core.breakpoint.sqllite.BreakpointSQLiteKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    public static final String CANCEL_TEXT = "cancel_text";
    public static final String CHANGE_FLAG = "change";
    public static final String DISPLAY_SIZE = "display_size";
    public static final String FILTER_NAME_NORMAL = "normal";
    public static final String FINISH_TEXT = "finish_text";
    public static final String FORUMID = "forumid";
    public static final String FORUMNAME = "foruimname";
    public static final String FROM = "from";
    public static final String FROMCODE = "request";
    public static final int PREVIEW_IMAGE_WIDTH = 300;
    public static final String THREADID = "threadid";
    public RadioButton mBtnBeautify;
    public RadioButton mBtnRotate;
    public String mFinishText;
    public View mNormalFilterView;
    public View mTitleLeftBtn;
    public View mTitleRightBtn;
    public HashMap<String, Bitmap> previewBitmaps;
    public HashMap<String, ImageView> previewImageView;
    public int requestCode;
    public ImageView mImage = null;
    public Bitmap mBitmap = null;
    public TextView mDelete = null;
    public View mParent = null;
    public HorizontalScrollView mBeautifyView = null;
    public ProgressBar mProgress = null;
    public h mTask = null;
    public g mFilterTask = null;
    public RadioGroup mRadioGroup = null;
    public LinearLayout mRotateView = null;
    public LinearLayout mBeautifyRotateView = null;
    public TextView mTitleText = null;
    public NavigationBar mNavigationBar = null;
    public Bitmap mPreparedBitmap = null;
    public i receiver = null;
    public int BOUND = 0;
    public int mDisplaySize = 0;
    public boolean isEdited = false;
    public boolean isFromFrs = false;
    public final Handler mHandler = new Handler();
    public final Object writeLock = new Object();
    public final View.OnClickListener backOnClickListener = new f();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteImageActivity.this.mNavigationBar.getVisibility() == 0) {
                WriteImageActivity.this.mNavigationBar.setVisibility(8);
                WriteImageActivity.this.mBeautifyRotateView.setVisibility(8);
                return;
            }
            WriteImageActivity.this.mNavigationBar.setVisibility(0);
            WriteImageActivity.this.mBeautifyRotateView.setVisibility(0);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.isFromFrs) {
                if (WriteImageActivity.this.requestCode == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() == 0) {
                        return;
                    }
                    if (WriteImageActivity.this.isEdited && WriteImageActivity.this.mPreparedBitmap != null && !WriteImageActivity.this.mPreparedBitmap.isRecycled()) {
                        Date date = new Date();
                        String str = "tieba" + String.valueOf(date.getTime()) + ".jpg";
                        if (WriteImageActivity.this.saveFile(str)) {
                            intent.putExtra(WriteImageActivity.CHANGE_FLAG, true);
                            intent.putExtra("file_name", str);
                        } else {
                            intent.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                        }
                    } else {
                        intent.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                    }
                    WriteImageActivity.this.setResult(-1, intent);
                } else {
                    WriteImageActivity.this.setResult(0, new Intent());
                }
            } else {
                WriteImageActivity.this.setResult(0, new Intent());
            }
            WriteImageActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.isFromFrs) {
                if (WriteImageActivity.this.requestCode == 12003) {
                    Intent intent = new Intent();
                    intent.putExtra("delete", true);
                    WriteImageActivity.this.setResult(-1, intent);
                } else {
                    Intent intent2 = new Intent();
                    if (WriteImageActivity.this.isEdited) {
                        if (WriteImageActivity.this.mPreparedBitmap != null && !WriteImageActivity.this.mPreparedBitmap.isRecycled()) {
                            Date date = new Date();
                            String str = "tieba" + String.valueOf(date.getTime()) + ".jpg";
                            if (WriteImageActivity.this.saveFile(str)) {
                                intent2.putExtra(WriteImageActivity.CHANGE_FLAG, true);
                                intent2.putExtra("file_name", str);
                            } else {
                                intent2.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                            }
                        } else {
                            intent2.putExtra(WriteImageActivity.CHANGE_FLAG, false);
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
            if (WriteImageActivity.this.isEdited && WriteImageActivity.this.mPreparedBitmap != null && !WriteImageActivity.this.mPreparedBitmap.isRecycled()) {
                Date date2 = new Date();
                String str2 = "tieba" + String.valueOf(date2.getTime()) + ".jpg";
                if (WriteImageActivity.this.saveFile(str2)) {
                    intent3.putExtra(BreakpointSQLiteKey.FILENAME, str2);
                }
            }
            WriteImageActivity.this.setResult(-1, intent3);
            WriteImageActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {
        public d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                if (compoundButton == WriteImageActivity.this.mBtnBeautify) {
                    WriteImageActivity.this.mBeautifyView.setVisibility(0);
                    WriteImageActivity.this.mRotateView.setVisibility(8);
                    WriteImageActivity.this.mTitleText.setText(WriteImageActivity.this.getPageContext().getString(R.string.beautify));
                } else if (compoundButton == WriteImageActivity.this.mBtnRotate) {
                    WriteImageActivity.this.mBeautifyView.setVisibility(8);
                    WriteImageActivity.this.mRotateView.setVisibility(0);
                    WriteImageActivity.this.mTitleText.setText(WriteImageActivity.this.getPageContext().getString(R.string.rotate));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteImageActivity.this.mProgress.getVisibility() == 0) {
                return;
            }
            if ((WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.mPreparedBitmap == null) || view.getTag() == null) {
                return;
            }
            WriteImageActivity.this.isEdited = false;
            WriteImageActivity.this.startFilterTask(view.getTag().toString());
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!WriteImageActivity.this.isFromFrs) {
                if (WriteImageActivity.this.requestCode == 12003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() == 0) {
                        return;
                    }
                    if (WriteImageActivity.this.isEdited && WriteImageActivity.this.mPreparedBitmap != null && !WriteImageActivity.this.mPreparedBitmap.isRecycled()) {
                        Date date = new Date();
                        String str = "tieba" + String.valueOf(date.getTime()) + ".jpg";
                        if (WriteImageActivity.this.saveFile(str)) {
                            intent.putExtra(WriteImageActivity.CHANGE_FLAG, true);
                            intent.putExtra("file_name", str);
                        } else {
                            intent.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                        }
                    } else {
                        intent.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                    }
                    WriteImageActivity.this.setResult(-1, intent);
                } else {
                    WriteImageActivity.this.setResult(0, new Intent());
                }
            } else {
                WriteImageActivity.this.setResult(0, new Intent());
            }
            WriteImageActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class g extends BdAsyncTask<String, Void, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public String f22558a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f22559b;

        /* renamed from: c  reason: collision with root package name */
        public Boolean f22560c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f22561d;

        public g() {
            Boolean bool = Boolean.FALSE;
            this.f22560c = bool;
            this.f22561d = bool;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            this.f22558a = strArr[0];
            if (WriteImageActivity.this.mBitmap == null && WriteImageActivity.this.mPreparedBitmap == null) {
                return null;
            }
            if (!this.f22558a.equals("0") && !this.f22558a.equals("1")) {
                if (this.f22558a.equals("2") || this.f22558a.equals("3")) {
                    this.f22561d = Boolean.TRUE;
                }
            } else {
                this.f22560c = Boolean.TRUE;
            }
            if (this.f22560c.booleanValue() || this.f22561d.booleanValue()) {
                if (WriteImageActivity.this.mPreparedBitmap == null || WriteImageActivity.this.mPreparedBitmap.isRecycled()) {
                    if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                        this.f22559b = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
                    }
                } else {
                    this.f22559b = WriteImageActivity.this.mPreparedBitmap.copy(WriteImageActivity.this.mPreparedBitmap.getConfig(), true);
                }
            } else if (!WriteImageActivity.this.mBitmap.isRecycled()) {
                this.f22559b = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            }
            Bitmap bitmap = this.f22559b;
            if (bitmap == null) {
                return null;
            }
            if (bitmap.getWidth() > 2000 || this.f22559b.getHeight() > 2000) {
                this.f22559b = BitmapHelper.resizeBitmap(this.f22559b, 2000);
            }
            if (this.f22560c.booleanValue()) {
                this.f22559b = BitmapHelper.rotateBitmap(this.f22559b, Integer.parseInt(this.f22558a));
            } else if (this.f22561d.booleanValue()) {
                this.f22559b = BitmapHelper.reversalBitmap(this.f22559b, Integer.parseInt(this.f22558a));
            }
            return this.f22559b;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Bitmap bitmap = this.f22559b;
            if (bitmap != null && !bitmap.isRecycled()) {
                Bitmap bitmap2 = WriteImageActivity.this.mPreparedBitmap;
                Bitmap bitmap3 = this.f22559b;
                if (bitmap2 != bitmap3) {
                    bitmap3.recycle();
                }
            }
            this.f22559b = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.mTitleRightBtn.setEnabled(true);
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.mTitleRightBtn.setEnabled(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.mTitleRightBtn.setEnabled(true);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            WriteImageActivity.this.isEdited = true;
            WriteImageActivity.this.mImage.setImageBitmap(bitmap);
            if (WriteImageActivity.this.mBitmap != null && (this.f22560c.booleanValue() || this.f22561d.booleanValue())) {
                if (WriteImageActivity.this.mBitmap.getWidth() > 2000 || WriteImageActivity.this.mBitmap.getHeight() > 2000) {
                    WriteImageActivity writeImageActivity = WriteImageActivity.this;
                    writeImageActivity.mBitmap = BitmapHelper.resizeBitmap(writeImageActivity.mBitmap, 2000);
                }
                if (this.f22560c.booleanValue()) {
                    WriteImageActivity writeImageActivity2 = WriteImageActivity.this;
                    writeImageActivity2.mBitmap = BitmapHelper.rotateBitmap(writeImageActivity2.mBitmap, Integer.parseInt(this.f22558a));
                } else if (this.f22561d.booleanValue()) {
                    WriteImageActivity writeImageActivity3 = WriteImageActivity.this;
                    writeImageActivity3.mBitmap = BitmapHelper.reversalBitmap(writeImageActivity3.mBitmap, Integer.parseInt(this.f22558a));
                }
            }
            if (WriteImageActivity.this.mPreparedBitmap != null && !WriteImageActivity.this.mPreparedBitmap.isRecycled()) {
                WriteImageActivity.this.mPreparedBitmap.recycle();
            }
            WriteImageActivity.this.mPreparedBitmap = bitmap;
        }

        public /* synthetic */ g(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public class h extends BdAsyncTask<Object, Integer, Bitmap> {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Object... objArr) {
            Bitmap bitmap;
            Exception e2;
            try {
                bitmap = FileHelper.getImage(null, TbConfig.IMAGE_RESIZED_FILE);
            } catch (Exception e3) {
                bitmap = null;
                e2 = e3;
            }
            try {
                if (isCancelled() && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                    return null;
                }
            } catch (Exception e4) {
                e2 = e4;
                e2.printStackTrace();
                BdLog.e(e2.toString());
                return bitmap;
            }
            return bitmap;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            WriteImageActivity.this.mTask = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.mTitleRightBtn.setEnabled(false);
            super.onPreExecute();
        }

        public /* synthetic */ h(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((h) bitmap);
            WriteImageActivity.this.mTitleRightBtn.setEnabled(true);
            WriteImageActivity.this.mTask = null;
            WriteImageActivity.this.mBitmap = bitmap;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            WriteImageActivity.this.mImage.setImageBitmap(bitmap);
        }
    }

    /* loaded from: classes5.dex */
    public class i extends BroadcastReceiver {
        public i() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WriteImageActivity.this.releaseResouce();
            if (intent.getBooleanExtra("result", false)) {
                WriteImageActivity.this.initData();
                return;
            }
            WriteImageActivity.this.showToast(intent.getStringExtra("error"));
            if (WriteImageActivity.this.mTitleRightBtn != null) {
                WriteImageActivity.this.mTitleRightBtn.setEnabled(false);
            }
        }

        public /* synthetic */ i(WriteImageActivity writeImageActivity, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        h hVar = this.mTask;
        if (hVar != null) {
            hVar.cancel();
        }
        h hVar2 = new h(this, null);
        this.mTask = hVar2;
        hVar2.execute(new Object[0]);
    }

    private void initUI() {
        this.mParent = findViewById(R.id.write_image_root_layout);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        this.mProgress = progressBar;
        progressBar.setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        this.mImage = imageView;
        imageView.setOnClickListener(new a());
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            this.mImage.setImageBitmap(bitmap);
        }
        this.mBeautifyView = (HorizontalScrollView) findViewById(R.id.filters_layout);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        this.mTitleLeftBtn = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b());
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, (View.OnClickListener) null);
        this.mTitleRightBtn = addCustomView;
        addCustomView.setOnClickListener(new c());
        this.mDelete = (TextView) this.mTitleRightBtn.findViewById(R.id.save);
        if (TextUtils.isEmpty(this.mFinishText)) {
            if (!this.isFromFrs && this.requestCode == 12003) {
                this.mDelete.setText(getPageContext().getString(R.string.delete));
            } else {
                this.mDelete.setText(getPageContext().getString(R.string.done));
            }
        } else {
            this.mDelete.setText(this.mFinishText);
        }
        this.BOUND = l.e(getPageContext().getPageActivity(), 2.0f);
        this.mTitleText = this.mNavigationBar.setTitleText(getPageContext().getString(R.string.beautify));
        this.mBeautifyRotateView = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.mRotateView = (LinearLayout) findViewById(R.id.rotate);
        this.mBtnBeautify = (RadioButton) findViewById(R.id.beautify_btn);
        this.mBtnRotate = (RadioButton) findViewById(R.id.rotate_btn);
        this.mRadioGroup = (RadioGroup) findViewById(R.id.beautify_tabs);
        d dVar = new d();
        this.mBtnBeautify.setOnCheckedChangeListener(dVar);
        this.mBtnRotate.setOnCheckedChangeListener(dVar);
        this.mBtnBeautify.setChecked(true);
        Button button = (Button) findViewById(R.id.rotate_left);
        Button button2 = (Button) findViewById(R.id.rotate_right);
        Button button3 = (Button) findViewById(R.id.rotate_left_right);
        Button button4 = (Button) findViewById(R.id.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        e eVar = new e();
        button.setOnClickListener(eVar);
        button2.setOnClickListener(eVar);
        button3.setOnClickListener(eVar);
        button4.setOnClickListener(eVar);
        this.mBeautifyRotateView.setVisibility(0);
        RadioButton radioButton = this.mBtnRotate;
        radioButton.setPadding(0, radioButton.getPaddingTop(), this.mBtnRotate.getPaddingRight(), this.mBtnRotate.getPaddingBottom());
        this.mBtnRotate.setChecked(true);
        this.mBeautifyView.setVisibility(8);
        this.mBtnBeautify.setVisibility(8);
        this.mRadioGroup.setVisibility(8);
    }

    private void regReceiver() {
        this.receiver = new i(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.receiver, intentFilter);
    }

    private void releasePreviewResouce() {
        synchronized (this.writeLock) {
            if (this.previewImageView != null) {
                for (Map.Entry<String, ImageView> entry : this.previewImageView.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageDrawable(null);
                    }
                }
                this.previewImageView.clear();
                this.previewImageView = null;
            }
            if (this.previewBitmaps != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.previewBitmaps.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.previewBitmaps.clear();
                this.previewBitmaps = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveFile(String str) {
        try {
            FileHelper.SaveFile(TbConfig.LOCAL_PIC_DIR, str, this.mPreparedBitmap, 90);
            this.mImage.setImageDrawable(null);
            Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.mPreparedBitmap, this.mDisplaySize > 0 ? this.mDisplaySize : 100);
            if (resizeBitmap != null) {
                return FileHelper.SaveFile(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null;
            }
            return false;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFilterTask(String str) {
        g gVar = this.mFilterTask;
        if (gVar != null) {
            gVar.cancel();
        }
        g gVar2 = new g(this, null);
        this.mFilterTask = gVar2;
        gVar2.execute(str);
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(this.mParent);
        SkinManager.setBackgroundColor(this.mNavigationBar, R.color.common_color_10222);
        SkinManager.setViewTextColor(this.mTitleText, R.color.CAM_X0111, 1);
        if (this.mTitleRightBtn.isEnabled()) {
            this.mDelete.setTextColor(getResources().getColor(R.color.navi_done_text));
        } else {
            this.mDelete.setTextColor(getResources().getColor(R.color.common_color_10231));
        }
        NavigationBar navigationBar = this.mNavigationBar;
        if (navigationBar != null) {
            navigationBar.onBackBtnOnChangeSkin();
        }
        int i3 = R.drawable.icon_topbar_return_s;
        SkinManager.setNavbarIconSrc((ImageView) ((ViewGroup) this.mTitleLeftBtn).getChildAt(0), i3, i3);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WriteImageActivityConfig.isActivityInStack = true;
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(getPageContext().getOrignalPage());
        setContentView(R.layout.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra("request", 0);
        this.mDisplaySize = intent.getIntExtra("display_size", 0);
        this.mFinishText = intent.getStringExtra("finish_text");
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.isFromFrs = true;
        }
        String stringExtra = intent.getStringExtra("file_name");
        int i2 = this.requestCode;
        if (i2 != 12002 && i2 != 12001) {
            initUI();
            initData();
            return;
        }
        initUI();
        if (intent.getData() != null) {
            TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), TbImageHelper.getInstance().getPostImageSize(), this.mDisplaySize);
        } else {
            TiebaPrepareImageService.StartService(this.requestCode, null, TbImageHelper.getInstance().getPostImageSize(), this.mDisplaySize, stringExtra);
        }
        regReceiver();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        WriteImageActivityConfig.isActivityInStack = false;
        TiebaPrepareImageService.StopService();
        releaseResouce();
        super.onDestroy();
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        Bitmap bitmap2 = this.mPreparedBitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.mPreparedBitmap.recycle();
            this.mPreparedBitmap = null;
        }
        h hVar = this.mTask;
        if (hVar != null) {
            hVar.cancel();
            this.mTask = null;
        }
        this.mProgress.setVisibility(8);
        int i2 = this.requestCode;
        if (i2 == 12002 || i2 == 12001) {
            unregisterReceiver(this.receiver);
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.backOnClickListener.onClick(null);
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        h hVar = this.mTask;
        if (hVar != null) {
            hVar.cancel();
        }
        this.mImage.setImageDrawable(null);
        releasePreviewResouce();
    }
}
