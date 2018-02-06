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
    private d eXs;
    private List<com.baidu.tieba.interestlabel.b.a> eXu;
    private List<Integer> eXv = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(d dVar) {
        this.eXs = dVar;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.E(bVar.aOL())) {
            this.mLabelDataSet = bVar;
            this.eXu = bVar.aOL();
            if (!v.E(bVar.aOM())) {
                this.eXv = new ArrayList(bVar.aOM());
            }
        }
    }

    public List<Integer> aOI() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.aOM();
    }

    public List<Integer> aOJ() {
        return this.eXv;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.D(this.eXu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qR */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) v.f(this.eXu, i);
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
        C0186b c0186b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.eXs.getContext()).inflate(d.h.item_label_layout, (ViewGroup) null);
            C0186b c0186b2 = new C0186b();
            c0186b2.eXx = (TextView) view2;
            view2.setTag(c0186b2);
            c0186b = c0186b2;
        } else {
            c0186b = (C0186b) view.getTag();
            view2 = view;
        }
        c0186b.eXx.setOnClickListener(new a(i));
        a(c0186b.eXx, getItem(i));
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
                aj.r(textView, d.C0140d.cp_link_tip_a);
                drawable = aj.getDrawable(d.f.icon_lable_confirm_s);
            } else {
                aj.r(textView, d.C0140d.cp_cont_b);
                drawable = aj.getDrawable(d.f.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0186b {
        TextView eXx;

        C0186b() {
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
                    b.this.eXv.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.eXv.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.eXs != null) {
                    b.this.eXs.io(v.D(b.this.eXv) > 0);
                }
            }
        }
    }
}
