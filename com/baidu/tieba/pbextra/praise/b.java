package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b {
    private View bsg;
    private HeadImageView fSn;
    private TextView fSo;
    private TextView fSp;
    private ImageView fSq;

    public static b c(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bsg = null;
        this.fSn = null;
        this.fSo = null;
        this.fSp = null;
        this.fSq = null;
        this.bsg = LayoutInflater.from(context).inflate(f.h.zan_list_item, (ViewGroup) null);
        this.fSn = (HeadImageView) this.bsg.findViewById(f.g.zan_list_item_head);
        this.fSo = (TextView) this.bsg.findViewById(f.g.zan_list_item_name);
        this.fSp = (TextView) this.bsg.findViewById(f.g.zan_list_item_time);
        this.fSq = (ImageView) this.bsg.findViewById(f.g.zan_list_item_line_bottom);
        this.fSq.setVisibility(0);
        this.bsg.setTag(this);
    }

    public View getView() {
        return this.bsg;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.fSo.setText(str);
        this.fSn.setImageDrawable(null);
        this.fSp.setText(ap.w(j));
        this.fSn.startLoad(str2, 28, false);
    }
}
