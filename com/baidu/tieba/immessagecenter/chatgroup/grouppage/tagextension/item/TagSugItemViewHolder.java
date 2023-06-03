package com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatActivity;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.TagSugItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.kh8;
import com.baidu.tieba.m75;
import com.baidu.tieba.rh8;
import com.baidu.tieba.sh8;
import com.baidu.tieba.wo8;
import com.baidu.tieba.zg8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TagSugItemViewHolder extends BaseTagItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView c;
    public zg8 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagSugItemViewHolder(View view2, final sh8 sh8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, sh8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922c8);
        ((ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0922c7)).setVisibility(8);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sg8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                    TagSugItemViewHolder.this.p(sh8Var, view3);
                }
            }
        });
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void f(rh8 rh8Var, Context context, int i) {
        long j;
        long j2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, rh8Var, context, i) == null) {
            super.f(rh8Var, context, i);
            if (rh8Var instanceof zg8) {
                zg8 zg8Var = (zg8) rh8Var;
                this.d = zg8Var;
                this.c.setText(zg8Var.c());
                String a = kh8.a(this.d.b());
                AbilityItem b = this.d.b();
                String l = l();
                String n = n();
                if (m() != null) {
                    j = m().h2();
                } else {
                    j = 0;
                }
                if (m() != null) {
                    j2 = m().j2();
                } else {
                    j2 = 0;
                }
                if (m() != null) {
                    str = m().k2();
                } else {
                    str = "";
                }
                kh8.d("c15300", 1, b, l, n, j, j2, str, a);
                q(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.h(i);
            q(i);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i();
        }
    }

    public final GroupChatFragment m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            View view2 = this.itemView;
            if (view2 == null || !(view2.getContext() instanceof GroupChatActivity)) {
                return null;
            }
            return ((GroupChatActivity) this.itemView.getContext()).t1();
        }
        return (GroupChatFragment) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        GroupInputViewController n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            GroupChatFragment m = m();
            if (m != null && (n2 = m.n2()) != null && n2.M0() != null) {
                return BIMManager.getBdUidFromBdUK(n2.M0().getUk());
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            GroupChatFragment m = m();
            if (m != null && m.n2() != null && m.n2().N0() != null) {
                return m.n2().N0().getName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            m75 d = m75.d(this.itemView);
            d.o(R.string.deprecated_J_X19);
            d.i(R.color.CAM_X0905);
            m75 d2 = m75.d(this.c);
            d2.B(R.dimen.T_X08);
            d2.w(R.color.CAM_X0302);
            d2.C(R.string.F_X01);
        }
    }

    public AbilityItem.Style o(@NonNull AbilityItem.StyleConf styleConf, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, styleConf, i)) == null) {
            if (4 == i) {
                return styleConf.getDark();
            }
            return styleConf.getDay();
        }
        return (AbilityItem.Style) invokeLI.objValue;
    }

    public /* synthetic */ void p(sh8 sh8Var, View view2) {
        long j;
        String str;
        if (sh8Var != null && this.d != null) {
            sh8Var.a(getAdapterPosition(), true, this.d.b());
            q(TbadkCoreApplication.getInst().getSkinType());
            String a = kh8.a(this.d.b());
            AbilityItem b = this.d.b();
            String l = l();
            String n = n();
            long j2 = 0;
            if (m() != null) {
                j = m().h2();
            } else {
                j = 0;
            }
            if (m() != null) {
                j2 = m().j2();
            }
            long j3 = j2;
            if (m() != null) {
                str = m().k2();
            } else {
                str = "";
            }
            kh8.d("c15300", 2, b, l, n, j, j3, str, a);
        }
    }

    public final void q(int i) {
        zg8 zg8Var;
        AbilityItem.Style o;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || (zg8Var = this.d) == null || zg8Var.b().getStyleConf() == null || (o = o(this.d.b().getStyleConf(), i)) == null) {
            return;
        }
        if (o.getContentColor() != null && o.getBackgroundColor() != null && !wo8.a(wo8.b(o.getContentColor())) && !wo8.a(wo8.b(o.getBackgroundColor()))) {
            s(o.getBackgroundColor(), o.getContentColor());
        } else {
            r();
        }
        this.c.setMaxLines(1);
        this.c.setSingleLine();
    }

    public final void s(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            m75 d = m75.d(this.itemView);
            d.o(R.string.deprecated_J_X19);
            d.e(R.string.A_X11);
            d.g(str);
            m75 d2 = m75.d(this.c);
            d2.B(R.dimen.T_X08);
            d2.C(R.string.F_X01);
            this.c.setTextColor(Color.parseColor(str2));
        }
    }
}
