package com.baidu.tieba.interestlabel.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class b extends BaseAdapter {
    private LabelSettingView kiF;
    private List<com.baidu.tieba.interestlabel.b.a> kiH;
    private List<Integer> kiI = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.kiF = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.cSz())) {
            this.mLabelDataSet = bVar;
            this.kiH = bVar.cSz();
            if (!y.isEmpty(bVar.cSA())) {
                this.kiI = new ArrayList(bVar.cSA());
            }
        }
    }

    public List<Integer> cSw() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.cSA();
    }

    public List<Integer> cSx() {
        return this.kiI;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.kiH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Dn */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) y.getItem(this.kiH, i);
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
        C0745b c0745b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.kiF.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            C0745b c0745b2 = new C0745b();
            c0745b2.kiK = (TextView) view2;
            view2.setTag(c0745b2);
            c0745b = c0745b2;
        } else {
            c0745b = (C0745b) view.getTag();
            view2 = view;
        }
        c0745b.kiK.setOnClickListener(new a(i));
        a(c0745b.kiK, getItem(i));
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, com.baidu.tieba.interestlabel.b.a aVar) {
        Drawable drawable;
        if (aVar != null) {
            String str = aVar.labelName;
            if (!StringUtils.isNull(aVar.labelName) && aVar.labelName.length() > 4) {
                str = aVar.labelName.substring(0, 3) + StringHelper.STRING_MORE;
            }
            textView.setText(str);
            if (aVar.isFollow) {
                ap.setViewTextColor(textView, R.color.cp_link_tip_a);
                drawable = ap.getDrawable(R.drawable.icon_lable_confirm_s);
            } else {
                ap.setViewTextColor(textView, R.color.cp_cont_b);
                drawable = ap.getDrawable(R.drawable.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    class C0745b {
        TextView kiK;

        C0745b() {
        }
    }

    /* loaded from: classes23.dex */
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
                    b.this.kiI.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.kiI.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.kiF != null) {
                    b.this.kiF.sk(y.getCount(b.this.kiI) > 0);
                }
            }
        }
    }
}
