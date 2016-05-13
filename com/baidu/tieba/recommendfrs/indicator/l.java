package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private List<TagInfo> cIJ = new ArrayList();
    private final int ceE;
    private Context mContext;
    private int padding;
    private int textSize;

    public l(Context context, int i) {
        this.textSize = 0;
        this.padding = 0;
        this.mContext = context;
        this.textSize = context.getResources().getDimensionPixelSize(t.e.fontsize28);
        this.padding = context.getResources().getDimensionPixelSize(t.e.ds16);
        this.ceE = i;
    }

    public void bx(List<TagInfo> list) {
        this.cIJ.clear();
        if (list != null && list.size() > 0) {
            this.cIJ.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cIJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ou */
    public TagInfo getItem(int i) {
        if (i < 0 || i >= this.cIJ.size()) {
            return null;
        }
        return this.cIJ.get(i);
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
        TagInfo tagInfo = (TagInfo) y.c(this.cIJ, i);
        if (tagInfo == null) {
            return null;
        }
        textView.setText(ay.d(tagInfo.tag_name, 8, null));
        at.c(textView, t.d.cp_cont_f, 1);
        if (i == this.ceE) {
            at.k(textView, t.f.btn_label_white_s);
            return textView;
        }
        at.k(textView, t.f.rec_frs_btn_more_item);
        return textView;
    }
}
