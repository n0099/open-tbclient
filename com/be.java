package com;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import java.util.List;
/* loaded from: classes.dex */
public class be extends ArrayAdapter {
    private SocialShareConfig a;

    /* loaded from: classes.dex */
    class a {
        private ImageView b;
        private TextView c;

        private a() {
        }
    }

    public be(Context context, List list) {
        super(context, 0, list);
        this.a = SocialShareConfig.getInstance(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            aVar = new a();
            view = LayoutInflater.from(getContext()).inflate(aq.a(getContext(), "bdsocialshare_sharemenugriditem"), (ViewGroup) null);
            aVar.b = (ImageView) view.findViewById(aq.d(getContext(), "sharemenugrid_iconview"));
            aVar.c = (TextView) view.findViewById(aq.d(getContext(), "sharemenugrid_icontext"));
            aVar.c.setTextColor(Color.parseColor(aq.a(getContext())));
        } else {
            aVar = (a) view.getTag();
        }
        MediaType mediaType = (MediaType) getItem(i);
        aVar.b.setImageResource(aq.c(getContext(), "bdsocialshare_" + mediaType.toString()));
        aVar.c.setText(this.a.getString(mediaType.toString()));
        return view;
    }
}
