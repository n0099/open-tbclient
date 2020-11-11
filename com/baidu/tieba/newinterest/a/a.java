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
    private int lhA;
    private final List<com.baidu.tieba.newinterest.data.b> lhB;
    private b lhC;
    private final Context mContext;

    /* loaded from: classes23.dex */
    public interface b {
        void Fs(int i);
    }

    public a(List<com.baidu.tieba.newinterest.data.b> list, Context context) {
        this.lhB = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lhB == null) {
            return 0;
        }
        return this.lhB.size();
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
        final C0798a c0798a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            C0798a c0798a2 = new C0798a(view);
            view.setTag(c0798a2);
            c0798a = c0798a2;
        } else {
            c0798a = (C0798a) view.getTag();
        }
        final com.baidu.tieba.newinterest.data.b bVar = this.lhB.get(i);
        if (bVar.getIcon() > 0) {
            SvgManager.brn().a(c0798a.lhG, bVar.getIcon(), (SvgManager.SvgResourceStateType) null);
        }
        c0798a.lhH.setText(bVar.getText());
        a(c0798a.lhI, bVar);
        if (bVar.isSelected()) {
            this.lhA++;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!bVar.isSelected() && a.this.lhA >= 10) {
                    l.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                bVar.setSelected(!bVar.isSelected());
                a.this.a(c0798a.lhI, bVar);
                a.this.a(bVar);
                if (a.this.lhC != null) {
                    a.this.lhC.Fs(a.this.lhA);
                }
                if (bVar.isSelected()) {
                    aq aqVar = new aq("c13682");
                    aqVar.al("obj_type", 2);
                    aqVar.al("obj_locate", 1);
                    aqVar.al("obj_source", i);
                    TiebaStatic.log(aqVar);
                }
            }
        });
        return view;
    }

    public List<com.baidu.tieba.newinterest.data.b> dgI() {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.tieba.newinterest.data.b bVar : this.lhB) {
            if (bVar.isSelected()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.tieba.newinterest.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C0798a {
        public ImageView lhG;
        public TextView lhH;
        public ImageView lhI;

        public C0798a(View view) {
            this.lhG = (ImageView) view.findViewById(R.id.interest_icon);
            this.lhH = (TextView) view.findViewById(R.id.interest_text);
            this.lhI = (ImageView) view.findViewById(R.id.select_status_view);
            ap.setViewTextColor(this.lhH, R.color.cp_cont_b);
            ap.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            SvgManager.brn().a(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.brn().a(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            this.lhA++;
        } else {
            this.lhA--;
        }
    }

    public void a(b bVar) {
        this.lhC = bVar;
    }
}
