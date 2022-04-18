package com.baidu.tieba.redpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ej4;
import com.repackage.fo;
import com.repackage.ig;
import com.repackage.oi;
/* loaded from: classes4.dex */
public class NewUserRedPackageActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView mBgImage;
    public ImageView mCloseBtnImage;
    public NewUserRedPackageData mData;
    public ej4 mGetMoneyModel;
    public View.OnClickListener mOnClickListener;
    public RoundRelativeLayout mRoundCornerLayout;

    /* loaded from: classes4.dex */
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
                if (view2.getId() != this.a.mCloseBtnImage.getId()) {
                    if (view2.getId() == this.a.mBgImage.getId()) {
                        TiebaStatic.log(new StatisticItem("c13684").param("obj_type", 2));
                        if (TbadkCoreApplication.isLogin()) {
                            if (this.a.mData != null) {
                                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{this.a.mData.clickUrl});
                                this.a.finish();
                                return;
                            }
                            return;
                        }
                        this.a.sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.a.getActivity(), true, 25046)));
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13684").param("obj_type", 3));
                this.a.finish();
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
        this.mOnClickListener = new a(this);
    }

    private void setData() {
        fo foVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || getIntent() == null) {
            return;
        }
        NewUserRedPackageData newUserRedPackageData = (NewUserRedPackageData) getIntent().getSerializableExtra("key_data");
        this.mData = newUserRedPackageData;
        if (newUserRedPackageData == null || (foVar = (fo) ig.h().n(this.mData.topPicUrl, 10, new Object[0])) == null) {
            return;
        }
        this.mBgImage.setImageBitmap(foVar.p());
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i != 25046 || this.mData == null) {
                return;
            }
            this.mGetMoneyModel.a();
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{this.mData.clickUrl});
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(this.mRoundCornerLayout, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0047);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f091ae8);
            this.mRoundCornerLayout = roundRelativeLayout;
            roundRelativeLayout.setAllCornerRound(oi.f(this, R.dimen.tbds31));
            this.mBgImage = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e9c);
            this.mCloseBtnImage = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e9f);
            this.mBgImage.setOnClickListener(this.mOnClickListener);
            this.mCloseBtnImage.setOnClickListener(this.mOnClickListener);
            setData();
            TiebaStatic.log(new StatisticItem("c13684").param("obj_type", 1));
            this.mGetMoneyModel = new ej4();
        }
    }
}
