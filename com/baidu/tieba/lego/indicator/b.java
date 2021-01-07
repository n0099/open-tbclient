package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.c.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private Context mContext;
    private int padding;
    private final int selectedPosition;
    private List<e> tagList = new ArrayList();
    private int textSize;

    public b(Context context, int i) {
        this.textSize = 0;
        this.padding = 0;
        this.mContext = context;
        this.textSize = context.getResources().getDimensionPixelSize(R.dimen.fontsize28);
        this.padding = context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.selectedPosition = i;
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
    /* renamed from: Fv */
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
        e eVar = (e) x.getItem(this.tagList, i);
        if (eVar == null) {
            return null;
        }
        textView.setText(at.cutChineseAndEnglishWithSuffix(eVar.tag_name, 8, null));
        ao.setViewTextColor(textView, R.color.CAM_X0106, 1);
        if (i == this.selectedPosition) {
            ao.setBackgroundResource(textView, R.drawable.btn_label_white_s);
            return textView;
        }
        ao.setBackgroundResource(textView, R.drawable.lego_btn_more_item);
        return textView;
    }
}
