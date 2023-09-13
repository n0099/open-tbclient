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
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.impl.ResponsesPanelControllerImpl;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.SingleTextImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.Reaction;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes8.dex */
public class ym8 implements wm8, tm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakReference<TbPageContext<BaseFragmentActivity>> a;
    public final ResponsesPanelControllerImpl b;
    @Nullable
    public io8 c;
    @Nullable
    public BaseMsg d;
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
    public boolean p;
    public FastRequest q;
    public FastRequest r;
    public String s;
    @Nullable
    public um8 t;
    public yd8 u;
    @NonNull
    public final zm8 v;
    public final FastRequest.b<Void> w;
    public final FastRequest.b<Void> x;
    public final FastRequest.b<Void> y;
    public FastRequest z;

    @Override // com.baidu.tieba.wm8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ym8 b;

        public a(ym8 ym8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ym8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ym8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                this.b.b.r(str);
                this.b.b.n(3, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void f(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                ym8 ym8Var = this.b;
                ym8Var.p = !ym8Var.p;
                String str = null;
                if (this.b.p) {
                    if (this.b.b.c.L2() != null) {
                        if (this.b.b.c.L2().n0()) {
                            str = TbadkApplication.getInst().getString(R.string.chat_msg_update_as_excellent);
                        } else {
                            str = TbadkApplication.getInst().getString(R.string.chat_msg_set_as_excellent);
                        }
                    }
                } else {
                    str = TbadkApplication.getInst().getString(R.string.chat_msg_remove_excellent);
                }
                this.b.b.n(3, 1, str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ym8 b;

        public b(ym8 ym8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ym8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ym8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void f(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.b.b.n(1, 1, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                this.b.b.n(1, i, str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ym8 b;

        public c(ym8 ym8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ym8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ym8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void f(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.b.b.n(2, 1, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                this.b.b.n(2, i, str);
            }
        }
    }

    public ym8(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull ResponsesPanelControllerImpl responsesPanelControllerImpl) {
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
        this.p = false;
        this.u = null;
        this.w = new a(this);
        this.x = new b(this);
        this.y = new c(this);
        this.a = new WeakReference<>(tbPageContext);
        this.b = responsesPanelControllerImpl;
        responsesPanelControllerImpl.p(this);
        this.v = new zm8(responsesPanelControllerImpl);
    }

    public boolean k(boolean z, @NonNull AbilityItem.StyleConf styleConf) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048583, this, z, styleConf)) == null) {
            if (styleConf.isFilterBotMsg() == null || styleConf.getShowMsgType() == null || ListUtils.isEmpty(styleConf.getShowMsgType()) || ListUtils.getCount(styleConf.getShowMsgType()) <= 0) {
                return true;
            }
            if (this.d != null && !styleConf.getShowMsgType().contains(Integer.valueOf(this.d.getMsgType()))) {
                return true;
            }
            if (z && Objects.equals(styleConf.isFilterBotMsg(), 1)) {
                return true;
            }
            return false;
        }
        return invokeZL.booleanValue;
    }

    @Override // com.baidu.tieba.wm8
    public void a(@NonNull um8 um8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, um8Var) == null) {
            this.t = um8Var;
        }
    }

    @Override // com.baidu.tieba.wm8
    public void e(@NonNull io8 io8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, io8Var) == null) {
            this.c = io8Var;
        }
    }

    @Override // com.baidu.tieba.tm8
    public void b(int i, @Nullable Map<String, Object> map) {
        String format;
        um8 um8Var;
        io8 io8Var;
        BaseMsg baseMsg;
        io8 io8Var2;
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
                        format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0417), this.k);
                    }
                    this.b.q(format);
                    return;
                case 18:
                    as8.e("c15091", String.valueOf(this.l), this.n, this.h);
                    o(new Object[0]);
                    return;
                case 19:
                    um8 um8Var2 = this.t;
                    if (um8Var2 != null) {
                        um8Var2.a(19, this.d, null);
                    }
                    BaseMsg baseMsg2 = this.d;
                    if (baseMsg2 != null) {
                        if (baseMsg2.getMsgType() == 1 || this.d.getMsgType() == 101) {
                            BaseMsg baseMsg3 = this.d;
                            if (baseMsg3 instanceof TextMsg) {
                                str = ((TextMsg) baseMsg3).getText();
                            } else if (baseMsg3 instanceof TextGenImageMsg) {
                                str = ((TextGenImageMsg) baseMsg3).getText();
                            }
                            if (!StringUtils.isNull(str)) {
                                AndroidUtils.copyToClipboard(str);
                                this.b.r(this.a.get().getResources().getString(R.string.obfuscated_res_0x7f0f0949));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 20:
                    n(new String[0]);
                    return;
                case 21:
                    if (this.d == null) {
                        return;
                    }
                    UserReplyInfoData userReplyInfoData = new UserReplyInfoData();
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.d.getReplyPrefix());
                    spannableStringBuilder.append(this.d.getThumbnailText());
                    userReplyInfoData.setmContent(spannableStringBuilder);
                    userReplyInfoData.setmNameShow(this.d.getCommonMsgField().getUserName());
                    userReplyInfoData.setmPortrait(this.d.getCommonMsgField().getPortrait());
                    userReplyInfoData.setmUid(this.d.getCommonMsgField().getUserId());
                    userReplyInfoData.setRobot(this.d.getCommonMsgField().isRobot());
                    um8 um8Var3 = this.t;
                    if (um8Var3 != null) {
                        um8Var3.a(21, this.d, userReplyInfoData);
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
                    BaseMsg baseMsg4 = this.d;
                    if (baseMsg4 != null && baseMsg4.getCommonMsgField().getBubbleInfo() != null) {
                        String jumpUrl = this.d.getCommonMsgField().getBubbleInfo().getJumpUrl();
                        if (!StringUtils.isNull(jumpUrl)) {
                            UrlManager.getInstance().dealOneLink(jumpUrl);
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c15236").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    return;
                case 24:
                    ChatRoomDetail chatRoomDetail2 = this.e;
                    if (chatRoomDetail2 != null && chatRoomDetail2.getLongPressMsgBtn() != null && (um8Var = this.t) != null && map != null) {
                        um8Var.a(i, this.d, map.get("robot_tag"));
                        return;
                    }
                    return;
                case 25:
                    as8.e("c15092", String.valueOf(this.j), this.n, this.h);
                    m(new Object[0]);
                    return;
                case 26:
                    if (map != null && map.containsKey("ext_reaction")) {
                        reaction = (Reaction) map.get("ext_reaction");
                    }
                    if (reaction != null && (io8Var = this.c) != null && (baseMsg = this.d) != null) {
                        this.v.c(io8Var, reaction, baseMsg);
                        return;
                    }
                    return;
                case 32:
                    BaseMsg baseMsg5 = this.d;
                    if (baseMsg5 != null) {
                        if (baseMsg5.getMsgType() == 102 || this.d.getMsgType() == 2 || this.d.getMsgType() == 101) {
                            BaseMsg baseMsg6 = this.d;
                            if (baseMsg6 instanceof ImageMsg) {
                                thumbUrl = ((ImageMsg) baseMsg6).getThumbUrl();
                            } else if (baseMsg6 instanceof SingleTextImageMsg) {
                                thumbUrl = ((SingleTextImageMsg) baseMsg6).getThumbUrl();
                            } else if (baseMsg6 instanceof TextGenImageMsg) {
                                thumbUrl = ((TextGenImageMsg) baseMsg6).getThumbUrl();
                            }
                            yd8 yd8Var = new yd8(this.a.get().getContext(), thumbUrl, this.n, null, this.h, true);
                            this.u = yd8Var;
                            yd8Var.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                case 33:
                    l();
                    return;
                case 34:
                    BaseMsg baseMsg7 = this.d;
                    if (baseMsg7 != null && (io8Var2 = this.c) != null) {
                        ip8.e(io8Var2, 1, baseMsg7);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.wm8
    public void d(@NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseMsg, chatRoomDetail) == null) {
            this.d = baseMsg;
            this.e = chatRoomDetail;
            this.v.e(chatRoomDetail.getReactions());
            this.v.d(this.a.get().getPageActivity());
            CommonMsgField commonMsgField = baseMsg.getCommonMsgField();
            if (!StringUtils.isNull(commonMsgField.getUserName())) {
                this.k = commonMsgField.getUserName();
            }
            if (!StringUtils.isNull(commonMsgField.getMsgKey())) {
                this.m = commonMsgField.getMsgKey();
            }
            CharSequence thumbnailText = this.d.getThumbnailText();
            int role = commonMsgField.getRole();
            if (commonMsgField.getRobotRole() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                role = 64;
            }
            this.f = role;
            this.h = commonMsgField.getRoomId();
            this.i = commonMsgField.getMsgId();
            this.j = commonMsgField.getUserId();
            this.l = TbadkCoreApplication.getCurrentAccountId();
            this.o = baseMsg.getMsgType();
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
            }
            if (this.e.getLongPressMsgBtn() != null && !ListUtils.isEmpty(this.e.getLongPressMsgBtn())) {
                int size = this.e.getLongPressMsgBtn().size();
                for (int i = 0; i < size; i++) {
                    if (this.e.getLongPressMsgBtn().get(i) != null) {
                        AbilityItem abilityItem = this.e.getLongPressMsgBtn().get(i);
                        if (abilityItem.getStyleConf() != null && !StringUtils.isNull(abilityItem.getStyleConf().getContent())) {
                            this.b.b(abilityItem);
                            this.b.c(abilityItem.getStyleConf().getContent(), i());
                            if (k(z, abilityItem.getStyleConf())) {
                                this.b.l();
                            }
                        }
                    }
                }
            } else {
                this.b.l();
            }
            this.b.j(this.k, thumbnailText);
            f();
        }
    }

    @Override // com.baidu.tieba.wm8
    public void f() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ChatRoomDetail chatRoomDetail;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HashMap hashMap = new HashMap();
            ChatRoomDetail chatRoomDetail2 = this.e;
            if (chatRoomDetail2 != null) {
                hashMap.put("is_show_reply", Boolean.valueOf(zo8.r(chatRoomDetail2)));
            }
            BaseMsg baseMsg = this.d;
            if (baseMsg != null && baseMsg.getCommonMsgField().getBubbleInfo() != null && !StringUtils.isNull(this.d.getCommonMsgField().getBubbleInfo().getJumpUrl())) {
                hashMap.put("is_show_bubble", Boolean.TRUE);
                TiebaStatic.log(new StatisticItem("c15235").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            BaseMsg baseMsg2 = this.d;
            if (baseMsg2 != null && baseMsg2.getMsgType() == 2) {
                hashMap.put("is_show_copy", Boolean.FALSE);
            }
            int i = this.o;
            if (i != 102 && i != 2 && i != 101) {
                z = false;
            } else {
                z = true;
            }
            BaseMsg baseMsg3 = this.d;
            if (baseMsg3 != null && baseMsg3.getCommonMsgField().getExcellentInfo() != null) {
                boolean isExcellent = this.d.getCommonMsgField().getExcellentInfo().isExcellent();
                this.p = isExcellent;
                hashMap.put("is_excellent_msg", Boolean.valueOf(isExcellent));
            } else {
                this.p = false;
            }
            if (j() && (chatRoomDetail = this.e) != null && this.d != null && chatRoomDetail.getBots() != null && this.e.getCanExcellent() != null) {
                if (this.e.getCanExcellent().getCanOpExcellent() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    for (BotsDTO.BotListDTO botListDTO : this.e.getBots().getBotList()) {
                        this.s = botListDTO.getAtGuide();
                    }
                    if (this.d.getMsgType() == 1) {
                        String text = ((TextMsg) this.d).getText();
                        if (StringUtils.isNull(this.s) || (text != null && !text.contains(this.s))) {
                            hashMap.put("is_show_excellent_btn", Boolean.TRUE);
                        }
                    } else {
                        hashMap.put("is_show_excellent_btn", Boolean.TRUE);
                    }
                }
            }
            BaseMsg baseMsg4 = this.d;
            if (baseMsg4 != null && (baseMsg4.getItemStatus() != 5 || this.d.isLocalMsg())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.b.c.E2() != null) {
                z3 = ip8.c(this.b.c.E2());
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
                z4 = true;
            } else {
                z4 = false;
            }
            responsesPanelControllerImpl.k(z4, this.f, this.g, hashMap, z, this.n, this.h);
        }
    }

    @Nullable
    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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

    public void l() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.z == null) {
                this.z = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GROUP_CHAT_EXCELLENT_MESSAGE, "c/c/chatroom/opExcellentMsg");
            }
            FastRequest fastRequest = this.z;
            fastRequest.N("forum_id", Long.valueOf(this.n));
            fastRequest.N("chatroom_id", String.valueOf(this.h));
            fastRequest.N("msg_id", String.valueOf(this.i));
            fastRequest.N("msg_key", String.valueOf(this.m));
            fastRequest.N("tbs", TbadkCoreApplication.getInst().getTbs());
            if (this.p) {
                i = 2;
            } else {
                i = 1;
            }
            fastRequest.N("op_type", Integer.valueOf(i));
            fastRequest.P(this.w);
            fastRequest.O();
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        int identityRole;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.e;
            if (chatRoomDetail == null || chatRoomDetail.getUserInfo() == null || (identityRole = this.e.getUserInfo().getIdentityRole()) <= 1 || identityRole >= 3) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void m(@NonNull Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, objArr) == null) {
            if (this.q == null && this.a.get() != null) {
                this.q = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GET_GROUP_CHAT_LIMIT_MESSAGE, "c/c/chatroom/controlSpeak");
            }
            FastRequest fastRequest = this.q;
            fastRequest.N("uid", String.valueOf(this.l));
            fastRequest.N("chatroom_id", String.valueOf(this.h));
            fastRequest.N("op_type", 1);
            fastRequest.N("block_uid", String.valueOf(this.j));
            fastRequest.N("forum_id", String.valueOf(this.n));
            fastRequest.P(this.x);
            fastRequest.T(true);
            fastRequest.O();
        }
    }

    public void o(@NonNull Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, objArr) == null) {
            if (this.r == null) {
                this.r = new FastRequest(this.a.get(), CmdConfigHttp.CMD_GET_GROUP_CHAT_ROLLBACK_MESSAGE, "c/c/chatroom/withdrawMsg");
            }
            FastRequest fastRequest = this.r;
            fastRequest.N("msg_type", Integer.valueOf(this.o));
            fastRequest.N("uid_to", String.valueOf(this.j));
            fastRequest.N("chatroom_id", String.valueOf(this.h));
            fastRequest.N("msg_id", String.valueOf(this.i));
            fastRequest.N("msg_key", String.valueOf(this.m));
            fastRequest.N("forum_id", String.valueOf(this.n));
            fastRequest.P(this.y);
            fastRequest.T(true);
            fastRequest.O();
        }
    }

    public void n(@NonNull String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, strArr) == null) {
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
}
