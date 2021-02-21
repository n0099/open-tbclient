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
    private NavigationBar gjT;
    private PbListView kSw;
    private BdRecyclerView nea;
    private c neb;
    private i nec;
    private k ned;
    private com.baidu.tieba.setting.forbiddenforum.a nee;
    private BdListView.e nef = new BdListView.e() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ForbiddenForumActivity.this.neb.getPageData().hasMore) {
                ForbiddenForumActivity.this.neb.bEN();
                ForbiddenForumActivity.this.WX();
            }
        }
    };
    private RecyclerView.Adapter neg = new RecyclerView.Adapter() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.4
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new a(LayoutInflater.from(ForbiddenForumActivity.this).inflate(R.layout.forbidden_forum_item_view, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            ((a) viewHolder).a(ForbiddenForumActivity.this.neb.getPageData().dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ForbiddenForumActivity.this.neb.getPageData().dataList.size();
        }
    };
    private c.a neh = new c.a() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.5
        @Override // com.baidu.tieba.setting.forbiddenforum.c.a
        public void a(d dVar) {
            if (ForbiddenForumActivity.this.isLoadingViewAttached()) {
                ForbiddenForumActivity.this.hideLoadingView(ForbiddenForumActivity.this.rootView);
            }
            if (y.isEmpty(ForbiddenForumActivity.this.neb.getPageData().dataList)) {
                ForbiddenForumActivity.this.showNoDataView();
                return;
            }
            ForbiddenForumActivity.this.neg.notifyDataSetChanged();
            if (dVar != null && !dVar.hasMore) {
                ForbiddenForumActivity.this.djx();
            }
        }

        @Override // com.baidu.tieba.setting.forbiddenforum.c.a
        public void onError(int i, String str) {
            ForbiddenForumActivity.this.hideLoadingView(ForbiddenForumActivity.this.rootView);
            ForbiddenForumActivity.this.showNetRefreshView(ForbiddenForumActivity.this.rootView, str, true);
            ForbiddenForumActivity.this.nea.setVisibility(8);
        }
    };
    private BdRecyclerView.a nei = new BdRecyclerView.a() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.2
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            if (ForbiddenForumActivity.this.neb != null) {
                if (ForbiddenForumActivity.this.neb.getPageData() != null || !y.isEmpty(ForbiddenForumActivity.this.neb.getPageData().dataList)) {
                    b bVar = ForbiddenForumActivity.this.neb.getPageData().dataList.get(i);
                    ForbiddenForumActivity.this.gp(bVar.nep, bVar.forumId);
                }
            }
        }
    };
    private HttpMessageListener nej = new HttpMessageListener(CmdConfigHttp.CMD_CANCEL_FORBIDDEN_FORUM) { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.3
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
                            bdTopToast.UZ(ForbiddenForumActivity.this.getString(R.string.cancel_forbidden_sucessful));
                            bdTopToast.zn(true);
                            TiebaStatic.log(new ar("c14057").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", str));
                            ForbiddenForumActivity.this.neb.Sv(str);
                            ForbiddenForumActivity.this.neg.notifyDataSetChanged();
                        } else {
                            bdTopToast.UZ(ForbiddenForumActivity.this.getString(R.string.cancel_forbidden_failed));
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
        this.neb = new c(getUniqueId());
        this.neb.a(this.neh);
        this.gjT = (NavigationBar) findViewById(R.id.navigation_bar);
        this.gjT.setCenterTextTitle(getString(R.string.privacy_forbidden_forum));
        this.gjT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gjT.isShowBottomLine(true);
        this.nea = (BdRecyclerView) findViewById(R.id.recycler_view);
        this.nea.setLayoutManager(new LinearLayoutManager(this));
        this.nea.setAdapter(this.neg);
        this.nea.setOnSrollToBottomListener(this.nef);
        this.nea.setOnItemClickListener(this.nei);
        this.neb.bEN();
        showLoadingView(this.rootView);
        this.nee = new com.baidu.tieba.setting.forbiddenforum.a();
        registerListener(this.nej);
        TiebaStatic.log(new ar("c14056").dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* loaded from: classes8.dex */
    class a extends RecyclerView.ViewHolder {
        private int ajU;
        private BarImageView nem;
        private TextView nen;

        public a(@NonNull View view) {
            super(view);
            this.ajU = 3;
            this.nem = (BarImageView) view.findViewById(R.id.img_bar);
            this.nem.setPlaceHolder(1);
            this.nem.setShowOval(true);
            this.nem.setAutoChangeStyle(true);
            this.nem.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.nem.setStrokeColorResId(R.color.CAM_X0401);
            this.nem.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.nen = (TextView) view.findViewById(R.id.text_bar);
        }

        public void a(b bVar) {
            if (bVar != null) {
                this.nem.startLoad(bVar.neo, 10, false);
                this.nen.setText(bVar.nep + TbadkCoreApplication.getInst().getString(R.string.forum));
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private void onChangeSkinType(int i) {
            if (this.ajU != i) {
                ap.setBackgroundColor(this.itemView, R.color.CAM_X0205);
                ap.setViewTextColor(this.nen, R.color.CAM_X0105);
                this.ajU = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0204);
        this.gjT.onChangeSkinType(getPageContext(), i);
        if (this.ned != null) {
            this.ned.onChangeSkinType();
        }
        if (this.neg != null) {
            this.neg.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.rootView);
        this.nea.setVisibility(0);
        this.neb.bEN();
        showLoadingView(this.rootView);
    }

    public void WX() {
        if (this.kSw == null) {
            this.kSw = new PbListView(this);
            this.kSw.createView();
            this.kSw.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.kSw.setLineGone();
            this.kSw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.kSw.setTextSize(R.dimen.tbfontsize33);
            this.kSw.setNoMoreTextColorId(R.color.CAM_X0110);
            this.nea.setNextPage(this.kSw);
        }
        this.kSw.setTopExtraViewGone();
        this.kSw.startLoadData();
        this.kSw.setText(this.nea.getContext().getString(R.string.list_loading));
        this.kSw.showEmptyView(1);
    }

    public void djx() {
        if (this.kSw != null) {
            this.kSw.hideWithoutEmptyView(l.getDimens(this, R.dimen.tbds180));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gp(final String str, final String str2) {
        if (this.nec == null) {
            if (this.ned == null) {
                this.ned = new k(this);
                this.ned.a(new k.a() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.6
                    @Override // com.baidu.tbadk.core.dialog.k.a
                    public void onClick() {
                        ForbiddenForumActivity.this.dGd();
                    }
                });
            }
            ArrayList arrayList = new ArrayList();
            g gVar = new g(this.ned);
            gVar.setText(getString(R.string.open_the_forum));
            gVar.a(new k.b() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.7
                @Override // com.baidu.tbadk.core.dialog.k.b
                public void onClick() {
                    ForbiddenForumActivity.this.dGd();
                    ForbiddenForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ForbiddenForumActivity.this.getActivity()).createNormalCfg(str, null)));
                    TiebaStatic.log(new ar("c14058").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", str2));
                }
            });
            arrayList.add(gVar);
            g gVar2 = new g(this.ned);
            gVar2.setText(getString(R.string.cancel_forbidden));
            gVar2.a(new k.b() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.b
                public void onClick() {
                    ForbiddenForumActivity.this.dGd();
                    ForbiddenForumActivity.this.Su(str2);
                }
            });
            arrayList.add(gVar2);
            this.ned.bw(arrayList);
            this.ned.setTitleText(str + TbadkCoreApplication.getInst().getString(R.string.forum));
            this.nec = new i(getPageContext(), this.ned);
            this.nec.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.9
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    ForbiddenForumActivity.this.nec = null;
                }
            });
            this.nec.QE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGd() {
        if (this.nec != null && this.nec.isShowing()) {
            this.nec.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Su(final String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.Au(getString(R.string.confirm_cancel_forbidden_forum));
        aVar.setOnlyMessageShowCenter(true);
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ForbiddenForumActivity.this.nee.cancel(str);
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
            this.fIt = NoDataViewFactory.a(this, this.rootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this, R.dimen.tbds308) + this.gjT.getBottom()), NoDataViewFactory.d.pz(R.string.no_forbidden_forum), null);
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
