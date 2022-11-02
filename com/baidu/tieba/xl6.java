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
public class xl6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public yl6 b;
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
    public tw6 o;

    public xl6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = xi.j(TbadkCoreApplication.getInst());
            this.f.scrW = xi.l(TbadkCoreApplication.getInst());
            this.f.scrDip = xi.i(TbadkCoreApplication.getInst());
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
        yl6 yl6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData != null && (yl6Var = this.b) != null && yl6Var.c != null) {
            ArrayList<wn> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<wn> t = t(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(t);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof cj6)) {
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
            ow6.a();
        }
    }

    public final void b(List<wn> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || vi7.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (wn wnVar : list) {
            if ((wnVar instanceof ThreadData) && (b = hh8.b(((ThreadData) wnVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        hh8.f().h(this.n, arrayList);
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
            ow6.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<wn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = ze8.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = hh8.f().d(this.n);
            }
            yl6 yl6Var = this.b;
            if (yl6Var == null) {
                arrayList = null;
            } else {
                arrayList = yl6Var.c;
            }
            String e = ze8.e(arrayList, this.h);
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
            yl6 yl6Var = this.b;
            if (yl6Var == null) {
                return true;
            }
            return yl6Var.a;
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

    public yl6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (yl6) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            yl6 yl6Var = this.b;
            if (yl6Var != null && !ListUtils.isEmpty(yl6Var.c)) {
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

    public final void g(List<App> list, List<wn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            ze8.i(ze8.h(list, "FRS_GENERAL_TAB"), list2, 0);
            ze8.a(list2, this.j, "FRS_GENERAL_TAB");
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
        yl6 yl6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && (yl6Var = this.b) != null && !vi7.e(yl6Var.c)) {
            ze8.d(str, this.b.c);
            this.a.N1(this.b);
        }
    }

    public void p(tw6 tw6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tw6Var) == null) {
            this.o = tw6Var;
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

    public final boolean m(yl6 yl6Var) {
        InterceptResult invokeL;
        boolean z;
        tw6 tw6Var;
        tw6 tw6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, yl6Var)) == null) {
            if (yl6Var == null) {
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
                Iterator<wn> it = yl6Var.c.iterator();
                while (it.hasNext()) {
                    wn next = it.next();
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
                int i = yl6Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (tw6.d()) {
                                    tw6 tw6Var3 = this.o;
                                    if (tw6Var3 != null) {
                                        tw6Var3.b(yl6Var.c, this.h, this.a.U());
                                    }
                                } else {
                                    g(yl6Var.k, yl6Var.c);
                                }
                            } else if (!ListUtils.isEmpty(yl6Var.m)) {
                                int intValue = yl6Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(yl6Var.k, yl6Var.c);
                                } else if (intValue == 2 && (tw6Var2 = this.o) != null) {
                                    tw6Var2.g(yl6Var.c, yl6Var.m, this.h, this.a.U());
                                }
                            }
                        } else {
                            tw6 tw6Var4 = this.o;
                            if (tw6Var4 != null) {
                                tw6Var4.b(yl6Var.c, this.h, this.a.U());
                            }
                        }
                    } else {
                        g(yl6Var.k, yl6Var.c);
                    }
                }
                this.b = yl6Var;
                yl6Var.c = t(yl6Var.c);
            } else {
                yl6 yl6Var2 = this.b;
                yl6Var2.a = yl6Var.a;
                yl6Var2.b.putAll(yl6Var.b);
                ArrayList<wn> arrayList2 = new ArrayList<>();
                Iterator<wn> it2 = yl6Var.c.iterator();
                while (it2.hasNext()) {
                    wn next2 = it2.next();
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
                int i2 = yl6Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (tw6.d()) {
                                tw6 tw6Var5 = this.o;
                                if (tw6Var5 != null) {
                                    tw6Var5.b(yl6Var.c, this.h, this.a.U());
                                }
                            } else {
                                g(yl6Var.k, yl6Var.c);
                            }
                        } else if (!ListUtils.isEmpty(yl6Var.m)) {
                            int intValue2 = yl6Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(yl6Var.k, yl6Var.c);
                            } else if (intValue2 == 2 && (tw6Var = this.o) != null) {
                                tw6Var.g(yl6Var.c, yl6Var.m, this.h, this.a.U());
                            }
                        }
                    } else {
                        tw6 tw6Var6 = this.o;
                        if (tw6Var6 != null) {
                            tw6Var6.b(yl6Var.c, this.h, this.a.U());
                        }
                    }
                } else {
                    g(yl6Var.k, yl6Var.c);
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
        yl6 yl6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof yl6) {
                yl6Var = (yl6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof zl6) {
                zl6 zl6Var = (zl6) mvcSocketResponsedMessage.getData();
                yl6 yl6Var2 = new yl6();
                ArrayList<wn> arrayList = zl6Var.a;
                yl6Var2.c = arrayList;
                yl6Var2.a = zl6Var.c;
                yl6Var2.b = zl6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<wn> arrayList2 = yl6Var2.c;
                    wn wnVar = (wn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (wnVar instanceof ThreadData) {
                        this.f.lastThreadId = wg.g(((ThreadData) wnVar).getId(), 0L);
                    }
                }
                yl6Var = yl6Var2;
            }
        }
        if (yl6Var != null && m(yl6Var)) {
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
        yl6 yl6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof yl6) {
                yl6Var = (yl6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof zl6) {
                zl6 zl6Var = (zl6) mvcHttpResponsedMessage.getData();
                yl6 yl6Var2 = new yl6();
                ArrayList<wn> arrayList = zl6Var.a;
                yl6Var2.c = arrayList;
                yl6Var2.a = zl6Var.c;
                yl6Var2.b = zl6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<wn> arrayList2 = yl6Var2.c;
                    wn wnVar = (wn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (wnVar instanceof ThreadData) {
                        this.f.lastThreadId = wg.g(((ThreadData) wnVar).getId(), 0L);
                    }
                }
                yl6Var = yl6Var2;
            }
        }
        if (yl6Var != null && m(yl6Var)) {
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

    public final ArrayList<wn> t(ArrayList<wn> arrayList) {
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
            ArrayList<wn> arrayList2 = new ArrayList<>();
            Iterator<wn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                wn next = it.next();
                if (next instanceof ft4) {
                    ((ft4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof ht4) {
                    ((ht4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        vu4 vu4Var = new vu4();
                        vu4Var.t = threadData;
                        vu4Var.position = i;
                        vu4Var.a = true;
                        vu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(vu4Var);
                        vu4 vu4Var2 = new vu4();
                        vu4Var2.t = threadData;
                        vu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            vu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            vu4Var2.d = true;
                            vu4Var2.u = imageWidthAndHeight[0];
                            vu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            vu4Var2.e = true;
                        } else {
                            vu4Var2.b = true;
                        }
                        vu4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(vu4Var2);
                        if (threadData.getPollData() != null) {
                            vu4 vu4Var3 = new vu4();
                            vu4Var3.o = true;
                            vu4Var3.t = threadData;
                            vu4Var3.position = i;
                            vu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            vu4 vu4Var4 = new vu4();
                            vu4Var4.l = true;
                            vu4Var4.t = threadData;
                            vu4Var4.position = i;
                            vu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            vu4 vu4Var5 = new vu4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                vu4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                vu4Var5.q = true;
                            }
                            vu4Var5.t = threadData;
                            vu4Var5.position = i;
                            vu4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            vu4 vu4Var6 = new vu4();
                            vu4Var6.h = true;
                            vu4Var6.t = threadData;
                            vu4Var6.position = i;
                            vu4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            vu4 vu4Var7 = new vu4();
                            vu4Var7.n = true;
                            vu4Var7.t = threadData;
                            vu4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var7);
                        }
                        vu4 vu4Var8 = new vu4();
                        vu4Var8.g = true;
                        vu4Var8.t = threadData;
                        vu4Var8.position = i;
                        vu4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(vu4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        vu4 vu4Var9 = new vu4();
                        vu4Var9.t = threadData;
                        vu4Var9.position = i;
                        vu4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        vu4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(vu4Var9);
                        vu4 vu4Var10 = new vu4();
                        vu4Var10.t = threadData;
                        vu4Var10.position = i;
                        if (threadData instanceof pt4) {
                            vu4Var10.j = true;
                        } else {
                            vu4Var10.i = true;
                        }
                        vu4Var10.t.isJumpToFrsVideoTabPlay = z2;
                        vu4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(vu4Var10);
                        if (threadData.getPollData() != null) {
                            vu4 vu4Var11 = new vu4();
                            vu4Var11.o = true;
                            vu4Var11.t = threadData;
                            vu4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            vu4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            vu4 vu4Var12 = new vu4();
                            vu4Var12.l = true;
                            vu4Var12.t = threadData;
                            vu4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            vu4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            vu4 vu4Var13 = new vu4();
                            vu4Var13.h = true;
                            vu4Var13.t = threadData;
                            vu4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            vu4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            vu4 vu4Var14 = new vu4();
                            vu4Var14.n = true;
                            vu4Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            vu4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var14);
                        }
                        vu4 vu4Var15 = new vu4();
                        vu4Var15.g = true;
                        vu4Var15.t = threadData;
                        vu4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        vu4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(vu4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        vu4 vu4Var16 = new vu4();
                        vu4Var16.t = threadData;
                        vu4Var16.position = i;
                        vu4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        vu4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(vu4Var16);
                        vu4 vu4Var17 = new vu4();
                        vu4Var17.t = threadData;
                        vu4Var17.position = i;
                        vu4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        vu4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(vu4Var17);
                        if (threadData.getPollData() != null) {
                            vu4 vu4Var18 = new vu4();
                            vu4Var18.o = true;
                            vu4Var18.t = threadData;
                            vu4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            vu4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            vu4 vu4Var19 = new vu4();
                            vu4Var19.l = true;
                            vu4Var19.t = threadData;
                            vu4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            vu4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            vu4 vu4Var20 = new vu4();
                            vu4Var20.h = true;
                            vu4Var20.t = threadData;
                            vu4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            vu4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            vu4 vu4Var21 = new vu4();
                            vu4Var21.n = true;
                            vu4Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            vu4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var21);
                        }
                        vu4 vu4Var22 = new vu4();
                        vu4Var22.g = true;
                        vu4Var22.t = threadData;
                        vu4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        vu4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(vu4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        vu4 vu4Var23 = new vu4();
                        vu4Var23.t = threadData;
                        vu4Var23.position = i;
                        arrayList2.add(vu4Var23);
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
