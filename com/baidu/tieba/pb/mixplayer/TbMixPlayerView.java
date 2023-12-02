package com.baidu.tieba.pb.mixplayer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.player.layer.AbsLayer;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.BasicVideoSeriesKt;
import com.baidu.searchbox.player.model.OptionState;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.LiveRoomEntranceButton;
import com.baidu.tbadk.widget.CardLiveLabelView;
import com.baidu.tieba.R;
import com.baidu.tieba.hy9;
import com.baidu.tieba.jt5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pb.mixplayer.TbLiveMixPlayerConfig;
import com.baidu.tieba.pb.mixplayer.TbMixPlayerView;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.yz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\\]B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010>\u001a\u00020?J\b\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020AH\u0002J\b\u0010C\u001a\u00020AH\u0002J\b\u0010D\u001a\u00020AH\u0002J\b\u0010E\u001a\u00020AH\u0002J\b\u0010F\u001a\u00020AH\u0002J\u0010\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020A2\u0006\u0010K\u001a\u00020IH\u0002J\b\u0010L\u001a\u00020AH\u0002J\u0010\u0010M\u001a\u00020A2\u0006\u0010N\u001a\u00020\bH\u0002J\u0006\u0010O\u001a\u00020AJ\u0006\u0010P\u001a\u00020AJ\u0006\u0010Q\u001a\u00020AJ\u0006\u0010R\u001a\u00020AJ\b\u0010S\u001a\u00020AH\u0002J\u000e\u0010T\u001a\u00020A2\u0006\u0010U\u001a\u000207J\u0018\u0010V\u001a\u00020A2\u0006\u0010W\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010Z\u001a\u00020A2\u0006\u0010$\u001a\u00020%H\u0002J\u0006\u0010[\u001a\u00020AR\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0013\u0010\nR\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/baidu/tieba/pb/mixplayer/TbMixPlayerView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveCloseCover", "Landroid/widget/ImageView;", "getLiveCloseCover", "()Landroid/widget/ImageView;", "liveCloseCover$delegate", "Lkotlin/Lazy;", "liveCloseCoverMask", "Landroid/view/View;", "getLiveCloseCoverMask", "()Landroid/view/View;", "liveCloseCoverMask$delegate", "liveCloseIcon", "getLiveCloseIcon", "liveCloseIcon$delegate", "liveLabelView", "Lcom/baidu/tbadk/widget/CardLiveLabelView;", "getLiveLabelView", "()Lcom/baidu/tbadk/widget/CardLiveLabelView;", "liveLabelView$delegate", "liveLoading", "Landroid/widget/ProgressBar;", "getLiveLoading", "()Landroid/widget/ProgressBar;", "liveLoading$delegate", "liveRoomEntranceButton", "Lcom/baidu/tbadk/coreExtra/view/LiveRoomEntranceButton;", "getLiveRoomEntranceButton", "()Lcom/baidu/tbadk/coreExtra/view/LiveRoomEntranceButton;", "liveRoomEntranceButton$delegate", "liveStatus", "Lcom/baidu/tieba/pb/mixplayer/TbLiveMixPlayerConfig$LiveStatus;", "getLiveStatus", "()Lcom/baidu/tieba/pb/mixplayer/TbLiveMixPlayerConfig$LiveStatus;", "setLiveStatus", "(Lcom/baidu/tieba/pb/mixplayer/TbLiveMixPlayerConfig$LiveStatus;)V", "onClickCallback", "Lcom/baidu/tieba/pb/mixplayer/TbMixPlayerView$ClickCallback;", "getOnClickCallback", "()Lcom/baidu/tieba/pb/mixplayer/TbMixPlayerView$ClickCallback;", "setOnClickCallback", "(Lcom/baidu/tieba/pb/mixplayer/TbMixPlayerView$ClickCallback;)V", "playerStatusCallBack", "Lcom/baidu/tieba/pb/mixplayer/TbMixPlayerView$PlayerStatusCallBack;", "getPlayerStatusCallBack", "()Lcom/baidu/tieba/pb/mixplayer/TbMixPlayerView$PlayerStatusCallBack;", "setPlayerStatusCallBack", "(Lcom/baidu/tieba/pb/mixplayer/TbMixPlayerView$PlayerStatusCallBack;)V", "tbMixPlayerConfig", "Lcom/baidu/tieba/pb/mixplayer/TbMixPlayerConfig;", "getTbMixPlayerConfig", "()Lcom/baidu/tieba/pb/mixplayer/TbMixPlayerConfig;", "setTbMixPlayerConfig", "(Lcom/baidu/tieba/pb/mixplayer/TbMixPlayerConfig;)V", "tbVideoView", "Lcom/baidu/tieba/play/TbVideoView;", "getPlayerHeight", "", "initClickListener", "", "initLiveCloseCover", "initLiveCloseCoverMask", "initLiveCloseIcon", "initLiveLabelView", "initLiveLoading", "initLivePlayer", "liveMixPlayerConfig", "Lcom/baidu/tieba/pb/mixplayer/TbLiveMixPlayerConfig;", "initLiveRoomEntranceButton", "tbLiveMixPlayerConfig", "initVideoView", "loadLiveCover", "coverView", DownloadStatisticConstants.UBC_TYPE_PAUSE, "play", "release", DownloadStatisticConstants.UBC_TYPE_RESUME, "setLiveViewScale", "setMixPlayerConfig", "mixPlayerConfig", "setMixPlayerViewSize", "view", "aspectRadio", "", "setViewByLiveStatus", "stop", "ClickCallback", "PlayerStatusCallBack", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class TbMixPlayerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbVideoView a;
    public final Lazy b;
    public hy9 c;
    public a d;
    public b e;
    public TbLiveMixPlayerConfig.LiveStatus f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;

    /* loaded from: classes7.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onError();

        void onPause();

        void onRelease();

        void onStart();

        void onStop();
    }

    /* loaded from: classes7.dex */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1585401001, "Lcom/baidu/tieba/pb/mixplayer/TbMixPlayerView$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1585401001, "Lcom/baidu/tieba/pb/mixplayer/TbMixPlayerView$c;");
                    return;
                }
            }
            int[] iArr = new int[TbLiveMixPlayerConfig.LiveStatus.values().length];
            iArr[TbLiveMixPlayerConfig.LiveStatus.LOADING.ordinal()] = 1;
            iArr[TbLiveMixPlayerConfig.LiveStatus.PLAY.ordinal()] = 2;
            iArr[TbLiveMixPlayerConfig.LiveStatus.ERROR.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbMixPlayerView(Context context) {
        this(context, null, 2, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes7.dex */
    public static final class d extends CustomTarget<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
            }
        }

        public d(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageView;
        }

        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, resource, transition) == null) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                this.a.setImageBitmap(jt5.a(resource, 50, false));
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbMixPlayerView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new TbVideoView(context);
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<CardLiveLabelView>(context) { // from class: com.baidu.tieba.pb.mixplayer.TbMixPlayerView$liveLabelView$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CardLiveLabelView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new CardLiveLabelView(this.$context);
                }
                return (CardLiveLabelView) invokeV.objValue;
            }
        });
        this.f = TbLiveMixPlayerConfig.LiveStatus.INIT;
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<LiveRoomEntranceButton>(context, this) { // from class: com.baidu.tieba.pb.mixplayer.TbMixPlayerView$liveRoomEntranceButton$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbMixPlayerView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context, this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
                this.this$0 = this;
            }

            /* loaded from: classes7.dex */
            public static final class a implements LiveRoomEntranceButton.ClickCallBack {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveRoomEntranceButton a;
                public final /* synthetic */ TbMixPlayerView b;

                public a(LiveRoomEntranceButton liveRoomEntranceButton, TbMixPlayerView tbMixPlayerView) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {liveRoomEntranceButton, tbMixPlayerView};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = liveRoomEntranceButton;
                    this.b = tbMixPlayerView;
                }

                @Override // com.baidu.tbadk.coreExtra.view.LiveRoomEntranceButton.ClickCallBack
                public void a(LiveRoomEntranceButton.ClickCallBack.ClickType clickType, Object obj) {
                    LiveRoomEntranceButton.a liveRoomEntranceData;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(1048576, this, clickType, obj) == null) {
                        Intrinsics.checkNotNullParameter(clickType, "clickType");
                        if (clickType == LiveRoomEntranceButton.ClickCallBack.ClickType.ENTER_CLICK && (liveRoomEntranceData = this.a.getLiveRoomEntranceData()) != null) {
                            TbMixPlayerView tbMixPlayerView = this.b;
                            if (!StringsKt__StringsJVMKt.isBlank(liveRoomEntranceData.a())) {
                                UrlManager.getInstance().dealOneLink(liveRoomEntranceData.a());
                            }
                            TbMixPlayerView.a onClickCallback = tbMixPlayerView.getOnClickCallback();
                            if (onClickCallback != null) {
                                onClickCallback.onClick();
                            }
                        }
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LiveRoomEntranceButton invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    LiveRoomEntranceButton liveRoomEntranceButton = new LiveRoomEntranceButton(this.$context, null, 2, null);
                    TbMixPlayerView tbMixPlayerView = this.this$0;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds650), UtilHelper.getDimenPixelSize(R.dimen.tbds107));
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                    layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
                    tbMixPlayerView.addView(liveRoomEntranceButton, layoutParams);
                    liveRoomEntranceButton.a();
                    liveRoomEntranceButton.setClickCallBack(new a(liveRoomEntranceButton, tbMixPlayerView));
                    return liveRoomEntranceButton;
                }
                return (LiveRoomEntranceButton) invokeV.objValue;
            }
        });
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>(context) { // from class: com.baidu.tieba.pb.mixplayer.TbMixPlayerView$liveCloseIcon$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new ImageView(this.$context);
                }
                return (ImageView) invokeV.objValue;
            }
        });
        this.i = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>(context) { // from class: com.baidu.tieba.pb.mixplayer.TbMixPlayerView$liveCloseCover$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new ImageView(this.$context);
                }
                return (ImageView) invokeV.objValue;
            }
        });
        this.j = LazyKt__LazyJVMKt.lazy(new Function0<View>(context) { // from class: com.baidu.tieba.pb.mixplayer.TbMixPlayerView$liveCloseCoverMask$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new View(this.$context);
                }
                return (View) invokeV.objValue;
            }
        });
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<ProgressBar>(context) { // from class: com.baidu.tieba.pb.mixplayer.TbMixPlayerView$liveLoading$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ProgressBar invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new ProgressBar(this.$context);
                }
                return (ProgressBar) invokeV.objValue;
            }
        });
        k();
        b();
    }

    public /* synthetic */ TbMixPlayerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void r(View view2, float f) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(1048595, this, view2, f) == null) && f > 0.0f && (layoutParams = view2.getLayoutParams()) != null) {
            layoutParams.height = MathKt__MathJVMKt.roundToInt(BdUtilHelper.getEquipmentWidth(getContext(), true) / f);
        }
    }

    public static final void c(TbMixPlayerView this$0, View view2) {
        TbLiveMixPlayerConfig tbLiveMixPlayerConfig;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            hy9 hy9Var = this$0.c;
            if (hy9Var instanceof TbLiveMixPlayerConfig) {
                tbLiveMixPlayerConfig = (TbLiveMixPlayerConfig) hy9Var;
            } else {
                tbLiveMixPlayerConfig = null;
            }
            if (tbLiveMixPlayerConfig != null) {
                String str = tbLiveMixPlayerConfig.a().mScheme;
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    UrlManager.getInstance().dealOneLink(str);
                }
            }
            a aVar = this$0.d;
            if (aVar != null) {
                aVar.onClick();
            }
        }
    }

    private final ImageView getLiveCloseCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return (ImageView) this.i.getValue();
        }
        return (ImageView) invokeV.objValue;
    }

    private final View getLiveCloseCoverMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return (View) this.j.getValue();
        }
        return (View) invokeV.objValue;
    }

    private final ImageView getLiveCloseIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            return (ImageView) this.h.getValue();
        }
        return (ImageView) invokeV.objValue;
    }

    private final CardLiveLabelView getLiveLabelView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            return (CardLiveLabelView) this.b.getValue();
        }
        return (CardLiveLabelView) invokeV.objValue;
    }

    private final ProgressBar getLiveLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            return (ProgressBar) this.k.getValue();
        }
        return (ProgressBar) invokeV.objValue;
    }

    private final LiveRoomEntranceButton getLiveRoomEntranceButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            return (LiveRoomEntranceButton) this.g.getValue();
        }
        return (LiveRoomEntranceButton) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gy9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        TbMixPlayerView.c(TbMixPlayerView.this, view2);
                    }
                }
            });
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || getLiveCloseCover().getParent() != null) {
            return;
        }
        addView(getLiveCloseCover(), new RelativeLayout.LayoutParams(-1, -1));
        getLiveCloseCover().setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public final TbLiveMixPlayerConfig.LiveStatus getLiveStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return (TbLiveMixPlayerConfig.LiveStatus) invokeV.objValue;
    }

    public final a getOnClickCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (a) invokeV.objValue;
    }

    public final int getPlayerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                return layoutParams.height;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final b getPlayerStatusCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (b) invokeV.objValue;
    }

    public final hy9 getTbMixPlayerConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return (hy9) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
            this.a.setVideoStatusChangeListener(new OnStatusChangedListener() { // from class: com.baidu.tieba.fy9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.play.OnStatusChangedListener
                public final void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, videoStatus) == null) {
                        TbMixPlayerView.l(TbMixPlayerView.this, videoStatus);
                    }
                }
            });
            this.a.setUseDurationStatistic(false);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            DefaultLog.getInstance().i("TbMixPlayer", "释放-release");
            this.a.O();
            b bVar = this.e;
            if (bVar != null) {
                bVar.onRelease();
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            DefaultLog.getInstance().i("TbMixPlayer", "停止-stop");
            this.a.V();
            b bVar = this.e;
            if (bVar != null) {
                bVar.onStop();
            }
        }
    }

    public static final void l(TbMixPlayerView this$0, OnStatusChangedListener.VideoStatus videoStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, this$0, videoStatus) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("TbMixPlayer", "播放器状态: " + videoStatus.name());
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_ERROR) {
                this$0.setViewByLiveStatus(TbLiveMixPlayerConfig.LiveStatus.ERROR);
                b bVar = this$0.e;
                if (bVar != null) {
                    bVar.onError();
                }
            } else if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                this$0.setViewByLiveStatus(TbLiveMixPlayerConfig.LiveStatus.PLAY);
                b bVar2 = this$0.e;
                if (bVar2 != null) {
                    bVar2.onStart();
                }
            }
        }
    }

    private final void setViewByLiveStatus(TbLiveMixPlayerConfig.LiveStatus liveStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, liveStatus) == null) {
            int i = c.$EnumSwitchMapping$0[liveStatus.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        getLiveLabelView().setVisibility(8);
                        getLiveRoomEntranceButton().setVisibility(8);
                        getLiveLoading().setVisibility(8);
                        getLiveCloseIcon().setVisibility(0);
                        getLiveCloseCover().setVisibility(0);
                        getLiveCloseCoverMask().setVisibility(0);
                        m(getLiveCloseCover());
                    }
                } else {
                    getLiveLabelView().setVisibility(0);
                    getLiveRoomEntranceButton().setVisibility(0);
                    getLiveCloseIcon().setVisibility(8);
                    getLiveCloseCover().setVisibility(8);
                    getLiveCloseCoverMask().setVisibility(8);
                    getLiveLoading().setVisibility(8);
                }
            } else {
                getLiveLoading().setVisibility(0);
                getLiveCloseCover().setVisibility(0);
                getLiveCloseCoverMask().setVisibility(0);
                getLiveCloseIcon().setVisibility(8);
                getLiveLabelView().setVisibility(8);
                getLiveRoomEntranceButton().setVisibility(8);
                m(getLiveCloseCover());
            }
            this.f = liveStatus;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getLiveCloseCoverMask().getParent() != null) {
            return;
        }
        addView(getLiveCloseCoverMask(), new RelativeLayout.LayoutParams(-1, -1));
        EMManager.from(getLiveCloseCoverMask()).setBackGroundColor(R.color.CAM_X0605);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || getLiveCloseIcon().getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        addView(getLiveCloseIcon(), layoutParams);
        SkinManager.setImageResource(getLiveCloseIcon(), R.drawable.icon_live_stop_play);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if ((this.c instanceof TbLiveMixPlayerConfig) && TbLiveMixPlayerConfig.LiveStatus.PLAY != this.f) {
                return;
            }
            DefaultLog.getInstance().i("TbMixPlayer", "暂停-pause");
            this.a.pause();
            b bVar = this.e;
            if (bVar != null) {
                bVar.onPause();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.c instanceof TbLiveMixPlayerConfig) {
                TbLiveMixPlayerConfig.LiveStatus liveStatus = TbLiveMixPlayerConfig.LiveStatus.LOADING;
                TbLiveMixPlayerConfig.LiveStatus liveStatus2 = this.f;
                if (liveStatus != liveStatus2 && TbLiveMixPlayerConfig.LiveStatus.ERROR != liveStatus2) {
                    setViewByLiveStatus(TbLiveMixPlayerConfig.LiveStatus.LOADING);
                } else {
                    return;
                }
            }
            DefaultLog.getInstance().i("TbMixPlayer", "播放-play");
            this.a.start();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || getLiveLabelView().getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds34);
        addView(getLiveLabelView(), layoutParams);
        getLiveLabelView().setViewType(2);
        getLiveLabelView().f();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || getLiveLoading().getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds125), UtilHelper.getDimenPixelSize(R.dimen.tbds125));
        layoutParams.addRule(13);
        getLiveLoading().setIndeterminateTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.CAM_X0622)));
        addView(getLiveLoading(), layoutParams);
        getLiveLoading().setVisibility(8);
    }

    public final void q() {
        TbLiveMixPlayerConfig tbLiveMixPlayerConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            hy9 hy9Var = this.c;
            if (hy9Var instanceof TbLiveMixPlayerConfig) {
                tbLiveMixPlayerConfig = (TbLiveMixPlayerConfig) hy9Var;
            } else {
                tbLiveMixPlayerConfig = null;
            }
            if (tbLiveMixPlayerConfig != null) {
                yz4 yz4Var = tbLiveMixPlayerConfig.a().mContainerSize;
                yz4 yz4Var2 = tbLiveMixPlayerConfig.a().mPlayerSize;
                if (yz4Var != null && yz4Var2 != null && !yz4Var.c() && !yz4Var2.c()) {
                    r(this, (yz4Var.b() * 1.0f) / yz4Var.a());
                } else {
                    r(this, 1.78f);
                }
            }
        }
    }

    public final void i(TbLiveMixPlayerConfig tbLiveMixPlayerConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbLiveMixPlayerConfig) == null) {
            BasicVideoSeries basicVideoSeries$default = BasicVideoSeriesKt.toBasicVideoSeries$default(tbLiveMixPlayerConfig.a().mFlv, false, 1, null);
            basicVideoSeries$default.setPreRenderOptionState(OptionState.ENABLE);
            this.a.setVideoSeries(basicVideoSeries$default, true);
        }
    }

    public final void setLiveStatus(TbLiveMixPlayerConfig.LiveStatus liveStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, liveStatus) == null) {
            Intrinsics.checkNotNullParameter(liveStatus, "<set-?>");
            this.f = liveStatus;
        }
    }

    public final void setOnClickCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            this.d = aVar;
        }
    }

    public final void setPlayerStatusCallBack(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public final void setTbMixPlayerConfig(hy9 hy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, hy9Var) == null) {
            this.c = hy9Var;
        }
    }

    public final void j(TbLiveMixPlayerConfig tbLiveMixPlayerConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tbLiveMixPlayerConfig) == null) {
            LiveRoomEntranceButton liveRoomEntranceButton = getLiveRoomEntranceButton();
            String string = getContext().getString(R.string.live_room_entrance_text);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri….live_room_entrance_text)");
            String str = tbLiveMixPlayerConfig.a().mScheme;
            if (str == null) {
                str = "";
            }
            liveRoomEntranceButton.setLiveRoomEntranceData(new LiveRoomEntranceButton.a(string, str));
        }
    }

    public final void m(ImageView imageView) {
        TbLiveMixPlayerConfig tbLiveMixPlayerConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, imageView) == null) {
            hy9 hy9Var = this.c;
            if (hy9Var instanceof TbLiveMixPlayerConfig) {
                tbLiveMixPlayerConfig = (TbLiveMixPlayerConfig) hy9Var;
            } else {
                tbLiveMixPlayerConfig = null;
            }
            if (tbLiveMixPlayerConfig != null) {
                d dVar = (d) Glide.with(this).asBitmap().load(tbLiveMixPlayerConfig.a().cover).into((RequestBuilder<Bitmap>) new d(imageView));
            }
        }
    }

    public final void setMixPlayerConfig(hy9 mixPlayerConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, mixPlayerConfig) == null) {
            Intrinsics.checkNotNullParameter(mixPlayerConfig, "mixPlayerConfig");
            this.c = mixPlayerConfig;
            if (mixPlayerConfig instanceof TbLiveMixPlayerConfig) {
                DefaultLog.getInstance().i("TbMixPlayer", "设置直播配置数据");
                TbLiveMixPlayerConfig tbLiveMixPlayerConfig = (TbLiveMixPlayerConfig) mixPlayerConfig;
                i(tbLiveMixPlayerConfig);
                q();
                g();
                j(tbLiveMixPlayerConfig);
                d();
                e();
                f();
                h();
                this.f = TbLiveMixPlayerConfig.LiveStatus.INIT;
                this.a.v();
                this.a.F(new AbsLayer(this) { // from class: com.baidu.tieba.pb.mixplayer.TbMixPlayerView$setMixPlayerConfig$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final Lazy a;
                    public final /* synthetic */ TbMixPlayerView b;

                    @Override // com.baidu.searchbox.player.interfaces.INeuron
                    public int[] getSubscribeEvent() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return null;
                        }
                        return (int[]) invokeV.objValue;
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>(this) { // from class: com.baidu.tieba.pb.mixplayer.TbMixPlayerView$setMixPlayerConfig$1$liveVideoCoverView$2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ TbMixPlayerView this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr2 = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i3 = newInitContext2.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final FrameLayout invoke() {
                                InterceptResult invokeV;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || (invokeV = interceptable3.invokeV(1048576, this)) == null) {
                                    FrameLayout frameLayout = new FrameLayout(this.this$0.getContext());
                                    ImageView imageView = new ImageView(this.this$0.getContext());
                                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                    frameLayout.setTag(imageView);
                                    frameLayout.addView(imageView);
                                    View view2 = new View(this.this$0.getContext());
                                    frameLayout.addView(view2);
                                    EMManager.from(view2).setBackGroundColor(R.color.CAM_X0605);
                                    return frameLayout;
                                }
                                return (FrameLayout) invokeV.objValue;
                            }
                        });
                    }

                    public final FrameLayout a() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return (FrameLayout) this.a.getValue();
                        }
                        return (FrameLayout) invokeV.objValue;
                    }

                    @Override // com.baidu.searchbox.player.layer.ILayer
                    public View getContentView() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            TbMixPlayerView tbMixPlayerView = this.b;
                            Object tag = a().getTag();
                            if (tag == null) {
                                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                            }
                            tbMixPlayerView.m((ImageView) tag);
                            return a();
                        }
                        return (View) invokeV.objValue;
                    }
                }, 0);
            }
        }
    }
}
