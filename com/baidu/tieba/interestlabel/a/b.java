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
/* loaded from: classes17.dex */
public class b extends BaseAdapter {
    private LabelSettingView jKX;
    private List<com.baidu.tieba.interestlabel.b.a> jKZ;
    private List<Integer> jLa = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.jKX = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.cLk())) {
            this.mLabelDataSet = bVar;
            this.jKZ = bVar.cLk();
            if (!y.isEmpty(bVar.cLl())) {
                this.jLa = new ArrayList(bVar.cLl());
            }
        }
    }

    public List<Integer> cLh() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.cLl();
    }

    public List<Integer> cLi() {
        return this.jLa;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.jKZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Cg */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) y.getItem(this.jKZ, i);
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
        C0730b c0730b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.jKX.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            C0730b c0730b2 = new C0730b();
            c0730b2.jLc = (TextView) view2;
            view2.setTag(c0730b2);
            c0730b = c0730b2;
        } else {
            c0730b = (C0730b) view.getTag();
            view2 = view;
        }
        c0730b.jLc.setOnClickListener(new a(i));
        a(c0730b.jLc, getItem(i));
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
    /* loaded from: classes17.dex */
    class C0730b {
        TextView jLc;

        C0730b() {
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
                    b.this.jLa.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.jLa.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.jKX != null) {
                    b.this.jKX.ru(y.getCount(b.this.jLa) > 0);
                }
            }
        }
    }
}
