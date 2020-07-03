package com.baidu.tieba.interestlabel.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private LabelSettingView jmW;
    private List<com.baidu.tieba.interestlabel.b.a> jmY;
    private List<Integer> jmZ = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.jmW = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !w.isEmpty(bVar.cwt())) {
            this.mLabelDataSet = bVar;
            this.jmY = bVar.cwt();
            if (!w.isEmpty(bVar.cwu())) {
                this.jmZ = new ArrayList(bVar.cwu());
            }
        }
    }

    public List<Integer> cwq() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.cwu();
    }

    public List<Integer> cwr() {
        return this.jmZ;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.getCount(this.jmY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zo */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) w.getItem(this.jmY, i);
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
        C0666b c0666b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.jmW.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            C0666b c0666b2 = new C0666b();
            c0666b2.jnb = (TextView) view2;
            view2.setTag(c0666b2);
            c0666b = c0666b2;
        } else {
            c0666b = (C0666b) view.getTag();
            view2 = view;
        }
        c0666b.jnb.setOnClickListener(new a(i));
        a(c0666b.jnb, getItem(i));
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
                an.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
                drawable = an.getDrawable(R.drawable.icon_lable_confirm_s);
            } else {
                an.setViewTextColor(textView, (int) R.color.cp_cont_b);
                drawable = an.getDrawable(R.drawable.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C0666b {
        TextView jnb;

        C0666b() {
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
                    b.this.jmZ.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.jmZ.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.jmW != null) {
                    b.this.jmW.qh(w.getCount(b.this.jmZ) > 0);
                }
            }
        }
    }
}
