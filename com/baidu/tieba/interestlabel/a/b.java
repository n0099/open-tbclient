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
    private LabelSettingView fmk;
    private List<com.baidu.tieba.interestlabel.b.a> fmm;
    private List<Integer> fmn = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.fmk = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.I(bVar.aXP())) {
            this.mLabelDataSet = bVar;
            this.fmm = bVar.aXP();
            if (!v.I(bVar.aXQ())) {
                this.fmn = new ArrayList(bVar.aXQ());
            }
        }
    }

    public List<Integer> aXM() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.aXQ();
    }

    public List<Integer> aXN() {
        return this.fmn;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.H(this.fmm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qW */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) v.d(this.fmm, i);
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
        C0260b c0260b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.fmk.getContext()).inflate(e.h.item_label_layout, (ViewGroup) null);
            C0260b c0260b2 = new C0260b();
            c0260b2.fmp = (TextView) view2;
            view2.setTag(c0260b2);
            c0260b = c0260b2;
        } else {
            c0260b = (C0260b) view.getTag();
            view2 = view;
        }
        c0260b.fmp.setOnClickListener(new a(i));
        a(c0260b.fmp, getItem(i));
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
    class C0260b {
        TextView fmp;

        C0260b() {
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
                    b.this.fmn.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.fmn.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.fmk != null) {
                    b.this.fmk.jr(v.H(b.this.fmn) > 0);
                }
            }
        }
    }
}
