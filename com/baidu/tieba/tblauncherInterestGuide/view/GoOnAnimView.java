package com.baidu.tieba.tblauncherInterestGuide.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class GoOnAnimView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f36278b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f36279c;

    /* renamed from: d  reason: collision with root package name */
    public int f36280d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f36281e;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GoOnAnimView a;

        public a(GoOnAnimView goOnAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {goOnAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = goOnAnimView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                this.a.f36280d %= 4;
                int i = this.a.f36280d;
                if (i == 0) {
                    this.a.a.setImageResource(R.drawable.obfuscated_res_0x7f080f58);
                    this.a.f36278b.setImageResource(R.drawable.obfuscated_res_0x7f080f57);
                    this.a.f36279c.setImageResource(R.drawable.obfuscated_res_0x7f080f56);
                } else if (i == 1) {
                    this.a.a.setImageResource(R.drawable.obfuscated_res_0x7f080f57);
                    this.a.f36278b.setImageResource(R.drawable.obfuscated_res_0x7f080f56);
                    this.a.f36279c.setImageResource(R.drawable.obfuscated_res_0x7f080f58);
                } else if (i == 2) {
                    this.a.a.setImageResource(R.drawable.obfuscated_res_0x7f080f56);
                    this.a.f36278b.setImageResource(R.drawable.obfuscated_res_0x7f080f58);
                    this.a.f36279c.setImageResource(R.drawable.obfuscated_res_0x7f080f57);
                } else if (i == 3) {
                    this.a.a.setImageResource(R.drawable.obfuscated_res_0x7f080f57);
                    this.a.f36278b.setImageResource(R.drawable.obfuscated_res_0x7f080f57);
                    this.a.f36279c.setImageResource(R.drawable.obfuscated_res_0x7f080f57);
                }
                GoOnAnimView.c(this.a);
                this.a.f36281e.removeMessages(0);
                this.a.f36281e.sendEmptyMessageDelayed(0, 300L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoOnAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36281e = new a(this);
        h(context);
    }

    public static /* synthetic */ int c(GoOnAnimView goOnAnimView) {
        int i = goOnAnimView.f36280d;
        goOnAnimView.f36280d = i + 1;
        return i;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0388, (ViewGroup) null, false);
            this.a = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f092015);
            this.f36278b = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f092016);
            this.f36279c = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f092017);
            this.a.setImageResource(R.drawable.obfuscated_res_0x7f080f58);
            this.f36278b.setImageResource(R.drawable.obfuscated_res_0x7f080f57);
            this.f36279c.setImageResource(R.drawable.obfuscated_res_0x7f080f56);
            addView(linearLayout);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f36281e.removeMessages(0);
            ImageView imageView = this.a;
            if (imageView != null) {
                imageView.setImageDrawable(null);
            }
            ImageView imageView2 = this.f36278b;
            if (imageView2 != null) {
                imageView2.setImageDrawable(null);
            }
            ImageView imageView3 = this.f36279c;
            if (imageView3 != null) {
                imageView3.setImageDrawable(null);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f36281e.removeMessages(0);
            this.f36281e.sendEmptyMessage(0);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f36281e.removeMessages(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoOnAnimView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36281e = new a(this);
        h(context);
    }
}
