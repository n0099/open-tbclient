package com.baidu.tieba.personCenter.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.r;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private r bxW;
    private Context eHl;
    private ArrayList<com.baidu.tieba.personCenter.b.a> eHm = new ArrayList<>();

    public a(Context context) {
        this.eHl = context;
    }

    public void setData(ArrayList<com.baidu.tieba.personCenter.b.a> arrayList) {
        this.eHm.clear();
        this.eHm.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eHm.size() == 0 || this.eHm.size() <= i) {
            return null;
        }
        return this.eHm.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eHm.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.eHl).inflate(w.j.person_center_function_grid_item, (ViewGroup) null);
            bVar = new b();
            bVar.ame = (LinearLayout) view.findViewById(w.h.func_icon_and_new);
            bVar.eHr = (TextView) view.findViewById(w.h.function_desc);
            bVar.eHq = (TbImageView) view.findViewById(w.h.function_icon);
            bVar.eHp = (TextView) view.findViewById(w.h.message_new);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.tieba.personCenter.b.a aVar = this.eHm.get(i);
        if (aVar != null) {
            bVar.eHq.setImageDrawable(aq.getDrawable(aVar.iconId));
            bVar.eHr.setText(aVar.title);
            if (aVar.bOj != null) {
                if (aVar.bOj.getBoolean("person_center_item_red_tip_show", false)) {
                    bVar.eHp.setVisibility(0);
                } else {
                    bVar.eHp.setVisibility(8);
                }
            }
            View$OnClickListenerC0075a view$OnClickListenerC0075a = new View$OnClickListenerC0075a();
            view$OnClickListenerC0075a.a(aVar);
            bVar.ame.setOnClickListener(view$OnClickListenerC0075a);
        }
        aq.i(bVar.eHr, w.e.cp_cont_c);
        aq.j(bVar.eHp, w.g.icon_news_down_bar_one);
        aq.j(bVar.ame, w.g.item_person_center_function_selector);
        return view;
    }

    public void setOnViewResponseListener(r rVar) {
        this.bxW = rVar;
    }

    /* renamed from: com.baidu.tieba.personCenter.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnClickListenerC0075a implements View.OnClickListener {
        private com.baidu.tieba.personCenter.b.a eHn;

        View$OnClickListenerC0075a() {
        }

        public void a(com.baidu.tieba.personCenter.b.a aVar) {
            this.eHn = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bxW != null) {
                a.this.bxW.a(view, this.eHn.eHs);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        LinearLayout ame;
        TextView eHp;
        TbImageView eHq;
        TextView eHr;

        public b() {
        }
    }
}
