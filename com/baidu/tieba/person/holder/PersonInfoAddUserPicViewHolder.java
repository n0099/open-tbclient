package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.repackage.h18;
import com.repackage.ro;
/* loaded from: classes3.dex */
public class PersonInfoAddUserPicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public ImageView b;
    public TextView c;
    public int d;
    public ro e;
    public View.OnClickListener f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoAddUserPicViewHolder(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
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
        this.d = 3;
        this.a = view2.findViewById(R.id.obfuscated_res_0x7f090117);
        this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090110);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092064);
    }

    public void c(ro roVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, roVar) == null) && (roVar instanceof h18)) {
            this.e = roVar;
            h18 h18Var = (h18) roVar;
            SkinManager.setImageResource(this.b, R.drawable.icon_mine_pic_add);
            if (h18Var.a() > 0) {
                this.c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f081c), Integer.valueOf(h18Var.a())));
            }
            b().setOnClickListener(this.f);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public ro d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (ro) invokeV.objValue;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.d == i) {
            return;
        }
        SkinManager.setViewTextColor(this.c, R.color.CAM_X0110, 1);
        SkinManager.setBackgroundColor(b(), R.color.CAM_X0205);
        this.d = i;
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }
}
