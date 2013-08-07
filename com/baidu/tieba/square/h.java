package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ah;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.view.z;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter implements z {

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f1724a = new i(this);
    private final Activity b;
    private g c;
    private com.baidu.tieba.util.a d;

    public h(Activity activity) {
        this.b = activity;
        this.d = new com.baidu.tieba.util.a(activity);
        int a2 = am.a((Context) activity, 54.0f);
        this.d.a(a2, a2);
    }

    public void a(g gVar) {
        this.c = gVar;
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
            ap.b(view);
        }
        int au = TiebaApplication.f().au();
        if (itemViewType == 0) {
            TextView textView = (TextView) view.findViewById(R.id.name);
            View findViewById = view.findViewById(R.id.container);
            if (au == 1) {
                textView.setTextColor(-8682095);
                ah.h(findViewById, (int) R.drawable.bg_list_up_1);
            } else {
                textView.setTextColor(-8023135);
                ah.h(findViewById, (int) R.drawable.bg_list_up);
            }
        } else if (itemViewType == 1) {
            ap.a(view);
        } else if (itemViewType == 3) {
            ap.a(view.findViewById(R.id.container), 2, au);
            ap.a(view);
        } else {
            ap.a(view.findViewById(R.id.container), 1, au);
            ap.a(view);
            a(viewGroup, (k) view.getTag(), i);
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
            r rVar = new r();
            rVar.f1734a = null;
            k kVar = new k();
            kVar.d = rVar;
            inflate.setTag(kVar);
            inflate.setOnClickListener(this.f1724a);
            return inflate;
        }
        View inflate2 = from.inflate(R.layout.bar_home_first_dir_item, (ViewGroup) null);
        inflate2.setOnClickListener(this.f1724a);
        k kVar2 = new k();
        kVar2.f1727a = (ImageView) inflate2.findViewById(R.id.portrait);
        kVar2.b = (TextView) inflate2.findViewById(R.id.name);
        kVar2.c = (BestStringsFitTextView) inflate2.findViewById(R.id.description);
        inflate2.setTag(kVar2);
        return inflate2;
    }

    private void a(ViewGroup viewGroup, k kVar, int i) {
        r rVar = (r) this.c.c().get((i - 1) / 2);
        kVar.d = rVar;
        kVar.b.setText(rVar.b);
        if (rVar.e != null) {
            String[] strArr = new String[rVar.e.size()];
            for (int i2 = 0; i2 < rVar.e.size(); i2++) {
                strArr[i2] = ((r) rVar.e.get(i2)).b;
            }
            kVar.c.setTextArray(strArr);
            kVar.c.setVisibility(0);
        } else {
            kVar.c.setVisibility(8);
        }
        if (rVar.d != null) {
            kVar.f1727a.setTag(rVar.d);
            if (this.d.d(rVar.d) != null) {
                kVar.f1727a.invalidate();
                return;
            } else {
                kVar.f1727a.setImageResource(R.drawable.icon_all_categories);
                return;
            }
        }
        kVar.f1727a.setImageResource(R.drawable.icon_all_categories);
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

    @Override // com.baidu.tieba.view.z
    public void c() {
        this.d.b();
    }

    @Override // com.baidu.tieba.view.z
    public void a(View view, int i, int i2) {
        while (i <= i2) {
            if (getItemViewType(i) == 2) {
                r rVar = (r) this.c.c().get((i - 1) / 2);
                if (rVar.d != null && this.d.d(rVar.d) == null) {
                    this.d.a(rVar.d, new j(this, view));
                }
            }
            i++;
        }
    }
}
