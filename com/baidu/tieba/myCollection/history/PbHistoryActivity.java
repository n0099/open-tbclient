package com.baidu.tieba.myCollection.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.d;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.R;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.myCollection.message.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.tieba.myCollection.message.AlaMGetLiveStatusRequestMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    private BdListView WV;
    private RelativeLayout bNf;
    private List<com.baidu.tieba.myCollection.baseHistory.a> cbD;
    private List<Long> closeLives;
    private d<com.baidu.tieba.myCollection.baseHistory.a, b, a> kNc;
    private NavigationBarShadowView kNs;
    private TextView lud;
    private NavigationBar mNavigationBar;
    private PbHistoryCacheModel model;
    private boolean lue = false;
    private final CacheModel.a<com.baidu.tieba.myCollection.baseHistory.a> callback = new CacheModel.a<com.baidu.tieba.myCollection.baseHistory.a>() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.1
        @Override // com.baidu.tbadk.mvc.model.CacheModel.a
        public void onCacheDataGet(ReadCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.a>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.myCollection.baseHistory.a> readCacheMessage) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null) {
                PbHistoryActivity.this.cbD = readCacheRespMsg.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.myCollection.baseHistory.a aVar : readCacheRespMsg.getData()) {
                    if (!StringUtils.isNull(aVar.getLiveId()) && Long.valueOf(aVar.getLiveId()).longValue() != 0) {
                        arrayList.add(Long.valueOf(aVar.getLiveId()));
                    }
                }
                if (PbHistoryActivity.this.lue) {
                    PbHistoryActivity.this.djF();
                    PbHistoryActivity.this.eX(PbHistoryActivity.this.cbD);
                    return;
                }
                PbHistoryActivity.this.a((List<Long>) arrayList, (Long) 0L);
                PbHistoryActivity.this.lue = true;
            }
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.a
        public void onCacheDataWrite(WriteCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.a>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.myCollection.baseHistory.a> writeCacheMessage) {
            if (writeCacheRespMsg != null && writeCacheRespMsg.isSuccess()) {
                if (writeCacheMessage.isClear()) {
                    PbHistoryActivity.this.eX(new ArrayList());
                } else {
                    PbHistoryActivity.this.refreshData();
                }
            }
        }
    };
    private final HttpMessageListener fwa = new HttpMessageListener(CmdConfigHttp.CMD_ALA_LIVE_ROOM_CLOSED) { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null) {
                if (httpResponsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                    PbHistoryActivity.this.closeLives = ((AlaMGetLiveStatusHttpResponseMessage) httpResponsedMessage).getCloseLives();
                }
                PbHistoryActivity.this.djF();
                PbHistoryActivity.this.eX(PbHistoryActivity.this.cbD);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.3
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                PbHistoryActivity.this.kNs.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                PbHistoryActivity.this.kNs.hide();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.model = new PbHistoryCacheModel(getPageContext());
        this.model.a(this.callback);
        registerListener(this.fwa);
        this.bNf = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.pb_history_activity, (ViewGroup) null);
        setContentView(this.bNf);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.my_history));
        this.kNs = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_pb_history);
        this.lud = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.clear_all_text));
        this.lud.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbHistoryActivity.this.getPageContext().getPageActivity());
                aVar.pa(R.string.pb_history_clear_tip);
                aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.4.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        PbHistoryActivity.this.model.clearCache();
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.4.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(PbHistoryActivity.this.getPageContext()).btX();
            }
        });
        this.lud.setVisibility(8);
        this.WV = (BdListView) findViewById(R.id.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(getActivity(), R.dimen.ds88)));
        this.WV.addHeaderView(textView, 0);
        this.kNc = new d<>(getPageContext(), a.class, R.layout.pb_history_list_item, null);
        this.kNc.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds190)), NoDataViewFactory.d.dY(null, getResources().getString(R.string.pb_history_no_data_tip_2)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.WV.setAdapter((ListAdapter) this.kNc);
        this.WV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.myCollection.baseHistory.a aVar = (com.baidu.tieba.myCollection.baseHistory.a) PbHistoryActivity.this.kNc.getItem(i);
                if (aVar != null) {
                    if (aVar.getThreadType() == 49) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(aVar.getLiveId(), 0L);
                        String str = "";
                        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            str = TbadkCoreApplication.getCurrentAccount();
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbHistoryActivity.this.getPageContext().getPageActivity(), alaLiveInfoCoreData, "scan_history", str, false, "")));
                    } else if (aVar.isManga()) {
                        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                bg.skipToLoginActivity(PbHistoryActivity.this.getActivity());
                                return;
                            } else {
                                PbHistoryActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(PbHistoryActivity.this.getPageContext().getPageActivity(), aVar.getCartoonId(), aVar.getChapterId(), 5)));
                                return;
                            }
                        }
                        l.showToast(PbHistoryActivity.this.getPageContext().getPageActivity(), R.string.manga_plugin_not_install_tip);
                    } else {
                        PbActivityConfig createHistoryCfg = new PbActivityConfig(PbHistoryActivity.this.getPageContext().getPageActivity()).createHistoryCfg(aVar.getThreadId(), aVar.bFk(), aVar.djD(), aVar.djE(), null);
                        createHistoryCfg.setStartFrom(11);
                        createHistoryCfg.setIsShareThread(aVar.isShareThread());
                        PbHistoryActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                    }
                }
            }
        });
        this.WV.setOnScrollListener(this.mOnScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        refreshData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djF() {
        if (!x.isEmpty(this.closeLives) && !x.isEmpty(this.cbD)) {
            for (com.baidu.tieba.myCollection.baseHistory.a aVar : this.cbD) {
                if (!StringUtils.isNull(aVar.getLiveId()) && Long.valueOf(aVar.getLiveId()).longValue() != 0) {
                    if (this.closeLives.contains(Long.valueOf(aVar.getLiveId()))) {
                        aVar.ue(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setNavbarTitleColor(this.lud, R.color.CAM_X0106, R.color.navi_op_text_skin);
        this.kNc.b(getPageContext(), i);
        getLayoutMode().onModeChanged(this.bNf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.model.bGS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(List<com.baidu.tieba.myCollection.baseHistory.a> list) {
        if (this.kNc != null) {
            this.kNc.bN(list);
        }
        if (list == null || list.size() == 0) {
            this.lud.setVisibility(8);
        } else {
            this.lud.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<Long> list, Long l) {
        AlaMGetLiveStatusRequestMessage alaMGetLiveStatusRequestMessage = new AlaMGetLiveStatusRequestMessage();
        alaMGetLiveStatusRequestMessage.setListIds(list);
        alaMGetLiveStatusRequestMessage.setAudienceCount(l.longValue());
        MessageManager.getInstance().sendMessage(alaMGetLiveStatusRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fwa);
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a082";
    }
}
