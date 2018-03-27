package com.baidu.tieba.interestlabel.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.view.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private d eXu;
    private List<com.baidu.tieba.interestlabel.b.a> eXw;
    private List<Integer> eXx = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(d dVar) {
        this.eXu = dVar;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.E(bVar.aOL())) {
            this.mLabelDataSet = bVar;
            this.eXw = bVar.aOL();
            if (!v.E(bVar.aOM())) {
                this.eXx = new ArrayList(bVar.aOM());
            }
        }
    }

    public List<Integer> aOI() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.aOM();
    }

    public List<Integer> aOJ() {
        return this.eXx;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.D(this.eXw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qS */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) v.f(this.eXw, i);
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
        C0187b c0187b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.eXu.getContext()).inflate(d.h.item_label_layout, (ViewGroup) null);
            C0187b c0187b2 = new C0187b();
            c0187b2.eXz = (TextView) view2;
            view2.setTag(c0187b2);
            c0187b = c0187b2;
        } else {
            c0187b = (C0187b) view.getTag();
            view2 = view;
        }
        c0187b.eXz.setOnClickListener(new a(i));
        a(c0187b.eXz, getItem(i));
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
                aj.r(textView, d.C0141d.cp_link_tip_a);
                drawable = aj.getDrawable(d.f.icon_lable_confirm_s);
            } else {
                aj.r(textView, d.C0141d.cp_cont_b);
                drawable = aj.getDrawable(d.f.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0187b {
        TextView eXz;

        C0187b() {
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
                    b.this.eXx.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.eXx.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.eXu != null) {
                    b.this.eXu.it(v.D(b.this.eXx) > 0);
                }
            }
        }
    }
}
