package com.baidu.ufosdk.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes21.dex */
public final class m {
    /* JADX WARN: Removed duplicated region for block: B:37:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(Context context, String str) {
        InputStream inputStream;
        Throwable th;
        Bitmap bitmap = null;
        try {
            try {
                inputStream = context.getAssets().open("ufo_res/" + str);
                try {
                    byte[] a = i.a(inputStream);
                    bitmap = BitmapFactory.decodeByteArray(a, 0, a.length, null);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    c.a("bmpProblemIcon fail", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return bitmap;
                }
            } catch (Throwable th2) {
                th = th2;
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
            inputStream = null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
            if (inputStream != null) {
            }
            throw th;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stateListDrawable;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(Context context) {
        InputStream inputStream;
        Throwable th;
        byte[] bArr = null;
        try {
            try {
                inputStream = context.getAssets().open("ufo_res/ufo_addpic_icon.png");
                try {
                    bArr = i.a(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    c.a("bmpProblemIcon fail", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return bArr;
                }
            } catch (Throwable th2) {
                th = th2;
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
            inputStream = null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
            if (inputStream != null) {
            }
            throw th;
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(Context context) {
        InputStream inputStream;
        Throwable th;
        byte[] bArr = null;
        try {
            try {
                inputStream = context.getAssets().open("ufo_res/ufo_addpic_icon.png");
                try {
                    bArr = i.a(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    c.a("bmpProblemIcon fail", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return bArr;
                }
            } catch (Throwable th2) {
                th = th2;
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
            inputStream = null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
            if (inputStream != null) {
            }
            throw th;
        }
        return bArr;
    }

    public static Bitmap c(Context context) {
        InputStream inputStream;
        Bitmap bitmap = null;
        try {
            if (com.baidu.ufosdk.b.g != null) {
                return com.baidu.ufosdk.b.g;
            }
            try {
                inputStream = context.getAssets().open("ufo_res/ufo_defult_me_icon.png");
                try {
                    byte[] a = i.a(inputStream);
                    bitmap = BitmapFactory.decodeByteArray(a, 0, a.length, null);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    c.a("bmpProblemIcon fail", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return bitmap;
                }
            } catch (IOException e4) {
                e = e4;
                inputStream = null;
            } catch (Throwable th) {
                inputStream = null;
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            return bitmap;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
