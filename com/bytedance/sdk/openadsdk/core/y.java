package com.bytedance.sdk.openadsdk.core;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.Keep;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.JProtect;
@Keep
@JProtect
/* loaded from: classes6.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view)) == null) ? view != null && view.isShown() : invokeL.booleanValue;
    }

    public static boolean a(View view, int i2) {
        InterceptResult invokeLI;
        char c2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, view, i2)) == null) {
            if (view != null) {
                if (view.getVisibility() == 0 && view.getParent() != null) {
                    Rect rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect)) {
                        return false;
                    }
                    long height = rect.height() * rect.width();
                    long height2 = view.getHeight() * view.getWidth();
                    if (height2 <= 0 || height * 100 < i2 * height2) {
                        return false;
                    }
                    c2 = '\'';
                    z = true;
                }
                return false;
            }
            c2 = 'R';
            z = false;
            if (c2 == '\'') {
                return z;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
        r1 = '[';
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
        switch(r1) {
            case 91: goto L29;
            case 92: goto L19;
            case 93: goto L19;
            default: goto L17;
        };
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(View view, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, view, i2, i3)) == null) {
            while (true) {
                char c2 = '^';
                char c3 = 'K';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                            }
                        case ']':
                            break;
                        case '^':
                            c2 = ']';
                            c3 = ']';
                        default:
                            c2 = ']';
                            c3 = ']';
                    }
                }
            }
            try {
                return b(view, i2, i3) == 0;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLII.booleanValue;
    }

    public static int b(View view, int i2, int i3) throws Throwable {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, view, i2, i3)) == null) {
            if (com.bytedance.sdk.openadsdk.core.k.c.a()) {
                if (a(view)) {
                    if (b(view, i3)) {
                        return !a(view, i2) ? 3 : 0;
                    }
                    return 6;
                }
                return 1;
            }
            return 4;
        }
        return invokeLII.intValue;
    }

    public static boolean b(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65540, null, view, i2)) == null) {
            return view.getWidth() >= c(view, i2) && view.getHeight() >= d(view, i2);
        }
        return invokeLI.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029 A[PHI: r4 
      PHI: (r4v7 int) = (r4v3 int), (r4v10 int) binds: [B:12:0x0023, B:6:0x0007] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035 A[PHI: r0 r4 
      PHI: (r0v6 double) = (r0v5 double), (r0v5 double), (r0v8 double) binds: [B:12:0x0023, B:11:0x0020, B:16:0x0029] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v6 int) = (r4v3 int), (r4v3 int), (r4v7 int) binds: [B:12:0x0023, B:11:0x0020, B:16:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a A[LOOP:0: B:9:0x001c->B:20:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0018 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0020 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0020 -> B:19:0x0035). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0023 -> B:16:0x0029). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0023 -> B:19:0x0035). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0018 -> B:9:0x001c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(View view, int i2) {
        InterceptResult invokeLI;
        int i3;
        double d2;
        char c2;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, view, i2)) == null) {
            if (i2 != 3) {
                i3 = 13;
                d2 = 72.0d;
                c2 = 'J';
                c3 = '7';
                while (true) {
                    switch (c2) {
                    }
                    c2 = 'H';
                }
                switch (c3) {
                }
                return (int) d2;
            }
            i3 = com.bytedance.sdk.openadsdk.r.q.c(view.getContext().getApplicationContext());
            d2 = i3 * 0.7d;
            c2 = 'I';
            c3 = '`';
            while (true) {
                switch (c2) {
                    case 'H':
                        break;
                    case 'I':
                        switch (c3) {
                        }
                    case 'J':
                        break;
                    default:
                        c2 = 'H';
                }
            }
            switch (c3) {
                case '7':
                    return 20;
                case '8':
                    d2 = i3 * 0.7d;
                    c2 = 'I';
                    c3 = '`';
                    while (true) {
                        switch (c2) {
                        }
                        c2 = 'H';
                    }
                    switch (c3) {
                        case '7':
                            break;
                        case '8':
                            break;
                        case '9':
                            break;
                        default:
                            c2 = 'I';
                            c3 = '`';
                            while (true) {
                                switch (c2) {
                                }
                                c2 = 'H';
                            }
                            switch (c3) {
                            }
                    }
            }
            return (int) d2;
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018 A[PHI: r4 
      PHI: (r4v2 int) = (r4v1 int), (r4v3 int), (r4v3 int) binds: [B:7:0x0016, B:9:0x001c, B:12:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0020 -> B:18:0x002e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x002c -> B:18:0x002e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0018 -> B:9:0x001c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d(View view, int i2) {
        InterceptResult invokeLI;
        int i3;
        char c2;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, view, i2)) == null) {
            if (i2 == 3) {
                i3 = com.bytedance.sdk.openadsdk.r.q.d(view.getContext().getApplicationContext());
                c2 = '_';
                c3 = '_';
                switch (c2) {
                    case '^':
                        if (c3 != '\'') {
                            return 20;
                        }
                        c2 = '_';
                        c3 = '_';
                        switch (c2) {
                            case '_':
                                switch (c3) {
                                    case '^':
                                    case '`':
                                        c2 = '_';
                                        c3 = '_';
                                        switch (c2) {
                                            case '`':
                                                switch (c3) {
                                                    case '7':
                                                    case '9':
                                                        return i3 / 2;
                                                    case '8':
                                                        c2 = '^';
                                                        c3 = '}';
                                                        switch (c2) {
                                                        }
                                                    default:
                                                        return 20;
                                                }
                                        }
                                }
                        }
                }
            } else {
                i3 = 13;
                c2 = '^';
                c3 = '}';
                switch (c2) {
                }
            }
        } else {
            return invokeLI.intValue;
        }
    }
}
