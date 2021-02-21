package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon;

import android.content.Context;
import android.text.Spannable;
import android.util.SparseIntArray;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public final class b {
    private static final SparseIntArray pfp = new SparseIntArray();

    private static int T(Context context, int i) {
        return pfp.get(i);
    }

    private static void bw(Context context) {
        if (pfp != null && pfp.size() == 0) {
            bx(context);
        }
    }

    private static void bx(Context context) {
        pfp.put(128515, a.e.emoji_1f603);
        pfp.put(128522, a.e.emoji_1f60a);
        pfp.put(9786, a.e.emoji_263a);
        pfp.put(128521, a.e.emoji_1f609);
        pfp.put(128525, a.e.emoji_1f60d);
        pfp.put(128536, a.e.emoji_1f618);
        pfp.put(128538, a.e.emoji_1f61a);
        pfp.put(128540, a.e.emoji_1f61c);
        pfp.put(128541, a.e.emoji_1f61d);
        pfp.put(128563, a.e.emoji_1f633);
        pfp.put(128513, a.e.emoji_1f601);
        pfp.put(128532, a.e.emoji_1f614);
        pfp.put(128524, a.e.emoji_1f60c);
        pfp.put(128530, a.e.emoji_1f612);
        pfp.put(128547, a.e.emoji_1f623);
        pfp.put(128546, a.e.emoji_1f622);
        pfp.put(128514, a.e.emoji_1f602);
        pfp.put(128557, a.e.emoji_1f62d);
        pfp.put(128554, a.e.emoji_1f62a);
        pfp.put(128549, a.e.emoji_1f625);
        pfp.put(128560, a.e.emoji_1f630);
        pfp.put(128517, a.e.emoji_1f605);
        pfp.put(128531, a.e.emoji_1f613);
        pfp.put(128555, a.e.emoji_1f62b);
        pfp.put(128552, a.e.emoji_1f628);
        pfp.put(128561, a.e.emoji_1f631);
        pfp.put(128544, a.e.emoji_1f620);
        pfp.put(128545, a.e.emoji_1f621);
        pfp.put(128548, a.e.emoji_1f624);
        pfp.put(128534, a.e.emoji_1f616);
        pfp.put(128518, a.e.emoji_1f606);
        pfp.put(128523, a.e.emoji_1f60b);
        pfp.put(128567, a.e.emoji_1f637);
        pfp.put(128526, a.e.emoji_1f60e);
        pfp.put(128564, a.e.emoji_1f634);
        pfp.put(128565, a.e.emoji_1f635);
        pfp.put(128562, a.e.emoji_1f632);
        pfp.put(128543, a.e.emoji_1f61f);
        pfp.put(128520, a.e.emoji_1f608);
        pfp.put(128556, a.e.emoji_1f62c);
        pfp.put(128528, a.e.emoji_1f610);
        pfp.put(128533, a.e.emoji_1f615);
        pfp.put(128559, a.e.emoji_1f62f);
        pfp.put(128519, a.e.emoji_1f607);
        pfp.put(128527, a.e.emoji_1f60f);
        pfp.put(128124, a.e.emoji_1f47c);
        pfp.put(128169, a.e.emoji_1f4a9);
        pfp.put(128293, a.e.emoji_1f525);
        pfp.put(10024, a.e.emoji_2728);
        pfp.put(128165, a.e.emoji_1f4a5);
        pfp.put(128162, a.e.emoji_1f4a2);
        pfp.put(128166, a.e.emoji_1f4a6);
        pfp.put(128167, a.e.emoji_1f4a7);
        pfp.put(128164, a.e.emoji_1f4a4);
        pfp.put(128168, a.e.emoji_1f4a8);
        pfp.put(128064, a.e.emoji_1f440);
        pfp.put(128068, a.e.emoji_1f444);
        pfp.put(128077, a.e.emoji_1f44d);
        pfp.put(128078, a.e.emoji_1f44e);
        pfp.put(128076, a.e.emoji_1f44c);
        pfp.put(128074, a.e.emoji_1f44a);
        pfp.put(128075, a.e.emoji_1f44b);
        pfp.put(128591, a.e.emoji_1f64f);
        pfp.put(128079, a.e.emoji_1f44f);
        pfp.put(128170, a.e.emoji_1f4aa);
        pfp.put(127939, a.e.emoji_1f3c3);
        pfp.put(128582, a.e.emoji_1f646);
        pfp.put(128581, a.e.emoji_1f645);
        pfp.put(128583, a.e.emoji_1f647);
        pfp.put(128081, a.e.emoji_1f451);
        pfp.put(128089, a.e.emoji_1f459);
        pfp.put(127872, a.e.emoji_1f380);
        pfp.put(127746, a.e.emoji_1f302);
        pfp.put(10084, a.e.emoji_2764);
        pfp.put(128139, a.e.emoji_1f48b);
        pfp.put(128141, a.e.emoji_1f48d);
        pfp.put(128099, a.e.emoji_1f463);
        pfp.put(128054, a.e.emoji_1f436);
        pfp.put(128055, a.e.emoji_1f437);
        pfp.put(128053, a.e.emoji_1f435);
        pfp.put(128052, a.e.emoji_1f434);
        pfp.put(127800, a.e.emoji_1f338);
        pfp.put(127808, a.e.emoji_1f340);
        pfp.put(127801, a.e.emoji_1f339);
        pfp.put(127809, a.e.emoji_1f341);
        pfp.put(127810, a.e.emoji_1f342);
        pfp.put(127794, a.e.emoji_1f332);
        pfp.put(127769, a.e.emoji_1f319);
        pfp.put(9925, a.e.emoji_26c5);
        pfp.put(9889, a.e.emoji_26a1);
        pfp.put(9748, a.e.emoji_2614);
        pfp.put(9924, a.e.emoji_26c4);
        pfp.put(127752, a.e.emoji_1f308);
        pfp.put(127878, a.e.emoji_1f386);
        pfp.put(127879, a.e.emoji_1f387);
        pfp.put(127875, a.e.emoji_1f383);
        pfp.put(127877, a.e.emoji_1f385);
        pfp.put(127876, a.e.emoji_1f384);
        pfp.put(127873, a.e.emoji_1f381);
        pfp.put(127881, a.e.emoji_1f389);
        pfp.put(128247, a.e.emoji_1f4f7);
        pfp.put(9742, a.e.emoji_260e);
        pfp.put(128163, a.e.emoji_1f4a3);
        pfp.put(128298, a.e.emoji_1f52a);
        pfp.put(128176, a.e.emoji_1f4b0);
        pfp.put(127936, a.e.emoji_1f3c0);
        pfp.put(127937, a.e.emoji_1f3c1);
        pfp.put(127938, a.e.emoji_1f3c2);
        pfp.put(9749, a.e.emoji_2615);
        pfp.put(127863, a.e.emoji_1f377);
        pfp.put(127874, a.e.emoji_1f382);
        pfp.put(127853, a.e.emoji_1f36d);
        pfp.put(127817, a.e.emoji_1f349);
        pfp.put(9888, a.e.emoji_26a0);
        pfp.put(128205, a.e.emoji_1f4cd);
        pfp.put(9940, a.e.emoji_26d4);
        pfp.put(10062, a.e.emoji_274e);
        pfp.put(9989, a.e.emoji_2705);
        pfp.put(10133, a.e.emoji_2795);
    }

    public static void a(Context context, Spannable spannable, int i) {
        int i2;
        bw(context);
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
        bw(context);
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
