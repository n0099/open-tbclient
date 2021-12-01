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
import c.a.d.f.p.l;
import c.a.q0.s.s.a;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.R;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.myCollection.message.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.tieba.myCollection.message.AlaMGetLiveStatusRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheModel.c<c.a.r0.j2.h.a> callback;
    public List<Long> closeLives;
    public List<c.a.r0.j2.h.a> datas;
    public boolean hasLoadStatus;
    public final HttpMessageListener listener;
    public c.a.q0.l0.f.d<c.a.r0.j2.h.a, c.a.q0.l0.d.b, c.a.r0.j2.i.a> mAdapter;
    public TextView mEditBtn;
    public BdListView mListView;
    public NavigationBar mNavigationBar;
    public AbsListView.OnScrollListener mOnScrollListener;
    public RelativeLayout mRootLayout;
    public NavigationBarShadowView mShadowView;
    public PbHistoryCacheModel model;

    /* loaded from: classes10.dex */
    public class a implements CacheModel.c<c.a.r0.j2.h.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbHistoryActivity f47112e;

        public a(PbHistoryActivity pbHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47112e = pbHistoryActivity;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void onCacheDataGet(ReadCacheRespMsg<List<c.a.r0.j2.h.a>> readCacheRespMsg, ReadCacheMessage<c.a.r0.j2.h.a> readCacheMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, readCacheRespMsg, readCacheMessage) == null) || readCacheRespMsg == null || readCacheRespMsg.getData() == null) {
                return;
            }
            this.f47112e.datas = readCacheRespMsg.getData();
            ArrayList arrayList = new ArrayList();
            for (c.a.r0.j2.h.a aVar : readCacheRespMsg.getData()) {
                if (!StringUtils.isNull(aVar.f()) && Long.valueOf(aVar.f()).longValue() != 0) {
                    arrayList.add(Long.valueOf(aVar.f()));
                }
            }
            if (this.f47112e.hasLoadStatus) {
                this.f47112e.mergeLiveStatus();
                PbHistoryActivity pbHistoryActivity = this.f47112e;
                pbHistoryActivity.updateUIByData(pbHistoryActivity.datas);
                return;
            }
            this.f47112e.sendLiveRoomStatusMessage(arrayList, 0L);
            this.f47112e.hasLoadStatus = true;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void onCacheDataWrite(WriteCacheRespMsg<List<c.a.r0.j2.h.a>> writeCacheRespMsg, WriteCacheMessage<c.a.r0.j2.h.a> writeCacheMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeCacheRespMsg, writeCacheMessage) == null) && writeCacheRespMsg != null && writeCacheRespMsg.isSuccess()) {
                if (writeCacheMessage.isClear()) {
                    this.f47112e.updateUIByData(new ArrayList());
                } else {
                    this.f47112e.refreshData();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbHistoryActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbHistoryActivity pbHistoryActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbHistoryActivity, Integer.valueOf(i2)};
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
            this.a = pbHistoryActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            if (httpResponsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                this.a.closeLives = ((AlaMGetLiveStatusHttpResponseMessage) httpResponsedMessage).getCloseLives();
            }
            this.a.mergeLiveStatus();
            PbHistoryActivity pbHistoryActivity = this.a;
            pbHistoryActivity.updateUIByData(pbHistoryActivity.datas);
        }
    }

    /* loaded from: classes10.dex */
    public class c implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbHistoryActivity f47113e;

        public c(PbHistoryActivity pbHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47113e = pbHistoryActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.f47113e.mShadowView.hide();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && i2 == 1) {
                this.f47113e.mShadowView.show();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbHistoryActivity f47114e;

        /* loaded from: classes10.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f47115e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47115e = dVar;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f47115e.f47114e.model.F();
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes10.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47114e = pbHistoryActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f47114e.getPageContext().getPageActivity());
                aVar.setMessageId(R.string.pb_history_clear_tip);
                aVar.setPositiveButton(R.string.confirm, new a(this));
                aVar.setNegativeButton(R.string.cancel, new b(this));
                aVar.create(this.f47114e.getPageContext()).show();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbHistoryActivity f47116e;

        public e(PbHistoryActivity pbHistoryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47116e = pbHistoryActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            c.a.r0.j2.h.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (aVar = (c.a.r0.j2.h.a) this.f47116e.mAdapter.getItem(i2)) == null) {
                return;
            }
            if (aVar.k() == 49) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = c.a.d.f.m.b.g(aVar.f(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f47116e.getPageContext().getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SCAN_HISTORY, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) ? TbadkCoreApplication.getCurrentAccount() : "", false, "")));
            } else if (aVar.r()) {
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                    if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        ViewHelper.skipToLoginActivity(this.f47116e.getActivity());
                        return;
                    } else {
                        this.f47116e.sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.f47116e.getPageContext().getPageActivity(), aVar.a(), aVar.b(), 5)));
                        return;
                    }
                }
                l.L(this.f47116e.getPageContext().getPageActivity(), R.string.manga_plugin_not_install_tip);
            } else {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.f47116e.getPageContext().getPageActivity()).createHistoryCfg(aVar.i(), aVar.g(), aVar.p(), aVar.w(), null);
                createHistoryCfg.setStartFrom(11);
                createHistoryCfg.setIsShareThread(aVar.t());
                this.f47116e.sendMessage(new CustomMessage(2004001, createHistoryCfg));
            }
        }
    }

    public PbHistoryActivity() {
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
        this.hasLoadStatus = false;
        this.callback = new a(this);
        this.listener = new b(this, CmdConfigHttp.CMD_ALA_LIVE_ROOM_CLOSED);
        this.mOnScrollListener = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLiveStatus() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || ListUtils.isEmpty(this.closeLives) || ListUtils.isEmpty(this.datas)) {
            return;
        }
        for (c.a.r0.j2.h.a aVar : this.datas) {
            if (!StringUtils.isNull(aVar.f()) && Long.valueOf(aVar.f()).longValue() != 0) {
                if (this.closeLives.contains(Long.valueOf(aVar.f()))) {
                    aVar.E(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.model.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLiveRoomStatusMessage(List<Long> list, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, this, list, l) == null) {
            AlaMGetLiveStatusRequestMessage alaMGetLiveStatusRequestMessage = new AlaMGetLiveStatusRequestMessage();
            alaMGetLiveStatusRequestMessage.setListIds(list);
            alaMGetLiveStatusRequestMessage.setAudienceCount(l.longValue());
            MessageManager.getInstance().sendMessage(alaMGetLiveStatusRequestMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUIByData(List<c.a.r0.j2.h.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, list) == null) {
            c.a.q0.l0.f.d<c.a.r0.j2.h.a, c.a.q0.l0.d.b, c.a.r0.j2.i.a> dVar = this.mAdapter;
            if (dVar != null) {
                dVar.k(list);
            }
            if (list != null && list.size() != 0) {
                this.mEditBtn.setVisibility(0);
            } else {
                this.mEditBtn.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.q0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a082" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setNavbarTitleColor(this.mEditBtn, R.color.CAM_X0106, R.color.navi_op_text_skin);
            this.mAdapter.onChangeSkinType(getPageContext(), i2);
            getLayoutMode().j(this.mRootLayout);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(getPageContext());
            this.model = pbHistoryCacheModel;
            pbHistoryCacheModel.O(this.callback);
            registerListener(this.listener);
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.pb_history_activity, (ViewGroup) null);
            this.mRootLayout = relativeLayout;
            setContentView(relativeLayout);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.my_history));
            this.mShadowView = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_pb_history);
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.clear_all_text));
            this.mEditBtn = addTextButton;
            addTextButton.setOnClickListener(new d(this));
            this.mEditBtn.setVisibility(8);
            this.mListView = (BdListView) findViewById(R.id.list);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(getActivity(), R.dimen.ds88)));
            this.mListView.addHeaderView(textView, 0);
            this.mAdapter = new c.a.q0.l0.f.d<>(getPageContext(), c.a.r0.j2.i.a.class, R.layout.pb_history_list_item, null);
            this.mAdapter.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds190)), NoDataViewFactory.e.d(null, getResources().getString(R.string.pb_history_no_data_tip_2)), null, null);
            this.mListView.setAdapter((ListAdapter) this.mAdapter);
            this.mListView.setOnItemClickListener(new e(this));
            this.mListView.setOnScrollListener(this.mOnScrollListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.listener);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            refreshData();
        }
    }
}
