package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.helper;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.a78;
import com.baidu.tieba.d78;
import com.baidu.tieba.hu5;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatActivity;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ability.RequestRouterHandler;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.helper.BotEffectUIAssist;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.AbilityEffectItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.mx9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003:\u0001,B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u0019R\u0010\u0010\u0006\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/helper/BotEffectUIAssist;", "ChildItemData", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseMsg;", "", "context", "Landroid/content/Context;", "childItemData", "holder", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseChatAdapter$SelfHolder;", "helper", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseAdapter$Helper;", "processor", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityProcessor;", "(Landroid/content/Context;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseMsg;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseChatAdapter$SelfHolder;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseAdapter$Helper;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityProcessor;)V", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseMsg;", "effectItem", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/AbilityEffectItem;", "hasRequestRouter", "", "mBubbleEffect", "Lcom/baidu/tbadk/widget/image/TbImage;", "mBubbleEffectAppear", "mBubbleEffectContainer", "Landroid/widget/RelativeLayout;", "mForumId", "", "Ljava/lang/Long;", "mRoomId", "dealEffectUIData", "", "effectClickLog", "abilityItem", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem;", "objSource", "", "initEffect", "requestAbility", "setEffectClick", NativeConstants.TYPE_VIEW, "Landroid/view/View;", "setForumId", "forumId", "setRoomId", "roomId", "Companion", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BotEffectUIAssist<ChildItemData extends BaseMsg> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final ChildItemData b;
    public final d78.c c;
    public final a78 d;
    public final RelativeLayout e;
    public final TbImage f;
    public final TbImage g;
    public AbilityEffectItem h;
    public boolean i;
    public Long j;
    public Long k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1996279219, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/helper/BotEffectUIAssist;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1996279219, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/helper/BotEffectUIAssist;");
        }
    }

    /* loaded from: classes5.dex */
    public static final class a implements hu5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BotEffectUIAssist<ChildItemData> a;

        @Override // com.baidu.tieba.hu5
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

        @Override // com.baidu.tieba.hu5
        public void b(String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, th) == null) {
                TbImage tbImage = this.a.f;
                tbImage.k("res://drawable/" + R.drawable.icon_bot_effect_appear);
                this.a.f.o();
            }
        }
    }

    public BotEffectUIAssist(Context context, ChildItemData childitemdata, BaseChatAdapter.SelfHolder holder, d78.c helper, a78 a78Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, childitemdata, holder, helper, a78Var};
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
        this.d = a78Var;
        RelativeLayout relativeLayout = holder.g;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "holder.bubbleEffectContainer");
        this.e = relativeLayout;
        TbImage tbImage = holder.h;
        Intrinsics.checkNotNullExpressionValue(tbImage, "holder.bubbleEffectAppear");
        this.f = tbImage;
        TbImage tbImage2 = holder.i;
        Intrinsics.checkNotNullExpressionValue(tbImage2, "holder.bubbleEffect");
        this.g = tbImage2;
        f();
    }

    public final void g(AbilityItem abilityItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, abilityItem) == null) {
            a78 a78Var = this.d;
            if (a78Var != null) {
                a78.e(a78Var, abilityItem, this.b, null, 4, null);
            }
            e(abilityItem, 3);
        }
    }

    public final void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.k = Long.valueOf(j);
        }
    }

    public final void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.j = Long.valueOf(j);
        }
    }

    public static final void d(BotEffectUIAssist this$0, AbilityItem abilityItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, abilityItem) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.e.getVisibility() == 0 && !this$0.i) {
                if (abilityItem != null) {
                    this$0.g(abilityItem);
                }
                mx9.b(this$0.e, 800);
            }
        }
    }

    public final void h(final View view2, final AbilityItem abilityItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, abilityItem) == null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.n78
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        BotEffectUIAssist.i(BotEffectUIAssist.this, abilityItem, view2, view3);
                    }
                }
            });
        }
    }

    public static final void i(BotEffectUIAssist this$0, AbilityItem abilityItem, View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, this$0, abilityItem, view2, view3) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(abilityItem, "$abilityItem");
            Intrinsics.checkNotNullParameter(view2, "$view");
            this$0.g(abilityItem);
            this$0.i = true;
            mx9.b(view2, 800);
            this$0.e(abilityItem, 4);
        }
    }

    public final void c() {
        final AbilityItem abilityItem;
        long j;
        AbilityItem.StyleConf styleConf;
        AbilityItem.Extra androidExtra;
        String endImage;
        AbilityItem.StyleConf styleConf2;
        AbilityItem.Extra androidExtra2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ChildItemData childitemdata = this.b;
            Intrinsics.checkNotNull(childitemdata);
            CommonMsgField commonMsgField = childitemdata.getCommonMsgField();
            Intrinsics.checkNotNullExpressionValue(commonMsgField, "childItemData!!.commonMsgField");
            if (commonMsgField.getAbilityEffectItem() == null) {
                return;
            }
            this.i = false;
            AbilityEffectItem abilityEffectItem = commonMsgField.getAbilityEffectItem();
            this.h = abilityEffectItem;
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
            final String str = "";
            String str2 = (abilityItem == null || (styleConf2 = abilityItem.getStyleConf()) == null || (androidExtra2 = styleConf2.getAndroidExtra()) == null || (str2 = androidExtra2.getStartImage()) == null) ? "" : "";
            if (abilityItem != null && (styleConf = abilityItem.getStyleConf()) != null && (androidExtra = styleConf.getAndroidExtra()) != null && (endImage = androidExtra.getEndImage()) != null) {
                str = endImage;
            }
            if (this.e.getVisibility() == 8) {
                mx9.d(this.e, 800);
            }
            this.f.setTag(str2);
            this.f.l(str2);
            this.g.setTag(str);
            this.g.l(str);
            this.f.setLoadResultListener(new a(this));
            this.f.k(str2);
            this.f.o();
            this.f.setOnWebpEndedListener(new Function0<Unit>(this, str) { // from class: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.helper.BotEffectUIAssist$dealEffectUIData$2
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
                        Object[] objArr = {this, str};
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
                    this.$guideUrl = str;
                }

                /* loaded from: classes5.dex */
                public static final class a implements hu5 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BotEffectUIAssist<ChildItemData> a;

                    @Override // com.baidu.tieba.hu5
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

                    @Override // com.baidu.tieba.hu5
                    public void b(String str, Throwable th) {
                        TbImage tbImage;
                        TbImage tbImage2;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, th) == null) {
                            tbImage = this.a.g;
                            tbImage.k("res://drawable/" + R.drawable.icon_bot_effect_guide);
                            tbImage2 = this.a.g;
                            tbImage2.o();
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
                        tbImage3.k(this.$guideUrl);
                        tbImage4 = this.this$0.g;
                        tbImage4.o();
                    }
                }
            });
            if (abilityItem != null) {
                h(this.e, abilityItem);
            }
            this.c.d(new Runnable() { // from class: com.baidu.tieba.q78
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BotEffectUIAssist.d(BotEffectUIAssist.this, abilityItem);
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
        ChatPage e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abilityItem, i) == null) {
            RequestRouterHandler.Conf conf = (RequestRouterHandler.Conf) DataExt.toEntity(abilityItem.getConfMap(), RequestRouterHandler.Conf.class);
            Context context = this.a;
            String str = null;
            if ((context instanceof GroupChatActivity) && (e2 = ((GroupChatActivity) context).t1().e2()) != null) {
                botsDTO = e2.C0();
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
            Long l = this.k;
            long j2 = 0;
            if (l != null) {
                j = l.longValue();
            } else {
                j = 0;
            }
            StatisticItem param3 = param2.param("fid", j);
            Long l2 = this.j;
            if (l2 != null) {
                j2 = l2.longValue();
            }
            TiebaStatic.log(param3.param("room_id", j2).param("obj_id", conf.getSkillId()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f.setLooping(false);
            this.f.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            this.g.setLooping(true);
            this.f.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        }
    }
}
