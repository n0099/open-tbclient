package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.tieba.LabelActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.home.SearchActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ NewHomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NewHomeActivity newHomeActivity) {
        this.a = newHomeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.refresh /* 2131230835 */:
                TiebaApplication.b().j(0);
                this.a.j();
                this.a.i();
                return;
            case R.id.search /* 2131230839 */:
                SearchActivity.a(this.a, this.a.getString(R.string.recommend_title));
                return;
            case R.id.edit_tag_btn /* 2131231258 */:
                LabelActivity.a(this.a, 1600002, "allthread");
                return;
            case R.id.home_webview_item /* 2131231259 */:
                this.a.i();
                return;
            default:
                return;
        }
    }
}
