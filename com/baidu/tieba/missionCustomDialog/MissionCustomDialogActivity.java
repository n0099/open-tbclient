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
/* loaded from: classes21.dex */
public class MissionCustomDialogActivity extends BaseActivity {
    private ActiveCenterData eqN;
    private ImageView fPM;
    private RoundRelativeLayout kWV;
    private ImageView kWW;
    private TextView kWX;
    private TextView kWY;
    private SignItemView kWZ;
    private RoundRelativeLayout kXa;
    private TextView kXb;
    private TextView kXc;
    private TBSpecificationBtn kXd;
    private TextView kXe;
    private View.OnClickListener kXf = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.ddj();
        }
    };
    SignItemView.a kXg = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
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
        q.bgf().bgo().bgu();
    }

    private void initView() {
        this.kWV = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.kWV.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.kWW = (ImageView) findViewById(R.id.dialog_background);
        this.fPM = (ImageView) findViewById(R.id.img_close);
        this.kWX = (TextView) findViewById(R.id.dialog_title);
        this.kWY = (TextView) findViewById(R.id.dialog_detail);
        this.kWZ = (SignItemView) findViewById(R.id.sign_view);
        this.kXa = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.kXb = (TextView) findViewById(R.id.bottom_title);
        this.kXc = (TextView) findViewById(R.id.bottom_detail);
        this.kXd = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.kXe = (TextView) findViewById(R.id.bottom_btn_text);
        this.kWZ.setItemClickListener(this.kXg);
        this.kXd.setOnClickListener(this.kXf);
        this.fPM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c13742").ak("obj_source", c.bfy().bfD() ? 2 : 1).ak("obj_type", 3));
                MissionCustomDialogActivity.this.finish();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void setData() {
        ActiveCenterData bgi = q.bgf().bgi();
        if (bgi == null || bgi.mission == null || bgi.mission_status_list == null || bgi.mission_status_list.size() <= 0) {
            finish();
            return;
        }
        q.bgf().iq(true);
        this.eqN = bgi;
        this.kWX.setText(au.cutChineseAndEnglishWithSuffix(this.eqN.win_title, 14, StringHelper.STRING_MORE));
        this.kWY.setText(au.cutChineseAndEnglishWithSuffix(this.eqN.win_desc, 30, StringHelper.STRING_MORE));
        this.kWZ.setData(bgi);
        d(this.eqN.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.eqN != null && this.eqN.mission != null && activeCenterStatusData != null) {
            this.kXa.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.kXb;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.kXc;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.kXd.setVisibility(0);
                this.kXe.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.kXd.setText("已完成");
                    this.kXd.setClickable(false);
                    this.kXd.setEnabled(false);
                } else {
                    this.kXd.setText("已过期");
                    this.kXd.setClickable(false);
                    this.kXd.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.kXd.setVisibility(0);
                this.kXe.setVisibility(8);
                if (this.eqN.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.kXd.setText("去领取");
                        this.kXd.setClickable(true);
                        this.kXd.setEnabled(true);
                    } else {
                        this.kXd.setText("未达标");
                        this.kXd.setClickable(false);
                        this.kXd.setEnabled(false);
                    }
                } else {
                    if (this.eqN.mission.task_type == 6) {
                        if (q.bgf().bgo().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.kXd.setText("已完成");
                        this.kXd.setClickable(false);
                        this.kXd.setEnabled(false);
                    } else {
                        this.kXd.setText("去完成");
                        this.kXd.setClickable(true);
                        this.kXd.setEnabled(true);
                    }
                }
            } else {
                this.kXd.setVisibility(8);
                this.kXe.setVisibility(0);
                this.kXe.setText("未开始");
            }
            a aVar = new a();
            aVar.qG(R.color.CAM_X0301);
            aVar.qD(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.kXd.setConfig(aVar);
            this.kXd.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.kWV, R.color.CAM_X0211);
        SvgManager.bqB().a(this.kWW, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.kWX, R.color.CAM_X0311);
        ap.setViewTextColor(this.kWY, R.color.CAM_X0301);
        ap.setBackgroundColor(this.kXa, R.color.CAM_X0204);
        ap.setViewTextColor(this.kXb, R.color.CAM_X0105);
        ap.setViewTextColor(this.kXc, R.color.CAM_X0109);
        ap.setViewTextColor(this.kXe, R.color.CAM_X0109);
        if (this.kXd != null) {
            a aVar = new a();
            aVar.qG(R.color.CAM_X0301);
            aVar.qD(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.kXd.setConfig(aVar);
        }
        this.kWZ.onChangeSkinType(i);
        ap.setImageResource(this.fPM, R.drawable.ic_icon_popup_close_n);
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
            ddj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddj() {
        TiebaStatic.log(new ar("c13742").ak("obj_source", c.bfy().bfD() ? 2 : 1).ak("obj_type", 2));
        if (this.eqN != null) {
            int curTaskType = this.eqN.getCurTaskType();
            if (curTaskType == 12) {
                ddk();
            } else if (curTaskType == 6) {
                ddl();
            } else if (curTaskType == 10) {
                ddm();
            } else if (curTaskType == 7) {
                ddn();
            } else if (curTaskType == 5) {
                ddo();
            } else if (curTaskType == 9) {
                ddp();
            } else if (curTaskType == 13) {
                ddq();
            }
        }
    }

    private void ddk() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgf().bgn().e(getPageContext());
            q.bgf().bgn().bgu();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void ddl() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgf().bgo().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void ddm() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgf().bgp().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void ddn() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgf().bgq().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void ddo() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgf().bgr().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void ddp() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgf().bgs().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void ddq() {
        if (TbadkCoreApplication.isLogin()) {
            q.bgf().bgt().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
