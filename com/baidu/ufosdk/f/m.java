package com.baidu.ufosdk.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class m {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x002c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x003c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0001 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.InputStream] */
    public static Bitmap a(Context e2, String str) {
        Bitmap bitmap = null;
        bitmap = null;
        bitmap = null;
        InputStream inputStream = null;
        try {
        } catch (Throwable th) {
            th = th;
            inputStream = e2;
        }
        try {
            try {
                e2 = e2.getAssets().open("ufo_res/" + str);
            } catch (IOException e3) {
                e2 = e3;
                e2.printStackTrace();
            }
            try {
                byte[] a2 = i.a((InputStream) e2);
                bitmap = BitmapFactory.decodeByteArray(a2, 0, a2.length, null);
            } catch (IOException e4) {
                e = e4;
                c.a("bmpProblemIcon fail", e);
                if (e2 != 0) {
                    e2.close();
                    e2 = e2;
                }
                return bitmap;
            }
        } catch (IOException e5) {
            e = e5;
            e2 = 0;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
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
        return bitmap;
    }

    public static StateListDrawable a(int i) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        ColorDrawable colorDrawable = new ColorDrawable(-15066598);
        stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(i));
        stateListDrawable.addState(new int[0], colorDrawable);
        return stateListDrawable;
    }

    public static StateListDrawable a(Context context, String str, String str2) {
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

    /* JADX WARN: Removed duplicated region for block: B:29:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(Context context) {
        Throwable th;
        InputStream inputStream;
        byte[] bArr = null;
        try {
            try {
                inputStream = context.getAssets().open("ufo_res/ufo_addpic_icon.png");
                try {
                    try {
                        bArr = i.a(inputStream);
                    } catch (IOException e2) {
                        e = e2;
                        c.a("bmpProblemIcon fail", e);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return bArr;
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
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(Context context) {
        Throwable th;
        InputStream inputStream;
        byte[] bArr = null;
        try {
            try {
                inputStream = context.getAssets().open("ufo_res/ufo_addpic_icon.png");
                try {
                    try {
                        bArr = i.a(inputStream);
                    } catch (IOException e2) {
                        e = e2;
                        c.a("bmpProblemIcon fail", e);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return bArr;
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
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap c(Context context) {
        Throwable th;
        InputStream inputStream;
        Bitmap bitmap = com.baidu.ufosdk.b.f22908g;
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmap2 = null;
        try {
            try {
                inputStream = context.getAssets().open("ufo_res/ufo_defult_me_icon.png");
                try {
                    try {
                        byte[] a2 = i.a(inputStream);
                        bitmap2 = BitmapFactory.decodeByteArray(a2, 0, a2.length, null);
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
}
