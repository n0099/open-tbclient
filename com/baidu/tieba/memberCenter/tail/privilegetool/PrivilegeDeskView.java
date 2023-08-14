package com.baidu.tieba.memberCenter.tail.privilegetool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import com.baidu.tieba.c49;
import com.baidu.tieba.c69;
import com.baidu.tieba.e69;
import com.baidu.tieba.lh5;
import com.baidu.tieba.sh5;
import com.baidu.tieba.th5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class PrivilegeDeskView extends CommonTabHost {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<th5> m;
    public int n;
    public DLauncher o;
    public DLauncher p;
    public Context q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public View.OnClickListener t;
    public View.OnClickListener u;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PrivilegeDeskView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PrivilegeDeskView privilegeDeskView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {privilegeDeskView, Integer.valueOf(i)};
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
            this.a = privilegeDeskView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.a.o.b(" ");
                } else {
                    this.a.o.c();
                }
                this.a.v();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PrivilegeDeskView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PrivilegeDeskView privilegeDeskView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {privilegeDeskView, Integer.valueOf(i)};
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
            this.a = privilegeDeskView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.a.p.b(" ");
                } else {
                    this.a.p.c();
                }
                this.a.v();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PrivilegeDeskView a;

        public c(PrivilegeDeskView privilegeDeskView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {privilegeDeskView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = privilegeDeskView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.hide();
                this.a.F(new lh5(1, 16, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PrivilegeDeskView a;

        public d(PrivilegeDeskView privilegeDeskView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {privilegeDeskView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = privilegeDeskView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.hide();
                this.a.F(new lh5(1, 12, null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivilegeDeskView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 0;
        this.r = new a(this, 2001344);
        this.s = new b(this, 2001353);
        this.t = new c(this);
        this.u = new d(this);
        r(context);
        e69 e69Var = new e69(context, 1);
        p(new c49(context));
        q(e69Var);
        this.q = context;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tieba.mh5
    public void B(lh5 lh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lh5Var) == null) {
            super.B(lh5Var);
            if (lh5Var == null) {
                return;
            }
            if (lh5Var.a == 2) {
                Object obj = lh5Var.c;
                if (obj == null) {
                    this.n--;
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    if (TextUtils.isEmpty(str)) {
                        this.n--;
                    } else if (TextUtils.isEmpty(str.trim())) {
                        this.n++;
                    } else {
                        this.n += JavaTypesHelper.toInt(str, 1);
                    }
                }
                if (this.n > 0) {
                    F(new lh5(2, 18, " "));
                } else {
                    F(new lh5(2, 18, null));
                }
            }
            if (lh5Var.a == 1) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 2));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tieba.yh5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            this.o.onChangeSkinType(i);
            this.p.onChangeSkinType(i);
        }
    }

    public final void p(c49 c49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, c49Var) == null) {
            DLauncher dLauncher = (DLauncher) sh5.a(getContext(), c49Var, 6);
            this.p = dLauncher;
            dLauncher.setOnClickListener(this.u);
            this.m.add(this.p);
        }
    }

    public final void q(e69 e69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, e69Var) == null) {
            DLauncher dLauncher = (DLauncher) sh5.a(getContext(), e69Var, 6);
            this.o = dLauncher;
            dLauncher.setOnClickListener(this.t);
            this.m.add(this.o);
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            setBackgroundColorId(R.color.CAM_X0206);
            setToolId(18);
            this.m = new LinkedList<>();
        }
    }

    public final void u(boolean z) {
        AccountData currentAccountObj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null) {
            currentAccountObj.setIsSelectTail(z);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tieba.yh5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setShowDelete(false);
            c69 c69Var = new c69();
            c69Var.z(this.m);
            h(c69Var);
            t();
            s();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.r);
            MessageManager.getInstance().registerListener(this.s);
            v();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.s);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble())) {
                this.p.b(" ");
            } else {
                this.p.c();
            }
            v();
        }
    }

    public final void t() {
        AccountData currentAccountObj;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) == null) {
            return;
        }
        if (currentAccountObj.getIsSelectTail()) {
            this.o.b(" ");
        } else {
            this.o.c();
        }
        v();
    }

    public final void v() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String text = this.o.getText();
            String text2 = this.p.getText();
            if (text != null && !text.equals("")) {
                z = true;
                F(new lh5(2, 18, " "));
                F(new lh5(2, 16, " "));
            } else {
                if (text2 != null && !text2.equals("")) {
                    F(new lh5(2, 18, " "));
                } else {
                    F(new lh5(2, 18, null));
                }
                z = false;
            }
            u(z);
        }
    }
}
