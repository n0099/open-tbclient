package com.baidu.tieba.personPolymeric.header;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonIntroductionActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PERSON_INTRODUCTION = "person_introduction";
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView mBackImg;
    public View.OnClickListener mClickListener;
    public TextView mIntroView;
    public NavigationBar mNavigationBar;
    public View mRootView;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonIntroductionActivity f56001e;

        public a(PersonIntroductionActivity personIntroductionActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personIntroductionActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56001e = personIntroductionActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56001e.finish();
            }
        }
    }

    public PersonIntroductionActivity() {
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
        this.mClickListener = new a(this);
    }

    public static void startPersonIntroductionActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) || k.isEmpty(str) || context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, PersonIntroductionActivity.class);
        intent.putExtra(PERSON_INTRODUCTION, str);
        context.startActivity(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.mIntroView, R.color.CAM_X0105, 1, i2);
            SkinManager.setBackgroundResource(this.mRootView, R.color.CAM_X0201, i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.person_introduction_layout);
            this.mRootView = findViewById(R.id.person_intro_root_view);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.person_introduction_title));
            ImageView imageView = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
            this.mBackImg = imageView;
            imageView.setOnClickListener(this.mClickListener);
            SkinManager.setImageResource(this.mBackImg, R.drawable.selector_topbar_return_black);
            TextView textView = (TextView) findViewById(R.id.person_intro);
            this.mIntroView = textView;
            textView.setText(getIntent().getStringExtra(PERSON_INTRODUCTION));
        }
    }
}
