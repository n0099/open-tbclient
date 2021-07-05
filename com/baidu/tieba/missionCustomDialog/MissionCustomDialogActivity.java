package com.baidu.tieba.missionCustomDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import d.a.c.e.p.l;
import d.a.r0.a.d;
import d.a.r0.a.s;
import java.util.ArrayList;
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MissionCustomDialogActivity f18629e;

        public a(MissionCustomDialogActivity missionCustomDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {missionCustomDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18629e = missionCustomDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18629e.handleTask();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MissionCustomDialogActivity f18630e;

        public b(MissionCustomDialogActivity missionCustomDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {missionCustomDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18630e = missionCustomDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MULTI_TASK_DIALOG_SHOW_AND_CLICK).param("obj_source", d.y().D() ? 2 : 1).param("obj_type", 3));
                this.f18630e.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements SignItemView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MissionCustomDialogActivity f18631a;

        public c(MissionCustomDialogActivity missionCustomDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {missionCustomDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18631a = missionCustomDialogActivity;
        }

        @Override // com.baidu.tbadk.widget.mission.SignItemView.b
        public void a(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activeCenterStatusData) == null) {
                this.f18631a.applyBottomStatus(activeCenterStatusData);
            }
        }
    }

    public MissionCustomDialogActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.mBottomActionLayout.setAllCornerRound(l.g(this, R.dimen.tbds21));
        String str = activeCenterStatusData.mission;
        TextView textView = this.mBottomActionTitle;
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        String str2 = activeCenterStatusData.desc;
        this.mBottomActionDetail.setText(str2 != null ? str2 : "");
        int i2 = activeCenterStatusData.is_today_mission;
        if (i2 == 0) {
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
        } else if (i2 == 1) {
            this.mBottomActionBtn.setVisibility(0);
            this.mBottonActionText.setVisibility(8);
            int i3 = this.mActiveCenterData.mission.task_type;
            if (i3 == 13) {
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
                if (i3 == 6) {
                    if (s.g().i().f()) {
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
        d.a.r0.r.f0.m.a aVar = new d.a.r0.r.f0.m.a();
        aVar.o(R.color.CAM_X0301);
        aVar.k(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
        this.mBottomActionBtn.setConfig(aVar);
        this.mBottomActionBtn.setTextSize(R.dimen.tbds34);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MULTI_TASK_DIALOG_SHOW_AND_CLICK).param("obj_source", d.y().D() ? 2 : 1).param("obj_type", 2));
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R.id.content_background);
            this.mContentBackground = roundRelativeLayout;
            roundRelativeLayout.setAllCornerRound(l.g(this, R.dimen.tbds32));
            this.mDialogBackground = (ImageView) findViewById(R.id.dialog_background);
            this.mImgClose = (ImageView) findViewById(R.id.img_close);
            this.mDialogTitle = (TextView) findViewById(R.id.dialog_title);
            this.mDialogDetail = (TextView) findViewById(R.id.dialog_detail);
            this.mSignView = (SignItemView) findViewById(R.id.sign_view);
            this.mBottomActionLayout = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
            this.mBottomActionTitle = (TextView) findViewById(R.id.bottom_title);
            this.mBottomActionDetail = (TextView) findViewById(R.id.bottom_detail);
            this.mBottomActionBtn = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
            this.mBottonActionText = (TextView) findViewById(R.id.bottom_btn_text);
            this.mSignView.setItemClickListener(this.mItemClickListener);
            this.mBottomActionBtn.setOnClickListener(this.onClickProcessTaskListener);
            this.mImgClose.setOnClickListener(new b(this));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void processBrowseThreadTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if (TbadkCoreApplication.isLogin()) {
                s.g().d().e(getPageContext());
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
                s.g().e().e(getPageContext());
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
                s.g().f().e(getPageContext());
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
                s.g().h().e(getPageContext());
                s.g().h().b();
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
                s.g().i().e(getPageContext());
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
                s.g().j().e(getPageContext());
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
                s.g().k().e(getPageContext());
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
            ActiveCenterData c2 = s.g().c();
            if (c2 != null && c2.mission != null && (arrayList = c2.mission_status_list) != null && arrayList.size() > 0) {
                s.g().u(true);
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
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 25046 && TbadkCoreApplication.isLogin()) {
                handleTask();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.mContentBackground, R.color.CAM_X0211);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.mDialogBackground, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.mDialogTitle, R.color.CAM_X0311);
            SkinManager.setViewTextColor(this.mDialogDetail, R.color.CAM_X0301);
            SkinManager.setBackgroundColor(this.mBottomActionLayout, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.mBottomActionTitle, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mBottomActionDetail, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.mBottonActionText, R.color.CAM_X0109);
            if (this.mBottomActionBtn != null) {
                d.a.r0.r.f0.m.a aVar = new d.a.r0.r.f0.m.a();
                aVar.o(R.color.CAM_X0301);
                aVar.k(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
                this.mBottomActionBtn.setConfig(aVar);
            }
            this.mSignView.e(i2);
            SkinManager.setImageResource(this.mImgClose, R.drawable.ic_icon_popup_close_n);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.activity_mission_custom_dialog);
            initView();
            setData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            s.g().i().b();
        }
    }
}
