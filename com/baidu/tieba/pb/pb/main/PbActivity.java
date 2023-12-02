package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.growthFunnel.GrowthFunnelHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.R;
import com.baidu.tieba.b1a;
import com.baidu.tieba.fp5;
import com.baidu.tieba.l4b;
import com.baidu.tieba.l68;
import com.baidu.tieba.n1a;
import com.baidu.tieba.oo4;
import com.baidu.tieba.pb.fragment.VideoFragmentController;
import com.baidu.tieba.po4;
import com.baidu.tieba.q35;
import com.baidu.tieba.si;
import com.baidu.tieba.y05;
import com.baidu.tieba.zv9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import kotlin.Pair;
/* loaded from: classes7.dex */
public class PbActivity extends AbsPbActivity implements l4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean u;
    public boolean v;
    @NonNull
    public final PriorityOrganizer w;
    public final VideoFragmentController x;

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.l4b
    @NonNull
    public String l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "pb_landing_page" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? R.layout.obfuscated_res_0x7f0d07d5 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.l4b
    @NonNull
    public String z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? "pb" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements si {
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

        @Override // com.baidu.tieba.si
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.a2(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements si {
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

        @Override // com.baidu.tieba.si
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
        this.u = false;
        this.v = false;
        this.w = PriorityOrganizer.create();
        this.x = new VideoFragmentController();
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            fp5.a.a(getUniqueId(), new Pair<>(PushMessageHelper.ERROR_TYPE, "pb_page"), new Pair<>("error_info", "pb page unfinished destroy"));
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONRESUME_STAMP_KEY);
            super.onResume();
            this.v = true;
            YunDialogManager.onShow(this, y05.p);
            if (X1()) {
                this.x.o(true);
                po4.w().Q(oo4.c0, this.x.d().c());
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (X1()) {
                this.x.d().d(i, i2, intent);
            }
        }
    }

    @Nullable
    public PbFragment S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Fragment fragment = this.b;
            if (fragment instanceof PbFragment) {
                return (PbFragment) fragment;
            }
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public final boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && Z1(pbModel.G)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public PriorityOrganizer a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.w;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l4b
    @NonNull
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (getUniqueId() == null) {
                return BdUniqueId.gen().toString();
            }
            return Integer.toString(getUniqueId().getId());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void initUniqueId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
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
            YunDialogManager.onHidden(y05.p);
            if (X1()) {
                this.x.o(false);
            }
        }
    }

    public final boolean Z1(zv9 zv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zv9Var)) == null) {
            return "video_pb_fragment_tag".equals(z1(zv9Var));
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            super.onChangeSkinType(i);
            if (X1()) {
                this.x.j(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (X1()) {
                this.x.k(configuration);
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public void v1(zv9 zv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, zv9Var) == null) {
            super.v1(zv9Var);
            if (this.a != null && Z1(zv9Var)) {
                this.a.p3(zv9Var);
                this.b.setArguments(this.x.g(zv9Var));
                this.x.l();
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public String z1(zv9 zv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, zv9Var)) == null) {
            if (zv9Var != null && zv9Var.y0()) {
                return "video_pb_fragment_tag";
            }
            return super.z1(zv9Var);
        }
        return (String) invokeL.objValue;
    }

    public final void a2(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DRAW_DISPATCH_STAMP_KEY);
                int i3 = -1;
                if (q35.a().c == 1) {
                    i3 = 8;
                }
                if (q35.a().c == 2) {
                    i3 = 9;
                }
                SpeedStats.getInstance().onSchemeOrPushStatsEnd(this, i3, q35.a().d);
            }
            long currentTimeMillis = System.currentTimeMillis() - y1();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_OPTIMIZE_LOAD_DURATION);
            statisticItem.addParam("obj_type", i2).addParam("obj_locate", i).addParam("obj_param1", currentTimeMillis).addParam(TiebaStatic.Params.OBJ_PARAM2, GrowthFunnelHelper.getRealStartScheme());
            TiebaStatic.log(statisticItem);
        }
    }

    public void b2(int i, BdTypeRecyclerView bdTypeRecyclerView) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, bdTypeRecyclerView) == null) && !this.u && B1() != null) {
            this.u = true;
            if (B1() != null && B1().r1() == 7) {
                i2 = 2;
            } else if (B1() != null && B1().c2()) {
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

    public void c2(int i, n1a n1aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048585, this, i, n1aVar) == null) && !this.u && B1() != null) {
            int i2 = 1;
            this.u = true;
            if (B1() != null && B1().r1() == 7) {
                i2 = 2;
            } else if (B1() == null || !B1().c2()) {
                i2 = 3;
            }
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY);
            }
            n1aVar.C2(new b(this, i, i2));
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_END_STAMP_KEY);
            registerListener(new b1a(this));
            if (B1() != null && B1().isFromNewFrs && !TextUtils.isEmpty(B1().R0())) {
                l68.a.b(B1().R0());
            }
            fp5.a.e(getUniqueId(), this);
            fp5.a.g(getUniqueId());
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i, keyEvent)) == null) {
            if (X1() && i == 4) {
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

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public Fragment u1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if ("video_pb_fragment_tag".equals(str)) {
                registerListener(this.x.f());
                this.x.i(this);
                return this.x.d().b();
            }
            return super.u1(str);
        }
        return (Fragment) invokeL.objValue;
    }
}
