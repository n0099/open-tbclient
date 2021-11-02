package com.baidu.tieba.personExtra;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.s.s.b;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class PersonImageActivity extends BaseActivity<PersonImageActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PAGE_LIMIT = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ImageUrlData> assistUrls;
    public String curImgUrl;
    public Context mContext;
    public b.c mDialogClickListener;
    public MultiImageView mMultiImageView;
    public View.OnClickListener mOnClickListener;
    public View.OnLongClickListener mOnLongClickListener;
    public BaseViewPager.a mOnscOnScrollOutListener;
    public ProgressBar mProgress;
    public e mSaveImageTask;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonImageActivity f53143e;

        public a(PersonImageActivity personImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53143e = personImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53143e.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonImageActivity f53144e;

        public b(PersonImageActivity personImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53144e = personImageActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                String[] strArr = {this.f53144e.getPageContext().getString(R.string.save)};
                PersonImageActivity personImageActivity = this.f53144e;
                personImageActivity.createListMenu(strArr, personImageActivity.mDialogClickListener);
                this.f53144e.showListMenu();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonImageActivity f53145a;

        public c(PersonImageActivity personImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53145a = personImageActivity;
        }

        @Override // b.a.q0.s.s.b.c
        public void a(b.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) && bVar == this.f53145a.getListMenu()) {
                if (i2 == 0) {
                    try {
                        byte[] currentImageData = this.f53145a.mMultiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            String currentImageUrl = this.f53145a.mMultiImageView.getCurrentImageUrl();
                            this.f53145a.mSaveImageTask = new e(this.f53145a, currentImageUrl, currentImageData);
                            this.f53145a.mSaveImageTask.execute(new String[0]);
                            this.f53145a.mProgress.setVisibility(0);
                        } else {
                            this.f53145a.showToast(this.f53145a.getPageContext().getString(R.string.no_data));
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                bVar.e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements BaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonImageActivity f53146a;

        public d(PersonImageActivity personImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53146a = personImageActivity;
        }

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f53147a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f53148b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PersonImageActivity f53149c;

        public e(PersonImageActivity personImageActivity, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personImageActivity, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53149c = personImageActivity;
            this.f53147a = null;
            this.f53148b = null;
            this.f53147a = str;
            this.f53148b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53149c.mSaveImageTask = null;
                this.f53149c.mProgress.setVisibility(8);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                int saveImageFileByUser = FileHelper.saveImageFileByUser(this.f53147a, this.f53148b, this.f53149c.getPageContext().getPageActivity());
                if (saveImageFileByUser != -2) {
                    if (saveImageFileByUser != 0) {
                        return this.f53149c.getPageContext().getString(R.string.save_fail);
                    }
                    return this.f53149c.getPageContext().getString(R.string.save_image_to_album);
                }
                return FileHelper.getSdErrorString();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                super.onPostExecute((e) str);
                this.f53149c.showToast(str);
                this.f53149c.mSaveImageTask = null;
                this.f53149c.mProgress.setVisibility(8);
            }
        }
    }

    public PersonImageActivity() {
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
        this.mProgress = null;
        this.mSaveImageTask = null;
        this.mMultiImageView = null;
        this.mOnClickListener = null;
        this.mOnLongClickListener = null;
        this.mDialogClickListener = null;
        this.mOnscOnScrollOutListener = null;
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, bundle) == null) {
            if (bundle != null) {
                this.curImgUrl = bundle.getString("curImgUrl");
                this.assistUrls = (HashMap) bundle.getSerializable("assistUrls");
                return;
            }
            Intent intent = getIntent();
            if (intent != null) {
                this.curImgUrl = intent.getStringExtra("curImgUrl");
                this.assistUrls = (HashMap) intent.getSerializableExtra("assistUrls");
            }
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.mOnClickListener = new a(this);
            this.mOnLongClickListener = new b(this);
            this.mDialogClickListener = new c(this);
            this.mOnscOnScrollOutListener = new d(this);
            this.mProgress = (ProgressBar) findViewById(R.id.progress);
            MultiImageView multiImageView = (MultiImageView) findViewById(R.id.viewpager);
            this.mMultiImageView = multiImageView;
            multiImageView.setPageMargin(l.e(getPageContext().getPageActivity(), 8.0f));
            this.mMultiImageView.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
            this.mMultiImageView.setItemOnclickListener(this.mOnClickListener);
            this.mMultiImageView.setItemOnLongClickListener(this.mOnLongClickListener);
            this.mMultiImageView.setCurrentItem(0, false);
            this.mMultiImageView.setOnScrollOutListener(this.mOnscOnScrollOutListener);
            this.mMultiImageView.setHasNext(false);
            this.mMultiImageView.setNextTitle("mNextTitle");
            this.mMultiImageView.setHeadImage(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (i2 != 1 && i2 != 4) {
                this.mMultiImageView.setBackgroundColor(-16777216);
            } else {
                this.mMultiImageView.setBackgroundColor(SkinManager.getBgColor(i2));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.mMultiImageView.setCurrentItem(0, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            setContentView(R.layout.person_image_activity);
            initData(bundle);
            initUI();
            ArrayList<String> arrayList = new ArrayList<>();
            this.mContext = getPageContext().getPageActivity();
            arrayList.add(this.curImgUrl);
            this.mMultiImageView.setIsFromCDN(true);
            this.mMultiImageView.setAllowLocalUrl(true);
            this.mMultiImageView.setAssistUrls(this.assistUrls);
            this.mMultiImageView.setUrlData(arrayList);
            this.mMultiImageView.setCurrentItem(0, false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            this.mMultiImageView.onDestroy();
            e eVar = this.mSaveImageTask;
            if (eVar != null) {
                eVar.cancel();
                this.mSaveImageTask = null;
            }
            ProgressBar progressBar = this.mProgress;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                finish();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            this.mMultiImageView.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            this.mMultiImageView.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("curImgUrl", this.curImgUrl);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mMultiImageView.onDestroy();
        }
    }
}
