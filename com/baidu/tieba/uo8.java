package com.baidu.tieba;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tieba.vi5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class uo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static SpannableString a(ArrayList<gy5> arrayList, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, arrayList, str)) == null) {
            if (TbFaceManager.i().p(str)) {
                SpannableString spannableString = new SpannableString(str + " ");
                gy5 d = TbFaceManager.i().d(str);
                if (arrayList != null) {
                    arrayList.add(d);
                }
                vi5.a g = TbFaceManager.i().g(str);
                if (g != null) {
                    int a = (int) (g.a() * 0.5d);
                    d.setBounds(new Rect(0, 0, a, a));
                } else {
                    d.setBounds(new Rect(0, 0, 0, 0));
                }
                spannableString.setSpan(new o07(d, 1), 0, str.length(), 33);
                return spannableString;
            }
            return null;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public static SpannableString b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return UrlManager.findAllWebUrl(str);
        }
        return (SpannableString) invokeL.objValue;
    }

    public static ArrayList<TbRichTextData> c(String str, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            ArrayList<TbRichTextData> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            TbRichTextData tbRichTextData = new TbRichTextData(1);
            arrayList.add(tbRichTextData);
            try {
                int length = str.length();
                int i3 = 0;
                String str2 = "";
                while (i3 < str.length()) {
                    char charAt = str.charAt(i3);
                    if (charAt == '#' && i3 < length - 1 && str.charAt(i3 + 1) == '(') {
                        String str3 = SmallTailInfo.EMOTION_PREFIX;
                        i3 += 2;
                        while (i3 < length) {
                            char charAt2 = str.charAt(i3);
                            str3 = str3 + charAt2;
                            if (charAt2 != ')' && ((i2 = i3 + 1) >= length || str.charAt(i2) != '#')) {
                                i3 = i2;
                            }
                        }
                        if (!TbFaceManager.i().p(str3)) {
                            str2 = str2 + str3;
                        } else {
                            if (!TextUtils.isEmpty(str2)) {
                                if (i == 1) {
                                    tbRichTextData.P(str2);
                                } else {
                                    SpannableString b = b(str2);
                                    if (b != null) {
                                        tbRichTextData.P(b);
                                    }
                                }
                                str2 = "";
                            }
                            SpannableString a = a(tbRichTextData.Q(), str3);
                            if (a != null) {
                                tbRichTextData.P(a);
                            }
                        }
                    } else {
                        str2 = str2 + charAt;
                    }
                    i3++;
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (i == 1) {
                        tbRichTextData.P(str2);
                    } else {
                        SpannableString b2 = b(str2);
                        if (b2 != null) {
                            tbRichTextData.P(b2);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }
}
