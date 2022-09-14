package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.QqShareH5Switch;
import com.baidu.tbadk.switchs.UrlNeedCuidSwitch;
import com.baidu.tbadk.switchs.WeChatShareSmallAppToH5Switch;
import com.baidu.tieba.m25;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes5.dex */
public class r25 {
    public static /* synthetic */ Interceptable $ic;
    public static final String j;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public n25 b;
    public o25 c;
    public String d;
    public String e;
    public m25 f;
    public m25.b g;
    public m25.b h;
    public m25.b i;

    /* loaded from: classes5.dex */
    public class a implements m25.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r25 a;

        public a(r25 r25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r25Var;
        }

        @Override // com.baidu.tieba.m25.b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                ShareItem w = this.a.w(shareItem, ThirdPartyUtil.TYPE_WEIXIN);
                this.a.f(w);
                this.a.c.a(w, 3, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements m25.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r25 a;

        public b(r25 r25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r25Var;
        }

        @Override // com.baidu.tieba.m25.b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                this.a.c.a(this.a.w(shareItem, Share.QQFRIEND), 8, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements m25.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r25 a;

        public c(r25 r25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r25Var;
        }

        @Override // com.baidu.tieba.m25.b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                this.a.c.a(this.a.w(shareItem, "qzone"), 4, true);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948069748, "Lcom/baidu/tieba/r25;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948069748, "Lcom/baidu/tieba/r25;");
                return;
            }
        }
        j = TbConfig.TIEBA_ADDRESS;
    }

    public r25(Context context, n25 n25Var) {
        p25 p25Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, n25Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f117c);
        this.e = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f15c0) + this.d;
        this.g = new a(this);
        this.h = new b(this);
        this.i = new c(this);
        this.a = context;
        this.b = n25Var;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001445, p25.class);
        if (runTask == null || runTask.getData() == null || (p25Var = (p25) runTask.getData()) == null) {
            return;
        }
        this.c = p25Var.a(this.a, this.b);
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (str.contains("?")) {
                str3 = "&";
            } else {
                str = str + "?";
                str3 = "";
            }
            return str + str3 + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String h(ThreadData threadData, int i, String str, long j2, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{threadData, Integer.valueOf(i), str, Long.valueOf(j2), str2, str3})) == null) {
            if (threadData == null) {
                return "";
            }
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            StringBuilder sb = new StringBuilder();
            if (i != 2 && i != 6 && i != 8) {
                if (threadData.getIsNoTitle() == 0) {
                    String str4 = threadData.getAbstract();
                    if (!StringUtils.isNull(str4)) {
                        str3 = str4;
                    }
                    if (!StringUtils.isNull(str3) && !StringUtil.NULL_STRING.equals(str3)) {
                        if (str3.length() > 20) {
                            sb.append(str3.substring(0, 20));
                            sb.append(StringHelper.STRING_MORE);
                        } else {
                            sb.append(str3);
                        }
                        sb.append(StringUtils.lineSeparator);
                    } else {
                        String k = k(threadData, str2);
                        if (!StringUtils.isNull(k)) {
                            sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0eef));
                            sb.append(k);
                            sb.append(StringUtils.lineSeparator);
                        }
                    }
                    if (j2 > 0) {
                        sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0690));
                        sb.append(StringHelper.numFormatOver10000(j2));
                    }
                } else {
                    String k2 = k(threadData, str2);
                    if (!StringUtils.isNull(k2)) {
                        sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0eef));
                        sb.append(k2);
                        sb.append(StringUtils.lineSeparator);
                    }
                    if (j2 > 0) {
                        sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0690));
                        sb.append(StringHelper.numFormatOver10000(j2));
                    }
                }
            } else {
                if (j2 > 0) {
                    sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0690));
                    sb.append(StringHelper.numFormatOver10000(j2));
                    sb.append(StringUtils.lineSeparator);
                }
                String k3 = k(threadData, str2);
                if (!StringUtils.isNull(k3)) {
                    sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0eef));
                    sb.append(k3);
                    sb.append(StringUtils.lineSeparator);
                }
                if (!StringUtils.isNull(str)) {
                    if (str.length() > 10) {
                        str = str.substring(0, 10) + StringHelper.STRING_MORE;
                    }
                    sb.append(str);
                    sb.append(inst.getString(R.string.obfuscated_res_0x7f0f066e));
                }
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String i(ThreadData threadData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, threadData, i)) == null) {
            if (threadData == null) {
                return "";
            }
            String title = threadData.getTitle();
            if (i == 2 || i == 6 || i == 8) {
                return title;
            }
            return threadData.getIsNoTitle() == 0 ? title : threadData.getAbstract();
        }
        return (String) invokeLI.objValue;
    }

    public static int j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, threadData)) == null) {
            if (threadData != null) {
                if (threadData.isRealGod()) {
                    return 4;
                }
                if (threadData.getIsLive() == 1) {
                    return 3;
                }
                if (threadData.isBJHArticleThreadType()) {
                    return 5;
                }
                if (threadData.isBJHVideoThreadType()) {
                    return 6;
                }
                if (threadData.isBJHNormalThreadType()) {
                    return 7;
                }
                if (threadData.isBJHVideoDynamicThreadType()) {
                    return 8;
                }
                if (!threadData.isShareThread || threadData.originalThreadData == null) {
                    return threadData.isRealVideoThread() ? 2 : 1;
                }
                return 9;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String k(ThreadData threadData, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, threadData, str)) == null) {
            if (threadData.getAuthor() != null) {
                str2 = threadData.getAuthor().getName_show();
                if (!StringUtils.isNull(str2) && str2.length() > 10) {
                    str2 = str2.substring(0, 10) + StringHelper.STRING_MORE;
                }
            } else {
                str2 = "";
            }
            return StringUtils.isNull(str2) ? str : str2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? TbadkCoreApplication.getInst().appResponseToCmd(2001445) : invokeV.booleanValue;
    }

    public static String u(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65547, null, str, str2, z)) == null) ? v(str, "copy", str2, z) : (String) invokeLLZ.objValue;
    }

    public static String v(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (dj.isEmpty(str)) {
                str = j;
            }
            String e = e(e(str, "sfc=" + str2), "client_type=2");
            String e2 = e(e, "client_version=" + TbConfig.getVersion());
            String e3 = e(e2, "st=" + (System.currentTimeMillis() / 1000));
            String e4 = e(e3, "is_video=" + z);
            if (str3 != null) {
                if (SwitchManager.getInstance().findType(UrlNeedCuidSwitch.URL_NEED_CUID_SWITCH) == 1) {
                    c2 = lj.c(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
                } else {
                    c2 = lj.c(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
                }
                return e(e4, "unique=" + c2);
            }
            return e4;
        }
        return (String) invokeCommon.objValue;
    }

    public final String d(String str, int i, int i2, String str2) {
        InterceptResult invokeCommon;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2})) == null) {
            if (str == null) {
                return str2;
            }
            if (Math.min((i - str2.length()) - i2, str.length()) < str.length()) {
                return str.substring(0, min - 1) + (StringHelper.STRING_MORE + str2);
            }
            return str + str2;
        }
        return (String) invokeCommon.objValue;
    }

    public final ShareItem f(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareItem)) == null) {
            if (shareItem == null) {
                return shareItem;
            }
            if (WeChatShareSmallAppToH5Switch.isOn() && (!StringUtils.isNull(shareItem.G0) || !StringUtils.isNull(shareItem.H0) || shareItem.I0 != null)) {
                if (!StringUtils.isNull(shareItem.G0)) {
                    shareItem.v = dj.cutString(shareItem.G0, 100);
                }
                if (!StringUtils.isNull(shareItem.H0)) {
                    shareItem.w = dj.cutString(shareItem.H0, 100);
                }
                Uri uri = shareItem.I0;
                if (uri != null) {
                    shareItem.z = uri;
                }
            }
            if (WeChatShareSmallAppToH5Switch.isOn() && !StringUtils.isNull(shareItem.x)) {
                shareItem.x = e(shareItem.x, "&source=12_16_sharecard_a");
            }
            return shareItem;
        }
        return (ShareItem) invokeL.objValue;
    }

    public final ShareItem g(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem)) == null) {
            if (!StringUtils.isNull(shareItem.H0)) {
                shareItem.w = dj.cutString(shareItem.H0, 100);
            }
            Uri uri = shareItem.I0;
            if (uri != null) {
                shareItem.z = uri;
            }
            if (!StringUtils.isNull(shareItem.x)) {
                shareItem.x = e(shareItem.x, "&source=12_16_sharecard_a");
            }
            return shareItem;
        }
        return (ShareItem) invokeL.objValue;
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("file://")) {
                try {
                    file = new File(new URI(str));
                } catch (URISyntaxException unused) {
                }
                return file.isFile() && file.exists();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void n(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, shareItem) == null) || this.c == null || shareItem == null) {
            return;
        }
        shareItem.w = d(shareItem.w, 80, 32, shareItem.n0 ? this.d : "");
        if (!QqShareH5Switch.isOn() && !dj.isEmpty(shareItem.q0)) {
            shareItem.z = Uri.parse(shareItem.q0);
            this.c.a(w(shareItem, Share.QQFRIEND), 8, true);
        } else if (!QqShareH5Switch.isOn() && dj.isEmpty(shareItem.q0) && !dj.isEmpty(shareItem.O) && !"0".equals(shareItem.O)) {
            if (this.f == null) {
                m25 m25Var = new m25();
                this.f = m25Var;
                m25Var.c(this.h);
            }
            this.f.b(shareItem);
        } else {
            if (!QqShareH5Switch.isOn()) {
                if (this.f == null) {
                    this.f = new m25();
                }
                this.f.b(shareItem);
            }
            ShareItem w = w(shareItem, Share.QQFRIEND);
            g(w);
            this.c.a(w, 8, true);
        }
    }

    public void o(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, shareItem) == null) || this.c == null) {
            return;
        }
        shareItem.w = d(shareItem.w, 80, 32, shareItem.n0 ? this.d : "");
        if (!QqShareH5Switch.isOn() && !dj.isEmpty(shareItem.q0)) {
            shareItem.z = Uri.parse(shareItem.q0);
            this.c.a(w(shareItem, "qzone"), 4, true);
        } else if (!QqShareH5Switch.isOn() && dj.isEmpty(shareItem.q0) && !dj.isEmpty(shareItem.O) && !"0".equals(shareItem.O)) {
            if (this.f == null) {
                m25 m25Var = new m25();
                this.f = m25Var;
                m25Var.c(this.i);
            }
            this.f.b(shareItem);
        } else {
            if (!QqShareH5Switch.isOn()) {
                if (this.f == null) {
                    this.f = new m25();
                }
                this.f.b(shareItem);
            }
            this.c.a(w(shareItem, "qzone"), 4, true);
        }
    }

    public void p(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, shareItem) == null) || this.c == null) {
            return;
        }
        shareItem.w = d(shareItem.w, Cea708Decoder.COMMAND_DLW, 20, shareItem.n0 ? this.d : "");
        this.c.a(w(shareItem, "renren"), 7, true);
    }

    public void q(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, shareItem) == null) || this.c == null) {
            return;
        }
        if (!l25.b(TbadkApplication.getInst().getApplicationContext(), 6)) {
            BdToast.b(TbadkApplication.getInst().getApplicationContext(), TbadkApplication.getInst().getApplicationContext().getText(R.string.obfuscated_res_0x7f0f1178)).i();
            return;
        }
        shareItem.w = d(shareItem.w, Cea708Decoder.COMMAND_DLW, 20, shareItem.n0 ? this.e : "");
        this.c.a(w(shareItem, "sina_weibo"), 6, true);
    }

    public void r(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareItem) == null) || this.c == null) {
            return;
        }
        shareItem.w = d(shareItem.w, Cea708Decoder.COMMAND_DLW, 20, shareItem.n0 ? this.d : "");
        this.c.a(w(shareItem, "tencent_weibo"), 5, true);
    }

    public void s(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, shareItem) == null) || this.c == null || shareItem == null) {
            return;
        }
        if (StringUtils.isNull(shareItem.O)) {
            shareItem.w = d(shareItem.w, 80, 20, shareItem.n0 ? this.d : "");
        }
        if (shareItem.s0 && !dj.isEmpty(shareItem.q0)) {
            shareItem.z = Uri.parse(shareItem.q0);
            ShareItem w = w(shareItem, ThirdPartyUtil.TYPE_WEIXIN);
            f(w);
            this.c.a(w, 3, false);
        } else if (shareItem.s0 && dj.isEmpty(shareItem.q0) && !dj.isEmpty(shareItem.O) && !"0".equals(shareItem.O)) {
            if (this.f == null) {
                m25 m25Var = new m25();
                this.f = m25Var;
                m25Var.c(this.g);
            }
            this.f.b(shareItem);
        } else {
            if (shareItem.C == 4) {
                if (this.f == null) {
                    this.f = new m25();
                }
                this.f.b(shareItem);
            }
            ShareItem w2 = w(shareItem, ThirdPartyUtil.TYPE_WEIXIN);
            f(w2);
            this.c.a(w2, 3, false);
        }
    }

    public void t(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, shareItem) == null) || this.c == null || shareItem == null) {
            return;
        }
        shareItem.w = d(shareItem.w, 80, 20, shareItem.n0 ? this.d : "");
        this.c.a(w(shareItem, Share.WEIXIN_TIMELINE), 2, false);
    }

    public final ShareItem w(ShareItem shareItem, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, shareItem, str)) == null) {
            if (shareItem == null) {
                return null;
            }
            Uri uri = shareItem.z;
            if ((uri == null || uri.equals("")) && shareItem.c() == null) {
                str.startsWith(ThirdPartyUtil.TYPE_WEIXIN);
                shareItem.z = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
            }
            Uri uri2 = shareItem.z;
            if (uri2 != null && !uri2.equals("")) {
                String uri3 = shareItem.z.toString();
                if (!l(uri3) && !x(uri3)) {
                    shareItem.z = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
                } else {
                    shareItem.z = Uri.parse(uri3);
                    e(uri3, "sfc=" + str);
                }
            }
            if (shareItem.o0) {
                shareItem.x = v(shareItem.x, str, shareItem.O, UtilHelper.isVideoThread(shareItem.Q));
            }
            return shareItem;
        }
        return (ShareItem) invokeLL.objValue;
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            String[] split = "jpg,jpeg,png,gif,bmp".split(",");
            if (UrlManager.getInstance().UrlValidated(str)) {
                if (split == null || split.length <= 0) {
                    return true;
                }
                for (String str2 : split) {
                    if (str2 != null && !str2.equals("") && (str.contains(str2) || str.contains(str2.toUpperCase()))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
