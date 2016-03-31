package com.baidu.tieba.pb.pb.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b {
    private View dnN;
    private HeadImageView dnO;
    private TextView dnP;
    private TextView dnQ;
    private ImageView dnR;

    public static b h(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.dnN = null;
        this.dnO = null;
        this.dnP = null;
        this.dnQ = null;
        this.dnR = null;
        this.dnN = LayoutInflater.from(context).inflate(t.h.zan_list_item, (ViewGroup) null);
        this.dnO = (HeadImageView) this.dnN.findViewById(t.g.zan_list_item_head);
        this.dnP = (TextView) this.dnN.findViewById(t.g.zan_list_item_name);
        this.dnQ = (TextView) this.dnN.findViewById(t.g.zan_list_item_time);
        this.dnR = (ImageView) this.dnN.findViewById(t.g.zan_list_item_line_bottom);
        this.dnR.setVisibility(0);
        this.dnN.setTag(this);
    }

    public View getView() {
        return this.dnN;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.dnP.setText(str);
        this.dnO.setImageDrawable(null);
        this.dnQ.setText(ay.w(j));
        this.dnO.c(str2, 28, false);
    }
}
