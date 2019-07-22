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
/* loaded from: classes4.dex */
public class b {
    private View dbR;
    private HeadImageView ihG;
    private TextView ihH;
    private TextView ihI;
    private ImageView ihJ;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.dbR = null;
        this.ihG = null;
        this.ihH = null;
        this.ihI = null;
        this.ihJ = null;
        this.dbR = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.ihG = (HeadImageView) this.dbR.findViewById(R.id.zan_list_item_head);
        this.ihH = (TextView) this.dbR.findViewById(R.id.zan_list_item_name);
        this.ihI = (TextView) this.dbR.findViewById(R.id.zan_list_item_time);
        this.ihJ = (ImageView) this.dbR.findViewById(R.id.zan_list_item_line_bottom);
        this.ihJ.setVisibility(0);
        this.dbR.setTag(this);
    }

    public View getView() {
        return this.dbR;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.ihH.setText(str);
        this.ihG.setImageDrawable(null);
        this.ihI.setText(aq.aD(j));
        this.ihG.startLoad(str2, 28, false);
    }
}
