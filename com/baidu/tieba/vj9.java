package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.p55;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.adapter.PbAdCardGiftItemResponseMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public we9 b;
    public LikeModel c;
    public ze9 d;
    public AlertDialog e;
    public k9 f;
    public AntiHelper.k g;

    /* loaded from: classes8.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vj9 vj9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj9Var, Integer.valueOf(i)};
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
            this.a = vj9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof PbAdCardGiftItemResponseMessage)) {
                PbAdCardGiftItemResponseMessage pbAdCardGiftItemResponseMessage = (PbAdCardGiftItemResponseMessage) httpResponsedMessage;
                if (pbAdCardGiftItemResponseMessage.getError() == 0 && pbAdCardGiftItemResponseMessage.getData() != null) {
                    this.a.x(pbAdCardGiftItemResponseMessage.getData());
                } else if (pbAdCardGiftItemResponseMessage.getError() != 502014 && pbAdCardGiftItemResponseMessage.getError() != 502015) {
                    this.a.a.showToast(pbAdCardGiftItemResponseMessage.getErrorString());
                } else {
                    this.a.w(pbAdCardGiftItemResponseMessage.getError(), pbAdCardGiftItemResponseMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ vj9 b;

        public b(vj9 vj9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vj9Var;
            this.a = i;
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, p55Var) != null) || vx5.a()) {
                return;
            }
            if (this.a == 502014) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.b.a.getActivity()).createNormalCfg(this.b.d.k().getName(), FrsActivityConfig.FRS_PB_CARD_GIFT);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (!this.b.a.checkUpIsLogin()) {
                return;
            } else {
                if (this.b.c == null) {
                    vj9 vj9Var = this.b;
                    vj9Var.c = new LikeModel(vj9Var.a.getPageContext());
                    this.b.c.setLoadDataCallBack(this.b.f);
                }
                this.b.c.setFrom(FrsActivityConfig.FRS_PB_CARD_GIFT);
                this.b.c.n0(this.b.d.k().getName(), String.valueOf(this.b.d.k().getId()));
            }
            p55Var.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(vj9 vj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj9 a;

        public d(vj9 vj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vj9Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.p();
        }
    }

    /* loaded from: classes8.dex */
    public class e extends k9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj9 a;

        public e(vj9 vj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vj9Var;
        }

        @Override // com.baidu.tieba.k9
        public void c(Object obj) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.a.d != null && this.a.d.k() != null && obj != null) {
                if (AntiHelper.m(this.a.c.getErrorCode(), this.a.c.getErrorString())) {
                    if (AntiHelper.t(this.a.a.getContext(), this.a.c.k0(), this.a.g) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String id = this.a.d.k().getId();
                yba ybaVar = null;
                if (obj instanceof yba) {
                    ybaVar = (yba) obj;
                }
                boolean z2 = false;
                if (ybaVar != null && this.a.c.getErrorCode() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (ybaVar != null && ybaVar.d() == 3250013) {
                    BdToast b = BdToast.b(TbadkCoreApplication.getInst().getContext(), ybaVar.e());
                    b.g(BdToast.ToastIcon.FAILURE);
                    b.d(3000);
                    b.q();
                } else {
                    z2 = z;
                }
                if (ybaVar != null && z2) {
                    ybaVar.y(1);
                    this.a.t(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, ybaVar));
                } else if (this.a.c.getErrorCode() == 22) {
                    this.a.a.showToast(this.a.a.getPageContext().getPageActivity().getString(R.string.had_liked_forum));
                } else {
                    this.a.a.showToast(this.a.c.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(vj9 vj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj9 a;

        public g(vj9 vj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vj9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e.dismiss();
                vj9 vj9Var = this.a;
                vj9Var.n(vj9Var.b);
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.a.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj9 a;

        public h(vj9 vj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vj9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj9 a;

        public i(vj9 vj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vj9Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.p();
        }
    }

    public vj9(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new e(this);
        this.g = new f(this);
        this.a = pbFragment;
        r();
        s();
    }

    public final void t(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) {
            tf8.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void v(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ze9Var) == null) {
            this.d = ze9Var;
        }
    }

    public final void n(we9 we9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, we9Var) != null) || we9Var == null) {
            return;
        }
        aba.g().c(this.a.getUniqueId(), yaa.c(this.d.N(), "a005", "common_click", 1, we9Var.b, true, we9Var.a.a + "", "", 19));
    }

    public void u(we9 we9Var) {
        ze9 ze9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, we9Var) == null) && we9Var != null && we9Var.a != null && (ze9Var = this.d) != null && ze9Var.N() != null) {
            this.b = we9Var;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
            httpMessage.addParam("tid", this.d.N().getTid());
            httpMessage.addParam("packet_id", we9Var.a.a);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void o(we9 we9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, we9Var) != null) || we9Var == null) {
            return;
        }
        String tid = this.d.N().getTid();
        aba.g().d(this.a.getUniqueId(), yaa.b(tid, str, "", null) + "_dialog", yaa.d(this.d.N(), "a005", "common_exp", we9Var.b, true, we9Var.a.a + "", "", 19));
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LikeModel likeModel = this.c;
            if (likeModel != null) {
                likeModel.j0();
            }
            AlertDialog alertDialog = this.e;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.registerListener(new a(this, CmdConfigHttp.CMD_GET_CARD_GIFT_REQ));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ, TbConfig.SERVER_ADDRESS + TbConfig.PB_CARD_GIFT_GET_URL);
            tbHttpMessageTask.setResponsedClass(PbAdCardGiftItemResponseMessage.class);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void w(int i2, String str) {
        int i3;
        int i4;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            if (i2 == 502014) {
                i3 = R.string.obfuscated_res_0x7f0f0fad;
                i4 = R.string.obfuscated_res_0x7f0f03ce;
                string = this.a.getPageContext().getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0fae);
            } else {
                i3 = R.string.obfuscated_res_0x7f0f0faa;
                i4 = R.string.obfuscated_res_0x7f0f0fab;
                string = this.a.getPageContext().getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0fac, this.d.k().getName());
                str = "";
            }
            p55 p55Var = new p55(this.a.getPageContext().getPageActivity());
            p55Var.setTitle(str);
            p55Var.setMessage(string);
            p55Var.setPositiveButton(i3, new b(this, i2));
            p55Var.setNegativeButton(i4, new c(this));
            p55Var.setOnDismissListener(new d(this));
            p55Var.setTitleShowCenter(true);
            p55Var.setNegativeTextColor(R.color.CAM_X0105);
            p55Var.setCanceledOnTouchOutside(true);
            p55Var.create(this.a.getPageContext()).show();
        }
    }

    public final void x(xe9 xe9Var) {
        we9 we9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xe9Var) == null) {
            we9 we9Var2 = this.b;
            if (we9Var2 != null) {
                we9Var2.a = xe9Var;
            }
            ze9 ze9Var = this.d;
            if (ze9Var != null && (we9Var = ze9Var.l) != null) {
                we9Var.a = xe9Var;
            }
            o(this.b);
            AlertDialog create = new AlertDialog.Builder(this.a.getPageContext().getPageActivity()).create();
            this.e = create;
            GreyUtil.grey(create);
            this.e.setCanceledOnTouchOutside(false);
            bh.i(this.e, this.a.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d077d, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0903d5);
            tbImageView.setRadius(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds30));
            tbImageView.setConrers(3);
            tbImageView.setDrawCorner(true);
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f081206);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0904a1);
            textView.setOnClickListener(new g(this));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0904a0);
            imageView.setOnClickListener(new h(this));
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092786);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092788);
            textView3.setText(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0fb4, new Object[]{xe9Var.c}));
            textView2.setText(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0fb3, new Object[]{xe9Var.f}));
            SkinManager.setImageResource(imageView, R.drawable.icon_use_close_n);
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092787), (int) R.color.CAM_X0107);
            SkinManager.setBackgroundResource(textView, R.drawable.btn_pb_ad_card_gift_get);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0112);
            this.e.setOnDismissListener(new i(this));
            Window window = this.e.getWindow();
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ee);
            window.setGravity(17);
            window.setLayout(-2, -2);
            window.setContentView(inflate);
        }
    }
}
