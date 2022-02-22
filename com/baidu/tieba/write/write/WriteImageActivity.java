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
import c.a.d.f.p.n;
import c.a.u0.s4.j;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes13.dex */
public class WriteImageActivity extends BaseActivity<WriteImageActivity> {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public int BOUND;
    public final View.OnClickListener backOnClickListener;
    public boolean isEdited;
    public boolean isFromFrs;
    public LinearLayout mBeautifyRotateView;
    public HorizontalScrollView mBeautifyView;
    public Bitmap mBitmap;
    public RadioButton mBtnBeautify;
    public RadioButton mBtnRotate;
    public TextView mDelete;
    public int mDisplaySize;
    public g mFilterTask;
    public String mFinishText;
    public final Handler mHandler;
    public ImageView mImage;
    public NavigationBar mNavigationBar;
    public View mNormalFilterView;
    public View mParent;
    public Bitmap mPreparedBitmap;
    public ProgressBar mProgress;
    public RadioGroup mRadioGroup;
    public LinearLayout mRotateView;
    public h mTask;
    public View mTitleLeftBtn;
    public View mTitleRightBtn;
    public TextView mTitleText;
    public HashMap<String, Bitmap> previewBitmaps;
    public HashMap<String, ImageView> previewImageView;
    public i receiver;
    public int requestCode;
    public final Object writeLock;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteImageActivity f50074e;

        public a(WriteImageActivity writeImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50074e = writeImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f50074e.mNavigationBar.getVisibility() == 0) {
                    this.f50074e.mNavigationBar.setVisibility(8);
                    this.f50074e.mBeautifyRotateView.setVisibility(8);
                    return;
                }
                this.f50074e.mNavigationBar.setVisibility(0);
                this.f50074e.mBeautifyRotateView.setVisibility(0);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteImageActivity f50075e;

        public b(WriteImageActivity writeImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50075e = writeImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f50075e.isFromFrs) {
                    if (this.f50075e.requestCode == 12003) {
                        Intent intent = new Intent();
                        if (this.f50075e.mProgress.getVisibility() == 0) {
                            return;
                        }
                        if (this.f50075e.isEdited && this.f50075e.mPreparedBitmap != null && !this.f50075e.mPreparedBitmap.isRecycled()) {
                            Date date = new Date();
                            String str = "tieba" + String.valueOf(date.getTime()) + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
                            if (this.f50075e.saveFile(str)) {
                                intent.putExtra(WriteImageActivity.CHANGE_FLAG, true);
                                intent.putExtra("file_name", str);
                            } else {
                                intent.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                            }
                        } else {
                            intent.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                        }
                        this.f50075e.setResult(-1, intent);
                    } else {
                        this.f50075e.setResult(0, new Intent());
                    }
                } else {
                    this.f50075e.setResult(0, new Intent());
                }
                this.f50075e.finish();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteImageActivity f50076e;

        public c(WriteImageActivity writeImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50076e = writeImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f50076e.isFromFrs) {
                    if (this.f50076e.requestCode == 12003) {
                        Intent intent = new Intent();
                        intent.putExtra("delete", true);
                        this.f50076e.setResult(-1, intent);
                    } else {
                        Intent intent2 = new Intent();
                        if (this.f50076e.isEdited) {
                            if (this.f50076e.mPreparedBitmap != null && !this.f50076e.mPreparedBitmap.isRecycled()) {
                                Date date = new Date();
                                String str = "tieba" + String.valueOf(date.getTime()) + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
                                if (this.f50076e.saveFile(str)) {
                                    intent2.putExtra(WriteImageActivity.CHANGE_FLAG, true);
                                    intent2.putExtra("file_name", str);
                                } else {
                                    intent2.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                                }
                            } else {
                                intent2.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                            }
                        } else {
                            intent2.setData(this.f50076e.getIntent().getData());
                            this.f50076e.setResult(-1, intent2);
                        }
                        this.f50076e.setResult(-1, intent2);
                    }
                    this.f50076e.finish();
                    return;
                }
                Intent intent3 = new Intent();
                if (this.f50076e.isEdited && this.f50076e.mPreparedBitmap != null && !this.f50076e.mPreparedBitmap.isRecycled()) {
                    Date date2 = new Date();
                    String str2 = "tieba" + String.valueOf(date2.getTime()) + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
                    if (this.f50076e.saveFile(str2)) {
                        intent3.putExtra(BreakpointSQLiteKey.FILENAME, str2);
                    }
                }
                this.f50076e.setResult(-1, intent3);
                this.f50076e.finish();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteImageActivity f50077e;

        public d(WriteImageActivity writeImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50077e = writeImageActivity;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                if (compoundButton == this.f50077e.mBtnBeautify) {
                    this.f50077e.mBeautifyView.setVisibility(0);
                    this.f50077e.mRotateView.setVisibility(8);
                    this.f50077e.mTitleText.setText(this.f50077e.getPageContext().getString(j.beautify));
                } else if (compoundButton == this.f50077e.mBtnRotate) {
                    this.f50077e.mBeautifyView.setVisibility(8);
                    this.f50077e.mRotateView.setVisibility(0);
                    this.f50077e.mTitleText.setText(this.f50077e.getPageContext().getString(j.rotate));
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteImageActivity f50078e;

        public e(WriteImageActivity writeImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50078e = writeImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50078e.mProgress.getVisibility() == 0) {
                return;
            }
            if ((this.f50078e.mBitmap == null && this.f50078e.mPreparedBitmap == null) || view.getTag() == null) {
                return;
            }
            this.f50078e.isEdited = false;
            this.f50078e.startFilterTask(view.getTag().toString());
        }
    }

    /* loaded from: classes13.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteImageActivity f50079e;

        public f(WriteImageActivity writeImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50079e = writeImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f50079e.isFromFrs) {
                    if (this.f50079e.requestCode == 12003) {
                        Intent intent = new Intent();
                        if (this.f50079e.mProgress.getVisibility() == 0) {
                            return;
                        }
                        if (this.f50079e.isEdited && this.f50079e.mPreparedBitmap != null && !this.f50079e.mPreparedBitmap.isRecycled()) {
                            Date date = new Date();
                            String str = "tieba" + String.valueOf(date.getTime()) + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
                            if (this.f50079e.saveFile(str)) {
                                intent.putExtra(WriteImageActivity.CHANGE_FLAG, true);
                                intent.putExtra("file_name", str);
                            } else {
                                intent.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                            }
                        } else {
                            intent.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                        }
                        this.f50079e.setResult(-1, intent);
                    } else {
                        this.f50079e.setResult(0, new Intent());
                    }
                } else {
                    this.f50079e.setResult(0, new Intent());
                }
                this.f50079e.finish();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class g extends BdAsyncTask<String, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f50080b;

        /* renamed from: c  reason: collision with root package name */
        public Boolean f50081c;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f50082d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteImageActivity f50083e;

        public g(WriteImageActivity writeImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50083e = writeImageActivity;
            Boolean bool = Boolean.FALSE;
            this.f50081c = bool;
            this.f50082d = bool;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.a = strArr[0];
                if (this.f50083e.mBitmap == null && this.f50083e.mPreparedBitmap == null) {
                    return null;
                }
                if (!this.a.equals("0") && !this.a.equals("1")) {
                    if (this.a.equals("2") || this.a.equals("3")) {
                        this.f50082d = Boolean.TRUE;
                    }
                } else {
                    this.f50081c = Boolean.TRUE;
                }
                if (this.f50081c.booleanValue() || this.f50082d.booleanValue()) {
                    if (this.f50083e.mPreparedBitmap == null || this.f50083e.mPreparedBitmap.isRecycled()) {
                        if (!this.f50083e.mBitmap.isRecycled()) {
                            this.f50080b = this.f50083e.mBitmap.copy(this.f50083e.mBitmap.getConfig(), true);
                        }
                    } else {
                        this.f50080b = this.f50083e.mPreparedBitmap.copy(this.f50083e.mPreparedBitmap.getConfig(), true);
                    }
                } else if (!this.f50083e.mBitmap.isRecycled()) {
                    this.f50080b = this.f50083e.mBitmap.copy(this.f50083e.mBitmap.getConfig(), true);
                }
                Bitmap bitmap = this.f50080b;
                if (bitmap == null) {
                    return null;
                }
                if (bitmap.getWidth() > 2000 || this.f50080b.getHeight() > 2000) {
                    this.f50080b = BitmapHelper.resizeBitmap(this.f50080b, 2000);
                }
                if (this.f50081c.booleanValue()) {
                    this.f50080b = BitmapHelper.rotateBitmap(this.f50080b, Integer.parseInt(this.a));
                } else if (this.f50082d.booleanValue()) {
                    this.f50080b = BitmapHelper.reversalBitmap(this.f50080b, Integer.parseInt(this.a));
                }
                return this.f50080b;
            }
            return (Bitmap) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Bitmap bitmap = this.f50080b;
                if (bitmap != null && !bitmap.isRecycled()) {
                    Bitmap bitmap2 = this.f50083e.mPreparedBitmap;
                    Bitmap bitmap3 = this.f50080b;
                    if (bitmap2 != bitmap3) {
                        bitmap3.recycle();
                    }
                }
                this.f50080b = null;
                this.f50083e.mProgress.setVisibility(8);
                this.f50083e.mTitleRightBtn.setEnabled(true);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f50083e.mProgress.setVisibility(0);
                this.f50083e.mTitleRightBtn.setEnabled(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                this.f50083e.mProgress.setVisibility(8);
                this.f50083e.mTitleRightBtn.setEnabled(true);
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                this.f50083e.isEdited = true;
                this.f50083e.mImage.setImageBitmap(bitmap);
                if (this.f50083e.mBitmap != null && (this.f50081c.booleanValue() || this.f50082d.booleanValue())) {
                    if (this.f50083e.mBitmap.getWidth() > 2000 || this.f50083e.mBitmap.getHeight() > 2000) {
                        WriteImageActivity writeImageActivity = this.f50083e;
                        writeImageActivity.mBitmap = BitmapHelper.resizeBitmap(writeImageActivity.mBitmap, 2000);
                    }
                    if (this.f50081c.booleanValue()) {
                        WriteImageActivity writeImageActivity2 = this.f50083e;
                        writeImageActivity2.mBitmap = BitmapHelper.rotateBitmap(writeImageActivity2.mBitmap, Integer.parseInt(this.a));
                    } else if (this.f50082d.booleanValue()) {
                        WriteImageActivity writeImageActivity3 = this.f50083e;
                        writeImageActivity3.mBitmap = BitmapHelper.reversalBitmap(writeImageActivity3.mBitmap, Integer.parseInt(this.a));
                    }
                }
                if (this.f50083e.mPreparedBitmap != null && !this.f50083e.mPreparedBitmap.isRecycled()) {
                    this.f50083e.mPreparedBitmap.recycle();
                }
                this.f50083e.mPreparedBitmap = bitmap;
            }
        }

        public /* synthetic */ g(WriteImageActivity writeImageActivity, a aVar) {
            this(writeImageActivity);
        }
    }

    /* loaded from: classes13.dex */
    public class h extends BdAsyncTask<Object, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteImageActivity a;

        public h(WriteImageActivity writeImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeImageActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Bitmap bitmap;
            Exception e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
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
            return (Bitmap) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.mTask = null;
                this.a.mProgress.setVisibility(8);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.mProgress.setVisibility(0);
                this.a.mTitleRightBtn.setEnabled(false);
                super.onPreExecute();
            }
        }

        public /* synthetic */ h(WriteImageActivity writeImageActivity, a aVar) {
            this(writeImageActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                super.onPostExecute((h) bitmap);
                this.a.mTitleRightBtn.setEnabled(true);
                this.a.mTask = null;
                this.a.mBitmap = bitmap;
                this.a.mProgress.setVisibility(8);
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                this.a.mImage.setImageBitmap(bitmap);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class i extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteImageActivity this$0;

        public i(WriteImageActivity writeImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = writeImageActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.releaseResouce();
                if (intent.getBooleanExtra("result", false)) {
                    this.this$0.initData();
                    return;
                }
                this.this$0.showToast(intent.getStringExtra("error"));
                if (this.this$0.mTitleRightBtn != null) {
                    this.this$0.mTitleRightBtn.setEnabled(false);
                }
            }
        }

        public /* synthetic */ i(WriteImageActivity writeImageActivity, a aVar) {
            this(writeImageActivity);
        }
    }

    public WriteImageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mImage = null;
        this.mBitmap = null;
        this.mDelete = null;
        this.mParent = null;
        this.mBeautifyView = null;
        this.mProgress = null;
        this.mTask = null;
        this.mFilterTask = null;
        this.mRadioGroup = null;
        this.mRotateView = null;
        this.mBeautifyRotateView = null;
        this.mTitleText = null;
        this.mNavigationBar = null;
        this.mPreparedBitmap = null;
        this.receiver = null;
        this.BOUND = 0;
        this.mDisplaySize = 0;
        this.isEdited = false;
        this.isFromFrs = false;
        this.mHandler = new Handler();
        this.writeLock = new Object();
        this.backOnClickListener = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            h hVar = this.mTask;
            if (hVar != null) {
                hVar.cancel();
            }
            h hVar2 = new h(this, null);
            this.mTask = hVar2;
            hVar2.execute(new Object[0]);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.mParent = findViewById(c.a.u0.s4.g.write_image_root_layout);
            ProgressBar progressBar = (ProgressBar) findViewById(c.a.u0.s4.g.progress);
            this.mProgress = progressBar;
            progressBar.setVisibility(8);
            ImageView imageView = (ImageView) findViewById(c.a.u0.s4.g.image);
            this.mImage = imageView;
            imageView.setOnClickListener(new a(this));
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                this.mImage.setImageBitmap(bitmap);
            }
            this.mBeautifyView = (HorizontalScrollView) findViewById(c.a.u0.s4.g.filters_layout);
            NavigationBar navigationBar = (NavigationBar) findViewById(c.a.u0.s4.g.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            this.mTitleLeftBtn = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, c.a.u0.s4.h.image_activity_save_button, (View.OnClickListener) null);
            this.mTitleRightBtn = addCustomView;
            addCustomView.setOnClickListener(new c(this));
            this.mDelete = (TextView) this.mTitleRightBtn.findViewById(c.a.u0.s4.g.save);
            if (TextUtils.isEmpty(this.mFinishText)) {
                if (!this.isFromFrs && this.requestCode == 12003) {
                    this.mDelete.setText(getPageContext().getString(j.delete));
                } else {
                    this.mDelete.setText(getPageContext().getString(j.done));
                }
            } else {
                this.mDelete.setText(this.mFinishText);
            }
            this.BOUND = n.d(getPageContext().getPageActivity(), 2.0f);
            this.mTitleText = this.mNavigationBar.setTitleText(getPageContext().getString(j.beautify));
            this.mBeautifyRotateView = (LinearLayout) findViewById(c.a.u0.s4.g.beautify_rotate);
            this.mRotateView = (LinearLayout) findViewById(c.a.u0.s4.g.rotate);
            this.mBtnBeautify = (RadioButton) findViewById(c.a.u0.s4.g.beautify_btn);
            this.mBtnRotate = (RadioButton) findViewById(c.a.u0.s4.g.rotate_btn);
            this.mRadioGroup = (RadioGroup) findViewById(c.a.u0.s4.g.beautify_tabs);
            d dVar = new d(this);
            this.mBtnBeautify.setOnCheckedChangeListener(dVar);
            this.mBtnRotate.setOnCheckedChangeListener(dVar);
            this.mBtnBeautify.setChecked(true);
            Button button = (Button) findViewById(c.a.u0.s4.g.rotate_left);
            Button button2 = (Button) findViewById(c.a.u0.s4.g.rotate_right);
            Button button3 = (Button) findViewById(c.a.u0.s4.g.rotate_left_right);
            Button button4 = (Button) findViewById(c.a.u0.s4.g.rotate_up_down);
            button.setTag(0);
            button2.setTag(1);
            button3.setTag(2);
            button4.setTag(3);
            e eVar = new e(this);
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
    }

    private void regReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.receiver = new i(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
            registerReceiver(this.receiver, intentFilter);
        }
    }

    private void releasePreviewResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, str)) == null) {
            try {
                FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_PIC_DIR, str, this.mPreparedBitmap, 90);
                this.mImage.setImageDrawable(null);
                Bitmap resizeBitmap = BitmapHelper.resizeBitmap(this.mPreparedBitmap, this.mDisplaySize > 0 ? this.mDisplaySize : 100);
                if (resizeBitmap != null) {
                    return FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null;
                }
                return false;
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFilterTask(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, str) == null) {
            g gVar = this.mFilterTask;
            if (gVar != null) {
                gVar.cancel();
            }
            g gVar2 = new g(this, null);
            this.mFilterTask = gVar2;
            gVar2.execute(str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mParent);
            SkinManager.setBackgroundColor(this.mNavigationBar, c.a.u0.s4.d.common_color_10222);
            SkinManager.setViewTextColor(this.mTitleText, c.a.u0.s4.d.CAM_X0111, 1);
            if (this.mTitleRightBtn.isEnabled()) {
                this.mDelete.setTextColor(getResources().getColor(c.a.u0.s4.d.navi_done_text));
            } else {
                this.mDelete.setTextColor(getResources().getColor(c.a.u0.s4.d.common_color_10231));
            }
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.onBackBtnOnChangeSkin();
            }
            int i3 = c.a.u0.s4.f.icon_topbar_return_s;
            SkinManager.setNavbarIconSrc((ImageView) ((ViewGroup) this.mTitleLeftBtn).getChildAt(0), i3, i3);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            WriteImageActivityConfig.isActivityInStack = true;
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(getPageContext().getOrignalPage());
            setContentView(c.a.u0.s4.h.write_image_activity);
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                this.backOnClickListener.onClick(null);
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h hVar = this.mTask;
            if (hVar != null) {
                hVar.cancel();
            }
            this.mImage.setImageDrawable(null);
            releasePreviewResouce();
        }
    }
}
