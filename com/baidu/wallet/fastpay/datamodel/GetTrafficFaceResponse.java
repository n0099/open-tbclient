package com.baidu.wallet.fastpay.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class GetTrafficFaceResponse implements IBeanResponse, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -9111183651727955558L;
    public transient /* synthetic */ FieldHolder $fh;
    public TrafficUserModel billAccount;
    public ContentDto contentDto;
    public String defaultDmt;
    public TrafficFaceModel[][] dmts;
    public String showMsg;

    /* loaded from: classes8.dex */
    public static class ContentDto implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4162913658702268232L;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public String imgUrl;
        public String smallImgUrl;
        public String url;

        public ContentDto() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.content = "";
            this.imgUrl = "";
            this.url = "";
            this.smallImgUrl = "";
        }
    }

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetTrafficFaceResponse f61068a;

        /* renamed from: b  reason: collision with root package name */
        public String f61069b;

        /* renamed from: c  reason: collision with root package name */
        public String f61070c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<TrafficFaceModel> f61071d;

        public a(GetTrafficFaceResponse getTrafficFaceResponse) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {getTrafficFaceResponse};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61068a = getTrafficFaceResponse;
            this.f61069b = "";
            this.f61070c = "";
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f61069b = str;
            }
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f61070c = str;
            }
        }

        public void a(ArrayList<TrafficFaceModel> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                this.f61071d = arrayList;
            }
        }
    }

    public GetTrafficFaceResponse() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.showMsg = "";
        this.defaultDmt = "";
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public String getMobile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TrafficUserModel trafficUserModel = this.billAccount;
            return trafficUserModel != null ? trafficUserModel.getExpressMobile() : "";
        }
        return (String) invokeV.objValue;
    }

    public String getProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TrafficUserModel trafficUserModel = this.billAccount;
            return (trafficUserModel == null || TextUtils.isEmpty(trafficUserModel.province)) ? "" : this.billAccount.provider;
        }
        return (String) invokeV.objValue;
    }

    public String getProvince() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TrafficUserModel trafficUserModel = this.billAccount;
            return (trafficUserModel == null || TextUtils.isEmpty(trafficUserModel.province)) ? "" : this.billAccount.province;
        }
        return (String) invokeV.objValue;
    }

    public String getPublicTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TrafficUserModel trafficUserModel = this.billAccount;
            return trafficUserModel != null ? trafficUserModel.publicTip : "";
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<a> getTrafficFaceChangedInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<a> arrayList = new ArrayList<>();
            TrafficFaceModel[][] trafficFaceModelArr = this.dmts;
            if (trafficFaceModelArr != null && trafficFaceModelArr.length > 0) {
                int i2 = 0;
                while (true) {
                    TrafficFaceModel[][] trafficFaceModelArr2 = this.dmts;
                    if (i2 >= trafficFaceModelArr2.length) {
                        break;
                    }
                    TrafficFaceModel[] trafficFaceModelArr3 = trafficFaceModelArr2[i2];
                    if (trafficFaceModelArr3 != null && trafficFaceModelArr3.length > 0) {
                        a aVar = new a(this);
                        ArrayList<TrafficFaceModel> arrayList2 = new ArrayList<>();
                        String str = "";
                        for (int i3 = 0; i3 < trafficFaceModelArr3.length; i3++) {
                            if (trafficFaceModelArr3[i3] != null) {
                                arrayList2.add(trafficFaceModelArr3[i3]);
                                if (!TextUtils.isEmpty(trafficFaceModelArr3[i3].getHuiIcon())) {
                                    str = trafficFaceModelArr3[i3].getHuiIcon();
                                }
                            }
                        }
                        aVar.a(trafficFaceModelArr3[0].denomination);
                        aVar.a(arrayList2);
                        aVar.b(str);
                        arrayList.add(aVar);
                    }
                    i2++;
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
        }
    }
}
