package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaTabFeedActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.data.LiveRemindNormalConfigData;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.live.LiveStartClickDataEvent;
import com.baidu.tieba.image.liveroom.LiveRoomRecommendListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes8.dex */
public class uf8 implements ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveRoomRecommendListAdapter a;
    public int b;
    public TbPageContext c;
    public LiveRemindNormalConfigData d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public List<String> i;
    public CustomMessageListener j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uf8 a;

        public a(uf8 uf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uf8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                mf8.c(2, this.a.e, this.a.g, TbadkCoreApplication.getCurrentAccount(), this.a.f, null);
                this.a.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends StaggeredGridLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(uf8 uf8Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uf8Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<uf8> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(uf8 uf8Var) {
            super(2921733);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(uf8Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            uf8 uf8Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (uf8Var = this.a.get()) == null || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921733 || customResponsedMessage.hasError() || customResponsedMessage.getError() != 0) {
                return;
            }
            uf8Var.d = k85.a().b;
        }
    }

    public uf8(List<String> list, TbPageContext tbPageContext, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, tbPageContext, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.e = "";
        this.f = "";
        this.g = "";
        this.j = new c(this);
        this.i = list;
        this.c = tbPageContext;
        this.a = new LiveRoomRecommendListAdapter(tbPageContext, str, str2, str3);
        this.d = k85.a().b;
        this.g = str2;
        this.e = str;
        this.f = str3;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.b = i;
            this.a.q(i);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.h = z;
        }
    }

    public void k(List<tf8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.a.r(list);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (!this.h) {
                return null;
            }
            String str = (String) ListUtils.getItem(this.i, i);
            if (!TextUtils.isEmpty(str) && !str.startsWith("####mLiveRoomPageProvider")) {
                return null;
            }
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0843, viewGroup, false);
            WebPManager.setPureDrawable((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0903e4), R.drawable.icon_pure_datuwei_live_more, R.color.CAM_X0101, null);
            EMManager.from((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0903e5)).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X08);
            inflate.findViewById(R.id.obfuscated_res_0x7f0903e3).setOnClickListener(new a(this));
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0903e7);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = this.b;
            linearLayout.setLayoutParams(layoutParams);
            viewGroup.addView(inflate);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f0903ea);
            bdRecyclerView.setLayoutManager(new b(this, 2, 1));
            bdRecyclerView.addItemDecoration(new LiveRoomRecommendListAdapter.LiveRoomItemDecoration());
            bdRecyclerView.setAdapter(this.a);
            MessageManager.getInstance().registerListener(this.j);
            return inflate;
        }
        return (View) invokeLI.objValue;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                if (StringUtils.isNull(str)) {
                    new AlaTabFeedActivityConfig(this.c.getPageActivity()).start();
                    return;
                } else {
                    UrlManager.getInstance().dealOneLink(this.c, new String[]{str}, true);
                    return;
                }
            }
            LiveStartClickDataEvent liveStartClickDataEvent = new LiveStartClickDataEvent();
            liveStartClickDataEvent.viewTag = str;
            MutiProcessManager.publishEvent(liveStartClickDataEvent);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LiveRemindNormalConfigData liveRemindNormalConfigData = this.d;
            if (liveRemindNormalConfigData != null && !StringUtils.isNull(liveRemindNormalConfigData.getNormalIconScheme())) {
                g(ud5.a(this.d.getNormalIconScheme(), 4));
            } else {
                g("");
            }
        }
    }
}
