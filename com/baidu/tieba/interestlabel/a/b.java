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
    private LabelSettingView kAX;
    private List<com.baidu.tieba.interestlabel.b.a> kAZ;
    private List<Integer> kBa = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.kAX = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.cYh())) {
            this.mLabelDataSet = bVar;
            this.kAZ = bVar.cYh();
            if (!y.isEmpty(bVar.cYi())) {
                this.kBa = new ArrayList(bVar.cYi());
            }
        }
    }

    public List<Integer> cYe() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.cYi();
    }

    public List<Integer> cYf() {
        return this.kBa;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.kAZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DT */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) y.getItem(this.kAZ, i);
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
        C0775b c0775b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.kAX.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            C0775b c0775b2 = new C0775b();
            c0775b2.kBc = (TextView) view2;
            view2.setTag(c0775b2);
            c0775b = c0775b2;
        } else {
            c0775b = (C0775b) view.getTag();
            view2 = view;
        }
        c0775b.kBc.setOnClickListener(new a(i));
        a(c0775b.kBc, getItem(i));
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
    class C0775b {
        TextView kBc;

        C0775b() {
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
                    b.this.kBa.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.kBa.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.kAX != null) {
                    b.this.kAX.sL(y.getCount(b.this.kBa) > 0);
                }
            }
        }
    }
}
