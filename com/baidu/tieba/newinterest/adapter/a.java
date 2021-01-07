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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private int lAA;
    private final List<com.baidu.tieba.newinterest.data.b> lAB;
    private b lAC;
    private final Context mContext;

    /* loaded from: classes8.dex */
    public interface b {
        void Gx(int i);
    }

    public a(List<com.baidu.tieba.newinterest.data.b> list, Context context) {
        this.lAB = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lAB == null) {
            return 0;
        }
        return this.lAB.size();
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
        final C0834a c0834a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            C0834a c0834a2 = new C0834a(view);
            view.setTag(c0834a2);
            c0834a = c0834a2;
        } else {
            c0834a = (C0834a) view.getTag();
        }
        final com.baidu.tieba.newinterest.data.b bVar = this.lAB.get(i);
        if (bVar.getIcon() > 0) {
            SvgManager.bwr().a(c0834a.lAG, bVar.getIcon(), (SvgManager.SvgResourceStateType) null);
        }
        c0834a.lAH.setText(bVar.getText());
        a(c0834a.lAI, bVar);
        if (bVar.isSelected()) {
            this.lAA++;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!bVar.isSelected() && a.this.lAA >= 10) {
                    l.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                bVar.setSelected(!bVar.isSelected());
                a.this.a(c0834a.lAI, bVar);
                a.this.a(bVar);
                if (a.this.lAC != null) {
                    a.this.lAC.Gx(a.this.lAA);
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

    public List<com.baidu.tieba.newinterest.data.b> dld() {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.tieba.newinterest.data.b bVar : this.lAB) {
            if (bVar.isSelected()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.tieba.newinterest.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0834a {
        public ImageView lAG;
        public TextView lAH;
        public ImageView lAI;

        public C0834a(View view) {
            this.lAG = (ImageView) view.findViewById(R.id.interest_icon);
            this.lAH = (TextView) view.findViewById(R.id.interest_text);
            this.lAI = (ImageView) view.findViewById(R.id.select_status_view);
            ao.setViewTextColor(this.lAH, R.color.CAM_X0105);
            ao.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            SvgManager.bwr().a(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.bwr().a(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            this.lAA++;
        } else {
            this.lAA--;
        }
    }

    public void a(b bVar) {
        this.lAC = bVar;
    }
}
