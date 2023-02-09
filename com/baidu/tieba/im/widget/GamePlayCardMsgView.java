package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.im.data.GamePlayOrderMsgData;
import com.baidu.tieba.im.model.FlutterCommonModel;
import com.baidu.tieba.im.model.IFlutterCommonDataCallback;
import com.baidu.tieba.kl7;
import com.baidu.tieba.n45;
import com.baidu.tieba.o45;
import com.baidu.tieba.p15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class GamePlayCardMsgView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;
    public EMTextView b;
    public TbImageView c;
    public EMTextView d;
    public EMTextView e;
    public EMTextView f;
    public EMTextView g;
    public LinearLayout h;
    public LinearLayout i;
    public TBSpecificationBtn j;
    public TBSpecificationBtn k;
    public LinearLayout l;
    public EMTextView m;
    public GamePlayOrderMsgData n;
    public FlutterCommonModel o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlayCardMsgView a;

        /* renamed from: com.baidu.tieba.im.widget.GamePlayCardMsgView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0316a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0316a(a aVar) {
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
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.a.j("order_confirm_player");
                }
            }
        }

        public a(GamePlayCardMsgView gamePlayCardMsgView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlayCardMsgView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePlayCardMsgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(this.a.f("c14878").addParam("obj_locate", 2));
                TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(TbadkCoreApplication.getInst().getCurrentActivity());
                tBAlertBuilder.w(R.string.game_back_tip);
                tBAlertBuilder.m(R.string.game_play_confirm_order);
                tBAlertBuilder.u(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0518, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0520, TBAlertConfig.OperateBtnStyle.MAIN, new View$OnClickListenerC0316a(this)));
                tBAlertBuilder.i();
                tBAlertBuilder.j(false);
                tBAlertBuilder.z();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlayCardMsgView a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.a.j("order_reject");
                }
            }
        }

        public c(GamePlayCardMsgView gamePlayCardMsgView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlayCardMsgView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePlayCardMsgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(this.a.f("c14878").addParam("obj_locate", 1));
                TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(TbadkCoreApplication.getInst().getCurrentActivity());
                tBAlertBuilder.w(R.string.game_back_tip);
                tBAlertBuilder.m(R.string.game_play_confuse_order);
                tBAlertBuilder.u(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0518, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0520, TBAlertConfig.OperateBtnStyle.MAIN, new a(this)));
                tBAlertBuilder.i();
                tBAlertBuilder.j(false);
                tBAlertBuilder.z();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlayCardMsgView a;

        public b(GamePlayCardMsgView gamePlayCardMsgView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlayCardMsgView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePlayCardMsgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(this.a.f("c14878").addParam("obj_locate", 2));
                this.a.j("order_accept");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlayCardMsgView a;

        public d(GamePlayCardMsgView gamePlayCardMsgView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlayCardMsgView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePlayCardMsgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(this.a.f("c14877"));
                if (this.a.n != null && !StringUtils.isNull(this.a.n.getOrder_id())) {
                    UrlSchemaJumpHelper.jumpGameOrderPage(this.a.getContext(), "com.baidu.tieba://unidispatch/GameGodsDetailPage?order_id=" + this.a.n.getOrder_id());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements IFlutterCommonDataCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlayCardMsgView a;

        public e(GamePlayCardMsgView gamePlayCardMsgView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlayCardMsgView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePlayCardMsgView;
        }

        @Override // com.baidu.tieba.im.model.IFlutterCommonDataCallback
        public void callback(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
                String str = (String) hashMap.get("cmd");
                if (!StringUtils.isNull(str) && this.a.n != null) {
                    try {
                        HashMap hashMap2 = new HashMap();
                        if (hashMap.get("params") instanceof HashMap) {
                            hashMap2 = (HashMap) hashMap.get("params");
                        }
                        if ("order_accept".equals(str)) {
                            String str2 = (String) hashMap2.get("order_id");
                            String str3 = (String) hashMap2.get("error_no");
                            if (str2 == null || !str2.equals(this.a.n.getOrder_id())) {
                                return;
                            }
                            this.a.y(1, str3);
                        } else if ("order_reject".equals(str)) {
                            String str4 = (String) hashMap2.get("order_id");
                            String str5 = (String) hashMap2.get("error_no");
                            if (str4 == null || !str4.equals(this.a.n.getOrder_id())) {
                                return;
                            }
                            this.a.y(2, str5);
                        } else if ("order_confirm_player".equals(str)) {
                            String str6 = (String) hashMap2.get("order_id");
                            String str7 = (String) hashMap2.get("error_no");
                            if (str6 == null || !str6.equals(this.a.n.getOrder_id())) {
                                return;
                            }
                            this.a.y(1, str7);
                        }
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlayCardMsgView a;

        public f(GamePlayCardMsgView gamePlayCardMsgView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlayCardMsgView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePlayCardMsgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m();
                TiebaStatic.log(this.a.f("c14878").addParam("obj_locate", 2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlayCardMsgView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(GamePlayCardMsgView gamePlayCardMsgView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlayCardMsgView, Integer.valueOf(i)};
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
            this.a = gamePlayCardMsgView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921732 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                int i = 0;
                try {
                    if (hashMap.get("success") != null && (hashMap.get("success") instanceof Integer)) {
                        i = ((Integer) hashMap.get("success")).intValue();
                    }
                    if (i == 1) {
                        int clickBtn = this.a.n.getClickBtn();
                        this.a.n.setClickBtn(2);
                        if (!this.a.z()) {
                            this.a.n.setClickBtn(clickBtn);
                        } else {
                            this.a.A();
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlayCardMsgView a;

        public h(GamePlayCardMsgView gamePlayCardMsgView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlayCardMsgView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePlayCardMsgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m();
                TiebaStatic.log(this.a.f("c14878").addParam("obj_locate", 2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlayCardMsgView a;

        public i(GamePlayCardMsgView gamePlayCardMsgView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlayCardMsgView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePlayCardMsgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(this.a.f("c14878").addParam("obj_locate", 1));
                if (!MessageManager.getInstance().hasListener(this.a.p.getCmd())) {
                    MessageManager.getInstance().registerListener(this.a.p);
                }
                this.a.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlayCardMsgView a;

        public j(GamePlayCardMsgView gamePlayCardMsgView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlayCardMsgView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePlayCardMsgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m();
                TiebaStatic.log(this.a.f("c14878").addParam("obj_locate", 2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePlayCardMsgView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(GamePlayCardMsgView gamePlayCardMsgView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlayCardMsgView, Integer.valueOf(i)};
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
            this.a = gamePlayCardMsgView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921731 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                int i = 0;
                try {
                    if (hashMap.get("success") != null && (hashMap.get("success") instanceof Integer)) {
                        i = ((Integer) hashMap.get("success")).intValue();
                    }
                    if (i == 1) {
                        int clickBtn = this.a.n.getClickBtn();
                        this.a.n.setClickBtn(1);
                        if (!this.a.z()) {
                            this.a.n.setClickBtn(clickBtn);
                        } else {
                            this.a.A();
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamePlayCardMsgView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new g(this, 2921732);
        this.q = new k(this, 2921731);
        h();
        g();
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || this.n == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", str);
        hashMap.put("order_id", this.n.getOrder_id());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("cmd", "gameplay");
        hashMap2.put("params", hashMap);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921729, hashMap2));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamePlayCardMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = new g(this, 2921732);
        this.q = new k(this, 2921731);
        h();
        g();
    }

    public void k(String str, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, str, hashMap) != null) || this.n == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("cmd", str);
        hashMap2.put("order_id", this.n.getOrder_id());
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put("cmd", "gameplay");
        hashMap3.put("params", hashMap2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921729, hashMap3));
    }

    private void setStrokeWith(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, tbImageView) == null) {
            tbImageView.setBorderWidth(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
        }
    }

    public void setData(GamePlayOrderMsgData gamePlayOrderMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gamePlayOrderMsgData) == null) {
            this.n = gamePlayOrderMsgData;
            if (gamePlayOrderMsgData != null) {
                A();
                TiebaStatic.log(f("c14876"));
            }
        }
    }

    public final void A() {
        GamePlayOrderMsgData gamePlayOrderMsgData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (gamePlayOrderMsgData = this.n) == null) {
            return;
        }
        this.a.setText(gamePlayOrderMsgData.getTitle());
        if (!StringUtils.isNull(this.n.getTitle_intro())) {
            this.b.setVisibility(0);
            this.b.setText(this.n.getTitle_intro());
        } else {
            this.b.setVisibility(8);
        }
        this.e.setText(this.n.getContent_title());
        this.c.setRadiusById(R.string.J_X05);
        this.c.setConrers(15);
        this.c.setDrawCorner(true);
        this.c.setPlaceHolder(1);
        this.c.setLongIconSupport(false);
        this.c.setGifIconSupport(false);
        this.c.K(this.n.getIcon(), 10, false);
        if (this.n.getContent_info() != null) {
            this.d.setVisibility(0);
            this.d.setText(this.n.getContent_info().getPrice());
            if (!StringUtils.isNull(this.n.getContent_info().getAmount())) {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                this.g.setText(this.n.getContent_info().getAmount());
            }
        }
        if (this.n.getPeiwan_msg_type() == 1) {
            if (this.n.getIs_god() == 1) {
                if (this.n.getClickBtn() == 1) {
                    r();
                } else if (this.n.getClickBtn() == 2) {
                    t();
                } else if (this.n.getClickBtn() == 3) {
                    n();
                } else {
                    u();
                }
            } else {
                this.i.setVisibility(8);
            }
        } else if (this.n.getPeiwan_msg_type() == 2) {
            this.i.setVisibility(8);
        } else if (this.n.getPeiwan_msg_type() == 3) {
            this.i.setVisibility(8);
        } else if (this.n.getPeiwan_msg_type() == 4) {
            if (this.n.getIs_god() == 1) {
                this.i.setVisibility(8);
            } else {
                q();
            }
        } else if (this.n.getPeiwan_msg_type() == 5) {
            if (this.n.getIs_god() == 1) {
                this.i.setVisibility(8);
            } else if (this.n.getClickBtn() == 1) {
                p();
            } else if (this.n.getClickBtn() == 3) {
                n();
            } else {
                w();
            }
        } else if (this.n.getPeiwan_msg_type() == 6) {
            this.i.setVisibility(8);
        } else if (this.n.getPeiwan_msg_type() == 7) {
            if (this.n.getIs_god() == 1) {
                this.i.setVisibility(8);
            } else {
                q();
            }
        } else if (this.n.getPeiwan_msg_type() == 8) {
            this.i.setVisibility(8);
        } else if (this.n.getPeiwan_msg_type() == 9) {
            if (this.n.getIs_god() == 1) {
                if (this.n.getClickBtn() == 1) {
                    p();
                } else if (this.n.getClickBtn() == 3) {
                    n();
                } else {
                    s();
                }
            } else {
                this.i.setVisibility(8);
            }
        } else if (this.n.getPeiwan_msg_type() == 10) {
            if (this.n.getIs_god() == 1) {
                this.i.setVisibility(8);
            } else if (this.n.getClickBtn() == 2) {
                v();
            } else if (this.n.getClickBtn() == 3) {
                n();
            } else {
                x();
            }
        } else {
            this.i.setVisibility(8);
        }
        if (!this.n.isLast() && this.n.getClickBtn() == 0) {
            this.i.setVisibility(8);
        }
    }

    public StatisticItem f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.n == null) {
                return null;
            }
            return new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.n.getUser_id()).param("obj_source", this.n.getPeiwan_msg_type());
        }
        return (StatisticItem) invokeL.objValue;
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (!StringUtils.isNull(str) && str.endsWith("MsgleftView")) {
                SkinManager.setBackgroundResource(this, R.drawable.icon_pic_im_bubble_share_left);
            } else if (!StringUtils.isNull(str) && str.endsWith("MsgrightView")) {
                SkinManager.setBackgroundResource(this, R.drawable.icon_pic_im_bubble_share_right);
            }
            p15.d(this.a).v(R.color.CAM_X0105);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setOnClickListener(new d(this));
            if (this.o == null) {
                this.o = new FlutterCommonModel();
            }
            this.o.setCallback(new e(this));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.i.setVisibility(0);
            this.j.setVisibility(0);
            this.j.setEnabled(false);
            this.k.setVisibility(8);
            this.j.setText("已操作完成");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.q);
            FlutterCommonModel flutterCommonModel = this.o;
            if (flutterCommonModel != null) {
                flutterCommonModel.setCallback(null);
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.i.setVisibility(0);
            this.k.setVisibility(8);
            this.j.setVisibility(0);
            this.j.setText("已完成");
            this.j.setEnabled(false);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i.setVisibility(0);
            this.k.setVisibility(8);
            this.j.setVisibility(0);
            this.j.setText("已接单");
            this.j.setEnabled(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.i.setVisibility(0);
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            this.k.setText("已拒绝");
            this.k.setEnabled(false);
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.n == null) {
                return false;
            }
            return kl7.w().y(this.n.getGid(), this.n.getMid(), OrmObject.jsonStrWithObject(this.n));
        }
        return invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.msg_card_game_play_view, this);
            setOrientation(1);
            this.a = (EMTextView) findViewById(R.id.msg_card_title);
            this.b = (EMTextView) findViewById(R.id.msg_card_hint);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.msg_card_inner_img);
            this.c = tbImageView;
            setStrokeWith(tbImageView);
            this.e = (EMTextView) findViewById(R.id.msg_card_inner_title);
            this.d = (EMTextView) findViewById(R.id.msg_card_inner_order_price);
            this.f = (EMTextView) findViewById(R.id.msg_card_inner_order_point);
            this.g = (EMTextView) findViewById(R.id.msg_card_inner_order_num);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.msg_card_inner_ll);
            this.h = linearLayout;
            p15 d2 = p15.d(linearLayout);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0204);
            this.l = (LinearLayout) findViewById(R.id.msg_card_bottom_ll);
            this.m = (EMTextView) findViewById(R.id.msg_card_bottom_hint);
            this.i = (LinearLayout) findViewById(R.id.msg_card_btn_ll);
            this.j = (TBSpecificationBtn) findViewById(R.id.msg_card_btn_main);
            this.k = (TBSpecificationBtn) findViewById(R.id.msg_card_btn_second);
            n45 n45Var = new n45();
            n45Var.r(R.color.CAM_X0302, R.color.CAM_X0101);
            this.j.setConfig(n45Var);
            this.j.setTextSize(R.dimen.T_X08);
            this.j.setEnabled(true);
            o45 o45Var = new o45();
            o45Var.s(R.color.CAM_X0105);
            this.k.setConfig(o45Var);
            this.k.setTextSize(R.dimen.T_X08);
            this.k.setEnabled(true);
            l("");
        }
    }

    public void i() {
        GamePlayOrderMsgData gamePlayOrderMsgData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (gamePlayOrderMsgData = this.n) != null && gamePlayOrderMsgData.getSecond_btn_action_params() != null) {
            UrlSchemaJumpHelper.jumpGameOrderCommentPage(getContext(), "com.baidu.tieba://unidispatch/GameOrderComment?order_id=" + this.n.getOrder_id() + "&order_status=" + this.n.getSecond_btn_action_params().getOrder_status() + "&game_name=" + this.n.getSecond_btn_action_params().getGame_name() + "&game_id=" + this.n.getSecond_btn_action_params().getGame_id() + "&play_times=" + this.n.getSecond_btn_action_params().getPlay_times() + "&order_amount=" + this.n.getSecond_btn_action_params().getOrder_amount() + "&play_price=" + this.n.getSecond_btn_action_params().getPlay_price() + "&unit=" + this.n.getSecond_btn_action_params().getUnit() + "&avatar=" + this.n.getSecond_btn_action_params().getAvatar() + "&user_name=" + this.n.getSecond_btn_action_params().getUser_name());
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.n == null) {
            return;
        }
        UrlSchemaJumpHelper.jumpGameGodsPage(getContext(), "com.baidu.tieba://unidispatch/GameGodsDetailPage?god_id=" + this.n.getGod_id() + "&" + BdUniDispatchSchemeController.PARAM_FROM_NATIVE + "=1");
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int clickBtn = this.n.getClickBtn();
            this.n.setClickBtn(3);
            if (z()) {
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.j.setEnabled(false);
                this.k.setVisibility(8);
                this.j.setText("已操作完成");
                return;
            }
            this.n.setClickBtn(clickBtn);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !StringUtils.isNull(this.n.getMain_btn()) && this.j != null) {
            this.i.setVisibility(0);
            this.k.setVisibility(8);
            this.j.setVisibility(0);
            this.j.setText(this.n.getMain_btn());
            this.j.setEnabled(true);
            this.j.setOnClickListener(new j(this));
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !StringUtils.isNull(this.n.getMain_btn()) && this.j != null) {
            this.i.setVisibility(0);
            this.k.setVisibility(8);
            this.j.setVisibility(0);
            this.j.setText(this.n.getMain_btn());
            this.j.setEnabled(true);
            this.j.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.im.widget.GamePlayCardMsgView.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GamePlayCardMsgView a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        TiebaStatic.log(this.a.f("c14878").addParam("obj_locate", 2));
                        if (!MessageManager.getInstance().hasListener(this.a.q.getCmd())) {
                            MessageManager.getInstance().registerListener(this.a.q);
                        }
                        if (this.a.n.getMain_btn_action_params() != null) {
                            this.a.k("order_confirm_god", new HashMap(this, this.a.n.getMain_btn_action_params().getFinish_example_image()) { // from class: com.baidu.tieba.im.widget.GamePlayCardMsgView.9.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass9 this$1;
                                public final /* synthetic */ String val$finishExampleImg;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, r7};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$finishExampleImg = r7;
                                    put("finish_example_image", this.val$finishExampleImg);
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && !StringUtils.isNull(this.n.getMain_btn()) && this.j != null) {
            this.i.setVisibility(0);
            this.k.setVisibility(8);
            this.j.setVisibility(0);
            this.j.setText(this.n.getMain_btn());
            this.j.setEnabled(true);
            this.j.setOnClickListener(new a(this));
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!StringUtils.isNull(this.n.getMain_btn()) && this.j != null) {
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.j.setText(this.n.getMain_btn());
                this.j.setEnabled(true);
                this.j.setOnClickListener(new b(this));
            }
            if (!StringUtils.isNull(this.n.getSecond_btn()) && this.k != null) {
                this.i.setVisibility(0);
                this.k.setVisibility(0);
                this.k.setText(this.n.getSecond_btn());
                this.k.setEnabled(true);
                this.k.setOnClickListener(new c(this));
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (!StringUtils.isNull(this.n.getMain_btn()) && this.j != null) {
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.j.setText(this.n.getMain_btn());
                this.j.setEnabled(true);
                this.j.setOnClickListener(new f(this));
            }
            if (!StringUtils.isNull(this.n.getSecond_btn()) && this.k != null) {
                this.i.setVisibility(0);
                this.k.setVisibility(0);
                this.k.setText("已评价");
                this.k.setEnabled(false);
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (!StringUtils.isNull(this.n.getMain_btn()) && this.j != null) {
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.j.setText(this.n.getMain_btn());
                this.j.setEnabled(true);
                this.j.setOnClickListener(new h(this));
            }
            if (!StringUtils.isNull(this.n.getSecond_btn()) && this.k != null) {
                this.i.setVisibility(0);
                this.k.setVisibility(0);
                this.k.setText(this.n.getSecond_btn());
                this.k.setEnabled(true);
                this.k.setOnClickListener(new i(this));
            }
        }
    }

    public final void y(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048598, this, i2, str) != null) || this.n == null) {
            return;
        }
        if ("0".equals(str)) {
            int clickBtn = this.n.getClickBtn();
            this.n.setClickBtn(i2);
            if (z()) {
                A();
            } else {
                this.n.setClickBtn(clickBtn);
            }
        } else if ("100107".equals(str)) {
            o();
        }
    }
}
