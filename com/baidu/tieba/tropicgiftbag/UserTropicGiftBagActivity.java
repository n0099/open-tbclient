package com.baidu.tieba.tropicgiftbag;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes8.dex */
public class UserTropicGiftBagActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RoundRelativeLayout a;
    public TextView b;
    public TextView c;
    public TextView d;
    public Button e;
    public TbImageView f;
    public TbImageView g;
    public TbImageView h;
    public TbImageView i;
    public View.OnClickListener j;

    /* loaded from: classes8.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbPageContext<?> pageContext = this.a.getPageContext();
                if (view2.getId() == this.a.e.getId()) {
                    UrlManager.getInstance().dealOneLink(pageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    this.a.t1(2);
                    this.a.finish();
                }
                if (view2.getId() == this.a.i.getId()) {
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
        this.j = new a(this);
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            if (this.j != null) {
                this.j = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            t1(1);
        }
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.setOnClickListener(this.j);
            this.i.setOnClickListener(this.j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d005f);
            initView();
            s1();
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f0926f8);
            this.a = roundRelativeLayout;
            roundRelativeLayout.setAllCornerRound(BdUtilHelper.getDimens(this, R.dimen.tbds32));
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0926f9);
            this.f = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0929e3);
            this.g = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091540);
            this.h = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091541);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0921e9);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0921ea);
            this.e = (Button) findViewById(R.id.obfuscated_res_0x7f0926fa);
            this.i = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090727);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setImageResource(this.f, R.drawable.obfuscated_res_0x7f080d28);
            this.f.setSkinType(i);
            SkinManager.setImageResource(this.g, R.drawable.obfuscated_res_0x7f080d29);
            this.g.setSkinType(i);
            SkinManager.setImageResource(this.h, R.drawable.obfuscated_res_0x7f080d2a);
            this.h.setSkinType(i);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColorSelector(this.e, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
            SkinManager.setImageResource(this.i, R.drawable.obfuscated_res_0x7f080b0c);
            this.i.setSkinType(i);
        }
    }

    public final void t1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_BACK_USER);
            statisticItem.param("obj_name", getResources().getString(R.string.obfuscated_res_0x7f0f1479));
            statisticItem.param("obj_type", i);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }
}
