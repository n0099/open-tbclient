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
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.growthFunnel.GrowthFunnelHelper;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.R;
import com.baidu.tieba.aj9;
import com.baidu.tieba.d85;
import com.baidu.tieba.fn;
import com.baidu.tieba.mn9;
import com.baidu.tieba.mt4;
import com.baidu.tieba.nt4;
import com.baidu.tieba.pb.fragment.VideoFragmentController;
import com.baidu.tieba.t55;
import com.baidu.tieba.xn9;
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
    public int F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d07b3 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class a implements fn {
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

        @Override // com.baidu.tieba.fn
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d2(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements fn {
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

        @Override // com.baidu.tieba.fn
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d2(this.a, this.b);
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
        this.w = PriorityOrganizer.create();
        this.x = new VideoFragmentController();
        this.y = -1;
        this.z = null;
    }

    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.y >= 0) {
                SharedPrefHelper.getInstance().putInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), this.y);
            }
            if (this.z != null) {
                SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_pb_strategy"), this.z);
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
            YunDialogManager.onShow(this, t55.p);
            if (b2()) {
                this.x.o(true);
                nt4.w().Q(mt4.c0, this.x.d().c());
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (b2()) {
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
    public void D1(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aj9Var) == null) {
            super.D1(aj9Var);
            if (this.a != null && c2(aj9Var)) {
                this.a.q3(aj9Var);
                this.b.setArguments(this.x.g(aj9Var));
                this.x.l();
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public String H1(aj9 aj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aj9Var)) == null) {
            if (aj9Var != null && aj9Var.x0()) {
                return "video_pb_fragment_tag";
            }
            return super.H1(aj9Var);
        }
        return (String) invokeL.objValue;
    }

    public final boolean c2(aj9 aj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aj9Var)) == null) {
            return "video_pb_fragment_tag".equals(H1(aj9Var));
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            super.onChangeSkinType(i);
            if (b2()) {
                this.x.j(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (b2()) {
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
            registerListener(new mn9(this));
            Y1();
        }
    }

    public final void Y1() {
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
            String string = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_pb_strategy"), "");
            String[] split = string.split(",");
            int length = split.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str3 = split[i];
                String str4 = string;
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
                string = str4;
                str2 = str;
                split = strArr;
            }
            String str5 = string;
            this.y = SharedPrefHelper.getInstance().getInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 0);
            this.z = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_pb_strategy"), str2);
            if (i2 == 0) {
                if (z) {
                    SharedPrefHelper.getInstance().putInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 3);
                    SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                    String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_pb_strategy");
                    sharedPrefHelper.putString(sharedPrefKeyWithAccount, str5 + "3,");
                    return;
                }
                SharedPrefHelper.getInstance().putInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 1);
                SharedPrefHelper sharedPrefHelper2 = SharedPrefHelper.getInstance();
                String sharedPrefKeyWithAccount2 = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_pb_strategy");
                sharedPrefHelper2.putString(sharedPrefKeyWithAccount2, str5 + "1,");
            } else if (i2 == 1) {
                if (z) {
                    SharedPrefHelper.getInstance().putInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 3);
                    SharedPrefHelper sharedPrefHelper3 = SharedPrefHelper.getInstance();
                    String sharedPrefKeyWithAccount3 = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_pb_strategy");
                    sharedPrefHelper3.putString(sharedPrefKeyWithAccount3, str5 + "3,");
                    return;
                }
                SharedPrefHelper.getInstance().putInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 2);
                SharedPrefHelper sharedPrefHelper4 = SharedPrefHelper.getInstance();
                String sharedPrefKeyWithAccount4 = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_pb_strategy");
                sharedPrefHelper4.putString(sharedPrefKeyWithAccount4, str5 + "2,");
            } else if (i2 == 4) {
                SharedPrefHelper.getInstance().putInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 1);
                SharedPrefHelper sharedPrefHelper5 = SharedPrefHelper.getInstance();
                String sharedPrefKeyWithAccount5 = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_pb_strategy");
                sharedPrefHelper5.putString(sharedPrefKeyWithAccount5, str5 + "1,");
            } else if (i2 == 5) {
                SharedPrefHelper.getInstance().putInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 2);
                SharedPrefHelper sharedPrefHelper6 = SharedPrefHelper.getInstance();
                String sharedPrefKeyWithAccount6 = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_pb_strategy");
                sharedPrefHelper6.putString(sharedPrefKeyWithAccount6, str5 + "2,");
            } else if (i2 == 3) {
                SharedPrefHelper.getInstance().putInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 3);
                SharedPrefHelper sharedPrefHelper7 = SharedPrefHelper.getInstance();
                String sharedPrefKeyWithAccount7 = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_pb_strategy");
                sharedPrefHelper7.putString(sharedPrefKeyWithAccount7, str5 + "3,");
            } else if (i2 == 7) {
                SharedPrefHelper.getInstance().putInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 4);
                SharedPrefHelper sharedPrefHelper8 = SharedPrefHelper.getInstance();
                String sharedPrefKeyWithAccount8 = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_pb_strategy");
                sharedPrefHelper8.putString(sharedPrefKeyWithAccount8, str5 + "4");
            }
        }
    }

    @Nullable
    public PbFragment Z1() {
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

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public final boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && c2(pbModel.G)) {
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
            YunDialogManager.onHidden(t55.p);
            if (b2()) {
                this.x.o(false);
            }
        }
    }

    @NonNull
    public PriorityOrganizer q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.w;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    public final void d2(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DRAW_DISPATCH_STAMP_KEY);
                int i3 = -1;
                if (d85.a().c == 1) {
                    i3 = 8;
                }
                if (d85.a().c == 2) {
                    i3 = 9;
                }
                SpeedStats.getInstance().onSchemeOrPushStatsEnd(this, i3, d85.a().d);
            }
            long currentTimeMillis = System.currentTimeMillis() - G1();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_OPTIMIZE_LOAD_DURATION);
            statisticItem.addParam("obj_type", i2).addParam("obj_locate", i).addParam("obj_param1", currentTimeMillis).addParam(TiebaStatic.Params.OBJ_PARAM2, GrowthFunnelHelper.getRealStartScheme());
            TiebaStatic.log(statisticItem);
        }
    }

    public void e2(int i, BdTypeRecyclerView bdTypeRecyclerView) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048588, this, i, bdTypeRecyclerView) == null) && !this.u && J1() != null) {
            this.u = true;
            if (J1() != null && J1().q1() == 7) {
                i2 = 2;
            } else if (J1() != null && J1().a2()) {
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

    public void f2(int i, xn9 xn9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048589, this, i, xn9Var) == null) && !this.u && J1() != null) {
            int i2 = 1;
            this.u = true;
            if (J1() != null && J1().q1() == 7) {
                i2 = 2;
            } else if (J1() == null || !J1().a2()) {
                i2 = 3;
            }
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY);
            }
            xn9Var.G2(new b(this, i, i2));
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048596, this, i, keyEvent)) == null) {
            if (b2() && i == 4) {
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
