package com.baidu.tieba.interestlabel.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    private LabelSettingView haG;
    private List<com.baidu.tieba.interestlabel.b.a> haI;
    private List<Integer> haJ = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.haG = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.aa(bVar.bJn())) {
            this.mLabelDataSet = bVar;
            this.haI = bVar.bJn();
            if (!v.aa(bVar.bJo())) {
                this.haJ = new ArrayList(bVar.bJo());
            }
        }
    }

    public List<Integer> bJk() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.bJo();
    }

    public List<Integer> bJl() {
        return this.haJ;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.haI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wn */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) v.c(this.haI, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        com.baidu.tieba.interestlabel.b.a item = getItem(i);
        if (item == null) {
            return 0L;
        }
        return item.bFL;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0345b c0345b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.haG.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            C0345b c0345b2 = new C0345b();
            c0345b2.haL = (TextView) view2;
            view2.setTag(c0345b2);
            c0345b = c0345b2;
        } else {
            c0345b = (C0345b) view.getTag();
            view2 = view;
        }
        c0345b.haL.setOnClickListener(new a(i));
        a(c0345b.haL, getItem(i));
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
                am.j(textView, R.color.cp_link_tip_a);
                drawable = am.getDrawable(R.drawable.icon_lable_confirm_s);
            } else {
                am.j(textView, R.color.cp_cont_b);
                drawable = am.getDrawable(R.drawable.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0345b {
        TextView haL;

        C0345b() {
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
                    b.this.haJ.add(Integer.valueOf(item.bFL));
                } else {
                    b.this.haJ.remove(Integer.valueOf(item.bFL));
                }
                if (b.this.haG != null) {
                    b.this.haG.mW(v.Z(b.this.haJ) > 0);
                }
            }
        }
    }
}
