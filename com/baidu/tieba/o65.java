package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class o65 extends d65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void f(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, view2) == null) {
        }
    }

    public o65() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.d65
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            YunDialogManager.unMarkShowingDialogName("userGrowth");
        }
    }

    @Override // com.baidu.tieba.d65
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            YunDialogManager.markShowingDialogName("userGrowth");
        }
    }

    public static final void g(LevePopData levePopData, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, levePopData, view2) == null) {
            BrowserHelper.startWebActivity(view2.getContext(), (String) null, levePopData.getBtn_scheme(), true);
        }
    }

    @Override // com.baidu.tieba.d65
    public void b(TBAlertBuilder builder) {
        String cancel_btn_text;
        String btn_text;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, builder) == null) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            final LevePopData levePopData = TbSingleton.getInstance().getLevePopData();
            RelativeLayout relativeLayout = new RelativeLayout(getActivity());
            View view2 = new View(getActivity());
            EMManager.from(view2).setCardType(1).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds127));
            layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds149), 0, 0);
            relativeLayout.addView(view2, layoutParams);
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_usergrouth_home, WebPManager.ResourceStateType.NORMAL));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            relativeLayout.addView(imageView, layoutParams2);
            TBAlertBuilder customHeaderView = builder.setTitleStr(levePopData.getTitle()).setDescStr(levePopData.getDesc()).setDescLightStyle(true).setCustomHeaderView(relativeLayout);
            TBAlertConfig.OperateBtnConfig[] operateBtnConfigArr = new TBAlertConfig.OperateBtnConfig[2];
            if (StringUtils.isNull(levePopData.getCancel_btn_text())) {
                cancel_btn_text = TbadkCoreApplication.getInst().getString(R.string.guide_popup_window_known);
            } else {
                cancel_btn_text = levePopData.getCancel_btn_text();
            }
            operateBtnConfigArr[0] = new TBAlertConfig.OperateBtnConfig(cancel_btn_text, TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: com.baidu.tieba.a65
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        o65.f(view3);
                    }
                }
            });
            if (StringUtils.isNull(levePopData.getBtn_text())) {
                btn_text = TbadkCoreApplication.getInst().getString(R.string.check_detail);
            } else {
                btn_text = levePopData.getBtn_text();
            }
            operateBtnConfigArr[1] = new TBAlertConfig.OperateBtnConfig(btn_text, TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: com.baidu.tieba.c65
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        o65.g(LevePopData.this, view3);
                    }
                }
            });
            customHeaderView.setOperateBtn(operateBtnConfigArr).setCancelable(false).setAutoClose().show();
            PollingModel.setLevelPopData(levePopData, true);
        }
    }
}
