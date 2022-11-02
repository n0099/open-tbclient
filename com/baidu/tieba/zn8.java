package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class zn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (BdNetTypeUtil.isWifiNet()) {
                if (TbadkCoreApplication.getInst().getAutoPlaySwitch() != 3) {
                    return true;
                }
                return false;
            } else if (yn5.a().i() && BdNetTypeUtil.isMobileNet() && TbadkCoreApplication.getInst().getAutoPlaySwitch() == 2) {
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            g15 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null && adAdSense.f()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (BdNetTypeUtil.isWifiNet()) {
                    return true;
                }
                return false;
            } else if (BdNetTypeUtil.isMobileNet() && TbadkCoreApplication.getInst().getAutoPlaySwitch() == 2) {
                return true;
            } else {
                if (BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getInst().getAutoPlaySwitch() != 3) {
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static int c(TbPageContext tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbPageContext, str)) == null) {
            if (tbPageContext == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            if (str.startsWith("tieba://deeplink?")) {
                Uri parse = Uri.parse(str);
                if (wf8.j(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT))) != 1000) {
                    if (!d(tbPageContext, parse.getQueryParameter("wap"))) {
                        return 0;
                    }
                    return 2;
                }
                return 1;
            } else if (!d(tbPageContext, str)) {
                return 0;
            } else {
                return 3;
            }
        }
        return invokeLL.intValue;
    }

    public static boolean d(TbPageContext tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, tbPageContext, str)) == null) {
            String[] strArr = {str};
            if (UrlManager.getInstance().UrlValidated(str)) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, strArr, true);
                return true;
            }
            return UrlManager.getInstance().dealOneLink(tbPageContext, strArr);
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(List<Object> list, int i) {
        boolean z;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, list, i) == null) && list != null && list.size() != 0) {
            if (MessageManager.getInstance().findTask(2016447) != null) {
                z = true;
            } else {
                z = false;
            }
            int i3 = 0;
            while (i3 < list.size()) {
                if (list.get(i3) instanceof ICardInfo) {
                    if (z) {
                        ICardInfo iCardInfo = (ICardInfo) list.get(i3);
                        int viewCount = iCardInfo.getViewCount();
                        ArrayList arrayList = new ArrayList();
                        for (int i4 = 0; i4 < viewCount; i4++) {
                            ICardInfo viewItem = iCardInfo.getViewItem(i4, i);
                            if (viewItem != null) {
                                viewItem.setBdUniqueId(li7.b.get(viewItem.getCardType()));
                                arrayList.add(viewItem);
                            }
                        }
                        if (arrayList.size() != 0) {
                            list.remove(i3);
                            list.addAll(i3, arrayList);
                            i2 = arrayList.size();
                            z2 = false;
                            if (!z2) {
                                list.remove(i3);
                                i2 = 0;
                            }
                        }
                    }
                    i2 = 1;
                    z2 = true;
                    if (!z2) {
                    }
                } else {
                    i2 = 1;
                }
                i3 += i2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(List<wn> list, int i) {
        boolean z;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, list, i) == null) && list != null && list.size() != 0) {
            if (MessageManager.getInstance().findTask(2016447) != null) {
                z = true;
            } else {
                z = false;
            }
            int i3 = 0;
            while (i3 < list.size()) {
                if (list.get(i3) instanceof ht4) {
                    if (z) {
                        if (!((ht4) list.get(i3)).isValid()) {
                            ((ht4) list.get(i3)).f();
                        }
                        if (((ht4) list.get(i3)).isValid()) {
                            ICardInfo c = ((ht4) list.get(i3)).c();
                            int viewCount = c.getViewCount();
                            ArrayList arrayList = new ArrayList();
                            for (int i4 = 0; i4 < viewCount; i4++) {
                                ICardInfo viewItem = c.getViewItem(i4, i);
                                if (viewItem != null) {
                                    viewItem.setBdUniqueId(li7.b.get(viewItem.getCardType()));
                                    arrayList.add(viewItem);
                                }
                            }
                            if (arrayList.size() != 0) {
                                list.remove(i3);
                                list.addAll(i3, arrayList);
                                i2 = arrayList.size();
                                z2 = false;
                                if (!z2) {
                                    list.remove(i3);
                                    i2 = 0;
                                }
                            }
                        }
                    }
                    i2 = 1;
                    z2 = true;
                    if (!z2) {
                    }
                } else {
                    i2 = 1;
                }
                i3 += i2;
            }
        }
    }

    public static ArrayList<BdUniqueId> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            int size = li7.b.size();
            ArrayList<BdUniqueId> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                arrayList.add(li7.b.valueAt(i));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
