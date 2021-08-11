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
/* loaded from: classes7.dex */
public class GoOnAnimView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f57049e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f57050f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57051g;

    /* renamed from: h  reason: collision with root package name */
    public int f57052h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f57053i;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GoOnAnimView f57054a;

        public a(GoOnAnimView goOnAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {goOnAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57054a = goOnAnimView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                this.f57054a.f57052h %= 4;
                int i2 = this.f57054a.f57052h;
                if (i2 == 0) {
                    this.f57054a.f57049e.setImageResource(R.drawable.pic_startpage1_next_3);
                    this.f57054a.f57050f.setImageResource(R.drawable.pic_startpage1_next_2);
                    this.f57054a.f57051g.setImageResource(R.drawable.pic_startpage1_next_1);
                } else if (i2 == 1) {
                    this.f57054a.f57049e.setImageResource(R.drawable.pic_startpage1_next_2);
                    this.f57054a.f57050f.setImageResource(R.drawable.pic_startpage1_next_1);
                    this.f57054a.f57051g.setImageResource(R.drawable.pic_startpage1_next_3);
                } else if (i2 == 2) {
                    this.f57054a.f57049e.setImageResource(R.drawable.pic_startpage1_next_1);
                    this.f57054a.f57050f.setImageResource(R.drawable.pic_startpage1_next_3);
                    this.f57054a.f57051g.setImageResource(R.drawable.pic_startpage1_next_2);
                } else if (i2 == 3) {
                    this.f57054a.f57049e.setImageResource(R.drawable.pic_startpage1_next_2);
                    this.f57054a.f57050f.setImageResource(R.drawable.pic_startpage1_next_2);
                    this.f57054a.f57051g.setImageResource(R.drawable.pic_startpage1_next_2);
                }
                GoOnAnimView.c(this.f57054a);
                this.f57054a.f57053i.removeMessages(0);
                this.f57054a.f57053i.sendEmptyMessageDelayed(0, 300L);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57053i = new a(this);
        h(context);
    }

    public static /* synthetic */ int c(GoOnAnimView goOnAnimView) {
        int i2 = goOnAnimView.f57052h;
        goOnAnimView.f57052h = i2 + 1;
        return i2;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.go_on_anim, (ViewGroup) null, false);
            this.f57049e = (ImageView) linearLayout.findViewById(R.id.tip_go_on_1);
            this.f57050f = (ImageView) linearLayout.findViewById(R.id.tip_go_on_2);
            this.f57051g = (ImageView) linearLayout.findViewById(R.id.tip_go_on_3);
            this.f57049e.setImageResource(R.drawable.pic_startpage1_next_3);
            this.f57050f.setImageResource(R.drawable.pic_startpage1_next_2);
            this.f57051g.setImageResource(R.drawable.pic_startpage1_next_1);
            addView(linearLayout);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f57053i.removeMessages(0);
            ImageView imageView = this.f57049e;
            if (imageView != null) {
                imageView.setImageDrawable(null);
            }
            ImageView imageView2 = this.f57050f;
            if (imageView2 != null) {
                imageView2.setImageDrawable(null);
            }
            ImageView imageView3 = this.f57051g;
            if (imageView3 != null) {
                imageView3.setImageDrawable(null);
            }
        }
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f57053i.removeMessages(0);
            this.f57053i.sendEmptyMessage(0);
        }
    }

    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f57053i.removeMessages(0);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57053i = new a(this);
        h(context);
    }
}
