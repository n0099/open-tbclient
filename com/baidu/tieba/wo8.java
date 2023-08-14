package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.immessagecenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AgreeList;
import tbclient.NewFloorInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes8.dex */
public class wo8 extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId D;
    public static final BdUniqueId E;
    public static final BdUniqueId F;
    public static final BdUniqueId G;
    public static final BdUniqueId H;
    public static final BdUniqueId I;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int B;
    public boolean C;
    public BdUniqueId a;
    public MetaData b;
    public String c;
    public long d;
    public String e;
    public String f;
    public OriginalThreadInfo g;
    public String h;
    public MetaData i;
    public int j;
    public String k;
    public String l;
    public long m;
    public long n;
    public boolean o;
    public String p;
    public MetaData q;
    public boolean r;
    public boolean s;
    public boolean t;
    public BaijiahaoData u;
    public String v;
    public int w;
    public String x;
    public List<NewFloorInfo> y;
    public TbRichText z;

    public void G(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbRichText) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948277417, "Lcom/baidu/tieba/wo8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948277417, "Lcom/baidu/tieba/wo8;");
                return;
            }
        }
        D = BdUniqueId.gen();
        E = BdUniqueId.gen();
        F = BdUniqueId.gen();
        G = BdUniqueId.gen();
        H = BdUniqueId.gen();
        I = BdUniqueId.gen();
        BdUniqueId.gen();
    }

    public wo8() {
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
        this.b = new MetaData();
        this.q = new MetaData();
        this.t = false;
        this.z = null;
        this.A = "";
        this.B = 0;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.B;
        }
        return invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return invokeV.longValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public TbRichText g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.z;
        }
        return (TbRichText) invokeV.objValue;
    }

    public BaijiahaoData getBaijiahaoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.u;
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public int getCardType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public String getSubTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String getTargetScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.A;
        }
        return (String) invokeV.objValue;
    }

    public int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.ym
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.a;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.n;
        }
        return invokeV.longValue;
    }

    public List<NewFloorInfo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.y;
        }
        return (List) invokeV.objValue;
    }

    public boolean isBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public OriginalThreadInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.g;
        }
        return (OriginalThreadInfo) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public MetaData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.q;
        }
        return (MetaData) invokeV.objValue;
    }

    public MetaData r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.b;
        }
        return (MetaData) invokeV.objValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.v;
        }
        return (String) invokeV.objValue;
    }

    public MetaData u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.i;
        }
        return (MetaData) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.C;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.j == 71) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void C(FeedData feedData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, feedData) != null) || feedData == null) {
            return;
        }
        this.b = feedData.getReplyer();
        this.d = feedData.getTime();
        this.l = feedData.getPost_id();
        this.s = feedData.getHasAgree();
        if (!feedData.isHideForumName()) {
            this.h = feedData.getFname();
        }
        this.k = feedData.getThread_id();
        this.m = feedData.getFromForumId();
        this.j = feedData.getThread_Type();
        this.e = feedData.getContent();
        this.o = feedData.getIsFloor();
        this.c = feedData.getPostFrom();
        this.p = feedData.getQuote_pid();
        this.r = feedData.isNew();
        this.i = feedData.getThreadAuthor();
        this.t = feedData.isBjh();
        this.u = feedData.getBaijiahaoData();
        this.A = feedData.getTargetScheme();
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        this.g = originalThreadInfo;
        originalThreadInfo.f = this.k;
        originalThreadInfo.e = this.m;
        originalThreadInfo.k = this.j;
        originalThreadInfo.c = feedData.getThreadImgUrl();
        this.g.I = feedData.getTargetScheme();
        OriginalThreadInfo originalThreadInfo2 = this.g;
        originalThreadInfo2.o = this.t;
        originalThreadInfo2.p = this.u;
        this.y = feedData.getNewReplayInfo();
        this.w = feedData.getType();
        this.q = feedData.getQuote_user();
        if (feedData.getType() == 1) {
            this.g.n = feedData.getQuote_pid();
            if (feedData.getQuote_user() != null) {
                if (StringHelper.equals(feedData.getQuote_user().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c56);
                } else {
                    str = feedData.getQuote_user().getName_show();
                }
            } else {
                str = "";
            }
            this.g.g = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1227, new Object[]{str, feedData.getQuote_content()});
            if (TextUtils.isGraphic(this.g.g)) {
                OriginalThreadInfo originalThreadInfo3 = this.g;
                originalThreadInfo3.g = originalThreadInfo3.g.replace("\n", " ");
            }
            if (feedData.getIsFloor()) {
                this.a = G;
            } else {
                this.a = H;
            }
        } else {
            this.g.n = "0";
            if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                this.g.g = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13a5, new Object[]{feedData.getOriginalThreadInfo().b});
            } else {
                this.g.g = feedData.getTitle();
            }
            this.a = I;
        }
        this.g.t();
        this.C = feedData.isBotReply();
    }

    public void D(AgreeList agreeList) {
        String string;
        User user;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, agreeList) != null) || agreeList == null) {
            return;
        }
        this.A = agreeList.target_scheme;
        this.n = agreeList.id.longValue();
        MetaData metaData = new MetaData();
        this.b = metaData;
        metaData.parserProtobuf(agreeList.agreeer);
        this.d = agreeList.time.intValue() * 1000;
        Post post = agreeList.post_info;
        if (post != null) {
            this.l = String.valueOf(post.id);
            if (!ListUtils.isEmpty(agreeList.post_info.content) && ListUtils.getItem(agreeList.post_info.content, 0) != null && (user = agreeList.post_info.author) != null) {
                String str = user.name_show;
                if (bi.isEmpty(str)) {
                    str = agreeList.post_info.author.name;
                }
                this.f = str + "：" + agreeList.post_info.content.get(0).text;
            }
            this.p = agreeList.post_info.quote_id;
        }
        ThreadData threadData = new ThreadData();
        threadData.parserProtobuf(agreeList.thread_info);
        this.g = OriginalThreadInfo.n(threadData);
        this.i = threadData.getAuthor();
        this.h = threadData.getForum_name();
        this.k = threadData.getId();
        this.m = threadData.getFid();
        this.j = threadData.threadType;
        this.t = threadData.isUgcThreadType();
        this.u = threadData.getBaijiahaoData();
        this.v = "c12927";
        int intValue = agreeList.type.intValue();
        int i = 4;
        int i2 = 1;
        if (intValue != 1 && intValue != 2) {
            if (intValue != 4) {
                this.a = D;
                if (threadData.isVideoThreadType()) {
                    i2 = 2;
                }
                this.B = i2;
                this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0115);
                if (this.t) {
                    this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0111);
                    return;
                } else if (threadData.isQuestionsAndAnswersThread()) {
                    this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0114);
                    return;
                } else {
                    return;
                }
            }
            this.B = 6;
            this.a = F;
            this.e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0112);
            String str2 = agreeList.virtual_image_url;
            this.x = str2;
            OriginalThreadInfo originalThreadInfo = this.g;
            originalThreadInfo.c = str2;
            originalThreadInfo.b = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0d20);
            this.g.a = 5;
            return;
        }
        if (agreeList.type.intValue() == 1) {
            if (!threadData.isVideoThreadType()) {
                i = 3;
            }
            this.B = i;
        } else {
            this.B = 5;
        }
        this.a = E;
        if (threadData.isQuestionsAndAnswersThread()) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0110);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0113);
        }
        this.e = string;
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.r = z;
        }
    }

    public void F(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbRichText) == null) {
            this.z = tbRichText;
        }
    }
}
