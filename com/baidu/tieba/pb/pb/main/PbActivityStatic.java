package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FoldCommentActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.module.frs.FrsService;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.TbSocketMessageTask;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.fv5;
import com.baidu.tieba.h5a;
import com.baidu.tieba.hd5;
import com.baidu.tieba.jy9;
import com.baidu.tieba.kd5;
import com.baidu.tieba.ky9;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.q4b;
import com.baidu.tieba.r1a;
import com.baidu.tieba.rd;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.vq4;
import com.baidu.tieba.vva;
import com.baidu.tieba.wq4;
import com.baidu.tieba.xq4;
import com.baidu.tieba.xt5;
import com.baidu.tieba.y3a;
import com.baidu.tieba.z6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.PbPage.PbPageResIdl;
/* loaded from: classes7.dex */
public class PbActivityStatic {
    public static /* synthetic */ Interceptable $ic;
    public static BdAsyncTaskParallel a;
    public static long b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof DownloadMessage)) {
                return;
            }
            DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
            if (downloadMessage.getData() != null && downloadMessage.getData().size() > 0) {
                for (DownloadData downloadData : downloadMessage.getData()) {
                    if (downloadData != null) {
                        for (kd5 kd5Var : TiePlusHelper.w) {
                            if (!StringUtils.isNull(kd5Var.f) && kd5Var.f.equals(downloadData.getId())) {
                                int status = downloadData.getStatus();
                                if (status != 0) {
                                    if (status == 1) {
                                        kd5Var.e = false;
                                    }
                                } else if (!kd5Var.e) {
                                    kd5Var.e = true;
                                    TiePlusStat.f(kd5Var.a, kd5Var.b, kd5Var.c, kd5Var.d);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
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
            hd5 hd5Var;
            String a;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof hd5) || (a = (hd5Var = (hd5) customResponsedMessage.getData()).a()) == null) {
                return;
            }
            try {
                Uri parse = Uri.parse(a);
                String queryParameter = parse.getQueryParameter("pid");
                String queryParameter2 = parse.getQueryParameter("tid");
                String queryParameter3 = parse.getQueryParameter("threadtype");
                String queryParameter4 = parse.getQueryParameter("jump_type");
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                baijiahaoData.oriUgcNid = parse.getQueryParameter("ori_ugc_nid");
                baijiahaoData.oriUgcTid = parse.getQueryParameter("ori_ugc_tid");
                baijiahaoData.oriUgcType = JavaTypesHelper.toInt(parse.getQueryParameter(TiebaStatic.Params.UGC_TYPE), 0);
                baijiahaoData.oriUgcVid = parse.getQueryParameter("ori_ugc_vid");
                if (!StringUtils.isNull(queryParameter3)) {
                    int i = JavaTypesHelper.toInt(queryParameter3, 0);
                    if (hd5Var.b() != null) {
                        xt5.a(queryParameter2, queryParameter, queryParameter4, i, hd5Var.b(), baijiahaoData);
                    } else {
                        xt5.a(queryParameter2, queryParameter, queryParameter4, i, hd5Var.b(), baijiahaoData);
                    }
                } else {
                    if (StringUtils.isNull(queryParameter2)) {
                        queryParameter2 = "0";
                    }
                    if (hd5Var.b() != null) {
                        xt5.a(queryParameter2, queryParameter, queryParameter4, 0, hd5Var.b(), baijiahaoData);
                    } else {
                        xt5.a(queryParameter2, queryParameter, queryParameter4, 0, hd5Var.b(), baijiahaoData);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements UrlManager.UrlDealListener {
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext == null || strArr == null || strArr[0] == null || !strArr[0].contains("tieba.baidu.com") || !"/mo/q/wise-main-share/shareVoiceRoom".equals(PbActivityStatic.e(strArr[0]))) {
                    return 3;
                }
                Uri parse = Uri.parse(strArr[0]);
                HashMap hashMap = new HashMap();
                for (String str : parse.getQueryParameterNames()) {
                    hashMap.put(str, String.valueOf(parse.getQueryParameter(str)));
                }
                if (hashMap.containsKey("room_id")) {
                    String str2 = (String) hashMap.get("room_id");
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "0";
                    }
                    ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoom(tbPageContext, str2, hashMap);
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements xq4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        @Override // com.baidu.tieba.xq4
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = wq4.a(context);
                if (a != null) {
                    FloatingLayout.LayoutParams layoutParams = new FloatingLayout.LayoutParams(-2, -2);
                    ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
                    SkinManager.setViewTextColor(a, (int) R.color.CAM_X0302);
                    layoutParams.setMargins(BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f07041d), BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f070224), 0, 0);
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements xq4 {
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

        @Override // com.baidu.tieba.xq4
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = wq4.a(context);
                if (a != null) {
                    SkinManager.setViewTextColor(a, (int) R.color.CAM_X0302);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f07041d), BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f0701d4), 0, 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements xq4 {
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

        @Override // com.baidu.tieba.xq4
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = wq4.a(context);
                if (a != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    SkinManager.setViewTextColor(a, (int) R.color.CAM_X0302);
                    layoutParams.setMargins(BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f07041d), BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f0701d4), 0, 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements xq4 {
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

        @Override // com.baidu.tieba.xq4
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = wq4.a(context);
                if (a != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    SkinManager.setViewTextColor(a, (int) R.color.CAM_X0302);
                    layoutParams.setMargins(BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f07041d), BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f0701d4), 0, 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements CustomMessageTask.CustomRunnable<PbActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<PbActivityConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || System.currentTimeMillis() - PbActivityStatic.b < 1500) {
                    return null;
                }
                long unused = PbActivityStatic.b = System.currentTimeMillis();
                if ("1".equals(customMessage.getData().getIntent().getStringExtra("is_start_for_result"))) {
                    customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra("request_code", 0), PbActivity.class);
                } else {
                    customMessage.getData().startActivity(PbActivity.class);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                fv5.a(PbPageRequestMessage.WIRE, PbPageResIdl.class);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Pattern a;

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = Pattern.compile(UrlSchemaHelper.PB_URL);
        }

        public final boolean a(TbPageContext tbPageContext, String str, Uri uri) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, tbPageContext, str, uri)) == null) {
                String queryParameter = uri.getQueryParameter("force_jump");
                if (!rd.isEmpty(queryParameter) && !rd.isEmpty(str)) {
                    if (queryParameter.equals("frs")) {
                        String queryParameter2 = uri.getQueryParameter("fname");
                        if (!rd.isEmpty(queryParameter2)) {
                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(queryParameter2, null);
                            createNormalCfg.setPushTid(str);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                            return true;
                        }
                        return false;
                    } else if (queryParameter.equals("maintab")) {
                        MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(tbPageContext.getContext());
                        mainTabActivityConfig.setPushTid(str);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            boolean z;
            String matchStringFromURL;
            String str;
            String str2;
            String str3;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            String str4;
            String str5;
            boolean z8;
            boolean z9;
            boolean z10;
            boolean z11;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0) {
                    if (strArr[0] != null) {
                        if (strArr.length > 1 && !StringUtils.isNull(strArr[1]) && strArr[1].toLowerCase().contains("n/video/opersquare")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        String lowerCase = strArr[0].toLowerCase();
                        Matcher matcher = this.a.matcher(lowerCase);
                        String str6 = "push";
                        if (!Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find() && !lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_BAIJIAHAO_PB)) {
                            if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(PbModel.UNIDISPATCH_PB)) {
                                return y3a.d(tbPageContext, lowerCase);
                            }
                            if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_SUB_PB)) {
                                String paramStr = UrlManager.getParamStr(lowerCase);
                                if (!TextUtils.isEmpty(paramStr)) {
                                    Map<String, String> paramPair = UrlManager.getParamPair(paramStr);
                                    if (!paramPair.isEmpty()) {
                                        String str7 = paramPair.get("tid");
                                        String str8 = paramPair.get("pid");
                                        if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                                            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(tbPageContext.getPageActivity()).createSubPbActivityConfig(str7, str8, "", true);
                                            createSubPbActivityConfig.setIsFromeSchema(true);
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                                            return 0;
                                        }
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains("bookcover:")) {
                                return y3a.a(lowerCase, tbPageContext);
                            }
                            String str9 = "allthread";
                            if (matcher.find()) {
                                String group = matcher.group(1);
                                Uri parse = Uri.parse(lowerCase);
                                if (a(tbPageContext, group, parse)) {
                                    return 0;
                                }
                                String queryParameter = parse.getQueryParameter("pid");
                                boolean z12 = JavaTypesHelper.toBoolean(parse.getQueryParameter("is_video"), false);
                                boolean z13 = JavaTypesHelper.toBoolean(parse.getQueryParameter("is_official_video"), false);
                                String queryParameter2 = parse.getQueryParameter("broadcast_id");
                                if (lowerCase != null) {
                                    String[] split = lowerCase.split("&");
                                    for (int i = 0; i < split.length; i++) {
                                        if (split[i] != null) {
                                            if (split[i].startsWith("thread_type=")) {
                                                split[i].substring(12);
                                            } else if (split[i].startsWith("playstatkey=")) {
                                                str6 = split[i].substring(12);
                                            }
                                        }
                                    }
                                    z10 = JavaTypesHelper.toBoolean(WebviewHelper.getMatchStringFromURL(lowerCase, "is_from_push="), false);
                                } else {
                                    z10 = false;
                                }
                                if (lowerCase != null && lowerCase.contains("?")) {
                                    String[] split2 = lowerCase.substring(lowerCase.indexOf("?") + 1, lowerCase.length()).split("&");
                                    int length = split2.length;
                                    int i2 = 0;
                                    while (i2 < length) {
                                        String str10 = split2[i2];
                                        if (str10.startsWith("playstatkey=")) {
                                            z11 = z10;
                                            str6 = str10.substring(12);
                                            break;
                                        }
                                        i2++;
                                        z10 = z10;
                                    }
                                }
                                z11 = z10;
                                if (lowerCase != null) {
                                    String matchStringFromURL2 = WebviewHelper.getMatchStringFromURL(lowerCase, "sttype=");
                                    if (!StringUtils.isNull(matchStringFromURL2)) {
                                        str9 = matchStringFromURL2;
                                    }
                                }
                                matchStringFromURL = group;
                                str = queryParameter;
                                z3 = z12;
                                z4 = z13;
                                z5 = z11;
                                z2 = true;
                                z6 = true;
                                z7 = false;
                                str3 = queryParameter2;
                                str2 = str9;
                            } else {
                                if (lowerCase != null && (lowerCase.startsWith(TbConfig.HTTP_PREFIX) || lowerCase.startsWith(TbConfig.HTTPS_PREFIX))) {
                                    if (lowerCase.startsWith(TbConfig.HTTP_PREFIX)) {
                                        str4 = lowerCase.substring(TbConfig.HTTP_PREFIX.length());
                                    } else if (lowerCase.startsWith(TbConfig.HTTPS_PREFIX)) {
                                        str4 = lowerCase.substring(TbConfig.HTTPS_PREFIX.length());
                                    } else {
                                        str4 = null;
                                    }
                                    if (str4 != null) {
                                        String[] split3 = str4.split("&");
                                        int i3 = 0;
                                        while (true) {
                                            if (i3 < split3.length) {
                                                if (split3[i3] != null && split3[i3].startsWith("kz=")) {
                                                    str5 = split3[i3].substring(3);
                                                    z9 = true;
                                                    break;
                                                }
                                                i3++;
                                            } else {
                                                str5 = null;
                                                z9 = false;
                                                break;
                                            }
                                        }
                                        if (!TextUtils.isEmpty(str5) && str5.contains("&")) {
                                            str5 = str5.split("&")[0];
                                        }
                                        if (!TextUtils.isEmpty(str5)) {
                                            z8 = z9;
                                        } else {
                                            z8 = z9;
                                            str5 = null;
                                        }
                                    } else {
                                        str5 = null;
                                        z8 = false;
                                    }
                                    matchStringFromURL = str5;
                                    z2 = z8;
                                    str = "";
                                    str2 = "allthread";
                                    str3 = null;
                                } else if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    String substring = lowerCase.substring(3);
                                    if (strArr.length > 1) {
                                        matchStringFromURL = substring;
                                        str2 = strArr[1];
                                        str = "";
                                        str3 = null;
                                    } else {
                                        matchStringFromURL = substring;
                                        str = "";
                                        str2 = null;
                                        str3 = null;
                                    }
                                    z2 = true;
                                } else if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                                    matchStringFromURL = lowerCase.substring(22);
                                    str = "";
                                    str2 = null;
                                    str3 = null;
                                    z2 = false;
                                    z3 = false;
                                    z4 = false;
                                    z5 = false;
                                    z6 = true;
                                    z7 = true;
                                } else if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && lowerCase.contains("kz=")) {
                                    matchStringFromURL = WebviewHelper.getMatchStringFromURL(lowerCase, "kz=");
                                    str = "";
                                    str2 = null;
                                    str3 = null;
                                    z2 = false;
                                } else {
                                    return 3;
                                }
                                z3 = false;
                                z4 = false;
                                z5 = false;
                                z6 = true;
                                z7 = false;
                            }
                            if (!StringUtils.isNull(matchStringFromURL, z6) && tbPageContext != null) {
                                return y3a.b(z3, z4, matchStringFromURL, tbPageContext, lowerCase, str, str2, str6, z5, str3, "from=threadcard2", z);
                            }
                            if (z7 && !TextUtils.isEmpty(matchStringFromURL)) {
                                return y3a.c(lowerCase, matchStringFromURL);
                            }
                            if (z2) {
                                tbPageContext.showToast((int) R.string.page_not_found);
                                return 1;
                            }
                            return 3;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001609, new hd5(tbPageContext, lowerCase)));
                        return 0;
                    }
                    return 3;
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<q4b> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof Context)) {
                    return new CustomResponsedMessage<>(2921343, new h5a(customMessage.getData()));
                }
                return null;
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
        a = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        b = -1L;
        d();
        o();
        m();
        h();
        j();
        g();
        f();
        i();
        p();
        q();
        n();
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new h());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        DefaultLog.getInstance().d("PbActivityStatic", "registerTask START_PB_ACTIVITY begin");
        MessageManager.getInstance().registerTask(customMessageTask);
        DefaultLog.getInstance().d("PbActivityStatic", "registerTask START_PB_ACTIVITY end");
        k();
        l();
        i iVar = new i();
        iVar.setSelfExecute(true);
        iVar.setPriority(4);
        iVar.execute(new Void[0]);
        ItemCardHelper.t();
        ItemCardHelper.s();
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

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(FoldCommentActivityConfig.class, FoldCommentActivity.class);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(ForbidActivityConfig.class, ForbidActivity.class);
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(PbCommentFloatActivityConfig.class, PbCommentFloatActivity.class);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(PbFullScreenEditorActivityConfig.class, PbFullScreenEditorActivity.class);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            UrlManager.getInstance().addListener(new j());
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            vva.b(2004003, r1a.class);
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            MessageManager.getInstance().registerListener(new b(2001609));
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            MessageManager.getInstance().registerListener(new a(2001118));
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921343, new k());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            UrlManager.getInstance().addListener(new c());
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            vq4.b().c(2, new d());
            vq4.b().c(3, new e());
            vq4.b().c(4, new f());
            vq4.b().c(6, new g());
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
            TbSocketMessageTask h2 = vva.h(302002, SubPbSocketResponseMessage.class, false, false);
            TbHttpMessageTask c2 = vva.c(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
            h2.setParallel(a);
            c2.setParallel(a);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_APPLY_COPY_THREAD, TbConfig.SERVER_ADDRESS + TbConfig.URL_APPLY_COPY_THREAD);
            tbHttpMessageTask.setResponsedClass(ApplyCopyThreadResponseMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_FLOOR_AGREE, TbConfig.SERVER_ADDRESS + TbConfig.PB_FLOOR_AGREE_URL);
            tbHttpMessageTask.setResponsedClass(PbFloorAgreeResponseMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                String path = Uri.parse(str).getPath();
                if (!TextUtils.isEmpty(path) && path.endsWith("/")) {
                    return path.substring(0, path.length() - 1);
                }
                return path;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            vva.h(302001, pbPageSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, vva.a("c/f/pb/page", 302001));
            ky9.g = tbHttpMessageTask;
            jy9.i = tbHttpMessageTask;
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setTimeOut(z6.d().b());
            tbHttpMessageTask.setRetry(z6.d().a());
            tbHttpMessageTask.setConnectTimeOut(z6.d().c());
            tbHttpMessageTask.setPriority(4);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsNeedCookie(UbsABTestHelper.isAddBaidIdCookie());
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            LocationModel.U();
            r();
            s();
        }
    }
}
