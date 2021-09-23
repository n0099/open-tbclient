package com.baidu.ufosdk.ui;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public final class r implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f60093a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f60094b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f60095c;

    public r(FeedbackEditActivity feedbackEditActivity, int i2, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity, Integer.valueOf(i2), jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60095c = feedbackEditActivity;
        this.f60093a = i2;
        this.f60094b = jVar;
    }

    @Override // com.baidu.ufosdk.ui.l
    public final void a() {
        HashMap hashMap;
        List list;
        List list2;
        HashMap hashMap2;
        List list3;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        List list4;
        HashMap hashMap6;
        List list5;
        HashMap hashMap7;
        HashMap hashMap8;
        HashMap hashMap9;
        HashMap hashMap10;
        HashMap hashMap11;
        HashMap hashMap12;
        HashMap hashMap13;
        HashMap hashMap14;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.baidu.ufosdk.f.c.a("DeleteConfirmDialog --> confirm clicked!");
            int i2 = this.f60093a;
            if (i2 == 1) {
                list4 = this.f60095c.q;
                int size = list4.size();
                if (size == 1) {
                    hashMap6 = this.f60095c.r;
                    hashMap6.remove("0");
                } else if (size == 2) {
                    hashMap7 = this.f60095c.r;
                    hashMap8 = this.f60095c.r;
                    hashMap7.put("0", hashMap8.get("1"));
                    hashMap9 = this.f60095c.r;
                    hashMap9.remove("1");
                } else if (size == 3) {
                    hashMap10 = this.f60095c.r;
                    hashMap11 = this.f60095c.r;
                    hashMap10.put("0", hashMap11.get("1"));
                    hashMap12 = this.f60095c.r;
                    hashMap13 = this.f60095c.r;
                    hashMap12.put("1", hashMap13.get("2"));
                    hashMap14 = this.f60095c.r;
                    hashMap14.remove("2");
                }
                list5 = this.f60095c.q;
                list5.remove(0);
            } else if (i2 == 2) {
                list2 = this.f60095c.q;
                int size2 = list2.size();
                if (size2 == 2) {
                    hashMap2 = this.f60095c.r;
                    hashMap2.remove("1");
                } else if (size2 == 3) {
                    hashMap3 = this.f60095c.r;
                    hashMap4 = this.f60095c.r;
                    hashMap3.put("1", hashMap4.get("2"));
                    hashMap5 = this.f60095c.r;
                    hashMap5.remove("2");
                }
                list3 = this.f60095c.q;
                list3.remove(1);
            } else {
                hashMap = this.f60095c.r;
                hashMap.remove("2");
                list = this.f60095c.q;
                list.remove(2);
            }
            this.f60095c.b();
            this.f60094b.dismiss();
        }
    }

    @Override // com.baidu.ufosdk.ui.l
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.baidu.ufosdk.f.c.a("DeleteConfirmDialog --> cancel clicked!");
            this.f60094b.dismiss();
        }
    }
}
