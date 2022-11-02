package com.baidu.ufosdk;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
/* loaded from: classes6.dex */
public class o0 implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ d1 a;
    public final /* synthetic */ FeedbackEditActivity b;

    public o0(FeedbackEditActivity feedbackEditActivity, d1 d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity, d1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = feedbackEditActivity;
        this.a = d1Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            FeedbackEditActivity feedbackEditActivity = this.b;
            feedbackEditActivity.B = i;
            feedbackEditActivity.R.setVisibility(0);
            this.b.S.setText(this.a.b[i]);
            this.b.P.setVisibility(8);
            FeedbackEditActivity feedbackEditActivity2 = this.b;
            feedbackEditActivity2.j.setText(feedbackEditActivity2.H);
            this.b.i.setVisibility(0);
        }
    }
}
