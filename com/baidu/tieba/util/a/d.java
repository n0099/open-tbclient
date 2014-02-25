package com.baidu.tieba.util.a;

import android.graphics.Bitmap;
import com.baidu.adp.lib.cache.s;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.log.j;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ae;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bm;
import com.baidu.tieba.util.br;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.util.bv;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.util.i;
import com.baidu.tieba.util.l;
import com.baidu.tieba.util.n;
import com.baidu.tieba.util.o;
/* loaded from: classes.dex */
public class d extends a {
    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, i iVar) {
        return com.baidu.tbadk.imageManager.e.a().c(iVar.a(str));
    }

    @Override // com.baidu.tieba.util.a.a
    public Object a(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        if (lVar.g) {
            String f = bs.f(str);
            String str2 = iVar.f != null ? String.valueOf(f) + iVar.f : f;
            String a = iVar.a(str);
            synchronized (n.a) {
                if (str2 != null) {
                    if (lVar.d == 5) {
                        f b = DatabaseService.b(a);
                        if (b != null) {
                            lVar.e = b.a;
                        }
                    } else {
                        int c = br.a().c(str2);
                        if (c > 0) {
                            com.baidu.tbadk.imageManager.e.a().c(c);
                            lVar.e = br.a().a(str2);
                            if (lVar.e != null) {
                                s<String> w = com.baidu.tieba.c.a.a().w();
                                if (w != null && "gif".equals(w.a(a))) {
                                    lVar.h = true;
                                }
                                if (!lVar.h) {
                                    lVar.h = br.a().b(str2);
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
                lVar.i = new com.baidu.adp.widget.ImageView.b(lVar.e, lVar.h, str);
                com.baidu.tbadk.imageManager.e.a().b(a, lVar.i);
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

    /* JADX WARN: Removed duplicated region for block: B:120:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x04ae A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04b1  */
    @Override // com.baidu.tieba.util.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar) {
        String f;
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
            cb.a("", -1003, "", "");
            return null;
        }
        int i3 = lVar.d;
        ae aeVar = new ae();
        aeVar.a(SocialConstants.PARAM_URL, str);
        String f2 = iVar.f != null ? String.valueOf(f) + iVar.f : bs.f(str);
        aeVar.a(SocialConstants.PARAM_MEDIA_UNAME, f2);
        if (iVar.b == 0) {
            i = BdUtilHelper.a(iVar.a, 105.0f);
        } else {
            i = iVar.b;
        }
        if (iVar.c == 0) {
            i2 = BdUtilHelper.a(iVar.a, 105.0f);
        } else {
            i2 = iVar.c;
        }
        aeVar.a("picW", Integer.valueOf(i));
        aeVar.a("picH", Integer.valueOf(i2));
        boolean e = iVar.e();
        if (e) {
            sb = str;
        } else {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(com.baidu.tieba.data.i.k);
            sb2.append("src=");
            sb2.append(bs.d(str));
            sb2.append("&width=");
            sb2.append(String.valueOf(i));
            sb2.append("&height=");
            sb2.append(String.valueOf(i2));
            sb2.append("&imgtype=0");
            sb2.append("&qulity=" + bv.a().d());
            sb2.append("&first_gif=1");
            if (iVar.e) {
                sb2.append("&ispv=1");
            }
            if (iVar.g) {
                sb2.append("&no_prefix=1");
            }
            sb = sb2.toString();
        }
        aeVar.a("fullUrl", sb);
        lVar.a = new ba(iVar.a, sb);
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
            if (e) {
                o.a().a(lVar.a.g());
            }
            boolean a2 = com.baidu.adp.lib.network.i.a();
            String str2 = "";
            String str3 = "";
            if (a2) {
                c = UtilHelper.i(iVar.a);
            } else {
                c = UtilHelper.c();
            }
            int indexOf2 = sb.indexOf("hiphotos.baidu.com");
            if (indexOf2 > 0) {
                str3 = String.valueOf(sb.substring(0, indexOf2).replace(com.baidu.loginshare.e.f, "")) + "hiphotos.baidu.com";
                str2 = UtilHelper.c(str3);
            }
            String str4 = String.valueOf(str3) + "=" + str2;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("IS_CDN=");
            sb3.append(e);
            sb3.append("|download error|iswifi=");
            sb3.append(a2 ? 1 : 0);
            sb3.append("|local_ip=");
            sb3.append(c);
            sb3.append("|");
            sb3.append(str4);
            com.baidu.tieba.log.a.b(j.a(sb, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(lVar.a.c()), String.valueOf(lVar.a.g()) + ":" + lVar.a.h(), sb3.toString()));
            ae aeVar2 = new ae();
            aeVar2.a("IS_CDN", Boolean.valueOf(e));
            aeVar2.a("iswifi", Integer.valueOf(a2 ? 1 : 0));
            aeVar2.a("local_ip", c);
            aeVar2.a("host", str4);
            if (lVar != null && lVar.a != null) {
                aeVar2.a("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                aeVar2.a("datasize", Integer.valueOf(lVar.a.c()));
                int f3 = lVar.a.f();
                if (f3 == 0) {
                    f3 = -1001;
                }
                aeVar2.a(aeVar);
                cb.a(lVar.a.a(), f3, lVar.a.j(), aeVar2.toString());
            }
            if (indexOf2 > 0) {
                lVar.a.a(sb);
                long currentTimeMillis2 = System.currentTimeMillis();
                byte[] l2 = lVar.a.l();
                if (!lVar.n) {
                    if ((l2 == null || !lVar.a.d()) && e) {
                        o.a().a(lVar.a.g());
                    }
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
                    sb4.append(str4);
                    com.baidu.tieba.log.a.b(j.a(sb, String.valueOf(System.currentTimeMillis() - currentTimeMillis2), String.valueOf(lVar.a.c()), String.valueOf(lVar.a.g()) + ":" + lVar.a.h(), sb4.toString()));
                    ae aeVar3 = new ae();
                    aeVar3.a("IS_CDN", Boolean.valueOf(e));
                    aeVar3.a("iswifi", Integer.valueOf(a2 ? 1 : 0));
                    aeVar3.a("local_ip", c);
                    aeVar3.a("host", str4);
                    aeVar3.a("downsize", Integer.valueOf(l2 != null ? l2.length : 0));
                    aeVar3.a("try download result", lVar.a.d() ? "succ" : "fail");
                    if (lVar != null && lVar.a != null) {
                        aeVar3.a("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        aeVar3.a("datasize", Integer.valueOf(lVar.a.c()));
                        int f4 = lVar.a.f();
                        if (f4 == 0) {
                            f4 = -1001;
                        }
                        aeVar3.a(aeVar);
                        cb.a(lVar.a.a(), f4, lVar.a.j(), aeVar3.toString());
                    }
                }
                bArr = l2;
                j = currentTimeMillis2;
                if (bArr != null || lVar.n) {
                    return null;
                }
                if (e) {
                    o.a().a(System.currentTimeMillis() - j);
                }
                String a3 = iVar.a(str);
                if (!lVar.n) {
                    return null;
                }
                com.baidu.tbadk.imageManager.e.a().c(com.baidu.tieba.data.i.x() + bArr.length);
                lVar.e = n.a(bArr);
                lVar.j = bArr;
                if (lVar.e == null) {
                    if (!lVar.n) {
                        boolean a4 = com.baidu.adp.lib.network.i.a();
                        String str5 = "";
                        String str6 = "";
                        if (a4) {
                            c2 = UtilHelper.i(iVar.a);
                        } else {
                            c2 = UtilHelper.c();
                        }
                        if (sb.indexOf("hiphotos.baidu.com") > 0) {
                            str6 = String.valueOf(sb.substring(0, indexOf).replace(com.baidu.loginshare.e.f, "")) + "hiphotos.baidu.com";
                            str5 = UtilHelper.c(str6);
                        }
                        String str7 = String.valueOf(str6) + "=" + str5;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("IS_CDN=");
                        sb5.append(e);
                        sb5.append("|decode error|iswifi=");
                        sb5.append(a4 ? 1 : 0);
                        sb5.append("|local_ip=");
                        sb5.append(c2);
                        sb5.append("|");
                        sb5.append(str7);
                        com.baidu.tieba.log.a.b(j.a(sb, String.valueOf(System.currentTimeMillis() - j), String.valueOf(lVar.a.c()), String.valueOf(lVar.a.g()) + ":" + lVar.a.h(), sb5.toString()));
                        ae aeVar4 = new ae();
                        aeVar4.a("IS_CDN", Boolean.valueOf(e));
                        aeVar4.a("iswifi", Integer.valueOf(a4 ? 1 : 0));
                        aeVar4.a("local_ip", c2);
                        aeVar4.a("host", str7);
                        if (lVar != null && lVar.a != null) {
                            aeVar4.a("cost", Long.valueOf(System.currentTimeMillis() - j));
                            aeVar4.a("datasize", Integer.valueOf(lVar.a.c()));
                            int f5 = lVar.a.f();
                            if (f5 == 0) {
                                f5 = -1001;
                            }
                            aeVar4.a(aeVar);
                            cb.a(lVar.a.a(), f5, lVar.a.j(), aeVar4.toString());
                        }
                    }
                    return null;
                }
                lVar.h = lVar.a.p() || BdUtilHelper.a(bArr);
                if (lVar.n) {
                    return null;
                }
                if (lVar.e.getWidth() > i || lVar.e.getHeight() > i2) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(String.valueOf(lVar.e.getWidth()) + "*" + String.valueOf(lVar.e.getHeight())));
                    com.baidu.tbadk.imageManager.e.a().c(n.a(lVar.e) * 2);
                    lVar.e = n.a(lVar.e, i, i2, true);
                }
                if (lVar.n) {
                    return null;
                }
                if (i3 == 4) {
                    com.baidu.tbadk.imageManager.e.a().c(n.a(lVar.e) * 2);
                    lVar.e = n.a(lVar.e, 7.0f, true);
                }
                if (lVar.n) {
                    return null;
                }
                if (lVar.p && (a = bm.a().a(lVar.e, lVar.p, true, f2)) != null) {
                    lVar.e = a;
                }
                lVar.i = new com.baidu.adp.widget.ImageView.b(lVar.e, lVar.h, str);
                com.baidu.tbadk.imageManager.e.a().b(a3, lVar.i);
                if (lVar.n) {
                    return null;
                }
                eVar.d(lVar);
                if (lVar.n) {
                    return null;
                }
                lVar.k = f2;
                lVar.l = a3;
                lVar.m = aeVar.toString();
                lVar.f = false;
                return lVar.i;
            }
        }
        bArr = l;
        j = currentTimeMillis;
        if (bArr != null) {
            return null;
        }
        if (e) {
        }
        String a32 = iVar.a(str);
        if (!lVar.n) {
        }
    }
}
