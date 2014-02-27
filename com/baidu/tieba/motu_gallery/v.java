package com.baidu.tieba.motu_gallery;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.IOException;
/* loaded from: classes.dex */
public final class v {
    private static final String[] b = {"image/jpeg", "image/png", "image/gif"};
    static final String[] a = {"_id", "datetaken", "date_added", "orientation", "_data"};

    private static String a() {
        return String.valueOf("case ifnull(datetaken,0) when 0 then date_modified*1000 else datetaken end") + " DESC, _id DESC";
    }

    private static Cursor a(ContentResolver contentResolver, Uri uri) {
        Cursor query;
        try {
            if (uri.getScheme().startsWith("file")) {
                String[] strArr = {""};
                strArr[0] = uri.getPath();
                query = MediaStore.Images.Media.query(contentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, a, "(_data=?)", strArr, a());
            } else {
                query = MediaStore.Images.Media.query(contentResolver, uri, a, "(mime_type in (?, ?, ?))", b, a());
            }
            return query;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static int a(Context context, Uri uri) {
        int i = 0;
        Cursor a2 = a(context.getContentResolver(), uri);
        if (a2 != null) {
            try {
                a2.moveToFirst();
                i = a2.getInt(3);
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return i;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static int b(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        int a2 = a(uri);
        if (a2 == 0) {
            Cursor a3 = a(contentResolver, uri);
            if (a3 == null) {
                return 0;
            }
            try {
                a3.moveToFirst();
                int i = a3.getInt(3);
                if (a3 == null) {
                    return i;
                }
                try {
                    a3.close();
                    return i;
                } catch (Exception e) {
                    e.printStackTrace();
                    return i;
                }
            } catch (Exception e2) {
                if (a3 != null) {
                    try {
                        a3.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                return 0;
            } catch (Throwable th) {
                if (a3 != null) {
                    try {
                        a3.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return a2;
    }

    private static int a(Uri uri) {
        if (!uri.getScheme().startsWith("file")) {
            return 0;
        }
        try {
            int intValue = Integer.valueOf(new ExifInterface(uri.getPath()).getAttribute("Orientation")).intValue();
            if (6 == intValue) {
                return 90;
            }
            if (3 == intValue) {
                return 180;
            }
            if (8 != intValue) {
                return 0;
            }
            return 270;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }
}
