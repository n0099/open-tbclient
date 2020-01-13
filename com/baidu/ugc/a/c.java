package com.baidu.ugc.a;

import android.content.Context;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.request.RequestOptions;
/* loaded from: classes12.dex */
public interface c {
    void I(Context context, int i);

    SpannableString a(Context context, CharSequence charSequence, TextView textView);

    void a(Context context, String str, ImageView imageView, RequestOptions requestOptions);

    void a(Context context, String str, RequestOptions requestOptions, ImageView imageView);

    String cRc();

    String cRg();

    void cRh();

    String cRi();

    void cRj();

    void e(Context context, int i, String str);

    void e(String str, Context context);

    void fE(Context context);

    String getUserId();

    void logout();

    void w(Context context, String str, String str2);
}
