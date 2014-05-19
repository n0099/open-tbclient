package com.baidu.tieba.square;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ac extends BaseAdapter {
    private Context b;
    private ArrayList<af> c = null;
    View.OnClickListener a = new ad(this);

    public ac(Context context) {
        this.b = null;
        this.b = context;
    }

    public void a(af afVar) {
        if (afVar != null) {
            this.c = a(afVar.d());
        }
    }

    private ArrayList<af> a(ArrayList<af> arrayList) {
        if (arrayList != null) {
            int size = (arrayList.size() / 2) * 2;
            int i = size <= 4 ? size : 4;
            if (i > 0) {
                return new ArrayList<>(arrayList.subList(0, i));
            }
            return null;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        return Math.round(this.c.size() / 2) + 1;
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
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == getCount() + (-1) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = a(i, itemViewType);
        }
        ae aeVar = (ae) view.getTag();
        int skinType = TbadkApplication.m252getInst().getSkinType();
        int count = getCount();
        com.baidu.tbadk.core.e eVar = (com.baidu.tbadk.core.e) this.b;
        eVar.a().a(skinType == 1);
        eVar.a().a(view);
        if (count > 2) {
            if (i == 0) {
                if (skinType == 1) {
                    aeVar.c.setBackgroundResource(com.baidu.tieba.q.bg_hot_up_1);
                } else {
                    aeVar.c.setBackgroundResource(com.baidu.tieba.q.bg_hot_up);
                }
            } else if (i == count - 2) {
                if (skinType == 1) {
                    aeVar.c.setBackgroundResource(com.baidu.tieba.q.bg_hot_down_1);
                } else {
                    aeVar.c.setBackgroundResource(com.baidu.tieba.q.bg_hot_down);
                }
            }
        } else if (count == 2 && i == 0) {
            if (skinType == 1) {
                aeVar.c.setBackgroundResource(com.baidu.tieba.q.bg_hot_1);
            } else {
                aeVar.c.setBackgroundResource(com.baidu.tieba.q.bg_hot);
            }
        }
        if (i >= 0 && this.c != null) {
            if (i * 2 < this.c.size()) {
                af afVar = this.c.get(i * 2);
                aeVar.a.setText(afVar.a());
                afVar.a(String.valueOf(String.valueOf(i)) + "_first");
                aeVar.a.setTag(afVar);
            }
            if ((i * 2) + 1 < this.c.size()) {
                af afVar2 = this.c.get((i * 2) + 1);
                aeVar.b.setText(afVar2.a());
                afVar2.a(String.valueOf(String.valueOf(i)) + "_second");
                aeVar.b.setTag(afVar2);
            }
        }
        return view;
    }

    private View a(int i, int i2) {
        if (i2 == 0) {
            View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.s.forum_list_recommend_item, (ViewGroup) null);
            ae aeVar = new ae(this, null);
            aeVar.c = (LinearLayout) inflate.findViewById(com.baidu.tieba.r.container);
            aeVar.a = (TextView) inflate.findViewById(com.baidu.tieba.r.forum_list_title_1);
            aeVar.b = (TextView) inflate.findViewById(com.baidu.tieba.r.forum_list_title_2);
            aeVar.a.setClickable(true);
            aeVar.b.setClickable(true);
            aeVar.a.setOnClickListener(this.a);
            aeVar.b.setOnClickListener(this.a);
            inflate.setTag(aeVar);
            return inflate;
        } else if (i2 == 1) {
            com.baidu.tieba.view.j jVar = new com.baidu.tieba.view.j(this.b);
            jVar.setHeightPx(this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.square_forum_list_paddingBottom));
            return jVar;
        } else {
            return null;
        }
    }
}
