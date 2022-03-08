package com.baidu.tieba.imageProblem.logic;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.j.b.f;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import com.baidu.tieba.R;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnIpListData;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ImageProblemAssistant {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public TbCdnIpListData f43958b;

    /* renamed from: c  reason: collision with root package name */
    public StringBuilder f43959c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<TestTask> f43960d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43961e;

    /* loaded from: classes5.dex */
    public class TestTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f43962b;

        /* renamed from: c  reason: collision with root package name */
        public String f43963c;

        public TestTask(ImageProblemAssistant imageProblemAssistant) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageProblemAssistant};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public ImageProblemAssistant(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43960d = new ArrayList<>();
        this.f43961e = false;
        this.a = context;
        String[] strArr = {context.getString(R.string.img_assistant_title_1), context.getString(R.string.img_assistant_title_2), context.getString(R.string.img_assistant_title_3), context.getString(R.string.img_assistant_title_4), context.getString(R.string.img_assistant_title_5), context.getString(R.string.img_assistant_title_6)};
        for (int i4 = 0; i4 < 6; i4++) {
            String str = strArr[i4];
            TestTask testTask = new TestTask(this);
            testTask.a = str;
            this.f43960d.add(testTask);
        }
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
        }
        return (String) invokeI.objValue;
    }

    public final boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                f fVar = new f();
                ImgHttpClient imgHttpClient = new ImgHttpClient(fVar);
                fVar.b().t(str);
                if (str2 != null && str2.length() > 0) {
                    imgHttpClient.getNetDataWithIp(str2, "tbcdn.hiphotos.baidu.com", 1);
                } else {
                    imgHttpClient.getNetDataWithIp(null, null, 1);
                }
                return fVar.c().b();
            } catch (Exception e2) {
                BdLog.e(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public void checkDNSIP() {
        TestTask testTask;
        Exception e2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        try {
            testTask = this.f43960d.get(1);
            try {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
                String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
                if (this.f43959c != null) {
                    this.f43959c.append("_2:" + b(dhcpInfo.dns1) + "," + b(dhcpInfo.dns2));
                }
                while (i2 < 3) {
                    String str = strArr[i2];
                    i2 = (b(dhcpInfo.dns1).equals(str) || b(dhcpInfo.dns2).equals(str)) ? 0 : i2 + 1;
                    testTask.f43962b = 1;
                    testTask.f43963c = this.a.getString(R.string.img_assistant_helptext_2_1) + b(dhcpInfo.dns1) + "," + b(dhcpInfo.dns2) + this.a.getString(R.string.img_assistant_helptext_2_2);
                    return;
                }
            } catch (Exception e3) {
                e2 = e3;
                if (testTask != null) {
                    testTask.f43962b = 0;
                }
                BdLog.e(e2);
            }
        } catch (Exception e4) {
            testTask = null;
            e2 = e4;
        }
    }

    public void checkLoadImg() {
        TestTask testTask;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                testTask = this.f43960d.get(5);
            } catch (Exception e3) {
                testTask = null;
                e2 = e3;
            }
            try {
                String postNetData = new NetWork(TbCdnTachometerModel.IPLIST_ADDRESS).postNetData();
                if (!TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    TbCdnIpListData tbCdnIpListData = new TbCdnIpListData();
                    this.f43958b = tbCdnIpListData;
                    tbCdnIpListData.parseJson(jSONObject);
                    boolean a = a(this.f43958b.f43929c, null);
                    boolean a2 = a("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                    boolean a3 = a(TbConfig.URL_IMAGE_PREFIX + this.f43958b.f43929c, null);
                    if (!a2 && !a3) {
                        testTask.f43962b = 2;
                        testTask.f43963c = this.a.getString(R.string.img_assistant_helptext_6_1);
                        if (this.f43959c != null) {
                            this.f43959c.append("_6:failed1");
                            return;
                        }
                        return;
                    } else if (a && a2 && a3) {
                        testTask.f43962b = 0;
                        this.f43961e = true;
                        return;
                    } else if (a3) {
                        testTask.f43962b = 1;
                        testTask.f43963c = this.a.getString(R.string.img_assistant_helptext_6_2);
                        if (this.f43959c != null) {
                            this.f43959c.append("_6:warning");
                        }
                        this.f43961e = true;
                        return;
                    } else {
                        testTask.f43962b = 2;
                        testTask.f43963c = this.a.getString(R.string.img_assistant_helptext_6_1);
                        if (this.f43959c != null) {
                            this.f43959c.append("_6:failed2");
                            return;
                        }
                        return;
                    }
                }
                testTask.f43962b = 2;
                testTask.f43963c = this.a.getString(R.string.img_assistant_helptext_6_1);
                if (this.f43959c != null) {
                    this.f43959c.append("_6:failed:iplist");
                }
            } catch (Exception e4) {
                e2 = e4;
                if (testTask != null) {
                    testTask.f43962b = 0;
                }
                BdLog.e(e2);
            }
        }
    }

    public void checkProxyIP() {
        TestTask testTask;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                testTask = this.f43960d.get(2);
            } catch (Exception e3) {
                testTask = null;
                e2 = e3;
            }
            try {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                try {
                    if (TextUtils.isEmpty(property)) {
                        property = Proxy.getHost(this.a);
                    }
                    if (TextUtils.isEmpty(property2)) {
                        property2 = String.valueOf(Proxy.getPort(this.a));
                    }
                } catch (Exception unused) {
                }
                if (property != null && property2 != null && property.length() > 0) {
                    testTask.f43962b = 1;
                    if (l.H()) {
                        testTask.f43963c = this.a.getString(R.string.img_assistant_helptext_3);
                    } else {
                        testTask.f43963c = this.a.getString(R.string.img_assistant_helptext_3_mobile);
                    }
                    if (this.f43959c != null) {
                        this.f43959c.append("_3:" + property + ":" + property2);
                        return;
                    }
                    return;
                }
                testTask.f43962b = 0;
            } catch (Exception e4) {
                e2 = e4;
                if (testTask != null) {
                    testTask.f43962b = 0;
                }
                BdLog.e(e2);
            }
        }
    }

    public void checkSetting() {
        TestTask testTask;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                testTask = this.f43960d.get(4);
            } catch (Exception e3) {
                testTask = null;
                e2 = e3;
            }
            try {
                testTask.f43962b = 0;
            } catch (Exception e4) {
                e2 = e4;
                if (testTask != null) {
                    testTask.f43962b = 0;
                }
                BdLog.e(e2);
            }
        }
    }

    public void fix() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ImageLogger.assistant(this.f43959c.toString());
            if (this.f43961e) {
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
                    netWork.addPostData("ab_img_m", "1");
                    netWork.postNetData();
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    public boolean hasImageProblem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!ICDNIPDirectConnect.getInstance().isAlreadyInit) {
                ICDNIPDirectConnect.getInstance().init();
            }
            return ICDNIPDirectConnect.getInstance().hasImageProblem();
        }
        return invokeV.booleanValue;
    }

    public void networkCheck() {
        TestTask testTask;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048583, this) != null) {
            return;
        }
        this.f43959c = new StringBuilder();
        Iterator<TestTask> it = this.f43960d.iterator();
        while (it.hasNext()) {
            it.next().f43963c = "";
        }
        try {
            testTask = this.f43960d.get(0);
            try {
                if (n.C()) {
                    testTask.f43962b = 0;
                } else {
                    testTask.f43962b = 2;
                    testTask.f43963c = this.a.getString(R.string.img_assistant_helptext_1);
                    if (this.f43959c != null) {
                        this.f43959c.append("1:failed");
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                if (testTask != null) {
                    testTask.f43962b = 0;
                }
                BdLog.e(e2);
            }
        } catch (Exception e4) {
            testTask = null;
            e2 = e4;
        }
    }

    public void networkTest() {
        TestTask testTask;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) {
            return;
        }
        try {
            testTask = this.f43960d.get(3);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (a(TbDomainConfig.DOMAIN_HTTPS_BAIDU, null)) {
                    testTask.f43962b = 0;
                } else {
                    testTask.f43962b = 2;
                    testTask.f43963c = this.a.getString(R.string.img_assistant_helptext_4);
                    if (this.f43959c != null) {
                        this.f43959c.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                if (testTask != null) {
                    testTask.f43962b = 0;
                }
                BdLog.e(e2);
            }
        } catch (Exception e4) {
            testTask = null;
            e2 = e4;
        }
    }
}
