package com.baidu.tieba.tbadkCore;

import androidx.core.view.InputDeviceCompat;
import b.a.e.f.m.b;
import b.a.r0.m3.e;
import b.a.r0.m3.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Error;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes9.dex */
public class FRSPageSocketResponsedMessage extends MvcSocketResponsedMessage<m, FrsPageResIdl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCategoryId;
    public int mIsGood;
    public boolean needCache;
    public m responseData;
    public int updateType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FRSPageSocketResponsedMessage() {
        super(301001);
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
        this.mIsGood = 0;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public Class<FrsPageResIdl> getProtobufResponseIdlClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? FrsPageResIdl.class : (Class) invokeV.objValue;
    }

    public m getResponseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.responseData : (m) invokeV.objValue;
    }

    public int getUpdateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.updateType : invokeV.intValue;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, message) == null) {
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
                    this.mCategoryId = frsRequestData.x();
                    this.mIsGood = frsRequestData.y();
                }
            }
        }
    }

    public void setResponseData(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mVar) == null) {
            this.responseData = mVar;
        }
    }

    public void setUpdateType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.updateType = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || hasError() || (mVar = this.responseData) == null || !this.needCache || mVar.getForum() == null) {
            return;
        }
        int sortType = this.responseData.getSortType();
        e i3 = e.i();
        String g2 = i3.g("1~" + this.responseData.getForum().getName(), sortType, this.mIsGood, this.mCategoryId);
        if (sortType == 3) {
            e.i().m(g2, bArr);
        } else {
            e.i().a(g2, bArr, true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i2, byte[] bArr) {
        int e2;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
            super.beforeDispatchInBackGround(i2, (int) bArr);
            if (this.responseData.getBookInfo() == null || StringUtils.isNull(this.responseData.getBookInfo().a(), true) || this.responseData.getBookInfo().a().equals("0") || this.responseData.getBookInfo().b() != 3 || (e2 = b.e(this.responseData.getBookInfo().a(), -1)) <= 0 || (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(e2))) == null) {
                return;
            }
            this.responseData.setMangaReadRecordChapterId(Integer.valueOf(((Integer) runTask.getData()).intValue()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Error error;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, bArr) == null) {
            m mVar = new m();
            this.responseData = mVar;
            FrsPageResIdl parserProtobuf = mVar.parserProtobuf(bArr, true);
            if (parserProtobuf != null && (error = parserProtobuf.error) != null) {
                Integer num = error.errorno;
                if (num != null) {
                    setError(num.intValue());
                    this.responseData.mErrorNo = parserProtobuf.error.errorno.intValue();
                }
                setErrorString(parserProtobuf.error.usermsg);
            }
            setData(this.responseData);
        }
    }
}
