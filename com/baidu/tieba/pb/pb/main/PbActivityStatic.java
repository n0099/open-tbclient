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
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
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
import com.baidu.tieba.a28;
import com.baidu.tieba.aa5;
import com.baidu.tieba.c08;
import com.baidu.tieba.co4;
import com.baidu.tieba.do4;
import com.baidu.tieba.ea5;
import com.baidu.tieba.eh;
import com.baidu.tieba.ej;
import com.baidu.tieba.eo4;
import com.baidu.tieba.fj;
import com.baidu.tieba.fx7;
import com.baidu.tieba.gx7;
import com.baidu.tieba.ih;
import com.baidu.tieba.lm4;
import com.baidu.tieba.my7;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.pz7;
import com.baidu.tieba.se5;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.th5;
import com.baidu.tieba.u45;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.w45;
import com.baidu.tieba.wz7;
import com.baidu.tieba.y95;
import com.baidu.tieba.yi5;
import com.baidu.tieba.zb;
import com.baidu.tieba.zi5;
import com.baidu.tieba.zm8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public final class a extends CustomMessageListener {
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof DownloadMessage)) {
                return;
            }
            DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
            if (downloadMessage.getData() != null && ((List) downloadMessage.getData()).size() > 0) {
                for (DownloadData downloadData : (List) downloadMessage.getData()) {
                    if (downloadData != null) {
                        for (w45 w45Var : TiePlusHelper.t) {
                            if (!StringUtils.isNull(w45Var.f) && w45Var.f.equals(downloadData.getId())) {
                                int status = downloadData.getStatus();
                                if (status != 0) {
                                    if (status == 1) {
                                        w45Var.e = false;
                                    }
                                } else if (!w45Var.e) {
                                    w45Var.e = true;
                                    TiePlusStat.e(w45Var.a, w45Var.b, w45Var.c, w45Var.d);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class b extends CustomMessageListener {
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            u45 u45Var;
            String a;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof u45) || (a = (u45Var = (u45) customResponsedMessage.getData()).a()) == null) {
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
                baijiahaoData.oriUgcType = eh.e(parse.getQueryParameter(TiebaStatic.Params.UGC_TYPE), 0);
                baijiahaoData.oriUgcVid = parse.getQueryParameter("ori_ugc_vid");
                if (!StringUtils.isNull(queryParameter3)) {
                    int e = eh.e(queryParameter3, 0);
                    if (u45Var.b() != null) {
                        th5.a(queryParameter2, queryParameter, queryParameter4, e, u45Var.b(), baijiahaoData);
                    } else {
                        th5.a(queryParameter2, queryParameter, queryParameter4, e, u45Var.b(), baijiahaoData);
                    }
                } else {
                    if (StringUtils.isNull(queryParameter2)) {
                        queryParameter2 = "0";
                    }
                    if (u45Var.b() != null) {
                        th5.a(queryParameter2, queryParameter, queryParameter4, 0, u45Var.b(), baijiahaoData);
                    } else {
                        th5.a(queryParameter2, queryParameter, queryParameter4, 0, u45Var.b(), baijiahaoData);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class c implements UrlManager.UrlDealListener {
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
        public int deal(TbPageContext tbPageContext, String[] strArr) {
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
                    ((aa5) ServiceManager.getService(aa5.a.a())).a(tbPageContext, eh.g((String) hashMap.get("room_id"), 0L));
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public final class d implements eo4 {
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

        @Override // com.baidu.tieba.eo4
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = do4.a(context);
                if (a != null) {
                    FloatingLayout.LayoutParams layoutParams = new FloatingLayout.LayoutParams(-2, -2);
                    ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
                    SkinManager.setViewTextColor(a, (int) R.color.CAM_X0302);
                    layoutParams.setMargins(fj.f(context, R.dimen.obfuscated_res_0x7f070302), fj.f(context, R.dimen.obfuscated_res_0x7f070224), 0, 0);
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public final class e implements eo4 {
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

        @Override // com.baidu.tieba.eo4
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = do4.a(context);
                if (a != null) {
                    SkinManager.setViewTextColor(a, (int) R.color.CAM_X0302);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(fj.f(context, R.dimen.obfuscated_res_0x7f070302), fj.f(context, R.dimen.obfuscated_res_0x7f0701d4), 0, 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public final class f implements eo4 {
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

        @Override // com.baidu.tieba.eo4
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = do4.a(context);
                if (a != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    SkinManager.setViewTextColor(a, (int) R.color.CAM_X0302);
                    layoutParams.setMargins(fj.f(context, R.dimen.obfuscated_res_0x7f070302), fj.f(context, R.dimen.obfuscated_res_0x7f0701d4), 0, 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public final class g implements eo4 {
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

        @Override // com.baidu.tieba.eo4
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = do4.a(context);
                if (a != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    SkinManager.setViewTextColor(a, (int) R.color.CAM_X0302);
                    layoutParams.setMargins(fj.f(context, R.dimen.obfuscated_res_0x7f070302), fj.f(context, R.dimen.obfuscated_res_0x7f0701d4), 0, 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public final class h implements CustomMessageTask.CustomRunnable {
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
        public CustomResponsedMessage run(CustomMessage customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    if ("1".equals(((PbActivityConfig) customMessage.getData()).getIntent().getStringExtra("is_start_for_result"))) {
                        ((PbActivityConfig) customMessage.getData()).startActivityForResult(((PbActivityConfig) customMessage.getData()).getIntent().getIntExtra("request_code", 0), PbActivity.class);
                    } else {
                        ((PbActivityConfig) customMessage.getData()).startActivity(PbActivity.class);
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public final class i extends BdAsyncTask {
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
                zi5.a(PbPageRequestMessage.WIRE, PbPageResIdl.class);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public final class j implements UrlManager.UrlDealListener {
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
                if (!ej.isEmpty(queryParameter) && !ej.isEmpty(str)) {
                    if (queryParameter.equals("frs")) {
                        String queryParameter2 = uri.getQueryParameter("fname");
                        if (!ej.isEmpty(queryParameter2)) {
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

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:76:0x012f  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x013f  */
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int deal(TbPageContext tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            boolean z;
            String c;
            String str;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            String str2;
            String str3;
            boolean z8;
            VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig;
            PbActivityConfig createNormalCfg;
            int i;
            String str4;
            String str5;
            boolean z9;
            String str6;
            char c2;
            char c3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0 && strArr[0] != null) {
                    if (strArr.length > 1 && !StringUtils.isNull(strArr[1]) && strArr[1].toLowerCase().contains("n/video/opersquare")) {
                        z = true;
                    } else {
                        z = false;
                    }
                    String lowerCase = strArr[0].toLowerCase();
                    Matcher matcher = this.a.matcher(lowerCase);
                    String str7 = "push";
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
                                    String queryParameter6 = parse.getQueryParameter("pageStartFrom");
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
                                        if (c3 != 0) {
                                            if (c3 != 1) {
                                                if (c3 == 2) {
                                                    pbActivityConfig.setSortType(2);
                                                }
                                            } else {
                                                pbActivityConfig.setSortType(1);
                                            }
                                        } else {
                                            pbActivityConfig.setSortType(0);
                                        }
                                    }
                                    if (!TextUtils.isEmpty(queryParameter4)) {
                                        int hashCode = queryParameter4.hashCode();
                                        if (hashCode != 48) {
                                            if (hashCode == 49 && queryParameter4.equals("1")) {
                                                c2 = 1;
                                                if (c2 == 0) {
                                                    if (c2 == 1) {
                                                        pbActivityConfig.setJumpToCommentArea(true);
                                                    }
                                                } else {
                                                    pbActivityConfig.setJumpToCommentArea(false);
                                                }
                                                if (!TextUtils.isEmpty(queryParameter5)) {
                                                    pbActivityConfig.setHighLightPostId(queryParameter5);
                                                }
                                            }
                                            c2 = 65535;
                                            if (c2 == 0) {
                                            }
                                            if (!TextUtils.isEmpty(queryParameter5)) {
                                            }
                                        } else {
                                            if (queryParameter4.equals("0")) {
                                                c2 = 0;
                                                if (c2 == 0) {
                                                }
                                                if (!TextUtils.isEmpty(queryParameter5)) {
                                                }
                                            }
                                            c2 = 65535;
                                            if (c2 == 0) {
                                            }
                                            if (!TextUtils.isEmpty(queryParameter5)) {
                                            }
                                        }
                                    }
                                    if (lowerCase != null && lowerCase.contains(UrlSchemaHelper.FROM_YUN_PUSH)) {
                                        pbActivityConfig.setStartFrom(7);
                                    }
                                    if (!TextUtils.isEmpty(queryParameter6)) {
                                        pbActivityConfig.setStartFrom(eh.e(queryParameter6, 0));
                                    }
                                    tbPageContext.sendMessage(new CustomMessage(2004001, pbActivityConfig));
                                } else {
                                    String queryParameter7 = parse.getQueryParameter("tid");
                                    ArrayList arrayList = new ArrayList();
                                    VideoItemData videoItemData = new VideoItemData();
                                    videoItemData.thread_id = queryParameter7;
                                    arrayList.add(videoItemData);
                                    VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig2 = new VideoRecommentPlayActivityConfig(tbPageContext.getPageActivity(), arrayList, null, VideoRecommentPlayActivityConfig.FROM_PB_VIDEO_SCHEME);
                                    videoRecommentPlayActivityConfig2.setParamIsVertail(true);
                                    videoRecommentPlayActivityConfig2.setUri(parse);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig2));
                                }
                            }
                            return 0;
                        }
                        String str8 = "";
                        if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_SUB_PB)) {
                            String paramStr = UrlManager.getParamStr(lowerCase);
                            if (!TextUtils.isEmpty(paramStr)) {
                                Map paramPair = UrlManager.getParamPair(paramStr);
                                if (!paramPair.isEmpty()) {
                                    String str9 = (String) paramPair.get("tid");
                                    String str10 = (String) paramPair.get("pid");
                                    if (!TextUtils.isEmpty(str9) && !TextUtils.isEmpty(str10)) {
                                        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(tbPageContext.getPageActivity()).createSubPbActivityConfig(str9, str10, "", true);
                                        createSubPbActivityConfig.setIsFromeSchema(true);
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                                        return 0;
                                    }
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains("bookcover:")) {
                            Map paramPair2 = UrlManager.getParamPair(lowerCase.substring(10));
                            if (paramPair2 == null || paramPair2.size() <= 0) {
                                return 0;
                            }
                            if (eh.e((String) paramPair2.get(PaymentConfirmActivityConfig.BOOK_TYPE), 1) == 3) {
                                if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                                    return 3;
                                }
                                fj.M(tbPageContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0ab0);
                                return 0;
                            } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                return 3;
                            } else {
                                fj.M(tbPageContext.getPageActivity(), R.string.obfuscated_res_0x7f0f032d);
                                return 0;
                            }
                        }
                        String str11 = "allthread";
                        if (matcher.find()) {
                            String group = matcher.group(1);
                            Uri parse2 = Uri.parse(lowerCase);
                            if (a(tbPageContext, group, parse2)) {
                                return 0;
                            }
                            str8 = parse2.getQueryParameter("pid");
                            z5 = eh.b(parse2.getQueryParameter("is_video"), false);
                            z6 = eh.b(parse2.getQueryParameter("is_official_video"), false);
                            String queryParameter8 = parse2.getQueryParameter("broadcast_id");
                            if (lowerCase != null) {
                                String[] split = lowerCase.split("&");
                                str4 = group;
                                int i2 = 0;
                                while (i2 < split.length) {
                                    if (split[i2] != null) {
                                        str6 = queryParameter8;
                                        if (split[i2].startsWith("thread_type=")) {
                                            split[i2].substring(12);
                                        } else if (split[i2].startsWith("playstatkey=")) {
                                            str7 = split[i2].substring(12);
                                        }
                                    } else {
                                        str6 = queryParameter8;
                                    }
                                    i2++;
                                    queryParameter8 = str6;
                                }
                                str5 = queryParameter8;
                                z9 = eh.b(yi5.c(lowerCase, "is_from_push="), false);
                            } else {
                                str4 = group;
                                str5 = queryParameter8;
                                z9 = false;
                            }
                            if (lowerCase != null && lowerCase.contains("?")) {
                                String[] split2 = lowerCase.substring(lowerCase.indexOf("?") + 1, lowerCase.length()).split("&");
                                int length = split2.length;
                                int i3 = 0;
                                while (i3 < length) {
                                    String str12 = split2[i3];
                                    if (str12.startsWith("playstatkey=")) {
                                        z7 = z9;
                                        str7 = str12.substring(12);
                                        break;
                                    }
                                    i3++;
                                    z9 = z9;
                                }
                            }
                            z7 = z9;
                            if (lowerCase != null) {
                                String c4 = yi5.c(lowerCase, "sttype=");
                                if (!StringUtils.isNull(c4)) {
                                    str11 = c4;
                                }
                            }
                            c = str4;
                            str = str5;
                            z2 = false;
                            z3 = true;
                            z4 = true;
                        } else if (lowerCase != null && (lowerCase.startsWith(TbConfig.HTTP_PREFIX) || lowerCase.startsWith(TbConfig.HTTPS_PREFIX))) {
                            if (lowerCase.startsWith(TbConfig.HTTP_PREFIX)) {
                                str2 = lowerCase.substring(TbConfig.HTTP_PREFIX.length());
                            } else if (lowerCase.startsWith(TbConfig.HTTPS_PREFIX)) {
                                str2 = lowerCase.substring(TbConfig.HTTPS_PREFIX.length());
                            } else {
                                str2 = null;
                            }
                            if (str2 != null) {
                                String[] split3 = str2.split("&");
                                int i4 = 0;
                                while (true) {
                                    if (i4 < split3.length) {
                                        if (split3[i4] != null && split3[i4].startsWith("kz=")) {
                                            str3 = split3[i4].substring(3);
                                            z8 = true;
                                            break;
                                        }
                                        i4++;
                                    } else {
                                        str3 = null;
                                        z8 = false;
                                        break;
                                    }
                                }
                                if (!TextUtils.isEmpty(str3) && str3.contains("&")) {
                                    str3 = str3.split("&")[0];
                                }
                                if (TextUtils.isEmpty(str3)) {
                                    str3 = null;
                                }
                            } else {
                                str3 = null;
                                z8 = false;
                            }
                            z3 = z8;
                            z2 = false;
                            z4 = true;
                            z5 = false;
                            z6 = false;
                            z7 = false;
                            c = str3;
                            str = null;
                        } else {
                            if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                String substring = lowerCase.substring(3);
                                if (strArr.length > 1) {
                                    str11 = strArr[1];
                                    c = substring;
                                    str = null;
                                    z2 = false;
                                    z3 = true;
                                    z4 = true;
                                    z5 = false;
                                    z6 = false;
                                    z7 = false;
                                } else {
                                    c = substring;
                                    str = null;
                                    z2 = false;
                                    z3 = true;
                                }
                            } else {
                                if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                                    c = lowerCase.substring(22);
                                    str = null;
                                    z2 = true;
                                } else if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && lowerCase.contains("kz=")) {
                                    c = yi5.c(lowerCase, "kz=");
                                    str = null;
                                    z2 = false;
                                } else {
                                    return 3;
                                }
                                z3 = false;
                            }
                            z4 = true;
                            z5 = false;
                            z6 = false;
                            str11 = null;
                            z7 = false;
                        }
                        if (!StringUtils.isNull(c, z4) && tbPageContext != null) {
                            if (!z5 && !z6) {
                                if (StringUtils.isNull(str8)) {
                                    createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(c, null, str11);
                                } else {
                                    createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(c, str8, str11);
                                }
                                if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(yi5.c(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                                    createNormalCfg.setUserName(yi5.c(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
                                }
                                createNormalCfg.setVideo_source(str7);
                                createNormalCfg.setStartFrom(25);
                                if (z7) {
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
                                if (TextUtils.isEmpty(lowerCase) || lowerCase.contains("from=threadcard2") || z) {
                                    return 0;
                                }
                                return 0;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            VideoItemData videoItemData2 = new VideoItemData();
                            videoItemData2.thread_id = c;
                            arrayList2.add(videoItemData2);
                            if (z5) {
                                videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(tbPageContext.getPageActivity(), arrayList2, null, VideoRecommentPlayActivityConfig.FROM_LINK_PAGE);
                            } else {
                                videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(tbPageContext.getPageActivity(), arrayList2, null, VideoRecommentPlayActivityConfig.FROM_OFFICAL_VIDEO);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
                            return 0;
                        } else if (z2 && !TextUtils.isEmpty(c)) {
                            ih.startService(TbadkCoreApplication.getInst(), wz7.f(TbadkCoreApplication.getInst(), c));
                            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", 3).param("obj_type", 2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
                            lm4.a(param, lowerCase);
                            TiebaStatic.log(param);
                            return 1;
                        } else if (z3) {
                            tbPageContext.showToast(R.string.obfuscated_res_0x7f0f0d60);
                            return 1;
                        } else {
                            return 3;
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001609, new u45(tbPageContext, lowerCase)));
                    return 0;
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public final class k implements CustomMessageTask.CustomRunnable {
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
        public CustomResponsedMessage run(CustomMessage customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof Context)) {
                    return new CustomResponsedMessage(2921343, new a28((Context) customMessage.getData()));
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
        b();
        m();
        k();
        f();
        h();
        e();
        d();
        g();
        n();
        SwitchManager.getInstance().registerSwitch(my7.class);
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
        y95.a(ea5.a, new pz7());
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

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            UrlManager.getInstance().addListener(new j());
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            zm8.b(2004003, c08.class);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            MessageManager.getInstance().registerListener(new b(2001609));
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

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            co4.b().c(2, new d());
            co4.b().c(3, new e());
            co4.b().c(4, new f());
            co4.b().c(6, new g());
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
            se5 h2 = zm8.h(302002, SubPbSocketResponseMessage.class, false, false);
            TbHttpMessageTask c2 = zm8.c(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
            h2.setParallel(a);
            c2.setParallel(a);
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

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_FLOOR_AGREE, TbConfig.SERVER_ADDRESS + TbConfig.PB_FLOOR_AGREE_URL);
            tbHttpMessageTask.setResponsedClass(PbFloorAgreeResponseMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
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

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            zm8.h(302001, pbPageSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, zm8.a("c/f/pb/page", 302001));
            gx7.g = tbHttpMessageTask;
            fx7.i = tbHttpMessageTask;
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setTimeOut(zb.d().b());
            tbHttpMessageTask.setRetry(zb.d().a());
            tbHttpMessageTask.setConnectTimeOut(zb.d().c());
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
}
