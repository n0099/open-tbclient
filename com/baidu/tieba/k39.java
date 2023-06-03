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
public class k39 {
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
            sb.append(ui.getUrlEncode(c0.getSrc()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(ey9 ey9Var, AbsPbActivity.e eVar) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, ey9Var, eVar) != null) || ey9Var == null || ey9Var.a0() == null || ey9Var.a0().W() == null || eVar == null || eVar.a == null || eVar.b == null || ey9Var.a0().W().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = ey9Var.a0().W().iterator();
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

    public static ey9 c(j39 j39Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{j39Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (j39Var != null && j39Var.F() != null && j39Var.F().size() > 0) {
                    ey9 ey9Var = j39Var.F().get(0);
                    if (ey9Var.D() != 1) {
                        return d(j39Var);
                    }
                    return ey9Var;
                }
                return null;
            }
            return d(j39Var);
        }
        return (ey9) invokeCommon.objValue;
    }

    public static ey9 d(j39 j39Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, j39Var)) == null) {
            if (j39Var != null && j39Var.N() != null && j39Var.N().getAuthor() != null) {
                ey9 ey9Var = new ey9();
                MetaData author = j39Var.N().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = j39Var.N().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                ey9Var.L0(1);
                ey9Var.R0(j39Var.N().getFirstPostId());
                ey9Var.i1(j39Var.N().getTitle());
                ey9Var.h1(j39Var.N().getCreateTime());
                ey9Var.I0(author);
                return ey9Var;
            }
            return null;
        }
        return (ey9) invokeL.objValue;
    }
}
