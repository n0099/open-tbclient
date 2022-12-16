package com.baidu.tieba.pb.pb.main.view;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.qb;
import com.baidu.tieba.r9;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.x08;
import com.baidu.tieba.xg;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbFakeFloorModel extends DataModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public x08 b;
    public boolean c;
    public SubPbRequestMessage d;
    public TbPageContext e;
    public b f;
    public String g;
    public boolean h;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public qb m;

    /* loaded from: classes5.dex */
    public interface b {
        void a(PostData postData);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFakeFloorModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbFakeFloorModel pbFakeFloorModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFakeFloorModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFakeFloorModel;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String userId;
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null && this.a.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                boolean z = false;
                this.a.c = false;
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = this.a.e.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0cb8);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    this.a.e.showToast(errorString);
                    return;
                }
                x08 x08Var = null;
                if (responsedMessage instanceof SubPbHttpResponseMessage) {
                    x08Var = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                    x08Var = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                }
                if (x08Var != null && x08Var.k() != null) {
                    PostData postData = (PostData) ListUtils.getItem(x08Var.k(), x08Var.k().size() - 1);
                    if (postData != null && this.a.b != null && this.a.b.i() != null) {
                        if (this.a.b.l() != null && this.a.b.l().getAuthor() != null && postData.r() != null && (userId = this.a.b.l().getAuthor().getUserId()) != null && userId.equals(postData.r().getUserId())) {
                            z = true;
                        }
                        postData.j1(this.a.e, z);
                    }
                    if (this.a.f != null) {
                        this.a.f.a(postData);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = false;
        this.f = null;
        a aVar = new a(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.m = aVar;
        this.e = tbPageContext;
        registerListener(aVar);
    }

    public void X(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, postData) == null) && postData != null) {
            this.b.i().b(postData);
            this.b.i().c(postData);
            this.b.i().U0(true);
        }
    }

    public void b0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void c0(x08 x08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, x08Var) == null) {
            this.b = x08Var;
        }
    }

    public void setFromForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.g = str;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.a = str;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            registerListener(this.m);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public int H() {
        InterceptResult invokeV;
        PostData i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            x08 x08Var = this.b;
            if (x08Var != null && (i = x08Var.i()) != null) {
                return i.D();
            }
            return super.H();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            x08 x08Var = this.b;
            if (x08Var != null && x08Var.l() != null) {
                return this.b.l().getTid();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            a0();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.c) {
            return;
        }
        cancelMessage();
        SubPbRequestMessage Y = Y();
        this.d = Y;
        if (Y == null) {
            return;
        }
        sendMessage(Y);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            x08 x08Var = this.b;
            if (x08Var != null && x08Var.d() != null) {
                return this.b.d().getId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            MessageManager.getInstance().unRegisterListener(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            x08 x08Var = this.b;
            if (x08Var != null && x08Var.d() != null && this.b.l() != null && this.b.i() != null) {
                WriteData writeData = new WriteData();
                boolean isMutiForumThread = this.b.l().isMutiForumThread();
                if (isMutiForumThread) {
                    writeData.setVForumId(this.b.d().getId());
                    writeData.setVForumName(this.b.d().getName());
                } else {
                    writeData.setForumName(this.b.d().getName());
                    writeData.setForumId(this.b.d().getId());
                }
                writeData.setFromForumId(this.g);
                writeData.setFloor(this.b.i().M());
                writeData.setType(2);
                writeData.setCanNoForum(isMutiForumThread);
                writeData.setThreadId(this.b.l().getId());
                writeData.setFloorNum(0);
                return writeData;
            }
            return null;
        }
        return (WriteData) invokeL.objValue;
    }

    public final SubPbRequestMessage Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            x08 x08Var = this.b;
            if (x08Var != null && x08Var.l() != null && this.b.l().getId() != null && this.b.i() != null && this.b.i().M() != null) {
                this.c = true;
                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int l = yi.l(TbadkCoreApplication.getInst().getApp());
                int j = yi.j(TbadkCoreApplication.getInst().getApp());
                return new SubPbRequestMessage(this.e.getPageActivity(), xg.g(this.b.l().getId(), 0L), xg.g(this.b.i().M(), 0L), 0L, 1, l, j, f, "", 1);
            }
            this.c = false;
            return null;
        }
        return (SubPbRequestMessage) invokeV.objValue;
    }

    public void Z(boolean z, @NonNull String str, @NonNull String str2, @NonNull String str3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), str, str2, str3, Boolean.valueOf(z2)}) == null) {
            this.h = z;
            this.i = str;
            this.j = str2;
            this.k = str3;
            this.l = z2;
        }
    }
}
