package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
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
import com.baidu.tieba.cq4;
import com.baidu.tieba.dq4;
import com.baidu.tieba.f55;
import com.baidu.tieba.hz8;
import com.baidu.tieba.ln;
import com.baidu.tieba.pb.fragment.VideoFragmentController;
import com.baidu.tieba.q15;
import com.baidu.tieba.qv8;
import com.baidu.tieba.r15;
import com.baidu.tieba.tz8;
import com.baidu.tieba.u35;
import com.baidu.tieba.x35;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbActivity extends AbsPbActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean u;
    public boolean v;
    @NonNull
    public final PriorityOrganizer w;
    public final VideoFragmentController x;

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d0732 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements ln {
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

        @Override // com.baidu.tieba.ln
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b2(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ln {
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

        @Override // com.baidu.tieba.ln
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b2(this.a, this.b);
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
        this.u = false;
        this.v = false;
        this.w = PriorityOrganizer.o();
        this.x = new VideoFragmentController();
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONRESUME_STAMP_KEY);
            super.onResume();
            this.v = true;
            r15.o(this, q15.o);
            if (Z1()) {
                this.x.o(true);
                dq4.w().Q(cq4.c0, this.x.d().c());
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (Z1()) {
                this.x.d().d(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public Fragment C1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if ("video_pb_fragment_tag".equals(str)) {
                registerListener(this.x.f());
                this.x.i(this);
                return this.x.d().b();
            }
            return super.C1(str);
        }
        return (Fragment) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public void D1(qv8 qv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qv8Var) == null) {
            super.D1(qv8Var);
            if (this.a != null && a2(qv8Var)) {
                this.a.v3(qv8Var);
                this.b.setArguments(this.x.g(qv8Var));
                this.x.l();
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public String I1(qv8 qv8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, qv8Var)) == null) {
            if (qv8Var != null && qv8Var.v0()) {
                return "video_pb_fragment_tag";
            }
            return super.I1(qv8Var);
        }
        return (String) invokeL.objValue;
    }

    public final boolean a2(qv8 qv8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, qv8Var)) == null) {
            return "video_pb_fragment_tag".equals(I1(qv8Var));
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            super.onChangeSkinType(i);
            if (Z1()) {
                this.x.j(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (Z1()) {
                this.x.k(configuration);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_END_STAMP_KEY);
            registerListener(new hz8(this));
            X1();
        }
    }

    public final void X1() {
        boolean z;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (getIntent() != null && !getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false)) {
                return;
            }
            if (getIntent() != null) {
                z = getIntent().getBooleanExtra("key_jump_to_comment_area", false);
            } else {
                z = false;
            }
            String s = f55.m().s(f55.q("key_reaction_guide_show_pb_strategy"), "");
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
                    f55.m().z(f55.q("key_reaction_guide_show_number_pb"), 3);
                    f55.m().B(f55.q("key_reaction_guide_show_pb_strategy"), s + "3,");
                    return;
                }
                f55.m().z(f55.q("key_reaction_guide_show_number_pb"), 1);
                f55.m().B(f55.q("key_reaction_guide_show_pb_strategy"), s + "1,");
            } else if (i == 1) {
                if (z) {
                    f55.m().z(f55.q("key_reaction_guide_show_number_pb"), 3);
                    f55.m().B(f55.q("key_reaction_guide_show_pb_strategy"), s + "3,");
                    return;
                }
                f55.m().z(f55.q("key_reaction_guide_show_number_pb"), 2);
                f55.m().B(f55.q("key_reaction_guide_show_pb_strategy"), s + "2,");
            } else if (i == 4) {
                f55.m().z(f55.q("key_reaction_guide_show_number_pb"), 1);
                f55.m().B(f55.q("key_reaction_guide_show_pb_strategy"), s + "1,");
            } else if (i == 5) {
                f55.m().z(f55.q("key_reaction_guide_show_number_pb"), 2);
                f55.m().B(f55.q("key_reaction_guide_show_pb_strategy"), s + "2,");
            } else if (i == 3) {
                f55.m().z(f55.q("key_reaction_guide_show_number_pb"), 3);
                f55.m().B(f55.q("key_reaction_guide_show_pb_strategy"), s + "3,");
            } else if (i == 7) {
                f55.m().z(f55.q("key_reaction_guide_show_number_pb"), 4);
                f55.m().B(f55.q("key_reaction_guide_show_pb_strategy"), s + "4");
            }
        }
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public final boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && a2(pbModel.G)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void initUniqueId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.initUniqueId();
            this.x.h(getUniqueId());
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPause();
            this.v = false;
            r15.n(q15.o);
            if (Z1()) {
                this.x.o(false);
            }
        }
    }

    @NonNull
    public PriorityOrganizer t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.w;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    public final void b2(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DRAW_DISPATCH_STAMP_KEY);
                int i3 = -1;
                if (x35.a().c == 1) {
                    i3 = 8;
                }
                if (x35.a().c == 2) {
                    i3 = 9;
                }
                SpeedStats.getInstance().onSchemeOrPushStatsEnd(this, i3, x35.a().d);
            }
            long currentTimeMillis = System.currentTimeMillis() - H1();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_OPTIMIZE_LOAD_DURATION);
            statisticItem.addParam("obj_type", i2).addParam("obj_locate", i).addParam("obj_param1", currentTimeMillis).addParam(TiebaStatic.Params.OBJ_PARAM2, u35.e());
            TiebaStatic.log(statisticItem);
        }
    }

    public void c2(int i, BdTypeRecyclerView bdTypeRecyclerView) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048587, this, i, bdTypeRecyclerView) == null) && !this.u && K1() != null) {
            this.u = true;
            if (K1() != null && K1().y1() == 7) {
                i2 = 2;
            } else if (K1() != null && K1().h2()) {
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

    public void d2(int i, tz8 tz8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048588, this, i, tz8Var) == null) && !this.u && K1() != null) {
            int i2 = 1;
            this.u = true;
            if (K1() != null && K1().y1() == 7) {
                i2 = 2;
            } else if (K1() == null || !K1().h2()) {
                i2 = 3;
            }
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY);
            }
            tz8Var.j2(new b(this, i, i2));
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i, keyEvent)) == null) {
            if (Z1() && i == 4) {
                if (this.x.d().e()) {
                    return false;
                }
                finish();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
