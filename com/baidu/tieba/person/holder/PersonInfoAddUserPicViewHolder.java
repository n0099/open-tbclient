package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.o.e.n;
import c.a.p0.y2.i.c;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PersonInfoAddUserPicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35348b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35349c;

    /* renamed from: d  reason: collision with root package name */
    public int f35350d;

    /* renamed from: e  reason: collision with root package name */
    public n f35351e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f35352f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoAddUserPicViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        this.f35350d = 3;
        this.a = view.findViewById(R.id.obfuscated_res_0x7f090118);
        this.f35348b = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090111);
        this.f35349c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09201e);
    }

    public void c(n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) && (nVar instanceof c)) {
            this.f35351e = nVar;
            c cVar = (c) nVar;
            SkinManager.setImageResource(this.f35348b, R.drawable.icon_mine_pic_add);
            if (cVar.a() > 0) {
                this.f35349c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0813), Integer.valueOf(cVar.a())));
            }
            b().setOnClickListener(this.f35352f);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35351e : (n) invokeV.objValue;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.f35350d == i) {
            return;
        }
        SkinManager.setViewTextColor(this.f35349c, R.color.CAM_X0110, 1);
        SkinManager.setBackgroundColor(b(), R.color.CAM_X0205);
        this.f35350d = i;
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f35352f = onClickListener;
        }
    }
}
