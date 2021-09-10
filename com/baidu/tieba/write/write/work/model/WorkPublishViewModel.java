package com.baidu.tieba.write.write.work.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import c.a.q0.u.i;
import c.a.r0.j3.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bW\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0007J\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u0012J\u0015\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R\u001c\u0010\"\u001a\u00020\u00188\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R(\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u00102R(\u00104\u001a\b\u0012\u0004\u0012\u0002030&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010)\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R(\u00107\u001a\b\u0012\u0004\u0012\u00020\f0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010)\u001a\u0004\b8\u0010+\"\u0004\b9\u0010-R\"\u0010:\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010)\u001a\u0004\b@\u0010+\"\u0004\bA\u0010-R(\u0010C\u001a\b\u0012\u0004\u0012\u00020B0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010)\u001a\u0004\bD\u0010+\"\u0004\bE\u0010-R8\u0010H\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0Fj\b\u0012\u0004\u0012\u00020\f`G0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010)\u001a\u0004\bI\u0010+\"\u0004\bJ\u0010-R(\u0010K\u001a\b\u0012\u0004\u0012\u00020\f0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010)\u001a\u0004\bL\u0010+\"\u0004\bM\u0010-R8\u0010N\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0Fj\b\u0012\u0004\u0012\u00020\f`G0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010)\u001a\u0004\bO\u0010+\"\u0004\bP\u0010-R(\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001e0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010)\u001a\u0004\bR\u0010+\"\u0004\bS\u0010-R(\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00180&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010)\u001a\u0004\bU\u0010+\"\u0004\bV\u0010-¨\u0006X"}, d2 = {"Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "Landroidx/lifecycle/ViewModel;", "", "checkIsAllLegal", "()V", "", "checkIsClassAndTagLegal", "()Z", "checkIsTitleLegal", "checkIsVideoLegal", "checkIsVideoMixStatusLegal", "clearDraft", "", "generateDraftString", "()Ljava/lang/String;", "loadDraft", "json", "parseDataFromDraft", "(Ljava/lang/String;)V", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writeData", "parseWriteData", "(Lcom/baidu/tbadk/coreExtra/data/WriteData;)V", "saveDraft", "", "status", "updateMixStatus", "(I)V", "newTitle", "updateTitle", "Lcom/baidu/tbadk/coreExtra/data/VideoInfo;", "newVideo", "updateVideo", "(Lcom/baidu/tbadk/coreExtra/data/VideoInfo;)V", "STATE_SUCCESS", "I", "getSTATE_SUCCESS", "()I", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/tbadk/data/SelectForumData;", "barInfo", "Landroidx/lifecycle/MutableLiveData;", "getBarInfo", "()Landroidx/lifecycle/MutableLiveData;", "setBarInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "canChangeBarName", "Z", "getCanChangeBarName", "setCanChangeBarName", "(Z)V", "Lcom/baidu/tbadk/data/VideoCategoryClassData;", "classInfo", "getClassInfo", "setClassInfo", "desc", "getDesc", "setDesc", "intentBarInfo", "Lcom/baidu/tbadk/data/SelectForumData;", "getIntentBarInfo", "()Lcom/baidu/tbadk/data/SelectForumData;", "setIntentBarInfo", "(Lcom/baidu/tbadk/data/SelectForumData;)V", "isLegal", "setLegal", "Lcom/baidu/tieba/tbadkCore/location/ResponsedSelectLocation;", "posInfo", "getPosInfo", "setPosInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tagInfo", "getTagInfo", "setTagInfo", "title", "getTitle", "setTitle", "topicInfo", "getTopicInfo", "setTopicInfo", TbPreviewVideoActivityConfig.KEY_VIDEO_INFO, "getVideoInfo", "setVideoInfo", "videoMixStatus", "getVideoMixStatus", "setVideoMixStatus", "<init>", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class WorkPublishViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f59191a;

    /* renamed from: b  reason: collision with root package name */
    public MutableLiveData<VideoInfo> f59192b;

    /* renamed from: c  reason: collision with root package name */
    public MutableLiveData<Integer> f59193c;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<String> f59194d;

    /* renamed from: e  reason: collision with root package name */
    public MutableLiveData<String> f59195e;

    /* renamed from: f  reason: collision with root package name */
    public MutableLiveData<VideoCategoryClassData> f59196f;

    /* renamed from: g  reason: collision with root package name */
    public MutableLiveData<i> f59197g;

    /* renamed from: h  reason: collision with root package name */
    public i f59198h;

    /* renamed from: i  reason: collision with root package name */
    public MutableLiveData<ArrayList<String>> f59199i;

    /* renamed from: j  reason: collision with root package name */
    public MutableLiveData<ResponsedSelectLocation> f59200j;
    public MutableLiveData<ArrayList<String>> k;
    public MutableLiveData<Boolean> l;
    public boolean m;

    /* loaded from: classes8.dex */
    public static final class a implements y.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishViewModel f59201a;

        public a(WorkPublishViewModel workPublishViewModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishViewModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59201a = workPublishViewModel;
        }

        @Override // c.a.r0.j3.y.f
        public final void a(String it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                WorkPublishViewModel workPublishViewModel = this.f59201a;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                workPublishViewModel.parseDataFromDraft(it);
            }
        }
    }

    public WorkPublishViewModel() {
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
        this.f59191a = 2;
        this.f59192b = new MutableLiveData<>();
        this.f59193c = new MutableLiveData<>();
        this.f59194d = new MutableLiveData<>();
        this.f59195e = new MutableLiveData<>();
        this.f59196f = new MutableLiveData<>();
        this.f59197g = new MutableLiveData<>();
        this.f59198h = new i();
        this.f59199i = new MutableLiveData<>();
        this.f59200j = new MutableLiveData<>();
        this.k = new MutableLiveData<>();
        this.l = new MutableLiveData<>();
        this.m = true;
    }

    public final void checkIsAllLegal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l.setValue(Boolean.valueOf(checkIsTitleLegal() && checkIsVideoLegal()));
        }
    }

    public final boolean checkIsClassAndTagLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<String> value = this.k.getValue();
            if (!(value == null || value.isEmpty()) && this.f59196f.getValue() != null) {
                if (this.f59196f.getValue() != null) {
                    VideoCategoryClassData value2 = this.f59196f.getValue();
                    if (value2 == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(value2, "classInfo.value!!");
                    String firstClass = value2.getFirstClass();
                    if (!(firstClass == null || firstClass.length() == 0)) {
                        VideoCategoryClassData value3 = this.f59196f.getValue();
                        if (value3 == null) {
                            Intrinsics.throwNpe();
                        }
                        Intrinsics.checkExpressionValueIsNotNull(value3, "classInfo.value!!");
                        String secondClass = value3.getSecondClass();
                        if (secondClass == null || secondClass.length() == 0) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean checkIsTitleLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String value = this.f59194d.getValue();
            if (!(value == null || value.length() == 0)) {
                String value2 = this.f59194d.getValue();
                if (value2 == null) {
                    Intrinsics.throwNpe();
                }
                if (value2.length() >= 5) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean checkIsVideoLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59192b.getValue() != null && checkIsVideoMixStatusLegal() : invokeV.booleanValue;
    }

    public final boolean checkIsVideoMixStatusLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f59193c.getValue() == null) {
                return true;
            }
            if (this.f59193c.getValue() != null) {
                Integer value = this.f59193c.getValue();
                return value != null && value.intValue() == this.f59191a;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void clearDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            y.r("");
        }
    }

    public final String generateDraftString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mTitle", this.f59194d.getValue());
                jSONObject.put("mDesc", this.f59195e.getValue());
                jSONObject.put("mClass", this.f59196f.getValue());
                VideoCategoryClassData value = this.f59196f.getValue();
                jSONObject.put("mFirstClass", value != null ? value.getFirstClass() : null);
                VideoCategoryClassData value2 = this.f59196f.getValue();
                jSONObject.put("mSecondClass", value2 != null ? value2.getSecondClass() : null);
                JSONArray jSONArray = new JSONArray();
                if (this.k.getValue() != null) {
                    ArrayList<String> value3 = this.k.getValue();
                    if (value3 == null) {
                        Intrinsics.throwNpe();
                    }
                    Iterator<String> it = value3.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    jSONObject.put("mTag", jSONArray);
                }
                if (this.f59192b.getValue() != null) {
                    jSONObject.put("new_video_info", new Gson().toJson(this.f59192b.getValue()));
                }
                if (this.f59197g.getValue() != null) {
                    i value4 = this.f59197g.getValue();
                    jSONObject.put("forum_id", value4 != null ? value4.f15029a : null);
                    i value5 = this.f59197g.getValue();
                    jSONObject.put("forum_name", value5 != null ? value5.f15031c : null);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "jsonObject.toString()");
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public final MutableLiveData<i> getBarInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f59197g : (MutableLiveData) invokeV.objValue;
    }

    public final boolean getCanChangeBarName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public final MutableLiveData<VideoCategoryClassData> getClassInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f59196f : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<String> getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f59195e : (MutableLiveData) invokeV.objValue;
    }

    public final i getIntentBarInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f59198h : (i) invokeV.objValue;
    }

    public final MutableLiveData<ResponsedSelectLocation> getPosInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f59200j : (MutableLiveData) invokeV.objValue;
    }

    public final int getSTATE_SUCCESS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f59191a : invokeV.intValue;
    }

    public final MutableLiveData<ArrayList<String>> getTagInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.k : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<String> getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f59194d : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<ArrayList<String>> getTopicInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f59199i : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<VideoInfo> getVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f59192b : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Integer> getVideoMixStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f59193c : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Boolean> isLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.l : (MutableLiveData) invokeV.objValue;
    }

    public final void loadDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            y.j(new a(this));
        }
    }

    public final void parseDataFromDraft(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            try {
                this.f59194d.setValue(jSONObject.optString("mTitle"));
                this.f59195e.setValue(jSONObject.optString("mDesc"));
                VideoCategoryClassData videoCategoryClassData = new VideoCategoryClassData();
                videoCategoryClassData.setFirstClass(jSONObject.optString("mFirstClass"));
                videoCategoryClassData.setSecondClass(jSONObject.optString("mSecondClass"));
                this.f59196f.setValue(videoCategoryClassData);
                String optString = jSONObject.optString("new_video_info");
                Intrinsics.checkExpressionValueIsNotNull(optString, "jsonObject.optString(VideoInfo.DRAFT_JSON_NAME)");
                if (!TextUtils.isEmpty(optString)) {
                    this.f59192b.setValue(new Gson().fromJson(optString, (Class<Object>) VideoInfo.class));
                }
                i iVar = new i();
                iVar.f15029a = jSONObject.optString("forum_id");
                iVar.f15031c = jSONObject.optString("forum_name");
                if (this.f59198h != null && !this.m) {
                    this.f59197g.setValue(this.f59198h);
                } else {
                    this.f59197g.setValue(iVar);
                }
                if (jSONObject.optJSONArray("mTag") != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("mTag");
                    Intrinsics.checkExpressionValueIsNotNull(optJSONArray, "jsonObject.optJSONArray(\"mTag\")");
                    ArrayList<String> arrayList = new ArrayList<>();
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        arrayList.add(optJSONArray.getString(i2));
                    }
                    this.k.setValue(arrayList);
                }
                checkIsAllLegal();
            } catch (JSONException unused) {
            }
        }
    }

    public final void parseWriteData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, writeData) == null) {
            this.f59194d.setValue(writeData.getTitle());
            this.f59195e.setValue(writeData.getContent());
            this.f59192b.setValue(writeData.getVideoInfo());
            VideoCategoryClassData videoCategoryClassData = new VideoCategoryClassData();
            VideoCategoryClassData classAndTagData = writeData.getClassAndTagData();
            Intrinsics.checkExpressionValueIsNotNull(classAndTagData, "writeData.classAndTagData");
            videoCategoryClassData.setFirstClass(classAndTagData.getFirstClass());
            VideoCategoryClassData classAndTagData2 = writeData.getClassAndTagData();
            Intrinsics.checkExpressionValueIsNotNull(classAndTagData2, "writeData.classAndTagData");
            videoCategoryClassData.setSecondClass(classAndTagData2.getSecondClass());
            this.f59196f.setValue(videoCategoryClassData);
            MutableLiveData<ArrayList<String>> mutableLiveData = this.k;
            VideoCategoryClassData classAndTagData3 = writeData.getClassAndTagData();
            Intrinsics.checkExpressionValueIsNotNull(classAndTagData3, "writeData.classAndTagData");
            mutableLiveData.setValue(classAndTagData3.getTags());
            i iVar = new i();
            iVar.f15029a = writeData.getForumId();
            iVar.f15031c = writeData.getForumName();
            this.f59197g.setValue(iVar);
            checkIsAllLegal();
        }
    }

    public final void saveDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            y.r(generateDraftString());
        }
    }

    public final void setBarInfo(MutableLiveData<i> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, mutableLiveData) == null) {
            this.f59197g = mutableLiveData;
        }
    }

    public final void setCanChangeBarName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.m = z;
        }
    }

    public final void setClassInfo(MutableLiveData<VideoCategoryClassData> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, mutableLiveData) == null) {
            this.f59196f = mutableLiveData;
        }
    }

    public final void setDesc(MutableLiveData<String> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, mutableLiveData) == null) {
            this.f59195e = mutableLiveData;
        }
    }

    public final void setIntentBarInfo(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, iVar) == null) {
            this.f59198h = iVar;
        }
    }

    public final void setLegal(MutableLiveData<Boolean> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, mutableLiveData) == null) {
            this.l = mutableLiveData;
        }
    }

    public final void setPosInfo(MutableLiveData<ResponsedSelectLocation> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, mutableLiveData) == null) {
            this.f59200j = mutableLiveData;
        }
    }

    public final void setTagInfo(MutableLiveData<ArrayList<String>> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, mutableLiveData) == null) {
            this.k = mutableLiveData;
        }
    }

    public final void setTitle(MutableLiveData<String> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, mutableLiveData) == null) {
            this.f59194d = mutableLiveData;
        }
    }

    public final void setTopicInfo(MutableLiveData<ArrayList<String>> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, mutableLiveData) == null) {
            this.f59199i = mutableLiveData;
        }
    }

    public final void setVideoInfo(MutableLiveData<VideoInfo> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, mutableLiveData) == null) {
            this.f59192b = mutableLiveData;
        }
    }

    public final void setVideoMixStatus(MutableLiveData<Integer> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, mutableLiveData) == null) {
            this.f59193c = mutableLiveData;
        }
    }

    public final void updateMixStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.f59193c.setValue(Integer.valueOf(i2));
            checkIsAllLegal();
        }
    }

    public final void updateTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.f59194d.setValue(str);
            checkIsAllLegal();
        }
    }

    public final void updateVideo(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, videoInfo) == null) {
            this.f59192b.setValue(videoInfo);
            checkIsAllLegal();
        }
    }
}
