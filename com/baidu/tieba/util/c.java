package com.baidu.tieba.util;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask {
    final /* synthetic */ a a;
    private com.baidu.tbadk.a.d c;
    private String d;
    private volatile int e;
    private volatile Bitmap f;
    private boolean h;
    private String i;
    private volatile com.baidu.adp.widget.a.b k;
    private volatile r b = null;
    private boolean g = true;
    private volatile boolean j = false;
    private boolean l = false;

    public c(a aVar, String str, int i, com.baidu.tbadk.a.d dVar, boolean z) {
        String str2;
        String str3;
        this.a = aVar;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = null;
        this.h = false;
        this.i = null;
        this.d = str;
        this.e = i;
        this.c = dVar;
        this.f = null;
        this.h = z;
        str2 = aVar.h;
        if (str2 != null) {
            StringBuilder sb = new StringBuilder(String.valueOf(str));
            str3 = aVar.h;
            this.i = sb.append(str3).toString();
            return;
        }
        this.i = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap a(String... strArr) {
        try {
            f();
        } catch (Exception e) {
            z.b("ImageAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return this.f;
    }

    private com.baidu.adp.widget.a.b f() {
        String str;
        Context context;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        int i5;
        Context context2;
        Context context3;
        Context context4;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int a;
        String str2;
        boolean z3 = false;
        byte[] bArr = null;
        int i6 = 0;
        int i7 = 0;
        String f = y.f(this.d);
        str = this.a.h;
        if (str != null) {
            StringBuilder sb = new StringBuilder(String.valueOf(f));
            str2 = this.a.h;
            f = sb.append(str2).toString();
        }
        if (this.h) {
            synchronized (d.a) {
                if (this.e == 1) {
                    this.f = DatabaseService.c(this.i);
                } else if (this.e == 2) {
                    this.f = DatabaseService.b(this.i);
                } else if (this.e == 3) {
                    if (f != null) {
                        this.f = m.c("hotspot", f);
                    }
                } else if ((this.e == 0 || this.e == 4) && f != null && (a = (int) m.a("image", f)) > 0) {
                    com.baidu.tbadk.a.e.a().c(a);
                    this.f = m.c("image", f);
                    if (this.f != null) {
                        this.j = m.b("image", f);
                    }
                }
                if (this.l) {
                    return null;
                }
                this.k = null;
                if (this.f != null) {
                    if (this.e == 0 || this.e == 4) {
                        this.k = new com.baidu.adp.widget.a.b(this.f, this.j, this.d);
                        com.baidu.tbadk.a.e.a().b(this.i, this.k);
                    } else if (this.e == 1 || this.e == 2) {
                        this.k = new com.baidu.adp.widget.a.b(this.f, false, this.d);
                        com.baidu.tbadk.a.e.a().a(this.i, this.k);
                    }
                }
                if (this.f != null) {
                    c((Object[]) new Integer[0]);
                    return this.k;
                }
            }
        }
        if (this.f == null) {
            this.g = false;
            String str3 = null;
            if (this.e == 0 || this.e == 4) {
                StringBuilder sb2 = new StringBuilder(100);
                sb2.append(com.baidu.tieba.data.g.j);
                sb2.append("src=");
                sb2.append(y.d(this.d));
                sb2.append("&width=");
                i = this.a.b;
                if (i == 0) {
                    context3 = this.a.a;
                    i2 = ab.a(context3, 105.0f);
                } else {
                    i2 = this.a.b;
                }
                sb2.append(String.valueOf(i2));
                sb2.append("&height=");
                i3 = this.a.c;
                if (i3 == 0) {
                    context2 = this.a.a;
                    i7 = ab.a(context2, 105.0f);
                } else {
                    i7 = this.a.c;
                }
                sb2.append(String.valueOf(i7));
                sb2.append("&imgtype=0");
                i4 = this.a.k;
                if (i4 != 0) {
                    i5 = this.a.k;
                    if (i5 == 1) {
                        sb2.append("&qulity=" + String.valueOf(80));
                    } else {
                        sb2.append("&qulity=" + String.valueOf(45));
                    }
                } else if (TiebaApplication.f().ao() == 1) {
                    sb2.append("&qulity=" + String.valueOf(80));
                } else {
                    sb2.append("&qulity=" + String.valueOf(45));
                }
                sb2.append("&first_gif=1");
                z = this.a.g;
                if (z) {
                    sb2.append("&ispv=1");
                }
                z2 = this.a.i;
                if (z2) {
                    sb2.append("&no_prefix=1");
                }
                String sb3 = sb2.toString();
                i6 = i2;
                str3 = sb3;
            } else if (this.e == 3) {
                str3 = this.d;
            } else if (this.e == 2) {
                str3 = String.valueOf(com.baidu.tieba.data.g.c()) + this.d;
            } else if (this.e == 1) {
                str3 = String.valueOf(com.baidu.tieba.data.g.k()) + this.d;
            }
            context4 = this.a.a;
            this.b = new r(context4, str3);
            arrayList = this.a.j;
            if (arrayList != null) {
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    arrayList2 = this.a.j;
                    if (i9 >= arrayList2.size()) {
                        break;
                    }
                    r rVar = this.b;
                    arrayList3 = this.a.j;
                    rVar.a((BasicNameValuePair) arrayList3.get(i9));
                    i8 = i9 + 1;
                }
            }
            if (this.e == 0 || this.e == 4) {
                this.b.c(true);
            }
            bArr = this.b.i();
            if (this.b.c()) {
                z3 = true;
            } else {
                bArr = null;
                z3 = true;
            }
        }
        synchronized (d.a) {
            if (this.l) {
                return null;
            }
            if (bArr != null) {
                if (this.e == 0 || this.e == 4) {
                    com.baidu.tbadk.a.e.a().c(com.baidu.tieba.data.g.j() + bArr.length);
                }
                this.f = d.a(bArr);
                this.j = ab.a(bArr);
                if (this.f != null) {
                    if (this.e == 0 || this.e == 4) {
                        if (this.f.getWidth() > i6 || this.f.getHeight() > i7) {
                            z.a(1, getClass().getName(), "doInBackground", "Pb_image_too_big:" + String.valueOf(String.valueOf(this.f.getWidth()) + "*" + String.valueOf(this.f.getHeight())));
                            com.baidu.tbadk.a.e.a().c(d.a(this.f) * 2);
                            this.f = d.a(this.f, i6, i7);
                        }
                    } else if (this.e != 3) {
                        int i10 = 80;
                        if (this.e == 1) {
                            i10 = com.baidu.tieba.data.g.l();
                        }
                        if (this.f.getWidth() > i10 || this.f.getHeight() > i10) {
                            z.a(1, getClass().getName(), "doInBackground", "photo_too_big:" + String.valueOf(String.valueOf(this.f.getWidth()) + "*" + String.valueOf(this.f.getHeight())));
                            com.baidu.tbadk.a.e.a().c(d.a(this.f) * 2);
                            this.f = d.a(this.f, i10);
                        }
                    }
                }
                if (this.l) {
                    return null;
                }
                if (this.e != 0 && this.f != null) {
                    com.baidu.tbadk.a.e.a().c(d.a(this.f) * 2);
                    Bitmap bitmap = this.f;
                    context = this.a.a;
                    this.f = d.a(bitmap, ab.a(context, 5.0f));
                }
            }
            if (this.l) {
                return null;
            }
            this.k = null;
            if (this.f != null) {
                if (this.e == 0 || this.e == 4) {
                    this.k = new com.baidu.adp.widget.a.b(this.f, this.j, this.d);
                    com.baidu.tbadk.a.e.a().b(this.i, this.k);
                } else if (this.e == 1 || this.e == 2) {
                    this.k = new com.baidu.adp.widget.a.b(this.f, false, this.d);
                    com.baidu.tbadk.a.e.a().a(this.i, this.k);
                }
            }
            if (this.f != null) {
                c((Object[]) new Integer[0]);
            }
            if (this.l) {
                return null;
            }
            if (z3 && this.f != null) {
                try {
                    if (this.e == 1) {
                        DatabaseService.b(this.i, this.f);
                    } else if (this.e == 2) {
                        DatabaseService.a(this.i, this.f);
                    } else if (this.e == 3) {
                        if (this.f != null && this.d != null && f != null) {
                            m.a("hotspot", f, this.f, 100);
                        }
                    } else if (this.e == 4) {
                        if (f != null && this.f != null && bArr != null) {
                            m.a("image", f, d.c(this.f, 80));
                        }
                    } else if (f != null && this.f != null && bArr != null) {
                        m.a("image", f, bArr);
                    }
                } catch (Throwable th) {
                }
            }
            return this.k;
        }
    }

    public String e() {
        return this.d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(Integer... numArr) {
        if (this.k != null && this.c != null) {
            this.c.a(this.k, this.d, this.g);
        }
        super.b((Object[]) numArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        LinkedList linkedList;
        boolean z;
        LinkedList linkedList2;
        LinkedList linkedList3;
        linkedList = this.a.d;
        linkedList.remove(this);
        z = this.a.f;
        if (z) {
            linkedList2 = this.a.e;
            if (linkedList2.size() > 0) {
                linkedList3 = this.a.e;
                b bVar = (b) linkedList3.remove(0);
                this.a.a(bVar.a, bVar.c, Integer.valueOf(bVar.b), bVar.d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        boolean z;
        LinkedList linkedList;
        LinkedList linkedList2;
        this.l = true;
        if (this.b != null) {
            this.b.h();
        }
        z = this.a.f;
        if (z) {
            linkedList = this.a.e;
            if (linkedList.size() > 0) {
                linkedList2 = this.a.e;
                b bVar = (b) linkedList2.remove(0);
                if (bVar != null) {
                    this.a.a(bVar.a, bVar.c, Integer.valueOf(bVar.b), bVar.d);
                }
            }
        }
        super.cancel(true);
    }
}
