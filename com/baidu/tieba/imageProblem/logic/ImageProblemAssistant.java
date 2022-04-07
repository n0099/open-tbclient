package com.baidu.tieba.imageProblem.logic;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.mi;
import com.repackage.of;
import com.repackage.oi;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ImageProblemAssistant {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public TbCdnIpListData b;
    public StringBuilder c;
    public ArrayList<TestTask> d;
    public boolean e;

    /* loaded from: classes3.dex */
    public class TestTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public String c;

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
        this.d = new ArrayList<>();
        this.e = false;
        this.a = context;
        String[] strArr = {context.getString(R.string.obfuscated_res_0x7f0f08c1), context.getString(R.string.obfuscated_res_0x7f0f08c2), context.getString(R.string.obfuscated_res_0x7f0f08c3), context.getString(R.string.obfuscated_res_0x7f0f08c4), context.getString(R.string.obfuscated_res_0x7f0f08c5), context.getString(R.string.obfuscated_res_0x7f0f08c6)};
        for (int i3 = 0; i3 < 6; i3++) {
            String str = strArr[i3];
            TestTask testTask = new TestTask(this);
            testTask.a = str;
            this.d.add(testTask);
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
                of ofVar = new of();
                ImgHttpClient imgHttpClient = new ImgHttpClient(ofVar);
                ofVar.b().t(str);
                if (str2 != null && str2.length() > 0) {
                    imgHttpClient.getNetDataWithIp(str2, "tbcdn.hiphotos.baidu.com", 1);
                } else {
                    imgHttpClient.getNetDataWithIp(null, null, 1);
                }
                return ofVar.c().b();
            } catch (Exception e) {
                BdLog.e(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public void checkDNSIP() {
        TestTask testTask;
        Exception e;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        try {
            testTask = this.d.get(1);
            try {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
                String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
                if (this.c != null) {
                    this.c.append("_2:" + b(dhcpInfo.dns1) + "," + b(dhcpInfo.dns2));
                }
                while (i < 3) {
                    String str = strArr[i];
                    i = (b(dhcpInfo.dns1).equals(str) || b(dhcpInfo.dns2).equals(str)) ? 0 : i + 1;
                    testTask.b = 1;
                    testTask.c = this.a.getString(R.string.obfuscated_res_0x7f0f08b9) + b(dhcpInfo.dns1) + "," + b(dhcpInfo.dns2) + this.a.getString(R.string.obfuscated_res_0x7f0f08ba);
                    return;
                }
            } catch (Exception e2) {
                e = e2;
                if (testTask != null) {
                    testTask.b = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e3) {
            testTask = null;
            e = e3;
        }
    }

    public void checkLoadImg() {
        TestTask testTask;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                testTask = this.d.get(5);
            } catch (Exception e2) {
                testTask = null;
                e = e2;
            }
            try {
                String postNetData = new NetWork(TbCdnTachometerModel.IPLIST_ADDRESS).postNetData();
                if (!TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    TbCdnIpListData tbCdnIpListData = new TbCdnIpListData();
                    this.b = tbCdnIpListData;
                    tbCdnIpListData.parseJson(jSONObject);
                    boolean a = a(this.b.c, null);
                    boolean a2 = a("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                    boolean a3 = a(TbConfig.URL_IMAGE_PREFIX + this.b.c, null);
                    if (!a2 && !a3) {
                        testTask.b = 2;
                        testTask.c = this.a.getString(R.string.obfuscated_res_0x7f0f08bf);
                        if (this.c != null) {
                            this.c.append("_6:failed1");
                            return;
                        }
                        return;
                    } else if (a && a2 && a3) {
                        testTask.b = 0;
                        this.e = true;
                        return;
                    } else if (a3) {
                        testTask.b = 1;
                        testTask.c = this.a.getString(R.string.obfuscated_res_0x7f0f08c0);
                        if (this.c != null) {
                            this.c.append("_6:warning");
                        }
                        this.e = true;
                        return;
                    } else {
                        testTask.b = 2;
                        testTask.c = this.a.getString(R.string.obfuscated_res_0x7f0f08bf);
                        if (this.c != null) {
                            this.c.append("_6:failed2");
                            return;
                        }
                        return;
                    }
                }
                testTask.b = 2;
                testTask.c = this.a.getString(R.string.obfuscated_res_0x7f0f08bf);
                if (this.c != null) {
                    this.c.append("_6:failed:iplist");
                }
            } catch (Exception e3) {
                e = e3;
                if (testTask != null) {
                    testTask.b = 0;
                }
                BdLog.e(e);
            }
        }
    }

    public void checkProxyIP() {
        TestTask testTask;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                testTask = this.d.get(2);
            } catch (Exception e2) {
                testTask = null;
                e = e2;
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
                    testTask.b = 1;
                    if (mi.H()) {
                        testTask.c = this.a.getString(R.string.obfuscated_res_0x7f0f08bb);
                    } else {
                        testTask.c = this.a.getString(R.string.obfuscated_res_0x7f0f08bc);
                    }
                    if (this.c != null) {
                        this.c.append("_3:" + property + ":" + property2);
                        return;
                    }
                    return;
                }
                testTask.b = 0;
            } catch (Exception e3) {
                e = e3;
                if (testTask != null) {
                    testTask.b = 0;
                }
                BdLog.e(e);
            }
        }
    }

    public void checkSetting() {
        TestTask testTask;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                testTask = this.d.get(4);
            } catch (Exception e2) {
                testTask = null;
                e = e2;
            }
            try {
                testTask.b = 0;
            } catch (Exception e3) {
                e = e3;
                if (testTask != null) {
                    testTask.b = 0;
                }
                BdLog.e(e);
            }
        }
    }

    public void fix() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ImageLogger.assistant(this.c.toString());
            if (this.e) {
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
                    netWork.addPostData("ab_img_m", "1");
                    netWork.postNetData();
                } catch (Exception e) {
                    BdLog.e(e);
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
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048583, this) != null) {
            return;
        }
        this.c = new StringBuilder();
        Iterator<TestTask> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().c = "";
        }
        try {
            testTask = this.d.get(0);
            try {
                if (oi.C()) {
                    testTask.b = 0;
                } else {
                    testTask.b = 2;
                    testTask.c = this.a.getString(R.string.obfuscated_res_0x7f0f08b8);
                    if (this.c != null) {
                        this.c.append("1:failed");
                    }
                }
            } catch (Exception e2) {
                e = e2;
                if (testTask != null) {
                    testTask.b = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e3) {
            testTask = null;
            e = e3;
        }
    }

    public void networkTest() {
        TestTask testTask;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) {
            return;
        }
        try {
            testTask = this.d.get(3);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (a(TbDomainConfig.DOMAIN_HTTPS_BAIDU, null)) {
                    testTask.b = 0;
                } else {
                    testTask.b = 2;
                    testTask.c = this.a.getString(R.string.obfuscated_res_0x7f0f08bd);
                    if (this.c != null) {
                        this.c.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                if (testTask != null) {
                    testTask.b = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e3) {
            testTask = null;
            e = e3;
        }
    }
}
