package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.c.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private final int fZo;
    private Context mContext;
    private int padding;
    private List<e> tagList = new ArrayList();
    private int textSize;

    public b(Context context, int i) {
        this.textSize = 0;
        this.padding = 0;
        this.mContext = context;
        this.textSize = context.getResources().getDimensionPixelSize(d.e.fontsize28);
        this.padding = context.getResources().getDimensionPixelSize(d.e.ds16);
        this.fZo = i;
    }

    public void setTagList(List<e> list) {
        this.tagList.clear();
        if (list != null && list.size() > 0) {
            this.tagList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.tagList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vc */
    public e getItem(int i) {
        if (i < 0 || i >= this.tagList.size()) {
            return null;
        }
        return this.tagList.get(i);
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
        e eVar = (e) v.c(this.tagList, i);
        if (eVar == null) {
            return null;
        }
        textView.setText(ap.g(eVar.tag_name, 8, null));
        al.d(textView, d.C0236d.cp_cont_f, 1);
        if (i == this.fZo) {
            al.k(textView, d.f.btn_label_white_s);
            return textView;
        }
        al.k(textView, d.f.lego_btn_more_item);
        return textView;
    }
}
