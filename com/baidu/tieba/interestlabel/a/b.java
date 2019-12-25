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
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private LabelSettingView hOM;
    private List<com.baidu.tieba.interestlabel.b.a> hOO;
    private List<Integer> hOP = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.hOM = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !v.isEmpty(bVar.bYm())) {
            this.mLabelDataSet = bVar;
            this.hOO = bVar.bYm();
            if (!v.isEmpty(bVar.bYn())) {
                this.hOP = new ArrayList(bVar.bYn());
            }
        }
    }

    public List<Integer> bYj() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.bYn();
    }

    public List<Integer> bYk() {
        return this.hOP;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.hOO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wZ */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) v.getItem(this.hOO, i);
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
        C0532b c0532b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.hOM.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            C0532b c0532b2 = new C0532b();
            c0532b2.hOR = (TextView) view2;
            view2.setTag(c0532b2);
            c0532b = c0532b2;
        } else {
            c0532b = (C0532b) view.getTag();
            view2 = view;
        }
        c0532b.hOR.setOnClickListener(new a(i));
        a(c0532b.hOR, getItem(i));
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
    /* loaded from: classes7.dex */
    class C0532b {
        TextView hOR;

        C0532b() {
        }
    }

    /* loaded from: classes7.dex */
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
                    b.this.hOP.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.hOP.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.hOM != null) {
                    b.this.hOM.oc(v.getCount(b.this.hOP) > 0);
                }
            }
        }
    }
}
