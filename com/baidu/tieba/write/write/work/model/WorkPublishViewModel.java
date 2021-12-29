package com.baidu.tieba.write.write.work.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import c.a.t0.w3.a0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.write.write.work.model.WorkPublishViewModel;
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
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020\u000fJ\u0006\u0010E\u001a\u00020\u000fJ\u0006\u0010F\u001a\u00020\u000fJ\u0006\u0010G\u001a\u00020\u000fJ\u0006\u0010H\u001a\u00020CJ\u0006\u0010I\u001a\u00020\u0019J\u0006\u0010J\u001a\u00020CJ\u000e\u0010K\u001a\u00020C2\u0006\u0010L\u001a\u00020\u0019J\u000e\u0010M\u001a\u00020C2\u0006\u0010N\u001a\u00020OJ\u0006\u0010P\u001a\u00020CJ\u000e\u0010Q\u001a\u00020C2\u0006\u0010R\u001a\u00020\u0004J\u0016\u0010S\u001a\u00020C2\u0006\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u0004J\u000e\u0010V\u001a\u00020C2\u0006\u0010W\u001a\u00020<R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\rR\u001a\u0010\u001c\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\rR \u0010#\u001a\b\u0012\u0004\u0012\u00020$0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000b\"\u0004\b&\u0010\rR0\u0010'\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00190(j\b\u0012\u0004\u0012\u00020\u0019`)0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010\rR \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\rR\u001a\u0010/\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R0\u00108\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00190(j\b\u0012\u0004\u0012\u00020\u0019`)0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010\rR \u0010;\u001a\b\u0012\u0004\u0012\u00020<0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000b\"\u0004\b>\u0010\rR \u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000b\"\u0004\bA\u0010\r¨\u0006X"}, d2 = {"Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "STATE_SUCCESS", "", "getSTATE_SUCCESS", "()I", "barInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/tbadk/data/SelectForumData;", "getBarInfo", "()Landroidx/lifecycle/MutableLiveData;", "setBarInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "canChangeBarName", "", "getCanChangeBarName", "()Z", "setCanChangeBarName", "(Z)V", "classInfo", "Lcom/baidu/tbadk/data/VideoCategoryClassData;", "getClassInfo", "setClassInfo", "desc", "", "getDesc", "setDesc", "intentBarInfo", "getIntentBarInfo", "()Lcom/baidu/tbadk/data/SelectForumData;", "setIntentBarInfo", "(Lcom/baidu/tbadk/data/SelectForumData;)V", "isLegal", "setLegal", "posInfo", "Lcom/baidu/tieba/tbadkCore/location/ResponsedSelectLocation;", "getPosInfo", "setPosInfo", "tagInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTagInfo", "setTagInfo", "title", "getTitle", "setTitle", "titleLength", "getTitleLength", "setTitleLength", "(I)V", "topicFromLastPage", "getTopicFromLastPage", "()Ljava/lang/String;", "setTopicFromLastPage", "(Ljava/lang/String;)V", "topicInfo", "getTopicInfo", "setTopicInfo", TbPreviewVideoActivityConfig.KEY_VIDEO_INFO, "Lcom/baidu/tbadk/coreExtra/data/VideoInfo;", "getVideoInfo", "setVideoInfo", "videoMixStatus", "getVideoMixStatus", "setVideoMixStatus", "checkIsAllLegal", "", "checkIsClassAndTagLegal", "checkIsTitleLegal", "checkIsVideoLegal", "checkIsVideoMixStatusLegal", "clearDraft", "generateDraftString", "loadDraft", "parseDataFromDraft", "json", "parseWriteData", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "saveDraft", "updateMixStatus", "status", "updateTitle", "newTitle", "newTitleLength", "updateVideo", "newVideo", "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class WorkPublishViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public MutableLiveData<VideoInfo> f51949b;

    /* renamed from: c  reason: collision with root package name */
    public MutableLiveData<Integer> f51950c;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<String> f51951d;

    /* renamed from: e  reason: collision with root package name */
    public String f51952e;

    /* renamed from: f  reason: collision with root package name */
    public MutableLiveData<String> f51953f;

    /* renamed from: g  reason: collision with root package name */
    public MutableLiveData<VideoCategoryClassData> f51954g;

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<SelectForumData> f51955h;

    /* renamed from: i  reason: collision with root package name */
    public SelectForumData f51956i;

    /* renamed from: j  reason: collision with root package name */
    public MutableLiveData<ArrayList<String>> f51957j;

    /* renamed from: k  reason: collision with root package name */
    public MutableLiveData<ResponsedSelectLocation> f51958k;
    public MutableLiveData<ArrayList<String>> l;
    public MutableLiveData<Boolean> m;
    public boolean n;
    public int o;

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
        this.a = 2;
        this.f51949b = new MutableLiveData<>();
        this.f51950c = new MutableLiveData<>();
        this.f51951d = new MutableLiveData<>();
        this.f51952e = "";
        this.f51953f = new MutableLiveData<>();
        this.f51954g = new MutableLiveData<>();
        this.f51955h = new MutableLiveData<>();
        this.f51956i = new SelectForumData();
        this.f51957j = new MutableLiveData<>();
        this.f51958k = new MutableLiveData<>();
        this.l = new MutableLiveData<>();
        this.m = new MutableLiveData<>();
        this.n = true;
    }

    public static final void a(WorkPublishViewModel this$0, String it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.parseDataFromDraft(it);
        }
    }

    public final void checkIsAllLegal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.m.setValue(Boolean.valueOf(checkIsTitleLegal() && checkIsVideoLegal()));
        }
    }

    public final boolean checkIsClassAndTagLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<String> value = this.l.getValue();
            if (!(value == null || value.isEmpty()) && this.f51954g.getValue() != null) {
                if (this.f51954g.getValue() != null) {
                    VideoCategoryClassData value2 = this.f51954g.getValue();
                    Intrinsics.checkNotNull(value2);
                    String firstClass = value2.getFirstClass();
                    if (!(firstClass == null || firstClass.length() == 0)) {
                        VideoCategoryClassData value3 = this.f51954g.getValue();
                        Intrinsics.checkNotNull(value3);
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String value = this.f51951d.getValue();
            return !(value == null || value.length() == 0) && (i2 = this.o) >= 5 && i2 <= 80;
        }
        return invokeV.booleanValue;
    }

    public final boolean checkIsVideoLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51949b.getValue() != null && checkIsVideoMixStatusLegal() : invokeV.booleanValue;
    }

    public final boolean checkIsVideoMixStatusLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f51950c.getValue() == null) {
                return true;
            }
            if (this.f51950c.getValue() != null) {
                Integer value = this.f51950c.getValue();
                return value != null && value.intValue() == this.a;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void clearDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a0.u("");
        }
    }

    public final String generateDraftString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mTitle", this.f51951d.getValue());
                jSONObject.put("mDesc", this.f51953f.getValue());
                jSONObject.put("mClass", this.f51954g.getValue());
                VideoCategoryClassData value = this.f51954g.getValue();
                String str = null;
                jSONObject.put("mFirstClass", value == null ? null : value.getFirstClass());
                VideoCategoryClassData value2 = this.f51954g.getValue();
                jSONObject.put("mSecondClass", value2 == null ? null : value2.getSecondClass());
                JSONArray jSONArray = new JSONArray();
                if (this.l.getValue() != null) {
                    ArrayList<String> value3 = this.l.getValue();
                    Intrinsics.checkNotNull(value3);
                    Iterator<String> it = value3.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    jSONObject.put("mTag", jSONArray);
                }
                if (this.f51949b.getValue() != null) {
                    jSONObject.put("new_video_info", new Gson().toJson(this.f51949b.getValue()));
                }
                if (this.f51955h.getValue() != null) {
                    SelectForumData value4 = this.f51955h.getValue();
                    jSONObject.put("forum_id", value4 == null ? null : value4.forumId);
                    SelectForumData value5 = this.f51955h.getValue();
                    if (value5 != null) {
                        str = value5.forumName;
                    }
                    jSONObject.put("forum_name", str);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public final MutableLiveData<SelectForumData> getBarInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f51955h : (MutableLiveData) invokeV.objValue;
    }

    public final boolean getCanChangeBarName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final MutableLiveData<VideoCategoryClassData> getClassInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f51954g : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<String> getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f51953f : (MutableLiveData) invokeV.objValue;
    }

    public final SelectForumData getIntentBarInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f51956i : (SelectForumData) invokeV.objValue;
    }

    public final MutableLiveData<ResponsedSelectLocation> getPosInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f51958k : (MutableLiveData) invokeV.objValue;
    }

    public final int getSTATE_SUCCESS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : invokeV.intValue;
    }

    public final MutableLiveData<ArrayList<String>> getTagInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.l : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<String> getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f51951d : (MutableLiveData) invokeV.objValue;
    }

    public final int getTitleLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.o : invokeV.intValue;
    }

    public final String getTopicFromLastPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f51952e : (String) invokeV.objValue;
    }

    public final MutableLiveData<ArrayList<String>> getTopicInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f51957j : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<VideoInfo> getVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f51949b : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Integer> getVideoMixStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f51950c : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Boolean> isLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.m : (MutableLiveData) invokeV.objValue;
    }

    public final void loadDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            a0.l(new a0.f() { // from class: c.a.t0.o4.e0.p.y.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.t0.w3.a0.f
                public final void a(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        WorkPublishViewModel.a(WorkPublishViewModel.this, str);
                    }
                }
            });
        }
    }

    public final void parseDataFromDraft(String json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            JSONObject jSONObject = new JSONObject(json);
            try {
                this.f51951d.setValue(jSONObject.optString("mTitle"));
                this.f51953f.setValue(jSONObject.optString("mDesc"));
                VideoCategoryClassData videoCategoryClassData = new VideoCategoryClassData();
                videoCategoryClassData.setFirstClass(jSONObject.optString("mFirstClass"));
                videoCategoryClassData.setSecondClass(jSONObject.optString("mSecondClass"));
                this.f51954g.setValue(videoCategoryClassData);
                String optString = jSONObject.optString("new_video_info");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(VideoInfo.DRAFT_JSON_NAME)");
                if (!TextUtils.isEmpty(optString)) {
                    this.f51949b.setValue(new Gson().fromJson(optString, (Class<Object>) VideoInfo.class));
                }
                SelectForumData selectForumData = new SelectForumData();
                selectForumData.forumId = jSONObject.optString("forum_id");
                selectForumData.forumName = jSONObject.optString("forum_name");
                if (this.f51956i != null && !this.n) {
                    this.f51955h.setValue(this.f51956i);
                } else {
                    this.f51955h.setValue(selectForumData);
                }
                if (jSONObject.optJSONArray("mTag") != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("mTag");
                    Intrinsics.checkNotNullExpressionValue(optJSONArray, "jsonObject.optJSONArray(\"mTag\")");
                    ArrayList<String> arrayList = new ArrayList<>();
                    int i2 = 0;
                    int length = optJSONArray.length();
                    if (length > 0) {
                        while (true) {
                            int i3 = i2 + 1;
                            arrayList.add(optJSONArray.getString(i2));
                            if (i3 >= length) {
                                break;
                            }
                            i2 = i3;
                        }
                    }
                    this.l.setValue(arrayList);
                }
                checkIsAllLegal();
            } catch (JSONException unused) {
            }
        }
    }

    public final void parseWriteData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, writeData) == null) {
            Intrinsics.checkNotNullParameter(writeData, "writeData");
            this.f51951d.setValue(writeData.getTitle());
            this.f51953f.setValue(writeData.getContent());
            this.f51949b.setValue(writeData.getVideoInfo());
            VideoCategoryClassData videoCategoryClassData = new VideoCategoryClassData();
            videoCategoryClassData.setFirstClass(writeData.getClassAndTagData().getFirstClass());
            videoCategoryClassData.setSecondClass(writeData.getClassAndTagData().getSecondClass());
            this.f51954g.setValue(videoCategoryClassData);
            this.l.setValue(writeData.getClassAndTagData().getTags());
            SelectForumData selectForumData = new SelectForumData();
            selectForumData.forumId = writeData.getForumId();
            selectForumData.forumName = writeData.getForumName();
            this.f51955h.setValue(selectForumData);
            checkIsAllLegal();
        }
    }

    public final void saveDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            a0.u(generateDraftString());
        }
    }

    public final void setBarInfo(MutableLiveData<SelectForumData> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, mutableLiveData) == null) {
            Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
            this.f51955h = mutableLiveData;
        }
    }

    public final void setCanChangeBarName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.n = z;
        }
    }

    public final void setClassInfo(MutableLiveData<VideoCategoryClassData> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, mutableLiveData) == null) {
            Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
            this.f51954g = mutableLiveData;
        }
    }

    public final void setDesc(MutableLiveData<String> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, mutableLiveData) == null) {
            Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
            this.f51953f = mutableLiveData;
        }
    }

    public final void setIntentBarInfo(SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, selectForumData) == null) {
            Intrinsics.checkNotNullParameter(selectForumData, "<set-?>");
            this.f51956i = selectForumData;
        }
    }

    public final void setLegal(MutableLiveData<Boolean> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, mutableLiveData) == null) {
            Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
            this.m = mutableLiveData;
        }
    }

    public final void setPosInfo(MutableLiveData<ResponsedSelectLocation> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, mutableLiveData) == null) {
            Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
            this.f51958k = mutableLiveData;
        }
    }

    public final void setTagInfo(MutableLiveData<ArrayList<String>> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, mutableLiveData) == null) {
            Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
            this.l = mutableLiveData;
        }
    }

    public final void setTitle(MutableLiveData<String> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, mutableLiveData) == null) {
            Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
            this.f51951d = mutableLiveData;
        }
    }

    public final void setTitleLength(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.o = i2;
        }
    }

    public final void setTopicFromLastPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f51952e = str;
        }
    }

    public final void setTopicInfo(MutableLiveData<ArrayList<String>> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, mutableLiveData) == null) {
            Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
            this.f51957j = mutableLiveData;
        }
    }

    public final void setVideoInfo(MutableLiveData<VideoInfo> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, mutableLiveData) == null) {
            Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
            this.f51949b = mutableLiveData;
        }
    }

    public final void setVideoMixStatus(MutableLiveData<Integer> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, mutableLiveData) == null) {
            Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
            this.f51950c = mutableLiveData;
        }
    }

    public final void updateMixStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.f51950c.setValue(Integer.valueOf(i2));
            checkIsAllLegal();
        }
    }

    public final void updateTitle(String newTitle, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048617, this, newTitle, i2) == null) {
            Intrinsics.checkNotNullParameter(newTitle, "newTitle");
            this.f51951d.setValue(newTitle);
            this.o = i2;
            checkIsAllLegal();
        }
    }

    public final void updateVideo(VideoInfo newVideo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, newVideo) == null) {
            Intrinsics.checkNotNullParameter(newVideo, "newVideo");
            this.f51949b.setValue(newVideo);
            checkIsAllLegal();
        }
    }
}
