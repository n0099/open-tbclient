package com.baidu.tieba.util;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class x {
    private static String a = "skinType not support";

    public static void a(TextView textView, int i) {
        if (textView != null) {
            TiebaApplication f = TiebaApplication.f();
            if (i == 1) {
                textView.setTextColor(f.getResources().getColor(R.color.skin_1_common_button_color));
            } else {
                textView.setTextColor(f.getResources().getColor(R.color.white));
            }
        }
    }

    public static void b(TextView textView, int i) {
        if (textView != null) {
            TiebaApplication f = TiebaApplication.f();
            if (i == 1) {
                textView.setTextColor(f.getResources().getColor(R.color.skin_1_common_color));
            } else {
                textView.setTextColor(f.getResources().getColor(R.color.black));
            }
        }
    }

    public static void c(TextView textView, int i) {
        if (textView != null) {
            TiebaApplication f = TiebaApplication.f();
            if (i == 1) {
                textView.setTextColor(f.getResources().getColor(R.color.gray_night_1));
            } else {
                textView.setTextColor(f.getResources().getColor(R.color.search_text_content));
            }
        }
    }

    public static void d(TextView textView, int i) {
        if (textView != null) {
            TiebaApplication f = TiebaApplication.f();
            if (i == 1) {
                textView.setTextColor(f.getResources().getColor(R.color.gray_night_2));
            } else {
                textView.setTextColor(f.getResources().getColor(R.color.gray_day_2));
            }
        }
    }

    public static void e(TextView textView, int i) {
        if (textView != null) {
            TiebaApplication f = TiebaApplication.f();
            if (i == 1) {
                textView.setTextColor(f.getResources().getColor(R.color.gray_night_3));
            } else {
                textView.setTextColor(f.getResources().getColor(R.color.gray_day_3));
            }
        }
    }

    public static void a(View view, int i) {
        if (view != null) {
            TiebaApplication f = TiebaApplication.f();
            if (i == 1) {
                view.setBackgroundColor(f.getResources().getColor(R.color.skin_1_common_bg));
            } else {
                view.setBackgroundColor(f.getResources().getColor(R.color.backgroundcolor));
            }
        }
    }

    public static void b(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundResource(R.drawable.common_bg_1);
            } else {
                view.setBackgroundResource(R.drawable.common_bg);
            }
        }
    }

    public static void c(View view, int i) {
        if (view != null) {
            TiebaApplication f = TiebaApplication.f();
            if (i == 1) {
                view.setBackgroundColor(f.getResources().getColor(R.color.skin_1_common_bg));
            } else {
                view.setBackgroundColor(f.getResources().getColor(R.color.login_bg_color));
            }
        }
    }

    public static void f(TextView textView, int i) {
        if (textView != null) {
            TiebaApplication f = TiebaApplication.f();
            if (i == 1) {
                textView.setTextColor(f.getResources().getColor(R.color.skin_1_common_color));
            } else {
                textView.setTextColor(f.getResources().getColor(R.color.white));
            }
        }
    }

    public static void d(View view, int i) {
        if (view != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            if (i == 1) {
                view.setBackgroundResource(R.drawable.titlebar_bg_1);
            } else {
                view.setBackgroundResource(R.drawable.titlebar_bg);
            }
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public static void e(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundResource(R.drawable.bg_list_top_1);
            } else {
                view.setBackgroundResource(R.drawable.bg_list_top);
            }
        }
    }

    public static void f(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundResource(R.drawable.bg_list_bottom_1);
            } else {
                view.setBackgroundResource(R.drawable.bg_list_bottom);
            }
        }
    }

    public static void g(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                h((View) textView, (int) R.drawable.title_comm_1);
            } else {
                h((View) textView, (int) R.drawable.title_comm);
            }
        }
        f(textView, i);
    }

    public static void h(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                h((View) textView, (int) R.drawable.title_comm_hilite_1);
            } else {
                h((View) textView, (int) R.drawable.title_comm_hilite);
            }
        }
        f(textView, i);
    }

    public static void a(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            if (i == 1) {
                imageView.setBackgroundResource(R.drawable.title_icon_bg_1);
                imageView.setImageResource(R.drawable.icon_return_n_1);
                return;
            }
            imageView.setBackgroundResource(R.drawable.title_icon_bg);
            imageView.setImageResource(R.drawable.icon_return_n);
        }
    }

    public static void g(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundResource(R.drawable.home_radio_button_1);
            } else {
                view.setBackgroundResource(R.drawable.home_radio_button);
            }
        }
    }

    public static void b(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            if (i == 1) {
                imageView.setBackgroundResource(R.drawable.title_icon_bg_1);
                imageView.setImageResource(R.drawable.icon_refresh_n_1);
                return;
            }
            imageView.setBackgroundResource(R.drawable.title_icon_bg);
            imageView.setImageResource(R.drawable.icon_refresh_n);
        }
    }

    public static void c(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            if (i == 1) {
                imageView.setBackgroundResource(R.drawable.title_icon_bg_1);
                imageView.setImageResource(R.drawable.icon_search_n_1);
                return;
            }
            imageView.setBackgroundResource(R.drawable.title_icon_bg);
            imageView.setImageResource(R.drawable.icon_search_n);
        }
    }

    public static void d(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            if (i == 1) {
                imageView.setBackgroundResource(R.drawable.title_icon_bg_1);
                imageView.setImageResource(R.drawable.icon_home_n_1);
                return;
            }
            imageView.setBackgroundResource(R.drawable.title_icon_bg);
            imageView.setImageResource(R.drawable.icon_home_n);
        }
    }

    public static int a(int i) {
        if (i == 1) {
            return TiebaApplication.f().getResources().getColor(R.color.skin_1_common_color);
        }
        throw new IllegalArgumentException(a);
    }

    public static int b(int i) {
        if (i == 1) {
            return TiebaApplication.f().getResources().getColor(R.color.skin_1_second_common_color);
        }
        throw new IllegalArgumentException(a);
    }

    public static int c(int i) {
        if (i == 1) {
            return TiebaApplication.f().getResources().getColor(R.color.skin_1_third_common_color);
        }
        throw new IllegalArgumentException(a);
    }

    public static int d(int i) {
        TiebaApplication f = TiebaApplication.f();
        return i == 1 ? f.getResources().getColor(R.color.skin_1_common_bg) : f.getResources().getColor(R.color.backgroundcolor);
    }

    public static void h(View view, int i) {
        if (view != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundResource(i);
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void a(ListView listView, int i) {
        if (listView != null) {
            TiebaApplication f = TiebaApplication.f();
            if (i == 1) {
                listView.setBackgroundColor(f.getResources().getColor(R.color.skin_1_common_bg));
                listView.setCacheColorHint(f.getResources().getColor(17170445));
                listView.setDivider(f.getResources().getDrawable(R.drawable.list_divider_1));
                listView.setSelector(R.drawable.list_selector_1);
                return;
            }
            listView.setBackgroundColor(f.getResources().getColor(R.color.backgroundcolor));
            listView.setCacheColorHint(f.getResources().getColor(17170445));
            listView.setDivider(f.getResources().getDrawable(R.drawable.list_divider));
            listView.setSelector(R.drawable.list_selector);
        }
    }

    public static void b(ListView listView, int i) {
        if (listView != null) {
            TiebaApplication f = TiebaApplication.f();
            if (i == 1) {
                listView.setBackgroundColor(f.getResources().getColor(R.color.skin_1_common_bg));
                listView.setCacheColorHint(f.getResources().getColor(17170445));
                listView.setSelector(R.drawable.list_selector_1);
                return;
            }
            listView.setBackgroundColor(f.getResources().getColor(R.color.backgroundcolor));
            listView.setCacheColorHint(f.getResources().getColor(17170445));
            listView.setSelector(R.drawable.list_selector);
        }
    }
}
