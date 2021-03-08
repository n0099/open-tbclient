package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon;

import android.content.Context;
import android.text.Spannable;
import android.util.SparseIntArray;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public final class b {
    private static final SparseIntArray phu = new SparseIntArray();

    private static int T(Context context, int i) {
        return phu.get(i);
    }

    private static void bv(Context context) {
        if (phu != null && phu.size() == 0) {
            bw(context);
        }
    }

    private static void bw(Context context) {
        phu.put(128515, a.e.emoji_1f603);
        phu.put(128522, a.e.emoji_1f60a);
        phu.put(9786, a.e.emoji_263a);
        phu.put(128521, a.e.emoji_1f609);
        phu.put(128525, a.e.emoji_1f60d);
        phu.put(128536, a.e.emoji_1f618);
        phu.put(128538, a.e.emoji_1f61a);
        phu.put(128540, a.e.emoji_1f61c);
        phu.put(128541, a.e.emoji_1f61d);
        phu.put(128563, a.e.emoji_1f633);
        phu.put(128513, a.e.emoji_1f601);
        phu.put(128532, a.e.emoji_1f614);
        phu.put(128524, a.e.emoji_1f60c);
        phu.put(128530, a.e.emoji_1f612);
        phu.put(128547, a.e.emoji_1f623);
        phu.put(128546, a.e.emoji_1f622);
        phu.put(128514, a.e.emoji_1f602);
        phu.put(128557, a.e.emoji_1f62d);
        phu.put(128554, a.e.emoji_1f62a);
        phu.put(128549, a.e.emoji_1f625);
        phu.put(128560, a.e.emoji_1f630);
        phu.put(128517, a.e.emoji_1f605);
        phu.put(128531, a.e.emoji_1f613);
        phu.put(128555, a.e.emoji_1f62b);
        phu.put(128552, a.e.emoji_1f628);
        phu.put(128561, a.e.emoji_1f631);
        phu.put(128544, a.e.emoji_1f620);
        phu.put(128545, a.e.emoji_1f621);
        phu.put(128548, a.e.emoji_1f624);
        phu.put(128534, a.e.emoji_1f616);
        phu.put(128518, a.e.emoji_1f606);
        phu.put(128523, a.e.emoji_1f60b);
        phu.put(128567, a.e.emoji_1f637);
        phu.put(128526, a.e.emoji_1f60e);
        phu.put(128564, a.e.emoji_1f634);
        phu.put(128565, a.e.emoji_1f635);
        phu.put(128562, a.e.emoji_1f632);
        phu.put(128543, a.e.emoji_1f61f);
        phu.put(128520, a.e.emoji_1f608);
        phu.put(128556, a.e.emoji_1f62c);
        phu.put(128528, a.e.emoji_1f610);
        phu.put(128533, a.e.emoji_1f615);
        phu.put(128559, a.e.emoji_1f62f);
        phu.put(128519, a.e.emoji_1f607);
        phu.put(128527, a.e.emoji_1f60f);
        phu.put(128124, a.e.emoji_1f47c);
        phu.put(128169, a.e.emoji_1f4a9);
        phu.put(128293, a.e.emoji_1f525);
        phu.put(10024, a.e.emoji_2728);
        phu.put(128165, a.e.emoji_1f4a5);
        phu.put(128162, a.e.emoji_1f4a2);
        phu.put(128166, a.e.emoji_1f4a6);
        phu.put(128167, a.e.emoji_1f4a7);
        phu.put(128164, a.e.emoji_1f4a4);
        phu.put(128168, a.e.emoji_1f4a8);
        phu.put(128064, a.e.emoji_1f440);
        phu.put(128068, a.e.emoji_1f444);
        phu.put(128077, a.e.emoji_1f44d);
        phu.put(128078, a.e.emoji_1f44e);
        phu.put(128076, a.e.emoji_1f44c);
        phu.put(128074, a.e.emoji_1f44a);
        phu.put(128075, a.e.emoji_1f44b);
        phu.put(128591, a.e.emoji_1f64f);
        phu.put(128079, a.e.emoji_1f44f);
        phu.put(128170, a.e.emoji_1f4aa);
        phu.put(127939, a.e.emoji_1f3c3);
        phu.put(128582, a.e.emoji_1f646);
        phu.put(128581, a.e.emoji_1f645);
        phu.put(128583, a.e.emoji_1f647);
        phu.put(128081, a.e.emoji_1f451);
        phu.put(128089, a.e.emoji_1f459);
        phu.put(127872, a.e.emoji_1f380);
        phu.put(127746, a.e.emoji_1f302);
        phu.put(10084, a.e.emoji_2764);
        phu.put(128139, a.e.emoji_1f48b);
        phu.put(128141, a.e.emoji_1f48d);
        phu.put(128099, a.e.emoji_1f463);
        phu.put(128054, a.e.emoji_1f436);
        phu.put(128055, a.e.emoji_1f437);
        phu.put(128053, a.e.emoji_1f435);
        phu.put(128052, a.e.emoji_1f434);
        phu.put(127800, a.e.emoji_1f338);
        phu.put(127808, a.e.emoji_1f340);
        phu.put(127801, a.e.emoji_1f339);
        phu.put(127809, a.e.emoji_1f341);
        phu.put(127810, a.e.emoji_1f342);
        phu.put(127794, a.e.emoji_1f332);
        phu.put(127769, a.e.emoji_1f319);
        phu.put(9925, a.e.emoji_26c5);
        phu.put(9889, a.e.emoji_26a1);
        phu.put(9748, a.e.emoji_2614);
        phu.put(9924, a.e.emoji_26c4);
        phu.put(127752, a.e.emoji_1f308);
        phu.put(127878, a.e.emoji_1f386);
        phu.put(127879, a.e.emoji_1f387);
        phu.put(127875, a.e.emoji_1f383);
        phu.put(127877, a.e.emoji_1f385);
        phu.put(127876, a.e.emoji_1f384);
        phu.put(127873, a.e.emoji_1f381);
        phu.put(127881, a.e.emoji_1f389);
        phu.put(128247, a.e.emoji_1f4f7);
        phu.put(9742, a.e.emoji_260e);
        phu.put(128163, a.e.emoji_1f4a3);
        phu.put(128298, a.e.emoji_1f52a);
        phu.put(128176, a.e.emoji_1f4b0);
        phu.put(127936, a.e.emoji_1f3c0);
        phu.put(127937, a.e.emoji_1f3c1);
        phu.put(127938, a.e.emoji_1f3c2);
        phu.put(9749, a.e.emoji_2615);
        phu.put(127863, a.e.emoji_1f377);
        phu.put(127874, a.e.emoji_1f382);
        phu.put(127853, a.e.emoji_1f36d);
        phu.put(127817, a.e.emoji_1f349);
        phu.put(9888, a.e.emoji_26a0);
        phu.put(128205, a.e.emoji_1f4cd);
        phu.put(9940, a.e.emoji_26d4);
        phu.put(10062, a.e.emoji_274e);
        phu.put(9989, a.e.emoji_2705);
        phu.put(10133, a.e.emoji_2795);
    }

    public static void a(Context context, Spannable spannable, int i) {
        int i2;
        bv(context);
        int length = spannable.length();
        for (c cVar : (c[]) spannable.getSpans(0, length, c.class)) {
            spannable.removeSpan(cVar);
        }
        int i3 = 0;
        while (i3 < length) {
            int codePointAt = Character.codePointAt(spannable, i3);
            int charCount = Character.charCount(codePointAt);
            int T = codePointAt > 255 ? T(context, codePointAt) : 0;
            if (T != 0 || i3 + charCount >= length) {
                i2 = charCount;
            } else {
                int codePointAt2 = Character.codePointAt(spannable, i3 + charCount);
                if (codePointAt2 == 8419) {
                    i2 = Character.charCount(codePointAt2) + charCount;
                } else {
                    int charCount2 = Character.charCount(codePointAt2);
                    switch (codePointAt) {
                        case 127464:
                            if (codePointAt2 == 127475) {
                                T = a.e.emoji_1f1e8_1f1f3;
                                break;
                            } else {
                                T = 0;
                                break;
                            }
                        default:
                            charCount2 = 0;
                            break;
                    }
                    i2 = charCount2 + charCount;
                }
            }
            if (T > 0) {
                spannable.setSpan(new c(context, T, i), i3, i3 + i2, 33);
            }
            i3 += i2;
        }
    }

    public static void a(Context context, Spannable spannable, int i, int i2, int i3, int i4) {
        int i5;
        bv(context);
        int i6 = i2 + i4;
        int i7 = i2 + i3;
        while (i7 < i6) {
            int codePointAt = Character.codePointAt(spannable, i7);
            int charCount = Character.charCount(codePointAt);
            int T = codePointAt > 255 ? T(context, codePointAt) : 0;
            if (T != 0 || i7 + charCount >= i6) {
                i5 = charCount;
            } else {
                int codePointAt2 = Character.codePointAt(spannable, i7 + charCount);
                if (codePointAt2 == 8419) {
                    i5 = Character.charCount(codePointAt2) + charCount;
                } else {
                    int charCount2 = Character.charCount(codePointAt2);
                    switch (codePointAt) {
                        case 127464:
                            if (codePointAt2 != 127475) {
                                T = 0;
                                break;
                            } else {
                                T = a.e.emoji_1f1e8_1f1f3;
                                break;
                            }
                        default:
                            charCount2 = 0;
                            break;
                    }
                    i5 = charCount2 + charCount;
                }
            }
            if (T > 0) {
                spannable.setSpan(new c(context, T, i), i7, i7 + i5, 33);
            }
            i7 += i5;
        }
    }
}
