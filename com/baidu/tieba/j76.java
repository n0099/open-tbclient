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
/* loaded from: classes6.dex */
public class j76 extends cj6<f66> {
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
    public v86 r;

    @Override // com.baidu.tieba.cj6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d094e : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements v86 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j76 a;

        /* renamed from: com.baidu.tieba.j76$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0353a extends AlaBannerViewHolder<SdkLiveInfoData> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public View a;
            public View b;
            public TabLiveStageLiveView c;
            public int d;
            public int e;
            public final /* synthetic */ a f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0353a(a aVar, View view2) {
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
                    this.c = (TabLiveStageLiveView) view2.findViewById(R.id.obfuscated_res_0x7f0922d7);
                    this.a = view2.findViewById(R.id.obfuscated_res_0x7f091e7e);
                    this.b = view2.findViewById(R.id.obfuscated_res_0x7f091e7f);
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
                            int a = z56.a(alaLiveInfo);
                            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData.liveInfo.yyExt;
                            if (yYExt != null) {
                                TiebaStaticHelper.addYYParam(statisticItem, z56.j(yYExt, sdkLiveInfoData.roomId));
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
                    this.d = this.f.a.z();
                    this.e = this.f.a.y();
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

        public a(j76 j76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j76Var;
        }

        @Override // com.baidu.tieba.v86
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
                return new C0353a(this, LayoutInflater.from(this.a.c()).inflate(R.layout.obfuscated_res_0x7f0d094f, viewGroup, false));
            }
            return (AlaBannerViewHolder) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j76(TbPageContext tbPageContext, ViewGroup viewGroup) {
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
        int equipmentWidth = (int) (BdUtilHelper.getEquipmentWidth(c()) * 0.76d);
        this.n = equipmentWidth;
        this.o = (int) ((equipmentWidth * 9.0d) / 16.0d);
        this.p = z56.b(this.c);
        A();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k = i().findViewById(R.id.obfuscated_res_0x7f091e7d);
            this.m = (TextView) i().findViewById(R.id.obfuscated_res_0x7f091e80);
            this.l = i().findViewById(R.id.obfuscated_res_0x7f091e7c);
            this.i = (AlaBannerRecyclerView) i().findViewById(R.id.obfuscated_res_0x7f091ebc);
            this.i.setLayoutManager(new LinearLayoutManager(c(), 0, false));
            C();
            AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = new AlaBannerRecyclerAdapter(c(), this.r, false);
            this.j = alaBannerRecyclerAdapter;
            this.i.setAdapter(alaBannerRecyclerAdapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cj6
    /* renamed from: B */
    public void j(f66 f66Var) {
        g66 g66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f66Var) == null) && f66Var != null && (g66Var = f66Var.a) != null) {
            boolean z = true;
            if (ListUtils.getCount(g66Var.a) != 1) {
                z = false;
            }
            this.q = z;
            C();
            this.j.setData(f66Var.a.a);
            this.j.notifyDataSetChanged();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int y = y();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, y);
            } else {
                layoutParams.width = -1;
                layoutParams.height = y;
            }
            this.i.setLayoutParams(layoutParams);
        }
    }

    public final int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.q) {
                return this.p[1];
            }
            return this.o;
        }
        return invokeV.intValue;
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.q) {
                return this.p[0];
            }
            return this.n;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.cj6
    public void k(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
        }
    }
}
