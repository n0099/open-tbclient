package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class iw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;

        public a(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Drawable maskDrawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(Boolean.valueOf(!((Boolean) view2.getTag()).booleanValue()));
                ImageView imageView = this.a;
                if (((Boolean) view2.getTag()).booleanValue()) {
                    maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
                } else {
                    maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
                }
                imageView.setImageDrawable(maskDrawable);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ FrsTabInfo b;
        public final /* synthetic */ FrsTabInfo c;

        public b(ImageView imageView, FrsTabInfo frsTabInfo, FrsTabInfo frsTabInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, frsTabInfo, frsTabInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageView;
            this.b = frsTabInfo;
            this.c = frsTabInfo2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SharedPrefHelper.getInstance().putBoolean("key_frs_move_area_tip", !((Boolean) this.a.getTag()).booleanValue());
                og7.h().m(this.b.tab_id.intValue(), this.c.tab_id.intValue());
            }
        }
    }

    public static void a(TbPageContext tbPageContext, FrsTabInfo frsTabInfo, FrsTabInfo frsTabInfo2) {
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, frsTabInfo, frsTabInfo2) == null) && frsTabInfo != null && frsTabInfo2 != null && tbPageContext != null && tbPageContext.getPageActivity() != null) {
            Activity pageActivity = tbPageContext.getPageActivity();
            LinearLayout linearLayout = new LinearLayout(pageActivity);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            linearLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X012), UtilHelper.getDimenPixelSize(R.dimen.M_H_X008), UtilHelper.getDimenPixelSize(R.dimen.M_W_X012), 0);
            ImageView imageView = new ImageView(pageActivity);
            imageView.setImageDrawable(SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null));
            linearLayout.addView(imageView, new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds39), UtilHelper.getDimenPixelSize(R.dimen.tbds39)));
            TextView textView = new TextView(pageActivity);
            textView.setText(R.string.no_tip_again);
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, 0, 0);
            EMManager.from(textView).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0108).setTextStyle(R.string.F_X01);
            linearLayout.addView(textView);
            imageView.setTag(Boolean.FALSE);
            imageView.setOnClickListener(new a(imageView));
            TBAlertBuilder title = new TBAlertBuilder(tbPageContext.getPageActivity()).setTitle(R.string.obfuscated_res_0x7f0f0856);
            if (frsTabInfo.is_general_tab.intValue() != 0 && frsTabInfo.tab_type.intValue() != 100) {
                String string = tbPageContext.getString(R.string.obfuscated_res_0x7f0f0854);
                String str = frsTabInfo.tab_name;
                format = String.format(string, str, frsTabInfo2.tab_name, str);
            } else {
                String string2 = tbPageContext.getString(R.string.obfuscated_res_0x7f0f0855);
                String str2 = frsTabInfo.tab_name;
                String str3 = frsTabInfo2.tab_name;
                format = String.format(string2, str2, str3, str2, str3);
            }
            title.setDescStr(format).setDescGravity(3).setDescLightStyle(true).setCustomContentView(linearLayout).setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.next_time, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0853, TBAlertConfig.OperateBtnStyle.MAIN, new b(imageView, frsTabInfo, frsTabInfo2))).setAutoClose().show();
        }
    }
}
