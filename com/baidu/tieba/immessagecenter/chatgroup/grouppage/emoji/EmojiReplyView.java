package com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiData;
import com.baidu.tieba.kp8;
import com.baidu.tieba.np8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class EmojiReplyView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public static final int e;
    public static final int f;
    public transient /* synthetic */ FieldHolder $fh;
    public AlignMode a;
    @Nullable
    public kp8 b;
    public LayoutTransition c;
    public np8 d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class AlignMode {
        public static final /* synthetic */ AlignMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AlignMode LEFT;
        public static final AlignMode RIGHT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(651128791, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/emoji/EmojiReplyView$AlignMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(651128791, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/emoji/EmojiReplyView$AlignMode;");
                    return;
                }
            }
            RIGHT = new AlignMode("RIGHT", 0);
            AlignMode alignMode = new AlignMode("LEFT", 1);
            LEFT = alignMode;
            $VALUES = new AlignMode[]{RIGHT, alignMode};
        }

        public AlignMode(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AlignMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (AlignMode) Enum.valueOf(AlignMode.class, str);
            }
            return (AlignMode) invokeL.objValue;
        }

        public static AlignMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (AlignMode[]) $VALUES.clone();
            }
            return (AlignMode[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2043319486, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/emoji/EmojiReplyView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2043319486, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/emoji/EmojiReplyView$a;");
                    return;
                }
            }
            int[] iArr = new int[AlignMode.values().length];
            a = iArr;
            try {
                iArr[AlignMode.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AlignMode.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1771956699, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/emoji/EmojiReplyView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1771956699, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/emoji/EmojiReplyView;");
                return;
            }
        }
        e = UtilHelper.getDimenPixelSize(R.dimen.M_H_X001);
        f = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            removeAllViews();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            g();
        }
    }

    @Nullable
    public kp8 getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (kp8) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            LayoutTransition layoutTransition = new LayoutTransition();
            this.c = layoutTransition;
            this.d = new np8(layoutTransition, this, this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiReplyView(Context context, AttributeSet attributeSet) {
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
        this.a = AlignMode.LEFT;
    }

    public void a(int i) {
        kp8 kp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || (kp8Var = this.b) == null) {
            return;
        }
        addView(kp8Var.h(this, null, i, kp8Var.i(i), 1), i);
        requestLayout();
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            removeViewAt(i);
            requestLayout();
        }
    }

    public void setAdapter(@NonNull kp8 kp8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, kp8Var) == null) {
            this.b = kp8Var;
        }
    }

    public void setAlignMode(@NonNull AlignMode alignMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, alignMode) == null) {
            this.a = alignMode;
            j();
        }
    }

    public final void b(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt = getChildAt(i7);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i2 - i < measuredWidth) {
                    i4 += f + measuredHeight;
                    childAt.layout(0, i4, measuredWidth, measuredHeight + i4);
                    int i8 = e;
                    int i9 = measuredWidth + i8;
                    i = measuredWidth + i8 + 0;
                    i3 = i9;
                } else {
                    int i10 = i3 + measuredWidth;
                    childAt.layout(i3, i4, i10, measuredHeight + i4);
                    int i11 = e;
                    i += measuredWidth + i11;
                    i3 = i10 + i11;
                }
            }
        }
    }

    public final void c(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            int i7 = i;
            int i8 = i4;
            int i9 = 0;
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i2 - i7 < measuredWidth) {
                    i8 += f + measuredHeight;
                    childAt.layout(i2 - measuredWidth, i8, i2, measuredHeight + i8);
                    i9 = i10;
                    i7 = measuredWidth + e + 0;
                } else {
                    for (int i11 = i10 - 1; i9 <= i11; i11--) {
                        View childAt2 = getChildAt(i11);
                        int top = childAt2.getTop();
                        int bottom = childAt2.getBottom();
                        int left = childAt2.getLeft();
                        int right = childAt2.getRight();
                        int i12 = e;
                        childAt2.layout(left - (measuredWidth + i12), top, right - (measuredWidth + i12), bottom);
                    }
                    childAt.layout(i2 - measuredWidth, i8, i2, measuredHeight + i8);
                    i7 += measuredWidth + e;
                }
            }
        }
    }

    public void f(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            h(i, i2);
        }
    }

    public final void h(int i, int i2) {
        kp8 kp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) != null) || (kp8Var = this.b) == null) {
            return;
        }
        kp8Var.h(this, getChildAt(i2), i2, kp8Var.i(i2), i);
        requestLayout();
    }

    public final void g() {
        kp8 kp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (kp8Var = this.b) == null) {
            return;
        }
        np8 np8Var = this.d;
        if (np8Var != null) {
            np8Var.b(false);
        }
        d();
        for (int i = 0; i < kp8Var.g(); i++) {
            EmojiData i2 = kp8Var.i(i);
            if (i2 != null) {
                if (i2.isAdd()) {
                    addView(kp8Var.f(this, null, i, i2));
                } else {
                    addView(kp8Var.h(this, null, i, i2, 0));
                }
            }
        }
        np8 np8Var2 = this.d;
        if (np8Var2 != null) {
            np8Var2.b(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int measuredWidth = getMeasuredWidth();
            int i5 = a.a[this.a.ordinal()];
            if (i5 != 1) {
                if (i5 == 2) {
                    c(0, measuredWidth, 0, 0, 0, 0);
                    return;
                }
                return;
            }
            b(0, measuredWidth, 0, 0, 0, 0);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            int size = View.MeasureSpec.getSize(i);
            Log.e("Anthony", "childcount: " + getChildCount());
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                measureChild(childAt, i, i2);
                if (childAt.getMeasuredWidth() > size - i5) {
                    i3 += i4 + f;
                    i5 = 0;
                }
                i5 += childAt.getMeasuredWidth() + e;
                i4 = childAt.getMeasuredHeight();
            }
            setMeasuredDimension(size, i3 + i4);
        }
    }
}
