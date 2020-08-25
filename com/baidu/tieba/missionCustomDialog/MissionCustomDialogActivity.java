package com.baidu.tieba.missionCustomDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.BdToken.c;
import com.baidu.tbadk.BdToken.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.a;
import com.baidu.tbadk.widget.mission.SignItemView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes16.dex */
public class MissionCustomDialogActivity extends BaseActivity {
    private ActiveCenterData dPQ;
    private ImageView fmw;
    private RoundRelativeLayout iQT;
    private TextView iQU;
    private TextView iQV;
    private TBSpecificationBtn iQW;
    private TextView iQX;
    private SignItemView kgA;
    private View.OnClickListener kgB = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.cQM();
        }
    };
    SignItemView.a kgC = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
        @Override // com.baidu.tbadk.widget.mission.SignItemView.a
        public void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            MissionCustomDialogActivity.this.d(activeCenterStatusData);
        }
    };
    private RoundRelativeLayout kgw;
    private ImageView kgx;
    private TextView kgy;
    private TextView kgz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_mission_custom_dialog);
        initView();
        setData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        q.aYY().aZh().aZn();
    }

    private void initView() {
        this.kgw = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.kgw.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.kgx = (ImageView) findViewById(R.id.dialog_background);
        this.fmw = (ImageView) findViewById(R.id.img_close);
        this.kgy = (TextView) findViewById(R.id.dialog_title);
        this.kgz = (TextView) findViewById(R.id.dialog_detail);
        this.kgA = (SignItemView) findViewById(R.id.sign_view);
        this.iQT = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.iQU = (TextView) findViewById(R.id.bottom_title);
        this.iQV = (TextView) findViewById(R.id.bottom_detail);
        this.iQW = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.iQX = (TextView) findViewById(R.id.bottom_btn_text);
        this.kgA.setItemClickListener(this.kgC);
        this.iQW.setOnClickListener(this.kgB);
        this.fmw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c13742").ai("obj_source", c.aYs().aYw() ? 2 : 1).ai("obj_type", 3));
                MissionCustomDialogActivity.this.finish();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void setData() {
        ActiveCenterData aZb = q.aYY().aZb();
        if (aZb == null || aZb.mission == null || aZb.mission_status_list == null || aZb.mission_status_list.size() <= 0) {
            finish();
            return;
        }
        q.aYY().hx(true);
        this.dPQ = aZb;
        this.kgy.setText(at.cutChineseAndEnglishWithSuffix(this.dPQ.win_title, 14, StringHelper.STRING_MORE));
        this.kgz.setText(at.cutChineseAndEnglishWithSuffix(this.dPQ.win_desc, 30, StringHelper.STRING_MORE));
        this.kgA.setData(aZb);
        d(this.dPQ.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.dPQ != null && this.dPQ.mission != null && activeCenterStatusData != null) {
            this.iQT.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.iQU;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.iQV;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.iQW.setVisibility(0);
                this.iQX.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.iQW.setText("已完成");
                    this.iQW.setClickable(false);
                    this.iQW.setEnabled(false);
                } else {
                    this.iQW.setText("已过期");
                    this.iQW.setClickable(false);
                    this.iQW.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.iQW.setVisibility(0);
                this.iQX.setVisibility(8);
                if (this.dPQ.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.iQW.setText("去领取");
                        this.iQW.setClickable(true);
                        this.iQW.setEnabled(true);
                    } else {
                        this.iQW.setText("未达标");
                        this.iQW.setClickable(false);
                        this.iQW.setEnabled(false);
                    }
                } else {
                    if (this.dPQ.mission.task_type == 6) {
                        if (q.aYY().aZh().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.iQW.setText("已完成");
                        this.iQW.setClickable(false);
                        this.iQW.setEnabled(false);
                    } else {
                        this.iQW.setText("去完成");
                        this.iQW.setClickable(true);
                        this.iQW.setEnabled(true);
                    }
                }
            } else {
                this.iQW.setVisibility(8);
                this.iQX.setVisibility(0);
                this.iQX.setText("未开始");
            }
            a aVar = new a();
            aVar.pb(R.color.cp_cont_h);
            aVar.oZ(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.iQW.setConfig(aVar);
            this.iQW.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.kgw, R.color.cp_bg_line_k);
        SvgManager.bjq().a(this.kgx, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.kgy, R.color.cp_other_e);
        ap.setViewTextColor(this.kgz, R.color.cp_cont_h);
        ap.setBackgroundColor(this.iQT, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.iQU, R.color.cp_cont_b);
        ap.setViewTextColor(this.iQV, R.color.cp_cont_d);
        ap.setViewTextColor(this.iQX, R.color.cp_cont_d);
        if (this.iQW != null) {
            a aVar = new a();
            aVar.pb(R.color.cp_cont_h);
            aVar.oZ(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.iQW.setConfig(aVar);
        }
        this.kgA.onChangeSkinType(i);
        ap.setImageResource(this.fmw, R.drawable.ic_icon_popup_close_n);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25046 && TbadkCoreApplication.isLogin()) {
            cQM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQM() {
        TiebaStatic.log(new aq("c13742").ai("obj_source", c.aYs().aYw() ? 2 : 1).ai("obj_type", 2));
        if (this.dPQ != null) {
            int curTaskType = this.dPQ.getCurTaskType();
            if (curTaskType == 12) {
                cQN();
            } else if (curTaskType == 6) {
                cQO();
            } else if (curTaskType == 10) {
                cQP();
            } else if (curTaskType == 7) {
                cQQ();
            } else if (curTaskType == 5) {
                cQR();
            } else if (curTaskType == 9) {
                cQS();
            } else if (curTaskType == 13) {
                cQT();
            }
        }
    }

    private void cQN() {
        if (TbadkCoreApplication.isLogin()) {
            q.aYY().aZg().e(getPageContext());
            q.aYY().aZg().aZn();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cQO() {
        if (TbadkCoreApplication.isLogin()) {
            q.aYY().aZh().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cQP() {
        if (TbadkCoreApplication.isLogin()) {
            q.aYY().aZi().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cQQ() {
        if (TbadkCoreApplication.isLogin()) {
            q.aYY().aZj().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cQR() {
        if (TbadkCoreApplication.isLogin()) {
            q.aYY().aZk().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cQS() {
        if (TbadkCoreApplication.isLogin()) {
            q.aYY().aZl().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cQT() {
        if (TbadkCoreApplication.isLogin()) {
            q.aYY().aZm().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
