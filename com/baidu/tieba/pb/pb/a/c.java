package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c extends v.a {
    public ImageView cyi;
    public TextView mTextView;

    public c(View view, Context context) {
        super(view);
        this.mTextView = (TextView) view.findViewById(d.g.no_data_text);
        this.cyi = (ImageView) view.findViewById(d.g.no_data_image);
    }
}
