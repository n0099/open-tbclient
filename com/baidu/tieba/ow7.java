package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsRecommendResMsg;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class ow7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsActivity a;
    public jga b;
    public HttpMessageListener c;
    public CustomMessageListener d;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow7 a;

        /* renamed from: com.baidu.tieba.ow7$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC0425a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0425a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.b != null && this.a.a.b.getForum() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.a.a.b.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a.a, "RecommendHistoryPage", hashMap)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ow7 ow7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow7Var, Integer.valueOf(i)};
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
            this.a = ow7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof FrsRecommendResMsg)) {
                return;
            }
            if (httpResponsedMessage.getError() == 0) {
                FrsRecommendResMsg frsRecommendResMsg = (FrsRecommendResMsg) httpResponsedMessage;
                int pushStatus = frsRecommendResMsg.getPushStatus();
                String pushMsg = frsRecommendResMsg.getPushMsg();
                if (pushStatus == 1) {
                    ScreenTopToast screenTopToast = new ScreenTopToast(this.a.a);
                    screenTopToast.m(this.a.a.getString(R.string.frs_recommend_suc_tip_title));
                    screenTopToast.l(this.a.a.getString(R.string.frs_recommend_suc_tip_content));
                    screenTopToast.k(this.a.a.getString(R.string.dialog_confirm_see));
                    screenTopToast.j(new View$OnClickListenerC0425a(this));
                    screenTopToast.o((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090c50));
                    return;
                }
                new BdTopToast(this.a.a).setIcon(false).setContent(pushMsg).show((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090c50));
                return;
            }
            new BdTopToast(this.a.a).setIcon(false).setContent(httpResponsedMessage.getErrorString()).show((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090c50));
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow7 a;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.b != null && this.a.a.b.getForum() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.a.a.b.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a.a, "ForumGradePage", hashMap)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ow7 ow7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow7Var, Integer.valueOf(i)};
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
            this.a = ow7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                ScreenTopToast screenTopToast = new ScreenTopToast(this.a.a);
                screenTopToast.m(this.a.a.getString(R.string.frs_recommend_fail_month_tip));
                screenTopToast.k(this.a.a.getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast.j(new a(this));
                screenTopToast.o((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090c50));
            }
        }
    }

    public ow7(FrsActivity frsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this, CmdConfigHttp.CMD_FRS_RECOMMEND);
        this.d = new b(this, 2921465);
        this.a = frsActivity;
    }

    public void c(jga jgaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jgaVar) == null) {
            this.b = jgaVar;
        }
    }
}
