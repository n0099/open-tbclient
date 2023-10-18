package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes7.dex */
public class pf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;
    public pea b;
    public ArrayList<pea> c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public AntiData i;
    public ThreadData j;
    public boolean k;
    public Error l;

    public pf9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 20;
        this.h = -1;
        this.b = null;
        this.c = new ArrayList<>();
        this.d = 1;
    }

    public static pf9 r(DataRes dataRes) {
        InterceptResult invokeL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dataRes)) == null) {
            if (dataRes == null) {
                return null;
            }
            try {
                pf9 pf9Var = new pf9();
                AntiData antiData = new AntiData();
                antiData.parserProtobuf(dataRes.anti);
                pf9Var.s(antiData);
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(dataRes.thread);
                pf9Var.z(threadData);
                ForumData forumData = new ForumData();
                forumData.parserProtobuf(dataRes.forum);
                pf9Var.v(forumData);
                pea peaVar = new pea();
                peaVar.Z0(forumData.isBrandForum);
                peaVar.K0(dataRes.post, threadData);
                pf9Var.x(peaVar);
                List<SubPostList> list = dataRes.subpost_list;
                int size = list.size();
                ArrayList<pea> arrayList = new ArrayList<>();
                int L = peaVar.L();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    pea peaVar2 = new pea();
                    peaVar2.Z0(forumData.isBrandForum);
                    peaVar2.I0(list.get(i), false, threadData, L);
                    if (peaVar2.p() != null && peaVar2.p().baijiahaoData == null && threadData.getBaijiahaoData() != null) {
                        peaVar2.p().baijiahaoData = threadData.getBaijiahaoData();
                    }
                    arrayList.add(peaVar2);
                }
                pf9Var.y(arrayList);
                AntiData antiData2 = new AntiData();
                antiData2.parserProtobuf(dataRes.anti);
                pf9Var.s(antiData2);
                Page page = dataRes.page;
                if (page != null) {
                    int intValue2 = page.total_page.intValue();
                    if (page.page_size.intValue() == 0) {
                        intValue = 20;
                    } else {
                        intValue = page.page_size.intValue();
                    }
                    int intValue3 = page.current_page.intValue();
                    int intValue4 = page.total_count.intValue();
                    pf9Var.u(intValue3);
                    pf9Var.w(intValue);
                    pf9Var.A(intValue4);
                    pf9Var.B(intValue2);
                }
                if (dataRes.is_black_white.intValue() == 1) {
                    z = true;
                }
                pf9Var.t(z);
                return pf9Var;
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (pf9) invokeL.objValue;
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.e = i;
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.d = i;
        }
    }

    public void s(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, antiData) == null) {
            this.i = antiData;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.k = z;
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.g = i;
        }
    }

    public void v(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, forumData) == null) {
            this.a = forumData;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i) == null) && i != 0) {
            this.f = i;
        }
    }

    public void x(pea peaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, peaVar) == null) {
            this.b = peaVar;
        }
    }

    public void y(ArrayList<pea> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, arrayList) == null) {
            this.c = arrayList;
        }
    }

    public void z(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, threadData) == null) {
            this.j = threadData;
        }
    }

    public AntiData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (AntiData) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public Error c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.l;
        }
        return (Error) invokeV.objValue;
    }

    public ForumData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (ForumData) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public pea g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (pea) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.h == -1) {
                this.h = this.g;
            }
            return this.h;
        }
        return invokeV.intValue;
    }

    public ArrayList<pea> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ThreadData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.j;
        }
        return (ThreadData) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.g < this.d) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ThreadData threadData = this.j;
            if (threadData != null && threadData.isUgcThreadType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ThreadData threadData = this.j;
            if (threadData != null && this.b != null && threadData.getAuthor() != null && this.j.getAuthor().getUserId() != null && this.b.t() != null && this.b.t().getUserId() != null) {
                return this.j.getAuthor().getUserId().equals(this.b.t().getUserId());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void p(pf9 pf9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048593, this, pf9Var, z) != null) || pf9Var == null) {
            return;
        }
        s(pf9Var.a());
        v(pf9Var.d());
        x(pf9Var.g());
        z(pf9Var.j());
        t(pf9Var.o());
        if (pf9Var.i() != null) {
            u(pf9Var.b());
            w(pf9Var.f());
            A(pf9Var.k());
            B(pf9Var.l());
        }
        int size = this.c.size();
        if (z && size % this.f != 0) {
            for (int i = 0; i < size % this.f; i++) {
                ArrayList<pea> arrayList = this.c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.c.addAll(pf9Var.i());
    }

    public void q(pf9 pf9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048594, this, pf9Var, z) != null) || pf9Var == null) {
            return;
        }
        s(pf9Var.a());
        this.h = pf9Var.b();
        v(pf9Var.d());
        w(pf9Var.f());
        z(pf9Var.j());
        A(pf9Var.k());
        B(pf9Var.l());
        t(pf9Var.o());
        this.c.addAll(0, pf9Var.i());
    }
}
