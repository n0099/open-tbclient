package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.k29;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u49 extends r49<CustomDialogData> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomDialogData c;
    public v49 d;
    public TbImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public View j;
    public View k;
    public LinearLayout l;

    @Override // com.baidu.tieba.w49
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.custom_dailog_view : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u49(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.w49
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
            this.f = (TextView) getViewGroup().findViewById(R.id.obfuscated_res_0x7f0908b0);
            this.g = (TextView) getViewGroup().findViewById(R.id.dialog_body);
            this.h = (TextView) getViewGroup().findViewById(R.id.obfuscated_res_0x7f0929a9);
            this.i = (TextView) getViewGroup().findViewById(R.id.obfuscated_res_0x7f0918d0);
            this.j = getViewGroup().findViewById(R.id.bdDialog_divider_line);
            this.k = getViewGroup().findViewById(R.id.divider_yes_no_button);
            this.l = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
            this.h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            SkinManager.setBackgroundResource(this.h, R.drawable.dialog_single_button_bg_selector);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.g, (int) R.color.common_color_10122);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.l, R.drawable.dialog_background);
        }
    }

    public void f(v49 v49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, v49Var) == null) {
            this.d = v49Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w49
    /* renamed from: e */
    public void c(CustomDialogData customDialogData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, customDialogData) != null) || customDialogData == null) {
            return;
        }
        this.c = customDialogData;
        CustomDialogData.Head head = customDialogData.head;
        if (!TextUtils.isEmpty(head.imageUrl)) {
            this.e.N(head.imageUrl, 10, false);
        }
        if (!TextUtils.isEmpty(head.text)) {
            this.f.setText(head.text);
        }
        if (!TextUtils.isEmpty(customDialogData.body)) {
            this.g.setText(customDialogData.body);
        }
        CustomDialogData.Button button = customDialogData.leftButton;
        if (button != null && !StringUtils.isNull(button.text)) {
            this.i.setText(customDialogData.leftButton.text);
        }
        CustomDialogData.Button button2 = customDialogData.rightButton;
        if (button2 != null && !StringUtils.isNull(button2.text)) {
            this.h.setText(customDialogData.rightButton.text);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        CustomDialogData.Button button;
        CustomDialogData.Button button2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2 == this.h) {
                CustomDialogData customDialogData = this.c;
                if (customDialogData != null && (button2 = customDialogData.rightButton) != null && !StringUtils.isNull(button2.action)) {
                    UrlManager.getInstance().dealOneLink(d(), new String[]{this.c.rightButton.action});
                }
                v49 v49Var = this.d;
                if (v49Var != null) {
                    v49Var.dismiss();
                }
                StatisticItem statisticItem = new StatisticItem(k29.a.b);
                statisticItem.param("obj_locate", 2);
                TiebaStatic.log(statisticItem);
            } else if (view2 == this.i) {
                CustomDialogData customDialogData2 = this.c;
                if (customDialogData2 != null && (button = customDialogData2.leftButton) != null && !StringUtils.isNull(button.action)) {
                    qx4.v(this.a.getPageActivity(), null, this.c.leftButton.action, true);
                }
                v49 v49Var2 = this.d;
                if (v49Var2 != null) {
                    v49Var2.dismiss();
                }
                StatisticItem statisticItem2 = new StatisticItem(k29.a.b);
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
            }
        }
    }
}
