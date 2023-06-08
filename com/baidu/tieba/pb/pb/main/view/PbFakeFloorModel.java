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
import com.baidu.tieba.e49;
import com.baidu.tieba.jb;
import com.baidu.tieba.jy9;
import com.baidu.tieba.k9;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tg;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PbFakeFloorModel extends DataModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public e49 b;
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
    public jb m;

    /* loaded from: classes7.dex */
    public interface b {
        void a(jy9 jy9Var);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a extends jb {
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

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String userId;
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null && this.a.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                boolean z = false;
                this.a.c = false;
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = this.a.e.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0def);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    this.a.e.showToast(errorString);
                    return;
                }
                e49 e49Var = null;
                if (responsedMessage instanceof SubPbHttpResponseMessage) {
                    e49Var = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                    e49Var = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                }
                if (e49Var != null && e49Var.i() != null) {
                    jy9 jy9Var = (jy9) ListUtils.getItem(e49Var.i(), e49Var.i().size() - 1);
                    if (jy9Var != null && this.a.b != null && this.a.b.g() != null) {
                        if (this.a.b.j() != null && this.a.b.j().getAuthor() != null && jy9Var.p() != null && (userId = this.a.b.j().getAuthor().getUserId()) != null && userId.equals(jy9Var.p().getUserId())) {
                            z = true;
                        }
                        jy9Var.p1(this.a.e, z);
                    }
                    if (this.a.f != null) {
                        this.a.f.a(jy9Var);
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
                super((k9) newInitContext.callArgs[0]);
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

    public void l0(jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, jy9Var) == null) && jy9Var != null) {
            this.b.g().b(jy9Var);
            this.b.g().c(jy9Var);
            this.b.g().Z0(true);
        }
    }

    public void p0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void q0(e49 e49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, e49Var) == null) {
            this.b = e49Var;
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
    public int V() {
        InterceptResult invokeV;
        jy9 g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e49 e49Var = this.b;
            if (e49Var != null && (g = e49Var.g()) != null) {
                return g.D();
            }
            return super.V();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e49 e49Var = this.b;
            if (e49Var != null && e49Var.j() != null) {
                return this.b.j().getTid();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            o0();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            e49 e49Var = this.b;
            if (e49Var != null && e49Var.d() != null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.c) {
            return;
        }
        cancelMessage();
        SubPbRequestMessage m0 = m0();
        this.d = m0;
        if (m0 == null) {
            return;
        }
        sendMessage(m0);
    }

    public void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            MessageManager.getInstance().unRegisterListener(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData b0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            e49 e49Var = this.b;
            if (e49Var != null && e49Var.d() != null && this.b.j() != null && this.b.g() != null) {
                WriteData writeData = new WriteData();
                boolean isMutiForumThread = this.b.j().isMutiForumThread();
                if (isMutiForumThread) {
                    writeData.setVForumId(this.b.d().getId());
                    writeData.setVForumName(this.b.d().getName());
                } else {
                    writeData.setForumName(this.b.d().getName());
                    writeData.setForumId(this.b.d().getId());
                }
                writeData.setFromForumId(this.g);
                writeData.setFloor(this.b.g().O());
                writeData.setType(2);
                writeData.setCanNoForum(isMutiForumThread);
                writeData.setThreadId(this.b.j().getId());
                writeData.setFloorNum(0);
                return writeData;
            }
            return null;
        }
        return (WriteData) invokeL.objValue;
    }

    public final SubPbRequestMessage m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            e49 e49Var = this.b;
            if (e49Var != null && e49Var.j() != null && this.b.j().getId() != null && this.b.g() != null && this.b.g().O() != null) {
                this.c = true;
                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int l = vi.l(TbadkCoreApplication.getInst().getApp());
                int j = vi.j(TbadkCoreApplication.getInst().getApp());
                return new SubPbRequestMessage(this.e.getPageActivity(), tg.g(this.b.j().getId(), 0L), tg.g(this.b.g().O(), 0L), 0L, 1, l, j, f, "", 1);
            }
            this.c = false;
            return null;
        }
        return (SubPbRequestMessage) invokeV.objValue;
    }

    public void n0(boolean z, @NonNull String str, @NonNull String str2, @NonNull String str3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), str, str2, str3, Boolean.valueOf(z2)}) == null) {
            this.h = z;
            this.i = str;
            this.j = str2;
            this.k = str3;
            this.l = z2;
        }
    }
}
