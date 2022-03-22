package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.l0.n.b;
import c.a.o0.w.a;
import c.a.o0.w.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn a;

    /* renamed from: b  reason: collision with root package name */
    public EditorTools f34329b;

    /* renamed from: c  reason: collision with root package name */
    public int f34330c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34331d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbLocationInfoContainer(Context context) {
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
        this.f34330c = 0;
        this.f34331d = true;
        c();
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.a.l(i);
        }
    }

    @Override // c.a.o0.w.n
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f34331d) {
            this.f34331d = false;
            d(new a(18, -1, Config.TRACE_VISIT_FIRST));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setGravity(16);
            setOrientation(0);
            RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702c4));
            layoutParams.setMargins(0, c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f070201), 0, c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f070234));
            setLayoutParams(layoutParams);
            b bVar = new b();
            bVar.p(R.color.CAM_X0209, R.color.CAM_X0105);
            bVar.h(R.color.CAM_X0110);
            bVar.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            bVar.m(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X004), c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X004));
            bVar.n(c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X002));
            bVar.i(R.drawable.obfuscated_res_0x7f080610, 0, TBSpecificationButtonConfig.IconType.WEBP);
            bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.a = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.a.setTextSize(R.dimen.tbds32);
            this.a.setOnClickListener(this);
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a48));
            addView(this.a, new LinearLayout.LayoutParams(-2, c.a.d.f.p.n.f(getContext(), R.dimen.tbds63)));
        }
    }

    @Override // c.a.o0.w.n
    public void d(a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || (editorTools = this.f34329b) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    @Override // c.a.o0.w.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34330c : invokeV.intValue;
    }

    @Override // c.a.o0.w.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a48));
        }
    }

    @Override // c.a.o0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // c.a.o0.w.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null) {
            return;
        }
        int i = aVar.a;
        if (i != 19) {
            if (i == 20) {
                hide();
                return;
            }
            return;
        }
        Object obj = aVar.f11499c;
        if (obj == null) {
            hide();
            return;
        }
        c.a.o0.w.w.a aVar2 = (c.a.o0.w.w.a) obj;
        if (aVar2.a == 1) {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a42));
        } else if (!TextUtils.isEmpty(aVar2.f11528b)) {
            this.a.setText(aVar2.f11528b);
        } else {
            this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a48));
        }
    }

    @Override // c.a.o0.w.n
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            a(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view) == null) && view == this.a) {
            d(new a(18, -1, null));
        }
    }

    @Override // c.a.o0.w.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editorTools) == null) {
            this.f34329b = editorTools;
        }
    }

    @Override // c.a.o0.w.n
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f34330c = i;
        }
    }
}
