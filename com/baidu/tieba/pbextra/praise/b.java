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
/* loaded from: classes2.dex */
public class b {
    private View mio;
    private HeadImageView mip;
    private TextView miq;
    private TextView mir;
    private ImageView mis;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.mio = null;
        this.mip = null;
        this.miq = null;
        this.mir = null;
        this.mis = null;
        this.mio = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.mip = (HeadImageView) this.mio.findViewById(R.id.zan_list_item_head);
        this.miq = (TextView) this.mio.findViewById(R.id.zan_list_item_name);
        this.mir = (TextView) this.mio.findViewById(R.id.zan_list_item_time);
        this.mis = (ImageView) this.mio.findViewById(R.id.zan_list_item_line_bottom);
        this.mis.setVisibility(0);
        this.mio.setTag(this);
    }

    public View getView() {
        return this.mio;
    }

    public void f(String str, String str2, long j, boolean z) {
        this.miq.setText(str);
        this.mip.setImageDrawable(null);
        this.mir.setText(at.getFormatTime(j));
        this.mip.startLoad(str2, 28, false);
    }
}
