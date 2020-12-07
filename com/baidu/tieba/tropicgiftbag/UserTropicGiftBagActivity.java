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
            if (view.getId() == UserTropicGiftBagActivity.this.nAc.getId()) {
                bf.bua().a(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                UserTropicGiftBagActivity.this.LO(2);
                UserTropicGiftBagActivity.this.finish();
            }
            if (view.getId() == UserTropicGiftBagActivity.this.nAg.getId()) {
                UserTropicGiftBagActivity.this.finish();
            }
        }
    };
    private RoundRelativeLayout mQO;
    private TextView nAa;
    private TextView nAb;
    private Button nAc;
    private TbImageView nAd;
    private TbImageView nAe;
    private TbImageView nAf;
    private TbImageView nAg;
    private TextView nzZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_tropic_gift_bag);
        initView();
        cOa();
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
        ap.setImageResource(this.nAd, R.drawable.icon_tropic);
        this.nAd.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nAe, R.drawable.icon_tropic_left);
        this.nAf.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nAf, R.drawable.icon_tropic_right);
        this.nAf.setIsNight(i == 4 || i == 1);
        ap.setBackgroundColor(this.mQO, R.color.CAM_X0205);
        ap.setViewTextColor(this.nzZ, R.color.CAM_X0105);
        ap.setViewTextColor(this.nAa, R.color.CAM_X0105);
        ap.setViewTextColor(this.nAb, R.color.CAM_X0109);
        ap.e(this.nAc, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
        ap.setImageResource(this.nAg, R.drawable.icon_popup_close);
        TbImageView tbImageView = this.nAg;
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
        this.mQO = (RoundRelativeLayout) findViewById(R.id.tropic_gift_bag_layout);
        this.mQO.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.nzZ = (TextView) findViewById(R.id.tropic_greetings);
        this.nAd = (TbImageView) findViewById(R.id.vip_pic);
        this.nAe = (TbImageView) findViewById(R.id.line_tropic_left);
        this.nAf = (TbImageView) findViewById(R.id.line_tropic_right);
        this.nAa = (TextView) findViewById(R.id.seven_day_vip);
        this.nAb = (TextView) findViewById(R.id.seven_day_vip_dec);
        this.nAc = (Button) findViewById(R.id.tropic_know);
        this.nAg = (TbImageView) findViewById(R.id.close);
    }

    private void cOa() {
        this.nAc.setOnClickListener(this.mOnClickListener);
        this.nAg.setOnClickListener(this.mOnClickListener);
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
