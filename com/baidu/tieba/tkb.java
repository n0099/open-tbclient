package com.baidu.tieba;

import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.f05;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tkb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<?> a;
    @NonNull
    public final yhb b;
    @NonNull
    public final vkb c;
    @Nullable
    public EditText d;
    @Nullable
    public EditText e;
    public final Runnable f;
    public final NewWriteModel.d g;

    /* loaded from: classes8.dex */
    public class b implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tkb a;

        /* loaded from: classes8.dex */
        public class a implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
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

        /* renamed from: com.baidu.tieba.tkb$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0485b implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0485b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                    PayPanelUtils.launchPayPanel(this.a.a.a, IMConstants.IM_MSG_TYPE_ADVISORY_EVALUATION, MemberPayStatistic.REFER_PAGE_POSTING);
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 1));
                }
            }
        }

        public b(tkb tkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tkbVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o95 o95Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o95Var, writeData, antiData}) != null) || postWriteCallBackData == null) {
                return;
            }
            this.a.b.m(null);
            if (z) {
                return;
            }
            if (postWriteCallBackData.isSensitiveError()) {
                this.a.b.n(postWriteCallBackData.getErrorString());
                this.a.b.m(postWriteCallBackData.getSensitiveWords());
                this.a.b.h(this.a.d, this.a.e);
            } else if (postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (this.a.a.getPageActivity() == null) {
                    return;
                }
                if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.q(this.a.a.getPageActivity(), this.a.a.getPageActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                } else {
                    DefaultNavigationBarCoverTip.q(this.a.a.getPageActivity(), postWriteCallBackData.getErrorString(), null).s();
                }
            } else if (postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                if (this.a.a.getPageActivity() == null) {
                    return;
                }
                f05 f05Var = new f05(this.a.a.getPageActivity());
                if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                    f05Var.setMessage(this.a.a.getPageActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    f05Var.setMessage(postWriteCallBackData.getErrorString());
                }
                f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new a(this));
                f05Var.setPositiveButton(R.string.open_now, new C0485b(this));
                f05Var.create(this.a.a).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
            } else if ((o95Var == null || writeData == null || o95Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData.getErrorCode() != 227001 && !d5b.d(postWriteCallBackData.getErrorCode())) {
                this.a.c.b(postWriteCallBackData);
            } else if (o95Var != null && writeData != null && o95Var.c() != null) {
                if (writeData.isCanNoForum()) {
                    writeData.setForumName("");
                    writeData.setForumId("0");
                }
                writeData.setVcodeMD5(o95Var.b());
                writeData.setVcodeUrl(o95Var.c());
                writeData.setVcodeExtra(o95Var.a());
                if (VcodeTool.needVcode(o95Var.d())) {
                    this.a.a.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.a.getPageActivity(), 12006, writeData, false, o95Var.d())));
                } else {
                    this.a.a.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.a.getPageActivity(), writeData, 12006)));
                }
            } else if (postWriteCallBackData.getErrorCode() == 227001) {
                this.a.a.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tkb a;

        public a(tkb tkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tkbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tkbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g.callback(false, nya.d, nya.e, nya.f, nya.g);
            }
        }
    }

    public tkb(@NonNull TbPageContext<?> tbPageContext, @NonNull yhb yhbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, yhbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.g = new b(this);
        this.a = tbPageContext;
        this.b = yhbVar;
        this.c = new vkb(tbPageContext);
    }

    public void i(@Nullable EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editText) == null) {
            this.e = editText;
        }
    }

    public void j(@Nullable EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, editText) == null) {
            this.d = editText;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.f);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SafeHandler.getInst().postDelayed(this.f, 500L);
        }
    }
}
