package com.baidu.tieba.immessagecenter.msgtab.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.d65;
import com.baidu.tieba.dm8;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.arch.view.LifecycleRootView;
import com.baidu.tieba.immessagecenter.databinding.MsgTabGuideViewBinding;
import com.baidu.tieba.lha;
import com.baidu.tieba.nha;
import com.baidu.tieba.r95;
import com.baidu.tieba.s75;
import com.baidu.tieba.vn8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0002/0B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\fJ\u0014\u0010\u001f\u001a\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJF\u0010 \u001a\u00020\f2>\u0010\u0011\u001a:\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012j\u0004\u0018\u0001`\u0019J\u0006\u0010!\u001a\u00020\fJ\u0010\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u000eH\u0002J\u0016\u0010#\u001a\u00020\f2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\bJ\u0014\u0010&\u001a\n (*\u0004\u0018\u00010'0'*\u00020)H\u0002J\f\u0010*\u001a\u00020\u0017*\u00020\u0017H\u0002J\f\u0010+\u001a\u00020\u000e*\u00020\u0017H\u0002J\f\u0010,\u001a\u00020\u000e*\u00020\u0017H\u0002J\f\u0010-\u001a\u00020\u000e*\u00020\u0017H\u0002J\f\u0010.\u001a\u00020\u000e*\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000RF\u0010\u0011\u001a:\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012j\u0004\u0018\u0001`\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabGuide;", "", "activity", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "(Lcom/baidu/tbadk/core/BaseFragmentActivity;)V", "binding", "Lcom/baidu/tieba/immessagecenter/databinding/MsgTabGuideViewBinding;", "confLists", "", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabGuide$Conf;", "dismissCallback", "Lkotlin/Function0;", "", "isDataReady", "", "isShowCalledWhenDataNotReady", "isShowing", "showCallback", "Lkotlin/Function2;", "Lcom/baidu/tieba/view/GuideHelper;", "Lkotlin/ParameterName;", "name", "helper", "", "index", "Lcom/baidu/tieba/view/GuideHelperCallback;", "thirdStepAnchorTag", "", "adjustGuideView", "hasThirdStep", "onDataReady", "setOnDismissCallback", "setOnShowCallback", "show", "switchSpriteShow", "trySetThirdStepData", "data", "Lcom/baidu/tieba/immessagecenter/msgtab/data/NavigationData;", "eMManager", "Lcom/baidu/tbadk/core/elementsMaven/EMManager;", "kotlin.jvm.PlatformType", "Landroid/view/View;", "id2Px", "isFirstStep", "isLastStep", "isSecondStep", "isThirdStep", "Companion", "Conf", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabGuide {
    public static /* synthetic */ Interceptable $ic;
    public static final a j;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public final List<Conf> b;
    public final MsgTabGuideViewBinding c;
    public long d;
    public Function2<? super lha, ? super Integer, Unit> e;
    public Function0<Unit> f;
    public boolean g;
    public boolean h;
    public boolean i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-49641000, "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabGuide;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-49641000, "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabGuide;");
                return;
            }
        }
        j = new a(null);
    }

    public /* synthetic */ MsgTabGuide(BaseFragmentActivity baseFragmentActivity, DefaultConstructorMarker defaultConstructorMarker) {
        this(baseFragmentActivity);
    }

    public final boolean o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i == 0 : invokeI.booleanValue;
    }

    public final boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i == 1 : invokeI.booleanValue;
    }

    public final boolean s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? i == 2 : invokeI.booleanValue;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabGuide$Conf;", "Ljava/io/Serializable;", "iconId", "", "iconW", "iconH", "tipsId", "tipsMarginTop", "(IIIII)V", "getIconH", "()I", "getIconId", "getIconW", "getTipsId", "getTipsMarginTop", "component1", "component2", "component3", "component4", "component5", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Conf implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int iconH;
        public final int iconId;
        public final int iconW;
        public final int tipsId;
        public final int tipsMarginTop;

        public static /* synthetic */ Conf copy$default(Conf conf, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = conf.iconId;
            }
            if ((i6 & 2) != 0) {
                i2 = conf.iconW;
            }
            int i7 = i2;
            if ((i6 & 4) != 0) {
                i3 = conf.iconH;
            }
            int i8 = i3;
            if ((i6 & 8) != 0) {
                i4 = conf.tipsId;
            }
            int i9 = i4;
            if ((i6 & 16) != 0) {
                i5 = conf.tipsMarginTop;
            }
            return conf.copy(i, i7, i8, i9, i5);
        }

        public final int component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.iconId : invokeV.intValue;
        }

        public final int component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.iconW : invokeV.intValue;
        }

        public final int component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.iconH : invokeV.intValue;
        }

        public final int component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.tipsId : invokeV.intValue;
        }

        public final int component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.tipsMarginTop : invokeV.intValue;
        }

        public final Conf copy(@DrawableRes int i, int i2, int i3, @StringRes int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) ? new Conf(i, i2, i3, i4, i5) : (Conf) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Conf) {
                    Conf conf = (Conf) obj;
                    return this.iconId == conf.iconId && this.iconW == conf.iconW && this.iconH == conf.iconH && this.tipsId == conf.tipsId && this.tipsMarginTop == conf.tipsMarginTop;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (((((((this.iconId * 31) + this.iconW) * 31) + this.iconH) * 31) + this.tipsId) * 31) + this.tipsMarginTop : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return "Conf(iconId=" + this.iconId + ", iconW=" + this.iconW + ", iconH=" + this.iconH + ", tipsId=" + this.tipsId + ", tipsMarginTop=" + this.tipsMarginTop + ')';
            }
            return (String) invokeV.objValue;
        }

        public Conf(@DrawableRes int i, int i2, int i3, @StringRes int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.iconId = i;
            this.iconW = i2;
            this.iconH = i3;
            this.tipsId = i4;
            this.tipsMarginTop = i5;
        }

        public final int getIconH() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.iconH;
            }
            return invokeV.intValue;
        }

        public final int getIconId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.iconId;
            }
            return invokeV.intValue;
        }

        public final int getIconW() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.iconW;
            }
            return invokeV.intValue;
        }

        public final int getTipsId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.tipsId;
            }
            return invokeV.intValue;
        }

        public final int getTipsMarginTop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.tipsMarginTop;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r95.p().A("key_show_msg_tab_guide", false);
            }
        }

        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return r95.p().l("key_show_msg_tab_guide", true);
            }
            return invokeV.booleanValue;
        }

        public final void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_MSG_TAB_GUIDE_STEP_CLICK);
                statisticItem.param("obj_type", i + 1);
                TiebaStatic.log(statisticItem);
            }
        }

        public final MsgTabGuide d(BaseFragmentActivity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!b()) {
                    return null;
                }
                return new MsgTabGuide(activity, null);
            }
            return (MsgTabGuide) invokeL.objValue;
        }
    }

    public MsgTabGuide(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = baseFragmentActivity;
        this.b = CollectionsKt__CollectionsKt.listOf((Object[]) new Conf[]{new Conf(R.drawable.obfuscated_res_0x7f080a5e, n(R.dimen.tbds260), n(R.dimen.tbds190), R.string.obfuscated_res_0x7f0f0ca1, 0), new Conf(R.drawable.obfuscated_res_0x7f080a5f, n(R.dimen.tbds177), n(R.dimen.tbds338), R.string.obfuscated_res_0x7f0f0ca2, 0), new Conf(R.drawable.obfuscated_res_0x7f080a60, n(R.dimen.tbds145), n(R.dimen.tbds160), R.string.obfuscated_res_0x7f0f0ca3, 0)});
        MsgTabGuideViewBinding c = MsgTabGuideViewBinding.c(LayoutInflater.from(this.a));
        Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.from(activity))");
        this.c = c;
        this.d = -1L;
    }

    public final s75 l(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            return s75.d(view2);
        }
        return (s75) invokeL.objValue;
    }

    public final int n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return UtilHelper.getDimenPixelSize(i);
        }
        return invokeI.intValue;
    }

    public final boolean p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if ((q(i) && !m()) || i == CollectionsKt__CollectionsKt.getLastIndex(this.b)) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void u(Function2<? super lha, ? super Integer, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, function2) == null) {
            this.e = function2;
        }
    }

    public final void k(int i) {
        int i2;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || i >= this.b.size()) {
            return;
        }
        Conf conf = this.b.get(i);
        boolean z = !s(i);
        if (p(i)) {
            i2 = R.string.obfuscated_res_0x7f0f0c9f;
        } else {
            i2 = R.string.obfuscated_res_0x7f0f0ca0;
        }
        if (z) {
            this.c.c.setVisibility(0);
            this.c.e.setVisibility(8);
            imageView = this.c.c;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.icon");
        } else {
            this.c.c.setVisibility(8);
            this.c.e.setVisibility(0);
            imageView = this.c.f;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.originViewIcon");
        }
        imageView.setImageResource(conf.getIconId());
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = conf.getIconW();
        layoutParams.height = conf.getIconH();
        ViewGroup.LayoutParams layoutParams2 = this.c.h.getLayoutParams();
        if (layoutParams2 != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = conf.getTipsMarginTop();
            this.c.h.setText(conf.getTipsId());
            this.c.b.setText(i2);
            TextView textView = this.c.b;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.action");
            s75 l = l(textView);
            l.o(R.string.J_X01);
            l.x(R.color.CAM_X0101);
            l.f(R.color.CAM_X0920);
            this.c.getRoot().invalidate();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d != -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.h = true;
            if (this.i) {
                this.i = false;
                v();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!this.h) {
                this.i = true;
            } else if (!this.g && j.b()) {
                this.g = true;
                lha a2 = lha.i.a(this.a);
                a2.d(new Function0<nha>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgTabGuide$show$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MsgTabGuide this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final nha invoke() {
                        InterceptResult invokeV;
                        MsgTabGuideViewBinding msgTabGuideViewBinding;
                        int n;
                        int n2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                            return (nha) invokeV.objValue;
                        }
                        this.this$0.k(0);
                        nha.a aVar = new nha.a();
                        msgTabGuideViewBinding = this.this$0.c;
                        ConstraintLayout root = msgTabGuideViewBinding.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                        aVar.d(root);
                        aVar.c(R.id.obfuscated_res_0x7f090fd4);
                        aVar.b(-1L);
                        n = this.this$0.n(R.dimen.tbds4);
                        aVar.e(-n);
                        n2 = this.this$0.n(R.dimen.tbds5);
                        aVar.f(n2);
                        return aVar.a();
                    }
                });
                a2.f(new Function2<lha, Integer, Unit>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgTabGuide$show$2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MsgTabGuide this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(lha lhaVar, Integer num) {
                        invoke(lhaVar, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(lha helper, int i) {
                        boolean o;
                        boolean q;
                        boolean m;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, helper, i) == null) {
                            Intrinsics.checkNotNullParameter(helper, "helper");
                            MsgTabGuide.j.c(i);
                            o = this.this$0.o(i);
                            if (o) {
                                this.this$0.k(i + 1);
                                helper.d(new Function0<nha>(this.this$0) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgTabGuide$show$2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ MsgTabGuide this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {r7};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = r7;
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final nha invoke() {
                                        InterceptResult invokeV;
                                        MsgTabGuideViewBinding msgTabGuideViewBinding;
                                        int n;
                                        int n2;
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || (invokeV = interceptable3.invokeV(1048576, this)) == null) {
                                            nha.a aVar = new nha.a();
                                            msgTabGuideViewBinding = this.this$0.c;
                                            ConstraintLayout root = msgTabGuideViewBinding.getRoot();
                                            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                                            aVar.d(root);
                                            aVar.c(R.id.obfuscated_res_0x7f090fd4);
                                            aVar.b(-2L);
                                            n = this.this$0.n(R.dimen.tbds4);
                                            aVar.e(-n);
                                            n2 = this.this$0.n(R.dimen.tbds4);
                                            aVar.f(n2);
                                            return aVar.a();
                                        }
                                        return (nha) invokeV.objValue;
                                    }
                                });
                                return;
                            }
                            q = this.this$0.q(i);
                            if (!q) {
                                return;
                            }
                            m = this.this$0.m();
                            if (m) {
                                this.this$0.k(i + 1);
                                helper.d(new Function0<nha>(this.this$0) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgTabGuide$show$2.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ MsgTabGuide this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {r7};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = r7;
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final nha invoke() {
                                        InterceptResult invokeV;
                                        MsgTabGuideViewBinding msgTabGuideViewBinding;
                                        long j2;
                                        int n;
                                        int n2;
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || (invokeV = interceptable3.invokeV(1048576, this)) == null) {
                                            nha.a aVar = new nha.a();
                                            msgTabGuideViewBinding = this.this$0.c;
                                            ConstraintLayout root = msgTabGuideViewBinding.getRoot();
                                            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                                            aVar.d(root);
                                            aVar.c(R.id.obfuscated_res_0x7f090fd4);
                                            j2 = this.this$0.d;
                                            aVar.b(Long.valueOf(j2));
                                            n = this.this$0.n(R.dimen.tbds3);
                                            aVar.e(-n);
                                            n2 = this.this$0.n(R.dimen.tbds3);
                                            aVar.f(n2);
                                            return aVar.a();
                                        }
                                        return (nha) invokeV.objValue;
                                    }
                                });
                            }
                        }
                    }
                });
                a2.h(this.e);
                a2.g(new Function0<Unit>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgTabGuide$show$3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MsgTabGuide this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                        Function0 function0;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            d65.s("key_show_msg_tab_guide");
                            this.this$0.w(true);
                            this.this$0.g = false;
                            function0 = this.this$0.f;
                            if (function0 != null) {
                                function0.invoke();
                            }
                        }
                    }
                });
                a2.i();
                j.a();
                d65.m("key_show_msg_tab_guide");
                TbSingleton.MsgUpgradeTips.markHasShown();
                TbSingleton.MsgUpgradeTips.setIsMsgTabUpgradeTipsShowing(false);
                w(false);
            }
        }
    }

    public final void w(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (!z) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921809, "source_from_msg_tab_guide");
                MessageManager.getInstance().registerStickyMode(2921809);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            } else {
                CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2921802, "source_from_msg_tab_guide");
                MessageManager.getInstance().registerStickyMode(2921802);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
            }
            MessageManager messageManager = MessageManager.getInstance();
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921810, Integer.valueOf(i)));
        }
    }

    public final void x(List<dm8> list) {
        Object obj;
        dm8 b;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, list) == null) && this.c.g.getChildCount() <= 0 && list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((dm8) obj).getType() == 3) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            dm8 dm8Var = (dm8) obj;
            if (dm8Var != null && (b = dm8.b(dm8Var, 0L, 6, false, 5, null)) != null) {
                this.d = b.c();
                vn8 vn8Var = new vn8(this.a);
                BaseView.H(vn8Var, this.a, this.c.g, false, false, 8, null);
                vn8Var.N(b);
                LifecycleRootView l = vn8Var.l();
                l.setScaleX(1.3f);
                l.setScaleY(1.3f);
                LifecycleRootView l2 = vn8Var.l();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                l2.setLayoutParams(layoutParams);
                this.c.g.addView(vn8Var.l());
            }
        }
    }
}
