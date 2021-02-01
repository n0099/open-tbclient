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
            if (view.getId() == UserTropicGiftBagActivity.this.nJr.getId()) {
                bf.bsV().a(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                UserTropicGiftBagActivity.this.Kp(2);
                UserTropicGiftBagActivity.this.finish();
            }
            if (view.getId() == UserTropicGiftBagActivity.this.nJv.getId()) {
                UserTropicGiftBagActivity.this.finish();
            }
        }
    };
    private TextView nJo;
    private TextView nJp;
    private TextView nJq;
    private Button nJr;
    private TbImageView nJs;
    private TbImageView nJt;
    private TbImageView nJu;
    private TbImageView nJv;
    private RoundRelativeLayout nbb;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_tropic_gift_bag);
        initView();
        cPm();
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
        ap.setImageResource(this.nJs, R.drawable.icon_tropic);
        this.nJs.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nJt, R.drawable.icon_tropic_left);
        this.nJu.setIsNight(i == 4 || i == 1);
        ap.setImageResource(this.nJu, R.drawable.icon_tropic_right);
        this.nJu.setIsNight(i == 4 || i == 1);
        ap.setBackgroundColor(this.nbb, R.color.CAM_X0205);
        ap.setViewTextColor(this.nJo, R.color.CAM_X0105);
        ap.setViewTextColor(this.nJp, R.color.CAM_X0105);
        ap.setViewTextColor(this.nJq, R.color.CAM_X0109);
        ap.k(this.nJr, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
        ap.setImageResource(this.nJv, R.drawable.icon_popup_close);
        TbImageView tbImageView = this.nJv;
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
        this.nbb = (RoundRelativeLayout) findViewById(R.id.tropic_gift_bag_layout);
        this.nbb.setAllCornerRound(l.getDimens(this, R.dimen.tbds32));
        this.nJo = (TextView) findViewById(R.id.tropic_greetings);
        this.nJs = (TbImageView) findViewById(R.id.vip_pic);
        this.nJt = (TbImageView) findViewById(R.id.line_tropic_left);
        this.nJu = (TbImageView) findViewById(R.id.line_tropic_right);
        this.nJp = (TextView) findViewById(R.id.seven_day_vip);
        this.nJq = (TextView) findViewById(R.id.seven_day_vip_dec);
        this.nJr = (Button) findViewById(R.id.tropic_know);
        this.nJv = (TbImageView) findViewById(R.id.close);
    }

    private void cPm() {
        this.nJr.setOnClickListener(this.mOnClickListener);
        this.nJv.setOnClickListener(this.mOnClickListener);
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
