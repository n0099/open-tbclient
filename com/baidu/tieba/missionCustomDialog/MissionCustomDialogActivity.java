package com.baidu.tieba.missionCustomDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
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
import d.a.c.e.p.l;
import d.a.n0.a.d;
import d.a.n0.a.s;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MissionCustomDialogActivity extends BaseActivity {
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
    public SignItemView mSignView;
    public View.OnClickListener onClickProcessTaskListener = new a();
    public SignItemView.b mItemClickListener = new c();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.handleTask();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MULTI_TASK_DIALOG_SHOW_AND_CLICK).param("obj_source", d.y().D() ? 2 : 1).param("obj_type", 3));
            MissionCustomDialogActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements SignItemView.b {
        public c() {
        }

        @Override // com.baidu.tbadk.widget.mission.SignItemView.b
        public void a(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            MissionCustomDialogActivity.this.applyBottomStatus(activeCenterStatusData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyBottomStatus(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        ActiveCenterData activeCenterData = this.mActiveCenterData;
        if (activeCenterData == null || activeCenterData.mission == null || activeCenterStatusData == null) {
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
        d.a.n0.r.f0.m.a aVar = new d.a.n0.r.f0.m.a();
        aVar.o(R.color.CAM_X0301);
        aVar.k(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
        this.mBottomActionBtn.setConfig(aVar);
        this.mBottomActionBtn.setTextSize(R.dimen.tbds34);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTask() {
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

    private void initView() {
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
        this.mImgClose.setOnClickListener(new b());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void processBrowseThreadTask() {
        if (TbadkCoreApplication.isLogin()) {
            s.g().d().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
    }

    private void processFinalAwardTask() {
        if (TbadkCoreApplication.isLogin()) {
            s.g().e().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
    }

    private void processFollowForumTask() {
        if (TbadkCoreApplication.isLogin()) {
            s.g().f().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
    }

    private void processNewUserRedPkgTask() {
        if (TbadkCoreApplication.isLogin()) {
            s.g().h().e(getPageContext());
            s.g().h().b();
            finish();
            return;
        }
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
    }

    private void processPushTask() {
        if (TbadkCoreApplication.isLogin()) {
            s.g().i().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
    }

    private void processShareThreadTask() {
        if (TbadkCoreApplication.isLogin()) {
            s.g().j().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
    }

    private void processSignRedPkgTask() {
        if (TbadkCoreApplication.isLogin()) {
            s.g().k().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getActivity(), true, 25046)));
    }

    private void setData() {
        ArrayList<ActiveCenterData.ActiveCenterStatusData> arrayList;
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

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 25046 && TbadkCoreApplication.isLogin()) {
            handleTask();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
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
            d.a.n0.r.f0.m.a aVar = new d.a.n0.r.f0.m.a();
            aVar.o(R.color.CAM_X0301);
            aVar.k(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.mBottomActionBtn.setConfig(aVar);
        }
        this.mSignView.e(i2);
        SkinManager.setImageResource(this.mImgClose, R.drawable.ic_icon_popup_close_n);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_mission_custom_dialog);
        initView();
        setData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        s.g().i().b();
    }
}
