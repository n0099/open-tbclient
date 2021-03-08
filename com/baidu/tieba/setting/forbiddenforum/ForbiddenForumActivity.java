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
/* loaded from: classes7.dex */
public class ForbiddenForumActivity extends BaseActivity {
    private NoDataView fJS;
    private NavigationBar glw;
    private PbListView kUy;
    private BdRecyclerView ngf;
    private c ngg;
    private i ngh;
    private k ngi;
    private com.baidu.tieba.setting.forbiddenforum.a ngj;
    private BdListView.e ngk = new BdListView.e() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ForbiddenForumActivity.this.ngg.getPageData().hasMore) {
                ForbiddenForumActivity.this.ngg.bER();
                ForbiddenForumActivity.this.Xa();
            }
        }
    };
    private RecyclerView.Adapter ngl = new RecyclerView.Adapter() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.4
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new a(LayoutInflater.from(ForbiddenForumActivity.this).inflate(R.layout.forbidden_forum_item_view, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            ((a) viewHolder).a(ForbiddenForumActivity.this.ngg.getPageData().dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ForbiddenForumActivity.this.ngg.getPageData().dataList.size();
        }
    };
    private c.a ngm = new c.a() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.5
        @Override // com.baidu.tieba.setting.forbiddenforum.c.a
        public void a(d dVar) {
            if (ForbiddenForumActivity.this.isLoadingViewAttached()) {
                ForbiddenForumActivity.this.hideLoadingView(ForbiddenForumActivity.this.rootView);
            }
            if (y.isEmpty(ForbiddenForumActivity.this.ngg.getPageData().dataList)) {
                ForbiddenForumActivity.this.showNoDataView();
                return;
            }
            ForbiddenForumActivity.this.ngl.notifyDataSetChanged();
            if (dVar != null && !dVar.hasMore) {
                ForbiddenForumActivity.this.djG();
            }
        }

        @Override // com.baidu.tieba.setting.forbiddenforum.c.a
        public void onError(int i, String str) {
            ForbiddenForumActivity.this.hideLoadingView(ForbiddenForumActivity.this.rootView);
            ForbiddenForumActivity.this.showNetRefreshView(ForbiddenForumActivity.this.rootView, str, true);
            ForbiddenForumActivity.this.ngf.setVisibility(8);
        }
    };
    private BdRecyclerView.a ngn = new BdRecyclerView.a() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.2
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            if (ForbiddenForumActivity.this.ngg != null) {
                if (ForbiddenForumActivity.this.ngg.getPageData() != null || !y.isEmpty(ForbiddenForumActivity.this.ngg.getPageData().dataList)) {
                    b bVar = ForbiddenForumActivity.this.ngg.getPageData().dataList.get(i);
                    ForbiddenForumActivity.this.gp(bVar.ngu, bVar.forumId);
                }
            }
        }
    };
    private HttpMessageListener ngo = new HttpMessageListener(CmdConfigHttp.CMD_CANCEL_FORBIDDEN_FORUM) { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.3
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
                            bdTopToast.Vg(ForbiddenForumActivity.this.getString(R.string.cancel_forbidden_sucessful));
                            bdTopToast.zm(true);
                            TiebaStatic.log(new ar("c14057").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", str));
                            ForbiddenForumActivity.this.ngg.SB(str);
                            ForbiddenForumActivity.this.ngl.notifyDataSetChanged();
                        } else {
                            bdTopToast.Vg(ForbiddenForumActivity.this.getString(R.string.cancel_forbidden_failed));
                            bdTopToast.zm(false);
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
        this.ngg = new c(getUniqueId());
        this.ngg.a(this.ngm);
        this.glw = (NavigationBar) findViewById(R.id.navigation_bar);
        this.glw.setCenterTextTitle(getString(R.string.privacy_forbidden_forum));
        this.glw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.glw.isShowBottomLine(true);
        this.ngf = (BdRecyclerView) findViewById(R.id.recycler_view);
        this.ngf.setLayoutManager(new LinearLayoutManager(this));
        this.ngf.setAdapter(this.ngl);
        this.ngf.setOnSrollToBottomListener(this.ngk);
        this.ngf.setOnItemClickListener(this.ngn);
        this.ngg.bER();
        showLoadingView(this.rootView);
        this.ngj = new com.baidu.tieba.setting.forbiddenforum.a();
        registerListener(this.ngo);
        TiebaStatic.log(new ar("c14056").dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* loaded from: classes7.dex */
    class a extends RecyclerView.ViewHolder {
        private int aln;
        private BarImageView ngr;
        private TextView ngs;

        public a(@NonNull View view) {
            super(view);
            this.aln = 3;
            this.ngr = (BarImageView) view.findViewById(R.id.img_bar);
            this.ngr.setPlaceHolder(1);
            this.ngr.setShowOval(true);
            this.ngr.setAutoChangeStyle(true);
            this.ngr.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.ngr.setStrokeColorResId(R.color.CAM_X0401);
            this.ngr.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ngs = (TextView) view.findViewById(R.id.text_bar);
        }

        public void a(b bVar) {
            if (bVar != null) {
                this.ngr.startLoad(bVar.ngt, 10, false);
                this.ngs.setText(bVar.ngu + TbadkCoreApplication.getInst().getString(R.string.forum));
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private void onChangeSkinType(int i) {
            if (this.aln != i) {
                ap.setBackgroundColor(this.itemView, R.color.CAM_X0205);
                ap.setViewTextColor(this.ngs, R.color.CAM_X0105);
                this.aln = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0204);
        this.glw.onChangeSkinType(getPageContext(), i);
        if (this.ngi != null) {
            this.ngi.onChangeSkinType();
        }
        if (this.ngl != null) {
            this.ngl.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.rootView);
        this.ngf.setVisibility(0);
        this.ngg.bER();
        showLoadingView(this.rootView);
    }

    public void Xa() {
        if (this.kUy == null) {
            this.kUy = new PbListView(this);
            this.kUy.createView();
            this.kUy.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.kUy.setLineGone();
            this.kUy.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.kUy.setTextSize(R.dimen.tbfontsize33);
            this.kUy.setNoMoreTextColorId(R.color.CAM_X0110);
            this.ngf.setNextPage(this.kUy);
        }
        this.kUy.setTopExtraViewGone();
        this.kUy.startLoadData();
        this.kUy.setText(this.ngf.getContext().getString(R.string.list_loading));
        this.kUy.showEmptyView(1);
    }

    public void djG() {
        if (this.kUy != null) {
            this.kUy.hideWithoutEmptyView(l.getDimens(this, R.dimen.tbds180));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gp(final String str, final String str2) {
        if (this.ngh == null) {
            if (this.ngi == null) {
                this.ngi = new k(this);
                this.ngi.a(new k.a() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.6
                    @Override // com.baidu.tbadk.core.dialog.k.a
                    public void onClick() {
                        ForbiddenForumActivity.this.dGl();
                    }
                });
            }
            ArrayList arrayList = new ArrayList();
            g gVar = new g(this.ngi);
            gVar.setText(getString(R.string.open_the_forum));
            gVar.a(new k.b() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.7
                @Override // com.baidu.tbadk.core.dialog.k.b
                public void onClick() {
                    ForbiddenForumActivity.this.dGl();
                    ForbiddenForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ForbiddenForumActivity.this.getActivity()).createNormalCfg(str, null)));
                    TiebaStatic.log(new ar("c14058").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", str2));
                }
            });
            arrayList.add(gVar);
            g gVar2 = new g(this.ngi);
            gVar2.setText(getString(R.string.cancel_forbidden));
            gVar2.a(new k.b() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.b
                public void onClick() {
                    ForbiddenForumActivity.this.dGl();
                    ForbiddenForumActivity.this.SA(str2);
                }
            });
            arrayList.add(gVar2);
            this.ngi.bw(arrayList);
            this.ngi.setTitleText(str + TbadkCoreApplication.getInst().getString(R.string.forum));
            this.ngh = new i(getPageContext(), this.ngi);
            this.ngh.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.9
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    ForbiddenForumActivity.this.ngh = null;
                }
            });
            this.ngh.QH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGl() {
        if (this.ngh != null && this.ngh.isShowing()) {
            this.ngh.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SA(final String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.AB(getString(R.string.confirm_cancel_forbidden_forum));
        aVar.setOnlyMessageShowCenter(true);
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ForbiddenForumActivity.this.ngj.cancel(str);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.forbiddenforum.ForbiddenForumActivity.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).bqz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.fJS == null) {
            this.fJS = NoDataViewFactory.a(this, this.rootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this, R.dimen.tbds308) + this.glw.getBottom()), NoDataViewFactory.d.pA(R.string.no_forbidden_forum), null);
            NoDataViewFactory.c.a aVar = new NoDataViewFactory.c.a();
            aVar.b(NoDataViewFactory.ImgType.CREATE);
            this.fJS.setImgOption(aVar.bud());
        }
        if (this.fJS.getVisibility() != 0) {
            this.fJS.onChangeSkinType(getPageContext(), TbadkApplication.getInst().getSkinType());
            this.fJS.setVisibility(0);
        }
    }
}
