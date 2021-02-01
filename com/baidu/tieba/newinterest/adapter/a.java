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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private int lDY;
    private final List<com.baidu.tieba.newinterest.data.b> lDZ;
    private b lEa;
    private final Context mContext;

    /* loaded from: classes8.dex */
    public interface b {
        void Fj(int i);
    }

    public a(List<com.baidu.tieba.newinterest.data.b> list, Context context) {
        this.lDZ = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lDZ == null) {
            return 0;
        }
        return this.lDZ.size();
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
        final C0818a c0818a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            C0818a c0818a2 = new C0818a(view);
            view.setTag(c0818a2);
            c0818a = c0818a2;
        } else {
            c0818a = (C0818a) view.getTag();
        }
        final com.baidu.tieba.newinterest.data.b bVar = this.lDZ.get(i);
        if (bVar.getIcon() > 0) {
            SvgManager.bsR().a(c0818a.lEe, bVar.getIcon(), (SvgManager.SvgResourceStateType) null);
        }
        c0818a.lEf.setText(bVar.getText());
        a(c0818a.lEg, bVar);
        if (bVar.isSelected()) {
            this.lDY++;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!bVar.isSelected() && a.this.lDY >= 10) {
                    l.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                bVar.setSelected(!bVar.isSelected());
                a.this.a(c0818a.lEg, bVar);
                a.this.a(bVar);
                if (a.this.lEa != null) {
                    a.this.lEa.Fj(a.this.lDY);
                }
                if (bVar.isSelected()) {
                    ar arVar = new ar("c13682");
                    arVar.ap("obj_type", 2);
                    arVar.ap("obj_locate", 1);
                    arVar.ap("obj_source", i);
                    TiebaStatic.log(arVar);
                }
            }
        });
        return view;
    }

    public List<com.baidu.tieba.newinterest.data.b> djm() {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.tieba.newinterest.data.b bVar : this.lDZ) {
            if (bVar.isSelected()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.tieba.newinterest.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0818a {
        public ImageView lEe;
        public TextView lEf;
        public ImageView lEg;

        public C0818a(View view) {
            this.lEe = (ImageView) view.findViewById(R.id.interest_icon);
            this.lEf = (TextView) view.findViewById(R.id.interest_text);
            this.lEg = (ImageView) view.findViewById(R.id.select_status_view);
            ap.setViewTextColor(this.lEf, R.color.CAM_X0105);
            ap.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            SvgManager.bsR().a(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.bsR().a(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            this.lDY++;
        } else {
            this.lDY--;
        }
    }

    public void a(b bVar) {
        this.lEa = bVar;
    }
}
