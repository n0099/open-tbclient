package com.baidu.tieba.im.under.common.tag.item;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.R;
import com.baidu.tieba.bo8;
import com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.im.under.common.tag.item.TagSugItemViewHolder;
import com.baidu.tieba.kf8;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.tieba.lf8;
import com.baidu.tieba.mo8;
import com.baidu.tieba.sf8;
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
    public bo8 d;
    public String e;
    public long f;
    public long g;
    @Nullable
    public BotsDTO.BotListDTO.SkillDTO h;
    @Nullable
    public BotsDTO.BotListDTO.UserDTO i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagSugItemViewHolder(@NonNull View view2, @NonNull final lf8 lf8Var, @Nullable sf8 sf8Var) {
        super(view2);
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, lf8Var, sf8Var};
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923be);
        if (sf8Var != null) {
            sf8Var.b();
        }
        if (sf8Var != null) {
            j = sf8Var.a();
        } else {
            j = 0;
        }
        this.f = j;
        this.g = sf8Var != null ? sf8Var.c() : 0L;
        if (sf8Var != null) {
            str = sf8Var.d();
        } else {
            str = "";
        }
        this.e = str;
        ((ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0923bd)).setVisibility(8);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.rn8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                    TagSugItemViewHolder.this.m(lf8Var, view3);
                }
            }
        });
    }

    @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
    public void f(kf8 kf8Var, Context context, int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, kf8Var, context, i) == null) {
            super.f(kf8Var, context, i);
            if (kf8Var instanceof bo8) {
                bo8 bo8Var = (bo8) kf8Var;
                this.d = bo8Var;
                this.c.setText(bo8Var.c());
                String b = mo8.b(this.d.b());
                AbilityItem b2 = this.d.b();
                String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(this.d.b().getStyleConf().getToUk());
                BotsDTO.BotListDTO.SkillDTO skillDTO = this.h;
                if (skillDTO != null) {
                    str = skillDTO.getName();
                } else {
                    str = "";
                }
                mo8.f("c15300", 1, b2, bdUidFromBdUK, str, this.f, this.g, this.e, b);
                n(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.h(i);
            n(i);
        }
    }

    public void o(@Nullable BotsDTO.BotListDTO.SkillDTO skillDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, skillDTO) == null) {
            this.h = skillDTO;
        }
    }

    public void r(@Nullable BotsDTO.BotListDTO.UserDTO userDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, userDTO) == null) {
            this.i = userDTO;
        }
    }

    @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i();
        }
    }

    public AbilityItem.Style l(@NonNull AbilityItem.StyleConf styleConf, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, styleConf, i)) == null) {
            if (4 == i) {
                return styleConf.getDark();
            }
            return styleConf.getDay();
        }
        return (AbilityItem.Style) invokeLI.objValue;
    }

    public /* synthetic */ void m(lf8 lf8Var, View view2) {
        String str;
        String str2;
        if (lf8Var != null && this.d != null) {
            lf8Var.a(getAdapterPosition(), true, this.d.b());
            n(TbadkCoreApplication.getInst().getSkinType());
            String b = mo8.b(this.d.b());
            BotsDTO.BotListDTO.UserDTO userDTO = this.i;
            if (userDTO == null) {
                str = "";
            } else {
                str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
            }
            AbilityItem b2 = this.d.b();
            BotsDTO.BotListDTO.SkillDTO skillDTO = this.h;
            if (skillDTO == null) {
                str2 = "";
            } else {
                str2 = skillDTO.getName();
            }
            mo8.f("c15300", 2, b2, str, str2, this.f, this.g, this.e, b);
        }
    }

    public final void n(int i) {
        bo8 bo8Var;
        AbilityItem.Style l;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || (bo8Var = this.d) == null || bo8Var.b().getStyleConf() == null || (l = l(this.d.b().getStyleConf(), i)) == null) {
            return;
        }
        if (l.getContentColor() != null && l.getBackgroundColor() != null && !ColorUtils.isColorInvalid(ColorUtils.parseColor(l.getContentColor())) && !ColorUtils.isColorInvalid(ColorUtils.parseColor(l.getBackgroundColor()))) {
            q(l.getBackgroundColor(), l.getContentColor());
        } else {
            p();
        }
        this.c.setMaxLines(1);
        this.c.setSingleLine();
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            EMManager.from(this.itemView).setCorner(R.string.deprecated_J_X19).setBackGroundSelectorColor(R.color.CAM_X0905);
            EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0302).setTextStyle(R.string.F_X01);
        }
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            EMManager.from(this.itemView).setCorner(R.string.deprecated_J_X19).setAlpha(R.string.A_X11).setBackGroundColorString(str);
            EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            this.c.setTextColor(Color.parseColor(str2));
        }
    }
}
