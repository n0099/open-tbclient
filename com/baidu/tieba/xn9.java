package com.baidu.tieba;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class xn9 implements Parcelable.Creator<WakeLockEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xn9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < q) {
            int k = SafeParcelReader.k(parcel);
            switch (SafeParcelReader.h(k)) {
                case 1:
                    i = SafeParcelReader.m(parcel, k);
                    break;
                case 2:
                    j = SafeParcelReader.n(parcel, k);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    SafeParcelReader.p(parcel, k);
                    break;
                case 4:
                    str = SafeParcelReader.d(parcel, k);
                    break;
                case 5:
                    i3 = SafeParcelReader.m(parcel, k);
                    break;
                case 6:
                    arrayList = SafeParcelReader.e(parcel, k);
                    break;
                case 8:
                    j2 = SafeParcelReader.n(parcel, k);
                    break;
                case 10:
                    str3 = SafeParcelReader.d(parcel, k);
                    break;
                case 11:
                    i2 = SafeParcelReader.m(parcel, k);
                    break;
                case 12:
                    str2 = SafeParcelReader.d(parcel, k);
                    break;
                case 13:
                    str4 = SafeParcelReader.d(parcel, k);
                    break;
                case 14:
                    i4 = SafeParcelReader.m(parcel, k);
                    break;
                case 15:
                    f = SafeParcelReader.j(parcel, k);
                    break;
                case 16:
                    j3 = SafeParcelReader.n(parcel, k);
                    break;
                case 17:
                    str5 = SafeParcelReader.d(parcel, k);
                    break;
                case 18:
                    z = SafeParcelReader.i(parcel, k);
                    break;
            }
        }
        SafeParcelReader.g(parcel, q);
        return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f, j3, str5, z);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
