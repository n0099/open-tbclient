package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.u.c;
import d.a.q0.h2.h.d;
/* loaded from: classes4.dex */
public class PbChildTitleViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f19282a;

    /* renamed from: b  reason: collision with root package name */
    public View f19283b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f19284c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19285d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbChildTitleViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19282a = view;
        this.f19283b = view.findViewById(R.id.pb_child_title_top_line);
        this.f19284c = (ViewGroup) view.findViewById(R.id.rl_pb_child_title_area);
        TextView textView = (TextView) view.findViewById(R.id.tv_pb_child_title);
        this.f19285d = textView;
        c.d(textView).y(R.string.F_X02);
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.f19285d.setText(dVar.c());
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19282a : (View) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.f19283b, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f19284c, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f19285d, R.color.CAM_X0105);
        }
    }

    public void e(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (view = this.f19282a) == null) {
            return;
        }
        view.setVisibility(i2);
    }
}
