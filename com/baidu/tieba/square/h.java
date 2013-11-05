package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.util.bj;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f2364a = new i(this);
    private final Activity b;
    private g c;
    private com.baidu.tieba.util.a d;

    public h(Activity activity) {
        this.b = activity;
        this.d = new com.baidu.tieba.util.a(activity);
        int a2 = UtilHelper.a((Context) activity, 45.0f);
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
        ArrayList<s> d = this.c.d();
        if (d == null || d.size() <= 0) {
            return 2;
        }
        return 2 + (d.size() * 2);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = a(viewGroup, itemViewType);
            bj.b(view);
        }
        int as = TiebaApplication.g().as();
        com.baidu.tieba.j jVar = (com.baidu.tieba.j) this.b;
        jVar.m().a(as == 1);
        jVar.m().a(view);
        if (itemViewType == 0) {
            View findViewById = view.findViewById(R.id.container);
            if (as == 1) {
                bb.e(findViewById, (int) R.drawable.bg_ba_catalogue_1);
            } else {
                bb.e(findViewById, (int) R.drawable.bg_ba_catalogue);
            }
        } else if (itemViewType == 1) {
            bj.a(view);
        } else if (itemViewType == 3) {
            bj.a(view.findViewById(R.id.container), 2, as);
            bj.a(view);
            Button button = (Button) view.findViewById(R.id.bar_item_all);
        } else {
            bj.a(view.findViewById(R.id.container), 1, as);
            bj.a(view);
            a(viewGroup, (l) view.getTag(), i);
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
            s sVar = new s();
            sVar.f2375a = null;
            l lVar = new l();
            lVar.d = sVar;
            Button button = (Button) inflate.findViewById(R.id.bar_item_all);
            button.setOnClickListener(this.f2364a);
            button.setTag(lVar);
            return inflate;
        }
        View inflate2 = from.inflate(R.layout.bar_home_first_dir_item, (ViewGroup) null);
        inflate2.setOnClickListener(this.f2364a);
        l lVar2 = new l();
        lVar2.f2368a = (HeadImageView) inflate2.findViewById(R.id.portrait);
        lVar2.b = (TextView) inflate2.findViewById(R.id.squre_name);
        lVar2.c = (BestStringsFitTextView) inflate2.findViewById(R.id.description);
        inflate2.setTag(lVar2);
        return inflate2;
    }

    private void a(ViewGroup viewGroup, l lVar, int i) {
        s sVar = this.c.d().get((i - 1) / 2);
        lVar.d = sVar;
        lVar.b.setText(sVar.b);
        if (sVar.e != null) {
            String[] strArr = new String[sVar.e.size()];
            for (int i2 = 0; i2 < sVar.e.size(); i2++) {
                strArr[i2] = sVar.e.get(i2).b;
            }
            lVar.c.setTextArray(strArr);
            lVar.c.setVisibility(0);
        } else {
            lVar.c.setVisibility(8);
        }
        if (sVar.d != null) {
            lVar.f2368a.setTag(sVar.d);
            com.baidu.adp.widget.ImageView.e d = this.d.d(sVar.d);
            if (d != null) {
                lVar.f2368a.setImageBitmap(d.f());
                lVar.f2368a.invalidate();
                return;
            }
            this.d.a(sVar.d, new j(this, viewGroup));
        }
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
        return i % 2 == 1 ? 2 : 1;
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
}
