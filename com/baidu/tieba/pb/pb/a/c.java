package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends v.a {
    public ImageView cHM;
    public TextView mTextView;

    public c(View view, Context context) {
        super(view);
        this.mTextView = (TextView) view.findViewById(R.id.no_data_text);
        this.cHM = (ImageView) view.findViewById(R.id.no_data_image);
    }
}
