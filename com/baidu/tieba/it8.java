package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class it8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbRichTextData)) == null) {
            if (tbRichTextData == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(150);
            TbRichTextImageInfo Y = tbRichTextData.Y();
            if (Y == null) {
                return null;
            }
            if (!StringUtils.isNull(Y.Q())) {
                return Y.Q();
            }
            if (Y.getHeight() * Y.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Y.getHeight() * Y.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (Y.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (Y.getHeight() * sqrt)));
            } else {
                double width = Y.getWidth() / Y.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(hi.getUrlEncode(Y.getSrc()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(am9 am9Var, AbsPbActivity.e eVar) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, am9Var, eVar) != null) || am9Var == null || am9Var.a0() == null || am9Var.a0().S() == null || eVar == null || eVar.a == null || eVar.b == null || am9Var.a0().S().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = am9Var.a0().S().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                String a = a(next);
                if (!StringUtils.isNull(a) && concurrentHashMap.get(a) != null && (imageUrlData = concurrentHashMap.get(a)) != null) {
                    eVar.a.add(a);
                    eVar.b.put(a, imageUrlData);
                }
            }
        }
        eVar.j = ListUtils.getPosition(eVar.a, str);
    }

    public static am9 c(ht8 ht8Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{ht8Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (ht8Var != null && ht8Var.F() != null && ht8Var.F().size() > 0) {
                    am9 am9Var = ht8Var.F().get(0);
                    if (am9Var.E() != 1) {
                        return d(ht8Var);
                    }
                    return am9Var;
                }
                return null;
            }
            return d(ht8Var);
        }
        return (am9) invokeCommon.objValue;
    }

    public static am9 d(ht8 ht8Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ht8Var)) == null) {
            if (ht8Var != null && ht8Var.M() != null && ht8Var.M().getAuthor() != null) {
                am9 am9Var = new am9();
                MetaData author = ht8Var.M().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = ht8Var.M().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                am9Var.K0(1);
                am9Var.Q0(ht8Var.M().getFirstPostId());
                am9Var.h1(ht8Var.M().getTitle());
                am9Var.g1(ht8Var.M().getCreateTime());
                am9Var.H0(author);
                return am9Var;
            }
            return null;
        }
        return (am9) invokeL.objValue;
    }
}
