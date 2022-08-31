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
/* loaded from: classes5.dex */
public class oi6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public pi6 b;
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
    public et6 o;

    public oi6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = ri.i(TbadkCoreApplication.getInst());
            this.f.scrW = ri.k(TbadkCoreApplication.getInst());
            this.f.scrDip = ri.h(TbadkCoreApplication.getInst());
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
        pi6 pi6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || (pi6Var = this.b) == null || pi6Var.c == null) {
            return;
        }
        ArrayList<pn> arrayList = new ArrayList<>();
        arrayList.add(threadData);
        ArrayList<pn> t = t(arrayList);
        if (ListUtils.isEmpty(this.b.c)) {
            this.b.c.addAll(t);
        } else {
            if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof if6)) {
                this.b.c.remove(0);
            }
            this.b.c.addAll(0, t);
        }
        this.a.M1(this.b);
    }

    public final void b(List<pn> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || gf7.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (pn pnVar : list) {
            if ((pnVar instanceof ThreadData) && (b = qd8.b(((ThreadData) pnVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        qd8.f().h(this.n, arrayList);
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int b = this.h ? 0 : ib8.b(this.b.c);
            String d = this.h ? "" : qd8.f().d(this.n);
            pi6 pi6Var = this.b;
            String e = ib8.e(pi6Var == null ? null : pi6Var.c, this.h);
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
            pi6 pi6Var = this.b;
            if (pi6Var == null) {
                return true;
            }
            return pi6Var.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.intValue;
    }

    public pi6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (pi6) invokeV.objValue;
    }

    public final void g(List<App> list, List<pn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            ib8.i(ib8.h(list, "FRS_GENERAL_TAB"), list2, 0);
            ib8.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            pi6 pi6Var = this.b;
            return (pi6Var == null || ListUtils.isEmpty(pi6Var.c)) ? false : true;
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
            zs6.a();
        }
    }

    public void l(String str) {
        pi6 pi6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (pi6Var = this.b) == null || gf7.e(pi6Var.c)) {
            return;
        }
        ib8.d(str, this.b.c);
        this.a.M1(this.b);
    }

    public final boolean m(pi6 pi6Var) {
        InterceptResult invokeL;
        et6 et6Var;
        et6 et6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, pi6Var)) == null) {
            if (pi6Var == null) {
                return false;
            }
            boolean z = this.a.h == 100;
            ArrayList arrayList = new ArrayList();
            if (this.h) {
                this.i.clear();
                Iterator<pn> it = pi6Var.c.iterator();
                while (it.hasNext()) {
                    pn next = it.next();
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
                int i = pi6Var.l;
                if (i != -1) {
                    if (i == 1) {
                        g(pi6Var.k, pi6Var.c);
                    } else if (i == 2) {
                        et6 et6Var3 = this.o;
                        if (et6Var3 != null) {
                            et6Var3.b(pi6Var.c, this.h, this.a.U());
                        }
                    } else if (i != 3) {
                        if (et6.d()) {
                            et6 et6Var4 = this.o;
                            if (et6Var4 != null) {
                                et6Var4.b(pi6Var.c, this.h, this.a.U());
                            }
                        } else {
                            g(pi6Var.k, pi6Var.c);
                        }
                    } else if (!ListUtils.isEmpty(pi6Var.m)) {
                        int intValue = pi6Var.m.get(0).ad_type.intValue();
                        if (intValue == 1) {
                            g(pi6Var.k, pi6Var.c);
                        } else if (intValue == 2 && (et6Var2 = this.o) != null) {
                            et6Var2.g(pi6Var.c, pi6Var.m, this.h, this.a.U());
                        }
                    }
                }
                this.b = pi6Var;
                pi6Var.c = t(pi6Var.c);
            } else {
                pi6 pi6Var2 = this.b;
                pi6Var2.a = pi6Var.a;
                pi6Var2.b.putAll(pi6Var.b);
                ArrayList<pn> arrayList2 = new ArrayList<>();
                Iterator<pn> it2 = pi6Var.c.iterator();
                while (it2.hasNext()) {
                    pn next2 = it2.next();
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
                int i2 = pi6Var.l;
                if (i2 == 1) {
                    g(pi6Var.k, pi6Var.c);
                } else if (i2 == 2) {
                    et6 et6Var5 = this.o;
                    if (et6Var5 != null) {
                        et6Var5.b(pi6Var.c, this.h, this.a.U());
                    }
                } else if (i2 != 3) {
                    if (et6.d()) {
                        et6 et6Var6 = this.o;
                        if (et6Var6 != null) {
                            et6Var6.b(pi6Var.c, this.h, this.a.U());
                        }
                    } else {
                        g(pi6Var.k, pi6Var.c);
                    }
                } else if (!ListUtils.isEmpty(pi6Var.m)) {
                    int intValue2 = pi6Var.m.get(0).ad_type.intValue();
                    if (intValue2 == 1) {
                        g(pi6Var.k, pi6Var.c);
                    } else if (intValue2 == 2 && (et6Var = this.o) != null) {
                        et6Var.g(pi6Var.c, pi6Var.m, this.h, this.a.U());
                    }
                }
                this.b.c.addAll(t(arrayList2));
            }
            this.a.M1(this.b);
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
        pi6 pi6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof pi6) {
                pi6Var = (pi6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof qi6) {
                qi6 qi6Var = (qi6) mvcSocketResponsedMessage.getData();
                pi6 pi6Var2 = new pi6();
                ArrayList<pn> arrayList = qi6Var.a;
                pi6Var2.c = arrayList;
                pi6Var2.a = qi6Var.c;
                pi6Var2.b = qi6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<pn> arrayList2 = pi6Var2.c;
                    pn pnVar = (pn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (pnVar instanceof ThreadData) {
                        this.f.lastThreadId = pg.g(((ThreadData) pnVar).getId(), 0L);
                    }
                }
                pi6Var = pi6Var2;
            }
        }
        if (pi6Var == null || !m(pi6Var)) {
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
            zs6.a();
        }
    }

    public void p(et6 et6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, et6Var) == null) {
            this.o = et6Var;
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
        pi6 pi6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof pi6) {
                pi6Var = (pi6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof qi6) {
                qi6 qi6Var = (qi6) mvcHttpResponsedMessage.getData();
                pi6 pi6Var2 = new pi6();
                ArrayList<pn> arrayList = qi6Var.a;
                pi6Var2.c = arrayList;
                pi6Var2.a = qi6Var.c;
                pi6Var2.b = qi6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<pn> arrayList2 = pi6Var2.c;
                    pn pnVar = (pn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (pnVar instanceof ThreadData) {
                        this.f.lastThreadId = pg.g(((ThreadData) pnVar).getId(), 0L);
                    }
                }
                pi6Var = pi6Var2;
            }
        }
        if (pi6Var == null || !m(pi6Var)) {
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

    public final ArrayList<pn> t(ArrayList<pn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, arrayList)) == null) {
            boolean z = this.a.h == 16;
            boolean z2 = this.a.h == 100;
            ArrayList<pn> arrayList2 = new ArrayList<>();
            Iterator<pn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                pn next = it.next();
                if (next instanceof up4) {
                    ((up4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof wp4) {
                    ((wp4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        jr4 jr4Var = new jr4();
                        jr4Var.t = threadData;
                        jr4Var.position = i;
                        jr4Var.a = true;
                        jr4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(jr4Var);
                        jr4 jr4Var2 = new jr4();
                        jr4Var2.t = threadData;
                        jr4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            jr4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            jr4Var2.d = true;
                            jr4Var2.u = imageWidthAndHeight[0];
                            jr4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            jr4Var2.e = true;
                        } else {
                            jr4Var2.b = true;
                        }
                        jr4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jr4Var2);
                        if (threadData.getPollData() != null) {
                            jr4 jr4Var3 = new jr4();
                            jr4Var3.o = true;
                            jr4Var3.t = threadData;
                            jr4Var3.position = i;
                            jr4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            jr4 jr4Var4 = new jr4();
                            jr4Var4.l = true;
                            jr4Var4.t = threadData;
                            jr4Var4.position = i;
                            jr4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            jr4 jr4Var5 = new jr4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                jr4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                jr4Var5.q = true;
                            }
                            jr4Var5.t = threadData;
                            jr4Var5.position = i;
                            jr4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            jr4 jr4Var6 = new jr4();
                            jr4Var6.h = true;
                            jr4Var6.t = threadData;
                            jr4Var6.position = i;
                            jr4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            jr4 jr4Var7 = new jr4();
                            jr4Var7.n = true;
                            jr4Var7.t = threadData;
                            jr4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var7);
                        }
                        jr4 jr4Var8 = new jr4();
                        jr4Var8.g = true;
                        jr4Var8.t = threadData;
                        jr4Var8.position = i;
                        jr4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jr4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        jr4 jr4Var9 = new jr4();
                        jr4Var9.t = threadData;
                        jr4Var9.position = i;
                        jr4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jr4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(jr4Var9);
                        jr4 jr4Var10 = new jr4();
                        jr4Var10.t = threadData;
                        jr4Var10.position = i;
                        if (threadData instanceof eq4) {
                            jr4Var10.j = true;
                        } else {
                            jr4Var10.i = true;
                        }
                        jr4Var10.t.isJumpToFrsVideoTabPlay = z2;
                        jr4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jr4Var10);
                        if (threadData.getPollData() != null) {
                            jr4 jr4Var11 = new jr4();
                            jr4Var11.o = true;
                            jr4Var11.t = threadData;
                            jr4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jr4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            jr4 jr4Var12 = new jr4();
                            jr4Var12.l = true;
                            jr4Var12.t = threadData;
                            jr4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jr4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            jr4 jr4Var13 = new jr4();
                            jr4Var13.h = true;
                            jr4Var13.t = threadData;
                            jr4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jr4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            jr4 jr4Var14 = new jr4();
                            jr4Var14.n = true;
                            jr4Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jr4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var14);
                        }
                        jr4 jr4Var15 = new jr4();
                        jr4Var15.g = true;
                        jr4Var15.t = threadData;
                        jr4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jr4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jr4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        jr4 jr4Var16 = new jr4();
                        jr4Var16.t = threadData;
                        jr4Var16.position = i;
                        jr4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jr4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(jr4Var16);
                        jr4 jr4Var17 = new jr4();
                        jr4Var17.t = threadData;
                        jr4Var17.position = i;
                        jr4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jr4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jr4Var17);
                        if (threadData.getPollData() != null) {
                            jr4 jr4Var18 = new jr4();
                            jr4Var18.o = true;
                            jr4Var18.t = threadData;
                            jr4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jr4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            jr4 jr4Var19 = new jr4();
                            jr4Var19.l = true;
                            jr4Var19.t = threadData;
                            jr4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jr4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            jr4 jr4Var20 = new jr4();
                            jr4Var20.h = true;
                            jr4Var20.t = threadData;
                            jr4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jr4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            jr4 jr4Var21 = new jr4();
                            jr4Var21.n = true;
                            jr4Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jr4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jr4Var21);
                        }
                        jr4 jr4Var22 = new jr4();
                        jr4Var22.g = true;
                        jr4Var22.t = threadData;
                        jr4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jr4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jr4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        jr4 jr4Var23 = new jr4();
                        jr4Var23.t = threadData;
                        jr4Var23.position = i;
                        arrayList2.add(jr4Var23);
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
