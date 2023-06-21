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
/* loaded from: classes7.dex */
public class rg7 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public sg7 b;
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
    public ht7 o;

    public rg7(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = wi.j(TbadkCoreApplication.getInst());
            this.f.scrW = wi.l(TbadkCoreApplication.getInst());
            this.f.scrDip = wi.i(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f);
            this.g = frsDynamicModel;
            frsDynamicModel.w0(this);
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
        frsCommonTabNetModel.w0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void L(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        sg7 sg7Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof sg7) {
                sg7Var = (sg7) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof tg7) {
                tg7 tg7Var = (tg7) mvcHttpResponsedMessage.getData();
                sg7 sg7Var2 = new sg7();
                ArrayList<wn> arrayList = tg7Var.a;
                sg7Var2.c = arrayList;
                sg7Var2.a = tg7Var.c;
                sg7Var2.b = tg7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<wn> arrayList2 = sg7Var2.c;
                    wn wnVar = (wn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (wnVar instanceof ThreadData) {
                        this.f.lastThreadId = ug.g(((ThreadData) wnVar).getId(), 0L);
                    }
                }
                sg7Var = sg7Var2;
            }
        }
        if (sg7Var != null && n(sg7Var)) {
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

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void z(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048596, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        sg7 sg7Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof sg7) {
                sg7Var = (sg7) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof tg7) {
                tg7 tg7Var = (tg7) mvcSocketResponsedMessage.getData();
                sg7 sg7Var2 = new sg7();
                ArrayList<wn> arrayList = tg7Var.a;
                sg7Var2.c = arrayList;
                sg7Var2.a = tg7Var.c;
                sg7Var2.b = tg7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<wn> arrayList2 = sg7Var2.c;
                    wn wnVar = (wn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (wnVar instanceof ThreadData) {
                        this.f.lastThreadId = ug.g(((ThreadData) wnVar).getId(), 0L);
                    }
                }
                sg7Var = sg7Var2;
            }
        }
        if (sg7Var != null && n(sg7Var)) {
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

    public void a(ThreadData threadData) {
        sg7 sg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && (sg7Var = this.b) != null && sg7Var.c != null) {
            ArrayList<wn> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<wn> s = s(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(s);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof vd7)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, s);
            }
            this.a.c2(this.b);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.o0()) {
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
            } else if (this.g.o0()) {
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
            ct7.a();
        }
    }

    public final void b(List<wn> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || sp8.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (wn wnVar : list) {
            if ((wnVar instanceof ThreadData) && (b = op9.b(((ThreadData) wnVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        op9.f().h(this.n, arrayList);
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.o0()) {
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
            } else if (this.g.o0()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            ct7.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<wn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = en9.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = op9.f().d(this.n);
            }
            sg7 sg7Var = this.b;
            if (sg7Var == null) {
                arrayList = null;
            } else {
                arrayList = sg7Var.c;
            }
            String e = en9.e(arrayList, this.h);
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
            sg7 sg7Var = this.b;
            if (sg7Var == null) {
                return true;
            }
            return sg7Var.a;
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

    public sg7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (sg7) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            sg7 sg7Var = this.b;
            if (sg7Var != null && !ListUtils.isEmpty(sg7Var.c)) {
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
                return frsCommonTabNetModel.o0();
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

    public final void g(List<App> list, List<wn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) {
            b(list2);
            en9.i(en9.h(list, "FRS_GENERAL_TAB"), list2, 0);
            en9.a(list2, this.j, "FRS_GENERAL_TAB");
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
        sg7 sg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (sg7Var = this.b) != null && !sp8.e(sg7Var.c)) {
            en9.d(str, this.b.c);
            this.a.c2(this.b);
        }
    }

    public void p(ht7 ht7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ht7Var) == null) {
            this.o = ht7Var;
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

    public final boolean n(sg7 sg7Var) {
        InterceptResult invokeL;
        boolean z;
        ht7 ht7Var;
        ht7 ht7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, sg7Var)) == null) {
            if (sg7Var == null) {
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
                Iterator<wn> it = sg7Var.c.iterator();
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
                int i = sg7Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (ht7.d()) {
                                    ht7 ht7Var3 = this.o;
                                    if (ht7Var3 != null) {
                                        ht7Var3.b(sg7Var.c, this.h, this.a.a0());
                                    }
                                } else {
                                    g(sg7Var.k, sg7Var.c);
                                }
                            } else if (!ListUtils.isEmpty(sg7Var.m)) {
                                int intValue = sg7Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(sg7Var.k, sg7Var.c);
                                } else if (intValue == 2 && (ht7Var2 = this.o) != null) {
                                    ht7Var2.g(sg7Var.c, sg7Var.m, this.h, this.a.a0());
                                }
                            }
                        } else {
                            ht7 ht7Var4 = this.o;
                            if (ht7Var4 != null) {
                                ht7Var4.b(sg7Var.c, this.h, this.a.a0());
                            }
                        }
                    } else {
                        g(sg7Var.k, sg7Var.c);
                    }
                }
                this.b = sg7Var;
                sg7Var.c = s(sg7Var.c);
            } else {
                sg7 sg7Var2 = this.b;
                sg7Var2.a = sg7Var.a;
                sg7Var2.b.putAll(sg7Var.b);
                ArrayList<wn> arrayList2 = new ArrayList<>();
                Iterator<wn> it2 = sg7Var.c.iterator();
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
                    String str = ((VideoItemData) arrayList.get(0)).forum_id;
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(str).clear();
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(str).addAll(arrayList);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921628));
                }
                int i2 = sg7Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (ht7.d()) {
                                ht7 ht7Var5 = this.o;
                                if (ht7Var5 != null) {
                                    ht7Var5.b(sg7Var.c, this.h, this.a.a0());
                                }
                            } else {
                                g(sg7Var.k, sg7Var.c);
                            }
                        } else if (!ListUtils.isEmpty(sg7Var.m)) {
                            int intValue2 = sg7Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(sg7Var.k, sg7Var.c);
                            } else if (intValue2 == 2 && (ht7Var = this.o) != null) {
                                ht7Var.g(sg7Var.c, sg7Var.m, this.h, this.a.a0());
                            }
                        }
                    } else {
                        ht7 ht7Var6 = this.o;
                        if (ht7Var6 != null) {
                            ht7Var6.b(sg7Var.c, this.h, this.a.a0());
                        }
                    }
                } else {
                    g(sg7Var.k, sg7Var.c);
                }
                this.b.c.addAll(s(arrayList2));
            }
            this.a.c2(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<wn> s(ArrayList<wn> arrayList) {
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
                if (next instanceof z25) {
                    ((z25) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof a35) {
                    ((a35) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        o45 o45Var = new o45();
                        o45Var.t = threadData;
                        o45Var.position = i;
                        o45Var.a = true;
                        o45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(o45Var);
                        o45 o45Var2 = new o45();
                        o45Var2.t = threadData;
                        o45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            o45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            o45Var2.d = true;
                            o45Var2.u = imageWidthAndHeight[0];
                            o45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            o45Var2.e = true;
                        } else {
                            o45Var2.b = true;
                        }
                        o45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(o45Var2);
                        if (threadData.getPollData() != null) {
                            o45 o45Var3 = new o45();
                            o45Var3.o = true;
                            o45Var3.t = threadData;
                            o45Var3.position = i;
                            o45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            o45 o45Var4 = new o45();
                            o45Var4.l = true;
                            o45Var4.t = threadData;
                            o45Var4.position = i;
                            o45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            o45 o45Var5 = new o45();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                o45Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                o45Var5.q = true;
                            }
                            o45Var5.t = threadData;
                            o45Var5.position = i;
                            o45Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            o45 o45Var6 = new o45();
                            o45Var6.h = true;
                            o45Var6.t = threadData;
                            o45Var6.position = i;
                            o45Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            o45 o45Var7 = new o45();
                            o45Var7.n = true;
                            o45Var7.t = threadData;
                            o45Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var7);
                        }
                        o45 o45Var8 = new o45();
                        o45Var8.g = true;
                        o45Var8.t = threadData;
                        o45Var8.position = i;
                        o45Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(o45Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        o45 o45Var9 = new o45();
                        o45Var9.t = threadData;
                        o45Var9.position = i;
                        o45Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        o45Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(o45Var9);
                        o45 o45Var10 = new o45();
                        o45Var10.t = threadData;
                        o45Var10.position = i;
                        if (threadData instanceof i35) {
                            o45Var10.j = true;
                        } else {
                            o45Var10.i = true;
                        }
                        o45Var10.t.isJumpToFrsVideoTabPlay = z2;
                        o45Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(o45Var10);
                        if (threadData.getPollData() != null) {
                            o45 o45Var11 = new o45();
                            o45Var11.o = true;
                            o45Var11.t = threadData;
                            o45Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            o45Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            o45 o45Var12 = new o45();
                            o45Var12.l = true;
                            o45Var12.t = threadData;
                            o45Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            o45Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            o45 o45Var13 = new o45();
                            o45Var13.h = true;
                            o45Var13.t = threadData;
                            o45Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            o45Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            o45 o45Var14 = new o45();
                            o45Var14.n = true;
                            o45Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            o45Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var14);
                        }
                        o45 o45Var15 = new o45();
                        o45Var15.g = true;
                        o45Var15.t = threadData;
                        o45Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        o45Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(o45Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        o45 o45Var16 = new o45();
                        o45Var16.t = threadData;
                        o45Var16.position = i;
                        o45Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        o45Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(o45Var16);
                        o45 o45Var17 = new o45();
                        o45Var17.t = threadData;
                        o45Var17.position = i;
                        o45Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        o45Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(o45Var17);
                        if (threadData.getPollData() != null) {
                            o45 o45Var18 = new o45();
                            o45Var18.o = true;
                            o45Var18.t = threadData;
                            o45Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            o45Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            o45 o45Var19 = new o45();
                            o45Var19.l = true;
                            o45Var19.t = threadData;
                            o45Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            o45Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            o45 o45Var20 = new o45();
                            o45Var20.h = true;
                            o45Var20.t = threadData;
                            o45Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            o45Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            o45 o45Var21 = new o45();
                            o45Var21.n = true;
                            o45Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            o45Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(o45Var21);
                        }
                        o45 o45Var22 = new o45();
                        o45Var22.g = true;
                        o45Var22.t = threadData;
                        o45Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        o45Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(o45Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        o45 o45Var23 = new o45();
                        o45Var23.t = threadData;
                        o45Var23.position = i;
                        arrayList2.add(o45Var23);
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
