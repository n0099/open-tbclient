package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.tieba.LabelActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.home.SearchActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewHomeActivity f1648a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewHomeActivity newHomeActivity) {
        this.f1648a = newHomeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.refresh /* 2131099800 */:
                TiebaApplication.f().j(0);
                this.f1648a.c();
                this.f1648a.b();
                return;
            case R.id.search /* 2131099804 */:
                SearchActivity.a(this.f1648a, this.f1648a.getString(R.string.recommend_title));
                return;
            case R.id.home_webview_item /* 2131100254 */:
                this.f1648a.b();
                return;
            case R.id.edit_tag_btn /* 2131100414 */:
                LabelActivity.a(this.f1648a, 16002, "allthread");
                return;
            default:
                return;
        }
    }
}
