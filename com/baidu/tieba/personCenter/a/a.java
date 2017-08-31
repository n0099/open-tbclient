package com.baidu.tieba.personCenter.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.g;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context feU;
    private ArrayList<com.baidu.tieba.personCenter.b.a> feV = new ArrayList<>();
    private g feW;

    public a(Context context) {
        this.feU = context;
    }

    public void setData(ArrayList<com.baidu.tieba.personCenter.b.a> arrayList) {
        this.feV.clear();
        this.feV.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.feV.size() == 0 || this.feV.size() <= i) {
            return null;
        }
        return this.feV.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.feV.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.feU).inflate(d.j.person_center_function_grid_item, (ViewGroup) null);
            bVar = new b();
            bVar.aLK = (LinearLayout) view.findViewById(d.h.func_icon_and_new);
            bVar.ffb = (TextView) view.findViewById(d.h.function_desc);
            bVar.ffa = (TbImageView) view.findViewById(d.h.function_icon);
            bVar.feZ = (TextView) view.findViewById(d.h.message_new);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.tieba.personCenter.b.a aVar = this.feV.get(i);
        if (aVar != null) {
            bVar.ffa.setImageDrawable(aj.getDrawable(aVar.iconId));
            bVar.ffb.setText(aVar.title);
            if (aVar.cec != null) {
                if (aVar.cec.getBoolean("person_center_item_red_tip_show", false)) {
                    bVar.feZ.setVisibility(0);
                } else {
                    bVar.feZ.setVisibility(8);
                }
            }
            View$OnClickListenerC0116a view$OnClickListenerC0116a = new View$OnClickListenerC0116a();
            view$OnClickListenerC0116a.a(aVar);
            bVar.aLK.setOnClickListener(view$OnClickListenerC0116a);
        }
        aj.i(bVar.ffb, d.e.cp_cont_c);
        aj.j(bVar.feZ, d.g.icon_news_down_bar_one);
        aj.j(bVar.aLK, d.g.item_person_center_function_selector);
        return view;
    }

    public void setOnViewResponseListener(g gVar) {
        this.feW = gVar;
    }

    /* renamed from: com.baidu.tieba.personCenter.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnClickListenerC0116a implements View.OnClickListener {
        private com.baidu.tieba.personCenter.b.a feX;

        View$OnClickListenerC0116a() {
        }

        public void a(com.baidu.tieba.personCenter.b.a aVar) {
            this.feX = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.feW != null) {
                a.this.feW.a(view, this.feX.ffc);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        LinearLayout aLK;
        TextView feZ;
        TbImageView ffa;
        TextView ffb;

        public b() {
        }
    }
}
