package com.baidu.wallet.fastpay.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class GetTrafficFaceResponse implements IBeanResponse, Serializable {
    public static final long serialVersionUID = -9111183651727955558L;
    public TrafficUserModel billAccount;
    public ContentDto contentDto;
    public TrafficFaceModel[][] dmts;
    public String showMsg = "";
    public String defaultDmt = "";

    /* loaded from: classes5.dex */
    public static class ContentDto implements NoProguard, Serializable {
        public static final long serialVersionUID = 4162913658702268232L;
        public String content = "";
        public String imgUrl = "";
        public String url = "";
        public String smallImgUrl = "";
    }

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public String f23978b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f23979c = "";

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<TrafficFaceModel> f23980d;

        public a() {
        }

        public void a(String str) {
            this.f23978b = str;
        }

        public void b(String str) {
            this.f23979c = str;
        }

        public void a(ArrayList<TrafficFaceModel> arrayList) {
            this.f23980d = arrayList;
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    public String getMobile() {
        TrafficUserModel trafficUserModel = this.billAccount;
        return trafficUserModel != null ? trafficUserModel.getExpressMobile() : "";
    }

    public String getProvider() {
        TrafficUserModel trafficUserModel = this.billAccount;
        return (trafficUserModel == null || TextUtils.isEmpty(trafficUserModel.province)) ? "" : this.billAccount.provider;
    }

    public String getProvince() {
        TrafficUserModel trafficUserModel = this.billAccount;
        return (trafficUserModel == null || TextUtils.isEmpty(trafficUserModel.province)) ? "" : this.billAccount.province;
    }

    public String getPublicTip() {
        TrafficUserModel trafficUserModel = this.billAccount;
        return trafficUserModel != null ? trafficUserModel.publicTip : "";
    }

    public ArrayList<a> getTrafficFaceChangedInfo() {
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
                    a aVar = new a();
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

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
