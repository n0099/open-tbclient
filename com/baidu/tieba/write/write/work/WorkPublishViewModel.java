package com.baidu.tieba.write.write.work;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
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
import d.a.o0.t.j;
import d.a.p0.h3.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u0015\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u0011J\u0015\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u00020\u00178\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R(\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R(\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010(\u001a\u0004\b0\u0010*\"\u0004\b1\u0010,R(\u00103\u001a\b\u0012\u0004\u0012\u0002020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010(\u001a\u0004\b4\u0010*\"\u0004\b5\u0010,R(\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010(\u001a\u0004\b7\u0010*\"\u0004\b8\u0010,R(\u00109\u001a\b\u0012\u0004\u0012\u00020\u001d0%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010(\u001a\u0004\b:\u0010*\"\u0004\b;\u0010,R(\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00170%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010(\u001a\u0004\b=\u0010*\"\u0004\b>\u0010,¨\u0006@"}, d2 = {"Lcom/baidu/tieba/write/write/work/WorkPublishViewModel;", "Landroidx/lifecycle/ViewModel;", "", "checkIsAllLegal", "()V", "", "checkIsTitleLegal", "()Z", "checkIsVideoLegal", "checkIsVideoMixStatusLegal", "clearDraft", "", "generateDraftString", "()Ljava/lang/String;", "loadDraft", "json", "parseDataFromDraft", "(Ljava/lang/String;)V", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writeData", "parseWriteData", "(Lcom/baidu/tbadk/coreExtra/data/WriteData;)V", "saveDraft", "", "status", "updateMixStatus", "(I)V", "newTitle", "updateTitle", "Lcom/baidu/tbadk/coreExtra/data/VideoInfo;", "newVideo", "updateVideo", "(Lcom/baidu/tbadk/coreExtra/data/VideoInfo;)V", "STATE_SUCCESS", "I", "getSTATE_SUCCESS", "()I", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/tbadk/data/SelectForumData;", "barInfo", "Landroidx/lifecycle/MutableLiveData;", "getBarInfo", "()Landroidx/lifecycle/MutableLiveData;", "setBarInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "desc", "getDesc", "setDesc", "isLegal", "setLegal", "Lcom/baidu/tieba/tbadkCore/location/ResponsedSelectLocation;", "posInfo", "getPosInfo", "setPosInfo", "title", "getTitle", "setTitle", TbPreviewVideoActivityConfig.KEY_VIDEO_INFO, "getVideoInfo", "setVideoInfo", "videoMixStatus", "getVideoMixStatus", "setVideoMixStatus", "<init>", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class WorkPublishViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f22989a;

    /* renamed from: b  reason: collision with root package name */
    public MutableLiveData<VideoInfo> f22990b;

    /* renamed from: c  reason: collision with root package name */
    public MutableLiveData<Integer> f22991c;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<String> f22992d;

    /* renamed from: e  reason: collision with root package name */
    public MutableLiveData<String> f22993e;

    /* renamed from: f  reason: collision with root package name */
    public MutableLiveData<j> f22994f;

    /* renamed from: g  reason: collision with root package name */
    public MutableLiveData<ResponsedSelectLocation> f22995g;

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<Boolean> f22996h;

    /* loaded from: classes4.dex */
    public static final class a implements y.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishViewModel f22997a;

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
            this.f22997a = workPublishViewModel;
        }

        @Override // d.a.p0.h3.y.f
        public final void a(String it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                WorkPublishViewModel workPublishViewModel = this.f22997a;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                workPublishViewModel.n(it);
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
        this.f22989a = 2;
        this.f22990b = new MutableLiveData<>();
        this.f22991c = new MutableLiveData<>();
        this.f22992d = new MutableLiveData<>();
        this.f22993e = new MutableLiveData<>();
        this.f22994f = new MutableLiveData<>();
        this.f22995g = new MutableLiveData<>();
        this.f22996h = new MutableLiveData<>();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22996h.setValue(Boolean.valueOf(b() && c()));
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String value = this.f22992d.getValue();
            if (!(value == null || value.length() == 0)) {
                String value2 = this.f22992d.getValue();
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

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22990b.getValue() != null && d() : invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f22991c.getValue() == null) {
                return true;
            }
            if (this.f22991c.getValue() != null) {
                Integer value = this.f22991c.getValue();
                return value != null && value.intValue() == this.f22989a;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            y.r("");
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mTitle", this.f22992d.getValue());
                jSONObject.put("mDesc", this.f22993e.getValue());
                if (this.f22990b.getValue() != null) {
                    jSONObject.put("new_video_info", new Gson().toJson(this.f22990b.getValue()));
                }
                if (this.f22994f.getValue() != null) {
                    j value = this.f22994f.getValue();
                    jSONObject.put("forum_id", value != null ? value.f53429a : null);
                    j value2 = this.f22994f.getValue();
                    jSONObject.put("forum_name", value2 != null ? value2.f53431c : null);
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

    public final MutableLiveData<j> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22994f : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22993e : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<ResponsedSelectLocation> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22995g : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22992d : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<VideoInfo> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f22990b : (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Boolean> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f22996h : (MutableLiveData) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            y.j(new a(this));
        }
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            try {
                this.f22992d.setValue(jSONObject.optString("mTitle"));
                this.f22993e.setValue(jSONObject.optString("mDesc"));
                String optString = jSONObject.optString("new_video_info");
                Intrinsics.checkExpressionValueIsNotNull(optString, "jsonObject.optString(VideoInfo.DRAFT_JSON_NAME)");
                if (!TextUtils.isEmpty(optString)) {
                    this.f22990b.setValue(new Gson().fromJson(optString, (Class<Object>) VideoInfo.class));
                }
                j jVar = new j();
                jVar.f53429a = jSONObject.optString("forum_id");
                jVar.f53431c = jSONObject.optString("forum_name");
                this.f22994f.setValue(jVar);
                a();
            } catch (JSONException unused) {
            }
        }
    }

    public final void o(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, writeData) == null) {
            this.f22992d.setValue(writeData.getTitle());
            this.f22993e.setValue(writeData.getContent());
            this.f22990b.setValue(writeData.getVideoInfo());
            j jVar = new j();
            jVar.f53429a = writeData.getForumId();
            jVar.f53431c = writeData.getForumName();
            this.f22994f.setValue(jVar);
            a();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            y.r(f());
        }
    }

    public final void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f22991c.setValue(Integer.valueOf(i2));
            a();
        }
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f22992d.setValue(str);
            a();
        }
    }

    public final void s(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, videoInfo) == null) {
            this.f22990b.setValue(videoInfo);
            a();
        }
    }
}
