package com.baidu.tieba.setting.forbiddenforum;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.forbiddenforum.c;
import com.baidu.tieba.view.BdTopToast;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class ForbiddenForumActivity extends BaseActivity {
    private NoDataView fIt;
    private NavigationBar gjF;
    private PbListView kSi;
    private BdRecyclerView ndA;
    private c ndB;
    private i ndC;
    private k ndD;
    private com.baidu.tieba.setting.forbiddenforum.a ndE;
    private BdListView.e ndF = new BdListView.e() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ForbiddenForumActivity.this.ndB.getPageData().hasMore) {
                ForbiddenForumActivity.this.ndB.bEN();
                ForbiddenForumActivity.this.WX();
            }
        }
    };
    private RecyclerView.Adapter ndG = new RecyclerView.Adapter() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.4
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new a(LayoutInflater.from(ForbiddenForumActivity.this).inflate(R.layout.forbidden_forum_item_view, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            ((a) viewHolder).a(ForbiddenForumActivity.this.ndB.getPageData().dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ForbiddenForumActivity.this.ndB.getPageData().dataList.size();
        }
    };
    private c.a ndH = new c.a() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.5
        @Override // com.baidu.tieba.setting.forbiddenforum.c.a
        public void a(d dVar) {
            if (ForbiddenForumActivity.this.isLoadingViewAttached()) {
                ForbiddenForumActivity.this.hideLoadingView(ForbiddenForumActivity.this.rootView);
            }
            if (y.isEmpty(ForbiddenForumActivity.this.ndB.getPageData().dataList)) {
                ForbiddenForumActivity.this.showNoDataView();
                return;
            }
            ForbiddenForumActivity.this.ndG.notifyDataSetChanged();
            if (dVar != null && !dVar.hasMore) {
                ForbiddenForumActivity.this.djq();
            }
        }

        @Override // com.baidu.tieba.setting.forbiddenforum.c.a
        public void onError(int i, String str) {
            ForbiddenForumActivity.this.hideLoadingView(ForbiddenForumActivity.this.rootView);
            ForbiddenForumActivity.this.showNetRefreshView(ForbiddenForumActivity.this.rootView, str, true);
            ForbiddenForumActivity.this.ndA.setVisibility(8);
        }
    };
    private BdRecyclerView.a ndI = new BdRecyclerView.a() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.2
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            if (ForbiddenForumActivity.this.ndB != null) {
                if (ForbiddenForumActivity.this.ndB.getPageData() != null || !y.isEmpty(ForbiddenForumActivity.this.ndB.getPageData().dataList)) {
                    b bVar = ForbiddenForumActivity.this.ndB.getPageData().dataList.get(i);
                    ForbiddenForumActivity.this.gn(bVar.ndP, bVar.forumId);
                }
            }
        }
    };
    private HttpMessageListener ndJ = new HttpMessageListener(CmdConfigHttp.CMD_CANCEL_FORBIDDEN_FORUM) { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            if (httpResponsedMessage != null) {
                if (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage) {
                    HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                    if (httpMessage.getParams() != null) {
                        str = String.valueOf(httpMessage.getParams().get("forum_id"));
                        BdTopToast bdTopToast = new BdTopToast(ForbiddenForumActivity.this);
                        if (httpResponsedMessage.getError() != 0) {
                            bdTopToast.UN(ForbiddenForumActivity.this.getString(R.string.cancel_forbidden_sucessful));
                            bdTopToast.zn(true);
                            TiebaStatic.log(new ar("c14057").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", str));
                            ForbiddenForumActivity.this.ndB.Sj(str);
                            ForbiddenForumActivity.this.ndG.notifyDataSetChanged();
                        } else {
                            bdTopToast.UN(ForbiddenForumActivity.this.getString(R.string.cancel_forbidden_failed));
                            bdTopToast.zn(false);
                        }
                        bdTopToast.aR((ViewGroup) ForbiddenForumActivity.this.rootView);
                    }
                }
                str = "";
                BdTopToast bdTopToast2 = new BdTopToast(ForbiddenForumActivity.this);
                if (httpResponsedMessage.getError() != 0) {
                }
                bdTopToast2.aR((ViewGroup) ForbiddenForumActivity.this.rootView);
            }
        }
    };
    private View rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_forbidden_forum);
        this.rootView = findViewById(R.id.root_view);
        this.ndB = new c(getUniqueId());
        this.ndB.a(this.ndH);
        this.gjF = (NavigationBar) findViewById(R.id.navigation_bar);
        this.gjF.setCenterTextTitle(getString(R.string.privacy_forbidden_forum));
        this.gjF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gjF.isShowBottomLine(true);
        this.ndA = (BdRecyclerView) findViewById(R.id.recycler_view);
        this.ndA.setLayoutManager(new LinearLayoutManager(this));
        this.ndA.setAdapter(this.ndG);
        this.ndA.setOnSrollToBottomListener(this.ndF);
        this.ndA.setOnItemClickListener(this.ndI);
        this.ndB.bEN();
        showLoadingView(this.rootView);
        this.ndE = new com.baidu.tieba.setting.forbiddenforum.a();
        registerListener(this.ndJ);
        TiebaStatic.log(new ar("c14056").dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* loaded from: classes8.dex */
    class a extends RecyclerView.ViewHolder {
        private int ajU;
        private BarImageView ndM;
        private TextView ndN;

        public a(@NonNull View view) {
            super(view);
            this.ajU = 3;
            this.ndM = (BarImageView) view.findViewById(R.id.img_bar);
            this.ndM.setPlaceHolder(1);
            this.ndM.setShowOval(true);
            this.ndM.setAutoChangeStyle(true);
            this.ndM.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.ndM.setStrokeColorResId(R.color.CAM_X0401);
            this.ndM.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ndN = (TextView) view.findViewById(R.id.text_bar);
        }

        public void a(b bVar) {
            if (bVar != null) {
                this.ndM.startLoad(bVar.ndO, 10, false);
                this.ndN.setText(bVar.ndP + TbadkCoreApplication.getInst().getString(R.string.forum));
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private void onChangeSkinType(int i) {
            if (this.ajU != i) {
                ap.setBackgroundColor(this.itemView, R.color.CAM_X0205);
                ap.setViewTextColor(this.ndN, R.color.CAM_X0105);
                this.ajU = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0204);
        this.gjF.onChangeSkinType(getPageContext(), i);
        if (this.ndD != null) {
            this.ndD.onChangeSkinType();
        }
        if (this.ndG != null) {
            this.ndG.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.rootView);
        this.ndA.setVisibility(0);
        this.ndB.bEN();
        showLoadingView(this.rootView);
    }

    public void WX() {
        if (this.kSi == null) {
            this.kSi = new PbListView(this);
            this.kSi.createView();
            this.kSi.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.kSi.setLineGone();
            this.kSi.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.kSi.setTextSize(R.dimen.tbfontsize33);
            this.kSi.setNoMoreTextColorId(R.color.CAM_X0110);
            this.ndA.setNextPage(this.kSi);
        }
        this.kSi.setTopExtraViewGone();
        this.kSi.startLoadData();
        this.kSi.setText(this.ndA.getContext().getString(R.string.list_loading));
        this.kSi.showEmptyView(1);
    }

    public void djq() {
        if (this.kSi != null) {
            this.kSi.hideWithoutEmptyView(l.getDimens(this, R.dimen.tbds180));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gn(final String str, final String str2) {
        if (this.ndC == null) {
            if (this.ndD == null) {
                this.ndD = new k(this);
                this.ndD.a(new k.a() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.6
                    @Override // com.baidu.tbadk.core.dialog.k.a
                    public void onClick() {
                        ForbiddenForumActivity.this.dFV();
                    }
                });
            }
            ArrayList arrayList = new ArrayList();
            g gVar = new g(this.ndD);
            gVar.setText(getString(R.string.open_the_forum));
            gVar.a(new k.b() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.7
                @Override // com.baidu.tbadk.core.dialog.k.b
                public void onClick() {
                    ForbiddenForumActivity.this.dFV();
                    ForbiddenForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ForbiddenForumActivity.this.getActivity()).createNormalCfg(str, null)));
                    TiebaStatic.log(new ar("c14058").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", str2));
                }
            });
            arrayList.add(gVar);
            g gVar2 = new g(this.ndD);
            gVar2.setText(getString(R.string.cancel_forbidden));
            gVar2.a(new k.b() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.b
                public void onClick() {
                    ForbiddenForumActivity.this.dFV();
                    ForbiddenForumActivity.this.Si(str2);
                }
            });
            arrayList.add(gVar2);
            this.ndD.bw(arrayList);
            this.ndD.setTitleText(str + TbadkCoreApplication.getInst().getString(R.string.forum));
            this.ndC = new i(getPageContext(), this.ndD);
            this.ndC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.9
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    ForbiddenForumActivity.this.ndC = null;
                }
            });
            this.ndC.QE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFV() {
        if (this.ndC != null && this.ndC.isShowing()) {
            this.ndC.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Si(final String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.Au(getString(R.string.confirm_cancel_forbidden_forum));
        aVar.setOnlyMessageShowCenter(true);
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ForbiddenForumActivity.this.ndE.cancel(str);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.fIt == null) {
            this.fIt = NoDataViewFactory.a(this, this.rootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this, R.dimen.tbds308) + this.gjF.getBottom()), NoDataViewFactory.d.pz(R.string.no_forbidden_forum), null);
            NoDataViewFactory.c.a aVar = new NoDataViewFactory.c.a();
            aVar.b(NoDataViewFactory.ImgType.CREATE);
            this.fIt.setImgOption(aVar.bua());
        }
        if (this.fIt.getVisibility() != 0) {
            this.fIt.onChangeSkinType(getPageContext(), TbadkApplication.getInst().getSkinType());
            this.fIt.setVisibility(0);
        }
    }
}
