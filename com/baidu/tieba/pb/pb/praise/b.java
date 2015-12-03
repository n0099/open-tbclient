package com.baidu.tieba.pb.pb.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class b {
    private HeadImageView mItemHead;
    private ImageView mItemLineBottom;
    private TextView mItemName;
    private TextView mItemTime;
    private View mItemView;

    public static b i(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.mItemView = null;
        this.mItemHead = null;
        this.mItemName = null;
        this.mItemTime = null;
        this.mItemLineBottom = null;
        this.mItemView = LayoutInflater.from(context).inflate(n.g.zan_list_item, (ViewGroup) null);
        this.mItemHead = (HeadImageView) this.mItemView.findViewById(n.f.zan_list_item_head);
        this.mItemName = (TextView) this.mItemView.findViewById(n.f.zan_list_item_name);
        this.mItemTime = (TextView) this.mItemView.findViewById(n.f.zan_list_item_time);
        this.mItemLineBottom = (ImageView) this.mItemView.findViewById(n.f.zan_list_item_line_bottom);
        this.mItemLineBottom.setVisibility(0);
        this.mItemView.setTag(this);
    }

    public View getView() {
        return this.mItemView;
    }

    public void setData(String str, String str2, long j, boolean z) {
        this.mItemName.setText(str);
        this.mItemHead.setImageDrawable(null);
        this.mItemTime.setText(ax.s(j));
        this.mItemHead.d(str2, 28, false);
    }
}
