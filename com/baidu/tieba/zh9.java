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
/* loaded from: classes9.dex */
public class zh9 {
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
            TbRichTextImageInfo V = tbRichTextData.V();
            if (V == null) {
                return null;
            }
            if (!StringUtils.isNull(V.N())) {
                return V.N();
            }
            if (V.getHeight() * V.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (V.getHeight() * V.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (V.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (V.getHeight() * sqrt)));
            } else {
                double width = V.getWidth() / V.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(di.getUrlEncode(V.getSrc()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(zfa zfaVar, AbsPbActivity.e eVar) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, zfaVar, eVar) != null) || zfaVar == null || zfaVar.e0() == null || zfaVar.e0().P() == null || eVar == null || eVar.a == null || eVar.b == null || zfaVar.e0().P().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = zfaVar.e0().P().iterator();
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

    public static zfa c(yh9 yh9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{yh9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (yh9Var != null && yh9Var.F() != null && yh9Var.F().size() > 0) {
                    zfa zfaVar = yh9Var.F().get(0);
                    if (zfaVar.I() != 1) {
                        return d(yh9Var);
                    }
                    return zfaVar;
                }
                return null;
            }
            return d(yh9Var);
        }
        return (zfa) invokeCommon.objValue;
    }

    public static zfa d(yh9 yh9Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, yh9Var)) == null) {
            if (yh9Var != null && yh9Var.O() != null && yh9Var.O().getAuthor() != null) {
                zfa zfaVar = new zfa();
                MetaData author = yh9Var.O().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = yh9Var.O().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                zfaVar.S0(1);
                zfaVar.Y0(yh9Var.O().getFirstPostId());
                zfaVar.p1(yh9Var.O().getTitle());
                zfaVar.o1(yh9Var.O().getCreateTime());
                zfaVar.N0(author);
                return zfaVar;
            }
            return null;
        }
        return (zfa) invokeL.objValue;
    }
}
