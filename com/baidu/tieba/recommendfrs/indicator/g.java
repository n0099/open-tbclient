package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private final int bPv;
    private List<TagInfo> dpo = new ArrayList();
    private Context mContext;
    private int padding;
    private int textSize;

    public g(Context context, int i) {
        this.textSize = 0;
        this.padding = 0;
        this.mContext = context;
        this.textSize = context.getResources().getDimensionPixelSize(n.e.fontsize28);
        this.padding = context.getResources().getDimensionPixelSize(n.e.ds16);
        this.bPv = i;
    }

    public void bI(List<TagInfo> list) {
        this.dpo.clear();
        if (list != null && list.size() > 0) {
            this.dpo.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dpo.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mp */
    public TagInfo getItem(int i) {
        if (i < 0 || i >= this.dpo.size()) {
            return null;
        }
        return this.dpo.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            textView = new TextView(this.mContext);
            textView.setGravity(17);
            textView.setTextSize(0, this.textSize);
            textView.setPadding(0, this.padding, 0, this.padding);
        }
        TagInfo tagInfo = (TagInfo) y.b(this.dpo, i);
        if (tagInfo == null) {
            return null;
        }
        textView.setText(ax.e(tagInfo.tag_name, 8, null));
        as.b(textView, n.d.cp_cont_f, 1);
        if (i == this.bPv) {
            as.i((View) textView, n.f.btn_label_white_s);
            return textView;
        }
        as.i((View) textView, n.f.rec_frs_btn_more_item);
        return textView;
    }
}
