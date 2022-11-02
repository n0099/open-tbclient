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
/* loaded from: classes6.dex */
public class wi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv4 a;

        public a(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iv4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    public static void a(Activity activity, TbPageContext<?> tbPageContext) {
        int l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, activity, tbPageContext) == null) && activity != null && tbPageContext != null) {
            View inflate = LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d0311, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090cbf);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090cbc);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090cbd);
            TextView textView4 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090cbe);
            TextView textView5 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090cbb);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0922de);
            iv4 iv4Var = new iv4(activity);
            iv4Var.setContentView(inflate);
            iv4Var.setContentViewSize(2);
            iv4Var.setCanceledOnTouchOutside(true);
            iv4Var.setAutoNight(true);
            iv4Var.setCancelable(true);
            int g = xi.g(activity, R.dimen.tbds31);
            SkinManager.setBackgroundShapeDrawable(inflate, g, R.color.CAM_X0201, R.color.CAM_X0101);
            tbImageView.setRadius(g);
            tbImageView.setConrers(3);
            tbImageView.setIsBitmapPic(true);
            int g2 = xi.g(activity, R.dimen.tbds44);
            if (UtilHelper.getRealScreenOrientation(activity) == 2) {
                l = xi.j(activity);
            } else {
                l = xi.l(activity);
            }
            int i = l - (g2 * 2);
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
            textView5.setOnClickListener(new a(iv4Var));
            iv4Var.create(tbPageContext).show();
        }
    }
}
