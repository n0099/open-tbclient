package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbBigEmotionMsg;
import com.baidu.tieba.im.lib.socket.msg.TbImageMsg;
import com.baidu.tieba.im.lib.socket.msg.TbSingleTextImageMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTextMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.im.lib.socket.msg.data.Reaction;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.BigEmotionItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.ImageItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.SingleTextImageItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.TextGenImageItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.TextItem;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.impl.ResponsesPanelControllerImpl;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes9.dex */
public class z29 implements x29, u29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FastRequest.b<e> A;
    public final FastRequest.b<Void> B;
    public FastRequest C;
    public final WeakReference<TbPageContext<BaseFragmentActivity>> a;
    public final ResponsesPanelControllerImpl b;
    @Nullable
    public lq8 c;
    @Nullable
    public BaseItem d;
    @Nullable
    public ChatRoomDetail e;
    public int f;
    public int g;
    public long h;
    public long i;
    public long j;
    public String k;
    public long l;
    public String m;
    public long n;
    public int o;
    public int p;
    public boolean q;
    public FastRequest r;
    public FastRequest s;
    public FastRequest t;
    public String u;
    @Nullable
    public v29 v;
    public os8 w;
    @NonNull
    public final a39 x;
    public final FastRequest.b<Void> y;
    public final FastRequest.b<f> z;

    @Override // com.baidu.tieba.x29
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z29 d;

        public a(z29 z29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = z29Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.f(i, str, r7);
                this.d.b.v(str);
                this.d.b.m(3, i, str, r7);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                z29 z29Var = this.d;
                z29Var.q = !z29Var.q;
                String str = null;
                if (this.d.q) {
                    if (this.d.b.c.w3() != null) {
                        if (this.d.b.c.w3().q0()) {
                            str = TbadkApplication.getInst().getString(R.string.chat_msg_update_as_excellent);
                        } else {
                            str = TbadkApplication.getInst().getString(R.string.chat_msg_set_as_excellent);
                        }
                    }
                } else {
                    str = TbadkApplication.getInst().getString(R.string.chat_msg_remove_excellent);
                }
                this.d.b.m(3, 1, str, r5);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends FastRequest.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z29 d;

        public b(z29 z29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = z29Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(@NonNull f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
                this.d.b.m(1, 1, null, fVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, @NonNull String str, @Nullable f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, fVar) == null) {
                super.f(i, str, fVar);
                this.d.b.m(1, i, str, fVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends FastRequest.b<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z29 d;

        public c(z29 z29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = z29Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(@NonNull e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
                this.d.b.m(4, 1, null, eVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, @NonNull String str, @Nullable e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, eVar) == null) {
                super.f(i, str, eVar);
                this.d.b.m(4, i, str, eVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z29 d;

        public d(z29 z29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = z29Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.d.b.m(2, 1, null, r5);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.f(i, str, r7);
                this.d.b.m(2, i, str, r7);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("forbidden_list_url")
        public String a;
        @SerializedName("status")
        public long b;

        public e() {
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

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return invokeV.longValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("forbidden_list_url")
        public String a;

        public f() {
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

    public z29(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull ResponsesPanelControllerImpl responsesPanelControllerImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, responsesPanelControllerImpl};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.w = null;
        this.y = new a(this);
        this.z = new b(this);
        this.A = new c(this);
        this.B = new d(this);
        this.a = new WeakReference<>(tbPageContext);
        this.b = responsesPanelControllerImpl;
        responsesPanelControllerImpl.q(this);
        this.x = new a39(responsesPanelControllerImpl);
    }

    @Override // com.baidu.tieba.x29
    public void a(@NonNull v29 v29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v29Var) == null) {
            this.v = v29Var;
        }
    }

    @Override // com.baidu.tieba.x29
    public void g(@NonNull lq8 lq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lq8Var) == null) {
            this.c = lq8Var;
        }
    }

    @Override // com.baidu.tieba.u29
    public void b(int i, @Nullable Map<String, Object> map) {
        String format;
        v29 v29Var;
        lq8 lq8Var;
        BaseItem<? extends TbBaseMsg> baseItem;
        lq8 lq8Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, map) == null) {
            String str = null;
            String thumbUrl = null;
            r2 = null;
            Reaction reaction = null;
            switch (i) {
                case 17:
                    ChatRoomDetail chatRoomDetail = this.e;
                    if (chatRoomDetail != null && !StringUtils.isNull(chatRoomDetail.getForbiddenContent())) {
                        format = String.format(this.e.getForbiddenContent().replaceAll("\\\\n", "\n"), this.k);
                    } else {
                        format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0422), this.k);
                    }
                    hz8.i(this.d);
                    this.b.u(format);
                    return;
                case 18:
                    hz8.e("c15091", String.valueOf(this.l), this.n, this.h);
                    p(new Object[0]);
                    return;
                case 19:
                    v29 v29Var2 = this.v;
                    if (v29Var2 != null) {
                        v29Var2.a(19, this.d, null);
                    }
                    BaseItem baseItem2 = this.d;
                    if (baseItem2 != null) {
                        if (baseItem2.getTbMsg().getType() == 1 || this.d.getTbMsg().getType() == 101) {
                            BaseItem baseItem3 = this.d;
                            if (baseItem3 instanceof TextItem) {
                                str = ((TextItem) baseItem3).getTbMsg().getText();
                            } else if (baseItem3 instanceof TextGenImageItem) {
                                str = ((TextGenImageItem) baseItem3).getTbMsg().getText();
                            }
                            if (!StringUtils.isNull(str)) {
                                AndroidUtils.copyToClipboard(str);
                                this.b.v(this.a.get().getResources().getString(R.string.obfuscated_res_0x7f0f096a));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 20:
                    o(new String[0]);
                    return;
                case 21:
                    if (this.d == null) {
                        return;
                    }
                    UserReplyInfoData userReplyInfoData = new UserReplyInfoData();
                    TbBaseMsg tbMsg = this.d.getTbMsg();
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(lz8.b(tbMsg));
                    spannableStringBuilder.append(tbMsg.getThumbnailText());
                    userReplyInfoData.setmContent(spannableStringBuilder);
                    userReplyInfoData.setmNameShow(tbMsg.getUserName());
                    userReplyInfoData.setmPortrait(tbMsg.getPortrait());
                    userReplyInfoData.setmUid(tbMsg.getUserId());
                    userReplyInfoData.setRobot(tbMsg.isRobot());
                    v29 v29Var3 = this.v;
                    if (v29Var3 != null) {
                        v29Var3.a(21, this.d, userReplyInfoData);
                        return;
                    }
                    return;
                case 22:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                default:
                    return;
                case 23:
                    BaseItem baseItem4 = this.d;
                    if (baseItem4 != null && baseItem4.getTbMsg() != null && this.d.getTbMsg().getBubbleInfo() != null) {
                        String jumpUrl = this.d.getTbMsg().getBubbleInfo().getJumpUrl();
                        if (!StringUtils.isNull(jumpUrl)) {
                            UrlManager.getInstance().dealOneLink(jumpUrl);
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c15236").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    return;
                case 24:
                    ChatRoomDetail chatRoomDetail2 = this.e;
                    if (chatRoomDetail2 != null && chatRoomDetail2.getLongPressMsgBtn() != null && (v29Var = this.v) != null && map != null) {
                        v29Var.a(i, this.d, map.get("robot_tag"));
                        return;
                    }
                    return;
                case 25:
                    hz8.e("c15092", String.valueOf(this.j), this.n, this.h);
                    n(new Object[0]);
                    return;
                case 26:
                    if (map != null && map.containsKey("ext_reaction")) {
                        reaction = (Reaction) map.get("ext_reaction");
                    }
                    if (reaction != null && (lq8Var = this.c) != null && (baseItem = this.d) != null) {
                        this.x.c(lq8Var, reaction, baseItem);
                        return;
                    }
                    return;
                case 32:
                    BaseItem baseItem5 = this.d;
                    if (baseItem5 != null) {
                        if (baseItem5.getTbMsg().getType() == 102 || this.d.getTbMsg().getType() == 2 || this.d.getTbMsg().getType() == 4 || this.d.getTbMsg().getType() == 101) {
                            BaseItem baseItem6 = this.d;
                            if (baseItem6 instanceof ImageItem) {
                                thumbUrl = ((TbImageMsg) ((ImageItem) baseItem6).getTbMsg()).getThumbUrl();
                            } else if (baseItem6 instanceof SingleTextImageItem) {
                                thumbUrl = ((TbSingleTextImageMsg) ((SingleTextImageItem) baseItem6).getTbMsg()).getThumbUrl();
                            } else if (baseItem6 instanceof TextGenImageItem) {
                                thumbUrl = ((TextGenImageItem) baseItem6).getTbMsg().getThumbUrl();
                            } else if (baseItem6 instanceof BigEmotionItem) {
                                thumbUrl = ((TbBigEmotionMsg) ((BigEmotionItem) baseItem6).getTbMsg()).getThumbUrl();
                            }
                            os8 os8Var = new os8(this.a.get().getContext(), thumbUrl, this.n, null, this.h, true);
                            this.w = os8Var;
                            os8Var.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                case 33:
                    m();
                    return;
                case 34:
                    BaseItem baseItem7 = this.d;
                    if (baseItem7 != null && (lq8Var2 = this.c) != null) {
                        jz8.e(lq8Var2, 1, baseItem7);
                        return;
                    }
                    return;
                case 35:
                    this.b.r(this.d, this.e);
                    return;
                case 36:
                    d(null);
                    hz8.j(this.d);
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.x29
    public void c(@NonNull BaseItem<? extends TbBaseMsg> baseItem, @NonNull ChatRoomDetail chatRoomDetail) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseItem, chatRoomDetail) == null) {
            this.d = baseItem;
            this.e = chatRoomDetail;
            this.x.e(chatRoomDetail.getReactions());
            this.x.d(this.a.get().getPageActivity());
            TbBaseMsg tbMsg = baseItem.getTbMsg();
            if (!StringUtils.isNull(tbMsg.getUserName())) {
                this.k = tbMsg.getUserName();
            }
            if (!StringUtils.isNull(tbMsg.getMsgKey())) {
                this.m = tbMsg.getMsgKey();
            }
            CharSequence thumbnailText = tbMsg.getThumbnailText();
            int role = tbMsg.getRole();
            if (tbMsg.getRobotRole() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                role = 64;
            }
            this.f = role;
            this.h = tbMsg.getSessionId();
            this.i = tbMsg.getMsgId();
            this.j = tbMsg.getUserId();
            this.l = TbadkCoreApplication.getCurrentAccountId();
            this.o = tbMsg.getType();
            if (chatRoomDetail.getBasicInfo() != null) {
                this.n = chatRoomDetail.getBasicInfo().getForumId();
            }
            this.g = 1;
            if (chatRoomDetail.getUserInfo() != null) {
                int identityRole = chatRoomDetail.getUserInfo().getIdentityRole();
                if (identityRole != 0) {
                    if (identityRole != 1) {
                        if (identityRole != 2 && identityRole != 3) {
                            if (identityRole == 4) {
                                this.g = 4;
                            }
                        } else {
                            this.g = 2;
                        }
                    } else {
                        this.g = 3;
                    }
                } else {
                    this.g = 1;
                }
                this.p = chatRoomDetail.getUserInfo().getBaZhuType();
            }
            if (this.e.getLongPressMsgBtn() != null && !ListUtils.isEmpty(this.e.getLongPressMsgBtn())) {
                int size = this.e.getLongPressMsgBtn().size();
                for (int i = 0; i < size; i++) {
                    if (this.e.getLongPressMsgBtn().get(i) != null) {
                        AbilityItem abilityItem = this.e.getLongPressMsgBtn().get(i);
                        if (abilityItem.getStyleConf() != null && !StringUtils.isNull(abilityItem.getStyleConf().getContent())) {
                            this.b.b(abilityItem);
                            this.b.d(abilityItem.getStyleConf().getContent(), j());
                            if (l(z, abilityItem.getStyleConf())) {
                                this.b.k();
                            }
                        }
                    }
                }
            } else {
                this.b.k();
            }
            this.b.i(this.k, thumbnailText);
            e();
        }
    }

    @Override // com.baidu.tieba.x29
    public void d(@Nullable FastRequest.b<e> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (this.s == null && this.a.get() != null) {
                this.s = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GET_GROUP_CHAT_IS_LIMIT_MESSAGE, "c/f/chat/checkUserForbidden");
            }
            if (bVar == null) {
                bVar = this.A;
            }
            FastRequest fastRequest = this.s;
            fastRequest.P("chatroom_id", String.valueOf(this.h));
            fastRequest.P("block_uid", String.valueOf(this.j));
            fastRequest.P("forum_id", String.valueOf(this.n));
            fastRequest.R(bVar);
            fastRequest.V(true);
            fastRequest.Q();
        }
    }

    public void o(@NonNull String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, strArr) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf(5));
            hashMap.put("chatroom_msg_id", String.valueOf(this.i));
            hashMap.put("chatroom_id", String.valueOf(this.h));
            String appendParams = UrlUtils.appendParams("https://tieba.baidu.com/tpl/wise-bawu-core/report", hashMap);
            if (this.a.get() != null) {
                UrlManager.getInstance().dealOneLink(this.a.get(), new String[]{appendParams});
            }
        }
    }

    @Override // com.baidu.tieba.x29
    public void e() {
        boolean z;
        boolean z2;
        boolean z3;
        ChatRoomDetail chatRoomDetail;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HashMap hashMap = new HashMap();
            boolean z6 = false;
            if (this.e != null) {
                if (this.b.c.q3() != null && this.b.c.q3().b3() != null) {
                    if (this.b.c.q3().b3().y().h() == null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    hashMap.put("is_show_reply", Boolean.valueOf(z5));
                } else {
                    hashMap.put("is_show_reply", Boolean.FALSE);
                }
            }
            BaseItem baseItem = this.d;
            if (baseItem != null && baseItem.getTbMsg() != null && this.d.getTbMsg().getBubbleInfo() != null && !StringUtils.isNull(this.d.getTbMsg().getBubbleInfo().getJumpUrl())) {
                hashMap.put("is_show_bubble", Boolean.TRUE);
                TiebaStatic.log(new StatisticItem("c15235").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            BaseItem baseItem2 = this.d;
            if (baseItem2 != null && (baseItem2.getTbMsg().getType() == 2 || this.o == 4)) {
                hashMap.put("is_show_copy", Boolean.FALSE);
            }
            int i = this.o;
            if (i != 102 && i != 2 && i != 4 && i != 101) {
                z = false;
            } else {
                z = true;
            }
            BaseItem baseItem3 = this.d;
            if (baseItem3 != null && baseItem3.getTbMsg().getExcellentInfo() != null) {
                boolean isExcellent = this.d.getTbMsg().getExcellentInfo().isExcellent();
                this.q = isExcellent;
                hashMap.put("is_excellent_msg", Boolean.valueOf(isExcellent));
            } else {
                this.q = false;
            }
            if (k() && (chatRoomDetail = this.e) != null && this.d != null && chatRoomDetail.getBots() != null && this.e.getCanExcellent() != null) {
                if (this.e.getCanExcellent().getCanOpExcellent() == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    for (BotsDTO.BotListDTO botListDTO : this.e.getBots().getBotList()) {
                        this.u = botListDTO.getAtGuide();
                    }
                    if (this.d.getTbMsg().getType() == 1) {
                        String text = ((TbTextMsg) this.d.getTbMsg()).getText();
                        if (StringUtils.isNull(this.u) || (text != null && !text.contains(this.u))) {
                            hashMap.put("is_show_excellent_btn", Boolean.TRUE);
                        }
                    } else {
                        hashMap.put("is_show_excellent_btn", Boolean.TRUE);
                    }
                }
            }
            BaseItem baseItem4 = this.d;
            if (baseItem4 != null && (baseItem4.getSendStatus() != 5 || this.d.getTbMsg().isMockSender())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.b.c.q3() != null && this.b.c.q3().b3() != null) {
                z3 = jz8.c(this.b.c.q3().b3());
            } else {
                z3 = true;
            }
            if (!z2 && z3) {
                hashMap.put("is_show_emoji_reply", Boolean.TRUE);
            } else {
                hashMap.put("is_show_emoji_reply", Boolean.FALSE);
            }
            ResponsesPanelControllerImpl responsesPanelControllerImpl = this.b;
            if (this.l == this.j) {
                z6 = true;
            }
            responsesPanelControllerImpl.j(z6, this.f, this.g, hashMap, z, this.p, this.n, this.h);
        }
    }

    @Nullable
    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.e;
            if (chatRoomDetail != null && !ListUtils.isEmpty(chatRoomDetail.getLongPressMsgBtn()) && this.e.getLongPressMsgBtn().get(0) != null) {
                int skinType = TbadkApplication.getInst().getSkinType();
                AbilityItem.StyleConf styleConf = this.e.getLongPressMsgBtn().get(0).getStyleConf();
                if (skinType == 4) {
                    if (styleConf != null && styleConf.getDark() != null) {
                        return styleConf.getDark().getIcon();
                    }
                } else if (skinType == 0 && styleConf != null && styleConf.getDay() != null) {
                    return styleConf.getDay().getIcon();
                }
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void m() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.C == null) {
                this.C = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GROUP_CHAT_EXCELLENT_MESSAGE, "c/c/chatroom/opExcellentMsg");
            }
            FastRequest fastRequest = this.C;
            fastRequest.P("forum_id", Long.valueOf(this.n));
            fastRequest.P("chatroom_id", String.valueOf(this.h));
            fastRequest.P("msg_id", String.valueOf(this.i));
            fastRequest.P("msg_key", String.valueOf(this.m));
            fastRequest.P("tbs", TbadkCoreApplication.getInst().getTbs());
            if (this.q) {
                i = 2;
            } else {
                i = 1;
            }
            fastRequest.P("op_type", Integer.valueOf(i));
            fastRequest.R(this.y);
            fastRequest.Q();
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        int identityRole;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.e;
            if (chatRoomDetail == null || chatRoomDetail.getUserInfo() == null || (identityRole = this.e.getUserInfo().getIdentityRole()) <= 1 || identityRole >= 3) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean l(boolean z, @NonNull AbilityItem.StyleConf styleConf) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, styleConf)) == null) {
            if (styleConf.isFilterBotMsg() == null || styleConf.getShowMsgType() == null || ListUtils.isEmpty(styleConf.getShowMsgType()) || ListUtils.getCount(styleConf.getShowMsgType()) <= 0) {
                return true;
            }
            if (this.d != null && !styleConf.getShowMsgType().contains(Integer.valueOf(this.d.getTbMsg().getType()))) {
                return true;
            }
            if (z && Objects.equals(styleConf.isFilterBotMsg(), 1)) {
                return true;
            }
            return false;
        }
        return invokeZL.booleanValue;
    }

    public void n(@NonNull Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, objArr) == null) {
            if (this.r == null && this.a.get() != null) {
                this.r = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GET_GROUP_CHAT_LIMIT_MESSAGE, "c/c/chatroom/controlSpeak");
            }
            FastRequest fastRequest = this.r;
            fastRequest.P("uid", String.valueOf(this.l));
            fastRequest.P("chatroom_id", String.valueOf(this.h));
            fastRequest.P("op_type", 1);
            fastRequest.P("block_uid", String.valueOf(this.j));
            fastRequest.P("forum_id", String.valueOf(this.n));
            fastRequest.R(this.z);
            fastRequest.V(true);
            fastRequest.Y("info");
            fastRequest.Q();
        }
    }

    public void p(@NonNull Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, objArr) == null) {
            if (this.t == null) {
                this.t = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GET_GROUP_CHAT_ROLLBACK_MESSAGE, "c/c/chatroom/withdrawMsg");
            }
            FastRequest fastRequest = this.t;
            fastRequest.P("msg_type", Integer.valueOf(this.o));
            fastRequest.P("uid_to", String.valueOf(this.j));
            fastRequest.P("chatroom_id", String.valueOf(this.h));
            fastRequest.P("msg_id", String.valueOf(this.i));
            fastRequest.P("msg_key", String.valueOf(this.m));
            fastRequest.P("forum_id", String.valueOf(this.n));
            fastRequest.R(this.B);
            fastRequest.V(true);
            fastRequest.Q();
        }
    }
}
