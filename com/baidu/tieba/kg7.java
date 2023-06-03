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
public class kg7 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public lg7 b;
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
    public xs7 o;

    public kg7(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicRequestData.scrH = vi.j(TbadkCoreApplication.getInst());
            this.f.scrW = vi.l(TbadkCoreApplication.getInst());
            this.f.scrDip = vi.i(TbadkCoreApplication.getInst());
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
        lg7 lg7Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof lg7) {
                lg7Var = (lg7) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof mg7) {
                mg7 mg7Var = (mg7) mvcHttpResponsedMessage.getData();
                lg7 lg7Var2 = new lg7();
                ArrayList<vn> arrayList = mg7Var.a;
                lg7Var2.c = arrayList;
                lg7Var2.a = mg7Var.c;
                lg7Var2.b = mg7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<vn> arrayList2 = lg7Var2.c;
                    vn vnVar = (vn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (vnVar instanceof ThreadData) {
                        this.f.lastThreadId = tg.g(((ThreadData) vnVar).getId(), 0L);
                    }
                }
                lg7Var = lg7Var2;
            }
        }
        if (lg7Var != null && n(lg7Var)) {
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
        lg7 lg7Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof lg7) {
                lg7Var = (lg7) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof mg7) {
                mg7 mg7Var = (mg7) mvcSocketResponsedMessage.getData();
                lg7 lg7Var2 = new lg7();
                ArrayList<vn> arrayList = mg7Var.a;
                lg7Var2.c = arrayList;
                lg7Var2.a = mg7Var.c;
                lg7Var2.b = mg7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<vn> arrayList2 = lg7Var2.c;
                    vn vnVar = (vn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (vnVar instanceof ThreadData) {
                        this.f.lastThreadId = tg.g(((ThreadData) vnVar).getId(), 0L);
                    }
                }
                lg7Var = lg7Var2;
            }
        }
        if (lg7Var != null && n(lg7Var)) {
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
        lg7 lg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && (lg7Var = this.b) != null && lg7Var.c != null) {
            ArrayList<vn> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<vn> s = s(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(s);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof od7)) {
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
            ss7.a();
        }
    }

    public final void b(List<vn> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || vo8.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (vn vnVar : list) {
            if ((vnVar instanceof ThreadData) && (b = rn9.b(((ThreadData) vnVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        rn9.f().h(this.n, arrayList);
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
            ss7.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<vn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = hl9.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = rn9.f().d(this.n);
            }
            lg7 lg7Var = this.b;
            if (lg7Var == null) {
                arrayList = null;
            } else {
                arrayList = lg7Var.c;
            }
            String e = hl9.e(arrayList, this.h);
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
            lg7 lg7Var = this.b;
            if (lg7Var == null) {
                return true;
            }
            return lg7Var.a;
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

    public lg7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (lg7) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            lg7 lg7Var = this.b;
            if (lg7Var != null && !ListUtils.isEmpty(lg7Var.c)) {
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

    public final void g(List<App> list, List<vn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) {
            b(list2);
            hl9.i(hl9.h(list, "FRS_GENERAL_TAB"), list2, 0);
            hl9.a(list2, this.j, "FRS_GENERAL_TAB");
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
        lg7 lg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (lg7Var = this.b) != null && !vo8.e(lg7Var.c)) {
            hl9.d(str, this.b.c);
            this.a.c2(this.b);
        }
    }

    public void p(xs7 xs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, xs7Var) == null) {
            this.o = xs7Var;
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

    public final boolean n(lg7 lg7Var) {
        InterceptResult invokeL;
        boolean z;
        xs7 xs7Var;
        xs7 xs7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, lg7Var)) == null) {
            if (lg7Var == null) {
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
                Iterator<vn> it = lg7Var.c.iterator();
                while (it.hasNext()) {
                    vn next = it.next();
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
                int i = lg7Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (xs7.d()) {
                                    xs7 xs7Var3 = this.o;
                                    if (xs7Var3 != null) {
                                        xs7Var3.b(lg7Var.c, this.h, this.a.a0());
                                    }
                                } else {
                                    g(lg7Var.k, lg7Var.c);
                                }
                            } else if (!ListUtils.isEmpty(lg7Var.m)) {
                                int intValue = lg7Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(lg7Var.k, lg7Var.c);
                                } else if (intValue == 2 && (xs7Var2 = this.o) != null) {
                                    xs7Var2.g(lg7Var.c, lg7Var.m, this.h, this.a.a0());
                                }
                            }
                        } else {
                            xs7 xs7Var4 = this.o;
                            if (xs7Var4 != null) {
                                xs7Var4.b(lg7Var.c, this.h, this.a.a0());
                            }
                        }
                    } else {
                        g(lg7Var.k, lg7Var.c);
                    }
                }
                this.b = lg7Var;
                lg7Var.c = s(lg7Var.c);
            } else {
                lg7 lg7Var2 = this.b;
                lg7Var2.a = lg7Var.a;
                lg7Var2.b.putAll(lg7Var.b);
                ArrayList<vn> arrayList2 = new ArrayList<>();
                Iterator<vn> it2 = lg7Var.c.iterator();
                while (it2.hasNext()) {
                    vn next2 = it2.next();
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
                int i2 = lg7Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (xs7.d()) {
                                xs7 xs7Var5 = this.o;
                                if (xs7Var5 != null) {
                                    xs7Var5.b(lg7Var.c, this.h, this.a.a0());
                                }
                            } else {
                                g(lg7Var.k, lg7Var.c);
                            }
                        } else if (!ListUtils.isEmpty(lg7Var.m)) {
                            int intValue2 = lg7Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(lg7Var.k, lg7Var.c);
                            } else if (intValue2 == 2 && (xs7Var = this.o) != null) {
                                xs7Var.g(lg7Var.c, lg7Var.m, this.h, this.a.a0());
                            }
                        }
                    } else {
                        xs7 xs7Var6 = this.o;
                        if (xs7Var6 != null) {
                            xs7Var6.b(lg7Var.c, this.h, this.a.a0());
                        }
                    }
                } else {
                    g(lg7Var.k, lg7Var.c);
                }
                this.b.c.addAll(s(arrayList2));
            }
            this.a.c2(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<vn> s(ArrayList<vn> arrayList) {
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
            ArrayList<vn> arrayList2 = new ArrayList<>();
            Iterator<vn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                vn next = it.next();
                if (next instanceof w25) {
                    ((w25) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof x25) {
                    ((x25) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        l45 l45Var = new l45();
                        l45Var.t = threadData;
                        l45Var.position = i;
                        l45Var.a = true;
                        l45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(l45Var);
                        l45 l45Var2 = new l45();
                        l45Var2.t = threadData;
                        l45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            l45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            l45Var2.d = true;
                            l45Var2.u = imageWidthAndHeight[0];
                            l45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            l45Var2.e = true;
                        } else {
                            l45Var2.b = true;
                        }
                        l45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(l45Var2);
                        if (threadData.getPollData() != null) {
                            l45 l45Var3 = new l45();
                            l45Var3.o = true;
                            l45Var3.t = threadData;
                            l45Var3.position = i;
                            l45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            l45 l45Var4 = new l45();
                            l45Var4.l = true;
                            l45Var4.t = threadData;
                            l45Var4.position = i;
                            l45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            l45 l45Var5 = new l45();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                l45Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                l45Var5.q = true;
                            }
                            l45Var5.t = threadData;
                            l45Var5.position = i;
                            l45Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            l45 l45Var6 = new l45();
                            l45Var6.h = true;
                            l45Var6.t = threadData;
                            l45Var6.position = i;
                            l45Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            l45 l45Var7 = new l45();
                            l45Var7.n = true;
                            l45Var7.t = threadData;
                            l45Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var7);
                        }
                        l45 l45Var8 = new l45();
                        l45Var8.g = true;
                        l45Var8.t = threadData;
                        l45Var8.position = i;
                        l45Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(l45Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        l45 l45Var9 = new l45();
                        l45Var9.t = threadData;
                        l45Var9.position = i;
                        l45Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        l45Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(l45Var9);
                        l45 l45Var10 = new l45();
                        l45Var10.t = threadData;
                        l45Var10.position = i;
                        if (threadData instanceof f35) {
                            l45Var10.j = true;
                        } else {
                            l45Var10.i = true;
                        }
                        l45Var10.t.isJumpToFrsVideoTabPlay = z2;
                        l45Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(l45Var10);
                        if (threadData.getPollData() != null) {
                            l45 l45Var11 = new l45();
                            l45Var11.o = true;
                            l45Var11.t = threadData;
                            l45Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            l45Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            l45 l45Var12 = new l45();
                            l45Var12.l = true;
                            l45Var12.t = threadData;
                            l45Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            l45Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            l45 l45Var13 = new l45();
                            l45Var13.h = true;
                            l45Var13.t = threadData;
                            l45Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            l45Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            l45 l45Var14 = new l45();
                            l45Var14.n = true;
                            l45Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            l45Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var14);
                        }
                        l45 l45Var15 = new l45();
                        l45Var15.g = true;
                        l45Var15.t = threadData;
                        l45Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        l45Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(l45Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        l45 l45Var16 = new l45();
                        l45Var16.t = threadData;
                        l45Var16.position = i;
                        l45Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        l45Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(l45Var16);
                        l45 l45Var17 = new l45();
                        l45Var17.t = threadData;
                        l45Var17.position = i;
                        l45Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        l45Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(l45Var17);
                        if (threadData.getPollData() != null) {
                            l45 l45Var18 = new l45();
                            l45Var18.o = true;
                            l45Var18.t = threadData;
                            l45Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            l45Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            l45 l45Var19 = new l45();
                            l45Var19.l = true;
                            l45Var19.t = threadData;
                            l45Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            l45Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            l45 l45Var20 = new l45();
                            l45Var20.h = true;
                            l45Var20.t = threadData;
                            l45Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            l45Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            l45 l45Var21 = new l45();
                            l45Var21.n = true;
                            l45Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            l45Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(l45Var21);
                        }
                        l45 l45Var22 = new l45();
                        l45Var22.g = true;
                        l45Var22.t = threadData;
                        l45Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        l45Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(l45Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        l45 l45Var23 = new l45();
                        l45Var23.t = threadData;
                        l45Var23.position = i;
                        arrayList2.add(l45Var23);
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
