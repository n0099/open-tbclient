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
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    private LabelSettingView gUq;
    private List<com.baidu.tieba.interestlabel.b.a> gUs;
    private List<Integer> gUt = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.gUq = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.aa(bVar.bGC())) {
            this.mLabelDataSet = bVar;
            this.gUs = bVar.bGC();
            if (!v.aa(bVar.bGD())) {
                this.gUt = new ArrayList(bVar.bGD());
            }
        }
    }

    public List<Integer> bGz() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.bGD();
    }

    public List<Integer> bGA() {
        return this.gUt;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.gUs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vL */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) v.c(this.gUs, i);
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
        C0346b c0346b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.gUq.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            C0346b c0346b2 = new C0346b();
            c0346b2.gUv = (TextView) view2;
            view2.setTag(c0346b2);
            c0346b = c0346b2;
        } else {
            c0346b = (C0346b) view.getTag();
            view2 = view;
        }
        c0346b.gUv.setOnClickListener(new a(i));
        a(c0346b.gUv, getItem(i));
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
                al.j(textView, R.color.cp_link_tip_a);
                drawable = al.getDrawable(R.drawable.icon_lable_confirm_s);
            } else {
                al.j(textView, R.color.cp_cont_b);
                drawable = al.getDrawable(R.drawable.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0346b {
        TextView gUv;

        C0346b() {
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
                    b.this.gUt.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.gUt.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.gUq != null) {
                    b.this.gUq.mH(v.Z(b.this.gUt) > 0);
                }
            }
        }
    }
}
