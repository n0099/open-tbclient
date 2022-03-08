package com.baidu.tieba.recapp.lego.model;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class FormCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BG_SIZE_FULL_SCALE = 2;
    public static final int BG_SIZE_WIDTH_SCALE = 1;
    public static final int FORM_DEFAULT_TYPE = -1;
    public static final int HEIGHT_DEFAULT_SIZE = 1334;
    public static final int TYPE_COMMIT_INFO = 2;
    public static final int TYPE_EDIT_MULTI_LINE_INFO = 4;
    public static final int TYPE_EDIT_PHONE_INFO = 5;
    public static final int TYPE_EDIT_SINGLE_LINE_INFO = 3;
    public static final int TYPE_PICKER_COMMON_INFO = 6;
    public static final int TYPE_PICKER_DATE_INFO = 7;
    public static final int TYPE_PICKER_TIME_INFO = 8;
    public static final int TYPE_TITLE_INFO = 1;
    public static final int WIDTH_DEFAULT_SIZE = 750;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo appInfo;
    public final a backgroundInfo;
    public final c commitInfo;
    public final List<b> itemList;
    public final int mHeight;
    public boolean mIsCommitSuccess;
    public final boolean mIsLegal;
    public final int mWidth;
    public String[] result;
    public final f resultInfo;
    public final g titleInfo;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f46097b;

        /* renamed from: c  reason: collision with root package name */
        public int f46098c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f46099b;

        /* renamed from: c  reason: collision with root package name */
        public String f46100c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f46101d;

        /* renamed from: e  reason: collision with root package name */
        public String f46102e;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f46103d;

        /* renamed from: e  reason: collision with root package name */
        public h f46104e;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String[] f46105d;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f46106b;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f46107d;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        JSONObject jSONObject2;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSONObject) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int i4 = 0;
        this.mIsCommitSuccess = false;
        if (jSONObject == null) {
            this.itemList = null;
            this.titleInfo = null;
            this.commitInfo = null;
            this.resultInfo = null;
            this.backgroundInfo = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mIsLegal = false;
            return;
        }
        this.mIsLegal = true;
        this.itemList = new ArrayList();
        this.mWidth = jSONObject.optInt("width", 750);
        this.mHeight = jSONObject.optInt("height", HEIGHT_DEFAULT_SIZE);
        JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.WearableExtender.KEY_BACKGROUND);
        int i5 = -1;
        if (optJSONObject != null) {
            a aVar = new a();
            this.backgroundInfo = aVar;
            aVar.a = optJSONObject.optString("img", "");
            this.backgroundInfo.f46097b = optJSONObject.optString("color", "");
            this.backgroundInfo.f46098c = optJSONObject.optInt("mode", -1);
        } else {
            this.backgroundInfo = null;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
        if (optJSONObject2 != null) {
            f fVar = new f();
            this.resultInfo = fVar;
            fVar.a = optJSONObject2.optString("title", "");
            this.resultInfo.f46106b = optJSONObject2.optString("desc", "");
        } else {
            this.resultInfo = null;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("commit_info");
        if (optJSONObject3 != null) {
            c cVar = new c();
            this.commitInfo = cVar;
            cVar.a = optJSONObject3.optInt("type", -1);
            this.commitInfo.f46102e = optJSONObject3.optString("post_url", "");
            this.commitInfo.f46099b = optJSONObject3.optString("content", "");
            this.commitInfo.f46101d = optJSONObject3.optString("check_str", "");
            this.commitInfo.f46100c = optJSONObject3.optString("tag", "");
        } else {
            this.commitInfo = null;
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("title_info");
        if (optJSONObject4 != null) {
            g gVar = new g();
            this.titleInfo = gVar;
            gVar.a = optJSONObject4.optInt("type", -1);
            this.titleInfo.f46099b = optJSONObject4.optString("content", "");
            this.titleInfo.f46100c = optJSONObject4.optString("tag", "");
        } else {
            this.titleInfo = null;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("item_list");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            int i6 = 0;
            while (i6 < optJSONArray.length()) {
                JSONObject jSONObject3 = optJSONArray.getJSONObject(i6);
                if (jSONObject3 != null) {
                    int optInt = jSONObject3.optInt("type", i5);
                    switch (optInt) {
                        case 1:
                            g gVar2 = new g();
                            gVar2.a = optInt;
                            gVar2.f46099b = jSONObject3.optString("content", "");
                            gVar2.f46100c = jSONObject3.optString("tag", "");
                            c.a.r0.z1.o.k.a.a(this.itemList, gVar2);
                            continue;
                        case 2:
                            c cVar2 = new c();
                            cVar2.a = optInt;
                            cVar2.f46099b = jSONObject3.optString("content", "");
                            cVar2.f46101d = jSONObject3.optString("check_str", "");
                            cVar2.f46102e = jSONObject3.optString("post_url", "");
                            cVar2.f46100c = jSONObject3.optString("tag", "");
                            c.a.r0.z1.o.k.a.a(this.itemList, cVar2);
                            continue;
                        case 3:
                        case 4:
                        case 5:
                            d dVar = new d();
                            dVar.a = optInt;
                            dVar.f46099b = jSONObject3.optString("content", "");
                            dVar.f46100c = jSONObject3.optString("tag", "");
                            dVar.f46103d = jSONObject3.optString("reg_str", "");
                            if (jSONObject3.has("veri_code_info") && (jSONObject2 = jSONObject3.getJSONObject("veri_code_info")) != null) {
                                h hVar = new h();
                                hVar.f46099b = jSONObject2.optString("content");
                                hVar.f46107d = jSONObject2.optString("btn_title");
                                hVar.f46100c = jSONObject2.optString("tag");
                                dVar.f46104e = hVar;
                            }
                            c.a.r0.z1.o.k.a.a(this.itemList, dVar);
                            continue;
                        case 6:
                        case 7:
                        case 8:
                            e eVar = new e();
                            eVar.a = optInt;
                            eVar.f46100c = jSONObject3.optString("tag", "");
                            eVar.f46099b = jSONObject3.optString("content", "");
                            eVar.f46100c = jSONObject3.optString("tag", "");
                            if (jSONObject3.has("list") && (jSONArray = jSONObject3.getJSONArray("list")) != null && jSONArray.length() > 0) {
                                String[] strArr = new String[jSONArray.length()];
                                while (i4 < jSONArray.length()) {
                                    strArr[i4] = jSONArray.getString(i4);
                                    i4++;
                                }
                                eVar.f46105d = strArr;
                            }
                            c.a.r0.z1.o.k.a.a(this.itemList, eVar);
                            continue;
                        default:
                            continue;
                    }
                }
                i6++;
                i4 = 0;
                i5 = -1;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean checkIsAppAdvert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean forFree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public AdvertAppInfo getAdvertAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.appInfo : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public c.a.q0.r.r.c getAppInfoModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (c.a.q0.r.r.c) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getDownloadKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getExtInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AdvertAppInfo advertAppInfo = this.appInfo;
            if (advertAppInfo == null) {
                return null;
            }
            return advertAppInfo.n4;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AdvertAppInfo advertAppInfo = this.appInfo;
            if (advertAppInfo != null) {
                return advertAppInfo.i4;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.mWidth;
            if (i2 > 0) {
                return this.mHeight / i2;
            }
            return super.getRatio();
        }
        return invokeV.doubleValue;
    }

    public boolean isCommitSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mIsCommitSuccess : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean responseAttention(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, advertAppInfo) == null) {
            this.appInfo = advertAppInfo;
        }
    }

    public void setCommitState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mIsCommitSuccess = z;
        }
    }
}
