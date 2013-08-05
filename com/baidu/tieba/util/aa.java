package com.baidu.tieba.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.account.az;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXImageObject;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class aa {
    private static Context e;
    private static aa f;

    /* renamed from: a  reason: collision with root package name */
    private IWXAPI f1746a;
    private File b;
    private int c;
    private String d;
    private MediaScannerConnection.MediaScannerConnectionClient g = new ab(this);
    private MediaScannerConnection h = new MediaScannerConnection(e, this.g);

    private aa() {
        d();
    }

    public static aa a(Context context) {
        e = context;
        if (f == null) {
            f = new aa();
        }
        return f;
    }

    public boolean a() {
        if (this.f1746a == null) {
            return false;
        }
        return this.f1746a.isWXAppInstalled();
    }

    public boolean b() {
        return this.f1746a != null && 553779201 <= this.f1746a.getWXAppSupportAPI();
    }

    private void d() {
        this.f1746a = WXAPIFactory.createWXAPI(e, "wx289a8c58bca4c71e", true);
        this.f1746a.registerApp("wx289a8c58bca4c71e");
    }

    public void a(int i, Bitmap bitmap) {
        String str = "";
        WXImageObject wXImageObject = new WXImageObject(bitmap);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = a(e.c(bitmap, WebChromeClient.STRING_DLG_BTN_SET, WebChromeClient.STRING_DLG_BTN_SET), true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = b("img");
        req.message = wXMediaMessage;
        switch (i) {
            case 3:
                req.scene = 0;
                str = "weixin";
                break;
            case 4:
                req.scene = 1;
                str = "weixin_friend";
                break;
        }
        new az(str).start();
        this.f1746a.sendReq(req);
    }

    public void a(Context context, String str, ag agVar) {
        Bitmap f2;
        a aVar = new a(context);
        aVar.a(LocationClientOption.MIN_SCAN_SPAN, LocationClientOption.MIN_SCAN_SPAN);
        com.baidu.adp.widget.a.b a2 = aVar.a(str, new ac(this, agVar));
        if (a2 != null && (f2 = a2.f()) != null && agVar != null) {
            agVar.a(f2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [284=4, 285=4, 287=4, 288=4] */
    public void a(int i, String str, Bitmap bitmap, String str2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        this.c = i;
        this.d = str;
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                if (p.a()) {
                    File file = new File(p.f1771a + "/tieba", "share");
                    if (file == null) {
                        fileOutputStream = null;
                    } else if (!file.isDirectory() && !file.mkdirs()) {
                        a(e, i, str, (Uri) null);
                        if (0 != 0) {
                            try {
                                fileOutputStream3.close();
                                return;
                            } catch (IOException e2) {
                                aj.b(getClass().getName(), "readyShare", e2.toString());
                                return;
                            }
                        }
                        return;
                    } else {
                        this.b = a(file, str2);
                        fileOutputStream = new FileOutputStream(this.b);
                        try {
                            boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                            fileOutputStream.flush();
                            if (compress) {
                                this.h = new MediaScannerConnection(e, this.g);
                                this.h.connect();
                                aj.b(getClass().getName(), "mediaScannerConnection", "connect");
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileOutputStream2 = fileOutputStream;
                            aj.b(getClass().getName(), "readyShare", e.toString());
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                    return;
                                } catch (IOException e4) {
                                    aj.b(getClass().getName(), "readyShare", e4.toString());
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e5) {
                                    aj.b(getClass().getName(), "readyShare", e5.toString());
                                }
                            }
                            throw th;
                        }
                    }
                } else {
                    a(e, i, str, (Uri) null);
                    fileOutputStream = null;
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        aj.b(getClass().getName(), "readyShare", e6.toString());
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i, String str, Uri uri) {
        String str2 = str == null ? "" : str;
        try {
            String substring = str2.length() > 140 ? str2.substring(0, 140) : str2;
            b(i);
            String str3 = uri == null ? "text/plain" : "image/*";
            Intent intent = new Intent("android.intent.action.SEND", (Uri) null);
            intent.putExtra("android.intent.extra.TEXT", substring);
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.setFlags(268435456);
            intent.setPackage(d(i));
            intent.setType(str3);
            context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.share_to)));
        } catch (Exception e2) {
            aj.b(getClass().getName(), "share", e2.toString());
        }
    }

    private void b(int i) {
        String str = "";
        if (i == 1) {
            str = "weibo";
        } else if (i == 2) {
            str = "qzone";
        } else if (i == 3) {
            str = "weixin";
        } else if (i == 4) {
            str = "weixin_friend";
        }
        new az(str).start();
    }

    public static String a(String str) {
        return a("", str, "", "", "", "", "", "", "");
    }

    public static String a(String str, String str2, String str3) {
        return a(str2, "", str3, "", "", "", str, "", "");
    }

    public static String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("pk_id", str2);
        treeMap.put("shake_num", str);
        treeMap.put("share_id", str3);
        treeMap.put("vote1_num", str4);
        treeMap.put("vote2_num", str5);
        treeMap.put("vote_diff", str6);
        treeMap.put("player1_id", str7);
        treeMap.put("player2_id", str8);
        treeMap.put("rank", str9);
        treeMap.put("rand_tm", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder(1024);
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append((String) entry.getKey()).append("=").append((String) entry.getValue()).append("&");
            sb2.append((String) entry.getKey()).append("=").append((String) entry.getValue());
        }
        sb2.append("tiebaclient!!!");
        sb.append("sign=").append(ai.a(sb2.toString()));
        return String.valueOf(com.baidu.tieba.data.g.f1013a) + "/c/s/uo/sharepic?" + sb.toString();
    }

    private boolean c(int i) {
        String d = d(i);
        for (ApplicationInfo applicationInfo : e.getPackageManager().getInstalledApplications(0)) {
            if (applicationInfo.packageName.equals(d)) {
                return true;
            }
        }
        return false;
    }

    private File a(File file, String str) {
        File[] listFiles = file.listFiles(new ad(this, str));
        return new File(file, String.valueOf(listFiles.length == 0 ? String.valueOf(str) + "_1" : String.valueOf(str) + "_" + (listFiles.length + 1)) + Util.PHOTO_DEFAULT_EXT);
    }

    private String d(int i) {
        switch (i) {
            case 1:
                return "com.sina.weibo";
            case 2:
                return "com.qzone";
            case 3:
                return MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN;
            case 4:
                return MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN;
            default:
                return null;
        }
    }

    public boolean a(int i) {
        boolean c = c(i);
        if (i == 3 && !a()) {
            c = false;
        }
        if (i == 4 && c && !b()) {
            am.a(e, (int) R.string.share_weixin_friend_no);
            return false;
        } else if (c) {
            return true;
        } else {
            switch (i) {
                case 1:
                    am.a(e, (int) R.string.share_sina_no);
                    return false;
                case 2:
                    am.a(e, (int) R.string.share_qzone_no);
                    return false;
                case 3:
                    am.a(e, (int) R.string.share_weixin_no);
                    return false;
                case 4:
                    am.a(e, (int) R.string.share_weixin_no);
                    return false;
                default:
                    return false;
            }
        }
    }

    public void a(String str, af afVar) {
        com.baidu.tieba.model.ah ahVar = new com.baidu.tieba.model.ah();
        ahVar.a(str);
        ahVar.a(new ae(this, afVar));
    }

    public static byte[] a(Bitmap bitmap, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z) {
            bitmap.recycle();
        }
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return byteArray;
    }

    private String b(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : String.valueOf(str) + System.currentTimeMillis();
    }
}
