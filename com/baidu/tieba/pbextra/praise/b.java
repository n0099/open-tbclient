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
/* loaded from: classes16.dex */
public class b {
    private View lcK;
    private HeadImageView lcL;
    private TextView lcM;
    private TextView lcN;
    private ImageView lcO;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.lcK = null;
        this.lcL = null;
        this.lcM = null;
        this.lcN = null;
        this.lcO = null;
        this.lcK = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.lcL = (HeadImageView) this.lcK.findViewById(R.id.zan_list_item_head);
        this.lcM = (TextView) this.lcK.findViewById(R.id.zan_list_item_name);
        this.lcN = (TextView) this.lcK.findViewById(R.id.zan_list_item_time);
        this.lcO = (ImageView) this.lcK.findViewById(R.id.zan_list_item_line_bottom);
        this.lcO.setVisibility(0);
        this.lcK.setTag(this);
    }

    public View getView() {
        return this.lcK;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.lcM.setText(str);
        this.lcL.setImageDrawable(null);
        this.lcN.setText(at.getFormatTime(j));
        this.lcL.startLoad(str2, 28, false);
    }
}
