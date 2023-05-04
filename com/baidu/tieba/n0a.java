package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.u05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n0a extends u05 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public ImageView b;
    public TextView c;
    public ViewGroup d;
    public TbCheckBox e;
    public TextView f;
    public Button g;
    public Button h;
    public ImageView i;
    public String j;
    public String k;
    public String l;
    public u05.e m;
    public String n;
    public u05.e o;
    public String p;
    public CompoundButton.OnCheckedChangeListener q;
    public boolean r;
    public TbCheckBox.b s;
    public final bg<tm> t;

    /* loaded from: classes5.dex */
    public class a implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n0a a;

        public a(n0a n0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n0aVar;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) && this.a.q != null) {
                this.a.q.onCheckedChanged(null, z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends bg<tm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n0a a;

        public b(n0a n0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n0aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        public void onLoaded(tm tmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, tmVar, str, i) == null) {
                super.onLoaded((b) tmVar, str, i);
                if (tmVar != null && tmVar.w()) {
                    this.a.b.setBackgroundResource(0);
                    this.a.b.setImageDrawable(null);
                    tmVar.h(this.a.b);
                    return;
                }
                this.a.b.setImageResource(R.drawable.obfuscated_res_0x7f0805c3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public c(n0a n0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a = z;
            }
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0a(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = false;
        this.s = new a(this);
        this.t = new b(this);
        c();
        setContentViewSize(1);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091bd2) {
            u05.e eVar = this.m;
            if (eVar != null) {
                eVar.onClick(this);
            }
        } else if (id == R.id.obfuscated_res_0x7f091808) {
            u05.e eVar2 = this.o;
            if (eVar2 != null) {
                eVar2.onClick(this);
            }
        } else if (id == R.id.obfuscated_res_0x7f0906f8) {
            dismiss();
        } else if (id == R.id.obfuscated_res_0x7f0906b5) {
            TbCheckBox tbCheckBox = this.e;
            tbCheckBox.setChecked(!tbCheckBox.d());
        }
    }

    public n0a e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.j = str;
            return this;
        }
        return (n0a) invokeL.objValue;
    }

    public n0a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (n0a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u05
    public /* bridge */ /* synthetic */ u05 setMessage(String str) {
        f(str);
        return this;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.obfuscated_res_0x7f0d025f, (ViewGroup) null);
            this.a = viewGroup;
            this.b = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090861);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09169d);
            Button button = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f091808);
            this.h = button;
            button.setOnClickListener(this);
            Button button2 = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f091bd2);
            this.g = button2;
            button2.setOnClickListener(this);
            ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0906f8);
            this.i = imageView;
            imageView.setOnClickListener(this);
            this.d = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0906b5);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0906b7);
            TbCheckBox tbCheckBox = (TbCheckBox) this.a.findViewById(R.id.obfuscated_res_0x7f0906b3);
            this.e = tbCheckBox;
            tbCheckBox.setBackgroundDrawableId(R.drawable.obfuscated_res_0x7f080797, R.drawable.obfuscated_res_0x7f080798);
            this.e.setStatedChangedListener(this.s);
            this.e.setTagData(new c(this));
            this.d.setClickable(true);
            this.d.setOnClickListener(this);
            setContentView(this.a);
        }
    }

    @Override // com.baidu.tieba.u05
    public u05 create(a9<?> a9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a9Var)) == null) {
            if (this.r) {
                return this;
            }
            this.r = true;
            super.create(a9Var);
            if (!hi.isEmpty(this.k)) {
                this.c.setText(this.k);
            }
            if (!hi.isEmpty(this.p)) {
                this.f.setText(this.p);
            } else {
                this.d.setVisibility(4);
            }
            if (!hi.isEmpty(this.n)) {
                this.h.setText(this.n);
            }
            if (!hi.isEmpty(this.l)) {
                this.g.setText(this.l);
            }
            if (!TextUtils.isEmpty(this.j)) {
                cg.h().m(this.j, 10, this.t, a9Var.getUniqueId());
            } else {
                this.b.setImageResource(R.drawable.obfuscated_res_0x7f0805c3);
            }
            getRealView().setBackgroundDrawable(null);
            return this;
        }
        return (u05) invokeL.objValue;
    }

    public n0a d(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, onCheckedChangeListener)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.p = activity.getResources().getString(i);
                this.q = onCheckedChangeListener;
            }
            return this;
        }
        return (n0a) invokeIL.objValue;
    }

    public n0a g(@StringRes int i, u05.e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.n = activity.getResources().getString(i);
                this.o = eVar;
            }
            return this;
        }
        return (n0a) invokeIL.objValue;
    }

    public n0a h(int i, u05.e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.l = activity.getResources().getString(i);
                this.m = eVar;
            }
            return this;
        }
        return (n0a) invokeIL.objValue;
    }

    public n0a i(String str, u05.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, eVar)) == null) {
            this.l = str;
            this.m = eVar;
            return this;
        }
        return (n0a) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.u05
    public /* bridge */ /* synthetic */ u05 setNegativeButton(@StringRes int i, u05.e eVar) {
        g(i, eVar);
        return this;
    }

    @Override // com.baidu.tieba.u05
    public /* bridge */ /* synthetic */ u05 setPositiveButton(int i, u05.e eVar) {
        h(i, eVar);
        return this;
    }

    @Override // com.baidu.tieba.u05
    public u05 setNegativeButton(String str, u05.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, eVar)) == null) {
            this.n = str;
            this.o = eVar;
            return this;
        }
        return (u05) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.u05
    public /* bridge */ /* synthetic */ u05 setPositiveButton(String str, u05.e eVar) {
        i(str, eVar);
        return this;
    }
}
