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
/* loaded from: classes8.dex */
public class xl7 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public yl7 b;
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
    public ry7 o;

    public xl7(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicModel.o0(this);
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
        frsCommonTabNetModel.o0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void C(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        yl7 yl7Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof yl7) {
                yl7Var = (yl7) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof zl7) {
                zl7 zl7Var = (zl7) mvcHttpResponsedMessage.getData();
                yl7 yl7Var2 = new yl7();
                ArrayList<bn> arrayList = zl7Var.a;
                yl7Var2.c = arrayList;
                yl7Var2.a = zl7Var.c;
                yl7Var2.b = zl7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<bn> arrayList2 = yl7Var2.c;
                    bn bnVar = (bn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (bnVar instanceof ThreadData) {
                        this.f.lastThreadId = JavaTypesHelper.toLong(((ThreadData) bnVar).getId(), 0L);
                    }
                }
                yl7Var = yl7Var2;
            }
        }
        if (yl7Var != null && n(yl7Var)) {
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
        yl7 yl7Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof yl7) {
                yl7Var = (yl7) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof zl7) {
                zl7 zl7Var = (zl7) mvcSocketResponsedMessage.getData();
                yl7 yl7Var2 = new yl7();
                ArrayList<bn> arrayList = zl7Var.a;
                yl7Var2.c = arrayList;
                yl7Var2.a = zl7Var.c;
                yl7Var2.b = zl7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<bn> arrayList2 = yl7Var2.c;
                    bn bnVar = (bn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (bnVar instanceof ThreadData) {
                        this.f.lastThreadId = JavaTypesHelper.toLong(((ThreadData) bnVar).getId(), 0L);
                    }
                }
                yl7Var = yl7Var2;
            }
        }
        if (yl7Var != null && n(yl7Var)) {
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
        yl7 yl7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && (yl7Var = this.b) != null && yl7Var.c != null) {
            ArrayList<bn> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<bn> s = s(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(s);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof xi7)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, s);
            }
            this.a.x2(this.b);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.g0()) {
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
            } else if (this.g.g0()) {
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
            my7.a();
        }
    }

    public final void b(List<bn> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || t49.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (bn bnVar : list) {
            if ((bnVar instanceof ThreadData) && (b = u6a.b(((ThreadData) bnVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        u6a.f().h(this.n, arrayList);
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.g0()) {
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
            } else if (this.g.g0()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            my7.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<bn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = j4a.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = u6a.f().d(this.n);
            }
            yl7 yl7Var = this.b;
            if (yl7Var == null) {
                arrayList = null;
            } else {
                arrayList = yl7Var.c;
            }
            String e = j4a.e(arrayList, this.h);
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
            yl7 yl7Var = this.b;
            if (yl7Var == null) {
                return true;
            }
            return yl7Var.a;
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

    public yl7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (yl7) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            yl7 yl7Var = this.b;
            if (yl7Var != null && !ListUtils.isEmpty(yl7Var.c)) {
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
                return frsCommonTabNetModel.g0();
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

    public final void g(List<App> list, List<bn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) {
            b(list2);
            j4a.i(j4a.h(list, "FRS_GENERAL_TAB"), list2, 0);
            j4a.a(list2, this.j, "FRS_GENERAL_TAB");
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
        yl7 yl7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (yl7Var = this.b) != null && !t49.e(yl7Var.c)) {
            j4a.d(str, this.b.c);
            this.a.x2(this.b);
        }
    }

    public void p(ry7 ry7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ry7Var) == null) {
            this.o = ry7Var;
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

    public final boolean n(yl7 yl7Var) {
        InterceptResult invokeL;
        boolean z;
        ry7 ry7Var;
        ry7 ry7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, yl7Var)) == null) {
            if (yl7Var == null) {
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
                Iterator<bn> it = yl7Var.c.iterator();
                while (it.hasNext()) {
                    bn next = it.next();
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
                int i = yl7Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (ry7.d()) {
                                    ry7 ry7Var3 = this.o;
                                    if (ry7Var3 != null) {
                                        ry7Var3.b(yl7Var.c, this.h, this.a.s0());
                                    }
                                } else {
                                    g(yl7Var.k, yl7Var.c);
                                }
                            } else if (!ListUtils.isEmpty(yl7Var.m)) {
                                int intValue = yl7Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(yl7Var.k, yl7Var.c);
                                } else if (intValue == 2 && (ry7Var2 = this.o) != null) {
                                    ry7Var2.g(yl7Var.c, yl7Var.m, this.h, this.a.s0());
                                }
                            }
                        } else {
                            ry7 ry7Var4 = this.o;
                            if (ry7Var4 != null) {
                                ry7Var4.b(yl7Var.c, this.h, this.a.s0());
                            }
                        }
                    } else {
                        g(yl7Var.k, yl7Var.c);
                    }
                }
                this.b = yl7Var;
                yl7Var.c = s(yl7Var.c);
            } else {
                yl7 yl7Var2 = this.b;
                yl7Var2.a = yl7Var.a;
                yl7Var2.b.putAll(yl7Var.b);
                ArrayList<bn> arrayList2 = new ArrayList<>();
                Iterator<bn> it2 = yl7Var.c.iterator();
                while (it2.hasNext()) {
                    bn next2 = it2.next();
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
                int i2 = yl7Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (ry7.d()) {
                                ry7 ry7Var5 = this.o;
                                if (ry7Var5 != null) {
                                    ry7Var5.b(yl7Var.c, this.h, this.a.s0());
                                }
                            } else {
                                g(yl7Var.k, yl7Var.c);
                            }
                        } else if (!ListUtils.isEmpty(yl7Var.m)) {
                            int intValue2 = yl7Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(yl7Var.k, yl7Var.c);
                            } else if (intValue2 == 2 && (ry7Var = this.o) != null) {
                                ry7Var.g(yl7Var.c, yl7Var.m, this.h, this.a.s0());
                            }
                        }
                    } else {
                        ry7 ry7Var6 = this.o;
                        if (ry7Var6 != null) {
                            ry7Var6.b(yl7Var.c, this.h, this.a.s0());
                        }
                    }
                } else {
                    g(yl7Var.k, yl7Var.c);
                }
                this.b.c.addAll(s(arrayList2));
            }
            this.a.x2(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<bn> s(ArrayList<bn> arrayList) {
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
            ArrayList<bn> arrayList2 = new ArrayList<>();
            Iterator<bn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                bn next = it.next();
                if (next instanceof t25) {
                    ((t25) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof u25) {
                    ((u25) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        h45 h45Var = new h45();
                        h45Var.t = threadData;
                        h45Var.position = i;
                        h45Var.a = true;
                        h45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(h45Var);
                        h45 h45Var2 = new h45();
                        h45Var2.t = threadData;
                        h45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            h45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            h45Var2.d = true;
                            h45Var2.u = imageWidthAndHeight[0];
                            h45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            h45Var2.e = true;
                        } else {
                            h45Var2.b = true;
                        }
                        h45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(h45Var2);
                        if (threadData.getPollData() != null) {
                            h45 h45Var3 = new h45();
                            h45Var3.o = true;
                            h45Var3.t = threadData;
                            h45Var3.position = i;
                            h45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            h45 h45Var4 = new h45();
                            h45Var4.l = true;
                            h45Var4.t = threadData;
                            h45Var4.position = i;
                            h45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            h45 h45Var5 = new h45();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                h45Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                h45Var5.q = true;
                            }
                            h45Var5.t = threadData;
                            h45Var5.position = i;
                            h45Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            h45 h45Var6 = new h45();
                            h45Var6.h = true;
                            h45Var6.t = threadData;
                            h45Var6.position = i;
                            h45Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            h45 h45Var7 = new h45();
                            h45Var7.n = true;
                            h45Var7.t = threadData;
                            h45Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var7);
                        }
                        h45 h45Var8 = new h45();
                        h45Var8.g = true;
                        h45Var8.t = threadData;
                        h45Var8.position = i;
                        h45Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(h45Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        h45 h45Var9 = new h45();
                        h45Var9.t = threadData;
                        h45Var9.position = i;
                        h45Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        h45Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(h45Var9);
                        h45 h45Var10 = new h45();
                        h45Var10.t = threadData;
                        h45Var10.position = i;
                        if (threadData instanceof b35) {
                            h45Var10.j = true;
                        } else {
                            h45Var10.i = true;
                        }
                        h45Var10.t.isJumpToFrsVideoTabPlay = z2;
                        h45Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(h45Var10);
                        if (threadData.getPollData() != null) {
                            h45 h45Var11 = new h45();
                            h45Var11.o = true;
                            h45Var11.t = threadData;
                            h45Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            h45Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            h45 h45Var12 = new h45();
                            h45Var12.l = true;
                            h45Var12.t = threadData;
                            h45Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            h45Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            h45 h45Var13 = new h45();
                            h45Var13.h = true;
                            h45Var13.t = threadData;
                            h45Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            h45Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            h45 h45Var14 = new h45();
                            h45Var14.n = true;
                            h45Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            h45Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var14);
                        }
                        h45 h45Var15 = new h45();
                        h45Var15.g = true;
                        h45Var15.t = threadData;
                        h45Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        h45Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(h45Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        h45 h45Var16 = new h45();
                        h45Var16.t = threadData;
                        h45Var16.position = i;
                        h45Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        h45Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(h45Var16);
                        h45 h45Var17 = new h45();
                        h45Var17.t = threadData;
                        h45Var17.position = i;
                        h45Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        h45Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(h45Var17);
                        if (threadData.getPollData() != null) {
                            h45 h45Var18 = new h45();
                            h45Var18.o = true;
                            h45Var18.t = threadData;
                            h45Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            h45Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            h45 h45Var19 = new h45();
                            h45Var19.l = true;
                            h45Var19.t = threadData;
                            h45Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            h45Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            h45 h45Var20 = new h45();
                            h45Var20.h = true;
                            h45Var20.t = threadData;
                            h45Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            h45Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            h45 h45Var21 = new h45();
                            h45Var21.n = true;
                            h45Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            h45Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var21);
                        }
                        h45 h45Var22 = new h45();
                        h45Var22.g = true;
                        h45Var22.t = threadData;
                        h45Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        h45Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(h45Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        h45 h45Var23 = new h45();
                        h45Var23.t = threadData;
                        h45Var23.position = i;
                        arrayList2.add(h45Var23);
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
