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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private int lhR;
    private final List<com.baidu.tieba.newinterest.data.b> lhS;
    private b lhT;
    private final Context mContext;

    /* loaded from: classes22.dex */
    public interface b {
        void FQ(int i);
    }

    public a(List<com.baidu.tieba.newinterest.data.b> list, Context context) {
        this.lhS = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lhS == null) {
            return 0;
        }
        return this.lhS.size();
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
        final C0800a c0800a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            C0800a c0800a2 = new C0800a(view);
            view.setTag(c0800a2);
            c0800a = c0800a2;
        } else {
            c0800a = (C0800a) view.getTag();
        }
        final com.baidu.tieba.newinterest.data.b bVar = this.lhS.get(i);
        if (bVar.getIcon() > 0) {
            SvgManager.bqB().a(c0800a.lhX, bVar.getIcon(), (SvgManager.SvgResourceStateType) null);
        }
        c0800a.lhY.setText(bVar.getText());
        a(c0800a.lhZ, bVar);
        if (bVar.isSelected()) {
            this.lhR++;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!bVar.isSelected() && a.this.lhR >= 10) {
                    l.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                bVar.setSelected(!bVar.isSelected());
                a.this.a(c0800a.lhZ, bVar);
                a.this.a(bVar);
                if (a.this.lhT != null) {
                    a.this.lhT.FQ(a.this.lhR);
                }
                if (bVar.isSelected()) {
                    ar arVar = new ar("c13682");
                    arVar.ak("obj_type", 2);
                    arVar.ak("obj_locate", 1);
                    arVar.ak("obj_source", i);
                    TiebaStatic.log(arVar);
                }
            }
        });
        return view;
    }

    public List<com.baidu.tieba.newinterest.data.b> dgf() {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.tieba.newinterest.data.b bVar : this.lhS) {
            if (bVar.isSelected()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.tieba.newinterest.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0800a {
        public ImageView lhX;
        public TextView lhY;
        public ImageView lhZ;

        public C0800a(View view) {
            this.lhX = (ImageView) view.findViewById(R.id.interest_icon);
            this.lhY = (TextView) view.findViewById(R.id.interest_text);
            this.lhZ = (ImageView) view.findViewById(R.id.select_status_view);
            ap.setViewTextColor(this.lhY, R.color.CAM_X0105);
            ap.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            SvgManager.bqB().a(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.bqB().a(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            this.lhR++;
        } else {
            this.lhR--;
        }
    }

    public void a(b bVar) {
        this.lhT = bVar;
    }
}
