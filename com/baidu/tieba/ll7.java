package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.base.BdPageContextSupport;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.frs.FrsRecommendResMsg;
import com.baidu.tieba.frs.broadcast.ForumManagerRightsResMsg;
import com.baidu.tieba.ll7;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ll7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity a;
    public long b;
    public String c;
    public ov7 d;

    /* loaded from: classes7.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ll7 ll7Var) {
            super(2921469);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            jx4 jx4Var;
            TbPageContextSupport tbPageContextSupport;
            ov7 ov7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if ((responsedMessage.getData() instanceof jx4) && !this.a.c().isDestroyed()) {
                    Object data = responsedMessage.getData();
                    TbPageContext tbPageContext = null;
                    if (data instanceof jx4) {
                        jx4Var = (jx4) data;
                    } else {
                        jx4Var = null;
                    }
                    if (jx4Var == null) {
                        return;
                    }
                    FragmentActivity c = this.a.c();
                    if (c instanceof TbPageContextSupport) {
                        tbPageContextSupport = (TbPageContextSupport) c;
                    } else {
                        tbPageContextSupport = null;
                    }
                    if (tbPageContextSupport != null) {
                        tbPageContext = tbPageContextSupport.getPageContext();
                    }
                    if (tbPageContext == null) {
                        return;
                    }
                    if (this.a.d == null) {
                        this.a.d = new ov7(tbPageContext);
                    }
                    si7 value = ((ForumViewModel) new ViewModelProvider(this.a.c()).get(ForumViewModel.class)).c().getValue();
                    if (value != null && (ov7Var = this.a.d) != null) {
                        ov7Var.j(jx4Var.a, String.valueOf(value.f()), value.g(), jx4Var.b);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ll7 ll7Var) {
            super(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll7Var;
        }

        public static final void g(ll7 this$0, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", Long.valueOf(this$0.d()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this$0.c(), "ForumGradePage", hashMap)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage responsedMessage) {
            ViewGroup viewGroup;
            boolean z;
            HashMap<String, Object> params;
            Object obj;
            String obj2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if ((responsedMessage instanceof ForumManagerRightsResMsg) && !this.a.c().isDestroyed()) {
                    Message<?> message = responsedMessage.getmOrginalMessage();
                    String str = "";
                    if ((message instanceof HttpMessage) && (params = ((HttpMessage) message).getParams()) != null && (obj = params.get("thread_id")) != null && (obj2 = obj.toString()) != null) {
                        str = obj2;
                    }
                    ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) responsedMessage;
                    if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount > 0) {
                        ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(TbadkCoreApplication.getInst());
                        forumBroadcastHelper.jumpFlutterEditGenear(String.valueOf(this.a.d()), this.a.e(), "6");
                        if (str.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            forumBroadcastHelper.clipCopy(str);
                            forumBroadcastHelper.start();
                            return;
                        }
                        return;
                    }
                    View decorView = this.a.c().getWindow().getDecorView();
                    if (decorView instanceof ViewGroup) {
                        viewGroup = (ViewGroup) decorView;
                    } else {
                        viewGroup = null;
                    }
                    if (viewGroup == null) {
                        return;
                    }
                    ScreenTopToast screenTopToast = new ScreenTopToast(this.a.c());
                    screenTopToast.n(this.a.c().getString(R.string.frs_forum_bawu_send_broadcast_none_tip));
                    screenTopToast.k(this.a.c().getString(R.string.frs_recommend_fail_tip_btn));
                    final ll7 ll7Var = this.a;
                    screenTopToast.j(new View.OnClickListener() { // from class: com.baidu.tieba.al7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                ll7.b.g(ll7.this, view2);
                            }
                        }
                    });
                    screenTopToast.p(viewGroup);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ll7 ll7Var) {
            super(CmdConfigHttp.CMD_FRS_RECOMMEND);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll7Var;
        }

        public static final void g(ll7 this$0, View view2) {
            String valueOf;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (this$0.d() == 0) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(this$0.d());
                }
                if (valueOf.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", valueOf);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this$0.c(), "RecommendHistoryPage", hashMap)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage responsedMessage) {
            ViewGroup viewGroup;
            HttpMessage httpMessage;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (!(responsedMessage instanceof FrsRecommendResMsg)) {
                    return;
                }
                View decorView = this.a.c().getWindow().getDecorView();
                String str = null;
                if (decorView instanceof ViewGroup) {
                    viewGroup = (ViewGroup) decorView;
                } else {
                    viewGroup = null;
                }
                if (viewGroup == null) {
                    return;
                }
                if (responsedMessage.getError() == 0) {
                    FrsRecommendResMsg frsRecommendResMsg = (FrsRecommendResMsg) responsedMessage;
                    int pushStatus = frsRecommendResMsg.getPushStatus();
                    String pushMsg = frsRecommendResMsg.getPushMsg();
                    if (pushMsg == null) {
                        pushMsg = "";
                    }
                    if (pushStatus == 1) {
                        ScreenTopToast screenTopToast = new ScreenTopToast(this.a.c());
                        screenTopToast.n(this.a.c().getString(R.string.frs_recommend_suc_tip_title));
                        screenTopToast.l(this.a.c().getString(R.string.frs_recommend_suc_tip_content));
                        screenTopToast.k(this.a.c().getString(R.string.dialog_confirm_see));
                        final ll7 ll7Var = this.a;
                        screenTopToast.j(new View.OnClickListener() { // from class: com.baidu.tieba.vk7
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                    ll7.c.g(ll7.this, view2);
                                }
                            }
                        });
                        screenTopToast.p(viewGroup);
                        Message<?> orginalMessage = frsRecommendResMsg.getOrginalMessage();
                        if (orginalMessage instanceof HttpMessage) {
                            httpMessage = (HttpMessage) orginalMessage;
                        } else {
                            httpMessage = null;
                        }
                        if (httpMessage != null) {
                            HashMap<String, Object> params = httpMessage.getParams();
                            if (params != null) {
                                obj = params.get("forum_id");
                            } else {
                                obj = null;
                            }
                            if (obj instanceof String) {
                                str = obj;
                            }
                            if (str != null) {
                                br6.b().c(new xj7(str));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    new BdTopToast(this.a.c()).setIcon(false).setContent(pushMsg).show(viewGroup);
                    return;
                }
                new BdTopToast(this.a.c()).setIcon(false).setContent(responsedMessage.getErrorString()).show(viewGroup);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ll7 ll7Var) {
            super(2921465);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll7Var;
        }

        public static final void g(ll7 this$0, View view2) {
            String valueOf;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (this$0.d() == 0) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(this$0.d());
                }
                if (valueOf.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", valueOf);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this$0.c(), "ForumGradePage", hashMap)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            ViewGroup viewGroup;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                View decorView = this.a.c().getWindow().getDecorView();
                if (decorView instanceof ViewGroup) {
                    viewGroup = (ViewGroup) decorView;
                } else {
                    viewGroup = null;
                }
                if (viewGroup == null) {
                    return;
                }
                ScreenTopToast screenTopToast = new ScreenTopToast(this.a.c());
                screenTopToast.n(this.a.c().getString(R.string.frs_recommend_fail_month_tip));
                screenTopToast.k(this.a.c().getString(R.string.frs_recommend_fail_tip_btn));
                final ll7 ll7Var = this.a;
                screenTopToast.j(new View.OnClickListener() { // from class: com.baidu.tieba.bl7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            ll7.d.g(ll7.this, view2);
                        }
                    }
                });
                screenTopToast.p(viewGroup);
            }
        }
    }

    public ll7(FragmentActivity activity) {
        BdPageContextSupport bdPageContextSupport;
        BdPageContext pageContext;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = activity;
        this.c = "";
        BdUniqueId bdUniqueId = null;
        if (activity instanceof BdPageContextSupport) {
            bdPageContextSupport = (BdPageContextSupport) activity;
        } else {
            bdPageContextSupport = null;
        }
        if (bdPageContextSupport != null && (pageContext = bdPageContextSupport.getPageContext()) != null) {
            bdUniqueId = pageContext.getUniqueId();
        }
        c cVar = new c(this);
        d dVar = new d(this);
        b bVar = new b(this);
        a aVar = new a(this);
        if (bdUniqueId != null) {
            cVar.setTag(bdUniqueId);
            dVar.setTag(bdUniqueId);
            bVar.setTag(bdUniqueId);
            aVar.setTag(bdUniqueId);
            cVar.setSelfListener(true);
            dVar.setSelfListener(true);
            bVar.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(cVar);
        MessageManager.getInstance().registerListener(dVar);
        MessageManager.getInstance().registerListener(bVar);
        MessageManager.getInstance().registerListener(aVar);
    }

    public final void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.b = j;
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }
    }

    public final FragmentActivity c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.longValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }
}
