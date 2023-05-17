package com.baidu.tieba.personPolymeric.tab.data;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetShoubaiThreadList.DataRes;
import tbclient.GetShoubaiThreadList.GetShoubaiThreadListResIdl;
import tbclient.GetShoubaiThreadList.PageInfo;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class PersonCenterDynamicTabSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mCursor;
    public boolean mHasMore;
    public List<ThreadData> mThreadDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCenterDynamicTabSocketResMessage() {
        super(309647);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
        this.mCursor = 0L;
        this.mHasMore = false;
        this.mThreadDataList = new ArrayList();
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            boolean z = false;
            GetShoubaiThreadListResIdl getShoubaiThreadListResIdl = (GetShoubaiThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetShoubaiThreadListResIdl.class);
            if (getShoubaiThreadListResIdl == null) {
                return null;
            }
            DataRes dataRes = getShoubaiThreadListResIdl.data;
            if (dataRes == null) {
                return getShoubaiThreadListResIdl;
            }
            PageInfo pageInfo = dataRes.page;
            if (pageInfo != null) {
                this.mCursor = pageInfo.cursor.longValue();
                if (getShoubaiThreadListResIdl.data.page.has_more.intValue() == 1) {
                    z = true;
                }
                this.mHasMore = z;
            }
            if (!ListUtils.isEmpty(getShoubaiThreadListResIdl.data.thread_list)) {
                for (ThreadInfo threadInfo : getShoubaiThreadListResIdl.data.thread_list) {
                    if (threadInfo != null) {
                        ThreadData threadData = new ThreadData();
                        threadData.parserProtobuf(threadInfo);
                        this.mThreadDataList.add(threadData);
                    }
                }
            }
            return getShoubaiThreadListResIdl;
        }
        return invokeIL.objValue;
    }
}
