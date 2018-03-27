package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private View bXM;
    private HeadImageView gho;
    private TextView ghp;
    private TextView ghq;
    private ImageView ghr;

    public static b c(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.bXM = null;
        this.gho = null;
        this.ghp = null;
        this.ghq = null;
        this.ghr = null;
        this.bXM = LayoutInflater.from(context).inflate(d.h.zan_list_item, (ViewGroup) null);
        this.gho = (HeadImageView) this.bXM.findViewById(d.g.zan_list_item_head);
        this.ghp = (TextView) this.bXM.findViewById(d.g.zan_list_item_name);
        this.ghq = (TextView) this.bXM.findViewById(d.g.zan_list_item_time);
        this.ghr = (ImageView) this.bXM.findViewById(d.g.zan_list_item_line_bottom);
        this.ghr.setVisibility(0);
        this.bXM.setTag(this);
    }

    public View getView() {
        return this.bXM;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.ghp.setText(str);
        this.gho.setImageDrawable(null);
        this.ghq.setText(am.z(j));
        this.gho.startLoad(str2, 28, false);
    }
}
