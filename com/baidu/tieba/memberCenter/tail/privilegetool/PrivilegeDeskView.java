package com.baidu.tieba.memberCenter.tail.privilegetool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.w.g;
import d.a.r0.w.h;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class PrivilegeDeskView extends CommonTabHost {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<h> q;
    public int r;
    public DLauncher s;
    public DLauncher t;
    public Context u;
    public CustomMessageListener v;
    public CustomMessageListener w;
    public View.OnClickListener x;
    public View.OnClickListener y;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrivilegeDeskView f18616a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PrivilegeDeskView privilegeDeskView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {privilegeDeskView, Integer.valueOf(i2)};
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
            this.f18616a = privilegeDeskView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f18616a.s.c(" ");
            } else {
                this.f18616a.s.f();
            }
            this.f18616a.y();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrivilegeDeskView f18617a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PrivilegeDeskView privilegeDeskView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {privilegeDeskView, Integer.valueOf(i2)};
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
            this.f18617a = privilegeDeskView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.f18617a.t.c(" ");
                } else {
                    this.f18617a.t.f();
                }
                this.f18617a.y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PrivilegeDeskView f18618e;

        public c(PrivilegeDeskView privilegeDeskView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {privilegeDeskView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18618e = privilegeDeskView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18618e.hide();
                this.f18618e.d(new d.a.r0.w.a(1, 16, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PrivilegeDeskView f18619e;

        public d(PrivilegeDeskView privilegeDeskView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {privilegeDeskView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18619e = privilegeDeskView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18619e.hide();
                this.f18619e.d(new d.a.r0.w.a(1, 12, null));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = 0;
        this.v = new a(this, 2001344);
        this.w = new b(this, 2001353);
        this.x = new c(this);
        this.y = new d(this);
        u(context);
        d.a.s0.v1.h.e.a aVar = new d.a.s0.v1.h.e.a(context, 1);
        s(new d.a.s0.v1.b.b(context));
        t(aVar);
        this.u = context;
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, d.a.r0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setShowDelete(false);
            d.a.s0.v1.h.d.a aVar = new d.a.s0.v1.h.d.a();
            aVar.C(this.q);
            k(aVar);
            w();
            v();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, d.a.r0.w.b
    public void onAction(d.a.r0.w.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            super.onAction(aVar);
            if (aVar == null) {
                return;
            }
            if (aVar.f56766a == 2) {
                Object obj = aVar.f56768c;
                if (obj == null) {
                    this.r--;
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    if (TextUtils.isEmpty(str)) {
                        this.r--;
                    } else if (TextUtils.isEmpty(str.trim())) {
                        this.r++;
                    } else {
                        this.r += d.a.c.e.m.b.d(str, 1);
                    }
                }
                if (this.r > 0) {
                    d(new d.a.r0.w.a(2, 18, " "));
                } else {
                    d(new d.a.r0.w.a(2, 18, null));
                }
            }
            if (aVar.f56766a == 1) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 2));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.v);
            MessageManager.getInstance().registerListener(this.w);
            y();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, d.a.r0.w.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.s.onChangeSkinType(i2);
            this.t.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.v);
            MessageManager.getInstance().unRegisterListener(this.w);
        }
    }

    public final void s(d.a.s0.v1.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            DLauncher dLauncher = (DLauncher) g.a(getContext(), bVar, 6);
            this.t = dLauncher;
            dLauncher.setOnClickListener(this.y);
            this.q.add(this.t);
        }
    }

    public final void t(d.a.s0.v1.h.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            DLauncher dLauncher = (DLauncher) g.a(getContext(), aVar, 6);
            this.s = dLauncher;
            dLauncher.setOnClickListener(this.x);
            this.q.add(this.s);
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            setBackgroundColorId(R.color.CAM_X0206);
            setToolId(18);
            this.q = new LinkedList<>();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble())) {
                this.t.c(" ");
            } else {
                this.t.f();
            }
            y();
        }
    }

    public final void w() {
        AccountData currentAccountObj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) == null) {
            return;
        }
        if (currentAccountObj.getIsSelectTail()) {
            this.s.c(" ");
        } else {
            this.s.f();
        }
        y();
    }

    public final void x(boolean z) {
        AccountData currentAccountObj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) == null) {
            return;
        }
        currentAccountObj.setIsSelectTail(z);
    }

    public final void y() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String text = this.s.getText();
            String text2 = this.t.getText();
            if (text != null && !text.equals("")) {
                z = true;
                d(new d.a.r0.w.a(2, 18, " "));
                d(new d.a.r0.w.a(2, 16, " "));
            } else {
                if (text2 != null && !text2.equals("")) {
                    d(new d.a.r0.w.a(2, 18, " "));
                } else {
                    d(new d.a.r0.w.a(2, 18, null));
                }
                z = false;
            }
            x(z);
        }
    }
}
