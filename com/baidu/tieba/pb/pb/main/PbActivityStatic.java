package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.a.w;
import c.a.q0.d1.u0;
import c.a.q0.d1.v0;
import c.a.r0.j2.k.e.m0;
import c.a.r0.j2.k.e.o;
import c.a.r0.j2.k.e.q0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.PbPage.PbPageResIdl;
/* loaded from: classes7.dex */
public class PbActivityStatic {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static BdAsyncTaskParallel f54948a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements c.a.q0.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.e.e
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a2 = c.a.q0.e.d.a(context);
                if (a2 != null) {
                    FloatingLayout.LayoutParams layoutParams = new FloatingLayout.LayoutParams(-2, -2);
                    ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
                    SkinManager.setViewTextColor(a2, R.color.CAM_X0302);
                    layoutParams.setMargins(l.g(context, R.dimen.ds8), l.g(context, R.dimen.ds4), 0, 0);
                    a2.setLayoutParams(layoutParams);
                }
                return a2;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements c.a.q0.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.e.e
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a2 = c.a.q0.e.d.a(context);
                if (a2 != null) {
                    SkinManager.setViewTextColor(a2, R.color.CAM_X0302);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(l.g(context, R.dimen.ds8), l.g(context, R.dimen.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    a2.setLayoutParams(layoutParams);
                }
                return a2;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements c.a.q0.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.e.e
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a2 = c.a.q0.e.d.a(context);
                if (a2 != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    SkinManager.setViewTextColor(a2, R.color.CAM_X0302);
                    layoutParams.setMargins(l.g(context, R.dimen.ds8), l.g(context, R.dimen.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    a2.setLayoutParams(layoutParams);
                }
                return a2;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements c.a.q0.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.e.e
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a2 = c.a.q0.e.d.a(context);
                if (a2 != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    SkinManager.setViewTextColor(a2, R.color.CAM_X0302);
                    layoutParams.setMargins(l.g(context, R.dimen.ds8), l.g(context, R.dimen.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    a2.setLayoutParams(layoutParams);
                }
                return a2;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements CustomMessageTask.CustomRunnable<PbActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<PbActivityConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    if ("1".equals(customMessage.getData().getIntent().getStringExtra("is_start_for_result"))) {
                        customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra("request_code", 0), PbActivity.class);
                    } else {
                        customMessage.getData().startActivity(PbActivity.class);
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                v0.a(PbPageRequestMessage.WIRE, PbPageResIdl.class);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Pattern f54949a;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54949a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
        }

        /* JADX WARN: Removed duplicated region for block: B:198:0x039e  */
        /* JADX WARN: Removed duplicated region for block: B:200:0x03a4 A[RETURN] */
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            String c2;
            boolean z;
            boolean z2;
            boolean z3;
            String str;
            boolean z4;
            String substring;
            boolean z5;
            PbActivityConfig createNormalCfg;
            int i2;
            boolean z6;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) != null) {
                return invokeLL.intValue;
            }
            if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                return 3;
            }
            boolean z7 = strArr.length > 1 && !StringUtils.isNull(strArr[1]) && strArr[1].toLowerCase().contains("n/video/opersquare");
            String lowerCase = strArr[0].toLowerCase();
            Matcher matcher = this.f54949a.matcher(lowerCase);
            String str3 = "push";
            if (!Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find() && !lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_BAIJIAHAO_PB)) {
                if (lowerCase.contains("unidispatch/pb")) {
                    Uri parse = Uri.parse(lowerCase);
                    if (parse != null) {
                        String queryParameter = parse.getQueryParameter(c.a.q0.a.g.U);
                        if (!StringUtils.isNull(queryParameter)) {
                            TbSingleton.getInstance().setFromWhichSearchSource(queryParameter);
                        }
                    }
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(tbPageContext.getPageActivity());
                    pbActivityConfig.setUri(Uri.parse(lowerCase));
                    if (lowerCase != null && lowerCase.contains(UrlSchemaHelper.FROM_YUN_PUSH)) {
                        pbActivityConfig.setStartFrom(7);
                    }
                    tbPageContext.sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    return 0;
                }
                String str4 = "";
                if (lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_SUB_PB)) {
                    String paramStr = UrlManager.getParamStr(lowerCase);
                    if (!TextUtils.isEmpty(paramStr)) {
                        Map<String, String> paramPair = UrlManager.getParamPair(paramStr);
                        if (!paramPair.isEmpty()) {
                            String str5 = paramPair.get("tid");
                            String str6 = paramPair.get("pid");
                            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(tbPageContext.getPageActivity()).createSubPbActivityConfig(str5, str6, "", true);
                                createSubPbActivityConfig.setIsFromeSchema(true);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                                return 0;
                            }
                        }
                    }
                }
                if (lowerCase.contains("bookcover:")) {
                    Map<String, String> paramPair2 = UrlManager.getParamPair(lowerCase.substring(10));
                    if (paramPair2 == null || paramPair2.size() <= 0) {
                        return 0;
                    }
                    if (c.a.e.e.m.b.e(paramPair2.get("book_type"), 1) == 3) {
                        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                            return 3;
                        }
                        l.L(tbPageContext.getPageActivity(), R.string.manga_plugin_not_install_tip);
                        return 0;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        return 3;
                    } else {
                        l.L(tbPageContext.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return 0;
                    }
                }
                String str7 = "allthread";
                if (matcher.find()) {
                    String group = matcher.group(1);
                    Uri parse2 = Uri.parse(lowerCase);
                    str4 = parse2.getQueryParameter("pid");
                    str = parse2.getQueryParameter("broadcast_id");
                    if (lowerCase != null) {
                        String[] split = lowerCase.split("&");
                        for (int i3 = 0; i3 < split.length; i3++) {
                            if (split[i3] != null) {
                                if (split[i3].startsWith("thread_type=")) {
                                    split[i3].substring(12);
                                } else if (split[i3].startsWith("playstatkey=")) {
                                    str3 = split[i3].substring(12);
                                }
                            }
                        }
                        z6 = c.a.e.e.m.b.b(u0.c(lowerCase, "is_from_push="), false);
                    } else {
                        z6 = false;
                    }
                    if (lowerCase != null && lowerCase.contains("?")) {
                        String[] split2 = lowerCase.substring(lowerCase.indexOf("?") + 1, lowerCase.length()).split("&");
                        int length = split2.length;
                        int i4 = 0;
                        while (i4 < length) {
                            String str8 = split2[i4];
                            if (str8.startsWith("playstatkey=")) {
                                str2 = group;
                                str3 = str8.substring(12);
                                break;
                            }
                            i4++;
                            group = group;
                        }
                    }
                    str2 = group;
                    if (lowerCase != null) {
                        String c3 = u0.c(lowerCase, "sttype=");
                        if (!StringUtils.isNull(c3)) {
                            str7 = c3;
                        }
                    }
                    z3 = z6;
                    c2 = str2;
                    z = false;
                    z2 = true;
                } else {
                    if (lowerCase != null && (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?"))) {
                        if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                            substring = lowerCase.substring(25);
                        } else {
                            substring = lowerCase.startsWith("http://tieba.baidu.com/f?") ? lowerCase.substring(25) : null;
                        }
                        if (substring != null) {
                            String[] split3 = substring.split("&");
                            int i5 = 0;
                            while (true) {
                                if (i5 >= split3.length) {
                                    c2 = null;
                                    z5 = false;
                                    break;
                                } else if (split3[i5] != null && split3[i5].startsWith("kz=")) {
                                    c2 = split3[i5].substring(3);
                                    z5 = true;
                                    break;
                                } else {
                                    i5++;
                                }
                            }
                            if (!TextUtils.isEmpty(c2) && c2.contains("&")) {
                                c2 = c2.split("&")[0];
                            }
                            if (TextUtils.isEmpty(c2)) {
                                c2 = null;
                            }
                        } else {
                            c2 = null;
                            z5 = false;
                        }
                        z2 = z5;
                        z = false;
                    } else {
                        if (lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            String substring2 = lowerCase.substring(3);
                            if (strArr.length > 1) {
                                str7 = strArr[1];
                                c2 = substring2;
                                z = false;
                                z2 = true;
                            } else {
                                c2 = substring2;
                                z = false;
                                z2 = true;
                            }
                        } else {
                            if (lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                                c2 = lowerCase.substring(22);
                                z = true;
                            } else if (!lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) || !lowerCase.contains("kz=")) {
                                return 3;
                            } else {
                                c2 = u0.c(lowerCase, "kz=");
                                z = false;
                            }
                            z2 = false;
                        }
                        z3 = false;
                        str = null;
                        z4 = true;
                        str7 = null;
                        if (StringUtils.isNull(c2, z4) && tbPageContext != null) {
                            if (StringUtils.isNull(str4)) {
                                createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(c2, null, str7);
                            } else {
                                createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(c2, str4, str7);
                            }
                            if (lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(u0.c(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                                createNormalCfg.setUserName(u0.c(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
                            }
                            createNormalCfg.setVideo_source(str3);
                            if (z3) {
                                createNormalCfg.setFromPushNotify();
                                i2 = 7;
                                createNormalCfg.setStartFrom(7);
                            } else {
                                i2 = 7;
                            }
                            if (lowerCase != null && lowerCase.contains(UrlSchemaHelper.FROM_YUN_PUSH)) {
                                createNormalCfg.setStartFrom(i2);
                            }
                            if (!StringUtils.isNull(str)) {
                                createNormalCfg.setOfficialBarMessageId(str);
                            }
                            if (lowerCase != null && lowerCase.contains("fr=collect")) {
                                createNormalCfg.setJumpToCommentArea(true);
                            }
                            tbPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            return (lowerCase.contains("from=threadcard2") || z7) ? 0 : 0;
                        } else if (!z && !TextUtils.isEmpty(c2)) {
                            c.a.e.e.m.f.c(TbadkCoreApplication.getInst(), q0.f(TbadkCoreApplication.getInst(), c2));
                            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", 3).param("obj_type", 2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
                            w.a(param, lowerCase);
                            TiebaStatic.log(param);
                            return 1;
                        } else {
                            if (z2) {
                                return 3;
                            }
                            tbPageContext.showToast(R.string.page_not_found);
                            return 1;
                        }
                    }
                    z3 = false;
                    str = null;
                }
                z4 = true;
                if (StringUtils.isNull(c2, z4)) {
                }
                if (!z) {
                }
                if (z2) {
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001609, new c.a.q0.u.h(tbPageContext, lowerCase)));
                return 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<c.a.r0.r3.a> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921343, new c.a.r0.j2.k.f.a(customMessage.getData()));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1084828188, "Lcom/baidu/tieba/pb/pb/main/PbActivityStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1084828188, "Lcom/baidu/tieba/pb/pb/main/PbActivityStatic;");
                return;
            }
        }
        f54948a = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        a();
        j();
        i();
        d();
        f();
        c();
        b();
        e();
        k();
        SwitchManager.getInstance().registerSwitch(o.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new e());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        g();
        h();
        f fVar = new f();
        fVar.setSelfExecute(true);
        fVar.setPriority(4);
        fVar.execute(new Void[0]);
        ItemCardHelper.t();
        ItemCardHelper.s();
        c.a.q0.i0.b.a(c.a.q0.i0.c.b.f13494a, new m0());
    }

    public PbActivityStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            c.a.q0.e.c.b().c(2, new a());
            c.a.q0.e.c.b().c(3, new b());
            c.a.q0.e.c.b().c(4, new c());
            c.a.q0.e.c.b().c(6, new d());
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(PbSearchEmotionActivityConfig.class, PbSearchEmotionActivity.class);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(ForbidActivityConfig.class, ForbidActivity.class);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(PbCommentFloatActivityConfig.class, PbCommentFloatActivity.class);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(PbFullScreenEditorActivityConfig.class, PbFullScreenEditorActivity.class);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
            c.a.q0.z0.b h2 = c.a.r0.j3.d0.a.h(302002, SubPbSocketResponseMessage.class, false, false);
            TbHttpMessageTask c2 = c.a.r0.j3.d0.a.c(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
            h2.setParallel(f54948a);
            c2.setParallel(f54948a);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            UrlManager.getInstance().addListener(new g());
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_APPLY_COPY_THREAD, TbConfig.SERVER_ADDRESS + TbConfig.URL_APPLY_COPY_THREAD);
            tbHttpMessageTask.setResponsedClass(ApplyCopyThreadResponseMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c.a.r0.j3.d0.a.b(2004003, c.a.r0.j2.k.e.v0.class);
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            c.a.r0.j3.d0.a.h(302001, pbPageSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, c.a.r0.j3.d0.a.a("c/f/pb/page", 302001));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            LocationModel.G();
            l();
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_FLOOR_AGREE, TbConfig.SERVER_ADDRESS + TbConfig.PB_FLOOR_AGREE_URL);
            tbHttpMessageTask.setResponsedClass(PbFloorAgreeResponseMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921343, new h());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }
}
