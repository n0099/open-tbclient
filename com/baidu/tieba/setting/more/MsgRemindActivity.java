package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ex4;
import com.repackage.hx4;
import com.repackage.j85;
import com.repackage.ja8;
import com.repackage.kf5;
import com.repackage.li;
import com.repackage.nm4;
import com.repackage.zx4;
import java.util.Date;
/* loaded from: classes3.dex */
public class MsgRemindActivity extends BaseActivity<MsgRemindActivity> implements BdSwitchView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MsgRemindModel.f callback;
    public MsgRemindModel mModel;
    public ja8 mView;
    public final kf5 onTimeSelectListener;

    /* loaded from: classes3.dex */
    public class a implements kf5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindActivity a;

        public a(MsgRemindActivity msgRemindActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgRemindActivity;
        }

        @Override // com.repackage.kf5
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view2) == null) || this.a.mView == null) {
                return;
            }
            ex4.d().W(date.getHours(), date.getMinutes());
            this.a.mView.E();
            this.a.mView.D();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements MsgRemindModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindActivity a;

        public b(MsgRemindActivity msgRemindActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgRemindActivity;
        }

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.f
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (i == 2) {
                    this.a.mView.F();
                } else if (i == 3) {
                    this.a.mView.G();
                } else if (i == 1) {
                    this.a.mView.I();
                } else if (i == 20) {
                    this.a.mView.K();
                } else if (i == 30) {
                    this.a.mView.H();
                } else if (i == 10) {
                    this.a.mView.L();
                } else if (i == 7) {
                    if (z) {
                        return;
                    }
                    if (z2) {
                        this.a.mView.h().k();
                    } else {
                        this.a.mView.h().n();
                    }
                } else if (i == 6) {
                    if (z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921631));
                    } else if (z2) {
                        this.a.mView.m().k();
                    } else {
                        this.a.mView.m().n();
                    }
                }
            }
        }
    }

    public MsgRemindActivity() {
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
        this.onTimeSelectListener = new a(this);
        this.callback = new b(this);
    }

    private void doMsgSwitchStat(BdSwitchView.SwitchState switchState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, switchState, i) == null) {
            doMsgSwitchStat(switchState, i, "");
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
            if (view2 == this.mView.q()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    ex4.d().V(true);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 2));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 1));
                    this.mView.E();
                    this.mView.B(true);
                } else {
                    ex4.d().V(false);
                    TiebaStatic.log(new StatisticItem("c12939").param("obj_type", 1));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SWITCH).param("obj_type", 0));
                    this.mView.B(false);
                }
                doMsgSwitchStat(switchState, 9, this.mView.r());
            } else if (view2 == this.mView.l()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.D(30, true, this.callback);
                } else {
                    this.mModel.D(30, false, this.callback);
                }
                doMsgSwitchStat(switchState, 10);
            } else if (view2 == this.mView.n()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.D(1, true, this.callback);
                } else {
                    this.mModel.D(1, false, this.callback);
                }
                doMsgSwitchStat(switchState, 1);
            } else if (view2 == this.mView.t()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.D(20, true, this.callback);
                } else {
                    this.mModel.D(20, false, this.callback);
                }
                doMsgSwitchStat(switchState, 2);
            } else if (view2 == this.mView.g()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.D(2, true, this.callback);
                } else {
                    this.mModel.D(2, false, this.callback);
                }
                doMsgSwitchStat(switchState, 4);
            } else if (view2 == this.mView.i()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.D(10, true, this.callback);
                } else {
                    this.mModel.D(10, false, this.callback);
                }
                doMsgSwitchStat(switchState, 11);
            } else if (view2 == this.mView.k()) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.mModel.D(3, true, this.callback);
                } else {
                    this.mModel.D(3, false, this.callback);
                }
                doMsgSwitchStat(switchState, 3);
            } else if (view2 == this.mView.h()) {
                this.mModel.D(7, switchState == BdSwitchView.SwitchState.OFF, this.callback);
                doMsgSwitchStat(switchState, 7);
            } else if (view2 == this.mView.m()) {
                this.mModel.D(6, switchState == BdSwitchView.SwitchState.OFF, this.callback);
                doMsgSwitchStat(switchState, 8);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.mView.o()) {
                hx4.c().l(getPageContext(), this.onTimeSelectListener);
            } else if (view2 == this.mView.j()) {
                nm4.c().b();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            ja8 ja8Var = new ja8(this);
            this.mView = ja8Var;
            ja8Var.u(this);
            this.mModel = new MsgRemindModel(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921660));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onNetRefreshButtonClicked();
            zx4.e(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            if (!j85.a(this)) {
                this.mView.C(false);
                showNetRefreshView(this.mView.s(), getString(R.string.obfuscated_res_0x7f0f15fc), getString(R.string.obfuscated_res_0x7f0f07c3), getString(R.string.obfuscated_res_0x7f0f07c2), true, getNetRefreshListener());
                setNetRefreshViewPicResId(R.drawable.new_pic_emotion_03);
                setNetRefreshViewEmotionMarginTop(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                return;
            }
            this.mView.C(true);
            hideNetRefreshView(this.mView.s());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStop();
            ex4.d().F();
        }
    }

    private void doMsgSwitchStat(BdSwitchView.SwitchState switchState, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65539, this, switchState, i, str) == null) {
            int i2 = switchState == BdSwitchView.SwitchState.ON ? 1 : 2;
            StatisticItem param = new StatisticItem("c13889").param("obj_locate", 2).param("obj_type", NotificationManagerCompat.from(this).areNotificationsEnabled() ? 1 : 2);
            StatisticItem param2 = param.param("obj_source", i + "_" + i2);
            if (i == 9 && !TextUtils.isEmpty(str) && switchState == BdSwitchView.SwitchState.ON) {
                param2.param("obj_param1", str);
            }
            TiebaStatic.log(param2);
        }
    }
}
