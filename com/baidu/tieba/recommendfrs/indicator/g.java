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
import tbclient.ExcFrsPage.ExcellentTagInfo;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private final int bLO;
    private List<ExcellentTagInfo> dix = new ArrayList();
    private Context mContext;
    private int padding;
    private int textSize;

    public g(Context context, int i) {
        this.textSize = 0;
        this.padding = 0;
        this.mContext = context;
        this.textSize = context.getResources().getDimensionPixelSize(n.d.fontsize28);
        this.padding = context.getResources().getDimensionPixelSize(n.d.ds16);
        this.bLO = i;
    }

    public void bG(List<ExcellentTagInfo> list) {
        this.dix.clear();
        if (list != null && list.size() > 0) {
            this.dix.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dix.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lO */
    public ExcellentTagInfo getItem(int i) {
        if (i < 0 || i >= this.dix.size()) {
            return null;
        }
        return this.dix.get(i);
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
        ExcellentTagInfo excellentTagInfo = (ExcellentTagInfo) y.b(this.dix, i);
        if (excellentTagInfo == null) {
            return null;
        }
        textView.setText(ax.e(excellentTagInfo.tag_name, 8, null));
        as.b(textView, n.c.cp_cont_f, 1);
        if (i == this.bLO) {
            as.i((View) textView, n.e.btn_label_white_s);
            return textView;
        }
        as.i((View) textView, n.e.rec_frs_btn_more_item);
        return textView;
    }
}
