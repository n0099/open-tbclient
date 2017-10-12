package com.baidu.tieba.play.b;

import android.net.Uri;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
/* loaded from: classes.dex */
public class a {
    private b fyo;
    private int fyp = 0;
    private int fyq = 0;

    public a(b bVar) {
        this.fyo = bVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.fyo == null) {
            return false;
        }
        if (i == -300) {
            if (this.fyq == 0) {
                this.fyq++;
                this.fyo.b(gVar, i, i2, i3);
            } else if (this.fyq != 1) {
                return false;
            } else {
                this.fyq++;
                this.fyo.c(gVar, i, i2, i3);
            }
            return true;
        } else if (i3 == -4399) {
            if (this.fyp < 4 && i == -200) {
                this.fyp = 4;
                if (!b(gVar, i, i2, i3, uri)) {
                    this.fyo.b(gVar, i, i2, i3);
                }
                return true;
            } else if (i == -100) {
                this.fyo.c(gVar, i, i2, i3);
                return true;
            } else {
                return false;
            }
        } else {
            this.fyp++;
            if (this.fyp <= 2) {
                if (!b(gVar, i, i2, i3, uri)) {
                    if (i != -200) {
                        return false;
                    }
                    this.fyp = 2;
                    this.fyo.b(gVar, i, i2, i3);
                }
                return true;
            } else if (this.fyp <= 4) {
                if (i == -200) {
                    this.fyo.b(gVar, i, i2, i3);
                    return true;
                }
                return false;
            } else if (this.fyp > 6 || i != -200) {
                return false;
            } else {
                this.fyo.c(gVar, i, i2, i3);
                return true;
            }
        }
    }

    private boolean b(g gVar, int i, int i2, int i3, Uri uri) {
        if (!beH() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost())) {
            return false;
        }
        com.baidu.tieba.play.a.b.beG().a(new C0119a(this.fyo, i, uri, gVar, i2, i3));
        return com.baidu.tieba.play.a.b.beG().qp(uri.getHost());
    }

    private boolean beH() {
        return (d.eV().af("android_video_http_dns_open") == 0 || !j.hh() || CustomPlayerSwitchStatic.bdV() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0119a implements b.InterfaceC0118b {
        private b fyo;
        private g fyr;
        private int fys;
        private int fyt;
        private Uri mUri;
        private int what;

        public C0119a(b bVar, int i, Uri uri, g gVar, int i2, int i3) {
            this.fyo = bVar;
            this.mUri = uri;
            this.fyr = gVar;
            this.fys = i;
            this.what = i2;
            this.fyt = i3;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0118b
        public void bQ(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.fyo != null) {
                        this.fyo.b(this.fyr, this.fys, this.what, this.fyt);
                    }
                } else if (this.fyo != null) {
                    this.fyo.a(this.fyr, this.fys, this.what, this.fyt, str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.fyo != null) {
                    this.fyo.b(this.fyr, this.fys, this.what, this.fyt);
                }
            }
        }
    }

    public boolean beI() {
        boolean z = this.fyp > 0 || this.fyq > 0;
        this.fyp = 0;
        this.fyq = 0;
        return z;
    }

    public static void W(int i, int i2, int i3) {
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
                    case TbErrInfo.ERR_IMG_NET_REQUEST /* -1010 */:
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

    public static void bI(int i, int i2) {
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
}
