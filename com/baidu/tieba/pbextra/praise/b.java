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
    private View dar;
    private HeadImageView ibn;
    private TextView ibo;
    private TextView ibp;
    private ImageView ibq;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.dar = null;
        this.ibn = null;
        this.ibo = null;
        this.ibp = null;
        this.ibq = null;
        this.dar = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.ibn = (HeadImageView) this.dar.findViewById(R.id.zan_list_item_head);
        this.ibo = (TextView) this.dar.findViewById(R.id.zan_list_item_name);
        this.ibp = (TextView) this.dar.findViewById(R.id.zan_list_item_time);
        this.ibq = (ImageView) this.dar.findViewById(R.id.zan_list_item_line_bottom);
        this.ibq.setVisibility(0);
        this.dar.setTag(this);
    }

    public View getView() {
        return this.dar;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.ibo.setText(str);
        this.ibn.setImageDrawable(null);
        this.ibp.setText(ap.aC(j));
        this.ibn.startLoad(str2, 28, false);
    }
}
