package com.baidu.tieba.tropicgiftbag;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class UserTropicGiftBagActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView mClose;
    public Button mKnow;
    public TbImageView mLineTropicLeft;
    public TbImageView mLineTropicRight;
    public View.OnClickListener mOnClickListener;
    public RoundRelativeLayout mRoundCornerLayout;
    public TextView mSevenDayVip;
    public TextView mSevenDayVipDec;
    public TextView mTropicGreetings;
    public TbImageView mVipPic;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserTropicGiftBagActivity f57523e;

        public a(UserTropicGiftBagActivity userTropicGiftBagActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userTropicGiftBagActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57523e = userTropicGiftBagActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TbPageContext<?> pageContext = this.f57523e.getPageContext();
                if (view.getId() == this.f57523e.mKnow.getId()) {
                    UrlManager.getInstance().dealOneLink(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    this.f57523e.sendStatisticLog(2);
                    this.f57523e.finish();
                }
                if (view.getId() == this.f57523e.mClose.getId()) {
                    this.f57523e.finish();
                }
            }
        }
    }

    public UserTropicGiftBagActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnClickListener = new a(this);
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
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
    }

    private void registeListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.mKnow.setOnClickListener(this.mOnClickListener);
            this.mClose.setOnClickListener(this.mOnClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendStatisticLog(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_BACK_USER);
            statisticItem.param("obj_name", getResources().getString(R.string.static_item));
            statisticItem.param("obj_type", i2);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setImageResource(this.mVipPic, R.drawable.icon_tropic);
            this.mVipPic.setSkinType(i2);
            SkinManager.setImageResource(this.mLineTropicLeft, R.drawable.icon_tropic_left);
            this.mLineTropicLeft.setSkinType(i2);
            SkinManager.setImageResource(this.mLineTropicRight, R.drawable.icon_tropic_right);
            this.mLineTropicRight.setSkinType(i2);
            SkinManager.setBackgroundColor(this.mRoundCornerLayout, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.mTropicGreetings, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mSevenDayVip, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mSevenDayVipDec, R.color.CAM_X0109);
            SkinManager.setViewTextColorSelector(this.mKnow, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
            SkinManager.setImageResource(this.mClose, R.drawable.icon_popup_close);
            this.mClose.setSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.activity_user_tropic_gift_bag);
            initView();
            registeListener();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            if (this.mOnClickListener != null) {
                this.mOnClickListener = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            sendStatisticLog(1);
        }
    }
}
