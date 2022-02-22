package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import c.a.u0.u2.i;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class PbNewsInfoHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View divide_line_up_pb_u9;
    public TextView pb_u9_text_view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbNewsInfoHolder(View view) {
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
        this.pb_u9_text_view = (TextView) view.findViewById(i.pb_u9_text_view);
        this.divide_line_up_pb_u9 = view.findViewById(i.divide_line_up_pb_u9);
    }
}
