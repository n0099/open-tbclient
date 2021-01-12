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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    private BdListView WT;
    private int agC;
    private CoverFlowView<a> ajL;
    private NoNetworkView fJE;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private MemberRecommendView nwS;
    private TextView nwo;
    private DressupCenterActivity nzh;
    private b nzi;

    public c(DressupCenterActivity dressupCenterActivity) {
        this.agC = 0;
        this.nzh = dressupCenterActivity;
        this.agC = l.getDimens(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nzh.getPageContext().getPageActivity()).inflate(R.layout.dressup_center_activity_layout, (ViewGroup) null);
        this.nzh.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.nzh.getPageContext().getString(R.string.dressup_center_title));
        this.fJE = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.WT = (BdListView) this.mRoot.findViewById(R.id.dress_listview);
        this.ajL = (CoverFlowView) this.mRoot.findViewById(R.id.dressup_center_coverflowview);
        dPc();
        this.nwS = (MemberRecommendView) this.mRoot.findViewById(R.id.dressup_center_recommend);
        this.nwS.setFromType(1);
        this.nzi = new b(this.nzh.getPageContext());
        this.nwo = new TextView(this.nzh.getActivity());
        this.nwo.setHeight(l.getDimens(this.nzh.getActivity(), R.dimen.ds30));
        this.WT.setAdapter((ListAdapter) this.nzi);
        this.WT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.1
            /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d item = c.this.nzi.getItem(i);
                if (item != null) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putLong(SharedPrefConfig.DRESSUP_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + item.getType(), item.getUpdateTime());
                    c.this.nzi.notifyDataSetChanged();
                    if (!StringUtils.isNull(item.getType())) {
                        String type = item.getType();
                        CustomMessage customMessage = null;
                        switch (com.baidu.adp.lib.f.b.toInt(type, 0)) {
                            case 1:
                                TiebaStatic.log("c10263");
                                c.this.dPb();
                                break;
                            case 2:
                                TiebaStatic.log("c10264");
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(c.this.nzh.getActivity()));
                                break;
                            case 3:
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(c.this.nzh.getActivity()));
                                break;
                            case 4:
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardCategoryActivityConfig(c.this.nzh.getPageContext().getPageActivity()));
                                break;
                            case 5:
                                TiebaStatic.log("c11611");
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(c.this.nzh.getActivity()));
                                break;
                            default:
                                be.bsB().b(c.this.nzh.getPageContext(), new String[]{type});
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
    public void dPb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nzh.getPageContext().getPageActivity());
        aVar.nu(R.string.function_unavailable_tip);
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.nzh.getPageContext()).bqe();
    }

    public void a(List<a> list, e eVar, List<d> list2, boolean z) {
        if ((list == null || list.size() <= 0) && ((eVar == null || StringUtils.isNull(eVar.dPd())) && (list2 == null || list2.size() <= 0))) {
            czw();
            return;
        }
        czx();
        x(list2, fX(list) || b(eVar));
    }

    private boolean fX(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.ajL.setVisibility(8);
            return false;
        }
        this.ajL.setVisibility(0);
        this.ajL.setData(list);
        return true;
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dPd())) {
            this.nwS.setVisibility(8);
            return false;
        }
        this.nwS.setVisibility(0);
        this.nwS.a(eVar);
        return true;
    }

    private void x(List<d> list, boolean z) {
        if (list == null || list.size() <= 0) {
            this.WT.setVisibility(8);
            return;
        }
        if (z) {
            this.WT.removeHeaderView(this.nwo);
            this.WT.addHeaderView(this.nwo);
        } else {
            this.WT.removeHeaderView(this.nwo);
        }
        this.WT.setVisibility(0);
        this.nzi.setData(list);
        this.nzi.notifyDataSetChanged();
    }

    @SuppressLint({"ResourceAsColor"})
    public void byV() {
        this.nzh.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nzh.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nzh.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fJE != null) {
            this.fJE.onChangeSkinType(this.nzh.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.ajL != null && this.ajL.getVisibility() == 0) {
            this.ajL.onChangeSkinType();
        }
        if (this.WT != null && this.WT.getVisibility() == 0 && this.nzi != null) {
            this.nzi.notifyDataSetChanged();
        }
        if (this.nwS != null && this.nwS.getVisibility() == 0) {
            this.nwS.btV();
        }
        ao.setBackgroundColor(this.nwo, R.color.CAM_X0204);
    }

    public void czw() {
        this.WT.setVisibility(8);
        this.ajL.setVisibility(8);
        this.nwS.setVisibility(8);
        String string = this.nzh.getPageContext().getResources().getString(R.string.no_data_text);
        this.nzh.setNetRefreshViewTopMargin(this.agC);
        this.nzh.showNetRefreshView(this.mRoot, string, false);
    }

    public void czx() {
        this.nzh.hideNetRefreshView(this.mRoot);
        this.WT.setVisibility(0);
        this.nwS.setVisibility(0);
        this.ajL.setVisibility(0);
    }

    private void dPc() {
        if (this.ajL != null) {
            this.ajL.setCoverFlowFactory(new com.baidu.tbadk.core.flow.a() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.3
                @Override // com.baidu.tbadk.core.flow.a
                public com.baidu.tbadk.core.flow.a.c tx() {
                    com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                    cVar.ok(R.drawable.icon_diandian_white_n);
                    cVar.ol(R.drawable.icon_diandian_white_s);
                    cVar.setSpacing(R.dimen.ds1);
                    cVar.setGravity(85);
                    cVar.on(R.dimen.ds30);
                    cVar.om(R.dimen.ds20);
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
                public com.baidu.tbadk.core.flow.a.e tw() {
                    com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                    eVar.setHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds280));
                    return eVar;
                }

                @Override // com.baidu.tbadk.core.flow.a
                public View bqO() {
                    return null;
                }
            });
            this.ajL.setCallback(new com.baidu.tbadk.core.flow.a.d<a>() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.flow.a.d
                public void f(int i, String str) {
                    TiebaStatic.log("c10262");
                    be.bsB().b(c.this.nzh.getPageContext(), new String[]{str});
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
