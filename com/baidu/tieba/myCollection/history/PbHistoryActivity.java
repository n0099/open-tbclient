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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.f.d;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.d;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    private BdListView LO;
    private final CacheModel.a<com.baidu.tieba.myCollection.baseHistory.a> aSn = new CacheModel.a<com.baidu.tieba.myCollection.baseHistory.a>() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.1
        @Override // com.baidu.tbadk.mvc.model.CacheModel.a
        public void a(ReadCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.a>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.myCollection.baseHistory.a> readCacheMessage) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null) {
                PbHistoryActivity.this.cL(readCacheRespMsg.getData());
            }
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.a
        public void a(WriteCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.a>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.myCollection.baseHistory.a> writeCacheMessage) {
            if (writeCacheRespMsg != null && writeCacheRespMsg.isSuccess()) {
                if (writeCacheMessage.isClear()) {
                    PbHistoryActivity.this.cL(new ArrayList());
                } else {
                    PbHistoryActivity.this.refreshData();
                }
            }
        }
    };
    private RelativeLayout cSA;
    private d<com.baidu.tieba.myCollection.baseHistory.a, com.baidu.tbadk.mvc.d.b, b> eGK;
    private TextView fkH;
    private PbHistoryCacheModel fkI;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fkI = new PbHistoryCacheModel(getPageContext());
        this.fkI.a(this.aSn);
        this.cSA = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.pb_history_activity, (ViewGroup) null);
        setContentView(this.cSA);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.my_history));
        this.mNavigationBar.showBottomLine();
        this.fkH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.clear_all_text));
        this.fkH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbHistoryActivity.this.getPageContext().getPageActivity());
                aVar.cf(d.j.pb_history_clear_tip);
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        PbHistoryActivity.this.fkI.clearCache();
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.2.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(PbHistoryActivity.this.getPageContext()).xf();
            }
        });
        this.fkH.setVisibility(8);
        this.LO = (BdListView) findViewById(d.g.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(getActivity(), d.e.ds88)));
        this.LO.addHeaderView(textView, 0);
        this.eGK = new com.baidu.tbadk.mvc.f.d<>(getPageContext(), b.class, d.h.pb_history_list_item, null);
        this.eGK.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds190)), NoDataViewFactory.d.E(d.j.pb_history_no_data_tip, d.j.pb_history_no_data_tip_2), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.LO.setAdapter((ListAdapter) this.eGK);
        this.LO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.myCollection.baseHistory.a aVar = (com.baidu.tieba.myCollection.baseHistory.a) PbHistoryActivity.this.eGK.getItem(i);
                if (aVar != null) {
                    if (aVar.getThreadType() == 49) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = com.baidu.adp.lib.g.b.c(aVar.getLiveId(), 0L);
                        String str = "";
                        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            str = TbadkCoreApplication.getCurrentAccount();
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbHistoryActivity.this.getPageContext().getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SCAN_HISTORY, str, false, "")));
                    } else if (aVar.isManga()) {
                        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ba.aU(PbHistoryActivity.this.getActivity());
                                return;
                            } else {
                                PbHistoryActivity.this.sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(PbHistoryActivity.this.getPageContext().getPageActivity(), aVar.getCartoonId(), aVar.getChapterId(), 5)));
                                return;
                            }
                        }
                        l.showToast(PbHistoryActivity.this.getPageContext().getPageActivity(), d.j.manga_plugin_not_install_tip);
                    } else {
                        PbActivityConfig createHistoryCfg = new PbActivityConfig(PbHistoryActivity.this.getPageContext().getPageActivity()).createHistoryCfg(aVar.getThreadId(), aVar.HO(), aVar.aXd(), aVar.aXe(), null);
                        createHistoryCfg.setStartFrom(11);
                        createHistoryCfg.setIsShareThread(aVar.isShareThread());
                        PbHistoryActivity.this.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        refreshData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.b(this.fkH, d.C0140d.cp_cont_f, d.C0140d.navi_op_text_skin);
        this.eGK.b(getPageContext(), i);
        getLayoutMode().onModeChanged(this.cSA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.fkI.JC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(List<com.baidu.tieba.myCollection.baseHistory.a> list) {
        if (this.eGK != null) {
            this.eGK.I(list);
        }
        if (list == null || list.size() == 0) {
            this.fkH.setVisibility(8);
        } else {
            this.fkH.setVisibility(0);
        }
    }
}
