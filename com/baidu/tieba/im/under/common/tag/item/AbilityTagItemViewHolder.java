package com.baidu.tieba.im.under.common.tag.item;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bn8;
import com.baidu.tieba.bv8;
import com.baidu.tieba.cn8;
import com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.tieba.tm8;
import com.baidu.tieba.uv8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class AbilityTagItemViewHolder extends BaseTagItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView c;
    public final TbImageView d;
    public final View e;
    public bv8 f;
    public String g;
    public long h;
    public Handler i;
    public boolean j;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cn8 a;
        public final /* synthetic */ AbilityTagItemViewHolder b;

        public a(AbilityTagItemViewHolder abilityTagItemViewHolder, cn8 cn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abilityTagItemViewHolder, cn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = abilityTagItemViewHolder;
            this.a = cn8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.f != null) {
                this.a.d(this.b.f.b(), this.b.f.c(), null);
                long e = this.b.f.e();
                uv8.g("c15210", 2, this.b.f.b(), this.b.f.d(), this.b.g, uv8.b(this.b.f.b()), e, this.b.h);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbilityTagItemViewHolder a;

        public b(AbilityTagItemViewHolder abilityTagItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abilityTagItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = abilityTagItemViewHolder;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.j = true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.i.removeCallbacksAndMessages(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ AbilityTagItemViewHolder c;

        public c(AbilityTagItemViewHolder abilityTagItemViewHolder, String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abilityTagItemViewHolder, str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = abilityTagItemViewHolder;
            this.a = str;
            this.b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.c.j) {
                return;
            }
            uv8.g("c15210", 1, this.c.f.b(), this.c.f.d(), this.c.g, this.a, this.b, this.c.h);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityTagItemViewHolder(@NonNull View view2, @Nullable cn8 cn8Var, @Nullable bn8 bn8Var) {
        super(view2);
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, cn8Var, bn8Var};
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
        this.i = new Handler();
        this.j = false;
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f090038);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090039);
        this.d = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09003a);
        if (bn8Var != null) {
            bn8Var.b();
        }
        if (bn8Var != null) {
            j = bn8Var.a();
        } else {
            j = 0;
        }
        this.h = j;
        if (bn8Var != null) {
            str = bn8Var.d();
        } else {
            str = "";
        }
        this.g = str;
        this.e.setOnClickListener(new a(this, cn8Var));
        this.e.addOnAttachStateChangeListener(new b(this));
    }

    @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
    public void f(@NonNull tm8 tm8Var, Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, tm8Var, context, i) == null) {
            super.f(tm8Var, context, i);
            if (tm8Var instanceof bv8) {
                bv8 bv8Var = (bv8) tm8Var;
                this.f = bv8Var;
                if (bv8Var.b() != null && this.f.b().getStyleConf() != null) {
                    this.c.setText(this.f.b().getStyleConf().getContent());
                }
                u(TbadkCoreApplication.getInst().getSkinType());
                long e = this.f.e();
                String b2 = uv8.b(this.f.b());
                this.i.removeCallbacksAndMessages(null);
                this.i.postDelayed(new c(this, b2, e), 500L);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.h(i);
            u(i);
        }
    }

    public AbilityItem.Style t(@NonNull AbilityItem.StyleConf styleConf, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, styleConf, i)) == null) {
            if (4 == i) {
                return styleConf.getDark();
            }
            return styleConf.getDay();
        }
        return (AbilityItem.Style) invokeLI.objValue;
    }

    public final void u(int i) {
        bv8 bv8Var;
        AbilityItem.StyleConf styleConf;
        AbilityItem.Style t;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || (bv8Var = this.f) == null || bv8Var.b() == null || this.f.b().getStyleConf() == null || (t = t((styleConf = this.f.b().getStyleConf()), i)) == null) {
            return;
        }
        if (TextUtils.isEmpty(styleConf.getContent()) && !TextUtils.isEmpty(t.getIcon())) {
            this.d.setVisibility(0);
            this.c.setVisibility(8);
            this.e.setBackground(null);
            this.d.startLoad(t.getIcon(), 45, false);
            return;
        }
        this.d.setVisibility(8);
        this.c.setVisibility(0);
        if (!ColorUtils.isColorInvalid(ColorUtils.parseColor(t.getContentColor()))) {
            this.c.setTextColor(ColorUtils.parseColor(t.getContentColor()));
        } else {
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0302);
        }
        if (!ColorUtils.isColorInvalid(ColorUtils.parseColor(t.getBackgroundColor()))) {
            EMManager.from(this.e).setBackGroundColorString(t.getBackgroundColor());
        } else {
            EMManager.from(this.e).setBackGroundColor(R.color.CAM_X0905);
        }
        EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
        EMManager.from(this.e).setCorner(R.string.deprecated_J_X19);
    }
}
