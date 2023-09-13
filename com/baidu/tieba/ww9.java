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
import com.baidu.tieba.i55;
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
/* loaded from: classes8.dex */
public class ww9 extends sw9 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public final WriteImagesInfo c;
    public boolean d;
    public zw9 e;
    public PersonChangeData f;
    public PermissionJudgePolicy g;
    public HttpMessageListener h;
    public HttpMessageListener i;
    public Runnable j;
    public CustomMessageListener k;

    /* loaded from: classes8.dex */
    public class a implements i55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g55 a;
        public final /* synthetic */ ww9 b;

        public a(ww9 ww9Var, g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww9Var, g55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ww9Var;
            this.a = g55Var;
        }

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                this.b.d = false;
                if (i != 0) {
                    if (i == 1) {
                        this.b.u();
                    }
                } else {
                    this.b.s();
                }
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements i55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh5 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;
        public final /* synthetic */ g55 d;
        public final /* synthetic */ ww9 e;

        public b(ww9 ww9Var, yh5 yh5Var, List list, int i, g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww9Var, yh5Var, list, Integer.valueOf(i), g55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ww9Var;
            this.a = yh5Var;
            this.b = list;
            this.c = i;
            this.d = g55Var;
        }

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                this.e.d = true;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                                this.e.t();
                            }
                        } else {
                            ww9 ww9Var = this.e;
                            if (ww9Var.a && ww9Var.e != null && this.e.e.j() != null && !this.e.e.j().canModifyAvatar()) {
                                if (!StringUtils.isNull(this.e.e.j().getCantModifyAvatarDesc())) {
                                    BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), this.e.e.j().getCantModifyAvatarDesc());
                                } else {
                                    BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.obfuscated_res_0x7f0f1065);
                                }
                            } else {
                                this.e.u();
                            }
                        }
                    } else {
                        ww9 ww9Var2 = this.e;
                        if (ww9Var2.a && ww9Var2.e != null && this.e.e.j() != null && !this.e.e.j().canModifyAvatar()) {
                            if (!StringUtils.isNull(this.e.e.j().getCantModifyAvatarDesc())) {
                                BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), this.e.e.j().getCantModifyAvatarDesc());
                            } else {
                                BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.obfuscated_res_0x7f0f1065);
                            }
                        } else {
                            this.e.s();
                        }
                    }
                } else {
                    this.e.x(this.a, this.b, this.c);
                }
                if (this.d.isShowing()) {
                    this.d.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements i55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yh5 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;
        public final /* synthetic */ g55 d;
        public final /* synthetic */ ww9 e;

        public c(ww9 ww9Var, yh5 yh5Var, List list, int i, g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww9Var, yh5Var, list, Integer.valueOf(i), g55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ww9Var;
            this.a = yh5Var;
            this.b = list;
            this.c = i;
            this.d = g55Var;
        }

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            xw9.b(this.a, this.b);
                        }
                    } else {
                        xw9.d(this.a, this.e.b.getUniqueId());
                    }
                } else {
                    this.e.x(this.a, this.b, this.c);
                }
                if (this.d.isShowing()) {
                    this.d.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ww9 ww9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww9Var, Integer.valueOf(i)};
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
            this.a = ww9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                this.a.A();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ww9 ww9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww9Var, Integer.valueOf(i)};
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
            this.a = ww9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() == 0) {
                    this.a.A();
                } else {
                    this.a.b.showToast(setUserPicsResponse.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(ww9 ww9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww9Var};
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

    /* loaded from: classes8.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ww9 ww9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww9Var, Integer.valueOf(i)};
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
            this.a = ww9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                this.a.y((PersonChangeData) customResponsedMessage.getData());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ww9(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
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

    public final void x(yh5 yh5Var, List<cn> list, int i) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048590, this, yh5Var, list, i) == null) && this.b != null && yh5Var != null && list != null && !StringUtils.isNull(yh5Var.a())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (cn cnVar : list) {
                if (cnVar instanceof yh5) {
                    yh5 yh5Var2 = (yh5) cnVar;
                    if (yh5Var2.c() && !yh5Var2.a().startsWith("http")) {
                        arrayList.add(xw9.c(this.b, yh5Var2.a()));
                    } else {
                        arrayList.add(yh5Var2.a());
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

    public void B(zw9 zw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zw9Var) == null) {
            this.e = zw9Var;
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SafeHandler.getInst().postDelayed(this.j, 300L);
        }
    }

    public void n() {
        zw9 zw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (zw9Var = this.e) != null && zw9Var.j() != null) {
            TbImageMemoryCache.A().q(this.e.j().getPortrait());
        }
    }

    public List<cn> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            zw9 zw9Var = this.e;
            if (zw9Var == null) {
                return null;
            }
            return zw9Var.k();
        }
        return (List) invokeV.objValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.b == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.b.getPageActivity())));
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.j);
        }
    }

    public final void C() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.choose_local_photo), this.b.getString(R.string.change_system_photo)};
        g55 g55Var = new g55(this.b);
        g55Var.i(null, strArr, new a(this, g55Var));
        g55Var.l();
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.b == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.b.getPageActivity(), 12014, this.d)));
    }

    public final void D(yh5 yh5Var, List<cn> list, int i) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048579, this, yh5Var, list, i) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.obfuscated_res_0x7f0f09b8), this.b.getString(R.string.change_photo), this.b.getString(R.string.change_system_photo), this.b.getString(R.string.check_headpendant)};
        g55 g55Var = new g55(this.b);
        g55Var.i(null, strArr, new b(this, yh5Var, list, i, g55Var));
        g55Var.l();
    }

    public final void E(yh5 yh5Var, List<cn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, yh5Var, list, i) == null) {
            String[] strArr = {this.b.getString(R.string.look_big_photo), this.b.getString(R.string.set_as_portrait_photo), this.b.getString(R.string.obfuscated_res_0x7f0f054b)};
            g55 g55Var = new g55(this.b);
            g55Var.i(null, strArr, new c(this, yh5Var, list, i, g55Var));
            g55Var.l();
        }
    }

    public void o(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, intent) == null) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.c.parseJson(stringExtra);
            this.c.updateQuality();
            if (!ListUtils.isEmpty(this.c.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.b.getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.c.getChosedFiles().get(0).getFilePath(), 1.0f, this.d).setUserGrowthTask(TbSingleton.getInstance().getUserGrowthTaskListData())));
            }
            this.c.clear();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view2) == null) && view2 != null && p() != null) {
            cn cnVar = null;
            if (view2.getTag() instanceof PersonInfoUserPicViewHolder) {
                cnVar = ((PersonInfoUserPicViewHolder) view2.getTag()).b();
            } else if (view2.getTag() instanceof PersonInfoAddUserPicViewHolder) {
                cnVar = ((PersonInfoAddUserPicViewHolder) view2.getTag()).b();
            }
            int position = ListUtils.getPosition(p(), cnVar);
            if (position < 0) {
                return;
            }
            q(cnVar, p(), position);
        }
    }

    public void q(cn cnVar, List<cn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048585, this, cnVar, list, i) == null) {
            r(cnVar, list, i, false);
        }
    }

    public void r(cn cnVar, List<cn> list, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{cnVar, list, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || cnVar == null) {
            return;
        }
        if (z) {
            if (cnVar instanceof yh5) {
                x((yh5) cnVar, list, i);
                return;
            }
            return;
        }
        zw9 zw9Var = this.e;
        if (zw9Var != null) {
            this.a = zw9Var.m();
        }
        if (!BdUtilHelper.isNetOk()) {
            this.b.showToast(R.string.obfuscated_res_0x7f0f0e40);
        } else if (!this.a) {
            if (cnVar instanceof yh5) {
                x((yh5) cnVar, list, i);
            }
        } else if (cnVar instanceof bt9) {
            C();
        } else if (cnVar instanceof yh5) {
            yh5 yh5Var = (yh5) cnVar;
            if (yh5Var.c()) {
                D(yh5Var, list, i);
            } else {
                E(yh5Var, list, i);
            }
        }
    }

    public void s() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || (tbPageContext = this.b) == null) {
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

    public final void y(PersonChangeData personChangeData) {
        zw9 zw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, personChangeData) == null) && personChangeData != null && (zw9Var = this.e) != null && zw9Var.j() != null && this.e.m() && personChangeData.getPhotoChanged()) {
            if (this.f == null) {
                this.f = new PersonChangeData();
            }
            this.f.setPhotoChanged(true);
            n();
        }
    }
}
