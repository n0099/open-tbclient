package com.baidu.tieba.pb.pb.main;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.R;
import com.baidu.tieba.ao;
import com.baidu.tieba.ew4;
import com.baidu.tieba.ex4;
import com.baidu.tieba.f18;
import com.baidu.tieba.gw4;
import com.baidu.tieba.hx4;
import com.baidu.tieba.py4;
import com.baidu.tieba.s18;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbActivity extends AbsPbActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean v;
    public boolean w;
    @NonNull
    public final PriorityOrganizer x;

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d06e7 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements ao {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ PbActivity c;

        public a(PbActivity pbActivity, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbActivity;
            this.a = i;
            this.b = i2;
        }

        @Override // com.baidu.tieba.ao
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.A1(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ao {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ PbActivity c;

        public b(PbActivity pbActivity, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbActivity;
            this.a = i;
            this.b = i2;
        }

        @Override // com.baidu.tieba.ao
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.A1(this.a, this.b);
            }
        }
    }

    public PbActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = false;
        this.w = false;
        this.x = PriorityOrganizer.n();
    }

    @NonNull
    public PriorityOrganizer d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.x;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
            this.w = false;
            gw4.n(ew4.o);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONRESUME_STAMP_KEY);
            super.onResume();
            this.w = true;
            gw4.o(this, ew4.o);
        }
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public final void A1(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DRAW_DISPATCH_STAMP_KEY);
                int i3 = -1;
                if (hx4.a().c == 1) {
                    i3 = 8;
                }
                if (hx4.a().c == 2) {
                    i3 = 9;
                }
                SpeedStats.getInstance().onSchemeOrPushStatsEnd(this, i3, hx4.a().d);
            }
            long currentTimeMillis = System.currentTimeMillis() - g1();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_OPTIMIZE_LOAD_DURATION);
            statisticItem.addParam("obj_type", i2).addParam("obj_locate", i).addParam("obj_param1", currentTimeMillis).addParam(TiebaStatic.Params.OBJ_PARAM2, ex4.e());
            TiebaStatic.log(statisticItem);
        }
    }

    public void B1(int i, BdTypeRecyclerView bdTypeRecyclerView) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bdTypeRecyclerView) == null) && !this.v && j1() != null) {
            this.v = true;
            if (j1() != null && j1().R1() == 7) {
                i2 = 2;
            } else if (j1() != null && j1().z2()) {
                i2 = 1;
            } else {
                i2 = 3;
            }
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY);
            }
            bdTypeRecyclerView.y = new a(this, i, i2);
            bdTypeRecyclerView.w = true;
        }
    }

    public void C1(int i, s18 s18Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, s18Var) == null) && !this.v && j1() != null) {
            int i2 = 1;
            this.v = true;
            if (j1() != null && j1().R1() == 7) {
                i2 = 2;
            } else if (j1() == null || !j1().z2()) {
                i2 = 3;
            }
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY);
            }
            s18Var.j2(new b(this, i, i2));
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_END_STAMP_KEY);
            registerListener(new f18(this));
            y1();
        }
    }

    public final void y1() {
        boolean z;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (getIntent() != null && !getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false)) {
                return;
            }
            if (getIntent() != null) {
                z = getIntent().getBooleanExtra("key_jump_to_comment_area", false);
            } else {
                z = false;
            }
            String q = py4.k().q(py4.o("key_reaction_guide_show_pb_strategy"), "");
            int i = 0;
            for (String str : q.split(",")) {
                if ("1".equals(str)) {
                    i = (int) (i + Math.pow(2.0d, 0.0d));
                }
                if ("2".equals(str)) {
                    i = (int) (i + Math.pow(2.0d, 1.0d));
                }
                if ("3".equals(str)) {
                    i = (int) (i + Math.pow(2.0d, 2.0d));
                }
                if ("4".equals(str)) {
                    i = (int) (i + Math.pow(2.0d, 3.0d));
                }
            }
            if (i == 0) {
                if (z) {
                    py4.k().w(py4.o("key_reaction_guide_show_number_pb"), 3);
                    py4.k().y(py4.o("key_reaction_guide_show_pb_strategy"), q + "3,");
                    return;
                }
                py4.k().w(py4.o("key_reaction_guide_show_number_pb"), 1);
                py4.k().y(py4.o("key_reaction_guide_show_pb_strategy"), q + "1,");
            } else if (i == 1) {
                if (z) {
                    py4.k().w(py4.o("key_reaction_guide_show_number_pb"), 3);
                    py4.k().y(py4.o("key_reaction_guide_show_pb_strategy"), q + "3,");
                    return;
                }
                py4.k().w(py4.o("key_reaction_guide_show_number_pb"), 2);
                py4.k().y(py4.o("key_reaction_guide_show_pb_strategy"), q + "2,");
            } else if (i == 4) {
                py4.k().w(py4.o("key_reaction_guide_show_number_pb"), 1);
                py4.k().y(py4.o("key_reaction_guide_show_pb_strategy"), q + "1,");
            } else if (i == 5) {
                py4.k().w(py4.o("key_reaction_guide_show_number_pb"), 2);
                py4.k().y(py4.o("key_reaction_guide_show_pb_strategy"), q + "2,");
            } else if (i == 3) {
                py4.k().w(py4.o("key_reaction_guide_show_number_pb"), 3);
                py4.k().y(py4.o("key_reaction_guide_show_pb_strategy"), q + "3,");
            } else if (i == 7) {
                py4.k().w(py4.o("key_reaction_guide_show_number_pb"), 4);
                py4.k().y(py4.o("key_reaction_guide_show_pb_strategy"), q + "4");
            }
        }
    }
}
