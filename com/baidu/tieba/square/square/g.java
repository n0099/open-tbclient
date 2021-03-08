package com.baidu.tieba.square.square;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.h;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class g extends BaseAdapter {
    private TbPageContext<Object> eWx;
    private Activity mActivity;
    private h nuR;
    private ArrayList<by> nuS;
    private ArrayList<h.b> nuT;
    private ArrayList<h.a> nuU;
    private com.baidu.tieba.square.view.a nuV;

    public g(TbPageContext<Object> tbPageContext) {
        this.nuV = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.eWx = tbPageContext;
            this.mActivity = tbPageContext.getPageActivity();
            this.nuV = new com.baidu.tieba.square.view.a(tbPageContext);
            CoverFlowView<i> dMF = this.nuV.dMF();
            if (tbPageContext.getOrignalPage() instanceof f) {
                dMF.setSwipeControlInterface((f) tbPageContext.getOrignalPage());
            }
            dMF.setDisableParentEvent(false);
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.nuR = hVar;
            this.nuS = this.nuR.dMw();
            this.nuT = this.nuR.dMu();
            this.nuU = this.nuR.dMv();
            this.nuV.setData(this.nuS);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.nuT != null && this.nuT.size() != 0) {
            i = 0 + this.nuT.size();
        }
        if (this.nuS != null && this.nuS.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        if (this.nuU != null && this.nuU.size() > 0) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int i2 = 1;
        int itemViewType = getItemViewType(i);
        if (itemViewType == -1 || itemViewType == 4) {
            return null;
        }
        if (itemViewType == 0) {
            return this.nuS;
        }
        if (itemViewType == 1) {
            return this.nuU;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            if (this.nuS == null || this.nuS.size() == 0) {
                i2 = 0;
            }
            if (this.nuU != null && this.nuU.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.nuT.size()) {
                return null;
            }
            return this.nuT.get(i - i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 5;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2 = 1;
        if (i == 0) {
            if (this.nuS != null && this.nuS.size() != 0) {
                return 0;
            }
            if (this.nuU != null && this.nuU.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || this.nuS == null || this.nuS.size() == 0 || this.nuU == null || this.nuU.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            if (this.nuS == null || this.nuS.size() == 0) {
                i2 = 0;
            }
            if (this.nuU != null && this.nuU.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.nuT.size()) {
                return -1;
            }
            h.b bVar = this.nuT.get(i - i2);
            if (bVar == null) {
                return -1;
            }
            if (bVar.nvm) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return this.nuV.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
        }
        E(view, i);
        this.eWx.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eWx.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            a aVar = new a();
            aVar.nvg = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            aVar.titleText = (TextView) inflate.findViewById(R.id.title_text);
            aVar.kjd = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(aVar);
            return inflate;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.eventStat(g.this.eWx.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                        g.this.dMs();
                    }
                });
                return inflate2;
            }
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.kyp = (TextView) inflate3.findViewById(R.id.forum_name);
            aVar2.nva = (BarImageView) inflate3.findViewById(R.id.forum_image);
            aVar2.nvb = (TextView) inflate3.findViewById(R.id.forum_rank);
            aVar2.nvc = (TextView) inflate3.findViewById(R.id.forum_intro);
            aVar2.nvd = (TextView) inflate3.findViewById(R.id.like_num_tv);
            aVar2.nve = (TextView) inflate3.findViewById(R.id.thread_num_tv);
            aVar2.nvf = (TextView) inflate3.findViewById(R.id.category_name_tv);
            aVar2.iYU = inflate3.findViewById(R.id.vertical_line_view);
            aVar2.nvi = (TextView) inflate3.findViewById(R.id.enter_forum);
            aVar2.nvh = (LinearLayout) inflate3.findViewById(R.id.enter_forum_ll);
            inflate3.setTag(aVar2);
            return inflate3;
        }
    }

    private void E(View view, int i) {
        if (view != null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 1) {
                eh(view);
            } else if (itemViewType == 2) {
                Object item = getItem(i);
                if (item instanceof h.b) {
                    final h.b bVar = (h.b) item;
                    a aVar = (a) view.getTag();
                    if (bVar.nvs == 0) {
                        aVar.nvg.setPadding(this.eWx.getResources().getDimensionPixelSize(R.dimen.ds30), this.eWx.getResources().getDimensionPixelSize(R.dimen.ds26), this.eWx.getResources().getDimensionPixelSize(R.dimen.ds20), this.eWx.getResources().getDimensionPixelSize(R.dimen.ds10));
                    } else {
                        aVar.nvg.setPadding(this.eWx.getResources().getDimensionPixelSize(R.dimen.ds30), this.eWx.getResources().getDimensionPixelSize(R.dimen.ds6), this.eWx.getResources().getDimensionPixelSize(R.dimen.ds20), this.eWx.getResources().getDimensionPixelSize(R.dimen.ds10));
                    }
                    aVar.titleText.setText(bVar.title);
                    if (bVar.nvn) {
                        aVar.kjd.setVisibility(8);
                        return;
                    }
                    aVar.kjd.setVisibility(0);
                    aVar.kjd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TiebaStatic.eventStat(g.this.mActivity, "square_category_more", "click", 1, "loc", Integer.valueOf(bVar.nvs));
                            bf.bsY().b(g.this.eWx, new String[]{bVar.link});
                        }
                    });
                }
            } else if (itemViewType == 3) {
                Object item2 = getItem(i);
                if (item2 instanceof h.b) {
                    final h.b bVar2 = (h.b) item2;
                    final a aVar2 = (a) view.getTag();
                    if (aVar2 != null) {
                        aVar2.nva.startLoad(bVar2.lNm, 10, false);
                        aVar2.kyp.setText(bVar2.forumName);
                        aVar2.nvb.setText(bVar2.nvp);
                        aVar2.nvc.setText(bVar2.nvq);
                        long j = bVar2.nvr;
                        if (j < 0) {
                            j = 0;
                        }
                        long j2 = bVar2.threadNum;
                        long j3 = j2 >= 0 ? j2 : 0L;
                        aVar2.nvd.setText(this.eWx.getString(R.string.attention) + au.numFormatOver10000wan(j));
                        aVar2.nve.setText(this.eWx.getString(R.string.text_post) + au.numFormatOver10000wan(j3));
                        if (bVar2.nvn && !StringUtils.isNull(bVar2.nvo)) {
                            aVar2.nvf.setText(UtilHelper.getFixedText(bVar2.nvo, 5));
                            aVar2.nvf.setVisibility(0);
                            aVar2.iYU.setVisibility(0);
                        } else {
                            aVar2.nvf.setVisibility(8);
                            aVar2.iYU.setVisibility(8);
                        }
                        aVar2.nvf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_menu", "click", 1, "loc", Integer.valueOf(bVar2.nvt));
                                bf.bsY().b(g.this.eWx, new String[]{bVar2.link});
                            }
                        });
                        aVar2.nvi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(bVar2.nvs), "loc", Integer.valueOf(bVar2.nvt));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.eWx.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
                            }
                        });
                        aVar2.nvh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                aVar2.nvi.performClick();
                            }
                        });
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(bVar2.nvs), "loc", Integer.valueOf(bVar2.nvt));
                                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(g.this.eWx.getPageActivity(), bVar2.forumId + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                                } else {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.eWx.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE)));
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void eh(View view) {
        if (view != null) {
            if (this.nuU == null || this.nuU.size() == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int size = this.nuU.size();
            int i = size > 4 ? 4 : size;
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < viewArr2.length; i2++) {
                if (i2 < i) {
                    final h.a aVar = this.nuU.get(i2);
                    if (aVar == null) {
                        viewArr2[i2].setVisibility(8);
                    } else {
                        if (viewArr2[i2] instanceof LinearLayout) {
                            LinearLayout linearLayout = (LinearLayout) viewArr2[i2];
                            linearLayout.setTag(Integer.valueOf(i2));
                            View childAt = linearLayout.getChildAt(0);
                            if (childAt instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt;
                                tbImageView.setTag(Integer.valueOf(i2));
                                tbImageView.setDrawerType(1);
                                tbImageView.setIsRound(true);
                                tbImageView.startLoad(aVar.nvl, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.title, 5, false));
                            }
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.7
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (aVar.kbU) {
                                        g.this.dMs();
                                    } else {
                                        bf.bsY().b(g.this.eWx, new String[]{aVar.link});
                                    }
                                    if (view2.getTag() instanceof Integer) {
                                        TiebaStatic.eventStat(g.this.mActivity, "square_entry_content", "click", 1, "loc", "" + ((Integer) view2.getTag()).intValue());
                                    }
                                }
                            });
                        }
                        viewArr2[i2].setVisibility(0);
                        viewArr[i2].setVisibility(0);
                    }
                } else {
                    viewArr2[i2].setVisibility(8);
                    viewArr[i2].setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMs() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(this.eWx.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    public void onChangeSkinType(int i) {
        if (this.nuV != null) {
            this.nuV.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        View iYU;
        TextView kjd;
        TextView kyp;
        BarImageView nva;
        TextView nvb;
        TextView nvc;
        TextView nvd;
        TextView nve;
        TextView nvf;
        RelativeLayout nvg;
        LinearLayout nvh;
        TextView nvi;
        TextView titleText;

        private a() {
        }
    }
}
