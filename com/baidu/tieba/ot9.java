package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.feedback.AigcFeedbackHelper;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ot9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public final Function0<ArrayList<oi>> b;
    public final Function0<Unit> c;
    public final CustomMessageListener d;

    /* loaded from: classes7.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ot9 ot9Var) {
            super(2016530);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AgreeMessageData)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    AgreeMessageData agreeMessageData = (AgreeMessageData) data;
                    AgreeData agreeData = agreeMessageData.agreeData;
                    if (agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                        ArrayList arrayList = (ArrayList) this.a.b.invoke();
                        if (arrayList != null && !arrayList.isEmpty()) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            return;
                        }
                        Object obj = null;
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object obj2 = (oi) it.next();
                            if (obj2 instanceof vra) {
                                vra vraVar = (vra) obj2;
                                String valueOf = String.valueOf(vraVar.p0());
                                String T2 = vraVar.T();
                                if (Intrinsics.areEqual(agreeData.threadId, valueOf) && Intrinsics.areEqual(agreeData.postId, T2)) {
                                    obj = obj2;
                                    break;
                                }
                            }
                        }
                        if (obj != null) {
                            vra vraVar2 = (vra) obj;
                            if (vraVar2.y0()) {
                                AgreeData p = vraVar2.p();
                                if (p != null) {
                                    ot9 ot9Var = this.a;
                                    if (!Intrinsics.areEqual(ot9Var.a, agreeMessageData.uniqueId)) {
                                        p.agreeType = agreeData.agreeType;
                                        p.hasAgree = agreeData.hasAgree;
                                        p.diffAgreeNum = agreeData.diffAgreeNum;
                                        p.agreeNum = agreeData.agreeNum;
                                        p.disAgreeNum = agreeData.disAgreeNum;
                                    } else if (p.isSelectDisagree()) {
                                        vraVar2.V0(1);
                                        AigcFeedbackHelper.d(vraVar2);
                                    } else if (p.isSelectAgree() || ot9Var.e(p)) {
                                        vraVar2.V0(0);
                                    }
                                }
                                this.a.c.invoke();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.tbadkCore.data.AgreeMessageData");
            }
        }
    }

    public ot9(BdUniqueId uniqueId, Function0<? extends ArrayList<oi>> dataList, Function0<Unit> afterSync) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uniqueId, dataList, afterSync};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(afterSync, "afterSync");
        this.a = uniqueId;
        this.b = dataList;
        this.c = afterSync;
        this.d = new a(this);
    }

    public final boolean e(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, agreeData)) == null) {
            Intrinsics.checkNotNullParameter(agreeData, "<this>");
            if (!agreeData.hasAgree && agreeData.isDisagreeType()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final CustomMessageListener d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (CustomMessageListener) invokeV.objValue;
    }
}
