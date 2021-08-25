package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.p0.s.f0.f;
import c.a.p0.s.s.a;
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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, f.g, BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.b2.g.a f54323f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.b2.f f54324g;

    /* renamed from: h  reason: collision with root package name */
    public int f54325h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<MarkData> f54326i;

    /* renamed from: j  reason: collision with root package name */
    public MarkData f54327j;
    public final CustomMessageListener k;
    public final CustomMessageListener l;
    public final AntiHelper.k m;

    /* loaded from: classes7.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54328e;

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
            this.f54328e = threadFragment;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f54328e.f54324g.v(this.f54328e.f54323f.q());
                this.f54328e.f54323f.w(Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.q0.b2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54329a;

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
            this.f54329a = threadFragment;
        }

        @Override // c.a.q0.b2.d
        public void a(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objArr) == null) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        this.f54329a.f54324g.c();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        this.f54329a.f54324g.e(r3, this.f54329a.f54323f, ((Boolean) objArr[2]).booleanValue());
                        this.f54329a.f54326i = this.f54329a.f54323f.n();
                        ThreadFragment threadFragment = this.f54329a;
                        if (this.f54329a.f54326i != null && !this.f54329a.f54326i.isEmpty()) {
                            r0 = true;
                        }
                        threadFragment.mIsEnableEdit = r0;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        this.f54329a.f54324g.c();
                        this.f54329a.f54324g.e((objArr[1] == null || !(objArr[1] instanceof String)) ? null : (String) objArr[1], null, false);
                        this.f54329a.f54324g.p(this.f54329a.f54323f, false);
                        this.f54329a.mIsEnableEdit = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        this.f54329a.f54324g.f(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            this.f54329a.f54324g.v(this.f54329a.f54323f.q());
                            this.f54329a.f54323f.w(Boolean.TRUE);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        this.f54329a.f54324g.d(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, this.f54329a.f54323f);
                        this.f54329a.f54326i = this.f54329a.f54323f.n();
                        ThreadFragment threadFragment2 = this.f54329a;
                        if (this.f54329a.f54326i != null && !this.f54329a.f54326i.isEmpty()) {
                            r0 = true;
                        }
                        threadFragment2.mIsEnableEdit = r0;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BdLog.d(e2.getMessage());
                }
                this.f54329a.sendEditEnableMessage(1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54330a;

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
            this.f54330a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Bundle)) {
                Bundle bundle = (Bundle) customResponsedMessage.getData();
                if (bundle.getInt(CollectFragment.FRAGMENT_TYPE, -1) == this.f54330a.getType()) {
                    this.f54330a.f54324g.a(bundle.getBoolean(CollectFragment.EDITOR_STATE_EXTRA, false));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54331a;

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
            this.f54331a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                c.a.q0.b2.c.c("c14066", ((Boolean) customResponsedMessage.getData()).booleanValue(), this.f54331a.f54327j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54332a;

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
            this.f54332a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.z()) {
                    this.f54332a.f54324g.j();
                    this.f54332a.f54324g.c();
                    this.f54332a.f54324g.r(false);
                    this.f54332a.f54324g.b(false);
                    return;
                }
                this.f54332a.f54323f.w(Boolean.FALSE);
                this.f54332a.f54324g.b(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54333a;

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
            this.f54333a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (this.f54333a.f54326i == null || data == null) {
                    return;
                }
                if (data.l != null && AntiHelper.t(this.f54333a.getActivity(), data.l, this.f54333a.m) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                }
                if (data.f47954a) {
                    Iterator it = this.f54333a.f54326i.iterator();
                    while (it.hasNext()) {
                        MarkData markData = (MarkData) it.next();
                        if (markData != null && StringHelper.equals(markData.getUesrId(), data.f47956c)) {
                            markData.metaData.setIsLike(data.f47957d);
                            markData.setLikeInPage(data.f47957d);
                        }
                    }
                    if (data.f47957d) {
                        l.L(this.f54333a.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                    this.f54333a.f54324g.m();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54334a;

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
            this.f54334a = threadFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.p0.s.s.a aVar) {
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
        this.f54323f = null;
        this.f54324g = null;
        this.f54325h = -1;
        this.k = new e(this, 2000994);
        this.l = new f(this, 2001115);
        this.m = new g(this);
    }

    public static final ThreadFragment newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? new ThreadFragment() : (ThreadFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean isEmptyData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<MarkData> arrayList = this.f54326i;
            return arrayList == null || arrayList.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            registerListener(new c(this, 2022208));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            registerListener(new d(this, 2921531));
        }
    }

    public final void m(MarkData markData) {
        c.a.q0.b2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, markData) == null) || markData == null || (aVar = this.f54323f) == null) {
            return;
        }
        int o = aVar.o();
        int w = c.a.p0.t.d.b.g0().w();
        TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
        if (markData.getNewCounts() > 0) {
            if (w > 0) {
                c.a.p0.t.d.b.g0().a0(w - 1);
            } else {
                c.a.p0.t.d.b.g0().a0(0);
            }
            if (o > 0) {
                this.f54323f.C(o - 1);
            } else {
                this.f54323f.C(0);
            }
        }
        markData.setNewCounts(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        c.a.q0.b2.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                if (i3 != 1 || 17001 != i2 || (aVar = this.f54323f) == null || this.f54324g == null) {
                    return;
                }
                int count = ListUtils.getCount(aVar.n());
                int i4 = this.f54325h;
                if (count <= i4 || i4 < 0) {
                    return;
                }
                this.f54323f.n().remove(this.f54325h);
                this.f54324g.m();
                this.f54324g.p(this.f54323f, false);
            } else if (17001 == i2) {
                MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                c.a.q0.b2.g.a aVar2 = this.f54323f;
                if (aVar2 == null || markData == null || this.f54324g == null) {
                    return;
                }
                int count2 = ListUtils.getCount(aVar2.n());
                int i5 = this.f54325h;
                if (count2 <= i5 || i5 < 0) {
                    return;
                }
                this.f54323f.n().get(this.f54325h).setPostId(markData.getPostId());
                this.f54323f.n().get(this.f54325h).setHostMode(markData.getHostMode());
                this.f54323f.n().get(this.f54325h).setSequence(markData.getSequence());
                this.f54324g.m();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.q0.b2.f fVar = this.f54324g;
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
            MarkData markData = (MarkData) ListUtils.getItem(this.f54326i, intValue);
            this.f54327j = markData;
            if (markData == null) {
                return;
            }
            boolean isShareThread = markData.isShareThread();
            StatisticItem statisticItem = new StatisticItem("c12529");
            if (view.getId() == this.f54324g.g(isShareThread)) {
                BdListView bdListView = this.f54324g.f15960c;
                if (bdListView != null && !bdListView.isRefreshDone()) {
                    return;
                }
                this.f54324g.u();
                if (!this.f54323f.D(intValue)) {
                    this.f54324g.j();
                }
                c.a.q0.b2.c.b("c14069", markData);
            } else if (view.getId() == this.f54324g.i(isShareThread)) {
                this.f54324g.l(markData);
                statisticItem.param("obj_locate", 1);
                c.a.q0.b2.c.b("c14064", markData);
            } else if (view.getId() == this.f54324g.h(isShareThread)) {
                statisticItem.param("obj_locate", 3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
                c.a.q0.b2.c.b("c14063", markData);
                m(markData);
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
            k();
            registerListener(this.k);
            registerListener(this.l);
            l();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.edit_mark_activity, (ViewGroup) null);
            this.f54323f = new c.a.q0.b2.g.a();
            c.a.q0.b2.f fVar = new c.a.q0.b2.f(this, inflate);
            this.f54324g = fVar;
            fVar.q(new a(this));
            this.f54324g.b(j.z());
            this.f54323f.A(new b(this));
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f54324g.o();
            this.f54323f.s();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (i2 >= 0 && i2 < this.f54323f.n().size()) {
                this.f54325h = i2;
                MarkData markData = this.f54323f.n().get(i2);
                MarkData markData2 = this.f54326i.get(i2);
                this.f54327j = markData2;
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
                        c.a.q0.b2.c.b("c14063", markData2);
                    }
                }
                m(markData2);
                markData2.setRedTipShow(false);
            }
            super.onItemClick(adapterView, view, i2, j2);
        }
    }

    @Override // c.a.p0.s.f0.f.g
    public void onListPullRefresh(boolean z) {
        c.a.q0.b2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (aVar = this.f54323f) == null || this.f54324g == null) {
            return;
        }
        aVar.z();
        this.f54324g.r(true);
        this.f54323f.w(Boolean.FALSE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            c.a.q0.b2.f fVar = this.f54324g;
            if (fVar != null) {
                fVar.w(this.f54326i);
                ArrayList<MarkData> arrayList = this.f54326i;
                this.mIsEnableEdit = (arrayList == null || arrayList.isEmpty()) ? false : true;
                sendEditEnableMessage(1);
                refresh();
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        c.a.q0.b2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f54324g == null || (aVar = this.f54323f) == null || !aVar.r()) {
            return;
        }
        this.f54324g.v(this.f54323f.q());
        this.f54323f.w(Boolean.FALSE);
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStart();
            this.f54324g.x();
        }
    }

    public final void refresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f54323f.m() == 0) {
            this.f54324g.v(this.f54323f.q());
        }
    }
}
