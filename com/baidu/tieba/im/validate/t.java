package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
public final class t extends com.baidu.adp.a.f {
    private View a;
    private ImageView c;
    private ValidateActivity d;
    private BdListView e;
    private h f;
    private ProgressBar g;
    private NavigationBar h;

    public t(ValidateActivity validateActivity) {
        super(validateActivity);
        this.d = validateActivity;
        this.a = View.inflate(this.d, com.baidu.tieba.im.i.validate_activity, null);
        this.d.setContentView(this.a);
        this.h = (NavigationBar) this.d.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.h.a(this.d.getString(com.baidu.tieba.im.j.group_apply_join));
        this.h.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new u(this));
        this.e = (BdListView) this.a.findViewById(com.baidu.tieba.im.h.validate_list);
        this.g = (ProgressBar) this.a.findViewById(com.baidu.tieba.im.h.pro_load);
        a(false);
        this.f = new h(this.d);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnScrollListener(this.d);
        this.e.setOnSrollToBottomListener(this.d);
    }

    @Override // com.baidu.adp.a.f
    public final void c() {
        super.c();
        if (this.f != null) {
            this.f.a();
            this.f = null;
        }
        this.d = null;
    }

    public final void a(List<ValidateItemData> list) {
        if (this.f != null) {
            this.f.a(list);
        }
    }

    public final void a(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
    }

    public final void a(int i) {
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a(this.a);
        this.h.b(i);
        if (i == 1) {
            this.e.setDivider(new ColorDrawable(this.d.getResources().getColor(com.baidu.tieba.im.e.night_divider)));
            this.e.setDividerHeight(this.d.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.onedip));
            return;
        }
        this.e.setDivider(new ColorDrawable(this.d.getResources().getColor(com.baidu.tieba.im.e.day_divider)));
        this.e.setDividerHeight(this.d.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.onedip));
    }

    public final ImageView a() {
        return this.c;
    }

    public final BdListView d() {
        return this.e;
    }

    public final h e() {
        return this.f;
    }
}
