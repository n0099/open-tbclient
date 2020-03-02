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
/* loaded from: classes9.dex */
public class b {
    private View cbQ;
    private HeadImageView jfc;
    private TextView jfd;
    private TextView jfe;
    private ImageView jff;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.cbQ = null;
        this.jfc = null;
        this.jfd = null;
        this.jfe = null;
        this.jff = null;
        this.cbQ = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.jfc = (HeadImageView) this.cbQ.findViewById(R.id.zan_list_item_head);
        this.jfd = (TextView) this.cbQ.findViewById(R.id.zan_list_item_name);
        this.jfe = (TextView) this.cbQ.findViewById(R.id.zan_list_item_time);
        this.jff = (ImageView) this.cbQ.findViewById(R.id.zan_list_item_line_bottom);
        this.jff.setVisibility(0);
        this.cbQ.setTag(this);
    }

    public View getView() {
        return this.cbQ;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.jfd.setText(str);
        this.jfc.setImageDrawable(null);
        this.jfe.setText(aq.getFormatTime(j));
        this.jfc.startLoad(str2, 28, false);
    }
}
