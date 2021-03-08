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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.a;
import com.baidu.tbadk.widget.mission.SignItemView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes2.dex */
public class MissionCustomDialogActivity extends BaseActivity {
    private ActiveCenterData eGb;
    private ImageView ggT;
    private RoundRelativeLayout lvN;
    private ImageView lvO;
    private TextView lvP;
    private TextView lvQ;
    private SignItemView lvR;
    private RoundRelativeLayout lvS;
    private TextView lvT;
    private TextView lvU;
    private TBSpecificationBtn lvV;
    private TextView lvW;
    private View.OnClickListener lvX = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.dgJ();
        }
    };
    SignItemView.a lvY = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
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
        cHU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        q.bhW().bif().bil();
    }

    private void initView() {
        this.lvN = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.lvN.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.lvO = (ImageView) findViewById(R.id.dialog_background);
        this.ggT = (ImageView) findViewById(R.id.img_close);
        this.lvP = (TextView) findViewById(R.id.dialog_title);
        this.lvQ = (TextView) findViewById(R.id.dialog_detail);
        this.lvR = (SignItemView) findViewById(R.id.sign_view);
        this.lvS = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.lvT = (TextView) findViewById(R.id.bottom_title);
        this.lvU = (TextView) findViewById(R.id.bottom_detail);
        this.lvV = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.lvW = (TextView) findViewById(R.id.bottom_btn_text);
        this.lvR.setItemClickListener(this.lvY);
        this.lvV.setOnClickListener(this.lvX);
        this.ggT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c13742").aq("obj_source", c.bhp().bhu() ? 2 : 1).aq("obj_type", 3));
                MissionCustomDialogActivity.this.finish();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void cHU() {
        ActiveCenterData bhZ = q.bhW().bhZ();
        if (bhZ == null || bhZ.mission == null || bhZ.mission_status_list == null || bhZ.mission_status_list.size() <= 0) {
            finish();
            return;
        }
        q.bhW().iY(true);
        this.eGb = bhZ;
        this.lvP.setText(au.cutChineseAndEnglishWithSuffix(this.eGb.win_title, 14, StringHelper.STRING_MORE));
        this.lvQ.setText(au.cutChineseAndEnglishWithSuffix(this.eGb.win_desc, 30, StringHelper.STRING_MORE));
        this.lvR.setData(bhZ);
        d(this.eGb.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.eGb != null && this.eGb.mission != null && activeCenterStatusData != null) {
            this.lvS.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.lvT;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.lvU;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.lvV.setVisibility(0);
                this.lvW.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.lvV.setText("已完成");
                    this.lvV.setClickable(false);
                    this.lvV.setEnabled(false);
                } else {
                    this.lvV.setText("已过期");
                    this.lvV.setClickable(false);
                    this.lvV.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.lvV.setVisibility(0);
                this.lvW.setVisibility(8);
                if (this.eGb.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.lvV.setText("去领取");
                        this.lvV.setClickable(true);
                        this.lvV.setEnabled(true);
                    } else {
                        this.lvV.setText("未达标");
                        this.lvV.setClickable(false);
                        this.lvV.setEnabled(false);
                    }
                } else {
                    if (this.eGb.mission.task_type == 6) {
                        if (q.bhW().bif().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.lvV.setText("已完成");
                        this.lvV.setClickable(false);
                        this.lvV.setEnabled(false);
                    } else {
                        this.lvV.setText("去完成");
                        this.lvV.setClickable(true);
                        this.lvV.setEnabled(true);
                    }
                }
            } else {
                this.lvV.setVisibility(8);
                this.lvW.setVisibility(0);
                this.lvW.setText("未开始");
            }
            a aVar = new a();
            aVar.pS(R.color.CAM_X0301);
            aVar.pP(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.lvV.setConfig(aVar);
            this.lvV.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.lvN, R.color.CAM_X0211);
        SvgManager.bsU().a(this.lvO, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.lvP, R.color.CAM_X0311);
        ap.setViewTextColor(this.lvQ, R.color.CAM_X0301);
        ap.setBackgroundColor(this.lvS, R.color.CAM_X0204);
        ap.setViewTextColor(this.lvT, R.color.CAM_X0105);
        ap.setViewTextColor(this.lvU, R.color.CAM_X0109);
        ap.setViewTextColor(this.lvW, R.color.CAM_X0109);
        if (this.lvV != null) {
            a aVar = new a();
            aVar.pS(R.color.CAM_X0301);
            aVar.pP(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.lvV.setConfig(aVar);
        }
        this.lvR.onChangeSkinType(i);
        ap.setImageResource(this.ggT, R.drawable.ic_icon_popup_close_n);
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
            dgJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgJ() {
        TiebaStatic.log(new ar("c13742").aq("obj_source", c.bhp().bhu() ? 2 : 1).aq("obj_type", 2));
        if (this.eGb != null) {
            int curTaskType = this.eGb.getCurTaskType();
            if (curTaskType == 12) {
                dgK();
            } else if (curTaskType == 6) {
                dgL();
            } else if (curTaskType == 10) {
                dgM();
            } else if (curTaskType == 7) {
                dgN();
            } else if (curTaskType == 5) {
                dgO();
            } else if (curTaskType == 9) {
                dgP();
            } else if (curTaskType == 13) {
                dgQ();
            }
        }
    }

    private void dgK() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhW().bie().e(getPageContext());
            q.bhW().bie().bil();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dgL() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhW().bif().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dgM() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhW().big().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dgN() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhW().bih().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dgO() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhW().bii().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dgP() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhW().bij().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dgQ() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhW().bik().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
