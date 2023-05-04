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
public class rv8 {
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
            TbRichTextImageInfo d0 = tbRichTextData.d0();
            if (d0 == null) {
                return null;
            }
            if (!StringUtils.isNull(d0.V())) {
                return d0.V();
            }
            if (d0.getHeight() * d0.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (d0.getHeight() * d0.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (d0.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (d0.getHeight() * sqrt)));
            } else {
                double width = d0.getWidth() / d0.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(hi.getUrlEncode(d0.getSrc()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(pp9 pp9Var, AbsPbActivity.e eVar) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, pp9Var, eVar) != null) || pp9Var == null || pp9Var.a0() == null || pp9Var.a0().X() == null || eVar == null || eVar.a == null || eVar.b == null || pp9Var.a0().X().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = pp9Var.a0().X().iterator();
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

    public static pp9 c(qv8 qv8Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{qv8Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (qv8Var != null && qv8Var.F() != null && qv8Var.F().size() > 0) {
                    pp9 pp9Var = qv8Var.F().get(0);
                    if (pp9Var.D() != 1) {
                        return d(qv8Var);
                    }
                    return pp9Var;
                }
                return null;
            }
            return d(qv8Var);
        }
        return (pp9) invokeCommon.objValue;
    }

    public static pp9 d(qv8 qv8Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, qv8Var)) == null) {
            if (qv8Var != null && qv8Var.M() != null && qv8Var.M().getAuthor() != null) {
                pp9 pp9Var = new pp9();
                MetaData author = qv8Var.M().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = qv8Var.M().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                pp9Var.L0(1);
                pp9Var.R0(qv8Var.M().getFirstPostId());
                pp9Var.i1(qv8Var.M().getTitle());
                pp9Var.h1(qv8Var.M().getCreateTime());
                pp9Var.I0(author);
                return pp9Var;
            }
            return null;
        }
        return (pp9) invokeL.objValue;
    }
}
