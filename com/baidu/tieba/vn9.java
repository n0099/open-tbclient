package com.baidu.tieba;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes6.dex */
public final class vn9 implements Parcelable.Creator<GetServiceRequest> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vn9() {
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

    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, getServiceRequest, parcel, i) == null) {
            int a = jn9.a(parcel);
            jn9.g(parcel, 1, getServiceRequest.zza);
            jn9.g(parcel, 2, getServiceRequest.zzb);
            jn9.g(parcel, 3, getServiceRequest.zzc);
            jn9.k(parcel, 4, getServiceRequest.zzd, false);
            jn9.f(parcel, 5, getServiceRequest.zze, false);
            jn9.m(parcel, 6, getServiceRequest.zzf, i, false);
            jn9.d(parcel, 7, getServiceRequest.zzg, false);
            jn9.j(parcel, 8, getServiceRequest.zzh, i, false);
            jn9.m(parcel, 10, getServiceRequest.zzi, i, false);
            jn9.m(parcel, 11, getServiceRequest.zzj, i, false);
            jn9.c(parcel, 12, getServiceRequest.zzk);
            jn9.g(parcel, 13, getServiceRequest.zzl);
            jn9.c(parcel, 14, getServiceRequest.zzm);
            jn9.k(parcel, 15, getServiceRequest.zza(), false);
            jn9.b(parcel, a);
        }
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GetServiceRequest createFromParcel(Parcel parcel) {
        int q = SafeParcelReader.q(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        String str2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < q) {
            int k = SafeParcelReader.k(parcel);
            switch (SafeParcelReader.h(k)) {
                case 1:
                    i = SafeParcelReader.m(parcel, k);
                    break;
                case 2:
                    i2 = SafeParcelReader.m(parcel, k);
                    break;
                case 3:
                    i3 = SafeParcelReader.m(parcel, k);
                    break;
                case 4:
                    str = SafeParcelReader.d(parcel, k);
                    break;
                case 5:
                    iBinder = SafeParcelReader.l(parcel, k);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.f(parcel, k, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.a(parcel, k);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.c(parcel, k, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.p(parcel, k);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.f(parcel, k, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.f(parcel, k, Feature.CREATOR);
                    break;
                case 12:
                    z = SafeParcelReader.i(parcel, k);
                    break;
                case 13:
                    i4 = SafeParcelReader.m(parcel, k);
                    break;
                case 14:
                    z2 = SafeParcelReader.i(parcel, k);
                    break;
                case 15:
                    str2 = SafeParcelReader.d(parcel, k);
                    break;
            }
        }
        SafeParcelReader.g(parcel, q);
        return new GetServiceRequest(i, i2, i3, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z, i4, z2, str2);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
