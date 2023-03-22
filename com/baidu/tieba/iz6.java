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
public class iz6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public jz6 b;
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
    public na7 o;

    public iz6(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = hi.j(TbadkCoreApplication.getInst());
            this.f.scrW = hi.l(TbadkCoreApplication.getInst());
            this.f.scrDip = hi.i(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f);
            this.g = frsDynamicModel;
            frsDynamicModel.t0(this);
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
        frsCommonTabNetModel.t0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void F(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        jz6 jz6Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof jz6) {
                jz6Var = (jz6) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof kz6) {
                kz6 kz6Var = (kz6) mvcHttpResponsedMessage.getData();
                jz6 jz6Var2 = new jz6();
                ArrayList<gn> arrayList = kz6Var.a;
                jz6Var2.c = arrayList;
                jz6Var2.a = kz6Var.c;
                jz6Var2.b = kz6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<gn> arrayList2 = jz6Var2.c;
                    gn gnVar = (gn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (gnVar instanceof ThreadData) {
                        this.f.lastThreadId = gg.g(((ThreadData) gnVar).getId(), 0L);
                    }
                }
                jz6Var = jz6Var2;
            }
        }
        if (jz6Var != null && m(jz6Var)) {
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
    public void u(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048595, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        jz6 jz6Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof jz6) {
                jz6Var = (jz6) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof kz6) {
                kz6 kz6Var = (kz6) mvcSocketResponsedMessage.getData();
                jz6 jz6Var2 = new jz6();
                ArrayList<gn> arrayList = kz6Var.a;
                jz6Var2.c = arrayList;
                jz6Var2.a = kz6Var.c;
                jz6Var2.b = kz6Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<gn> arrayList2 = jz6Var2.c;
                    gn gnVar = (gn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (gnVar instanceof ThreadData) {
                        this.f.lastThreadId = gg.g(((ThreadData) gnVar).getId(), 0L);
                    }
                }
                jz6Var = jz6Var2;
            }
        }
        if (jz6Var != null && m(jz6Var)) {
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
        jz6 jz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && (jz6Var = this.b) != null && jz6Var.c != null) {
            ArrayList<gn> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<gn> r = r(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(r);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof mw6)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, r);
            }
            this.a.Z1(this.b);
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.l0()) {
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
            } else if (this.g.l0()) {
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
            ia7.a();
        }
    }

    public final void b(List<gn> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || v38.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (gn gnVar : list) {
            if ((gnVar instanceof ThreadData) && (b = r29.b(((ThreadData) gnVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        r29.f().h(this.n, arrayList);
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.l0()) {
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
            } else if (this.g.l0()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            ia7.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<gn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = j09.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = r29.f().d(this.n);
            }
            jz6 jz6Var = this.b;
            if (jz6Var == null) {
                arrayList = null;
            } else {
                arrayList = jz6Var.c;
            }
            String e = j09.e(arrayList, this.h);
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
            jz6 jz6Var = this.b;
            if (jz6Var == null) {
                return true;
            }
            return jz6Var.a;
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

    public jz6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (jz6) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            jz6 jz6Var = this.b;
            if (jz6Var != null && !ListUtils.isEmpty(jz6Var.c)) {
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
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final void g(List<App> list, List<gn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) {
            b(list2);
            j09.i(j09.h(list, "FRS_GENERAL_TAB"), list2, 0);
            j09.a(list2, this.j, "FRS_GENERAL_TAB");
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

    public void l(String str) {
        jz6 jz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && (jz6Var = this.b) != null && !v38.e(jz6Var.c)) {
            j09.d(str, this.b.c);
            this.a.Z1(this.b);
        }
    }

    public void o(na7 na7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, na7Var) == null) {
            this.o = na7Var;
        }
    }

    public void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.k = j;
        }
    }

    public void q(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && (frsCommonTabRequestData = this.c) != null) {
            frsCommonTabRequestData.tabType = i;
        }
    }

    public final boolean m(jz6 jz6Var) {
        InterceptResult invokeL;
        boolean z;
        na7 na7Var;
        na7 na7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, jz6Var)) == null) {
            if (jz6Var == null) {
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
                Iterator<gn> it = jz6Var.c.iterator();
                while (it.hasNext()) {
                    gn next = it.next();
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
                int i = jz6Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (na7.d()) {
                                    na7 na7Var3 = this.o;
                                    if (na7Var3 != null) {
                                        na7Var3.b(jz6Var.c, this.h, this.a.O());
                                    }
                                } else {
                                    g(jz6Var.k, jz6Var.c);
                                }
                            } else if (!ListUtils.isEmpty(jz6Var.m)) {
                                int intValue = jz6Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(jz6Var.k, jz6Var.c);
                                } else if (intValue == 2 && (na7Var2 = this.o) != null) {
                                    na7Var2.g(jz6Var.c, jz6Var.m, this.h, this.a.O());
                                }
                            }
                        } else {
                            na7 na7Var4 = this.o;
                            if (na7Var4 != null) {
                                na7Var4.b(jz6Var.c, this.h, this.a.O());
                            }
                        }
                    } else {
                        g(jz6Var.k, jz6Var.c);
                    }
                }
                this.b = jz6Var;
                jz6Var.c = r(jz6Var.c);
            } else {
                jz6 jz6Var2 = this.b;
                jz6Var2.a = jz6Var.a;
                jz6Var2.b.putAll(jz6Var.b);
                ArrayList<gn> arrayList2 = new ArrayList<>();
                Iterator<gn> it2 = jz6Var.c.iterator();
                while (it2.hasNext()) {
                    gn next2 = it2.next();
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
                int i2 = jz6Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (na7.d()) {
                                na7 na7Var5 = this.o;
                                if (na7Var5 != null) {
                                    na7Var5.b(jz6Var.c, this.h, this.a.O());
                                }
                            } else {
                                g(jz6Var.k, jz6Var.c);
                            }
                        } else if (!ListUtils.isEmpty(jz6Var.m)) {
                            int intValue2 = jz6Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(jz6Var.k, jz6Var.c);
                            } else if (intValue2 == 2 && (na7Var = this.o) != null) {
                                na7Var.g(jz6Var.c, jz6Var.m, this.h, this.a.O());
                            }
                        }
                    } else {
                        na7 na7Var6 = this.o;
                        if (na7Var6 != null) {
                            na7Var6.b(jz6Var.c, this.h, this.a.O());
                        }
                    }
                } else {
                    g(jz6Var.k, jz6Var.c);
                }
                this.b.c.addAll(r(arrayList2));
            }
            this.a.Z1(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<gn> r(ArrayList<gn> arrayList) {
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
            ArrayList<gn> arrayList2 = new ArrayList<>();
            Iterator<gn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                gn next = it.next();
                if (next instanceof xx4) {
                    ((xx4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof yx4) {
                    ((yx4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        mz4 mz4Var = new mz4();
                        mz4Var.t = threadData;
                        mz4Var.position = i;
                        mz4Var.a = true;
                        mz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(mz4Var);
                        mz4 mz4Var2 = new mz4();
                        mz4Var2.t = threadData;
                        mz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            mz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            mz4Var2.d = true;
                            mz4Var2.u = imageWidthAndHeight[0];
                            mz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            mz4Var2.e = true;
                        } else {
                            mz4Var2.b = true;
                        }
                        mz4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(mz4Var2);
                        if (threadData.getPollData() != null) {
                            mz4 mz4Var3 = new mz4();
                            mz4Var3.o = true;
                            mz4Var3.t = threadData;
                            mz4Var3.position = i;
                            mz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            mz4 mz4Var4 = new mz4();
                            mz4Var4.l = true;
                            mz4Var4.t = threadData;
                            mz4Var4.position = i;
                            mz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            mz4 mz4Var5 = new mz4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                mz4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                mz4Var5.q = true;
                            }
                            mz4Var5.t = threadData;
                            mz4Var5.position = i;
                            mz4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            mz4 mz4Var6 = new mz4();
                            mz4Var6.h = true;
                            mz4Var6.t = threadData;
                            mz4Var6.position = i;
                            mz4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            mz4 mz4Var7 = new mz4();
                            mz4Var7.n = true;
                            mz4Var7.t = threadData;
                            mz4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var7);
                        }
                        mz4 mz4Var8 = new mz4();
                        mz4Var8.g = true;
                        mz4Var8.t = threadData;
                        mz4Var8.position = i;
                        mz4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(mz4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        mz4 mz4Var9 = new mz4();
                        mz4Var9.t = threadData;
                        mz4Var9.position = i;
                        mz4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        mz4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(mz4Var9);
                        mz4 mz4Var10 = new mz4();
                        mz4Var10.t = threadData;
                        mz4Var10.position = i;
                        if (threadData instanceof gy4) {
                            mz4Var10.j = true;
                        } else {
                            mz4Var10.i = true;
                        }
                        mz4Var10.t.isJumpToFrsVideoTabPlay = z2;
                        mz4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(mz4Var10);
                        if (threadData.getPollData() != null) {
                            mz4 mz4Var11 = new mz4();
                            mz4Var11.o = true;
                            mz4Var11.t = threadData;
                            mz4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            mz4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            mz4 mz4Var12 = new mz4();
                            mz4Var12.l = true;
                            mz4Var12.t = threadData;
                            mz4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            mz4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            mz4 mz4Var13 = new mz4();
                            mz4Var13.h = true;
                            mz4Var13.t = threadData;
                            mz4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            mz4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            mz4 mz4Var14 = new mz4();
                            mz4Var14.n = true;
                            mz4Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            mz4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var14);
                        }
                        mz4 mz4Var15 = new mz4();
                        mz4Var15.g = true;
                        mz4Var15.t = threadData;
                        mz4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        mz4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(mz4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        mz4 mz4Var16 = new mz4();
                        mz4Var16.t = threadData;
                        mz4Var16.position = i;
                        mz4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        mz4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(mz4Var16);
                        mz4 mz4Var17 = new mz4();
                        mz4Var17.t = threadData;
                        mz4Var17.position = i;
                        mz4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        mz4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(mz4Var17);
                        if (threadData.getPollData() != null) {
                            mz4 mz4Var18 = new mz4();
                            mz4Var18.o = true;
                            mz4Var18.t = threadData;
                            mz4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            mz4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            mz4 mz4Var19 = new mz4();
                            mz4Var19.l = true;
                            mz4Var19.t = threadData;
                            mz4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            mz4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            mz4 mz4Var20 = new mz4();
                            mz4Var20.h = true;
                            mz4Var20.t = threadData;
                            mz4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            mz4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            mz4 mz4Var21 = new mz4();
                            mz4Var21.n = true;
                            mz4Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            mz4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(mz4Var21);
                        }
                        mz4 mz4Var22 = new mz4();
                        mz4Var22.g = true;
                        mz4Var22.t = threadData;
                        mz4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        mz4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(mz4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        mz4 mz4Var23 = new mz4();
                        mz4Var23.t = threadData;
                        mz4Var23.position = i;
                        arrayList2.add(mz4Var23);
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
