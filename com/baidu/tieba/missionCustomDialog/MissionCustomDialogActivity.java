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
    private ActiveCenterData eCt;
    private ImageView gcW;
    private View.OnClickListener llA = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.det();
        }
    };
    SignItemView.a llB = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
        @Override // com.baidu.tbadk.widget.mission.SignItemView.a
        public void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            MissionCustomDialogActivity.this.d(activeCenterStatusData);
        }
    };
    private RoundRelativeLayout llq;
    private ImageView llr;
    private TextView lls;
    private TextView llt;
    private SignItemView llu;
    private RoundRelativeLayout llv;
    private TextView llw;
    private TextView llx;
    private TBSpecificationBtn lly;
    private TextView llz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_mission_custom_dialog);
        initView();
        cGu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        q.bhH().bhQ().bhW();
    }

    private void initView() {
        this.llq = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.llq.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.llr = (ImageView) findViewById(R.id.dialog_background);
        this.gcW = (ImageView) findViewById(R.id.img_close);
        this.lls = (TextView) findViewById(R.id.dialog_title);
        this.llt = (TextView) findViewById(R.id.dialog_detail);
        this.llu = (SignItemView) findViewById(R.id.sign_view);
        this.llv = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.llw = (TextView) findViewById(R.id.bottom_title);
        this.llx = (TextView) findViewById(R.id.bottom_detail);
        this.lly = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.llz = (TextView) findViewById(R.id.bottom_btn_text);
        this.llu.setItemClickListener(this.llB);
        this.lly.setOnClickListener(this.llA);
        this.gcW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c13742").an("obj_source", c.bha().bhf() ? 2 : 1).an("obj_type", 3));
                MissionCustomDialogActivity.this.finish();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void cGu() {
        ActiveCenterData bhK = q.bhH().bhK();
        if (bhK == null || bhK.mission == null || bhK.mission_status_list == null || bhK.mission_status_list.size() <= 0) {
            finish();
            return;
        }
        q.bhH().iW(true);
        this.eCt = bhK;
        this.lls.setText(at.cutChineseAndEnglishWithSuffix(this.eCt.win_title, 14, StringHelper.STRING_MORE));
        this.llt.setText(at.cutChineseAndEnglishWithSuffix(this.eCt.win_desc, 30, StringHelper.STRING_MORE));
        this.llu.setData(bhK);
        d(this.eCt.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.eCt != null && this.eCt.mission != null && activeCenterStatusData != null) {
            this.llv.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.llw;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.llx;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.lly.setVisibility(0);
                this.llz.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.lly.setText("已完成");
                    this.lly.setClickable(false);
                    this.lly.setEnabled(false);
                } else {
                    this.lly.setText("已过期");
                    this.lly.setClickable(false);
                    this.lly.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.lly.setVisibility(0);
                this.llz.setVisibility(8);
                if (this.eCt.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.lly.setText("去领取");
                        this.lly.setClickable(true);
                        this.lly.setEnabled(true);
                    } else {
                        this.lly.setText("未达标");
                        this.lly.setClickable(false);
                        this.lly.setEnabled(false);
                    }
                } else {
                    if (this.eCt.mission.task_type == 6) {
                        if (q.bhH().bhQ().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.lly.setText("已完成");
                        this.lly.setClickable(false);
                        this.lly.setEnabled(false);
                    } else {
                        this.lly.setText("去完成");
                        this.lly.setClickable(true);
                        this.lly.setEnabled(true);
                    }
                }
            } else {
                this.lly.setVisibility(8);
                this.llz.setVisibility(0);
                this.llz.setText("未开始");
            }
            a aVar = new a();
            aVar.pM(R.color.CAM_X0301);
            aVar.pJ(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.lly.setConfig(aVar);
            this.lly.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.llq, R.color.CAM_X0211);
        SvgManager.bsx().a(this.llr, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.lls, R.color.CAM_X0311);
        ao.setViewTextColor(this.llt, R.color.CAM_X0301);
        ao.setBackgroundColor(this.llv, R.color.CAM_X0204);
        ao.setViewTextColor(this.llw, R.color.CAM_X0105);
        ao.setViewTextColor(this.llx, R.color.CAM_X0109);
        ao.setViewTextColor(this.llz, R.color.CAM_X0109);
        if (this.lly != null) {
            a aVar = new a();
            aVar.pM(R.color.CAM_X0301);
            aVar.pJ(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.lly.setConfig(aVar);
        }
        this.llu.onChangeSkinType(i);
        ao.setImageResource(this.gcW, R.drawable.ic_icon_popup_close_n);
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
            det();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void det() {
        TiebaStatic.log(new aq("c13742").an("obj_source", c.bha().bhf() ? 2 : 1).an("obj_type", 2));
        if (this.eCt != null) {
            int curTaskType = this.eCt.getCurTaskType();
            if (curTaskType == 12) {
                deu();
            } else if (curTaskType == 6) {
                dev();
            } else if (curTaskType == 10) {
                dew();
            } else if (curTaskType == 7) {
                dex();
            } else if (curTaskType == 5) {
                dey();
            } else if (curTaskType == 9) {
                dez();
            } else if (curTaskType == 13) {
                deA();
            }
        }
    }

    private void deu() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhH().bhP().e(getPageContext());
            q.bhH().bhP().bhW();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dev() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhH().bhQ().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dew() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhH().bhR().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dex() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhH().bhS().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dey() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhH().bhT().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dez() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhH().bhU().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void deA() {
        if (TbadkCoreApplication.isLogin()) {
            q.bhH().bhV().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
