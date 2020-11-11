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
/* loaded from: classes22.dex */
public class MissionCustomDialogActivity extends BaseActivity {
    private ActiveCenterData est;
    private ImageView fQd;
    private RoundRelativeLayout jHc;
    private TextView jHd;
    private TextView jHe;
    private TBSpecificationBtn jHf;
    private TextView jHg;
    private RoundRelativeLayout kWI;
    private ImageView kWJ;
    private TextView kWK;
    private TextView kWL;
    private SignItemView kWM;
    private View.OnClickListener kWN = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.ddM();
        }
    };
    SignItemView.a kWO = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
        @Override // com.baidu.tbadk.widget.mission.SignItemView.a
        public void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            MissionCustomDialogActivity.this.d(activeCenterStatusData);
        }
    };

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
        q.bgM().bgV().bhb();
    }

    private void initView() {
        this.kWI = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.kWI.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.kWJ = (ImageView) findViewById(R.id.dialog_background);
        this.fQd = (ImageView) findViewById(R.id.img_close);
        this.kWK = (TextView) findViewById(R.id.dialog_title);
        this.kWL = (TextView) findViewById(R.id.dialog_detail);
        this.kWM = (SignItemView) findViewById(R.id.sign_view);
        this.jHc = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.jHd = (TextView) findViewById(R.id.bottom_title);
        this.jHe = (TextView) findViewById(R.id.bottom_detail);
        this.jHf = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.jHg = (TextView) findViewById(R.id.bottom_btn_text);
        this.kWM.setItemClickListener(this.kWO);
        this.jHf.setOnClickListener(this.kWN);
        this.fQd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c13742").al("obj_source", c.bgf().bgk() ? 2 : 1).al("obj_type", 3));
                MissionCustomDialogActivity.this.finish();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void setData() {
        ActiveCenterData bgP = q.bgM().bgP();
        if (bgP == null || bgP.mission == null || bgP.mission_status_list == null || bgP.mission_status_list.size() <= 0) {
            finish();
            return;
        }
        q.bgM().in(true);
        this.est = bgP;
        this.kWK.setText(at.cutChineseAndEnglishWithSuffix(this.est.win_title, 14, StringHelper.STRING_MORE));
        this.kWL.setText(at.cutChineseAndEnglishWithSuffix(this.est.win_desc, 30, StringHelper.STRING_MORE));
        this.kWM.setData(bgP);
        d(this.est.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.est != null && this.est.mission != null && activeCenterStatusData != null) {
            this.jHc.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.jHd;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.jHe;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.jHf.setVisibility(0);
                this.jHg.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.jHf.setText("已完成");
                    this.jHf.setClickable(false);
                    this.jHf.setEnabled(false);
                } else {
                    this.jHf.setText("已过期");
                    this.jHf.setClickable(false);
                    this.jHf.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.jHf.setVisibility(0);
                this.jHg.setVisibility(8);
                if (this.est.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.jHf.setText("去领取");
                        this.jHf.setClickable(true);
                        this.jHf.setEnabled(true);
                    } else {
                        this.jHf.setText("未达标");
                        this.jHf.setClickable(false);
                        this.jHf.setEnabled(false);
                    }
                } else {
                    if (this.est.mission.task_type == 6) {
                        if (q.bgM().bgV().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.jHf.setText("已完成");
                        this.jHf.setClickable(false);
                        this.jHf.setEnabled(false);
                    } else {
                        this.jHf.setText("去完成");
                        this.jHf.setClickable(true);
                        this.jHf.setEnabled(true);
                    }
                }
            } else {
                this.jHf.setVisibility(8);
                this.jHg.setVisibility(0);
                this.jHg.setText("未开始");
            }
            a aVar = new a();
            aVar.qi(R.color.cp_cont_h);
            aVar.qf(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.jHf.setConfig(aVar);
            this.jHf.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.kWI, R.color.cp_bg_line_k);
        SvgManager.brn().a(this.kWJ, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.kWK, R.color.cp_other_e);
        ap.setViewTextColor(this.kWL, R.color.cp_cont_h);
        ap.setBackgroundColor(this.jHc, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.jHd, R.color.cp_cont_b);
        ap.setViewTextColor(this.jHe, R.color.cp_cont_d);
        ap.setViewTextColor(this.jHg, R.color.cp_cont_d);
        if (this.jHf != null) {
            a aVar = new a();
            aVar.qi(R.color.cp_cont_h);
            aVar.qf(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.jHf.setConfig(aVar);
        }
        this.kWM.onChangeSkinType(i);
        ap.setImageResource(this.fQd, R.drawable.ic_icon_popup_close_n);
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
            ddM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddM() {
        TiebaStatic.log(new aq("c13742").al("obj_source", c.bgf().bgk() ? 2 : 1).al("obj_type", 2));
        if (this.est != null) {
            int curTaskType = this.est.getCurTaskType();
            if (curTaskType == 12) {
                ddN();
            } else if (curTaskType == 6) {
                ddO();
            } else if (curTaskType == 10) {
                ddP();
            } else if (curTaskType == 7) {
                ddQ();
            } else if (curTaskType == 5) {
                ddR();
            } else if (curTaskType == 9) {
                ddS();
            } else if (curTaskType == 13) {
                ddT();
            }
        }
    }

    private void ddN() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgM().bgU().e(getPageContext());
            q.bgM().bgU().bhb();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void ddO() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgM().bgV().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void ddP() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgM().bgW().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void ddQ() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgM().bgX().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void ddR() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgM().bgY().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void ddS() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgM().bgZ().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void ddT() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgM().bha().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
