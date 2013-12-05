package com.baidu.tieba.square;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aa extends BaseAdapter {
    private Context b;
    private ArrayList<ad> c = null;

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f2471a = new ab(this);

    public aa(Context context) {
        this.b = null;
        this.b = context;
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.c = a(adVar.d());
        }
    }

    private ArrayList<ad> a(ArrayList<ad> arrayList) {
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
        ac acVar = (ac) view.getTag();
        int an = TiebaApplication.h().an();
        int count = getCount();
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.b;
        baseFragmentActivity.a().a(an == 1);
        baseFragmentActivity.a().a(view);
        if (count > 2) {
            if (i == 0) {
                if (an == 1) {
                    acVar.d.setBackgroundResource(R.drawable.bg_hot_up_1);
                } else {
                    acVar.d.setBackgroundResource(R.drawable.bg_hot_up);
                }
            } else if (i == count - 2) {
                if (an == 1) {
                    acVar.d.setBackgroundResource(R.drawable.bg_hot_down_1);
                } else {
                    acVar.d.setBackgroundResource(R.drawable.bg_hot_down);
                }
            }
        } else if (count == 2 && i == 0) {
            if (an == 1) {
                acVar.d.setBackgroundResource(R.drawable.bg_hot_1);
            } else {
                acVar.d.setBackgroundResource(R.drawable.bg_hot);
            }
        }
        if (i >= 0 && this.c != null) {
            if (i * 2 < this.c.size()) {
                ad adVar = this.c.get(i * 2);
                acVar.f2473a.setText(adVar.a());
                adVar.a(String.valueOf(i) + "_first");
                acVar.f2473a.setTag(adVar);
            }
            if ((i * 2) + 1 < this.c.size()) {
                ad adVar2 = this.c.get((i * 2) + 1);
                acVar.b.setText(adVar2.a());
                adVar2.a(String.valueOf(i) + "_second");
                acVar.b.setTag(adVar2);
            }
        }
        return view;
    }

    private View a(int i, int i2) {
        if (i2 == 0) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.forum_list_recommend_item, (ViewGroup) null);
            ac acVar = new ac(this, null);
            acVar.d = (LinearLayout) inflate.findViewById(R.id.container);
            acVar.f2473a = (TextView) inflate.findViewById(R.id.forum_list_title_1);
            acVar.b = (TextView) inflate.findViewById(R.id.forum_list_title_2);
            acVar.c = inflate.findViewById(R.id.forum_list_title_divider);
            acVar.f2473a.setClickable(true);
            acVar.b.setClickable(true);
            acVar.f2473a.setOnClickListener(this.f2471a);
            acVar.b.setOnClickListener(this.f2471a);
            inflate.setTag(acVar);
            return inflate;
        } else if (i2 == 1) {
            com.baidu.tieba.view.r rVar = new com.baidu.tieba.view.r(this.b);
            rVar.setHeightPx(this.b.getResources().getDimensionPixelSize(R.dimen.square_forum_list_paddingBottom));
            return rVar;
        } else {
            return null;
        }
    }
}
