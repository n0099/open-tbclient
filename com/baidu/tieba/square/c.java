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
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.ap;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f1719a = new d(this);
    private Activity b;
    private final g c;
    private com.baidu.tieba.util.a d;

    public c(Activity activity, g gVar, boolean z) {
        this.b = activity;
        this.c = gVar;
        this.d = new com.baidu.tieba.util.a(activity);
        int a2 = am.a((Context) activity, 54.0f);
        this.d.a(a2, a2);
    }

    public g a() {
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
            ap.b(view);
        }
        ap.a(view);
        if (itemViewType != 3) {
            int au = TiebaApplication.f().au();
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
            ap.a(findViewById, itemViewType, au);
            a(viewGroup, (k) view.getTag(), i);
        }
        return view;
    }

    private View a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i == 3) {
            return from.inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        View inflate = from.inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.f1719a);
        k kVar = new k();
        kVar.f1727a = (ImageView) inflate.findViewById(R.id.portrait);
        kVar.b = (TextView) inflate.findViewById(R.id.name);
        kVar.c = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(kVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, k kVar, int i) {
        r rVar = (r) this.c.c().get(i / 2);
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
            if (this.d.a(rVar.d, new e(this, viewGroup)) != null) {
                kVar.f1727a.invalidate();
                return;
            } else {
                kVar.f1727a.setImageResource(R.drawable.icon_all_categories);
                return;
            }
        }
        kVar.f1727a.setImageResource(R.drawable.icon_all_categories);
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
        if (i % 2 != 0) {
            return 3;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity b() {
        return this.b;
    }
}
