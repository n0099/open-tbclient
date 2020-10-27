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
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.tropicgiftbag.UserTropicGiftBagActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> pageContext = UserTropicGiftBagActivity.this.getPageContext();
            if (view.getId() == UserTropicGiftBagActivity.this.neW.getId()) {
                be.boR().a(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                UserTropicGiftBagActivity.this.Kg(2);
                UserTropicGiftBagActivity.this.finish();
            }
            if (view.getId() == UserTropicGiftBagActivity.this.nfa.getId()) {
                UserTropicGiftBagActivity.this.finish();
            }
        }
    };
    private RoundRelativeLayout mws;
    private TextView neT;
    private TextView neU;
    private TextView neV;
    private Button neW;
    private TbImageView neX;
    private TbImageView neY;
    private TbImageView neZ;
    private TbImageView nfa;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_tropic_gift_bag);
        initView();
        cGF();
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
        ap.setImageResource(this.neX, R.drawable.icon_tropic);
        this.neX.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.neY, R.drawable.icon_tropic_left);
        this.neZ.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.neZ, R.drawable.icon_tropic_right);
        this.neZ.setIsNight(i == 4 || i == 1);
        ap.setBackgroundColor(this.mws, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.neT, R.color.cp_cont_b);
        ap.setViewTextColor(this.neU, R.color.cp_cont_b);
        ap.setViewTextColor(this.neV, R.color.cp_cont_d);
        ap.e(this.neW, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50);
        ap.setImageResource(this.nfa, R.drawable.icon_popup_close);
        TbImageView tbImageView = this.nfa;
        if (i == 4 || i == 1) {
            z = true;
        }
        tbImageView.setIsNight(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Kg(1);
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
        this.mws = (RoundRelativeLayout) findViewById(R.id.tropic_gift_bag_layout);
        this.mws.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.neT = (TextView) findViewById(R.id.tropic_greetings);
        this.neX = (TbImageView) findViewById(R.id.vip_pic);
        this.neY = (TbImageView) findViewById(R.id.line_tropic_left);
        this.neZ = (TbImageView) findViewById(R.id.line_tropic_right);
        this.neU = (TextView) findViewById(R.id.seven_day_vip);
        this.neV = (TextView) findViewById(R.id.seven_day_vip_dec);
        this.neW = (Button) findViewById(R.id.tropic_know);
        this.nfa = (TbImageView) findViewById(R.id.close);
    }

    private void cGF() {
        this.neW.setOnClickListener(this.mOnClickListener);
        this.nfa.setOnClickListener(this.mOnClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kg(int i) {
        aq aqVar = new aq("c13997");
        aqVar.dR("obj_name", getResources().getString(R.string.static_item));
        aqVar.aj("obj_type", i);
        aqVar.dR("uid", TbadkApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
    }
}
