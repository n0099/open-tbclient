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
/* loaded from: classes4.dex */
public class km6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public lm6 b;
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
    public fx6 o;

    public km6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = yi.j(TbadkCoreApplication.getInst());
            this.f.scrW = yi.l(TbadkCoreApplication.getInst());
            this.f.scrDip = yi.i(TbadkCoreApplication.getInst());
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
        lm6 lm6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData != null && (lm6Var = this.b) != null && lm6Var.c != null) {
            ArrayList<xn> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<xn> t = t(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(t);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof pj6)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, t);
            }
            this.a.N1(this.b);
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
            ax6.a();
        }
    }

    public final void b(List<xn> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || hj7.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (xn xnVar : list) {
            if ((xnVar instanceof ThreadData) && (b = th8.b(((ThreadData) xnVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        th8.f().h(this.n, arrayList);
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
            ax6.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<xn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = lf8.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = th8.f().d(this.n);
            }
            lm6 lm6Var = this.b;
            if (lm6Var == null) {
                arrayList = null;
            } else {
                arrayList = lm6Var.c;
            }
            String e = lf8.e(arrayList, this.h);
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
            lm6 lm6Var = this.b;
            if (lm6Var == null) {
                return true;
            }
            return lm6Var.a;
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

    public lm6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (lm6) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            lm6 lm6Var = this.b;
            if (lm6Var != null && !ListUtils.isEmpty(lm6Var.c)) {
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

    public final void g(List<App> list, List<xn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            lf8.i(lf8.h(list, "FRS_GENERAL_TAB"), list2, 0);
            lf8.a(list2, this.j, "FRS_GENERAL_TAB");
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
        lm6 lm6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && (lm6Var = this.b) != null && !hj7.e(lm6Var.c)) {
            lf8.d(str, this.b.c);
            this.a.N1(this.b);
        }
    }

    public void p(fx6 fx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fx6Var) == null) {
            this.o = fx6Var;
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
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && (frsCommonTabRequestData = this.c) != null) {
            frsCommonTabRequestData.tabType = i;
        }
    }

    public final boolean m(lm6 lm6Var) {
        InterceptResult invokeL;
        boolean z;
        fx6 fx6Var;
        fx6 fx6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, lm6Var)) == null) {
            if (lm6Var == null) {
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
                Iterator<xn> it = lm6Var.c.iterator();
                while (it.hasNext()) {
                    xn next = it.next();
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
                int i = lm6Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (fx6.d()) {
                                    fx6 fx6Var3 = this.o;
                                    if (fx6Var3 != null) {
                                        fx6Var3.b(lm6Var.c, this.h, this.a.U());
                                    }
                                } else {
                                    g(lm6Var.k, lm6Var.c);
                                }
                            } else if (!ListUtils.isEmpty(lm6Var.m)) {
                                int intValue = lm6Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(lm6Var.k, lm6Var.c);
                                } else if (intValue == 2 && (fx6Var2 = this.o) != null) {
                                    fx6Var2.g(lm6Var.c, lm6Var.m, this.h, this.a.U());
                                }
                            }
                        } else {
                            fx6 fx6Var4 = this.o;
                            if (fx6Var4 != null) {
                                fx6Var4.b(lm6Var.c, this.h, this.a.U());
                            }
                        }
                    } else {
                        g(lm6Var.k, lm6Var.c);
                    }
                }
                this.b = lm6Var;
                lm6Var.c = t(lm6Var.c);
            } else {
                lm6 lm6Var2 = this.b;
                lm6Var2.a = lm6Var.a;
                lm6Var2.b.putAll(lm6Var.b);
                ArrayList<xn> arrayList2 = new ArrayList<>();
                Iterator<xn> it2 = lm6Var.c.iterator();
                while (it2.hasNext()) {
                    xn next2 = it2.next();
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
                int i2 = lm6Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (fx6.d()) {
                                fx6 fx6Var5 = this.o;
                                if (fx6Var5 != null) {
                                    fx6Var5.b(lm6Var.c, this.h, this.a.U());
                                }
                            } else {
                                g(lm6Var.k, lm6Var.c);
                            }
                        } else if (!ListUtils.isEmpty(lm6Var.m)) {
                            int intValue2 = lm6Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(lm6Var.k, lm6Var.c);
                            } else if (intValue2 == 2 && (fx6Var = this.o) != null) {
                                fx6Var.g(lm6Var.c, lm6Var.m, this.h, this.a.U());
                            }
                        }
                    } else {
                        fx6 fx6Var6 = this.o;
                        if (fx6Var6 != null) {
                            fx6Var6.b(lm6Var.c, this.h, this.a.U());
                        }
                    }
                } else {
                    g(lm6Var.k, lm6Var.c);
                }
                this.b.c.addAll(t(arrayList2));
            }
            this.a.N1(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048589, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        lm6 lm6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof lm6) {
                lm6Var = (lm6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof mm6) {
                mm6 mm6Var = (mm6) mvcSocketResponsedMessage.getData();
                lm6 lm6Var2 = new lm6();
                ArrayList<xn> arrayList = mm6Var.a;
                lm6Var2.c = arrayList;
                lm6Var2.a = mm6Var.c;
                lm6Var2.b = mm6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<xn> arrayList2 = lm6Var2.c;
                    xn xnVar = (xn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (xnVar instanceof ThreadData) {
                        this.f.lastThreadId = xg.g(((ThreadData) xnVar).getId(), 0L);
                    }
                }
                lm6Var = lm6Var2;
            }
        }
        if (lm6Var != null && m(lm6Var)) {
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

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048594, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        lm6 lm6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof lm6) {
                lm6Var = (lm6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof mm6) {
                mm6 mm6Var = (mm6) mvcHttpResponsedMessage.getData();
                lm6 lm6Var2 = new lm6();
                ArrayList<xn> arrayList = mm6Var.a;
                lm6Var2.c = arrayList;
                lm6Var2.a = mm6Var.c;
                lm6Var2.b = mm6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<xn> arrayList2 = lm6Var2.c;
                    xn xnVar = (xn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (xnVar instanceof ThreadData) {
                        this.f.lastThreadId = xg.g(((ThreadData) xnVar).getId(), 0L);
                    }
                }
                lm6Var = lm6Var2;
            }
        }
        if (lm6Var != null && m(lm6Var)) {
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

    public final ArrayList<xn> t(ArrayList<xn> arrayList) {
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
            ArrayList<xn> arrayList2 = new ArrayList<>();
            Iterator<xn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                xn next = it.next();
                if (next instanceof ht4) {
                    ((ht4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof jt4) {
                    ((jt4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        xu4 xu4Var = new xu4();
                        xu4Var.t = threadData;
                        xu4Var.position = i;
                        xu4Var.a = true;
                        xu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(xu4Var);
                        xu4 xu4Var2 = new xu4();
                        xu4Var2.t = threadData;
                        xu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            xu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            xu4Var2.d = true;
                            xu4Var2.u = imageWidthAndHeight[0];
                            xu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            xu4Var2.e = true;
                        } else {
                            xu4Var2.b = true;
                        }
                        xu4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(xu4Var2);
                        if (threadData.getPollData() != null) {
                            xu4 xu4Var3 = new xu4();
                            xu4Var3.o = true;
                            xu4Var3.t = threadData;
                            xu4Var3.position = i;
                            xu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            xu4 xu4Var4 = new xu4();
                            xu4Var4.l = true;
                            xu4Var4.t = threadData;
                            xu4Var4.position = i;
                            xu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            xu4 xu4Var5 = new xu4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                xu4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                xu4Var5.q = true;
                            }
                            xu4Var5.t = threadData;
                            xu4Var5.position = i;
                            xu4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            xu4 xu4Var6 = new xu4();
                            xu4Var6.h = true;
                            xu4Var6.t = threadData;
                            xu4Var6.position = i;
                            xu4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            xu4 xu4Var7 = new xu4();
                            xu4Var7.n = true;
                            xu4Var7.t = threadData;
                            xu4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var7);
                        }
                        xu4 xu4Var8 = new xu4();
                        xu4Var8.g = true;
                        xu4Var8.t = threadData;
                        xu4Var8.position = i;
                        xu4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(xu4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        xu4 xu4Var9 = new xu4();
                        xu4Var9.t = threadData;
                        xu4Var9.position = i;
                        xu4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        xu4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(xu4Var9);
                        xu4 xu4Var10 = new xu4();
                        xu4Var10.t = threadData;
                        xu4Var10.position = i;
                        if (threadData instanceof rt4) {
                            xu4Var10.j = true;
                        } else {
                            xu4Var10.i = true;
                        }
                        xu4Var10.t.isJumpToFrsVideoTabPlay = z2;
                        xu4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(xu4Var10);
                        if (threadData.getPollData() != null) {
                            xu4 xu4Var11 = new xu4();
                            xu4Var11.o = true;
                            xu4Var11.t = threadData;
                            xu4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            xu4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            xu4 xu4Var12 = new xu4();
                            xu4Var12.l = true;
                            xu4Var12.t = threadData;
                            xu4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            xu4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            xu4 xu4Var13 = new xu4();
                            xu4Var13.h = true;
                            xu4Var13.t = threadData;
                            xu4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            xu4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            xu4 xu4Var14 = new xu4();
                            xu4Var14.n = true;
                            xu4Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            xu4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var14);
                        }
                        xu4 xu4Var15 = new xu4();
                        xu4Var15.g = true;
                        xu4Var15.t = threadData;
                        xu4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        xu4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(xu4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        xu4 xu4Var16 = new xu4();
                        xu4Var16.t = threadData;
                        xu4Var16.position = i;
                        xu4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        xu4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(xu4Var16);
                        xu4 xu4Var17 = new xu4();
                        xu4Var17.t = threadData;
                        xu4Var17.position = i;
                        xu4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        xu4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(xu4Var17);
                        if (threadData.getPollData() != null) {
                            xu4 xu4Var18 = new xu4();
                            xu4Var18.o = true;
                            xu4Var18.t = threadData;
                            xu4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            xu4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            xu4 xu4Var19 = new xu4();
                            xu4Var19.l = true;
                            xu4Var19.t = threadData;
                            xu4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            xu4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            xu4 xu4Var20 = new xu4();
                            xu4Var20.h = true;
                            xu4Var20.t = threadData;
                            xu4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            xu4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            xu4 xu4Var21 = new xu4();
                            xu4Var21.n = true;
                            xu4Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            xu4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(xu4Var21);
                        }
                        xu4 xu4Var22 = new xu4();
                        xu4Var22.g = true;
                        xu4Var22.t = threadData;
                        xu4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        xu4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(xu4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        xu4 xu4Var23 = new xu4();
                        xu4Var23.t = threadData;
                        xu4Var23.position = i;
                        arrayList2.add(xu4Var23);
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
