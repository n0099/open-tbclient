package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private Activity b;
    private ArrayList<z> c;
    private com.baidu.tieba.util.i d;
    private float e = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f2401a = new f(this);

    public c(Activity activity, h hVar, boolean z) {
        this.b = activity;
        this.c = hVar.d();
        this.d = new com.baidu.tieba.util.i(activity);
        int a2 = UtilHelper.a((Context) activity, 45.0f);
        this.d.a(a2, a2);
    }

    public ArrayList<z> a() {
        return this.c;
    }

    public void a(ArrayList<z> arrayList) {
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
            com.baidu.tieba.util.bl.b(view);
        }
        com.baidu.tieba.util.bl.a(view);
        if (itemViewType != 3) {
            int ap = TiebaApplication.g().ap();
            View findViewById = view.findViewById(R.id.container);
            com.baidu.tieba.util.bl.a(findViewById, 1, ap);
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
            return from.inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return from.inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = from.inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.f2401a);
        g gVar = new g();
        gVar.f2405a = (HeadImageView) inflate.findViewById(R.id.portrait);
        gVar.b = (TextView) inflate.findViewById(R.id.name);
        gVar.c = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(gVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, g gVar, int i) {
        int i2 = 0;
        z zVar = this.c.get(i / 2);
        gVar.d = zVar;
        gVar.b.setText(zVar.b);
        if (zVar.e != null) {
            gVar.c.setVisibility(0);
            String[] strArr = new String[zVar.e.size()];
            while (true) {
                int i3 = i2;
                if (i3 >= zVar.e.size()) {
                    break;
                }
                strArr[i3] = zVar.e.get(i3).b;
                i2 = i3 + 1;
            }
            gVar.c.setTextArray(strArr);
        } else {
            gVar.c.setVisibility(8);
        }
        if (zVar.d != null) {
            gVar.f2405a.setImageBitmap(null);
            gVar.f2405a.setTag(zVar.d);
            com.baidu.adp.widget.ImageView.e d = this.d.d(zVar.d);
            if (d != null) {
                gVar.f2405a.setImageBitmap(d.f());
                gVar.f2405a.invalidate();
                return;
            }
            this.d.a(zVar.d, new d(this, viewGroup));
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
        return i % 2 == 1 ? 3 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity b() {
        return this.b;
    }
}
