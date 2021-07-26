package com.baidu.ufosdk.ui;

import android.graphics.BitmapFactory;
import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class x implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f23851a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f23852b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f23853c;

    public x(FeedbackEditActivity feedbackEditActivity, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23853c = feedbackEditActivity;
        this.f23851a = str;
        this.f23852b = i2;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0059: IGET  (r2v1 int A[REMOVE]) = (r4v0 'this' com.baidu.ufosdk.ui.x A[IMMUTABLE_TYPE, THIS]) com.baidu.ufosdk.ui.x.b int)] */
    @Override // java.lang.Runnable
    public final void run() {
        byte[] b2;
        HashMap hashMap;
        HashMap hashMap2;
        Handler handler;
        List list;
        List list2;
        List list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.baidu.ufosdk.f.c.c(" --*^o^*-- return : " + this.f23851a);
            b2 = FeedbackEditActivity.b(BitmapFactory.decodeFile(this.f23851a));
            if (b2 == null || b2.length == 0) {
                return;
            }
            try {
                list = this.f23853c.q;
                if (list.size() == 0) {
                    list3 = this.f23853c.q;
                    list3.add(b2);
                } else {
                    list2 = this.f23853c.q;
                    list2.set(this.f23852b, b2);
                }
            } catch (Exception e2) {
                com.baidu.ufosdk.f.c.a("arrayList error in readBitmapFromFile!", e2);
            }
            hashMap = this.f23853c.r;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f23852b);
            hashMap.put(sb.toString(), this.f23851a);
            StringBuilder sb2 = new StringBuilder("*^o^*-- picPathMap.size : ");
            hashMap2 = this.f23853c.r;
            sb2.append(hashMap2.size());
            com.baidu.ufosdk.f.c.c(sb2.toString());
            handler = this.f23853c.af;
            handler.obtainMessage(17).sendToTarget();
        }
    }
}
