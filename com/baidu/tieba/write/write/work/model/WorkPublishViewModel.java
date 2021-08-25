package com.baidu.tieba.write.write.work.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import c.a.p0.u.i;
import c.a.p0.u.n;
import c.a.q0.i3.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bL\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0007J\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u0012J\u0015\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R\u001c\u0010\"\u001a\u00020\u00188\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R(\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u0010/\u001a\b\u0012\u0004\u0012\u00020.0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R(\u00102\u001a\b\u0012\u0004\u0012\u00020\f0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010)\u001a\u0004\b3\u0010+\"\u0004\b4\u0010-R(\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010)\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R(\u00108\u001a\b\u0012\u0004\u0012\u0002070&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010)\u001a\u0004\b9\u0010+\"\u0004\b:\u0010-R8\u0010=\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0;j\b\u0012\u0004\u0012\u00020\f`<0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010)\u001a\u0004\b>\u0010+\"\u0004\b?\u0010-R(\u0010@\u001a\b\u0012\u0004\u0012\u00020\f0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010)\u001a\u0004\bA\u0010+\"\u0004\bB\u0010-R8\u0010C\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0;j\b\u0012\u0004\u0012\u00020\f`<0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010)\u001a\u0004\bD\u0010+\"\u0004\bE\u0010-R(\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001e0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010)\u001a\u0004\bG\u0010+\"\u0004\bH\u0010-R(\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00180&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010)\u001a\u0004\bJ\u0010+\"\u0004\bK\u0010-¨\u0006M"}, d2 = {"Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "Landroidx/lifecycle/ViewModel;", "", "checkIsAllLegal", "()V", "", "checkIsClassAndTagLegal", "()Z", "checkIsTitleLegal", "checkIsVideoLegal", "checkIsVideoMixStatusLegal", "clearDraft", "", "generateDraftString", "()Ljava/lang/String;", "loadDraft", "json", "parseDataFromDraft", "(Ljava/lang/String;)V", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writeData", "parseWriteData", "(Lcom/baidu/tbadk/coreExtra/data/WriteData;)V", "saveDraft", "", "status", "updateMixStatus", "(I)V", "newTitle", "updateTitle", "Lcom/baidu/tbadk/coreExtra/data/VideoInfo;", "newVideo", "updateVideo", "(Lcom/baidu/tbadk/coreExtra/data/VideoInfo;)V", "STATE_SUCCESS", "I", "getSTATE_SUCCESS", "()I", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/tbadk/data/SelectForumData;", "barInfo", "Landroidx/lifecycle/MutableLiveData;", "getBarInfo", "()Landroidx/lifecycle/MutableLiveData;", "setBarInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "Lcom/baidu/tbadk/data/VideoCategoryClassData;", "classInfo", "getClassInfo", "setClassInfo", "desc", "getDesc", "setDesc", "isLegal", "setLegal", "Lcom/baidu/tieba/tbadkCore/location/ResponsedSelectLocation;", "posInfo", "getPosInfo", "setPosInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tagInfo", "getTagInfo", "setTagInfo", "title", "getTitle", "setTitle", "topicInfo", "getTopicInfo", "setTopicInfo", TbPreviewVideoActivityConfig.KEY_VIDEO_INFO, "getVideoInfo", "setVideoInfo", "videoMixStatus", "getVideoMixStatus", "setVideoMixStatus", "<init>", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class WorkPublishViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f59012a;

    /* renamed from: b  reason: collision with root package name */
    public MutableLiveData<VideoInfo> f59013b;

    /* renamed from: c  reason: collision with root package name */
    public MutableLiveData<Integer> f59014c;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<String> f59015d;

    /* renamed from: e  reason: collision with root package name */
    public MutableLiveData<String> f59016e;

    /* renamed from: f  reason: collision with root package name */
    public MutableLiveData<n> f59017f;

    /* renamed from: g  reason: collision with root package name */
    public MutableLiveData<i> f59018g;

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<ArrayList<String>> f59019h;

    /* renamed from: i  reason: collision with root package name */
    public MutableLiveData<ResponsedSelectLocation> f59020i;

    /* renamed from: j  reason: collision with root package name */
    public MutableLiveData<ArrayList<String>> f59021j;
    public MutableLiveData<Boolean> k;

    /* loaded from: classes7.dex */
    public static final class a implements y.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishViewModel f59022a;

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
            this.f59022a = workPublishViewModel;
        }

        @Override // c.a.q0.i3.y.f
        public final void a(String it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                WorkPublishViewModel workPublishViewModel = this.f59022a;
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
        this.f59012a = 2;
        this.f59013b = new MutableLiveData<>();
        this.f59014c = new MutableLiveData<>();
        this.f59015d = new MutableLiveData<>();
        this.f59016e = new MutableLiveData<>();
        this.f59017f = new MutableLiveData<>();
        this.f59018g = new MutableLiveData<>();
        this.f59019h = new MutableLiveData<>();
        this.f59020i = new MutableLiveData<>();
        this.f59021j = new MutableLiveData<>();
        this.k = new MutableLiveData<>();
    }

    public final void checkIsAllLegal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.setValue(Boolean.valueOf(checkIsTitleLegal() && checkIsVideoLegal() && checkIsClassAndTagLegal()));
        }
    }

    public final boolean checkIsClassAndTagLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<String> value = this.f59021j.getValue();
            if (!(value == null || value.isEmpty()) && this.f59017f.getValue() != null) {
                if (this.f59017f.getValue() != null) {
                    n value2 = this.f59017f.getValue();
                    if (value2 == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(value2, "classInfo.value!!");
                    String a2 = value2.a();
                    if (!(a2 == null || a2.length() == 0)) {
                        n value3 = this.f59017f.getValue();
                        if (value3 == null) {
                            Intrinsics.throwNpe();
                        }
                        Intrinsics.checkExpressionValueIsNotNull(value3, "classInfo.value!!");
                        String b2 = value3.b();
                        if (b2 == null || b2.length() == 0) {
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
            String value = this.f59015d.getValue();
            if (!(value == null || value.length() == 0)) {
                String value2 = this.f59015d.getValue();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59013b.getValue() != null && checkIsVideoMixStatusLegal() : invokeV.booleanValue;
    }

    public final boolean checkIsVideoMixStatusLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f59014c.getValue() == null) {
                return true;
            }
            if (this.f59014c.getValue() != null) {
                Integer value = this.f59014c.getValue();
                return value != null && value.intValue() == this.f59012a;
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
                jSONObject.put("mTitle", this.f59015d.getValue());
                jSONObject.put("mDesc", this.f59016e.getValue());
                if (this.f59013b.getValue() != null) {
                    jSONObject.put("new_video_info", new Gson().toJson(this.f59013b.getValue()));
                }
                if (this.f59018g.getValue() != null) {
                    i value = this.f59018g.getValue();
                    jSONObject.put("forum_id", value != null ? value.f15024a : null);
                    i value2 = this.f59018g.getValue();
                    jSONObject.put("forum_name", value2 != null ? value2.f15026c : null);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f59018g : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<n> getClassInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f59017f : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<String> getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f59016e : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<ResponsedSelectLocation> getPosInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f59020i : (MutableLiveData) invokeV.objValue;
    }

    public final int getSTATE_SUCCESS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f59012a : invokeV.intValue;
    }

    public final MutableLiveData<ArrayList<String>> getTagInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f59021j : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<String> getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f59015d : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<ArrayList<String>> getTopicInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f59019h : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<VideoInfo> getVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f59013b : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Integer> getVideoMixStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f59014c : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Boolean> isLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.k : (MutableLiveData) invokeV.objValue;
    }

    public final void loadDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            y.j(new a(this));
        }
    }

    public final void parseDataFromDraft(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            try {
                this.f59015d.setValue(jSONObject.optString("mTitle"));
                this.f59016e.setValue(jSONObject.optString("mDesc"));
                String optString = jSONObject.optString("new_video_info");
                Intrinsics.checkExpressionValueIsNotNull(optString, "jsonObject.optString(VideoInfo.DRAFT_JSON_NAME)");
                if (!TextUtils.isEmpty(optString)) {
                    this.f59013b.setValue(new Gson().fromJson(optString, (Class<Object>) VideoInfo.class));
                }
                i iVar = new i();
                iVar.f15024a = jSONObject.optString("forum_id");
                iVar.f15026c = jSONObject.optString("forum_name");
                this.f59018g.setValue(iVar);
                checkIsAllLegal();
            } catch (JSONException unused) {
            }
        }
    }

    public final void parseWriteData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, writeData) == null) {
            this.f59015d.setValue(writeData.getTitle());
            this.f59016e.setValue(writeData.getContent());
            this.f59013b.setValue(writeData.getVideoInfo());
            i iVar = new i();
            iVar.f15024a = writeData.getForumId();
            iVar.f15026c = writeData.getForumName();
            this.f59018g.setValue(iVar);
            checkIsAllLegal();
        }
    }

    public final void saveDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            y.r(generateDraftString());
        }
    }

    public final void setBarInfo(MutableLiveData<i> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, mutableLiveData) == null) {
            this.f59018g = mutableLiveData;
        }
    }

    public final void setClassInfo(MutableLiveData<n> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, mutableLiveData) == null) {
            this.f59017f = mutableLiveData;
        }
    }

    public final void setDesc(MutableLiveData<String> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, mutableLiveData) == null) {
            this.f59016e = mutableLiveData;
        }
    }

    public final void setLegal(MutableLiveData<Boolean> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, mutableLiveData) == null) {
            this.k = mutableLiveData;
        }
    }

    public final void setPosInfo(MutableLiveData<ResponsedSelectLocation> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, mutableLiveData) == null) {
            this.f59020i = mutableLiveData;
        }
    }

    public final void setTagInfo(MutableLiveData<ArrayList<String>> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, mutableLiveData) == null) {
            this.f59021j = mutableLiveData;
        }
    }

    public final void setTitle(MutableLiveData<String> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, mutableLiveData) == null) {
            this.f59015d = mutableLiveData;
        }
    }

    public final void setTopicInfo(MutableLiveData<ArrayList<String>> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, mutableLiveData) == null) {
            this.f59019h = mutableLiveData;
        }
    }

    public final void setVideoInfo(MutableLiveData<VideoInfo> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, mutableLiveData) == null) {
            this.f59013b = mutableLiveData;
        }
    }

    public final void setVideoMixStatus(MutableLiveData<Integer> mutableLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, mutableLiveData) == null) {
            this.f59014c = mutableLiveData;
        }
    }

    public final void updateMixStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.f59014c.setValue(Integer.valueOf(i2));
            checkIsAllLegal();
        }
    }

    public final void updateTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.f59015d.setValue(str);
            checkIsAllLegal();
        }
    }

    public final void updateVideo(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, videoInfo) == null) {
            this.f59013b.setValue(videoInfo);
            checkIsAllLegal();
        }
    }
}
