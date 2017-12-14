package com.baidu.tieba.play.b;

import android.net.Uri;
import android.os.Handler;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    private c fRv;
    private int fRw = 0;
    private int fRx = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.fRv = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.fRv == null) {
            return false;
        }
        if (i == -300) {
            if (this.fRx == 0) {
                this.fRx++;
                this.mHandler.postDelayed(new b(this.fRv, gVar, i, i2, i3, 0, this.fRx), 200L);
            } else if (this.fRx == 1) {
                this.fRx++;
                this.mHandler.postDelayed(new b(this.fRv, gVar, i, i2, i3, 1, this.fRx), 200L);
            } else {
                return false;
            }
            return true;
        } else if (i3 == -4399) {
            if (this.fRw < 4 && i == -200) {
                if (!a(gVar, i, i2, i3, uri, this.fRw)) {
                    this.mHandler.postDelayed(new b(this.fRv, gVar, i, i2, i3, 0, this.fRw), 200L);
                }
                this.fRw = 4;
                return true;
            } else if (i == -100) {
                this.mHandler.postDelayed(new b(this.fRv, gVar, i, i2, i3, 1, this.fRw), 200L);
                return true;
            } else {
                return false;
            }
        } else {
            this.fRw++;
            if (this.fRw <= 2) {
                if (!a(gVar, i, i2, i3, uri, this.fRw)) {
                    if (i == -200) {
                        this.mHandler.postDelayed(new b(this.fRv, gVar, i, i2, i3, 0, this.fRw), 200L);
                        this.fRw = 2;
                    } else {
                        this.mHandler.postDelayed(new b(this.fRv, gVar, i, i2, i3, 1, this.fRw), 200L);
                        this.fRw = 4;
                        return false;
                    }
                }
                return true;
            } else if (this.fRw <= 4) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.fRv, gVar, i, i2, i3, 0, this.fRw), 200L);
                    return true;
                }
                return false;
            } else if (this.fRw <= 6 && i == -200) {
                this.mHandler.postDelayed(new b(this.fRv, gVar, i, i2, i3, 1, this.fRw), 200L);
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!bjO() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost())) {
            return false;
        }
        com.baidu.tieba.play.a.b.bjN().a(new C0136a(this.mHandler, this.fRv, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.bjN().ru(uri.getHost());
    }

    private boolean bjO() {
        return (com.baidu.adp.lib.b.d.eV().af("android_video_http_dns_open") == 0 || !j.hh() || CustomPlayerSwitchStatic.biQ() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0136a implements b.InterfaceC0135b {
        private int afo;
        private int fRA;
        private c fRv;
        private g fRy;
        private int fRz;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0136a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.fRv = cVar;
            this.mUri = uri;
            this.fRy = gVar;
            this.fRz = i;
            this.what = i2;
            this.fRA = i3;
            this.afo = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0135b
        public void bS(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.fRv, this.fRy, this.fRz, this.what, this.fRA, 0, this.afo), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.fRv, this.fRy, this.fRz, this.what, this.fRA, str, 2, this.afo), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.fRv, this.fRy, this.fRz, this.what, this.fRA, 0, this.afo), 200L);
                }
            }
        }
    }

    public boolean bjP() {
        boolean z = this.fRw > 0 || this.fRx > 0;
        this.fRw = 0;
        this.fRx = 0;
        return z;
    }

    public static void Y(int i, int i2, int i3) {
        if (i == -100) {
            if (i2 == -24399) {
                TiebaStatic.log(new ak("c12512").r("obj_locate", 0));
            } else if (i2 == -34399) {
                TiebaStatic.log(new ak("c12512").r("obj_locate", 1));
            } else {
                switch (i2) {
                    case 1:
                        i2 = 0;
                        break;
                    case 100:
                        i2 = 1;
                        break;
                    case 200:
                        i2 = 2;
                        break;
                }
                switch (i3) {
                    case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                        i3 = 4;
                        break;
                    case -1010:
                        i3 = 2;
                        break;
                    case TbErrInfo.ERR_IMG_FILE /* -1007 */:
                        i3 = 1;
                        break;
                    case TbErrInfo.ERR_IMG_CACHE /* -1004 */:
                        i3 = 0;
                        break;
                    case -110:
                        i3 = 3;
                        break;
                }
                TiebaStatic.log(new ak("c12508").r("obj_locate", i2).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i3));
            }
        } else if (i == -200) {
            if (i2 == -24399) {
                TiebaStatic.log(new ak("c12512").r("obj_locate", 0));
            } else if (i2 == -34399) {
                TiebaStatic.log(new ak("c12512").r("obj_locate", 1));
            } else {
                switch (i3) {
                    case -10028:
                        TiebaStatic.log(new ak("c12510").r("obj_locate", 7));
                        return;
                    case -10027:
                        TiebaStatic.log(new ak("c12510").r("obj_locate", 6));
                        return;
                    case -10026:
                        TiebaStatic.log(new ak("c12510").r("obj_locate", 5));
                        return;
                    case -10025:
                        TiebaStatic.log(new ak("c12510").r("obj_locate", 4));
                        return;
                    case -10024:
                        TiebaStatic.log(new ak("c12510").r("obj_locate", 3));
                        return;
                    case -10023:
                        TiebaStatic.log(new ak("c12510").r("obj_locate", 2));
                        return;
                    case -10022:
                        TiebaStatic.log(new ak("c12510").r("obj_locate", 1));
                        return;
                    case -10021:
                        TiebaStatic.log(new ak("c12510").r("obj_locate", 0));
                        return;
                    case -10020:
                    case -10019:
                    case -10017:
                    case -10016:
                    default:
                        return;
                    case -10018:
                        TiebaStatic.log(new ak("c12509").r("obj_locate", 8));
                        return;
                    case -10015:
                        TiebaStatic.log(new ak("c12509").r("obj_locate", 5));
                        return;
                    case -10014:
                        TiebaStatic.log(new ak("c12509").r("obj_locate", 4));
                        return;
                    case -10013:
                        TiebaStatic.log(new ak("c12509").r("obj_locate", 3));
                        return;
                    case -10012:
                        TiebaStatic.log(new ak("c12509").r("obj_locate", 2));
                        return;
                    case -10011:
                        TiebaStatic.log(new ak("c12509").r("obj_locate", 1));
                        return;
                    case -10010:
                        TiebaStatic.log(new ak("c12509").r("obj_locate", 0));
                        return;
                }
            }
        }
    }

    public static void bK(int i, int i2) {
        switch (i2) {
            case -10040:
                TiebaStatic.log(new ak("c12511").r("obj_locate", 6));
                return;
            case -10039:
                TiebaStatic.log(new ak("c12511").r("obj_locate", 5));
                return;
            case -10038:
                TiebaStatic.log(new ak("c12511").r("obj_locate", 4));
                return;
            case -10037:
                TiebaStatic.log(new ak("c12511").r("obj_locate", 3));
                return;
            case -10035:
                TiebaStatic.log(new ak("c12511").r("obj_locate", 2));
                return;
            case -10032:
                TiebaStatic.log(new ak("c12511").r("obj_locate", 1));
                return;
            case -10031:
                TiebaStatic.log(new ak("c12511").r("obj_locate", 0));
                return;
            case -10019:
                TiebaStatic.log(new ak("c12509").r("obj_locate", 8));
                return;
            case -10017:
                TiebaStatic.log(new ak("c12509").r("obj_locate", 7));
                return;
            case -10016:
                TiebaStatic.log(new ak("c12509").r("obj_locate", 6));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    private static class b implements Runnable {
        private final int afo;
        private final int fRA;
        private c fRv;
        private final g fRy;
        private final int fRz;
        private final String ip;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.fRv = cVar;
            this.fRy = gVar;
            this.fRz = i;
            this.what = i2;
            this.fRA = i3;
            this.type = i4;
            this.afo = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.fRv = cVar;
            this.fRy = gVar;
            this.fRz = i;
            this.what = i2;
            this.fRA = i3;
            this.ip = str;
            this.type = i4;
            this.afo = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fRv != null) {
                if (this.type == 0) {
                    this.fRv.a(this.fRy, this.fRz, this.what, this.fRA, this.afo);
                } else if (this.type == 1) {
                    this.fRv.b(this.fRy, this.fRz, this.what, this.fRA, this.afo);
                } else if (this.type == 2) {
                    this.fRv.a(this.fRy, this.fRz, this.what, this.fRA, this.ip, this.afo);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void rw(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1) {
                        k.r(new File(strArr[0]).getParentFile());
                    }
                    return null;
                }
            }.execute(str);
        }
    }
}
