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
/* loaded from: classes21.dex */
public class UserTropicGiftBagActivity extends BaseActivity {
    private RoundRelativeLayout mCN;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.tropicgiftbag.UserTropicGiftBagActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> pageContext = UserTropicGiftBagActivity.this.getPageContext();
            if (view.getId() == UserTropicGiftBagActivity.this.nlZ.getId()) {
                bf.bqF().a(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                UserTropicGiftBagActivity.this.KW(2);
                UserTropicGiftBagActivity.this.finish();
            }
            if (view.getId() == UserTropicGiftBagActivity.this.nmd.getId()) {
                UserTropicGiftBagActivity.this.finish();
            }
        }
    };
    private TextView nlW;
    private TextView nlX;
    private TextView nlY;
    private Button nlZ;
    private TbImageView nma;
    private TbImageView nmb;
    private TbImageView nmc;
    private TbImageView nmd;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_tropic_gift_bag);
        initView();
        cIL();
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
        ap.setImageResource(this.nma, R.drawable.icon_tropic);
        this.nma.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nmb, R.drawable.icon_tropic_left);
        this.nmc.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nmc, R.drawable.icon_tropic_right);
        this.nmc.setIsNight(i == 4 || i == 1);
        ap.setBackgroundColor(this.mCN, R.color.CAM_X0205);
        ap.setViewTextColor(this.nlW, R.color.CAM_X0105);
        ap.setViewTextColor(this.nlX, R.color.CAM_X0105);
        ap.setViewTextColor(this.nlY, R.color.CAM_X0109);
        ap.f(this.nlZ, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
        ap.setImageResource(this.nmd, R.drawable.icon_popup_close);
        TbImageView tbImageView = this.nmd;
        if (i == 4 || i == 1) {
            z = true;
        }
        tbImageView.setIsNight(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        KW(1);
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
        this.mCN = (RoundRelativeLayout) findViewById(R.id.tropic_gift_bag_layout);
        this.mCN.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.nlW = (TextView) findViewById(R.id.tropic_greetings);
        this.nma = (TbImageView) findViewById(R.id.vip_pic);
        this.nmb = (TbImageView) findViewById(R.id.line_tropic_left);
        this.nmc = (TbImageView) findViewById(R.id.line_tropic_right);
        this.nlX = (TextView) findViewById(R.id.seven_day_vip);
        this.nlY = (TextView) findViewById(R.id.seven_day_vip_dec);
        this.nlZ = (Button) findViewById(R.id.tropic_know);
        this.nmd = (TbImageView) findViewById(R.id.close);
    }

    private void cIL() {
        this.nlZ.setOnClickListener(this.mOnClickListener);
        this.nmd.setOnClickListener(this.mOnClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KW(int i) {
        ar arVar = new ar("c13997");
        arVar.dR("obj_name", getResources().getString(R.string.static_item));
        arVar.ak("obj_type", i);
        arVar.dR("uid", TbadkApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
    }
}
