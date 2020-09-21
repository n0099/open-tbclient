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
/* loaded from: classes21.dex */
public class UserTropicGiftBagActivity extends BaseActivity {
    private RoundRelativeLayout lUk;
    private TextView mCC;
    private TextView mCD;
    private TextView mCE;
    private Button mCF;
    private TbImageView mCG;
    private TbImageView mCH;
    private TbImageView mCI;
    private TbImageView mCJ;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.tropicgiftbag.UserTropicGiftBagActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> pageContext = UserTropicGiftBagActivity.this.getPageContext();
            if (view.getId() == UserTropicGiftBagActivity.this.mCF.getId()) {
                be.bkp().a(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                UserTropicGiftBagActivity.this.Ji(2);
                UserTropicGiftBagActivity.this.finish();
            }
            if (view.getId() == UserTropicGiftBagActivity.this.mCJ.getId()) {
                UserTropicGiftBagActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_tropic_gift_bag);
        initView();
        czU();
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
        ap.setImageResource(this.mCG, R.drawable.icon_tropic);
        this.mCG.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.mCH, R.drawable.icon_tropic_left);
        this.mCI.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.mCI, R.drawable.icon_tropic_right);
        this.mCI.setIsNight(i == 4 || i == 1);
        ap.setBackgroundColor(this.lUk, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.mCC, R.color.cp_cont_b);
        ap.setViewTextColor(this.mCD, R.color.cp_cont_b);
        ap.setViewTextColor(this.mCE, R.color.cp_cont_d);
        ap.e(this.mCF, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50);
        ap.setImageResource(this.mCJ, R.drawable.icon_popup_close);
        TbImageView tbImageView = this.mCJ;
        if (i == 4 || i == 1) {
            z = true;
        }
        tbImageView.setIsNight(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Ji(1);
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
        this.lUk = (RoundRelativeLayout) findViewById(R.id.tropic_gift_bag_layout);
        this.lUk.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.mCC = (TextView) findViewById(R.id.tropic_greetings);
        this.mCG = (TbImageView) findViewById(R.id.vip_pic);
        this.mCH = (TbImageView) findViewById(R.id.line_tropic_left);
        this.mCI = (TbImageView) findViewById(R.id.line_tropic_right);
        this.mCD = (TextView) findViewById(R.id.seven_day_vip);
        this.mCE = (TextView) findViewById(R.id.seven_day_vip_dec);
        this.mCF = (Button) findViewById(R.id.tropic_know);
        this.mCJ = (TbImageView) findViewById(R.id.close);
    }

    private void czU() {
        this.mCF.setOnClickListener(this.mOnClickListener);
        this.mCJ.setOnClickListener(this.mOnClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ji(int i) {
        aq aqVar = new aq("c13997");
        aqVar.dF("obj_name", getResources().getString(R.string.static_item));
        aqVar.ai("obj_type", i);
        aqVar.dF("uid", TbadkApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
    }
}
