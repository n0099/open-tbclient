package com.baidu.ufosdk.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes11.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0030 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0040 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(Context e2, String str) {
        InterceptResult invokeLL;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, e2, str)) == null) {
            Bitmap bitmap = null;
            bitmap = null;
            bitmap = null;
            InputStream inputStream = null;
            try {
                try {
                    try {
                        e2 = e2.getAssets().open("ufo_res/" + str);
                        try {
                            byte[] a = i.a((InputStream) e2);
                            bitmap = BitmapFactory.decodeByteArray(a, 0, a.length, null);
                        } catch (IOException e3) {
                            e = e3;
                            c.a("bmpProblemIcon fail", e);
                            if (e2 != 0) {
                                e2.close();
                                e2 = e2;
                            }
                            return bitmap;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = e2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    e2 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStream != null) {
                    }
                    throw th;
                }
                if (e2 != 0) {
                    e2.close();
                    e2 = e2;
                }
            } catch (IOException e6) {
                e2 = e6;
                e2.printStackTrace();
            }
            return bitmap;
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static StateListDrawable a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            ColorDrawable colorDrawable = new ColorDrawable(-15066598);
            stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(i2));
            stateListDrawable.addState(new int[0], colorDrawable);
            return stateListDrawable;
        }
        return (StateListDrawable) invokeI.objValue;
    }

    public static StateListDrawable a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            try {
                stateListDrawable.addState(new int[]{16842919}, o.a(context, str2));
                if (str != null) {
                    stateListDrawable.addState(new int[0], o.a(context, str));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return stateListDrawable;
        }
        return (StateListDrawable) invokeLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x001e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0032 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0031 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0005 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static byte[] a(Context e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, e2)) == null) {
            byte[] bArr = null;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    e2 = e2.getAssets().open("ufo_res/ufo_addpic_icon.png");
                } catch (IOException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                }
                try {
                    bArr = i.a((InputStream) e2);
                } catch (IOException e4) {
                    e = e4;
                    c.a("bmpProblemIcon fail", e);
                    if (e2 != 0) {
                        e2.close();
                        e2 = e2;
                    }
                    return bArr;
                }
            } catch (IOException e5) {
                e = e5;
                e2 = 0;
            } catch (Throwable th2) {
                th = th2;
                e2 = 0;
                if (e2 != 0) {
                    try {
                        e2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
            if (e2 != 0) {
                e2.close();
                e2 = e2;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x001e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0032 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0031 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0005 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static byte[] b(Context e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, e2)) == null) {
            byte[] bArr = null;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    e2 = e2.getAssets().open("ufo_res/ufo_addpic_icon.png");
                } catch (IOException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                }
                try {
                    bArr = i.a((InputStream) e2);
                } catch (IOException e4) {
                    e = e4;
                    c.a("bmpProblemIcon fail", e);
                    if (e2 != 0) {
                        e2.close();
                        e2 = e2;
                    }
                    return bArr;
                }
            } catch (IOException e5) {
                e = e5;
                e2 = 0;
            } catch (Throwable th2) {
                th = th2;
                e2 = 0;
                if (e2 != 0) {
                    try {
                        e2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
            if (e2 != 0) {
                e2.close();
                e2 = e2;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap c(Context context) {
        InterceptResult invokeL;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            Bitmap bitmap = com.baidu.ufosdk.b.f51518g;
            if (bitmap != null) {
                return bitmap;
            }
            Bitmap bitmap2 = null;
            try {
                try {
                    inputStream = context.getAssets().open("ufo_res/ufo_defult_me_icon.png");
                    try {
                        try {
                            byte[] a = i.a(inputStream);
                            bitmap2 = BitmapFactory.decodeByteArray(a, 0, a.length, null);
                        } catch (IOException e2) {
                            e = e2;
                            c.a("bmpProblemIcon fail", e);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bitmap2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (IOException e5) {
                e = e5;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                if (inputStream != null) {
                }
                throw th;
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return bitmap2;
        }
        return (Bitmap) invokeL.objValue;
    }
}
