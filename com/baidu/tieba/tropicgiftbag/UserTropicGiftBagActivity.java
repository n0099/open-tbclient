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
            if (view.getId() == UserTropicGiftBagActivity.this.nLW.getId()) {
                bf.bsY().a(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                UserTropicGiftBagActivity.this.Ku(2);
                UserTropicGiftBagActivity.this.finish();
            }
            if (view.getId() == UserTropicGiftBagActivity.this.nMa.getId()) {
                UserTropicGiftBagActivity.this.finish();
            }
        }
    };
    private TextView nLT;
    private TextView nLU;
    private TextView nLV;
    private Button nLW;
    private TbImageView nLX;
    private TbImageView nLY;
    private TbImageView nLZ;
    private TbImageView nMa;
    private RoundRelativeLayout ndF;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_tropic_gift_bag);
        initView();
        cPA();
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
        ap.setImageResource(this.nLX, R.drawable.icon_tropic);
        this.nLX.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nLY, R.drawable.icon_tropic_left);
        this.nLZ.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nLZ, R.drawable.icon_tropic_right);
        this.nLZ.setIsNight(i == 4 || i == 1);
        ap.setBackgroundColor(this.ndF, R.color.CAM_X0205);
        ap.setViewTextColor(this.nLT, R.color.CAM_X0105);
        ap.setViewTextColor(this.nLU, R.color.CAM_X0105);
        ap.setViewTextColor(this.nLV, R.color.CAM_X0109);
        ap.k(this.nLW, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
        ap.setImageResource(this.nMa, R.drawable.icon_popup_close);
        TbImageView tbImageView = this.nMa;
        if (i == 4 || i == 1) {
            z = true;
        }
        tbImageView.setIsNight(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Ku(1);
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
        this.ndF = (RoundRelativeLayout) findViewById(R.id.tropic_gift_bag_layout);
        this.ndF.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.nLT = (TextView) findViewById(R.id.tropic_greetings);
        this.nLX = (TbImageView) findViewById(R.id.vip_pic);
        this.nLY = (TbImageView) findViewById(R.id.line_tropic_left);
        this.nLZ = (TbImageView) findViewById(R.id.line_tropic_right);
        this.nLU = (TextView) findViewById(R.id.seven_day_vip);
        this.nLV = (TextView) findViewById(R.id.seven_day_vip_dec);
        this.nLW = (Button) findViewById(R.id.tropic_know);
        this.nMa = (TbImageView) findViewById(R.id.close);
    }

    private void cPA() {
        this.nLW.setOnClickListener(this.mOnClickListener);
        this.nMa.setOnClickListener(this.mOnClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ku(int i) {
        ar arVar = new ar("c13997");
        arVar.dR("obj_name", getResources().getString(R.string.static_item));
        arVar.aq("obj_type", i);
        arVar.dR("uid", TbadkApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
    }
}
