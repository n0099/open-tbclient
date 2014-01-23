package com.baidu.tieba.util.a;

import android.graphics.Bitmap;
import com.baidu.adp.lib.cache.s;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.h;
import com.baidu.tieba.log.j;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ac;
import com.baidu.tieba.util.ax;
import com.baidu.tieba.util.bo;
import com.baidu.tieba.util.bt;
import com.baidu.tieba.util.bu;
import com.baidu.tieba.util.bx;
import com.baidu.tieba.util.by;
import com.baidu.tieba.util.i;
import com.baidu.tieba.util.l;
import com.baidu.tieba.util.n;
/* loaded from: classes.dex */
public class d extends a {
    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, i iVar) {
        return com.baidu.tbadk.imageManager.d.a().c(iVar.a(str));
    }

    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        if (lVar.g) {
            String f = bu.f(str);
            String str2 = iVar.f != null ? f + iVar.f : f;
            String a = iVar.a(str);
            synchronized (n.a) {
                if (str2 != null) {
                    if (lVar.d == 5) {
                        f b = DatabaseService.b(a);
                        if (b != null) {
                            lVar.e = b.a;
                        }
                    } else {
                        int c = bt.a().c(str2);
                        if (c > 0) {
                            com.baidu.tbadk.imageManager.d.a().c(c);
                            lVar.e = bt.a().a(str2);
                            if (lVar.e != null) {
                                s<String> v = com.baidu.tieba.b.a.a().v();
                                if (v != null && "gif".equals(v.a(a))) {
                                    lVar.h = true;
                                }
                                if (!lVar.h) {
                                    lVar.h = bt.a().b(str2);
                                }
                            }
                        }
                    }
                }
                if (eVar.isCancelled()) {
                    return null;
                }
                if (lVar.e == null) {
                    return null;
                }
                lVar.i = new com.baidu.adp.widget.ImageView.d(lVar.e, lVar.h, str);
                com.baidu.tbadk.imageManager.d.a().b(a, lVar.i);
                if (eVar.isCancelled()) {
                    return null;
                }
                if (lVar.i != null) {
                    eVar.d(lVar);
                }
                lVar.f = true;
                return lVar.i;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0476 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0479  */
    @Override // com.baidu.tieba.util.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        int i;
        int i2;
        String sb;
        String c;
        byte[] bArr;
        long j;
        Bitmap a;
        String c2;
        int indexOf;
        if (str == null || str.length() == 0) {
            by.a("", -1003, "", "");
            return null;
        }
        int i3 = lVar.d;
        ac acVar = new ac();
        acVar.a(SocialConstants.PARAM_URL, str);
        String f = bu.f(str);
        String str2 = iVar.f != null ? f + iVar.f : f;
        acVar.a(SocialConstants.PARAM_MEDIA_UNAME, str2);
        if (iVar.b == 0) {
            i = com.baidu.adp.lib.g.g.a(iVar.a, 105.0f);
        } else {
            i = iVar.b;
        }
        if (iVar.c == 0) {
            i2 = com.baidu.adp.lib.g.g.a(iVar.a, 105.0f);
        } else {
            i2 = iVar.c;
        }
        acVar.a("picW", Integer.valueOf(i));
        acVar.a("picH", Integer.valueOf(i2));
        boolean e = iVar.e();
        if (e) {
            sb = str;
        } else {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(h.k);
            sb2.append("src=");
            sb2.append(bu.d(str));
            sb2.append("&width=");
            sb2.append(String.valueOf(i));
            sb2.append("&height=");
            sb2.append(String.valueOf(i2));
            sb2.append("&imgtype=0");
            sb2.append("&qulity=" + bx.a().d());
            sb2.append("&first_gif=1");
            if (iVar.e) {
                sb2.append("&ispv=1");
            }
            if (iVar.g) {
                sb2.append("&no_prefix=1");
            }
            sb = sb2.toString();
        }
        acVar.a("fullUrl", sb);
        lVar.a = new ax(iVar.a, sb);
        int i4 = 1;
        if (sb.contains(".gif")) {
            i4 = 2;
        }
        lVar.a.a(iVar.f(), i4);
        if (e) {
            lVar.a.d(false);
        } else {
            lVar.a.d(true);
        }
        lVar.a.f(e);
        if (iVar.h != null && !e) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= iVar.h.size()) {
                    break;
                }
                lVar.a.a(iVar.h.get(i6));
                i5 = i6 + 1;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        byte[] l = lVar.a.l();
        if ((l == null || !lVar.a.d()) && !lVar.n) {
            boolean a2 = com.baidu.adp.lib.network.i.a();
            String str3 = "";
            String str4 = "";
            if (a2) {
                c = UtilHelper.h(iVar.a);
            } else {
                c = UtilHelper.c();
            }
            int indexOf2 = sb.indexOf("hiphotos.baidu.com");
            if (indexOf2 > 0) {
                str4 = sb.substring(0, indexOf2).replace(com.baidu.loginshare.e.f, "") + "hiphotos.baidu.com";
                str3 = UtilHelper.c(str4);
            }
            String str5 = str4 + "=" + str3;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("IS_CDN=");
            sb3.append(e);
            sb3.append("|download error|iswifi=");
            sb3.append(a2 ? 1 : 0);
            sb3.append("|local_ip=");
            sb3.append(c);
            sb3.append("|");
            sb3.append(str5);
            com.baidu.tieba.log.a.b(j.a(sb, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(lVar.a.c()), lVar.a.g() + ":" + lVar.a.h(), sb3.toString()));
            ac acVar2 = new ac();
            acVar2.a("IS_CDN", Boolean.valueOf(e));
            acVar2.a("iswifi", Integer.valueOf(a2 ? 1 : 0));
            acVar2.a("local_ip", c);
            acVar2.a("host", str5);
            if (lVar != null && lVar.a != null) {
                acVar2.a("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                acVar2.a("datasize", Integer.valueOf(lVar.a.c()));
                int f2 = lVar.a.f();
                if (f2 == 0) {
                    f2 = -1001;
                }
                acVar2.a(acVar);
                by.a(lVar.a.a(), f2, lVar.a.j(), acVar2.toString());
            }
            if (indexOf2 > 0) {
                lVar.a.a(sb);
                long currentTimeMillis2 = System.currentTimeMillis();
                byte[] l2 = lVar.a.l();
                if (!lVar.n) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("downsize=");
                    sb4.append(l2 != null ? l2.length : 0);
                    sb4.append("|try download result:");
                    sb4.append(lVar.a.d() ? "succ" : "fail");
                    sb4.append("|iswifi=");
                    sb4.append(a2 ? 1 : 0);
                    sb4.append("|local_ip=");
                    sb4.append(c);
                    sb4.append("|");
                    sb4.append(str5);
                    com.baidu.tieba.log.a.b(j.a(sb, String.valueOf(System.currentTimeMillis() - currentTimeMillis2), String.valueOf(lVar.a.c()), lVar.a.g() + ":" + lVar.a.h(), sb4.toString()));
                    ac acVar3 = new ac();
                    acVar3.a("IS_CDN", Boolean.valueOf(e));
                    acVar3.a("iswifi", Integer.valueOf(a2 ? 1 : 0));
                    acVar3.a("local_ip", c);
                    acVar3.a("host", str5);
                    acVar3.a("downsize", Integer.valueOf(l2 != null ? l2.length : 0));
                    acVar3.a("try download result", lVar.a.d() ? "succ" : "fail");
                    if (lVar != null && lVar.a != null) {
                        acVar3.a("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        acVar3.a("datasize", Integer.valueOf(lVar.a.c()));
                        int f3 = lVar.a.f();
                        if (f3 == 0) {
                            f3 = -1001;
                        }
                        acVar3.a(acVar);
                        by.a(lVar.a.a(), f3, lVar.a.j(), acVar3.toString());
                    }
                }
                bArr = l2;
                j = currentTimeMillis2;
                if (bArr != null || lVar.n) {
                    return null;
                }
                String a3 = iVar.a(str);
                if (!lVar.n) {
                    return null;
                }
                com.baidu.tbadk.imageManager.d.a().c(h.m() + bArr.length);
                lVar.e = n.a(bArr);
                lVar.j = bArr;
                if (lVar.e == null) {
                    if (!lVar.n) {
                        boolean a4 = com.baidu.adp.lib.network.i.a();
                        String str6 = "";
                        String str7 = "";
                        if (a4) {
                            c2 = UtilHelper.h(iVar.a);
                        } else {
                            c2 = UtilHelper.c();
                        }
                        if (sb.indexOf("hiphotos.baidu.com") > 0) {
                            str7 = sb.substring(0, indexOf).replace(com.baidu.loginshare.e.f, "") + "hiphotos.baidu.com";
                            str6 = UtilHelper.c(str7);
                        }
                        String str8 = str7 + "=" + str6;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("IS_CDN=");
                        sb5.append(e);
                        sb5.append("|decode error|iswifi=");
                        sb5.append(a4 ? 1 : 0);
                        sb5.append("|local_ip=");
                        sb5.append(c2);
                        sb5.append("|");
                        sb5.append(str8);
                        com.baidu.tieba.log.a.b(j.a(sb, String.valueOf(System.currentTimeMillis() - j), String.valueOf(lVar.a.c()), lVar.a.g() + ":" + lVar.a.h(), sb5.toString()));
                        ac acVar4 = new ac();
                        acVar4.a("IS_CDN", Boolean.valueOf(e));
                        acVar4.a("iswifi", Integer.valueOf(a4 ? 1 : 0));
                        acVar4.a("local_ip", c2);
                        acVar4.a("host", str8);
                        if (lVar != null && lVar.a != null) {
                            acVar4.a("cost", Long.valueOf(System.currentTimeMillis() - j));
                            acVar4.a("datasize", Integer.valueOf(lVar.a.c()));
                            int f4 = lVar.a.f();
                            if (f4 == 0) {
                                f4 = -1001;
                            }
                            acVar4.a(acVar);
                            by.a(lVar.a.a(), f4, lVar.a.j(), acVar4.toString());
                        }
                    }
                    return null;
                }
                lVar.h = lVar.a.q() || com.baidu.adp.lib.g.g.a(bArr);
                if (lVar.n) {
                    return null;
                }
                if (lVar.e.getWidth() > i || lVar.e.getHeight() > i2) {
                    com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(lVar.e.getWidth() + "*" + String.valueOf(lVar.e.getHeight())));
                    com.baidu.tbadk.imageManager.d.a().c(n.a(lVar.e) * 2);
                    lVar.e = n.a(lVar.e, i, i2);
                }
                if (lVar.n) {
                    return null;
                }
                if (i3 == 4) {
                    com.baidu.tbadk.imageManager.d.a().c(n.a(lVar.e) * 2);
                    lVar.e = n.a(lVar.e, 7.0f);
                }
                if (lVar.n) {
                    return null;
                }
                if (lVar.p && (a = bo.a().a(lVar.e, lVar.p, true, str2)) != null) {
                    lVar.e = a;
                }
                lVar.i = new com.baidu.adp.widget.ImageView.d(lVar.e, lVar.h, str);
                com.baidu.tbadk.imageManager.d.a().b(a3, lVar.i);
                if (lVar.n) {
                    return null;
                }
                eVar.d(lVar);
                if (lVar.n) {
                    return null;
                }
                lVar.k = str2;
                lVar.l = a3;
                lVar.m = acVar.toString();
                lVar.f = false;
                return lVar.i;
            }
        }
        bArr = l;
        j = currentTimeMillis;
        if (bArr != null) {
            return null;
        }
        String a32 = iVar.a(str);
        if (!lVar.n) {
        }
    }
}
