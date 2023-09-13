package com.baidu.tieba.view.headcard.playerlist;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tieba.R;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.dxa;
import com.baidu.tieba.hz4;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tha;
import com.baidu.tieba.view.headcard.playerlist.PlayerCardView;
import com.baidu.tieba.zfa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0018H\u0002J\u0006\u0010F\u001a\u00020CJ\u0010\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0007H\u0002J\u000e\u0010J\u001a\u00020C2\u0006\u0010E\u001a\u00020\u0018R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0015\u0010\fR\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001a\u0010\u0012R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000e\u001a\u0004\b\"\u0010\u0012R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u000e\u001a\u0004\b'\u0010\u0012R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u000e\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000e\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u000e\u001a\u0004\b4\u00105R\u001b\u00107\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u000e\u001a\u0004\b8\u0010\u0012R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u000e\u001a\u0004\b=\u0010\u0012R\u001b\u0010?\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u000e\u001a\u0004\b@\u0010\u0012¨\u0006K"}, d2 = {"Lcom/baidu/tieba/view/headcard/playerlist/PlayerCardView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAgreeImg", "Landroid/widget/ImageView;", "getMAgreeImg", "()Landroid/widget/ImageView;", "mAgreeImg$delegate", "Lkotlin/Lazy;", "mAgreeNum", "Landroid/widget/TextView;", "getMAgreeNum", "()Landroid/widget/TextView;", "mAgreeNum$delegate", "mArrowImg", "getMArrowImg", "mArrowImg$delegate", "mData", "Lcom/baidu/tieba/view/headcard/data/MatchPlayerInfoData;", "mGotoMark", "getMGotoMark", "mGotoMark$delegate", "mKDAIcon", "Lcom/baidu/tbadk/core/view/HeadImageView;", "getMKDAIcon", "()Lcom/baidu/tbadk/core/view/HeadImageView;", "mKDAIcon$delegate", "mKDAInfo", "getMKDAInfo", "mKDAInfo$delegate", "mPlayerName", "", "mPlayerNameView", "getMPlayerNameView", "mPlayerNameView$delegate", "mPlayerPhoto", "Lcom/baidu/tbadk/widget/TbImageView;", "getMPlayerPhoto", "()Lcom/baidu/tbadk/widget/TbImageView;", "mPlayerPhoto$delegate", "mRankStarView", "Lcom/baidu/tbadk/widget/RankStarView;", "getMRankStarView", "()Lcom/baidu/tbadk/widget/RankStarView;", "mRankStarView$delegate", "mReplyLayout", "getMReplyLayout", "()Landroid/widget/LinearLayout;", "mReplyLayout$delegate", "mReplyTextView", "getMReplyTextView", "mReplyTextView$delegate", "mRootView", "Landroid/view/View;", "mScore", "getMScore", "mScore$delegate", "mScoreCount", "getMScoreCount", "mScoreCount$delegate", "clickStatisticLog", "", "objType", "data", "onChangeSkinType", "parseStarFromScore", "", "score", "setData", "tbadk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class PlayerCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dxa a;
    public final View b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlayerCardView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlayerCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes8.dex */
    public static final class a implements hz4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayerCardView a;

        @Override // com.baidu.tieba.hz4.d
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "gameCard.playerInfoStar" : (String) invokeV.objValue;
        }

        public a(PlayerCardView playerCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playerCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = playerCardView;
        }

        @Override // com.baidu.tieba.hz4.c
        public void a(String data) {
            boolean z;
            boolean z2;
            Long l;
            Integer num;
            int i;
            double d;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (!TextUtils.isEmpty(data)) {
                    try {
                        JSONObject jSONObject = new JSONObject(data);
                        long optLong = jSONObject.optLong("matchId", -1L);
                        int optInt = jSONObject.optInt("index", -1);
                        long optLong2 = jSONObject.optLong("playerId", -1L);
                        dxa dxaVar = this.a.a;
                        boolean z3 = true;
                        int i2 = 0;
                        if (dxaVar != null && optLong == dxaVar.e()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            return;
                        }
                        dxa dxaVar2 = this.a.a;
                        if (dxaVar2 != null && optInt == dxaVar2.f()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            return;
                        }
                        dxa dxaVar3 = this.a.a;
                        if (dxaVar3 == null || optLong2 != dxaVar3.i()) {
                            z3 = false;
                        }
                        if (z3) {
                            TbLog hybridLog = HybridLog.getInstance();
                            StringBuilder sb = new StringBuilder();
                            sb.append("收到评星数据 matchId:");
                            dxa dxaVar4 = this.a.a;
                            Long l2 = null;
                            if (dxaVar4 != null) {
                                l = Long.valueOf(dxaVar4.e());
                            } else {
                                l = null;
                            }
                            sb.append(l);
                            sb.append(" matchIndex:");
                            dxa dxaVar5 = this.a.a;
                            if (dxaVar5 != null) {
                                num = Integer.valueOf(dxaVar5.f());
                            } else {
                                num = null;
                            }
                            sb.append(num);
                            sb.append("  playerId:");
                            dxa dxaVar6 = this.a.a;
                            if (dxaVar6 != null) {
                                l2 = Long.valueOf(dxaVar6.i());
                            }
                            sb.append(l2);
                            sb.append(GlideException.IndentedAppendable.INDENT);
                            sb.append(jSONObject);
                            hybridLog.i("PlayerCard", sb.toString());
                            dxa dxaVar7 = this.a.a;
                            if (dxaVar7 != null) {
                                i = dxaVar7.m();
                            } else {
                                i = 0;
                            }
                            int optInt2 = jSONObject.optInt("score", i);
                            dxa dxaVar8 = this.a.a;
                            if (dxaVar8 != null) {
                                d = dxaVar8.j();
                            } else {
                                d = 0.0d;
                            }
                            double optDouble = jSONObject.optDouble("averageScore", d);
                            dxa dxaVar9 = this.a.a;
                            if (dxaVar9 != null) {
                                i2 = (int) dxaVar9.k();
                            }
                            int optInt3 = jSONObject.optInt("starTimes", i2);
                            dxa dxaVar10 = this.a.a;
                            Intrinsics.checkNotNull(dxaVar10);
                            dxaVar10.y(optInt2);
                            dxa dxaVar11 = this.a.a;
                            Intrinsics.checkNotNull(dxaVar11);
                            dxaVar11.w(optDouble);
                            dxa dxaVar12 = this.a.a;
                            Intrinsics.checkNotNull(dxaVar12);
                            dxaVar12.x(optInt3);
                            PlayerCardView playerCardView = this.a;
                            dxa dxaVar13 = this.a.a;
                            Intrinsics.checkNotNull(dxaVar13);
                            playerCardView.setData(dxaVar13);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlayerCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<TbImageView>(this) { // from class: com.baidu.tieba.view.headcard.playerlist.PlayerCardView$mPlayerPhoto$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TbImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TbImageView) this.this$0.findViewById(R.id.player_photo);
                }
                return (TbImageView) invokeV.objValue;
            }
        });
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.playerlist.PlayerCardView$mPlayerNameView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.player_name);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<HeadImageView>(this) { // from class: com.baidu.tieba.view.headcard.playerlist.PlayerCardView$mKDAIcon$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HeadImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (HeadImageView) this.this$0.findViewById(R.id.kda_icon);
                }
                return (HeadImageView) invokeV.objValue;
            }
        });
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.playerlist.PlayerCardView$mKDAInfo$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.kda_info);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.playerlist.PlayerCardView$mScore$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.obfuscated_res_0x7f09212b);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.playerlist.PlayerCardView$mScoreCount$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.score_count);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.i = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>(this) { // from class: com.baidu.tieba.view.headcard.playerlist.PlayerCardView$mReplyLayout$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (LinearLayout) this.this$0.findViewById(R.id.hot_reply_content);
                }
                return (LinearLayout) invokeV.objValue;
            }
        });
        this.j = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.playerlist.PlayerCardView$mReplyTextView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.hot_reply_text);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>(this) { // from class: com.baidu.tieba.view.headcard.playerlist.PlayerCardView$mAgreeImg$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (ImageView) this.this$0.findViewById(R.id.reply_agree_img);
                }
                return (ImageView) invokeV.objValue;
            }
        });
        this.l = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.playerlist.PlayerCardView$mAgreeNum$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.reply_agree_num);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.m = LazyKt__LazyJVMKt.lazy(new Function0<RankStarView>(this) { // from class: com.baidu.tieba.view.headcard.playerlist.PlayerCardView$mRankStarView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RankStarView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (RankStarView) this.this$0.findViewById(R.id.item_star);
                }
                return (RankStarView) invokeV.objValue;
            }
        });
        this.n = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.playerlist.PlayerCardView$mGotoMark$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.goto_mark);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.o = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>(this) { // from class: com.baidu.tieba.view.headcard.playerlist.PlayerCardView$mArrowImg$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (ImageView) this.this$0.findViewById(R.id.arrow_img);
                }
                return (ImageView) invokeV.objValue;
            }
        });
        View inflate = LayoutInflater.from(context).inflate(R.layout.recommend_match_player_card, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…_player_card, this, true)");
        this.b = inflate;
        setOrientation(1);
        getMPlayerPhoto().setDrawCorner(true);
        getMPlayerPhoto().setPlaceHolder(0);
        getMPlayerPhoto().setRadiusById(R.string.J_X04);
        getMPlayerPhoto().setConrers(15);
        getMKDAIcon().setScaleType(ImageView.ScaleType.CENTER_CROP);
        getMKDAIcon().setPlaceHolder(1);
        getMKDAIcon().setIsRound(true);
        getMRankStarView().setStarSpacing(BdUtilHelper.getDimens(getContext(), R.dimen.tbds18));
        getMRankStarView().setFullStarColorListIndex(0, zfa.f("#FFA02B"));
        getMRankStarView().setFullStarColorListIndex(1, zfa.f("#FF962B"));
        getMRankStarView().setFullStarColorListIndex(2, zfa.f("#FF8C2B"));
        getMRankStarView().setFullStarColorListIndex(3, zfa.f("#FF842B"));
        getMRankStarView().setFullStarColorListIndex(4, zfa.f("#FF7C2B"));
        hz4.b.a().c(new a(this));
    }

    public /* synthetic */ PlayerCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final float d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i <= 0) {
                return 0.0f;
            }
            return i / 2;
        }
        return invokeI.floatValue;
    }

    public static final boolean e(dxa data, PlayerCardView this$0, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, data, this$0, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            boolean z = false;
            if (motionEvent != null && motionEvent.getAction() == 1) {
                z = true;
            }
            if (z && !TextUtils.isEmpty(data.q())) {
                BrowserHelper.startWebActivity(this$0.getContext(), data.q());
                this$0.b(5, data);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public static final void f(dxa data, PlayerCardView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, data, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!TextUtils.isEmpty(data.q())) {
                BrowserHelper.startWebActivity(this$0.getContext(), data.q());
                this$0.b(4, data);
            }
        }
    }

    private final ImageView getMAgreeImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            Object value = this.k.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mAgreeImg>(...)");
            return (ImageView) value;
        }
        return (ImageView) invokeV.objValue;
    }

    private final TextView getMAgreeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            Object value = this.l.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mAgreeNum>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final ImageView getMArrowImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            Object value = this.o.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mArrowImg>(...)");
            return (ImageView) value;
        }
        return (ImageView) invokeV.objValue;
    }

    private final TextView getMGotoMark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            Object value = this.n.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mGotoMark>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final HeadImageView getMKDAIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            Object value = this.e.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mKDAIcon>(...)");
            return (HeadImageView) value;
        }
        return (HeadImageView) invokeV.objValue;
    }

    private final TextView getMKDAInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            Object value = this.f.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mKDAInfo>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final TextView getMPlayerNameView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            Object value = this.d.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mPlayerNameView>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final TbImageView getMPlayerPhoto() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            Object value = this.c.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mPlayerPhoto>(...)");
            return (TbImageView) value;
        }
        return (TbImageView) invokeV.objValue;
    }

    private final RankStarView getMRankStarView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            Object value = this.m.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mRankStarView>(...)");
            return (RankStarView) value;
        }
        return (RankStarView) invokeV.objValue;
    }

    private final LinearLayout getMReplyLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            Object value = this.i.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mReplyLayout>(...)");
            return (LinearLayout) value;
        }
        return (LinearLayout) invokeV.objValue;
    }

    private final TextView getMReplyTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            Object value = this.j.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mReplyTextView>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final TextView getMScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            Object value = this.g.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mScore>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final TextView getMScoreCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            Object value = this.h.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mScoreCount>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    public final void b(int i, dxa dxaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, dxaVar) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
            statisticItem.param("obj_type", i);
            statisticItem.addParam("obj_locate", dxaVar.n());
            statisticItem.addParam("obj_source", dxaVar.h());
            statisticItem.addParam("fid", dxaVar.b());
            statisticItem.addParam("fname", dxaVar.c());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EMManager.from(this.b).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0204);
            EMManager.from(getMPlayerNameView()).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0105);
            EMManager.from(getMKDAInfo()).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0107);
            EMManager.from(getMScore()).setTextSize(R.dimen.T_X02).setTextColor(R.color.CAM_X0319);
            EMManager.from(getMReplyTextView()).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0319);
            int color = SkinManager.getColor(R.color.CAM_X0301);
            EMManager.from(getMReplyLayout()).setCorner(R.string.J_X18).setGradientColorValue(new int[]{zfa.a(color, 0.06f), zfa.a(color, 0.04f)}, Direction.LEFT);
            WebPManager.setPureDrawable(getMAgreeImg(), R.drawable.icon_pure_danmu_zan, R.color.CAM_X0319, WebPManager.ResourceStateType.NORMAL);
            EMManager.from(getMAgreeNum()).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0319);
            getMRankStarView().f(TbadkCoreApplication.getInst().getSkinType());
            EMManager.from(getMGotoMark()).setTextSize(R.dimen.tbds36).setTextColor(R.color.CAM_X0107);
            WebPManager.setPureDrawable(getMArrowImg(), R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
        }
    }

    public final void setData(final dxa data) {
        AgreeData p;
        TbRichText f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.a = data;
            String a2 = data.a();
            if (a2 != null) {
                getMPlayerPhoto().startLoad(a2, 28, false);
            }
            String g = data.g();
            if (g != null) {
                getMPlayerNameView().setText(g);
            }
            String o = data.o();
            if (o != null) {
                getMKDAIcon().startLoad(o, 28, false);
            }
            String p2 = data.p();
            if (p2 != null) {
                getMKDAInfo().setText(p2);
            }
            getMScore().setText(String.valueOf(data.j()));
            TextView mScoreCount = getMScoreCount();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getResources().getString(R.string.score_count);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.score_count)");
            String format = String.format(string, Arrays.copyOf(new Object[]{StringHelper.numberUniformFormatExtraWithRound(data.k())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            mScoreCount.setText(format);
            tha d = data.d();
            if (d != null && (f0 = d.f0()) != null) {
                getMReplyTextView().setText(f0.toString());
            }
            getMAgreeImg().setVisibility(8);
            getMAgreeNum().setVisibility(8);
            tha d2 = data.d();
            if (d2 != null && (p = d2.p()) != null && p.agreeType == 2) {
                getMAgreeImg().setVisibility(0);
                getMAgreeNum().setVisibility(0);
                getMAgreeNum().setText(StringHelper.numberUniformFormatExtraWithRound(p.agreeNum));
            }
            getMRankStarView().setStarCount(d(data.m()));
            getMRankStarView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ixa
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? PlayerCardView.e(dxa.this, this, view2, motionEvent) : invokeLL.booleanValue;
                }
            });
            getMGotoMark().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.jxa
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        PlayerCardView.f(dxa.this, this, view2);
                    }
                }
            });
            c();
        }
    }
}
