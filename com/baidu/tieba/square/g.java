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
import com.baidu.tieba.util.x;
import com.baidu.tieba.view.v;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter implements v {
    View.OnClickListener a = new h(this);
    private final Activity b;
    private f c;
    private com.baidu.tieba.util.a d;

    public g(Activity activity) {
        this.b = activity;
        this.d = new com.baidu.tieba.util.a(activity);
        int a = ab.a(activity, 54.0f);
        this.d.a(a, a);
    }

    public void a(f fVar) {
        this.c = fVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        ArrayList c = this.c.c();
        if (c == null || c.size() <= 0) {
            return 2;
        }
        return 2 + c.size() + c.size() + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = a(viewGroup, itemViewType);
            ae.b(view);
        }
        int at = TiebaApplication.f().at();
        if (itemViewType == 0) {
            TextView textView = (TextView) view.findViewById(R.id.name);
            View findViewById = view.findViewById(R.id.container);
            if (at == 1) {
                textView.setTextColor(-8682095);
                x.h(findViewById, (int) R.drawable.bg_list_up_1);
            } else {
                textView.setTextColor(-8023135);
                x.h(findViewById, (int) R.drawable.bg_list_up);
            }
        } else if (itemViewType == 1) {
            ae.a(view);
        } else if (itemViewType == 3) {
            ae.a(view.findViewById(R.id.container), 2, at);
            ae.a(view);
        } else {
            ae.a(view.findViewById(R.id.container), 1, at);
            ae.a(view);
            a(viewGroup, (j) view.getTag(), i);
        }
        return view;
    }

    private View a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i == 0) {
            return from.inflate(R.layout.bar_home_header, (ViewGroup) null);
        }
        if (i == 1) {
            return from.inflate(R.layout.bar_home_list_line, (ViewGroup) null);
        }
        if (i == 3) {
            View inflate = from.inflate(R.layout.bar_home_all_dir_item, (ViewGroup) null);
            q qVar = new q();
            qVar.a = null;
            j jVar = new j();
            jVar.d = qVar;
            inflate.setTag(jVar);
            inflate.setOnClickListener(this.a);
            return inflate;
        }
        View inflate2 = from.inflate(R.layout.bar_home_first_dir_item, (ViewGroup) null);
        inflate2.setOnClickListener(this.a);
        j jVar2 = new j();
        jVar2.a = (ImageView) inflate2.findViewById(R.id.portrait);
        jVar2.b = (TextView) inflate2.findViewById(R.id.name);
        jVar2.c = (BestStringsFitTextView) inflate2.findViewById(R.id.description);
        inflate2.setTag(jVar2);
        return inflate2;
    }

    private void a(ViewGroup viewGroup, j jVar, int i) {
        q qVar = (q) this.c.c().get((i - 1) / 2);
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
                c.b(jVar.a);
                return;
            }
            jVar.a.setImageResource(R.drawable.icon_all_categories);
            jVar.a.setTag(qVar.d);
            return;
        }
        jVar.a.setImageResource(R.drawable.icon_all_categories);
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
            return 3;
        }
        if (i % 2 == 0) {
            return 2;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public Activity a() {
        return this.b;
    }

    @Override // com.baidu.tieba.view.v
    public void c() {
        this.d.b();
    }

    @Override // com.baidu.tieba.view.v
    public void a(View view, int i, int i2) {
        while (i < i2) {
            if (getItemViewType(i) == 2) {
                q qVar = (q) this.c.c().get((i - 1) / 2);
                if (qVar.d != null && this.d.c(qVar.d) == null) {
                    this.d.a(qVar.d, new i(this, view));
                }
            }
            i++;
        }
    }
}
