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
    private Context ffN;
    private ArrayList<com.baidu.tieba.personCenter.b.a> ffO = new ArrayList<>();
    private g ffP;

    public a(Context context) {
        this.ffN = context;
    }

    public void setData(ArrayList<com.baidu.tieba.personCenter.b.a> arrayList) {
        this.ffO.clear();
        this.ffO.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ffO.size() == 0 || this.ffO.size() <= i) {
            return null;
        }
        return this.ffO.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ffO.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.ffN).inflate(d.j.person_center_function_grid_item, (ViewGroup) null);
            bVar = new b();
            bVar.aLH = (LinearLayout) view.findViewById(d.h.func_icon_and_new);
            bVar.ffU = (TextView) view.findViewById(d.h.function_desc);
            bVar.ffT = (TbImageView) view.findViewById(d.h.function_icon);
            bVar.ffS = (TextView) view.findViewById(d.h.message_new);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.tieba.personCenter.b.a aVar = this.ffO.get(i);
        if (aVar != null) {
            bVar.ffT.setImageDrawable(aj.getDrawable(aVar.iconId));
            bVar.ffU.setText(aVar.title);
            if (aVar.ceU != null) {
                if (aVar.ceU.getBoolean("person_center_item_red_tip_show", false)) {
                    bVar.ffS.setVisibility(0);
                } else {
                    bVar.ffS.setVisibility(8);
                }
            }
            View$OnClickListenerC0115a view$OnClickListenerC0115a = new View$OnClickListenerC0115a();
            view$OnClickListenerC0115a.a(aVar);
            bVar.aLH.setOnClickListener(view$OnClickListenerC0115a);
        }
        aj.i(bVar.ffU, d.e.cp_cont_c);
        aj.j(bVar.ffS, d.g.icon_news_down_bar_one);
        aj.j(bVar.aLH, d.g.item_person_center_function_selector);
        return view;
    }

    public void setOnViewResponseListener(g gVar) {
        this.ffP = gVar;
    }

    /* renamed from: com.baidu.tieba.personCenter.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnClickListenerC0115a implements View.OnClickListener {
        private com.baidu.tieba.personCenter.b.a ffQ;

        View$OnClickListenerC0115a() {
        }

        public void a(com.baidu.tieba.personCenter.b.a aVar) {
            this.ffQ = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ffP != null) {
                a.this.ffP.a(view, this.ffQ.ffV);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        LinearLayout aLH;
        TextView ffS;
        TbImageView ffT;
        TextView ffU;

        public b() {
        }
    }
}
