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
public class pw9 implements vv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;
    public mwa b;
    public ArrayList<mwa> c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public AntiData i;
    public ThreadData j;
    public boolean k;
    public Error l;

    public pw9() {
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

    public static pw9 r(DataRes dataRes) {
        InterceptResult invokeL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dataRes)) == null) {
            if (dataRes == null) {
                return null;
            }
            try {
                pw9 pw9Var = new pw9();
                AntiData antiData = new AntiData();
                antiData.parserProtobuf(dataRes.anti);
                pw9Var.s(antiData);
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(dataRes.thread);
                pw9Var.z(threadData);
                ForumData forumData = new ForumData();
                forumData.parserProtobuf(dataRes.forum);
                pw9Var.v(forumData);
                mwa mwaVar = new mwa();
                mwaVar.c1(forumData.isBrandForum);
                mwaVar.O0(dataRes.post, threadData);
                pw9Var.x(mwaVar);
                List<SubPostList> list = dataRes.subpost_list;
                int size = list.size();
                ArrayList<mwa> arrayList = new ArrayList<>();
                int L = mwaVar.L();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    mwa mwaVar2 = new mwa();
                    mwaVar2.c1(forumData.isBrandForum);
                    mwaVar2.M0(list.get(i), false, threadData, L);
                    if (mwaVar2.p() != null && mwaVar2.p().baijiahaoData == null && threadData.getBaijiahaoData() != null) {
                        mwaVar2.p().baijiahaoData = threadData.getBaijiahaoData();
                    }
                    arrayList.add(mwaVar2);
                }
                pw9Var.y(arrayList);
                AntiData antiData2 = new AntiData();
                antiData2.parserProtobuf(dataRes.anti);
                pw9Var.s(antiData2);
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
                    pw9Var.u(intValue3);
                    pw9Var.w(intValue);
                    pw9Var.A(intValue4);
                    pw9Var.B(intValue2);
                }
                if (dataRes.is_black_white.intValue() == 1) {
                    z = true;
                }
                pw9Var.t(z);
                return pw9Var;
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (pw9) invokeL.objValue;
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

    public void x(mwa mwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, mwaVar) == null) {
            this.b = mwaVar;
        }
    }

    public void y(ArrayList<mwa> arrayList) {
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

    @Override // com.baidu.tieba.vv9
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ThreadData threadData = this.j;
            if (threadData != null && threadData.isUgcThreadType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vv9
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public AntiData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (AntiData) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public Error e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.l;
        }
        return (Error) invokeV.objValue;
    }

    public ForumData f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (ForumData) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public mwa i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return (mwa) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.h == -1) {
                this.h = this.g;
            }
            return this.h;
        }
        return invokeV.intValue;
    }

    public ArrayList<mwa> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ThreadData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.j;
        }
        return (ThreadData) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.g < this.d) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ThreadData threadData = this.j;
            if (threadData != null && this.b != null && threadData.getAuthor() != null && this.j.getAuthor().getUserId() != null && this.b.u() != null && this.b.u().getUserId() != null) {
                return this.j.getAuthor().getUserId().equals(this.b.u().getUserId());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void p(pw9 pw9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048593, this, pw9Var, z) != null) || pw9Var == null) {
            return;
        }
        s(pw9Var.c());
        v(pw9Var.f());
        x(pw9Var.i());
        z(pw9Var.l());
        t(pw9Var.b());
        if (pw9Var.k() != null) {
            u(pw9Var.d());
            w(pw9Var.h());
            A(pw9Var.m());
            B(pw9Var.n());
        }
        int size = this.c.size();
        if (z && size % this.f != 0) {
            for (int i = 0; i < size % this.f; i++) {
                ArrayList<mwa> arrayList = this.c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.c.addAll(pw9Var.k());
    }

    public void q(pw9 pw9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048594, this, pw9Var, z) != null) || pw9Var == null) {
            return;
        }
        s(pw9Var.c());
        this.h = pw9Var.d();
        v(pw9Var.f());
        w(pw9Var.h());
        z(pw9Var.l());
        A(pw9Var.m());
        B(pw9Var.n());
        t(pw9Var.b());
        this.c.addAll(0, pw9Var.k());
    }
}
