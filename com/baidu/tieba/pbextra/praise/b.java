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
    private View ddM;
    private HeadImageView ikH;
    private TextView ikI;
    private TextView ikJ;
    private ImageView ikK;

    public static b d(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.ddM = null;
        this.ikH = null;
        this.ikI = null;
        this.ikJ = null;
        this.ikK = null;
        this.ddM = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.ikH = (HeadImageView) this.ddM.findViewById(R.id.zan_list_item_head);
        this.ikI = (TextView) this.ddM.findViewById(R.id.zan_list_item_name);
        this.ikJ = (TextView) this.ddM.findViewById(R.id.zan_list_item_time);
        this.ikK = (ImageView) this.ddM.findViewById(R.id.zan_list_item_line_bottom);
        this.ikK.setVisibility(0);
        this.ddM.setTag(this);
    }

    public View getView() {
        return this.ddM;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.ikI.setText(str);
        this.ikH.setImageDrawable(null);
        this.ikJ.setText(aq.aD(j));
        this.ikH.startLoad(str2, 28, false);
    }
}
