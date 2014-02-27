package com.baidu.tieba.im.validate;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public final class r extends com.baidu.adp.a.e {
    private View a;
    private ImageView c;
    private ValidateActivity d;
    private BdListView e;
    private f f;
    private ProgressBar g;
    private NavigationBar h;

    public r(ValidateActivity validateActivity) {
        super(validateActivity);
        this.d = validateActivity;
        this.a = View.inflate(this.d, R.layout.validate_activity, null);
        this.d.setContentView(this.a);
        this.h = (NavigationBar) this.d.findViewById(R.id.view_navigation_bar);
        this.h.a(this.d.getString(R.string.group_apply_join));
        this.h.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        this.e = (BdListView) this.a.findViewById(R.id.validate_list);
        this.g = (ProgressBar) this.a.findViewById(R.id.pro_load);
        a(false);
        this.f = new f(this.d);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnScrollListener(this.d);
        this.e.setOnSrollToBottomListener(this.d);
    }

    @Override // com.baidu.adp.a.e
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
            this.e.setDivider(new ColorDrawable(this.d.getResources().getColor(R.color.night_divider)));
            this.e.setDividerHeight(this.d.getResources().getDimensionPixelSize(R.dimen.onedip));
            return;
        }
        this.e.setDivider(new ColorDrawable(this.d.getResources().getColor(R.color.day_divider)));
        this.e.setDividerHeight(this.d.getResources().getDimensionPixelSize(R.dimen.onedip));
    }

    public final ImageView a() {
        return this.c;
    }

    public final BdListView d() {
        return this.e;
    }

    public final f e() {
        return this.f;
    }
}
