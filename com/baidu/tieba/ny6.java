package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.message.ForumGuideHttpResponseMessage;
import com.baidu.tieba.enterForum.message.ForumGuideRequestMessage;
import com.baidu.tieba.enterForum.message.ForumGuideSocketResponseMessage;
import com.baidu.tieba.enterForum.message.SetLikeForumHttpResponseMessage;
import com.baidu.tieba.enterForum.message.SetLikeForumSocketResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.i95;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingCache;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.m45;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class ny6 implements ql5, hq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i95.g A;
    public EnterForumFragment a;
    public d07 b;
    public EnterForumModel c;
    public RecentlyVisitedForumModel d;
    public rja e;
    public boolean f;
    public boolean g;
    public boolean h;
    public String i;
    public BaseFragmentActivity j;
    public long k;
    public boolean l;
    public LikeModel m;
    public ViewEventCenter n;
    public BlueCircleProgressDialog o;
    public int p;
    public h07 q;
    public boolean r;
    public View s;
    public final hz6 t;
    public boolean u;
    public CustomMessageListener v;
    public NetMessageListener w;
    public NetMessageListener x;
    public h9 y;
    public final EnterForumModel.f z;

    @Override // com.baidu.tieba.ql5
    public void a(BdImage bdImage, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048599, this, bdImage, str, z) != null) || bdImage == null) {
        }
    }

    @Override // com.baidu.tieba.hq5
    public boolean h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements i95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny6 a;

        public a(ny6 ny6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ny6Var;
        }

        @Override // com.baidu.tieba.i95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                EnterForumDelegateStatic.c.T();
                this.a.c.Y(!StringUtils.isNull(this.a.i));
                this.a.d.loadData();
                this.a.c.m0(true);
                TbadkCoreApplication.getInst().setLikeBarChanged(false);
                this.a.t.h();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public b(ny6 ny6Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny6Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.a)) {
                    return null;
                }
                OfficialSettingCache.getInstance().saveAcceptNotify(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a), this.b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ny6 ny6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny6Var, Integer.valueOf(i)};
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
            this.a = ny6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.h = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ny6 ny6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny6Var, Integer.valueOf(i)};
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
            this.a = ny6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.b != null && this.a.b.L()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements CustomMessageTask.CustomRunnable<k25> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny6 a;

        public e(ny6 ny6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ny6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<k25> run(CustomMessage<k25> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                k25 k25Var = new k25();
                ArrayList arrayList = new ArrayList();
                if (this.a.c != null && this.a.c.R() != null && this.a.c.R().e() != null && ListUtils.getCount(this.a.c.R().e().b()) > 0) {
                    Iterator<ey6> it = this.a.c.R().e().b().iterator();
                    while (it.hasNext()) {
                        ey6 next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(JavaTypesHelper.toLong(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.i());
                            hotTopicBussinessData.setForumAvatar(next.e());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    k25Var.a(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, k25Var);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ny6 ny6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = ny6Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof ForumGuideSocketResponseMessage;
                if ((!z && !(responsedMessage instanceof ForumGuideHttpResponseMessage)) || this.a.c.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                    return;
                }
                this.a.b.M();
                this.a.b.z = true;
                if (responsedMessage.hasError()) {
                    if (!this.a.u && responsedMessage.getError() == -100000303) {
                        if (responsedMessage.getOrginalMessage().getExtra() instanceof ForumGuideRequestMessage) {
                            this.a.c.Z(true, ((ForumGuideRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getSortType().intValue());
                            this.a.u = true;
                            return;
                        }
                        return;
                    } else if (this.a.b.Z()) {
                        this.a.b.F0(this.a.s);
                        return;
                    } else {
                        return;
                    }
                }
                if (z) {
                    this.a.c.e0((ForumGuideSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof ForumGuideHttpResponseMessage) {
                    this.a.c.d0((ForumGuideHttpResponseMessage) responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ny6 ny6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = ny6Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Activity currentActivity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if ((!(responsedMessage instanceof SetLikeForumSocketResponseMessage) && !(responsedMessage instanceof SetLikeForumHttpResponseMessage)) || (currentActivity = TbadkApplication.getInst().getCurrentActivity()) == null) {
                    return;
                }
                if (responsedMessage.getError() == 0) {
                    new BdTopToast(currentActivity, 2000).setIcon(true).setContent(this.a.j.getActivity().getString(R.string.obfuscated_res_0x7f0f0b84)).show((ViewGroup) currentActivity.findViewById(16908290));
                } else {
                    new BdTopToast(currentActivity, 2000).setIcon(false).setContent(responsedMessage.getErrorString()).show((ViewGroup) currentActivity.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey6 a;
        public final /* synthetic */ ny6 b;

        public h(ny6 ny6Var, ey6 ey6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny6Var, ey6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ny6Var;
            this.a = ey6Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                if (BdUtilHelper.isNetOk()) {
                    new m(this.b, this.a).execute(new ey6[0]);
                } else {
                    this.b.j.showToast(R.string.obfuscated_res_0x7f0f054f);
                }
                TiebaStatic.eventStat(this.b.j.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(ny6 ny6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends h9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny6 a;

        public j(ny6 ny6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ny6Var;
        }

        @Override // com.baidu.tieba.h9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.a.m.getErrorCode(), this.a.m.getErrorString())) {
                    AntiHelper.u(this.a.j.getPageContext().getPageActivity(), this.a.m.getErrorString());
                } else if (obj != null) {
                    this.a.c.Y(!StringUtils.isNull(this.a.i));
                } else if (!StringUtils.isNull(this.a.m.getErrorString())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), this.a.m.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements EnterForumModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny6 a;

        public k(ny6 ny6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ny6Var;
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) && eVar != null && this.a.a != null) {
                if (eVar.c == 1) {
                    this.a.b.M();
                }
                if (eVar.b) {
                    int i = eVar.c;
                    if (i == 1) {
                        this.a.g = true;
                        cy6 cy6Var = eVar.d;
                        this.a.M(cy6Var);
                        if (cy6Var.g() > 0) {
                            SharedPrefHelper.getInstance().putInt("key_LIKE_forum_sort_state", cy6Var.g());
                            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                            if (cy6Var.g() == 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            sharedPrefHelper.putBoolean("like_forum_sort_level", z);
                        }
                        if (cy6Var.e() != null && ListUtils.isNotEmpty(cy6Var.e().b())) {
                            ArrayList<ey6> b = cy6Var.e().b();
                            StringBuilder sb = new StringBuilder();
                            for (ey6 ey6Var : b) {
                                if (ey6Var != null && StringUtils.isNotNull(ey6Var.i())) {
                                    sb.append(ey6Var.i());
                                    sb.append("、");
                                }
                            }
                            TbLog a = zj.a();
                            a.e(Config.DEVICE_PART, "当前用户关注的吧有：" + sb.toString());
                        }
                    } else if (i == 0 && !this.a.g) {
                        cy6 cy6Var2 = eVar.d;
                        this.a.c.j0(cy6Var2);
                        this.a.M(cy6Var2);
                    }
                } else {
                    String str = eVar.a;
                    if (str != null && !str.equals("")) {
                        this.a.j.showToast(eVar.a);
                        this.a.b.h0(ux6.a(2));
                    }
                }
                if (eVar.c == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && this.a.G()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (eVar.c == 1 && this.a.k > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaStatic.OpKey.OP_FORUM_ENTER, currentTimeMillis - this.a.k, this.a.c.T() - this.a.k, this.a.c.V(), this.a.c.U(), currentTimeMillis - this.a.c.S());
                    this.a.k = -1L;
                }
                String string = this.a.j.getResources().getString(R.string.obfuscated_res_0x7f0f0669);
                cy6 cy6Var3 = eVar.d;
                if (cy6Var3 != null && cy6Var3.d() != null) {
                    HotSearchInfoData d = eVar.d.d();
                    SharedPrefHelper.getInstance().putString("hot_search_info", OrmObject.jsonStrWithObject(d));
                    if (d != null && d.N() != null) {
                        string = d.N();
                    }
                }
                this.a.T(string);
                cy6 cy6Var4 = eVar.d;
                if (cy6Var4 != null && cy6Var4.c() != null) {
                    this.a.b.t0(eVar.d.c());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends BdAsyncTask<ey6, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public ey6 b;
        public final /* synthetic */ ny6 c;

        public l(ny6 ny6Var, ey6 ey6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny6Var, ey6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ny6Var;
            this.a = null;
            this.b = null;
            this.b = ey6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(ey6... ey6VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ey6VarArr)) == null) {
                ey6 ey6Var = this.b;
                if (ey6Var != null) {
                    try {
                        if (ey6Var.getId() != null && ey6Var.i() != null) {
                            if (ey6Var.g() == 0) {
                                this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                            } else {
                                this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                            }
                            this.a.addPostData("forum_id", ey6Var.getId());
                            this.a.getNetContext().getRequest().mIsNeedTbs = true;
                            this.a.postNetData();
                            return null;
                        }
                        return null;
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.c.U(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((l) str);
                this.c.U(false);
                int g = this.b.g();
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.c.l = true;
                        if (this.c.a.isAdded() && this.c.j != null) {
                            BaseFragmentActivity baseFragmentActivity = this.c.j;
                            Activity activity = this.c.j.getActivity();
                            if (g > 0) {
                                i2 = R.string.obfuscated_res_0x7f0f066f;
                            } else {
                                i2 = R.string.obfuscated_res_0x7f0f066b;
                            }
                            baseFragmentActivity.showToast(activity.getString(i2));
                        }
                        this.c.c.Y(true);
                    } else if (this.c.j == null) {
                    } else {
                        if (!StringUtils.isNull(this.a.getErrorString())) {
                            this.c.j.showToast(this.a.getErrorString());
                        } else if (this.c.a.isAdded()) {
                            BaseFragmentActivity baseFragmentActivity2 = this.c.j;
                            Activity activity2 = this.c.j.getActivity();
                            if (g > 0) {
                                i = R.string.obfuscated_res_0x7f0f066e;
                            } else {
                                i = R.string.obfuscated_res_0x7f0f066a;
                            }
                            baseFragmentActivity2.showToast(activity2.getString(i));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends BdAsyncTask<ey6, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public ey6 b;
        public final /* synthetic */ ny6 c;

        public m(ny6 ny6Var, ey6 ey6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny6Var, ey6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ny6Var;
            this.a = null;
            this.b = null;
            this.b = ey6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(ey6... ey6VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ey6VarArr)) == null) {
                ey6 ey6Var = this.b;
                if (ey6Var != null) {
                    try {
                        if (ey6Var.getId() != null && ey6Var.i() != null) {
                            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                            this.a = netWork;
                            netWork.addPostData("fid", ey6Var.getId());
                            this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, ey6Var.i());
                            this.a.getNetContext().getRequest().mIsNeedTbs = true;
                            this.a.postNetData();
                            return null;
                        }
                        return null;
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.c.U(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((m) str);
                this.c.U(false);
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.c.l = true;
                        if (this.c.a.isAdded() && this.c.j != null) {
                            this.c.j.showToast(this.c.j.getActivity().getString(R.string.unlike_success));
                        }
                        TbadkCoreApplication.getInst().setLikeBarChanged(true);
                        this.c.Q(false, this.b.getId());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.b.getId()));
                        long j = JavaTypesHelper.toLong(this.b.getId(), 0L);
                        if (j > 0) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(j)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.b.i()));
                        }
                        this.c.b.n0(this.b, this.c.c.W());
                        this.c.c.b0(this.b);
                    } else if (this.c.j == null) {
                    } else {
                        if (!StringUtils.isNull(this.a.getErrorString())) {
                            this.c.j.showToast(this.a.getErrorString());
                        } else if (this.c.a.isAdded()) {
                            this.c.j.showToast(this.c.j.getActivity().getString(R.string.obfuscated_res_0x7f0f054f));
                        }
                    }
                }
            }
        }
    }

    public ny6(EnterForumFragment enterForumFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.f = true;
        this.g = false;
        this.k = -1L;
        this.p = 1;
        this.v = new c(this, 2921032);
        this.w = new f(this, CmdConfigHttp.CMD_ENTER_FORUM_DATA, 309683);
        this.x = new g(this, CmdConfigHttp.CMD_SET_LIKE_FORUM, 309685);
        this.y = new j(this);
        this.z = new k(this);
        this.A = new a(this);
        this.a = enterForumFragment;
        this.j = enterForumFragment.getBaseFragmentActivity();
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        this.n = viewEventCenter;
        viewEventCenter.addEventDelegate(this);
        ns7.d();
        this.k = System.currentTimeMillis();
        this.f = true;
        this.g = false;
        this.i = "";
        this.c = new EnterForumModel(this.j.getPageContext());
        this.t = new hz6();
        this.d = new RecentlyVisitedForumModel();
        this.m = new LikeModel(this.j.getPageContext());
        this.e = new rja(this.j.getPageContext());
        this.m.setLoadDataCallBack(this.y);
        this.c.l0(this.z);
        SharedPrefHelper.getInstance().putBoolean("enter_forum_edit_mode", false);
        zy6.b().c(this.a.getFragmentActivity(), BdUtilHelper.getStatusBarHeight(this.a.getFragmentActivity()));
        E();
        D();
        O();
    }

    public void y(boolean z) {
        boolean z2;
        boolean z3;
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048605, this, z) == null) && !this.r && this.c != null && this.b != null) {
            String str = this.i;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.i = currentAccount;
            if (this.f) {
                this.f = false;
                z2 = false;
                z3 = true;
            } else {
                if (currentAccount != null && !currentAccount.equals(str)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = false;
            }
            if (TbadkCoreApplication.getInst().getLikeBarChanged()) {
                TbadkCoreApplication.getInst().setLikeBarChanged(false);
                z2 = true;
            }
            if (z) {
                z2 = true;
            }
            if (TbadkCoreApplication.getInst().signedForumCount() > 0) {
                EnterForumModel enterForumModel2 = this.c;
                if (enterForumModel2 != null && enterForumModel2.R() != null && this.c.R().e() != null) {
                    Iterator<ey6> it = this.c.R().e().b().iterator();
                    while (it.hasNext()) {
                        ey6 next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.i())) {
                            next.A(1);
                            int signLevelUpValue = TbadkCoreApplication.getInst().getSignLevelUpValue(next.i());
                            if (signLevelUpValue > 0) {
                                next.C(signLevelUpValue);
                            }
                        }
                    }
                }
                TbadkCoreApplication.getInst().clearSignedForum();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    sca.g(currentAccount2);
                }
                this.b.c0(this.c.W());
            }
            if (!z3 && !z2) {
                return;
            }
            v();
            hz6 hz6Var = this.t;
            if (hz6Var != null) {
                hz6Var.h();
            }
            if (z2) {
                EnterForumModel enterForumModel3 = this.c;
                if (enterForumModel3 != null) {
                    enterForumModel3.X(!StringUtils.isNull(this.i));
                }
                this.d.loadData();
            } else if (z3 && (enterForumModel = this.c) != null) {
                enterForumModel.X(!StringUtils.isNull(this.i));
            }
        }
    }

    public final void Q(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048593, this, z, str) == null) {
            new b(this, str, z).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            d07 d07Var = this.b;
            if (d07Var != null) {
                d07Var.d0(i2);
            }
            h07 h07Var = this.q;
            if (h07Var != null) {
                h07Var.r();
            }
        }
    }

    public void R(by6 by6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, by6Var) == null) {
            this.b.q0(by6Var);
            this.a.P1(by6Var);
        }
    }

    public void S(BdUniqueId bdUniqueId) {
        d07 d07Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) && (d07Var = this.b) != null) {
            d07Var.x0(bdUniqueId);
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (this.o == null) {
                F();
            }
            this.o.setDialogVisiable(z);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && this.b != null && this.a != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(z ? 1 : 0)));
        }
    }

    public d07 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (d07) invokeV.objValue;
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.s;
        }
        return (View) invokeV.objValue;
    }

    public void C() {
        d07 d07Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (d07Var = this.b) != null) {
            d07Var.X(this.s);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            P();
            this.a.registerListener(this.w);
            this.a.registerListener(this.x);
            this.a.registerListener(this.v);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.o = new BlueCircleProgressDialog(this.j.getPageContext());
        }
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a.isHidden()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.b == null) {
            return;
        }
        y(false);
    }

    public void L() {
        RecentlyVisitedForumModel recentlyVisitedForumModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.a.isAdded() && this.a.isPrimary() && (recentlyVisitedForumModel = this.d) != null) {
                recentlyVisitedForumModel.O();
            }
            d07 d07Var = this.b;
            if (d07Var != null) {
                d07Var.g0();
            }
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new e(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.registerListener(new d(this, 2007010));
        }
    }

    @Override // com.baidu.tieba.hq5
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.j.getUniqueId();
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void v() {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (enterForumModel = this.c) != null) {
            enterForumModel.cancelLoadData();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || this.b == null) {
            return;
        }
        y(true);
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.s = LayoutInflater.from(this.j.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d02c0, (ViewGroup) null);
            d07 d07Var = new d07(this.a, this.s, this.n, this.d, this.c);
            this.b = d07Var;
            d07Var.A0(this.t);
            this.b.v0(this.A);
            I(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.hq5
    public boolean E0(iq5 iq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iq5Var)) == null) {
            int b2 = iq5Var.b();
            cq5 a2 = iq5Var.a();
            int i2 = 2;
            switch (b2) {
                case 1:
                    if (this.p == 2 || !(a2 instanceof ey6)) {
                        return false;
                    }
                    ey6 ey6Var = (ey6) a2;
                    String i3 = ey6Var.i();
                    if (bi.isForumName(i3)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.j.getPageContext().getPageActivity()).createNormalCfg(i3, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        if (iq5Var.c() instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            intent.putExtra("transition_type", 0);
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, ey6Var.f());
                            ey6Var.z(0L);
                        }
                        this.j.sendMessage(new CustomMessage(2003000, callFrom));
                        if (YYLiveUtil.isLiveRoom(i3)) {
                            StatisticItem statisticItem = new StatisticItem("c12888");
                            TiebaStaticHelper.addYYParam(statisticItem);
                            TiebaStatic.log(statisticItem);
                        }
                        StatisticItem param = new StatisticItem("c13368").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        if (this.c.R().g() != 1) {
                            i2 = 1;
                        }
                        TiebaStatic.log(param.param("obj_type", i2).param("fid", ey6Var.getId()));
                        return true;
                    }
                    break;
                case 2:
                    if (this.p == 2) {
                        return false;
                    }
                    if (SharedPrefHelper.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                    SharedPrefHelper.getInstance().putBoolean("enter_forum_edit_mode", true);
                    if (this.a.getView() != null && this.a.getView().getParent() != null) {
                        this.a.getView().getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                case 3:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                    SharedPrefHelper.getInstance().putBoolean("enter_forum_edit_mode", false);
                    return true;
                case 4:
                    if (!(a2 instanceof ey6)) {
                        return false;
                    }
                    V((ey6) a2);
                    return true;
                case 6:
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.j.getActivity());
                        return true;
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.j.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("find_more_text_click"));
                    return true;
                case 7:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.j.getPageContext().getPageActivity())));
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.j.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("c13367").param("obj_location", "1"));
                    return true;
                case 8:
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).param("obj_type", "2").param("obj_locate", 1));
                    this.j.finish();
                    return true;
                case 9:
                    d07 d07Var = this.b;
                    if (d07Var != null) {
                        d07Var.G0();
                    }
                    return true;
                case 10:
                    this.p = 2;
                    return true;
                case 11:
                    this.p = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                    return true;
                case 12:
                    if (this.p == 2) {
                        return true;
                    }
                    if (this.q == null) {
                        this.q = new h07(this.j.getPageContext(), this.n);
                    }
                    if (a2 instanceof ey6) {
                        this.q.s((ey6) a2);
                        this.q.l();
                    }
                    return true;
                case 13:
                    if (!(a2 instanceof ey6)) {
                        return false;
                    }
                    ey6 ey6Var2 = (ey6) a2;
                    new l(this, ey6Var2).execute(new ey6[0]);
                    StatisticItem statisticItem2 = new StatisticItem("c13370");
                    if (ey6Var2.g() <= 0) {
                        i2 = 1;
                    }
                    TiebaStatic.log(statisticItem2.param("obj_type", i2).param("fid", ey6Var2.getId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                    return true;
                case 14:
                    UrlManager.getInstance().dealOneLink(this.j.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "mo/q/priforum/create/info?nomenu=1"});
                    return true;
                case 15:
                    if (!this.e.d() && (a2 instanceof ey6)) {
                        UrlManager.getInstance().dealOneLink(this.j.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "mo/q/priforum/editinfo?fid=" + ((ey6) a2).getId() + "&nomenu=1"});
                    }
                    return true;
                case 16:
                    R((by6) iq5Var.d());
                    break;
                case 17:
                    R((by6) iq5Var.d());
                    break;
                case 18:
                    R((by6) iq5Var.d());
                    break;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            v();
            zy6.b().a();
            d07 d07Var = this.b;
            if (d07Var != null) {
                d07Var.e0();
            }
            MessageManager.getInstance().unRegisterTask(2016527);
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.d;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.onDestroy();
            }
            EnterForumModel enterForumModel = this.c;
            if (enterForumModel != null) {
                enterForumModel.onDestroy();
            }
            ViewEventCenter viewEventCenter = this.n;
            if (viewEventCenter != null) {
                viewEventCenter.removeEventDelegate(this);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d07 d07Var = this.b;
            if (d07Var != null && d07Var.Q() != null) {
                this.b.Q().y();
            }
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.d;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.onPause();
            }
            EnterForumModel enterForumModel = this.c;
            if (enterForumModel != null) {
                enterForumModel.onPause();
            }
            d07 d07Var2 = this.b;
            if (d07Var2 != null) {
                d07Var2.f0();
            }
        }
    }

    public void M(cy6 cy6Var) {
        d07 d07Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, cy6Var) != null) || (d07Var = this.b) == null) {
            return;
        }
        if (cy6Var == null) {
            d07Var.F0(this.s);
            return;
        }
        gy6 e2 = cy6Var.e();
        ArrayList<ey6> arrayList = new ArrayList<>();
        if (e2 != null) {
            arrayList = e2.b();
        }
        w(arrayList, cy6Var.f());
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(SharedPrefHelper.getInstance().getString("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.N() != null) {
            T(hotSearchInfoData.N());
        }
        this.b.i0();
        this.b.h0(cy6Var.g());
    }

    public void N(boolean z) {
        d07 d07Var;
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (d07Var = this.b) != null && (enterForumFragment = this.a) != null) {
            if (z) {
                if (enterForumFragment.isPrimary() && this.a.isResumed()) {
                    this.b.G0();
                } else {
                    this.b.M();
                }
            } else {
                d07Var.M();
            }
            this.b.u0(z);
        }
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || this.a.M1() == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.a.M1().j0(str.trim());
        } else {
            this.a.M1().j0(this.j.getActivity().getString(R.string.obfuscated_res_0x7f0f0669));
        }
    }

    public void V(ey6 ey6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, ey6Var) != null) || ey6Var == null) {
            return;
        }
        m45 m45Var = new m45(this.j.getPageContext().getPageActivity());
        m45Var.setMessage(String.format(this.j.getPageContext().getString(R.string.obfuscated_res_0x7f0f02ef), ey6Var.i()));
        m45Var.setPositiveButton(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03cf), new h(this, ey6Var));
        m45Var.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03ce), new i(this));
        m45Var.setButtonTextColor(R.color.CAM_X0105);
        m45Var.create(this.j.getPageContext());
        m45Var.show();
    }

    public final void w(List<ey6> list, h35 h35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048603, this, list, h35Var) != null) || list == null) {
            return;
        }
        if (list.size() > 500) {
            list = list.subList(0, 500);
        }
        this.b.l0(this.c.n0(list, cv5.a()), h35Var, this.c.W());
    }
}
