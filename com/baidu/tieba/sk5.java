package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.adevent.AdEventType;
/* loaded from: classes7.dex */
public class sk5 implements tk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public ImageView b;
    public ImageView c;
    public TextView d;
    public LinearLayout e;

    @Override // com.baidu.tieba.tk5
    public void onClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public sk5(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_rule_copy, (ViewGroup) null);
        this.a = inflate;
        this.b = (ImageView) inflate.findViewById(R.id.floating_view_icon);
        this.d = (TextView) this.a.findViewById(R.id.floating_view_title);
        this.c = (ImageView) this.a.findViewById(R.id.floating_view_arrow);
        this.e = (LinearLayout) this.a.findViewById(R.id.floating_view_main);
        this.d.setText(R.string.frs_forum_rule_return_info);
        b();
    }

    @Override // com.baidu.tieba.tk5
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null) {
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0101);
            this.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right_n, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0302).setShape(0).setAlpha(AdEventType.VIDEO_LOADING).tlRadius(wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).blRadius(wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).into(this.e);
            this.b.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_manage_postdelete_cancel32, WebPManager.ResourceStateType.NORMAL));
        }
    }

    @Override // com.baidu.tieba.tk5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.a;
            if (view2 != null) {
                return view2;
            }
            return LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }
}
