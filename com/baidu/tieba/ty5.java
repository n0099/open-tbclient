package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ty5 extends a86<rx5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TabLiveStageLiveView j;
    public int k;

    @Override // com.baidu.tieba.a86
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0873 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ty5(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 0;
        r();
    }

    @Override // com.baidu.tieba.a86
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(h(), R.color.CAM_X0201);
            TabLiveStageLiveView tabLiveStageLiveView = this.j;
            if (tabLiveStageLiveView != null) {
                tabLiveStageLiveView.c();
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i = h();
            int[] b = ix5.b(getContext());
            int i = b[0];
            int i2 = b[1];
            TabLiveStageLiveView tabLiveStageLiveView = (TabLiveStageLiveView) this.i.findViewById(R.id.obfuscated_res_0x7f09205c);
            this.j = tabLiveStageLiveView;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tabLiveStageLiveView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(i, i2);
            } else {
                layoutParams.width = i;
                layoutParams.height = i2;
            }
            layoutParams.gravity = 1;
            this.j.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a86
    /* renamed from: s */
    public void i(rx5 rx5Var) {
        SdkLiveInfoData sdkLiveInfoData;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, rx5Var) == null) && rx5Var != null && rx5Var.a != null) {
            int l = zi.l(this.c);
            if (l != this.k) {
                int[] b = ix5.b(getContext());
                int i = b[0];
                int i2 = b[1];
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.j.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
                this.j.setLayoutParams(layoutParams);
                this.k = l;
            }
            this.j.setData(rx5Var.a.a, 101);
            StatisticItem statisticItem = new StatisticItem("c13551");
            sx5 sx5Var = rx5Var.a;
            if (sx5Var != null && (sdkLiveInfoData = sx5Var.a) != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null) {
                int a = ix5.a(alaLiveInfo);
                SdkLiveInfoData sdkLiveInfoData2 = rx5Var.a.a;
                SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData2.liveInfo.yyExt;
                if (yYExt != null) {
                    TiebaStaticHelper.addYYParam(statisticItem, ix5.j(yYExt, sdkLiveInfoData2.roomId));
                    str = TiebaStatic.YYValues.YY_LIVE;
                } else {
                    str = "";
                }
                statisticItem.param("obj_param1", a);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
            }
            statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
            statisticItem.param("nid", rx5Var.a.a.nid);
            statisticItem.param(TiebaStatic.Params.LOGID, rx5Var.a.a.logid);
            TiebaStatic.log(statisticItem);
        }
    }
}
