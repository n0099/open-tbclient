package com.baidu.tieba.pb.pb.main;

import android.os.Bundle;
import android.text.ParcelableSpan;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.data.LotteryActRegularInfo;
import com.baidu.tieba.pb.data.LotteryUserChanceInfo;
import com.baidu.tieba.pb.pb.main.p;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class GetLotteryChanceActivity extends BaseActivity {
    private static HashMap<Integer, Integer> dfN = new HashMap<>();
    private View bGF;
    private FrameLayout dfF;
    private LinearLayout dfG;
    private LinearLayout dfH;
    private LotteryUserChanceInfo dfJ;
    private long dfK;
    private TextView dfL;
    private boolean dfO;
    private long dfP;
    private TextView dfQ;
    private int dfR;
    private String forumId;
    private String forumName;
    private long threadId;
    private boolean dfI = false;
    private final List<LotteryActRegularInfo> dfM = new ArrayList();
    private com.baidu.tieba.tbadkCore.ah buI = null;
    private HttpMessageListener dfS = new b(this, CmdConfigHttp.PB_LOTTERY_ADD_COUNT);

    static {
        dfN.put(1, Integer.valueOf(t.j.sign));
        dfN.put(2, Integer.valueOf(t.j.share));
        dfN.put(3, Integer.valueOf(t.j.reply));
        dfN.put(4, Integer.valueOf(t.j.click_link));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        setContentView(t.h.activity_get_lottery_chance);
        registerListener(this.dfS);
        if (getIntent() != null) {
            this.dfJ = (LotteryUserChanceInfo) getIntent().getSerializableExtra(GetLotteryChanceActivityConfig.LOTTERY_USER_CHANCE);
            this.dfO = getIntent().getBooleanExtra(GetLotteryChanceActivityConfig.HAS_SIGN, false);
            this.threadId = com.baidu.adp.lib.h.b.c(getIntent().getStringExtra("thread_id"), 0L);
            this.dfP = getIntent().getLongExtra(GetLotteryChanceActivityConfig.AWARD_ACT_ID, 0L);
            this.forumName = getIntent().getStringExtra("forum_name");
            this.forumId = getIntent().getStringExtra("forum_id");
        }
        TQ();
        initData();
        initViews();
    }

    private void TQ() {
        this.buI = new com.baidu.tieba.tbadkCore.ah(this);
        this.buI.setLoadDataCallBack(new e(this));
    }

    private void initData() {
        if (this.dfJ != null) {
            this.dfK = this.dfJ.getEnableGetChance();
            this.dfM.addAll(this.dfJ.getActRegularList());
        }
    }

    private void initViews() {
        this.dfF = (FrameLayout) findViewById(t.g.root_layout);
        this.dfG = (LinearLayout) findViewById(t.g.dialog_content_layout);
        this.bGF = findViewById(t.g.empty_layout);
        this.bGF.setOnClickListener(new f(this));
        this.dfL = (TextView) findViewById(t.g.tip_bottom);
        this.dfH = (LinearLayout) findViewById(t.g.regular_container);
        awb();
    }

    private void awb() {
        lR((int) this.dfK);
        this.dfH.removeAllViews();
        for (LotteryActRegularInfo lotteryActRegularInfo : this.dfM) {
            View inflate = LayoutInflater.from(getActivity()).inflate(t.h.act_regular_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.type_name);
            TextView textView2 = (TextView) inflate.findViewById(t.g.action_button);
            a(textView2, lotteryActRegularInfo);
            if (lotteryActRegularInfo.getType() == 1) {
                if (this.dfO) {
                    textView2.setText(getResources().getString(t.j.already_signed));
                    textView2.setEnabled(false);
                } else {
                    textView2.setText(String.valueOf(getResources().getString(t.j.immediately)) + getActivity().getString(dfN.get(Integer.valueOf(lotteryActRegularInfo.getType())).intValue()));
                    textView2.setEnabled(true);
                }
                this.dfR = lotteryActRegularInfo.getChanceCount();
            } else if (lotteryActRegularInfo.getType() == 4) {
                textView2.setText(lotteryActRegularInfo.getBtnName());
            } else {
                textView2.setText(String.valueOf(getResources().getString(t.j.immediately)) + getActivity().getString(dfN.get(Integer.valueOf(lotteryActRegularInfo.getType())).intValue()));
            }
            textView.setText(dfN.get(Integer.valueOf(lotteryActRegularInfo.getType())).intValue());
            ((TextView) inflate.findViewById(t.g.get_chance_intro)).setText(I(lotteryActRegularInfo.getChanceCount(), getActivity().getString(t.j.get_some_chance_for_lottery, new Object[]{Integer.valueOf(lotteryActRegularInfo.getChanceCount())})));
            this.dfH.addView(inflate);
        }
    }

    private void a(TextView textView, LotteryActRegularInfo lotteryActRegularInfo) {
        int type = lotteryActRegularInfo.getType();
        if (lotteryActRegularInfo.getChanceCount() <= 0) {
            textView.setOnClickListener(new g(this));
            return;
        }
        switch (type) {
            case 1:
                h(textView);
                this.dfQ = textView;
                return;
            case 2:
                i(textView);
                return;
            case 3:
                j(textView);
                return;
            case 4:
                b(textView, lotteryActRegularInfo);
                return;
            default:
                return;
        }
    }

    private void h(TextView textView) {
        textView.setOnClickListener(new h(this));
    }

    private void i(TextView textView) {
        textView.setOnClickListener(new i(this));
    }

    private void j(TextView textView) {
        textView.setOnClickListener(new j(this));
    }

    private void b(TextView textView, LotteryActRegularInfo lotteryActRegularInfo) {
        textView.setOnClickListener(new k(this, lotteryActRegularInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LotteryActRegularInfo lotteryActRegularInfo) {
        if (lotteryActRegularInfo != null) {
            AddLotteryCountRequestMessage addLotteryCountRequestMessage = new AddLotteryCountRequestMessage();
            addLotteryCountRequestMessage.setFromType(lotteryActRegularInfo.getType());
            addLotteryCountRequestMessage.setThreadId(this.threadId);
            addLotteryCountRequestMessage.setAwardActId(this.dfP);
            addLotteryCountRequestMessage.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            sendMessage(addLotteryCountRequestMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awc() {
        p pVar = new p(getActivity());
        p.c cVar = new p.c();
        cVar.bLb = getPageContext();
        cVar.dgf = getResources().getString(t.j.no_lottery_chance_tip);
        cVar.dgg = getResources().getString(t.j.get_more_lottery_chance_tip);
        cVar.dgb = null;
        cVar.dgc = getResources().getString(t.j.confirm);
        cVar.dgd = null;
        cVar.dge = new l(this);
        pVar.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(int i) {
        this.dfL.setText(I(i, getActivity().getString(t.j.get_lottery_chance_tip, new Object[]{Integer.valueOf(i)})));
    }

    private SpannableString I(int i, String str) {
        SpannableString spannableString = new SpannableString(str);
        a(spannableString, str, new StringBuilder(String.valueOf(i)).toString(), new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_h)));
        return spannableString;
    }

    private void a(SpannableString spannableString, String str, String str2, ParcelableSpan parcelableSpan) {
        if (spannableString != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && parcelableSpan != null) {
            int indexOf = str.indexOf(str2);
            spannableString.setSpan(parcelableSpan, indexOf, str2.length() + indexOf, 33);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(this.dfF);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        super.enterExitAnimation();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        super.closeAnimation();
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void Xp() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.bGF.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.bottom_fold_up);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new c(this));
        this.dfG.startAnimation(loadAnimation);
        this.dfI = true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.dfI) {
            Xp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Xq();
    }

    private void Xq() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.bGF.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new d(this));
        this.dfG.startAnimation(loadAnimation);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.buI != null) {
            this.buI.aQp();
            this.buI = null;
        }
    }
}
