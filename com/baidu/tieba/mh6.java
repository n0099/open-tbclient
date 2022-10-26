package com.baidu.tieba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;

        public a(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pu4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    public static void a(Activity activity, TbPageContext tbPageContext) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, activity, tbPageContext) == null) && activity != null && tbPageContext != null) {
            View inflate = LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d030f, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090ca0);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c9d);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c9e);
            TextView textView4 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c9f);
            TextView textView5 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c9c);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09228b);
            pu4 pu4Var = new pu4(activity);
            pu4Var.setContentView(inflate);
            pu4Var.setContentViewSize(2);
            pu4Var.setCanceledOnTouchOutside(true);
            pu4Var.setAutoNight(true);
            pu4Var.setCancelable(true);
            int f = fj.f(activity, R.dimen.tbds31);
            SkinManager.setBackgroundShapeDrawable(inflate, f, R.color.CAM_X0201, R.color.CAM_X0101);
            tbImageView.setRadius(f);
            tbImageView.setConrers(3);
            tbImageView.setIsBitmapPic(true);
            int f2 = fj.f(activity, R.dimen.tbds44);
            if (UtilHelper.getRealScreenOrientation(activity) == 2) {
                k = fj.i(activity);
            } else {
                k = fj.k(activity);
            }
            int i = k - (f2 * 2);
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = (i * 556) / 988;
            tbImageView.setLayoutParams(layoutParams);
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080593);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(textView4, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(textView5, (int) R.color.CAM_X0302);
            textView5.setOnClickListener(new a(pu4Var));
            pu4Var.create(tbPageContext).show();
        }
    }
}
