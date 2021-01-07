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
/* loaded from: classes9.dex */
public class c {
    private BdListView WV;
    private int aht;
    private CoverFlowView<a> akC;
    private NoNetworkView fOl;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nAT;
    private MemberRecommendView nBx;
    private DressupCenterActivity nDM;
    private b nDN;

    public c(DressupCenterActivity dressupCenterActivity) {
        this.aht = 0;
        this.nDM = dressupCenterActivity;
        this.aht = l.getDimens(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nDM.getPageContext().getPageActivity()).inflate(R.layout.dressup_center_activity_layout, (ViewGroup) null);
        this.nDM.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.nDM.getPageContext().getString(R.string.dressup_center_title));
        this.fOl = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.WV = (BdListView) this.mRoot.findViewById(R.id.dress_listview);
        this.akC = (CoverFlowView) this.mRoot.findViewById(R.id.dressup_center_coverflowview);
        dSU();
        this.nBx = (MemberRecommendView) this.mRoot.findViewById(R.id.dressup_center_recommend);
        this.nBx.setFromType(1);
        this.nDN = new b(this.nDM.getPageContext());
        this.nAT = new TextView(this.nDM.getActivity());
        this.nAT.setHeight(l.getDimens(this.nDM.getActivity(), R.dimen.ds30));
        this.WV.setAdapter((ListAdapter) this.nDN);
        this.WV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.1
            /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d item = c.this.nDN.getItem(i);
                if (item != null) {
                    com.baidu.tbadk.core.sharedPref.b.bvr().putLong(SharedPrefConfig.DRESSUP_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + item.getType(), item.getUpdateTime());
                    c.this.nDN.notifyDataSetChanged();
                    if (!StringUtils.isNull(item.getType())) {
                        String type = item.getType();
                        CustomMessage customMessage = null;
                        switch (com.baidu.adp.lib.f.b.toInt(type, 0)) {
                            case 1:
                                TiebaStatic.log("c10263");
                                c.this.dST();
                                break;
                            case 2:
                                TiebaStatic.log("c10264");
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(c.this.nDM.getActivity()));
                                break;
                            case 3:
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(c.this.nDM.getActivity()));
                                break;
                            case 4:
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardCategoryActivityConfig(c.this.nDM.getPageContext().getPageActivity()));
                                break;
                            case 5:
                                TiebaStatic.log("c11611");
                                customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(c.this.nDM.getActivity()));
                                break;
                            default:
                                be.bwv().b(c.this.nDM.getPageContext(), new String[]{type});
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
    public void dST() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nDM.getPageContext().getPageActivity());
        aVar.pa(R.string.function_unavailable_tip);
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.nDM.getPageContext()).btY();
    }

    public void a(List<a> list, e eVar, List<d> list2, boolean z) {
        if ((list == null || list.size() <= 0) && ((eVar == null || StringUtils.isNull(eVar.dSV())) && (list2 == null || list2.size() <= 0))) {
            cDo();
            return;
        }
        cDp();
        x(list2, fX(list) || b(eVar));
    }

    private boolean fX(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.akC.setVisibility(8);
            return false;
        }
        this.akC.setVisibility(0);
        this.akC.setData(list);
        return true;
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dSV())) {
            this.nBx.setVisibility(8);
            return false;
        }
        this.nBx.setVisibility(0);
        this.nBx.a(eVar);
        return true;
    }

    private void x(List<d> list, boolean z) {
        if (list == null || list.size() <= 0) {
            this.WV.setVisibility(8);
            return;
        }
        if (z) {
            this.WV.removeHeaderView(this.nAT);
            this.WV.addHeaderView(this.nAT);
        } else {
            this.WV.removeHeaderView(this.nAT);
        }
        this.WV.setVisibility(0);
        this.nDN.setData(list);
        this.nDN.notifyDataSetChanged();
    }

    @SuppressLint({"ResourceAsColor"})
    public void bCP() {
        this.nDM.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nDM.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nDM.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fOl != null) {
            this.fOl.onChangeSkinType(this.nDM.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.akC != null && this.akC.getVisibility() == 0) {
            this.akC.onChangeSkinType();
        }
        if (this.WV != null && this.WV.getVisibility() == 0 && this.nDN != null) {
            this.nDN.notifyDataSetChanged();
        }
        if (this.nBx != null && this.nBx.getVisibility() == 0) {
            this.nBx.bxP();
        }
        ao.setBackgroundColor(this.nAT, R.color.CAM_X0204);
    }

    public void cDo() {
        this.WV.setVisibility(8);
        this.akC.setVisibility(8);
        this.nBx.setVisibility(8);
        String string = this.nDM.getPageContext().getResources().getString(R.string.no_data_text);
        this.nDM.setNetRefreshViewTopMargin(this.aht);
        this.nDM.showNetRefreshView(this.mRoot, string, false);
    }

    public void cDp() {
        this.nDM.hideNetRefreshView(this.mRoot);
        this.WV.setVisibility(0);
        this.nBx.setVisibility(0);
        this.akC.setVisibility(0);
    }

    private void dSU() {
        if (this.akC != null) {
            this.akC.setCoverFlowFactory(new com.baidu.tbadk.core.flow.a() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.3
                @Override // com.baidu.tbadk.core.flow.a
                public com.baidu.tbadk.core.flow.a.c tI() {
                    com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                    cVar.pR(R.drawable.icon_diandian_white_n);
                    cVar.pS(R.drawable.icon_diandian_white_s);
                    cVar.setSpacing(R.dimen.ds1);
                    cVar.setGravity(85);
                    cVar.pU(R.dimen.ds30);
                    cVar.pT(R.dimen.ds20);
                    return cVar;
                }

                @Override // com.baidu.tbadk.core.flow.a
                public TbImageView W(Context context) {
                    TbImageView tbImageView = new TbImageView(context);
                    tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    tbImageView.setGifIconSupport(false);
                    return tbImageView;
                }

                @Override // com.baidu.tbadk.core.flow.a
                public com.baidu.tbadk.core.flow.a.e tH() {
                    com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                    eVar.setHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds280));
                    return eVar;
                }

                @Override // com.baidu.tbadk.core.flow.a
                public View buI() {
                    return null;
                }
            });
            this.akC.setCallback(new com.baidu.tbadk.core.flow.a.d<a>() { // from class: com.baidu.tieba.themeCenter.dressCenter.c.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.flow.a.d
                public void e(int i, String str) {
                    TiebaStatic.log("c10262");
                    be.bwv().b(c.this.nDM.getPageContext(), new String[]{str});
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
