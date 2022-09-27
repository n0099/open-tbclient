package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.FoldCommentActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.aa5;
import com.baidu.tieba.bo4;
import com.baidu.tieba.by7;
import com.baidu.tieba.co4;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.do4;
import com.baidu.tieba.ej;
import com.baidu.tieba.ez7;
import com.baidu.tieba.hh;
import com.baidu.tieba.km4;
import com.baidu.tieba.lz7;
import com.baidu.tieba.me5;
import com.baidu.tieba.nh5;
import com.baidu.tieba.o45;
import com.baidu.tieba.p18;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.r45;
import com.baidu.tieba.rz7;
import com.baidu.tieba.si5;
import com.baidu.tieba.sm8;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.ti5;
import com.baidu.tieba.u95;
import com.baidu.tieba.uw7;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.vw7;
import com.baidu.tieba.w95;
import com.baidu.tieba.xt8;
import com.baidu.tieba.yb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.PbPage.PbPageResIdl;
/* loaded from: classes5.dex */
public class PbActivityStatic {
    public static /* synthetic */ Interceptable $ic;
    public static BdAsyncTaskParallel a;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage)) {
                DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
                if (downloadMessage.getData() == null || downloadMessage.getData().size() <= 0) {
                    return;
                }
                for (DownloadData downloadData : downloadMessage.getData()) {
                    if (downloadData != null) {
                        for (r45 r45Var : TiePlusHelper.t) {
                            if (!StringUtils.isNull(r45Var.f) && r45Var.f.equals(downloadData.getId())) {
                                int status = downloadData.getStatus();
                                if (status != 0) {
                                    if (status == 1) {
                                        r45Var.e = false;
                                    }
                                } else if (!r45Var.e) {
                                    r45Var.e = true;
                                    TiePlusStat.e(r45Var.a, r45Var.b, r45Var.c, r45Var.d);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends CustomMessageListener {
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
            o45 o45Var;
            String a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof o45) || (a = (o45Var = (o45) customResponsedMessage.getData()).a()) == null) {
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
                baijiahaoData.oriUgcType = dh.e(parse.getQueryParameter(TiebaStatic.Params.UGC_TYPE), 0);
                baijiahaoData.oriUgcVid = parse.getQueryParameter("ori_ugc_vid");
                if (!StringUtils.isNull(queryParameter3)) {
                    int e = dh.e(queryParameter3, 0);
                    if (o45Var.b() != null) {
                        nh5.a(queryParameter2, queryParameter, queryParameter4, e, o45Var.b(), baijiahaoData);
                    } else {
                        nh5.a(queryParameter2, queryParameter, queryParameter4, e, o45Var.b(), baijiahaoData);
                    }
                } else {
                    if (StringUtils.isNull(queryParameter2)) {
                        queryParameter2 = "0";
                    }
                    if (o45Var.b() != null) {
                        nh5.a(queryParameter2, queryParameter, queryParameter4, 0, o45Var.b(), baijiahaoData);
                    } else {
                        nh5.a(queryParameter2, queryParameter, queryParameter4, 0, o45Var.b(), baijiahaoData);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext == null || strArr == null || strArr[0] == null || !strArr[0].contains("tieba.baidu.com") || !"/mo/q/wise-main-share/shareVoiceRoom".equals(PbActivityStatic.c(strArr[0]))) {
                    return 3;
                }
                Uri parse = Uri.parse(strArr[0]);
                HashMap hashMap = new HashMap();
                for (String str : parse.getQueryParameterNames()) {
                    hashMap.put(str, String.valueOf(parse.getQueryParameter(str)));
                }
                if (hashMap.containsKey("room_id")) {
                    ((w95) ServiceManager.getService(w95.a.a())).a(tbPageContext, dh.g((String) hashMap.get("room_id"), 0L));
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements do4 {
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

        @Override // com.baidu.tieba.do4
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = co4.a(context);
                if (a != null) {
                    FloatingLayout.LayoutParams layoutParams = new FloatingLayout.LayoutParams(-2, -2);
                    ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
                    SkinManager.setViewTextColor(a, (int) R.color.CAM_X0302);
                    layoutParams.setMargins(ej.f(context, R.dimen.obfuscated_res_0x7f070302), ej.f(context, R.dimen.obfuscated_res_0x7f070224), 0, 0);
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements do4 {
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

        @Override // com.baidu.tieba.do4
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = co4.a(context);
                if (a != null) {
                    SkinManager.setViewTextColor(a, (int) R.color.CAM_X0302);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(ej.f(context, R.dimen.obfuscated_res_0x7f070302), ej.f(context, R.dimen.obfuscated_res_0x7f0701d4), 0, 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements do4 {
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

        @Override // com.baidu.tieba.do4
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = co4.a(context);
                if (a != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    SkinManager.setViewTextColor(a, (int) R.color.CAM_X0302);
                    layoutParams.setMargins(ej.f(context, R.dimen.obfuscated_res_0x7f070302), ej.f(context, R.dimen.obfuscated_res_0x7f0701d4), 0, 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements do4 {
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

        @Override // com.baidu.tieba.do4
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = co4.a(context);
                if (a != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    SkinManager.setViewTextColor(a, (int) R.color.CAM_X0302);
                    layoutParams.setMargins(ej.f(context, R.dimen.obfuscated_res_0x7f070302), ej.f(context, R.dimen.obfuscated_res_0x7f0701d4), 0, 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements CustomMessageTask.CustomRunnable<PbActivityConfig> {
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

    /* loaded from: classes5.dex */
    public static class i extends BdAsyncTask<Void, Void, Void> {
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
                ti5.a(PbPageRequestMessage.WIRE, PbPageResIdl.class);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements UrlManager.UrlDealListener {
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
                if (dj.isEmpty(queryParameter) || dj.isEmpty(str)) {
                    return false;
                }
                if (queryParameter.equals("frs")) {
                    String queryParameter2 = uri.getQueryParameter("fname");
                    if (dj.isEmpty(queryParameter2)) {
                        return false;
                    }
                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(queryParameter2, null);
                    createNormalCfg.setPushTid(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                    return true;
                } else if (queryParameter.equals("maintab")) {
                    MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(tbPageContext.getContext());
                    mainTabActivityConfig.setPushTid(str);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
                    return true;
                } else {
                    return false;
                }
            }
            return invokeLLL.booleanValue;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:76:0x012a  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x013a  */
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            String c;
            String str;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            String substring;
            String str2;
            boolean z7;
            VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig;
            PbActivityConfig createNormalCfg;
            int i;
            String str3;
            String str4;
            boolean z8;
            String str5;
            char c2;
            char c3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, strArr)) == null) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                boolean z9 = strArr.length > 1 && !StringUtils.isNull(strArr[1]) && strArr[1].toLowerCase().contains("n/video/opersquare");
                String lowerCase = strArr[0].toLowerCase();
                Matcher matcher = this.a.matcher(lowerCase);
                String str6 = "push";
                if (!Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find() && !lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_BAIJIAHAO_PB)) {
                    if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(PbModel.UNIDISPATCH_PB)) {
                        Uri parse = Uri.parse(lowerCase);
                        if (parse != null) {
                            String queryParameter = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_SOURCE);
                            if (!StringUtils.isNull(queryParameter)) {
                                TbSingleton.getInstance().setFromWhichSearchSource(queryParameter);
                            }
                        }
                        if (parse != null) {
                            String queryParameter2 = parse.getQueryParameter("obj_param1");
                            if (!BdUniDispatchSchemeController.PARAM_VIDEO.equals(queryParameter2) && !"2".equals(queryParameter2)) {
                                PbActivityConfig pbActivityConfig = new PbActivityConfig(tbPageContext.getPageActivity());
                                pbActivityConfig.setUri(Uri.parse(lowerCase));
                                String queryParameter3 = parse.getQueryParameter("comment_sort_type");
                                String queryParameter4 = parse.getQueryParameter("is_anchor_to_comment");
                                String queryParameter5 = parse.getQueryParameter("hightlight_anchor_pid");
                                if (!TextUtils.isEmpty(queryParameter3)) {
                                    switch (queryParameter3.hashCode()) {
                                        case 48:
                                            if (queryParameter3.equals("0")) {
                                                c3 = 0;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        case 49:
                                            if (queryParameter3.equals("1")) {
                                                c3 = 1;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        case 50:
                                            if (queryParameter3.equals("2")) {
                                                c3 = 2;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        default:
                                            c3 = 65535;
                                            break;
                                    }
                                    if (c3 == 0) {
                                        pbActivityConfig.setSortType(0);
                                    } else if (c3 == 1) {
                                        pbActivityConfig.setSortType(1);
                                    } else if (c3 == 2) {
                                        pbActivityConfig.setSortType(2);
                                    }
                                }
                                if (!TextUtils.isEmpty(queryParameter4)) {
                                    int hashCode = queryParameter4.hashCode();
                                    if (hashCode != 48) {
                                        if (hashCode == 49 && queryParameter4.equals("1")) {
                                            c2 = 1;
                                            if (c2 != 0) {
                                                pbActivityConfig.setJumpToCommentArea(false);
                                            } else if (c2 == 1) {
                                                pbActivityConfig.setJumpToCommentArea(true);
                                            }
                                            if (!TextUtils.isEmpty(queryParameter5)) {
                                                pbActivityConfig.setHighLightPostId(queryParameter5);
                                            }
                                        }
                                        c2 = 65535;
                                        if (c2 != 0) {
                                        }
                                        if (!TextUtils.isEmpty(queryParameter5)) {
                                        }
                                    } else {
                                        if (queryParameter4.equals("0")) {
                                            c2 = 0;
                                            if (c2 != 0) {
                                            }
                                            if (!TextUtils.isEmpty(queryParameter5)) {
                                            }
                                        }
                                        c2 = 65535;
                                        if (c2 != 0) {
                                        }
                                        if (!TextUtils.isEmpty(queryParameter5)) {
                                        }
                                    }
                                }
                                if (lowerCase != null && lowerCase.contains(UrlSchemaHelper.FROM_YUN_PUSH)) {
                                    pbActivityConfig.setStartFrom(7);
                                }
                                tbPageContext.sendMessage(new CustomMessage(2004001, pbActivityConfig));
                            } else {
                                String queryParameter6 = parse.getQueryParameter("tid");
                                ArrayList arrayList = new ArrayList();
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.thread_id = queryParameter6;
                                arrayList.add(videoItemData);
                                VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig2 = new VideoRecommentPlayActivityConfig(tbPageContext.getPageActivity(), arrayList, null, VideoRecommentPlayActivityConfig.FROM_PB_VIDEO_SCHEME);
                                videoRecommentPlayActivityConfig2.setParamIsVertail(true);
                                videoRecommentPlayActivityConfig2.setUri(parse);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig2));
                            }
                        }
                        return 0;
                    }
                    String str7 = "";
                    if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_SUB_PB)) {
                        String paramStr = UrlManager.getParamStr(lowerCase);
                        if (!TextUtils.isEmpty(paramStr)) {
                            Map<String, String> paramPair = UrlManager.getParamPair(paramStr);
                            if (!paramPair.isEmpty()) {
                                String str8 = paramPair.get("tid");
                                String str9 = paramPair.get("pid");
                                if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(str9)) {
                                    SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(tbPageContext.getPageActivity()).createSubPbActivityConfig(str8, str9, "", true);
                                    createSubPbActivityConfig.setIsFromeSchema(true);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                                    return 0;
                                }
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains("bookcover:")) {
                        Map<String, String> paramPair2 = UrlManager.getParamPair(lowerCase.substring(10));
                        if (paramPair2 == null || paramPair2.size() <= 0) {
                            return 0;
                        }
                        if (dh.e(paramPair2.get("book_type"), 1) == 3) {
                            if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                                return 3;
                            }
                            ej.M(tbPageContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0aa2);
                            return 0;
                        } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            return 3;
                        } else {
                            ej.M(tbPageContext.getPageActivity(), R.string.obfuscated_res_0x7f0f032d);
                            return 0;
                        }
                    }
                    String str10 = "allthread";
                    if (matcher.find()) {
                        String group = matcher.group(1);
                        Uri parse2 = Uri.parse(lowerCase);
                        if (a(tbPageContext, group, parse2)) {
                            return 0;
                        }
                        String queryParameter7 = parse2.getQueryParameter("pid");
                        z4 = dh.b(parse2.getQueryParameter("is_video"), false);
                        z5 = dh.b(parse2.getQueryParameter("is_official_video"), false);
                        String queryParameter8 = parse2.getQueryParameter("broadcast_id");
                        if (lowerCase != null) {
                            String[] split = lowerCase.split("&");
                            str3 = group;
                            int i2 = 0;
                            while (i2 < split.length) {
                                if (split[i2] != null) {
                                    str5 = queryParameter8;
                                    if (split[i2].startsWith("thread_type=")) {
                                        split[i2].substring(12);
                                    } else if (split[i2].startsWith("playstatkey=")) {
                                        str6 = split[i2].substring(12);
                                    }
                                } else {
                                    str5 = queryParameter8;
                                }
                                i2++;
                                queryParameter8 = str5;
                            }
                            str4 = queryParameter8;
                            z8 = dh.b(si5.c(lowerCase, "is_from_push="), false);
                        } else {
                            str3 = group;
                            str4 = queryParameter8;
                            z8 = false;
                        }
                        if (lowerCase != null && lowerCase.contains("?")) {
                            String[] split2 = lowerCase.substring(lowerCase.indexOf("?") + 1, lowerCase.length()).split("&");
                            int length = split2.length;
                            int i3 = 0;
                            while (i3 < length) {
                                String str11 = split2[i3];
                                if (str11.startsWith("playstatkey=")) {
                                    z6 = z8;
                                    str6 = str11.substring(12);
                                    break;
                                }
                                i3++;
                                z8 = z8;
                            }
                        }
                        z6 = z8;
                        if (lowerCase != null) {
                            String c4 = si5.c(lowerCase, "sttype=");
                            if (!StringUtils.isNull(c4)) {
                                str10 = c4;
                            }
                        }
                        str7 = queryParameter7;
                        c = str3;
                        str = str4;
                        z = false;
                        z2 = true;
                        z3 = true;
                    } else if (lowerCase != null && (lowerCase.startsWith(TbConfig.HTTP_PREFIX) || lowerCase.startsWith(TbConfig.HTTPS_PREFIX))) {
                        if (lowerCase.startsWith(TbConfig.HTTP_PREFIX)) {
                            substring = lowerCase.substring(TbConfig.HTTP_PREFIX.length());
                        } else {
                            substring = lowerCase.startsWith(TbConfig.HTTPS_PREFIX) ? lowerCase.substring(TbConfig.HTTPS_PREFIX.length()) : null;
                        }
                        if (substring != null) {
                            String[] split3 = substring.split("&");
                            int i4 = 0;
                            while (true) {
                                if (i4 >= split3.length) {
                                    str2 = null;
                                    z7 = false;
                                    break;
                                } else if (split3[i4] != null && split3[i4].startsWith("kz=")) {
                                    str2 = split3[i4].substring(3);
                                    z7 = true;
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            if (!TextUtils.isEmpty(str2) && str2.contains("&")) {
                                str2 = str2.split("&")[0];
                            }
                            if (TextUtils.isEmpty(str2)) {
                                str2 = null;
                            }
                        } else {
                            str2 = null;
                            z7 = false;
                        }
                        z2 = z7;
                        z = false;
                        z3 = true;
                        z4 = false;
                        z5 = false;
                        z6 = false;
                        c = str2;
                        str = null;
                    } else {
                        if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                            String substring2 = lowerCase.substring(3);
                            if (strArr.length > 1) {
                                str10 = strArr[1];
                                c = substring2;
                                str = null;
                                z = false;
                                z2 = true;
                                z3 = true;
                                z4 = false;
                                z5 = false;
                                z6 = false;
                            } else {
                                c = substring2;
                                str = null;
                                z = false;
                                z2 = true;
                            }
                        } else {
                            if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                                c = lowerCase.substring(22);
                                str = null;
                                z = true;
                            } else if (TextUtils.isEmpty(lowerCase) || !lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) || !lowerCase.contains("kz=")) {
                                return 3;
                            } else {
                                c = si5.c(lowerCase, "kz=");
                                str = null;
                                z = false;
                            }
                            z2 = false;
                        }
                        z3 = true;
                        z4 = false;
                        str10 = null;
                        z5 = false;
                        z6 = false;
                    }
                    if (StringUtils.isNull(c, z3) || tbPageContext == null) {
                        if (!z || TextUtils.isEmpty(c)) {
                            if (z2) {
                                tbPageContext.showToast((int) R.string.obfuscated_res_0x7f0f0d4f);
                                return 1;
                            }
                            return 3;
                        }
                        hh.startService(TbadkCoreApplication.getInst(), lz7.f(TbadkCoreApplication.getInst(), c));
                        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", 3).param("obj_type", 2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
                        km4.a(param, lowerCase);
                        TiebaStatic.log(param);
                        return 1;
                    } else if (!z4 && !z5) {
                        if (StringUtils.isNull(str7)) {
                            createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(c, null, str10);
                        } else {
                            createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(c, str7, str10);
                        }
                        if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(si5.c(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                            createNormalCfg.setUserName(si5.c(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
                        }
                        createNormalCfg.setVideo_source(str6);
                        createNormalCfg.setStartFrom(25);
                        if (z6) {
                            createNormalCfg.setFromPushNotify();
                            i = 7;
                            createNormalCfg.setStartFrom(7);
                        } else {
                            i = 7;
                        }
                        if (lowerCase != null && lowerCase.contains(UrlSchemaHelper.FROM_YUN_PUSH)) {
                            createNormalCfg.setStartFrom(i);
                        }
                        if (lowerCase != null && (lowerCase.contains(UrlSchemaHelper.FROM_YUN_PUSH) || lowerCase.contains(UrlSchemaHelper.FROM_YUN_PUSH_TWO))) {
                            createNormalCfg.setStartFrom(7);
                        }
                        if (!StringUtils.isNull(str)) {
                            createNormalCfg.setOfficialBarMessageId(str);
                        }
                        if (lowerCase != null && lowerCase.contains("fr=collect")) {
                            createNormalCfg.setJumpToCommentArea(true);
                        }
                        tbPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        return (TextUtils.isEmpty(lowerCase) || lowerCase.contains("from=threadcard2") || z9) ? 0 : 0;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        VideoItemData videoItemData2 = new VideoItemData();
                        videoItemData2.thread_id = c;
                        arrayList2.add(videoItemData2);
                        if (z4) {
                            videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(tbPageContext.getPageActivity(), arrayList2, null, VideoRecommentPlayActivityConfig.FROM_LINK_PAGE);
                        } else {
                            videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(tbPageContext.getPageActivity(), arrayList2, null, VideoRecommentPlayActivityConfig.FROM_OFFICAL_VIDEO);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
                        return 0;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001609, new o45(tbPageContext, lowerCase)));
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements CustomMessageTask.CustomRunnable<Context> {
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
        public CustomResponsedMessage<xt8> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921343, new p18(customMessage.getData()));
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
        b();
        m();
        k();
        f();
        h();
        e();
        d();
        g();
        n();
        SwitchManager.getInstance().registerSwitch(by7.class);
        o();
        l();
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new h());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        i();
        j();
        i iVar = new i();
        iVar.setSelfExecute(true);
        iVar.setPriority(4);
        iVar.execute(new Void[0]);
        ItemCardHelper.t();
        ItemCardHelper.s();
        u95.a(aa5.a, new ez7());
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

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            bo4.b().c(2, new d());
            bo4.b().c(3, new e());
            bo4.b().c(4, new f());
            bo4.b().c(6, new g());
        }
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                String path = Uri.parse(str).getPath();
                return (TextUtils.isEmpty(path) || !path.endsWith("/")) ? path : path.substring(0, path.length() - 1);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(FoldCommentActivityConfig.class, FoldCommentActivity.class);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(ForbidActivityConfig.class, ForbidActivity.class);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(PbCommentFloatActivityConfig.class, PbCommentFloatActivity.class);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(PbFullScreenEditorActivityConfig.class, PbFullScreenEditorActivity.class);
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
            me5 h2 = sm8.h(302002, SubPbSocketResponseMessage.class, false, false);
            TbHttpMessageTask c2 = sm8.c(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
            h2.setParallel(a);
            c2.setParallel(a);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            UrlManager.getInstance().addListener(new j());
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_APPLY_COPY_THREAD, TbConfig.SERVER_ADDRESS + TbConfig.URL_APPLY_COPY_THREAD);
            tbHttpMessageTask.setResponsedClass(ApplyCopyThreadResponseMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            sm8.b(2004003, rz7.class);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            MessageManager.getInstance().registerListener(new b(2001609));
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            sm8.h(302001, pbPageSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, sm8.a("c/f/pb/page", 302001));
            vw7.g = tbHttpMessageTask;
            uw7.i = tbHttpMessageTask;
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setTimeOut(yb.d().b());
            tbHttpMessageTask.setRetry(yb.d().a());
            tbHttpMessageTask.setConnectTimeOut(yb.d().c());
            tbHttpMessageTask.setPriority(4);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsNeedCookie(UbsABTestHelper.isAddBaidIdCookie());
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            LocationModel.F();
            p();
            q();
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_FLOOR_AGREE, TbConfig.SERVER_ADDRESS + TbConfig.PB_FLOOR_AGREE_URL);
            tbHttpMessageTask.setResponsedClass(PbFloorAgreeResponseMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            MessageManager.getInstance().registerListener(new a(2001118));
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921343, new k());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            UrlManager.getInstance().addListener(new c());
        }
    }
}
