package com.baidu.tieba.myCollection.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.R;
import com.baidu.tieba.g55;
import com.baidu.tieba.gr5;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.myCollection.message.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.tieba.myCollection.message.AlaMGetLiveStatusRequestMessage;
import com.baidu.tieba.nr5;
import com.baidu.tieba.s39;
import com.baidu.tieba.t39;
import com.baidu.tieba.vg;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public NavigationBar b;
    public NavigationBarShadowView c;
    public TextView d;
    public BdListView e;
    public nr5<s39, gr5, t39> f;
    public boolean g;
    public List<s39> h;
    public List<Long> i;
    public PbHistoryCacheModel j;
    public final CacheModel.c<s39> k;
    public final HttpMessageListener l;
    public AbsListView.OnScrollListener m;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.cs5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "a082" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbHistoryActivity a;

        /* loaded from: classes6.dex */
        public class a implements g55.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.tieba.g55.e
            public void onClick(g55 g55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, g55Var) == null) {
                    this.a.a.j.e0();
                    g55Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements g55.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.g55.e
            public void onClick(g55 g55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, g55Var) == null) {
                    g55Var.dismiss();
                }
            }
        }

        public d(PbHistoryActivity pbHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbHistoryActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g55 g55Var = new g55(this.a.getPageContext().getPageActivity());
                g55Var.setMessageId(R.string.obfuscated_res_0x7f0f0fc3);
                g55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04be, new a(this));
                g55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03cc, new b(this));
                g55Var.create(this.a.getPageContext()).show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements CacheModel.c<s39> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbHistoryActivity a;

        public a(PbHistoryActivity pbHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbHistoryActivity;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void l(WriteCacheRespMsg<List<s39>> writeCacheRespMsg, WriteCacheMessage<s39> writeCacheMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, writeCacheRespMsg, writeCacheMessage) == null) && writeCacheRespMsg != null && writeCacheRespMsg.isSuccess()) {
                if (writeCacheMessage.isClear()) {
                    this.a.O1(new ArrayList());
                } else {
                    this.a.M1();
                }
            }
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void q(ReadCacheRespMsg<List<s39>> readCacheRespMsg, ReadCacheMessage<s39> readCacheMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, readCacheRespMsg, readCacheMessage) == null) && readCacheRespMsg != null && readCacheRespMsg.getData() != null) {
                this.a.h = readCacheRespMsg.getData();
                ArrayList arrayList = new ArrayList();
                for (s39 s39Var : readCacheRespMsg.getData()) {
                    if (!StringUtils.isNull(s39Var.e()) && Long.valueOf(s39Var.e()).longValue() != 0) {
                        arrayList.add(Long.valueOf(s39Var.e()));
                    }
                }
                if (this.a.g) {
                    this.a.L1();
                    PbHistoryActivity pbHistoryActivity = this.a;
                    pbHistoryActivity.O1(pbHistoryActivity.h);
                    return;
                }
                this.a.N1(arrayList, 0L);
                this.a.g = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbHistoryActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbHistoryActivity pbHistoryActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbHistoryActivity, Integer.valueOf(i)};
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
            this.a = pbHistoryActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null) {
                return;
            }
            if (httpResponsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                this.a.i = ((AlaMGetLiveStatusHttpResponseMessage) httpResponsedMessage).getCloseLives();
            }
            this.a.L1();
            PbHistoryActivity pbHistoryActivity = this.a;
            pbHistoryActivity.O1(pbHistoryActivity.h);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbHistoryActivity a;

        public c(PbHistoryActivity pbHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbHistoryActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.a.c.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && i == 1) {
                this.a.c.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbHistoryActivity a;

        public e(PbHistoryActivity pbHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbHistoryActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            s39 s39Var;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && (s39Var = (s39) this.a.f.getItem(i)) != null) {
                if (s39Var.i() == 49) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = vg.g(s39Var.e(), 0L);
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        str = TbadkCoreApplication.getCurrentAccount();
                    } else {
                        str = "";
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a.getPageContext().getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SCAN_HISTORY, str, false, "")));
                } else if (s39Var.n()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            ViewHelper.skipToLoginActivity(this.a.getActivity());
                            return;
                        } else {
                            this.a.sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.a.getPageContext().getPageActivity(), s39Var.a(), s39Var.b(), 5)));
                            return;
                        }
                    }
                    xi.P(this.a.getPageContext().getPageActivity(), R.string.manga_plugin_not_install_tip);
                } else if (s39Var.i() == 40) {
                    ArrayList arrayList = new ArrayList();
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.thread_id = s39Var.g();
                    arrayList.add(videoItemData);
                    new VideoRecommentPlayActivityConfig(SelectorHelper.getContext(), arrayList, null, VideoRecommentPlayActivityConfig.FROM_HISTORY).start();
                } else {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createHistoryCfg(s39Var.g(), s39Var.f(), s39Var.l(), s39Var.q(), null);
                    createHistoryCfg.setStartFrom(11);
                    createHistoryCfg.setIsShareThread(s39Var.o());
                    this.a.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                }
            }
        }
    }

    public PbHistoryActivity() {
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
        this.g = false;
        this.k = new a(this);
        this.l = new b(this, CmdConfigHttp.CMD_ALA_LIVE_ROOM_CLOSED);
        this.m = new c(this);
    }

    public final void N1(List<Long> list, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, l) == null) {
            AlaMGetLiveStatusRequestMessage alaMGetLiveStatusRequestMessage = new AlaMGetLiveStatusRequestMessage();
            alaMGetLiveStatusRequestMessage.setListIds(list);
            alaMGetLiveStatusRequestMessage.setAudienceCount(l.longValue());
            MessageManager.getInstance().sendMessage(alaMGetLiveStatusRequestMessage);
        }
    }

    public final void O1(List<s39> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            nr5<s39, gr5, t39> nr5Var = this.f;
            if (nr5Var != null) {
                nr5Var.g(list);
            }
            if (list != null && list.size() != 0) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !ListUtils.isEmpty(this.i) && !ListUtils.isEmpty(this.h)) {
            for (s39 s39Var : this.h) {
                if (!StringUtils.isNull(s39Var.e()) && Long.valueOf(s39Var.e()).longValue() != 0) {
                    if (this.i.contains(Long.valueOf(s39Var.e()))) {
                        s39Var.z(false);
                    }
                }
            }
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j.k0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            M1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.onChangeSkinType(getPageContext(), i);
            SkinManager.setNavbarTitleColor(this.d, R.color.CAM_X0106, R.color.navi_op_text_skin);
            this.f.onChangeSkinType(getPageContext(), i);
            getLayoutMode().k(this.a);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(getPageContext());
            this.j = pbHistoryCacheModel;
            pbHistoryCacheModel.n0(this.k);
            registerListener(this.l);
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0775, (ViewGroup) null);
            this.a = relativeLayout;
            setContentView(relativeLayout);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.b = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.b.setCenterTextTitle(getPageContext().getString(R.string.my_history));
            this.c = (NavigationBarShadowView) findViewById(R.id.obfuscated_res_0x7f091898);
            TextView addTextButton = this.b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.clear_all_text));
            this.d = addTextButton;
            addTextButton.setOnClickListener(new d(this));
            this.d.setVisibility(8);
            this.e = (BdListView) findViewById(R.id.obfuscated_res_0x7f09150b);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + xi.g(getActivity(), R.dimen.obfuscated_res_0x7f07041a)));
            this.e.w(textView, 0);
            this.f = new nr5<>(getPageContext(), t39.class, R.layout.obfuscated_res_0x7f0d0776, null);
            this.f.f(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070385)), NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0fc5)), null, null);
            this.e.setAdapter((ListAdapter) this.f);
            this.e.setOnItemClickListener(new e(this));
            this.e.setOnScrollListener(this.m);
        }
    }
}
