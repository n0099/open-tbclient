package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon;

import android.content.Context;
import android.text.Spannable;
import android.util.SparseIntArray;
/* loaded from: classes4.dex */
public final class b {
    private static final SparseIntArray osT = new SparseIntArray();

    private static int J(Context context, int i) {
        return osT.get(i);
    }

    private static void gG(Context context) {
        if (osT != null && osT.size() == 0) {
            gH(context);
        }
    }

    private static void gH(Context context) {
        osT.put(128515, bs(context, "emoji_1f603"));
        osT.put(128522, bs(context, "emoji_1f60a"));
        osT.put(9786, bs(context, "emoji_263a"));
        osT.put(128521, bs(context, "emoji_1f609"));
        osT.put(128525, bs(context, "emoji_1f60d"));
        osT.put(128536, bs(context, "emoji_1f618"));
        osT.put(128538, bs(context, "emoji_1f61a"));
        osT.put(128540, bs(context, "emoji_1f61c"));
        osT.put(128541, bs(context, "emoji_1f61d"));
        osT.put(128563, bs(context, "emoji_1f633"));
        osT.put(128513, bs(context, "emoji_1f601"));
        osT.put(128532, bs(context, "emoji_1f614"));
        osT.put(128524, bs(context, "emoji_1f60c"));
        osT.put(128530, bs(context, "emoji_1f612"));
        osT.put(128547, bs(context, "emoji_1f623"));
        osT.put(128546, bs(context, "emoji_1f622"));
        osT.put(128514, bs(context, "emoji_1f602"));
        osT.put(128557, bs(context, "emoji_1f62d"));
        osT.put(128554, bs(context, "emoji_1f62a"));
        osT.put(128549, bs(context, "emoji_1f625"));
        osT.put(128560, bs(context, "emoji_1f630"));
        osT.put(128517, bs(context, "emoji_1f605"));
        osT.put(128531, bs(context, "emoji_1f613"));
        osT.put(128555, bs(context, "emoji_1f62b"));
        osT.put(128552, bs(context, "emoji_1f628"));
        osT.put(128561, bs(context, "emoji_1f631"));
        osT.put(128544, bs(context, "emoji_1f620"));
        osT.put(128545, bs(context, "emoji_1f621"));
        osT.put(128548, bs(context, "emoji_1f624"));
        osT.put(128534, bs(context, "emoji_1f616"));
        osT.put(128518, bs(context, "emoji_1f606"));
        osT.put(128523, bs(context, "emoji_1f60b"));
        osT.put(128567, bs(context, "emoji_1f637"));
        osT.put(128526, bs(context, "emoji_1f60e"));
        osT.put(128564, bs(context, "emoji_1f634"));
        osT.put(128565, bs(context, "emoji_1f635"));
        osT.put(128562, bs(context, "emoji_1f632"));
        osT.put(128543, bs(context, "emoji_1f61f"));
        osT.put(128520, bs(context, "emoji_1f608"));
        osT.put(128556, bs(context, "emoji_1f62c"));
        osT.put(128528, bs(context, "emoji_1f610"));
        osT.put(128533, bs(context, "emoji_1f615"));
        osT.put(128559, bs(context, "emoji_1f62f"));
        osT.put(128519, bs(context, "emoji_1f607"));
        osT.put(128527, bs(context, "emoji_1f60f"));
        osT.put(128124, bs(context, "emoji_1f47c"));
        osT.put(128169, bs(context, "emoji_1f4a9"));
        osT.put(128293, bs(context, "emoji_1f525"));
        osT.put(10024, bs(context, "emoji_2728"));
        osT.put(128165, bs(context, "emoji_1f4a5"));
        osT.put(128162, bs(context, "emoji_1f4a2"));
        osT.put(128166, bs(context, "emoji_1f4a6"));
        osT.put(128167, bs(context, "emoji_1f4a7"));
        osT.put(128164, bs(context, "emoji_1f4a4"));
        osT.put(128168, bs(context, "emoji_1f4a8"));
        osT.put(128064, bs(context, "emoji_1f440"));
        osT.put(128068, bs(context, "emoji_1f444"));
        osT.put(128077, bs(context, "emoji_1f44d"));
        osT.put(128078, bs(context, "emoji_1f44e"));
        osT.put(128076, bs(context, "emoji_1f44c"));
        osT.put(128074, bs(context, "emoji_1f44a"));
        osT.put(128075, bs(context, "emoji_1f44b"));
        osT.put(128591, bs(context, "emoji_1f64f"));
        osT.put(128079, bs(context, "emoji_1f44f"));
        osT.put(128170, bs(context, "emoji_1f4aa"));
        osT.put(127939, bs(context, "emoji_1f3c3"));
        osT.put(128582, bs(context, "emoji_1f646"));
        osT.put(128581, bs(context, "emoji_1f645"));
        osT.put(128583, bs(context, "emoji_1f647"));
        osT.put(128081, bs(context, "emoji_1f451"));
        osT.put(128089, bs(context, "emoji_1f459"));
        osT.put(127872, bs(context, "emoji_1f380"));
        osT.put(127746, bs(context, "emoji_1f302"));
        osT.put(10084, bs(context, "emoji_2764"));
        osT.put(128139, bs(context, "emoji_1f48b"));
        osT.put(128141, bs(context, "emoji_1f48d"));
        osT.put(128099, bs(context, "emoji_1f463"));
        osT.put(128054, bs(context, "emoji_1f436"));
        osT.put(128055, bs(context, "emoji_1f437"));
        osT.put(128053, bs(context, "emoji_1f435"));
        osT.put(128052, bs(context, "emoji_1f434"));
        osT.put(127800, bs(context, "emoji_1f338"));
        osT.put(127808, bs(context, "emoji_1f340"));
        osT.put(127801, bs(context, "emoji_1f339"));
        osT.put(127809, bs(context, "emoji_1f341"));
        osT.put(127810, bs(context, "emoji_1f342"));
        osT.put(127794, bs(context, "emoji_1f332"));
        osT.put(127769, bs(context, "emoji_1f319"));
        osT.put(9925, bs(context, "emoji_26c5"));
        osT.put(9889, bs(context, "emoji_26a1"));
        osT.put(9748, bs(context, "emoji_2614"));
        osT.put(9924, bs(context, "emoji_26c4"));
        osT.put(127752, bs(context, "emoji_1f308"));
        osT.put(127878, bs(context, "emoji_1f386"));
        osT.put(127879, bs(context, "emoji_1f387"));
        osT.put(127875, bs(context, "emoji_1f383"));
        osT.put(127877, bs(context, "emoji_1f385"));
        osT.put(127876, bs(context, "emoji_1f384"));
        osT.put(127873, bs(context, "emoji_1f381"));
        osT.put(127881, bs(context, "emoji_1f389"));
        osT.put(128247, bs(context, "emoji_1f4f7"));
        osT.put(9742, bs(context, "emoji_260e"));
        osT.put(128163, bs(context, "emoji_1f4a3"));
        osT.put(128298, bs(context, "emoji_1f52a"));
        osT.put(128176, bs(context, "emoji_1f4b0"));
        osT.put(127936, bs(context, "emoji_1f3c0"));
        osT.put(127937, bs(context, "emoji_1f3c1"));
        osT.put(127938, bs(context, "emoji_1f3c2"));
        osT.put(9749, bs(context, "emoji_2615"));
        osT.put(127863, bs(context, "emoji_1f377"));
        osT.put(127874, bs(context, "emoji_1f382"));
        osT.put(127853, bs(context, "emoji_1f36d"));
        osT.put(127817, bs(context, "emoji_1f349"));
        osT.put(9888, bs(context, "emoji_26a0"));
        osT.put(128205, bs(context, "emoji_1f4cd"));
        osT.put(9940, bs(context, "emoji_26d4"));
        osT.put(10062, bs(context, "emoji_274e"));
        osT.put(9989, bs(context, "emoji_2705"));
        osT.put(10133, bs(context, "emoji_2795"));
    }

    private static int bs(Context context, String str) {
        return com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().h(context, context.getPackageName(), str, "drawable");
    }

    public static void a(Context context, Spannable spannable, int i) {
        int i2;
        int bs;
        int i3;
        gG(context);
        int length = spannable.length();
        for (c cVar : (c[]) spannable.getSpans(0, length, c.class)) {
            spannable.removeSpan(cVar);
        }
        int i4 = 0;
        while (i4 < length) {
            int codePointAt = Character.codePointAt(spannable, i4);
            int charCount = Character.charCount(codePointAt);
            int J = codePointAt > 255 ? J(context, codePointAt) : 0;
            if (J != 0 || i4 + charCount >= length) {
                i2 = charCount;
            } else {
                int codePointAt2 = Character.codePointAt(spannable, i4 + charCount);
                if (codePointAt2 == 8419) {
                    i2 = Character.charCount(codePointAt2) + charCount;
                } else {
                    int charCount2 = Character.charCount(codePointAt2);
                    switch (codePointAt) {
                        case 127464:
                            bs = codePointAt2 == 127475 ? bs(context, "emoji_1f1e8_1f1f3") : 0;
                            i3 = charCount2;
                            break;
                        default:
                            bs = J;
                            i3 = 0;
                            break;
                    }
                    int i5 = bs;
                    i2 = i3 + charCount;
                    J = i5;
                }
            }
            if (J > 0) {
                spannable.setSpan(new c(context, J, i), i4, i4 + i2, 33);
            }
            i4 += i2;
        }
    }

    public static void a(Context context, Spannable spannable, int i, int i2, int i3, int i4) {
        int i5;
        int bs;
        int i6;
        gG(context);
        int i7 = i2 + i4;
        int i8 = i2 + i3;
        while (i8 < i7) {
            int codePointAt = Character.codePointAt(spannable, i8);
            int charCount = Character.charCount(codePointAt);
            int J = codePointAt > 255 ? J(context, codePointAt) : 0;
            if (J != 0 || i8 + charCount >= i7) {
                i5 = charCount;
            } else {
                int codePointAt2 = Character.codePointAt(spannable, i8 + charCount);
                if (codePointAt2 == 8419) {
                    i5 = Character.charCount(codePointAt2) + charCount;
                } else {
                    int charCount2 = Character.charCount(codePointAt2);
                    switch (codePointAt) {
                        case 127464:
                            bs = codePointAt2 == 127475 ? bs(context, "emoji_1f1e8_1f1f3") : 0;
                            i6 = charCount2;
                            break;
                        default:
                            bs = J;
                            i6 = 0;
                            break;
                    }
                    int i9 = bs;
                    i5 = i6 + charCount;
                    J = i9;
                }
            }
            if (J > 0) {
                spannable.setSpan(new c(context, J, i), i8, i8 + i5, 33);
            }
            i8 += i5;
        }
    }
}
