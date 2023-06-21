package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.az8;
import com.baidu.tieba.bz8;
import com.baidu.tieba.d55;
import com.baidu.tieba.dz8;
import com.baidu.tieba.ez8;
import com.baidu.tieba.me5;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.wi;
import com.baidu.tieba.x95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class ThreadFragment extends CollectFragment implements View.OnClickListener, x95.g, BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ez8 c;
    public dz8 d;
    public int e;
    public ArrayList<MarkData> f;
    public MarkData g;
    public final CustomMessageListener h;
    public final CustomMessageListener i;
    public final AntiHelper.k j;

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements d55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadFragment a;

        public a(ThreadFragment threadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadFragment;
        }

        @Override // com.baidu.tieba.d55.e
        public void onClick(d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                d55Var.dismiss();
                this.a.d.v(this.a.c.q());
                this.a.c.w(Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends bz8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadFragment a;

        public b(ThreadFragment threadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadFragment;
        }

        @Override // com.baidu.tieba.bz8
        public void a(Object... objArr) {
            boolean z;
            boolean z2;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objArr) == null) {
                boolean z3 = false;
                try {
                    String str2 = null;
                    if (((Integer) objArr[0]).intValue() == 0) {
                        this.a.d.c();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            str2 = (String) objArr[1];
                        }
                        this.a.d.e(str2, this.a.c, ((Boolean) objArr[2]).booleanValue());
                        this.a.f = this.a.c.n();
                        ThreadFragment threadFragment = this.a;
                        if (this.a.f != null && !this.a.f.isEmpty()) {
                            z3 = true;
                        }
                        threadFragment.a = z3;
                    } else if (((Integer) objArr[0]).intValue() == 3) {
                        this.a.d.c();
                        if (objArr[1] != null && (objArr[1] instanceof String)) {
                            str = (String) objArr[1];
                        } else {
                            str = null;
                        }
                        this.a.d.e(str, null, false);
                        this.a.d.p(this.a.c, false);
                        this.a.a = false;
                    } else if (((Integer) objArr[0]).intValue() == 1) {
                        if (objArr[1] != null) {
                            z2 = ((Boolean) objArr[1]).booleanValue();
                        } else {
                            z2 = false;
                        }
                        if (objArr[2] != null) {
                            str2 = (String) objArr[2];
                        }
                        if (objArr[3] != null) {
                            z3 = ((Boolean) objArr[3]).booleanValue();
                        }
                        this.a.d.f(z2, str2, z3);
                        if (z2) {
                            this.a.d.v(this.a.c.q());
                            this.a.c.w(Boolean.TRUE);
                        }
                    } else if (((Integer) objArr[0]).intValue() == 2) {
                        if (objArr[1] != null) {
                            z = ((Boolean) objArr[1]).booleanValue();
                        } else {
                            z = false;
                        }
                        if (objArr[2] != null) {
                            str2 = (String) objArr[2];
                        }
                        this.a.d.d(z, str2, this.a.c);
                        this.a.f = this.a.c.n();
                        ThreadFragment threadFragment2 = this.a;
                        if (this.a.f != null && !this.a.f.isEmpty()) {
                            z3 = true;
                        }
                        threadFragment2.a = z3;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    BdLog.d(e.getMessage());
                }
                this.a.J1(1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ThreadFragment threadFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment, Integer.valueOf(i)};
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
            this.a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Bundle)) {
                Bundle bundle = (Bundle) customResponsedMessage.getData();
                if (bundle.getInt("fragment_type", -1) == this.a.getType()) {
                    this.a.d.a(bundle.getBoolean("is_edit_state", false));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ThreadFragment threadFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment, Integer.valueOf(i)};
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
            this.a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                az8.c("c14066", ((Boolean) customResponsedMessage.getData()).booleanValue(), this.a.g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ThreadFragment threadFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment, Integer.valueOf(i)};
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
            this.a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage)) {
                return;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.a.d.j();
                this.a.d.c();
                this.a.d.r(false);
                this.a.d.b(false);
                return;
            }
            this.a.c.w(Boolean.FALSE);
            this.a.d.b(true);
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ThreadFragment threadFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment, Integer.valueOf(i)};
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
            this.a = threadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
            if (this.a.f != null && data != null) {
                if (data.i != null && AntiHelper.t(this.a.getActivity(), data.i, this.a.j) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                }
                if (data.a) {
                    Iterator it = this.a.f.iterator();
                    while (it.hasNext()) {
                        MarkData markData = (MarkData) it.next();
                        if (markData != null && StringHelper.equals(markData.getUesrId(), data.c)) {
                            markData.metaData.setIsLike(data.d);
                            markData.setLikeInPage(data.d);
                        }
                    }
                    this.a.d.m();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadFragment a;

        public g(ThreadFragment threadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    public ThreadFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = -1;
        this.h = new e(this, 2000994);
        this.i = new f(this, 2001115);
        this.j = new g(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            dz8 dz8Var = this.d;
            if (dz8Var != null) {
                dz8Var.w(this.f);
                ArrayList<MarkData> arrayList = this.f;
                if (arrayList != null && !arrayList.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                this.a = z;
                J1(1);
                refresh();
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.x95.g
    public void f(boolean z) {
        ez8 ez8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (ez8Var = this.c) != null && this.d != null) {
            ez8Var.z();
            this.d.r(true);
            this.c.w(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
            dz8 dz8Var = this.d;
            if (dz8Var != null) {
                dz8Var.n(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            W1();
            registerListener(this.h);
            registerListener(this.i);
            X1();
        }
    }

    public static final ThreadFragment V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return new ThreadFragment();
        }
        return (ThreadFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment
    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<MarkData> arrayList = this.f;
            if (arrayList != null && !arrayList.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            registerListener(new c(this, 2022208));
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            registerListener(new d(this, 2921531));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d.o();
            this.c.s();
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        ez8 ez8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.d != null && (ez8Var = this.c) != null && ez8Var.r()) {
            this.d.v(this.c.q());
            this.c.w(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tbadk.collectTab.CollectFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStart();
            this.d.x();
        }
    }

    public final void refresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.c.m() == 0) {
            this.d.v(this.c.q());
        }
    }

    public final void Y1(MarkData markData) {
        ez8 ez8Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, markData) == null) && markData != null && (ez8Var = this.c) != null) {
            int o = ez8Var.o();
            int v = me5.h0().v();
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            if (markData.getNewCounts() > 0) {
                i = 1;
            } else {
                i = 0;
            }
            TiebaStatic.eventStat(inst, "my_favorite_content", "is_redpoint", i, new Object[0]);
            if (markData.getNewCounts() > 0) {
                if (v > 0) {
                    me5.h0().a0(v - 1);
                } else {
                    me5.h0().a0(0);
                }
                if (o > 0) {
                    this.c.C(o - 1);
                } else {
                    this.c.C(0);
                }
            }
            markData.setNewCounts(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        ez8 ez8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (17001 == i) {
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    ez8 ez8Var2 = this.c;
                    if (ez8Var2 != null && markData != null && this.d != null) {
                        int count = ListUtils.getCount(ez8Var2.n());
                        int i3 = this.e;
                        if (count > i3 && i3 >= 0) {
                            this.c.n().get(this.e).setPostId(markData.getPostId());
                            this.c.n().get(this.e).setHostMode(markData.getHostMode());
                            this.c.n().get(this.e).setSequence(markData.getSequence());
                            this.d.m();
                        }
                    }
                }
            } else if (i2 == 1 && 17001 == i && (ez8Var = this.c) != null && this.d != null) {
                int count2 = ListUtils.getCount(ez8Var.n());
                int i4 = this.e;
                if (count2 > i4 && i4 >= 0) {
                    this.c.n().remove(this.e);
                    this.d.m();
                    this.d.p(this.c, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            int intValue = ((Integer) view2.getTag()).intValue();
            MarkData markData = (MarkData) ListUtils.getItem(this.f, intValue);
            this.g = markData;
            if (markData == null) {
                return;
            }
            boolean isShareThread = markData.isShareThread();
            StatisticItem statisticItem = new StatisticItem("c12529");
            if (view2.getId() == this.d.g(isShareThread)) {
                BdListView bdListView = this.d.c;
                if (bdListView != null && !bdListView.B()) {
                    return;
                }
                this.d.u();
                if (!this.c.D(intValue)) {
                    this.d.j();
                }
                az8.b("c14069", markData);
                return;
            }
            FragmentActivity activity = getActivity();
            if ((activity instanceof CollectTabActivity) && ((CollectTabActivity) activity).w1()) {
                wi.Q(activity, "请先退出编辑状态");
                super.onClick(view2);
                return;
            }
            if (view2.getId() == this.d.i(isShareThread)) {
                this.d.l(markData);
                statisticItem.param("obj_locate", 1);
                az8.b("c14064", markData);
            } else if (view2.getId() == this.d.h(isShareThread)) {
                statisticItem.param("obj_locate", 3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001)));
                az8.b("c14063", markData);
                Y1(markData);
            }
            statisticItem.param("tid", markData.getId());
            statisticItem.param("obj_id", markData.getUesrId());
            TiebaStatic.log(statisticItem);
            super.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d027f, (ViewGroup) null);
            this.c = new ez8();
            dz8 dz8Var = new dz8(this, inflate);
            this.d = dz8Var;
            dz8Var.q(new a(this));
            this.d.b(BdNetTypeUtil.isNetWorkAvailable());
            this.c.A(new b(this));
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            FragmentActivity activity = getActivity();
            if ((activity instanceof CollectTabActivity) && ((CollectTabActivity) activity).w1()) {
                wi.Q(activity, "请先退出编辑状态");
                super.onItemClick(adapterView, view2, i, j);
                return;
            }
            if (i >= 0 && i < this.c.n().size()) {
                this.e = i;
                MarkData markData = this.c.n().get(i);
                MarkData markData2 = this.f.get(i);
                this.g = markData2;
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
                            wi.P(getPageContext().getPageActivity(), R.string.manga_plugin_not_install_tip);
                        }
                    } else if (markData.getThreadType() == 40) {
                        ArrayList arrayList = new ArrayList();
                        VideoItemData videoItemData = new VideoItemData();
                        videoItemData.thread_id = markData.getThreadId();
                        arrayList.add(videoItemData);
                        new VideoRecommentPlayActivityConfig(getContext(), arrayList, null, VideoRecommentPlayActivityConfig.FROM_COLLECTION).start();
                    } else {
                        PbActivityConfig createMarkCfg = new PbActivityConfig(getPageContext().getPageActivity()).createMarkCfg(markData.getThreadId(), markData.getPostId(), markData.getHostMode(), markData.getSequence().booleanValue(), null, 17001);
                        createMarkCfg.setStartFrom(10);
                        createMarkCfg.setJumpToCommentArea(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createMarkCfg));
                        az8.b("c14063", markData2);
                    }
                }
                Y1(markData2);
                markData2.setRedTipShow(false);
            }
            super.onItemClick(adapterView, view2, i, j);
        }
    }
}
