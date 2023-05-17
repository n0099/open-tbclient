package com.baidu.ufosdk;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.s;
import com.baidu.ufosdk.v1;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class FeedbackManager implements IFeedbackManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile FeedbackManager d;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public IConfigurations b;
    public IFeedbackMethodCallback c;

    @Override // com.baidu.ufosdk.IFeedbackManager
    public String getSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "4.1.9.1" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e0 a;
        public final /* synthetic */ CountDownLatch b;

        public a(FeedbackManager feedbackManager, e0 e0Var, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackManager, e0Var, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e0Var;
            this.b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.a();
                } catch (Exception unused) {
                }
                this.b.countDown();
            }
        }
    }

    public FeedbackManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
    }

    public static FeedbackManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (d == null) {
                synchronized (FeedbackManager.class) {
                    if (d == null) {
                        d = new FeedbackManager(context);
                    }
                }
            }
            return d;
        }
        return (FeedbackManager) invokeL.objValue;
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public Intent getFeedbackIntentWithCategory(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return b.a(this.a, i, "", "", "");
        }
        return (Intent) invokeI.objValue;
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public void initFeedbackPlugin(IConfigurations iConfigurations) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iConfigurations) == null) {
            a(iConfigurations, true);
        }
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public void initFeedbackSDK(IConfigurations iConfigurations) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iConfigurations) == null) {
            a(iConfigurations, false);
        }
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public void setBaiduCuid(String str) {
        IConfigurations iConfigurations;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (iConfigurations = this.b) != null) {
            iConfigurations.setBaiduCuid(str);
        }
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public void setExtraData(String str) {
        IConfigurations iConfigurations;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && (iConfigurations = this.b) != null) {
            iConfigurations.setExtraData(str);
        }
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public void setFeedbackCallback(IFeedbackMethodCallback iFeedbackMethodCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iFeedbackMethodCallback) == null) {
            this.c = iFeedbackMethodCallback;
        }
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public void setFeedbackChannel(String str) {
        IConfigurations iConfigurations;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && (iConfigurations = this.b) != null) {
            iConfigurations.setFeedbackChannel(str);
        }
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public void setLocation(String str) {
        IConfigurations iConfigurations;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && (iConfigurations = this.b) != null) {
            iConfigurations.setLocation(str);
        }
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public void setThemeMode(int i) {
        IConfigurations iConfigurations;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (iConfigurations = this.b) != null) {
            iConfigurations.setThemeMode(i);
        }
    }

    public final void a(IConfigurations iConfigurations, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, iConfigurations, z) == null) {
            System.currentTimeMillis();
            Context context = this.a;
            if (context == null) {
                return;
            }
            this.b = iConfigurations;
            b.h = context.getContentResolver();
            b.e = this.a;
            b.f = new Handler(Looper.getMainLooper());
            Context context2 = this.a;
            String appPkgName = iConfigurations.getAppPkgName();
            String appVersion = iConfigurations.getAppVersion();
            c.b = appPkgName;
            c.a = appVersion;
            u1.a(b.i(context2).edit().putString("app_pkg", appPkgName));
            u1.a(b.i(context2).edit().putString("app_vn", c.a));
            b.d = iConfigurations;
            s sVar = s.b.a;
            Context context3 = this.a;
            if (context3.getSharedPreferences("feedback_switch_prefs", 0).getLong("pl_clo_ts", 0L) - System.currentTimeMillis() <= 0) {
                v1.b.a.a(new q(sVar, context3));
            }
            e0 a2 = e0.a(this.a);
            if (TextUtils.isEmpty(a2.b)) {
                if (z) {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    v1 v1Var = v1.b.a;
                    a aVar = new a(this, a2, countDownLatch);
                    if (v1Var != null) {
                        w1 w1Var = new w1(aVar, true, 5);
                        w1Var.c = System.currentTimeMillis();
                        v1Var.a.execute(w1Var);
                        try {
                            countDownLatch.await();
                            return;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    throw null;
                }
                a2.a(true);
            }
        }
    }

    public IConfigurations getAppConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (IConfigurations) invokeV.objValue;
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public IFeedbackMethodCallback getFeedbackCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (IFeedbackMethodCallback) invokeV.objValue;
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public String getHostPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            IConfigurations iConfigurations = this.b;
            if (iConfigurations != null) {
                return iConfigurations.getAppPkgName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public long getLastSendMessageTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return b.i(this.a).getLong("Ufolastsendtime", -1L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public Intent getFeedbackIntentWithCategory(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, str)) == null) {
            return b.a(this.a, i, str, "", "");
        }
        return (Intent) invokeIL.objValue;
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public Intent getFeedbackIntentWithCategory(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            return b.a(this.a, i, str, str2, str3);
        }
        return (Intent) invokeCommon.objValue;
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public String getFeedbackNoticeFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            e0 a2 = e0.a(this.a);
            if (TextUtils.isEmpty(a2.b)) {
                return null;
            }
            try {
                String str = s1.i;
                HashMap hashMap = new HashMap();
                hashMap.put("clientid", a2.a);
                hashMap.put("appid", a2.b);
                hashMap.put("devid", a2.c);
                hashMap.put("uid", this.b.getAccountUid());
                hashMap.put(DpStatConstants.KEY_USER_ID, this.b.getAccountUid());
                hashMap.put("username", this.b.getAccountName());
                hashMap.put("interval", "" + q1.a);
                String b = b.b(b.a(hashMap));
                HashMap hashMap2 = new HashMap();
                hashMap2.put("sdk_encrypt", b);
                String a3 = d0.a(str, d0.a(hashMap2));
                if (!TextUtils.isEmpty(a3)) {
                    String a4 = b.a(a3);
                    String str2 = "-----------getFeedbackChatBack---------response is " + a4;
                    JSONObject jSONObject = new JSONObject(a4);
                    if (((Integer) jSONObject.get("errno")).intValue() == 0) {
                        return jSONObject.optString("newmsg");
                    }
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.ufosdk.IFeedbackManager
    public void setAccount(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            try {
                if (this.b != null) {
                    this.b.setAccount(str, str2);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("accountName", str);
                jSONObject.put("accountUid", str2);
                Context context = this.a;
                u1.a(b.i(context).edit().putString("ufo_papo_acc", b.b(jSONObject.toString())));
            } catch (Exception unused) {
            }
        }
    }
}
