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
    private ActiveCenterData eEA;
    private ImageView gfq;
    private RoundRelativeLayout ltL;
    private ImageView ltM;
    private TextView ltN;
    private TextView ltO;
    private SignItemView ltP;
    private RoundRelativeLayout ltQ;
    private TextView ltR;
    private TextView ltS;
    private TBSpecificationBtn ltT;
    private TextView ltU;
    private View.OnClickListener ltV = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.dgA();
        }
    };
    SignItemView.a ltW = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
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
        cHO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        q.bhU().bid().bij();
    }

    private void initView() {
        this.ltL = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.ltL.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.ltM = (ImageView) findViewById(R.id.dialog_background);
        this.gfq = (ImageView) findViewById(R.id.img_close);
        this.ltN = (TextView) findViewById(R.id.dialog_title);
        this.ltO = (TextView) findViewById(R.id.dialog_detail);
        this.ltP = (SignItemView) findViewById(R.id.sign_view);
        this.ltQ = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.ltR = (TextView) findViewById(R.id.bottom_title);
        this.ltS = (TextView) findViewById(R.id.bottom_detail);
        this.ltT = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.ltU = (TextView) findViewById(R.id.bottom_btn_text);
        this.ltP.setItemClickListener(this.ltW);
        this.ltT.setOnClickListener(this.ltV);
        this.gfq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c13742").ap("obj_source", c.bhn().bhs() ? 2 : 1).ap("obj_type", 3));
                MissionCustomDialogActivity.this.finish();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void cHO() {
        ActiveCenterData bhX = q.bhU().bhX();
        if (bhX == null || bhX.mission == null || bhX.mission_status_list == null || bhX.mission_status_list.size() <= 0) {
            finish();
            return;
        }
        q.bhU().iY(true);
        this.eEA = bhX;
        this.ltN.setText(au.cutChineseAndEnglishWithSuffix(this.eEA.win_title, 14, StringHelper.STRING_MORE));
        this.ltO.setText(au.cutChineseAndEnglishWithSuffix(this.eEA.win_desc, 30, StringHelper.STRING_MORE));
        this.ltP.setData(bhX);
        d(this.eEA.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.eEA != null && this.eEA.mission != null && activeCenterStatusData != null) {
            this.ltQ.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.ltR;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.ltS;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.ltT.setVisibility(0);
                this.ltU.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.ltT.setText("已完成");
                    this.ltT.setClickable(false);
                    this.ltT.setEnabled(false);
                } else {
                    this.ltT.setText("已过期");
                    this.ltT.setClickable(false);
                    this.ltT.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.ltT.setVisibility(0);
                this.ltU.setVisibility(8);
                if (this.eEA.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.ltT.setText("去领取");
                        this.ltT.setClickable(true);
                        this.ltT.setEnabled(true);
                    } else {
                        this.ltT.setText("未达标");
                        this.ltT.setClickable(false);
                        this.ltT.setEnabled(false);
                    }
                } else {
                    if (this.eEA.mission.task_type == 6) {
                        if (q.bhU().bid().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.ltT.setText("已完成");
                        this.ltT.setClickable(false);
                        this.ltT.setEnabled(false);
                    } else {
                        this.ltT.setText("去完成");
                        this.ltT.setClickable(true);
                        this.ltT.setEnabled(true);
                    }
                }
            } else {
                this.ltT.setVisibility(8);
                this.ltU.setVisibility(0);
                this.ltU.setText("未开始");
            }
            a aVar = new a();
            aVar.pR(R.color.CAM_X0301);
            aVar.pO(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.ltT.setConfig(aVar);
            this.ltT.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.ltL, R.color.CAM_X0211);
        SvgManager.bsR().a(this.ltM, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.ltN, R.color.CAM_X0311);
        ap.setViewTextColor(this.ltO, R.color.CAM_X0301);
        ap.setBackgroundColor(this.ltQ, R.color.CAM_X0204);
        ap.setViewTextColor(this.ltR, R.color.CAM_X0105);
        ap.setViewTextColor(this.ltS, R.color.CAM_X0109);
        ap.setViewTextColor(this.ltU, R.color.CAM_X0109);
        if (this.ltT != null) {
            a aVar = new a();
            aVar.pR(R.color.CAM_X0301);
            aVar.pO(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.ltT.setConfig(aVar);
        }
        this.ltP.onChangeSkinType(i);
        ap.setImageResource(this.gfq, R.drawable.ic_icon_popup_close_n);
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
            dgA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgA() {
        TiebaStatic.log(new ar("c13742").ap("obj_source", c.bhn().bhs() ? 2 : 1).ap("obj_type", 2));
        if (this.eEA != null) {
            int curTaskType = this.eEA.getCurTaskType();
            if (curTaskType == 12) {
                dgB();
            } else if (curTaskType == 6) {
                dgC();
            } else if (curTaskType == 10) {
                dgD();
            } else if (curTaskType == 7) {
                dgE();
            } else if (curTaskType == 5) {
                dgF();
            } else if (curTaskType == 9) {
                dgG();
            } else if (curTaskType == 13) {
                dgH();
            }
        }
    }

    private void dgB() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhU().bic().e(getPageContext());
            q.bhU().bic().bij();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dgC() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhU().bid().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dgD() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhU().bie().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dgE() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhU().bif().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dgF() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhU().big().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dgG() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhU().bih().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dgH() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhU().bii().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
