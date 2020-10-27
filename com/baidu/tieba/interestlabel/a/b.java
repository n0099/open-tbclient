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
    private LabelSettingView kvc;
    private List<com.baidu.tieba.interestlabel.b.a> kve;
    private List<Integer> kvf = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.kvc = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.cVG())) {
            this.mLabelDataSet = bVar;
            this.kve = bVar.cVG();
            if (!y.isEmpty(bVar.cVH())) {
                this.kvf = new ArrayList(bVar.cVH());
            }
        }
    }

    public List<Integer> cVD() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.cVH();
    }

    public List<Integer> cVE() {
        return this.kvf;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.kve);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DG */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) y.getItem(this.kve, i);
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
        C0761b c0761b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.kvc.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            C0761b c0761b2 = new C0761b();
            c0761b2.kvh = (TextView) view2;
            view2.setTag(c0761b2);
            c0761b = c0761b2;
        } else {
            c0761b = (C0761b) view.getTag();
            view2 = view;
        }
        c0761b.kvh.setOnClickListener(new a(i));
        a(c0761b.kvh, getItem(i));
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
    class C0761b {
        TextView kvh;

        C0761b() {
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
                    b.this.kvf.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.kvf.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.kvc != null) {
                    b.this.kvc.sC(y.getCount(b.this.kvf) > 0);
                }
            }
        }
    }
}
