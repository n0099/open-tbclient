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
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.R;
import com.baidu.tieba.as8;
import com.baidu.tieba.hs8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatActivity;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.TagSugItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.is8;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.tieba.or8;
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
    public or8 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagSugItemViewHolder(View view2, final is8 is8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, is8Var};
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923f3);
        ((ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0923f2)).setVisibility(8);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.fr8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                    TagSugItemViewHolder.this.p(is8Var, view3);
                }
            }
        });
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void f(hs8 hs8Var, Context context, int i) {
        long j;
        long j2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, hs8Var, context, i) == null) {
            super.f(hs8Var, context, i);
            if (hs8Var instanceof or8) {
                or8 or8Var = (or8) hs8Var;
                this.d = or8Var;
                this.c.setText(or8Var.c());
                String b = as8.b(this.d.b());
                AbilityItem b2 = this.d.b();
                String l = l();
                String n = n();
                if (m() != null) {
                    j = m().x2();
                } else {
                    j = 0;
                }
                if (m() != null) {
                    j2 = m().z2();
                } else {
                    j2 = 0;
                }
                if (m() != null) {
                    str = m().A2();
                } else {
                    str = "";
                }
                as8.f("c15300", 1, b2, l, n, j, j2, str, b);
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
        GroupInputViewController E2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            GroupChatFragment m = m();
            if (m != null && (E2 = m.E2()) != null && E2.M0() != null) {
                return BIMManager.getBdUidFromBdUK(E2.M0().getUk());
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
            if (m != null && m.E2() != null && m.E2().N0() != null) {
                return m.E2().N0().getName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            EMManager.from(this.itemView).setCorner(R.string.deprecated_J_X19).setBackGroundSelectorColor(R.color.CAM_X0905);
            EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0302).setTextStyle(R.string.F_X01);
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

    public /* synthetic */ void p(is8 is8Var, View view2) {
        long j;
        String str;
        if (is8Var != null && this.d != null) {
            is8Var.a(getAdapterPosition(), true, this.d.b());
            q(TbadkCoreApplication.getInst().getSkinType());
            String b = as8.b(this.d.b());
            AbilityItem b2 = this.d.b();
            String l = l();
            String n = n();
            long j2 = 0;
            if (m() != null) {
                j = m().x2();
            } else {
                j = 0;
            }
            if (m() != null) {
                j2 = m().z2();
            }
            long j3 = j2;
            if (m() != null) {
                str = m().A2();
            } else {
                str = "";
            }
            as8.f("c15300", 2, b2, l, n, j, j3, str, b);
        }
    }

    public final void q(int i) {
        or8 or8Var;
        AbilityItem.Style o;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || (or8Var = this.d) == null || or8Var.b().getStyleConf() == null || (o = o(this.d.b().getStyleConf(), i)) == null) {
            return;
        }
        if (o.getContentColor() != null && o.getBackgroundColor() != null && !ColorUtils.isColorInvalid(ColorUtils.parseColor(o.getContentColor())) && !ColorUtils.isColorInvalid(ColorUtils.parseColor(o.getBackgroundColor()))) {
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
            EMManager.from(this.itemView).setCorner(R.string.deprecated_J_X19).setAlpha(R.string.A_X11).setBackGroundColorString(str);
            EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            this.c.setTextColor(Color.parseColor(str2));
        }
    }
}
