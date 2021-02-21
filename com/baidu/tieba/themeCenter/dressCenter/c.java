package com.baidu.tieba.themeCenter.dressCenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardCategoryActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdListView WO;
    private CoverFlowView<a> ajA;
    private NoNetworkView fLP;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nGz;
    private MemberRecommendView nHd;
    private DressupCenterActivity nJs;
    private b nJt;
    private int topMargin;

    public c(DressupCenterActivity dressupCenterActivity) {
        this.topMargin = 0;
        this.nJs = dressupCenterActivity;
        this.topMargin = l.getDimens(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nJs.getPageContext().getPageActivity()).inflate(R.layout.dressup_center_activity_layout, (ViewGroup) null);
        this.nJs.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.nJs.getPageContext().getString(R.string.dressup_center_title));
        this.fLP = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.WO = (BdListView) this.mRoot.findViewById(R.id.dress_listview);
        this.ajA = (CoverFlowView) this.mRoot.findViewById(R.id.dressup_center_coverflowview);
        dRv();
        this.nHd = (MemberRecommendView) this.mRoot.findViewById(R.id.dressup_center_recommend);
        this.nHd.setFromType(1);
        this.nJt = new b(this.nJs.getPageContext());
        this.nGz = new TextView(this.nJs.getActivity());
        this.nGz.setHeight(l.getDimens(this.nJs.getActivity(), R.dimen.ds30));
        this.WO.setAdapter((ListAdapter) this.nJt);
        this.WO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.1
            /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d item = c.this.nJt.getItem(i);
                if (item != null) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.DRESSUP_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + item.getType(), item.getUpdateTime());
                    c.this.nJt.notifyDataSetChanged();
                    if (!StringUtils.isNull(item.getType())) {
                        String type = item.getType();
                        CustomMessage customMessage = null;
                        switch (com.baidu.adp.lib.f.b.toInt(type, 0)) {
                            case 1:
                                TiebaStatic.log("c10263");
                                c.this.dRu();
                                break;
                            case 2:
                                TiebaStatic.log("c10264");
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(c.this.nJs.getActivity()));
                                break;
                            case 3:
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(c.this.nJs.getActivity()));
                                break;
                            case 4:
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardCategoryActivityConfig(c.this.nJs.getPageContext().getPageActivity()));
                                break;
                            case 5:
                                TiebaStatic.log("c11611");
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(c.this.nJs.getActivity()));
                                break;
                            default:
                                bf.bsV().b(c.this.nJs.getPageContext(), new String[]{type});
                                break;
                        }
                        if (customMessage != null) {
                            MessageManager.getInstance().sendMessage(customMessage);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nJs.getPageContext().getPageActivity());
        aVar.nx(R.string.function_unavailable_tip);
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.nJs.getPageContext()).bqx();
    }

    public void a(List<a> list, e eVar, List<d> list2, boolean z) {
        if ((list == null || list.size() <= 0) && ((eVar == null || StringUtils.isNull(eVar.dRw())) && (list2 == null || list2.size() <= 0))) {
            cAO();
            return;
        }
        cAP();
        z(list2, fV(list) || b(eVar));
    }

    private boolean fV(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.ajA.setVisibility(8);
            return false;
        }
        this.ajA.setVisibility(0);
        this.ajA.setData(list);
        return true;
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRw())) {
            this.nHd.setVisibility(8);
            return false;
        }
        this.nHd.setVisibility(0);
        this.nHd.a(eVar);
        return true;
    }

    private void z(List<d> list, boolean z) {
        if (list == null || list.size() <= 0) {
            this.WO.setVisibility(8);
            return;
        }
        if (z) {
            this.WO.removeHeaderView(this.nGz);
            this.WO.addHeaderView(this.nGz);
        } else {
            this.WO.removeHeaderView(this.nGz);
        }
        this.WO.setVisibility(0);
        this.nJt.setData(list);
        this.nJt.notifyDataSetChanged();
    }

    @SuppressLint({"ResourceAsColor"})
    public void bzn() {
        this.nJs.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nJs.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nJs.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fLP != null) {
            this.fLP.onChangeSkinType(this.nJs.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.ajA != null && this.ajA.getVisibility() == 0) {
            this.ajA.onChangeSkinType();
        }
        if (this.WO != null && this.WO.getVisibility() == 0 && this.nJt != null) {
            this.nJt.notifyDataSetChanged();
        }
        if (this.nHd != null && this.nHd.getVisibility() == 0) {
            this.nHd.bup();
        }
        ap.setBackgroundColor(this.nGz, R.color.CAM_X0204);
    }

    public void cAO() {
        this.WO.setVisibility(8);
        this.ajA.setVisibility(8);
        this.nHd.setVisibility(8);
        String string = this.nJs.getPageContext().getResources().getString(R.string.no_data_text);
        this.nJs.setNetRefreshViewTopMargin(this.topMargin);
        this.nJs.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAP() {
        this.nJs.hideNetRefreshView(this.mRoot);
        this.WO.setVisibility(0);
        this.nHd.setVisibility(0);
        this.ajA.setVisibility(0);
    }

    private void dRv() {
        if (this.ajA != null) {
            this.ajA.setCoverFlowFactory(new com.baidu.tbadk.core.flow.a() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.3
                @Override // com.baidu.tbadk.core.flow.a
                public com.baidu.tbadk.core.flow.a.c tu() {
                    com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                    cVar.op(R.drawable.icon_diandian_white_n);
                    cVar.oq(R.drawable.icon_diandian_white_s);
                    cVar.setSpacing(R.dimen.ds1);
                    cVar.setGravity(85);
                    cVar.os(R.dimen.ds30);
                    cVar.or(R.dimen.ds20);
                    return cVar;
                }

                @Override // com.baidu.tbadk.core.flow.a
                public TbImageView V(Context context) {
                    TbImageView tbImageView = new TbImageView(context);
                    tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    tbImageView.setGifIconSupport(false);
                    return tbImageView;
                }

                @Override // com.baidu.tbadk.core.flow.a
                public com.baidu.tbadk.core.flow.a.e tt() {
                    com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                    eVar.setHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds280));
                    return eVar;
                }

                @Override // com.baidu.tbadk.core.flow.a
                public View brh() {
                    return null;
                }
            });
            this.ajA.setCallback(new com.baidu.tbadk.core.flow.a.d<a>() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.flow.a.d
                public void f(int i, String str) {
                    TiebaStatic.log("c10262");
                    bf.bsV().b(c.this.nJs.getPageContext(), new String[]{str});
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.core.flow.a.d
                public void a(int i, a aVar) {
                }
            });
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
