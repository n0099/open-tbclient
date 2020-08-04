package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b {
    private View kMN;
    private HeadImageView kMO;
    private TextView kMP;
    private TextView kMQ;
    private ImageView kMR;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.kMN = null;
        this.kMO = null;
        this.kMP = null;
        this.kMQ = null;
        this.kMR = null;
        this.kMN = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.kMO = (HeadImageView) this.kMN.findViewById(R.id.zan_list_item_head);
        this.kMP = (TextView) this.kMN.findViewById(R.id.zan_list_item_name);
        this.kMQ = (TextView) this.kMN.findViewById(R.id.zan_list_item_time);
        this.kMR = (ImageView) this.kMN.findViewById(R.id.zan_list_item_line_bottom);
        this.kMR.setVisibility(0);
        this.kMN.setTag(this);
    }

    public View getView() {
        return this.kMN;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.kMP.setText(str);
        this.kMO.setImageDrawable(null);
        this.kMQ.setText(as.getFormatTime(j));
        this.kMO.startLoad(str2, 28, false);
    }
}
