package com.baidu.ufosdk;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.NoUnderlineSpan;
/* loaded from: classes7.dex */
public class j1 extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public TextView b;
    public TextView c;
    public View d;
    public TextView e;
    public Context f;
    public String g;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j1 a;

        public a(j1 j1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public String b;

        public b(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setPackage(c.a());
                intent.setData(Uri.parse(this.b));
                this.a.startActivity(intent);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(Context context, boolean z) {
        super(context, com.baidu.tieba.R.style.obfuscated_res_0x7f10042e);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = "https://mbd.baidu.com/newspage/data/landingshare?context=%7B%22nid%22%3A%22news_9309125611591740777%22%2C%22sourceFrom%22%3A%22bjh%22%2C%22url_data%22%3A%22bjhauthor%22%7D";
        a(context, z);
    }

    public final void a(Context context, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) {
            this.f = context;
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            getWindow().setGravity(17);
            setContentView(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0924);
            LinearLayout linearLayout = (LinearLayout) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091dae);
            this.a = linearLayout;
            if (z) {
                i = com.baidu.tieba.R.drawable.obfuscated_res_0x7f0804c9;
            } else {
                i = com.baidu.tieba.R.drawable.obfuscated_res_0x7f0804c8;
            }
            linearLayout.setBackgroundResource(i);
            TextView textView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091daf);
            this.b = textView;
            int i5 = -13421773;
            if (z) {
                i2 = -11711155;
            } else {
                i2 = -13421773;
            }
            textView.setTextColor(i2);
            TextView textView2 = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091dad);
            this.c = textView2;
            SpannableString spannableString = new SpannableString(this.f.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f0528));
            spannableString.setSpan(new ForegroundColorSpan(-16776961), 51, 64, 33);
            spannableString.setSpan(new b(this.f, this.g), 51, 64, 33);
            textView2.setText(spannableString);
            TextView textView3 = this.c;
            if (z) {
                i3 = -11711155;
            } else {
                i3 = -6710887;
            }
            textView3.setTextColor(i3);
            this.c.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView4 = this.c;
            CharSequence text = textView4.getText();
            if (text instanceof Spannable) {
                ((Spannable) textView4.getText()).setSpan(new NoUnderlineSpan(), 0, text.length(), 17);
            }
            View findViewById = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0908c1);
            this.d = findViewById;
            if (z) {
                i4 = -13619152;
            } else {
                i4 = BdThumbSeekBarView.BUFFERING_PAINT_COLOR;
            }
            findViewById.setBackgroundColor(i4);
            TextView textView5 = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0911ab);
            this.e = textView5;
            if (z) {
                i5 = -11711155;
            }
            textView5.setTextColor(i5);
            this.e.setOnClickListener(new a(this));
        }
    }
}
