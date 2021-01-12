package com.baidu.tieba.newinterest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private int lvU;
    private final List<com.baidu.tieba.newinterest.data.b> lvV;
    private b lvW;
    private final Context mContext;

    /* loaded from: classes7.dex */
    public interface b {
        void ER(int i);
    }

    public a(List<com.baidu.tieba.newinterest.data.b> list, Context context) {
        this.lvV = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lvV == null) {
            return 0;
        }
        return this.lvV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final C0817a c0817a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            C0817a c0817a2 = new C0817a(view);
            view.setTag(c0817a2);
            c0817a = c0817a2;
        } else {
            c0817a = (C0817a) view.getTag();
        }
        final com.baidu.tieba.newinterest.data.b bVar = this.lvV.get(i);
        if (bVar.getIcon() > 0) {
            SvgManager.bsx().a(c0817a.lwa, bVar.getIcon(), (SvgManager.SvgResourceStateType) null);
        }
        c0817a.lwb.setText(bVar.getText());
        a(c0817a.lwc, bVar);
        if (bVar.isSelected()) {
            this.lvU++;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!bVar.isSelected() && a.this.lvU >= 10) {
                    l.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                bVar.setSelected(!bVar.isSelected());
                a.this.a(c0817a.lwc, bVar);
                a.this.a(bVar);
                if (a.this.lvW != null) {
                    a.this.lvW.ER(a.this.lvU);
                }
                if (bVar.isSelected()) {
                    aq aqVar = new aq("c13682");
                    aqVar.an("obj_type", 2);
                    aqVar.an("obj_locate", 1);
                    aqVar.an("obj_source", i);
                    TiebaStatic.log(aqVar);
                }
            }
        });
        return view;
    }

    public List<com.baidu.tieba.newinterest.data.b> dhl() {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.tieba.newinterest.data.b bVar : this.lvV) {
            if (bVar.isSelected()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.tieba.newinterest.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0817a {
        public ImageView lwa;
        public TextView lwb;
        public ImageView lwc;

        public C0817a(View view) {
            this.lwa = (ImageView) view.findViewById(R.id.interest_icon);
            this.lwb = (TextView) view.findViewById(R.id.interest_text);
            this.lwc = (ImageView) view.findViewById(R.id.select_status_view);
            ao.setViewTextColor(this.lwb, R.color.CAM_X0105);
            ao.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            SvgManager.bsx().a(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.bsx().a(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            this.lvU++;
        } else {
            this.lvU--;
        }
    }

    public void a(b bVar) {
        this.lvW = bVar;
    }
}
