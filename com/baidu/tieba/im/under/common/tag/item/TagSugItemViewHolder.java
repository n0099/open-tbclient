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
import com.baidu.tieba.cz8;
import com.baidu.tieba.fq8;
import com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.im.under.common.tag.item.TagSugItemViewHolder;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.tieba.ry8;
import com.baidu.tieba.xp8;
import com.baidu.tieba.yp8;
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
    public ry8 d;
    public String e;
    public long f;
    public long g;
    @Nullable
    public BotsDTO.BotListDTO.SkillDTO h;
    @Nullable
    public BotsDTO.BotListDTO.UserDTO i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagSugItemViewHolder(@NonNull View view2, @NonNull final yp8 yp8Var, @Nullable fq8 fq8Var) {
        super(view2);
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, yp8Var, fq8Var};
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924a1);
        if (fq8Var != null) {
            fq8Var.b();
        }
        if (fq8Var != null) {
            j = fq8Var.a();
        } else {
            j = 0;
        }
        this.f = j;
        this.g = fq8Var != null ? fq8Var.c() : 0L;
        if (fq8Var != null) {
            str = fq8Var.d();
        } else {
            str = "";
        }
        this.e = str;
        ((ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0924a0)).setVisibility(8);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hy8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                    TagSugItemViewHolder.this.o(yp8Var, view3);
                }
            }
        });
    }

    @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
    public void f(xp8 xp8Var, Context context, int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, xp8Var, context, i) == null) {
            super.f(xp8Var, context, i);
            if (xp8Var instanceof ry8) {
                ry8 ry8Var = (ry8) xp8Var;
                this.d = ry8Var;
                this.c.setText(ry8Var.c());
                String b = cz8.b(this.d.b());
                AbilityItem b2 = this.d.b();
                String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(this.d.b().getStyleConf().getToUk());
                BotsDTO.BotListDTO.SkillDTO skillDTO = this.h;
                if (skillDTO != null) {
                    str = skillDTO.getName();
                } else {
                    str = "";
                }
                cz8.f("c15300", 1, b2, bdUidFromBdUK, str, this.f, this.g, this.e, b);
                p(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.h(i);
            p(i);
        }
    }

    public void q(@Nullable BotsDTO.BotListDTO.SkillDTO skillDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, skillDTO) == null) {
            this.h = skillDTO;
        }
    }

    public void t(@Nullable BotsDTO.BotListDTO.UserDTO userDTO) {
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

    public AbilityItem.Style n(@NonNull AbilityItem.StyleConf styleConf, int i) {
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

    public /* synthetic */ void o(yp8 yp8Var, View view2) {
        String str;
        String str2;
        if (yp8Var != null && this.d != null) {
            yp8Var.a(getAdapterPosition(), true, this.d.b());
            p(TbadkCoreApplication.getInst().getSkinType());
            String b = cz8.b(this.d.b());
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
            cz8.f("c15300", 2, b2, str, str2, this.f, this.g, this.e, b);
        }
    }

    public final void p(int i) {
        ry8 ry8Var;
        AbilityItem.Style n;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || (ry8Var = this.d) == null || ry8Var.b().getStyleConf() == null || (n = n(this.d.b().getStyleConf(), i)) == null) {
            return;
        }
        if (n.getContentColor() != null && n.getBackgroundColor() != null && !ColorUtils.isColorInvalid(ColorUtils.parseColor(n.getContentColor())) && !ColorUtils.isColorInvalid(ColorUtils.parseColor(n.getBackgroundColor()))) {
            s(n.getBackgroundColor(), n.getContentColor());
        } else {
            r();
        }
        this.c.setMaxLines(1);
        this.c.setSingleLine();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            EMManager.from(this.itemView).setCorner(R.string.deprecated_J_X19).setBackGroundSelectorColor(R.color.CAM_X0905);
            EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0302).setTextStyle(R.string.F_X01);
        }
    }

    public final void s(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            EMManager.from(this.itemView).setCorner(R.string.deprecated_J_X19).setAlpha(R.string.A_X11).setBackGroundColorString(str);
            EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            this.c.setTextColor(Color.parseColor(str2));
        }
    }
}
