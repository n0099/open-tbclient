package com.baidu.tieba.pb.pb.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b {
    private View cST;
    private HeadImageView cSU;
    private TextView cSV;
    private TextView cSW;
    private ImageView cSX;

    public static b h(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.cST = null;
        this.cSU = null;
        this.cSV = null;
        this.cSW = null;
        this.cSX = null;
        this.cST = LayoutInflater.from(context).inflate(t.h.zan_list_item, (ViewGroup) null);
        this.cSU = (HeadImageView) this.cST.findViewById(t.g.zan_list_item_head);
        this.cSV = (TextView) this.cST.findViewById(t.g.zan_list_item_name);
        this.cSW = (TextView) this.cST.findViewById(t.g.zan_list_item_time);
        this.cSX = (ImageView) this.cST.findViewById(t.g.zan_list_item_line_bottom);
        this.cSX.setVisibility(0);
        this.cST.setTag(this);
    }

    public View getView() {
        return this.cST;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.cSV.setText(str);
        this.cSU.setImageDrawable(null);
        this.cSW.setText(aw.t(j));
        this.cSU.d(str2, 28, false);
    }
}
