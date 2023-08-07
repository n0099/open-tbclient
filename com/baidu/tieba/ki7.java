package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabNetModel;
import com.baidu.tieba.frs.commontab.FrsCommonTabRequestData;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes6.dex */
public class ki7 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public li7 b;
    public FrsCommonTabRequestData c;
    public FrsCommonTabNetModel d;
    public boolean e;
    public FrsDynamicRequestData f;
    public FrsDynamicModel g;
    public boolean h;
    public HashSet<String> i;
    public int j;
    public long k;
    public int l;
    public String m;
    public String n;
    public jv7 o;

    public ki7(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new HashSet<>();
        this.j = 1;
        this.k = -1L;
        if (frsCommonTabFragment == null) {
            return;
        }
        this.a = frsCommonTabFragment;
        this.n = "FRS_GENERAL_TAB" + i2;
        if (i2 == 89) {
            this.e = true;
            FrsDynamicRequestData frsDynamicRequestData = new FrsDynamicRequestData();
            this.f = frsDynamicRequestData;
            frsDynamicRequestData.forumId = i;
            frsDynamicRequestData.scrH = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            this.f.scrW = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            this.f.scrDip = BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f);
            this.g = frsDynamicModel;
            frsDynamicModel.p0(this);
            this.g.setUniqueId(frsCommonTabFragment.getUniqueId());
            return;
        }
        this.e = false;
        FrsCommonTabRequestData frsCommonTabRequestData = new FrsCommonTabRequestData();
        this.c = frsCommonTabRequestData;
        frsCommonTabRequestData.fid = i;
        frsCommonTabRequestData.tabId = i2;
        frsCommonTabRequestData.isDefaultNavTab = i(i2) ? 1 : 0;
        FrsCommonTabRequestData frsCommonTabRequestData2 = this.c;
        frsCommonTabRequestData2.tabName = str;
        frsCommonTabRequestData2.isGeneralTab = i3;
        FrsCommonTabNetModel frsCommonTabNetModel = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.c);
        this.d = frsCommonTabNetModel;
        frsCommonTabNetModel.p0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void H(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        li7 li7Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof li7) {
                li7Var = (li7) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof mi7) {
                mi7 mi7Var = (mi7) mvcHttpResponsedMessage.getData();
                li7 li7Var2 = new li7();
                ArrayList<ym> arrayList = mi7Var.a;
                li7Var2.c = arrayList;
                li7Var2.a = mi7Var.c;
                li7Var2.b = mi7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<ym> arrayList2 = li7Var2.c;
                    ym ymVar = (ym) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (ymVar instanceof ThreadData) {
                        this.f.lastThreadId = JavaTypesHelper.toLong(((ThreadData) ymVar).getId(), 0L);
                    }
                }
                li7Var = li7Var2;
            }
        }
        if (li7Var != null && n(li7Var)) {
            return;
        }
        this.l = mvcHttpResponsedMessage.getError();
        this.m = mvcHttpResponsedMessage.getErrorString();
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.l);
        errorData.setError_msg(this.m);
        if (this.l != 0) {
            this.a.f(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void v(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048596, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        li7 li7Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof li7) {
                li7Var = (li7) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof mi7) {
                mi7 mi7Var = (mi7) mvcSocketResponsedMessage.getData();
                li7 li7Var2 = new li7();
                ArrayList<ym> arrayList = mi7Var.a;
                li7Var2.c = arrayList;
                li7Var2.a = mi7Var.c;
                li7Var2.b = mi7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<ym> arrayList2 = li7Var2.c;
                    ym ymVar = (ym) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (ymVar instanceof ThreadData) {
                        this.f.lastThreadId = JavaTypesHelper.toLong(((ThreadData) ymVar).getId(), 0L);
                    }
                }
                li7Var = li7Var2;
            }
        }
        if (li7Var != null && n(li7Var)) {
            return;
        }
        this.l = mvcSocketResponsedMessage.getError();
        this.m = mvcSocketResponsedMessage.getErrorString();
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.l);
        errorData.setError_msg(this.m);
        if (this.l != 0) {
            this.a.f(errorData);
        }
    }

    public void a(ThreadData threadData) {
        li7 li7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && (li7Var = this.b) != null && li7Var.c != null) {
            ArrayList<ym> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<ym> s = s(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(s);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof of7)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, s);
            }
            this.a.d2(this.b);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.h0()) {
                    return;
                }
                this.j = 1;
                FrsCommonTabRequestData frsCommonTabRequestData = this.c;
                frsCommonTabRequestData.pn = 1;
                frsCommonTabRequestData.sortType = i;
                long j = this.k;
                if (j >= 0) {
                    frsCommonTabRequestData.lastThreadId = j;
                }
                this.c.adExtParams = c();
                this.d.loadData();
            } else if (this.g.h0()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.f.lastThreadId = 0L;
                this.g.loadData();
            }
            ev7.a();
        }
    }

    public final void b(List<ym> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || cy8.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ym ymVar : list) {
            if ((ymVar instanceof ThreadData) && (b = zy9.b(((ThreadData) ymVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        zy9.f().h(this.n, arrayList);
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.h0()) {
                    return;
                }
                int i2 = this.j + 1;
                this.j = i2;
                FrsCommonTabRequestData frsCommonTabRequestData = this.c;
                frsCommonTabRequestData.pn = i2;
                frsCommonTabRequestData.sortType = i;
                frsCommonTabRequestData.lastThreadId = -1L;
                frsCommonTabRequestData.adExtParams = c();
                this.d.loadData();
            } else if (this.g.h0()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            ev7.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<ym> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = ow9.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = zy9.f().d(this.n);
            }
            li7 li7Var = this.b;
            if (li7Var == null) {
                arrayList = null;
            } else {
                arrayList = li7Var.c;
            }
            String e = ow9.e(arrayList, this.h);
            AdExtParam.a b2 = AdExtParam.a.b();
            b2.g(b);
            b2.e(e);
            b2.c(d);
            b2.f(this.a.f);
            return b2.a();
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            li7 li7Var = this.b;
            if (li7Var == null) {
                return true;
            }
            return li7Var.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public li7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (li7) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            li7 li7Var = this.b;
            if (li7Var != null && !ListUtils.isEmpty(li7Var.c)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            FrsCommonTabNetModel frsCommonTabNetModel = this.d;
            if (frsCommonTabNetModel != null) {
                return frsCommonTabNetModel.h0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final void g(List<App> list, List<ym> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) {
            b(list2);
            ow9.i(ow9.h(list, "FRS_GENERAL_TAB"), list2, 0);
            ow9.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public final boolean i(int i) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.d) == null || frsViewData.mHeadLineDefaultNavTabId != i) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void m(String str) {
        li7 li7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (li7Var = this.b) != null && !cy8.e(li7Var.c)) {
            ow9.d(str, this.b.c);
            this.a.d2(this.b);
        }
    }

    public void p(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jv7Var) == null) {
            this.o = jv7Var;
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.k = j;
        }
    }

    public void r(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (frsCommonTabRequestData = this.c) != null) {
            frsCommonTabRequestData.tabType = i;
        }
    }

    public final boolean n(li7 li7Var) {
        InterceptResult invokeL;
        boolean z;
        jv7 jv7Var;
        jv7 jv7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, li7Var)) == null) {
            if (li7Var == null) {
                return false;
            }
            if (this.a.h == 100) {
                z = true;
            } else {
                z = false;
            }
            ArrayList arrayList = new ArrayList();
            if (this.h) {
                this.i.clear();
                Iterator<ym> it = li7Var.c.iterator();
                while (it.hasNext()) {
                    ym next = it.next();
                    if (next instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) next;
                        String tid = threadData.getTid();
                        if (!this.i.contains(tid)) {
                            this.i.add(tid);
                        }
                        if (z && threadData.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData.getThreadVideoInfo().video_url)) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.buildWithThreadData(threadData);
                            arrayList.add(videoItemData);
                        }
                    }
                }
                if (z && !arrayList.isEmpty()) {
                    FrsVideoTabPlayActivityConfig.putVideoTabListByFid(((VideoItemData) arrayList.get(0)).forum_id, arrayList);
                }
                int i = li7Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (jv7.d()) {
                                    jv7 jv7Var3 = this.o;
                                    if (jv7Var3 != null) {
                                        jv7Var3.b(li7Var.c, this.h, this.a.e0());
                                    }
                                } else {
                                    g(li7Var.k, li7Var.c);
                                }
                            } else if (!ListUtils.isEmpty(li7Var.m)) {
                                int intValue = li7Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(li7Var.k, li7Var.c);
                                } else if (intValue == 2 && (jv7Var2 = this.o) != null) {
                                    jv7Var2.g(li7Var.c, li7Var.m, this.h, this.a.e0());
                                }
                            }
                        } else {
                            jv7 jv7Var4 = this.o;
                            if (jv7Var4 != null) {
                                jv7Var4.b(li7Var.c, this.h, this.a.e0());
                            }
                        }
                    } else {
                        g(li7Var.k, li7Var.c);
                    }
                }
                this.b = li7Var;
                li7Var.c = s(li7Var.c);
            } else {
                li7 li7Var2 = this.b;
                li7Var2.a = li7Var.a;
                li7Var2.b.putAll(li7Var.b);
                ArrayList<ym> arrayList2 = new ArrayList<>();
                Iterator<ym> it2 = li7Var.c.iterator();
                while (it2.hasNext()) {
                    ym next2 = it2.next();
                    if (next2 instanceof ThreadData) {
                        ThreadData threadData2 = (ThreadData) next2;
                        String tid2 = threadData2.getTid();
                        if (!this.i.contains(tid2)) {
                            threadData2.isFromBrandForum = this.a.l;
                            arrayList2.add(threadData2);
                            this.i.add(tid2);
                            if (z && threadData2.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData2.getThreadVideoInfo().video_url)) {
                                VideoItemData videoItemData2 = new VideoItemData();
                                videoItemData2.buildWithThreadData(threadData2);
                                arrayList.add(videoItemData2);
                            }
                        }
                    }
                }
                if (z && !arrayList.isEmpty()) {
                    String str = ((VideoItemData) arrayList.get(0)).forum_id;
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(str).clear();
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(str).addAll(arrayList);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921628));
                }
                int i2 = li7Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (jv7.d()) {
                                jv7 jv7Var5 = this.o;
                                if (jv7Var5 != null) {
                                    jv7Var5.b(li7Var.c, this.h, this.a.e0());
                                }
                            } else {
                                g(li7Var.k, li7Var.c);
                            }
                        } else if (!ListUtils.isEmpty(li7Var.m)) {
                            int intValue2 = li7Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(li7Var.k, li7Var.c);
                            } else if (intValue2 == 2 && (jv7Var = this.o) != null) {
                                jv7Var.g(li7Var.c, li7Var.m, this.h, this.a.e0());
                            }
                        }
                    } else {
                        jv7 jv7Var6 = this.o;
                        if (jv7Var6 != null) {
                            jv7Var6.b(li7Var.c, this.h, this.a.e0());
                        }
                    }
                } else {
                    g(li7Var.k, li7Var.c);
                }
                this.b.c.addAll(s(arrayList2));
            }
            this.a.d2(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<ym> s(ArrayList<ym> arrayList) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
            if (this.a.h == 16) {
                z = true;
            } else {
                z = false;
            }
            if (this.a.h == 100) {
                z2 = true;
            } else {
                z2 = false;
            }
            ArrayList<ym> arrayList2 = new ArrayList<>();
            Iterator<ym> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ym next = it.next();
                if (next instanceof i25) {
                    ((i25) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof j25) {
                    ((j25) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        w35 w35Var = new w35();
                        w35Var.t = threadData;
                        w35Var.position = i;
                        w35Var.a = true;
                        w35Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(w35Var);
                        w35 w35Var2 = new w35();
                        w35Var2.t = threadData;
                        w35Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            w35Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            w35Var2.d = true;
                            w35Var2.u = imageWidthAndHeight[0];
                            w35Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            w35Var2.e = true;
                        } else {
                            w35Var2.b = true;
                        }
                        w35Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(w35Var2);
                        if (threadData.getPollData() != null) {
                            w35 w35Var3 = new w35();
                            w35Var3.o = true;
                            w35Var3.t = threadData;
                            w35Var3.position = i;
                            w35Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            w35 w35Var4 = new w35();
                            w35Var4.l = true;
                            w35Var4.t = threadData;
                            w35Var4.position = i;
                            w35Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            w35 w35Var5 = new w35();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                w35Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                w35Var5.q = true;
                            }
                            w35Var5.t = threadData;
                            w35Var5.position = i;
                            w35Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            w35 w35Var6 = new w35();
                            w35Var6.h = true;
                            w35Var6.t = threadData;
                            w35Var6.position = i;
                            w35Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            w35 w35Var7 = new w35();
                            w35Var7.n = true;
                            w35Var7.t = threadData;
                            w35Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var7);
                        }
                        w35 w35Var8 = new w35();
                        w35Var8.g = true;
                        w35Var8.t = threadData;
                        w35Var8.position = i;
                        w35Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(w35Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        w35 w35Var9 = new w35();
                        w35Var9.t = threadData;
                        w35Var9.position = i;
                        w35Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        w35Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(w35Var9);
                        w35 w35Var10 = new w35();
                        w35Var10.t = threadData;
                        w35Var10.position = i;
                        if (threadData instanceof q25) {
                            w35Var10.j = true;
                        } else {
                            w35Var10.i = true;
                        }
                        w35Var10.t.isJumpToFrsVideoTabPlay = z2;
                        w35Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(w35Var10);
                        if (threadData.getPollData() != null) {
                            w35 w35Var11 = new w35();
                            w35Var11.o = true;
                            w35Var11.t = threadData;
                            w35Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            w35Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            w35 w35Var12 = new w35();
                            w35Var12.l = true;
                            w35Var12.t = threadData;
                            w35Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            w35Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            w35 w35Var13 = new w35();
                            w35Var13.h = true;
                            w35Var13.t = threadData;
                            w35Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            w35Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            w35 w35Var14 = new w35();
                            w35Var14.n = true;
                            w35Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            w35Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var14);
                        }
                        w35 w35Var15 = new w35();
                        w35Var15.g = true;
                        w35Var15.t = threadData;
                        w35Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        w35Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(w35Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        w35 w35Var16 = new w35();
                        w35Var16.t = threadData;
                        w35Var16.position = i;
                        w35Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        w35Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(w35Var16);
                        w35 w35Var17 = new w35();
                        w35Var17.t = threadData;
                        w35Var17.position = i;
                        w35Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        w35Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(w35Var17);
                        if (threadData.getPollData() != null) {
                            w35 w35Var18 = new w35();
                            w35Var18.o = true;
                            w35Var18.t = threadData;
                            w35Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            w35Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            w35 w35Var19 = new w35();
                            w35Var19.l = true;
                            w35Var19.t = threadData;
                            w35Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            w35Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            w35 w35Var20 = new w35();
                            w35Var20.h = true;
                            w35Var20.t = threadData;
                            w35Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            w35Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            w35 w35Var21 = new w35();
                            w35Var21.n = true;
                            w35Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            w35Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(w35Var21);
                        }
                        w35 w35Var22 = new w35();
                        w35Var22.g = true;
                        w35Var22.t = threadData;
                        w35Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        w35Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(w35Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        w35 w35Var23 = new w35();
                        w35Var23.t = threadData;
                        w35Var23.position = i;
                        arrayList2.add(w35Var23);
                    }
                    i++;
                    threadData.setSupportType(BaseCardInfo.SupportType.TOP);
                } else {
                    arrayList2.add(next);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}
