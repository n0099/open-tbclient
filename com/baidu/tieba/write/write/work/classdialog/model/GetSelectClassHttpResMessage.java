package com.baidu.tieba.write.write.work.classdialog.model;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.VideoCategoryClassData;
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
/* loaded from: classes8.dex */
public class GetSelectClassHttpResMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> firstClass;
    public List<List<String>> secondClass;
    public List<VideoCategoryClassData> tags;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetSelectClassHttpResMessage() {
        super(CmdConfigHttp.CMD_GET_SELECT_CLASS);
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
        this.firstClass = new ArrayList();
        this.secondClass = new ArrayList();
        this.tags = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetWorksTagsResIdl getWorksTagsResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) && (getWorksTagsResIdl = (GetWorksTagsResIdl) new Wire(new Class[0]).parseFrom(bArr, GetWorksTagsResIdl.class)) != null) {
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
                        VideoCategoryClassData videoCategoryClassData = new VideoCategoryClassData();
                        videoCategoryClassData.setFirstClass(tag.first_class);
                        videoCategoryClassData.setSecondClass(tag.second_class);
                        videoCategoryClassData.setTags(tag.tags);
                        this.tags.add(videoCategoryClassData);
                    }
                }
            }
            this.firstClass.add(0, "一级分类");
            ArrayList arrayList = new ArrayList();
            arrayList.add("二级分类");
            this.secondClass.add(0, arrayList);
        }
    }

    public List<String> getFirstClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.firstClass;
        }
        return (List) invokeV.objValue;
    }

    public List<List<String>> getSecondClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.secondClass;
        }
        return (List) invokeV.objValue;
    }

    public List<VideoCategoryClassData> getTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.tags;
        }
        return (List) invokeV.objValue;
    }
}
