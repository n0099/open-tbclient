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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes22.dex */
public class UserTropicGiftBagActivity extends BaseActivity {
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.tropicgiftbag.UserTropicGiftBagActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> pageContext = UserTropicGiftBagActivity.this.getPageContext();
            if (view.getId() == UserTropicGiftBagActivity.this.nAe.getId()) {
                bf.bua().a(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                UserTropicGiftBagActivity.this.LO(2);
                UserTropicGiftBagActivity.this.finish();
            }
            if (view.getId() == UserTropicGiftBagActivity.this.nAi.getId()) {
                UserTropicGiftBagActivity.this.finish();
            }
        }
    };
    private RoundRelativeLayout mQQ;
    private TextView nAb;
    private TextView nAc;
    private TextView nAd;
    private Button nAe;
    private TbImageView nAf;
    private TbImageView nAg;
    private TbImageView nAh;
    private TbImageView nAi;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_tropic_gift_bag);
        initView();
        cOb();
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
        ap.setImageResource(this.nAf, R.drawable.icon_tropic);
        this.nAf.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nAg, R.drawable.icon_tropic_left);
        this.nAh.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nAh, R.drawable.icon_tropic_right);
        this.nAh.setIsNight(i == 4 || i == 1);
        ap.setBackgroundColor(this.mQQ, R.color.CAM_X0205);
        ap.setViewTextColor(this.nAb, R.color.CAM_X0105);
        ap.setViewTextColor(this.nAc, R.color.CAM_X0105);
        ap.setViewTextColor(this.nAd, R.color.CAM_X0109);
        ap.e(this.nAe, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
        ap.setImageResource(this.nAi, R.drawable.icon_popup_close);
        TbImageView tbImageView = this.nAi;
        if (i == 4 || i == 1) {
            z = true;
        }
        tbImageView.setIsNight(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LO(1);
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
        this.mQQ = (RoundRelativeLayout) findViewById(R.id.tropic_gift_bag_layout);
        this.mQQ.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.nAb = (TextView) findViewById(R.id.tropic_greetings);
        this.nAf = (TbImageView) findViewById(R.id.vip_pic);
        this.nAg = (TbImageView) findViewById(R.id.line_tropic_left);
        this.nAh = (TbImageView) findViewById(R.id.line_tropic_right);
        this.nAc = (TextView) findViewById(R.id.seven_day_vip);
        this.nAd = (TextView) findViewById(R.id.seven_day_vip_dec);
        this.nAe = (Button) findViewById(R.id.tropic_know);
        this.nAi = (TbImageView) findViewById(R.id.close);
    }

    private void cOb() {
        this.nAe.setOnClickListener(this.mOnClickListener);
        this.nAi.setOnClickListener(this.mOnClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LO(int i) {
        ar arVar = new ar("c13997");
        arVar.dY("obj_name", getResources().getString(R.string.static_item));
        arVar.al("obj_type", i);
        arVar.dY("uid", TbadkApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
    }
}
