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
import com.baidu.tieba.view.p;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context eyw;
    private ArrayList<com.baidu.tieba.personCenter.b.a> eyx = new ArrayList<>();
    private p eyy;

    public a(Context context) {
        this.eyw = context;
    }

    public void setData(ArrayList<com.baidu.tieba.personCenter.b.a> arrayList) {
        this.eyx.clear();
        this.eyx.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eyx.size() == 0 || this.eyx.size() <= i) {
            return null;
        }
        return this.eyx.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eyx.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.eyw).inflate(w.j.person_center_function_grid_item, (ViewGroup) null);
            bVar = new b();
            bVar.amo = (LinearLayout) view.findViewById(w.h.func_icon_and_new);
            bVar.eyD = (TextView) view.findViewById(w.h.function_desc);
            bVar.eyC = (TbImageView) view.findViewById(w.h.function_icon);
            bVar.eyB = (TextView) view.findViewById(w.h.message_new);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.tieba.personCenter.b.a aVar = this.eyx.get(i);
        if (aVar != null) {
            bVar.eyC.setImageDrawable(aq.getDrawable(aVar.iconId));
            bVar.eyD.setText(aVar.title);
            if (aVar.bIv != null) {
                if (aVar.bIv.getBoolean("person_center_item_red_tip_show", false)) {
                    bVar.eyB.setVisibility(0);
                } else {
                    bVar.eyB.setVisibility(8);
                }
            }
            View$OnClickListenerC0074a view$OnClickListenerC0074a = new View$OnClickListenerC0074a();
            view$OnClickListenerC0074a.a(aVar);
            bVar.amo.setOnClickListener(view$OnClickListenerC0074a);
        }
        aq.i(bVar.eyD, w.e.cp_cont_c);
        aq.j(bVar.eyB, w.g.icon_news_down_bar_one);
        aq.j(bVar.amo, w.g.item_person_center_function_selector);
        return view;
    }

    public void setOnViewResponseListener(p pVar) {
        this.eyy = pVar;
    }

    /* renamed from: com.baidu.tieba.personCenter.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnClickListenerC0074a implements View.OnClickListener {
        private com.baidu.tieba.personCenter.b.a eyz;

        View$OnClickListenerC0074a() {
        }

        public void a(com.baidu.tieba.personCenter.b.a aVar) {
            this.eyz = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eyy != null) {
                a.this.eyy.a(view, this.eyz.eyE);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        LinearLayout amo;
        TextView eyB;
        TbImageView eyC;
        TextView eyD;

        public b() {
        }
    }
}
