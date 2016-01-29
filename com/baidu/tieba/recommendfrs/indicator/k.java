package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private final int bTv;
    private List<TagInfo> dEX = new ArrayList();
    private Context mContext;
    private int padding;
    private int textSize;

    public k(Context context, int i) {
        this.textSize = 0;
        this.padding = 0;
        this.mContext = context;
        this.textSize = context.getResources().getDimensionPixelSize(t.e.fontsize28);
        this.padding = context.getResources().getDimensionPixelSize(t.e.ds16);
        this.bTv = i;
    }

    public void bU(List<TagInfo> list) {
        this.dEX.clear();
        if (list != null && list.size() > 0) {
            this.dEX.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dEX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: nA */
    public TagInfo getItem(int i) {
        if (i < 0 || i >= this.dEX.size()) {
            return null;
        }
        return this.dEX.get(i);
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
        TagInfo tagInfo = (TagInfo) x.b(this.dEX, i);
        if (tagInfo == null) {
            return null;
        }
        textView.setText(aw.e(tagInfo.tag_name, 8, null));
        ar.b(textView, t.d.cp_cont_f, 1);
        if (i == this.bTv) {
            ar.k(textView, t.f.btn_label_white_s);
            return textView;
        }
        ar.k(textView, t.f.rec_frs_btn_more_item);
        return textView;
    }
}
