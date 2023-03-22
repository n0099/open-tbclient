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
public class li8 {
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
            TbRichTextImageInfo Z = tbRichTextData.Z();
            if (Z == null) {
                return null;
            }
            if (!StringUtils.isNull(Z.R())) {
                return Z.R();
            }
            if (Z.getHeight() * Z.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Z.getHeight() * Z.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (Z.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (Z.getHeight() * sqrt)));
            } else {
                double width = Z.getWidth() / Z.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(gi.getUrlEncode(Z.getSrc()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(bc9 bc9Var, AbsPbActivity.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, bc9Var, eVar) != null) || bc9Var == null || bc9Var.Z() == null || bc9Var.Z().T() == null || eVar == null || eVar.a == null || eVar.b == null || bc9Var.Z().T().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = bc9Var.Z().T().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                String a = a(next);
                if (!StringUtils.isNull(a) && concurrentHashMap.get(a) != null) {
                    eVar.a.add(a);
                    eVar.b.put(a, concurrentHashMap.get(a));
                }
            }
        }
        eVar.j = ListUtils.getPosition(eVar.a, str);
    }

    public static bc9 c(ki8 ki8Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{ki8Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (ki8Var != null && ki8Var.H() != null && ki8Var.H().size() > 0) {
                    bc9 bc9Var = ki8Var.H().get(0);
                    if (bc9Var.E() != 1) {
                        return d(ki8Var);
                    }
                    return bc9Var;
                }
                return null;
            }
            return d(ki8Var);
        }
        return (bc9) invokeCommon.objValue;
    }

    public static bc9 d(ki8 ki8Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ki8Var)) == null) {
            if (ki8Var != null && ki8Var.Q() != null && ki8Var.Q().getAuthor() != null) {
                bc9 bc9Var = new bc9();
                MetaData author = ki8Var.Q().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = ki8Var.Q().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                bc9Var.J0(1);
                bc9Var.P0(ki8Var.Q().getFirstPostId());
                bc9Var.g1(ki8Var.Q().getTitle());
                bc9Var.f1(ki8Var.Q().getCreateTime());
                bc9Var.G0(author);
                return bc9Var;
            }
            return null;
        }
        return (bc9) invokeL.objValue;
    }
}
