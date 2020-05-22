package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    private View kiR;
    private HeadImageView kiS;
    private TextView kiT;
    private TextView kiU;
    private ImageView kiV;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.kiR = null;
        this.kiS = null;
        this.kiT = null;
        this.kiU = null;
        this.kiV = null;
        this.kiR = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.kiS = (HeadImageView) this.kiR.findViewById(R.id.zan_list_item_head);
        this.kiT = (TextView) this.kiR.findViewById(R.id.zan_list_item_name);
        this.kiU = (TextView) this.kiR.findViewById(R.id.zan_list_item_time);
        this.kiV = (ImageView) this.kiR.findViewById(R.id.zan_list_item_line_bottom);
        this.kiV.setVisibility(0);
        this.kiR.setTag(this);
    }

    public View getView() {
        return this.kiR;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.kiT.setText(str);
        this.kiS.setImageDrawable(null);
        this.kiU.setText(aq.getFormatTime(j));
        this.kiS.startLoad(str2, 28, false);
    }
}
