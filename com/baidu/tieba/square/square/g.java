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
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.h;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class g extends BaseAdapter {
    private TbPageContext<Object> dPv;
    private h lBF;
    private ArrayList<br> lBG;
    private ArrayList<h.b> lBH;
    private ArrayList<h.a> lBI;
    private com.baidu.tieba.square.view.a lBJ;
    private Activity mActivity;

    public g(TbPageContext<Object> tbPageContext) {
        this.lBJ = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.dPv = tbPageContext;
            this.mActivity = tbPageContext.getPageActivity();
            this.lBJ = new com.baidu.tieba.square.view.a(tbPageContext);
            CoverFlowView<i> dgW = this.lBJ.dgW();
            if (tbPageContext.getOrignalPage() instanceof f) {
                dgW.setSwipeControlInterface((f) tbPageContext.getOrignalPage());
            }
            dgW.setDisableParentEvent(false);
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.lBF = hVar;
            this.lBG = this.lBF.dgN();
            this.lBH = this.lBF.dgL();
            this.lBI = this.lBF.dgM();
            this.lBJ.setData(this.lBG);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.lBH != null && this.lBH.size() != 0) {
            i = 0 + this.lBH.size();
        }
        if (this.lBG != null && this.lBG.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        if (this.lBI != null && this.lBI.size() > 0) {
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
            return this.lBG;
        }
        if (itemViewType == 1) {
            return this.lBI;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            if (this.lBG == null || this.lBG.size() == 0) {
                i2 = 0;
            }
            if (this.lBI != null && this.lBI.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.lBH.size()) {
                return null;
            }
            return this.lBH.get(i - i2);
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
            if (this.lBG != null && this.lBG.size() != 0) {
                return 0;
            }
            if (this.lBI != null && this.lBI.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || this.lBG == null || this.lBG.size() == 0 || this.lBI == null || this.lBI.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            if (this.lBG == null || this.lBG.size() == 0) {
                i2 = 0;
            }
            if (this.lBI != null && this.lBI.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.lBH.size()) {
                return -1;
            }
            h.b bVar = this.lBH.get(i - i2);
            if (bVar == null) {
                return -1;
            }
            if (bVar.lCb) {
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
            return this.lBJ.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
        }
        v(view, i);
        this.dPv.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.dPv.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            a aVar = new a();
            aVar.lBU = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            aVar.titleText = (TextView) inflate.findViewById(R.id.title_text);
            aVar.ire = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(aVar);
            return inflate;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.eventStat(g.this.dPv.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                        g.this.dgJ();
                    }
                });
                return inflate2;
            }
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.iFK = (TextView) inflate3.findViewById(R.id.forum_name);
            aVar2.lBO = (BarImageView) inflate3.findViewById(R.id.forum_image);
            aVar2.lBP = (TextView) inflate3.findViewById(R.id.forum_rank);
            aVar2.lBQ = (TextView) inflate3.findViewById(R.id.forum_intro);
            aVar2.lBR = (TextView) inflate3.findViewById(R.id.like_num_tv);
            aVar2.lBS = (TextView) inflate3.findViewById(R.id.thread_num_tv);
            aVar2.lBT = (TextView) inflate3.findViewById(R.id.category_name_tv);
            aVar2.hqB = inflate3.findViewById(R.id.vertical_line_view);
            aVar2.lBW = (TextView) inflate3.findViewById(R.id.enter_forum);
            aVar2.lBV = (LinearLayout) inflate3.findViewById(R.id.enter_forum_ll);
            inflate3.setTag(aVar2);
            return inflate3;
        }
    }

    private void v(View view, int i) {
        if (view != null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 1) {
                db(view);
            } else if (itemViewType == 2) {
                Object item = getItem(i);
                if (item instanceof h.b) {
                    final h.b bVar = (h.b) item;
                    a aVar = (a) view.getTag();
                    if (bVar.lCh == 0) {
                        aVar.lBU.setPadding(this.dPv.getResources().getDimensionPixelSize(R.dimen.ds30), this.dPv.getResources().getDimensionPixelSize(R.dimen.ds26), this.dPv.getResources().getDimensionPixelSize(R.dimen.ds20), this.dPv.getResources().getDimensionPixelSize(R.dimen.ds10));
                    } else {
                        aVar.lBU.setPadding(this.dPv.getResources().getDimensionPixelSize(R.dimen.ds30), this.dPv.getResources().getDimensionPixelSize(R.dimen.ds6), this.dPv.getResources().getDimensionPixelSize(R.dimen.ds20), this.dPv.getResources().getDimensionPixelSize(R.dimen.ds10));
                    }
                    aVar.titleText.setText(bVar.title);
                    if (bVar.lCc) {
                        aVar.ire.setVisibility(8);
                        return;
                    }
                    aVar.ire.setVisibility(0);
                    aVar.ire.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TiebaStatic.eventStat(g.this.mActivity, "square_category_more", "click", 1, "loc", Integer.valueOf(bVar.lCh));
                            bc.aWU().b(g.this.dPv, new String[]{bVar.link});
                        }
                    });
                }
            } else if (itemViewType == 3) {
                Object item2 = getItem(i);
                if (item2 instanceof h.b) {
                    final h.b bVar2 = (h.b) item2;
                    final a aVar2 = (a) view.getTag();
                    if (aVar2 != null) {
                        aVar2.lBO.startLoad(bVar2.jZH, 10, false);
                        aVar2.iFK.setText(bVar2.forumName);
                        aVar2.lBP.setText(bVar2.lCe);
                        aVar2.lBQ.setText(bVar2.lCf);
                        long j = bVar2.lCg;
                        if (j < 0) {
                            j = 0;
                        }
                        long j2 = bVar2.threadNum;
                        long j3 = j2 >= 0 ? j2 : 0L;
                        aVar2.lBR.setText(this.dPv.getString(R.string.attention) + ar.numFormatOver10000wan(j));
                        aVar2.lBS.setText(this.dPv.getString(R.string.text_post) + ar.numFormatOver10000wan(j3));
                        if (bVar2.lCc && !StringUtils.isNull(bVar2.lCd)) {
                            aVar2.lBT.setText(UtilHelper.getFixedText(bVar2.lCd, 5));
                            aVar2.lBT.setVisibility(0);
                            aVar2.hqB.setVisibility(0);
                        } else {
                            aVar2.lBT.setVisibility(8);
                            aVar2.hqB.setVisibility(8);
                        }
                        aVar2.lBT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_menu", "click", 1, "loc", Integer.valueOf(bVar2.lCi));
                                bc.aWU().b(g.this.dPv, new String[]{bVar2.link});
                            }
                        });
                        aVar2.lBW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(bVar2.lCh), "loc", Integer.valueOf(bVar2.lCi));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.dPv.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
                            }
                        });
                        aVar2.lBV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                aVar2.lBW.performClick();
                            }
                        });
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(bVar2.lCh), "loc", Integer.valueOf(bVar2.lCi));
                                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(g.this.dPv.getPageActivity(), bVar2.forumId + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                                } else {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.dPv.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE)));
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void db(View view) {
        if (view != null) {
            if (this.lBI == null || this.lBI.size() == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int size = this.lBI.size();
            int i = size > 4 ? 4 : size;
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < viewArr2.length; i2++) {
                if (i2 < i) {
                    final h.a aVar = this.lBI.get(i2);
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
                                tbImageView.startLoad(aVar.lBZ, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.title, 5, false));
                            }
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.7
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (aVar.lCa) {
                                        g.this.dgJ();
                                    } else {
                                        bc.aWU().b(g.this.dPv, new String[]{aVar.link});
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
    public void dgJ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(this.dPv.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", SchemeCollecter.CLASSIFY_ALL))));
    }

    public void onChangeSkinType(int i) {
        if (this.lBJ != null) {
            this.lBJ.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        View hqB;
        TextView iFK;
        TextView ire;
        BarImageView lBO;
        TextView lBP;
        TextView lBQ;
        TextView lBR;
        TextView lBS;
        TextView lBT;
        RelativeLayout lBU;
        LinearLayout lBV;
        TextView lBW;
        TextView titleText;

        private a() {
        }
    }
}
