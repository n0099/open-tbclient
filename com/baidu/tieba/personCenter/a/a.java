package com.baidu.tieba.personCenter.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.r;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context eQY;
    private ArrayList<com.baidu.tieba.personCenter.b.a> eQZ = new ArrayList<>();
    private r eRa;

    public a(Context context) {
        this.eQY = context;
    }

    public void setData(ArrayList<com.baidu.tieba.personCenter.b.a> arrayList) {
        this.eQZ.clear();
        this.eQZ.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eQZ.size() == 0 || this.eQZ.size() <= i) {
            return null;
        }
        return this.eQZ.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eQZ.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.eQY).inflate(w.j.person_center_function_grid_item, (ViewGroup) null);
            bVar = new b();
            bVar.aJF = (LinearLayout) view.findViewById(w.h.func_icon_and_new);
            bVar.eRf = (TextView) view.findViewById(w.h.function_desc);
            bVar.eRe = (TbImageView) view.findViewById(w.h.function_icon);
            bVar.eRd = (TextView) view.findViewById(w.h.message_new);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.tieba.personCenter.b.a aVar = this.eQZ.get(i);
        if (aVar != null) {
            bVar.eRe.setImageDrawable(as.getDrawable(aVar.iconId));
            bVar.eRf.setText(aVar.title);
            if (aVar.bVe != null) {
                if (aVar.bVe.getBoolean("person_center_item_red_tip_show", false)) {
                    bVar.eRd.setVisibility(0);
                } else {
                    bVar.eRd.setVisibility(8);
                }
            }
            View$OnClickListenerC0078a view$OnClickListenerC0078a = new View$OnClickListenerC0078a();
            view$OnClickListenerC0078a.a(aVar);
            bVar.aJF.setOnClickListener(view$OnClickListenerC0078a);
        }
        as.i(bVar.eRf, w.e.cp_cont_c);
        as.j(bVar.eRd, w.g.icon_news_down_bar_one);
        as.j(bVar.aJF, w.g.item_person_center_function_selector);
        return view;
    }

    public void setOnViewResponseListener(r rVar) {
        this.eRa = rVar;
    }

    /* renamed from: com.baidu.tieba.personCenter.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnClickListenerC0078a implements View.OnClickListener {
        private com.baidu.tieba.personCenter.b.a eRb;

        View$OnClickListenerC0078a() {
        }

        public void a(com.baidu.tieba.personCenter.b.a aVar) {
            this.eRb = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eRa != null) {
                a.this.eRa.a(view, this.eRb.eRg);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        LinearLayout aJF;
        TextView eRd;
        TbImageView eRe;
        TextView eRf;

        public b() {
        }
    }
}
