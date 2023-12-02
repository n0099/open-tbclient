package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.SocketMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.newFriends.RequestDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.f05;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mba implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h7a a;
    public iba b;
    public q4b c;
    public TbPageContext d;
    public BlackListModel e;
    public boolean f;
    public String g;
    public long h;
    public String i;
    public qba j;
    public BdUniqueId k;
    public boolean l;
    public RemoveFansController m;
    public g7a n;
    public final SocketMessageListener o;
    public final SocketMessageListener p;
    public final CustomMessageListener q;
    public final CustomMessageListener r;
    public final SocketMessageListener s;

    /* loaded from: classes7.dex */
    public class a extends SocketMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mba a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mba mbaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mbaVar, Integer.valueOf(i)};
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
            this.a = mbaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                if (StringUtils.isNull(socketResponsedMessage.getErrorString())) {
                    errorString = this.a.d.getResources().getString(R.string.obfuscated_res_0x7f0f0e70);
                } else {
                    errorString = socketResponsedMessage.getErrorString();
                }
                this.a.d.showToast(errorString);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mba a;

        public b(mba mbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mbaVar;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i, String str, long j, boolean z) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        TbPageContext tbPageContext = this.a.d;
                        if (i == 0) {
                            i2 = R.string.remove_fans_success;
                        } else {
                            i2 = R.string.remove_fans_fail;
                        }
                        BdUtilHelper.showToast(this.a.d.getPageActivity(), tbPageContext.getString(i2));
                    } else {
                        BdUtilHelper.showToast(this.a.d.getPageActivity(), str);
                    }
                }
                mba mbaVar = this.a;
                if (j == mbaVar.h && i == 0) {
                    mbaVar.l = false;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mba a;

        public c(mba mbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mbaVar;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.a.m.removeFans(this.a.h);
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(mba mbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mba a;

        public e(mba mbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mbaVar;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                mba mbaVar = this.a;
                if (mbaVar.h > 0) {
                    if (mbaVar.e.getMaskType() == 1) {
                        this.a.e.removeFromBlackList(this.a.h);
                    } else {
                        this.a.e.addToBlackList(this.a.h);
                    }
                }
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(mba mbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends SocketMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mba a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(mba mbaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mbaVar, Integer.valueOf(i)};
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
            this.a = mbaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() != 10) {
                    return;
                }
                if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                    this.a.e.setMaskType(1);
                } else {
                    this.a.e.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() != 0) {
                    if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                        errorString = this.a.d.getResources().getString(R.string.obfuscated_res_0x7f0f0e70);
                    } else {
                        errorString = responseUpdateMaskInfoMessage.getErrorString();
                    }
                    this.a.d.showToast(errorString);
                } else if (this.a.e.getMaskType() == 1) {
                    TbPageContext tbPageContext = this.a.d;
                    tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0421));
                } else {
                    TbPageContext tbPageContext2 = this.a.d;
                    tbPageContext2.showToast(tbPageContext2.getString(R.string.remove_succ));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends SocketMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mba a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(mba mbaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mbaVar, Integer.valueOf(i)};
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
            this.a = mbaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, socketResponsedMessage) != null) || !(socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
                return;
            }
            ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
            int error = responseDeleteFriendMessage.getError();
            String errorString2 = responseDeleteFriendMessage.getErrorString();
            if (error == 0) {
                this.a.f(false);
            } else {
                if (StringUtils.isNull(responseDeleteFriendMessage.getErrorString())) {
                    errorString = this.a.d.getResources().getString(R.string.obfuscated_res_0x7f0f0e70);
                } else {
                    errorString = responseDeleteFriendMessage.getErrorString();
                }
                errorString2 = errorString;
            }
            this.a.d.showToast(errorString2);
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mba a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(mba mbaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mbaVar, Integer.valueOf(i)};
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
            this.a = mbaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                this.a.f(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mba a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(mba mbaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mbaVar, Integer.valueOf(i)};
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
            this.a = mbaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                return;
            }
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                this.a.f(false);
            } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                this.a.f(true);
            }
        }
    }

    public mba(TbPageContext tbPageContext, iba ibaVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ibaVar, blackListModel, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new g(this, 104102);
        this.p = new h(this, 304102);
        this.q = new i(this, 2001174);
        this.r = new j(this, 2001174);
        this.s = new a(this, 304103);
        this.d = tbPageContext;
        this.b = ibaVar;
        this.e = blackListModel;
        this.k = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, q4b.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            q4b q4bVar = (q4b) runTask.getData();
            this.c = q4bVar;
            q4bVar.b(bdUniqueId);
        }
        g();
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, this.k);
        this.m = removeFansController;
        removeFansController.setResultCallBack(new b(this));
    }

    public final void f(boolean z) {
        BlackListModel blackListModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f = z;
            qba qbaVar = this.j;
            if (qbaVar != null) {
                qbaVar.x(z);
            }
            h7a h7aVar = this.a;
            if (h7aVar != null && (blackListModel = this.e) != null) {
                boolean z2 = this.f;
                boolean z3 = true;
                if (blackListModel.getMaskType() != 1) {
                    z3 = false;
                }
                h7aVar.F(z2, z3, this.l);
            }
        }
    }

    public void e() {
        BlackListModel blackListModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b != null && (blackListModel = this.e) != null) {
            boolean z = true;
            if (blackListModel.getMaskType() != 1) {
                z = false;
            }
            j(this.f, z, this.b.e(), this.l);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o.setTag(this.k);
            this.p.setTag(this.k);
            this.s.setTag(this.k);
            this.r.setTag(this.k);
            this.q.setTag(this.k);
            this.d.registerListener(this.o);
            this.d.registerListener(this.p);
            this.d.registerListener(this.s);
            this.d.registerListener(this.r);
            this.d.registerListener(this.q);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.h == 0) {
            return;
        }
        f05 f05Var = new f05(this.d.getPageActivity());
        f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04d2, new c(this));
        f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new d(this));
        f05Var.setMessage(String.format(this.d.getString(R.string.obfuscated_res_0x7f0f126c), this.g));
        f05Var.create(this.d);
        f05Var.show();
    }

    public void h(qba qbaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, qbaVar) == null) && this.e != null && qbaVar != null && qbaVar.j() != null) {
            this.j = qbaVar;
            UserData j2 = qbaVar.j();
            this.f = qbaVar.l();
            BlackListModel blackListModel = this.e;
            boolean z = false;
            if (j2.isMask()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            blackListModel.setMaskType(i2);
            this.g = j2.getName_show();
            this.h = j2.getUserIdLong();
            this.i = j2.getPortrait();
            if (j2.getIsMyFans() == 1) {
                z = true;
            }
            this.l = z;
        }
    }

    public void i() {
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.g == null) {
            return;
        }
        f05 f05Var = new f05(this.d.getPageActivity());
        f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04d2, new e(this));
        f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new f(this));
        if (this.e.getMaskType() == 1) {
            format = String.format(this.d.getString(R.string.obfuscated_res_0x7f0f036a), this.g);
        } else {
            format = String.format(this.d.getString(R.string.obfuscated_res_0x7f0f036c), this.g);
        }
        f05Var.setMessage(format);
        f05Var.create(this.d);
        f05Var.show();
    }

    public final void j(boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) {
            h7a h7aVar = new h7a(this.d, this);
            this.a = h7aVar;
            h7aVar.F(z, z2, z3);
            if (i2 != -1) {
                this.a.E(i2);
            }
            qba qbaVar = this.j;
            if (qbaVar != null && qbaVar.j() != null) {
                this.a.G(this.j.j().getUserName());
            }
            this.a.onChangeSkinType();
            g7a g7aVar = new g7a(this.d.getPageActivity(), this.a.C());
            this.n = g7aVar;
            g7aVar.show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, view2) != null) || view2 == null) {
            return;
        }
        yb.a(this.n, this.d.getPageActivity());
        if (this.a.g() != null && view2.getId() == this.a.g().getId()) {
            i();
        } else if (this.a.x() != null && view2.getId() == this.a.x().getId()) {
            if (this.f) {
                RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                requestDeleteFriendMessage.setFriendId(this.h);
                MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.d.getPageActivity(), String.valueOf(this.h), this.g, this.i, null, false, null)));
        } else if (this.a.y() != null && view2.getId() == this.a.y().getId()) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.d.showToast(R.string.obfuscated_res_0x7f0f0e70);
                return;
            }
            iba ibaVar = this.b;
            if (ibaVar == null) {
                return;
            }
            if (ibaVar.e() == 0) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.h), this.g, null, null, 0, this.b.d(), this.b.f());
                userMuteAddAndDelCustomMessage.mId = this.b.f();
                iba ibaVar2 = this.b;
                ibaVar2.j(false, userMuteAddAndDelCustomMessage, ibaVar2.d(), this.g);
            } else if (this.b.e() == 1) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.h), this.g, null, null, 0, this.b.d(), this.b.f());
                userMuteAddAndDelCustomMessage2.mId = this.b.f();
                this.b.j(true, userMuteAddAndDelCustomMessage2, null, this.g);
            }
        } else if (this.a.A() != null && view2.getId() == this.a.A().getId()) {
            if (this.c != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 1));
                this.c.c(String.valueOf(this.h));
            }
        } else if (this.a.z() != null && view2.getId() == this.a.z().getId()) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showToast(this.d.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0e70);
            } else {
                k();
            }
        }
    }
}
