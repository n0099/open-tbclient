package com.baidu.tieba.im.widget;

import android.app.Activity;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ImageView.BDImageView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import protobuf.QueryPrize.QueryPrizeRes;
/* loaded from: classes.dex */
public final class a {
    private static com.baidu.tieba.view.dialog.a a = null;
    private static QueryPrizeRes.PrizeInfo b = null;

    /* JADX WARN: Removed duplicated region for block: B:16:0x00e6 A[Catch: all -> 0x00eb, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0007, B:8:0x000e, B:10:0x0062, B:11:0x0067, B:13:0x00b5, B:14:0x00de, B:16:0x00e6, B:34:0x0213, B:23:0x00f3, B:24:0x0119, B:26:0x0122, B:27:0x014e, B:29:0x0153, B:30:0x0186, B:31:0x01a6, B:32:0x01d3, B:33:0x0200), top: B:36:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0213 A[Catch: all -> 0x00eb, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0007, B:8:0x000e, B:10:0x0062, B:11:0x0067, B:13:0x00b5, B:14:0x00de, B:16:0x00e6, B:34:0x0213, B:23:0x00f3, B:24:0x0119, B:26:0x0122, B:27:0x014e, B:29:0x0153, B:30:0x0186, B:31:0x01a6, B:32:0x01d3, B:33:0x0200), top: B:36:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void a(Activity activity, QueryPrizeRes.PrizeInfo prizeInfo) {
        boolean z;
        synchronized (a.class) {
            if (prizeInfo == null) {
                com.baidu.adp.lib.util.e.e("no PriceInfo");
            } else {
                com.baidu.adp.lib.util.e.e("name:" + prizeInfo.getName() + " link:" + prizeInfo.getLink() + " type:" + prizeInfo.getType() + " subtype:" + prizeInfo.getSubType() + " text:" + prizeInfo.getAbstract());
                b = prizeInfo;
                if (a != null) {
                    a.c();
                }
                a = new com.baidu.tieba.view.dialog.a(activity);
                View inflate = LayoutInflater.from(TiebaApplication.g().b()).inflate(R.layout.egg_breaker_tip_center_view, (ViewGroup) null);
                BDImageView bDImageView = (BDImageView) inflate.findViewById(R.id.egg_breaker_tip_img);
                TextView textView = (TextView) inflate.findViewById(R.id.egg_breaker_tip_sfc);
                TextView textView2 = (TextView) inflate.findViewById(R.id.egg_breaker_tip_main_tip);
                TextView textView3 = (TextView) inflate.findViewById(R.id.egg_breaker_tip_down_tip);
                int type = b.getType();
                int subType = b.getSubType();
                if (type == 4) {
                    bDImageView.setImageResource(R.drawable.bg_egg_breaker_sfc);
                    textView.setText(b.getAbstract());
                    textView2.setVisibility(8);
                    textView3.setText(TiebaApplication.g().b().getString(R.string.egg_breaker_tip));
                    c();
                } else if (type == 1) {
                    bDImageView.setImageResource(R.drawable.bg_egg_breaker_virtual);
                    textView2.setText(a(b.getName()));
                    textView3.setText(TiebaApplication.g().b().getString(R.string.egg_breaker_tip));
                    a(activity, type);
                } else {
                    bDImageView.setImageResource(R.drawable.bg_egg_breaker_virtual);
                    if (type == 3) {
                        textView2.setText(a(TiebaApplication.g().b().getString(R.string.egg_breaker_tip_tdou_name)));
                        textView3.setText(TiebaApplication.g().b().getString(R.string.egg_breaker_tip));
                        c();
                    } else {
                        switch (subType) {
                            case 0:
                                textView2.setText(b.getAbstract());
                                textView3.setVisibility(8);
                                c();
                                break;
                            case 1:
                                textView2.setText(a(TiebaApplication.g().b().getString(R.string.egg_breaker_tip_emotion_name)));
                                textView3.setText(TiebaApplication.g().b().getString(R.string.egg_breaker_tip_emotion_tip_down));
                                a(activity, b.getType());
                                break;
                            case 2:
                                textView2.setText(a(TiebaApplication.g().b().getString(R.string.egg_breaker_tip_badge_name)));
                                textView3.setVisibility(8);
                                c();
                                break;
                            case 3:
                                textView2.setText(a(TiebaApplication.g().b().getString(R.string.egg_breaker_tip_retroactive_name)));
                                textView3.setText(TiebaApplication.g().b().getString(R.string.egg_breaker_tip_retroactive_tip_down));
                                c();
                                break;
                            case 4:
                                textView2.setText(a(TiebaApplication.g().b().getString(R.string.egg_breaker_tip_magic_egg_name)));
                                textView3.setText(TiebaApplication.g().b().getString(R.string.egg_breaker_tip_magic_egg_tip_down));
                                c();
                                break;
                            default:
                                z = false;
                                break;
                        }
                        if (z) {
                            a = null;
                        } else {
                            a.a(false);
                            a.a();
                            a.b();
                        }
                    }
                }
                a.a(inflate);
                z = true;
                if (z) {
                }
            }
        }
    }

    private static Spanned a(String str) {
        return Html.fromHtml(String.format(b.getAbstract().replaceAll("[\\\n]+", "<br>"), "<font color=\"#f15a23\">" + str + "</font>"));
    }

    private static void c() {
        if (a != null) {
            a.a(R.string.egg_breaker_tip_isee, new b());
        }
    }

    private static void a(Activity activity, int i) {
        a.b(R.string.egg_breaker_tip_isee, new c(i));
        if (i == 2) {
            a.a(R.string.egg_breaker_tip_emotion_button, new d(activity));
        } else if (i == 1) {
            a.a(R.string.egg_breaker_tip_real_button, new e(activity));
        }
    }
}
