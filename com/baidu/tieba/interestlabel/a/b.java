package com.baidu.tieba.interestlabel.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private LabelSettingView esc;
    private List<com.baidu.tieba.interestlabel.b.a> ese;
    private List<Integer> esf = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.esc = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.w(bVar.aJN())) {
            this.mLabelDataSet = bVar;
            this.ese = bVar.aJN();
            if (!v.w(bVar.aJO())) {
                this.esf = new ArrayList(bVar.aJO());
            }
        }
    }

    public List<Integer> aJK() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.aJO();
    }

    public List<Integer> aJL() {
        return this.esf;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.v(this.ese);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: on */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) v.c(this.ese, i);
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0170b c0170b;
        View view3;
        if (view2 == null) {
            view3 = LayoutInflater.from(this.esc.getContext()).inflate(d.i.item_label_layout, (ViewGroup) null);
            C0170b c0170b2 = new C0170b();
            c0170b2.esh = (TextView) view3;
            view3.setTag(c0170b2);
            c0170b = c0170b2;
        } else {
            c0170b = (C0170b) view2.getTag();
            view3 = view2;
        }
        c0170b.esh.setOnClickListener(new a(i));
        a(c0170b.esh, getItem(i));
        return view3;
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
                ak.h(textView, d.C0126d.cp_link_tip_a);
                drawable = ak.getDrawable(d.f.icon_lable_confirm_s);
            } else {
                ak.h(textView, d.C0126d.cp_cont_b);
                drawable = ak.getDrawable(d.f.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0170b {
        TextView esh;

        C0170b() {
        }
    }

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        private int index;

        public a(int i) {
            this.index = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            com.baidu.tieba.interestlabel.b.a item = b.this.getItem(this.index);
            if (item != null) {
                item.isFollow = !item.isFollow;
                if (view2 instanceof TextView) {
                    b.this.a((TextView) view2, item);
                }
                if (item.isFollow) {
                    b.this.esf.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.esf.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.esc != null) {
                    b.this.esc.hR(v.v(b.this.esf) > 0);
                }
            }
        }
    }
}
