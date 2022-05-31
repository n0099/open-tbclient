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
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.myCollection.message.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.tieba.myCollection.message.AlaMGetLiveStatusRequestMessage;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ck7;
import com.repackage.dk7;
import com.repackage.dq4;
import com.repackage.i65;
import com.repackage.jg;
import com.repackage.li;
import com.repackage.q65;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheModel.c<ck7> callback;
    public List<Long> closeLives;
    public List<ck7> datas;
    public boolean hasLoadStatus;
    public final HttpMessageListener listener;
    public q65<ck7, i65, dk7> mAdapter;
    public TextView mEditBtn;
    public BdListView mListView;
    public NavigationBar mNavigationBar;
    public AbsListView.OnScrollListener mOnScrollListener;
    public RelativeLayout mRootLayout;
    public NavigationBarShadowView mShadowView;
    public PbHistoryCacheModel model;

    /* loaded from: classes3.dex */
    public class a implements CacheModel.c<ck7> {
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
        public void e(WriteCacheRespMsg<List<ck7>> writeCacheRespMsg, WriteCacheMessage<ck7> writeCacheMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, writeCacheRespMsg, writeCacheMessage) == null) && writeCacheRespMsg != null && writeCacheRespMsg.isSuccess()) {
                if (writeCacheMessage.isClear()) {
                    this.a.updateUIByData(new ArrayList());
                } else {
                    this.a.refreshData();
                }
            }
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void g(ReadCacheRespMsg<List<ck7>> readCacheRespMsg, ReadCacheMessage<ck7> readCacheMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, readCacheRespMsg, readCacheMessage) == null) || readCacheRespMsg == null || readCacheRespMsg.getData() == null) {
                return;
            }
            this.a.datas = readCacheRespMsg.getData();
            ArrayList arrayList = new ArrayList();
            for (ck7 ck7Var : readCacheRespMsg.getData()) {
                if (!StringUtils.isNull(ck7Var.e()) && Long.valueOf(ck7Var.e()).longValue() != 0) {
                    arrayList.add(Long.valueOf(ck7Var.e()));
                }
            }
            if (this.a.hasLoadStatus) {
                this.a.mergeLiveStatus();
                PbHistoryActivity pbHistoryActivity = this.a;
                pbHistoryActivity.updateUIByData(pbHistoryActivity.datas);
                return;
            }
            this.a.sendLiveRoomStatusMessage(arrayList, 0L);
            this.a.hasLoadStatus = true;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                this.a.mShadowView.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && i == 1) {
                this.a.mShadowView.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbHistoryActivity a;

        /* loaded from: classes3.dex */
        public class a implements dq4.e {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    this.a.a.model.H();
                    dq4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements dq4.e {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
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
                dq4 dq4Var = new dq4(this.a.getPageContext().getPageActivity());
                dq4Var.setMessageId(R.string.obfuscated_res_0x7f0f0dc2);
                dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f042e, new a(this));
                dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new b(this));
                dq4Var.create(this.a.getPageContext()).show();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            ck7 ck7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (ck7Var = (ck7) this.a.mAdapter.getItem(i)) == null) {
                return;
            }
            if (ck7Var.k() == 49) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = jg.g(ck7Var.e(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a.getPageContext().getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SCAN_HISTORY, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) ? TbadkCoreApplication.getCurrentAccount() : "", false, "")));
            } else if (ck7Var.r()) {
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                    if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        ViewHelper.skipToLoginActivity(this.a.getActivity());
                        return;
                    } else {
                        this.a.sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.a.getPageContext().getPageActivity(), ck7Var.a(), ck7Var.b(), 5)));
                        return;
                    }
                }
                li.N(this.a.getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f0a86);
            } else if (ck7Var.k() == 40) {
                ArrayList arrayList = new ArrayList();
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.thread_id = ck7Var.h();
                arrayList.add(videoItemData);
                VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(SelectorHelper.getContext(), arrayList, null, VideoRecommentPlayActivityConfig.FROM_HISTORY);
                videoRecommentPlayActivityConfig.setParamIsVertail(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
            } else {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createHistoryCfg(ck7Var.h(), ck7Var.g(), ck7Var.o(), ck7Var.t(), null);
                createHistoryCfg.setStartFrom(11);
                createHistoryCfg.setIsShareThread(ck7Var.s());
                this.a.sendMessage(new CustomMessage(2004001, createHistoryCfg));
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
        for (ck7 ck7Var : this.datas) {
            if (!StringUtils.isNull(ck7Var.e()) && Long.valueOf(ck7Var.e()).longValue() != 0) {
                if (this.closeLives.contains(Long.valueOf(ck7Var.e()))) {
                    ck7Var.E(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.model.N();
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
    public void updateUIByData(List<ck7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, list) == null) {
            q65<ck7, i65, dk7> q65Var = this.mAdapter;
            if (q65Var != null) {
                q65Var.g(list);
            }
            if (list != null && list.size() != 0) {
                this.mEditBtn.setVisibility(0);
            } else {
                this.mEditBtn.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.f75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a082" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setNavbarTitleColor(this.mEditBtn, R.color.CAM_X0106, R.color.obfuscated_res_0x7f06087a);
            this.mAdapter.onChangeSkinType(getPageContext(), i);
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
            pbHistoryCacheModel.Q(this.callback);
            registerListener(this.listener);
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0668, (ViewGroup) null);
            this.mRootLayout = relativeLayout;
            setContentView(relativeLayout);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923a2);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f0b47));
            this.mShadowView = (NavigationBarShadowView) findViewById(R.id.obfuscated_res_0x7f0914e4);
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f03db));
            this.mEditBtn = addTextButton;
            addTextButton.setOnClickListener(new d(this));
            this.mEditBtn.setVisibility(8);
            this.mListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f09123c);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + li.f(getActivity(), R.dimen.obfuscated_res_0x7f070309)));
            this.mListView.x(textView, 0);
            this.mAdapter = new q65<>(getPageContext(), dk7.class, R.layout.obfuscated_res_0x7f0d0669, null);
            this.mAdapter.f(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07026b)), NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0dc4)), null, null);
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
