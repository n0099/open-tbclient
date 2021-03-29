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
import d.b.b.e.p.l;
import d.b.h0.r.s.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    public List<Long> closeLives;
    public List<d.b.i0.v1.h.a> datas;
    public d.b.h0.g0.f.d<d.b.i0.v1.h.a, d.b.h0.g0.d.b, d.b.i0.v1.i.a> mAdapter;
    public TextView mEditBtn;
    public BdListView mListView;
    public NavigationBar mNavigationBar;
    public RelativeLayout mRootLayout;
    public NavigationBarShadowView mShadowView;
    public PbHistoryCacheModel model;
    public boolean hasLoadStatus = false;
    public final CacheModel.c<d.b.i0.v1.h.a> callback = new a();
    public final HttpMessageListener listener = new b(CmdConfigHttp.CMD_ALA_LIVE_ROOM_CLOSED);
    public AbsListView.OnScrollListener mOnScrollListener = new c();

    /* loaded from: classes3.dex */
    public class a implements CacheModel.c<d.b.i0.v1.h.a> {
        public a() {
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void onCacheDataGet(ReadCacheRespMsg<List<d.b.i0.v1.h.a>> readCacheRespMsg, ReadCacheMessage<d.b.i0.v1.h.a> readCacheMessage) {
            if (readCacheRespMsg == null || readCacheRespMsg.getData() == null) {
                return;
            }
            PbHistoryActivity.this.datas = readCacheRespMsg.getData();
            ArrayList arrayList = new ArrayList();
            for (d.b.i0.v1.h.a aVar : readCacheRespMsg.getData()) {
                if (!StringUtils.isNull(aVar.g()) && Long.valueOf(aVar.g()).longValue() != 0) {
                    arrayList.add(Long.valueOf(aVar.g()));
                }
            }
            if (PbHistoryActivity.this.hasLoadStatus) {
                PbHistoryActivity.this.mergeLiveStatus();
                PbHistoryActivity pbHistoryActivity = PbHistoryActivity.this;
                pbHistoryActivity.updateUIByData(pbHistoryActivity.datas);
                return;
            }
            PbHistoryActivity.this.sendLiveRoomStatusMessage(arrayList, 0L);
            PbHistoryActivity.this.hasLoadStatus = true;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void onCacheDataWrite(WriteCacheRespMsg<List<d.b.i0.v1.h.a>> writeCacheRespMsg, WriteCacheMessage<d.b.i0.v1.h.a> writeCacheMessage) {
            if (writeCacheRespMsg == null || !writeCacheRespMsg.isSuccess()) {
                return;
            }
            if (writeCacheMessage.isClear()) {
                PbHistoryActivity.this.updateUIByData(new ArrayList());
            } else {
                PbHistoryActivity.this.refreshData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null) {
                return;
            }
            if (httpResponsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                PbHistoryActivity.this.closeLives = ((AlaMGetLiveStatusHttpResponseMessage) httpResponsedMessage).getCloseLives();
            }
            PbHistoryActivity.this.mergeLiveStatus();
            PbHistoryActivity pbHistoryActivity = PbHistoryActivity.this;
            pbHistoryActivity.updateUIByData(pbHistoryActivity.datas);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AbsListView.OnScrollListener {
        public c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                PbHistoryActivity.this.mShadowView.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                PbHistoryActivity.this.mShadowView.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* loaded from: classes3.dex */
        public class a implements a.e {
            public a() {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                PbHistoryActivity.this.model.B();
                aVar.dismiss();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements a.e {
            public b(d dVar) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(PbHistoryActivity.this.getPageContext().getPageActivity());
            aVar.setMessageId(R.string.pb_history_clear_tip);
            aVar.setPositiveButton(R.string.confirm, new a());
            aVar.setNegativeButton(R.string.cancel, new b(this));
            aVar.create(PbHistoryActivity.this.getPageContext()).show();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d.b.i0.v1.h.a aVar = (d.b.i0.v1.h.a) PbHistoryActivity.this.mAdapter.getItem(i);
            if (aVar != null) {
                if (aVar.m() == 49) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = d.b.b.e.m.b.f(aVar.g(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbHistoryActivity.this.getPageContext().getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SCAN_HISTORY, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) ? TbadkCoreApplication.getCurrentAccount() : "", false, "")));
                } else if (aVar.u()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            ViewHelper.skipToLoginActivity(PbHistoryActivity.this.getActivity());
                            return;
                        } else {
                            PbHistoryActivity.this.sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(PbHistoryActivity.this.getPageContext().getPageActivity(), aVar.b(), aVar.c(), 5)));
                            return;
                        }
                    }
                    l.K(PbHistoryActivity.this.getPageContext().getPageActivity(), R.string.manga_plugin_not_install_tip);
                } else {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(PbHistoryActivity.this.getPageContext().getPageActivity()).createHistoryCfg(aVar.i(), aVar.h(), aVar.s(), aVar.w(), null);
                    createHistoryCfg.setStartFrom(11);
                    createHistoryCfg.setIsShareThread(aVar.v());
                    PbHistoryActivity.this.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLiveStatus() {
        if (ListUtils.isEmpty(this.closeLives) || ListUtils.isEmpty(this.datas)) {
            return;
        }
        for (d.b.i0.v1.h.a aVar : this.datas) {
            if (!StringUtils.isNull(aVar.g()) && Long.valueOf(aVar.g()).longValue() != 0) {
                if (this.closeLives.contains(Long.valueOf(aVar.g()))) {
                    aVar.E(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.model.H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLiveRoomStatusMessage(List<Long> list, Long l) {
        AlaMGetLiveStatusRequestMessage alaMGetLiveStatusRequestMessage = new AlaMGetLiveStatusRequestMessage();
        alaMGetLiveStatusRequestMessage.setListIds(list);
        alaMGetLiveStatusRequestMessage.setAudienceCount(l.longValue());
        MessageManager.getInstance().sendMessage(alaMGetLiveStatusRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUIByData(List<d.b.i0.v1.h.a> list) {
        d.b.h0.g0.f.d<d.b.i0.v1.h.a, d.b.h0.g0.d.b, d.b.i0.v1.i.a> dVar = this.mAdapter;
        if (dVar != null) {
            dVar.k(list);
        }
        if (list != null && list.size() != 0) {
            this.mEditBtn.setVisibility(0);
        } else {
            this.mEditBtn.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a082";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        SkinManager.setNavbarTitleColor(this.mEditBtn, R.color.CAM_X0106, R.color.navi_op_text_skin);
        this.mAdapter.onChangeSkinType(getPageContext(), i);
        getLayoutMode().j(this.mRootLayout);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(getPageContext());
        this.model = pbHistoryCacheModel;
        pbHistoryCacheModel.K(this.callback);
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
        addTextButton.setOnClickListener(new d());
        this.mEditBtn.setVisibility(8);
        this.mListView = (BdListView) findViewById(R.id.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds88)));
        this.mListView.x(textView, 0);
        this.mAdapter = new d.b.h0.g0.f.d<>(getPageContext(), d.b.i0.v1.i.a.class, R.layout.pb_history_list_item, null);
        this.mAdapter.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds190)), NoDataViewFactory.e.d(null, getResources().getString(R.string.pb_history_no_data_tip_2)), null, null);
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mListView.setOnItemClickListener(new e());
        this.mListView.setOnScrollListener(this.mOnScrollListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        refreshData();
    }
}
