package com.baidu.tieba.tropicgiftbag;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class UserTropicGiftBagActivity extends BaseActivity {
    public TbImageView mClose;
    public Button mKnow;
    public TbImageView mLineTropicLeft;
    public TbImageView mLineTropicRight;
    public View.OnClickListener mOnClickListener = new a();
    public RoundRelativeLayout mRoundCornerLayout;
    public TextView mSevenDayVip;
    public TextView mSevenDayVipDec;
    public TextView mTropicGreetings;
    public TbImageView mVipPic;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> pageContext = UserTropicGiftBagActivity.this.getPageContext();
            if (view.getId() == UserTropicGiftBagActivity.this.mKnow.getId()) {
                UrlManager.getInstance().dealOneLink(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                UserTropicGiftBagActivity.this.sendStatisticLog(2);
                UserTropicGiftBagActivity.this.finish();
            }
            if (view.getId() == UserTropicGiftBagActivity.this.mClose.getId()) {
                UserTropicGiftBagActivity.this.finish();
            }
        }
    }

    private void initView() {
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R.id.tropic_gift_bag_layout);
        this.mRoundCornerLayout = roundRelativeLayout;
        roundRelativeLayout.setAllCornerRound(l.g(this, R.dimen.tbds32));
        this.mTropicGreetings = (TextView) findViewById(R.id.tropic_greetings);
        this.mVipPic = (TbImageView) findViewById(R.id.vip_pic);
        this.mLineTropicLeft = (TbImageView) findViewById(R.id.line_tropic_left);
        this.mLineTropicRight = (TbImageView) findViewById(R.id.line_tropic_right);
        this.mSevenDayVip = (TextView) findViewById(R.id.seven_day_vip);
        this.mSevenDayVipDec = (TextView) findViewById(R.id.seven_day_vip_dec);
        this.mKnow = (Button) findViewById(R.id.tropic_know);
        this.mClose = (TbImageView) findViewById(R.id.close);
    }

    private void registeListener() {
        this.mKnow.setOnClickListener(this.mOnClickListener);
        this.mClose.setOnClickListener(this.mOnClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendStatisticLog(int i) {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_BACK_USER);
        statisticItem.param("obj_name", getResources().getString(R.string.static_item));
        statisticItem.param("obj_type", i);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setImageResource(this.mVipPic, R.drawable.icon_tropic);
        boolean z = false;
        this.mVipPic.setIsNight(i == 4 || i == 1);
        SkinManager.setImageResource(this.mLineTropicLeft, R.drawable.icon_tropic_left);
        this.mLineTropicRight.setIsNight(i == 4 || i == 1);
        SkinManager.setImageResource(this.mLineTropicRight, R.drawable.icon_tropic_right);
        this.mLineTropicRight.setIsNight(i == 4 || i == 1);
        SkinManager.setBackgroundColor(this.mRoundCornerLayout, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.mTropicGreetings, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.mSevenDayVip, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.mSevenDayVipDec, R.color.CAM_X0109);
        SkinManager.setViewTextColorSelector(this.mKnow, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
        SkinManager.setImageResource(this.mClose, R.drawable.icon_popup_close);
        this.mClose.setIsNight((i == 4 || i == 1) ? true : true);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_tropic_gift_bag);
        initView();
        registeListener();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mOnClickListener != null) {
            this.mOnClickListener = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        sendStatisticLog(1);
    }
}
