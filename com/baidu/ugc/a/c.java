package com.baidu.ugc.a;

import android.content.Context;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.request.RequestOptions;
/* loaded from: classes11.dex */
public interface c {
    void H(Context context, int i);

    SpannableString a(Context context, CharSequence charSequence, TextView textView);

    void a(Context context, String str, ImageView imageView, RequestOptions requestOptions);

    void a(Context context, String str, RequestOptions requestOptions, ImageView imageView);

    String cPZ();

    String cQd();

    void cQe();

    String cQf();

    void cQg();

    void e(Context context, int i, String str);

    void e(String str, Context context);

    void fD(Context context);

    String getUserId();

    void logout();

    void w(Context context, String str, String str2);
}
