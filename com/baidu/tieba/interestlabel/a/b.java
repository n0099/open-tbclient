package com.baidu.tieba.interestlabel.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class b extends BaseAdapter {
    private LabelSettingView jvA;
    private List<com.baidu.tieba.interestlabel.b.a> jvC;
    private List<Integer> jvD = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.jvA = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !x.isEmpty(bVar.cAs())) {
            this.mLabelDataSet = bVar;
            this.jvC = bVar.cAs();
            if (!x.isEmpty(bVar.cAt())) {
                this.jvD = new ArrayList(bVar.cAt());
            }
        }
    }

    public List<Integer> cAp() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.cAt();
    }

    public List<Integer> cAq() {
        return this.jvD;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return x.getCount(this.jvC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zN */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) x.getItem(this.jvC, i);
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
        C0678b c0678b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.jvA.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            C0678b c0678b2 = new C0678b();
            c0678b2.jvF = (TextView) view2;
            view2.setTag(c0678b2);
            c0678b = c0678b2;
        } else {
            c0678b = (C0678b) view.getTag();
            view2 = view;
        }
        c0678b.jvF.setOnClickListener(new a(i));
        a(c0678b.jvF, getItem(i));
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
                ao.setViewTextColor(textView, R.color.cp_link_tip_a);
                drawable = ao.getDrawable(R.drawable.icon_lable_confirm_s);
            } else {
                ao.setViewTextColor(textView, R.color.cp_cont_b);
                drawable = ao.getDrawable(R.drawable.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    class C0678b {
        TextView jvF;

        C0678b() {
        }
    }

    /* loaded from: classes17.dex */
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
                    b.this.jvD.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.jvD.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.jvA != null) {
                    b.this.jvA.qO(x.getCount(b.this.jvD) > 0);
                }
            }
        }
    }
}
