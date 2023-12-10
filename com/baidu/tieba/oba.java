package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.p05;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.holder.PersonInfoAddUserPicViewHolder;
import com.baidu.tieba.person.holder.PersonInfoUserPicViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class oba extends kba implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public final WriteImagesInfo c;
    public boolean d;
    public rba e;
    public PersonChangeData f;
    public PermissionJudgePolicy g;
    public HttpMessageListener h;
    public HttpMessageListener i;
    public Runnable j;
    public CustomMessageListener k;

    /* loaded from: classes7.dex */
    public class a implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n05 a;
        public final /* synthetic */ oba b;

        public a(oba obaVar, n05 n05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obaVar, n05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = obaVar;
            this.a = n05Var;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                this.b.d = false;
                if (i != 0) {
                    if (i == 1) {
                        this.b.x();
                    }
                } else {
                    this.b.t();
                }
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd5 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;
        public final /* synthetic */ n05 d;
        public final /* synthetic */ oba e;

        public b(oba obaVar, nd5 nd5Var, List list, int i, n05 n05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obaVar, nd5Var, list, Integer.valueOf(i), n05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = obaVar;
            this.a = nd5Var;
            this.b = list;
            this.c = i;
            this.d = n05Var;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                this.e.d = true;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                                this.e.u();
                            }
                        } else {
                            oba obaVar = this.e;
                            if (obaVar.a && obaVar.e != null && this.e.e.j() != null && !this.e.e.j().canModifyAvatar()) {
                                if (!StringUtils.isNull(this.e.e.j().getCantModifyAvatarDesc())) {
                                    BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), this.e.e.j().getCantModifyAvatarDesc());
                                } else {
                                    BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.obfuscated_res_0x7f0f1097);
                                }
                            } else {
                                this.e.x();
                            }
                        }
                    } else {
                        oba obaVar2 = this.e;
                        if (obaVar2.a && obaVar2.e != null && this.e.e.j() != null && !this.e.e.j().canModifyAvatar()) {
                            if (!StringUtils.isNull(this.e.e.j().getCantModifyAvatarDesc())) {
                                BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), this.e.e.j().getCantModifyAvatarDesc());
                            } else {
                                BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.obfuscated_res_0x7f0f1097);
                            }
                        } else {
                            this.e.t();
                        }
                    }
                } else {
                    this.e.y(this.a, this.b, this.c);
                }
                if (this.d.isShowing()) {
                    this.d.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd5 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;
        public final /* synthetic */ n05 d;
        public final /* synthetic */ oba e;

        public c(oba obaVar, nd5 nd5Var, List list, int i, n05 n05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obaVar, nd5Var, list, Integer.valueOf(i), n05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = obaVar;
            this.a = nd5Var;
            this.b = list;
            this.c = i;
            this.d = n05Var;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            pba.b(this.a, this.b);
                        }
                    } else {
                        pba.d(this.a, this.e.b.getUniqueId());
                    }
                } else {
                    this.e.y(this.a, this.b, this.c);
                }
                if (this.d.isShowing()) {
                    this.d.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oba a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(oba obaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obaVar, Integer.valueOf(i)};
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
            this.a = obaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                this.a.B();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oba a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(oba obaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obaVar, Integer.valueOf(i)};
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
            this.a = obaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() == 0) {
                    this.a.B();
                } else {
                    this.a.b.showToast(setUserPicsResponse.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(oba obaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921424));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oba a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(oba obaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obaVar, Integer.valueOf(i)};
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
            this.a = obaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                this.a.z((PersonChangeData) customResponsedMessage.getData());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oba(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new WriteImagesInfo(1);
        this.d = true;
        this.h = new d(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        this.i = new e(this, CmdConfigHttp.CMD_SET_USER_PICS);
        this.j = new f(this);
        g gVar = new g(this, 2001380);
        this.k = gVar;
        this.b = tbPageContext;
        gVar.setTag(bdUniqueId);
        this.i.setTag(bdUniqueId);
        this.h.setTag(bdUniqueId);
        this.b.registerListener(this.k);
        this.b.registerListener(this.i);
        this.b.registerListener(this.h);
    }

    public final void y(nd5 nd5Var, List<pi> list, int i) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048591, this, nd5Var, list, i) == null) && this.b != null && nd5Var != null && list != null && !StringUtils.isNull(nd5Var.a())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (pi piVar : list) {
                if (piVar instanceof nd5) {
                    nd5 nd5Var2 = (nd5) piVar;
                    if (nd5Var2.c() && !nd5Var2.a().startsWith("http")) {
                        arrayList.add(pba.c(this.b, nd5Var2.a()));
                    } else {
                        arrayList.add(nd5Var2.a());
                    }
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                str = arrayList.get(size - 1);
            } else {
                str = "";
            }
            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
            builder.setData(arrayList).setIndex(i).setIsCDN(true).setLastId(str).setIsReserve(true).setIsShowHost(false);
            ImageViewerConfig bulid = builder.bulid(this.b.getPageActivity());
            bulid.getIntent().putExtra("from", "portrait");
            this.b.sendMessage(new CustomMessage(2010000, bulid));
        }
    }

    public void C(rba rbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rbaVar) == null) {
            this.e = rbaVar;
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.j);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SafeHandler.getInst().postDelayed(this.j, 300L);
        }
    }

    public void o() {
        rba rbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (rbaVar = this.e) != null && rbaVar.j() != null) {
            TbImageMemoryCache.w().q(this.e.j().getPortrait());
        }
    }

    public List<pi> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            rba rbaVar = this.e;
            if (rbaVar == null) {
                return null;
            }
            return rbaVar.k();
        }
        return (List) invokeV.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.b == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.b.getPageActivity())));
    }

    public final void D() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.choose_local_photo), this.b.getString(R.string.change_system_photo)};
        n05 n05Var = new n05(this.b);
        n05Var.i(null, strArr, new a(this, n05Var));
        n05Var.l();
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.b == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.b.getPageActivity(), 12014, this.d)));
    }

    public final void E(nd5 nd5Var, List<pi> list, int i) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048580, this, nd5Var, list, i) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.obfuscated_res_0x7f0f09dd), this.b.getString(R.string.change_photo), this.b.getString(R.string.change_system_photo), this.b.getString(R.string.check_headpendant)};
        n05 n05Var = new n05(this.b);
        n05Var.i(null, strArr, new b(this, nd5Var, list, i, n05Var));
        n05Var.l();
    }

    public final void F(nd5 nd5Var, List<pi> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, nd5Var, list, i) == null) {
            String[] strArr = {this.b.getString(R.string.look_big_photo), this.b.getString(R.string.set_as_portrait_photo), this.b.getString(R.string.obfuscated_res_0x7f0f055b)};
            n05 n05Var = new n05(this.b);
            n05Var.i(null, strArr, new c(this, nd5Var, list, i, n05Var));
            n05Var.l();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view2) == null) && view2 != null && q() != null) {
            pi piVar = null;
            if (view2.getTag() instanceof PersonInfoUserPicViewHolder) {
                piVar = ((PersonInfoUserPicViewHolder) view2.getTag()).b();
            } else if (view2.getTag() instanceof PersonInfoAddUserPicViewHolder) {
                piVar = ((PersonInfoAddUserPicViewHolder) view2.getTag()).b();
            }
            int position = ListUtils.getPosition(q(), piVar);
            if (position < 0) {
                return;
            }
            r(piVar, q(), position);
        }
    }

    public void p(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.c.parseJson(stringExtra);
            this.c.updateQuality();
            if (!ListUtils.isEmpty(this.c.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.b.getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.c.getChosedFiles().get(0).getFilePath(), 1.0f, this.d).setUserGrowthTask(TbSingleton.getInstance().getUserGrowthTaskListData())));
            }
            this.c.clear();
        }
    }

    public void r(pi piVar, List<pi> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048586, this, piVar, list, i) == null) {
            s(piVar, list, i, false);
        }
    }

    public void s(pi piVar, List<pi> list, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048587, this, new Object[]{piVar, list, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || piVar == null) {
            return;
        }
        if (z) {
            if (piVar instanceof nd5) {
                y((nd5) piVar, list, i);
                return;
            }
            return;
        }
        rba rbaVar = this.e;
        if (rbaVar != null) {
            this.a = rbaVar.m();
        }
        if (!BdUtilHelper.isNetOk()) {
            this.b.showToast(R.string.obfuscated_res_0x7f0f0e70);
        } else if (!this.a) {
            if (piVar instanceof nd5) {
                y((nd5) piVar, list, i);
            }
        } else if (piVar instanceof t7a) {
            D();
        } else if (piVar instanceof nd5) {
            nd5 nd5Var = (nd5) piVar;
            if (nd5Var.c()) {
                E(nd5Var, list, i);
            } else {
                F(nd5Var, list, i);
            }
        }
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (this.g == null) {
            this.g = new PermissionJudgePolicy();
        }
        this.g.clearRequestPermissionList();
        this.g.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.g.startRequestPermission(pageActivity)) {
            return;
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.b.getPageActivity(), this.c.toJsonString(), true);
        albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public final void z(PersonChangeData personChangeData) {
        rba rbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, personChangeData) == null) && personChangeData != null && (rbaVar = this.e) != null && rbaVar.j() != null && this.e.m() && personChangeData.getPhotoChanged()) {
            if (this.f == null) {
                this.f = new PersonChangeData();
            }
            this.f.setPhotoChanged(true);
            o();
        }
    }
}
