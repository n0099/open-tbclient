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
    private View mhJ;
    private HeadImageView mhK;
    private TextView mhL;
    private TextView mhM;
    private ImageView mhN;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.mhJ = null;
        this.mhK = null;
        this.mhL = null;
        this.mhM = null;
        this.mhN = null;
        this.mhJ = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.mhK = (HeadImageView) this.mhJ.findViewById(R.id.zan_list_item_head);
        this.mhL = (TextView) this.mhJ.findViewById(R.id.zan_list_item_name);
        this.mhM = (TextView) this.mhJ.findViewById(R.id.zan_list_item_time);
        this.mhN = (ImageView) this.mhJ.findViewById(R.id.zan_list_item_line_bottom);
        this.mhN.setVisibility(0);
        this.mhJ.setTag(this);
    }

    public View getView() {
        return this.mhJ;
    }

    public void b(String str, String str2, long j, boolean z) {
        this.mhL.setText(str);
        this.mhK.setImageDrawable(null);
        this.mhM.setText(au.getFormatTime(j));
        this.mhK.startLoad(str2, 28, false);
    }
}
