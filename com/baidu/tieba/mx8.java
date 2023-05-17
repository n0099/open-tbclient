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
/* loaded from: classes6.dex */
public class mx8 {
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
            TbRichTextImageInfo c0 = tbRichTextData.c0();
            if (c0 == null) {
                return null;
            }
            if (!StringUtils.isNull(c0.U())) {
                return c0.U();
            }
            if (c0.getHeight() * c0.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (c0.getHeight() * c0.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (c0.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (c0.getHeight() * sqrt)));
            } else {
                double width = c0.getWidth() / c0.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(qi.getUrlEncode(c0.getSrc()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(rr9 rr9Var, AbsPbActivity.e eVar) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, rr9Var, eVar) != null) || rr9Var == null || rr9Var.a0() == null || rr9Var.a0().W() == null || eVar == null || eVar.a == null || eVar.b == null || rr9Var.a0().W().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = rr9Var.a0().W().iterator();
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

    public static rr9 c(lx8 lx8Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{lx8Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (lx8Var != null && lx8Var.F() != null && lx8Var.F().size() > 0) {
                    rr9 rr9Var = lx8Var.F().get(0);
                    if (rr9Var.D() != 1) {
                        return d(lx8Var);
                    }
                    return rr9Var;
                }
                return null;
            }
            return d(lx8Var);
        }
        return (rr9) invokeCommon.objValue;
    }

    public static rr9 d(lx8 lx8Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lx8Var)) == null) {
            if (lx8Var != null && lx8Var.M() != null && lx8Var.M().getAuthor() != null) {
                rr9 rr9Var = new rr9();
                MetaData author = lx8Var.M().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = lx8Var.M().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                rr9Var.L0(1);
                rr9Var.R0(lx8Var.M().getFirstPostId());
                rr9Var.i1(lx8Var.M().getTitle());
                rr9Var.h1(lx8Var.M().getCreateTime());
                rr9Var.I0(author);
                return rr9Var;
            }
            return null;
        }
        return (rr9) invokeL.objValue;
    }
}
