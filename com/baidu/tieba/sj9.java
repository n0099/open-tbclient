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
/* loaded from: classes8.dex */
public final class sj9 {
    public static /* synthetic */ Interceptable $ic;
    public static final sj9 a;
    public static boolean b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948153479, "Lcom/baidu/tieba/sj9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948153479, "Lcom/baidu/tieba/sj9;");
                return;
            }
        }
        a = new sj9();
    }

    public sj9() {
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
            ye9 s1 = pbModel.s1();
            TbRichText f = f(pbModel, str, i);
            if (f == null || (tbRichTextData = f.P().get(c)) == null) {
                return;
            }
            eVar.f = String.valueOf(f.getPostId());
            eVar.a = new ArrayList<>();
            eVar.b = new ConcurrentHashMap<>();
            boolean z = false;
            if (!tbRichTextData.V().V()) {
                eVar.h = false;
                String a2 = ze9.a(tbRichTextData);
                eVar.a.add(a2);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                    imageUrlData.urlType = 38;
                } else {
                    Intrinsics.checkNotNull(s1);
                    if (s1.m0()) {
                        i4 = 17;
                    } else {
                        i4 = 18;
                    }
                    imageUrlData.urlType = i4;
                }
                imageUrlData.urlThumbType = imageUrlData.urlType;
                imageUrlData.imageThumbUrl = imageUrlData.imageUrl;
                imageUrlData.originalUrl = ck9.o(tbRichTextData);
                imageUrlData.originalUrl = ck9.o(tbRichTextData);
                imageUrlData.originalSize = ck9.p(tbRichTextData);
                imageUrlData.mIsShowOrigonButton = ck9.l(tbRichTextData);
                imageUrlData.isLongPic = ck9.k(tbRichTextData);
                imageUrlData.postId = f.getPostId();
                imageUrlData.mIsReserver = pbModel.E1();
                imageUrlData.mIsSeeHost = pbModel.V0();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
                Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "result.assistUrls");
                concurrentHashMap.put(a2, imageUrlData);
                if (s1 != null) {
                    if (s1.k() != null) {
                        eVar.c = s1.k().getName();
                        eVar.d = s1.k().getId();
                    }
                    if (s1.O() != null) {
                        eVar.e = s1.O().getId();
                    }
                    if (s1.r() == 1) {
                        z = true;
                    }
                    eVar.g = z;
                }
                imageUrlData.threadId = JavaTypesHelper.toLong(eVar.e, -1L);
                return;
            }
            eVar.h = true;
            Intrinsics.checkNotNull(s1);
            int size = s1.F().size();
            b = false;
            eVar.j = -1;
            if (s1.i() != null) {
                TbRichText f0 = s1.i().f0();
                sj9 sj9Var = a;
                ArrayList<String> arrayList = eVar.a;
                Intrinsics.checkNotNullExpressionValue(arrayList, "result.urlList");
                i2 = sj9Var.c(pbModel, f0, f, i, i, arrayList, eVar.b);
            } else {
                i2 = i;
            }
            int i5 = i2;
            int i6 = 0;
            while (i6 < size) {
                pea peaVar = s1.F().get(i6);
                if (peaVar.U() != null && s1.i() != null && s1.i().U() != null && Intrinsics.areEqual(peaVar.U(), s1.i().U())) {
                    i3 = i6;
                } else {
                    TbRichText f02 = peaVar.f0();
                    sj9 sj9Var2 = a;
                    ArrayList<String> arrayList2 = eVar.a;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "result.urlList");
                    i3 = i6;
                    i5 = sj9Var2.c(pbModel, f02, f, i5, i, arrayList2, eVar.b);
                }
                i6 = i3 + 1;
            }
            if (eVar.a.size() > 0) {
                ArrayList<String> arrayList3 = eVar.a;
                eVar.i = arrayList3.get(arrayList3.size() - 1);
            }
            if (s1.k() != null) {
                eVar.c = s1.k().getName();
                eVar.d = s1.k().getId();
            }
            if (s1.O() != null) {
                eVar.e = s1.O().getId();
            }
            if (s1.r() == 1) {
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
            if (pbModel == null || pbModel.s1() == null || str == null || i < 0) {
                return null;
            }
            ye9 s1 = pbModel.s1();
            if (s1.i() != null) {
                ArrayList<pea> arrayList = new ArrayList<>();
                arrayList.add(s1.i());
                tbRichText = a.b(arrayList, str, i);
            }
            if (tbRichText == null) {
                ArrayList<pea> F = s1.F();
                a.a(s1, F);
                return a.b(F, str, i);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    public final void a(ye9 ye9Var, ArrayList<pea> arrayList) {
        List<pea> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, ye9Var, arrayList) == null) && ye9Var != null && ye9Var.T() != null && ye9Var.T().a != null && (list = ye9Var.T().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<pea> it = arrayList.iterator();
                while (it.hasNext()) {
                    pea next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            pea peaVar = (pea) it2.next();
                            if (peaVar != null && !TextUtils.isEmpty(next.U()) && !TextUtils.isEmpty(peaVar.U()) && Intrinsics.areEqual(next.U(), peaVar.U())) {
                                arrayList2.add(peaVar);
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

    public final TbRichText b(ArrayList<pea> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    pea peaVar = arrayList.get(i2);
                    Intrinsics.checkNotNullExpressionValue(peaVar, "datas[k]");
                    TbRichText f0 = peaVar.f0();
                    if (f0 != null && (P = f0.P()) != null) {
                        int size2 = P.size();
                        int i3 = -1;
                        for (int i4 = 0; i4 < size2; i4++) {
                            if (P.get(i4) != null) {
                                TbRichTextData tbRichTextData = P.get(i4);
                                Intrinsics.checkNotNull(tbRichTextData);
                                if (tbRichTextData.getType() == 8) {
                                    i3++;
                                    TbRichTextData tbRichTextData2 = P.get(i4);
                                    Intrinsics.checkNotNull(tbRichTextData2);
                                    if (!Intrinsics.areEqual(tbRichTextData2.V().P(), str)) {
                                        TbRichTextData tbRichTextData3 = P.get(i4);
                                        Intrinsics.checkNotNull(tbRichTextData3);
                                        if (!Intrinsics.areEqual(tbRichTextData3.V().Q(), str)) {
                                            if (i3 > i) {
                                                break;
                                            }
                                        }
                                    }
                                    int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                                    TbRichTextData tbRichTextData4 = P.get(i4);
                                    Intrinsics.checkNotNull(tbRichTextData4);
                                    int width = tbRichTextData4.V().getWidth() * equipmentDensity;
                                    TbRichTextData tbRichTextData5 = P.get(i4);
                                    Intrinsics.checkNotNull(tbRichTextData5);
                                    int height = tbRichTextData5.V().getHeight() * equipmentDensity;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    c = i4;
                                    return f0;
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
                int size = tbRichText.P().size();
                int i4 = i;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.P().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.V().getWidth() * equipmentDensity;
                        int height = tbRichTextData.V().getHeight() * equipmentDensity;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && tbRichTextData.V().V()) {
                            if (tbRichTextData.getType() != 20) {
                                String bigImageUrl = ze9.a(tbRichTextData);
                                if (!TextUtils.isEmpty(bigImageUrl)) {
                                    arrayList.add(bigImageUrl);
                                    TbRichTextImageInfo V = tbRichTextData.V();
                                    if (V != null) {
                                        String P = V.P();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            P = V.Q();
                                        } else {
                                            ye9 ye9Var = null;
                                            if (pbModel != null && pbModel.s1() != null) {
                                                ye9Var = pbModel.s1();
                                            }
                                            if (ye9Var != null && ye9Var.m0()) {
                                                i3 = 17;
                                            } else {
                                                i3 = 18;
                                            }
                                            imageUrlData.urlType = i3;
                                        }
                                        imageUrlData.imageUrl = P;
                                        imageUrlData.imageThumbUrl = P;
                                        imageUrlData.urlThumbType = imageUrlData.urlType;
                                        imageUrlData.originalUrl = ck9.o(tbRichTextData);
                                        imageUrlData.originalSize = ck9.p(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = ck9.l(tbRichTextData);
                                        imageUrlData.isLongPic = ck9.k(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        Intrinsics.checkNotNull(pbModel);
                                        imageUrlData.threadId = JavaTypesHelper.toLong(pbModel.M1(), -1L);
                                        imageUrlData.mIsReserver = pbModel.E1();
                                        imageUrlData.mIsSeeHost = pbModel.V0();
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
