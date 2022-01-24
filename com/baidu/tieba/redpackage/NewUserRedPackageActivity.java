package com.baidu.tieba.redpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.l.d;
import c.a.d.f.p.n;
import c.a.s0.a.t;
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
/* loaded from: classes12.dex */
public class NewUserRedPackageActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView mBgImage;
    public ImageView mCloseBtnImage;
    public NewUserRedPackageData mData;
    public t mGetMoneyModel;
    public View.OnClickListener mOnClickListener;
    public RoundRelativeLayout mRoundCornerLayout;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewUserRedPackageActivity f47766e;

        public a(NewUserRedPackageActivity newUserRedPackageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserRedPackageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47766e = newUserRedPackageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() != this.f47766e.mCloseBtnImage.getId()) {
                    if (view.getId() == this.f47766e.mBgImage.getId()) {
                        TiebaStatic.log(new StatisticItem("c13684").param("obj_type", 2));
                        if (TbadkCoreApplication.isLogin()) {
                            if (this.f47766e.mData != null) {
                                UrlManager.getInstance().dealOneLink(this.f47766e.getPageContext(), new String[]{this.f47766e.mData.clickUrl});
                                this.f47766e.finish();
                                return;
                            }
                            return;
                        }
                        this.f47766e.sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.f47766e.getActivity(), true, 25046)));
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13684").param("obj_type", 3));
                this.f47766e.finish();
            }
        }
    }

    public NewUserRedPackageActivity() {
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

    private void setData() {
        c.a.d.n.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || getIntent() == null) {
            return;
        }
        NewUserRedPackageData newUserRedPackageData = (NewUserRedPackageData) getIntent().getSerializableExtra("key_data");
        this.mData = newUserRedPackageData;
        if (newUserRedPackageData == null || (aVar = (c.a.d.n.d.a) d.h().n(this.mData.topPicUrl, 10, new Object[0])) == null) {
            return;
        }
        this.mBgImage.setImageBitmap(aVar.p());
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
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 != 25046 || this.mData == null) {
                return;
            }
            this.mGetMoneyModel.a();
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{this.mData.clickUrl});
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.mRoundCornerLayout, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.activity_new_user_red_package);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
            this.mRoundCornerLayout = roundRelativeLayout;
            roundRelativeLayout.setAllCornerRound(n.f(this, R.dimen.tbds31));
            this.mBgImage = (ImageView) findViewById(R.id.img_bg);
            this.mCloseBtnImage = (ImageView) findViewById(R.id.img_btn_close);
            this.mBgImage.setOnClickListener(this.mOnClickListener);
            this.mCloseBtnImage.setOnClickListener(this.mOnClickListener);
            setData();
            TiebaStatic.log(new StatisticItem("c13684").param("obj_type", 1));
            this.mGetMoneyModel = new t();
        }
    }
}
