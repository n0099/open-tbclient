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
import com.baidu.tieba.di8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatActivity;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.TagSugItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.ki8;
import com.baidu.tieba.li8;
import com.baidu.tieba.p75;
import com.baidu.tieba.rh8;
import com.baidu.tieba.tp8;
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
    public rh8 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagSugItemViewHolder(View view2, final li8 li8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, li8Var};
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922d3);
        ((ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0922d2)).setVisibility(8);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.kh8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                    TagSugItemViewHolder.this.p(li8Var, view3);
                }
            }
        });
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void f(ki8 ki8Var, Context context, int i) {
        long j;
        long j2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, ki8Var, context, i) == null) {
            super.f(ki8Var, context, i);
            if (ki8Var instanceof rh8) {
                rh8 rh8Var = (rh8) ki8Var;
                this.d = rh8Var;
                this.c.setText(rh8Var.c());
                String a = di8.a(this.d.b());
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
                di8.d("c15300", 1, b, l, n, j, j2, str, a);
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
            return ((GroupChatActivity) this.itemView.getContext()).u1();
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
            p75 d = p75.d(this.itemView);
            d.o(R.string.deprecated_J_X19);
            d.i(R.color.CAM_X0905);
            p75 d2 = p75.d(this.c);
            d2.C(R.dimen.T_X08);
            d2.x(R.color.CAM_X0302);
            d2.D(R.string.F_X01);
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

    public /* synthetic */ void p(li8 li8Var, View view2) {
        long j;
        String str;
        if (li8Var != null && this.d != null) {
            li8Var.a(getAdapterPosition(), true, this.d.b());
            q(TbadkCoreApplication.getInst().getSkinType());
            String a = di8.a(this.d.b());
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
            di8.d("c15300", 2, b, l, n, j, j3, str, a);
        }
    }

    public final void q(int i) {
        rh8 rh8Var;
        AbilityItem.Style o;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || (rh8Var = this.d) == null || rh8Var.b().getStyleConf() == null || (o = o(this.d.b().getStyleConf(), i)) == null) {
            return;
        }
        if (o.getContentColor() != null && o.getBackgroundColor() != null && !tp8.a(tp8.b(o.getContentColor())) && !tp8.a(tp8.b(o.getBackgroundColor()))) {
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
            p75 d = p75.d(this.itemView);
            d.o(R.string.deprecated_J_X19);
            d.e(R.string.A_X11);
            d.g(str);
            p75 d2 = p75.d(this.c);
            d2.C(R.dimen.T_X08);
            d2.D(R.string.F_X01);
            this.c.setTextColor(Color.parseColor(str2));
        }
    }
}
