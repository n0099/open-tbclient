package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
public class tq6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public uq6 b;
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
    public a27 o;

    public tq6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = zi.j(TbadkCoreApplication.getInst());
            this.f.scrW = zi.l(TbadkCoreApplication.getInst());
            this.f.scrDip = zi.i(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f);
            this.g = frsDynamicModel;
            frsDynamicModel.i0(this);
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
        frsCommonTabNetModel.i0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(ThreadData threadData) {
        uq6 uq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData != null && (uq6Var = this.b) != null && uq6Var.c != null) {
            ArrayList<yn> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<yn> s = s(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(s);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof xn6)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, s);
            }
            this.a.Y1(this.b);
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.a0()) {
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
            } else if (this.g.a0()) {
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
            v17.a();
        }
    }

    public final void b(List<yn> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || uq7.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (yn ynVar : list) {
            if ((ynVar instanceof ThreadData) && (b = dp8.b(((ThreadData) ynVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        dp8.f().h(this.n, arrayList);
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.a0()) {
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
            } else if (this.g.a0()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            v17.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<yn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = vm8.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = dp8.f().d(this.n);
            }
            uq6 uq6Var = this.b;
            if (uq6Var == null) {
                arrayList = null;
            } else {
                arrayList = uq6Var.c;
            }
            String e = vm8.e(arrayList, this.h);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            uq6 uq6Var = this.b;
            if (uq6Var == null) {
                return true;
            }
            return uq6Var.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public uq6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (uq6) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            uq6 uq6Var = this.b;
            if (uq6Var != null && !ListUtils.isEmpty(uq6Var.c)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final void g(List<App> list, List<yn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            vm8.i(vm8.h(list, "FRS_GENERAL_TAB"), list2, 0);
            vm8.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public final boolean i(int i) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.d) == null || frsViewData.mHeadLineDefaultNavTabId != i) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void l(String str) {
        uq6 uq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && (uq6Var = this.b) != null && !uq7.e(uq6Var.c)) {
            vm8.d(str, this.b.c);
            this.a.Y1(this.b);
        }
    }

    public void o(a27 a27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, a27Var) == null) {
            this.o = a27Var;
        }
    }

    public void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.k = j;
        }
    }

    public void r(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && (frsCommonTabRequestData = this.c) != null) {
            frsCommonTabRequestData.tabType = i;
        }
    }

    public final boolean m(uq6 uq6Var) {
        InterceptResult invokeL;
        boolean z;
        a27 a27Var;
        a27 a27Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, uq6Var)) == null) {
            if (uq6Var == null) {
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
                Iterator<yn> it = uq6Var.c.iterator();
                while (it.hasNext()) {
                    yn next = it.next();
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
                int i = uq6Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (a27.d()) {
                                    a27 a27Var3 = this.o;
                                    if (a27Var3 != null) {
                                        a27Var3.b(uq6Var.c, this.h, this.a.X());
                                    }
                                } else {
                                    g(uq6Var.k, uq6Var.c);
                                }
                            } else if (!ListUtils.isEmpty(uq6Var.m)) {
                                int intValue = uq6Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(uq6Var.k, uq6Var.c);
                                } else if (intValue == 2 && (a27Var2 = this.o) != null) {
                                    a27Var2.g(uq6Var.c, uq6Var.m, this.h, this.a.X());
                                }
                            }
                        } else {
                            a27 a27Var4 = this.o;
                            if (a27Var4 != null) {
                                a27Var4.b(uq6Var.c, this.h, this.a.X());
                            }
                        }
                    } else {
                        g(uq6Var.k, uq6Var.c);
                    }
                }
                this.b = uq6Var;
                uq6Var.c = s(uq6Var.c);
            } else {
                uq6 uq6Var2 = this.b;
                uq6Var2.a = uq6Var.a;
                uq6Var2.b.putAll(uq6Var.b);
                ArrayList<yn> arrayList2 = new ArrayList<>();
                Iterator<yn> it2 = uq6Var.c.iterator();
                while (it2.hasNext()) {
                    yn next2 = it2.next();
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
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(((VideoItemData) arrayList.get(0)).forum_id).addAll(arrayList);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921628));
                }
                int i2 = uq6Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (a27.d()) {
                                a27 a27Var5 = this.o;
                                if (a27Var5 != null) {
                                    a27Var5.b(uq6Var.c, this.h, this.a.X());
                                }
                            } else {
                                g(uq6Var.k, uq6Var.c);
                            }
                        } else if (!ListUtils.isEmpty(uq6Var.m)) {
                            int intValue2 = uq6Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(uq6Var.k, uq6Var.c);
                            } else if (intValue2 == 2 && (a27Var = this.o) != null) {
                                a27Var.g(uq6Var.c, uq6Var.m, this.h, this.a.X());
                            }
                        }
                    } else {
                        a27 a27Var6 = this.o;
                        if (a27Var6 != null) {
                            a27Var6.b(uq6Var.c, this.h, this.a.X());
                        }
                    }
                } else {
                    g(uq6Var.k, uq6Var.c);
                }
                this.b.c.addAll(s(arrayList2));
            }
            this.a.Y1(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void q(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048592, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        uq6 uq6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof uq6) {
                uq6Var = (uq6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof vq6) {
                vq6 vq6Var = (vq6) mvcSocketResponsedMessage.getData();
                uq6 uq6Var2 = new uq6();
                ArrayList<yn> arrayList = vq6Var.a;
                uq6Var2.c = arrayList;
                uq6Var2.a = vq6Var.c;
                uq6Var2.b = vq6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<yn> arrayList2 = uq6Var2.c;
                    yn ynVar = (yn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (ynVar instanceof ThreadData) {
                        this.f.lastThreadId = yg.g(((ThreadData) ynVar).getId(), 0L);
                    }
                }
                uq6Var = uq6Var2;
            }
        }
        if (uq6Var != null && m(uq6Var)) {
            return;
        }
        this.l = mvcSocketResponsedMessage.getError();
        this.m = mvcSocketResponsedMessage.getErrorString();
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.l);
        errorData.setError_msg(this.m);
        if (this.l != 0) {
            this.a.g(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void y(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048595, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        uq6 uq6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof uq6) {
                uq6Var = (uq6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof vq6) {
                vq6 vq6Var = (vq6) mvcHttpResponsedMessage.getData();
                uq6 uq6Var2 = new uq6();
                ArrayList<yn> arrayList = vq6Var.a;
                uq6Var2.c = arrayList;
                uq6Var2.a = vq6Var.c;
                uq6Var2.b = vq6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<yn> arrayList2 = uq6Var2.c;
                    yn ynVar = (yn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (ynVar instanceof ThreadData) {
                        this.f.lastThreadId = yg.g(((ThreadData) ynVar).getId(), 0L);
                    }
                }
                uq6Var = uq6Var2;
            }
        }
        if (uq6Var != null && m(uq6Var)) {
            return;
        }
        this.l = mvcHttpResponsedMessage.getError();
        this.m = mvcHttpResponsedMessage.getErrorString();
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.l);
        errorData.setError_msg(this.m);
        if (this.l != 0) {
            this.a.g(errorData);
        }
    }

    public final ArrayList<yn> s(ArrayList<yn> arrayList) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, arrayList)) == null) {
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
            ArrayList<yn> arrayList2 = new ArrayList<>();
            Iterator<yn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                yn next = it.next();
                if (next instanceof ut4) {
                    ((ut4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof vt4) {
                    ((vt4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        jv4 jv4Var = new jv4();
                        jv4Var.t = threadData;
                        jv4Var.position = i;
                        jv4Var.a = true;
                        jv4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(jv4Var);
                        jv4 jv4Var2 = new jv4();
                        jv4Var2.t = threadData;
                        jv4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            jv4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            jv4Var2.d = true;
                            jv4Var2.u = imageWidthAndHeight[0];
                            jv4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            jv4Var2.e = true;
                        } else {
                            jv4Var2.b = true;
                        }
                        jv4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jv4Var2);
                        if (threadData.getPollData() != null) {
                            jv4 jv4Var3 = new jv4();
                            jv4Var3.o = true;
                            jv4Var3.t = threadData;
                            jv4Var3.position = i;
                            jv4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            jv4 jv4Var4 = new jv4();
                            jv4Var4.l = true;
                            jv4Var4.t = threadData;
                            jv4Var4.position = i;
                            jv4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            jv4 jv4Var5 = new jv4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                jv4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                jv4Var5.q = true;
                            }
                            jv4Var5.t = threadData;
                            jv4Var5.position = i;
                            jv4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            jv4 jv4Var6 = new jv4();
                            jv4Var6.h = true;
                            jv4Var6.t = threadData;
                            jv4Var6.position = i;
                            jv4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            jv4 jv4Var7 = new jv4();
                            jv4Var7.n = true;
                            jv4Var7.t = threadData;
                            jv4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var7);
                        }
                        jv4 jv4Var8 = new jv4();
                        jv4Var8.g = true;
                        jv4Var8.t = threadData;
                        jv4Var8.position = i;
                        jv4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jv4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        jv4 jv4Var9 = new jv4();
                        jv4Var9.t = threadData;
                        jv4Var9.position = i;
                        jv4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jv4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(jv4Var9);
                        jv4 jv4Var10 = new jv4();
                        jv4Var10.t = threadData;
                        jv4Var10.position = i;
                        if (threadData instanceof du4) {
                            jv4Var10.j = true;
                        } else {
                            jv4Var10.i = true;
                        }
                        jv4Var10.t.isJumpToFrsVideoTabPlay = z2;
                        jv4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jv4Var10);
                        if (threadData.getPollData() != null) {
                            jv4 jv4Var11 = new jv4();
                            jv4Var11.o = true;
                            jv4Var11.t = threadData;
                            jv4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jv4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            jv4 jv4Var12 = new jv4();
                            jv4Var12.l = true;
                            jv4Var12.t = threadData;
                            jv4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jv4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            jv4 jv4Var13 = new jv4();
                            jv4Var13.h = true;
                            jv4Var13.t = threadData;
                            jv4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jv4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            jv4 jv4Var14 = new jv4();
                            jv4Var14.n = true;
                            jv4Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jv4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var14);
                        }
                        jv4 jv4Var15 = new jv4();
                        jv4Var15.g = true;
                        jv4Var15.t = threadData;
                        jv4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jv4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jv4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        jv4 jv4Var16 = new jv4();
                        jv4Var16.t = threadData;
                        jv4Var16.position = i;
                        jv4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jv4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(jv4Var16);
                        jv4 jv4Var17 = new jv4();
                        jv4Var17.t = threadData;
                        jv4Var17.position = i;
                        jv4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jv4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jv4Var17);
                        if (threadData.getPollData() != null) {
                            jv4 jv4Var18 = new jv4();
                            jv4Var18.o = true;
                            jv4Var18.t = threadData;
                            jv4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jv4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            jv4 jv4Var19 = new jv4();
                            jv4Var19.l = true;
                            jv4Var19.t = threadData;
                            jv4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jv4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            jv4 jv4Var20 = new jv4();
                            jv4Var20.h = true;
                            jv4Var20.t = threadData;
                            jv4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jv4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            jv4 jv4Var21 = new jv4();
                            jv4Var21.n = true;
                            jv4Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jv4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jv4Var21);
                        }
                        jv4 jv4Var22 = new jv4();
                        jv4Var22.g = true;
                        jv4Var22.t = threadData;
                        jv4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jv4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jv4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        jv4 jv4Var23 = new jv4();
                        jv4Var23.t = threadData;
                        jv4Var23.position = i;
                        arrayList2.add(jv4Var23);
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
