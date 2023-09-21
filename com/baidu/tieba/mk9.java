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
/* loaded from: classes7.dex */
public class mk9 {
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
            TbRichTextImageInfo U = tbRichTextData.U();
            if (U == null) {
                return null;
            }
            if (!StringUtils.isNull(U.M())) {
                return U.M();
            }
            if (U.getHeight() * U.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (U.getHeight() * U.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (U.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (U.getHeight() * sqrt)));
            } else {
                double width = U.getWidth() / U.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(di.getUrlEncode(U.S()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(zja zjaVar, AbsPbActivity.e eVar) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, zjaVar, eVar) != null) || zjaVar == null || zjaVar.f0() == null || zjaVar.f0().O() == null || eVar == null || eVar.a == null || eVar.b == null || zjaVar.f0().O().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = zjaVar.f0().O().iterator();
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

    public static zja c(lk9 lk9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{lk9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (lk9Var != null && lk9Var.F() != null && lk9Var.F().size() > 0) {
                    zja zjaVar = lk9Var.F().get(0);
                    if (zjaVar.L() != 1) {
                        return d(lk9Var);
                    }
                    return zjaVar;
                }
                return null;
            }
            return d(lk9Var);
        }
        return (zja) invokeCommon.objValue;
    }

    public static zja d(lk9 lk9Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lk9Var)) == null) {
            if (lk9Var != null && lk9Var.O() != null && lk9Var.O().getAuthor() != null) {
                zja zjaVar = new zja();
                MetaData author = lk9Var.O().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = lk9Var.O().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                zjaVar.W0(1);
                zjaVar.c1(lk9Var.O().getFirstPostId());
                zjaVar.t1(lk9Var.O().getTitle());
                zjaVar.s1(lk9Var.O().getCreateTime());
                zjaVar.P0(author);
                return zjaVar;
            }
            return null;
        }
        return (zja) invokeL.objValue;
    }
}
