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
/* loaded from: classes6.dex */
public final class ix9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public final Function0<ArrayList<pi>> b;
    public final Function0<Unit> c;
    public final CustomMessageListener d;

    /* loaded from: classes6.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ix9 ix9Var) {
            super(2016530);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix9Var};
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
            this.a = ix9Var;
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
                            Object obj2 = (pi) it.next();
                            if (obj2 instanceof mwa) {
                                mwa mwaVar = (mwa) obj2;
                                String valueOf = String.valueOf(mwaVar.q0());
                                String U = mwaVar.U();
                                if (Intrinsics.areEqual(agreeData.threadId, valueOf) && Intrinsics.areEqual(agreeData.postId, U)) {
                                    obj = obj2;
                                    break;
                                }
                            }
                        }
                        if (obj != null) {
                            mwa mwaVar2 = (mwa) obj;
                            if (mwaVar2.z0()) {
                                AgreeData p = mwaVar2.p();
                                if (p != null) {
                                    ix9 ix9Var = this.a;
                                    if (!Intrinsics.areEqual(ix9Var.a, agreeMessageData.uniqueId)) {
                                        p.agreeType = agreeData.agreeType;
                                        p.hasAgree = agreeData.hasAgree;
                                        p.diffAgreeNum = agreeData.diffAgreeNum;
                                        p.agreeNum = agreeData.agreeNum;
                                        p.disAgreeNum = agreeData.disAgreeNum;
                                    } else if (p.isSelectDisagree()) {
                                        mwaVar2.X0(1);
                                        AigcFeedbackHelper.d(mwaVar2);
                                    } else if (p.isSelectAgree() || ix9Var.e(p)) {
                                        mwaVar2.X0(0);
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

    public ix9(BdUniqueId uniqueId, Function0<? extends ArrayList<pi>> dataList, Function0<Unit> afterSync) {
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
