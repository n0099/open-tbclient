package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
/* loaded from: classes8.dex */
public class sm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tm8 a;
    public um8 b;
    public rm8 c;
    public boolean d;
    public long e;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm8 a;
        public final /* synthetic */ sm8 b;

        public a(sm8 sm8Var, rm8 rm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm8Var, rm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sm8Var;
            this.a = rm8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (TbadkCoreApplication.isLogin()) {
                    sm8 sm8Var = this.b;
                    if (sm8Var.a.b.a == CollapseState.Icon.FORUM) {
                        sm8Var.d = true;
                        zm8.b(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, this.a.w(), this.a.v(), String.valueOf(this.b.a.b.d), 14, 1);
                        GroupChatActivity.w1(view2.getContext(), this.b.a.b.d, -1, "", 14);
                        return;
                    }
                }
                this.a.onClick(view2);
            }
        }
    }

    public sm8(@NonNull ChatFloatEntranceFragment.u uVar, @NonNull rm8 rm8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {uVar, rm8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = rm8Var;
        um8 um8Var = new um8(uVar, rm8Var);
        this.b = um8Var;
        this.a = new tm8(this, um8Var);
        uVar.l.setOnClickListener(new a(this, rm8Var));
        long w = rm8Var.w();
        String v = rm8Var.v();
        String valueOf = String.valueOf(this.a.b.d);
        if (d()) {
            str = "1";
        } else {
            str = "2";
        }
        zm8.e("c15207", w, v, valueOf, 1, str);
        zm8.c(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, rm8Var.w(), rm8Var.v(), String.valueOf(this.a.b.d), 2, 1);
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void h(CollapseState collapseState, CollapseState collapseState2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, collapseState, collapseState2) == null) {
            this.b.c(collapseState, collapseState2);
        }
    }

    public void b() {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (System.currentTimeMillis() - this.e > 5000) {
                this.c.U1();
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
            zm8.e("c15207", w, v, valueOf, i, str);
            zm8.c(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, this.c.w(), this.c.v(), String.valueOf(this.a.b.d), 2, 14);
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
            zm8.e("c15207", w, v, valueOf, 1, str);
            zm8.c(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, this.c.w(), this.c.v(), String.valueOf(this.a.b.d), 2, 1);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            return sharedPrefHelper.getBoolean(ChatFloatEntranceFragment.Y + this.c.v(), true);
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
