package com.baidu.tieba.interestlabel.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private LabelSettingView eIo;
    private List<com.baidu.tieba.interestlabel.b.a> eIq;
    private List<Integer> eIr = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.eIo = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !w.A(bVar.aPo())) {
            this.mLabelDataSet = bVar;
            this.eIq = bVar.aPo();
            if (!w.A(bVar.aPp())) {
                this.eIr = new ArrayList(bVar.aPp());
            }
        }
    }

    public List<Integer> aPl() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.aPp();
    }

    public List<Integer> aPm() {
        return this.eIr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.z(this.eIq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oF */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) w.d(this.eIq, i);
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
        C0188b c0188b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.eIo.getContext()).inflate(d.i.item_label_layout, (ViewGroup) null);
            C0188b c0188b2 = new C0188b();
            c0188b2.eIt = (TextView) view2;
            view2.setTag(c0188b2);
            c0188b = c0188b2;
        } else {
            c0188b = (C0188b) view.getTag();
            view2 = view;
        }
        c0188b.eIt.setOnClickListener(new a(i));
        a(c0188b.eIt, getItem(i));
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
                am.h(textView, d.C0142d.cp_link_tip_a);
                drawable = am.getDrawable(d.f.icon_lable_confirm_s);
            } else {
                am.h(textView, d.C0142d.cp_cont_b);
                drawable = am.getDrawable(d.f.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0188b {
        TextView eIt;

        C0188b() {
        }
    }

    /* loaded from: classes3.dex */
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
                    b.this.eIr.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.eIr.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.eIo != null) {
                    b.this.eIo.ii(w.z(b.this.eIr) > 0);
                }
            }
        }
    }
}
