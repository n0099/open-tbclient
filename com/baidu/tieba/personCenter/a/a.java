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
    private Context feJ;
    private ArrayList<com.baidu.tieba.personCenter.b.a> feK = new ArrayList<>();
    private g feL;

    public a(Context context) {
        this.feJ = context;
    }

    public void setData(ArrayList<com.baidu.tieba.personCenter.b.a> arrayList) {
        this.feK.clear();
        this.feK.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.feK.size() == 0 || this.feK.size() <= i) {
            return null;
        }
        return this.feK.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.feK.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.feJ).inflate(d.j.person_center_function_grid_item, (ViewGroup) null);
            bVar = new b();
            bVar.aMc = (LinearLayout) view.findViewById(d.h.func_icon_and_new);
            bVar.feQ = (TextView) view.findViewById(d.h.function_desc);
            bVar.feP = (TbImageView) view.findViewById(d.h.function_icon);
            bVar.feO = (TextView) view.findViewById(d.h.message_new);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.tieba.personCenter.b.a aVar = this.feK.get(i);
        if (aVar != null) {
            bVar.feP.setImageDrawable(ai.getDrawable(aVar.iconId));
            bVar.feQ.setText(aVar.title);
            if (aVar.cay != null) {
                if (aVar.cay.getBoolean("person_center_item_red_tip_show", false)) {
                    bVar.feO.setVisibility(0);
                } else {
                    bVar.feO.setVisibility(8);
                }
            }
            View$OnClickListenerC0113a view$OnClickListenerC0113a = new View$OnClickListenerC0113a();
            view$OnClickListenerC0113a.a(aVar);
            bVar.aMc.setOnClickListener(view$OnClickListenerC0113a);
        }
        ai.i(bVar.feQ, d.e.cp_cont_c);
        ai.j(bVar.feO, d.g.icon_news_down_bar_one);
        ai.j(bVar.aMc, d.g.item_person_center_function_selector);
        return view;
    }

    public void setOnViewResponseListener(g gVar) {
        this.feL = gVar;
    }

    /* renamed from: com.baidu.tieba.personCenter.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnClickListenerC0113a implements View.OnClickListener {
        private com.baidu.tieba.personCenter.b.a feM;

        View$OnClickListenerC0113a() {
        }

        public void a(com.baidu.tieba.personCenter.b.a aVar) {
            this.feM = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.feL != null) {
                a.this.feL.a(view, this.feM.feR);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        LinearLayout aMc;
        TextView feO;
        TbImageView feP;
        TextView feQ;

        public b() {
        }
    }
}
