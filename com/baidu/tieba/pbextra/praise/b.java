package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b {
    private View lTm;
    private HeadImageView lTn;
    private TextView lTo;
    private TextView lTp;
    private ImageView lTq;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.lTm = null;
        this.lTn = null;
        this.lTo = null;
        this.lTp = null;
        this.lTq = null;
        this.lTm = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.lTn = (HeadImageView) this.lTm.findViewById(R.id.zan_list_item_head);
        this.lTo = (TextView) this.lTm.findViewById(R.id.zan_list_item_name);
        this.lTp = (TextView) this.lTm.findViewById(R.id.zan_list_item_time);
        this.lTq = (ImageView) this.lTm.findViewById(R.id.zan_list_item_line_bottom);
        this.lTq.setVisibility(0);
        this.lTm.setTag(this);
    }

    public View getView() {
        return this.lTm;
    }

    public void b(String str, String str2, long j, boolean z) {
        this.lTo.setText(str);
        this.lTn.setImageDrawable(null);
        this.lTp.setText(at.getFormatTime(j));
        this.lTn.startLoad(str2, 28, false);
    }
}
