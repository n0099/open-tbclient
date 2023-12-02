package com.baidu.tieba;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.download.GamenowDownloadButtomView;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.tieba.adnotify.receiver.NotInstallNotificationReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class uw3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static int s;
    public transient /* synthetic */ FieldHolder $fh;
    public GamenowDownloadButtomView a;
    public bx3 b;
    public lu3 c;
    public GameGuideConfigInfo.CloseInfo d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;
    public int l;
    public int m;
    public String n;
    public String o;
    public String p;
    public String q;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uw3 a;

        public a(uw3 uw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uw3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.h.equals("wdview")) {
                    gx3.n().j("0", this.a.k, this.a.l);
                } else if (this.a.h.equals("gbview") && this.a.d != null) {
                    if (this.a.d.type != 0 && this.a.d.type != 1) {
                        if (this.a.d.type == 2) {
                            gx3.n().b("gbADialogClick", "0", "", "");
                        }
                    } else {
                        gx3.n().b("gbBDialogClick", "0", "", "");
                    }
                }
                this.a.s(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-361181414, "Lcom/baidu/tieba/uw3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-361181414, "Lcom/baidu/tieba/uw3$b;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            a = iArr;
            try {
                iArr[DownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DownloadState.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DownloadState.NOT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[DownloadState.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends r23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String c;
        public String d;
        public lu3 e;
        public String f;
        public String g;

        @Override // com.baidu.tieba.p23
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.tieba.p23
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public c(String str, String str2, lu3 lu3Var, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, lu3Var, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = str;
            this.c = str2;
            this.e = lu3Var;
            this.f = str3;
            this.g = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.r23, com.baidu.tieba.p23
        public void onEvent(@NonNull n23 n23Var) {
            Bundle a;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n23Var) != null) || (a = n23Var.a()) == null) {
                return;
            }
            uw3.q(a, this.e, this.d, this.c, this.f, this.g);
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final uw3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-361181352, "Lcom/baidu/tieba/uw3$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-361181352, "Lcom/baidu/tieba/uw3$d;");
                    return;
                }
            }
            a = new uw3();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948225368, "Lcom/baidu/tieba/uw3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948225368, "Lcom/baidu/tieba/uw3;");
                return;
            }
        }
        r = vm1.a;
        s = 0;
    }

    public static uw3 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return d.a;
        }
        return (uw3) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b.b;
        }
        return (String) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a.setOnClickListener(new a(this));
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c = null;
            this.a = null;
            this.b = null;
        }
    }

    public uw3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = "";
        this.f = "";
        this.g = "";
        this.j = "";
        this.n = "";
        this.o = "";
        this.p = "";
    }

    public final void C(String str) {
        bx3 bx3Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || (bx3Var = this.b) == null) {
            return;
        }
        bx3Var.c = str;
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            y(i);
        }
    }

    public void E(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadState) == null) {
            z(downloadState);
        }
    }

    public final byte[] h(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            return Base64Encoder.B64Encode(bArr);
        }
        return (byte[]) invokeL.objValue;
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f = str;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.g = str;
        }
    }

    public final void y(int i) {
        bx3 bx3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && (bx3Var = this.b) != null && i != bx3Var.d) {
            bx3Var.d = i;
            F();
        }
    }

    public final void z(DownloadState downloadState) {
        bx3 bx3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, downloadState) == null) && (bx3Var = this.b) != null && downloadState != bx3Var.a) {
            bx3Var.a = downloadState;
            F();
        }
    }

    public static String f(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, map)) == null) {
            if (map != null) {
                for (String str2 : map.keySet()) {
                    if (!TextUtils.isEmpty(map.get(str2))) {
                        str = sm4.a(str, str2, map.get(str2));
                    }
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void g(String str, String str2, String str3, String str4, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i)}) == null) && TextUtils.equals(ow3.a, str) && TextUtils.equals(str2, "checkPackageExpired")) {
            gx3.n().m(str3, str4, i);
        }
    }

    public static void q(@NonNull Bundle bundle, lu3 lu3Var, String str, String str2, String str3, String str4) {
        String string;
        char c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{bundle, lu3Var, str, str2, str3, str4}) == null) && (string = bundle.getString("functionType")) != null && lu3Var != null) {
            String string2 = bundle.getString("resultData", "");
            if (r) {
                Log.d("DownloadButtonManager", "handleResult:function = " + string + ",result = " + string2);
            }
            int hashCode = string.hashCode();
            if (hashCode != -1013362275) {
                if (hashCode == -530890460 && string.equals("onSuccess")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (string.equals("onFail")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    if (!TextUtils.isEmpty(string2) && string2.equals(DownloadState.NOT_START.name())) {
                        lu3Var.c(DownloadState.NOT_START, 0);
                    }
                    g(str, str2, str3, str4, 0);
                    return;
                }
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(string2);
                int optInt = jSONObject.optInt("progress", -1);
                if (optInt > -1) {
                    lu3Var.a(optInt);
                }
                if (jSONObject.optBoolean("installed")) {
                    lu3Var.c(DownloadState.INSTALLED, optInt);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    return;
                }
                int optInt2 = optJSONObject.optInt("status", 0);
                int value = DownloadState.NOT_START.value();
                if (optInt2 == 0) {
                    lu3Var.c(DownloadState.DOWNLOADING, optInt);
                    value = DownloadState.DOWNLOADING.value();
                } else if (optInt2 == 1) {
                    lu3Var.c(DownloadState.DOWNLOADING, optInt);
                    value = DownloadState.DOWNLOADING.value();
                } else if (optInt2 == 2) {
                    lu3Var.c(DownloadState.DOWNLOAD_PAUSED, optInt);
                    value = DownloadState.DOWNLOAD_PAUSED.value();
                } else if (optInt2 == 3) {
                    lu3Var.c(DownloadState.DOWNLOAD_FAILED, optInt);
                    value = DownloadState.DOWNLOAD_FAILED.value();
                } else if (optInt2 == 4) {
                    lu3Var.c(DownloadState.DELETED, optInt);
                    value = DownloadState.DELETED.value();
                } else if (optInt2 == 5) {
                    lu3Var.c(DownloadState.DOWNLOADED, optInt);
                    value = DownloadState.DOWNLOADED.value();
                }
                g(str, str2, str3, str4, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void A(String str, String str2, String str3, int i) {
        bx3 bx3Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(1048576, this, str, str2, str3, i) != null) || (bx3Var = this.b) == null) {
            return;
        }
        DownloadState downloadState = bx3Var.a;
        if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
            String str4 = this.o;
            if (TextUtils.equals(ow3.a, this.b.c)) {
                str4 = k(1, str, str2, str3);
                if (!TextUtils.isEmpty(this.q)) {
                    this.b.c(this.q);
                }
            }
            this.b.b = str4;
            this.f = str;
            if (i >= 0) {
                this.g = String.valueOf(i);
            }
        }
        s(false);
    }

    public final void B() {
        bx3 bx3Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (bx3Var = this.b) == null) {
            return;
        }
        int i = b.a[bx3Var.a.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3) {
                this.a.j(-1);
                this.a.h(rp2.c().getResources().getColor(R.color.obfuscated_res_0x7f06041f));
                this.a.i(rp2.c().getResources().getColor(R.color.obfuscated_res_0x7f060423));
                return;
            }
            this.a.j(-1);
            this.a.i(rp2.c().getResources().getColor(R.color.obfuscated_res_0x7f060422));
            return;
        }
        this.a.j(rp2.c().getResources().getColor(R.color.obfuscated_res_0x7f06041f));
        this.a.h(rp2.c().getResources().getColor(R.color.obfuscated_res_0x7f06041f));
        this.a.i(rp2.c().getResources().getColor(R.color.obfuscated_res_0x7f060423));
    }

    public final void F() {
        bx3 bx3Var;
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (bx3Var = this.b) == null) {
            return;
        }
        if (bx3Var.a == DownloadState.DOWNLOADING) {
            GamenowDownloadButtomView gamenowDownloadButtomView = this.a;
            if (gamenowDownloadButtomView != null && gamenowDownloadButtomView.getVisibility() != 8) {
                if (this.b.d < this.a.getMax()) {
                    String string2 = rp2.c().getResources().getString(R.string.obfuscated_res_0x7f0f019a);
                    string = String.format(string2, this.b.d + "%");
                } else {
                    string = rp2.c().getResources().getString(R.string.obfuscated_res_0x7f0f01a4);
                }
                this.a.setText(string);
                this.a.setProgress(this.b.d);
            }
        } else {
            String string3 = rp2.c().getResources().getString(v(this.b.a));
            if (this.b.a == DownloadState.DOWNLOADED) {
                this.a.setProgress(100);
            }
            bx3 bx3Var2 = this.b;
            if (bx3Var2.a == DownloadState.DOWNLOAD_PAUSED) {
                this.a.setProgress(bx3Var2.d);
            }
            this.a.setText(string3);
            DownloadState downloadState = this.b.a;
            if ((downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) && !TextUtils.isEmpty(this.e)) {
                this.a.setText(this.e);
            }
        }
        if (this.a != null) {
            B();
            this.a.setState(this.b.a);
            this.a.postInvalidate();
        }
    }

    public GamenowDownloadButtomView i(lu3 lu3Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, lu3Var, str, str2)) == null) {
            return j(lu3Var, str, str2, 0, 0);
        }
        return (GamenowDownloadButtomView) invokeLLL.objValue;
    }

    public GamenowDownloadButtomView j(lu3 lu3Var, String str, String str2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{lu3Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            this.h = str;
            this.i = str2;
            this.k = i;
            this.l = i2;
            GameGuideConfigInfo z = jw3.o.z();
            int color = rp2.c().getResources().getColor(R.color.obfuscated_res_0x7f06041f);
            int color2 = rp2.c().getResources().getColor(R.color.obfuscated_res_0x7f060b44);
            if (z != null) {
                this.j = z.configName;
                this.o = z.targetAppDownloadUrl;
                String str3 = z.targetAppPackageId;
                this.p = str3;
                if (TextUtils.equals(ow3.a, str3)) {
                    this.q = z.gamenowApkId;
                }
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1252040192) {
                    if (hashCode == -792126734 && str.equals("wdview")) {
                        c2 = 0;
                    }
                } else if (str.equals("gbview")) {
                    c2 = 1;
                }
                if (c2 != 0) {
                    if (c2 == 1) {
                        GameGuideConfigInfo.CloseInfo closeInfo = z.closeInfo;
                        this.d = closeInfo;
                        if (closeInfo != null) {
                            try {
                                if (!TextUtils.isEmpty(closeInfo.downloadBackgroundColor) && !this.d.downloadBackgroundColor.equals(StringUtil.NULL_STRING)) {
                                    color = Color.parseColor(this.d.downloadBackgroundColor);
                                }
                                if (!TextUtils.isEmpty(this.d.downloadTextColor) && !this.d.downloadTextColor.equals(StringUtil.NULL_STRING)) {
                                    color2 = Color.parseColor(this.d.downloadTextColor);
                                }
                            } catch (IllegalArgumentException e) {
                                if (r) {
                                    e.printStackTrace();
                                }
                            }
                            GameGuideConfigInfo.CloseInfo closeInfo2 = this.d;
                            this.e = closeInfo2.buttonText;
                            this.m = closeInfo2.targetType;
                            this.n = closeInfo2.target;
                        }
                    }
                } else {
                    GameGuideConfigInfo.DialogInfo dialogInfo = z.dialogInfo;
                    if (dialogInfo != null) {
                        this.e = dialogInfo.buttonText;
                        this.m = dialogInfo.targetType;
                        this.n = dialogInfo.target;
                    }
                }
            }
            String str4 = this.o;
            if (TextUtils.equals(ow3.a, this.p)) {
                str4 = k(this.m, this.n, "", "");
            }
            this.b = bx3.a(str4, this.p);
            if (!TextUtils.isEmpty(this.q)) {
                this.b.c(this.q);
            }
            this.c = lu3Var;
            GamenowDownloadButtomView gamenowDownloadButtomView = new GamenowDownloadButtomView(rp2.c());
            this.a = gamenowDownloadButtomView;
            gamenowDownloadButtomView.k(bk3.g(16.0f));
            gamenowDownloadButtomView.f(true);
            gamenowDownloadButtomView.j(color2);
            gamenowDownloadButtomView.h(color);
            gamenowDownloadButtomView.i(rp2.c().getResources().getColor(R.color.obfuscated_res_0x7f060423));
            gamenowDownloadButtomView.g(true);
            this.a.setText(this.e);
            this.a.setVisibility(0);
            this.a.setProgress(s);
            this.a.setState(DownloadState.NOT_START);
            r();
            t();
            return this.a;
        }
        return (GamenowDownloadButtomView) invokeCommon.objValue;
    }

    public final String k(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            if (TextUtils.isEmpty(this.o)) {
                str4 = "https://gamenow.baidu.com/api/download/newest_gamenow";
            } else {
                str4 = this.o;
            }
            this.o = str4;
            if (i == 0) {
                return str4;
            }
            String i2 = rp2.h0().i(AppRuntime.getAppContext());
            int J = jw3.o.J();
            StringBuffer stringBuffer = new StringBuffer();
            if (!TextUtils.isEmpty(i2)) {
                stringBuffer.append(i2);
            }
            stringBuffer.append(",");
            stringBuffer.append(J);
            if (i == 1) {
                if (TextUtils.isEmpty(str) || str.equals(StringUtil.NULL_STRING)) {
                    str = j63.K().getAppId();
                }
                stringBuffer.append(",");
                stringBuffer.append(str);
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    stringBuffer.append(",");
                    stringBuffer.append(str2);
                    stringBuffer.append(",");
                    stringBuffer.append(str3);
                }
            }
            str = (i != 2 || TextUtils.isEmpty(str)) ? "" : "";
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ext", new String(h(stringBuffer.toString().getBytes())));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT, str);
                }
                jSONObject.put("path", "operate");
                jSONObject.put("data", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jw3 jw3Var = jw3.o;
            if (jw3Var != null && jw3Var.z() != null && !TextUtils.isEmpty(jw3.o.z().gamenowChannel)) {
                str5 = jw3.o.z().gamenowChannel;
            } else {
                str5 = "2101000000";
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str6 = new String(h(jSONObject.toString().getBytes()));
            linkedHashMap.put("channel", str5);
            linkedHashMap.put("suffix", str6);
            linkedHashMap.put(BreakpointSQLiteKey.FILENAME, "");
            String f = f(this.o, linkedHashMap);
            if (!TextUtils.isEmpty(f)) {
                f = rp2.o().m(f);
            }
            if (r) {
                Log.e("DownloadButtonManager", "channel is " + str5);
                Log.e("DownloadButtonManager", "ext is " + stringBuffer.toString());
                Log.e("DownloadButtonManager", "suffixObj is " + jSONObject.toString());
                Log.e("DownloadButtonManager", "downloadUrl is " + f);
            }
            return f;
        }
        return (String) invokeCommon.objValue;
    }

    public final void p(String str, lu3 lu3Var) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, str, lu3Var) != null) || this.b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("key_download_package_name", this.b.c);
            jSONObject.put(NotInstallNotificationReceiver.INTENT_PARAMS_KEY_DOWNLOAD_URL, this.b.b);
            jSONObject2.put("from_view", this.h);
            jSONObject2.put("from_value", this.i);
            jSONObject2.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.j);
            jSONObject2.put("apk_id", this.b.b());
            jSONObject.put(DownloadConstants.DOWNLOAD_PARAMS, jSONObject2.toString());
            if (TextUtils.equals(str, "checkPackageExpired")) {
                if (jw3.o.z() == null) {
                    j = 0;
                } else {
                    j = jw3.o.z().packageExpire;
                }
                jSONObject.put(GameGuideConfigInfo.KEY_PACKAGE_EXPIRE, j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, str);
        bundle.putString("ubc_params", new fx3().a());
        bundle.putString("data", jSONObject.toString());
        f33 y = j63.K().y();
        if (y != null) {
            y.X(bundle, xw3.class, new c(this.b.c, str, lu3Var, this.h, this.i));
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
                Toast.makeText(rp2.c(), rp2.c().getResources().getString(R.string.obfuscated_res_0x7f0f01c2), 0).show();
                return;
            }
            bx3 bx3Var = this.b;
            if (bx3Var == null) {
                return;
            }
            DownloadState downloadState = bx3Var.a;
            if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download start");
                }
                p("startDownload", this.c);
            }
            if (this.b.a == DownloadState.DOWNLOADING && z) {
                if (r) {
                    Log.d("DownloadButtonManager", "download pause");
                }
                p("pauseDownload", this.c);
            }
            if (this.b.a == DownloadState.DOWNLOAD_PAUSED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download resume");
                }
                p(com.baidu.mobads.sdk.internal.ap.d, this.c);
            }
            if (this.b.a == DownloadState.DOWNLOAD_FAILED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download retry");
                }
                p("startDownload", this.c);
            }
            if (this.b.a == DownloadState.DOWNLOADED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download install");
                }
                this.c.b();
                p("installApp", this.c);
            }
            if (this.b.a == DownloadState.INSTALLED) {
                if (r) {
                    Log.d("DownloadButtonManager", "open app");
                }
                String e = this.c.e();
                if (TextUtils.isEmpty(this.b.c) && !TextUtils.isEmpty(e)) {
                    C(e);
                }
                p("open_manual", this.c);
            }
        }
    }

    public void t() {
        bx3 bx3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (bx3Var = this.b) != null && !TextUtils.isEmpty(bx3Var.c) && !TextUtils.isEmpty(this.p) && this.c != null) {
            if (ek3.F(rp2.c(), this.b.c)) {
                E(DownloadState.INSTALLED);
                g(this.p, "checkPackageExpired", this.h, this.i, DownloadState.INSTALLED.value());
                return;
            }
            p("checkPackageExpired", this.c);
        }
    }

    public final int v(DownloadState downloadState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, downloadState)) == null) {
            switch (b.a[downloadState.ordinal()]) {
                case 1:
                    return R.string.obfuscated_res_0x7f0f01a6;
                case 2:
                    return R.string.obfuscated_res_0x7f0f01a2;
                case 3:
                    return R.string.obfuscated_res_0x7f0f01a4;
                case 4:
                default:
                    return R.string.obfuscated_res_0x7f0f01a1;
                case 5:
                    return R.string.obfuscated_res_0x7f0f01a3;
                case 6:
                    return R.string.obfuscated_res_0x7f0f01a5;
            }
        }
        return invokeL.intValue;
    }
}
