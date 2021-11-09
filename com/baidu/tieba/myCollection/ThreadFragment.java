package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.q0.s.g0.f;
import b.a.q0.s.s.a;
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
/* loaded from: classes9.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, f.g, BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.d2.g.a f51701f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.d2.f f51702g;

    /* renamed from: h  reason: collision with root package name */
    public int f51703h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<MarkData> f51704i;
    public MarkData j;
    public final CustomMessageListener k;
    public final CustomMessageListener l;
    public final AntiHelper.k m;

    /* loaded from: classes9.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f51705e;

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
            this.f51705e = threadFragment;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f51705e.f51702g.v(this.f51705e.f51701f.q());
                this.f51705e.f51701f.w(Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends b.a.r0.d2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f51706a;

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
            this.f51706a = threadFragment;
        }

        @Override // b.a.r0.d2.d
        public void a(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objArr) == null) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        this.f51706a.f51702g.c();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        this.f51706a.f51702g.e(r3, this.f51706a.f51701f, ((Boolean) objArr[2]).booleanValue());
                        this.f51706a.f51704i = this.f51706a.f51701f.n();
                        ThreadFragment threadFragment = this.f51706a;
                        if (this.f51706a.f51704i != null && !this.f51706a.f51704i.isEmpty()) {
                            r0 = true;
                        }
                        threadFragment.mIsEnableEdit = r0;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        this.f51706a.f51702g.c();
                        this.f51706a.f51702g.e((objArr[1] == null || !(objArr[1] instanceof String)) ? null : (String) objArr[1], null, false);
                        this.f51706a.f51702g.p(this.f51706a.f51701f, false);
                        this.f51706a.mIsEnableEdit = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        this.f51706a.f51702g.f(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            this.f51706a.f51702g.v(this.f51706a.f51701f.q());
                            this.f51706a.f51701f.w(Boolean.TRUE);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        this.f51706a.f51702g.d(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, this.f51706a.f51701f);
                        this.f51706a.f51704i = this.f51706a.f51701f.n();
                        ThreadFragment threadFragment2 = this.f51706a;
                        if (this.f51706a.f51704i != null && !this.f51706a.f51704i.isEmpty()) {
                            r0 = true;
                        }
                        threadFragment2.mIsEnableEdit = r0;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BdLog.d(e2.getMessage());
                }
                this.f51706a.sendEditEnableMessage(1);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f51707a;

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
            this.f51707a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Bundle)) {
                Bundle bundle = (Bundle) customResponsedMessage.getData();
                if (bundle.getInt(CollectFragment.FRAGMENT_TYPE, -1) == this.f51707a.getType()) {
                    this.f51707a.f51702g.a(bundle.getBoolean(CollectFragment.EDITOR_STATE_EXTRA, false));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f51708a;

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
            this.f51708a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                b.a.r0.d2.c.c("c14066", ((Boolean) customResponsedMessage.getData()).booleanValue(), this.f51708a.j);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f51709a;

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
            this.f51709a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.z()) {
                    this.f51709a.f51702g.j();
                    this.f51709a.f51702g.c();
                    this.f51709a.f51702g.r(false);
                    this.f51709a.f51702g.b(false);
                    return;
                }
                this.f51709a.f51701f.w(Boolean.FALSE);
                this.f51709a.f51702g.b(true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f51710a;

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
            this.f51710a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (this.f51710a.f51704i == null || data == null) {
                    return;
                }
                if (data.l != null && AntiHelper.t(this.f51710a.getActivity(), data.l, this.f51710a.m) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                }
                if (data.f45667a) {
                    Iterator it = this.f51710a.f51704i.iterator();
                    while (it.hasNext()) {
                        MarkData markData = (MarkData) it.next();
                        if (markData != null && StringHelper.equals(markData.getUesrId(), data.f45669c)) {
                            markData.metaData.setIsLike(data.f45670d);
                            markData.setLikeInPage(data.f45670d);
                        }
                    }
                    if (data.f45670d) {
                        l.L(this.f51710a.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                    this.f51710a.f51702g.m();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(b.a.q0.s.s.a aVar) {
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
        this.f51701f = null;
        this.f51702g = null;
        this.f51703h = -1;
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
            ArrayList<MarkData> arrayList = this.f51704i;
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
        b.a.r0.d2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, markData) == null) || markData == null || (aVar = this.f51701f) == null) {
            return;
        }
        int o = aVar.o();
        int w = b.a.q0.t.d.b.g0().w();
        TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
        if (markData.getNewCounts() > 0) {
            if (w > 0) {
                b.a.q0.t.d.b.g0().a0(w - 1);
            } else {
                b.a.q0.t.d.b.g0().a0(0);
            }
            if (o > 0) {
                this.f51701f.C(o - 1);
            } else {
                this.f51701f.C(0);
            }
        }
        markData.setNewCounts(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        b.a.r0.d2.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                if (i3 != 1 || 17001 != i2 || (aVar = this.f51701f) == null || this.f51702g == null) {
                    return;
                }
                int count = ListUtils.getCount(aVar.n());
                int i4 = this.f51703h;
                if (count <= i4 || i4 < 0) {
                    return;
                }
                this.f51701f.n().remove(this.f51703h);
                this.f51702g.m();
                this.f51702g.p(this.f51701f, false);
            } else if (17001 == i2) {
                MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                b.a.r0.d2.g.a aVar2 = this.f51701f;
                if (aVar2 == null || markData == null || this.f51702g == null) {
                    return;
                }
                int count2 = ListUtils.getCount(aVar2.n());
                int i5 = this.f51703h;
                if (count2 <= i5 || i5 < 0) {
                    return;
                }
                this.f51701f.n().get(this.f51703h).setPostId(markData.getPostId());
                this.f51701f.n().get(this.f51703h).setHostMode(markData.getHostMode());
                this.f51701f.n().get(this.f51703h).setSequence(markData.getSequence());
                this.f51702g.m();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            b.a.r0.d2.f fVar = this.f51702g;
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
            MarkData markData = (MarkData) ListUtils.getItem(this.f51704i, intValue);
            this.j = markData;
            if (markData == null) {
                return;
            }
            boolean isShareThread = markData.isShareThread();
            StatisticItem statisticItem = new StatisticItem("c12529");
            if (view.getId() == this.f51702g.g(isShareThread)) {
                BdListView bdListView = this.f51702g.f15656c;
                if (bdListView != null && !bdListView.isRefreshDone()) {
                    return;
                }
                this.f51702g.u();
                if (!this.f51701f.D(intValue)) {
                    this.f51702g.j();
                }
                b.a.r0.d2.c.b("c14069", markData);
            } else if (view.getId() == this.f51702g.i(isShareThread)) {
                this.f51702g.l(markData);
                statisticItem.param("obj_locate", 1);
                b.a.r0.d2.c.b("c14064", markData);
            } else if (view.getId() == this.f51702g.h(isShareThread)) {
                statisticItem.param("obj_locate", 3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
                b.a.r0.d2.c.b("c14063", markData);
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
            this.f51701f = new b.a.r0.d2.g.a();
            b.a.r0.d2.f fVar = new b.a.r0.d2.f(this, inflate);
            this.f51702g = fVar;
            fVar.q(new a(this));
            this.f51702g.b(j.z());
            this.f51701f.A(new b(this));
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f51702g.o();
            this.f51701f.s();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            if (i2 >= 0 && i2 < this.f51701f.n().size()) {
                this.f51703h = i2;
                MarkData markData = this.f51701f.n().get(i2);
                MarkData markData2 = this.f51704i.get(i2);
                this.j = markData2;
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
                        b.a.r0.d2.c.b("c14063", markData2);
                    }
                }
                m(markData2);
                markData2.setRedTipShow(false);
            }
            super.onItemClick(adapterView, view, i2, j);
        }
    }

    @Override // b.a.q0.s.g0.f.g
    public void onListPullRefresh(boolean z) {
        b.a.r0.d2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (aVar = this.f51701f) == null || this.f51702g == null) {
            return;
        }
        aVar.z();
        this.f51702g.r(true);
        this.f51701f.w(Boolean.FALSE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            b.a.r0.d2.f fVar = this.f51702g;
            if (fVar != null) {
                fVar.w(this.f51704i);
                ArrayList<MarkData> arrayList = this.f51704i;
                this.mIsEnableEdit = (arrayList == null || arrayList.isEmpty()) ? false : true;
                sendEditEnableMessage(1);
                refresh();
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        b.a.r0.d2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f51702g == null || (aVar = this.f51701f) == null || !aVar.r()) {
            return;
        }
        this.f51702g.v(this.f51701f.q());
        this.f51701f.w(Boolean.FALSE);
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStart();
            this.f51702g.x();
        }
    }

    public final void refresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f51701f.m() == 0) {
            this.f51702g.v(this.f51701f.q());
        }
    }
}
