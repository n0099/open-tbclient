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
    private ActiveCenterData emy;
    private ImageView fKn;
    private RoundRelativeLayout jBf;
    private TextView jBg;
    private TextView jBh;
    private TBSpecificationBtn jBi;
    private TextView jBj;
    private RoundRelativeLayout kQM;
    private ImageView kQN;
    private TextView kQO;
    private TextView kQP;
    private SignItemView kQQ;
    private View.OnClickListener kQR = new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MissionCustomDialogActivity.this.dbk();
        }
    };
    SignItemView.a kQS = new SignItemView.a() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.3
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
        q.bem().bev().beB();
    }

    private void initView() {
        this.kQM = (RoundRelativeLayout) findViewById(R.id.content_background);
        this.kQM.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.kQN = (ImageView) findViewById(R.id.dialog_background);
        this.fKn = (ImageView) findViewById(R.id.img_close);
        this.kQO = (TextView) findViewById(R.id.dialog_title);
        this.kQP = (TextView) findViewById(R.id.dialog_detail);
        this.kQQ = (SignItemView) findViewById(R.id.sign_view);
        this.jBf = (RoundRelativeLayout) findViewById(R.id.bottom_action_layout);
        this.jBg = (TextView) findViewById(R.id.bottom_title);
        this.jBh = (TextView) findViewById(R.id.bottom_detail);
        this.jBi = (TBSpecificationBtn) findViewById(R.id.bottom_btn);
        this.jBj = (TextView) findViewById(R.id.bottom_btn_text);
        this.kQQ.setItemClickListener(this.kQS);
        this.jBi.setOnClickListener(this.kQR);
        this.fKn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c13742").aj("obj_source", c.bdF().bdK() ? 2 : 1).aj("obj_type", 3));
                MissionCustomDialogActivity.this.finish();
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void setData() {
        ActiveCenterData bep = q.bem().bep();
        if (bep == null || bep.mission == null || bep.mission_status_list == null || bep.mission_status_list.size() <= 0) {
            finish();
            return;
        }
        q.bem().ie(true);
        this.emy = bep;
        this.kQO.setText(at.cutChineseAndEnglishWithSuffix(this.emy.win_title, 14, StringHelper.STRING_MORE));
        this.kQP.setText(at.cutChineseAndEnglishWithSuffix(this.emy.win_desc, 30, StringHelper.STRING_MORE));
        this.kQQ.setData(bep);
        d(this.emy.getTodayMissionStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.emy != null && this.emy.mission != null && activeCenterStatusData != null) {
            this.jBf.setAllCornerRound(l.getDimens(this, R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.jBg;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.jBh;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.jBi.setVisibility(0);
                this.jBj.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.jBi.setText("已完成");
                    this.jBi.setClickable(false);
                    this.jBi.setEnabled(false);
                } else {
                    this.jBi.setText("已过期");
                    this.jBi.setClickable(false);
                    this.jBi.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.jBi.setVisibility(0);
                this.jBj.setVisibility(8);
                if (this.emy.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.jBi.setText("去领取");
                        this.jBi.setClickable(true);
                        this.jBi.setEnabled(true);
                    } else {
                        this.jBi.setText("未达标");
                        this.jBi.setClickable(false);
                        this.jBi.setEnabled(false);
                    }
                } else {
                    if (this.emy.mission.task_type == 6) {
                        if (q.bem().bev().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.jBi.setText("已完成");
                        this.jBi.setClickable(false);
                        this.jBi.setEnabled(false);
                    } else {
                        this.jBi.setText("去完成");
                        this.jBi.setClickable(true);
                        this.jBi.setEnabled(true);
                    }
                }
            } else {
                this.jBi.setVisibility(8);
                this.jBj.setVisibility(0);
                this.jBj.setText("未开始");
            }
            a aVar = new a();
            aVar.pY(R.color.cp_cont_h);
            aVar.pV(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.jBi.setConfig(aVar);
            this.jBi.setTextSize(R.dimen.tbds34);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.kQM, R.color.cp_bg_line_k);
        SvgManager.boN().a(this.kQN, R.drawable.ic_pic_mask_newuser_background_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.kQO, R.color.cp_other_e);
        ap.setViewTextColor(this.kQP, R.color.cp_cont_h);
        ap.setBackgroundColor(this.jBf, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.jBg, R.color.cp_cont_b);
        ap.setViewTextColor(this.jBh, R.color.cp_cont_d);
        ap.setViewTextColor(this.jBj, R.color.cp_cont_d);
        if (this.jBi != null) {
            a aVar = new a();
            aVar.pY(R.color.cp_cont_h);
            aVar.pV(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.jBi.setConfig(aVar);
        }
        this.kQQ.onChangeSkinType(i);
        ap.setImageResource(this.fKn, R.drawable.ic_icon_popup_close_n);
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
            dbk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbk() {
        TiebaStatic.log(new aq("c13742").aj("obj_source", c.bdF().bdK() ? 2 : 1).aj("obj_type", 2));
        if (this.emy != null) {
            int curTaskType = this.emy.getCurTaskType();
            if (curTaskType == 12) {
                dbl();
            } else if (curTaskType == 6) {
                dbm();
            } else if (curTaskType == 10) {
                dbn();
            } else if (curTaskType == 7) {
                dbo();
            } else if (curTaskType == 5) {
                dbp();
            } else if (curTaskType == 9) {
                dbq();
            } else if (curTaskType == 13) {
                dbr();
            }
        }
    }

    private void dbl() {
        if (TbadkCoreApplication.isLogin()) {
            q.bem().beu().e(getPageContext());
            q.bem().beu().beB();
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dbm() {
        if (TbadkCoreApplication.isLogin()) {
            q.bem().bev().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dbn() {
        if (TbadkCoreApplication.isLogin()) {
            q.bem().bew().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dbo() {
        if (TbadkCoreApplication.isLogin()) {
            q.bem().bex().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dbp() {
        if (TbadkCoreApplication.isLogin()) {
            q.bem().bey().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dbq() {
        if (TbadkCoreApplication.isLogin()) {
            q.bem().bez().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }

    private void dbr() {
        if (TbadkCoreApplication.isLogin()) {
            q.bem().beA().e(getPageContext());
            finish();
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_GUARD_CLUB_RANK)));
    }
}
