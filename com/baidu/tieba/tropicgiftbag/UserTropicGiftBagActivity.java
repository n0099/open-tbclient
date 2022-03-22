package com.baidu.tieba.tropicgiftbag;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserTropicGiftBagActivity a;

        public a(UserTropicGiftBagActivity userTropicGiftBagActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userTropicGiftBagActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userTropicGiftBagActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TbPageContext<?> pageContext = this.a.getPageContext();
                if (view.getId() == this.a.mKnow.getId()) {
                    UrlManager.getInstance().dealOneLink(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    this.a.sendStatisticLog(2);
                    this.a.finish();
                }
                if (view.getId() == this.a.mClose.getId()) {
                    this.a.finish();
                }
            }
        }
    }

    public UserTropicGiftBagActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f092153);
            this.mRoundCornerLayout = roundRelativeLayout;
            roundRelativeLayout.setAllCornerRound(n.f(this, R.dimen.tbds32));
            this.mTropicGreetings = (TextView) findViewById(R.id.obfuscated_res_0x7f092154);
            this.mVipPic = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0923f8);
            this.mLineTropicLeft = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091266);
            this.mLineTropicRight = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091267);
            this.mSevenDayVip = (TextView) findViewById(R.id.obfuscated_res_0x7f091caa);
            this.mSevenDayVipDec = (TextView) findViewById(R.id.obfuscated_res_0x7f091cab);
            this.mKnow = (Button) findViewById(R.id.obfuscated_res_0x7f092155);
            this.mClose = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090662);
        }
    }

    private void registeListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mKnow.setOnClickListener(this.mOnClickListener);
            this.mClose.setOnClickListener(this.mOnClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendStatisticLog(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_BACK_USER);
            statisticItem.param("obj_name", getResources().getString(R.string.obfuscated_res_0x7f0f11c7));
            statisticItem.param("obj_type", i);
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
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setImageResource(this.mVipPic, R.drawable.obfuscated_res_0x7f080a91);
            this.mVipPic.setSkinType(i);
            SkinManager.setImageResource(this.mLineTropicLeft, R.drawable.obfuscated_res_0x7f080a92);
            this.mLineTropicLeft.setSkinType(i);
            SkinManager.setImageResource(this.mLineTropicRight, R.drawable.obfuscated_res_0x7f080a93);
            this.mLineTropicRight.setSkinType(i);
            SkinManager.setBackgroundColor(this.mRoundCornerLayout, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.mTropicGreetings, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mSevenDayVip, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mSevenDayVipDec, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColorSelector(this.mKnow, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
            SkinManager.setImageResource(this.mClose, R.drawable.obfuscated_res_0x7f0808c2);
            this.mClose.setSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d005b);
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
