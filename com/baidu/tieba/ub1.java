package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.txt.SelectorTextView;
import com.baidu.tieba.a41;
import com.baidu.tieba.rb1;
import com.baidu.tieba.tb1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ub1 extends rb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TextView j;
    public SelectorTextView k;
    public c l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub1 a;

        public a(ub1 ub1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.l.k != null) {
                this.a.l.k.a(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub1 a;

        public b(ub1 ub1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.l.j != null) {
                this.a.l.j.a(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends rb1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int g;
        public int h;
        public int i;
        public rb1.c j;
        public rb1.c k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public c A(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                super.q(i);
                return this;
            }
            return (c) invokeI.objValue;
        }

        @Override // com.baidu.tieba.tb1.a
        public tb1 f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                return new ub1(context);
            }
            return (tb1) invokeL.objValue;
        }

        @Override // com.baidu.tieba.tb1.a
        public /* bridge */ /* synthetic */ tb1.a q(int i) {
            A(i);
            return this;
        }

        @Override // com.baidu.tieba.rb1.b, com.baidu.tieba.tb1.a
        public tb1 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ub1 ub1Var = (ub1) super.a();
                ub1Var.p(this);
                return ub1Var;
            }
            return (tb1) invokeV.objValue;
        }

        public c z(int i, rb1.c cVar) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, cVar)) == null) {
                this.g = i;
                this.k = cVar;
                return this;
            }
            return (c) invokeIL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ub1(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void p(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.l = cVar;
        }
    }

    @Override // com.baidu.tieba.rb1
    public View i(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.e).inflate(R.layout.nad_view_safe_dialog, viewGroup, false);
            this.i = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.safe_dialog_content);
            this.j = textView;
            textView.setTextColor(getContext().getResources().getColor(R.color.nad_safe_dialog_message));
            SelectorTextView selectorTextView = (SelectorTextView) this.i.findViewById(R.id.safe_dialog_sub_content);
            this.k = selectorTextView;
            selectorTextView.setTextColor(getContext().getResources().getColor(R.color.nad_safe_dialog_btn_blue));
            o();
            return this.i;
        }
        return (View) invokeL.objValue;
    }

    public final void o() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (cVar = this.l) == null) {
            return;
        }
        this.j.setText(this.e.getText(cVar.g));
        this.j.setOnClickListener(new a(this));
        if (this.l.h > 0) {
            this.k.setVisibility(0);
            this.k.setText(this.e.getText(this.l.h));
            this.k.setOnClickListener(new b(this));
        } else {
            this.k.setVisibility(8);
        }
        if (this.l.i > 0) {
            Drawable drawable = this.e.getResources().getDrawable(this.l.i);
            qc1.c(getContext(), drawable);
            drawable.setBounds(0, 0, a41.c.a(this.e, 12.0f), a41.c.a(this.e, 12.0f));
            this.k.setCompoundDrawables(drawable, null, null, null);
        }
    }
}
