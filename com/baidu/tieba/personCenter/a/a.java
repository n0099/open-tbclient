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
    private Context fgE;
    private ArrayList<com.baidu.tieba.personCenter.b.a> fgF = new ArrayList<>();
    private g fgG;

    public a(Context context) {
        this.fgE = context;
    }

    public void setData(ArrayList<com.baidu.tieba.personCenter.b.a> arrayList) {
        this.fgF.clear();
        this.fgF.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fgF.size() == 0 || this.fgF.size() <= i) {
            return null;
        }
        return this.fgF.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fgF.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.fgE).inflate(d.j.person_center_function_grid_item, (ViewGroup) null);
            bVar = new b();
            bVar.aMe = (LinearLayout) view.findViewById(d.h.func_icon_and_new);
            bVar.fgL = (TextView) view.findViewById(d.h.function_desc);
            bVar.fgK = (TbImageView) view.findViewById(d.h.function_icon);
            bVar.fgJ = (TextView) view.findViewById(d.h.message_new);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.tieba.personCenter.b.a aVar = this.fgF.get(i);
        if (aVar != null) {
            bVar.fgK.setImageDrawable(ai.getDrawable(aVar.iconId));
            bVar.fgL.setText(aVar.title);
            if (aVar.cbl != null) {
                if (aVar.cbl.getBoolean("person_center_item_red_tip_show", false)) {
                    bVar.fgJ.setVisibility(0);
                } else {
                    bVar.fgJ.setVisibility(8);
                }
            }
            View$OnClickListenerC0114a view$OnClickListenerC0114a = new View$OnClickListenerC0114a();
            view$OnClickListenerC0114a.a(aVar);
            bVar.aMe.setOnClickListener(view$OnClickListenerC0114a);
        }
        ai.i(bVar.fgL, d.e.cp_cont_c);
        ai.j(bVar.fgJ, d.g.icon_news_down_bar_one);
        ai.j(bVar.aMe, d.g.item_person_center_function_selector);
        return view;
    }

    public void setOnViewResponseListener(g gVar) {
        this.fgG = gVar;
    }

    /* renamed from: com.baidu.tieba.personCenter.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnClickListenerC0114a implements View.OnClickListener {
        private com.baidu.tieba.personCenter.b.a fgH;

        View$OnClickListenerC0114a() {
        }

        public void a(com.baidu.tieba.personCenter.b.a aVar) {
            this.fgH = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fgG != null) {
                a.this.fgG.a(view, this.fgH.fgM);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        LinearLayout aMe;
        TextView fgJ;
        TbImageView fgK;
        TextView fgL;

        public b() {
        }
    }
}
