package com.baidu.tieba.interestlabel.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private LabelSettingView eMi;
    private List<com.baidu.tieba.interestlabel.b.a> eMk;
    private List<Integer> eMl = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.eMi = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !w.z(bVar.aQo())) {
            this.mLabelDataSet = bVar;
            this.eMk = bVar.aQo();
            if (!w.z(bVar.aQp())) {
                this.eMl = new ArrayList(bVar.aQp());
            }
        }
    }

    public List<Integer> aQl() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.aQp();
    }

    public List<Integer> aQm() {
        return this.eMl;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.y(this.eMk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oU */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) w.d(this.eMk, i);
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
            view2 = LayoutInflater.from(this.eMi.getContext()).inflate(d.h.item_label_layout, (ViewGroup) null);
            C0187b c0187b2 = new C0187b();
            c0187b2.eMn = (TextView) view2;
            view2.setTag(c0187b2);
            c0187b = c0187b2;
        } else {
            c0187b = (C0187b) view.getTag();
            view2 = view;
        }
        c0187b.eMn.setOnClickListener(new a(i));
        a(c0187b.eMn, getItem(i));
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
                am.h(textView, d.C0140d.cp_link_tip_a);
                drawable = am.getDrawable(d.f.icon_lable_confirm_s);
            } else {
                am.h(textView, d.C0140d.cp_cont_b);
                drawable = am.getDrawable(d.f.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0187b {
        TextView eMn;

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
                    b.this.eMl.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.eMl.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.eMi != null) {
                    b.this.eMi.il(w.y(b.this.eMl) > 0);
                }
            }
        }
    }
}
