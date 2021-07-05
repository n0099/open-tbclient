package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view, boolean z, boolean z2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{view, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || view == null || (view2 = (View) view.getTag()) == null) {
            return;
        }
        String str = (z2 || z) ? "wallet_base_height_separator_line_focus" : "wallet_base_height_separator_line";
        view2.setBackgroundColor(ResUtils.getColor(view.getContext(), !z ? z2 ? "wallet_base_separator_color_focus" : "wallet_base_separator_color" : "wallet_base_font_fa5050"));
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.height = (int) ResUtils.getDimension(view.getContext(), str);
        view2.setLayoutParams(layoutParams);
    }

    public static void a(ViewGroup viewGroup, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65537, null, viewGroup, charSequence, charSequence2, charSequence3) == null) && (viewGroup instanceof ViewGroup)) {
            if (charSequence == null) {
                viewGroup.setVisibility(8);
                return;
            }
            Context context = viewGroup.getContext();
            TextView textView = (TextView) viewGroup.findViewById(ResUtils.id(context, "wallet_bind_card_subtitle_sec2"));
            TextView textView2 = (TextView) viewGroup.findViewById(ResUtils.id(context, "wallet_bind_card_subtitle_sec3"));
            ((TextView) viewGroup.findViewById(ResUtils.id(context, "wallet_bind_card_subtitle_sec1"))).setText(charSequence);
            if (TextUtils.isEmpty(charSequence2)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(charSequence2);
            }
            if (TextUtils.isEmpty(charSequence3)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(charSequence3);
            }
            viewGroup.setVisibility(0);
        }
    }
}
