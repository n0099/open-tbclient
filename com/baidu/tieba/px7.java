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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class px7 {
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
            TbRichTextImageInfo F = tbRichTextData.F();
            if (F == null) {
                return null;
            }
            if (!StringUtils.isNull(F.z())) {
                return F.z();
            }
            if (F.getHeight() * F.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (F.getHeight() * F.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (F.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (F.getHeight() * sqrt)));
            } else {
                double width = F.getWidth() / F.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(xi.getUrlEncode(F.F()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(PostData postData, AbsPbActivity.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, postData, eVar) != null) || postData == null || postData.X() == null || postData.X().B() == null || eVar == null || eVar.a == null || eVar.b == null || postData.X().B().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = postData.X().B().iterator();
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

    public static PostData c(ox7 ox7Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{ox7Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (ox7Var != null && ox7Var.H() != null && ox7Var.H().size() > 0) {
                    PostData postData = ox7Var.H().get(0);
                    if (postData.D() != 1) {
                        return d(ox7Var);
                    }
                    return postData;
                }
                return null;
            }
            return d(ox7Var);
        }
        return (PostData) invokeCommon.objValue;
    }

    public static PostData d(ox7 ox7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ox7Var)) == null) {
            if (ox7Var != null && ox7Var.Q() != null && ox7Var.Q().getAuthor() != null) {
                PostData postData = new PostData();
                MetaData author = ox7Var.Q().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = ox7Var.Q().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                postData.G0(1);
                postData.M0(ox7Var.Q().getFirstPostId());
                postData.d1(ox7Var.Q().getTitle());
                postData.c1(ox7Var.Q().getCreateTime());
                postData.E0(author);
                return postData;
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }
}
