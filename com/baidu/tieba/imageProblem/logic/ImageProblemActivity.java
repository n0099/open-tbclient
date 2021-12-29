package com.baidu.tieba.imageProblem.logic;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageProblemAssistant mImageProblemAssistant;
    public CheckTask mTask;
    public ImageProblemView mView;

    /* renamed from: com.baidu.tieba.imageProblem.logic.ImageProblemActivity$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes12.dex */
    public class CheckTask extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageProblemActivity a;

        public CheckTask(ImageProblemActivity imageProblemActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageProblemActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageProblemActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public BdStatSwitchData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                publishProgress(0);
                this.a.mImageProblemAssistant.networkCheck();
                publishProgress(1);
                this.a.mImageProblemAssistant.checkDNSIP();
                publishProgress(2);
                this.a.mImageProblemAssistant.checkProxyIP();
                publishProgress(3);
                this.a.mImageProblemAssistant.networkTest();
                publishProgress(4);
                this.a.mImageProblemAssistant.checkSetting();
                publishProgress(5);
                this.a.mImageProblemAssistant.checkLoadImg();
                publishProgress(6);
                this.a.mImageProblemAssistant.fix();
                publishProgress(7);
                return null;
            }
            return (BdStatSwitchData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdStatSwitchData) == null) {
                super.onPostExecute(bdStatSwitchData);
                this.a.mView.getCheckButton().setText(this.a.getResources().getText(R.string.diagnose));
                this.a.mView.complete();
                this.a.mTask = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Integer... numArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, numArr) == null) {
                super.onProgressUpdate(numArr);
                int intValue = numArr[0].intValue();
                ImageProblemActivity imageProblemActivity = this.a;
                imageProblemActivity.mView.setValue(intValue, imageProblemActivity.mImageProblemAssistant.f47128d);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.mView.start();
            }
        }

        public /* synthetic */ CheckTask(ImageProblemActivity imageProblemActivity, AnonymousClass1 anonymousClass1) {
            this(imageProblemActivity);
        }
    }

    public ImageProblemActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.mView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && view == this.mView.getCheckButton()) {
            if (this.mTask == null) {
                this.mView.getCheckButton().setText(getResources().getText(R.string.stop));
                CheckTask checkTask = new CheckTask(this, null);
                this.mTask = checkTask;
                checkTask.execute(new Object[0]);
                return;
            }
            this.mView.getCheckButton().setText(getResources().getText(R.string.diagnose));
            CheckTask checkTask2 = this.mTask;
            if (checkTask2 != null) {
                checkTask2.cancel();
                this.mTask = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            ImageProblemAssistant imageProblemAssistant = new ImageProblemAssistant(getPageContext().getPageActivity());
            this.mImageProblemAssistant = imageProblemAssistant;
            this.mView = new ImageProblemView(this, imageProblemAssistant);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            CheckTask checkTask = this.mTask;
            if (checkTask != null) {
                checkTask.cancel();
                this.mTask = null;
            }
        }
    }
}
