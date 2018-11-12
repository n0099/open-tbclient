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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.f.d;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.e;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    private BdListView OF;
    private final CacheModel.a<com.baidu.tieba.myCollection.baseHistory.a> baP = new CacheModel.a<com.baidu.tieba.myCollection.baseHistory.a>() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.1
        @Override // com.baidu.tbadk.mvc.model.CacheModel.a
        public void a(ReadCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.a>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.myCollection.baseHistory.a> readCacheMessage) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null) {
                PbHistoryActivity.this.cZ(readCacheRespMsg.getData());
            }
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.a
        public void a(WriteCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.a>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.myCollection.baseHistory.a> writeCacheMessage) {
            if (writeCacheRespMsg != null && writeCacheRespMsg.isSuccess()) {
                if (writeCacheMessage.isClear()) {
                    PbHistoryActivity.this.cZ(new ArrayList());
                } else {
                    PbHistoryActivity.this.refreshData();
                }
            }
        }
    };
    private RelativeLayout dhJ;
    private d<com.baidu.tieba.myCollection.baseHistory.a, com.baidu.tbadk.mvc.d.b, b> eWW;
    private TextView fBa;
    private PbHistoryCacheModel fBb;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fBb = new PbHistoryCacheModel(getPageContext());
        this.fBb.a(this.baP);
        this.dhJ = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.pb_history_activity, (ViewGroup) null);
        setContentView(this.dhJ);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.my_history));
        this.mNavigationBar.showBottomLine();
        this.fBa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.clear_all_text));
        this.fBa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbHistoryActivity.this.getPageContext().getPageActivity());
                aVar.cN(e.j.pb_history_clear_tip);
                aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.2.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        PbHistoryActivity.this.fBb.clearCache();
                        aVar2.dismiss();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.2.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(PbHistoryActivity.this.getPageContext()).AB();
            }
        });
        this.fBa.setVisibility(8);
        this.OF = (BdListView) findViewById(e.g.list);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(getActivity(), e.C0200e.ds88)));
        this.OF.addHeaderView(textView, 0);
        this.eWW = new d<>(getPageContext(), b.class, e.h.pb_history_list_item, null);
        this.eWW.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0200e.ds190)), NoDataViewFactory.d.G(e.j.pb_history_no_data_tip, e.j.pb_history_no_data_tip_2), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.OF.setAdapter((ListAdapter) this.eWW);
        this.OF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.myCollection.history.PbHistoryActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.myCollection.baseHistory.a aVar = (com.baidu.tieba.myCollection.baseHistory.a) PbHistoryActivity.this.eWW.getItem(i);
                if (aVar != null) {
                    if (aVar.getThreadType() == 49) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = com.baidu.adp.lib.g.b.d(aVar.getLiveId(), 0L);
                        String str = "";
                        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                            str = TbadkCoreApplication.getCurrentAccount();
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbHistoryActivity.this.getPageContext().getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SCAN_HISTORY, str, false, "")));
                    } else if (aVar.isManga()) {
                        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MangaBrowserActivityConfig.class)) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ba.bF(PbHistoryActivity.this.getActivity());
                                return;
                            } else {
                                PbHistoryActivity.this.sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(PbHistoryActivity.this.getPageContext().getPageActivity(), aVar.getCartoonId(), aVar.getChapterId(), 5)));
                                return;
                            }
                        }
                        l.showToast(PbHistoryActivity.this.getPageContext().getPageActivity(), e.j.manga_plugin_not_install_tip);
                    } else {
                        PbActivityConfig createHistoryCfg = new PbActivityConfig(PbHistoryActivity.this.getPageContext().getPageActivity()).createHistoryCfg(aVar.getThreadId(), aVar.Lo(), aVar.bbX(), aVar.bbY(), null);
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
        al.b(this.fBa, e.d.cp_cont_f, e.d.navi_op_text_skin);
        this.eWW.b(getPageContext(), i);
        getLayoutMode().onModeChanged(this.dhJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.fBb.Nd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZ(List<com.baidu.tieba.myCollection.baseHistory.a> list) {
        if (this.eWW != null) {
            this.eWW.R(list);
        }
        if (list == null || list.size() == 0) {
            this.fBa.setVisibility(8);
        } else {
            this.fBa.setVisibility(0);
        }
    }
}
