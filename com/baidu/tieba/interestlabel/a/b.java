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
import com.baidu.tieba.e;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private LabelSettingView fcB;
    private List<com.baidu.tieba.interestlabel.b.a> fcD;
    private List<Integer> fcE = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.fcB = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.I(bVar.aVk())) {
            this.mLabelDataSet = bVar;
            this.fcD = bVar.aVk();
            if (!v.I(bVar.aVl())) {
                this.fcE = new ArrayList(bVar.aVl());
            }
        }
    }

    public List<Integer> aVh() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.aVl();
    }

    public List<Integer> aVi() {
        return this.fcE;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.H(this.fcD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qp */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) v.d(this.fcD, i);
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
        C0249b c0249b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.fcB.getContext()).inflate(e.h.item_label_layout, (ViewGroup) null);
            C0249b c0249b2 = new C0249b();
            c0249b2.fcG = (TextView) view2;
            view2.setTag(c0249b2);
            c0249b = c0249b2;
        } else {
            c0249b = (C0249b) view.getTag();
            view2 = view;
        }
        c0249b.fcG.setOnClickListener(new a(i));
        a(c0249b.fcG, getItem(i));
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
                al.h(textView, e.d.cp_link_tip_a);
                drawable = al.getDrawable(e.f.icon_lable_confirm_s);
            } else {
                al.h(textView, e.d.cp_cont_b);
                drawable = al.getDrawable(e.f.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0249b {
        TextView fcG;

        C0249b() {
        }
    }

    /* loaded from: classes3.dex */
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
                    b.this.fcE.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.fcE.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.fcB != null) {
                    b.this.fcB.jl(v.H(b.this.fcE) > 0);
                }
            }
        }
    }
}
