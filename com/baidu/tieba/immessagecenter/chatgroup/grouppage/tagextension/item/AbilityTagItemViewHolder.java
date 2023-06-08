package com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.ke8;
import com.baidu.tieba.le8;
import com.baidu.tieba.nh8;
import com.baidu.tieba.o75;
import com.baidu.tieba.uh8;
import com.baidu.tieba.vg8;
import com.baidu.tieba.zo8;
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
    public vg8 f;
    public String g;
    public long h;
    public Handler i;
    public boolean j;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le8 a;
        public final /* synthetic */ AbilityTagItemViewHolder b;

        public a(AbilityTagItemViewHolder abilityTagItemViewHolder, le8 le8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abilityTagItemViewHolder, le8Var};
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
            this.a = le8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.f != null) {
                this.a.c(this.b.f.b(), this.b.f.c());
                long d = this.b.f.d();
                nh8.e("c15210", 2, this.b.f.b(), this.b.f.c(), this.b.g, nh8.a(this.b.f.b()), d, this.b.h);
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
            nh8.e("c15210", 1, this.c.f.b(), this.c.f.c(), this.c.g, this.a, this.b, this.c.h);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityTagItemViewHolder(@NonNull View view2, @Nullable le8 le8Var, @Nullable ke8 ke8Var) {
        super(view2);
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, le8Var, ke8Var};
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
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f090025);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090026);
        this.d = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090027);
        if (ke8Var != null) {
            ke8Var.b();
        }
        if (ke8Var != null) {
            j = ke8Var.a();
        } else {
            j = 0;
        }
        this.h = j;
        if (ke8Var != null) {
            str = ke8Var.c();
        } else {
            str = "";
        }
        this.g = str;
        this.e.setOnClickListener(new a(this, le8Var));
        this.e.addOnAttachStateChangeListener(new b(this));
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void f(@NonNull uh8 uh8Var, Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, uh8Var, context, i) == null) {
            super.f(uh8Var, context, i);
            if (uh8Var instanceof vg8) {
                vg8 vg8Var = (vg8) uh8Var;
                this.f = vg8Var;
                if (vg8Var.b() != null && this.f.b().getStyleConf() != null) {
                    this.c.setText(this.f.b().getStyleConf().getContent());
                }
                s(TbadkCoreApplication.getInst().getSkinType());
                long d = this.f.d();
                String a2 = nh8.a(this.f.b());
                this.i.removeCallbacksAndMessages(null);
                this.i.postDelayed(new c(this, a2, d), 500L);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.h(i);
            s(i);
        }
    }

    public AbilityItem.Style r(@NonNull AbilityItem.StyleConf styleConf, int i) {
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

    public final void s(int i) {
        vg8 vg8Var;
        AbilityItem.StyleConf styleConf;
        AbilityItem.Style r;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || (vg8Var = this.f) == null || vg8Var.b() == null || this.f.b().getStyleConf() == null || (r = r((styleConf = this.f.b().getStyleConf()), i)) == null) {
            return;
        }
        if (TextUtils.isEmpty(styleConf.getContent()) && !TextUtils.isEmpty(r.getIcon())) {
            this.d.setVisibility(0);
            this.c.setVisibility(8);
            this.e.setBackground(null);
            this.d.N(r.getIcon(), 45, false);
            return;
        }
        this.d.setVisibility(8);
        this.c.setVisibility(0);
        if (!zo8.a(zo8.b(r.getContentColor()))) {
            this.c.setTextColor(zo8.b(r.getContentColor()));
        } else {
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0302);
        }
        if (!zo8.a(zo8.b(r.getBackgroundColor()))) {
            o75.d(this.e).g(r.getBackgroundColor());
        } else {
            o75.d(this.e).f(R.color.CAM_X0905);
        }
        o75 d = o75.d(this.c);
        d.B(R.dimen.T_X08);
        d.C(R.string.F_X01);
        o75.d(this.e).o(R.string.deprecated_J_X19);
    }
}
