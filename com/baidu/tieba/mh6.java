package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class mh6 extends eh6 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId A0;
    public static final BdUniqueId B0;
    public static final BdUniqueId C0;
    public static final BdUniqueId D0;
    public static final BdUniqueId E0;
    public static final BdUniqueId F0;
    public static final BdUniqueId G0;
    public static final BdUniqueId H0;
    public static final BdUniqueId I0;
    public static final BdUniqueId J0;
    public static final BdUniqueId K0;
    public static final BdUniqueId L0;
    public static final BdUniqueId M0;
    public static final BdUniqueId N0;
    public static final BdUniqueId O0;
    public static final BdUniqueId P0;
    public static String S = "";
    public static String T = "";
    public static String U = "";
    public static String V = "";
    public static String W = "";
    public static String X = "";
    public static String Y = "";
    public static String Z = "";
    public static String a0 = "";
    public static String b0 = "";
    public static String c0 = "";
    public static String d0 = "";
    public static String e0 = "";
    public static String f0 = "";
    public static String g0 = "";
    public static String h0 = "";
    public static String i0 = "";
    public static final BdUniqueId j0;
    public static final BdUniqueId r0;
    public static final BdUniqueId s0;
    public static final BdUniqueId t0;
    public static final BdUniqueId u0;
    public static final BdUniqueId v0;
    public static final BdUniqueId w0;
    public static final BdUniqueId x0;
    public static final BdUniqueId y0;
    public static final BdUniqueId z0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean R;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947972718, "Lcom/baidu/tieba/mh6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947972718, "Lcom/baidu/tieba/mh6;");
                return;
            }
        }
        j0 = BdUniqueId.gen();
        r0 = BdUniqueId.gen();
        s0 = BdUniqueId.gen();
        t0 = BdUniqueId.gen();
        u0 = BdUniqueId.gen();
        v0 = BdUniqueId.gen();
        w0 = BdUniqueId.gen();
        x0 = BdUniqueId.gen();
        y0 = BdUniqueId.gen();
        z0 = BdUniqueId.gen();
        A0 = BdUniqueId.gen();
        B0 = BdUniqueId.gen();
        C0 = BdUniqueId.gen();
        D0 = BdUniqueId.gen();
        E0 = BdUniqueId.gen();
        F0 = BdUniqueId.gen();
        G0 = BdUniqueId.gen();
        H0 = BdUniqueId.gen();
        I0 = BdUniqueId.gen();
        J0 = BdUniqueId.gen();
        K0 = BdUniqueId.gen();
        L0 = BdUniqueId.gen();
        M0 = BdUniqueId.gen();
        N0 = BdUniqueId.gen();
        O0 = BdUniqueId.gen();
        P0 = BdUniqueId.gen();
    }

    @Override // com.baidu.tieba.eh6
    public StatisticItem f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (V()) {
                return l(Z);
            }
            if (nh6.R(this.a)) {
                StatisticItem o = o(h0, true);
                if (o != null && getThreadData() != null) {
                    ThreadData threadData = getThreadData();
                    if (threadData.getBaijiahaoData() != null) {
                        o.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                        o.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                    }
                    o.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
                }
                return o;
            }
            StatisticItem m = m(U, 0);
            if (m != null) {
                m.param("ab_tag", c()).param(TiebaStatic.Params.AB_ACTION, "click");
                if (getThreadData() != null) {
                    ThreadData threadData2 = getThreadData();
                    if (threadData2.getBaijiahaoData() != null) {
                        m.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.getBaijiahaoData().oriUgcNid);
                    }
                    m.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData2));
                    m.param("nid", threadData2.getNid());
                }
            }
            return m;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eh6
    public StatisticItem s() {
        InterceptResult invokeV;
        StatisticItem l;
        SmartApp smartApp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (V()) {
                l = l(Y);
            } else if (U()) {
                StatisticItem l2 = l(e0);
                if (l2 != null && getThreadData() != null && (smartApp = getThreadData().getSmartApp()) != null) {
                    TiebaStatic.deleteParamByKey(l2, "obj_type");
                    l2.param("obj_type", smartApp.id);
                    l2.param("obj_name", smartApp.name);
                }
                return l2;
            } else {
                l = l(T);
                if (l != null) {
                    l.param(TiebaStatic.Params.AB_ACTION, "click");
                    if (getThreadData() != null) {
                        ThreadData threadData = getThreadData();
                        if (threadData.getBaijiahaoData() != null) {
                            l.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                        }
                        l.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
                    }
                }
            }
            if (l != null && getThreadData() != null) {
                l.param(TiebaStatic.Params.IS_FULL, getThreadData().isShowFullThread() ? 1 : 0);
            }
            return l;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public mh6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.R = false;
    }

    public StatisticItem T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return l(c0);
        }
        return (StatisticItem) invokeV.objValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData != null && !threadData.isSmartAppThreadType()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData != null && ListUtils.getCount(threadData.getVoice()) != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.eh6, com.baidu.tieba.jw4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData == null) {
                return null;
            }
            if (threadData.getResource() == 5) {
                return this.a;
            }
            this.a.setResource(1);
            return this.a;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eh6
    public boolean isVideoThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData != null && threadData.isVideoThreadType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean W(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            if (threadData.getType() != ThreadData.TYPE_NORMAL && threadData.getType() != ThreadData.TYPE_GOD_NORMAL && threadData.getType() != ThreadData.TYPE_LINK && threadData.getType() != ThreadData.TYPE_SHARE_THREAD && threadData.getType() != ThreadData.TYPE_FRS_HOTTOPIC) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int L(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return 0;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 1;
            }
            if (threadData.isVideoThreadType()) {
                return 2;
            }
            if (threadData.isBJHNormalThreadType()) {
                return 3;
            }
            if (!threadData.isBJHVideoDynamicThreadType()) {
                return 0;
            }
            return 4;
        }
        return invokeL.intValue;
    }

    public int Y(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, threadData)) == null) {
            if (threadData == null) {
                return 1;
            }
            if (!threadData.isBJHVideoDynamicThreadType() && !threadData.isBJHNormalThreadType()) {
                if (!threadData.isBJHArticleThreadType() && !threadData.isBJHVideoThreadType()) {
                    return 1;
                }
                return 3;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public static boolean X(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            if (threadData.getType() != ThreadData.TYPE_SMART_APP_IMAGE && threadData.getType() != ThreadData.TYPE_SMART_APP_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public StatisticItem Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return l(str);
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            StatisticItem l = l(str);
            ThreadData threadData = this.a;
            if (threadData != null && threadData.getAuthor() != null) {
                l.param(TiebaStatic.Params.AB_TYPE, this.a.getAuthor().hadConcerned() ? 1 : 0);
            }
            return l;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem M(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StatisticItem l = l(str);
            if (l != null) {
                l.param("ab_tag", c()).param(TiebaStatic.Params.AB_ACTION, "show");
                if (getThreadData() != null) {
                    ThreadData threadData = getThreadData();
                    int i2 = 1;
                    if (threadData.getTopAgreePost() != null && (threadData.getTopAgreePost().a0() != null || threadData.getTopAgreePost().r0() != null)) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    l.param("obj_name", i);
                    if (i != 0 && threadData.getTopAgreePost().a0() != null && threadData.getTopAgreePost().a0().S() != null && threadData.getTopAgreePost().a0().S().size() > 0) {
                        if (threadData.getTopAgreePost().N) {
                            i2 = 2;
                        }
                        l.param(TiebaStatic.Params.OBJ_TO, i2);
                    }
                }
            }
            return l;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem N() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (V()) {
                return l(b0);
            }
            StatisticItem l = l(W);
            if (l != null) {
                l.param(TiebaStatic.Params.AB_ACTION, "click");
                if (getThreadData() != null) {
                    ThreadData threadData = getThreadData();
                    if (threadData.getBaijiahaoData() != null) {
                        l.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    }
                    l.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
                }
                if (lr5.c()) {
                    i = 1;
                } else {
                    i = 2;
                }
                l.param(TiebaStatic.Params.OBJ_TO, i);
            }
            return l;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eh6
    public StatisticItem v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            StatisticItem o = o(f0, true);
            if (getThreadData() != null) {
                ThreadData threadData = getThreadData();
                if (threadData.getBaijiahaoData() != null) {
                    o.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    o.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                o.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
            }
            return o;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (nh6.R(this.a)) {
                StatisticItem o = o(g0, true);
                if (o != null && getThreadData() != null) {
                    ThreadData threadData = getThreadData();
                    if (threadData.getBaijiahaoData() != null) {
                        o.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                        o.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                    }
                    o.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
                    if (threadData.isAlaLiveUser()) {
                        o.addParam(TiebaStatic.Params.OBJ_PARAM2, 2);
                    } else {
                        o.addParam(TiebaStatic.Params.OBJ_PARAM2, 1);
                    }
                    if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
                        int calculateLiveType = YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo());
                        if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                            TiebaStaticHelper.addYYParam(o, threadData.getAuthor().getAlaInfo().mYyExtData);
                        }
                        o.param(TiebaStatic.Params.OBJ_PARAM7, calculateLiveType);
                    }
                }
                return o;
            } else if (V()) {
                return l(a0);
            } else {
                StatisticItem l = l(V);
                if (l != null) {
                    l.param("ab_tag", c()).param(TiebaStatic.Params.AB_ACTION, "click");
                    if (getThreadData() != null) {
                        ThreadData threadData2 = getThreadData();
                        if (threadData2.getBaijiahaoData() != null) {
                            l.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.getBaijiahaoData().oriUgcNid);
                        }
                        l.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData2));
                        l.param("nid", threadData2.getNid());
                        if (threadData2.isAlaLiveUser()) {
                            l.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                        } else {
                            l.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                        }
                        if (threadData2.getAuthor() != null && threadData2.getAuthor().getAlaInfo() != null) {
                            int calculateLiveType2 = YYLiveUtil.calculateLiveType(threadData2.getAuthor().getAlaInfo());
                            if (threadData2.getAuthor().getAlaInfo().mYyExtData != null) {
                                TiebaStaticHelper.addYYParam(l, threadData2.getAuthor().getAlaInfo().mYyExtData);
                            }
                            l.param(TiebaStatic.Params.OBJ_PARAM6, calculateLiveType2);
                        }
                    }
                }
                return l;
            }
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eh6
    public StatisticItem d(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            ThreadData threadData = this.a;
            if (threadData != null) {
                if (threadData.getBaijiahaoData() == null) {
                    statisticItem.param("fid", this.a.getFid());
                    statisticItem.param("tid", this.a.getTid());
                    statisticItem.param("fname", this.a.getForum_name());
                } else {
                    statisticItem.param("tid", this.a.getBaijiahaoData().oriUgcNid);
                }
                int i2 = 2;
                if (this.a.isVideoThreadType()) {
                    i = 2;
                } else if (this.a.isLinkThread()) {
                    i = 4;
                } else {
                    ThreadData threadData2 = this.a;
                    if (threadData2.isShareThread) {
                        i = 5;
                    } else if (threadData2.isBJHArticleThreadType()) {
                        i = 6;
                    } else if (this.a.isBJHNormalThreadType()) {
                        i = 7;
                    } else if (this.a.isBJHVideoThreadType()) {
                        i = 8;
                    } else if (this.a.isBJHVideoDynamicThreadType()) {
                        i = 9;
                    } else {
                        i = 1;
                    }
                }
                statisticItem.param("obj_type", i);
                statisticItem.param("obj_id", this.a.getAuthor().getUserId());
                if (!x()) {
                    i2 = 1;
                }
                statisticItem.param("obj_param1", i2);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.hn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int indexOf;
        int indexOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData == null) {
                return j0;
            }
            if (this.B && eh6.Q.length > 1) {
                BdUniqueId type = threadData.getType();
                if (type == ThreadData.TYPE_NORMAL || type == ThreadData.TYPE_LINK || type == ThreadData.TYPE_FRS_HOTTOPIC || type == ThreadData.TYPE_GOD_NORMAL) {
                    if (this.n) {
                        indexOf = eh6.O.indexOf(eh6.E);
                    } else {
                        indexOf = eh6.O.indexOf(eh6.D);
                    }
                    if (this.o) {
                        indexOf2 = eh6.P.indexOf(eh6.F);
                    } else if (this.q) {
                        indexOf2 = eh6.P.indexOf(eh6.H);
                    } else if (this.p) {
                        indexOf2 = eh6.P.indexOf(eh6.G);
                    } else {
                        indexOf2 = eh6.P.indexOf(eh6.I);
                    }
                    if (indexOf >= 0) {
                        BdUniqueId[][] bdUniqueIdArr = eh6.Q;
                        if (indexOf < bdUniqueIdArr.length && indexOf2 >= 0 && indexOf2 < bdUniqueIdArr[0].length) {
                            return bdUniqueIdArr[indexOf][indexOf2];
                        }
                        return type;
                    }
                    return type;
                }
                return type;
            }
            ThreadData threadData2 = this.a;
            int i = threadData2.threadType;
            if (i == 63) {
                return x0;
            }
            if (i == 64) {
                return y0;
            }
            if (threadData2.isShareThread && (originalThreadInfo = threadData2.originalThreadData) != null) {
                if (originalThreadInfo.x) {
                    if (originalThreadInfo.r != null) {
                        return w0;
                    }
                    if (originalThreadInfo.i()) {
                        return v0;
                    }
                    return u0;
                }
                return t0;
            } else if (this.m) {
                return C0;
            } else {
                if (this.t) {
                    return I0;
                }
                if (this.r) {
                    return E0;
                }
                if (this.p) {
                    return F0;
                }
                if (this.q) {
                    return G0;
                }
                if (this.o) {
                    return H0;
                }
                if (this.A) {
                    return J0;
                }
                if (this.y) {
                    return L0;
                }
                if (this.x) {
                    return K0;
                }
                if (this.n) {
                    return D0;
                }
                if (this.u) {
                    return M0;
                }
                if (this.v) {
                    return N0;
                }
                if (this.w) {
                    return O0;
                }
                if (this.z) {
                    return P0;
                }
                return B0;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eh6
    public StatisticItem u() {
        InterceptResult invokeV;
        int i;
        int i2;
        SmartApp smartApp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int i3 = 0;
            int i4 = 1;
            if (V()) {
                StatisticItem l = l(X);
                if (l != null) {
                    l.setPosition(this.position);
                    if (getThreadData() != null) {
                        ThreadData threadData = getThreadData();
                        if (threadData.getTopAgreePost() != null && (threadData.getTopAgreePost().a0() != null || threadData.getTopAgreePost().r0() != null)) {
                            i3 = 1;
                        }
                        l.param("obj_name", i3);
                        if (threadData.getAuthor() != null) {
                            l.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                        }
                        l.param(TiebaStatic.Params.IS_FULL, threadData.isShowFullThread() ? 1 : 0);
                    }
                }
                return l;
            } else if (U()) {
                StatisticItem l2 = l(d0);
                if (l2 != null) {
                    l2.setPosition(this.position);
                    if (getThreadData() != null && (smartApp = getThreadData().getSmartApp()) != null) {
                        TiebaStatic.deleteParamByKey(l2, "obj_type");
                        l2.param("obj_type", smartApp.id);
                        l2.param("obj_name", smartApp.name);
                    }
                }
                return l2;
            } else if (isVideoThreadType()) {
                return null;
            } else {
                StatisticItem l3 = l(S);
                if (l3 != null) {
                    l3.setPosition(this.position);
                    l3.param(TiebaStatic.Params.AB_ACTION, "show");
                    if (getThreadData() != null) {
                        ThreadData threadData2 = getThreadData();
                        if (threadData2.getTopAgreePost() != null && (threadData2.getTopAgreePost().a0() != null || threadData2.getTopAgreePost().r0() != null)) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        l3.param("obj_name", i);
                        if (i != 0 && threadData2.getTopAgreePost().a0() != null && threadData2.getTopAgreePost().a0().S() != null && threadData2.getTopAgreePost().a0().S().size() > 0) {
                            if (threadData2.getTopAgreePost().N) {
                                i2 = 2;
                            } else {
                                i2 = 1;
                            }
                            l3.param(TiebaStatic.Params.OBJ_TO, i2);
                        }
                        if (threadData2.getAuthor() != null) {
                            l3.param(TiebaStatic.Params.AB_TYPE, threadData2.getAuthor().hadConcerned() ? 1 : 0);
                        }
                        l3.param(TiebaStatic.Params.IS_FULL, threadData2.isShowFullThread() ? 1 : 0);
                        if (threadData2.getBaijiahaoData() != null) {
                            l3.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.getBaijiahaoData().oriUgcNid);
                        }
                        l3.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData2));
                        if (threadData2.isAlaLiveUser()) {
                            l3.param(TiebaStatic.Params.OBJ_PARAM6, 2);
                        } else {
                            l3.param(TiebaStatic.Params.OBJ_PARAM6, 1);
                        }
                        if (threadData2.isGoods()) {
                            l3.param(TiebaStatic.Params.GUA_TYPE, 1);
                        } else if (threadData2.getItem() != null) {
                            l3.param(TiebaStatic.Params.GUA_TYPE, 2);
                        } else {
                            l3.param(TiebaStatic.Params.GUA_TYPE, 0);
                        }
                        if (threadData2.getAuthor() != null && threadData2.getAuthor().getAlaInfo() != null) {
                            int calculateLiveType = YYLiveUtil.calculateLiveType(threadData2.getAuthor().getAlaInfo());
                            if (threadData2.getAuthor().getAlaInfo().live_status != 1 && threadData2.getAuthor().getAlaInfo().friendRoomStatus != 2) {
                                i4 = 2;
                            }
                            if (threadData2.getAuthor().getAlaInfo().mYyExtData != null) {
                                TiebaStaticHelper.addYYParam(l3, threadData2.getAuthor().getAlaInfo().mYyExtData);
                            }
                            l3.param(TiebaStatic.Params.OBJ_PARAM7, i4);
                            l3.param(TiebaStatic.Params.OBJ_PARAM8, calculateLiveType);
                        }
                    }
                }
                return l3;
            }
        }
        return (StatisticItem) invokeV.objValue;
    }
}
