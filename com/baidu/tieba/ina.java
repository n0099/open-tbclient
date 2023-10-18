package com.baidu.tieba;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tieba.userblock.UserBlockInfoModel;
import com.baidu.tieba.userblock.UserBlockSetModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.GetUserBlackInfo.DataRes;
import tbclient.PermissionList;
/* loaded from: classes6.dex */
public class ina {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public BlueCircleProgressDialog c;
    public lz4 d;
    public ArrayList<tz4> e;
    public long f;
    public UserBlockSetModel g;
    public UserBlockInfoModel h;
    public AdapterView.OnItemClickListener i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes6.dex */
    public class a implements yt4<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ina a;

        public a(ina inaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yt4
        /* renamed from: b */
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                hna.g((ViewGroup) this.a.a.getPageActivity().findViewById(16908290), str, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921690));
                this.a.k();
            }
        }

        @Override // com.baidu.tieba.yt4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.k();
                hna.g((ViewGroup) this.a.a.getPageActivity().findViewById(16908290), str, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yt4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ina a;

        public b(ina inaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inaVar;
        }

        @Override // com.baidu.tieba.yt4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.a != null) {
                this.a.a.showToast(str);
            }
        }

        @Override // com.baidu.tieba.yt4
        public void onSuccess(Object obj) {
            int i;
            PermissionList permissionList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (obj instanceof DataRes) {
                    DataRes dataRes = (DataRes) obj;
                    i = dataRes.is_black_white.intValue();
                    permissionList = dataRes.perm_list;
                } else {
                    i = 0;
                    permissionList = null;
                }
                if (permissionList != null) {
                    this.a.m(i, permissionList);
                } else if (this.a.a != null) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f06b2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ina a;

        public c(ina inaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inaVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                tz4 tz4Var = (tz4) ListUtils.getItem(this.a.e, i);
                if (tz4Var != null) {
                    this.a.d.r(true);
                }
                this.a.d.h(i);
                hna.a(tz4Var, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ina a;

        public d(ina inaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ina a;

        public e(ina inaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d.d();
                if (this.a.e != null && BdNetTypeUtil.isNetWorkAvailable() && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    Iterator it = this.a.e.iterator();
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    while (it.hasNext()) {
                        tz4 tz4Var = (tz4) it.next();
                        if (tz4Var.d() && "1".equals(tz4Var.b())) {
                            i = 1;
                        } else if (tz4Var.d() && "2".equals(tz4Var.b())) {
                            i2 = 1;
                        } else if (tz4Var.d() && "3".equals(tz4Var.b())) {
                            i3 = 1;
                        }
                    }
                    this.a.o();
                    this.a.g.T(this.a.f, i, i2, i3);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ina a;

        public f(ina inaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inaVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.a.b);
            }
        }
    }

    public ina(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new c(this);
        this.j = new d(this);
        this.k = new e(this);
        this.a = tbPageContext;
        this.b = bdUniqueId;
        UserBlockSetModel userBlockSetModel = new UserBlockSetModel(tbPageContext, bdUniqueId);
        this.g = userBlockSetModel;
        userBlockSetModel.U(new a(this));
        UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(tbPageContext, bdUniqueId);
        this.h = userBlockInfoModel;
        userBlockInfoModel.U(new b(this));
    }

    public final String j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return TbadkCoreApplication.getInst().getString(i);
        }
        return (String) invokeI.objValue;
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f = j;
            this.h.T(j);
        }
    }

    public final void k() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (blueCircleProgressDialog = this.c) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.c == null) {
                BlueCircleProgressDialog blueCircleProgressDialog = new BlueCircleProgressDialog(this.a);
                this.c = blueCircleProgressDialog;
                blueCircleProgressDialog.setCancelListener(new f(this));
            }
            this.c.setDialogVisiable(true);
            this.c.setCanceledOnTouchOutside(false);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = -1L;
            BlueCircleProgressDialog blueCircleProgressDialog = this.c;
            if (blueCircleProgressDialog != null) {
                blueCircleProgressDialog.setDialogVisiable(false);
            }
            lz4 lz4Var = this.d;
            if (lz4Var != null) {
                lz4Var.d();
            }
            UserBlockInfoModel userBlockInfoModel = this.h;
            if (userBlockInfoModel != null) {
                userBlockInfoModel.onDestroy();
            }
            UserBlockSetModel userBlockSetModel = this.g;
            if (userBlockSetModel != null) {
                userBlockSetModel.onDestroy();
            }
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, this.b);
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.b);
        }
    }

    public final void m(int i, PermissionList permissionList) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, permissionList) == null) {
            boolean z3 = false;
            if (permissionList != null && permissionList.follow.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (permissionList != null && permissionList.interact.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (permissionList != null && permissionList.chat.intValue() == 1) {
                z3 = true;
            }
            ArrayList<tz4> arrayList = new ArrayList<>();
            this.e = arrayList;
            if (i == 1) {
                arrayList.add(new tz4(j(R.string.block_follow), z, "1"));
                this.e.add(new tz4(j(R.string.block_action), z2, "2"));
                this.e.add(new tz4(j(R.string.block_message), z3, "3"));
            } else {
                arrayList.add(new tz4(j(R.string.block_commit), z2, "2"));
                this.e.add(new tz4(j(R.string.block_message), z3, "3"));
            }
            lz4 lz4Var = new lz4(this.a);
            this.d = lz4Var;
            lz4Var.l(R.string.block_user_title);
            this.d.k(this.e, this.i);
            this.d.q(R.string.obfuscated_res_0x7f0f05b2, this.k);
            this.d.p(R.string.obfuscated_res_0x7f0f03d2, this.j);
            lz4 lz4Var2 = this.d;
            lz4Var2.c();
            lz4Var2.n();
        }
    }
}
