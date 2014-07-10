package com.baidu.tieba.square;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class x extends BaseAdapter {
    private Context b;
    private ArrayList<aa> c = null;
    View.OnClickListener a = new y(this);

    public x(Context context) {
        this.b = null;
        this.b = context;
    }

    public void a(aa aaVar) {
        if (aaVar != null) {
            this.c = a(aaVar.d());
        }
    }

    private ArrayList<aa> a(ArrayList<aa> arrayList) {
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
        z zVar = (z) view.getTag();
        int skinType = TbadkApplication.m252getInst().getSkinType();
        int count = getCount();
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.b;
        baseFragmentActivity.c().a(skinType == 1);
        baseFragmentActivity.c().a(view);
        if (count > 2) {
            if (i == 0) {
                if (skinType == 1) {
                    zVar.c.setBackgroundResource(com.baidu.tieba.u.bg_hot_up_1);
                } else {
                    zVar.c.setBackgroundResource(com.baidu.tieba.u.bg_hot_up);
                }
            } else if (i == count - 2) {
                if (skinType == 1) {
                    zVar.c.setBackgroundResource(com.baidu.tieba.u.bg_hot_down_1);
                } else {
                    zVar.c.setBackgroundResource(com.baidu.tieba.u.bg_hot_down);
                }
            }
        } else if (count == 2 && i == 0) {
            if (skinType == 1) {
                zVar.c.setBackgroundResource(com.baidu.tieba.u.bg_hot_1);
            } else {
                zVar.c.setBackgroundResource(com.baidu.tieba.u.bg_hot);
            }
        }
        if (i >= 0 && this.c != null) {
            if (i * 2 < this.c.size()) {
                aa aaVar = this.c.get(i * 2);
                zVar.a.setText(aaVar.a());
                aaVar.a(String.valueOf(String.valueOf(i)) + "_first");
                zVar.a.setTag(aaVar);
            }
            if ((i * 2) + 1 < this.c.size()) {
                aa aaVar2 = this.c.get((i * 2) + 1);
                zVar.b.setText(aaVar2.a());
                aaVar2.a(String.valueOf(String.valueOf(i)) + "_second");
                zVar.b.setTag(aaVar2);
            }
        }
        return view;
    }

    private View a(int i, int i2) {
        if (i2 == 0) {
            View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.forum_list_recommend_item, (ViewGroup) null);
            z zVar = new z(this, null);
            zVar.c = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.container);
            zVar.a = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_list_title_1);
            zVar.b = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_list_title_2);
            zVar.a.setClickable(true);
            zVar.b.setClickable(true);
            zVar.a.setOnClickListener(this.a);
            zVar.b.setOnClickListener(this.a);
            inflate.setTag(zVar);
            return inflate;
        } else if (i2 == 1) {
            com.baidu.tieba.view.k kVar = new com.baidu.tieba.view.k(this.b);
            kVar.setHeightPx(this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.square_forum_list_paddingBottom));
            return kVar;
        } else {
            return null;
        }
    }
}
