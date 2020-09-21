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
/* loaded from: classes21.dex */
public class MissionCustomDialogActivity extends BaseActivity {
    private ActiveCenterData dSb;
    private ImageView fpF;
    private RoundRelativeLayout iZG;
    private TextView iZH;
    private TextView iZI;
    private TBSpecificationBtn iZJ;
    private TextView iZK;
    private RoundRelativeLayout kpd;
    private ImageView kpe;
    private TextView kpf;
    private TextView kpg;
    private SignItemView kph;
    private View.OnClickListener kpi = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.cUt();
        }
    };
    SignItemView.a kpj = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
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
        q.aZL().aZU().baa();
    }

    private void initView() {
        this.kpd = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.kpd.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.kpe = (ImageView) findViewById(R.id.dialog_background);
        this.fpF = (ImageView) findViewById(R.id.img_close);
        this.kpf = (TextView) findViewById(R.id.dialog_title);
        this.kpg = (TextView) findViewById(R.id.dialog_detail);
        this.kph = (SignItemView) findViewById(R.id.sign_view);
        this.iZG = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.iZH = (TextView) findViewById(R.id.bottom_title);
        this.iZI = (TextView) findViewById(R.id.bottom_detail);
        this.iZJ = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.iZK = (TextView) findViewById(R.id.bottom_btn_text);
        this.kph.setItemClickListener(this.kpj);
        this.iZJ.setOnClickListener(this.kpi);
        this.fpF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c13742").ai("obj_source", c.aZe().aZj() ? 2 : 1).ai("obj_type", 3));
                MissionCustomDialogActivity.this.finish();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void setData() {
        ActiveCenterData aZO = q.aZL().aZO();
        if (aZO == null || aZO.mission == null || aZO.mission_status_list == null || aZO.mission_status_list.size() <= 0) {
            finish();
            return;
        }
        q.aZL().hv(true);
        this.dSb = aZO;
        this.kpf.setText(at.cutChineseAndEnglishWithSuffix(this.dSb.win_title, 14, StringHelper.STRING_MORE));
        this.kpg.setText(at.cutChineseAndEnglishWithSuffix(this.dSb.win_desc, 30, StringHelper.STRING_MORE));
        this.kph.setData(aZO);
        d(this.dSb.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.dSb != null && this.dSb.mission != null && activeCenterStatusData != null) {
            this.iZG.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.iZH;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.iZI;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.iZJ.setVisibility(0);
                this.iZK.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.iZJ.setText("已完成");
                    this.iZJ.setClickable(false);
                    this.iZJ.setEnabled(false);
                } else {
                    this.iZJ.setText("已过期");
                    this.iZJ.setClickable(false);
                    this.iZJ.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.iZJ.setVisibility(0);
                this.iZK.setVisibility(8);
                if (this.dSb.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.iZJ.setText("去领取");
                        this.iZJ.setClickable(true);
                        this.iZJ.setEnabled(true);
                    } else {
                        this.iZJ.setText("未达标");
                        this.iZJ.setClickable(false);
                        this.iZJ.setEnabled(false);
                    }
                } else {
                    if (this.dSb.mission.task_type == 6) {
                        if (q.aZL().aZU().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.iZJ.setText("已完成");
                        this.iZJ.setClickable(false);
                        this.iZJ.setEnabled(false);
                    } else {
                        this.iZJ.setText("去完成");
                        this.iZJ.setClickable(true);
                        this.iZJ.setEnabled(true);
                    }
                }
            } else {
                this.iZJ.setVisibility(8);
                this.iZK.setVisibility(0);
                this.iZK.setText("未开始");
            }
            a aVar = new a();
            aVar.pp(R.color.cp_cont_h);
            aVar.pl(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.iZJ.setConfig(aVar);
            this.iZJ.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.kpd, R.color.cp_bg_line_k);
        SvgManager.bkl().a(this.kpe, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.kpf, R.color.cp_other_e);
        ap.setViewTextColor(this.kpg, R.color.cp_cont_h);
        ap.setBackgroundColor(this.iZG, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.iZH, R.color.cp_cont_b);
        ap.setViewTextColor(this.iZI, R.color.cp_cont_d);
        ap.setViewTextColor(this.iZK, R.color.cp_cont_d);
        if (this.iZJ != null) {
            a aVar = new a();
            aVar.pp(R.color.cp_cont_h);
            aVar.pl(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.iZJ.setConfig(aVar);
        }
        this.kph.onChangeSkinType(i);
        ap.setImageResource(this.fpF, R.drawable.ic_icon_popup_close_n);
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
            cUt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUt() {
        TiebaStatic.log(new aq("c13742").ai("obj_source", c.aZe().aZj() ? 2 : 1).ai("obj_type", 2));
        if (this.dSb != null) {
            int curTaskType = this.dSb.getCurTaskType();
            if (curTaskType == 12) {
                cUu();
            } else if (curTaskType == 6) {
                cUv();
            } else if (curTaskType == 10) {
                cUw();
            } else if (curTaskType == 7) {
                cUx();
            } else if (curTaskType == 5) {
                cUy();
            } else if (curTaskType == 9) {
                cUz();
            } else if (curTaskType == 13) {
                cUA();
            }
        }
    }

    private void cUu() {
        if (TbadkCoreApplication.isLogin()) {
            q.aZL().aZT().e(getPageContext());
            q.aZL().aZT().baa();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cUv() {
        if (TbadkCoreApplication.isLogin()) {
            q.aZL().aZU().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cUw() {
        if (TbadkCoreApplication.isLogin()) {
            q.aZL().aZV().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cUx() {
        if (TbadkCoreApplication.isLogin()) {
            q.aZL().aZW().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cUy() {
        if (TbadkCoreApplication.isLogin()) {
            q.aZL().aZX().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cUz() {
        if (TbadkCoreApplication.isLogin()) {
            q.aZL().aZY().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cUA() {
        if (TbadkCoreApplication.isLogin()) {
            q.aZL().aZZ().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
