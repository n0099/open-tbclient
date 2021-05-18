package com.baidu.tieba.pb.pb.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbNoDataItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f18921a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f18922b;

    public PbNoDataItemViewHolder(View view, Context context) {
        super(view);
        this.f18921a = (TextView) view.findViewById(R.id.no_data_text);
        this.f18922b = (ImageView) view.findViewById(R.id.no_data_image);
    }
}
