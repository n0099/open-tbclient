package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.br;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    View.OnClickListener a = new d(this);
    private Activity b;
    private ArrayList<ab> c;
    private com.baidu.tbadk.editortool.ab d;

    public c(Activity activity, h hVar, boolean z) {
        this.b = activity;
        this.c = hVar.d();
        this.d = new com.baidu.tbadk.editortool.ab(activity);
        int a = com.baidu.adp.lib.util.k.a((Context) activity, 45.0f);
        this.d.a(a, a);
    }

    public ArrayList<ab> a() {
        return this.c;
    }

    public void a(ArrayList<ab> arrayList) {
        this.c = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        return (this.c.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = a(viewGroup, itemViewType);
            br.b(view);
        }
        br.a(view);
        if (itemViewType != 3) {
            int skinType = TbadkApplication.m252getInst().getSkinType();
            View findViewById = view.findViewById(com.baidu.tieba.v.container);
            br.a(findViewById, 1, skinType);
            if (itemViewType == 2) {
                if (getCount() > 1) {
                    findViewById.setVisibility(0);
                }
            } else if (itemViewType == 1) {
                a(viewGroup, (g) view.getTag(), i);
            }
        }
        return view;
    }

    private View a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i == 3) {
            return from.inflate(com.baidu.tieba.w.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return from.inflate(com.baidu.tieba.w.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = from.inflate(com.baidu.tieba.w.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.a);
        g gVar = new g();
        gVar.a = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.portrait);
        gVar.b = (TextView) inflate.findViewById(com.baidu.tieba.v.name);
        gVar.c = (BestStringsFitTextView) inflate.findViewById(com.baidu.tieba.v.description);
        inflate.setTag(gVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, g gVar, int i) {
        int i2 = 0;
        ab abVar = this.c.get(i / 2);
        gVar.d = abVar;
        gVar.b.setText(abVar.b);
        if (abVar.e != null) {
            gVar.c.setVisibility(0);
            String[] strArr = new String[abVar.e.size()];
            while (true) {
                int i3 = i2;
                if (i3 >= abVar.e.size()) {
                    break;
                }
                strArr[i3] = abVar.e.get(i3).b;
                i2 = i3 + 1;
            }
            gVar.c.setTextArray(strArr);
        } else {
            gVar.c.setVisibility(8);
        }
        if (abVar.d != null) {
            gVar.a.setImageBitmap(null);
            gVar.a.setTag(abVar.d);
            this.d.b(abVar.d, new e(this, viewGroup));
        }
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
        if (i == getCount() - 1) {
            return 2;
        }
        if (i < 0) {
            i *= -1;
        }
        return i % 2 == 1 ? 3 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity b() {
        return this.b;
    }
}
