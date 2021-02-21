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
/* loaded from: classes2.dex */
public class UserTropicGiftBagActivity extends BaseActivity {
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.tropicgiftbag.UserTropicGiftBagActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> pageContext = UserTropicGiftBagActivity.this.getPageContext();
            if (view.getId() == UserTropicGiftBagActivity.this.nJR.getId()) {
                bf.bsV().a(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                UserTropicGiftBagActivity.this.Kp(2);
                UserTropicGiftBagActivity.this.finish();
            }
            if (view.getId() == UserTropicGiftBagActivity.this.nJV.getId()) {
                UserTropicGiftBagActivity.this.finish();
            }
        }
    };
    private TextView nJO;
    private TextView nJP;
    private TextView nJQ;
    private Button nJR;
    private TbImageView nJS;
    private TbImageView nJT;
    private TbImageView nJU;
    private TbImageView nJV;
    private RoundRelativeLayout nbB;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_tropic_gift_bag);
        initView();
        cPt();
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
        ap.setImageResource(this.nJS, R.drawable.icon_tropic);
        this.nJS.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nJT, R.drawable.icon_tropic_left);
        this.nJU.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nJU, R.drawable.icon_tropic_right);
        this.nJU.setIsNight(i == 4 || i == 1);
        ap.setBackgroundColor(this.nbB, R.color.CAM_X0205);
        ap.setViewTextColor(this.nJO, R.color.CAM_X0105);
        ap.setViewTextColor(this.nJP, R.color.CAM_X0105);
        ap.setViewTextColor(this.nJQ, R.color.CAM_X0109);
        ap.k(this.nJR, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
        ap.setImageResource(this.nJV, R.drawable.icon_popup_close);
        TbImageView tbImageView = this.nJV;
        if (i == 4 || i == 1) {
            z = true;
        }
        tbImageView.setIsNight(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Kp(1);
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
        this.nbB = (RoundRelativeLayout) findViewById(R.id.tropic_gift_bag_layout);
        this.nbB.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.nJO = (TextView) findViewById(R.id.tropic_greetings);
        this.nJS = (TbImageView) findViewById(R.id.vip_pic);
        this.nJT = (TbImageView) findViewById(R.id.line_tropic_left);
        this.nJU = (TbImageView) findViewById(R.id.line_tropic_right);
        this.nJP = (TextView) findViewById(R.id.seven_day_vip);
        this.nJQ = (TextView) findViewById(R.id.seven_day_vip_dec);
        this.nJR = (Button) findViewById(R.id.tropic_know);
        this.nJV = (TbImageView) findViewById(R.id.close);
    }

    private void cPt() {
        this.nJR.setOnClickListener(this.mOnClickListener);
        this.nJV.setOnClickListener(this.mOnClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kp(int i) {
        ar arVar = new ar("c13997");
        arVar.dR("obj_name", getResources().getString(R.string.static_item));
        arVar.ap("obj_type", i);
        arVar.dR("uid", TbadkApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
    }
}
