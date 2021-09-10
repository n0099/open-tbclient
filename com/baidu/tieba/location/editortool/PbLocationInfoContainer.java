package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.f0.n.b;
import c.a.q0.x.a;
import c.a.q0.x.n;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes7.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f54031e;

    /* renamed from: f  reason: collision with root package name */
    public EditorTools f54032f;

    /* renamed from: g  reason: collision with root package name */
    public int f54033g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54034h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbLocationInfoContainer(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54033g = 0;
        this.f54034h = true;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setGravity(16);
            setOrientation(0);
            RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, l.g(getContext(), R.dimen.ds48));
            layoutParams.setMargins(0, l.g(getContext(), R.dimen.ds30), 0, l.g(getContext(), R.dimen.ds12));
            setLayoutParams(layoutParams);
            b bVar = new b();
            bVar.o(R.color.CAM_X0209, R.color.CAM_X0105);
            bVar.h(R.color.CAM_X0110);
            bVar.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            bVar.l(l.g(getContext(), R.dimen.M_W_X004), l.g(getContext(), R.dimen.M_W_X004));
            bVar.m(l.g(getContext(), R.dimen.M_H_X002));
            bVar.i(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
            bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.f54031e = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f54031e.setTextSize(R.dimen.tbds32);
            this.f54031e.setOnClickListener(this);
            this.f54031e.setText(getContext().getString(R.string.location_where_are_you));
            addView(this.f54031e, new LinearLayout.LayoutParams(-2, l.g(getContext(), R.dimen.tbds63)));
        }
    }

    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f54031e.changeSkinType(i2);
        }
    }

    @Override // c.a.q0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f54034h) {
            this.f54034h = false;
            sendAction(new a(18, -1, "first"));
        }
    }

    @Override // c.a.q0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54033g : invokeV.intValue;
    }

    @Override // c.a.q0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f54031e.setText(getContext().getString(R.string.location_where_are_you));
        }
    }

    @Override // c.a.q0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // c.a.q0.x.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f15079a;
        if (i2 != 19) {
            if (i2 == 20) {
                hide();
                return;
            }
            return;
        }
        Object obj = aVar.f15081c;
        if (obj == null) {
            hide();
            return;
        }
        c.a.q0.x.u.a aVar2 = (c.a.q0.x.u.a) obj;
        if (aVar2.f15106a == 1) {
            this.f54031e.setText(getContext().getString(R.string.location_loading));
        } else if (!TextUtils.isEmpty(aVar2.f15107b)) {
            this.f54031e.setText(aVar2.f15107b);
        } else {
            this.f54031e.setText(getContext().getString(R.string.location_where_are_you));
        }
    }

    @Override // c.a.q0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            changeSkinType(i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) && view == this.f54031e) {
            sendAction(new a(18, -1, null));
        }
    }

    @Override // c.a.q0.x.n
    public void sendAction(a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || (editorTools = this.f54032f) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // c.a.q0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editorTools) == null) {
            this.f54032f = editorTools;
        }
    }

    @Override // c.a.q0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f54033g = i2;
        }
    }
}
