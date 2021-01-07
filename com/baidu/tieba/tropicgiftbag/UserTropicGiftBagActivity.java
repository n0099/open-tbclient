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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes2.dex */
public class UserTropicGiftBagActivity extends BaseActivity {
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.tropicgiftbag.UserTropicGiftBagActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> pageContext = UserTropicGiftBagActivity.this.getPageContext();
            if (view.getId() == UserTropicGiftBagActivity.this.nEl.getId()) {
                be.bwv().a(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                UserTropicGiftBagActivity.this.LC(2);
                UserTropicGiftBagActivity.this.finish();
            }
            if (view.getId() == UserTropicGiftBagActivity.this.nEp.getId()) {
                UserTropicGiftBagActivity.this.finish();
            }
        }
    };
    private RoundRelativeLayout mWp;
    private TextView nEi;
    private TextView nEj;
    private TextView nEk;
    private Button nEl;
    private TbImageView nEm;
    private TbImageView nEn;
    private TbImageView nEo;
    private TbImageView nEp;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_tropic_gift_bag);
        initView();
        cRi();
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
        ao.setImageResource(this.nEm, R.drawable.icon_tropic);
        this.nEm.setIsNight(i == 4 || i == 1);
        ao.setImageResource(this.nEn, R.drawable.icon_tropic_left);
        this.nEo.setIsNight(i == 4 || i == 1);
        ao.setImageResource(this.nEo, R.drawable.icon_tropic_right);
        this.nEo.setIsNight(i == 4 || i == 1);
        ao.setBackgroundColor(this.mWp, R.color.CAM_X0205);
        ao.setViewTextColor(this.nEi, R.color.CAM_X0105);
        ao.setViewTextColor(this.nEj, R.color.CAM_X0105);
        ao.setViewTextColor(this.nEk, R.color.CAM_X0109);
        ao.k(this.nEl, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
        ao.setImageResource(this.nEp, R.drawable.icon_popup_close);
        TbImageView tbImageView = this.nEp;
        if (i == 4 || i == 1) {
            z = true;
        }
        tbImageView.setIsNight(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LC(1);
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
        this.mWp = (RoundRelativeLayout) findViewById(R.id.tropic_gift_bag_layout);
        this.mWp.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.nEi = (TextView) findViewById(R.id.tropic_greetings);
        this.nEm = (TbImageView) findViewById(R.id.vip_pic);
        this.nEn = (TbImageView) findViewById(R.id.line_tropic_left);
        this.nEo = (TbImageView) findViewById(R.id.line_tropic_right);
        this.nEj = (TextView) findViewById(R.id.seven_day_vip);
        this.nEk = (TextView) findViewById(R.id.seven_day_vip_dec);
        this.nEl = (Button) findViewById(R.id.tropic_know);
        this.nEp = (TbImageView) findViewById(R.id.close);
    }

    private void cRi() {
        this.nEl.setOnClickListener(this.mOnClickListener);
        this.nEp.setOnClickListener(this.mOnClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LC(int i) {
        aq aqVar = new aq("c13997");
        aqVar.dX("obj_name", getResources().getString(R.string.static_item));
        aqVar.an("obj_type", i);
        aqVar.dX("uid", TbadkApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
    }
}
