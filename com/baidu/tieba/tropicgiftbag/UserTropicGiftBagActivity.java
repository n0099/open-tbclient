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
            if (view.getId() == UserTropicGiftBagActivity.this.mSr.getId()) {
                be.bmY().a(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                UserTropicGiftBagActivity.this.JO(2);
                UserTropicGiftBagActivity.this.finish();
            }
            if (view.getId() == UserTropicGiftBagActivity.this.mSv.getId()) {
                UserTropicGiftBagActivity.this.finish();
            }
        }
    };
    private TextView mSn;
    private TextView mSo;
    private TextView mSq;
    private Button mSr;
    private TbImageView mSs;
    private TbImageView mSt;
    private TbImageView mSu;
    private TbImageView mSv;
    private RoundRelativeLayout mjR;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_tropic_gift_bag);
        initView();
        cDy();
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
        ap.setImageResource(this.mSs, R.drawable.icon_tropic);
        this.mSs.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.mSt, R.drawable.icon_tropic_left);
        this.mSu.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.mSu, R.drawable.icon_tropic_right);
        this.mSu.setIsNight(i == 4 || i == 1);
        ap.setBackgroundColor(this.mjR, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.mSn, R.color.cp_cont_b);
        ap.setViewTextColor(this.mSo, R.color.cp_cont_b);
        ap.setViewTextColor(this.mSq, R.color.cp_cont_d);
        ap.e(this.mSr, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50);
        ap.setImageResource(this.mSv, R.drawable.icon_popup_close);
        TbImageView tbImageView = this.mSv;
        if (i == 4 || i == 1) {
            z = true;
        }
        tbImageView.setIsNight(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        JO(1);
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
        this.mjR = (RoundRelativeLayout) findViewById(R.id.tropic_gift_bag_layout);
        this.mjR.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.mSn = (TextView) findViewById(R.id.tropic_greetings);
        this.mSs = (TbImageView) findViewById(R.id.vip_pic);
        this.mSt = (TbImageView) findViewById(R.id.line_tropic_left);
        this.mSu = (TbImageView) findViewById(R.id.line_tropic_right);
        this.mSo = (TextView) findViewById(R.id.seven_day_vip);
        this.mSq = (TextView) findViewById(R.id.seven_day_vip_dec);
        this.mSr = (Button) findViewById(R.id.tropic_know);
        this.mSv = (TbImageView) findViewById(R.id.close);
    }

    private void cDy() {
        this.mSr.setOnClickListener(this.mOnClickListener);
        this.mSv.setOnClickListener(this.mOnClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JO(int i) {
        aq aqVar = new aq("c13997");
        aqVar.dK("obj_name", getResources().getString(R.string.static_item));
        aqVar.aj("obj_type", i);
        aqVar.dK("uid", TbadkApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
    }
}
