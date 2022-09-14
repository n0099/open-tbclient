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
public class tj6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public uj6 b;
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
    public pu6 o;

    public tj6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = ej.i(TbadkCoreApplication.getInst());
            this.f.scrW = ej.k(TbadkCoreApplication.getInst());
            this.f.scrDip = ej.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f);
            this.g = frsDynamicModel;
            frsDynamicModel.b0(this);
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
        frsCommonTabNetModel.b0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(ThreadData threadData) {
        uj6 uj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || (uj6Var = this.b) == null || uj6Var.c == null) {
            return;
        }
        ArrayList<Cdo> arrayList = new ArrayList<>();
        arrayList.add(threadData);
        ArrayList<Cdo> t = t(arrayList);
        if (ListUtils.isEmpty(this.b.c)) {
            this.b.c.addAll(t);
        } else {
            if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof yg6)) {
                this.b.c.remove(0);
            }
            this.b.c.addAll(0, t);
        }
        this.a.L1(this.b);
    }

    public final void b(List<Cdo> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || mg7.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Cdo cdo : list) {
            if ((cdo instanceof ThreadData) && (b = ye8.b(((ThreadData) cdo).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        ye8.f().h(this.n, arrayList);
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int b = this.h ? 0 : qc8.b(this.b.c);
            String d = this.h ? "" : ye8.f().d(this.n);
            uj6 uj6Var = this.b;
            String e = qc8.e(uj6Var == null ? null : uj6Var.c, this.h);
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
            uj6 uj6Var = this.b;
            if (uj6Var == null) {
                return true;
            }
            return uj6Var.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.intValue;
    }

    public uj6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (uj6) invokeV.objValue;
    }

    public final void g(List<App> list, List<Cdo> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            qc8.i(qc8.h(list, "FRS_GENERAL_TAB"), list2, 0);
            qc8.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            uj6 uj6Var = this.b;
            return (uj6Var == null || ListUtils.isEmpty(uj6Var.c)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i(int i) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            return (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.d) == null || frsViewData.mHeadLineDefaultNavTabId != i) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.T()) {
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
            } else if (this.g.T()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            ku6.a();
        }
    }

    public void l(String str) {
        uj6 uj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (uj6Var = this.b) == null || mg7.e(uj6Var.c)) {
            return;
        }
        qc8.d(str, this.b.c);
        this.a.L1(this.b);
    }

    public final boolean m(uj6 uj6Var) {
        InterceptResult invokeL;
        pu6 pu6Var;
        pu6 pu6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, uj6Var)) == null) {
            if (uj6Var == null) {
                return false;
            }
            boolean z = this.a.h == 100;
            ArrayList arrayList = new ArrayList();
            if (this.h) {
                this.i.clear();
                Iterator<Cdo> it = uj6Var.c.iterator();
                while (it.hasNext()) {
                    Cdo next = it.next();
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
                int i = uj6Var.l;
                if (i != -1) {
                    if (i == 1) {
                        g(uj6Var.k, uj6Var.c);
                    } else if (i == 2) {
                        pu6 pu6Var3 = this.o;
                        if (pu6Var3 != null) {
                            pu6Var3.b(uj6Var.c, this.h, this.a.U());
                        }
                    } else if (i != 3) {
                        if (pu6.d()) {
                            pu6 pu6Var4 = this.o;
                            if (pu6Var4 != null) {
                                pu6Var4.b(uj6Var.c, this.h, this.a.U());
                            }
                        } else {
                            g(uj6Var.k, uj6Var.c);
                        }
                    } else if (!ListUtils.isEmpty(uj6Var.m)) {
                        int intValue = uj6Var.m.get(0).ad_type.intValue();
                        if (intValue == 1) {
                            g(uj6Var.k, uj6Var.c);
                        } else if (intValue == 2 && (pu6Var2 = this.o) != null) {
                            pu6Var2.g(uj6Var.c, uj6Var.m, this.h, this.a.U());
                        }
                    }
                }
                this.b = uj6Var;
                uj6Var.c = t(uj6Var.c);
            } else {
                uj6 uj6Var2 = this.b;
                uj6Var2.a = uj6Var.a;
                uj6Var2.b.putAll(uj6Var.b);
                ArrayList<Cdo> arrayList2 = new ArrayList<>();
                Iterator<Cdo> it2 = uj6Var.c.iterator();
                while (it2.hasNext()) {
                    Cdo next2 = it2.next();
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
                int i2 = uj6Var.l;
                if (i2 == 1) {
                    g(uj6Var.k, uj6Var.c);
                } else if (i2 == 2) {
                    pu6 pu6Var5 = this.o;
                    if (pu6Var5 != null) {
                        pu6Var5.b(uj6Var.c, this.h, this.a.U());
                    }
                } else if (i2 != 3) {
                    if (pu6.d()) {
                        pu6 pu6Var6 = this.o;
                        if (pu6Var6 != null) {
                            pu6Var6.b(uj6Var.c, this.h, this.a.U());
                        }
                    } else {
                        g(uj6Var.k, uj6Var.c);
                    }
                } else if (!ListUtils.isEmpty(uj6Var.m)) {
                    int intValue2 = uj6Var.m.get(0).ad_type.intValue();
                    if (intValue2 == 1) {
                        g(uj6Var.k, uj6Var.c);
                    } else if (intValue2 == 2 && (pu6Var = this.o) != null) {
                        pu6Var.g(uj6Var.c, uj6Var.m, this.h, this.a.U());
                    }
                }
                this.b.c.addAll(t(arrayList2));
            }
            this.a.L1(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048589, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        uj6 uj6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof uj6) {
                uj6Var = (uj6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof vj6) {
                vj6 vj6Var = (vj6) mvcSocketResponsedMessage.getData();
                uj6 uj6Var2 = new uj6();
                ArrayList<Cdo> arrayList = vj6Var.a;
                uj6Var2.c = arrayList;
                uj6Var2.a = vj6Var.c;
                uj6Var2.b = vj6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<Cdo> arrayList2 = uj6Var2.c;
                    Cdo cdo = (Cdo) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (cdo instanceof ThreadData) {
                        this.f.lastThreadId = dh.g(((ThreadData) cdo).getId(), 0L);
                    }
                }
                uj6Var = uj6Var2;
            }
        }
        if (uj6Var == null || !m(uj6Var)) {
            this.l = mvcSocketResponsedMessage.getError();
            this.m = mvcSocketResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.l);
            errorData.setError_msg(this.m);
            if (this.l != 0) {
                this.a.f(errorData);
            }
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.T()) {
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
            } else if (this.g.T()) {
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
            ku6.a();
        }
    }

    public void p(pu6 pu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pu6Var) == null) {
            this.o = pu6Var;
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.k = j;
        }
    }

    public void r(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (frsCommonTabRequestData = this.c) == null) {
            return;
        }
        frsCommonTabRequestData.tabType = i;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        uj6 uj6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof uj6) {
                uj6Var = (uj6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof vj6) {
                vj6 vj6Var = (vj6) mvcHttpResponsedMessage.getData();
                uj6 uj6Var2 = new uj6();
                ArrayList<Cdo> arrayList = vj6Var.a;
                uj6Var2.c = arrayList;
                uj6Var2.a = vj6Var.c;
                uj6Var2.b = vj6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<Cdo> arrayList2 = uj6Var2.c;
                    Cdo cdo = (Cdo) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (cdo instanceof ThreadData) {
                        this.f.lastThreadId = dh.g(((ThreadData) cdo).getId(), 0L);
                    }
                }
                uj6Var = uj6Var2;
            }
        }
        if (uj6Var == null || !m(uj6Var)) {
            this.l = mvcHttpResponsedMessage.getError();
            this.m = mvcHttpResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.l);
            errorData.setError_msg(this.m);
            if (this.l != 0) {
                this.a.f(errorData);
            }
        }
    }

    public final ArrayList<Cdo> t(ArrayList<Cdo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
            boolean z = this.a.h == 16;
            boolean z2 = this.a.h == 100;
            ArrayList<Cdo> arrayList2 = new ArrayList<>();
            Iterator<Cdo> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next instanceof zr4) {
                    ((zr4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof bs4) {
                    ((bs4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        ot4 ot4Var = new ot4();
                        ot4Var.t = threadData;
                        ot4Var.position = i;
                        ot4Var.a = true;
                        ot4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(ot4Var);
                        ot4 ot4Var2 = new ot4();
                        ot4Var2.t = threadData;
                        ot4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            ot4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            ot4Var2.d = true;
                            ot4Var2.u = imageWidthAndHeight[0];
                            ot4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            ot4Var2.e = true;
                        } else {
                            ot4Var2.b = true;
                        }
                        ot4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(ot4Var2);
                        if (threadData.getPollData() != null) {
                            ot4 ot4Var3 = new ot4();
                            ot4Var3.o = true;
                            ot4Var3.t = threadData;
                            ot4Var3.position = i;
                            ot4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            ot4 ot4Var4 = new ot4();
                            ot4Var4.l = true;
                            ot4Var4.t = threadData;
                            ot4Var4.position = i;
                            ot4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            ot4 ot4Var5 = new ot4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                ot4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                ot4Var5.q = true;
                            }
                            ot4Var5.t = threadData;
                            ot4Var5.position = i;
                            ot4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            ot4 ot4Var6 = new ot4();
                            ot4Var6.h = true;
                            ot4Var6.t = threadData;
                            ot4Var6.position = i;
                            ot4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            ot4 ot4Var7 = new ot4();
                            ot4Var7.n = true;
                            ot4Var7.t = threadData;
                            ot4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var7);
                        }
                        ot4 ot4Var8 = new ot4();
                        ot4Var8.g = true;
                        ot4Var8.t = threadData;
                        ot4Var8.position = i;
                        ot4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(ot4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        ot4 ot4Var9 = new ot4();
                        ot4Var9.t = threadData;
                        ot4Var9.position = i;
                        ot4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        ot4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(ot4Var9);
                        ot4 ot4Var10 = new ot4();
                        ot4Var10.t = threadData;
                        ot4Var10.position = i;
                        if (threadData instanceof js4) {
                            ot4Var10.j = true;
                        } else {
                            ot4Var10.i = true;
                        }
                        ot4Var10.t.isJumpToFrsVideoTabPlay = z2;
                        ot4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(ot4Var10);
                        if (threadData.getPollData() != null) {
                            ot4 ot4Var11 = new ot4();
                            ot4Var11.o = true;
                            ot4Var11.t = threadData;
                            ot4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ot4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            ot4 ot4Var12 = new ot4();
                            ot4Var12.l = true;
                            ot4Var12.t = threadData;
                            ot4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ot4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            ot4 ot4Var13 = new ot4();
                            ot4Var13.h = true;
                            ot4Var13.t = threadData;
                            ot4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ot4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            ot4 ot4Var14 = new ot4();
                            ot4Var14.n = true;
                            ot4Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ot4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var14);
                        }
                        ot4 ot4Var15 = new ot4();
                        ot4Var15.g = true;
                        ot4Var15.t = threadData;
                        ot4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        ot4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(ot4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        ot4 ot4Var16 = new ot4();
                        ot4Var16.t = threadData;
                        ot4Var16.position = i;
                        ot4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        ot4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(ot4Var16);
                        ot4 ot4Var17 = new ot4();
                        ot4Var17.t = threadData;
                        ot4Var17.position = i;
                        ot4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        ot4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(ot4Var17);
                        if (threadData.getPollData() != null) {
                            ot4 ot4Var18 = new ot4();
                            ot4Var18.o = true;
                            ot4Var18.t = threadData;
                            ot4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ot4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            ot4 ot4Var19 = new ot4();
                            ot4Var19.l = true;
                            ot4Var19.t = threadData;
                            ot4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ot4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            ot4 ot4Var20 = new ot4();
                            ot4Var20.h = true;
                            ot4Var20.t = threadData;
                            ot4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ot4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            ot4 ot4Var21 = new ot4();
                            ot4Var21.n = true;
                            ot4Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            ot4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ot4Var21);
                        }
                        ot4 ot4Var22 = new ot4();
                        ot4Var22.g = true;
                        ot4Var22.t = threadData;
                        ot4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        ot4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(ot4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        ot4 ot4Var23 = new ot4();
                        ot4Var23.t = threadData;
                        ot4Var23.position = i;
                        arrayList2.add(ot4Var23);
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
