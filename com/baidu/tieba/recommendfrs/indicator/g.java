package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private final int bvZ;
    private List<String> cHY = new ArrayList();
    private Context mContext;
    private int padding;
    private int textSize;

    public g(Context context, int i) {
        this.textSize = 0;
        this.padding = 0;
        this.mContext = context;
        this.textSize = context.getResources().getDimensionPixelSize(i.d.fontsize28);
        this.padding = context.getResources().getDimensionPixelSize(i.d.ds16);
        this.bvZ = i;
    }

    public void bp(List<String> list) {
        this.cHY.clear();
        if (list != null && list.size() > 0) {
            this.cHY.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cHY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: im */
    public String getItem(int i) {
        if (i < 0 || i >= this.cHY.size()) {
            return null;
        }
        return this.cHY.get(i);
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
        textView.setText(getItem(i));
        am.b(textView, i.c.cp_cont_f, 1);
        if (i == this.bvZ) {
            am.i((View) textView, i.e.btn_label_white_s);
        } else {
            am.i((View) textView, i.e.rec_frs_btn_more_item);
        }
        return textView;
    }
}
