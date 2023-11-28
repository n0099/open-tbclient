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
/* loaded from: classes7.dex */
public class mv7 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCommonTabFragment a;
    public nv7 b;
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
    public s88 o;

    public mv7(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
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
            frsDynamicModel.q0(this);
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
        frsCommonTabNetModel.q0(this);
        this.d.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void I(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        nv7 nv7Var = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof nv7) {
                nv7Var = (nv7) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof ov7) {
                ov7 ov7Var = (ov7) mvcHttpResponsedMessage.getData();
                nv7 nv7Var2 = new nv7();
                ArrayList<pi> arrayList = ov7Var.a;
                nv7Var2.c = arrayList;
                nv7Var2.a = ov7Var.c;
                nv7Var2.b = ov7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<pi> arrayList2 = nv7Var2.c;
                    pi piVar = (pi) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (piVar instanceof ThreadData) {
                        this.f.lastThreadId = JavaTypesHelper.toLong(((ThreadData) piVar).getId(), 0L);
                    }
                }
                nv7Var = nv7Var2;
            }
        }
        if (nv7Var != null && n(nv7Var)) {
            return;
        }
        this.l = mvcHttpResponsedMessage.getError();
        this.m = mvcHttpResponsedMessage.getErrorString();
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.l);
        errorData.setError_msg(this.m);
        if (this.l != 0) {
            this.a.i(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void u(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048596, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        nv7 nv7Var = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof nv7) {
                nv7Var = (nv7) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof ov7) {
                ov7 ov7Var = (ov7) mvcSocketResponsedMessage.getData();
                nv7 nv7Var2 = new nv7();
                ArrayList<pi> arrayList = ov7Var.a;
                nv7Var2.c = arrayList;
                nv7Var2.a = ov7Var.c;
                nv7Var2.b = ov7Var.b;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<pi> arrayList2 = nv7Var2.c;
                    pi piVar = (pi) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (piVar instanceof ThreadData) {
                        this.f.lastThreadId = JavaTypesHelper.toLong(((ThreadData) piVar).getId(), 0L);
                    }
                }
                nv7Var = nv7Var2;
            }
        }
        if (nv7Var != null && n(nv7Var)) {
            return;
        }
        this.l = mvcSocketResponsedMessage.getError();
        this.m = mvcSocketResponsedMessage.getErrorString();
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.l);
        errorData.setError_msg(this.m);
        if (this.l != 0) {
            this.a.i(errorData);
        }
    }

    public void a(ThreadData threadData) {
        nv7 nv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && (nv7Var = this.b) != null && nv7Var.c != null) {
            ArrayList<pi> arrayList = new ArrayList<>();
            arrayList.add(threadData);
            ArrayList<pi> s = s(arrayList);
            if (ListUtils.isEmpty(this.b.c)) {
                this.b.c.addAll(s);
            } else {
                if (this.b.c.size() == 1 && (this.b.c.get(0) instanceof ks7)) {
                    this.b.c.remove(0);
                }
                this.b.c.addAll(0, s);
            }
            this.a.b3(this.b);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.h = true;
            if (!this.e) {
                if (this.d.i0()) {
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
            } else if (this.g.i0()) {
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
            n88.a();
        }
    }

    public final void b(List<pi> list) {
        JSONObject b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || zf9.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (pi piVar : list) {
            if ((piVar instanceof ThreadData) && (b = fja.b(((ThreadData) piVar).getRawThreadInfo())) != null) {
                arrayList.add(b);
            }
        }
        fja.f().h(this.n, arrayList);
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.h = false;
            if (!this.e) {
                if (this.d.i0()) {
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
            } else if (this.g.i0()) {
                return;
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.f.qType = 2;
                } else {
                    this.f.qType = 1;
                }
                this.g.loadData();
            }
            n88.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        int b;
        String d;
        ArrayList<pi> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.h) {
                b = 0;
            } else {
                b = uga.b(this.b.c);
            }
            if (this.h) {
                d = "";
            } else {
                d = fja.f().d(this.n);
            }
            nv7 nv7Var = this.b;
            if (nv7Var == null) {
                arrayList = null;
            } else {
                arrayList = nv7Var.c;
            }
            String e = uga.e(arrayList, this.h);
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
            nv7 nv7Var = this.b;
            if (nv7Var == null) {
                return true;
            }
            return nv7Var.a;
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

    public nv7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (nv7) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            nv7 nv7Var = this.b;
            if (nv7Var != null && !ListUtils.isEmpty(nv7Var.c)) {
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
                return frsCommonTabNetModel.i0();
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

    public final void g(List<App> list, List<pi> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) {
            b(list2);
            uga.i(uga.h(list, "FRS_GENERAL_TAB"), list2, 0);
            uga.a(list2, this.j, "FRS_GENERAL_TAB");
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
        nv7 nv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (nv7Var = this.b) != null && !zf9.e(nv7Var.c)) {
            uga.d(str, this.b.c);
            this.a.b3(this.b);
        }
    }

    public void p(s88 s88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, s88Var) == null) {
            this.o = s88Var;
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

    public final boolean n(nv7 nv7Var) {
        InterceptResult invokeL;
        boolean z;
        s88 s88Var;
        s88 s88Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, nv7Var)) == null) {
            if (nv7Var == null) {
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
                Iterator<pi> it = nv7Var.c.iterator();
                while (it.hasNext()) {
                    pi next = it.next();
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
                int i = nv7Var.l;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (s88.d()) {
                                    s88 s88Var3 = this.o;
                                    if (s88Var3 != null) {
                                        s88Var3.b(nv7Var.c, this.h, this.a.C0());
                                    }
                                } else {
                                    g(nv7Var.k, nv7Var.c);
                                }
                            } else if (!ListUtils.isEmpty(nv7Var.m)) {
                                int intValue = nv7Var.m.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    g(nv7Var.k, nv7Var.c);
                                } else if (intValue == 2 && (s88Var2 = this.o) != null) {
                                    s88Var2.g(nv7Var.c, nv7Var.m, this.h, this.a.C0());
                                }
                            }
                        } else {
                            s88 s88Var4 = this.o;
                            if (s88Var4 != null) {
                                s88Var4.b(nv7Var.c, this.h, this.a.C0());
                            }
                        }
                    } else {
                        g(nv7Var.k, nv7Var.c);
                    }
                }
                this.b = nv7Var;
                nv7Var.c = s(nv7Var.c);
            } else {
                nv7 nv7Var2 = this.b;
                nv7Var2.a = nv7Var.a;
                nv7Var2.b.putAll(nv7Var.b);
                ArrayList<pi> arrayList2 = new ArrayList<>();
                Iterator<pi> it2 = nv7Var.c.iterator();
                while (it2.hasNext()) {
                    pi next2 = it2.next();
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
                int i2 = nv7Var.l;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (s88.d()) {
                                s88 s88Var5 = this.o;
                                if (s88Var5 != null) {
                                    s88Var5.b(nv7Var.c, this.h, this.a.C0());
                                }
                            } else {
                                g(nv7Var.k, nv7Var.c);
                            }
                        } else if (!ListUtils.isEmpty(nv7Var.m)) {
                            int intValue2 = nv7Var.m.get(0).ad_type.intValue();
                            if (intValue2 == 1) {
                                g(nv7Var.k, nv7Var.c);
                            } else if (intValue2 == 2 && (s88Var = this.o) != null) {
                                s88Var.g(nv7Var.c, nv7Var.m, this.h, this.a.C0());
                            }
                        }
                    } else {
                        s88 s88Var6 = this.o;
                        if (s88Var6 != null) {
                            s88Var6.b(nv7Var.c, this.h, this.a.C0());
                        }
                    }
                } else {
                    g(nv7Var.k, nv7Var.c);
                }
                this.b.c.addAll(s(arrayList2));
            }
            this.a.b3(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<pi> s(ArrayList<pi> arrayList) {
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
            ArrayList<pi> arrayList2 = new ArrayList<>();
            Iterator<pi> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                pi next = it.next();
                if (next instanceof vx4) {
                    ((vx4) next).setPosition(i);
                    arrayList2.add(next);
                } else if (next instanceof wx4) {
                    ((wx4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        jz4 jz4Var = new jz4();
                        jz4Var.t = threadData;
                        jz4Var.position = i;
                        jz4Var.a = true;
                        jz4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(jz4Var);
                        jz4 jz4Var2 = new jz4();
                        jz4Var2.t = threadData;
                        jz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            jz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            jz4Var2.d = true;
                            jz4Var2.u = imageWidthAndHeight[0];
                            jz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            jz4Var2.e = true;
                        } else {
                            jz4Var2.b = true;
                        }
                        jz4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jz4Var2);
                        if (threadData.getPollData() != null) {
                            jz4 jz4Var3 = new jz4();
                            jz4Var3.o = true;
                            jz4Var3.t = threadData;
                            jz4Var3.position = i;
                            jz4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            jz4 jz4Var4 = new jz4();
                            jz4Var4.l = true;
                            jz4Var4.t = threadData;
                            jz4Var4.position = i;
                            jz4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            jz4 jz4Var5 = new jz4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                jz4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                jz4Var5.q = true;
                            }
                            jz4Var5.t = threadData;
                            jz4Var5.position = i;
                            jz4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            jz4 jz4Var6 = new jz4();
                            jz4Var6.h = true;
                            jz4Var6.t = threadData;
                            jz4Var6.position = i;
                            jz4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var6);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            jz4 jz4Var7 = new jz4();
                            jz4Var7.n = true;
                            jz4Var7.t = threadData;
                            jz4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var7);
                        }
                        jz4 jz4Var8 = new jz4();
                        jz4Var8.g = true;
                        jz4Var8.t = threadData;
                        jz4Var8.position = i;
                        jz4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jz4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        jz4 jz4Var9 = new jz4();
                        jz4Var9.t = threadData;
                        jz4Var9.position = i;
                        jz4Var9.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jz4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(jz4Var9);
                        jz4 jz4Var10 = new jz4();
                        jz4Var10.t = threadData;
                        jz4Var10.position = i;
                        if (threadData instanceof dy4) {
                            jz4Var10.j = true;
                        } else {
                            jz4Var10.i = true;
                        }
                        jz4Var10.t.isJumpToFrsVideoTabPlay = z2;
                        jz4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jz4Var10);
                        if (threadData.getPollData() != null) {
                            jz4 jz4Var11 = new jz4();
                            jz4Var11.o = true;
                            jz4Var11.t = threadData;
                            jz4Var11.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jz4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            jz4 jz4Var12 = new jz4();
                            jz4Var12.l = true;
                            jz4Var12.t = threadData;
                            jz4Var12.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jz4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            jz4 jz4Var13 = new jz4();
                            jz4Var13.h = true;
                            jz4Var13.t = threadData;
                            jz4Var13.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jz4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var13);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            jz4 jz4Var14 = new jz4();
                            jz4Var14.n = true;
                            jz4Var14.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jz4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var14);
                        }
                        jz4 jz4Var15 = new jz4();
                        jz4Var15.g = true;
                        jz4Var15.t = threadData;
                        jz4Var15.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jz4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jz4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        jz4 jz4Var16 = new jz4();
                        jz4Var16.t = threadData;
                        jz4Var16.position = i;
                        jz4Var16.a = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jz4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(jz4Var16);
                        jz4 jz4Var17 = new jz4();
                        jz4Var17.t = threadData;
                        jz4Var17.position = i;
                        jz4Var17.k = true;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jz4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(jz4Var17);
                        if (threadData.getPollData() != null) {
                            jz4 jz4Var18 = new jz4();
                            jz4Var18.o = true;
                            jz4Var18.t = threadData;
                            jz4Var18.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jz4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            jz4 jz4Var19 = new jz4();
                            jz4Var19.l = true;
                            jz4Var19.t = threadData;
                            jz4Var19.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jz4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            jz4 jz4Var20 = new jz4();
                            jz4Var20.h = true;
                            jz4Var20.t = threadData;
                            jz4Var20.position = i;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jz4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var20);
                        }
                        if (!z && threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            jz4 jz4Var21 = new jz4();
                            jz4Var21.n = true;
                            jz4Var21.t = threadData;
                            threadData.isJumpToFrsVideoTabPlay = z2;
                            jz4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(jz4Var21);
                        }
                        jz4 jz4Var22 = new jz4();
                        jz4Var22.g = true;
                        jz4Var22.t = threadData;
                        jz4Var22.position = i;
                        threadData.isJumpToFrsVideoTabPlay = z2;
                        jz4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(jz4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        jz4 jz4Var23 = new jz4();
                        jz4Var23.t = threadData;
                        jz4Var23.position = i;
                        arrayList2.add(jz4Var23);
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
