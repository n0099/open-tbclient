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
    private Context fdx;
    private ArrayList<com.baidu.tieba.personCenter.b.a> fdy = new ArrayList<>();
    private g fdz;

    public a(Context context) {
        this.fdx = context;
    }

    public void setData(ArrayList<com.baidu.tieba.personCenter.b.a> arrayList) {
        this.fdy.clear();
        this.fdy.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fdy.size() == 0 || this.fdy.size() <= i) {
            return null;
        }
        return this.fdy.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fdy.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.fdx).inflate(d.j.person_center_function_grid_item, (ViewGroup) null);
            bVar = new b();
            bVar.aKN = (LinearLayout) view.findViewById(d.h.func_icon_and_new);
            bVar.fdE = (TextView) view.findViewById(d.h.function_desc);
            bVar.fdD = (TbImageView) view.findViewById(d.h.function_icon);
            bVar.fdC = (TextView) view.findViewById(d.h.message_new);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.tieba.personCenter.b.a aVar = this.fdy.get(i);
        if (aVar != null) {
            bVar.fdD.setImageDrawable(ai.getDrawable(aVar.iconId));
            bVar.fdE.setText(aVar.title);
            if (aVar.bZs != null) {
                if (aVar.bZs.getBoolean("person_center_item_red_tip_show", false)) {
                    bVar.fdC.setVisibility(0);
                } else {
                    bVar.fdC.setVisibility(8);
                }
            }
            View$OnClickListenerC0114a view$OnClickListenerC0114a = new View$OnClickListenerC0114a();
            view$OnClickListenerC0114a.a(aVar);
            bVar.aKN.setOnClickListener(view$OnClickListenerC0114a);
        }
        ai.i(bVar.fdE, d.e.cp_cont_c);
        ai.j(bVar.fdC, d.g.icon_news_down_bar_one);
        ai.j(bVar.aKN, d.g.item_person_center_function_selector);
        return view;
    }

    public void setOnViewResponseListener(g gVar) {
        this.fdz = gVar;
    }

    /* renamed from: com.baidu.tieba.personCenter.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnClickListenerC0114a implements View.OnClickListener {
        private com.baidu.tieba.personCenter.b.a fdA;

        View$OnClickListenerC0114a() {
        }

        public void a(com.baidu.tieba.personCenter.b.a aVar) {
            this.fdA = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fdz != null) {
                a.this.fdz.a(view, this.fdA.fdF);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        LinearLayout aKN;
        TextView fdC;
        TbImageView fdD;
        TextView fdE;

        public b() {
        }
    }
}
