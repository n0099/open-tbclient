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
    private ActiveCenterData eec;
    private ImageView fBS;
    private RoundRelativeLayout joF;
    private TextView joG;
    private TextView joH;
    private TBSpecificationBtn joI;
    private TextView joJ;
    private RoundRelativeLayout kEp;
    private ImageView kEq;
    private TextView kEr;
    private TextView kEs;
    private SignItemView kEt;
    private View.OnClickListener kEu = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.cYc();
        }
    };
    SignItemView.a kEv = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
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
        q.bct().bcC().bcI();
    }

    private void initView() {
        this.kEp = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.kEp.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.kEq = (ImageView) findViewById(R.id.dialog_background);
        this.fBS = (ImageView) findViewById(R.id.img_close);
        this.kEr = (TextView) findViewById(R.id.dialog_title);
        this.kEs = (TextView) findViewById(R.id.dialog_detail);
        this.kEt = (SignItemView) findViewById(R.id.sign_view);
        this.joF = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.joG = (TextView) findViewById(R.id.bottom_title);
        this.joH = (TextView) findViewById(R.id.bottom_detail);
        this.joI = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.joJ = (TextView) findViewById(R.id.bottom_btn_text);
        this.kEt.setItemClickListener(this.kEv);
        this.joI.setOnClickListener(this.kEu);
        this.fBS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c13742").aj("obj_source", c.bbM().bbR() ? 2 : 1).aj("obj_type", 3));
                MissionCustomDialogActivity.this.finish();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void setData() {
        ActiveCenterData bcw = q.bct().bcw();
        if (bcw == null || bcw.mission == null || bcw.mission_status_list == null || bcw.mission_status_list.size() <= 0) {
            finish();
            return;
        }
        q.bct().hR(true);
        this.eec = bcw;
        this.kEr.setText(at.cutChineseAndEnglishWithSuffix(this.eec.win_title, 14, StringHelper.STRING_MORE));
        this.kEs.setText(at.cutChineseAndEnglishWithSuffix(this.eec.win_desc, 30, StringHelper.STRING_MORE));
        this.kEt.setData(bcw);
        d(this.eec.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.eec != null && this.eec.mission != null && activeCenterStatusData != null) {
            this.joF.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.joG;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.joH;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.joI.setVisibility(0);
                this.joJ.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.joI.setText("已完成");
                    this.joI.setClickable(false);
                    this.joI.setEnabled(false);
                } else {
                    this.joI.setText("已过期");
                    this.joI.setClickable(false);
                    this.joI.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.joI.setVisibility(0);
                this.joJ.setVisibility(8);
                if (this.eec.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.joI.setText("去领取");
                        this.joI.setClickable(true);
                        this.joI.setEnabled(true);
                    } else {
                        this.joI.setText("未达标");
                        this.joI.setClickable(false);
                        this.joI.setEnabled(false);
                    }
                } else {
                    if (this.eec.mission.task_type == 6) {
                        if (q.bct().bcC().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.joI.setText("已完成");
                        this.joI.setClickable(false);
                        this.joI.setEnabled(false);
                    } else {
                        this.joI.setText("去完成");
                        this.joI.setClickable(true);
                        this.joI.setEnabled(true);
                    }
                }
            } else {
                this.joI.setVisibility(8);
                this.joJ.setVisibility(0);
                this.joJ.setText("未开始");
            }
            a aVar = new a();
            aVar.pN(R.color.cp_cont_h);
            aVar.pK(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.joI.setConfig(aVar);
            this.joI.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.kEp, R.color.cp_bg_line_k);
        SvgManager.bmU().a(this.kEq, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.kEr, R.color.cp_other_e);
        ap.setViewTextColor(this.kEs, R.color.cp_cont_h);
        ap.setBackgroundColor(this.joF, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.joG, R.color.cp_cont_b);
        ap.setViewTextColor(this.joH, R.color.cp_cont_d);
        ap.setViewTextColor(this.joJ, R.color.cp_cont_d);
        if (this.joI != null) {
            a aVar = new a();
            aVar.pN(R.color.cp_cont_h);
            aVar.pK(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.joI.setConfig(aVar);
        }
        this.kEt.onChangeSkinType(i);
        ap.setImageResource(this.fBS, R.drawable.ic_icon_popup_close_n);
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
            cYc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYc() {
        TiebaStatic.log(new aq("c13742").aj("obj_source", c.bbM().bbR() ? 2 : 1).aj("obj_type", 2));
        if (this.eec != null) {
            int curTaskType = this.eec.getCurTaskType();
            if (curTaskType == 12) {
                cYd();
            } else if (curTaskType == 6) {
                cYe();
            } else if (curTaskType == 10) {
                cYf();
            } else if (curTaskType == 7) {
                cYg();
            } else if (curTaskType == 5) {
                cYh();
            } else if (curTaskType == 9) {
                cYi();
            } else if (curTaskType == 13) {
                cYj();
            }
        }
    }

    private void cYd() {
        if (TbadkCoreApplication.isLogin()) {
            q.bct().bcB().e(getPageContext());
            q.bct().bcB().bcI();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cYe() {
        if (TbadkCoreApplication.isLogin()) {
            q.bct().bcC().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cYf() {
        if (TbadkCoreApplication.isLogin()) {
            q.bct().bcD().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cYg() {
        if (TbadkCoreApplication.isLogin()) {
            q.bct().bcE().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cYh() {
        if (TbadkCoreApplication.isLogin()) {
            q.bct().bcF().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cYi() {
        if (TbadkCoreApplication.isLogin()) {
            q.bct().bcG().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cYj() {
        if (TbadkCoreApplication.isLogin()) {
            q.bct().bcH().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
