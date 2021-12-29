package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.s0.s.u.c;
import c.a.t0.s2.f;
import c.a.t0.s2.i;
import c.a.t0.s2.l;
import c.a.t0.s2.r.e;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PbChildTitleViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f48246b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f48247c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f48248d;

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
        this.a = view;
        this.f48246b = view.findViewById(i.pb_child_title_top_line);
        this.f48247c = (ViewGroup) view.findViewById(i.rl_pb_child_title_area);
        TextView textView = (TextView) view.findViewById(i.tv_pb_child_title);
        this.f48248d = textView;
        c.d(textView).A(l.F_X02);
    }

    public void bindData(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f48248d.setText(eVar.d());
        }
    }

    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.f48246b, f.CAM_X0204);
            SkinManager.setBackgroundColor(this.f48247c, f.CAM_X0205);
            SkinManager.setViewTextColor(this.f48248d, f.CAM_X0105);
        }
    }

    public void setViewVisibility(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (view = this.a) == null) {
            return;
        }
        view.setVisibility(i2);
    }
}
