package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.q0.r.v.c;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PbLoadMoreItemVideoViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f45162b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f45163c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbLoadMoreItemVideoViewHolder(View view) {
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
        this.f45162b = (RelativeLayout) view.findViewById(R.id.pb_check_video_more);
        TextView textView = (TextView) view.findViewById(R.id.pb_check_more_text);
        this.f45163c = textView;
        c d2 = c.d(textView);
        d2.z(R.dimen.T_X12);
        d2.A(R.string.F_X01);
        d2.v(R.color.CAM_X0107);
        this.f45162b.setVisibility(0);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.a.setOnClickListener(onClickListener);
        }
    }
}
