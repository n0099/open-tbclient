package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tieba.immessagecenter.chatgroup.floatentrance.ChatFloatEntranceFragment;
import com.baidu.tieba.immessagecenter.chatgroup.floatentrance.CollapseState;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class pd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qd8 a;
    public rd8 b;
    public od8 c;
    public boolean d;
    public long e;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od8 a;
        public final /* synthetic */ pd8 b;

        public a(pd8 pd8Var, od8 od8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pd8Var, od8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pd8Var;
            this.a = od8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (TbadkCoreApplication.isLogin()) {
                    pd8 pd8Var = this.b;
                    if (pd8Var.a.b.a == CollapseState.Icon.FORUM) {
                        pd8Var.d = true;
                        wd8.b(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, this.a.w(), this.a.v(), String.valueOf(this.b.a.b.d), 14, null);
                        GroupChatActivity.u1(view2.getContext(), this.b.a.b.d, -1, "");
                        return;
                    }
                }
                this.a.onClick(view2);
            }
        }
    }

    public pd8(@NonNull ChatFloatEntranceFragment.t tVar, @NonNull od8 od8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tVar, od8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = od8Var;
        rd8 rd8Var = new rd8(tVar, od8Var);
        this.b = rd8Var;
        this.a = new qd8(this, rd8Var);
        tVar.l.setOnClickListener(new a(this, od8Var));
        long w = od8Var.w();
        String v = od8Var.v();
        String valueOf = String.valueOf(this.a.b.d);
        if (d()) {
            str = "1";
        } else {
            str = "2";
        }
        wd8.d("c15207", w, v, valueOf, 1, str);
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void update(CollapseState collapseState, CollapseState collapseState2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, collapseState, collapseState2) == null) {
            this.b.update(collapseState, collapseState2);
        }
    }

    public void b() {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (System.currentTimeMillis() - this.e > 5000) {
                this.c.B1();
                this.e = System.currentTimeMillis();
            }
            this.a.b(false);
            long w = this.c.w();
            String v = this.c.v();
            String valueOf = String.valueOf(this.a.b.d);
            if (this.a.b.a == CollapseState.Icon.DEFAULT) {
                i = 3;
            } else {
                i = 2;
            }
            if (d()) {
                str = "1";
            } else {
                str = "2";
            }
            wd8.d("c15207", w, v, valueOf, i, str);
        }
    }

    public void c() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.b(true);
            long w = this.c.w();
            String v = this.c.v();
            String valueOf = String.valueOf(this.a.b.d);
            if (d()) {
                str = "1";
            } else {
                str = "2";
            }
            wd8.d("c15207", w, v, valueOf, 1, str);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            n95 m = n95.m();
            return m.i(ChatFloatEntranceFragment.f1126T + this.c.w(), true);
        }
        return invokeV.booleanValue;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.b.b(i);
        }
    }

    public void g(List<Long> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && this.d) {
            this.a.c(list);
            this.d = false;
        }
    }

    public void f(List<Long> list, long j, List list2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{list, Long.valueOf(j), list2, Integer.valueOf(i)}) == null) {
            this.a.a(list, j, list2, i);
        }
    }
}
