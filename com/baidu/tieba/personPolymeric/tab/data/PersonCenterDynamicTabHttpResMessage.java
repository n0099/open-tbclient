package com.baidu.tieba.personPolymeric.tab.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
/* loaded from: classes5.dex */
public class PersonCenterDynamicTabHttpResMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mCursor;
    public boolean mHasMore;
    public List mThreadDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCenterDynamicTabHttpResMessage() {
        super(CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            boolean z = false;
            GetShoubaiThreadListResIdl getShoubaiThreadListResIdl = (GetShoubaiThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetShoubaiThreadListResIdl.class);
            if (getShoubaiThreadListResIdl == null || (dataRes = getShoubaiThreadListResIdl.data) == null) {
                return;
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
        }
    }
}
