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
/* loaded from: classes21.dex */
public class b {
    private View lTC;
    private HeadImageView lTD;
    private TextView lTE;
    private TextView lTF;
    private ImageView lTG;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.lTC = null;
        this.lTD = null;
        this.lTE = null;
        this.lTF = null;
        this.lTG = null;
        this.lTC = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.lTD = (HeadImageView) this.lTC.findViewById(R.id.zan_list_item_head);
        this.lTE = (TextView) this.lTC.findViewById(R.id.zan_list_item_name);
        this.lTF = (TextView) this.lTC.findViewById(R.id.zan_list_item_time);
        this.lTG = (ImageView) this.lTC.findViewById(R.id.zan_list_item_line_bottom);
        this.lTG.setVisibility(0);
        this.lTC.setTag(this);
    }

    public View getView() {
        return this.lTC;
    }

    public void b(String str, String str2, long j, boolean z) {
        this.lTE.setText(str);
        this.lTD.setImageDrawable(null);
        this.lTF.setText(au.getFormatTime(j));
        this.lTD.startLoad(str2, 28, false);
    }
}
