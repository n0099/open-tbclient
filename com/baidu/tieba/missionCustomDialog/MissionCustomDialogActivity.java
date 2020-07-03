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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tbadk.widget.mission.SignItemView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes9.dex */
public class MissionCustomDialogActivity extends BaseActivity {
    private ActiveCenterData dAN;
    private ImageView eVv;
    private RoundRelativeLayout ivV;
    private TextView ivW;
    private TextView ivX;
    private TBSpecificationBtn ivY;
    private TextView ivZ;
    private TextView jIA;
    private SignItemView jIB;
    private View.OnClickListener jIC = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.cBZ();
        }
    };
    SignItemView.a jID = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
        @Override // com.baidu.tbadk.widget.mission.SignItemView.a
        public void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            MissionCustomDialogActivity.this.d(activeCenterStatusData);
        }
    };
    private RoundRelativeLayout jIx;
    private ImageView jIy;
    private TextView jIz;

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
        q.aMU().aNd().aNj();
    }

    private void initView() {
        this.jIx = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.jIx.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.jIy = (ImageView) findViewById(R.id.dialog_background);
        this.eVv = (ImageView) findViewById(R.id.img_close);
        this.jIz = (TextView) findViewById(R.id.dialog_title);
        this.jIA = (TextView) findViewById(R.id.dialog_detail);
        this.jIB = (SignItemView) findViewById(R.id.sign_view);
        this.ivV = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.ivW = (TextView) findViewById(R.id.bottom_title);
        this.ivX = (TextView) findViewById(R.id.bottom_detail);
        this.ivY = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.ivZ = (TextView) findViewById(R.id.bottom_btn_text);
        this.jIB.setItemClickListener(this.jID);
        this.ivY.setOnClickListener(this.jIC);
        this.eVv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ao("c13742").ag("obj_source", c.aMo().aMs() ? 2 : 1).ag("obj_type", 3));
                MissionCustomDialogActivity.this.finish();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void setData() {
        ActiveCenterData aMX = q.aMU().aMX();
        if (aMX == null || aMX.mission == null || aMX.mission_status_list == null || aMX.mission_status_list.size() <= 0) {
            finish();
            return;
        }
        q.aMU().gG(true);
        this.dAN = aMX;
        this.jIz.setText(ar.cutChineseAndEnglishWithSuffix(this.dAN.win_title, 14, StringHelper.STRING_MORE));
        this.jIA.setText(ar.cutChineseAndEnglishWithSuffix(this.dAN.win_desc, 30, StringHelper.STRING_MORE));
        this.jIB.setData(aMX);
        d(this.dAN.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.dAN != null && this.dAN.mission != null && activeCenterStatusData != null) {
            this.ivV.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.ivW;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.ivX;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.ivY.setVisibility(0);
                this.ivZ.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.ivY.setText("已完成");
                    this.ivY.setClickable(false);
                    this.ivY.setEnabled(false);
                } else {
                    this.ivY.setText("已过期");
                    this.ivY.setClickable(false);
                    this.ivY.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.ivY.setVisibility(0);
                this.ivZ.setVisibility(8);
                if (this.dAN.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.ivY.setText("去领取");
                        this.ivY.setClickable(true);
                        this.ivY.setEnabled(true);
                    } else {
                        this.ivY.setText("未达标");
                        this.ivY.setClickable(false);
                        this.ivY.setEnabled(false);
                    }
                } else {
                    if (this.dAN.mission.task_type == 6) {
                        if (q.aMU().aNd().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.ivY.setText("已完成");
                        this.ivY.setClickable(false);
                        this.ivY.setEnabled(false);
                    } else {
                        this.ivY.setText("去完成");
                        this.ivY.setClickable(true);
                        this.ivY.setEnabled(true);
                    }
                }
            } else {
                this.ivY.setVisibility(8);
                this.ivZ.setVisibility(0);
                this.ivZ.setText("未开始");
            }
            b bVar = new b();
            bVar.mC(R.color.cp_cont_h);
            bVar.mA(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.ivY.setConfig(bVar);
            this.ivY.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        an.setBackgroundColor(this.jIx, R.color.cp_bg_line_k);
        SvgManager.aWQ().a(this.jIy, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        an.setViewTextColor(this.jIz, (int) R.color.cp_other_e);
        an.setViewTextColor(this.jIA, (int) R.color.cp_cont_h);
        an.setBackgroundColor(this.ivV, R.color.cp_bg_line_c);
        an.setViewTextColor(this.ivW, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.ivX, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.ivZ, (int) R.color.cp_cont_d);
        if (this.ivY != null) {
            b bVar = new b();
            bVar.mC(R.color.cp_cont_h);
            bVar.mA(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.ivY.setConfig(bVar);
        }
        this.jIB.onChangeSkinType(i);
        an.setImageResource(this.eVv, R.drawable.ic_icon_popup_close_n);
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
            cBZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBZ() {
        TiebaStatic.log(new ao("c13742").ag("obj_source", c.aMo().aMs() ? 2 : 1).ag("obj_type", 2));
        if (this.dAN != null) {
            int curTaskType = this.dAN.getCurTaskType();
            if (curTaskType == 12) {
                cCa();
            } else if (curTaskType == 6) {
                cCb();
            } else if (curTaskType == 10) {
                cCc();
            } else if (curTaskType == 7) {
                cCd();
            } else if (curTaskType == 5) {
                cCe();
            } else if (curTaskType == 9) {
                cCf();
            } else if (curTaskType == 13) {
                cCg();
            }
        }
    }

    private void cCa() {
        if (TbadkCoreApplication.isLogin()) {
            q.aMU().aNc().e(getPageContext());
            q.aMU().aNc().aNj();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cCb() {
        if (TbadkCoreApplication.isLogin()) {
            q.aMU().aNd().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cCc() {
        if (TbadkCoreApplication.isLogin()) {
            q.aMU().aNe().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cCd() {
        if (TbadkCoreApplication.isLogin()) {
            q.aMU().aNf().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cCe() {
        if (TbadkCoreApplication.isLogin()) {
            q.aMU().aNg().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cCf() {
        if (TbadkCoreApplication.isLogin()) {
            q.aMU().aNh().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void cCg() {
        if (TbadkCoreApplication.isLogin()) {
            q.aMU().aNi().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
