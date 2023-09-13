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
public class rj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;
    public tha b;
    public ArrayList<tha> c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public AntiData i;
    public ThreadData j;
    public boolean k;
    public Error l;

    public rj9() {
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

    public static rj9 r(DataRes dataRes) {
        InterceptResult invokeL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dataRes)) == null) {
            if (dataRes == null) {
                return null;
            }
            try {
                rj9 rj9Var = new rj9();
                AntiData antiData = new AntiData();
                antiData.parserProtobuf(dataRes.anti);
                rj9Var.s(antiData);
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(dataRes.thread);
                rj9Var.z(threadData);
                ForumData forumData = new ForumData();
                forumData.parserProtobuf(dataRes.forum);
                rj9Var.v(forumData);
                tha thaVar = new tha();
                thaVar.Z0(forumData.isBrandForum);
                thaVar.K0(dataRes.post, threadData);
                rj9Var.x(thaVar);
                List<SubPostList> list = dataRes.subpost_list;
                int size = list.size();
                ArrayList<tha> arrayList = new ArrayList<>();
                int L = thaVar.L();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    tha thaVar2 = new tha();
                    thaVar2.Z0(forumData.isBrandForum);
                    thaVar2.I0(list.get(i), false, threadData, L);
                    if (thaVar2.p() != null && thaVar2.p().baijiahaoData == null && threadData.getBaijiahaoData() != null) {
                        thaVar2.p().baijiahaoData = threadData.getBaijiahaoData();
                    }
                    arrayList.add(thaVar2);
                }
                rj9Var.y(arrayList);
                AntiData antiData2 = new AntiData();
                antiData2.parserProtobuf(dataRes.anti);
                rj9Var.s(antiData2);
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
                    rj9Var.u(intValue3);
                    rj9Var.w(intValue);
                    rj9Var.A(intValue4);
                    rj9Var.B(intValue2);
                }
                if (dataRes.is_black_white.intValue() == 1) {
                    z = true;
                }
                rj9Var.t(z);
                return rj9Var;
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (rj9) invokeL.objValue;
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

    public void x(tha thaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, thaVar) == null) {
            this.b = thaVar;
        }
    }

    public void y(ArrayList<tha> arrayList) {
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

    public tha g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (tha) invokeV.objValue;
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

    public ArrayList<tha> i() {
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

    public void p(rj9 rj9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048593, this, rj9Var, z) != null) || rj9Var == null) {
            return;
        }
        s(rj9Var.a());
        v(rj9Var.d());
        x(rj9Var.g());
        z(rj9Var.j());
        t(rj9Var.o());
        if (rj9Var.i() != null) {
            u(rj9Var.b());
            w(rj9Var.f());
            A(rj9Var.k());
            B(rj9Var.l());
        }
        int size = this.c.size();
        if (z && size % this.f != 0) {
            for (int i = 0; i < size % this.f; i++) {
                ArrayList<tha> arrayList = this.c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.c.addAll(rj9Var.i());
    }

    public void q(rj9 rj9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048594, this, rj9Var, z) != null) || rj9Var == null) {
            return;
        }
        s(rj9Var.a());
        this.h = rj9Var.b();
        v(rj9Var.d());
        w(rj9Var.f());
        z(rj9Var.j());
        A(rj9Var.k());
        B(rj9Var.l());
        t(rj9Var.o());
        this.c.addAll(0, rj9Var.i());
    }
}
