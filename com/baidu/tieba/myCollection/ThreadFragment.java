package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.o0.r.f0.f;
import d.a.o0.r.s.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, f.g, BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.a2.g.a f18743g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.a2.f f18744h;

    /* renamed from: i  reason: collision with root package name */
    public int f18745i;
    public ArrayList<MarkData> j;
    public MarkData k;
    public final CustomMessageListener l;
    public final CustomMessageListener m;
    public final AntiHelper.k n;

    /* loaded from: classes4.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f18746e;

        public a(ThreadFragment threadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18746e = threadFragment;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f18746e.f18744h.v(this.f18746e.f18743g.q());
                this.f18746e.f18743g.w(Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.p0.a2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f18747a;

        public b(ThreadFragment threadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18747a = threadFragment;
        }

        @Override // d.a.p0.a2.d
        public void a(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objArr) == null) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        this.f18747a.f18744h.c();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        this.f18747a.f18744h.e(r3, this.f18747a.f18743g, ((Boolean) objArr[2]).booleanValue());
                        this.f18747a.j = this.f18747a.f18743g.n();
                        ThreadFragment threadFragment = this.f18747a;
                        if (this.f18747a.j != null && !this.f18747a.j.isEmpty()) {
                            r0 = true;
                        }
                        threadFragment.f12193e = r0;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        this.f18747a.f18744h.c();
                        this.f18747a.f18744h.e((objArr[1] == null || !(objArr[1] instanceof String)) ? null : (String) objArr[1], null, false);
                        this.f18747a.f18744h.p(this.f18747a.f18743g, false);
                        this.f18747a.f12193e = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        this.f18747a.f18744h.f(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            this.f18747a.f18744h.v(this.f18747a.f18743g.q());
                            this.f18747a.f18743g.w(Boolean.TRUE);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        this.f18747a.f18744h.d(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, this.f18747a.f18743g);
                        this.f18747a.j = this.f18747a.f18743g.n();
                        ThreadFragment threadFragment2 = this.f18747a;
                        if (this.f18747a.j != null && !this.f18747a.j.isEmpty()) {
                            r0 = true;
                        }
                        threadFragment2.f12193e = r0;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BdLog.d(e2.getMessage());
                }
                this.f18747a.K0(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f18748a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ThreadFragment threadFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18748a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Bundle)) {
                Bundle bundle = (Bundle) customResponsedMessage.getData();
                if (bundle.getInt("fragment_type", -1) == this.f18748a.H0()) {
                    this.f18748a.f18744h.a(bundle.getBoolean("is_edit_state", false));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f18749a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ThreadFragment threadFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18749a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                d.a.p0.a2.c.c("c14066", ((Boolean) customResponsedMessage.getData()).booleanValue(), this.f18749a.k);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f18750a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ThreadFragment threadFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18750a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.z()) {
                    this.f18750a.f18744h.j();
                    this.f18750a.f18744h.c();
                    this.f18750a.f18744h.r(false);
                    this.f18750a.f18744h.b(false);
                    return;
                }
                this.f18750a.f18743g.w(Boolean.FALSE);
                this.f18750a.f18744h.b(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f18751a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ThreadFragment threadFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18751a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (this.f18751a.j == null || data == null) {
                    return;
                }
                if (data.l != null && AntiHelper.t(this.f18751a.getActivity(), data.l, this.f18751a.n) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                }
                if (data.f12817a) {
                    Iterator it = this.f18751a.j.iterator();
                    while (it.hasNext()) {
                        MarkData markData = (MarkData) it.next();
                        if (markData != null && StringHelper.equals(markData.getUesrId(), data.f12819c)) {
                            markData.metaData.setIsLike(data.f12820d);
                            markData.setLikeInPage(data.f12820d);
                        }
                    }
                    if (data.f12820d) {
                        l.L(this.f18751a.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                    this.f18751a.f18744h.m();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f18752a;

        public g(ThreadFragment threadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18752a = threadFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    public ThreadFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18743g = null;
        this.f18744h = null;
        this.f18745i = -1;
        this.l = new e(this, 2000994);
        this.m = new f(this, 2001115);
        this.n = new g(this);
    }

    public static final ThreadFragment W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? new ThreadFragment() : (ThreadFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<MarkData> arrayList = this.j;
            return arrayList == null || arrayList.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            registerListener(new c(this, 2022208));
        }
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            registerListener(new d(this, 2921531));
        }
    }

    public final void Z0(MarkData markData) {
        d.a.p0.a2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, markData) == null) || markData == null || (aVar = this.f18743g) == null) {
            return;
        }
        int o = aVar.o();
        int w = d.a.o0.s.d.b.g0().w();
        TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
        if (markData.getNewCounts() > 0) {
            if (w > 0) {
                d.a.o0.s.d.b.g0().a0(w - 1);
            } else {
                d.a.o0.s.d.b.g0().a0(0);
            }
            if (o > 0) {
                this.f18743g.C(o - 1);
            } else {
                this.f18743g.C(0);
            }
        }
        markData.setNewCounts(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        d.a.p0.a2.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                if (i3 != 1 || 17001 != i2 || (aVar = this.f18743g) == null || this.f18744h == null) {
                    return;
                }
                int count = ListUtils.getCount(aVar.n());
                int i4 = this.f18745i;
                if (count <= i4 || i4 < 0) {
                    return;
                }
                this.f18743g.n().remove(this.f18745i);
                this.f18744h.m();
                this.f18744h.p(this.f18743g, false);
            } else if (17001 == i2) {
                MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                d.a.p0.a2.g.a aVar2 = this.f18743g;
                if (aVar2 == null || markData == null || this.f18744h == null) {
                    return;
                }
                int count2 = ListUtils.getCount(aVar2.n());
                int i5 = this.f18745i;
                if (count2 <= i5 || i5 < 0) {
                    return;
                }
                this.f18743g.n().get(this.f18745i).setPostId(markData.getPostId());
                this.f18743g.n().get(this.f18745i).setHostMode(markData.getHostMode());
                this.f18743g.n().get(this.f18745i).setSequence(markData.getSequence());
                this.f18744h.m();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.p0.a2.f fVar = this.f18744h;
            if (fVar != null) {
                fVar.n(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            int intValue = ((Integer) view.getTag()).intValue();
            MarkData markData = (MarkData) ListUtils.getItem(this.j, intValue);
            this.k = markData;
            if (markData == null) {
                return;
            }
            boolean isShareThread = markData.isShareThread();
            StatisticItem statisticItem = new StatisticItem("c12529");
            if (view.getId() == this.f18744h.g(isShareThread)) {
                BdListView bdListView = this.f18744h.f53969c;
                if (bdListView != null && !bdListView.C()) {
                    return;
                }
                this.f18744h.u();
                if (!this.f18743g.D(intValue)) {
                    this.f18744h.j();
                }
                d.a.p0.a2.c.b("c14069", markData);
            } else if (view.getId() == this.f18744h.i(isShareThread)) {
                this.f18744h.l(markData);
                statisticItem.param("obj_locate", 1);
                d.a.p0.a2.c.b("c14064", markData);
            } else if (view.getId() == this.f18744h.h(isShareThread)) {
                statisticItem.param("obj_locate", 3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
                d.a.p0.a2.c.b("c14063", markData);
                Z0(markData);
            }
            statisticItem.param("tid", markData.getId());
            statisticItem.param("obj_id", markData.getUesrId());
            TiebaStatic.log(statisticItem);
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            X0();
            registerListener(this.l);
            registerListener(this.m);
            Y0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.edit_mark_activity, (ViewGroup) null);
            this.f18743g = new d.a.p0.a2.g.a();
            d.a.p0.a2.f fVar = new d.a.p0.a2.f(this, inflate);
            this.f18744h = fVar;
            fVar.q(new a(this));
            this.f18744h.b(j.z());
            this.f18743g.A(new b(this));
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f18744h.o();
            this.f18743g.s();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            if (i2 >= 0 && i2 < this.f18743g.n().size()) {
                this.f18745i = i2;
                MarkData markData = this.f18743g.n().get(i2);
                MarkData markData2 = this.j.get(i2);
                this.k = markData2;
                StatisticItem statisticItem = new StatisticItem("c12529");
                statisticItem.param("obj_locate", 2);
                statisticItem.param("tid", markData2.getId());
                statisticItem.param("obj_id", markData2.getUesrId());
                TiebaStatic.log(statisticItem);
                if (markData != null) {
                    if (markData.isManga()) {
                        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
                            } else {
                                sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), markData.getCartoonId(), markData.getChapterId(), 3)));
                            }
                        } else {
                            l.L(getPageContext().getPageActivity(), R.string.manga_plugin_not_install_tip);
                        }
                    } else {
                        PbActivityConfig createMarkCfg = new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001);
                        createMarkCfg.setStartFrom(10);
                        createMarkCfg.setJumpToCommentArea(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createMarkCfg));
                        d.a.p0.a2.c.b("c14063", markData2);
                    }
                }
                Z0(markData2);
                markData2.setRedTipShow(false);
            }
            super.onItemClick(adapterView, view, i2, j);
        }
    }

    @Override // d.a.o0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        d.a.p0.a2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (aVar = this.f18743g) == null || this.f18744h == null) {
            return;
        }
        aVar.z();
        this.f18744h.r(true);
        this.f18743g.w(Boolean.FALSE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            d.a.p0.a2.f fVar = this.f18744h;
            if (fVar != null) {
                fVar.w(this.j);
                ArrayList<MarkData> arrayList = this.j;
                this.f12193e = (arrayList == null || arrayList.isEmpty()) ? false : true;
                K0(1);
                refresh();
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        d.a.p0.a2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f18744h == null || (aVar = this.f18743g) == null || !aVar.r()) {
            return;
        }
        this.f18744h.v(this.f18743g.q());
        this.f18743g.w(Boolean.FALSE);
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStart();
            this.f18744h.x();
        }
    }

    public final void refresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f18743g.m() == 0) {
            this.f18744h.v(this.f18743g.q());
        }
    }
}
