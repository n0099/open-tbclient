package com.baidu.tieba.personPolymeric.header;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
/* loaded from: classes5.dex */
public class PersonIntroductionActivity extends BaseActivity {
    public static final String PERSON_INTRODUCTION = "person_introduction";
    public ImageView mBackImg;
    public View.OnClickListener mClickListener = new a();
    public TextView mIntroView;
    public NavigationBar mNavigationBar;
    public View mRootView;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonIntroductionActivity.this.finish();
        }
    }

    public static void startPersonIntroductionActivity(Context context, String str) {
        if (k.isEmpty(str) || context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, PersonIntroductionActivity.class);
        intent.putExtra(PERSON_INTRODUCTION, str);
        context.startActivity(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        SkinManager.setViewTextColor(this.mIntroView, R.color.CAM_X0105, 1, i2);
        SkinManager.setBackgroundResource(this.mRootView, R.color.CAM_X0201, i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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
