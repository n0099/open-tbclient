package com.baidu.tieba;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zzj;
/* loaded from: classes6.dex */
public final class tn9 implements Parcelable.Creator<zzj> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tn9() {
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
    public final /* bridge */ /* synthetic */ zzj createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int i = 0;
        while (parcel.dataPosition() < q) {
            int k = SafeParcelReader.k(parcel);
            int h = SafeParcelReader.h(k);
            if (h == 1) {
                bundle = SafeParcelReader.a(parcel, k);
            } else if (h == 2) {
                featureArr = (Feature[]) SafeParcelReader.f(parcel, k, Feature.CREATOR);
            } else if (h == 3) {
                i = SafeParcelReader.m(parcel, k);
            } else if (h != 4) {
                SafeParcelReader.p(parcel, k);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) SafeParcelReader.c(parcel, k, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        SafeParcelReader.g(parcel, q);
        return new zzj(bundle, featureArr, i, connectionTelemetryConfiguration);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj[] newArray(int i) {
        return new zzj[i];
    }
}
