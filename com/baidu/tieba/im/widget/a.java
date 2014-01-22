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
public class a {
    private static com.baidu.tieba.view.dialog.a a = null;
    private static QueryPrizeRes.PrizeInfo b = null;

    public static synchronized void a(Activity activity, QueryPrizeRes.PrizeInfo prizeInfo) {
        synchronized (a.class) {
            if (prizeInfo == null) {
                com.baidu.adp.lib.g.e.d("no PriceInfo");
            } else {
                com.baidu.adp.lib.g.e.d("name:" + prizeInfo.getName() + " link:" + prizeInfo.getLink() + " type:" + prizeInfo.getType() + " subtype:" + prizeInfo.getSubType() + " text:" + prizeInfo.getAbstract());
                b = prizeInfo;
                if (a != null) {
                    a.c();
                }
                a = new com.baidu.tieba.view.dialog.a(activity);
                if (!a(activity)) {
                    a = null;
                } else {
                    a.a(false);
                    a.a();
                    a.b();
                }
            }
        }
    }

    private static Spanned a(String str) {
        return Html.fromHtml(String.format(b.getAbstract().replaceAll("[\\\n]+", "<br>"), "<font color=\"#f15a23\">" + str + "</font>"));
    }

    private static boolean a(Activity activity) {
        View inflate = LayoutInflater.from(TiebaApplication.h()).inflate(R.layout.egg_breaker_tip_center_view, (ViewGroup) null);
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
            textView3.setText(TiebaApplication.h().getString(R.string.egg_breaker_tip));
            c();
        } else if (type == 1) {
            bDImageView.setImageResource(R.drawable.bg_egg_breaker_virtual);
            textView2.setText(a(b.getName()));
            textView3.setText(TiebaApplication.h().getString(R.string.egg_breaker_tip));
            a(activity, type);
        } else {
            bDImageView.setImageResource(R.drawable.bg_egg_breaker_virtual);
            if (type == 3) {
                textView2.setText(a(TiebaApplication.h().getString(R.string.egg_breaker_tip_tdou_name)));
                textView3.setText(TiebaApplication.h().getString(R.string.egg_breaker_tip));
                c();
            } else {
                switch (subType) {
                    case 0:
                        textView2.setText(b.getAbstract());
                        textView3.setVisibility(8);
                        c();
                        break;
                    case 1:
                        textView2.setText(a(TiebaApplication.h().getString(R.string.egg_breaker_tip_emotion_name)));
                        textView3.setText(TiebaApplication.h().getString(R.string.egg_breaker_tip_emotion_tip_down));
                        a(activity, b.getType());
                        break;
                    case 2:
                        textView2.setText(a(TiebaApplication.h().getString(R.string.egg_breaker_tip_badge_name)));
                        textView3.setVisibility(8);
                        c();
                        break;
                    case 3:
                        textView2.setText(a(TiebaApplication.h().getString(R.string.egg_breaker_tip_retroactive_name)));
                        textView3.setText(TiebaApplication.h().getString(R.string.egg_breaker_tip_retroactive_tip_down));
                        c();
                        break;
                    case 4:
                        textView2.setText(a(TiebaApplication.h().getString(R.string.egg_breaker_tip_magic_egg_name)));
                        textView3.setText(TiebaApplication.h().getString(R.string.egg_breaker_tip_magic_egg_tip_down));
                        c();
                        break;
                    default:
                        return false;
                }
            }
        }
        a.a(inflate);
        return true;
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
