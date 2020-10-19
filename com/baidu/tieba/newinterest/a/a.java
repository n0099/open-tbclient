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
    private int kPf;
    private final List<com.baidu.tieba.newinterest.data.b> kPg;
    private b kPh;
    private final Context mContext;

    /* loaded from: classes23.dex */
    public interface b {
        void EM(int i);
    }

    public a(List<com.baidu.tieba.newinterest.data.b> list, Context context) {
        this.kPg = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kPg == null) {
            return 0;
        }
        return this.kPg.size();
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
        final C0768a c0768a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            C0768a c0768a2 = new C0768a(view);
            view.setTag(c0768a2);
            c0768a = c0768a2;
        } else {
            c0768a = (C0768a) view.getTag();
        }
        final com.baidu.tieba.newinterest.data.b bVar = this.kPg.get(i);
        if (bVar.getIcon() > 0) {
            SvgManager.bmU().a(c0768a.kPl, bVar.getIcon(), (SvgManager.SvgResourceStateType) null);
        }
        c0768a.kPm.setText(bVar.getText());
        a(c0768a.kPn, bVar);
        if (bVar.isSelected()) {
            this.kPf++;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!bVar.isSelected() && a.this.kPf >= 10) {
                    l.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                bVar.setSelected(!bVar.isSelected());
                a.this.a(c0768a.kPn, bVar);
                a.this.a(bVar);
                if (a.this.kPh != null) {
                    a.this.kPh.EM(a.this.kPf);
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

    public List<com.baidu.tieba.newinterest.data.b> daY() {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.tieba.newinterest.data.b bVar : this.kPg) {
            if (bVar.isSelected()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.tieba.newinterest.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C0768a {
        public ImageView kPl;
        public TextView kPm;
        public ImageView kPn;

        public C0768a(View view) {
            this.kPl = (ImageView) view.findViewById(R.id.interest_icon);
            this.kPm = (TextView) view.findViewById(R.id.interest_text);
            this.kPn = (ImageView) view.findViewById(R.id.select_status_view);
            ap.setViewTextColor(this.kPm, R.color.cp_cont_b);
            ap.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            SvgManager.bmU().a(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.bmU().a(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            this.kPf++;
        } else {
            this.kPf--;
        }
    }

    public void a(b bVar) {
        this.kPh = bVar;
    }
}
