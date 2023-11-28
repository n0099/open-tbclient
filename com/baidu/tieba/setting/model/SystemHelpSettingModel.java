package com.baidu.tieba.setting.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StorageFile;
import com.baidu.tieba.R;
import com.baidu.tieba.i7;
import com.baidu.tieba.m75;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class SystemHelpSettingModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public c b;
    public Context c;
    public BaseActivity.LoadDataCallBack d;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SystemHelpSettingModel a;

        public b(SystemHelpSettingModel systemHelpSettingModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = systemHelpSettingModel;
        }

        public /* synthetic */ b(SystemHelpSettingModel systemHelpSettingModel, a aVar) {
            this(systemHelpSettingModel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().b();
                m75.a();
                try {
                    FileHelper.clearCacheDir("image");
                    FileHelper.clearCacheDir("images");
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921549));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921807));
                    StorageFile.getInstance().clearBubbleCache();
                    return null;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((b) str);
                this.a.a = null;
                if (this.a.d != null) {
                    this.a.d.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<String, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<Context> a;
        public final /* synthetic */ SystemHelpSettingModel b;

        public c(SystemHelpSettingModel systemHelpSettingModel, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {systemHelpSettingModel, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = systemHelpSettingModel;
            this.a = new WeakReference<>(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        @SuppressLint({"DefaultLocale"})
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            long j;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                i7 i7Var = new i7();
                String a = i7Var.a("image", true, false, true);
                String cacheDir = FileHelper.getCacheDir();
                String a2 = i7Var.a("images", true, false, true);
                String str = cacheDir + "voice";
                long directorySize = FileHelper.getDirectorySize(a, false);
                long directorySize2 = FileHelper.getDirectorySize(a2, false);
                long directorySize3 = FileHelper.getDirectorySize(str, false);
                long fileSize = FileHelper.getFileSize(cacheDir + TbConfig.TMP_DATABASE_NAME);
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921548, Long.class);
                if (runTask != null && (runTask.getData() instanceof Long)) {
                    j = ((Long) runTask.getData()).longValue();
                } else {
                    j = 0;
                }
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2921808, Long.class);
                if (runTask2 != null && (runTask2.getData() instanceof Long)) {
                    j2 = ((Long) runTask2.getData()).longValue();
                } else {
                    j2 = 0;
                }
                long j3 = directorySize + directorySize3 + fileSize + directorySize2 + j + j2;
                float f = ((float) j3) + 0.0f;
                if (j3 >= 10485.76d && this.a.get() != null) {
                    return String.format("%.2f", Float.valueOf(f / 1048576.0f)) + this.a.get().getString(R.string.obfuscated_res_0x7f0f0ca3);
                }
                return "";
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((c) str);
                this.b.b = null;
                if (this.b.d != null) {
                    this.b.d.callback(MoreModel.TaskType.GET_SIZE, str);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemHelpSettingModel(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {systemHelpSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.c = systemHelpSettingActivity.getPageContext().getPageActivity();
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            TbadkCoreApplication.getInst().setHeadsetModeOn(z);
        }
    }

    public void V(BaseActivity.LoadDataCallBack loadDataCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, loadDataCallBack) == null) {
            this.d = loadDataCallBack;
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a == null) {
            b bVar = new b(this, null);
            this.a = bVar;
            bVar.execute(new String[0]);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
            }
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.b == null) {
            c cVar = new c(this, this.c);
            this.b = cVar;
            cVar.execute(new String[0]);
        }
    }
}
