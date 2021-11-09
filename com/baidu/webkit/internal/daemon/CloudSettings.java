package com.baidu.webkit.internal.daemon;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.ConectivityUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.RC4;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.baidu.webkit.internal.utils.b;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class CloudSettings implements INoProGuard, INetListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLOUD_SETTING_URL = "https://browserkernel.baidu.com/config/t5config?cmd=1&";
    public static final String CLOUD_SETTING_URL_HTTP = "http://browserkernel.baidu.com/config/t5config?cmd=1&";
    public static final String LOG_TAG = "CloudSettings";
    public static List<a> NetRecordList;
    public static boolean mDownloading;
    public static boolean mReady;
    public static boolean mSuccessDownload;
    public static a netRecord;
    public static String sLastGetTime;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteArrayOutputStream mData;
    public Map<String, String> mHeader;
    public int mNetres;
    public long mStartTime;

    /* loaded from: classes11.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f60989a;

        /* renamed from: b  reason: collision with root package name */
        public int f60990b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f60991c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CloudSettings f60992d;

        public a(CloudSettings cloudSettings) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cloudSettings};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60992d = cloudSettings;
            this.f60990b = -1;
        }

        public final void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                Log.w(CloudSettings.LOG_TAG, "setNetRes ".concat(String.valueOf(i2)));
                this.f60990b = i2;
            }
        }

        public final void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                Log.w(CloudSettings.LOG_TAG, "setNetTime ".concat(String.valueOf(j)));
                this.f60989a = j;
            }
        }

        public final void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                Log.w(CloudSettings.LOG_TAG, "mCronet ".concat(String.valueOf(z)));
                this.f60991c = z;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-535629477, "Lcom/baidu/webkit/internal/daemon/CloudSettings;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-535629477, "Lcom/baidu/webkit/internal/daemon/CloudSettings;");
                return;
            }
        }
        NetRecordList = new ArrayList();
    }

    public CloudSettings() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mNetres = -1;
        this.mData = null;
    }

    public static void addRawLogItem(StringBuilder sb, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{sb, str, Long.valueOf(j)}) == null) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(j);
        }
    }

    public static void addRawLogItem(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, sb, str, str2) == null) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(str2);
        }
    }

    public static void addRawLogItem(StringBuilder sb, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, sb, str, z) == null) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(z);
        }
    }

    public static String bytesToHexString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder("");
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            String cloudSettingUrl = WebSettingsGlobalBlink.getCloudSettingUrl();
            cloudSettingUrl = (cloudSettingUrl == null || cloudSettingUrl.length() <= 0) ? "https://browserkernel.baidu.com/config/t5config?cmd=1&" : "https://browserkernel.baidu.com/config/t5config?cmd=1&";
            StringBuilder sb = new StringBuilder();
            addRawLogItem(sb, "package_name", context.getPackageName());
            addRawLogItem(sb, "sdk_ver", WebKitFactory.getSdkVersionName());
            if (WebKitFactory.getAppIdString() != null) {
                addRawLogItem(sb, "appid", WebKitFactory.getAppIdString());
            }
            if (WebKitFactory.getAppVersionString() != null) {
                addRawLogItem(sb, "appversion", WebKitFactory.getAppVersionString());
            }
            addRawLogItem(sb, ETAG.KEY_DEV_VER, Build.VERSION.SDK_INT);
            addRawLogItem(sb, "net_type", ConectivityUtils.getNetType(context));
            try {
                addRawLogItem(sb, "model", new String(Base64.encode(Build.MODEL.getBytes(), 0)));
            } catch (Throwable th) {
                Log.e(LOG_TAG, "model exception ", th);
            }
            String str = cloudSettingUrl + sb.toString();
            Log.w(LOG_TAG, "cloud url=".concat(String.valueOf(str)));
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isCloudSettingsReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? mReady : invokeV.booleanValue;
    }

    public static String refFormatNowDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())) : (String) invokeV.objValue;
    }

    public static void restoreLastSentTimeFromCfg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            Log.w(LOG_TAG, "restoreLastSentTimeFromCfg");
            sLastGetTime = null;
            b.b();
            String str = ZeusInitConfigUtils.get("engineCloudSettingsTime", (String) null);
            if (str == null) {
                return;
            }
            try {
                byte[] decode = Base64.decode(str.getBytes(), 0);
                if (decode == null) {
                    return;
                }
                sLastGetTime = reverseString(new String(decode, "utf-8"));
                b.b();
                String str2 = ZeusInitConfigUtils.get("engineCloudSettingsData", (String) null);
                if (str2 == null) {
                    Log.w(LOG_TAG, "restoreLastSentTimeFromCfg null");
                } else {
                    WebSettingsGlobalBlink.setCloudSettings(new String(str2.getBytes("utf-8"), "utf-8"));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void restoreSettingsToFrameWork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            try {
                b.b();
                String str = ZeusInitConfigUtils.get("engineCloudSettingsData", (String) null);
                if (str == null) {
                    return;
                }
                WebSettingsGlobalBlink.setCloudSettings(new String(str.getBytes("utf-8"), "utf-8"));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static String reverseString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void saveLastSentTimeToCfg(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, bArr) == null) {
            try {
                String refFormatNowDate = refFormatNowDate();
                sLastGetTime = refFormatNowDate;
                byte[] encode = Base64.encode(reverseString(refFormatNowDate).getBytes(), 0);
                if (encode != null) {
                    String str = new String(encode, "utf-8");
                    b.b();
                    ZeusInitConfigUtils.set("engineCloudSettingsTime", str);
                    ZeusInitConfigUtils.set("engineCloudSettingsData", new String(bArr, "utf-8"));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void tryToUpdateCloudSettings(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, context) == null) || ConectivityUtils.getNetType(context).equals("unknown")) {
            return;
        }
        if (!WebKitFactory.getNeedDownloadCloudResource()) {
            Log.w(LOG_TAG, " tryToUpdateCloudSettings festival return");
        } else if (!WebKitFactory.isUserPrivacyEnabled()) {
            Log.i(LOG_TAG, " tryToUpdateCloudSettings isUserPrivacy return");
        } else if (!tryToUploadCloudSettings()) {
            Log.i(LOG_TAG, " tryToUpdateCloudSettings tryToUploadCloudSettings return");
        } else {
            Log.w(LOG_TAG, "tryToUpdateCloudSettings " + WebKitFactory.getNeedDownloadCloudResource());
            try {
                BdNet bdNet = new BdNet(context);
                bdNet.setEventListener(new CloudSettings());
                BdNetTask bdNetTask = new BdNetTask();
                bdNetTask.setNet(bdNet);
                bdNetTask.setUrl(getUrl(context));
                bdNet.start(bdNetTask, false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static synchronized boolean tryToUploadCloudSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            synchronized (CloudSettings.class) {
                if (mDownloading) {
                    return false;
                }
                if (sLastGetTime == null) {
                    restoreLastSentTimeFromCfg();
                }
                if (!refFormatNowDate().equals(sLastGetTime)) {
                    mDownloading = true;
                    sLastGetTime = null;
                    return true;
                } else if (mSuccessDownload) {
                    return false;
                } else {
                    mDownloading = true;
                    return true;
                }
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdNet) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdNet, bdNetTask, netError, i2) == null) {
            a aVar = new a(this);
            aVar.a(System.currentTimeMillis() - this.mStartTime);
            aVar.a(0);
            aVar.a(bdNetTask.isUseCorenet());
            NetRecordList.add(aVar);
            mDownloading = false;
            Log.w(LOG_TAG, "onNetDownloadError  " + bdNetTask.getUrl());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, bdNet, bdNetTask, bArr, i2) == null) {
            if (this.mData == null) {
                this.mData = new ByteArrayOutputStream();
            }
            this.mData.write(bArr, 0, i2);
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bdNet, bdNetTask) == null) {
            this.mHeader = bdNetTask.getResHeaders();
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, bdNet, bdNetTask, i2)) == null) {
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, bdNet, bdNetTask, i2) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048582, this, bdNet, bdNetTask, netState, i2) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bdNet, bdNetTask) == null) {
            a aVar = new a(this);
            aVar.a(System.currentTimeMillis() - this.mStartTime);
            aVar.a(1);
            aVar.a(bdNetTask.isUseCorenet());
            NetRecordList.add(aVar);
            mDownloading = false;
            this.mNetres = 1;
            if (this.mData == null) {
                Log.w(LOG_TAG, "mData==null");
                return;
            }
            Map<String, String> map = this.mHeader;
            if (map != null) {
                String str = map.get("Last-Modified");
                Log.w(LOG_TAG, "lastModify ".concat(String.valueOf(str)));
                if (str != null) {
                    Log.w(LOG_TAG, "lastModify1 ".concat(String.valueOf(str)));
                    CfgFileUtils.set(CfgFileUtils.KEY_CLOUDSETTINGS_LASTMODIFY, str);
                }
            }
            mSuccessDownload = true;
            byte[] byteArray = this.mData.toByteArray();
            Log.w(LOG_TAG, "onNetDownloadComplete " + byteArray.length);
            Log.w(LOG_TAG, "onNetDownloadComplete url " + bdNetTask.getUrl());
            try {
                byteArray = new RC4(WebSettingsGlobalBlink.getRc4SecrectKey()).decrypt(byteArray);
                WebSettingsGlobalBlink.setCloudSettings(new String(byteArray, "utf-8"));
                VideoCloudSetting.saveVideoSettingToCfg();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            saveLastSentTimeToCfg(byteArray);
            mReady = true;
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdNet, bdNetTask) == null) {
            Log.w(LOG_TAG, "onNetTaskStart  " + bdNetTask.getUrl());
            Log.w(LOG_TAG, "getUsingChromiumNet  " + bdNetTask.isUseCorenet());
            this.mStartTime = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bdNet, bdNetTask) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048586, this, bdNet, bdNetTask, i2, i3) == null) {
        }
    }
}
