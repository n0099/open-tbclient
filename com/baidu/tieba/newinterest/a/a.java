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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private int lbD;
    private final List<com.baidu.tieba.newinterest.data.b> lbE;
    private b lbF;
    private final Context mContext;

    /* loaded from: classes23.dex */
    public interface b {
        void Ff(int i);
    }

    public a(List<com.baidu.tieba.newinterest.data.b> list, Context context) {
        this.lbE = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lbE == null) {
            return 0;
        }
        return this.lbE.size();
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
        final C0783a c0783a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            C0783a c0783a2 = new C0783a(view);
            view.setTag(c0783a2);
            c0783a = c0783a2;
        } else {
            c0783a = (C0783a) view.getTag();
        }
        final com.baidu.tieba.newinterest.data.b bVar = this.lbE.get(i);
        if (bVar.getIcon() > 0) {
            SvgManager.boN().a(c0783a.lbJ, bVar.getIcon(), (SvgManager.SvgResourceStateType) null);
        }
        c0783a.lbK.setText(bVar.getText());
        a(c0783a.lbL, bVar);
        if (bVar.isSelected()) {
            this.lbD++;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!bVar.isSelected() && a.this.lbD >= 10) {
                    l.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                bVar.setSelected(!bVar.isSelected());
                a.this.a(c0783a.lbL, bVar);
                a.this.a(bVar);
                if (a.this.lbF != null) {
                    a.this.lbF.Ff(a.this.lbD);
                }
                if (bVar.isSelected()) {
                    aq aqVar = new aq("c13682");
                    aqVar.aj("obj_type", 2);
                    aqVar.aj("obj_locate", 1);
                    aqVar.aj("obj_source", i);
                    TiebaStatic.log(aqVar);
                }
            }
        });
        return view;
    }

    public List<com.baidu.tieba.newinterest.data.b> deg() {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.tieba.newinterest.data.b bVar : this.lbE) {
            if (bVar.isSelected()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.tieba.newinterest.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C0783a {
        public ImageView lbJ;
        public TextView lbK;
        public ImageView lbL;

        public C0783a(View view) {
            this.lbJ = (ImageView) view.findViewById(R.id.interest_icon);
            this.lbK = (TextView) view.findViewById(R.id.interest_text);
            this.lbL = (ImageView) view.findViewById(R.id.select_status_view);
            ap.setViewTextColor(this.lbK, R.color.cp_cont_b);
            ap.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            SvgManager.boN().a(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.boN().a(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            this.lbD++;
        } else {
            this.lbD--;
        }
    }

    public void a(b bVar) {
        this.lbF = bVar;
    }
}
