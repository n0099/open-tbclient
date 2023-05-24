package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.tieba.a35;
import com.baidu.tieba.d19;
import com.baidu.tieba.d55;
import com.baidu.tieba.g55;
import com.baidu.tieba.lr4;
import com.baidu.tieba.mr4;
import com.baidu.tieba.mx8;
import com.baidu.tieba.o65;
import com.baidu.tieba.p19;
import com.baidu.tieba.pb.fragment.VideoFragmentController;
import com.baidu.tieba.un;
import com.baidu.tieba.z25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PbActivity extends AbsPbActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean u;
    public boolean v;
    @NonNull
    public final PriorityOrganizer w;
    public final VideoFragmentController x;
    public int y;
    public String z;

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d075b : invokeV.intValue;
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

    /* loaded from: classes7.dex */
    public class a implements un {
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

        @Override // com.baidu.tieba.un
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.c2(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements un {
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

        @Override // com.baidu.tieba.un
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.c2(this.a, this.b);
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
        this.w = PriorityOrganizer.n();
        this.x = new VideoFragmentController();
        this.y = -1;
        this.z = null;
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.y >= 0) {
                o65.m().z(o65.q("key_reaction_guide_show_number_pb"), this.y);
            }
            if (this.z != null) {
                o65.m().B(o65.q("key_reaction_guide_show_pb_strategy"), this.z);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONRESUME_STAMP_KEY);
            super.onResume();
            this.v = true;
            a35.o(this, z25.o);
            if (a2()) {
                this.x.o(true);
                mr4.w().Q(lr4.c0, this.x.d().c());
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (a2()) {
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
    public void D1(mx8 mx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mx8Var) == null) {
            super.D1(mx8Var);
            if (this.a != null && b2(mx8Var)) {
                this.a.u3(mx8Var);
                this.b.setArguments(this.x.g(mx8Var));
                this.x.l();
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public String I1(mx8 mx8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mx8Var)) == null) {
            if (mx8Var != null && mx8Var.v0()) {
                return "video_pb_fragment_tag";
            }
            return super.I1(mx8Var);
        }
        return (String) invokeL.objValue;
    }

    public final boolean b2(mx8 mx8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, mx8Var)) == null) {
            return "video_pb_fragment_tag".equals(I1(mx8Var));
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            super.onChangeSkinType(i);
            if (a2()) {
                this.x.j(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (a2()) {
                this.x.k(configuration);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_END_STAMP_KEY);
            registerListener(new d19(this));
            X1();
        }
    }

    public final void X1() {
        boolean z;
        String[] strArr;
        String str;
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
            String str2 = "";
            String s = o65.m().s(o65.q("key_reaction_guide_show_pb_strategy"), "");
            String[] split = s.split(",");
            int length = split.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str3 = split[i];
                String str4 = s;
                if ("1".equals(str3)) {
                    strArr = split;
                    str = str2;
                    i2 = (int) (i2 + Math.pow(2.0d, 0.0d));
                } else {
                    strArr = split;
                    str = str2;
                }
                if ("2".equals(str3)) {
                    i2 = (int) (i2 + Math.pow(2.0d, 1.0d));
                }
                if ("3".equals(str3)) {
                    i2 = (int) (i2 + Math.pow(2.0d, 2.0d));
                }
                if ("4".equals(str3)) {
                    i2 = (int) (i2 + Math.pow(2.0d, 3.0d));
                }
                i++;
                s = str4;
                str2 = str;
                split = strArr;
            }
            String str5 = s;
            this.y = o65.m().n(o65.q("key_reaction_guide_show_number_pb"), 0);
            this.z = o65.m().s(o65.q("key_reaction_guide_show_pb_strategy"), str2);
            if (i2 == 0) {
                if (z) {
                    o65.m().z(o65.q("key_reaction_guide_show_number_pb"), 3);
                    o65 m = o65.m();
                    String q = o65.q("key_reaction_guide_show_pb_strategy");
                    m.B(q, str5 + "3,");
                    return;
                }
                o65.m().z(o65.q("key_reaction_guide_show_number_pb"), 1);
                o65 m2 = o65.m();
                String q2 = o65.q("key_reaction_guide_show_pb_strategy");
                m2.B(q2, str5 + "1,");
            } else if (i2 == 1) {
                if (z) {
                    o65.m().z(o65.q("key_reaction_guide_show_number_pb"), 3);
                    o65 m3 = o65.m();
                    String q3 = o65.q("key_reaction_guide_show_pb_strategy");
                    m3.B(q3, str5 + "3,");
                    return;
                }
                o65.m().z(o65.q("key_reaction_guide_show_number_pb"), 2);
                o65 m4 = o65.m();
                String q4 = o65.q("key_reaction_guide_show_pb_strategy");
                m4.B(q4, str5 + "2,");
            } else if (i2 == 4) {
                o65.m().z(o65.q("key_reaction_guide_show_number_pb"), 1);
                o65 m5 = o65.m();
                String q5 = o65.q("key_reaction_guide_show_pb_strategy");
                m5.B(q5, str5 + "1,");
            } else if (i2 == 5) {
                o65.m().z(o65.q("key_reaction_guide_show_number_pb"), 2);
                o65 m6 = o65.m();
                String q6 = o65.q("key_reaction_guide_show_pb_strategy");
                m6.B(q6, str5 + "2,");
            } else if (i2 == 3) {
                o65.m().z(o65.q("key_reaction_guide_show_number_pb"), 3);
                o65 m7 = o65.m();
                String q7 = o65.q("key_reaction_guide_show_pb_strategy");
                m7.B(q7, str5 + "3,");
            } else if (i2 == 7) {
                o65.m().z(o65.q("key_reaction_guide_show_number_pb"), 4);
                o65 m8 = o65.m();
                String q8 = o65.q("key_reaction_guide_show_pb_strategy");
                m8.B(q8, str5 + "4");
            }
        }
    }

    @Nullable
    public PbFragment Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Fragment fragment = this.b;
            if (fragment instanceof PbFragment) {
                return (PbFragment) fragment;
            }
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public final boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && b2(pbModel.G)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void initUniqueId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.initUniqueId();
            this.x.h(getUniqueId());
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            this.v = false;
            a35.n(z25.o);
            if (a2()) {
                this.x.o(false);
            }
        }
    }

    @NonNull
    public PriorityOrganizer s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.w;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    public final void c2(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DRAW_DISPATCH_STAMP_KEY);
                int i3 = -1;
                if (g55.a().c == 1) {
                    i3 = 8;
                }
                if (g55.a().c == 2) {
                    i3 = 9;
                }
                SpeedStats.getInstance().onSchemeOrPushStatsEnd(this, i3, g55.a().d);
            }
            long currentTimeMillis = System.currentTimeMillis() - H1();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_OPTIMIZE_LOAD_DURATION);
            statisticItem.addParam("obj_type", i2).addParam("obj_locate", i).addParam("obj_param1", currentTimeMillis).addParam(TiebaStatic.Params.OBJ_PARAM2, d55.e());
            TiebaStatic.log(statisticItem);
        }
    }

    public void d2(int i, BdTypeRecyclerView bdTypeRecyclerView) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048588, this, i, bdTypeRecyclerView) == null) && !this.u && K1() != null) {
            this.u = true;
            if (K1() != null && K1().x1() == 7) {
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

    public void e2(int i, p19 p19Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048589, this, i, p19Var) == null) && !this.u && K1() != null) {
            int i2 = 1;
            this.u = true;
            if (K1() != null && K1().x1() == 7) {
                i2 = 2;
            } else if (K1() == null || !K1().g2()) {
                i2 = 3;
            }
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY);
            }
            p19Var.k2(new b(this, i, i2));
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048596, this, i, keyEvent)) == null) {
            if (a2() && i == 4) {
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
