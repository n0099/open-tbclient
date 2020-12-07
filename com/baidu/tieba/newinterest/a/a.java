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
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private int lvq;
    private final List<com.baidu.tieba.newinterest.data.b> lvr;
    private b lvs;
    private final Context mContext;

    /* loaded from: classes23.dex */
    public interface b {
        void GF(int i);
    }

    public a(List<com.baidu.tieba.newinterest.data.b> list, Context context) {
        this.lvr = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lvr == null) {
            return 0;
        }
        return this.lvr.size();
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
        final C0816a c0816a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            C0816a c0816a2 = new C0816a(view);
            view.setTag(c0816a2);
            c0816a = c0816a2;
        } else {
            c0816a = (C0816a) view.getTag();
        }
        final com.baidu.tieba.newinterest.data.b bVar = this.lvr.get(i);
        if (bVar.getIcon() > 0) {
            SvgManager.btW().a(c0816a.lvw, bVar.getIcon(), (SvgManager.SvgResourceStateType) null);
        }
        c0816a.lvx.setText(bVar.getText());
        a(c0816a.lvy, bVar);
        if (bVar.isSelected()) {
            this.lvq++;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!bVar.isSelected() && a.this.lvq >= 10) {
                    l.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                bVar.setSelected(!bVar.isSelected());
                a.this.a(c0816a.lvy, bVar);
                a.this.a(bVar);
                if (a.this.lvs != null) {
                    a.this.lvs.GF(a.this.lvq);
                }
                if (bVar.isSelected()) {
                    ar arVar = new ar("c13682");
                    arVar.al("obj_type", 2);
                    arVar.al("obj_locate", 1);
                    arVar.al("obj_source", i);
                    TiebaStatic.log(arVar);
                }
            }
        });
        return view;
    }

    public List<com.baidu.tieba.newinterest.data.b> dlr() {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.tieba.newinterest.data.b bVar : this.lvr) {
            if (bVar.isSelected()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: com.baidu.tieba.newinterest.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C0816a {
        public ImageView lvw;
        public TextView lvx;
        public ImageView lvy;

        public C0816a(View view) {
            this.lvw = (ImageView) view.findViewById(R.id.interest_icon);
            this.lvx = (TextView) view.findViewById(R.id.interest_text);
            this.lvy = (ImageView) view.findViewById(R.id.select_status_view);
            ap.setViewTextColor(this.lvx, R.color.CAM_X0105);
            ap.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            SvgManager.btW().a(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.btW().a(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newinterest.data.b bVar) {
        if (bVar.isSelected()) {
            this.lvq++;
        } else {
            this.lvq--;
        }
    }

    public void a(b bVar) {
        this.lvs = bVar;
    }
}
