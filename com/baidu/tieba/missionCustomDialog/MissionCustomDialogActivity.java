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
    private ImageView fXX;
    private View.OnClickListener lkA = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.diw();
        }
    };
    SignItemView.a lkB = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
        @Override // com.baidu.tbadk.widget.mission.SignItemView.a
        public void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            MissionCustomDialogActivity.this.d(activeCenterStatusData);
        }
    };
    private RoundRelativeLayout lkq;
    private ImageView lkr;
    private TextView lks;
    private TextView lkt;
    private SignItemView lku;
    private RoundRelativeLayout lkv;
    private TextView lkw;
    private TextView lkx;
    private TBSpecificationBtn lky;
    private TextView lkz;

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
        this.lkq = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.lkq.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.lkr = (ImageView) findViewById(R.id.dialog_background);
        this.fXX = (ImageView) findViewById(R.id.img_close);
        this.lks = (TextView) findViewById(R.id.dialog_title);
        this.lkt = (TextView) findViewById(R.id.dialog_detail);
        this.lku = (SignItemView) findViewById(R.id.sign_view);
        this.lkv = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.lkw = (TextView) findViewById(R.id.bottom_title);
        this.lkx = (TextView) findViewById(R.id.bottom_detail);
        this.lky = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.lkz = (TextView) findViewById(R.id.bottom_btn_text);
        this.lku.setItemClickListener(this.lkB);
        this.lky.setOnClickListener(this.lkA);
        this.fXX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
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
        this.lks.setText(au.cutChineseAndEnglishWithSuffix(this.exP.win_title, 14, StringHelper.STRING_MORE));
        this.lkt.setText(au.cutChineseAndEnglishWithSuffix(this.exP.win_desc, 30, StringHelper.STRING_MORE));
        this.lku.setData(bjn);
        d(this.exP.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.exP != null && this.exP.mission != null && activeCenterStatusData != null) {
            this.lkv.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.lkw;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.lkx;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.lky.setVisibility(0);
                this.lkz.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.lky.setText("已完成");
                    this.lky.setClickable(false);
                    this.lky.setEnabled(false);
                } else {
                    this.lky.setText("已过期");
                    this.lky.setClickable(false);
                    this.lky.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.lky.setVisibility(0);
                this.lkz.setVisibility(8);
                if (this.exP.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.lky.setText("去领取");
                        this.lky.setClickable(true);
                        this.lky.setEnabled(true);
                    } else {
                        this.lky.setText("未达标");
                        this.lky.setClickable(false);
                        this.lky.setEnabled(false);
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
                        this.lky.setText("已完成");
                        this.lky.setClickable(false);
                        this.lky.setEnabled(false);
                    } else {
                        this.lky.setText("去完成");
                        this.lky.setClickable(true);
                        this.lky.setEnabled(true);
                    }
                }
            } else {
                this.lky.setVisibility(8);
                this.lkz.setVisibility(0);
                this.lkz.setText("未开始");
            }
            a aVar = new a();
            aVar.rh(R.color.CAM_X0301);
            aVar.re(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.lky.setConfig(aVar);
            this.lky.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.lkq, R.color.CAM_X0211);
        SvgManager.btW().a(this.lkr, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.lks, R.color.CAM_X0311);
        ap.setViewTextColor(this.lkt, R.color.CAM_X0301);
        ap.setBackgroundColor(this.lkv, R.color.CAM_X0204);
        ap.setViewTextColor(this.lkw, R.color.CAM_X0105);
        ap.setViewTextColor(this.lkx, R.color.CAM_X0109);
        ap.setViewTextColor(this.lkz, R.color.CAM_X0109);
        if (this.lky != null) {
            a aVar = new a();
            aVar.rh(R.color.CAM_X0301);
            aVar.re(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.lky.setConfig(aVar);
        }
        this.lku.onChangeSkinType(i);
        ap.setImageResource(this.fXX, R.drawable.ic_icon_popup_close_n);
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
            diw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diw() {
        TiebaStatic.log(new ar("c13742").al("obj_source", c.biD().biI() ? 2 : 1).al("obj_type", 2));
        if (this.exP != null) {
            int curTaskType = this.exP.getCurTaskType();
            if (curTaskType == 12) {
                dix();
            } else if (curTaskType == 6) {
                diy();
            } else if (curTaskType == 10) {
                diz();
            } else if (curTaskType == 7) {
                diA();
            } else if (curTaskType == 5) {
                diB();
            } else if (curTaskType == 9) {
                diC();
            } else if (curTaskType == 13) {
                diD();
            }
        }
    }

    private void dix() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bjs().e(getPageContext());
            q.bjk().bjs().bjz();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void diy() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bjt().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void diz() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bju().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void diA() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bjv().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void diB() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bjw().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void diC() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bjx().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void diD() {
        if (TbadkCoreApplication.isLogin()) {
            q.bjk().bjy().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
