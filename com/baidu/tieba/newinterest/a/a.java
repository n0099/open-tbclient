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
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private int kro;
    private final List<com.baidu.tieba.newinterest.data.b> krp;
    private b krq;
    private final Context mContext;

    /* loaded from: classes17.dex */
    public interface b {
        void DF(int i);
    }

    public a(List<com.baidu.tieba.newinterest.data.b> list, Context context) {
        this.krp = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.krp == null) {
            return 0;
        }
        return this.krp.size();
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
        final C0753a c0753a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            C0753a c0753a2 = new C0753a(view);
            view.setTag(c0753a2);
            c0753a = c0753a2;
        } else {
            c0753a = (C0753a) view.getTag();
        }
        final com.baidu.tieba.newinterest.data.b bVar = this.krp.get(i);
        if (bVar.getIcon() > 0) {
            SvgManager.bjq().a(c0753a.kru, bVar.getIcon(), (SvgManager.SvgResourceStateType) null);
        }
        c0753a.krv.setText(bVar.getText());
        a(c0753a.krw, bVar);
        if (bVar.isSelected()) {
            this.kro++;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!bVar.isSelected() && a.this.kro >= 10) {
                    l.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                bVar.setSelected(!bVar.isSelected());
                a.this.a(c0753a.krw, bVar);
                a.this.a(bVar);
                if (a.this.krq != null) {
                    a.this.krq.DF(a.this.kro);
                }
                if (bVar.isSelected()) {
                    aq aqVar = new aq("c13682");
                    aqVar.ai("obj_type", 2);
                    aqVar.ai("obj_locate", 1);
                    aqVar.ai("obj_source", i);
                    TiebaStatic.log(aqVar);
                }
            }
        });
        return view;
    }

    public List<com.baidu.tieba.newinterest.data.b> cTJ() {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.tieba.newinterest.data.b bVar : this.krp) {
            if (bVar.isSelected()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.tieba.newinterest.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0753a {
        public ImageView kru;
        public TextView krv;
        public ImageView krw;

        public C0753a(View view) {
            this.kru = (ImageView) view.findViewById(R.id.interest_icon);
            this.krv = (TextView) view.findViewById(R.id.interest_text);
            this.krw = (ImageView) view.findViewById(R.id.select_status_view);
            ap.setViewTextColor(this.krv, R.color.cp_cont_b);
            ap.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            SvgManager.bjq().a(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.bjq().a(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            this.kro++;
        } else {
            this.kro--;
        }
    }

    public void a(b bVar) {
        this.krq = bVar;
    }
}
