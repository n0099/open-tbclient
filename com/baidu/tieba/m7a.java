package com.baidu.tieba;

import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Toast;
import tbclient.ToastContent;
/* loaded from: classes6.dex */
public class m7a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static BdToastData a(Toast toast) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, toast)) == null) {
            if (toast == null) {
                return null;
            }
            BdToastData bdToastData = new BdToastData();
            bdToastData.setIconType(toast.icon_type.intValue());
            bdToastData.setIconUrl(toast.icon_url);
            bdToastData.setIconWidth(toast.icon_width.intValue());
            bdToastData.setIconHeight(toast.icon_height.intValue());
            bdToastData.setHudWidth(toast.hud_width.intValue());
            ArrayList arrayList = new ArrayList();
            for (ToastContent toastContent : toast.content) {
                if (toastContent != null) {
                    BdToastData.ContentBean contentBean = new BdToastData.ContentBean();
                    contentBean.setText(toastContent.text);
                    contentBean.setHasColor(toastContent.has_color.intValue());
                    contentBean.setTextColor(toastContent.text_color);
                    contentBean.setTextColorDark(toastContent.text_color_dark);
                    arrayList.add(contentBean);
                }
            }
            List<Integer> list = toast.task_ids;
            if (list != null) {
                int[] iArr = new int[list.size()];
                for (int i = 0; i < toast.task_ids.size(); i++) {
                    iArr[i] = toast.task_ids.get(i).intValue();
                }
                bdToastData.setTaskIds(iArr);
            }
            bdToastData.setContent(arrayList);
            bdToastData.setUrl(toast.url);
            bdToastData.setBackground(toast.background);
            return bdToastData;
        }
        return (BdToastData) invokeL.objValue;
    }
}
