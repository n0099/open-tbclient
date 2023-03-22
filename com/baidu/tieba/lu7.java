package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tieba.immessagecenter.chatgroup.floatentrance.ChatFloatEntranceFragment;
import com.baidu.tieba.immessagecenter.chatgroup.floatentrance.CollapseState;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class lu7 implements pu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mu7 a;
    public nu7 b;
    public ju7 c;
    public boolean d;
    public long e;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju7 a;
        public final /* synthetic */ lu7 b;

        public a(lu7 lu7Var, ju7 ju7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lu7Var, ju7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lu7Var;
            this.a = ju7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (TbadkCoreApplication.isLogin()) {
                    lu7 lu7Var = this.b;
                    if (lu7Var.a.b.a == CollapseState.Icon.FORUM) {
                        lu7Var.d = true;
                        tu7.b(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, this.a.w(), this.a.v(), String.valueOf(this.b.a.b.d), 14, null);
                        GroupChatActivity.r1(view2.getContext(), this.b.a.b.d, -1, "");
                        return;
                    }
                }
                this.a.onClick(view2);
            }
        }
    }

    public lu7(@NonNull ChatFloatEntranceFragment.q qVar, @NonNull ju7 ju7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qVar, ju7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = ju7Var;
        nu7 nu7Var = new nu7(qVar, ju7Var);
        this.b = nu7Var;
        this.a = new mu7(this, nu7Var);
        qVar.l.setOnClickListener(new a(this, ju7Var));
        tu7.c("c15207", ju7Var.w(), ju7Var.v(), String.valueOf(this.a.b.d), 1, null);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void update(CollapseState collapseState, CollapseState collapseState2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, collapseState, collapseState2) == null) {
            this.b.update(collapseState, collapseState2);
        }
    }

    @Override // com.baidu.tieba.pu7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j(false);
        }
    }

    @Override // com.baidu.tieba.pu7
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            j(true);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.d();
        }
    }

    public void d() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (System.currentTimeMillis() - this.e > 5000) {
                this.c.y1();
                this.e = System.currentTimeMillis();
            }
            this.a.b(false);
            j(false);
            long w = this.c.w();
            String v = this.c.v();
            String valueOf = String.valueOf(this.a.b.d);
            if (this.a.b.a == CollapseState.Icon.DEFAULT) {
                i = 3;
            } else {
                i = 2;
            }
            tu7.c("c15207", w, v, valueOf, i, null);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.b(true);
            this.b.d();
            tu7.c("c15207", this.c.w(), this.c.v(), String.valueOf(this.a.b.d), 1, null);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.b.b(i);
        }
    }

    public void i(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            if (this.d) {
                this.a.c(list);
                this.d = false;
            }
            j(false);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && this.a.b.a == CollapseState.Icon.FORUM) {
            this.b.c(z);
        }
    }

    public void g(List<Long> list, long j, List list2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, Long.valueOf(j), list2, Integer.valueOf(i)}) == null) {
            this.a.a(list, j, list2, i);
            j(false);
        }
    }
}
