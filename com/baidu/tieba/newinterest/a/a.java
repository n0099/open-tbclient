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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private int kbT;
    private final List<com.baidu.tieba.newinterest.data.b> kbU;
    private b kbV;
    private final Context mContext;

    /* loaded from: classes17.dex */
    public interface b {
        void Bm(int i);
    }

    public a(List<com.baidu.tieba.newinterest.data.b> list, Context context) {
        this.kbU = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kbU == null) {
            return 0;
        }
        return this.kbU.size();
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
        final C0702a c0702a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            C0702a c0702a2 = new C0702a(view);
            view.setTag(c0702a2);
            c0702a = c0702a2;
        } else {
            c0702a = (C0702a) view.getTag();
        }
        final com.baidu.tieba.newinterest.data.b bVar = this.kbU.get(i);
        if (bVar.getIcon() > 0) {
            SvgManager.baR().a(c0702a.kbZ, bVar.getIcon(), (SvgManager.SvgResourceStateType) null);
        }
        c0702a.kca.setText(bVar.getText());
        a(c0702a.kcb, bVar);
        if (bVar.isSelected()) {
            this.kbT++;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!bVar.isSelected() && a.this.kbT >= 10) {
                    l.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                bVar.setSelected(!bVar.isSelected());
                a.this.a(c0702a.kcb, bVar);
                a.this.a(bVar);
                if (a.this.kbV != null) {
                    a.this.kbV.Bm(a.this.kbT);
                }
                if (bVar.isSelected()) {
                    ap apVar = new ap("c13682");
                    apVar.ah("obj_type", 2);
                    apVar.ah("obj_locate", 1);
                    apVar.ah("obj_source", i);
                    TiebaStatic.log(apVar);
                }
            }
        });
        return view;
    }

    public List<com.baidu.tieba.newinterest.data.b> cIU() {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.tieba.newinterest.data.b bVar : this.kbU) {
            if (bVar.isSelected()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.tieba.newinterest.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0702a {
        public ImageView kbZ;
        public TextView kca;
        public ImageView kcb;

        public C0702a(View view) {
            this.kbZ = (ImageView) view.findViewById(R.id.interest_icon);
            this.kca = (TextView) view.findViewById(R.id.interest_text);
            this.kcb = (ImageView) view.findViewById(R.id.select_status_view);
            ao.setViewTextColor(this.kca, R.color.cp_cont_b);
            ao.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            SvgManager.baR().a(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.baR().a(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            this.kbT++;
        } else {
            this.kbT--;
        }
    }

    public void a(b bVar) {
        this.kbV = bVar;
    }
}
