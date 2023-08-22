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
import com.baidu.tieba.fr8;
import com.baidu.tieba.gr8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatActivity;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.TagSugItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.tieba.mq8;
import com.baidu.tieba.yq8;
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
    public mq8 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagSugItemViewHolder(View view2, final gr8 gr8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, gr8Var};
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923b3);
        ((ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0923b2)).setVisibility(8);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.dq8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                    TagSugItemViewHolder.this.q(gr8Var, view3);
                }
            }
        });
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void g(fr8 fr8Var, Context context, int i) {
        long j;
        long j2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, fr8Var, context, i) == null) {
            super.g(fr8Var, context, i);
            if (fr8Var instanceof mq8) {
                mq8 mq8Var = (mq8) fr8Var;
                this.d = mq8Var;
                this.c.setText(mq8Var.c());
                String b = yq8.b(this.d.b());
                AbilityItem b2 = this.d.b();
                String m = m();
                String o = o();
                if (n() != null) {
                    j = n().v2();
                } else {
                    j = 0;
                }
                if (n() != null) {
                    j2 = n().x2();
                } else {
                    j2 = 0;
                }
                if (n() != null) {
                    str = n().y2();
                } else {
                    str = "";
                }
                yq8.f("c15300", 1, b2, m, o, j, j2, str, b);
                r(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.i(i);
            r(i);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.j();
        }
    }

    public final GroupChatFragment n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            View view2 = this.itemView;
            if (view2 == null || !(view2.getContext() instanceof GroupChatActivity)) {
                return null;
            }
            return ((GroupChatActivity) this.itemView.getContext()).s1();
        }
        return (GroupChatFragment) invokeV.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        GroupInputViewController C2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            GroupChatFragment n = n();
            if (n != null && (C2 = n.C2()) != null && C2.N0() != null) {
                return BIMManager.getBdUidFromBdUK(C2.N0().getUk());
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            GroupChatFragment n = n();
            if (n != null && n.C2() != null && n.C2().O0() != null) {
                return n.C2().O0().getName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            EMManager.from(this.itemView).setCorner(R.string.deprecated_J_X19).setBackGroundSelectorColor(R.color.CAM_X0905);
            EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0302).setTextStyle(R.string.F_X01);
        }
    }

    public AbilityItem.Style p(@NonNull AbilityItem.StyleConf styleConf, int i) {
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

    public /* synthetic */ void q(gr8 gr8Var, View view2) {
        long j;
        String str;
        if (gr8Var != null && this.d != null) {
            gr8Var.a(getAdapterPosition(), true, this.d.b());
            r(TbadkCoreApplication.getInst().getSkinType());
            String b = yq8.b(this.d.b());
            AbilityItem b2 = this.d.b();
            String m = m();
            String o = o();
            long j2 = 0;
            if (n() != null) {
                j = n().v2();
            } else {
                j = 0;
            }
            if (n() != null) {
                j2 = n().x2();
            }
            long j3 = j2;
            if (n() != null) {
                str = n().y2();
            } else {
                str = "";
            }
            yq8.f("c15300", 2, b2, m, o, j, j3, str, b);
        }
    }

    public final void r(int i) {
        mq8 mq8Var;
        AbilityItem.Style p;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || (mq8Var = this.d) == null || mq8Var.b().getStyleConf() == null || (p = p(this.d.b().getStyleConf(), i)) == null) {
            return;
        }
        if (p.getContentColor() != null && p.getBackgroundColor() != null && !ColorUtils.isColorInvalid(ColorUtils.parseColor(p.getContentColor())) && !ColorUtils.isColorInvalid(ColorUtils.parseColor(p.getBackgroundColor()))) {
            t(p.getBackgroundColor(), p.getContentColor());
        } else {
            s();
        }
        this.c.setMaxLines(1);
        this.c.setSingleLine();
    }

    public final void t(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            EMManager.from(this.itemView).setCorner(R.string.deprecated_J_X19).setAlpha(R.string.A_X11).setBackGroundColorString(str);
            EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            this.c.setTextColor(Color.parseColor(str2));
        }
    }
}
