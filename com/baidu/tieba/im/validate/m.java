package com.baidu.tieba.im.validate;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private View f1727a;
    private ImageView c;
    private ValidateActivity d;
    private BdListView e;
    private e f;
    private ProgressBar g;

    public m(ValidateActivity validateActivity) {
        super(validateActivity);
        this.d = validateActivity;
        a();
        this.f = new e(this.d);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnScrollListener(this.d);
    }

    void a() {
        this.f1727a = View.inflate(this.d, R.layout.validate_activity, null);
        this.d.setContentView(this.f1727a);
        this.c = (ImageView) this.f1727a.findViewById(R.id.back);
        this.c.setOnClickListener(this.d);
        this.e = (BdListView) this.f1727a.findViewById(R.id.validate_list);
        this.g = (ProgressBar) this.f1727a.findViewById(R.id.pro_load);
        a(false);
    }

    @Override // com.baidu.adp.a.e
    public void c() {
        super.c();
        if (this.f != null) {
            this.f.a();
            this.f = null;
        }
        this.d = null;
    }

    public void a(List<ValidateItemData> list) {
        if (this.f != null) {
            this.f.a(list);
        }
    }

    public void a(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
    }

    public void a(int i) {
        this.d.m().a(i == 1);
        this.d.m().a(this.f1727a);
        if (i == 1) {
            this.e.setDivider(this.d.getResources().getDrawable(R.drawable.list_divider_1));
        } else {
            this.e.setDivider(this.d.getResources().getDrawable(R.drawable.list_divider));
        }
    }

    public ImageView e() {
        return this.c;
    }

    public BdListView f() {
        return this.e;
    }

    public e g() {
        return this.f;
    }
}
