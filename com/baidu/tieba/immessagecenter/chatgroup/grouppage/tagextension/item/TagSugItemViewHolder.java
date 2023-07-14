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
import com.baidu.tieba.d85;
import com.baidu.tieba.ep8;
import com.baidu.tieba.h09;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatActivity;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.TagSugItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.lp8;
import com.baidu.tieba.mp8;
import com.baidu.tieba.so8;
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
    public so8 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagSugItemViewHolder(View view2, final mp8 mp8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, mp8Var};
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092367);
        ((ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092366)).setVisibility(8);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.jo8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                    TagSugItemViewHolder.this.q(mp8Var, view3);
                }
            }
        });
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void g(lp8 lp8Var, Context context, int i) {
        long j;
        long j2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, lp8Var, context, i) == null) {
            super.g(lp8Var, context, i);
            if (lp8Var instanceof so8) {
                so8 so8Var = (so8) lp8Var;
                this.d = so8Var;
                this.c.setText(so8Var.c());
                String b = ep8.b(this.d.b());
                AbilityItem b2 = this.d.b();
                String m = m();
                String o = o();
                if (n() != null) {
                    j = n().i2();
                } else {
                    j = 0;
                }
                if (n() != null) {
                    j2 = n().k2();
                } else {
                    j2 = 0;
                }
                if (n() != null) {
                    str = n().l2();
                } else {
                    str = "";
                }
                ep8.f("c15300", 1, b2, m, o, j, j2, str, b);
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
            return ((GroupChatActivity) this.itemView.getContext()).u1();
        }
        return (GroupChatFragment) invokeV.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        GroupInputViewController p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            GroupChatFragment n = n();
            if (n != null && (p2 = n.p2()) != null && p2.N0() != null) {
                return BIMManager.getBdUidFromBdUK(p2.N0().getUk());
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
            if (n != null && n.p2() != null && n.p2().O0() != null) {
                return n.p2().O0().getName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d85 d = d85.d(this.itemView);
            d.o(R.string.deprecated_J_X19);
            d.i(R.color.CAM_X0905);
            d85 d2 = d85.d(this.c);
            d2.C(R.dimen.T_X08);
            d2.x(R.color.CAM_X0302);
            d2.D(R.string.F_X01);
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

    public /* synthetic */ void q(mp8 mp8Var, View view2) {
        long j;
        String str;
        if (mp8Var != null && this.d != null) {
            mp8Var.a(getAdapterPosition(), true, this.d.b());
            r(TbadkCoreApplication.getInst().getSkinType());
            String b = ep8.b(this.d.b());
            AbilityItem b2 = this.d.b();
            String m = m();
            String o = o();
            long j2 = 0;
            if (n() != null) {
                j = n().i2();
            } else {
                j = 0;
            }
            if (n() != null) {
                j2 = n().k2();
            }
            long j3 = j2;
            if (n() != null) {
                str = n().l2();
            } else {
                str = "";
            }
            ep8.f("c15300", 2, b2, m, o, j, j3, str, b);
        }
    }

    public final void r(int i) {
        so8 so8Var;
        AbilityItem.Style p;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || (so8Var = this.d) == null || so8Var.b().getStyleConf() == null || (p = p(this.d.b().getStyleConf(), i)) == null) {
            return;
        }
        if (p.getContentColor() != null && p.getBackgroundColor() != null && !h09.a(h09.b(p.getContentColor())) && !h09.a(h09.b(p.getBackgroundColor()))) {
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
            d85 d = d85.d(this.itemView);
            d.o(R.string.deprecated_J_X19);
            d.e(R.string.A_X11);
            d.g(str);
            d85 d2 = d85.d(this.c);
            d2.C(R.dimen.T_X08);
            d2.D(R.string.F_X01);
            this.c.setTextColor(Color.parseColor(str2));
        }
    }
}
