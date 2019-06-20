package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends v.a {
    public ImageView cGs;
    public TextView mTextView;

    public c(View view, Context context) {
        super(view);
        this.mTextView = (TextView) view.findViewById(R.id.no_data_text);
        this.cGs = (ImageView) view.findViewById(R.id.no_data_image);
    }
}
