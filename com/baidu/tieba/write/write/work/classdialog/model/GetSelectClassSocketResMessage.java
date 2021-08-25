package com.baidu.tieba.write.write.work.classdialog.model;

import c.a.p0.u.n;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetWorksTags.Category;
import tbclient.GetWorksTags.DataRes;
import tbclient.GetWorksTags.GetWorksTagsResIdl;
import tbclient.GetWorksTags.Tag;
/* loaded from: classes7.dex */
public class GetSelectClassSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> firstClass;
    public List<List<String>> secondClass;
    public List<n> tags;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetSelectClassSocketResMessage() {
        super(309713);
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
        this.firstClass = new ArrayList();
        this.secondClass = new ArrayList();
        this.tags = new ArrayList();
    }

    public List<String> getFirstClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.firstClass : (List) invokeV.objValue;
    }

    public List<List<String>> getSecondClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.secondClass : (List) invokeV.objValue;
    }

    public List<n> getTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.tags : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetWorksTagsResIdl getWorksTagsResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getWorksTagsResIdl = (GetWorksTagsResIdl) new Wire(new Class[0]).parseFrom(bArr, GetWorksTagsResIdl.class)) == null) {
            return;
        }
        Error error = getWorksTagsResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getWorksTagsResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
        }
        DataRes dataRes = getWorksTagsResIdl.data;
        if (dataRes != null) {
            List<Category> list = dataRes.category;
            if (list != null) {
                for (Category category : list) {
                    this.firstClass.add(category.first_class);
                    this.secondClass.add(category.second_class);
                }
            }
            List<Tag> list2 = getWorksTagsResIdl.data.tags;
            if (list2 != null) {
                for (Tag tag : list2) {
                    n nVar = new n();
                    nVar.d(tag.first_class);
                    nVar.e(tag.second_class);
                    nVar.f(tag.tags);
                    this.tags.add(nVar);
                }
            }
        }
        this.firstClass.add(0, "一级分类");
        ArrayList arrayList = new ArrayList();
        arrayList.add("二级分类");
        this.secondClass.add(0, arrayList);
    }
}
