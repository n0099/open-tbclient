package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.f05;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.p05;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
/* loaded from: classes7.dex */
public class nm6 extends n05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w4 A;
    public final p05.f B;
    public TbPageContext l;
    public Context m;
    public final p05 n;
    public AlertDialog o;
    public AlertDialog p;
    public f05 q;
    public Dialog r;
    public final List<l05> s;
    public String t;
    public String u;
    public List<BlueCheckRadioButton> v;
    public ThreadData w;
    public ForumManageModel x;
    public boolean y;
    public final CompoundButton.OnCheckedChangeListener z;

    /* loaded from: classes7.dex */
    public class h extends w4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        /* loaded from: classes7.dex */
        public class a implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
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
                if ((interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) && f05Var != null) {
                    f05Var.dismiss();
                }
            }
        }

        public h(nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            String a0;
            String a02;
            String a03;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.a.x != null) {
                ViewGroup viewGroup = (ViewGroup) this.a.Z();
                switch (this.a.x.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.d != 0) {
                            if (bVar.h) {
                                new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.a0(R.string.shield_fail, new Object[0])).show(viewGroup);
                                return;
                            } else {
                                new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.a0(R.string.delete_fail, new Object[0])).show(viewGroup);
                                return;
                            }
                        } else if (bVar.a) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.w.getId()));
                            if (bVar.h) {
                                new BdTopToast(this.a.getContext()).setIcon(true).setContent(this.a.a0(R.string.shield_success, new Object[0])).show(viewGroup);
                                return;
                            } else {
                                new BdTopToast(this.a.getContext()).setIcon(true).setContent(this.a.a0(R.string.delete_success, new Object[0])).show(viewGroup);
                                return;
                            }
                        } else {
                            if (!TextUtils.isEmpty(bVar.b)) {
                                a0 = bVar.b;
                            } else {
                                a0 = this.a.a0(R.string.delete_fail, new Object[0]);
                            }
                            if (bVar.c == 1211066) {
                                if (this.a.q == null) {
                                    nm6 nm6Var = this.a;
                                    nm6Var.q = new f05(nm6Var.l.getPageActivity());
                                    this.a.q.setMessage(a0);
                                    this.a.q.setPositiveButton(R.string.dialog_known, new a(this));
                                    this.a.q.setCancelable(true);
                                    this.a.q.create(this.a.l);
                                }
                                this.a.q.show();
                                return;
                            }
                            new BdTopToast(this.a.getContext()).setIcon(false).setContent(a0).show(viewGroup);
                            return;
                        }
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        if (dVar == null) {
                            BdUtilHelper.showToast(this.a.m, this.a.a0(R.string.mute_fail, new Object[0]));
                            return;
                        } else if (dVar.a) {
                            if (!TextUtils.isEmpty(dVar.b)) {
                                a03 = dVar.b;
                            } else {
                                a03 = this.a.a0(R.string.mute_success, new Object[0]);
                            }
                            BdUtilHelper.showToast(this.a.m, a03);
                            return;
                        } else {
                            if (!TextUtils.isEmpty(dVar.b)) {
                                a02 = dVar.b;
                            } else {
                                a02 = this.a.a0(R.string.mute_fail, new Object[0]);
                            }
                            BdUtilHelper.showToast(this.a.m, a02);
                            return;
                        }
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        nm6 nm6Var2 = this.a;
                        nm6Var2.Y(nm6Var2.x.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        if (gVar == null || !gVar.a) {
                            BdUtilHelper.showToast(this.a.m, this.a.a0(R.string.operation_failed, new Object[0]));
                            return;
                        } else {
                            this.a.i0(gVar.c);
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        public a(nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o != null) {
                    this.a.o.dismiss();
                }
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    BdUtilHelper.showToast(this.a.m, (int) R.string.obfuscated_res_0x7f0f0e70);
                } else {
                    this.a.j0(null, false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        public b(nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.o != null) {
                this.a.o.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        public c(nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.p != null) {
                    this.a.p.dismiss();
                }
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    BdUtilHelper.showToast(this.a.m, (int) R.string.obfuscated_res_0x7f0f0e70);
                    return;
                }
                this.a.j0(null, true);
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_CONFIRM_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", this.a.w.getId());
                statisticItem.param("fid", this.a.w.getFid());
                statisticItem.param("fname", this.a.w.getForum_name());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        public d(nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.p != null) {
                    this.a.p.dismiss();
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_CANCEL_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", this.a.w.getId());
                statisticItem.param("fid", this.a.w.getFid());
                statisticItem.param("fname", this.a.w.getForum_name());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        public e(nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                yb.b(this.a.r, this.a.l);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        public f(nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                yb.b(this.a.r, this.a.l);
                nm6 nm6Var = this.a;
                nm6Var.l0(nm6Var.u, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        public g(nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z && (compoundButton.getTag() instanceof String)) {
                this.a.u = (String) compoundButton.getTag();
                if (this.a.v != null) {
                    for (BlueCheckRadioButton blueCheckRadioButton : this.a.v) {
                        String str = (String) blueCheckRadioButton.getTag();
                        if (str != null && this.a.u != null && !str.equals(this.a.u)) {
                            blueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        public i(nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                this.a.dismiss();
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(this.a.m, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (this.a.w != null && this.a.w.getAuthor() != null) {
                        if (UtilHelper.isCurrentAccount(this.a.w.getAuthor().getUserId())) {
                            this.a.h0();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new m16(1, this.a.x, this.a.w)));
                        }
                    }
                } else if (i == 9) {
                    if (this.a.w != null && this.a.w.getAuthor() != null) {
                        if (UtilHelper.isCurrentAccount(this.a.w.getAuthor().getUserId())) {
                            this.a.g0();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new m16(3, this.a.x, this.a.w)));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("tid", this.a.w.getId());
                            if (this.a.w.getForumData() != null) {
                                statisticItem.param("fid", this.a.w.getForumData().b());
                                statisticItem.param("fname", this.a.w.getForumData().d());
                            }
                            statisticItem.param("obj_source", 1);
                            TiebaStatic.log(statisticItem);
                        }
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_BAWU_FRS_MUSK_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("tid", this.a.w.getId());
                        statisticItem2.param("fid", this.a.w.getFid());
                        statisticItem2.param("fname", this.a.w.getForum_name());
                        TiebaStatic.log(statisticItem2);
                    }
                } else if (i == 2) {
                    this.a.k0();
                } else if (i == 3) {
                    this.a.m0();
                } else if (i == 4) {
                    nm6 nm6Var = this.a;
                    nm6Var.l0(nm6Var.t, true);
                } else if (i == 5) {
                    this.a.Q();
                } else if (i == 10) {
                    this.a.P();
                    StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_BAWU_MULTI_MUSK_CLICK);
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem3.param("tid", this.a.w.getId());
                    statisticItem3.param("fid", this.a.w.getFid());
                    statisticItem3.param("fname", this.a.w.getForum_name());
                    TiebaStatic.log(statisticItem3);
                } else if (i == 6) {
                    this.a.e0();
                } else if (i == 7) {
                    this.a.O();
                } else if (i == 8) {
                    this.a.N();
                }
                this.a.c0(i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nm6(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = "0";
        this.u = "0";
        this.y = false;
        this.z = new g(this);
        this.A = new h(this);
        this.B = new i(this);
        this.l = tbPageContext;
        this.m = tbPageContext.getPageActivity();
        this.s = new ArrayList();
        p05 p05Var = new p05(this.m);
        this.n = p05Var;
        p05Var.u(a0(R.string.thread_manager, new Object[0]));
        this.n.r(this.B);
        ForumManageModel forumManageModel = new ForumManageModel(this.l);
        this.x = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.A);
        this.y = z;
        h(this.n);
    }

    public void f0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, threadData) == null) {
            this.w = threadData;
            S();
        }
    }

    public final String a0(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, objArr)) == null) {
            Context context = this.m;
            if (context == null) {
                return null;
            }
            return context.getString(i2, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public final String b0(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return a0(i2, new Object[0]);
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.w));
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            xr7.h().p(true, false);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            yr7.f().o(false);
            yr7.f().p(true, false);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            U();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            W();
            V();
            X();
            dismiss();
        }
    }

    public void V() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (alertDialog = this.p) != null && alertDialog.isShowing()) {
            this.p.dismiss();
        }
    }

    public void W() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (alertDialog = this.o) != null && alertDialog.isShowing()) {
            this.o.dismiss();
        }
    }

    public void X() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (dialog = this.r) != null && dialog.isShowing()) {
            this.r.dismiss();
        }
    }

    public final View Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Context context = this.m;
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            p05 p05Var = this.n;
            if (p05Var != null) {
                p05Var.k();
            }
            f05 f05Var = this.q;
            if (f05Var != null) {
                jq5.a(this.l, f05Var.getRealView());
            }
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            yr7.f().o(true);
            yr7.f().p(true, false);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.w.getId());
            statisticItem.param("fid", this.w.getFid());
            statisticItem.param("fname", this.w.getForum_name());
            TiebaStatic.log(statisticItem);
        }
    }

    public final BlueCheckRadioButton R(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.m);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, BdUtilHelper.getDimens(this.m, R.dimen.obfuscated_res_0x7f07019a));
            blueCheckRadioButton.setOnCheckedChangeListener(this.z);
            blueCheckRadioButton.setTag(str);
            blueCheckRadioButton.setText(str2);
            blueCheckRadioButton.setLayoutParams(layoutParams);
            return blueCheckRadioButton;
        }
        return (BlueCheckRadioButton) invokeLL.objValue;
    }

    public final void l0(String str, boolean z) {
        ThreadData threadData;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048600, this, str, z) == null) && (threadData = this.w) != null && this.x != null) {
            if (threadData.getIs_good() == 1) {
                i2 = 3;
            } else if (z) {
                i2 = 6;
            } else {
                i2 = 2;
            }
            String id = this.w.getId();
            this.x.l0(String.valueOf(this.w.getFid()), this.w.getForum_name(), id, i2, str);
        }
    }

    public final void S() {
        List<l05> list;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        boolean z4;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.w != null && (list = this.s) != null && this.n != null) {
            list.clear();
            if (gs7.d(gs7.a()) && !gs7.f()) {
                boolean isBjh = this.w.isBjh();
                if (this.w.getAuthor() != null && this.w.getAuthor().isForumBusinessAccount() && !this.w.isSelf() && !xt7.isOn()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean g2 = gs7.g();
                boolean isWorksInfo = this.w.isWorksInfo();
                boolean isScoreThread = this.w.isScoreThread();
                if (this.w.isTiePlusCantDeleteUnion() && !this.w.isSelf()) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("ThreadManage", "isBjh: " + isBjh + "   officialThreadCondition: " + z3 + "   isForumMask: " + g2 + "   isWorkInfo: " + isWorksInfo + "   isScoreThread: " + isScoreThread + "   tiePlusCondition: " + z4);
                if (!isBjh && !z3 && !g2 && !isWorksInfo && !isScoreThread && z4) {
                    this.s.add(new l05(1, a0(R.string.delete_page, new Object[0]), this.n));
                }
                if (this.w.isWorksInfo() || this.w.isScoreThread() || (gs7.g() && !this.w.isBjh() && (this.w.getAuthor() == null || !this.w.getAuthor().isForumBusinessAccount() || this.w.isSelf() || xt7.isOn()))) {
                    this.s.add(new l05(9, a0(R.string.forum_shield, new Object[0]), this.n));
                }
                if (this.w.getAuthor() != null) {
                    str = this.w.getAuthor().getUserId();
                } else {
                    str = "";
                }
                if (!UtilHelper.isCurrentAccount(str) && ((this.w.getAuthor() == null || !this.w.getAuthor().isForumBusinessAccount()) && !this.w.isTiePlusCantDeleteUnion())) {
                    this.s.add(new l05(2, a0(R.string.thread_forbid, new Object[0]), this.n));
                }
            }
            if (gs7.e() || gs7.f()) {
                if (this.w.getIs_top() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    i2 = R.string.cancel_top;
                } else {
                    i2 = R.string.obfuscated_res_0x7f0f1719;
                }
                this.s.add(new l05(3, a0(i2, new Object[0]), this.n));
            }
            if (gs7.e() || gs7.h()) {
                if (this.w.getIs_good() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    i3 = R.string.cancel_good;
                } else {
                    i3 = R.string.commit_good;
                }
                this.s.add(new l05(4, a0(i3, new Object[0]), this.n));
            }
            if (gs7.e()) {
                this.s.add(new l05(6, a0(R.string.frs_recommend_thread, new Object[0]), this.n));
            }
            if (gs7.e() || gs7.f()) {
                this.s.add(new l05(8, a0(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.n));
            }
            if (gs7.e() && this.y) {
                this.s.add(new l05(7, a0(R.string.frs_move_area_thread, new Object[0]), this.n));
            }
            if (!gs7.f() && yr7.f().j() && this.y && ((this.w.getAuthor() == null || !this.w.getAuthor().isForumBusinessAccount() || this.w.isSelf() || xt7.isOn()) && !gs7.g())) {
                this.s.add(new l05(5, a0(R.string.multi_delete, new Object[0]), this.n));
            }
            if (gs7.g() && !gs7.f() && yr7.f().j() && this.y && (this.w.getAuthor() == null || !this.w.getAuthor().isForumBusinessAccount() || this.w.isSelf() || xt7.isOn())) {
                this.s.add(new l05(10, a0(R.string.multi_shield, new Object[0]), this.n));
            }
            if (gs7.g() && this.w.isSelf() && !this.w.isBjh()) {
                this.s.add(new l05(1, a0(R.string.obfuscated_res_0x7f0f055b, new Object[0]), this.n));
            }
            this.n.m(this.s);
        }
    }

    public final void Y(int i2, ForumManageModel.g gVar) {
        String a0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, gVar) == null) {
            ThreadData threadData = this.w;
            if (threadData != null && gVar != null && gVar.a) {
                String str = "";
                boolean z = true;
                if (i2 == 2) {
                    threadData.setIs_good(1);
                    jx4 jx4Var = new jx4();
                    jx4Var.a = 2;
                    jx4Var.b = this.w.getTid();
                    if (gs7.e()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, jx4Var));
                    } else {
                        str = b0(gVar.b, R.string.set_good_success);
                        z = false;
                    }
                } else {
                    if (i2 == 3) {
                        threadData.setIs_good(0);
                        str = b0(gVar.b, R.string.operation_success);
                    } else if (i2 == 4) {
                        threadData.setIs_top(1);
                        jx4 jx4Var2 = new jx4();
                        jx4Var2.a = 1;
                        jx4Var2.b = this.w.getTid();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, jx4Var2));
                    } else if (i2 == 5) {
                        threadData.setIs_top(0);
                        str = b0(gVar.b, R.string.operation_success);
                    }
                    z = false;
                }
                ForumManageModel.e eVar = new ForumManageModel.e();
                eVar.a = this.w.getId();
                eVar.c = this.w.getForum_name();
                eVar.b = String.valueOf(this.w.getFid());
                eVar.d = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
                if (TextUtils.isEmpty(str)) {
                    str = a0(R.string.operation_success, new Object[0]);
                }
                if (!z) {
                    BdUtilHelper.showToast(this.m, str);
                    return;
                }
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                a0 = gVar.b;
            } else {
                a0 = a0(R.string.operation_failed, new Object[0]);
            }
            BdUtilHelper.showToast(this.m, a0);
        }
    }

    public final void c0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048591, this, i2) != null) || this.w == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.w.getFid()).param("tid", this.w.getId()));
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.l != null && this.w != null) {
            BawuThrones b2 = zr7.c().b();
            if (b2 == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (b2.total_recommend_num.intValue() == b2.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (SharedPrefHelper.getInstance().getBoolean("key_frs_recommend_tip", true)) {
                zr7.c().f(this.l, String.valueOf(this.w.getFid()), this.w.getId());
            } else {
                zr7.c().d(String.valueOf(this.w.getFid()), this.w.getId());
            }
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            W();
            if (this.l == null) {
                return;
            }
            TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f055b, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03db, TBAlertConfig.OperateBtnStyle.SECONDARY);
            this.o = new TBAlertBuilder(this.l.getPageActivity()).setTitle(R.string.del_my_thread_confirm).setDesc(R.string.del_my_thread_confirm_subtitle).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
            operateBtnConfig.setListener(new a(this));
            operateBtnConfig2.setListener(new b(this));
        }
    }

    public final void k0() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.m != null && (threadData = this.w) != null && threadData.getAuthor() != null) {
            String userId = this.w.getAuthor().getUserId();
            String userName = this.w.getAuthor().getUserName();
            String name_show = this.w.getAuthor().getName_show();
            String id = this.w.getId();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.m, String.valueOf(this.w.getFid()), this.w.getForum_name(), id, userId, userName, name_show, null, this.w.getAuthor().getPortrait())));
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            V();
            if (this.l == null) {
                return;
            }
            TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f1429, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03db, TBAlertConfig.OperateBtnStyle.SECONDARY);
            this.p = new TBAlertBuilder(this.l.getPageActivity()).setTitle(R.string.musk_my_thread_confirm).setDesc(R.string.musk_my_thread_confirm_subtitle).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
            operateBtnConfig.setListener(new c(this));
            operateBtnConfig2.setListener(new d(this));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.w.getId());
            statisticItem.param("fid", this.w.getFid());
            statisticItem.param("fname", this.w.getForum_name());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void i0(ArrayList<wx4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) {
            if (this.r == null) {
                View inflate = LayoutInflater.from(this.m).inflate(R.layout.commit_good, (ViewGroup) null);
                Dialog dialog = new Dialog(this.m, R.style.obfuscated_res_0x7f1003c6);
                this.r = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.r.setCancelable(true);
                this.r.setContentView(inflate);
                WindowManager.LayoutParams attributes = this.r.getWindow().getAttributes();
                attributes.width = BdUtilHelper.getDimens(this.m, R.dimen.obfuscated_res_0x7f0703f6);
                this.r.getWindow().setAttributes(attributes);
                inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new e(this));
                inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new f(this));
            }
            jq5.a(this.l, this.r.findViewById(R.id.commit_good_layout));
            LinearLayout linearLayout = (LinearLayout) this.r.findViewById(R.id.good_class_group);
            linearLayout.removeAllViews();
            this.v = new ArrayList();
            BlueCheckRadioButton R = R(this.t, a0(R.string.thread_good_class, new Object[0]));
            R.setChecked(true);
            linearLayout.addView(R);
            this.v.add(R);
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    wx4 wx4Var = arrayList.get(i2);
                    if (wx4Var != null && !TextUtils.isEmpty(wx4Var.b()) && wx4Var.a() > 0) {
                        BlueCheckRadioButton R2 = R(String.valueOf(wx4Var.a()), wx4Var.b());
                        this.v.add(R2);
                        View view2 = new View(this.m);
                        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(this.m, R.dimen.obfuscated_res_0x7f070198)));
                        linearLayout.addView(view2);
                        linearLayout.addView(R2);
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                    }
                }
                ScrollView scrollView = (ScrollView) this.r.findViewById(R.id.good_scroll);
                ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
                int size2 = arrayList.size();
                if (size2 != 0 && size2 != 1) {
                    if (size2 != 2) {
                        layoutParams.height = BdUtilHelper.dip2px(this.m, 220.0f);
                    } else {
                        layoutParams.height = BdUtilHelper.dip2px(this.m, 186.0f);
                    }
                } else {
                    layoutParams.height = BdUtilHelper.dip2px(this.m, 120.0f);
                }
                scrollView.setLayoutParams(layoutParams);
                scrollView.removeAllViews();
                scrollView.addView(linearLayout);
            }
            yb.j(this.r, this.l);
        }
    }

    public final void j0(JSONArray jSONArray, boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048598, this, jSONArray, z) == null) && this.x != null && (threadData = this.w) != null && threadData.getAuthor() != null) {
            String userId = this.w.getAuthor().getUserId();
            String id = this.w.getId();
            String forum_name = this.w.getForum_name();
            String valueOf = String.valueOf(this.w.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.x.j0(StringHelper.JsonArrayToString(jSONArray));
            }
            this.x.k0(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, this.w.getBaijiahaoData(), z);
        }
    }

    public final void m0() {
        ThreadData threadData;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (threadData = this.w) != null && this.x != null) {
            if (threadData.getIs_top() == 1) {
                i2 = 5;
            } else {
                i2 = 4;
            }
            String id = this.w.getId();
            this.x.l0(String.valueOf(this.w.getFid()), this.w.getForum_name(), id, i2, null);
        }
    }
}
