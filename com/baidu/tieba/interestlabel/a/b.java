package com.baidu.tieba.interestlabel.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private LabelSettingView iUW;
    private List<com.baidu.tieba.interestlabel.b.a> iUY;
    private List<Integer> iUZ = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.iUW = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.csu())) {
            this.mLabelDataSet = bVar;
            this.iUY = bVar.csu();
            if (!v.isEmpty(bVar.csv())) {
                this.iUZ = new ArrayList(bVar.csv());
            }
        }
    }

    public List<Integer> csr() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.csv();
    }

    public List<Integer> css() {
        return this.iUZ;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.iUY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yA */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) v.getItem(this.iUY, i);
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
        C0653b c0653b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.iUW.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            C0653b c0653b2 = new C0653b();
            c0653b2.iVb = (TextView) view2;
            view2.setTag(c0653b2);
            c0653b = c0653b2;
        } else {
            c0653b = (C0653b) view.getTag();
            view2 = view;
        }
        c0653b.iVb.setOnClickListener(new a(i));
        a(c0653b.iVb, getItem(i));
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
                am.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
                drawable = am.getDrawable(R.drawable.icon_lable_confirm_s);
            } else {
                am.setViewTextColor(textView, (int) R.color.cp_cont_b);
                drawable = am.getDrawable(R.drawable.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C0653b {
        TextView iVb;

        C0653b() {
        }
    }

    /* loaded from: classes10.dex */
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
                    b.this.iUZ.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.iUZ.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.iUW != null) {
                    b.this.iUW.pX(v.getCount(b.this.iUZ) > 0);
                }
            }
        }
    }
}
