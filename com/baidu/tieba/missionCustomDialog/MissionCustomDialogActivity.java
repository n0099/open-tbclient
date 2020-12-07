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
/* loaded from: classes22.dex */
public class MissionCustomDialogActivity extends BaseActivity {
    private ActiveCenterData exP;
    private ImageView fXV;
    private RoundRelativeLayout lko;
    private ImageView lkp;
    private TextView lkq;
    private TextView lkr;
    private SignItemView lks;
    private RoundRelativeLayout lkt;
    private TextView lku;
    private TextView lkv;
    private TBSpecificationBtn lkw;
    private TextView lkx;
    private View.OnClickListener lky = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.div();
        }
    };
    SignItemView.a lkz = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
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
        q.bjk().bjt().bjz();
    }

    private void initView() {
        this.lko = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.lko.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.lkp = (ImageView) findViewById(R.id.dialog_background);
        this.fXV = (ImageView) findViewById(R.id.img_close);
        this.lkq = (TextView) findViewById(R.id.dialog_title);
        this.lkr = (TextView) findViewById(R.id.dialog_detail);
        this.lks = (SignItemView) findViewById(R.id.sign_view);
        this.lkt = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.lku = (TextView) findViewById(R.id.bottom_title);
        this.lkv = (TextView) findViewById(R.id.bottom_detail);
        this.lkw = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.lkx = (TextView) findViewById(R.id.bottom_btn_text);
        this.lks.setItemClickListener(this.lkz);
        this.lkw.setOnClickListener(this.lky);
        this.fXV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c13742").al("obj_source", c.biD().biI() ? 2 : 1).al("obj_type", 3));
                MissionCustomDialogActivity.this.finish();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void setData() {
        ActiveCenterData bjn = q.bjk().bjn();
        if (bjn == null || bjn.mission == null || bjn.mission_status_list == null || bjn.mission_status_list.size() <= 0) {
            finish();
            return;
        }
        q.bjk().iF(true);
        this.exP = bjn;
        this.lkq.setText(au.cutChineseAndEnglishWithSuffix(this.exP.win_title, 14, StringHelper.STRING_MORE));
        this.lkr.setText(au.cutChineseAndEnglishWithSuffix(this.exP.win_desc, 30, StringHelper.STRING_MORE));
        this.lks.setData(bjn);
        d(this.exP.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.exP != null && this.exP.mission != null && activeCenterStatusData != null) {
            this.lkt.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.lku;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.lkv;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.lkw.setVisibility(0);
                this.lkx.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.lkw.setText("已完成");
                    this.lkw.setClickable(false);
                    this.lkw.setEnabled(false);
                } else {
                    this.lkw.setText("已过期");
                    this.lkw.setClickable(false);
                    this.lkw.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.lkw.setVisibility(0);
                this.lkx.setVisibility(8);
                if (this.exP.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.lkw.setText("去领取");
                        this.lkw.setClickable(true);
                        this.lkw.setEnabled(true);
                    } else {
                        this.lkw.setText("未达标");
                        this.lkw.setClickable(false);
                        this.lkw.setEnabled(false);
                    }
                } else {
                    if (this.exP.mission.task_type == 6) {
                        if (q.bjk().bjt().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.lkw.setText("已完成");
                        this.lkw.setClickable(false);
                        this.lkw.setEnabled(false);
                    } else {
                        this.lkw.setText("去完成");
                        this.lkw.setClickable(true);
                        this.lkw.setEnabled(true);
                    }
                }
            } else {
                this.lkw.setVisibility(8);
                this.lkx.setVisibility(0);
                this.lkx.setText("未开始");
            }
            a aVar = new a();
            aVar.rh(R.color.CAM_X0301);
            aVar.re(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.lkw.setConfig(aVar);
            this.lkw.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.lko, R.color.CAM_X0211);
        SvgManager.btW().a(this.lkp, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.lkq, R.color.CAM_X0311);
        ap.setViewTextColor(this.lkr, R.color.CAM_X0301);
        ap.setBackgroundColor(this.lkt, R.color.CAM_X0204);
        ap.setViewTextColor(this.lku, R.color.CAM_X0105);
        ap.setViewTextColor(this.lkv, R.color.CAM_X0109);
        ap.setViewTextColor(this.lkx, R.color.CAM_X0109);
        if (this.lkw != null) {
            a aVar = new a();
            aVar.rh(R.color.CAM_X0301);
            aVar.re(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.lkw.setConfig(aVar);
        }
        this.lks.onChangeSkinType(i);
        ap.setImageResource(this.fXV, R.drawable.ic_icon_popup_close_n);
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
            div();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void div() {
        TiebaStatic.log(new ar("c13742").al("obj_source", c.biD().biI() ? 2 : 1).al("obj_type", 2));
        if (this.exP != null) {
            int curTaskType = this.exP.getCurTaskType();
            if (curTaskType == 12) {
                diw();
            } else if (curTaskType == 6) {
                dix();
            } else if (curTaskType == 10) {
                diy();
            } else if (curTaskType == 7) {
                diz();
            } else if (curTaskType == 5) {
                diA();
            } else if (curTaskType == 9) {
                diB();
            } else if (curTaskType == 13) {
                diC();
            }
        }
    }

    private void diw() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bjs().e(getPageContext());
            q.bjk().bjs().bjz();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dix() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bjt().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void diy() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bju().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void diz() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bjv().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void diA() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bjw().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void diB() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bjx().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void diC() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bjy().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
