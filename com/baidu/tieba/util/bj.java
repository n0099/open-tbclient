package com.baidu.tieba.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.switchs.SwitchKey;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bj {

    /* renamed from: a  reason: collision with root package name */
    private static int f2443a = -1;
    private static int b = -1;
    private static com.baidu.adp.lib.d.a<Integer, Integer> c = new com.baidu.adp.lib.d.a<>(BdWebErrorView.ERROR_CODE_500);

    public static void a(TiebaApplication tiebaApplication) {
        if (tiebaApplication != null && tiebaApplication.getResources() != null) {
            f2443a = tiebaApplication.getResources().getColor(R.color.skin_1_common_color);
            b = tiebaApplication.getResources().getColor(R.color.more_color);
        }
    }

    public static void a(View view) {
        if (view instanceof ViewGroup) {
            a((ViewGroup) view, TiebaApplication.g().as());
        }
    }

    public static void b(View view) {
        if (view != null) {
            c.b((com.baidu.adp.lib.d.a<Integer, Integer>) Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void a(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer a2 = c.a((com.baidu.adp.lib.d.a<Integer, Integer>) Integer.valueOf(identityHashCode));
        if (a2 == null || i != a2.intValue()) {
            b(viewGroup, i);
            c.a(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, bo boVar) {
        if (!z || !boVar.a(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!boVar.a(childAt)) {
                        if (childAt instanceof ViewGroup) {
                            linkedList.addLast((ViewGroup) childAt);
                        }
                    } else {
                        return;
                    }
                }
                if (!linkedList.isEmpty()) {
                    viewGroup = (ViewGroup) linkedList.removeFirst();
                } else {
                    return;
                }
            }
        }
    }

    private static void b(ViewGroup viewGroup, int i) {
        a(viewGroup, true, (bo) new bk(i, i == 1));
    }

    public static void a(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundColor(-14078923);
            } else {
                view.setBackgroundColor(-1183760);
            }
        }
    }

    public static void a(View view, int i, int i2) {
        if (view != null) {
            view.setBackgroundDrawable(null);
            if (i2 == 1) {
                if (i == 0) {
                    view.setBackgroundResource(R.drawable.auto_skin_list_item_bg_up_1);
                } else if (i == 2) {
                    view.setBackgroundResource(R.drawable.auto_skin_list_item_bg_down_1);
                } else {
                    view.setBackgroundResource(R.drawable.list_selector_item_1);
                }
            } else if (i == 0) {
                view.setBackgroundResource(R.drawable.auto_skin_list_item_bg_up);
            } else if (i == 2) {
                view.setBackgroundResource(R.drawable.auto_skin_list_item_bg_down);
            } else {
                view.setBackgroundResource(R.drawable.list_selector_item);
            }
        }
    }

    public static void a(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                textView.setTextColor(-11446171);
            } else {
                textView.setTextColor(-5065030);
            }
        }
    }

    public static void b(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                textView.setTextColor(f2443a);
            } else {
                textView.setTextColor(b);
            }
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            if (i == 1) {
                checkBox.setTextColor(f2443a);
            } else {
                checkBox.setTextColor(b);
            }
        }
    }

    public static void a(Activity activity, int i, String str, bn bnVar) {
        int i2 = 1;
        if ((i == R.id.share_weixin || i == R.id.share_qqfriend) && com.baidu.adp.lib.a.d.a().b(SwitchKey.MM) == 1) {
            UtilHelper.a((Context) activity, (int) R.string.share_weixin_turn_off);
            return;
        }
        if (i == R.id.share_weixin) {
            StatService.onEvent(activity, "kn_share_pk_weixin", "share");
            i2 = 3;
        } else if (i == R.id.share_qqfriend) {
            StatService.onEvent(activity, "kn_share_pk_qqfrend", "share");
            i2 = 4;
        } else if (i == R.id.share_qqzone) {
            StatService.onEvent(activity, "kn_share_pk_qzone", "share");
            i2 = 2;
        } else if (i == R.id.share_sina) {
            StatService.onEvent(activity, "kn_share_pk_weibo", "share");
        } else {
            return;
        }
        bnVar.a();
        String a2 = au.a(str);
        au a3 = au.a(activity);
        if (a3.a(i2)) {
            a3.a(activity, a2, new bl(bnVar, activity, i2, a3));
        } else {
            bnVar.b();
        }
    }
}
