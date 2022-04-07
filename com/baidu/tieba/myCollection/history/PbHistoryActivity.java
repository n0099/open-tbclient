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
import com.repackage.d75;
import com.repackage.dr4;
import com.repackage.mg;
import com.repackage.oi;
import com.repackage.rm7;
import com.repackage.sm7;
import com.repackage.v65;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheModel.c<rm7> callback;
    public List<Long> closeLives;
    public List<rm7> datas;
    public boolean hasLoadStatus;
    public final HttpMessageListener listener;
    public d75<rm7, v65, sm7> mAdapter;
    public TextView mEditBtn;
    public BdListView mListView;
    public NavigationBar mNavigationBar;
    public AbsListView.OnScrollListener mOnScrollListener;
    public RelativeLayout mRootLayout;
    public NavigationBarShadowView mShadowView;
    public PbHistoryCacheModel model;

    /* loaded from: classes3.dex */
    public class a implements CacheModel.c<rm7> {
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
        public void e(WriteCacheRespMsg<List<rm7>> writeCacheRespMsg, WriteCacheMessage<rm7> writeCacheMessage) {
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
        public void g(ReadCacheRespMsg<List<rm7>> readCacheRespMsg, ReadCacheMessage<rm7> readCacheMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, readCacheRespMsg, readCacheMessage) == null) || readCacheRespMsg == null || readCacheRespMsg.getData() == null) {
                return;
            }
            this.a.datas = readCacheRespMsg.getData();
            ArrayList arrayList = new ArrayList();
            for (rm7 rm7Var : readCacheRespMsg.getData()) {
                if (!StringUtils.isNull(rm7Var.e()) && Long.valueOf(rm7Var.e()).longValue() != 0) {
                    arrayList.add(Long.valueOf(rm7Var.e()));
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
        public class a implements dr4.e {
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

            @Override // com.repackage.dr4.e
            public void onClick(dr4 dr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                    this.a.a.model.H();
                    dr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements dr4.e {
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

            @Override // com.repackage.dr4.e
            public void onClick(dr4 dr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                    dr4Var.dismiss();
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
                dr4 dr4Var = new dr4(this.a.getPageContext().getPageActivity());
                dr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0da5);
                dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0421, new a(this));
                dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new b(this));
                dr4Var.create(this.a.getPageContext()).show();
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
            rm7 rm7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (rm7Var = (rm7) this.a.mAdapter.getItem(i)) == null) {
                return;
            }
            if (rm7Var.k() == 49) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = mg.g(rm7Var.e(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a.getPageContext().getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SCAN_HISTORY, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) ? TbadkCoreApplication.getCurrentAccount() : "", false, "")));
            } else if (rm7Var.r()) {
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                    if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        ViewHelper.skipToLoginActivity(this.a.getActivity());
                        return;
                    } else {
                        this.a.sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.a.getPageContext().getPageActivity(), rm7Var.a(), rm7Var.b(), 5)));
                        return;
                    }
                }
                oi.M(this.a.getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f0a79);
            } else if (rm7Var.k() == 40) {
                ArrayList arrayList = new ArrayList();
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.thread_id = rm7Var.h();
                arrayList.add(videoItemData);
                VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(SelectorHelper.getContext(), arrayList, null, VideoRecommentPlayActivityConfig.FROM_HISTORY);
                videoRecommentPlayActivityConfig.setParamIsVertail(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
            } else {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createHistoryCfg(rm7Var.h(), rm7Var.g(), rm7Var.o(), rm7Var.t(), null);
                createHistoryCfg.setStartFrom(11);
                createHistoryCfg.setIsShareThread(rm7Var.s());
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
        for (rm7 rm7Var : this.datas) {
            if (!StringUtils.isNull(rm7Var.e()) && Long.valueOf(rm7Var.e()).longValue() != 0) {
                if (this.closeLives.contains(Long.valueOf(rm7Var.e()))) {
                    rm7Var.E(false);
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
    public void updateUIByData(List<rm7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, list) == null) {
            d75<rm7, v65, sm7> d75Var = this.mAdapter;
            if (d75Var != null) {
                d75Var.k(list);
            }
            if (list != null && list.size() != 0) {
                this.mEditBtn.setVisibility(0);
            } else {
                this.mEditBtn.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.v75
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
            SkinManager.setNavbarTitleColor(this.mEditBtn, R.color.CAM_X0106, R.color.obfuscated_res_0x7f060870);
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
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0681, (ViewGroup) null);
            this.mRootLayout = relativeLayout;
            setContentView(relativeLayout);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ab);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f0b2e));
            this.mShadowView = (NavigationBarShadowView) findViewById(R.id.obfuscated_res_0x7f091505);
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f03d3));
            this.mEditBtn = addTextButton;
            addTextButton.setOnClickListener(new d(this));
            this.mEditBtn.setVisibility(8);
            this.mListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f09126c);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + oi.f(getActivity(), R.dimen.obfuscated_res_0x7f070309)));
            this.mListView.x(textView, 0);
            this.mAdapter = new d75<>(getPageContext(), sm7.class, R.layout.obfuscated_res_0x7f0d0682, null);
            this.mAdapter.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07026b)), NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0da7)), null, null);
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
