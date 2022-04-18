package com.baidu.tieba.missionCustomDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.mission.SignItemView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cj4;
import com.repackage.ku4;
import com.repackage.oi;
import com.repackage.oi4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MissionCustomDialogActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ActiveCenterData mActiveCenterData;
    public TBSpecificationBtn mBottomActionBtn;
    public TextView mBottomActionDetail;
    public RoundRelativeLayout mBottomActionLayout;
    public TextView mBottomActionTitle;
    public TextView mBottonActionText;
    public RoundRelativeLayout mContentBackground;
    public ImageView mDialogBackground;
    public TextView mDialogDetail;
    public TextView mDialogTitle;
    public ImageView mImgClose;
    public SignItemView.b mItemClickListener;
    public SignItemView mSignView;
    public View.OnClickListener onClickProcessTaskListener;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MissionCustomDialogActivity a;

        public a(MissionCustomDialogActivity missionCustomDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {missionCustomDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = missionCustomDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.handleTask();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MissionCustomDialogActivity a;

        public b(MissionCustomDialogActivity missionCustomDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {missionCustomDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = missionCustomDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MULTI_TASK_DIALOG_SHOW_AND_CLICK).param("obj_source", oi4.y().E() ? 2 : 1).param("obj_type", 3));
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements SignItemView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MissionCustomDialogActivity a;

        public c(MissionCustomDialogActivity missionCustomDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {missionCustomDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = missionCustomDialogActivity;
        }

        @Override // com.baidu.tbadk.widget.mission.SignItemView.b
        public void a(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activeCenterStatusData) == null) {
                this.a.applyBottomStatus(activeCenterStatusData);
            }
        }
    }

    public MissionCustomDialogActivity() {
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
        this.onClickProcessTaskListener = new a(this);
        this.mItemClickListener = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyBottomStatus(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        ActiveCenterData activeCenterData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, activeCenterStatusData) == null) || (activeCenterData = this.mActiveCenterData) == null || activeCenterData.mission == null || activeCenterStatusData == null) {
            return;
        }
        this.mBottomActionLayout.setAllCornerRound(oi.f(this, R.dimen.tbds21));
        String str = activeCenterStatusData.mission;
        TextView textView = this.mBottomActionTitle;
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        String str2 = activeCenterStatusData.desc;
        this.mBottomActionDetail.setText(str2 != null ? str2 : "");
        int i = activeCenterStatusData.is_today_mission;
        if (i == 0) {
            this.mBottomActionBtn.setVisibility(0);
            this.mBottonActionText.setVisibility(8);
            if (activeCenterStatusData.is_completed) {
                this.mBottomActionBtn.setText("已完成");
                this.mBottomActionBtn.setClickable(false);
                this.mBottomActionBtn.setEnabled(false);
            } else {
                this.mBottomActionBtn.setText("已过期");
                this.mBottomActionBtn.setClickable(false);
                this.mBottomActionBtn.setEnabled(false);
            }
        } else if (i == 1) {
            this.mBottomActionBtn.setVisibility(0);
            this.mBottonActionText.setVisibility(8);
            int i2 = this.mActiveCenterData.mission.task_type;
            if (i2 == 13) {
                if (activeCenterStatusData.is_completed) {
                    this.mBottomActionBtn.setText("去领取");
                    this.mBottomActionBtn.setClickable(true);
                    this.mBottomActionBtn.setEnabled(true);
                } else {
                    this.mBottomActionBtn.setText("未达标");
                    this.mBottomActionBtn.setClickable(false);
                    this.mBottomActionBtn.setEnabled(false);
                }
            } else {
                if (i2 == 6) {
                    if (cj4.g().i().f()) {
                        activeCenterStatusData.is_completed = true;
                    } else {
                        activeCenterStatusData.is_completed = false;
                    }
                }
                if (activeCenterStatusData.is_completed) {
                    this.mBottomActionBtn.setText("已完成");
                    this.mBottomActionBtn.setClickable(false);
                    this.mBottomActionBtn.setEnabled(false);
                } else {
                    this.mBottomActionBtn.setText("去完成");
                    this.mBottomActionBtn.setClickable(true);
                    this.mBottomActionBtn.setEnabled(true);
                }
            }
        } else {
            this.mBottomActionBtn.setVisibility(8);
            this.mBottonActionText.setVisibility(0);
            this.mBottonActionText.setText("未开始");
        }
        ku4 ku4Var = new ku4();
        ku4Var.p(R.color.CAM_X0301);
        ku4Var.l(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
        this.mBottomActionBtn.setConfig(ku4Var);
        this.mBottomActionBtn.setTextSize(R.dimen.tbds34);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MULTI_TASK_DIALOG_SHOW_AND_CLICK).param("obj_source", oi4.y().E() ? 2 : 1).param("obj_type", 2));
            ActiveCenterData activeCenterData = this.mActiveCenterData;
            if (activeCenterData == null) {
                return;
            }
            int curTaskType = activeCenterData.getCurTaskType();
            if (curTaskType == 12) {
                processNewUserRedPkgTask();
            } else if (curTaskType == 6) {
                processPushTask();
            } else if (curTaskType == 10) {
                processSignRedPkgTask();
            } else if (curTaskType == 7) {
                processBrowseThreadTask();
            } else if (curTaskType == 5) {
                processShareThreadTask();
            } else if (curTaskType == 9) {
                processFollowForumTask();
            } else if (curTaskType == 13) {
                processFinalAwardTask();
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906e6);
            this.mContentBackground = roundRelativeLayout;
            roundRelativeLayout.setAllCornerRound(oi.f(this, R.dimen.tbds32));
            this.mDialogBackground = (ImageView) findViewById(R.id.obfuscated_res_0x7f09079a);
            this.mImgClose = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ea7);
            this.mDialogTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f0907bf);
            this.mDialogDetail = (TextView) findViewById(R.id.obfuscated_res_0x7f0907ac);
            this.mSignView = (SignItemView) findViewById(R.id.obfuscated_res_0x7f091cf6);
            this.mBottomActionLayout = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f0903be);
            this.mBottomActionTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f0903eb);
            this.mBottomActionDetail = (TextView) findViewById(R.id.obfuscated_res_0x7f0903c9);
            this.mBottomActionBtn = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f0903c3);
            this.mBottonActionText = (TextView) findViewById(R.id.obfuscated_res_0x7f0903c4);
            this.mSignView.setItemClickListener(this.mItemClickListener);
            this.mBottomActionBtn.setOnClickListener(this.onClickProcessTaskListener);
            this.mImgClose.setOnClickListener(new b(this));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void processBrowseThreadTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            if (TbadkCoreApplication.isLogin()) {
                cj4.g().d().e(getPageContext());
                finish();
                return;
            }
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
        }
    }

    private void processFinalAwardTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (TbadkCoreApplication.isLogin()) {
                cj4.g().e().e(getPageContext());
                finish();
                return;
            }
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
        }
    }

    private void processFollowForumTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (TbadkCoreApplication.isLogin()) {
                cj4.g().f().e(getPageContext());
                finish();
                return;
            }
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
        }
    }

    private void processNewUserRedPkgTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (TbadkCoreApplication.isLogin()) {
                cj4.g().h().e(getPageContext());
                cj4.g().h().b();
                finish();
                return;
            }
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
        }
    }

    private void processPushTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (TbadkCoreApplication.isLogin()) {
                cj4.g().i().e(getPageContext());
                finish();
                return;
            }
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
        }
    }

    private void processShareThreadTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (TbadkCoreApplication.isLogin()) {
                cj4.g().j().e(getPageContext());
                finish();
                return;
            }
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
        }
    }

    private void processSignRedPkgTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (TbadkCoreApplication.isLogin()) {
                cj4.g().k().e(getPageContext());
                finish();
                return;
            }
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
        }
    }

    private void setData() {
        ArrayList<ActiveCenterData.ActiveCenterStatusData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            ActiveCenterData c2 = cj4.g().c();
            if (c2 != null && c2.mission != null && (arrayList = c2.mission_status_list) != null && arrayList.size() > 0) {
                cj4.g().u(true);
                this.mActiveCenterData = c2;
                this.mDialogTitle.setText(StringHelper.cutChineseAndEnglishWithSuffix(c2.win_title, 14, StringHelper.STRING_MORE));
                this.mDialogDetail.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.mActiveCenterData.win_desc, 30, StringHelper.STRING_MORE));
                this.mSignView.setData(c2);
                applyBottomStatus(this.mActiveCenterData.getTodayMissionStatus());
                return;
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 25046 && TbadkCoreApplication.isLogin()) {
                handleTask();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(this.mContentBackground, R.color.CAM_X0211);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.mDialogBackground, R.drawable.obfuscated_res_0x7f08064a, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.mDialogTitle, (int) R.color.CAM_X0311);
            SkinManager.setViewTextColor(this.mDialogDetail, (int) R.color.CAM_X0301);
            SkinManager.setBackgroundColor(this.mBottomActionLayout, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.mBottomActionTitle, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mBottomActionDetail, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.mBottonActionText, (int) R.color.CAM_X0109);
            if (this.mBottomActionBtn != null) {
                ku4 ku4Var = new ku4();
                ku4Var.p(R.color.CAM_X0301);
                ku4Var.l(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
                this.mBottomActionBtn.setConfig(ku4Var);
            }
            this.mSignView.e(i);
            SkinManager.setImageResource(this.mImgClose, R.drawable.obfuscated_res_0x7f0805f8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0045);
            initView();
            setData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            cj4.g().i().b();
        }
    }
}
