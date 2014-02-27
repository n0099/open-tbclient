package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ch;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class c extends BaseAdapter {
    View.OnClickListener a = new d(this);
    private Activity b;
    private ArrayList<ab> c;
    private com.baidu.tieba.util.i d;

    public c(Activity activity, h hVar) {
        this.b = activity;
        this.c = hVar.d();
        this.d = new com.baidu.tieba.util.i(activity);
        int a = BdUtilHelper.a((Context) activity, 45.0f);
        this.d.a(a, a);
    }

    public final ArrayList<ab> a() {
        return this.c;
    }

    public final void a(ArrayList<ab> arrayList) {
        this.c = arrayList;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.c == null) {
            return 0;
        }
        return (this.c.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        int i2 = 0;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.b);
            if (itemViewType == 3) {
                view2 = from.inflate(R.layout.bar_home_list_line, viewGroup, false);
            } else if (itemViewType == 2) {
                view2 = from.inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
            } else {
                View inflate = from.inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
                inflate.setOnClickListener(this.a);
                g gVar = new g();
                gVar.a = (HeadImageView) inflate.findViewById(R.id.portrait);
                gVar.b = (TextView) inflate.findViewById(R.id.name);
                gVar.c = (BestStringsFitTextView) inflate.findViewById(R.id.description);
                inflate.setTag(gVar);
                view2 = inflate;
            }
            ch.b(view2);
            view = view2;
        }
        ch.a(view);
        if (itemViewType != 3) {
            int ae = TiebaApplication.g().ae();
            View findViewById = view.findViewById(R.id.container);
            ch.a(findViewById, 1, ae);
            if (itemViewType == 2) {
                if (getCount() > 1) {
                    findViewById.setVisibility(0);
                }
            } else if (itemViewType == 1) {
                g gVar2 = (g) view.getTag();
                ab abVar = this.c.get(i / 2);
                gVar2.d = abVar;
                gVar2.b.setText(abVar.b);
                if (abVar.e != null) {
                    gVar2.c.setVisibility(0);
                    String[] strArr = new String[abVar.e.size()];
                    while (true) {
                        int i3 = i2;
                        if (i3 >= abVar.e.size()) {
                            break;
                        }
                        strArr[i3] = abVar.e.get(i3).b;
                        i2 = i3 + 1;
                    }
                    gVar2.c.setTextArray(strArr);
                } else {
                    gVar2.c.setVisibility(8);
                }
                if (abVar.d != null) {
                    gVar2.a.setImageBitmap(null);
                    gVar2.a.setTag(abVar.d);
                    this.d.b(abVar.d, new e(this, viewGroup));
                }
            }
        }
        return view;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        if (i == getCount() - 1) {
            return 2;
        }
        if (i < 0) {
            i *= -1;
        }
        return i % 2 == 1 ? 3 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Activity b() {
        return this.b;
    }
}
