package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class xw9 {
    public static /* synthetic */ Interceptable $ic;
    public static final xw9 a;
    public static boolean b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948314927, "Lcom/baidu/tieba/xw9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948314927, "Lcom/baidu/tieba/xw9;");
                return;
            }
        }
        a = new xw9();
    }

    public xw9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c;
        }
        return invokeV.intValue;
    }

    @JvmStatic
    public static final void e(PbModel pbModel, String str, int i, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65539, null, pbModel, str, i, eVar) == null) {
            Intrinsics.checkNotNullParameter(pbModel, "pbModel");
            if (eVar == null) {
                return;
            }
            ds9 t1 = pbModel.t1();
            TbRichText f = f(pbModel, str, i);
            if (f == null || (tbRichTextData = f.Q().get(c)) == null) {
                return;
            }
            eVar.f = String.valueOf(f.getPostId());
            eVar.a = new ArrayList<>();
            eVar.b = new ConcurrentHashMap<>();
            boolean z = false;
            if (!tbRichTextData.W().W()) {
                eVar.h = false;
                String a2 = es9.a(tbRichTextData);
                eVar.a.add(a2);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                    imageUrlData.urlType = 38;
                } else {
                    Intrinsics.checkNotNull(t1);
                    if (t1.m0()) {
                        i4 = 17;
                    } else {
                        i4 = 18;
                    }
                    imageUrlData.urlType = i4;
                }
                imageUrlData.urlThumbType = imageUrlData.urlType;
                imageUrlData.imageThumbUrl = imageUrlData.imageUrl;
                imageUrlData.originalUrl = hx9.p(tbRichTextData);
                imageUrlData.originalUrl = hx9.p(tbRichTextData);
                imageUrlData.originalSize = hx9.q(tbRichTextData);
                imageUrlData.mIsShowOrigonButton = hx9.m(tbRichTextData);
                imageUrlData.isLongPic = hx9.l(tbRichTextData);
                imageUrlData.postId = f.getPostId();
                imageUrlData.mIsReserver = pbModel.F1();
                imageUrlData.mIsSeeHost = pbModel.W0();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
                Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "result.assistUrls");
                concurrentHashMap.put(a2, imageUrlData);
                if (t1 != null) {
                    if (t1.k() != null) {
                        eVar.c = t1.k().getName();
                        eVar.d = t1.k().getId();
                    }
                    if (t1.O() != null) {
                        eVar.e = t1.O().getId();
                    }
                    if (t1.r() == 1) {
                        z = true;
                    }
                    eVar.g = z;
                }
                imageUrlData.threadId = JavaTypesHelper.toLong(eVar.e, -1L);
                return;
            }
            eVar.h = true;
            Intrinsics.checkNotNull(t1);
            int size = t1.F().size();
            b = false;
            eVar.j = -1;
            if (t1.i() != null) {
                TbRichText e0 = t1.i().e0();
                xw9 xw9Var = a;
                ArrayList<String> arrayList = eVar.a;
                Intrinsics.checkNotNullExpressionValue(arrayList, "result.urlList");
                i2 = xw9Var.c(pbModel, e0, f, i, i, arrayList, eVar.b);
            } else {
                i2 = i;
            }
            int i5 = i2;
            int i6 = 0;
            while (i6 < size) {
                ura uraVar = t1.F().get(i6);
                if (uraVar.T() != null && t1.i() != null && t1.i().T() != null && Intrinsics.areEqual(uraVar.T(), t1.i().T())) {
                    i3 = i6;
                } else {
                    TbRichText e02 = uraVar.e0();
                    xw9 xw9Var2 = a;
                    ArrayList<String> arrayList2 = eVar.a;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "result.urlList");
                    i3 = i6;
                    i5 = xw9Var2.c(pbModel, e02, f, i5, i, arrayList2, eVar.b);
                }
                i6 = i3 + 1;
            }
            if (eVar.a.size() > 0) {
                ArrayList<String> arrayList3 = eVar.a;
                eVar.i = arrayList3.get(arrayList3.size() - 1);
            }
            if (t1.k() != null) {
                eVar.c = t1.k().getName();
                eVar.d = t1.k().getId();
            }
            if (t1.O() != null) {
                eVar.e = t1.O().getId();
            }
            if (t1.r() == 1) {
                z = true;
            }
            eVar.g = z;
            eVar.j = i5;
        }
    }

    @JvmStatic
    public static final TbRichText f(PbModel pbModel, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, pbModel, str, i)) == null) {
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.t1() == null || str == null || i < 0) {
                return null;
            }
            ds9 t1 = pbModel.t1();
            if (t1.i() != null) {
                ArrayList<ura> arrayList = new ArrayList<>();
                arrayList.add(t1.i());
                tbRichText = a.b(arrayList, str, i);
            }
            if (tbRichText == null) {
                ArrayList<ura> F = t1.F();
                a.a(t1, F);
                return a.b(F, str, i);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    public final void a(ds9 ds9Var, ArrayList<ura> arrayList) {
        List<ura> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, ds9Var, arrayList) == null) && ds9Var != null && ds9Var.T() != null && ds9Var.T().a != null && (list = ds9Var.T().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<ura> it = arrayList.iterator();
                while (it.hasNext()) {
                    ura next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            ura uraVar = (ura) it2.next();
                            if (uraVar != null && !TextUtils.isEmpty(next.T()) && !TextUtils.isEmpty(uraVar.T()) && Intrinsics.areEqual(next.T(), uraVar.T())) {
                                arrayList2.add(uraVar);
                            }
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    arrayList3.removeAll(arrayList2);
                }
                if (arrayList3.size() > 0) {
                    arrayList.addAll(arrayList3);
                }
            }
        }
    }

    public final TbRichText b(ArrayList<ura> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ura uraVar = arrayList.get(i2);
                    Intrinsics.checkNotNullExpressionValue(uraVar, "datas[k]");
                    TbRichText e0 = uraVar.e0();
                    if (e0 != null && (Q = e0.Q()) != null) {
                        int size2 = Q.size();
                        int i3 = -1;
                        for (int i4 = 0; i4 < size2; i4++) {
                            if (Q.get(i4) != null) {
                                TbRichTextData tbRichTextData = Q.get(i4);
                                Intrinsics.checkNotNull(tbRichTextData);
                                if (tbRichTextData.getType() == 8) {
                                    i3++;
                                    TbRichTextData tbRichTextData2 = Q.get(i4);
                                    Intrinsics.checkNotNull(tbRichTextData2);
                                    if (!Intrinsics.areEqual(tbRichTextData2.W().Q(), str)) {
                                        TbRichTextData tbRichTextData3 = Q.get(i4);
                                        Intrinsics.checkNotNull(tbRichTextData3);
                                        if (!Intrinsics.areEqual(tbRichTextData3.W().R(), str)) {
                                            if (i3 > i) {
                                                break;
                                            }
                                        }
                                    }
                                    int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                                    TbRichTextData tbRichTextData4 = Q.get(i4);
                                    Intrinsics.checkNotNull(tbRichTextData4);
                                    int width = tbRichTextData4.W().getWidth() * equipmentDensity;
                                    TbRichTextData tbRichTextData5 = Q.get(i4);
                                    Intrinsics.checkNotNull(tbRichTextData5);
                                    int height = tbRichTextData5.W().getHeight() * equipmentDensity;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    c = i4;
                                    return e0;
                                }
                                continue;
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    public final int c(PbModel pbModel, TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pbModel, tbRichText, tbRichText2, Integer.valueOf(i), Integer.valueOf(i2), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                b = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.Q().size();
                int i4 = i;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.Q().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.W().getWidth() * equipmentDensity;
                        int height = tbRichTextData.W().getHeight() * equipmentDensity;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && tbRichTextData.W().W()) {
                            if (tbRichTextData.getType() != 20) {
                                String bigImageUrl = es9.a(tbRichTextData);
                                if (!TextUtils.isEmpty(bigImageUrl)) {
                                    arrayList.add(bigImageUrl);
                                    TbRichTextImageInfo W = tbRichTextData.W();
                                    if (W != null) {
                                        String Q = W.Q();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            Q = W.R();
                                        } else {
                                            ds9 ds9Var = null;
                                            if (pbModel != null && pbModel.t1() != null) {
                                                ds9Var = pbModel.t1();
                                            }
                                            if (ds9Var != null && ds9Var.m0()) {
                                                i3 = 17;
                                            } else {
                                                i3 = 18;
                                            }
                                            imageUrlData.urlType = i3;
                                        }
                                        imageUrlData.imageUrl = Q;
                                        imageUrlData.imageThumbUrl = Q;
                                        imageUrlData.urlThumbType = imageUrlData.urlType;
                                        imageUrlData.originalUrl = hx9.p(tbRichTextData);
                                        imageUrlData.originalSize = hx9.q(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = hx9.m(tbRichTextData);
                                        imageUrlData.isLongPic = hx9.l(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        Intrinsics.checkNotNull(pbModel);
                                        imageUrlData.threadId = JavaTypesHelper.toLong(pbModel.N1(), -1L);
                                        imageUrlData.mIsReserver = pbModel.F1();
                                        imageUrlData.mIsSeeHost = pbModel.W0();
                                        if (concurrentHashMap != null) {
                                            Intrinsics.checkNotNullExpressionValue(bigImageUrl, "bigImageUrl");
                                            concurrentHashMap.put(bigImageUrl, imageUrlData);
                                        }
                                    }
                                }
                                if (!b) {
                                    i4++;
                                }
                            }
                        } else if (tbRichText == tbRichText2) {
                            if (i5 <= i2) {
                                i4--;
                            }
                        }
                    }
                }
                return i4;
            }
            return i;
        }
        return invokeCommon.intValue;
    }
}
