package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    private View daq;
    private HeadImageView ibk;
    private TextView ibl;
    private TextView ibm;
    private ImageView ibn;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.daq = null;
        this.ibk = null;
        this.ibl = null;
        this.ibm = null;
        this.ibn = null;
        this.daq = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.ibk = (HeadImageView) this.daq.findViewById(R.id.zan_list_item_head);
        this.ibl = (TextView) this.daq.findViewById(R.id.zan_list_item_name);
        this.ibm = (TextView) this.daq.findViewById(R.id.zan_list_item_time);
        this.ibn = (ImageView) this.daq.findViewById(R.id.zan_list_item_line_bottom);
        this.ibn.setVisibility(0);
        this.daq.setTag(this);
    }

    public View getView() {
        return this.daq;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.ibl.setText(str);
        this.ibk.setImageDrawable(null);
        this.ibm.setText(ap.aC(j));
        this.ibk.startLoad(str2, 28, false);
    }
}
