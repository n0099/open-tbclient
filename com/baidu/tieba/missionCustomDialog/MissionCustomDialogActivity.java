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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.a;
import com.baidu.tbadk.widget.mission.SignItemView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes2.dex */
public class MissionCustomDialogActivity extends BaseActivity {
    private ActiveCenterData eHe;
    private ImageView ghE;
    private RoundRelativeLayout lqa;
    private ImageView lqb;
    private TextView lqc;
    private TextView lqd;
    private SignItemView lqe;
    private RoundRelativeLayout lqf;
    private TextView lqg;
    private TextView lqh;
    private TBSpecificationBtn lqi;
    private TextView lqj;
    private View.OnClickListener lqk = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.dik();
        }
    };
    SignItemView.a lql = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
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
        cKl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        q.blA().blJ().blP();
    }

    private void initView() {
        this.lqa = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.lqa.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.lqb = (ImageView) findViewById(R.id.dialog_background);
        this.ghE = (ImageView) findViewById(R.id.img_close);
        this.lqc = (TextView) findViewById(R.id.dialog_title);
        this.lqd = (TextView) findViewById(R.id.dialog_detail);
        this.lqe = (SignItemView) findViewById(R.id.sign_view);
        this.lqf = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.lqg = (TextView) findViewById(R.id.bottom_title);
        this.lqh = (TextView) findViewById(R.id.bottom_detail);
        this.lqi = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.lqj = (TextView) findViewById(R.id.bottom_btn_text);
        this.lqe.setItemClickListener(this.lql);
        this.lqi.setOnClickListener(this.lqk);
        this.ghE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c13742").an("obj_source", c.bkT().bkY() ? 2 : 1).an("obj_type", 3));
                MissionCustomDialogActivity.this.finish();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void cKl() {
        ActiveCenterData blD = q.blA().blD();
        if (blD == null || blD.mission == null || blD.mission_status_list == null || blD.mission_status_list.size() <= 0) {
            finish();
            return;
        }
        q.blA().ja(true);
        this.eHe = blD;
        this.lqc.setText(at.cutChineseAndEnglishWithSuffix(this.eHe.win_title, 14, StringHelper.STRING_MORE));
        this.lqd.setText(at.cutChineseAndEnglishWithSuffix(this.eHe.win_desc, 30, StringHelper.STRING_MORE));
        this.lqe.setData(blD);
        d(this.eHe.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.eHe != null && this.eHe.mission != null && activeCenterStatusData != null) {
            this.lqf.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.lqg;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.lqh;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.lqi.setVisibility(0);
                this.lqj.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.lqi.setText("已完成");
                    this.lqi.setClickable(false);
                    this.lqi.setEnabled(false);
                } else {
                    this.lqi.setText("已过期");
                    this.lqi.setClickable(false);
                    this.lqi.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.lqi.setVisibility(0);
                this.lqj.setVisibility(8);
                if (this.eHe.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.lqi.setText("去领取");
                        this.lqi.setClickable(true);
                        this.lqi.setEnabled(true);
                    } else {
                        this.lqi.setText("未达标");
                        this.lqi.setClickable(false);
                        this.lqi.setEnabled(false);
                    }
                } else {
                    if (this.eHe.mission.task_type == 6) {
                        if (q.blA().blJ().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.lqi.setText("已完成");
                        this.lqi.setClickable(false);
                        this.lqi.setEnabled(false);
                    } else {
                        this.lqi.setText("去完成");
                        this.lqi.setClickable(true);
                        this.lqi.setEnabled(true);
                    }
                }
            } else {
                this.lqi.setVisibility(8);
                this.lqj.setVisibility(0);
                this.lqj.setText("未开始");
            }
            a aVar = new a();
            aVar.rs(R.color.CAM_X0301);
            aVar.rp(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.lqi.setConfig(aVar);
            this.lqi.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.lqa, R.color.CAM_X0211);
        SvgManager.bwq().a(this.lqb, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.lqc, R.color.CAM_X0311);
        ao.setViewTextColor(this.lqd, R.color.CAM_X0301);
        ao.setBackgroundColor(this.lqf, R.color.CAM_X0204);
        ao.setViewTextColor(this.lqg, R.color.CAM_X0105);
        ao.setViewTextColor(this.lqh, R.color.CAM_X0109);
        ao.setViewTextColor(this.lqj, R.color.CAM_X0109);
        if (this.lqi != null) {
            a aVar = new a();
            aVar.rs(R.color.CAM_X0301);
            aVar.rp(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.lqi.setConfig(aVar);
        }
        this.lqe.onChangeSkinType(i);
        ao.setImageResource(this.ghE, R.drawable.ic_icon_popup_close_n);
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
            dik();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dik() {
        TiebaStatic.log(new aq("c13742").an("obj_source", c.bkT().bkY() ? 2 : 1).an("obj_type", 2));
        if (this.eHe != null) {
            int curTaskType = this.eHe.getCurTaskType();
            if (curTaskType == 12) {
                dil();
            } else if (curTaskType == 6) {
                dim();
            } else if (curTaskType == 10) {
                din();
            } else if (curTaskType == 7) {
                dio();
            } else if (curTaskType == 5) {
                dip();
            } else if (curTaskType == 9) {
                diq();
            } else if (curTaskType == 13) {
                dir();
            }
        }
    }

    private void dil() {
        if (TbadkCoreApplication.isLogin()) {
            q.blA().blI().e(getPageContext());
            q.blA().blI().blP();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dim() {
        if (TbadkCoreApplication.isLogin()) {
            q.blA().blJ().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void din() {
        if (TbadkCoreApplication.isLogin()) {
            q.blA().blK().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dio() {
        if (TbadkCoreApplication.isLogin()) {
            q.blA().blL().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dip() {
        if (TbadkCoreApplication.isLogin()) {
            q.blA().blM().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void diq() {
        if (TbadkCoreApplication.isLogin()) {
            q.blA().blN().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dir() {
        if (TbadkCoreApplication.isLogin()) {
            q.blA().blO().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
