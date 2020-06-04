package com.baidu.tieba.newinterest.a;

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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private final List<com.baidu.tieba.newinterest.data.b> jAa;
    private b jAb;
    private int jzZ;
    private final Context mContext;

    /* loaded from: classes10.dex */
    public interface b {
        void zL(int i);
    }

    public a(List<com.baidu.tieba.newinterest.data.b> list, Context context) {
        this.jAa = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jAa == null) {
            return 0;
        }
        return this.jAa.size();
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
        final C0675a c0675a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            C0675a c0675a2 = new C0675a(view);
            view.setTag(c0675a2);
            c0675a = c0675a2;
        } else {
            c0675a = (C0675a) view.getTag();
        }
        final com.baidu.tieba.newinterest.data.b bVar = this.jAa.get(i);
        if (bVar.getIcon() > 0) {
            SvgManager.aUW().a(c0675a.jAf, bVar.getIcon(), (SvgManager.SvgResourceStateType) null);
        }
        c0675a.jAg.setText(bVar.getText());
        a(c0675a.jAh, bVar);
        if (bVar.isSelected()) {
            this.jzZ++;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!bVar.isSelected() && a.this.jzZ >= 10) {
                    l.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                bVar.setSelected(!bVar.isSelected());
                a.this.a(c0675a.jAh, bVar);
                a.this.a(bVar);
                if (a.this.jAb != null) {
                    a.this.jAb.zL(a.this.jzZ);
                }
                if (bVar.isSelected()) {
                    an anVar = new an("c13682");
                    anVar.ag("obj_type", 2);
                    anVar.ag("obj_locate", 1);
                    anVar.ag("obj_source", i);
                    TiebaStatic.log(anVar);
                }
            }
        });
        return view;
    }

    public List<com.baidu.tieba.newinterest.data.b> cAU() {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.tieba.newinterest.data.b bVar : this.jAa) {
            if (bVar.isSelected()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.tieba.newinterest.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0675a {
        public ImageView jAf;
        public TextView jAg;
        public ImageView jAh;

        public C0675a(View view) {
            this.jAf = (ImageView) view.findViewById(R.id.interest_icon);
            this.jAg = (TextView) view.findViewById(R.id.interest_text);
            this.jAh = (ImageView) view.findViewById(R.id.select_status_view);
            am.setViewTextColor(this.jAg, (int) R.color.cp_cont_b);
            am.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            SvgManager.aUW().a(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.aUW().a(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            this.jzZ++;
        } else {
            this.jzZ--;
        }
    }

    public void a(b bVar) {
        this.jAb = bVar;
    }
}
