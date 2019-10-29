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
/* loaded from: classes4.dex */
public class b {
    private View dng;
    private HeadImageView ijr;
    private TextView ijs;
    private TextView ijt;
    private ImageView iju;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.dng = null;
        this.ijr = null;
        this.ijs = null;
        this.ijt = null;
        this.iju = null;
        this.dng = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.ijr = (HeadImageView) this.dng.findViewById(R.id.zan_list_item_head);
        this.ijs = (TextView) this.dng.findViewById(R.id.zan_list_item_name);
        this.ijt = (TextView) this.dng.findViewById(R.id.zan_list_item_time);
        this.iju = (ImageView) this.dng.findViewById(R.id.zan_list_item_line_bottom);
        this.iju.setVisibility(0);
        this.dng.setTag(this);
    }

    public View getView() {
        return this.dng;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.ijs.setText(str);
        this.ijr.setImageDrawable(null);
        this.ijt.setText(aq.getFormatTime(j));
        this.ijr.startLoad(str2, 28, false);
    }
}
