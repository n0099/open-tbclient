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
    public TbCdnIpListData f34117b;

    /* renamed from: c  reason: collision with root package name */
    public StringBuilder f34118c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<TestTask> f34119d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34120e;

    /* loaded from: classes5.dex */
    public class TestTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f34121b;

        /* renamed from: c  reason: collision with root package name */
        public String f34122c;

        public TestTask(ImageProblemAssistant imageProblemAssistant) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageProblemAssistant};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34119d = new ArrayList<>();
        this.f34120e = false;
        this.a = context;
        String[] strArr = {context.getString(R.string.obfuscated_res_0x7f0f08c1), context.getString(R.string.obfuscated_res_0x7f0f08c2), context.getString(R.string.obfuscated_res_0x7f0f08c3), context.getString(R.string.obfuscated_res_0x7f0f08c4), context.getString(R.string.obfuscated_res_0x7f0f08c5), context.getString(R.string.obfuscated_res_0x7f0f08c6)};
        for (int i3 = 0; i3 < 6; i3++) {
            String str = strArr[i3];
            TestTask testTask = new TestTask(this);
            testTask.a = str;
            this.f34119d.add(testTask);
        }
    }

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
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
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        try {
            testTask = this.f34119d.get(1);
            try {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
                String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
                if (this.f34118c != null) {
                    this.f34118c.append("_2:" + b(dhcpInfo.dns1) + "," + b(dhcpInfo.dns2));
                }
                while (i < 3) {
                    String str = strArr[i];
                    i = (b(dhcpInfo.dns1).equals(str) || b(dhcpInfo.dns2).equals(str)) ? 0 : i + 1;
                    testTask.f34121b = 1;
                    testTask.f34122c = this.a.getString(R.string.obfuscated_res_0x7f0f08b9) + b(dhcpInfo.dns1) + "," + b(dhcpInfo.dns2) + this.a.getString(R.string.obfuscated_res_0x7f0f08ba);
                    return;
                }
            } catch (Exception e3) {
                e2 = e3;
                if (testTask != null) {
                    testTask.f34121b = 0;
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
                testTask = this.f34119d.get(5);
            } catch (Exception e3) {
                testTask = null;
                e2 = e3;
            }
            try {
                String postNetData = new NetWork(TbCdnTachometerModel.IPLIST_ADDRESS).postNetData();
                if (!TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    TbCdnIpListData tbCdnIpListData = new TbCdnIpListData();
                    this.f34117b = tbCdnIpListData;
                    tbCdnIpListData.parseJson(jSONObject);
                    boolean a = a(this.f34117b.f34089c, null);
                    boolean a2 = a("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                    boolean a3 = a(TbConfig.URL_IMAGE_PREFIX + this.f34117b.f34089c, null);
                    if (!a2 && !a3) {
                        testTask.f34121b = 2;
                        testTask.f34122c = this.a.getString(R.string.obfuscated_res_0x7f0f08bf);
                        if (this.f34118c != null) {
                            this.f34118c.append("_6:failed1");
                            return;
                        }
                        return;
                    } else if (a && a2 && a3) {
                        testTask.f34121b = 0;
                        this.f34120e = true;
                        return;
                    } else if (a3) {
                        testTask.f34121b = 1;
                        testTask.f34122c = this.a.getString(R.string.obfuscated_res_0x7f0f08c0);
                        if (this.f34118c != null) {
                            this.f34118c.append("_6:warning");
                        }
                        this.f34120e = true;
                        return;
                    } else {
                        testTask.f34121b = 2;
                        testTask.f34122c = this.a.getString(R.string.obfuscated_res_0x7f0f08bf);
                        if (this.f34118c != null) {
                            this.f34118c.append("_6:failed2");
                            return;
                        }
                        return;
                    }
                }
                testTask.f34121b = 2;
                testTask.f34122c = this.a.getString(R.string.obfuscated_res_0x7f0f08bf);
                if (this.f34118c != null) {
                    this.f34118c.append("_6:failed:iplist");
                }
            } catch (Exception e4) {
                e2 = e4;
                if (testTask != null) {
                    testTask.f34121b = 0;
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
                testTask = this.f34119d.get(2);
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
                    testTask.f34121b = 1;
                    if (l.H()) {
                        testTask.f34122c = this.a.getString(R.string.obfuscated_res_0x7f0f08bb);
                    } else {
                        testTask.f34122c = this.a.getString(R.string.obfuscated_res_0x7f0f08bc);
                    }
                    if (this.f34118c != null) {
                        this.f34118c.append("_3:" + property + ":" + property2);
                        return;
                    }
                    return;
                }
                testTask.f34121b = 0;
            } catch (Exception e4) {
                e2 = e4;
                if (testTask != null) {
                    testTask.f34121b = 0;
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
                testTask = this.f34119d.get(4);
            } catch (Exception e3) {
                testTask = null;
                e2 = e3;
            }
            try {
                testTask.f34121b = 0;
            } catch (Exception e4) {
                e2 = e4;
                if (testTask != null) {
                    testTask.f34121b = 0;
                }
                BdLog.e(e2);
            }
        }
    }

    public void fix() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ImageLogger.assistant(this.f34118c.toString());
            if (this.f34120e) {
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
        this.f34118c = new StringBuilder();
        Iterator<TestTask> it = this.f34119d.iterator();
        while (it.hasNext()) {
            it.next().f34122c = "";
        }
        try {
            testTask = this.f34119d.get(0);
            try {
                if (n.C()) {
                    testTask.f34121b = 0;
                } else {
                    testTask.f34121b = 2;
                    testTask.f34122c = this.a.getString(R.string.obfuscated_res_0x7f0f08b8);
                    if (this.f34118c != null) {
                        this.f34118c.append("1:failed");
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                if (testTask != null) {
                    testTask.f34121b = 0;
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
            testTask = this.f34119d.get(3);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (a(TbDomainConfig.DOMAIN_HTTPS_BAIDU, null)) {
                    testTask.f34121b = 0;
                } else {
                    testTask.f34121b = 2;
                    testTask.f34122c = this.a.getString(R.string.obfuscated_res_0x7f0f08bd);
                    if (this.f34118c != null) {
                        this.f34118c.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                if (testTask != null) {
                    testTask.f34121b = 0;
                }
                BdLog.e(e2);
            }
        } catch (Exception e4) {
            testTask = null;
            e2 = e4;
        }
    }
}
