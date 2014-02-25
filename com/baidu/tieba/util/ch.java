package com.baidu.tieba.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ch {
    private static int a = -1;
    private static int b = -1;
    private static boolean c = false;
    private static com.baidu.adp.lib.d.a<Integer, Integer> d = new com.baidu.adp.lib.d.a<>(500);
    private static Context e = null;

    public static void a(Context context) {
        e = context;
        c = true;
    }

    private static void a() {
        if (e != null && e.getResources() != null) {
            b = e.getResources().getColor(R.color.more_color);
            a = e.getResources().getColor(R.color.skin_1_common_color);
        }
    }

    private static int a(int i) {
        return b(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(boolean z) {
        if (c) {
            c = false;
            a();
        }
        return z ? a : b;
    }

    public static void a(View view) {
        if (view instanceof ViewGroup) {
            a((ViewGroup) view, TiebaApplication.g().al());
        }
    }

    public static void b(View view) {
        if (view != null) {
            d.b((com.baidu.adp.lib.d.a<Integer, Integer>) Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void a(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer a2 = d.a((com.baidu.adp.lib.d.a<Integer, Integer>) Integer.valueOf(identityHashCode));
        if (a2 == null || i != a2.intValue()) {
            b(viewGroup, i);
            d.a(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, cj cjVar) {
        if (!z || !cjVar.a(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!cjVar.a(childAt)) {
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
        a(viewGroup, true, (cj) new ci(i, i == 1));
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
            textView.setTextColor(a(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(a(i));
        }
    }
}
