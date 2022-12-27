package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.tbadk.core.util.videoPreload.IVideoData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xm6 extends BaseCardInfo implements IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId u;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public int g;
    public boolean h;
    public String i;
    public List<String> j;
    public List<String> k;
    public String l;
    public b m;
    public c n;
    public BaijiahaoData o;
    public uu4 p;
    public List<ms8> q;
    public WorksInfoData r;
    public boolean s;
    public AgreeData t;

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public boolean e;
        public boolean f;
        public a g;

        /* loaded from: classes6.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;
            public String b;
            public String c;
            public String d;
            public Integer e;
            public String f;

            public a() {
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
        }

        public b() {
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
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;
        public String c;
        public String d;
        public String e;

        public a() {
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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("startTime = " + this.a);
                sb.append(",   ad_end_time = " + this.b);
                sb.append(",   pic_url = " + this.c);
                sb.append(",   card_title = " + this.d);
                sb.append(",   button_title = " + this.e);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public int e;
        public String f;
        public String g;
        public long h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public a o;
        public List<d> p;

        public c() {
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
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948305224, "Lcom/baidu/tieba/xm6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948305224, "Lcom/baidu/tieba/xm6;");
                return;
            }
        }
        u = BdUniqueId.gen();
    }

    public xm6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new ArrayList();
        this.t = new AgreeData();
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BaijiahaoData baijiahaoData = this.o;
            if (baijiahaoData == null) {
                return 1;
            }
            int i = baijiahaoData.oriUgcType;
            if (i == 2) {
                return 3;
            }
            if (i != 4) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.xn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return u;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c cVar = this.n;
            if (cVar != null) {
                return cVar.d;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void f(String str) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = jSONObject.optString("forum_id");
            this.b = jSONObject.optString("thread_id");
            this.c = jSONObject.optString("nid");
            jSONObject.optString("first_post_id");
            jSONObject.optString("create_time");
            jSONObject.optLong("play_count");
            this.l = jSONObject.optString("title");
            this.d = jSONObject.optLong("post_num");
            jSONObject.optLong("share_num");
            this.e = jSONObject.optLong("agree_num");
            this.f = jSONObject.optLong("disagree_num");
            this.g = jSONObject.optInt("agree_type");
            boolean z3 = true;
            if (jSONObject.optInt("has_agree") == 1) {
                z = true;
            } else {
                z = false;
            }
            this.h = z;
            if (this.e < 0) {
                this.e = 0L;
            }
            if (this.f < 0) {
                this.f = 0L;
            }
            this.t.threadId = this.b;
            this.t.agreeType = this.g;
            this.t.hasAgree = this.h;
            this.t.agreeNum = this.e;
            this.t.disAgreeNum = this.f;
            this.t.diffAgreeNum = jSONObject.optLong("diff_agree_num", 0L);
            jSONObject.optString("source");
            jSONObject.optString("extra");
            jSONObject.optString("abtest_tag");
            jSONObject.optString("weight");
            this.j = new ArrayList();
            String optString = jSONObject.optString("forum_id_shared");
            if (!StringUtils.isNull(optString)) {
                JSONArray jSONArray = new JSONArray(optString);
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.j.add(jSONArray.optString(i));
                }
            }
            this.k = new ArrayList();
            String optString2 = jSONObject.optString("forum_name_shared");
            if (!StringUtils.isNull(optString2)) {
                JSONArray jSONArray2 = new JSONArray(optString2);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    this.k.add(jSONArray2.optString(i2));
                }
            }
            String optString3 = jSONObject.optString(NotificationCompat.CarExtender.KEY_AUTHOR);
            if (!TextUtils.isEmpty(optString3)) {
                this.m = new b();
                JSONObject jSONObject2 = new JSONObject(optString3);
                this.m.a = jSONObject2.optString("user_id");
                this.m.b = jSONObject2.optString("user_name");
                this.m.c = jSONObject2.optString("user_nickname");
                this.m.d = jSONObject2.optString("portrait");
                b bVar = this.m;
                if (jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                bVar.e = z2;
                b bVar2 = this.m;
                if (jSONObject2.optInt(IMUserExtraData.KEY_IS_GOD) != 1) {
                    z3 = false;
                }
                bVar2.f = z3;
                String optString4 = jSONObject2.optString("baijiahao_info");
                if (!TextUtils.isEmpty(optString4)) {
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.m.g = new b.a();
                    this.m.g.a = jSONObject3.optString("name");
                    this.m.g.d = jSONObject3.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                    this.m.g.b = jSONObject3.optString("avatar");
                    this.m.g.c = jSONObject3.optString("avatar_h");
                    this.m.g.e = Integer.valueOf(jSONObject3.optInt("auth_id"));
                    this.m.g.f = jSONObject3.optString(IMUserExtraData.KEY_AUTH_DESC);
                }
            }
            String optString5 = jSONObject.optString("video");
            if (!TextUtils.isEmpty(optString5)) {
                this.n = new c();
                JSONObject jSONObject4 = new JSONObject(optString5);
                this.n.a = jSONObject4.optString("thumbnail_width");
                this.n.b = jSONObject4.optString("thumbnail_height");
                this.n.c = jSONObject4.optString(VideoFinishResult.KEY_VIDEO_MD5);
                this.n.d = jSONObject4.optString("video_url");
                this.n.e = jSONObject4.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
                this.n.f = jSONObject4.optString("video_width");
                this.n.g = jSONObject4.optString("video_height");
                this.n.h = jSONObject4.optLong("video_size");
                this.n.i = jSONObject4.optString("video_type");
                this.n.j = jSONObject4.optString("thumbnail_url");
                this.n.k = jSONObject4.optString("video_format");
                this.n.l = jSONObject4.optString("thumbnail_picid");
                this.n.m = jSONObject4.optString("origin_video_url");
                this.n.n = jSONObject4.optString("mcn_lead_page");
                String optString6 = jSONObject4.optString("video_desc");
                if (!TextUtils.isEmpty(optString6)) {
                    this.n.p = new ArrayList();
                    JSONArray jSONArray3 = new JSONArray(optString6);
                    for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                        d dVar = new d();
                        jSONArray3.optJSONObject(i3).optString("video_id");
                        jSONArray3.optJSONObject(i3).optString("video_url");
                        jSONArray3.optJSONObject(i3).optString("video_width");
                        jSONArray3.optJSONObject(i3).optString("video_height");
                        this.n.p.add(dVar);
                    }
                }
                JSONObject optJSONObject = jSONObject4.optJSONObject("mcn_ad_card");
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.a = optJSONObject.optLong("ad_start_time");
                    aVar.b = optJSONObject.optLong("ad_end_time");
                    aVar.c = optJSONObject.optString("pic_url");
                    optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    aVar.d = optJSONObject.optString("card_title");
                    aVar.e = optJSONObject.optString("button_title");
                    optJSONObject.optLong("effect_time");
                    optJSONObject.optLong("expire_time");
                    this.n.o = aVar;
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject2 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.o = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("forum_info");
            if (optJSONObject3 != null) {
                uu4 uu4Var = new uu4();
                this.p = uu4Var;
                uu4Var.i(optJSONObject3);
            }
            jSONObject.optLong("last_time_int");
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null) {
                this.q = new ArrayList();
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    ms8 ms8Var = new ms8();
                    ms8Var.a(optJSONArray.getJSONObject(i4));
                    this.q.add(ms8Var);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("works_info");
            if (optJSONObject4 != null) {
                WorksInfoData worksInfoData = new WorksInfoData();
                this.r = worksInfoData;
                worksInfoData.parseJson(optJSONObject4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
