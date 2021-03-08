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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private int lGo;
    private final List<com.baidu.tieba.newinterest.data.b> lGp;
    private b lGq;
    private final Context mContext;

    /* loaded from: classes7.dex */
    public interface b {
        void Fm(int i);
    }

    public a(List<com.baidu.tieba.newinterest.data.b> list, Context context) {
        this.lGp = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lGp == null) {
            return 0;
        }
        return this.lGp.size();
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
        final C0825a c0825a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            C0825a c0825a2 = new C0825a(view);
            view.setTag(c0825a2);
            c0825a = c0825a2;
        } else {
            c0825a = (C0825a) view.getTag();
        }
        final com.baidu.tieba.newinterest.data.b bVar = this.lGp.get(i);
        if (bVar.getIcon() > 0) {
            SvgManager.bsU().a(c0825a.lGu, bVar.getIcon(), (SvgManager.SvgResourceStateType) null);
        }
        c0825a.lGv.setText(bVar.getText());
        a(c0825a.lGw, bVar);
        if (bVar.isSelected()) {
            this.lGo++;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!bVar.isSelected() && a.this.lGo >= 10) {
                    l.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                bVar.setSelected(!bVar.isSelected());
                a.this.a(c0825a.lGw, bVar);
                a.this.a(bVar);
                if (a.this.lGq != null) {
                    a.this.lGq.Fm(a.this.lGo);
                }
                if (bVar.isSelected()) {
                    ar arVar = new ar("c13682");
                    arVar.aq("obj_type", 2);
                    arVar.aq("obj_locate", 1);
                    arVar.aq("obj_source", i);
                    TiebaStatic.log(arVar);
                }
            }
        });
        return view;
    }

    public List<com.baidu.tieba.newinterest.data.b> djC() {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.tieba.newinterest.data.b bVar : this.lGp) {
            if (bVar.isSelected()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.tieba.newinterest.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0825a {
        public ImageView lGu;
        public TextView lGv;
        public ImageView lGw;

        public C0825a(View view) {
            this.lGu = (ImageView) view.findViewById(R.id.interest_icon);
            this.lGv = (TextView) view.findViewById(R.id.interest_text);
            this.lGw = (ImageView) view.findViewById(R.id.select_status_view);
            ap.setViewTextColor(this.lGv, R.color.CAM_X0105);
            ap.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            SvgManager.bsU().a(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.bsU().a(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            this.lGo++;
        } else {
            this.lGo--;
        }
    }

    public void a(b bVar) {
        this.lGq = bVar;
    }
}
