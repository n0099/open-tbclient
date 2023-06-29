package com.baidu.tieba.tbadkCore;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.c3a;
import com.baidu.tieba.t2a;
import com.baidu.tieba.vg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Error;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes7.dex */
public class FRSPageSocketResponsedMessage extends MvcSocketResponsedMessage<c3a, FrsPageResIdl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCategoryId;
    public int mIsGood;
    public boolean needCache;
    public c3a responseData;
    public int updateType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FRSPageSocketResponsedMessage() {
        super(301001);
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
        this.mIsGood = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        c3a c3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) && !hasError() && (c3aVar = this.responseData) != null && this.needCache && c3aVar.getForum() != null) {
            int sortType = this.responseData.getSortType();
            t2a i2 = t2a.i();
            String g = i2.g("1~" + this.responseData.getForum().getName(), sortType, this.mIsGood, this.mCategoryId);
            if (sortType == 3) {
                t2a.i().m(g, bArr);
            } else {
                t2a.i().a(g, bArr, true);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        int e;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            super.beforeDispatchInBackGround(i, (int) bArr);
            if (this.responseData.getBookInfo() != null && !StringUtils.isNull(this.responseData.getBookInfo().a(), true) && !this.responseData.getBookInfo().a().equals("0") && this.responseData.getBookInfo().b() == 3 && (e = vg.e(this.responseData.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(e))) != null) {
                this.responseData.setMangaReadRecordChapterId(Integer.valueOf(((Integer) runTask.getData()).intValue()));
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Error error;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, bArr)) == null) {
            c3a c3aVar = new c3a();
            this.responseData = c3aVar;
            FrsPageResIdl parserProtobuf = c3aVar.parserProtobuf(bArr, true);
            if (parserProtobuf != null && (error = parserProtobuf.error) != null) {
                Integer num = error.errorno;
                if (num != null) {
                    setError(num.intValue());
                    this.responseData.mErrorNo = parserProtobuf.error.errorno.intValue();
                }
                setErrorString(parserProtobuf.error.usermsg);
            }
            c3a c3aVar2 = this.responseData;
            c3aVar2.isFromCache = false;
            setData(c3aVar2);
            return parserProtobuf;
        }
        return invokeIL.objValue;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public Class<FrsPageResIdl> getProtobufResponseIdlClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return FrsPageResIdl.class;
        }
        return (Class) invokeV.objValue;
    }

    public c3a getResponseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.responseData;
        }
        return (c3a) invokeV.objValue;
    }

    public int getUpdateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.updateType;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
            super.setOrginalMessage(message);
            if (message.getExtra() instanceof FRSPageRequestMessage) {
                FRSPageRequestMessage fRSPageRequestMessage = (FRSPageRequestMessage) message.getExtra();
                this.updateType = fRSPageRequestMessage.getUpdateType();
                this.needCache = fRSPageRequestMessage.isNeedCache();
                this.mCategoryId = fRSPageRequestMessage.getCategoryId();
            } else if (message.getExtra() instanceof MvcNetMessage) {
                MvcNetMessage mvcNetMessage = (MvcNetMessage) message.getExtra();
                if (mvcNetMessage.getRequestData() instanceof FrsRequestData) {
                    FrsRequestData frsRequestData = (FrsRequestData) mvcNetMessage.getRequestData();
                    this.updateType = frsRequestData.getUpdateType();
                    this.needCache = frsRequestData.isNeedCache();
                    this.mCategoryId = frsRequestData.V();
                    this.mIsGood = frsRequestData.X();
                }
            }
        }
    }

    public void setResponseData(c3a c3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, c3aVar) == null) {
            this.responseData = c3aVar;
        }
    }

    public void setUpdateType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.updateType = i;
        }
    }
}
