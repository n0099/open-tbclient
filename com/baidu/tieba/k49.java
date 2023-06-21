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
public class k49 {
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
            sb.append(vi.getUrlEncode(c0.getSrc()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(b0a b0aVar, AbsPbActivity.e eVar) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, b0aVar, eVar) != null) || b0aVar == null || b0aVar.e0() == null || b0aVar.e0().W() == null || eVar == null || eVar.a == null || eVar.b == null || b0aVar.e0().W().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = b0aVar.e0().W().iterator();
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

    public static b0a c(j49 j49Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{j49Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (j49Var != null && j49Var.F() != null && j49Var.F().size() > 0) {
                    b0a b0aVar = j49Var.F().get(0);
                    if (b0aVar.I() != 1) {
                        return d(j49Var);
                    }
                    return b0aVar;
                }
                return null;
            }
            return d(j49Var);
        }
        return (b0a) invokeCommon.objValue;
    }

    public static b0a d(j49 j49Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, j49Var)) == null) {
            if (j49Var != null && j49Var.N() != null && j49Var.N().getAuthor() != null) {
                b0a b0aVar = new b0a();
                MetaData author = j49Var.N().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = j49Var.N().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                b0aVar.S0(1);
                b0aVar.Y0(j49Var.N().getFirstPostId());
                b0aVar.p1(j49Var.N().getTitle());
                b0aVar.o1(j49Var.N().getCreateTime());
                b0aVar.N0(author);
                return b0aVar;
            }
            return null;
        }
        return (b0a) invokeL.objValue;
    }
}
