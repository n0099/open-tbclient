package com.baidu.tieba.pbextra.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b {
    private View lcD;
    private HeadImageView lcE;
    private TextView lcF;
    private TextView lcG;
    private ImageView lcH;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.lcD = null;
        this.lcE = null;
        this.lcF = null;
        this.lcG = null;
        this.lcH = null;
        this.lcD = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.lcE = (HeadImageView) this.lcD.findViewById(R.id.zan_list_item_head);
        this.lcF = (TextView) this.lcD.findViewById(R.id.zan_list_item_name);
        this.lcG = (TextView) this.lcD.findViewById(R.id.zan_list_item_time);
        this.lcH = (ImageView) this.lcD.findViewById(R.id.zan_list_item_line_bottom);
        this.lcH.setVisibility(0);
        this.lcD.setTag(this);
    }

    public View getView() {
        return this.lcD;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.lcF.setText(str);
        this.lcE.setImageDrawable(null);
        this.lcG.setText(at.getFormatTime(j));
        this.lcE.startLoad(str2, 28, false);
    }
}
