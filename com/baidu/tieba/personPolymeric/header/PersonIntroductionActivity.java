package com.baidu.tieba.personPolymeric.header;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PersonIntroductionActivity extends BaseActivity {
    private ImageView giu;
    private TextView kta;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonIntroductionActivity.this.finish();
        }
    };
    private NavigationBar mNavigationBar;
    private View mRootView;

    public static void aM(Context context, String str) {
        if (!aq.isEmpty(str) && context != null) {
            Intent intent = new Intent();
            intent.setClass(context, PersonIntroductionActivity.class);
            intent.putExtra("person_introduction", str);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_introduction_layout);
        this.mRootView = findViewById(R.id.person_intro_root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.person_introduction_title));
        this.giu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        this.giu.setOnClickListener(this.mClickListener);
        am.setImageResource(this.giu, R.drawable.selector_topbar_return_black);
        this.kta = (TextView) findViewById(R.id.person_intro);
        this.kta.setText(getIntent().getStringExtra("person_introduction"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.kta, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
