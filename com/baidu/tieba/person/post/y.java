package com.baidu.tieba.person.post;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.e {
    final /* synthetic */ t a;
    private BaseFragmentActivity b;
    private TextView c = null;
    private ProgressBar d = null;
    private View.OnClickListener e = null;
    private View f = null;
    private View g;

    public y(t tVar, BaseFragmentActivity baseFragmentActivity) {
        this.a = tVar;
        this.b = null;
        this.b = baseFragmentActivity;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View a() {
        this.f = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.new_pb_list_more, (ViewGroup) null);
        this.f.setPadding(0, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin), 0, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin));
        this.c = (TextView) this.f.findViewById(com.baidu.tieba.v.pb_more_text);
        this.g = this.f.findViewById(com.baidu.tieba.v.pb_more_view);
        this.g.setVisibility(8);
        this.d = (ProgressBar) this.f.findViewById(com.baidu.tieba.v.progress);
        a(TbadkApplication.m252getInst().getSkinType());
        this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.f;
    }

    public void a(int i) {
        this.b.c().a(this.g);
    }

    public void c() {
        this.d.setVisibility(0);
        this.c.setText(this.b.getText(com.baidu.tieba.y.loading));
        this.g.setVisibility(0);
    }

    public void d() {
        if (this.d != null) {
            this.d.setVisibility(8);
        }
        if (this.c != null) {
            this.g.setVisibility(0);
            this.c.setText(com.baidu.tieba.y.person_post_thread_no_more);
        }
    }

    public void e() {
        this.d.setVisibility(8);
        this.g.setVisibility(0);
        this.c.setText(com.baidu.tieba.y.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.e != null) {
            this.e.onClick(this.f);
        }
    }
}
