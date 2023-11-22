package com.baidu.tieba.im.under.common.uiliststyle.group.adapter;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
import com.baidu.tieba.dn8;
import com.baidu.tieba.fn8;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityEffectItem;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.BaseStyleNormalAdapter;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.BotEffectUIAssist;
import com.baidu.tieba.im.under.common.uiliststyle.group.data.PayloadData;
import com.baidu.tieba.jn8;
import com.baidu.tieba.lw5;
import com.baidu.tieba.ns8;
import com.baidu.tieba.o0b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.image.ImageInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 2*\u000e\b\u0000\u0010\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u00020\u0003:\u000223B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\n\u0010'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010)\u001a\u00020!H\u0002J\u0010\u0010*\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020-2\u0006\u0010#\u001a\u00020$H\u0002J\u000e\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0017J\u000e\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u0017R\u0010\u0010\u0006\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/baidu/tieba/im/under/common/uiliststyle/group/adapter/BotEffectUIAssist;", "ChildItemData", "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "", "context", "Landroid/content/Context;", "childItemData", "holder", "Lcom/baidu/tieba/im/under/common/uiliststyle/group/adapter/BaseStyleNormalAdapter$SelfHolder;", "helper", "Lcom/baidu/tieba/im/base/core/uilist/BaseChatAdapter$Helper;", "processor", "Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "(Landroid/content/Context;Lcom/baidu/tieba/im/base/core/uilist/BaseItem;Lcom/baidu/tieba/im/under/common/uiliststyle/group/adapter/BaseStyleNormalAdapter$SelfHolder;Lcom/baidu/tieba/im/base/core/uilist/BaseChatAdapter$Helper;Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;)V", "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "effectItem", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityEffectItem;", "mBubbleEffect", "Lcom/baidu/tbadk/widget/image/TbImage;", "mBubbleEffectAppear", "mBubbleEffectContainer", "Landroid/widget/RelativeLayout;", "mForumId", "", "Ljava/lang/Long;", "mRoomId", "payloadProvider", "Lcom/baidu/tieba/im/base/core/uilist/PayloadProvider;", "getPayloadProvider", "()Lcom/baidu/tieba/im/base/core/uilist/PayloadProvider;", "setPayloadProvider", "(Lcom/baidu/tieba/im/base/core/uilist/PayloadProvider;)V", "dealEffectUIData", "", "effectClickLog", "abilityItem", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "objSource", "", "getPayloadData", "Lcom/baidu/tieba/im/under/common/uiliststyle/group/data/PayloadData;", "initEffect", "requestAbility", "setEffectClick", "view", "Landroid/view/View;", "setForumId", "forumId", "setRoomId", "roomId", "Companion", "Conf", "im-under-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BotEffectUIAssist<ChildItemData extends BaseItem<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final ChildItemData b;
    public final fn8.c c;
    public final dn8 d;
    public final RelativeLayout e;
    public final TbImage f;
    public final TbImage g;
    public AbilityEffectItem h;
    public Long i;
    public Long j;
    public jn8 k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(907651798, "Lcom/baidu/tieba/im/under/common/uiliststyle/group/adapter/BotEffectUIAssist;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(907651798, "Lcom/baidu/tieba/im/under/common/uiliststyle/group/adapter/BotEffectUIAssist;");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/im/under/common/uiliststyle/group/adapter/BotEffectUIAssist$Conf;", "Ljava/io/Serializable;", "botUk", "", "skillId", "", "(Ljava/lang/String;J)V", "getBotUk", "()Ljava/lang/String;", "getSkillId", "()J", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "im-under-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Conf implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("bot_uk")
        public final String botUk;
        @SerializedName("skill_id")
        public final long skillId;

        public static /* synthetic */ Conf copy$default(Conf conf, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = conf.botUk;
            }
            if ((i & 2) != 0) {
                j = conf.skillId;
            }
            return conf.copy(str, j);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.botUk : (String) invokeV.objValue;
        }

        public final long component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.skillId : invokeV.longValue;
        }

        public final Conf copy(String botUk, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, botUk, j)) == null) {
                Intrinsics.checkNotNullParameter(botUk, "botUk");
                return new Conf(botUk, j);
            }
            return (Conf) invokeLJ.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Conf) {
                    Conf conf = (Conf) obj;
                    return Intrinsics.areEqual(this.botUk, conf.botUk) && this.skillId == conf.skillId;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.botUk.hashCode() * 31) + c.a(this.skillId) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "Conf(botUk=" + this.botUk + ", skillId=" + this.skillId + ')';
            }
            return (String) invokeV.objValue;
        }

        public Conf(String botUk, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {botUk, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(botUk, "botUk");
            this.botUk = botUk;
            this.skillId = j;
        }

        public final String getBotUk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.botUk;
            }
            return (String) invokeV.objValue;
        }

        public final long getSkillId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.skillId;
            }
            return invokeV.longValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements lw5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BotEffectUIAssist<ChildItemData> a;

        @Override // com.baidu.tieba.lw5
        public void a(String str, ImageInfo imageInfo, Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, imageInfo, animatable) == null) {
            }
        }

        public a(BotEffectUIAssist<ChildItemData> botEffectUIAssist) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {botEffectUIAssist};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = botEffectUIAssist;
        }

        @Override // com.baidu.tieba.lw5
        public void b(String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, th) == null) {
                TbImage tbImage = this.a.f;
                tbImage.l("res://drawable/" + R.drawable.icon_bot_effect_appear);
                this.a.f.p();
            }
        }
    }

    public BotEffectUIAssist(Context context, ChildItemData childitemdata, BaseStyleNormalAdapter.SelfHolder holder, fn8.c helper, dn8 dn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, childitemdata, holder, helper, dn8Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(helper, "helper");
        this.a = context;
        this.b = childitemdata;
        this.c = helper;
        this.d = dn8Var;
        RelativeLayout relativeLayout = holder.g;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "holder.bubbleEffectContainer");
        this.e = relativeLayout;
        TbImage tbImage = holder.h;
        Intrinsics.checkNotNullExpressionValue(tbImage, "holder.bubbleEffectAppear");
        this.f = tbImage;
        TbImage tbImage2 = holder.i;
        Intrinsics.checkNotNullExpressionValue(tbImage2, "holder.bubbleEffect");
        this.g = tbImage2;
        g();
    }

    public static final void d(BotEffectUIAssist this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.e.getVisibility() == 0) {
                o0b.b(this$0.e, 800);
            }
        }
    }

    public final void h(AbilityItem abilityItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, abilityItem) == null) {
            dn8 dn8Var = this.d;
            if (dn8Var != null) {
                dn8.e(dn8Var, abilityItem, this.b, null, 4, null);
            }
            e(abilityItem, 3);
        }
    }

    public final void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.j = Long.valueOf(j);
        }
    }

    public final void l(jn8 jn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jn8Var) == null) {
            this.k = jn8Var;
        }
    }

    public final void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.i = Long.valueOf(j);
        }
    }

    public static final void j(BotEffectUIAssist this$0, AbilityItem abilityItem, View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, this$0, abilityItem, view2, view3) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(abilityItem, "$abilityItem");
            Intrinsics.checkNotNullParameter(view2, "$view");
            this$0.h(abilityItem);
            o0b.b(view2, 800);
            this$0.e(abilityItem, 4);
        }
    }

    public final void c() {
        AbilityItem abilityItem;
        long j;
        String mainEndImage;
        AbilityItem.StyleConf styleConf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ChildItemData childitemdata = this.b;
            Intrinsics.checkNotNull(childitemdata);
            TbBaseMsg tbMsg = childitemdata.getTbMsg();
            if (tbMsg.getAbilityEffectItem() == null) {
                return;
            }
            AbilityEffectItem abilityEffectItem = tbMsg.getAbilityEffectItem();
            this.h = abilityEffectItem;
            AbilityItem.Extra extra = null;
            if (abilityEffectItem != null) {
                abilityItem = abilityEffectItem.getAbilityItem();
            } else {
                abilityItem = null;
            }
            AbilityEffectItem abilityEffectItem2 = this.h;
            if (abilityEffectItem2 != null) {
                j = abilityEffectItem2.getButtonHideTime();
            } else {
                j = 6;
            }
            long j2 = j * 1000;
            if (abilityItem != null && (styleConf = abilityItem.getStyleConf()) != null) {
                extra = styleConf.getAndroidExtra();
            }
            String str = "";
            String str2 = (extra == null || (str2 = extra.getStartImage()) == null) ? "" : "";
            final String str3 = (extra == null || (str3 = extra.getEndImage()) == null) ? "" : "";
            String str4 = (extra == null || (str4 = extra.getMainStartImage()) == null) ? "" : "";
            if (extra != null && (mainEndImage = extra.getMainEndImage()) != null) {
                str = mainEndImage;
            }
            if (this.e.getVisibility() == 8) {
                o0b.d(this.e, 800);
            }
            boolean d = ns8.d(String.valueOf(tbMsg.getUserId()));
            if (d) {
                str2 = str4;
            }
            if (d) {
                str3 = str;
            }
            this.f.setTag(str2);
            this.f.m(str2);
            this.g.setTag(str3);
            this.g.m(str3);
            this.f.setLoadResultListener(new a(this));
            this.f.l(str2);
            this.f.p();
            this.f.setOnWebpEndedListener(new Function0<Unit>(this, str3) { // from class: com.baidu.tieba.im.under.common.uiliststyle.group.adapter.BotEffectUIAssist$dealEffectUIData$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $guideUrl;
                public final /* synthetic */ BotEffectUIAssist<ChildItemData> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$guideUrl = str3;
                }

                /* loaded from: classes6.dex */
                public static final class a implements lw5 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BotEffectUIAssist<ChildItemData> a;

                    @Override // com.baidu.tieba.lw5
                    public void a(String str, ImageInfo imageInfo, Animatable animatable) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, imageInfo, animatable) == null) {
                        }
                    }

                    public a(BotEffectUIAssist<ChildItemData> botEffectUIAssist) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {botEffectUIAssist};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = botEffectUIAssist;
                    }

                    @Override // com.baidu.tieba.lw5
                    public void b(String str, Throwable th) {
                        TbImage tbImage;
                        TbImage tbImage2;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, th) == null) {
                            tbImage = this.a.g;
                            tbImage.l("res://drawable/" + R.drawable.icon_bot_effect_guide);
                            tbImage2 = this.a.g;
                            tbImage2.p();
                        }
                    }
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    TbImage tbImage;
                    TbImage tbImage2;
                    TbImage tbImage3;
                    TbImage tbImage4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.f.setVisibility(8);
                        tbImage = this.this$0.g;
                        tbImage.setVisibility(0);
                        tbImage2 = this.this$0.g;
                        tbImage2.setLoadResultListener(new a(this.this$0));
                        tbImage3 = this.this$0.g;
                        tbImage3.l(this.$guideUrl);
                        tbImage4 = this.this$0.g;
                        tbImage4.p();
                    }
                }
            });
            if (abilityItem != null) {
                i(this.e, abilityItem);
            }
            this.c.d(new Runnable() { // from class: com.baidu.tieba.mv8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BotEffectUIAssist.d(BotEffectUIAssist.this);
                    }
                }
            }, j2);
        }
    }

    public final void e(AbilityItem abilityItem, int i) {
        BotsDTO botsDTO;
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        long j;
        BotsDTO.BotListDTO findBotByUk;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abilityItem, i) == null) {
            Conf conf = (Conf) DataExt.toEntity(abilityItem.getConfMap(), Conf.class);
            PayloadData f = f();
            String str = null;
            if (f != null) {
                botsDTO = f.getBotsDTO();
            } else {
                botsDTO = null;
            }
            if (botsDTO != null && (findBotByUk = botsDTO.findBotByUk(conf.getBotUk())) != null) {
                skillDTO = findBotByUk.cloneSkillById((int) conf.getSkillId());
            } else {
                skillDTO = null;
            }
            StatisticItem param = new StatisticItem("c15134").param("obj_type", 3).param("obj_source", i);
            if (skillDTO != null) {
                str = skillDTO.getName();
            }
            if (str == null) {
                str = "";
            }
            StatisticItem param2 = param.param("obj_name", str);
            Long l = this.j;
            long j2 = 0;
            if (l != null) {
                j = l.longValue();
            } else {
                j = 0;
            }
            StatisticItem param3 = param2.param("fid", j);
            Long l2 = this.i;
            if (l2 != null) {
                j2 = l2.longValue();
            }
            TiebaStatic.log(param3.param("room_id", j2).param("obj_id", conf.getSkillId()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final PayloadData f() {
        InterceptResult invokeV;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            jn8 jn8Var = this.k;
            if (jn8Var != null) {
                obj = jn8Var.a();
            } else {
                obj = null;
            }
            if (!(obj instanceof PayloadData)) {
                return null;
            }
            return (PayloadData) obj;
        }
        return (PayloadData) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f.setLooping(false);
            this.f.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            this.g.setLooping(true);
            this.f.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        }
    }

    public final void i(final View view2, final AbilityItem abilityItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, abilityItem) == null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lv8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        BotEffectUIAssist.j(BotEffectUIAssist.this, abilityItem, view2, view3);
                    }
                }
            });
        }
    }
}
