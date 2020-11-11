package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon;

import android.content.Context;
import android.text.Spannable;
import android.util.SparseIntArray;
/* loaded from: classes4.dex */
public final class b {
    private static final SparseIntArray oCm = new SparseIntArray();

    private static int K(Context context, int i) {
        return oCm.get(i);
    }

    private static void gG(Context context) {
        if (oCm != null && oCm.size() == 0) {
            gH(context);
        }
    }

    private static void gH(Context context) {
        oCm.put(128515, bs(context, "emoji_1f603"));
        oCm.put(128522, bs(context, "emoji_1f60a"));
        oCm.put(9786, bs(context, "emoji_263a"));
        oCm.put(128521, bs(context, "emoji_1f609"));
        oCm.put(128525, bs(context, "emoji_1f60d"));
        oCm.put(128536, bs(context, "emoji_1f618"));
        oCm.put(128538, bs(context, "emoji_1f61a"));
        oCm.put(128540, bs(context, "emoji_1f61c"));
        oCm.put(128541, bs(context, "emoji_1f61d"));
        oCm.put(128563, bs(context, "emoji_1f633"));
        oCm.put(128513, bs(context, "emoji_1f601"));
        oCm.put(128532, bs(context, "emoji_1f614"));
        oCm.put(128524, bs(context, "emoji_1f60c"));
        oCm.put(128530, bs(context, "emoji_1f612"));
        oCm.put(128547, bs(context, "emoji_1f623"));
        oCm.put(128546, bs(context, "emoji_1f622"));
        oCm.put(128514, bs(context, "emoji_1f602"));
        oCm.put(128557, bs(context, "emoji_1f62d"));
        oCm.put(128554, bs(context, "emoji_1f62a"));
        oCm.put(128549, bs(context, "emoji_1f625"));
        oCm.put(128560, bs(context, "emoji_1f630"));
        oCm.put(128517, bs(context, "emoji_1f605"));
        oCm.put(128531, bs(context, "emoji_1f613"));
        oCm.put(128555, bs(context, "emoji_1f62b"));
        oCm.put(128552, bs(context, "emoji_1f628"));
        oCm.put(128561, bs(context, "emoji_1f631"));
        oCm.put(128544, bs(context, "emoji_1f620"));
        oCm.put(128545, bs(context, "emoji_1f621"));
        oCm.put(128548, bs(context, "emoji_1f624"));
        oCm.put(128534, bs(context, "emoji_1f616"));
        oCm.put(128518, bs(context, "emoji_1f606"));
        oCm.put(128523, bs(context, "emoji_1f60b"));
        oCm.put(128567, bs(context, "emoji_1f637"));
        oCm.put(128526, bs(context, "emoji_1f60e"));
        oCm.put(128564, bs(context, "emoji_1f634"));
        oCm.put(128565, bs(context, "emoji_1f635"));
        oCm.put(128562, bs(context, "emoji_1f632"));
        oCm.put(128543, bs(context, "emoji_1f61f"));
        oCm.put(128520, bs(context, "emoji_1f608"));
        oCm.put(128556, bs(context, "emoji_1f62c"));
        oCm.put(128528, bs(context, "emoji_1f610"));
        oCm.put(128533, bs(context, "emoji_1f615"));
        oCm.put(128559, bs(context, "emoji_1f62f"));
        oCm.put(128519, bs(context, "emoji_1f607"));
        oCm.put(128527, bs(context, "emoji_1f60f"));
        oCm.put(128124, bs(context, "emoji_1f47c"));
        oCm.put(128169, bs(context, "emoji_1f4a9"));
        oCm.put(128293, bs(context, "emoji_1f525"));
        oCm.put(10024, bs(context, "emoji_2728"));
        oCm.put(128165, bs(context, "emoji_1f4a5"));
        oCm.put(128162, bs(context, "emoji_1f4a2"));
        oCm.put(128166, bs(context, "emoji_1f4a6"));
        oCm.put(128167, bs(context, "emoji_1f4a7"));
        oCm.put(128164, bs(context, "emoji_1f4a4"));
        oCm.put(128168, bs(context, "emoji_1f4a8"));
        oCm.put(128064, bs(context, "emoji_1f440"));
        oCm.put(128068, bs(context, "emoji_1f444"));
        oCm.put(128077, bs(context, "emoji_1f44d"));
        oCm.put(128078, bs(context, "emoji_1f44e"));
        oCm.put(128076, bs(context, "emoji_1f44c"));
        oCm.put(128074, bs(context, "emoji_1f44a"));
        oCm.put(128075, bs(context, "emoji_1f44b"));
        oCm.put(128591, bs(context, "emoji_1f64f"));
        oCm.put(128079, bs(context, "emoji_1f44f"));
        oCm.put(128170, bs(context, "emoji_1f4aa"));
        oCm.put(127939, bs(context, "emoji_1f3c3"));
        oCm.put(128582, bs(context, "emoji_1f646"));
        oCm.put(128581, bs(context, "emoji_1f645"));
        oCm.put(128583, bs(context, "emoji_1f647"));
        oCm.put(128081, bs(context, "emoji_1f451"));
        oCm.put(128089, bs(context, "emoji_1f459"));
        oCm.put(127872, bs(context, "emoji_1f380"));
        oCm.put(127746, bs(context, "emoji_1f302"));
        oCm.put(10084, bs(context, "emoji_2764"));
        oCm.put(128139, bs(context, "emoji_1f48b"));
        oCm.put(128141, bs(context, "emoji_1f48d"));
        oCm.put(128099, bs(context, "emoji_1f463"));
        oCm.put(128054, bs(context, "emoji_1f436"));
        oCm.put(128055, bs(context, "emoji_1f437"));
        oCm.put(128053, bs(context, "emoji_1f435"));
        oCm.put(128052, bs(context, "emoji_1f434"));
        oCm.put(127800, bs(context, "emoji_1f338"));
        oCm.put(127808, bs(context, "emoji_1f340"));
        oCm.put(127801, bs(context, "emoji_1f339"));
        oCm.put(127809, bs(context, "emoji_1f341"));
        oCm.put(127810, bs(context, "emoji_1f342"));
        oCm.put(127794, bs(context, "emoji_1f332"));
        oCm.put(127769, bs(context, "emoji_1f319"));
        oCm.put(9925, bs(context, "emoji_26c5"));
        oCm.put(9889, bs(context, "emoji_26a1"));
        oCm.put(9748, bs(context, "emoji_2614"));
        oCm.put(9924, bs(context, "emoji_26c4"));
        oCm.put(127752, bs(context, "emoji_1f308"));
        oCm.put(127878, bs(context, "emoji_1f386"));
        oCm.put(127879, bs(context, "emoji_1f387"));
        oCm.put(127875, bs(context, "emoji_1f383"));
        oCm.put(127877, bs(context, "emoji_1f385"));
        oCm.put(127876, bs(context, "emoji_1f384"));
        oCm.put(127873, bs(context, "emoji_1f381"));
        oCm.put(127881, bs(context, "emoji_1f389"));
        oCm.put(128247, bs(context, "emoji_1f4f7"));
        oCm.put(9742, bs(context, "emoji_260e"));
        oCm.put(128163, bs(context, "emoji_1f4a3"));
        oCm.put(128298, bs(context, "emoji_1f52a"));
        oCm.put(128176, bs(context, "emoji_1f4b0"));
        oCm.put(127936, bs(context, "emoji_1f3c0"));
        oCm.put(127937, bs(context, "emoji_1f3c1"));
        oCm.put(127938, bs(context, "emoji_1f3c2"));
        oCm.put(9749, bs(context, "emoji_2615"));
        oCm.put(127863, bs(context, "emoji_1f377"));
        oCm.put(127874, bs(context, "emoji_1f382"));
        oCm.put(127853, bs(context, "emoji_1f36d"));
        oCm.put(127817, bs(context, "emoji_1f349"));
        oCm.put(9888, bs(context, "emoji_26a0"));
        oCm.put(128205, bs(context, "emoji_1f4cd"));
        oCm.put(9940, bs(context, "emoji_26d4"));
        oCm.put(10062, bs(context, "emoji_274e"));
        oCm.put(9989, bs(context, "emoji_2705"));
        oCm.put(10133, bs(context, "emoji_2795"));
    }

    private static int bs(Context context, String str) {
        return com.baidu.yuyinala.privatemessage.implugin.d.b.efv().h(context, context.getPackageName(), str, "drawable");
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
            int K = codePointAt > 255 ? K(context, codePointAt) : 0;
            if (K != 0 || i4 + charCount >= length) {
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
                            bs = K;
                            i3 = 0;
                            break;
                    }
                    int i5 = bs;
                    i2 = i3 + charCount;
                    K = i5;
                }
            }
            if (K > 0) {
                spannable.setSpan(new c(context, K, i), i4, i4 + i2, 33);
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
            int K = codePointAt > 255 ? K(context, codePointAt) : 0;
            if (K != 0 || i8 + charCount >= i7) {
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
                            bs = K;
                            i6 = 0;
                            break;
                    }
                    int i9 = bs;
                    i5 = i6 + charCount;
                    K = i9;
                }
            }
            if (K > 0) {
                spannable.setSpan(new c(context, K, i), i8, i8 + i5, 33);
            }
            i8 += i5;
        }
    }
}
