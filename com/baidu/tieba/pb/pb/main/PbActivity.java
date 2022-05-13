package com.baidu.tieba.pb.pb.main;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fw7;
import com.repackage.uo;
import com.repackage.us4;
import com.repackage.xs4;
/* loaded from: classes3.dex */
public class PbActivity extends AbsPbActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasPbDataFillLogged;

    /* loaded from: classes3.dex */
    public class a implements uo {
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

        @Override // com.repackage.uo
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.logOnPbDataSet(this.a, this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements uo {
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

        @Override // com.repackage.uo
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.logOnPbDataSet(this.a, this.b);
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
        this.hasPbDataFillLogged = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logOnPbDataSet(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, this, i, i2) == null) {
            if (i2 != 3) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DRAW_DISPATCH_STAMP_KEY);
                int i3 = xs4.a().c == 1 ? 8 : -1;
                if (xs4.a().c == 2) {
                    i3 = 9;
                }
                SpeedStats.getInstance().onSchemeOrPushStatsEnd(this, i3, xs4.a().d);
            }
            long currentTimeMillis = System.currentTimeMillis() - getCreateTime();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_OPTIMIZE_LOAD_DURATION);
            statisticItem.addParam("obj_type", i2).addParam("obj_locate", i).addParam("obj_param1", currentTimeMillis).addParam(TiebaStatic.Params.OBJ_PARAM2, us4.e());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int getContentViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0679 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int getImmersionVideoCommentSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int getShowFloorNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONRESUME_STAMP_KEY);
            super.onResume();
        }
    }

    public void logOnPbDataSet(int i, BdTypeRecyclerView bdTypeRecyclerView) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, bdTypeRecyclerView) == null) || this.hasPbDataFillLogged || getPbModel() == null) {
            return;
        }
        this.hasPbDataFillLogged = true;
        if (getPbModel() == null || getPbModel().O1() != 7) {
            i2 = (getPbModel() == null || !getPbModel().u2()) ? 3 : 1;
        } else {
            i2 = 2;
        }
        if (i2 != 3) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY);
        }
        bdTypeRecyclerView.y = new a(this, i, i2);
        bdTypeRecyclerView.w = true;
    }

    public void logOnPbDataSet(int i, fw7 fw7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, fw7Var) == null) || this.hasPbDataFillLogged || getPbModel() == null) {
            return;
        }
        int i2 = 1;
        this.hasPbDataFillLogged = true;
        if (getPbModel() != null && getPbModel().O1() == 7) {
            i2 = 2;
        } else if (getPbModel() == null || !getPbModel().u2()) {
            i2 = 3;
        }
        if (i2 != 3) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY);
        }
        fw7Var.g2(new b(this, i, i2));
    }
}
