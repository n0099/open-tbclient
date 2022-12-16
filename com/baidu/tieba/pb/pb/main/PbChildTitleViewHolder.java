package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.g08;
import com.baidu.tieba.rw4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbChildTitleViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public ViewGroup c;
    public TextView d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbChildTitleViewHolder(View view2) {
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
        this.a = view2;
        this.b = view2.findViewById(R.id.pb_child_title_top_line);
        this.c = (ViewGroup) view2.findViewById(R.id.rl_pb_child_title_area);
        TextView textView = (TextView) view2.findViewById(R.id.tv_pb_child_title);
        this.d = textView;
        rw4.d(textView).A(R.string.F_X02);
    }

    public void a(g08 g08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, g08Var) == null) {
            this.d.setText(g08Var.b());
        }
    }

    public void d(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (view2 = this.a) != null) {
            view2.setVisibility(i);
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
        }
    }
}
