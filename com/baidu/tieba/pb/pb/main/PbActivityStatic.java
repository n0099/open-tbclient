package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.a.w;
import c.a.s0.e1.v0;
import c.a.s0.e1.w0;
import c.a.s0.e1.x;
import c.a.s0.u.l;
import c.a.s0.u.o;
import c.a.t0.s2.u.f.n0;
import c.a.t0.s2.u.f.r0;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.FoldCommentActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
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
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.video.VideoItemData;
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
/* loaded from: classes12.dex */
public class PbActivityStatic {
    public static /* synthetic */ Interceptable $ic;
    public static BdAsyncTaskParallel a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                        for (o oVar : TiePlusHelper.w) {
                            if (!StringUtils.isNull(oVar.f14154f) && oVar.f14154f.equals(downloadData.getId())) {
                                int status = downloadData.getStatus();
                                if (status != 0) {
                                    if (status == 1) {
                                        oVar.f14153e = false;
                                    }
                                } else if (!oVar.f14153e) {
                                    oVar.f14153e = true;
                                    TiePlusStat.e(oVar.a, oVar.f14150b, oVar.f14151c, oVar.f14152d);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            l lVar;
            String a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof l) || (a = (lVar = (l) customResponsedMessage.getData()).a()) == null) {
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
                baijiahaoData.oriUgcType = c.a.d.f.m.b.e(parse.getQueryParameter(TiebaStatic.Params.UGC_TYPE), 0);
                baijiahaoData.oriUgcVid = parse.getQueryParameter("ori_ugc_vid");
                if (!StringUtils.isNull(queryParameter3)) {
                    int e2 = c.a.d.f.m.b.e(queryParameter3, 0);
                    if (lVar.b() != null) {
                        x.a(queryParameter2, queryParameter, queryParameter4, e2, lVar.b(), baijiahaoData);
                    } else {
                        x.a(queryParameter2, queryParameter, queryParameter4, e2, lVar.b(), baijiahaoData);
                    }
                } else {
                    if (StringUtils.isNull(queryParameter2)) {
                        queryParameter2 = "0";
                    }
                    if (lVar.b() != null) {
                        x.a(queryParameter2, queryParameter, queryParameter4, 0, lVar.b(), baijiahaoData);
                    } else {
                        x.a(queryParameter2, queryParameter, queryParameter4, 0, lVar.b(), baijiahaoData);
                    }
                }
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class c implements UrlManager.UrlDealListener {
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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext == null || strArr == null || strArr[0] == null || !strArr[0].startsWith(TbDomainConfig.DOMAIN_HTTPS_TIEBA) || !"/mo/q/wise-main-share/shareVoiceRoom".equals(PbActivityStatic.c(strArr[0]))) {
                    return 3;
                }
                Uri parse = Uri.parse(strArr[0]);
                HashMap hashMap = new HashMap();
                for (String str : parse.getQueryParameterNames()) {
                    hashMap.put(str, String.valueOf(parse.getQueryParameter(str)));
                }
                if (hashMap.containsKey("room_id")) {
                    ((c.a.s0.j0.c.a) ServiceManager.getService(c.a.s0.j0.c.a.a.a())).a(tbPageContext, c.a.d.f.m.b.g((String) hashMap.get("room_id"), 0L));
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class d implements c.a.s0.e.e {
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

        @Override // c.a.s0.e.e
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = c.a.s0.e.d.a(context);
                if (a != null) {
                    FloatingLayout.LayoutParams layoutParams = new FloatingLayout.LayoutParams(-2, -2);
                    ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
                    SkinManager.setViewTextColor(a, c.a.t0.s2.f.CAM_X0302);
                    layoutParams.setMargins(n.f(context, c.a.t0.s2.g.ds8), n.f(context, c.a.t0.s2.g.ds4), 0, 0);
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class e implements c.a.s0.e.e {
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

        @Override // c.a.s0.e.e
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = c.a.s0.e.d.a(context);
                if (a != null) {
                    SkinManager.setViewTextColor(a, c.a.t0.s2.f.CAM_X0302);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(n.f(context, c.a.t0.s2.g.ds8), n.f(context, c.a.t0.s2.g.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class f implements c.a.s0.e.e {
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

        @Override // c.a.s0.e.e
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = c.a.s0.e.d.a(context);
                if (a != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    SkinManager.setViewTextColor(a, c.a.t0.s2.f.CAM_X0302);
                    layoutParams.setMargins(n.f(context, c.a.t0.s2.g.ds8), n.f(context, c.a.t0.s2.g.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class g implements c.a.s0.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.a.s0.e.e
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = c.a.s0.e.d.a(context);
                if (a != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    SkinManager.setViewTextColor(a, c.a.t0.s2.f.CAM_X0302);
                    layoutParams.setMargins(n.f(context, c.a.t0.s2.g.ds8), n.f(context, c.a.t0.s2.g.ds2), 0, 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class h implements CustomMessageTask.CustomRunnable<PbActivityConfig> {
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

    /* loaded from: classes12.dex */
    public static class i extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
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
                w0.a(PbPageRequestMessage.WIRE, PbPageResIdl.class);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class j implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Pattern a;

        public j() {
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
            this.a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            String c2;
            boolean z;
            boolean z2;
            boolean z3;
            String str;
            boolean z4;
            boolean z5;
            String substring;
            PbActivityConfig createNormalCfg;
            int i2;
            String str2;
            boolean z6;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0) {
                    int i3 = 0;
                    if (strArr[0] != null) {
                        boolean z7 = strArr.length > 1 && !StringUtils.isNull(strArr[1]) && strArr[1].toLowerCase().contains("n/video/opersquare");
                        String lowerCase = strArr[0].toLowerCase();
                        Matcher matcher = this.a.matcher(lowerCase);
                        String str4 = "push";
                        if (!Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find() && !lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_BAIJIAHAO_PB)) {
                            if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains("unidispatch/pb")) {
                                Uri parse = Uri.parse(lowerCase);
                                if (parse != null) {
                                    String queryParameter = parse.getQueryParameter(c.a.s0.a.g.Z);
                                    if (!StringUtils.isNull(queryParameter)) {
                                        TbSingleton.getInstance().setFromWhichSearchSource(queryParameter);
                                    }
                                }
                                if (parse != null) {
                                    String queryParameter2 = parse.getQueryParameter("obj_param1");
                                    if (!c.a.s0.a.g.g0.equals(queryParameter2) && !"2".equals(queryParameter2)) {
                                        PbActivityConfig pbActivityConfig = new PbActivityConfig(tbPageContext.getPageActivity());
                                        pbActivityConfig.setUri(Uri.parse(lowerCase));
                                        if (lowerCase != null && lowerCase.contains(UrlSchemaHelper.FROM_YUN_PUSH)) {
                                            pbActivityConfig.setStartFrom(7);
                                        }
                                        tbPageContext.sendMessage(new CustomMessage(2004001, pbActivityConfig));
                                    } else {
                                        String queryParameter3 = parse.getQueryParameter("tid");
                                        ArrayList arrayList = new ArrayList();
                                        VideoItemData videoItemData = new VideoItemData();
                                        videoItemData.thread_id = queryParameter3;
                                        arrayList.add(videoItemData);
                                        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(tbPageContext.getPageActivity(), arrayList, null, VideoRecommentPlayActivityConfig.FROM_PB_VIDEO_SCHEME);
                                        videoRecommentPlayActivityConfig.setParamIsVertail(true);
                                        videoRecommentPlayActivityConfig.setUri(parse);
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
                                    }
                                }
                                return 0;
                            }
                            String str5 = "";
                            if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_SUB_PB)) {
                                String paramStr = UrlManager.getParamStr(lowerCase);
                                if (!TextUtils.isEmpty(paramStr)) {
                                    Map<String, String> paramPair = UrlManager.getParamPair(paramStr);
                                    if (!paramPair.isEmpty()) {
                                        String str6 = paramPair.get("tid");
                                        String str7 = paramPair.get("pid");
                                        if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7)) {
                                            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(tbPageContext.getPageActivity()).createSubPbActivityConfig(str6, str7, "", true);
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
                                if (c.a.d.f.m.b.e(paramPair2.get("book_type"), 1) == 3) {
                                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                                        return 3;
                                    }
                                    n.M(tbPageContext.getPageActivity(), c.a.t0.s2.l.manga_plugin_not_install_tip);
                                    return 0;
                                } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                    return 3;
                                } else {
                                    n.M(tbPageContext.getPageActivity(), c.a.t0.s2.l.book_plugin_not_install_tip);
                                    return 0;
                                }
                            }
                            String str8 = "allthread";
                            if (matcher.find()) {
                                String group = matcher.group(1);
                                Uri parse2 = Uri.parse(lowerCase);
                                str5 = parse2.getQueryParameter("pid");
                                z4 = c.a.d.f.m.b.b(parse2.getQueryParameter("is_video"), false);
                                str = parse2.getQueryParameter("broadcast_id");
                                if (lowerCase != null) {
                                    String[] split = lowerCase.split("&");
                                    while (i3 < split.length) {
                                        if (split[i3] != null) {
                                            str3 = group;
                                            if (split[i3].startsWith("thread_type=")) {
                                                split[i3].substring(12);
                                            } else if (split[i3].startsWith("playstatkey=")) {
                                                str4 = split[i3].substring(12);
                                            }
                                        } else {
                                            str3 = group;
                                        }
                                        i3++;
                                        group = str3;
                                    }
                                    str2 = group;
                                    z6 = c.a.d.f.m.b.b(v0.c(lowerCase, "is_from_push="), false);
                                } else {
                                    str2 = group;
                                    z6 = false;
                                }
                                if (lowerCase != null && lowerCase.contains("?")) {
                                    String[] split2 = lowerCase.substring(lowerCase.indexOf("?") + 1, lowerCase.length()).split("&");
                                    int length = split2.length;
                                    int i4 = 0;
                                    while (i4 < length) {
                                        String str9 = split2[i4];
                                        if (str9.startsWith("playstatkey=")) {
                                            z5 = z6;
                                            str4 = str9.substring(12);
                                            break;
                                        }
                                        i4++;
                                        z6 = z6;
                                    }
                                }
                                z5 = z6;
                                if (lowerCase != null) {
                                    String c3 = v0.c(lowerCase, "sttype=");
                                    if (!StringUtils.isNull(c3)) {
                                        str8 = c3;
                                    }
                                }
                                c2 = str2;
                                z = false;
                                z2 = true;
                                z3 = true;
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
                                                z2 = false;
                                                break;
                                            } else if (split3[i5] != null && split3[i5].startsWith("kz=")) {
                                                c2 = split3[i5].substring(3);
                                                z2 = true;
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
                                        z2 = false;
                                    }
                                    z = false;
                                } else {
                                    if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                        String substring2 = lowerCase.substring(3);
                                        if (strArr.length > 1) {
                                            str8 = strArr[1];
                                            c2 = substring2;
                                            z = false;
                                            z2 = true;
                                        } else {
                                            c2 = substring2;
                                            z = false;
                                            z2 = true;
                                        }
                                    } else {
                                        if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                                            c2 = lowerCase.substring(22);
                                            z = true;
                                        } else if (TextUtils.isEmpty(lowerCase) || !lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) || !lowerCase.contains("kz=")) {
                                            return 3;
                                        } else {
                                            c2 = v0.c(lowerCase, "kz=");
                                            z = false;
                                        }
                                        z2 = false;
                                    }
                                    z3 = true;
                                    str = null;
                                    z4 = false;
                                    str8 = null;
                                    z5 = false;
                                }
                                z3 = true;
                                str = null;
                                z4 = false;
                                z5 = false;
                            }
                            if (StringUtils.isNull(c2, z3) || tbPageContext == null) {
                                if (!z || TextUtils.isEmpty(c2)) {
                                    if (z2) {
                                        tbPageContext.showToast(c.a.t0.s2.l.page_not_found);
                                        return 1;
                                    }
                                    return 3;
                                }
                                c.a.d.f.m.f.startService(TbadkCoreApplication.getInst(), r0.f(TbadkCoreApplication.getInst(), c2));
                                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", 3).param("obj_type", 2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
                                w.a(param, lowerCase);
                                TiebaStatic.log(param);
                                return 1;
                            }
                            if (z4) {
                                ArrayList arrayList2 = new ArrayList();
                                VideoItemData videoItemData2 = new VideoItemData();
                                videoItemData2.thread_id = c2;
                                arrayList2.add(videoItemData2);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoRecommentPlayActivityConfig(tbPageContext.getPageActivity(), arrayList2, null, VideoRecommentPlayActivityConfig.FROM_LINK_PAGE)));
                            } else {
                                if (StringUtils.isNull(str5)) {
                                    createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(c2, null, str8);
                                } else {
                                    createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(c2, str5, str8);
                                }
                                if (TextUtils.isEmpty(lowerCase) && lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(v0.c(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                                    createNormalCfg.setUserName(v0.c(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
                                }
                                createNormalCfg.setVideo_source(str4);
                                createNormalCfg.setStartFrom(25);
                                if (z5) {
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
                                if (!TextUtils.isEmpty(lowerCase) || lowerCase.contains("from=threadcard2") || z7) {
                                    return 0;
                                }
                            }
                            return 0;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001609, new l(tbPageContext, lowerCase)));
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class k implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
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
        public CustomResponsedMessage<c.a.t0.e4.a> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921343, new c.a.t0.s2.u.g.a(customMessage.getData()));
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
        n();
        l();
        g();
        i();
        f();
        e();
        d();
        h();
        o();
        SwitchManager.getInstance().registerSwitch(c.a.t0.s2.u.f.o.class);
        p();
        m();
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new h());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        j();
        k();
        i iVar = new i();
        iVar.setSelfExecute(true);
        iVar.setPriority(4);
        iVar.execute(new Void[0]);
        ItemCardHelper.t();
        ItemCardHelper.s();
        c.a.s0.j0.b.a(c.a.s0.j0.e.b.a, new n0());
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
            c.a.s0.e.c.b().c(2, new d());
            c.a.s0.e.c.b().c(3, new e());
            c.a.s0.e.c.b().c(4, new f());
            c.a.s0.e.c.b().c(6, new g());
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
            TbadkCoreApplication.getInst().RegisterIntent(PbSearchEmotionActivityConfig.class, PbSearchEmotionActivity.class);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(FoldCommentActivityConfig.class, FoldCommentActivity.class);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(ForbidActivityConfig.class, ForbidActivity.class);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(PbCommentFloatActivityConfig.class, PbCommentFloatActivity.class);
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(PbFullScreenEditorActivityConfig.class, PbFullScreenEditorActivity.class);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
            c.a.s0.a1.b h2 = c.a.t0.w3.f0.a.h(302002, SubPbSocketResponseMessage.class, false, false);
            TbHttpMessageTask c2 = c.a.t0.w3.f0.a.c(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
            h2.setParallel(a);
            c2.setParallel(a);
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            UrlManager.getInstance().addListener(new j());
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_APPLY_COPY_THREAD, TbConfig.SERVER_ADDRESS + TbConfig.URL_APPLY_COPY_THREAD);
            tbHttpMessageTask.setResponsedClass(ApplyCopyThreadResponseMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            c.a.t0.w3.f0.a.b(2004003, c.a.t0.s2.u.f.w0.class);
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            MessageManager.getInstance().registerListener(new b(2001609));
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            c.a.t0.w3.f0.a.h(302001, pbPageSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, c.a.t0.w3.f0.a.a("c/f/pb/page", 302001));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            LocationModel.H();
            q();
            r();
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_FLOOR_AGREE, TbConfig.SERVER_ADDRESS + TbConfig.PB_FLOOR_AGREE_URL);
            tbHttpMessageTask.setResponsedClass(PbFloorAgreeResponseMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            MessageManager.getInstance().registerListener(new a(2001118));
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921343, new k());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            UrlManager.getInstance().addListener(new c());
        }
    }
}
