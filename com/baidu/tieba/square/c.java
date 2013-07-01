package com.baidu.tieba.square;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ab;
import com.baidu.tieba.util.ae;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f1429a = new d(this);
    private Activity b;
    private final f c;
    private com.baidu.tieba.util.a d;
    private final boolean e;

    public c(Activity activity, f fVar, boolean z) {
        this.b = activity;
        this.c = fVar;
        this.e = z;
        this.d = new com.baidu.tieba.util.a(activity);
        int a2 = ab.a(activity, 54.0f);
        this.d.a(a2, a2);
    }

    public f a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList c = this.c.c();
        if (c == null) {
            return 0;
        }
        return (c.size() * 2) - 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = a(viewGroup, itemViewType);
            ae.b(view);
        }
        ae.a(view);
        if (itemViewType != 3) {
            int at = TiebaApplication.f().at();
            View findViewById = view.findViewById(R.id.container);
            View findViewById2 = view.findViewById(R.id.item_up);
            View findViewById3 = view.findViewById(R.id.item_down);
            if (itemViewType == 0) {
                findViewById2.setVisibility(0);
                findViewById3.setVisibility(8);
            } else if (itemViewType == 2) {
                findViewById2.setVisibility(8);
                findViewById3.setVisibility(0);
            } else {
                findViewById2.setVisibility(8);
                findViewById3.setVisibility(8);
            }
            ae.a(findViewById, itemViewType, at);
            a(viewGroup, (j) view.getTag(), i);
        }
        return view;
    }

    private View a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i == 3) {
            return from.inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        View inflate = from.inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.f1429a);
        j jVar = new j();
        jVar.f1435a = (ImageView) inflate.findViewById(R.id.portrait);
        jVar.b = (TextView) inflate.findViewById(R.id.name);
        jVar.c = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(jVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, j jVar, int i) {
        q qVar = (q) this.c.c().get(i / 2);
        jVar.d = qVar;
        jVar.b.setText(qVar.b);
        if (qVar.e != null) {
            String[] strArr = new String[qVar.e.size()];
            for (int i2 = 0; i2 < qVar.e.size(); i2++) {
                strArr[i2] = ((q) qVar.e.get(i2)).b;
            }
            jVar.c.setTextArray(strArr);
            jVar.c.setVisibility(0);
        } else {
            jVar.c.setVisibility(8);
        }
        if (qVar.d != null) {
            com.baidu.adp.widget.a.b c = this.d.c(qVar.d);
            if (c != null) {
                c.b(jVar.f1435a);
                return;
            }
            jVar.f1435a.setImageResource(R.drawable.icon_all_categories);
            jVar.f1435a.setTag(qVar.d);
            this.d.a(qVar.d, new e(this, viewGroup));
            return;
        }
        jVar.f1435a.setImageResource(R.drawable.icon_all_categories);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == getCount() - 1) {
            return 2;
        }
        return i % 2 == 1 ? 3 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity b() {
        return this.b;
    }
}
