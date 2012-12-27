package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.home.SearchActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ NewHomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewHomeActivity newHomeActivity) {
        this.a = newHomeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login /* 2131230785 */:
                LoginActivity.a(this.a);
                return;
            case R.id.refresh /* 2131230809 */:
                Activity currentActivity = this.a.getLocalActivityManager().getCurrentActivity();
                if (currentActivity instanceof RecommendActivity) {
                    TiebaApplication.a().h(0);
                    ((RecommendActivity) currentActivity).h();
                    ((RecommendActivity) currentActivity).g();
                    return;
                } else if (currentActivity instanceof GuessActivity) {
                    ((GuessActivity) currentActivity).h();
                    return;
                } else {
                    return;
                }
            case R.id.search /* 2131230813 */:
                SearchActivity.a(this.a, this.a.getString(R.string.recommend_title));
                return;
            default:
                return;
        }
    }
}
