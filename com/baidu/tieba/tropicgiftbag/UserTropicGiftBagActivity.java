package com.baidu.tieba.tropicgiftbag;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes22.dex */
public class UserTropicGiftBagActivity extends BaseActivity {
    private RoundRelativeLayout mCp;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.tropicgiftbag.UserTropicGiftBagActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> pageContext = UserTropicGiftBagActivity.this.getPageContext();
            if (view.getId() == UserTropicGiftBagActivity.this.nkS.getId()) {
                be.brr().a(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                UserTropicGiftBagActivity.this.Kt(2);
                UserTropicGiftBagActivity.this.finish();
            }
            if (view.getId() == UserTropicGiftBagActivity.this.nkW.getId()) {
                UserTropicGiftBagActivity.this.finish();
            }
        }
    };
    private TextView nkP;
    private TextView nkQ;
    private TextView nkR;
    private Button nkS;
    private TbImageView nkT;
    private TbImageView nkU;
    private TbImageView nkV;
    private TbImageView nkW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_tropic_gift_bag);
        initView();
        cJg();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        boolean z = false;
        super.onChangeSkinType(i);
        ap.setImageResource(this.nkT, R.drawable.icon_tropic);
        this.nkT.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nkU, R.drawable.icon_tropic_left);
        this.nkV.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nkV, R.drawable.icon_tropic_right);
        this.nkV.setIsNight(i == 4 || i == 1);
        ap.setBackgroundColor(this.mCp, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.nkP, R.color.cp_cont_b);
        ap.setViewTextColor(this.nkQ, R.color.cp_cont_b);
        ap.setViewTextColor(this.nkR, R.color.cp_cont_d);
        ap.e(this.nkS, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50);
        ap.setImageResource(this.nkW, R.drawable.icon_popup_close);
        TbImageView tbImageView = this.nkW;
        if (i == 4 || i == 1) {
            z = true;
        }
        tbImageView.setIsNight(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Kt(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mOnClickListener != null) {
            this.mOnClickListener = null;
        }
    }

    private void initView() {
        this.mCp = (RoundRelativeLayout) findViewById(R.id.tropic_gift_bag_layout);
        this.mCp.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.nkP = (TextView) findViewById(R.id.tropic_greetings);
        this.nkT = (TbImageView) findViewById(R.id.vip_pic);
        this.nkU = (TbImageView) findViewById(R.id.line_tropic_left);
        this.nkV = (TbImageView) findViewById(R.id.line_tropic_right);
        this.nkQ = (TextView) findViewById(R.id.seven_day_vip);
        this.nkR = (TextView) findViewById(R.id.seven_day_vip_dec);
        this.nkS = (Button) findViewById(R.id.tropic_know);
        this.nkW = (TbImageView) findViewById(R.id.close);
    }

    private void cJg() {
        this.nkS.setOnClickListener(this.mOnClickListener);
        this.nkW.setOnClickListener(this.mOnClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kt(int i) {
        aq aqVar = new aq("c13997");
        aqVar.dR("obj_name", getResources().getString(R.string.static_item));
        aqVar.al("obj_type", i);
        aqVar.dR("uid", TbadkApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
    }
}
