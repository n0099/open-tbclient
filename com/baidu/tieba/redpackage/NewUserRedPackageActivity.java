package com.baidu.tieba.redpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserRedPackageActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ap4;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class NewUserRedPackageActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RoundRelativeLayout a;
    public NewUserRedPackageData b;
    public ap4 c;
    public ImageView d;
    public ImageView e;
    public View.OnClickListener f;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewUserRedPackageActivity a;

        public a(NewUserRedPackageActivity newUserRedPackageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserRedPackageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newUserRedPackageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.e.getId()) {
                    TiebaStatic.log(new StatisticItem("c13684").param("obj_type", 3));
                    this.a.finish();
                } else if (view2.getId() == this.a.d.getId()) {
                    TiebaStatic.log(new StatisticItem("c13684").param("obj_type", 2));
                    if (TbadkCoreApplication.isLogin()) {
                        if (this.a.b != null) {
                            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{this.a.b.clickUrl});
                            this.a.finish();
                            return;
                        }
                        return;
                    }
                    this.a.sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.a.getActivity(), true, 25046)));
                }
            }
        }
    }

    public NewUserRedPackageActivity() {
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
        this.f = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        }
    }

    public final void N0() {
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || getIntent() == null) {
            return;
        }
        NewUserRedPackageData newUserRedPackageData = (NewUserRedPackageData) getIntent().getSerializableExtra(NewUserRedPackageActivityConfig.KEY_DATA);
        this.b = newUserRedPackageData;
        if (newUserRedPackageData != null && (bdImage = (BdImage) BdResourceLoader.getInstance().loadResourceFromMemery(this.b.topPicUrl, 10, new Object[0])) != null) {
            this.d.setImageBitmap(bdImage.getRawBitmap());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 25046 && this.b != null) {
                this.c.a();
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{this.b.clickUrl});
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d004b);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
            this.a = roundRelativeLayout;
            roundRelativeLayout.setAllCornerRound(BdUtilHelper.getDimens(this, R.dimen.tbds31));
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f09111a);
            this.e = (ImageView) findViewById(R.id.img_btn_close);
            this.d.setOnClickListener(this.f);
            this.e.setOnClickListener(this.f);
            N0();
            TiebaStatic.log(new StatisticItem("c13684").param("obj_type", 1));
            this.c = new ap4();
        }
    }
}
