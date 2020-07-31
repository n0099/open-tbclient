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
    private View kML;
    private HeadImageView kMM;
    private TextView kMN;
    private TextView kMO;
    private ImageView kMP;

    public static b b(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.kML = null;
        this.kMM = null;
        this.kMN = null;
        this.kMO = null;
        this.kMP = null;
        this.kML = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.kMM = (HeadImageView) this.kML.findViewById(R.id.zan_list_item_head);
        this.kMN = (TextView) this.kML.findViewById(R.id.zan_list_item_name);
        this.kMO = (TextView) this.kML.findViewById(R.id.zan_list_item_time);
        this.kMP = (ImageView) this.kML.findViewById(R.id.zan_list_item_line_bottom);
        this.kMP.setVisibility(0);
        this.kML.setTag(this);
    }

    public View getView() {
        return this.kML;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.kMN.setText(str);
        this.kMM.setImageDrawable(null);
        this.kMO.setText(as.getFormatTime(j));
        this.kMM.startLoad(str2, 28, false);
    }
}
