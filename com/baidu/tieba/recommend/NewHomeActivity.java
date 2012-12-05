package com.baidu.tieba.recommend;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.home.SearchActivity;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class NewHomeActivity extends ActivityGroup {
    private Button loginButton;
    private RadioButton mBtnGuess;
    private RadioButton mBtnRecommend;
    private FrameLayout mContent;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = null;
    private View.OnClickListener mOncClickListener;
    private Button refreshButton;
    private Button searchButton;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_home_activity);
        initUI();
    }

    private void initUI() {
        this.loginButton = (Button) findViewById(R.id.login);
        this.searchButton = (Button) findViewById(R.id.search);
        this.refreshButton = (Button) findViewById(R.id.refresh);
        this.mOncClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recommend.NewHomeActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.login /* 2131230785 */:
                        LoginActivity.startActivityNoExitDialog(NewHomeActivity.this);
                        return;
                    case R.id.search /* 2131230809 */:
                        SearchActivity.startActivity(NewHomeActivity.this, NewHomeActivity.this.getString(R.string.recommend_title));
                        return;
                    case R.id.refresh /* 2131230933 */:
                        Activity activity = NewHomeActivity.this.getLocalActivityManager().getCurrentActivity();
                        if (activity instanceof RecommendActivity) {
                            ((RecommendActivity) activity).resetPage();
                            ((RecommendActivity) activity).refresh();
                            return;
                        } else if (activity instanceof GuessActivity) {
                            ((GuessActivity) activity).refresh();
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        };
        this.loginButton.setOnClickListener(this.mOncClickListener);
        this.searchButton.setOnClickListener(this.mOncClickListener);
        this.refreshButton.setOnClickListener(this.mOncClickListener);
        this.mContent = (FrameLayout) findViewById(R.id.content);
        this.mBtnRecommend = (RadioButton) findViewById(R.id.recommend_tab);
        this.mBtnGuess = (RadioButton) findViewById(R.id.guess_tab);
        this.mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recommend.NewHomeActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setTextColor(NewHomeActivity.this.getResources().getColor(R.color.tab_hightlight_text_color));
                    if (buttonView != NewHomeActivity.this.mBtnRecommend) {
                        if (buttonView == NewHomeActivity.this.mBtnGuess) {
                            NewHomeActivity.this.addView("guess", GuessActivity.class);
                            return;
                        }
                        return;
                    }
                    NewHomeActivity.this.addView("recommend", RecommendActivity.class);
                    return;
                }
                buttonView.setTextColor(NewHomeActivity.this.getResources().getColor(R.color.tab_text_color));
            }
        };
        this.mBtnRecommend.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        this.mBtnGuess.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        this.mBtnRecommend.setChecked(true);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        String id = TiebaApplication.getCurrentAccount();
        if (id != null && id.length() > 0) {
            this.loginButton.setVisibility(4);
            this.loginButton.setClickable(false);
        } else {
            this.loginButton.setVisibility(0);
            this.loginButton.setClickable(true);
        }
        super.onResume();
        UtilHelper.setEyeShieldMode(this);
    }

    public void addView(String id, Class<?> cls) {
        Intent intent = new Intent(this, cls);
        this.mContent.removeAllViews();
        this.mContent.addView(getLocalActivityManager().startActivity(id, intent).getDecorView());
    }
}
