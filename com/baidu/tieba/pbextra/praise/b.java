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
    private View das;
    private HeadImageView ibo;
    private TextView ibp;
    private TextView ibq;
    private ImageView ibr;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.das = null;
        this.ibo = null;
        this.ibp = null;
        this.ibq = null;
        this.ibr = null;
        this.das = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.ibo = (HeadImageView) this.das.findViewById(R.id.zan_list_item_head);
        this.ibp = (TextView) this.das.findViewById(R.id.zan_list_item_name);
        this.ibq = (TextView) this.das.findViewById(R.id.zan_list_item_time);
        this.ibr = (ImageView) this.das.findViewById(R.id.zan_list_item_line_bottom);
        this.ibr.setVisibility(0);
        this.das.setTag(this);
    }

    public View getView() {
        return this.das;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.ibp.setText(str);
        this.ibo.setImageDrawable(null);
        this.ibq.setText(ap.aC(j));
        this.ibo.startLoad(str2, 28, false);
    }
}
