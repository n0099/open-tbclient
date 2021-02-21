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
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private LabelSettingView kXW;
    private List<com.baidu.tieba.interestlabel.b.a> kXY;
    private List<Integer> kXZ = new ArrayList();
    private com.baidu.tieba.interestlabel.b.b mLabelDataSet;

    public b(LabelSettingView labelSettingView) {
        this.kXW = labelSettingView;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && !y.isEmpty(bVar.daN())) {
            this.mLabelDataSet = bVar;
            this.kXY = bVar.daN();
            if (!y.isEmpty(bVar.daO())) {
                this.kXZ = new ArrayList(bVar.daO());
            }
        }
    }

    public List<Integer> daK() {
        return this.mLabelDataSet == null ? new ArrayList() : this.mLabelDataSet.daO();
    }

    public List<Integer> daL() {
        return this.kXZ;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.kXY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DM */
    public com.baidu.tieba.interestlabel.b.a getItem(int i) {
        return (com.baidu.tieba.interestlabel.b.a) y.getItem(this.kXY, i);
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
        C0772b c0772b;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.kXW.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
            C0772b c0772b2 = new C0772b();
            c0772b2.kYb = (TextView) view2;
            view2.setTag(c0772b2);
            c0772b = c0772b2;
        } else {
            c0772b = (C0772b) view.getTag();
            view2 = view;
        }
        c0772b.kYb.setOnClickListener(new a(i));
        a(c0772b.kYb, getItem(i));
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
                ap.setViewTextColor(textView, R.color.CAM_X0302);
                drawable = ap.getDrawable(R.drawable.icon_lable_confirm_s);
            } else {
                ap.setViewTextColor(textView, R.color.CAM_X0105);
                drawable = ap.getDrawable(R.drawable.icon_lable_confirm_n);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    /* renamed from: com.baidu.tieba.interestlabel.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    class C0772b {
        TextView kYb;

        C0772b() {
        }
    }

    /* loaded from: classes8.dex */
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
                    b.this.kXZ.add(Integer.valueOf(item.labelId));
                } else {
                    b.this.kXZ.remove(Integer.valueOf(item.labelId));
                }
                if (b.this.kXW != null) {
                    b.this.kXW.tA(y.getCount(b.this.kXZ) > 0);
                }
            }
        }
    }
}
