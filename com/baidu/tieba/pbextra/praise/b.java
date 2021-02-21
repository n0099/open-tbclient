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
/* loaded from: classes2.dex */
public class b {
    private View mrE;
    private HeadImageView mrF;
    private TextView mrG;
    private TextView mrH;
    private ImageView mrI;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.mrE = null;
        this.mrF = null;
        this.mrG = null;
        this.mrH = null;
        this.mrI = null;
        this.mrE = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.mrF = (HeadImageView) this.mrE.findViewById(R.id.zan_list_item_head);
        this.mrG = (TextView) this.mrE.findViewById(R.id.zan_list_item_name);
        this.mrH = (TextView) this.mrE.findViewById(R.id.zan_list_item_time);
        this.mrI = (ImageView) this.mrE.findViewById(R.id.zan_list_item_line_bottom);
        this.mrI.setVisibility(0);
        this.mrE.setTag(this);
    }

    public View getView() {
        return this.mrE;
    }

    public void f(String str, String str2, long j, boolean z) {
        this.mrG.setText(str);
        this.mrF.setImageDrawable(null);
        this.mrH.setText(au.getFormatTime(j));
        this.mrF.startLoad(str2, 28, false);
    }
}
