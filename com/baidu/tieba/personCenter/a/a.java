package com.baidu.tieba.personCenter.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.g;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context fgC;
    private ArrayList<com.baidu.tieba.personCenter.b.a> fgD = new ArrayList<>();
    private g fgE;

    public a(Context context) {
        this.fgC = context;
    }

    public void setData(ArrayList<com.baidu.tieba.personCenter.b.a> arrayList) {
        this.fgD.clear();
        this.fgD.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fgD.size() == 0 || this.fgD.size() <= i) {
            return null;
        }
        return this.fgD.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fgD.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.fgC).inflate(d.j.person_center_function_grid_item, (ViewGroup) null);
            bVar = new b();
            bVar.aMd = (LinearLayout) view.findViewById(d.h.func_icon_and_new);
            bVar.fgJ = (TextView) view.findViewById(d.h.function_desc);
            bVar.fgI = (TbImageView) view.findViewById(d.h.function_icon);
            bVar.fgH = (TextView) view.findViewById(d.h.message_new);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.tieba.personCenter.b.a aVar = this.fgD.get(i);
        if (aVar != null) {
            bVar.fgI.setImageDrawable(ai.getDrawable(aVar.iconId));
            bVar.fgJ.setText(aVar.title);
            if (aVar.cbk != null) {
                if (aVar.cbk.getBoolean("person_center_item_red_tip_show", false)) {
                    bVar.fgH.setVisibility(0);
                } else {
                    bVar.fgH.setVisibility(8);
                }
            }
            View$OnClickListenerC0114a view$OnClickListenerC0114a = new View$OnClickListenerC0114a();
            view$OnClickListenerC0114a.a(aVar);
            bVar.aMd.setOnClickListener(view$OnClickListenerC0114a);
        }
        ai.i(bVar.fgJ, d.e.cp_cont_c);
        ai.j(bVar.fgH, d.g.icon_news_down_bar_one);
        ai.j(bVar.aMd, d.g.item_person_center_function_selector);
        return view;
    }

    public void setOnViewResponseListener(g gVar) {
        this.fgE = gVar;
    }

    /* renamed from: com.baidu.tieba.personCenter.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnClickListenerC0114a implements View.OnClickListener {
        private com.baidu.tieba.personCenter.b.a fgF;

        View$OnClickListenerC0114a() {
        }

        public void a(com.baidu.tieba.personCenter.b.a aVar) {
            this.fgF = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fgE != null) {
                a.this.fgE.a(view, this.fgF.fgK);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        LinearLayout aMd;
        TextView fgH;
        TbImageView fgI;
        TextView fgJ;

        public b() {
        }
    }
}
