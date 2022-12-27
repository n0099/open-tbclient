package com.baidu.tieba.write.write.work.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alipay.sdk.widget.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tieba.pr8;
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
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020\u000fJ\u0006\u0010E\u001a\u00020\u000fJ\u0006\u0010F\u001a\u00020\u000fJ\u0006\u0010G\u001a\u00020\u000fJ\u0006\u0010H\u001a\u00020CJ\u0006\u0010I\u001a\u00020\u0019J\u0006\u0010J\u001a\u00020CJ\u000e\u0010K\u001a\u00020C2\u0006\u0010L\u001a\u00020\u0019J\u000e\u0010M\u001a\u00020C2\u0006\u0010N\u001a\u00020OJ\u0006\u0010P\u001a\u00020CJ\u000e\u0010Q\u001a\u00020C2\u0006\u0010R\u001a\u00020\u0004J\u0016\u0010S\u001a\u00020C2\u0006\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u0004J\u000e\u0010V\u001a\u00020C2\u0006\u0010W\u001a\u00020<R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\rR\u001a\u0010\u001c\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\rR \u0010#\u001a\b\u0012\u0004\u0012\u00020$0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000b\"\u0004\b&\u0010\rR0\u0010'\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00190(j\b\u0012\u0004\u0012\u00020\u0019`)0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010\rR \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\rR\u001a\u0010/\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R0\u00108\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00190(j\b\u0012\u0004\u0012\u00020\u0019`)0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010\rR \u0010;\u001a\b\u0012\u0004\u0012\u00020<0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000b\"\u0004\b>\u0010\rR \u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000b\"\u0004\bA\u0010\r¨\u0006X"}, d2 = {"Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "STATE_SUCCESS", "", "getSTATE_SUCCESS", "()I", "barInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/tbadk/data/SelectForumData;", "getBarInfo", "()Landroidx/lifecycle/MutableLiveData;", "setBarInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "canChangeBarName", "", "getCanChangeBarName", "()Z", "setCanChangeBarName", "(Z)V", "classInfo", "Lcom/baidu/tbadk/data/VideoCategoryClassData;", "getClassInfo", "setClassInfo", "desc", "", "getDesc", "setDesc", "intentBarInfo", "getIntentBarInfo", "()Lcom/baidu/tbadk/data/SelectForumData;", "setIntentBarInfo", "(Lcom/baidu/tbadk/data/SelectForumData;)V", "isLegal", "setLegal", "posInfo", "Lcom/baidu/tieba/tbadkCore/location/ResponsedSelectLocation;", "getPosInfo", "setPosInfo", "tagInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTagInfo", "setTagInfo", "title", "getTitle", d.o, "titleLength", "getTitleLength", "setTitleLength", "(I)V", "topicFromLastPage", "getTopicFromLastPage", "()Ljava/lang/String;", "setTopicFromLastPage", "(Ljava/lang/String;)V", "topicInfo", "getTopicInfo", "setTopicInfo", "videoInfo", "Lcom/baidu/tbadk/coreExtra/data/VideoInfo;", "getVideoInfo", "setVideoInfo", "videoMixStatus", "getVideoMixStatus", "setVideoMixStatus", "checkIsAllLegal", "", "checkIsClassAndTagLegal", "checkIsTitleLegal", "checkIsVideoLegal", "checkIsVideoMixStatusLegal", "clearDraft", "generateDraftString", "loadDraft", "parseDataFromDraft", "json", "parseWriteData", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "saveDraft", "updateMixStatus", "status", "updateTitle", "newTitle", "newTitleLength", "updateVideo", "newVideo", "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class WorkPublishViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public MutableLiveData<VideoInfo> b;
    public MutableLiveData<Integer> c;
    public MutableLiveData<String> d;
    public MutableLiveData<String> e;
    public MutableLiveData<VideoCategoryClassData> f;
    public MutableLiveData<SelectForumData> g;
    public SelectForumData h;
    public MutableLiveData<ArrayList<String>> i;
    public MutableLiveData<ResponsedSelectLocation> j;
    public MutableLiveData<ArrayList<String>> k;
    public MutableLiveData<Boolean> l;
    public boolean m;
    public int n;

    public WorkPublishViewModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 2;
        this.b = new MutableLiveData<>();
        this.c = new MutableLiveData<>();
        this.d = new MutableLiveData<>();
        this.e = new MutableLiveData<>();
        this.f = new MutableLiveData<>();
        this.g = new MutableLiveData<>();
        this.h = new SelectForumData();
        this.i = new MutableLiveData<>();
        this.j = new MutableLiveData<>();
        this.k = new MutableLiveData<>();
        this.l = new MutableLiveData<>();
        this.m = true;
    }

    public static final void q(WorkPublishViewModel this$0, String it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.r(it);
        }
    }

    public final void x(String newTitle, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, newTitle, i) == null) {
            Intrinsics.checkNotNullParameter(newTitle, "newTitle");
            this.d.setValue(newTitle);
            this.n = i;
            a();
        }
    }

    public final void a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MutableLiveData<Boolean> mutableLiveData = this.l;
            if (b() && c()) {
                z = true;
            } else {
                z = false;
            }
            mutableLiveData.setValue(Boolean.valueOf(z));
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b.getValue() != null && d()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            pr8.x("");
        }
    }

    public final MutableLiveData<SelectForumData> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<VideoCategoryClassData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<String> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<ResponsedSelectLocation> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.j;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<ArrayList<String>> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<String> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<ArrayList<String>> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.i;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<VideoInfo> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.b;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final MutableLiveData<Boolean> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.l;
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            pr8.n(new pr8.h() { // from class: com.baidu.tieba.qd9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pr8.h
                public final void a(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        WorkPublishViewModel.q(WorkPublishViewModel.this, str);
                    }
                }
            });
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            pr8.x(f());
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String value = this.d.getValue();
            if (value != null && value.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z || (i = this.n) < 5 || i > 80) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.c.getValue() == null) {
                return true;
            }
            if (this.c.getValue() != null) {
                Integer value = this.c.getValue();
                int i = this.a;
                if (value != null && value.intValue() == i) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String f() {
        InterceptResult invokeV;
        String firstClass;
        String secondClass;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mTitle", this.d.getValue());
                jSONObject.put("mDesc", this.e.getValue());
                jSONObject.put("mClass", this.f.getValue());
                VideoCategoryClassData value = this.f.getValue();
                String str2 = null;
                if (value == null) {
                    firstClass = null;
                } else {
                    firstClass = value.getFirstClass();
                }
                jSONObject.put("mFirstClass", firstClass);
                VideoCategoryClassData value2 = this.f.getValue();
                if (value2 == null) {
                    secondClass = null;
                } else {
                    secondClass = value2.getSecondClass();
                }
                jSONObject.put("mSecondClass", secondClass);
                JSONArray jSONArray = new JSONArray();
                if (this.k.getValue() != null) {
                    ArrayList<String> value3 = this.k.getValue();
                    Intrinsics.checkNotNull(value3);
                    Iterator<String> it = value3.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    jSONObject.put("mTag", jSONArray);
                }
                if (this.b.getValue() != null) {
                    jSONObject.put("new_video_info", new Gson().toJson(this.b.getValue()));
                }
                if (this.g.getValue() != null) {
                    SelectForumData value4 = this.g.getValue();
                    if (value4 == null) {
                        str = null;
                    } else {
                        str = value4.forumId;
                    }
                    jSONObject.put("forum_id", str);
                    SelectForumData value5 = this.g.getValue();
                    if (value5 != null) {
                        str2 = value5.forumName;
                    }
                    jSONObject.put("forum_name", str2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public final void r(String json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            JSONObject jSONObject = new JSONObject(json);
            try {
                this.d.setValue(jSONObject.optString("mTitle"));
                this.e.setValue(jSONObject.optString("mDesc"));
                VideoCategoryClassData videoCategoryClassData = new VideoCategoryClassData();
                videoCategoryClassData.setFirstClass(jSONObject.optString("mFirstClass"));
                videoCategoryClassData.setSecondClass(jSONObject.optString("mSecondClass"));
                this.f.setValue(videoCategoryClassData);
                String optString = jSONObject.optString("new_video_info");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(VideoInfo.DRAFT_JSON_NAME)");
                if (!TextUtils.isEmpty(optString)) {
                    this.b.setValue(new Gson().fromJson(optString, (Class<Object>) VideoInfo.class));
                }
                SelectForumData selectForumData = new SelectForumData();
                selectForumData.forumId = jSONObject.optString("forum_id");
                selectForumData.forumName = jSONObject.optString("forum_name");
                if (this.h != null && !this.m) {
                    this.g.setValue(this.h);
                } else {
                    this.g.setValue(selectForumData);
                }
                if (jSONObject.optJSONArray("mTag") != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("mTag");
                    Intrinsics.checkNotNullExpressionValue(optJSONArray, "jsonObject.optJSONArray(\"mTag\")");
                    ArrayList<String> arrayList = new ArrayList<>();
                    int i = 0;
                    int length = optJSONArray.length();
                    if (length > 0) {
                        while (true) {
                            int i2 = i + 1;
                            arrayList.add(optJSONArray.getString(i));
                            if (i2 >= length) {
                                break;
                            }
                            i = i2;
                        }
                    }
                    this.k.setValue(arrayList);
                }
                a();
            } catch (JSONException unused) {
            }
        }
    }

    public final void s(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, writeData) == null) {
            Intrinsics.checkNotNullParameter(writeData, "writeData");
            this.d.setValue(writeData.getTitle());
            this.e.setValue(writeData.getContent());
            this.b.setValue(writeData.getVideoInfo());
            VideoCategoryClassData videoCategoryClassData = new VideoCategoryClassData();
            videoCategoryClassData.setFirstClass(writeData.getClassAndTagData().getFirstClass());
            videoCategoryClassData.setSecondClass(writeData.getClassAndTagData().getSecondClass());
            this.f.setValue(videoCategoryClassData);
            this.k.setValue(writeData.getClassAndTagData().getTags());
            SelectForumData selectForumData = new SelectForumData();
            selectForumData.forumId = writeData.getForumId();
            selectForumData.forumName = writeData.getForumName();
            this.g.setValue(selectForumData);
            a();
        }
    }

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.m = z;
        }
    }

    public final void v(SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, selectForumData) == null) {
            Intrinsics.checkNotNullParameter(selectForumData, "<set-?>");
            this.h = selectForumData;
        }
    }

    public final void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.c.setValue(Integer.valueOf(i));
            a();
        }
    }

    public final void y(VideoInfo newVideo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, newVideo) == null) {
            Intrinsics.checkNotNullParameter(newVideo, "newVideo");
            this.b.setValue(newVideo);
            a();
        }
    }
}
