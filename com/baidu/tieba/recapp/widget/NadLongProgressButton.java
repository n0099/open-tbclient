package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.eg0;
import com.baidu.tieba.u06;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001JB'\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u0002022\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u000209J\u0012\u0010:\u001a\u0002022\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0012\u0010;\u001a\u0002022\b\u00106\u001a\u0004\u0018\u000107H\u0002J\b\u0010<\u001a\u00020\u0001H\u0016J\b\u0010=\u001a\u00020\u0001H\u0016J\b\u0010>\u001a\u000202H\u0002J\u0010\u0010?\u001a\u0002022\u0006\u00108\u001a\u00020\bH\u0016J\u0012\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010C\u001a\u0002022\b\u00106\u001a\u0004\u0018\u000107H\u0014J\u0012\u0010D\u001a\u0002022\b\u0010E\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010F\u001a\u0002022\b\u0010G\u001a\u0004\u0018\u00010\u000b2\u0006\u0010H\u001a\u00020IH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b\"\u0010\u0013R\u0010\u0010$\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0015\u001a\u0004\b,\u0010-R\u0010\u0010/\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/baidu/tieba/recapp/widget/NadLongProgressButton;", "Landroid/view/View;", "Lcom/baidu/tieba/ad/download/mvp/IDownloadView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonText", "", "clickInterceptListener", "Lcom/baidu/tieba/ad/download/mvp/IDownloadView$OnClickInterceptListener;", "horizontalDistance", "", "iconPaint", "Landroid/graphics/Paint;", "getIconPaint", "()Landroid/graphics/Paint;", "iconPaint$delegate", "Lkotlin/Lazy;", "iconShader", "Landroid/graphics/Shader;", "iconSize", "progress", "progressBgColor", "progressBgColorRes", "progressOval", "Landroid/graphics/RectF;", "getProgressOval", "()Landroid/graphics/RectF;", "progressOval$delegate", "progressPaint", "getProgressPaint", "progressPaint$delegate", "progressShader", "radius", "status", "Lcom/baidu/nadcore/download/consts/AdDownloadStatus;", "textColorInProgress", "textColorInProgressRes", "textPaint", "Landroid/text/TextPaint;", "getTextPaint", "()Landroid/text/TextPaint;", "textPaint$delegate", "textShader", "textSize", UbcRemoteStat.BIND_SERVICE, "", "p0", "Landroid/view/ViewGroup;", "drawIcon", "canvas", "Landroid/graphics/Canvas;", "type", "Lcom/baidu/tieba/recapp/widget/NadLongProgressButton$IconType;", "drawProgress", "drawText", "getActionBar", "getRealView", "initPaint", "onChangeSkinType", "onClickIntercept", "", "view", "onDraw", "setOnClickInterceptListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, StickerDataChangeType.UPDATE, "text", "adDownloadBean", "Lcom/baidu/nadcore/download/model/AdDownloadBean;", "IconType", "recApp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NadLongProgressButton extends View implements u06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public int c;
    public int d;
    public int e;
    public AdDownloadStatus f;
    public String g;
    public float h;
    public float i;
    public float j;
    public u06.a k;
    public int l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public Shader q;
    public Shader r;
    public Shader s;

    /* loaded from: classes7.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(432064941, "Lcom/baidu/tieba/recapp/widget/NadLongProgressButton$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(432064941, "Lcom/baidu/tieba/recapp/widget/NadLongProgressButton$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            iArr[AdDownloadStatus.FAILED.ordinal()] = 2;
            iArr[AdDownloadStatus.COMPLETED.ordinal()] = 3;
            iArr[AdDownloadStatus.INSTALLED.ordinal()] = 4;
            iArr[AdDownloadStatus.PAUSE.ordinal()] = 5;
            iArr[AdDownloadStatus.DOWNLOADING.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[IconType.values().length];
            iArr2[IconType.LEFT.ordinal()] = 1;
            iArr2[IconType.RIGHT.ordinal()] = 2;
            iArr2[IconType.FINISH_DOWNLOAD.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadLongProgressButton(Context context) {
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadLongProgressButton(Context context, AttributeSet attributeSet) {
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
    }

    @Override // com.baidu.tieba.xg0
    public void d(ViewGroup p0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, p0) == null) {
            Intrinsics.checkNotNullParameter(p0, "p0");
        }
    }

    public View getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xg0
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (View) invokeV.objValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/tieba/recapp/widget/NadLongProgressButton$IconType;", "", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "FINISH_DOWNLOAD", "recApp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class IconType {
        public static final /* synthetic */ IconType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final IconType FINISH_DOWNLOAD;
        public static final IconType LEFT;
        public static final IconType RIGHT;
        public transient /* synthetic */ FieldHolder $fh;

        public static final /* synthetic */ IconType[] $values() {
            return new IconType[]{LEFT, RIGHT, FINISH_DOWNLOAD};
        }

        public static IconType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (IconType) Enum.valueOf(IconType.class, str) : (IconType) invokeL.objValue;
        }

        public static IconType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (IconType[]) $VALUES.clone() : (IconType[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1925984789, "Lcom/baidu/tieba/recapp/widget/NadLongProgressButton$IconType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1925984789, "Lcom/baidu/tieba/recapp/widget/NadLongProgressButton$IconType;");
                    return;
                }
            }
            LEFT = new IconType("LEFT", 0);
            RIGHT = new IconType("RIGHT", 1);
            FINISH_DOWNLOAD = new IconType("FINISH_DOWNLOAD", 2);
            $VALUES = $values();
        }

        public IconType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadLongProgressButton(Context context, AttributeSet attributeSet, int i) {
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
        new LinkedHashMap();
        this.a = R.color.CAM_X0101;
        this.b = R.color.CAM_X0302;
        this.c = SkinManager.getColor(R.color.CAM_X0101);
        this.d = SkinManager.getColor(this.b);
        this.f = AdDownloadStatus.NONE;
        this.g = "";
        this.h = getResources().getDimensionPixelSize(R.dimen.T_X12);
        this.i = getResources().getDimensionPixelSize(R.dimen.M_H_X005);
        this.j = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
        this.l = getResources().getDimensionPixelSize(R.dimen.tbds21);
        this.m = LazyKt__LazyJVMKt.lazy(NadLongProgressButton$progressOval$2.INSTANCE);
        this.n = LazyKt__LazyJVMKt.lazy(NadLongProgressButton$progressPaint$2.INSTANCE);
        this.o = LazyKt__LazyJVMKt.lazy(NadLongProgressButton$textPaint$2.INSTANCE);
        this.p = LazyKt__LazyJVMKt.lazy(NadLongProgressButton$iconPaint$2.INSTANCE);
        g();
    }

    public /* synthetic */ NadLongProgressButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final Paint getIconPaint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return (Paint) this.p.getValue();
        }
        return (Paint) invokeV.objValue;
    }

    private final RectF getProgressOval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return (RectF) this.m.getValue();
        }
        return (RectF) invokeV.objValue;
    }

    private final Paint getProgressPaint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return (Paint) this.n.getValue();
        }
        return (Paint) invokeV.objValue;
    }

    private final TextPaint getTextPaint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            return (TextPaint) this.o.getValue();
        }
        return (TextPaint) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            getProgressPaint().setAntiAlias(true);
            getProgressPaint().setStyle(Paint.Style.FILL);
            getProgressPaint().setColor(this.d);
        }
    }

    @Override // com.baidu.tieba.u06
    public boolean a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            u06.a aVar = this.k;
            if (aVar != null) {
                return aVar.a(view2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.u06
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.c = SkinManager.getColor(this.a);
            this.d = SkinManager.getColor(this.b);
            postInvalidate();
        }
    }

    @Override // com.baidu.tieba.u06
    public void setOnClickInterceptListener(u06.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.k = aVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Canvas canvas, IconType type) {
        Bitmap decodeResource;
        float f;
        float f2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, type) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            getIconPaint().setStyle(Paint.Style.FILL);
            getIconPaint().setColor(this.d);
            float f3 = this.e / 100.0f;
            int i = a.$EnumSwitchMapping$1[type.ordinal()];
            float f4 = 0.0f;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        decodeResource = null;
                        f2 = 0.0f;
                    } else {
                        decodeResource = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.icon_pure_image_ok_select17);
                        f4 = this.j;
                        f = this.i;
                    }
                } else {
                    decodeResource = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.icon_pure_list_arrow16_right);
                    float measuredWidth = getMeasuredWidth() - this.j;
                    f2 = measuredWidth;
                    f4 = measuredWidth - this.i;
                }
                float f5 = this.i;
                Bitmap extractAlpha = Bitmap.createScaledBitmap(decodeResource, (int) f5, (int) f5, false).copy(Bitmap.Config.ARGB_8888, true).extractAlpha();
                float measuredWidth2 = getMeasuredWidth() * f3;
                float f6 = (measuredWidth2 - f4) / this.i;
                switch (a.$EnumSwitchMapping$0[this.f.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        getIconPaint().setShader(null);
                        getIconPaint().setColor(this.c);
                        break;
                    case 5:
                    case 6:
                        if (measuredWidth2 <= f4) {
                            getIconPaint().setShader(null);
                            getIconPaint().setColor(this.d);
                            break;
                        } else {
                            if (f4 <= measuredWidth2 && measuredWidth2 <= f2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                this.s = new LinearGradient(0.0f, 0.0f, this.i, 0.0f, new int[]{this.c, this.d}, new float[]{f6, f6 + 0.001f}, Shader.TileMode.CLAMP);
                                getIconPaint().setShader(this.s);
                                getIconPaint().setColor(this.d);
                                break;
                            } else {
                                getIconPaint().setShader(null);
                                getIconPaint().setColor(this.c);
                                break;
                            }
                        }
                }
                if (canvas == null) {
                    canvas.drawBitmap(extractAlpha, f4, (getMeasuredHeight() / 2) - (this.i / 2), getIconPaint());
                    return;
                }
                return;
            }
            decodeResource = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.icon_pure_pb_recommend_save30);
            f4 = this.j;
            f = this.i;
            f2 = f + f4;
            float f52 = this.i;
            Bitmap extractAlpha2 = Bitmap.createScaledBitmap(decodeResource, (int) f52, (int) f52, false).copy(Bitmap.Config.ARGB_8888, true).extractAlpha();
            float measuredWidth22 = getMeasuredWidth() * f3;
            float f62 = (measuredWidth22 - f4) / this.i;
            switch (a.$EnumSwitchMapping$0[this.f.ordinal()]) {
            }
            if (canvas == null) {
            }
        }
    }

    @Override // com.baidu.tieba.xg0
    public void c(String str, eg0 adDownloadBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, adDownloadBean) == null) {
            Intrinsics.checkNotNullParameter(adDownloadBean, "adDownloadBean");
            AdDownloadStatus adDownloadStatus = adDownloadBean.c;
            Intrinsics.checkNotNullExpressionValue(adDownloadStatus, "adDownloadBean.status");
            this.f = adDownloadStatus;
            if (str == null) {
                str = getResources().getString(R.string.install_app);
                Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.install_app)");
            }
            this.g = str;
            float f = 100;
            this.e = (int) RangesKt___RangesKt.coerceAtLeast(adDownloadBean.i * f, adDownloadBean.j * f);
            postInvalidate();
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            getProgressOval().left = 0.0f;
            getProgressOval().top = -this.l;
            getProgressOval().right = getMeasuredWidth();
            getProgressOval().bottom = getMeasuredHeight();
            float f = this.e / 100.0f;
            switch (a.$EnumSwitchMapping$0[this.f.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    getProgressPaint().setShader(null);
                    getProgressPaint().setColor(this.d);
                    break;
                case 5:
                case 6:
                    this.q = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.d, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
                    getProgressPaint().setShader(this.q);
                    break;
            }
            if (canvas != null) {
                canvas.save();
            }
            if (canvas != null) {
                canvas.clipRect(getProgressOval().left, getProgressOval().top + this.l, getProgressOval().right, getProgressOval().bottom, Region.Op.INTERSECT);
            }
            if (canvas != null) {
                RectF progressOval = getProgressOval();
                int i = this.l;
                canvas.drawRoundRect(progressOval, i, i, getProgressPaint());
            }
            if (canvas != null) {
                canvas.restore();
            }
        }
    }

    public final void f(Canvas canvas) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            getTextPaint().setAntiAlias(true);
            getTextPaint().setTextSize(this.h);
            float measureText = getTextPaint().measureText(this.g);
            float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.M_W_X015);
            float f = dimensionPixelSize + measureText;
            float measuredWidth = getMeasuredWidth() * (this.e / 100.0f);
            float f2 = (measuredWidth - dimensionPixelSize) / measureText;
            switch (a.$EnumSwitchMapping$0[this.f.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    getTextPaint().setShader(null);
                    getTextPaint().setColor(this.c);
                    break;
                case 5:
                case 6:
                    if (measuredWidth <= dimensionPixelSize) {
                        getTextPaint().setShader(null);
                        getTextPaint().setColor(this.d);
                        break;
                    } else {
                        if (dimensionPixelSize <= measuredWidth && measuredWidth <= f) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            this.r = new LinearGradient(dimensionPixelSize, 0.0f, f, 0.0f, new int[]{this.c, this.d}, new float[]{f2, f2 + 0.001f}, Shader.TileMode.CLAMP);
                            getTextPaint().setShader(this.r);
                            getTextPaint().setColor(this.d);
                            break;
                        } else {
                            getTextPaint().setShader(null);
                            getTextPaint().setColor(this.c);
                            break;
                        }
                    }
            }
            Paint.FontMetrics fontMetrics = getTextPaint().getFontMetrics();
            Intrinsics.checkNotNullExpressionValue(fontMetrics, "textPaint.fontMetrics");
            float f3 = fontMetrics.descent;
            float height = ((getHeight() / 2) - f3) + ((f3 - fontMetrics.ascent) / 2);
            if (canvas != null) {
                canvas.drawText(this.g, dimensionPixelSize, height, getTextPaint());
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            super.onDraw(canvas);
            e(canvas);
            f(canvas);
            AdDownloadStatus adDownloadStatus = this.f;
            if (adDownloadStatus != AdDownloadStatus.COMPLETED && adDownloadStatus != AdDownloadStatus.INSTALLED) {
                b(canvas, IconType.LEFT);
                b(canvas, IconType.RIGHT);
                return;
            }
            b(canvas, IconType.FINISH_DOWNLOAD);
            b(canvas, IconType.RIGHT);
        }
    }
}
