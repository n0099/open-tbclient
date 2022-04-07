package com.baidu.tieba.pb.pb.main;

import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ks4;
/* loaded from: classes3.dex */
public class PbActivity extends AbsPbActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasPbDataFillLogged;

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

    public /* synthetic */ boolean a(int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis() - getCreateTime();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_OPTIMIZE_LOAD_DURATION);
        statisticItem.addParam("obj_type", i).addParam("obj_locate", i2).addParam("obj_param1", currentTimeMillis).addParam(TiebaStatic.Params.OBJ_PARAM2, ks4.e());
        TiebaStatic.log(statisticItem);
        return false;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int getContentViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d0687 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int getImmersionVideoCommentSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.AbsPbActivity
    public int getShowFloorNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    public void logOnPbDataSet(final int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || this.hasPbDataFillLogged || getPbModel() == null) {
            return;
        }
        final int i2 = 1;
        this.hasPbDataFillLogged = true;
        if (getPbModel() != null && getPbModel().S0() == 7) {
            i2 = 2;
        } else if (getPbModel() == null || !getPbModel().y1()) {
            i2 = 3;
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.repackage.yt7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? PbActivity.this.a(i2, i) : invokeV.booleanValue;
            }
        });
    }
}
