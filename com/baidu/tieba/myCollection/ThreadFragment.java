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
import c.a.q0.s.f0.f;
import c.a.q0.s.s.a;
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
    public c.a.r0.c2.g.a f54471f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.c2.f f54472g;

    /* renamed from: h  reason: collision with root package name */
    public int f54473h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<MarkData> f54474i;

    /* renamed from: j  reason: collision with root package name */
    public MarkData f54475j;
    public final CustomMessageListener k;
    public final CustomMessageListener l;
    public final AntiHelper.k m;

    /* loaded from: classes7.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54476e;

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
            this.f54476e = threadFragment;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f54476e.f54472g.v(this.f54476e.f54471f.q());
                this.f54476e.f54471f.w(Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.r0.c2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54477a;

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
            this.f54477a = threadFragment;
        }

        @Override // c.a.r0.c2.d
        public void a(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objArr) == null) {
                try {
                    if (((Integer) objArr[0]).intValue() == 0) {
                        this.f54477a.f54472g.c();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            r3 = (String) objArr[1];
                        }
                        this.f54477a.f54472g.e(r3, this.f54477a.f54471f, ((Boolean) objArr[2]).booleanValue());
                        this.f54477a.f54474i = this.f54477a.f54471f.n();
                        ThreadFragment threadFragment = this.f54477a;
                        if (this.f54477a.f54474i != null && !this.f54477a.f54474i.isEmpty()) {
                            r0 = true;
                        }
                        threadFragment.mIsEnableEdit = r0;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        this.f54477a.f54472g.c();
                        this.f54477a.f54472g.e((objArr[1] == null || !(objArr[1] instanceof String)) ? null : (String) objArr[1], null, false);
                        this.f54477a.f54472g.p(this.f54477a.f54471f, false);
                        this.f54477a.mIsEnableEdit = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                        this.f54477a.f54472g.f(booleanValue, objArr[2] != null ? (String) objArr[2] : null, objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false);
                        if (booleanValue) {
                            this.f54477a.f54472g.v(this.f54477a.f54471f.q());
                            this.f54477a.f54471f.w(Boolean.TRUE);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        this.f54477a.f54472g.d(objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false, objArr[2] != null ? (String) objArr[2] : null, this.f54477a.f54471f);
                        this.f54477a.f54474i = this.f54477a.f54471f.n();
                        ThreadFragment threadFragment2 = this.f54477a;
                        if (this.f54477a.f54474i != null && !this.f54477a.f54474i.isEmpty()) {
                            r0 = true;
                        }
                        threadFragment2.mIsEnableEdit = r0;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BdLog.d(e2.getMessage());
                }
                this.f54477a.sendEditEnableMessage(1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54478a;

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
            this.f54478a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Bundle)) {
                Bundle bundle = (Bundle) customResponsedMessage.getData();
                if (bundle.getInt(CollectFragment.FRAGMENT_TYPE, -1) == this.f54478a.getType()) {
                    this.f54478a.f54472g.a(bundle.getBoolean(CollectFragment.EDITOR_STATE_EXTRA, false));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54479a;

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
            this.f54479a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                c.a.r0.c2.c.c("c14066", ((Boolean) customResponsedMessage.getData()).booleanValue(), this.f54479a.f54475j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54480a;

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
            this.f54480a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (!j.z()) {
                    this.f54480a.f54472g.j();
                    this.f54480a.f54472g.c();
                    this.f54480a.f54472g.r(false);
                    this.f54480a.f54472g.b(false);
                    return;
                }
                this.f54480a.f54471f.w(Boolean.FALSE);
                this.f54480a.f54472g.b(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54481a;

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
            this.f54481a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (this.f54481a.f54474i == null || data == null) {
                    return;
                }
                if (data.l != null && AntiHelper.t(this.f54481a.getActivity(), data.l, this.f54481a.m) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                }
                if (data.f48082a) {
                    Iterator it = this.f54481a.f54474i.iterator();
                    while (it.hasNext()) {
                        MarkData markData = (MarkData) it.next();
                        if (markData != null && StringHelper.equals(markData.getUesrId(), data.f48084c)) {
                            markData.metaData.setIsLike(data.f48085d);
                            markData.setLikeInPage(data.f48085d);
                        }
                    }
                    if (data.f48085d) {
                        l.L(this.f54481a.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                    this.f54481a.f54472g.m();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadFragment f54482a;

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
            this.f54482a = threadFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.q0.s.s.a aVar) {
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
        this.f54471f = null;
        this.f54472g = null;
        this.f54473h = -1;
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
            ArrayList<MarkData> arrayList = this.f54474i;
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
        c.a.r0.c2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, markData) == null) || markData == null || (aVar = this.f54471f) == null) {
            return;
        }
        int o = aVar.o();
        int w = c.a.q0.t.d.b.g0().w();
        TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "my_favorite_content", "is_redpoint", markData.getNewCounts() > 0 ? 1 : 0, new Object[0]);
        if (markData.getNewCounts() > 0) {
            if (w > 0) {
                c.a.q0.t.d.b.g0().a0(w - 1);
            } else {
                c.a.q0.t.d.b.g0().a0(0);
            }
            if (o > 0) {
                this.f54471f.C(o - 1);
            } else {
                this.f54471f.C(0);
            }
        }
        markData.setNewCounts(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        c.a.r0.c2.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                if (i3 != 1 || 17001 != i2 || (aVar = this.f54471f) == null || this.f54472g == null) {
                    return;
                }
                int count = ListUtils.getCount(aVar.n());
                int i4 = this.f54473h;
                if (count <= i4 || i4 < 0) {
                    return;
                }
                this.f54471f.n().remove(this.f54473h);
                this.f54472g.m();
                this.f54472g.p(this.f54471f, false);
            } else if (17001 == i2) {
                MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                c.a.r0.c2.g.a aVar2 = this.f54471f;
                if (aVar2 == null || markData == null || this.f54472g == null) {
                    return;
                }
                int count2 = ListUtils.getCount(aVar2.n());
                int i5 = this.f54473h;
                if (count2 <= i5 || i5 < 0) {
                    return;
                }
                this.f54471f.n().get(this.f54473h).setPostId(markData.getPostId());
                this.f54471f.n().get(this.f54473h).setHostMode(markData.getHostMode());
                this.f54471f.n().get(this.f54473h).setSequence(markData.getSequence());
                this.f54472g.m();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.r0.c2.f fVar = this.f54472g;
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
            MarkData markData = (MarkData) ListUtils.getItem(this.f54474i, intValue);
            this.f54475j = markData;
            if (markData == null) {
                return;
            }
            boolean isShareThread = markData.isShareThread();
            StatisticItem statisticItem = new StatisticItem("c12529");
            if (view.getId() == this.f54472g.g(isShareThread)) {
                BdListView bdListView = this.f54472g.f16472c;
                if (bdListView != null && !bdListView.isRefreshDone()) {
                    return;
                }
                this.f54472g.u();
                if (!this.f54471f.D(intValue)) {
                    this.f54472g.j();
                }
                c.a.r0.c2.c.b("c14069", markData);
            } else if (view.getId() == this.f54472g.i(isShareThread)) {
                this.f54472g.l(markData);
                statisticItem.param("obj_locate", 1);
                c.a.r0.c2.c.b("c14064", markData);
            } else if (view.getId() == this.f54472g.h(isShareThread)) {
                statisticItem.param("obj_locate", 3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
                c.a.r0.c2.c.b("c14063", markData);
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
            this.f54471f = new c.a.r0.c2.g.a();
            c.a.r0.c2.f fVar = new c.a.r0.c2.f(this, inflate);
            this.f54472g = fVar;
            fVar.q(new a(this));
            this.f54472g.b(j.z());
            this.f54471f.A(new b(this));
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f54472g.o();
            this.f54471f.s();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (i2 >= 0 && i2 < this.f54471f.n().size()) {
                this.f54473h = i2;
                MarkData markData = this.f54471f.n().get(i2);
                MarkData markData2 = this.f54474i.get(i2);
                this.f54475j = markData2;
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
                        c.a.r0.c2.c.b("c14063", markData2);
                    }
                }
                m(markData2);
                markData2.setRedTipShow(false);
            }
            super.onItemClick(adapterView, view, i2, j2);
        }
    }

    @Override // c.a.q0.s.f0.f.g
    public void onListPullRefresh(boolean z) {
        c.a.r0.c2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (aVar = this.f54471f) == null || this.f54472g == null) {
            return;
        }
        aVar.z();
        this.f54472g.r(true);
        this.f54471f.w(Boolean.FALSE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            c.a.r0.c2.f fVar = this.f54472g;
            if (fVar != null) {
                fVar.w(this.f54474i);
                ArrayList<MarkData> arrayList = this.f54474i;
                this.mIsEnableEdit = (arrayList == null || arrayList.isEmpty()) ? false : true;
                sendEditEnableMessage(1);
                refresh();
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        c.a.r0.c2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f54472g == null || (aVar = this.f54471f) == null || !aVar.r()) {
            return;
        }
        this.f54472g.v(this.f54471f.q());
        this.f54471f.w(Boolean.FALSE);
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStart();
            this.f54472g.x();
        }
    }

    public final void refresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f54471f.m() == 0) {
            this.f54472g.v(this.f54471f.q());
        }
    }
}
