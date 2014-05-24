package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.c {
    private View a;
    private ImageView b;
    private ValidateActivity c;
    private BdListView d;
    private h e;
    private ProgressBar f;
    private NavigationBar g;

    public t(ValidateActivity validateActivity) {
        super(validateActivity);
        this.c = validateActivity;
        a();
        this.e = new h(this.c);
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnScrollListener(this.c);
        this.d.setOnSrollToBottomListener(this.c);
    }

    void a() {
        this.a = View.inflate(this.c, w.validate_activity, null);
        this.c.setContentView(this.a);
        this.g = (NavigationBar) this.c.findViewById(v.view_navigation_bar);
        this.g.a(this.c.getString(y.group_apply_join));
        this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new u(this));
        this.d = (BdListView) this.a.findViewById(v.validate_list);
        this.f = (ProgressBar) this.a.findViewById(v.pro_load);
        a(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
        this.c = null;
    }

    public void a(List<ValidateItemData> list) {
        if (this.e != null) {
            this.e.a(list);
        }
    }

    public void a(boolean z) {
        this.f.setVisibility(z ? 0 : 8);
    }

    public void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.a);
        this.g.c(i);
        if (i == 1) {
            this.d.setDivider(new ColorDrawable(this.c.getResources().getColor(com.baidu.tieba.s.night_divider)));
            this.d.setDividerHeight(this.c.getResources().getDimensionPixelSize(com.baidu.tieba.t.onedip));
            return;
        }
        this.d.setDivider(new ColorDrawable(this.c.getResources().getColor(com.baidu.tieba.s.day_divider)));
        this.d.setDividerHeight(this.c.getResources().getDimensionPixelSize(com.baidu.tieba.t.onedip));
    }

    public ImageView b() {
        return this.b;
    }

    public BdListView c() {
        return this.d;
    }

    public h d() {
        return this.e;
    }
}
