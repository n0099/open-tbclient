package com.baidu.tieba;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class rd1 extends od1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView f;
    public final TextView g;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ rd1 b;

        public a(rd1 rd1Var, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd1Var, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rd1Var;
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                aj0.c(this.a.h.d, this.b.getContext());
                u21.b(new ClogBuilder().y(ClogBuilder.LogType.CLICK).i(ClogBuilder.Area.BUTTON).p(this.a.f.d));
                gd1 gd1Var = this.b.d;
                if (gd1Var != null) {
                    gd1Var.b(this.a);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rd1(int i, View view2) {
        super(i, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = (TextView) a(R.id.feed_ad_operate_command_app_name);
        this.f = (TextView) a(R.id.nad_feed_ad_operate_command_button);
        k();
    }

    @Override // com.baidu.tieba.od1
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            od1.d(adBaseModel);
            k();
            String str = adBaseModel.h.b.a;
            if (!TextUtils.isEmpty(str)) {
                this.g.setText(str);
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
            this.f.setText(adBaseModel.h.c);
            if (!TextUtils.isEmpty(adBaseModel.h.d)) {
                this.f.setVisibility(0);
                this.f.setOnClickListener(new a(this, adBaseModel));
                return;
            }
            this.f.setVisibility(8);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !(b() instanceof AdBaseModel)) {
            return;
        }
        this.g.setTextColor(getResources().getColor(R.color.NAD_FC1));
        this.f.setTextColor(getResources().getColor(R.color.NAD_FC13));
        if (this.f.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) this.f.getBackground()).setColor(getResources().getColor(R.color.NAD_GC52));
            ((GradientDrawable) this.f.getBackground()).setStroke(2, getResources().getColor(R.color.NAD_GC53));
            return;
        }
        this.f.setBackground(getResources().getDrawable(R.drawable.nad_progress_button_bg));
    }
}
