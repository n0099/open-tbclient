package com.baidu.webkit.internal.blink;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes2.dex */
public class VideoFreeFlowConfigManager implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIRECT = "DIRECT";
    public static final String HOST_MATCH = "HOSTMATCH";
    public static final String HOST_STR = "HOSTSTR";
    public static final String HOST_STR_MATCH = "HOSTSTRMATCH";
    public static final int INDEX_MATCH_RULE = 0;
    public static final int INDEX_MATCH_STR = 1;
    public static final int INDEX_PAC_STR = 2;
    public static final String[] LOCAL_RULE_STRINGS;
    public static final String PROXY = "PROXY";
    public static final String SEPARATOR_STR = "#";
    public static final String TAG = "VideoFreeFlowConfigManager";
    public static final String URL_MATCH = "URLMATCH";
    public static VideoFreeFlowConfigManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] mListLock;
    public ArrayList<a> mPacRulesList;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f52793b;

        /* renamed from: c  reason: collision with root package name */
        public String f52794c;

        /* renamed from: d  reason: collision with root package name */
        public int f52795d;

        /* renamed from: e  reason: collision with root package name */
        public String f52796e;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f52793b = null;
            this.f52794c = null;
            this.f52795d = 2;
            this.f52796e = null;
            if (TextUtils.isEmpty(str) || !str.contains("#")) {
                return;
            }
            String[] split = str.split("#");
            int length = split.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (!TextUtils.isEmpty(split[i4])) {
                    if (i4 == 0) {
                        this.a = split[i4];
                    } else if (i4 == 1) {
                        this.f52793b = split[i4];
                    } else if (i4 == 2) {
                        String str2 = split[i4];
                        this.f52794c = str2;
                        if (!TextUtils.isEmpty(str2)) {
                            String trim = str2.trim();
                            this.f52794c = trim;
                            if (trim.startsWith(VideoFreeFlowConfigManager.DIRECT)) {
                                this.f52795d = 2;
                            } else if (this.f52794c.startsWith(VideoFreeFlowConfigManager.PROXY)) {
                                this.f52795d = 1;
                                String str3 = this.f52794c;
                                String trim2 = str3.substring(str3.indexOf(VideoFreeFlowConfigManager.PROXY) + 5).trim();
                                if (!TextUtils.isEmpty(trim2)) {
                                    String[] split2 = trim2.split(";");
                                    if (split2.length > 0 && !TextUtils.isEmpty(split2[0])) {
                                        this.f52796e = split2[0];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2146206463, "Lcom/baidu/webkit/internal/blink/VideoFreeFlowConfigManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2146206463, "Lcom/baidu/webkit/internal/blink/VideoFreeFlowConfigManager;");
                return;
            }
        }
        LOCAL_RULE_STRINGS = new String[]{"HOSTMATCH#m.baidu.com#DIRECT", "HOSTMATCH#mbd.baidu.com#DIRECT", "HOSTMATCH#vdf1.bdstatic.com#DIRECT", "HOSTMATCH#vdf2.bdstatic.com#DIRECT", "HOSTMATCH#vdf3.bdstatic.com#DIRECT", "HOSTMATCH#vdf4.bdstatic.com#DIRECT", "HOSTMATCH#shouji.baidu.com#DIRECT", "HOSTMATCH#appc.baidu.com#DIRECT", "HOSTMATCH#v.gdown.baidu.com #DIRECT", "HOSTMATCH#pan.baidu.com#DIRECT", "HOSTMATCH#d.pcs.baidu.com#DIRECT", "HOSTMATCH#pcs.baidu.com#DIRECT", "HOSTMATCH#pcsdata.baidu.com#DIRECT", "HOSTMATCH#thumbnail0.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail1.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail2.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail3.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail4.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail5.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail6.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail7.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail8.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail9.baidupcs.com#DIRECT", "HOSTMATCH#thumbnail10.baidupcs.com#DIRECT", "HOSTMATCH#update.pan.baidu.com#DIRECT", "HOSTMATCH#d14.baidupcs.com#DIRECT", "HOSTMATCH#d16.baidupcs.com#DIRECT", "HOSTMATCH#v6.baidupcs.com#DIRECT", "HOSTMATCH#v8.baidupcs.com#DIRECT", "HOSTMATCH#allall05.baidupcs.com#DIRECT", "HOSTMATCH#allall04.baidupcs.com#DIRECT", "HOSTMATCH#allnest.pcs.baidu.com#DIRECT", "HOSTMATCH#c.pcs.baidu.com#DIRECT", "HOSTMATCH#tieba.baidu.com?#DIRECT", "HOSTMATCH#tiebac.baidu.com#DIRECT", "HOSTMATCH#c.tieba.baidu.com#DIRECT", "HOSTMATCH#client.map.baidu.com#DIRECT", "HOSTMATCH#newclient.map.baidu.com#DIRECT", "HOSTMATCH#map.baidu.com#DIRECT", "HOSTMATCH#loc.map.baidu.com#DIRECT", "HOSTMATCH#lbsyun.baidu.com#DIRECT", "HOSTMATCH#api.map.baidu.com#DIRECT", "HOSTMATCH#its.map.baidu.com#DIRECT", "HOSTMATCH#sv.map.baidu.com#DIRECT", "HOSTMATCH#wapmap.baidu.com#DIRECT", "HOSTMATCH#newvector.map.baidu.com#DIRECT", "HOSTMATCH#or.map.baidu.com#DIRECT", "HOSTMATCH#s0.map.bdimg.com#DIRECT", "HOSTMATCH#s1.map.bdimg.com#DIRECT", "HOSTMATCH#offmap2.baidu.com#DIRECT", "HOSTMATCH#offmap1.baidu.com#DIRECT", "HOSTMATCH#offmap0.baidu.com#DIRECT", "HOSTMATCH#wapmap0.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap1.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap2.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap3.map.bdimg.com#DIRECT", "HOSTMATCH#wapmap4.map.bdimg.com#DIRECT", "HOSTMATCH#webapp0.map.bdstatic.com#DIRECT", "HOSTMATCH#webapp1.map.bdstatic.com#DIRECT", "HOSTMATCH#webapp2.map.bdstatic.com#DIRECT", "HOSTMATCH#webapp3.map.bdstatic.com#DIRECT", "HOSTMATCH#webmap0.bdimg.com#DIRECT", "HOSTMATCH#webmap1.bdimg.com#DIRECT", "HOSTMATCH#webmap2.bdimg.com#DIRECT", "HOSTMATCH#webmap3.bdimg.com#DIRECT", "HOSTMATCH#webmap4.bdimg.com#DIRECT", "HOSTMATCH#hiphotos.baidu.com#DIRECT", "HOSTMATCH#imgsrc.baidu.com#DIRECT", "HOSTMATCH#hiphotos.bdimg.com#DIRECT", "HOSTMATCH#picphotos.baidu.com#DIRECT", "HOSTMATCH#imgsrc.bdimg.com#DIRECT", "HOSTMATCH#imagecdn.baidu.com#DIRECT", "HOSTMATCH#q1.baidu.com#DIRECT", "HOSTMATCH#q2.baidu.com#DIRECT", "HOSTMATCH#q3.baidu.com#DIRECT", "HOSTMATCH#q4.baidu.com#DIRECT", "HOSTMATCH#q5.baidu.com#DIRECT", "HOSTMATCH#q6.baidu.com#DIRECT", "HOSTMATCH#q7.baidu.com#DIRECT", "HOSTMATCH#q8.baidu.com#DIRECT", "HOSTMATCH#t1.baidu.com#DIRECT", "HOSTMATCH#t2.baidu.com#DIRECT", "HOSTMATCH#t3.baidu.com#DIRECT", "HOSTMATCH#t4.baidu.com#DIRECT", "HOSTMATCH#t10.baidu.com#DIRECT", "HOSTMATCH#t11.baidu.com#DIRECT", "HOSTMATCH#t12.baidu.com#DIRECT", "HOSTMATCH#i1.baidu.com#DIRECT", "HOSTMATCH#i2.baidu.com#DIRECT", "HOSTMATCH#i3.baidu.com#DIRECT", "HOSTMATCH#i4.baidu.com#DIRECT", "HOSTMATCH#i5.baidu.com#DIRECT", "HOSTMATCH#i6.baidu.com#DIRECT", "HOSTMATCH#i7.baidu.com#DIRECT", "HOSTMATCH#i8.baidu.com#DIRECT", "HOSTMATCH#i9.baidu.com#DIRECT", "HOSTMATCH#i10.baidu.com#DIRECT", "HOSTMATCH#i11.baidu.com#DIRECT", "HOSTMATCH#i12.baidu.com#DIRECT", "HOSTMATCH#tnimg1.baidu.com#DIRECT", "HOSTMATCH#tnimg2.baidu.com#DIRECT", "HOSTMATCH#img0.bdstatic.com#DIRECT", "HOSTMATCH#img1.bdstatic.com#DIRECT", "HOSTMATCH#img2.bdstatic.com#DIRECT", "HOSTMATCH#img3.bdstatic.com#DIRECT", "HOSTMATCH#img4.bdstatic.com#DIRECT", "HOSTMATCH#img5.bdstatic.com#DIRECT", "HOSTMATCH#img6.bdstatic.com#DIRECT", "HOSTMATCH#img7.bdstatic.com#DIRECT", "HOSTMATCH#f10.baidu.com#DIRECT", "HOSTMATCH#f11.baidu.com#DIRECT", "HOSTMATCH#f12.baidu.com#DIRECT", "HOSTMATCH#timg01.bdimg.com#DIRECT", "HOSTMATCH#timg02.bdimg.com#DIRECT", "HOSTMATCH#timg03.bdimg.com#DIRECT", "HOSTMATCH#timg04.bdimg.com#DIRECT", "HOSTMATCH#timg05.bdimg.com#DIRECT", "HOSTMATCH#cdn00.baidu-img.cn#DIRECT", "HOSTMATCH#cdn01.baidu-img.cn#DIRECT", "HOSTMATCH#cdn02.baidu-img.cn#DIRECT", "HOSTMATCH#cdn03.baidu-img.cn#DIRECT", "HOSTMATCH#wiseala.baidu-img.cn#DIRECT", "HOSTMATCH#wa1.baidu-1img.cn#DIRECT", "HOSTMATCH#wa2.baidu-1img.cn#DIRECT", "HOSTMATCH#wa3.baidu-1img.cn#DIRECT", "HOSTMATCH#imgtn.bdimg.com#DIRECT", "HOSTMATCH#browserkernel.baidu.com#DIRECT", "HOSTMATCH#browsersafe.baidu.com#DIRECT", "URLMATCH#https://#PROXY cloudnproxy.baidu.com:443;DIRECT;", "URLMATCH#ws://#PROXY cloudnproxy.baidu.com:443;DIRECT;", "URLMATCH#wss://#PROXY cloudnproxy.baidu.com:443;DIRECT;", "HOSTMATCH#*#PROXY cloudnproxy.baidu.com:443;DIRECT;"};
    }

    public VideoFreeFlowConfigManager() {
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
        this.mPacRulesList = new ArrayList<>();
        this.mListLock = new byte[0];
    }

    public static synchronized VideoFreeFlowConfigManager getInstance() {
        InterceptResult invokeV;
        VideoFreeFlowConfigManager videoFreeFlowConfigManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (VideoFreeFlowConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new VideoFreeFlowConfigManager();
                }
                videoFreeFlowConfigManager = sInstance;
            }
            return videoFreeFlowConfigManager;
        }
        return (VideoFreeFlowConfigManager) invokeV.objValue;
    }

    private void initPacRule(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            Log.w(TAG, "initPacRule:".concat(String.valueOf(str)));
            synchronized (this.mListLock) {
                this.mPacRulesList.clear();
                for (String str2 : str.split(StringUtils.LF)) {
                    this.mPacRulesList.add(new a(str2));
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a3, code lost:
        if (r3.indexOf(r6.f52793b) != (-1)) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cf A[Catch: all -> 0x00e4, TryCatch #0 {, blocks: (B:12:0x0016, B:14:0x0028, B:16:0x0037, B:18:0x003f, B:20:0x0047, B:23:0x0051, B:52:0x00cf, B:54:0x00d3, B:55:0x00d5, B:57:0x00d7, B:59:0x00dc, B:61:0x00de, B:26:0x005e, B:28:0x0068, B:30:0x006e, B:32:0x007a, B:35:0x0092, B:37:0x009d, B:40:0x00a6, B:42:0x00b0, B:45:0x00b9, B:47:0x00c3, B:62:0x00e2), top: B:71:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00de A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getFreeFlowProxy(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (isFreeFlowEnable() && !TextUtils.isEmpty(str)) {
                synchronized (this.mListLock) {
                    int size = this.mPacRulesList.size();
                    String host = Uri.parse(str).getHost();
                    for (int i2 = 0; i2 < size; i2++) {
                        a aVar = this.mPacRulesList.get(i2);
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(aVar.a) && !TextUtils.isEmpty(aVar.f52793b) && !TextUtils.isEmpty(aVar.f52794c)) {
                            if (!aVar.f52793b.equals("*")) {
                                if (aVar.a.equals(HOST_MATCH)) {
                                    if (!TextUtils.isEmpty(host) && host.length() >= aVar.f52793b.length() && host.substring(host.length() - aVar.f52793b.length()).equals(aVar.f52793b)) {
                                    }
                                } else if (!aVar.a.equals(HOST_STR)) {
                                    if (aVar.a.equals(HOST_STR_MATCH)) {
                                        if (host.equals(aVar.f52793b)) {
                                        }
                                    } else if (aVar.a.equals(URL_MATCH) && str.indexOf(aVar.f52793b) != -1) {
                                    }
                                }
                                if (z) {
                                    if (aVar.f52795d == 1) {
                                        return aVar.f52796e;
                                    }
                                    if (aVar.f52795d == 2) {
                                        return null;
                                    }
                                }
                            }
                            z = true;
                            if (z) {
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    }
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void initLocalRule() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Log.w(TAG, "initLocalRule called");
            synchronized (this.mListLock) {
                this.mPacRulesList.clear();
                for (String str : LOCAL_RULE_STRINGS) {
                    this.mPacRulesList.add(new a(str));
                }
            }
        }
    }

    public boolean isFreeFlowEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? WebSettingsGlobalBlink.canUseFreeFlow() : invokeV.booleanValue;
    }

    public void setPacData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            initPacRule(str);
        }
    }
}
