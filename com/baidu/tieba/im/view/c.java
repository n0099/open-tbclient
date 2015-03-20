package com.baidu.tieba.im.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.im.util.i;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private List<com.baidu.tieba.im.data.d> bnY;
    private Context mContext;

    public c(Context context, List<com.baidu.tieba.im.data.d> list) {
        this.mContext = context;
        this.bnY = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bnY == null) {
            return 0;
        }
        return (this.bnY.size() * 2) - 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (this.bnY != null && itemId >= 0 && itemId < this.bnY.size()) {
            return this.bnY.get(itemId);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i % 2 == 1) {
            return -1L;
        }
        return i / 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) == -1 ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        int itemViewType = getItemViewType(i);
        View view2 = view;
        if (view == null) {
            d dVar = new d(this);
            if (itemViewType == 0) {
                TextView textView = new TextView(this.mContext);
                textView.setLayoutParams(new AbsListView.LayoutParams(-1, i.j(this.mContext, t.ds96)));
                textView.setTextSize(0, i.j(this.mContext, t.ds32));
                textView.setTextColor(this.mContext.getResources().getColor(s.cp_cont_b));
                textView.setGravity(17);
                textView.setBackgroundResource(u.official_bar_menu_text_bg);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.END);
                dVar.bnZ = textView;
                linearLayout = textView;
            } else {
                linearLayout = view;
                if (itemViewType == 1) {
                    LinearLayout linearLayout2 = new LinearLayout(this.mContext);
                    linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, i.j(this.mContext, t.ds1)));
                    ImageView imageView = new ImageView(this.mContext);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    layoutParams.setMargins(i.j(this.mContext, t.ds30), 0, i.j(this.mContext, t.ds30), 0);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setBackgroundColor(this.mContext.getResources().getColor(s.cp_bg_line_b));
                    linearLayout2.addView(imageView);
                    linearLayout = linearLayout2;
                }
            }
            linearLayout.setTag(dVar);
            view2 = linearLayout;
        }
        d dVar2 = (d) view2.getTag();
        if (itemViewType == 0) {
            dVar2.bnZ.setText(((com.baidu.tieba.im.data.d) getItem(i)).getName());
        }
        return view2;
    }
}
