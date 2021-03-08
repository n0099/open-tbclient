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
/* loaded from: classes8.dex */
public class c {
    private BdListView Yj;
    private CoverFlowView<a> akS;
    private NoNetworkView fNp;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nIF;
    private MemberRecommendView nJj;
    private DressupCenterActivity nLy;
    private b nLz;
    private int topMargin;

    public c(DressupCenterActivity dressupCenterActivity) {
        this.topMargin = 0;
        this.nLy = dressupCenterActivity;
        this.topMargin = l.getDimens(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nLy.getPageContext().getPageActivity()).inflate(R.layout.dressup_center_activity_layout, (ViewGroup) null);
        this.nLy.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.nLy.getPageContext().getString(R.string.dressup_center_title));
        this.fNp = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.Yj = (BdListView) this.mRoot.findViewById(R.id.dress_listview);
        this.akS = (CoverFlowView) this.mRoot.findViewById(R.id.dressup_center_coverflowview);
        dRE();
        this.nJj = (MemberRecommendView) this.mRoot.findViewById(R.id.dressup_center_recommend);
        this.nJj.setFromType(1);
        this.nLz = new b(this.nLy.getPageContext());
        this.nIF = new TextView(this.nLy.getActivity());
        this.nIF.setHeight(l.getDimens(this.nLy.getActivity(), R.dimen.ds30));
        this.Yj.setAdapter((ListAdapter) this.nLz);
        this.Yj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.1
            /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d item = c.this.nLz.getItem(i);
                if (item != null) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putLong(SharedPrefConfig.DRESSUP_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + item.getType(), item.getUpdateTime());
                    c.this.nLz.notifyDataSetChanged();
                    if (!StringUtils.isNull(item.getType())) {
                        String type = item.getType();
                        CustomMessage customMessage = null;
                        switch (com.baidu.adp.lib.f.b.toInt(type, 0)) {
                            case 1:
                                TiebaStatic.log("c10263");
                                c.this.dRD();
                                break;
                            case 2:
                                TiebaStatic.log("c10264");
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(c.this.nLy.getActivity()));
                                break;
                            case 3:
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(c.this.nLy.getActivity()));
                                break;
                            case 4:
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardCategoryActivityConfig(c.this.nLy.getPageContext().getPageActivity()));
                                break;
                            case 5:
                                TiebaStatic.log("c11611");
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(c.this.nLy.getActivity()));
                                break;
                            default:
                                bf.bsY().b(c.this.nLy.getPageContext(), new String[]{type});
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
    public void dRD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nLy.getPageContext().getPageActivity());
        aVar.ny(R.string.function_unavailable_tip);
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.nLy.getPageContext()).bqz();
    }

    public void a(List<a> list, e eVar, List<d> list2, boolean z) {
        if ((list == null || list.size() <= 0) && ((eVar == null || StringUtils.isNull(eVar.dRF())) && (list2 == null || list2.size() <= 0))) {
            cAU();
            return;
        }
        cAV();
        z(list2, fV(list) || b(eVar));
    }

    private boolean fV(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.akS.setVisibility(8);
            return false;
        }
        this.akS.setVisibility(0);
        this.akS.setData(list);
        return true;
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRF())) {
            this.nJj.setVisibility(8);
            return false;
        }
        this.nJj.setVisibility(0);
        this.nJj.a(eVar);
        return true;
    }

    private void z(List<d> list, boolean z) {
        if (list == null || list.size() <= 0) {
            this.Yj.setVisibility(8);
            return;
        }
        if (z) {
            this.Yj.removeHeaderView(this.nIF);
            this.Yj.addHeaderView(this.nIF);
        } else {
            this.Yj.removeHeaderView(this.nIF);
        }
        this.Yj.setVisibility(0);
        this.nLz.setData(list);
        this.nLz.notifyDataSetChanged();
    }

    @SuppressLint({"ResourceAsColor"})
    public void bzq() {
        this.nLy.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nLy.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nLy.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fNp != null) {
            this.fNp.onChangeSkinType(this.nLy.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.akS != null && this.akS.getVisibility() == 0) {
            this.akS.onChangeSkinType();
        }
        if (this.Yj != null && this.Yj.getVisibility() == 0 && this.nLz != null) {
            this.nLz.notifyDataSetChanged();
        }
        if (this.nJj != null && this.nJj.getVisibility() == 0) {
            this.nJj.bus();
        }
        ap.setBackgroundColor(this.nIF, R.color.CAM_X0204);
    }

    public void cAU() {
        this.Yj.setVisibility(8);
        this.akS.setVisibility(8);
        this.nJj.setVisibility(8);
        String string = this.nLy.getPageContext().getResources().getString(R.string.no_data_text);
        this.nLy.setNetRefreshViewTopMargin(this.topMargin);
        this.nLy.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAV() {
        this.nLy.hideNetRefreshView(this.mRoot);
        this.Yj.setVisibility(0);
        this.nJj.setVisibility(0);
        this.akS.setVisibility(0);
    }

    private void dRE() {
        if (this.akS != null) {
            this.akS.setCoverFlowFactory(new com.baidu.tbadk.core.flow.a() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.3
                @Override // com.baidu.tbadk.core.flow.a
                public com.baidu.tbadk.core.flow.a.c tu() {
                    com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                    cVar.oq(R.drawable.icon_diandian_white_n);
                    cVar.or(R.drawable.icon_diandian_white_s);
                    cVar.setSpacing(R.dimen.ds1);
                    cVar.setGravity(85);
                    cVar.ot(R.dimen.ds30);
                    cVar.os(R.dimen.ds20);
                    return cVar;
                }

                @Override // com.baidu.tbadk.core.flow.a
                public TbImageView U(Context context) {
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
                public View bri() {
                    return null;
                }
            });
            this.akS.setCallback(new com.baidu.tbadk.core.flow.a.d<a>() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.flow.a.d
                public void f(int i, String str) {
                    TiebaStatic.log("c10262");
                    bf.bsY().b(c.this.nLy.getPageContext(), new String[]{str});
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
