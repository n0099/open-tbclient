package com.baidu.tieba;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.immessagecenter.chatgroup.floatentrance.ChatFloatEntranceFragment;
import com.baidu.tieba.immessagecenter.chatgroup.floatentrance.CollapseState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
/* loaded from: classes8.dex */
public class z78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ChatFloatEntranceFragment.t a;
    @NonNull
    public w78 b;
    public String c;
    public int d;
    @Nullable
    public CollapseState e;

    public z78(@NonNull ChatFloatEntranceFragment.t tVar, @NonNull w78 w78Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tVar, w78Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0;
        this.a = tVar;
        this.b = w78Var;
    }

    public void a(CollapseState collapseState) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, collapseState) != null) || collapseState == null) {
            return;
        }
        if (collapseState.b == CollapseState.State.EXPAND) {
            this.a.q.setVisibility(8);
            this.a.s.setVisibility(8);
            return;
        }
        e(collapseState);
    }

    public void b(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.d = i;
            o65 m = o65.m();
            if (i == 0) {
                str = "frs_loop_hot_chat_day_resource";
            } else {
                str = "frs_loop_hot_chat_night_resource";
            }
            this.c = m.s(str, "");
            SkinManager.setImageResource(this.a.m, R.drawable.icon_chat_group_collapse);
            this.a.o.setRadius(R.dimen.tbds134);
            this.a.o.setSkinType(i);
            if (i == 0) {
                this.a.k.setElevation(UtilHelper.getDimenPixelSize(R.dimen.tbds16));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0207));
            gradientDrawable.setShape(1);
            gradientDrawable.setUseLevel(false);
            this.a.k.setBackground(gradientDrawable);
            SkinManager.setImageResource(this.a.p, R.drawable.chat_collapse_at_me);
            SkinManager.setImageResource(this.a.r, R.drawable.chat_collapse_three_exp);
            d();
        }
    }

    public void c(CollapseState collapseState) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collapseState) != null) || collapseState == null) {
            return;
        }
        if (collapseState.a == CollapseState.Icon.DEFAULT) {
            Glide.with(this.a.o).load(Integer.valueOf((int) R.drawable.bg_chat_group_collapse_gradual)).into(this.a.o);
            this.a.m.setVisibility(0);
            this.a.n.setVisibility(8);
            return;
        }
        Glide.with(this.a.o).load(collapseState.e).into(this.a.o);
        this.a.m.setVisibility(8);
        this.a.n.setVisibility(0);
    }

    public final void d() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.e != null && this.b.getViewContext() != null && this.e.c == CollapseState.Tip.AT_ME) {
                Glide.with(this.b.getViewContext()).load(this.c).into(this.a.n);
                return;
            }
            ImageView imageView = this.a.n;
            if (this.d == 0) {
                i = R.drawable.obfuscated_res_0x7f08072b;
            } else {
                i = R.drawable.obfuscated_res_0x7f08072c;
            }
            SkinManager.setImageResource(imageView, i);
        }
    }

    public void e(CollapseState collapseState) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, collapseState) != null) || collapseState == null) {
            return;
        }
        CollapseState.Tip tip = collapseState.c;
        if (tip != CollapseState.Tip.DEFAULT && collapseState.b != CollapseState.State.EXPAND) {
            if (tip == CollapseState.Tip.AT_ME) {
                this.a.q.setVisibility(0);
                this.a.s.setVisibility(8);
            } else {
                this.a.q.setVisibility(8);
                this.a.s.setVisibility(0);
            }
        } else {
            this.a.q.setVisibility(8);
            this.a.s.setVisibility(8);
        }
        d();
    }

    public void update(CollapseState collapseState, CollapseState collapseState2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, collapseState, collapseState2) != null) || collapseState2 == null) {
            return;
        }
        this.e = collapseState2;
        if (collapseState.c != collapseState2.c) {
            e(collapseState2);
        }
        if (collapseState.a != collapseState2.a) {
            c(collapseState2);
        }
        if (collapseState.d != collapseState2.d) {
            c(collapseState2);
        }
        if ((TextUtils.isEmpty(collapseState.e) && !TextUtils.isEmpty(collapseState2.e)) || (!TextUtils.isEmpty(collapseState.e) && !collapseState.e.equals(collapseState2.e))) {
            c(collapseState2);
        }
        if (collapseState.b != collapseState2.b) {
            a(collapseState2);
        }
    }
}
