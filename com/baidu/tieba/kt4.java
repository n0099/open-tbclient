package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class kt4 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || customResponsedMessage.getData() == null) {
                return;
            }
            gt4.j(TbadkCoreApplication.getInst());
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements UrlManager.UrlWebDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlWebDealListener
        public void deal(TbPageContext<?> tbPageContext, String str, String str2, boolean z, UrlManager.UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, str, str2, Boolean.valueOf(z), urlWebDialogCancelListener, Boolean.valueOf(z2), bundle}) == null) {
                if (z2) {
                    kt4.q(tbPageContext, str2, null, false, bundle);
                } else {
                    kt4.s(tbPageContext, str2, str, z, bundle);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            String str;
            String str2;
            Uri parse;
            Bundle bundle;
            Bundle i;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str4 = strArr[0];
                if (StringUtils.isNull(str4)) {
                    return 3;
                }
                if (strArr.length > 2) {
                    str = strArr[2];
                } else {
                    str = null;
                }
                if (strArr.length > 1) {
                    str2 = strArr[1];
                } else {
                    str2 = null;
                }
                if (str4.startsWith("tel:")) {
                    UtilHelper.callPhone(tbPageContext.getPageActivity(), str4.substring(4));
                    return 0;
                } else if (oq5.h(str4) && str4.toLowerCase().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) {
                    kt4.p(tbPageContext.getPageActivity(), str4);
                    return 0;
                } else {
                    String str5 = "";
                    if (str4.contains(UrlSchemaHelper.JUMP_TO_HOT_TOPIC)) {
                        Uri parse2 = Uri.parse(str4);
                        String queryParameter = parse2.getQueryParameter("topic_id");
                        String queryParameter2 = parse2.getQueryParameter(IntentConfig.TOPIC_NAME);
                        String queryParameter3 = parse2.getQueryParameter("is_video_topic");
                        if (TextUtils.isEmpty(queryParameter)) {
                            return 3;
                        }
                        if (strArr.length > 1 && !StringUtils.isNull(strArr[1])) {
                            str5 = strArr[1];
                        }
                        if (!StringHelper.equals(queryParameter3, "1") && NewWebHotTopicPageSwitch.isOn()) {
                            mp5.e(tbPageContext, queryParameter, queryParameter2);
                        } else {
                            new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(queryParameter, queryParameter2, queryParameter3, str5).start();
                        }
                        return 0;
                    } else if (str4.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                        String substring = str4.substring(4);
                        if (!str4.contains("body=")) {
                            str3 = "";
                            str5 = substring;
                        } else {
                            str3 = oq5.c(str4, "body=");
                            int indexOf = substring.indexOf("?");
                            if (indexOf >= 1 && indexOf <= substring.length()) {
                                str5 = substring.substring(0, indexOf);
                            }
                        }
                        UtilHelper.smsTo(tbPageContext.getPageActivity(), str5, str3);
                        return 0;
                    } else if (str4.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_OUTER)) {
                        gt4.o(tbPageContext.getPageActivity(), str4);
                        return 1;
                    } else if (UtilHelper.isNativeAdURL(str4)) {
                        g19.a(tbPageContext.getPageActivity(), str4, null, null, null);
                        return 1;
                    } else if (!str4.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE) && !str4.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE_2)) {
                        if ((str4.contains(UrlSchemaHelper.SCHEMA_TYPE_FINISH_THIS_PAGE) || str4.startsWith(UrlSchemaHelper.SCHEMA_TYPE_CLOSE_WEBVIEW)) && tbPageContext.getPageActivity() != null) {
                            tbPageContext.getPageActivity().finish();
                            return 1;
                        } else if (str4.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str4.contains(UrlSchemaHelper.TBEAN_TOAST) && (tbPageContext instanceof Activity)) {
                            UtilHelper.showToast(tbPageContext.getPageActivity(), (int) R.string.buy_sucess);
                            ((Activity) tbPageContext).finish();
                            return 0;
                        } else if (str4.startsWith("tieba://focusforum")) {
                            TbadkCoreApplication.getInst().setLikeBarChanged(true);
                            return 0;
                        } else if (str4.startsWith("baiduxiuba://")) {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.addCategory("android.intent.category.DEFAULT");
                            intent.setData(Uri.parse(str4));
                            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                            tbPageContext.getPageActivity().startActivity(intent);
                            return 0;
                        } else if (str4.contains(UrlSchemaHelper.AUTO_PAY_MEMBER_SUCC_URL) && str4.contains(UrlSchemaHelper.AUTO_PAY_MEMBER_SUCC_PARAM)) {
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016525, Boolean.TRUE));
                            tbPageContext.getPageActivity().finish();
                            return 1;
                        } else if (str4.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str4.contains(UrlSchemaHelper.GOTO_TDOU_PAY_BUNDING_PHONE)) {
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001359, oq5.c(str4, "bindid=")));
                            tbPageContext.getPageActivity().finish();
                            return 1;
                        } else if (str4.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str4.contains(UrlSchemaHelper.CHANGE_YINJI_SUCCESS) && (i = oq5.i(str4)) != null && UrlSchemaHelper.CHANGE_YINJI_SUCCESS.equalsIgnoreCase(i.getString("path"))) {
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001372));
                            return 0;
                        } else if (str4.startsWith(UrlSchemaHelper.SCHEME_TYPE_ACCOUNT_SAFE) && tbPageContext.getPageActivity() != null) {
                            MessageManager.getInstance().runTask(2921329, null, tbPageContext.getPageActivity());
                            return 0;
                        } else if (str4.contains(UrlSchemaHelper.FROM_FORUM_SQUARE) && tbPageContext.getPageActivity() != null) {
                            ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(tbPageContext.getPageActivity());
                            forumSquareActivityConfig.setUri(Uri.parse(str4));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
                            return 0;
                        } else if (str4.contains(UrlSchemaHelper.FROM_ENTER_FORUM) && tbPageContext.getPageActivity() != null) {
                            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(1);
                            String queryParameter4 = Uri.parse(str4).getQueryParameter(BdUniDispatchSchemeController.PARAM_TAB_NAME);
                            if (!gi.isEmpty(queryParameter4)) {
                                createNormalCfg.setSubTab(0, queryParameter4);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, createNormalCfg));
                            return 0;
                        } else {
                            if (!str4.startsWith(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE)) {
                                if (!str4.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                                    if (!str4.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TOPIC)) {
                                        if (!str4.startsWith(UrlSchemaHelper.SCHEMA_TYPE_ZB)) {
                                            if (str4.startsWith(UrlSchemaHelper.SCHEMA_TYPE_LIST)) {
                                                String substring2 = str4.substring(5);
                                                if (!TextUtils.isEmpty(substring2)) {
                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2902028, new ForumRankActivityConfig(tbPageContext.getPageActivity(), substring2, str)));
                                                }
                                            } else if (str4.contains("com.baidu.tieba://unidispatch/tbwebview") && (parse = Uri.parse(str4)) != null) {
                                                String queryParameter5 = parse.getQueryParameter("url");
                                                String queryParameter6 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_OPEN_TYPE);
                                                if (!StringUtils.isNull(queryParameter6)) {
                                                    bundle = new Bundle();
                                                    bundle.putString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE, queryParameter6);
                                                } else {
                                                    bundle = null;
                                                }
                                                kt4.q(tbPageContext, queryParameter5, null, false, bundle);
                                                return 0;
                                            }
                                        } else {
                                            kt4.r(tbPageContext, str4.substring(3), tbPageContext.getString(R.string.photo_live_tips), false, true, false, false);
                                        }
                                    } else {
                                        kt4.r(tbPageContext, str2, str4.substring(6), false, true, true, false);
                                    }
                                } else {
                                    kt4.r(tbPageContext, gt4.l(str4.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, ""), str), null, false, true, true, true);
                                }
                            } else {
                                kt4.r(tbPageContext, gt4.l(str4.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE, ""), str), null, false, true, true, true);
                            }
                            return 3;
                        }
                    } else {
                        gt4.s(tbPageContext.getPageActivity(), str4);
                        return 1;
                    }
                }
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Bundle d;

        public d(TbPageContext tbPageContext, String str, String str2, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, str, str2, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = str;
            this.c = str2;
            this.d = bundle;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
                gt4.u(this.a.getPageActivity(), this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            PbActivityConfig createNormalCfg;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr[0] != null) {
                    Uri parse = Uri.parse(strArr[0]);
                    if ("lego".equalsIgnoreCase(parse.getAuthority())) {
                        if (!kt4.g(tbPageContext, parse, null, false)) {
                            return 3;
                        }
                        return 0;
                    } else if ("pb".equalsIgnoreCase(parse.getAuthority())) {
                        String queryParameter = parse.getQueryParameter("tId");
                        String queryParameter2 = parse.getQueryParameter("view_type");
                        if (queryParameter == null || queryParameter.length() <= 0) {
                            return 3;
                        }
                        if (queryParameter2 != null && (queryParameter2.equals("2") || queryParameter2.equals("3"))) {
                            createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createViewTypeCfg(queryParameter, Boolean.valueOf(queryParameter2.equals("2")).booleanValue(), Boolean.valueOf(!queryParameter2.equals("3")).booleanValue(), "lego");
                            createNormalCfg.setVideo_source("frs");
                        } else {
                            createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(queryParameter, null, "lego");
                        }
                        tbPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        return 0;
                    } else if ("frs".equalsIgnoreCase(parse.getAuthority())) {
                        String queryParameter3 = parse.getQueryParameter(TiebaStatic.Params.H5_FORUM_NAME);
                        if (queryParameter3 == null || queryParameter3.length() <= 0) {
                            return 3;
                        }
                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(queryParameter3, "lego");
                        createNormalCfg2.setCallFrom(12);
                        tbPageContext.sendMessage(new CustomMessage(2003000, createNormalCfg2));
                        return 0;
                    } else if ("person".equalsIgnoreCase(parse.getAuthority())) {
                        String queryParameter4 = parse.getQueryParameter("uid");
                        String queryParameter5 = parse.getQueryParameter("uname");
                        String queryParameter6 = parse.getQueryParameter("changeAvatar");
                        if (queryParameter4 == null || queryParameter4.length() <= 0) {
                            return 3;
                        }
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(tbPageContext.getPageActivity(), queryParameter4, queryParameter5);
                        personInfoActivityConfig.setChangeAvatar(queryParameter6);
                        tbPageContext.sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                        return 0;
                    } else if ("topic".equalsIgnoreCase(parse.getAuthority())) {
                        String queryParameter7 = parse.getQueryParameter("topic_id");
                        String queryParameter8 = parse.getQueryParameter(IntentConfig.TOPIC_NAME);
                        String queryParameter9 = parse.getQueryParameter("is_video_topic");
                        if (queryParameter7 != null && queryParameter8 != null) {
                            if (!StringHelper.equals(queryParameter9, "1") && NewWebHotTopicPageSwitch.isOn()) {
                                mp5.e(tbPageContext, queryParameter7, queryParameter8);
                            } else {
                                new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(queryParameter7, queryParameter8, queryParameter9, null).start();
                            }
                            return 1;
                        } else if (queryParameter7 != null) {
                            if (!StringHelper.equals(queryParameter9, "1") && NewWebHotTopicPageSwitch.isOn()) {
                                mp5.e(tbPageContext, queryParameter7, null);
                            } else {
                                new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(queryParameter7, null, queryParameter9, null).start();
                            }
                            return 1;
                        }
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr[0] != null) {
                    String str = strArr[0];
                    String str2 = null;
                    if (!str.startsWith(kt4.b) && !str.startsWith(kt4.c)) {
                        if (!str.startsWith(kt4.d) && !str.startsWith(kt4.e)) {
                            return 3;
                        }
                        int indexOf = str.indexOf("page/") + 5;
                        int indexOf2 = str.indexOf("?");
                        if (indexOf > 5 && indexOf2 > indexOf) {
                            str2 = str.substring(indexOf, indexOf2);
                        }
                        if (indexOf2 > -1) {
                            if (kt4.g(tbPageContext, Uri.parse(UrlSchemaHelper.SCHEMA_TYPE_LEGO + str.substring(indexOf2 + 1)), str2, true)) {
                                return 0;
                            }
                        }
                        return 3;
                    }
                    int indexOf3 = str.indexOf("page/") + 5;
                    int indexOf4 = str.indexOf("?");
                    if (indexOf3 > 5 && indexOf4 > indexOf3) {
                        str2 = str.substring(indexOf3, indexOf4);
                    }
                    if (indexOf4 > -1) {
                        if (kt4.g(tbPageContext, Uri.parse(UrlSchemaHelper.SCHEMA_TYPE_LEGO + str.substring(indexOf4 + 1)), str2, false)) {
                            return 0;
                        }
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947924606, "Lcom/baidu/tieba/kt4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947924606, "Lcom/baidu/tieba/kt4;");
                return;
            }
        }
        a = TbConfig.TIEBA_ADDRESS + "mo/q/checkurl?url=";
        b = TbConfig.TIEBA_ADDRESS + "mo/q/blitz/index#";
        c = TbConfig.TIEBA_ADDRESS + "mo/q/blitz/index#";
        d = TbConfig.TIEBA_ADDRESS + "tb/zt/lego/h5/#";
        e = TbConfig.TIEBA_ADDRESS + "tb/zt/lego/h5/#";
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            UrlManager.getInstance().addListener(new c());
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            UrlManager.getInstance().addListener(new f());
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            UrlManager.getInstance().addListener(new g());
        }
    }

    public static boolean g(TbPageContext<?> tbPageContext, Uri uri, String str, boolean z) {
        InterceptResult invokeCommon;
        String queryParameter;
        int i;
        int i2;
        int i3;
        String str2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{tbPageContext, uri, str, Boolean.valueOf(z)})) == null) {
            if (tbPageContext != null && uri != null) {
                if (str != null && str.length() != 0) {
                    queryParameter = str;
                } else {
                    queryParameter = uri.getQueryParameter(LegoListActivityConfig.PAGE_ID);
                }
                String queryParameter2 = uri.getQueryParameter("page_type");
                String queryParameter3 = uri.getQueryParameter("item_id");
                String queryParameter4 = uri.getQueryParameter("rn");
                String queryParameter5 = uri.getQueryParameter("params");
                String queryParameter6 = uri.getQueryParameter(LegoListActivityConfig.PRE_LOAD);
                String queryParameter7 = uri.getQueryParameter("next_page");
                String queryParameter8 = uri.getQueryParameter("lego_version");
                String queryParameter9 = uri.getQueryParameter(LegoListActivityConfig.IS_IMMERSIVE);
                String queryParameter10 = uri.getQueryParameter(LegoListActivityConfig.HAS_ANIMATION);
                String queryParameter11 = uri.getQueryParameter(LegoListActivityConfig.IS_LANDINGPAGE);
                String queryParameter12 = uri.getQueryParameter("source");
                if (TextUtils.isEmpty(queryParameter12)) {
                    queryParameter12 = "unknown";
                }
                String str3 = queryParameter12;
                if ((!z || j(queryParameter8)) && queryParameter != null && queryParameter2 != null && queryParameter.length() > 0 && queryParameter2.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(queryParameter2);
                        long parseLong = Long.parseLong(queryParameter);
                        try {
                            i = Integer.parseInt(queryParameter4);
                        } catch (Exception unused) {
                            i = 20;
                        }
                        try {
                            i2 = Integer.parseInt(queryParameter9);
                        } catch (Exception unused2) {
                            i2 = 0;
                        }
                        try {
                            i3 = Integer.parseInt(queryParameter10);
                        } catch (Exception unused3) {
                            i3 = 0;
                        }
                        if (i3 == 1) {
                            str2 = uri.getQueryParameter(LegoListActivityConfig.ANIMATION_INFO);
                        } else {
                            str2 = "";
                        }
                        try {
                            i4 = Integer.parseInt(queryParameter11);
                        } catch (Exception unused4) {
                            i4 = 0;
                        }
                        LegoListActivityConfig createNormalCfg = new LegoListActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(parseLong, parseInt, queryParameter3, i2, i, queryParameter5);
                        createNormalCfg.addLandingPageParams(str2, queryParameter6, queryParameter7, i3, i4, str3);
                        tbPageContext.sendMessage(new CustomMessage(2016447, createNormalCfg));
                        return true;
                    } catch (Exception unused5) {
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            MessageManager.getInstance().registerListener(2005016, new a(0));
            UrlManager.getInstance().setWebListener(new b());
            SwitchManager.getInstance().addSwitchData(new ue("switch_mbaidu_startup", 1, null));
            m();
            n();
            o();
        }
    }

    public static boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return "lego".equalsIgnoreCase(Uri.parse(str).getAuthority());
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "1.0.0";
            }
            if (TbConfig.getLegoLibVersion().compareTo(str) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                String str2 = new String(str.getBytes(), StandardCharsets.UTF_8);
                try {
                    return URLEncoder.encode(str2, "UTF-8");
                } catch (Exception unused) {
                    return str2;
                }
            } catch (Exception unused2) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            String str2 = a;
            Matcher matcher = Pattern.compile("^http[s]?:\\/\\/[^\\/\\\\\\\\]*(tieba\\.baidu\\.com\\/)", 2).matcher(str);
            if (!str.startsWith(str2)) {
                if (matcher == null || !matcher.find()) {
                    return str2 + t(str);
                }
                return str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            String checkUrl = TbadkCoreApplication.getInst().getCheckUrl();
            if (checkUrl == null) {
                checkUrl = a;
            } else if (checkUrl.trim().length() == 0) {
                return str;
            }
            if (str.startsWith(checkUrl)) {
                return str;
            }
            return checkUrl + t(str);
        }
        return (String) invokeL.objValue;
    }

    public static boolean p(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, str)) == null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                    context.startActivity(intent);
                    return true;
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void q(TbPageContext<?> tbPageContext, String str, String str2, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{tbPageContext, str, str2, Boolean.valueOf(z), bundle}) == null) {
            boolean isBaiduDomain = UrlUtils.isBaiduDomain(str);
            if (bundle != null && !bundle.getBoolean(BaseWebViewActivity.BUNDLE_NEED_EXTRA_PARAM, true)) {
                isBaiduDomain = false;
            }
            if (isBaiduDomain) {
                str = gt4.c(gt4.f(gt4.d(str)));
            }
            String l = l(str);
            if (z) {
                g95.f(tbPageContext, new d(tbPageContext, str2, l, bundle), new e(), l);
            } else {
                gt4.u(tbPageContext.getPageActivity(), str2, l, bundle);
            }
        }
    }

    public static void r(TbPageContext<?> tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{tbPageContext, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            q(tbPageContext, str, str2, z, null);
        }
    }

    public static void s(TbPageContext<?> tbPageContext, String str, String str2, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{tbPageContext, str, str2, Boolean.valueOf(z), bundle}) == null) {
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "url_1", null);
            q(tbPageContext, str, str2, z, bundle);
        }
    }
}
