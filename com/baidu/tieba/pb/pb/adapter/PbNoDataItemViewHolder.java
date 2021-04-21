package com.baidu.tieba.pb.pb.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class PbNoDataItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f19176a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19177b;

    public PbNoDataItemViewHolder(View view, Context context) {
        super(view);
        this.f19176a = (TextView) view.findViewById(R.id.no_data_text);
        this.f19177b = (ImageView) view.findViewById(R.id.no_data_image);
    }
}
