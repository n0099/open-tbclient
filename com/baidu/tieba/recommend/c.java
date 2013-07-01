package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.tieba.LabelActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.home.SearchActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewHomeActivity f1386a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewHomeActivity newHomeActivity) {
        this.f1386a = newHomeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.refresh /* 2131099795 */:
                TiebaApplication.f().l(0);
                this.f1386a.c();
                this.f1386a.b();
                return;
            case R.id.search /* 2131099799 */:
                SearchActivity.a(this.f1386a, this.f1386a.getString(R.string.recommend_title));
                return;
            case R.id.edit_tag_btn /* 2131100313 */:
                LabelActivity.a(this.f1386a, 1600002, "allthread");
                return;
            case R.id.home_webview_item /* 2131100314 */:
                this.f1386a.b();
                return;
            default:
                return;
        }
    }
}
