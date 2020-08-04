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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tbadk.widget.mission.SignItemView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes16.dex */
public class MissionCustomDialogActivity extends BaseActivity {
    private ActiveCenterData dGJ;
    private ImageView fbc;
    private RoundRelativeLayout iCb;
    private TextView iCc;
    private TextView iCd;
    private TBSpecificationBtn iCe;
    private TextView iCf;
    private RoundRelativeLayout jRd;
    private ImageView jRe;
    private TextView jRf;
    private TextView jRg;
    private SignItemView jRh;
    private View.OnClickListener jRi = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.cFX();
        }
    };
    SignItemView.a jRj = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
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
        q.aQI().aQR().aQX();
    }

    private void initView() {
        this.jRd = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.jRd.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.jRe = (ImageView) findViewById(R.id.dialog_background);
        this.fbc = (ImageView) findViewById(R.id.img_close);
        this.jRf = (TextView) findViewById(R.id.dialog_title);
        this.jRg = (TextView) findViewById(R.id.dialog_detail);
        this.jRh = (SignItemView) findViewById(R.id.sign_view);
        this.iCb = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.iCc = (TextView) findViewById(R.id.bottom_title);
        this.iCd = (TextView) findViewById(R.id.bottom_detail);
        this.iCe = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.iCf = (TextView) findViewById(R.id.bottom_btn_text);
        this.jRh.setItemClickListener(this.jRj);
        this.iCe.setOnClickListener(this.jRi);
        this.fbc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ap("c13742").ah("obj_source", c.aQc().aQg() ? 2 : 1).ah("obj_type", 3));
                MissionCustomDialogActivity.this.finish();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void setData() {
        ActiveCenterData aQL = q.aQI().aQL();
        if (aQL == null || aQL.mission == null || aQL.mission_status_list == null || aQL.mission_status_list.size() <= 0) {
            finish();
            return;
        }
        q.aQI().hb(true);
        this.dGJ = aQL;
        this.jRf.setText(as.cutChineseAndEnglishWithSuffix(this.dGJ.win_title, 14, StringHelper.STRING_MORE));
        this.jRg.setText(as.cutChineseAndEnglishWithSuffix(this.dGJ.win_desc, 30, StringHelper.STRING_MORE));
        this.jRh.setData(aQL);
        d(this.dGJ.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.dGJ != null && this.dGJ.mission != null && activeCenterStatusData != null) {
            this.iCb.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.iCc;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.iCd;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.iCe.setVisibility(0);
                this.iCf.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.iCe.setText("已完成");
                    this.iCe.setClickable(false);
                    this.iCe.setEnabled(false);
                } else {
                    this.iCe.setText("已过期");
                    this.iCe.setClickable(false);
                    this.iCe.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.iCe.setVisibility(0);
                this.iCf.setVisibility(8);
                if (this.dGJ.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.iCe.setText("去领取");
                        this.iCe.setClickable(true);
                        this.iCe.setEnabled(true);
                    } else {
                        this.iCe.setText("未达标");
                        this.iCe.setClickable(false);
                        this.iCe.setEnabled(false);
                    }
                } else {
                    if (this.dGJ.mission.task_type == 6) {
                        if (q.aQI().aQR().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.iCe.setText("已完成");
                        this.iCe.setClickable(false);
                        this.iCe.setEnabled(false);
                    } else {
                        this.iCe.setText("去完成");
                        this.iCe.setClickable(true);
                        this.iCe.setEnabled(true);
                    }
                }
            } else {
                this.iCe.setVisibility(8);
                this.iCf.setVisibility(0);
                this.iCf.setText("未开始");
            }
            b bVar = new b();
            bVar.mV(R.color.cp_cont_h);
            bVar.mT(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.iCe.setConfig(bVar);
            this.iCe.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.jRd, R.color.cp_bg_line_k);
        SvgManager.baR().a(this.jRe, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.jRf, R.color.cp_other_e);
        ao.setViewTextColor(this.jRg, R.color.cp_cont_h);
        ao.setBackgroundColor(this.iCb, R.color.cp_bg_line_c);
        ao.setViewTextColor(this.iCc, R.color.cp_cont_b);
        ao.setViewTextColor(this.iCd, R.color.cp_cont_d);
        ao.setViewTextColor(this.iCf, R.color.cp_cont_d);
        if (this.iCe != null) {
            b bVar = new b();
            bVar.mV(R.color.cp_cont_h);
            bVar.mT(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.iCe.setConfig(bVar);
        }
        this.jRh.onChangeSkinType(i);
        ao.setImageResource(this.fbc, R.drawable.ic_icon_popup_close_n);
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
            cFX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFX() {
        TiebaStatic.log(new ap("c13742").ah("obj_source", c.aQc().aQg() ? 2 : 1).ah("obj_type", 2));
        if (this.dGJ != null) {
            int curTaskType = this.dGJ.getCurTaskType();
            if (curTaskType == 12) {
                cFY();
            } else if (curTaskType == 6) {
                cFZ();
            } else if (curTaskType == 10) {
                cGa();
            } else if (curTaskType == 7) {
                cGb();
            } else if (curTaskType == 5) {
                cGc();
            } else if (curTaskType == 9) {
                cGd();
            } else if (curTaskType == 13) {
                cGe();
            }
        }
    }

    private void cFY() {
        if (TbadkCoreApplication.isLogin()) {
            q.aQI().aQQ().e(getPageContext());
            q.aQI().aQQ().aQX();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cFZ() {
        if (TbadkCoreApplication.isLogin()) {
            q.aQI().aQR().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cGa() {
        if (TbadkCoreApplication.isLogin()) {
            q.aQI().aQS().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cGb() {
        if (TbadkCoreApplication.isLogin()) {
            q.aQI().aQT().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cGc() {
        if (TbadkCoreApplication.isLogin()) {
            q.aQI().aQU().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cGd() {
        if (TbadkCoreApplication.isLogin()) {
            q.aQI().aQV().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cGe() {
        if (TbadkCoreApplication.isLogin()) {
            q.aQI().aQW().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
