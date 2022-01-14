package com.baidu.tieba.personPolymeric.tab.data;

import c.a.s0.s.q.e2;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetShoubaiThreadList.DataRes;
import tbclient.GetShoubaiThreadList.GetShoubaiThreadListResIdl;
import tbclient.GetShoubaiThreadList.PageInfo;
import tbclient.ThreadInfo;
/* loaded from: classes12.dex */
public class PersonCenterDynamicTabSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mCursor;
    public boolean mHasMore;
    public List<e2> mThreadDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCenterDynamicTabSocketResMessage() {
        super(309647);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCursor = 0L;
        this.mHasMore = false;
        this.mThreadDataList = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            GetShoubaiThreadListResIdl getShoubaiThreadListResIdl = (GetShoubaiThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetShoubaiThreadListResIdl.class);
            if (getShoubaiThreadListResIdl == null || (dataRes = getShoubaiThreadListResIdl.data) == null) {
                return;
            }
            PageInfo pageInfo = dataRes.page;
            if (pageInfo != null) {
                this.mCursor = pageInfo.cursor.longValue();
                this.mHasMore = getShoubaiThreadListResIdl.data.page.has_more.intValue() == 1;
            }
            if (ListUtils.isEmpty(getShoubaiThreadListResIdl.data.thread_list)) {
                return;
            }
            for (ThreadInfo threadInfo : getShoubaiThreadListResIdl.data.thread_list) {
                if (threadInfo != null) {
                    e2 e2Var = new e2();
                    e2Var.c3(threadInfo);
                    this.mThreadDataList.add(e2Var);
                }
            }
        }
    }
}
