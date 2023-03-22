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
import com.baidu.tieba.b25;
import com.baidu.tieba.bm8;
import com.baidu.tieba.e25;
import com.baidu.tieba.jn;
import com.baidu.tieba.m35;
import com.baidu.tieba.om8;
import com.baidu.tieba.v05;
import com.baidu.tieba.w05;
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
    public int G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0728 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements jn {
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

        @Override // com.baidu.tieba.jn
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.a2(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements jn {
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

        @Override // com.baidu.tieba.jn
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.a2(this.a, this.b);
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
        this.x = PriorityOrganizer.h();
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            this.w = false;
            w05.m(v05.o);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONRESUME_STAMP_KEY);
            super.onResume();
            this.w = true;
            w05.n(this, v05.o);
        }
    }

    @NonNull
    public PriorityOrganizer r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.x;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    public final void Y1() {
        boolean z;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (getIntent() != null && !getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false)) {
                return;
            }
            if (getIntent() != null) {
                z = getIntent().getBooleanExtra("key_jump_to_comment_area", false);
            } else {
                z = false;
            }
            String s = m35.m().s(m35.q("key_reaction_guide_show_pb_strategy"), "");
            int i = 0;
            for (String str : s.split(",")) {
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
                    m35.m().z(m35.q("key_reaction_guide_show_number_pb"), 3);
                    m35.m().B(m35.q("key_reaction_guide_show_pb_strategy"), s + "3,");
                    return;
                }
                m35.m().z(m35.q("key_reaction_guide_show_number_pb"), 1);
                m35.m().B(m35.q("key_reaction_guide_show_pb_strategy"), s + "1,");
            } else if (i == 1) {
                if (z) {
                    m35.m().z(m35.q("key_reaction_guide_show_number_pb"), 3);
                    m35.m().B(m35.q("key_reaction_guide_show_pb_strategy"), s + "3,");
                    return;
                }
                m35.m().z(m35.q("key_reaction_guide_show_number_pb"), 2);
                m35.m().B(m35.q("key_reaction_guide_show_pb_strategy"), s + "2,");
            } else if (i == 4) {
                m35.m().z(m35.q("key_reaction_guide_show_number_pb"), 1);
                m35.m().B(m35.q("key_reaction_guide_show_pb_strategy"), s + "1,");
            } else if (i == 5) {
                m35.m().z(m35.q("key_reaction_guide_show_number_pb"), 2);
                m35.m().B(m35.q("key_reaction_guide_show_pb_strategy"), s + "2,");
            } else if (i == 3) {
                m35.m().z(m35.q("key_reaction_guide_show_number_pb"), 3);
                m35.m().B(m35.q("key_reaction_guide_show_pb_strategy"), s + "3,");
            } else if (i == 7) {
                m35.m().z(m35.q("key_reaction_guide_show_number_pb"), 4);
                m35.m().B(m35.q("key_reaction_guide_show_pb_strategy"), s + "4");
            }
        }
    }

    public final void a2(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DRAW_DISPATCH_STAMP_KEY);
                int i3 = -1;
                if (e25.a().c == 1) {
                    i3 = 8;
                }
                if (e25.a().c == 2) {
                    i3 = 9;
                }
                SpeedStats.getInstance().onSchemeOrPushStatsEnd(this, i3, e25.a().d);
            }
            long currentTimeMillis = System.currentTimeMillis() - H1();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_OPTIMIZE_LOAD_DURATION);
            statisticItem.addParam("obj_type", i2).addParam("obj_locate", i).addParam("obj_param1", currentTimeMillis).addParam(TiebaStatic.Params.OBJ_PARAM2, b25.e());
            TiebaStatic.log(statisticItem);
        }
    }

    public void b2(int i, BdTypeRecyclerView bdTypeRecyclerView) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048582, this, i, bdTypeRecyclerView) == null) && !this.v && K1() != null) {
            this.v = true;
            if (K1() != null && K1().v1() == 7) {
                i2 = 2;
            } else if (K1() != null && K1().g2()) {
                i2 = 1;
            } else {
                i2 = 3;
            }
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY);
            }
            bdTypeRecyclerView.onListSecondDispatchDraw = new a(this, i, i2);
            bdTypeRecyclerView.isDataSet = true;
        }
    }

    public void c2(int i, om8 om8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, om8Var) == null) && !this.v && K1() != null) {
            int i2 = 1;
            this.v = true;
            if (K1() != null && K1().v1() == 7) {
                i2 = 2;
            } else if (K1() == null || !K1().g2()) {
                i2 = 3;
            }
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY);
            }
            om8Var.q2(new b(this, i, i2));
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_END_STAMP_KEY);
            registerListener(new bm8(this));
            Y1();
        }
    }
}
