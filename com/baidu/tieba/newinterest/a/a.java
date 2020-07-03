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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private int jTs;
    private final List<com.baidu.tieba.newinterest.data.b> jTt;
    private b jTu;
    private final Context mContext;

    /* loaded from: classes10.dex */
    public interface b {
        void AN(int i);
    }

    public a(List<com.baidu.tieba.newinterest.data.b> list, Context context) {
        this.jTt = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jTt == null) {
            return 0;
        }
        return this.jTt.size();
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
        final C0690a c0690a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            C0690a c0690a2 = new C0690a(view);
            view.setTag(c0690a2);
            c0690a = c0690a2;
        } else {
            c0690a = (C0690a) view.getTag();
        }
        final com.baidu.tieba.newinterest.data.b bVar = this.jTt.get(i);
        if (bVar.getIcon() > 0) {
            SvgManager.aWQ().a(c0690a.jTy, bVar.getIcon(), (SvgManager.SvgResourceStateType) null);
        }
        c0690a.jTz.setText(bVar.getText());
        a(c0690a.jTA, bVar);
        if (bVar.isSelected()) {
            this.jTs++;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!bVar.isSelected() && a.this.jTs >= 10) {
                    l.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                bVar.setSelected(!bVar.isSelected());
                a.this.a(c0690a.jTA, bVar);
                a.this.a(bVar);
                if (a.this.jTu != null) {
                    a.this.jTu.AN(a.this.jTs);
                }
                if (bVar.isSelected()) {
                    ao aoVar = new ao("c13682");
                    aoVar.ag("obj_type", 2);
                    aoVar.ag("obj_locate", 1);
                    aoVar.ag("obj_source", i);
                    TiebaStatic.log(aoVar);
                }
            }
        });
        return view;
    }

    public List<com.baidu.tieba.newinterest.data.b> cFk() {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.tieba.newinterest.data.b bVar : this.jTt) {
            if (bVar.isSelected()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.tieba.newinterest.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0690a {
        public ImageView jTA;
        public ImageView jTy;
        public TextView jTz;

        public C0690a(View view) {
            this.jTy = (ImageView) view.findViewById(R.id.interest_icon);
            this.jTz = (TextView) view.findViewById(R.id.interest_text);
            this.jTA = (ImageView) view.findViewById(R.id.select_status_view);
            an.setViewTextColor(this.jTz, (int) R.color.cp_cont_b);
            an.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            SvgManager.aWQ().a(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.aWQ().a(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            this.jTs++;
        } else {
            this.jTs--;
        }
    }

    public void a(b bVar) {
        this.jTu = bVar;
    }
}
