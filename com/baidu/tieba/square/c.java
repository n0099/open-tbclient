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
import com.baidu.tieba.util.av;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f1738a = new d(this);
    private Activity b;
    private ArrayList c;
    private com.baidu.tieba.util.a d;

    public c(Activity activity, g gVar, boolean z) {
        this.b = activity;
        this.c = gVar.d();
        this.d = new com.baidu.tieba.util.a(activity);
        int a2 = UtilHelper.a((Context) activity, 45.0f);
        this.d.a(a2, a2);
    }

    public ArrayList a() {
        return this.c;
    }

    public void a(ArrayList arrayList) {
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
            av.b(view);
        }
        av.a(view);
        if (itemViewType != 3) {
            int an = TiebaApplication.g().an();
            View findViewById = view.findViewById(R.id.container);
            av.a(findViewById, 1, an);
            if (itemViewType == 2) {
                if (getCount() > 1) {
                    findViewById.setVisibility(0);
                }
            } else if (itemViewType == 1) {
                a(viewGroup, (l) view.getTag(), i);
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
        inflate.setOnClickListener(this.f1738a);
        l lVar = new l();
        lVar.f1747a = (HeadImageView) inflate.findViewById(R.id.portrait);
        lVar.b = (TextView) inflate.findViewById(R.id.name);
        lVar.c = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(lVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, l lVar, int i) {
        s sVar = (s) this.c.get(i / 2);
        lVar.d = sVar;
        lVar.b.setText(sVar.b);
        if (sVar.e != null) {
            String[] strArr = new String[sVar.e.size()];
            for (int i2 = 0; i2 < sVar.e.size(); i2++) {
                strArr[i2] = ((s) sVar.e.get(i2)).b;
            }
            lVar.c.setTextArray(strArr);
            lVar.c.setVisibility(0);
        } else {
            lVar.c.setVisibility(8);
        }
        if (sVar.d != null) {
            lVar.f1747a.setTag(sVar.d);
            com.baidu.adp.widget.a.b d = this.d.d(sVar.d);
            if (d != null) {
                lVar.f1747a.setImageBitmap(d.f());
                lVar.f1747a.invalidate();
                return;
            }
            this.d.a(sVar.d, new e(this, viewGroup));
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
