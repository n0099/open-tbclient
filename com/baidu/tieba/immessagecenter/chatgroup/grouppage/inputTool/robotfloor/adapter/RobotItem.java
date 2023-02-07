package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.robotfloor.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ar7;
import com.baidu.tieba.br7;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.ChatRoomRecycleAdapter;
import com.baidu.tieba.op7;
import com.baidu.tieba.zq7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class RobotItem extends op7 implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -5589601297540632738L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isShowHeadView;
    public RecyclerView.Adapter mAdapter;
    public List<op7> mSubItems;
    public String roboatName;
    public String robortAvatar;

    @Override // com.baidu.tieba.op7
    public int getViewType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    public RobotItem(List<op7> list, @NonNull String str, @NonNull String str2, @NonNull TbPageContext tbPageContext, zq7 zq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2, tbPageContext, zq7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSubItems = new ArrayList();
        this.isShowHeadView = true;
        this.roboatName = str2;
        this.robortAvatar = str;
        ar7 ar7Var = new ar7(tbPageContext);
        if (!ListUtils.isEmpty(list)) {
            this.mSubItems.addAll(list);
        }
        this.mAdapter = new ChatRoomRecycleAdapter(new br7(zq7Var), ar7Var, tbPageContext);
        ar7Var.b(getSubItems());
    }

    public RecyclerView.Adapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAdapter;
        }
        return (RecyclerView.Adapter) invokeV.objValue;
    }

    public String getRoboatName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.roboatName;
        }
        return (String) invokeV.objValue;
    }

    public String getRobortAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.robortAvatar;
        }
        return (String) invokeV.objValue;
    }

    public List<op7> getSubItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mSubItems;
        }
        return (List) invokeV.objValue;
    }

    public boolean isShowHeadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.isShowHeadView;
        }
        return invokeV.booleanValue;
    }

    public void setShowHeadView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.isShowHeadView = z;
        }
    }
}
