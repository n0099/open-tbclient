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
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.hz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xpa extends hz4 implements View.OnClickListener {
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
    public hz4.e m;
    public String n;
    public hz4.e o;
    public String p;
    public CompoundButton.OnCheckedChangeListener q;
    public boolean r;
    public TbCheckBox.b s;
    public final BdResourceCallback<BdImage> t;

    /* loaded from: classes8.dex */
    public class a implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xpa a;

        public a(xpa xpaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xpaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xpaVar;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) && this.a.q != null) {
                this.a.q.onCheckedChanged(null, z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xpa a;

        public b(xpa xpaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xpaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xpaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                super.onLoaded((b) bdImage, str, i);
                if (bdImage != null && bdImage.isValidNow()) {
                    this.a.b.setBackgroundResource(0);
                    this.a.b.setImageDrawable(null);
                    bdImage.drawImageTo(this.a.b);
                    return;
                }
                this.a.b.setImageResource(R.drawable.obfuscated_res_0x7f0806e2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public c(xpa xpaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xpaVar};
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
    public xpa(Activity activity) {
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
        if (id == R.id.obfuscated_res_0x7f091d26) {
            hz4.e eVar = this.m;
            if (eVar != null) {
                eVar.onClick(this);
            }
        } else if (id == R.id.obfuscated_res_0x7f091941) {
            hz4.e eVar2 = this.o;
            if (eVar2 != null) {
                eVar2.onClick(this);
            }
        } else if (id == R.id.obfuscated_res_0x7f09073b) {
            dismiss();
        } else if (id == R.id.obfuscated_res_0x7f0906f8) {
            TbCheckBox tbCheckBox = this.e;
            tbCheckBox.setChecked(!tbCheckBox.d());
        }
    }

    public xpa e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.j = str;
            return this;
        }
        return (xpa) invokeL.objValue;
    }

    public xpa f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (xpa) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hz4
    public /* bridge */ /* synthetic */ hz4 setMessage(String str) {
        f(str);
        return this;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.obfuscated_res_0x7f0d0286, (ViewGroup) null);
            this.a = viewGroup;
            this.b = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0908ac);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091767);
            Button button = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f091941);
            this.h = button;
            button.setOnClickListener(this);
            Button button2 = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f091d26);
            this.g = button2;
            button2.setOnClickListener(this);
            ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09073b);
            this.i = imageView;
            imageView.setOnClickListener(this);
            this.d = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0906f8);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0906fa);
            TbCheckBox tbCheckBox = (TbCheckBox) this.a.findViewById(R.id.obfuscated_res_0x7f0906f6);
            this.e = tbCheckBox;
            tbCheckBox.setBackgroundDrawableId(R.drawable.obfuscated_res_0x7f080903, R.drawable.obfuscated_res_0x7f080904);
            this.e.setStatedChangedListener(this.s);
            this.e.setTagData(new c(this));
            this.d.setClickable(true);
            this.d.setOnClickListener(this);
            setContentView(this.a);
        }
    }

    @Override // com.baidu.tieba.hz4
    public hz4 create(BdPageContext<?> bdPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdPageContext)) == null) {
            if (this.r) {
                return this;
            }
            this.r = true;
            super.create(bdPageContext);
            if (!ad.isEmpty(this.k)) {
                this.c.setText(this.k);
            }
            if (!ad.isEmpty(this.p)) {
                this.f.setText(this.p);
            } else {
                this.d.setVisibility(4);
            }
            if (!ad.isEmpty(this.n)) {
                this.h.setText(this.n);
            }
            if (!ad.isEmpty(this.l)) {
                this.g.setText(this.l);
            }
            if (!TextUtils.isEmpty(this.j)) {
                BdResourceLoader.getInstance().loadResource(this.j, 10, this.t, bdPageContext.getUniqueId());
            } else {
                this.b.setImageResource(R.drawable.obfuscated_res_0x7f0806e2);
            }
            getRealView().setBackgroundDrawable(null);
            return this;
        }
        return (hz4) invokeL.objValue;
    }

    public xpa d(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
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
        return (xpa) invokeIL.objValue;
    }

    public xpa g(@StringRes int i, hz4.e eVar) {
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
        return (xpa) invokeIL.objValue;
    }

    public xpa h(int i, hz4.e eVar) {
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
        return (xpa) invokeIL.objValue;
    }

    public xpa i(String str, hz4.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, eVar)) == null) {
            this.l = str;
            this.m = eVar;
            return this;
        }
        return (xpa) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.hz4
    public /* bridge */ /* synthetic */ hz4 setNegativeButton(@StringRes int i, hz4.e eVar) {
        g(i, eVar);
        return this;
    }

    @Override // com.baidu.tieba.hz4
    public /* bridge */ /* synthetic */ hz4 setPositiveButton(int i, hz4.e eVar) {
        h(i, eVar);
        return this;
    }

    @Override // com.baidu.tieba.hz4
    public hz4 setNegativeButton(String str, hz4.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, eVar)) == null) {
            this.n = str;
            this.o = eVar;
            return this;
        }
        return (hz4) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.hz4
    public /* bridge */ /* synthetic */ hz4 setPositiveButton(String str, hz4.e eVar) {
        i(str, eVar);
        return this;
    }
}
