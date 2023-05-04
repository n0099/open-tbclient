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
public class t97 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public u97 b;
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
    public gm7 o;

    public t97(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = ii.j(TbadkCoreApplication.getInst());
            this.f.scrW = ii.l(TbadkCoreApplication.getInst());
            this.f.scrDip = ii.i(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.f);
            this.g = frsDynamicModel;
            frsDynamicModel.x0(this);
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
        frsCommonTabNetModel.x0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void A(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        u97 u97Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof u97) {
                u97Var = (u97) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof v97) {
                v97 v97Var = (v97) mvcSocketResponsedMessage.getData();
                u97 u97Var2 = new u97();
                ArrayList<in> arrayList = v97Var.a;
                u97Var2.c = arrayList;
                u97Var2.a = v97Var.c;
                u97Var2.b = v97Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<in> arrayList2 = u97Var2.c;
                    in inVar = (in) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (inVar instanceof ThreadData) {
                        this.f.lastThreadId = gg.g(((ThreadData) inVar).getId(), 0L);
                    }
                }
                u97Var = u97Var2;
            }
        }
        if (u97Var != null && m(u97Var)) {
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
    public void M(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        u97 u97Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof u97) {
                u97Var = (u97) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof v97) {
                v97 v97Var = (v97) mvcHttpResponsedMessage.getData();
                u97 u97Var2 = new u97();
                ArrayList<in> arrayList = v97Var.a;
                u97Var2.c = arrayList;
                u97Var2.a = v97Var.c;
                u97Var2.b = v97Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<in> arrayList2 = u97Var2.c;
                    in inVar = (in) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (inVar instanceof ThreadData) {
                        this.f.lastThreadId = gg.g(((ThreadData) inVar).getId(), 0L);
                    }
                }
                u97Var = u97Var2;
            }
        }
        if (u97Var != null && m(u97Var)) {
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

    public void a(ThreadData threadData) {
        u97 u97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) && threadData != null && (u97Var = this.b) != null && u97Var.c != null) {
            ArrayList<in> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<in> r = r(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(r);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof x67)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, r);
            }
            this.a.a2(this.b);
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.p0()) {
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
            } else if (this.g.p0()) {
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
            bm7.a();
        }
    }

    public final void b(List<in> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, list) != null) || ch8.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (in inVar : list) {
            if ((inVar instanceof ThreadData) && (b = nf9.b(((ThreadData) inVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        nf9.f().h(this.n, arrayList);
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.p0()) {
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
            } else if (this.g.p0()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            bm7.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<in> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = dd9.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = nf9.f().d(this.n);
            }
            u97 u97Var = this.b;
            if (u97Var == null) {
                arrayList = null;
            } else {
                arrayList = u97Var.c;
            }
            String e = dd9.e(arrayList, this.h);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            u97 u97Var = this.b;
            if (u97Var == null) {
                return true;
            }
            return u97Var.a;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public u97 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (u97) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            u97 u97Var = this.b;
            if (u97Var != null && !ListUtils.isEmpty(u97Var.c)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final void g(List<App> list, List<in> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2) == null) {
            b(list2);
            dd9.i(dd9.h(list, "FRS_GENERAL_TAB"), list2, 0);
            dd9.a(list2, this.j, "FRS_GENERAL_TAB");
        }
    }

    public final boolean i(int i) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.a;
            if (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.d) == null || frsViewData.mHeadLineDefaultNavTabId != i) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void l(String str) {
        u97 u97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (u97Var = this.b) != null && !ch8.e(u97Var.c)) {
            dd9.d(str, this.b.c);
            this.a.a2(this.b);
        }
    }

    public void o(gm7 gm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gm7Var) == null) {
            this.o = gm7Var;
        }
    }

    public void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.k = j;
        }
    }

    public void q(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (frsCommonTabRequestData = this.c) != null) {
            frsCommonTabRequestData.tabType = i;
        }
    }

    public final boolean m(u97 u97Var) {
        InterceptResult invokeL;
        boolean z;
        gm7 gm7Var;
        gm7 gm7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, u97Var)) == null) {
            if (u97Var == null) {
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
                Iterator<in> it = u97Var.c.iterator();
                while (it.hasNext()) {
                    in next = it.next();
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
                int i = u97Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (gm7.d()) {
                                    gm7 gm7Var3 = this.o;
                                    if (gm7Var3 != null) {
                                        gm7Var3.b(u97Var.c, this.h, this.a.V());
                                    }
                                } else {
                                    g(u97Var.k, u97Var.c);
                                }
                            } else if (!ListUtils.isEmpty(u97Var.m)) {
                                int intValue = u97Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(u97Var.k, u97Var.c);
                                } else if (intValue == 2 && (gm7Var2 = this.o) != null) {
                                    gm7Var2.g(u97Var.c, u97Var.m, this.h, this.a.V());
                                }
                            }
                        } else {
                            gm7 gm7Var4 = this.o;
                            if (gm7Var4 != null) {
                                gm7Var4.b(u97Var.c, this.h, this.a.V());
                            }
                        }
                    } else {
                        g(u97Var.k, u97Var.c);
                    }
                }
                this.b = u97Var;
                u97Var.c = r(u97Var.c);
            } else {
                u97 u97Var2 = this.b;
                u97Var2.a = u97Var.a;
                u97Var2.b.putAll(u97Var.b);
                ArrayList<in> arrayList2 = new ArrayList<>();
                Iterator<in> it2 = u97Var.c.iterator();
                while (it2.hasNext()) {
                    in next2 = it2.next();
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
                int i2 = u97Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (gm7.d()) {
                                gm7 gm7Var5 = this.o;
                                if (gm7Var5 != null) {
                                    gm7Var5.b(u97Var.c, this.h, this.a.V());
                                }
                            } else {
                                g(u97Var.k, u97Var.c);
                            }
                        } else if (!ListUtils.isEmpty(u97Var.m)) {
                            int intValue2 = u97Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(u97Var.k, u97Var.c);
                            } else if (intValue2 == 2 && (gm7Var = this.o) != null) {
                                gm7Var.g(u97Var.c, u97Var.m, this.h, this.a.V());
                            }
                        }
                    } else {
                        gm7 gm7Var6 = this.o;
                        if (gm7Var6 != null) {
                            gm7Var6.b(u97Var.c, this.h, this.a.V());
                        }
                    }
                } else {
                    g(u97Var.k, u97Var.c);
                }
                this.b.c.addAll(r(arrayList2));
            }
            this.a.a2(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<in> r(ArrayList<in> arrayList) {
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
            ArrayList<in> arrayList2 = new ArrayList<>();
            Iterator<in> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                in next = it.next();
                if (next instanceof qy4) {
                    ((qy4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof ry4) {
                    ((ry4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        f05 f05Var = new f05();
                        f05Var.t = threadData;
                        f05Var.position = i;
                        f05Var.a = true;
                        f05Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(f05Var);
                        f05 f05Var2 = new f05();
                        f05Var2.t = threadData;
                        f05Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            f05Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            f05Var2.d = true;
                            f05Var2.u = imageWidthAndHeight[0];
                            f05Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            f05Var2.e = true;
                        } else {
                            f05Var2.b = true;
                        }
                        f05Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(f05Var2);
                        if (threadData.getPollData() != null) {
                            f05 f05Var3 = new f05();
                            f05Var3.o = true;
                            f05Var3.t = threadData;
                            f05Var3.position = i;
                            f05Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            f05 f05Var4 = new f05();
                            f05Var4.l = true;
                            f05Var4.t = threadData;
                            f05Var4.position = i;
                            f05Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            f05 f05Var5 = new f05();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                f05Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                f05Var5.q = true;
                            }
                            f05Var5.t = threadData;
                            f05Var5.position = i;
                            f05Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            f05 f05Var6 = new f05();
                            f05Var6.h = true;
                            f05Var6.t = threadData;
                            f05Var6.position = i;
                            f05Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            f05 f05Var7 = new f05();
                            f05Var7.n = true;
                            f05Var7.t = threadData;
                            f05Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var7);
                        }
                        f05 f05Var8 = new f05();
                        f05Var8.g = true;
                        f05Var8.t = threadData;
                        f05Var8.position = i;
                        f05Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(f05Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        f05 f05Var9 = new f05();
                        f05Var9.t = threadData;
                        f05Var9.position = i;
                        f05Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        f05Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(f05Var9);
                        f05 f05Var10 = new f05();
                        f05Var10.t = threadData;
                        f05Var10.position = i;
                        if (threadData instanceof zy4) {
                            f05Var10.j = true;
                        } else {
                            f05Var10.i = true;
                        }
                        f05Var10.t.isJumpToFrsVideoTabPlay = z2;
                        f05Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(f05Var10);
                        if (threadData.getPollData() != null) {
                            f05 f05Var11 = new f05();
                            f05Var11.o = true;
                            f05Var11.t = threadData;
                            f05Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            f05Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            f05 f05Var12 = new f05();
                            f05Var12.l = true;
                            f05Var12.t = threadData;
                            f05Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            f05Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            f05 f05Var13 = new f05();
                            f05Var13.h = true;
                            f05Var13.t = threadData;
                            f05Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            f05Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            f05 f05Var14 = new f05();
                            f05Var14.n = true;
                            f05Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            f05Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var14);
                        }
                        f05 f05Var15 = new f05();
                        f05Var15.g = true;
                        f05Var15.t = threadData;
                        f05Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        f05Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(f05Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        f05 f05Var16 = new f05();
                        f05Var16.t = threadData;
                        f05Var16.position = i;
                        f05Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        f05Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(f05Var16);
                        f05 f05Var17 = new f05();
                        f05Var17.t = threadData;
                        f05Var17.position = i;
                        f05Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        f05Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(f05Var17);
                        if (threadData.getPollData() != null) {
                            f05 f05Var18 = new f05();
                            f05Var18.o = true;
                            f05Var18.t = threadData;
                            f05Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            f05Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            f05 f05Var19 = new f05();
                            f05Var19.l = true;
                            f05Var19.t = threadData;
                            f05Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            f05Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            f05 f05Var20 = new f05();
                            f05Var20.h = true;
                            f05Var20.t = threadData;
                            f05Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            f05Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            f05 f05Var21 = new f05();
                            f05Var21.n = true;
                            f05Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            f05Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(f05Var21);
                        }
                        f05 f05Var22 = new f05();
                        f05Var22.g = true;
                        f05Var22.t = threadData;
                        f05Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        f05Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(f05Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        f05 f05Var23 = new f05();
                        f05Var23.t = threadData;
                        f05Var23.position = i;
                        arrayList2.add(f05Var23);
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
