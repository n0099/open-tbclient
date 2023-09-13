package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerAdapter;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wc6 extends no6<sb6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaBannerRecyclerView i;
    public AlaBannerRecyclerAdapter j;
    public View k;
    public View l;
    public TextView m;
    public int n;
    public int o;
    public int[] p;
    public boolean q;
    public ie6 r;

    @Override // com.baidu.tieba.no6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d095f : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements ie6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wc6 a;

        /* renamed from: com.baidu.tieba.wc6$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0516a extends AlaBannerViewHolder<SdkLiveInfoData> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public View a;
            public View b;
            public TabLiveStageLiveView c;
            public int d;
            public int e;
            public final /* synthetic */ a f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0516a(a aVar, View view2) {
                super(view2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                    this.c = (TabLiveStageLiveView) view2.findViewById(R.id.obfuscated_res_0x7f092302);
                    this.a = view2.findViewById(R.id.obfuscated_res_0x7f091e92);
                    this.b = view2.findViewById(R.id.obfuscated_res_0x7f091e93);
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                    this.c.c();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i, SdkLiveInfoData sdkLiveInfoData) {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048579, this, i, sdkLiveInfoData) == null) {
                    this.c.setData(sdkLiveInfoData, 102);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
                    if (i == 0) {
                        if (this.f.a.q) {
                            layoutParams.width = this.f.a.b.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            layoutParams2.width = this.f.a.b.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            this.b.setVisibility(0);
                        } else {
                            layoutParams.width = this.f.a.b.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            this.b.setVisibility(8);
                        }
                    } else {
                        layoutParams.width = this.f.a.b.getResources().getDimensionPixelSize(R.dimen.tbds12);
                        if (this.f.a.j.getItemCount() - 1 == i) {
                            this.b.setVisibility(0);
                        } else {
                            this.b.setVisibility(8);
                        }
                    }
                    this.a.setLayoutParams(layoutParams);
                    this.b.setLayoutParams(layoutParams2);
                    e();
                    StatisticItem statisticItem = new StatisticItem("c13558");
                    if (sdkLiveInfoData != null) {
                        SdkLiveInfoData.AlaLiveInfo alaLiveInfo = sdkLiveInfoData.liveInfo;
                        if (alaLiveInfo != null) {
                            int a = mb6.a(alaLiveInfo);
                            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData.liveInfo.yyExt;
                            if (yYExt != null) {
                                TiebaStaticHelper.addYYParam(statisticItem, mb6.j(yYExt, sdkLiveInfoData.roomId));
                                str = TiebaStatic.YYValues.YY_LIVE;
                            } else {
                                str = "";
                            }
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                        }
                        statisticItem.param("nid", sdkLiveInfoData.nid);
                        statisticItem.param("log_id", sdkLiveInfoData.logid);
                    }
                    statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
                    TiebaStatic.log(statisticItem);
                }
            }

            public final void e() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    this.d = this.f.a.y();
                    this.e = this.f.a.x();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.d, this.e);
                    } else {
                        layoutParams.width = this.d;
                        layoutParams.height = this.e;
                    }
                    layoutParams.gravity = 1;
                    this.c.setLayoutParams(layoutParams);
                }
            }
        }

        public a(wc6 wc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wc6Var;
        }

        @Override // com.baidu.tieba.ie6
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
                return new C0516a(this, LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0960, viewGroup, false));
            }
            return (AlaBannerViewHolder) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wc6(TbPageContext tbPageContext, ViewGroup viewGroup) {
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
        this.q = false;
        this.r = new a(this);
        this.q = false;
        int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(getContext()) * 0.76d);
        this.n = equipmentWidth;
        this.o = (int) ((equipmentWidth * 9.0d) / 16.0d);
        this.p = mb6.b(this.c);
        z();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.no6
    /* renamed from: A */
    public void i(sb6 sb6Var) {
        tb6 tb6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, sb6Var) == null) && sb6Var != null && (tb6Var = sb6Var.a) != null) {
            boolean z = true;
            if (ListUtils.getCount(tb6Var.a) != 1) {
                z = false;
            }
            this.q = z;
            B();
            this.j.setData(sb6Var.a.a);
            this.j.notifyDataSetChanged();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int x = x();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, x);
            } else {
                layoutParams.width = -1;
                layoutParams.height = x;
            }
            this.i.setLayoutParams(layoutParams);
        }
    }

    public final int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.q) {
                return this.p[1];
            }
            return this.o;
        }
        return invokeV.intValue;
    }

    public final int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.q) {
                return this.p[0];
            }
            return this.n;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.no6
    public void j(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = h().findViewById(R.id.obfuscated_res_0x7f091e91);
            this.m = (TextView) h().findViewById(R.id.obfuscated_res_0x7f091e94);
            this.l = h().findViewById(R.id.obfuscated_res_0x7f091e90);
            this.i = (AlaBannerRecyclerView) h().findViewById(R.id.obfuscated_res_0x7f091ed0);
            this.i.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            B();
            AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = new AlaBannerRecyclerAdapter(getContext(), this.r, false);
            this.j = alaBannerRecyclerAdapter;
            this.i.setAdapter(alaBannerRecyclerAdapter);
        }
    }
}
