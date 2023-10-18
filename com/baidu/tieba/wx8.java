package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearchlib.Info;
import com.baidu.clientupdate.ClientUpdater;
import com.baidu.clientupdate.IClientUpdaterCallback;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wx8 extends BdAsyncTask<String, Integer, ClientUpdateInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ClientUpdater a;
    public IClientUpdaterCallback b;
    public volatile ClientUpdateInfo c;
    public String d;
    public boolean e;
    public Handler f;
    public Runnable g;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wx8 a;

        public a(wx8 wx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wx8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null && "1".equals(this.a.c.mStatus) && TbConfig.COULD_UPDATE) {
                VersionData versionData = new VersionData();
                versionData.setForceUpdate(Integer.parseInt(this.a.c.mIsForceUpdate));
                versionData.setStrategy(0);
                versionData.setNewVersion(this.a.c.mVername);
                versionData.setNewVersionCode(Integer.parseInt(this.a.c.mVercode));
                versionData.setNewFile(this.a.c.mPackageName + this.a.c.mVername + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                versionData.setHasNewVer(Integer.parseInt(this.a.c.mStatus));
                versionData.setNewVersionDesc(this.a.c.mChangelog);
                versionData.setUrl(this.a.c.mDownurl);
                versionData.setSize(this.a.c.mSize);
                versionData.setPatch(this.a.c.mPatchDownUrl);
                versionData.setPatchSize(this.a.c.mPatchSize);
                versionData.setTiebaIconUrl(this.a.c.mIconUrl);
                versionData.setApkMD5RSA(this.a.c.mSignMd5);
                if (TbSingleton.getInstance().isSplashShowing()) {
                    zma.c().d(new bna(versionData, this.a.c, this.a.d, this.a.e));
                    return;
                }
                ana.c(versionData, this.a.c, this.a.d, this.a.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements IClientUpdaterCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wx8 a;

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onError(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            }
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onException(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            }
        }

        public b(wx8 wx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wx8Var;
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onFetched(JSONObject jSONObject) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, jSONObject) != null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("rule")) == null || (optJSONObject2 = optJSONObject.optJSONObject(ExceptionHandlerImpl.KEY_CUSTOM)) == null) {
                return;
            }
            this.a.d = optJSONObject2.optString("apk_MD5_RSA");
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onCompleted(ClientUpdateInfo clientUpdateInfo, RuleInfo ruleInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, clientUpdateInfo, ruleInfo) != null) || clientUpdateInfo == null || TextUtils.isEmpty(this.a.d)) {
                return;
            }
            this.a.c = clientUpdateInfo;
            this.a.f.post(this.a.g);
        }
    }

    public wx8(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.e = z;
        ClientUpdater clientUpdater = ClientUpdater.getInstance(TbadkCoreApplication.getInst());
        this.a = clientUpdater;
        clientUpdater.setUseCFG(false);
        this.a.setUseRSA(false);
        this.a.setFileProvider("com.baidu.tieba.fileprovider");
        this.b = new b(this);
        this.f = new Handler(Looper.getMainLooper());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public ClientUpdateInfo doInBackground(String... strArr) throws IOException {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
            this.a.setOsName(Info.PASSWORD);
            this.a.setTypeId("0");
            this.a.setFrom("tieba");
            this.a.addParamValue("versionType", String.valueOf(TbConfig.getVersionType()));
            this.a.addParamValue("tieba_versionname", TbConfig.getVersion());
            ClientUpdater clientUpdater = this.a;
            String str2 = "64";
            if (rc.a()) {
                str = "64";
            } else {
                str = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
            }
            clientUpdater.addParamValue("running_abi", str);
            ClientUpdater clientUpdater2 = this.a;
            if (!rc.b()) {
                str2 = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
            }
            clientUpdater2.addParamValue("support_abi", str2);
            this.a.checkUpdate(this.b);
            return null;
        }
        return (ClientUpdateInfo) invokeL.objValue;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.cancel();
            this.f.removeCallbacks(this.g);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPreExecute();
            this.f.removeCallbacks(this.g);
        }
    }
}
