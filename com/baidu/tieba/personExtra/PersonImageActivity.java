package com.baidu.tieba.personExtra;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.mi;
import com.repackage.pr4;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PersonImageActivity extends BaseActivity<PersonImageActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PAGE_LIMIT = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ImageUrlData> assistUrls;
    public String curImgUrl;
    public Context mContext;
    public pr4.c mDialogClickListener;
    public MultiImageView mMultiImageView;
    public View.OnClickListener mOnClickListener;
    public View.OnLongClickListener mOnLongClickListener;
    public BaseViewPager.a mOnscOnScrollOutListener;
    public ProgressBar mProgress;
    public e mSaveImageTask;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonImageActivity a;

        public a(PersonImageActivity personImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonImageActivity a;

        public b(PersonImageActivity personImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personImageActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f107c)};
                PersonImageActivity personImageActivity = this.a;
                personImageActivity.createListMenu(strArr, personImageActivity.mDialogClickListener);
                this.a.showListMenu();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements pr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonImageActivity a;

        public c(PersonImageActivity personImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personImageActivity;
        }

        @Override // com.repackage.pr4.c
        public void a(pr4 pr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, pr4Var, i, view2) == null) && pr4Var == this.a.getListMenu()) {
                if (i == 0) {
                    try {
                        byte[] currentImageData = this.a.mMultiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            String currentImageUrl = this.a.mMultiImageView.getCurrentImageUrl();
                            this.a.mSaveImageTask = new e(this.a, currentImageUrl, currentImageData);
                            this.a.mSaveImageTask.execute(new String[0]);
                            this.a.mProgress.setVisibility(0);
                        } else {
                            this.a.showToast(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c43));
                        }
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                }
                pr4Var.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements BaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonImageActivity a;

        public d(PersonImageActivity personImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personImageActivity;
        }

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public byte[] b;
        public final /* synthetic */ PersonImageActivity c;

        public e(PersonImageActivity personImageActivity, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personImageActivity, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = personImageActivity;
            this.a = null;
            this.b = null;
            this.a = str;
            this.b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.mSaveImageTask = null;
                this.c.mProgress.setVisibility(8);
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
                int saveImageFileByUser = FileHelper.saveImageFileByUser(this.a, this.b, this.c.getPageContext().getPageActivity());
                if (saveImageFileByUser != -2) {
                    if (saveImageFileByUser != 0) {
                        return this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1081);
                    }
                    return this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1082);
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
                this.c.showToast(str);
                this.c.mSaveImageTask = null;
                this.c.mProgress.setVisibility(8);
            }
        }
    }

    public PersonImageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.mProgress = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091975);
            MultiImageView multiImageView = (MultiImageView) findViewById(R.id.obfuscated_res_0x7f092412);
            this.mMultiImageView = multiImageView;
            multiImageView.setPageMargin(mi.d(getPageContext().getPageActivity(), 8.0f));
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
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            if (i != 1 && i != 4) {
                this.mMultiImageView.setBackgroundColor(-16777216);
            } else {
                this.mMultiImageView.setBackgroundColor(SkinManager.getBgColor(i));
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
            setContentView(R.layout.obfuscated_res_0x7f0d06b5);
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
            this.mMultiImageView.v();
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
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, keyEvent)) == null) {
            if (i == 4) {
                finish();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            this.mMultiImageView.w();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            this.mMultiImageView.x();
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
            this.mMultiImageView.v();
        }
    }
}
