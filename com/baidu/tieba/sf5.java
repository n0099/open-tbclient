package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.QqShareH5Switch;
import com.baidu.tbadk.switchs.UrlNeedCuidSwitch;
import com.baidu.tbadk.switchs.WeChatShareSmallAppToH5Switch;
import com.baidu.tieba.nf5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
/* loaded from: classes7.dex */
public class sf5 {
    public static /* synthetic */ Interceptable $ic;
    public static final String i;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public of5 b;
    public pf5 c;
    public String d;
    public nf5 e;
    public nf5.b f;
    public nf5.b g;
    public nf5.b h;

    /* loaded from: classes7.dex */
    public class a implements nf5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf5 a;

        public a(sf5 sf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sf5Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.sf5.b(com.baidu.tieba.sf5, com.baidu.tbadk.coreExtra.share.ShareItem):com.baidu.tbadk.coreExtra.share.ShareItem
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // com.baidu.tieba.nf5.b
        public void a(com.baidu.tbadk.coreExtra.share.ShareItem r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.sf5.a.$ic
                if (r0 != 0) goto L1d
            L4:
                com.baidu.tieba.sf5 r0 = r4.a
                java.lang.String r1 = "weixin"
                com.baidu.tbadk.coreExtra.share.ShareItem r5 = com.baidu.tieba.sf5.a(r0, r5, r1)
                com.baidu.tieba.sf5 r0 = r4.a
                com.baidu.tieba.sf5.b(r0, r5)
                com.baidu.tieba.sf5 r0 = r4.a
                com.baidu.tieba.pf5 r0 = com.baidu.tieba.sf5.c(r0)
                r1 = 3
                r2 = 0
                r0.a(r5, r1, r2)
                return
            L1d:
                r2 = r0
                r3 = 1048576(0x100000, float:1.469368E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.sf5.a.a(com.baidu.tbadk.coreExtra.share.ShareItem):void");
        }
    }

    /* loaded from: classes7.dex */
    public class b implements nf5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf5 a;

        public b(sf5 sf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sf5Var;
        }

        @Override // com.baidu.tieba.nf5.b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, shareItem) != null) {
                return;
            }
            this.a.c.a(this.a.v(shareItem, Share.QQFRIEND), 8, true);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements nf5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf5 a;

        public c(sf5 sf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sf5Var;
        }

        @Override // com.baidu.tieba.nf5.b
        public void a(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, shareItem) != null) {
                return;
            }
            this.a.c.a(this.a.v(shareItem, "qzone"), 4, true);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948149511, "Lcom/baidu/tieba/sf5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948149511, "Lcom/baidu/tieba/sf5;");
                return;
            }
        }
        i = TbConfig.TIEBA_ADDRESS;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return TbadkCoreApplication.getInst().appResponseToCmd(2001445);
        }
        return invokeV.booleanValue;
    }

    public sf5(Context context, of5 of5Var) {
        qf5 qf5Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, of5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = TbadkCoreApplication.getInst().getContext().getString(R.string.share_tail);
        this.f = new a(this);
        this.g = new b(this);
        this.h = new c(this);
        this.a = context;
        this.b = of5Var;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001445, qf5.class);
        if (runTask != null && runTask.getData() != null && (qf5Var = (qf5) runTask.getData()) != null) {
            this.c = qf5Var.a(this.a, this.b);
        }
    }

    public static String t(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65547, null, str, str2, z)) == null) {
            return u(str, CommandUBCHelper.COMMAND_UBC_TYPE_COPY, str2, z);
        }
        return (String) invokeLLZ.objValue;
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static /* synthetic */ com.baidu.tbadk.coreExtra.share.ShareItem b(com.baidu.tieba.sf5 r0, com.baidu.tbadk.coreExtra.share.ShareItem r1) {
        /*
            r0.f(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.sf5.b(com.baidu.tieba.sf5, com.baidu.tbadk.coreExtra.share.ShareItem):com.baidu.tbadk.coreExtra.share.ShareItem");
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.sf5.a.a(com.baidu.tbadk.coreExtra.share.ShareItem):void] */
    public static /* synthetic */ pf5 c(sf5 sf5Var) {
        return sf5Var.c;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (!str.contains("?")) {
                str = str + "?";
                str3 = "";
            } else {
                str3 = "&";
            }
            return str + str3 + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String i(ThreadData threadData, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, threadData, i2)) == null) {
            if (threadData == null) {
                return "";
            }
            String title = threadData.getTitle();
            if (i2 != 2 && i2 != 6 && i2 != 8) {
                String str = threadData.getAbstract();
                if (threadData.getIsNoTitle() == 0) {
                    return title;
                }
                return str;
            }
            return title;
        }
        return (String) invokeLI.objValue;
    }

    public static String h(ThreadData threadData, int i2, String str, long j, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{threadData, Integer.valueOf(i2), str, Long.valueOf(j), str2, str3})) == null) {
            if (threadData == null) {
                return "";
            }
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            StringBuilder sb = new StringBuilder();
            if (i2 != 2 && i2 != 6 && i2 != 8) {
                if (threadData.getIsNoTitle() == 0) {
                    String str4 = threadData.getAbstract();
                    if (!StringUtils.isNull(str4)) {
                        str3 = str4;
                    }
                    if (!StringUtils.isNull(str3) && !StringUtil.NULL_STRING.equals(str3)) {
                        if (str3.length() > 20) {
                            sb.append(str3.substring(0, 20));
                            sb.append("...");
                        } else {
                            sb.append(str3);
                        }
                        sb.append(StringUtils.lineSeparator);
                    } else {
                        String k = k(threadData, str2);
                        if (!StringUtils.isNull(k)) {
                            sb.append(inst.getString(R.string.post_author));
                            sb.append(k);
                            sb.append(StringUtils.lineSeparator);
                        }
                    }
                    if (j > 0) {
                        sb.append(inst.getString(R.string.forum_friend_looking));
                        sb.append(StringHelper.numFormatOver10000(j));
                    }
                } else {
                    String k2 = k(threadData, str2);
                    if (!StringUtils.isNull(k2)) {
                        sb.append(inst.getString(R.string.post_author));
                        sb.append(k2);
                        sb.append(StringUtils.lineSeparator);
                    }
                    if (j > 0) {
                        sb.append(inst.getString(R.string.forum_friend_looking));
                        sb.append(StringHelper.numFormatOver10000(j));
                    }
                }
            } else {
                if (j > 0) {
                    sb.append(inst.getString(R.string.forum_friend_looking));
                    sb.append(StringHelper.numFormatOver10000(j));
                    sb.append(StringUtils.lineSeparator);
                }
                String k3 = k(threadData, str2);
                if (!StringUtils.isNull(k3)) {
                    sb.append(inst.getString(R.string.post_author));
                    sb.append(k3);
                    sb.append(StringUtils.lineSeparator);
                }
                if (!StringUtils.isNull(str)) {
                    if (str.length() > 10) {
                        str = str.substring(0, 10) + "...";
                    }
                    sb.append(str);
                    sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0767));
                }
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
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
                if (threadData.isShareThread && threadData.originalThreadData != null) {
                    return 9;
                }
                if (!threadData.isRealVideoThread()) {
                    return 1;
                }
                return 2;
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
                    str2 = str2.substring(0, 10) + "...";
                }
            } else {
                str2 = "";
            }
            if (!StringUtils.isNull(str2)) {
                return str2;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public final ShareItem v(ShareItem shareItem, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, shareItem, str)) == null) {
            if (shareItem == null) {
                return null;
            }
            Uri uri = shareItem.z;
            if ((uri == null || uri.equals("")) && shareItem.d() == null) {
                str.startsWith(ThirdPartyUtil.TYPE_WEIXIN);
                shareItem.z = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
            }
            if (shareItem.r0) {
                shareItem.x = u(shareItem.x, str, shareItem.O, UtilHelper.isVideoThread(shareItem.R));
            }
            return shareItem;
        }
        return (ShareItem) invokeLL.objValue;
    }

    public static String u(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (vi.isEmpty(str)) {
                str = i;
            }
            String e = e(e(str, "sfc=" + str2), "client_type=2");
            String e2 = e(e, "client_version=" + TbConfig.getVersion());
            String e3 = e(e2, "st=" + (System.currentTimeMillis() / 1000));
            String e4 = e(e3, "is_video=" + z);
            if (str3 != null) {
                if (SwitchManager.getInstance().findType(UrlNeedCuidSwitch.URL_NEED_CUID_SWITCH) == 1) {
                    c2 = dj.c(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
                } else {
                    c2 = dj.c(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
                }
                return e(e4, "unique=" + c2);
            }
            return e4;
        }
        return (String) invokeCommon.objValue;
    }

    public final String d(String str, int i2, int i3, String str2) {
        InterceptResult invokeCommon;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2})) == null) {
            if (str == null) {
                return str2;
            }
            if (Math.min((i2 - str2.length()) - i3, str.length()) < str.length()) {
                return str.substring(0, min - 1) + ("..." + str2);
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
            if (WeChatShareSmallAppToH5Switch.isOn() && (!StringUtils.isNull(shareItem.I0) || !StringUtils.isNull(shareItem.J0) || shareItem.K0 != null)) {
                if (!StringUtils.isNull(shareItem.I0)) {
                    shareItem.v = vi.cutString(shareItem.I0, 100);
                }
                if (!StringUtils.isNull(shareItem.J0)) {
                    shareItem.w = vi.cutString(shareItem.J0, 100);
                }
                Uri uri = shareItem.K0;
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
            if (!StringUtils.isNull(shareItem.J0)) {
                shareItem.w = vi.cutString(shareItem.J0, 100);
            }
            Uri uri = shareItem.K0;
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

    public void o(ShareItem shareItem) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, shareItem) != null) || this.c == null) {
            return;
        }
        String str2 = shareItem.w;
        if (shareItem.q0) {
            str = this.d;
        } else {
            str = "";
        }
        shareItem.w = d(str2, Cea708Decoder.COMMAND_DLW, 20, str);
        this.c.a(v(shareItem, "renren"), 7, true);
    }

    public void q(ShareItem shareItem) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, shareItem) != null) || this.c == null) {
            return;
        }
        String str2 = shareItem.w;
        if (shareItem.q0) {
            str = this.d;
        } else {
            str = "";
        }
        shareItem.w = d(str2, Cea708Decoder.COMMAND_DLW, 20, str);
        this.c.a(v(shareItem, "tencent_weibo"), 5, true);
    }

    public void s(ShareItem shareItem) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, shareItem) != null) || this.c == null || shareItem == null) {
            return;
        }
        String str2 = shareItem.w;
        if (shareItem.q0) {
            str = this.d;
        } else {
            str = "";
        }
        shareItem.w = d(str2, 80, 20, str);
        this.c.a(v(shareItem, Share.WEIXIN_TIMELINE), 2, false);
    }

    public void m(ShareItem shareItem) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, shareItem) == null) && this.c != null && shareItem != null) {
            String str2 = shareItem.w;
            if (shareItem.q0) {
                str = this.d;
            } else {
                str = "";
            }
            shareItem.w = d(str2, 80, 32, str);
            if (!QqShareH5Switch.isOn() && !vi.isEmpty(shareItem.t0)) {
                shareItem.z = Uri.parse(shareItem.t0);
                this.c.a(v(shareItem, Share.QQFRIEND), 8, true);
            } else if (!QqShareH5Switch.isOn() && vi.isEmpty(shareItem.t0) && !vi.isEmpty(shareItem.O) && !"0".equals(shareItem.O)) {
                if (this.e == null) {
                    nf5 nf5Var = new nf5();
                    this.e = nf5Var;
                    nf5Var.c(this.g);
                }
                this.e.b(shareItem);
            } else {
                if (!QqShareH5Switch.isOn()) {
                    if (this.e == null) {
                        this.e = new nf5();
                    }
                    this.e.b(shareItem);
                }
                ShareItem v = v(shareItem, Share.QQFRIEND);
                g(v);
                this.c.a(v, 8, true);
            }
        }
    }

    public void n(ShareItem shareItem) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, shareItem) != null) || this.c == null) {
            return;
        }
        String str2 = shareItem.w;
        if (shareItem.q0) {
            str = this.d;
        } else {
            str = "";
        }
        shareItem.w = d(str2, 80, 32, str);
        if (!QqShareH5Switch.isOn() && !vi.isEmpty(shareItem.t0)) {
            shareItem.z = Uri.parse(shareItem.t0);
            this.c.a(v(shareItem, "qzone"), 4, true);
        } else if (!QqShareH5Switch.isOn() && vi.isEmpty(shareItem.t0) && !vi.isEmpty(shareItem.O) && !"0".equals(shareItem.O)) {
            if (this.e == null) {
                nf5 nf5Var = new nf5();
                this.e = nf5Var;
                nf5Var.c(this.h);
            }
            this.e.b(shareItem);
        } else {
            if (!QqShareH5Switch.isOn()) {
                if (this.e == null) {
                    this.e = new nf5();
                }
                this.e.b(shareItem);
            }
            this.c.a(v(shareItem, "qzone"), 4, true);
        }
    }

    public void p(ShareItem shareItem) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, shareItem) != null) || this.c == null) {
            return;
        }
        if (!mf5.b(TbadkApplication.getInst().getApplicationContext(), 6)) {
            BdToast.b(TbadkApplication.getInst().getApplicationContext(), TbadkApplication.getInst().getApplicationContext().getText(R.string.share_sina_weibo_not_install)).q();
            return;
        }
        String string = TbadkCoreApplication.getInst().getContext().getString(R.string.weibo_share_tail);
        if (shareItem.L0 != null) {
            str = string + TbadkCoreApplication.getInst().getContext().getString(R.string.share_group_tail);
        } else {
            str = string + this.d;
        }
        String str2 = shareItem.w;
        if (!shareItem.q0) {
            str = "";
        }
        shareItem.w = d(str2, Cea708Decoder.COMMAND_DLW, 20, str);
        this.c.a(v(shareItem, "sina_weibo"), 6, true);
    }

    public void r(ShareItem shareItem) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareItem) != null) || this.c == null || shareItem == null) {
            return;
        }
        if (StringUtils.isNull(shareItem.O)) {
            String str2 = shareItem.w;
            if (shareItem.q0) {
                str = this.d;
            } else {
                str = "";
            }
            shareItem.w = d(str2, 80, 20, str);
        }
        if (shareItem.v0 && !vi.isEmpty(shareItem.t0)) {
            shareItem.z = Uri.parse(shareItem.t0);
            ShareItem v = v(shareItem, ThirdPartyUtil.TYPE_WEIXIN);
            f(v);
            this.c.a(v, 3, false);
        } else if (shareItem.v0 && vi.isEmpty(shareItem.t0) && !vi.isEmpty(shareItem.O) && !"0".equals(shareItem.O)) {
            if (this.e == null) {
                nf5 nf5Var = new nf5();
                this.e = nf5Var;
                nf5Var.c(this.f);
            }
            this.e.b(shareItem);
        } else {
            if (shareItem.C == 4) {
                if (this.e == null) {
                    this.e = new nf5();
                }
                this.e.b(shareItem);
            }
            ShareItem v2 = v(shareItem, ThirdPartyUtil.TYPE_WEIXIN);
            f(v2);
            this.c.a(v2, 3, false);
        }
    }
}
