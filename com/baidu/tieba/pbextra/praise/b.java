package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    private View kDJ;
    private HeadImageView kDK;
    private TextView kDL;
    private TextView kDM;
    private ImageView kDN;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.kDJ = null;
        this.kDK = null;
        this.kDL = null;
        this.kDM = null;
        this.kDN = null;
        this.kDJ = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.kDK = (HeadImageView) this.kDJ.findViewById(R.id.zan_list_item_head);
        this.kDL = (TextView) this.kDJ.findViewById(R.id.zan_list_item_name);
        this.kDM = (TextView) this.kDJ.findViewById(R.id.zan_list_item_time);
        this.kDN = (ImageView) this.kDJ.findViewById(R.id.zan_list_item_line_bottom);
        this.kDN.setVisibility(0);
        this.kDJ.setTag(this);
    }

    public View getView() {
        return this.kDJ;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.kDL.setText(str);
        this.kDK.setImageDrawable(null);
        this.kDM.setText(ar.getFormatTime(j));
        this.kDK.startLoad(str2, 28, false);
    }
}
