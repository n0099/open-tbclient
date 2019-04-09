package com.baidu.tieba.interestlabel.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    private LabelSettingView gCZ;
    private List<com.baidu.tieba.interestlabel.b.a> gDb;
    private List<Integer> gDc = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.gCZ = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.T(bVar.byS())) {
            this.mLabelDataSet = bVar;
            this.gDb = bVar.byS();
            if (!v.T(bVar.byT())) {
                this.gDc = new ArrayList(bVar.byT());
            }
        }
    }

    public List<Integer> byP() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.byT();
    }

    public List<Integer> byQ() {
        return this.gDc;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.S(this.gDb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uE */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) v.c(this.gDb, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        com.baidu.tieba.interestlabel.b.a item = getItem(i);
        if (item == null) {
            return 0L;
        }
        return item.labelId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0328b c0328b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.gCZ.getContext()).inflate(d.h.item_label_layout, (ViewGroup) null);
            C0328b c0328b2 = new C0328b();
            c0328b2.gDe = (TextView) view2;
            view2.setTag(c0328b2);
            c0328b = c0328b2;
        } else {
            c0328b = (C0328b) view.getTag();
            view2 = view;
        }
        c0328b.gDe.setOnClickListener(new a(i));
        a(c0328b.gDe, getItem(i));
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, com.baidu.tieba.interestlabel.b.a aVar) {
        Drawable drawable;
        if (aVar != null) {
            String str = aVar.labelName;
            if (!StringUtils.isNull(aVar.labelName) && aVar.labelName.length() > 4) {
                str = aVar.labelName.substring(0, 3) + "...";
            }
            textView.setText(str);
            if (aVar.isFollow) {
                al.j(textView, d.C0277d.cp_link_tip_a);
                drawable = al.getDrawable(d.f.icon_lable_confirm_s);
            } else {
                al.j(textView, d.C0277d.cp_cont_b);
                drawable = al.getDrawable(d.f.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0328b {
        TextView gDe;

        C0328b() {
        }
    }

    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        private int index;

        public a(int i) {
            this.index = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.interestlabel.b.a item = b.this.getItem(this.index);
            if (item != null) {
                item.isFollow = !item.isFollow;
                if (view instanceof TextView) {
                    b.this.a((TextView) view, item);
                }
                if (item.isFollow) {
                    b.this.gDc.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.gDc.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.gCZ != null) {
                    b.this.gCZ.lS(v.S(b.this.gDc) > 0);
                }
            }
        }
    }
}
