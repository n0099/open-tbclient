package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b {
    private View mhH;
    private HeadImageView mhI;
    private TextView mhJ;
    private TextView mhK;
    private ImageView mhL;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.mhH = null;
        this.mhI = null;
        this.mhJ = null;
        this.mhK = null;
        this.mhL = null;
        this.mhH = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.mhI = (HeadImageView) this.mhH.findViewById(R.id.zan_list_item_head);
        this.mhJ = (TextView) this.mhH.findViewById(R.id.zan_list_item_name);
        this.mhK = (TextView) this.mhH.findViewById(R.id.zan_list_item_time);
        this.mhL = (ImageView) this.mhH.findViewById(R.id.zan_list_item_line_bottom);
        this.mhL.setVisibility(0);
        this.mhH.setTag(this);
    }

    public View getView() {
        return this.mhH;
    }

    public void b(String str, String str2, long j, boolean z) {
        this.mhJ.setText(str);
        this.mhI.setImageDrawable(null);
        this.mhK.setText(au.getFormatTime(j));
        this.mhI.startLoad(str2, 28, false);
    }
}
