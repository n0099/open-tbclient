package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bx;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    View.OnClickListener a = new d(this);
    private Activity b;
    private ArrayList<w> c;

    public c(Activity activity, f fVar, boolean z) {
        this.b = activity;
        this.c = fVar.d();
    }

    public ArrayList<w> a() {
        return this.c;
    }

    public void a(ArrayList<w> arrayList) {
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
            bx.b(view);
        }
        bx.a(view);
        if (itemViewType != 3) {
            int skinType = TbadkApplication.m252getInst().getSkinType();
            View findViewById = view.findViewById(com.baidu.tieba.v.container);
            bx.a(findViewById, 1, skinType);
            if (itemViewType == 2) {
                if (getCount() > 1) {
                    findViewById.setVisibility(0);
                }
            } else if (itemViewType == 1) {
                a(viewGroup, (e) view.getTag(), i);
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
        e eVar = new e();
        eVar.a = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.portrait);
        eVar.b = (TextView) inflate.findViewById(com.baidu.tieba.v.name);
        eVar.c = (BestStringsFitTextView) inflate.findViewById(com.baidu.tieba.v.description);
        inflate.setTag(eVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, e eVar, int i) {
        w wVar = this.c.get(i / 2);
        eVar.d = wVar;
        eVar.b.setText(wVar.b);
        if (wVar.e != null) {
            eVar.c.setVisibility(0);
            String[] strArr = new String[wVar.e.size()];
            for (int i2 = 0; i2 < wVar.e.size(); i2++) {
                strArr[i2] = wVar.e.get(i2).b;
            }
            eVar.c.setTextArray(strArr);
        } else {
            eVar.c.setVisibility(8);
        }
        if (wVar.d != null) {
            int a = com.baidu.adp.lib.util.j.a((Context) this.b, 45.0f);
            eVar.a.setImageBitmap(null);
            eVar.a.setTag(wVar.d);
            eVar.a.a(wVar.d, 10, a, a, false);
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
