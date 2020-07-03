package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends ad.a {
    public ImageView mImageView;
    public TextView mTextView;

    public b(View view, Context context) {
        super(view);
        this.mTextView = (TextView) view.findViewById(R.id.no_data_text);
        this.mImageView = (ImageView) view.findViewById(R.id.no_data_image);
    }
}
