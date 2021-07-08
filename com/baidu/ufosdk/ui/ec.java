package com.baidu.ufosdk.ui;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class ec implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f23595a;

    public ec(FeedbackReportActivity feedbackReportActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackReportActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23595a = feedbackReportActivity;
    }

    @Override // com.baidu.ufosdk.ui.d
    public final void a(ArrayList arrayList, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        Button button;
        String str;
        Button button2;
        Button button3;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        byte[] bArr;
        TextView textView;
        List list;
        byte[] bArr2;
        TextView textView2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        TextView textView3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, arrayList, i2) == null) {
            this.f23595a.p = i2;
            i3 = this.f23595a.p;
            if (i3 == 1) {
                this.f23595a.q = true;
                linearLayout4 = this.f23595a.o;
                linearLayout4.setVisibility(0);
                SpannableString spannableString = new SpannableString("上传截图*(请上传该视频在其他平台带发布时间的截图)");
                spannableString.setSpan(new ForegroundColorSpan(com.baidu.ufosdk.b.K), 4, 5, 34);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 5, 26, 34);
                spannableString.setSpan(new AbsoluteSizeSpan(12, true), 5, 26, 34);
                textView3 = this.f23595a.r;
                textView3.setText(spannableString);
            }
            i4 = this.f23595a.p;
            if (i4 == 2) {
                linearLayout3 = this.f23595a.O;
                linearLayout3.setVisibility(0);
            }
            i5 = this.f23595a.p;
            if (i5 == 3) {
                this.f23595a.q = false;
                linearLayout2 = this.f23595a.o;
                linearLayout2.setVisibility(8);
                SpannableString spannableString2 = new SpannableString("问题截图（系统自动截取）");
                spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 4, spannableString2.length(), 34);
                spannableString2.setSpan(new AbsoluteSizeSpan(12, true), 4, spannableString2.length(), 34);
                bArr = this.f23595a.j;
                if (bArr != null) {
                    list = this.f23595a.x;
                    bArr2 = this.f23595a.j;
                    if (list.contains(bArr2)) {
                        textView2 = this.f23595a.r;
                        textView2.setText(spannableString2);
                    }
                }
                textView = this.f23595a.r;
                textView.setText("上传截图");
            }
            i6 = this.f23595a.p;
            if (i6 == 4) {
                linearLayout = this.f23595a.O;
                linearLayout.setVisibility(8);
            }
            com.baidu.ufosdk.f.c.a("CheckGroup回调函数：selectedData.size() = " + arrayList.size());
            if (arrayList.size() > 0) {
                button3 = this.f23595a.m;
                int i7 = com.baidu.ufosdk.b.v;
                int i8 = com.baidu.ufosdk.b.y;
                int i9 = com.baidu.ufosdk.b.v;
                button3.setTextColor(com.baidu.ufosdk.f.i.a(i7, i8, i9, i9));
            } else {
                button = this.f23595a.m;
                button.setTextColor(com.baidu.ufosdk.b.y);
            }
            if (arrayList.contains("播放问题")) {
                str = this.f23595a.F;
                if (str.length() <= 0) {
                    button2 = this.f23595a.m;
                    button2.setTextColor(com.baidu.ufosdk.b.y);
                }
            }
        }
    }
}
