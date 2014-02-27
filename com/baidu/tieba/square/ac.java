package com.baidu.tieba.square;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class ac extends BaseAdapter {
    private Context b;
    private ArrayList<af> c = null;
    View.OnClickListener a = new ad(this);

    public ac(Context context) {
        this.b = null;
        this.b = context;
    }

    public final void a(af afVar) {
        ArrayList<af> arrayList = null;
        if (afVar != null) {
            ArrayList<af> d = afVar.d();
            if (d != null) {
                int size = (d.size() / 2) * 2;
                int i = size <= 4 ? size : 4;
                if (i > 0) {
                    arrayList = new ArrayList<>(d.subList(0, i));
                }
            }
            this.c = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.c == null) {
            return 0;
        }
        return Math.round(this.c.size() / 2) + 1;
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
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        return i == getCount() + (-1) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = null;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            if (itemViewType == 0) {
                view2 = LayoutInflater.from(this.b).inflate(R.layout.forum_list_recommend_item, (ViewGroup) null);
                ae aeVar = new ae(this, (byte) 0);
                aeVar.d = (LinearLayout) view2.findViewById(R.id.container);
                aeVar.a = (TextView) view2.findViewById(R.id.forum_list_title_1);
                aeVar.b = (TextView) view2.findViewById(R.id.forum_list_title_2);
                aeVar.c = view2.findViewById(R.id.forum_list_title_divider);
                aeVar.a.setClickable(true);
                aeVar.b.setClickable(true);
                aeVar.a.setOnClickListener(this.a);
                aeVar.b.setOnClickListener(this.a);
                view2.setTag(aeVar);
            } else if (itemViewType == 1) {
                view2 = new com.baidu.tieba.view.ad(this.b);
                ((com.baidu.tieba.view.ad) view2).setHeightPx(this.b.getResources().getDimensionPixelSize(R.dimen.square_forum_list_paddingBottom));
            }
            view = view2;
        }
        ae aeVar2 = (ae) view.getTag();
        int ae = TiebaApplication.g().ae();
        int count = getCount();
        com.baidu.tieba.k kVar = (com.baidu.tieba.k) this.b;
        kVar.a().a(ae == 1);
        kVar.a().a(view);
        if (count > 2) {
            if (i == 0) {
                if (ae == 1) {
                    aeVar2.d.setBackgroundResource(R.drawable.bg_hot_up_1);
                } else {
                    aeVar2.d.setBackgroundResource(R.drawable.bg_hot_up);
                }
            } else if (i == count - 2) {
                if (ae == 1) {
                    aeVar2.d.setBackgroundResource(R.drawable.bg_hot_down_1);
                } else {
                    aeVar2.d.setBackgroundResource(R.drawable.bg_hot_down);
                }
            }
        } else if (count == 2 && i == 0) {
            if (ae == 1) {
                aeVar2.d.setBackgroundResource(R.drawable.bg_hot_1);
            } else {
                aeVar2.d.setBackgroundResource(R.drawable.bg_hot);
            }
        }
        if (i >= 0 && this.c != null) {
            if (i * 2 < this.c.size()) {
                af afVar = this.c.get(i * 2);
                aeVar2.a.setText(afVar.a());
                afVar.a(String.valueOf(String.valueOf(i)) + "_first");
                aeVar2.a.setTag(afVar);
            }
            if ((i * 2) + 1 < this.c.size()) {
                af afVar2 = this.c.get((i * 2) + 1);
                aeVar2.b.setText(afVar2.a());
                afVar2.a(String.valueOf(String.valueOf(i)) + "_second");
                aeVar2.b.setTag(afVar2);
            }
        }
        return view;
    }
}
