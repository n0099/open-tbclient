package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private View brw;
    private HeadImageView fSk;
    private TextView fSl;
    private TextView fSm;
    private ImageView fSn;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.brw = null;
        this.fSk = null;
        this.fSl = null;
        this.fSm = null;
        this.fSn = null;
        this.brw = LayoutInflater.from(context).inflate(d.i.zan_list_item, (ViewGroup) null);
        this.fSk = (HeadImageView) this.brw.findViewById(d.g.zan_list_item_head);
        this.fSl = (TextView) this.brw.findViewById(d.g.zan_list_item_name);
        this.fSm = (TextView) this.brw.findViewById(d.g.zan_list_item_time);
        this.fSn = (ImageView) this.brw.findViewById(d.g.zan_list_item_line_bottom);
        this.fSn.setVisibility(0);
        this.brw.setTag(this);
    }

    public View getView() {
        return this.brw;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.fSl.setText(str);
        this.fSk.setImageDrawable(null);
        this.fSm.setText(ap.w(j));
        this.fSk.startLoad(str2, 28, false);
    }
}
