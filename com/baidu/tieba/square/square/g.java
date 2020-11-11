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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.h;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class g extends BaseAdapter {
    private TbPageContext<Object> eIc;
    private Activity mActivity;
    private h mSG;
    private ArrayList<bt> mSH;
    private ArrayList<h.b> mSI;
    private ArrayList<h.a> mSJ;
    private com.baidu.tieba.square.view.a mSK;

    public g(TbPageContext<Object> tbPageContext) {
        this.mSK = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.eIc = tbPageContext;
            this.mActivity = tbPageContext.getPageActivity();
            this.mSK = new com.baidu.tieba.square.view.a(tbPageContext);
            CoverFlowView<i> dIV = this.mSK.dIV();
            if (tbPageContext.getOrignalPage() instanceof f) {
                dIV.setSwipeControlInterface((f) tbPageContext.getOrignalPage());
            }
            dIV.setDisableParentEvent(false);
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.mSG = hVar;
            this.mSH = this.mSG.dIM();
            this.mSI = this.mSG.dIK();
            this.mSJ = this.mSG.dIL();
            this.mSK.setData(this.mSH);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.mSI != null && this.mSI.size() != 0) {
            i = 0 + this.mSI.size();
        }
        if (this.mSH != null && this.mSH.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        if (this.mSJ != null && this.mSJ.size() > 0) {
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
            return this.mSH;
        }
        if (itemViewType == 1) {
            return this.mSJ;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            if (this.mSH == null || this.mSH.size() == 0) {
                i2 = 0;
            }
            if (this.mSJ != null && this.mSJ.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.mSI.size()) {
                return null;
            }
            return this.mSI.get(i - i2);
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
            if (this.mSH != null && this.mSH.size() != 0) {
                return 0;
            }
            if (this.mSJ != null && this.mSJ.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || this.mSH == null || this.mSH.size() == 0 || this.mSJ == null || this.mSJ.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            if (this.mSH == null || this.mSH.size() == 0) {
                i2 = 0;
            }
            if (this.mSJ != null && this.mSJ.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.mSI.size()) {
                return -1;
            }
            h.b bVar = this.mSI.get(i - i2);
            if (bVar == null) {
                return -1;
            }
            if (bVar.mTc) {
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
            return this.mSK.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
        }
        z(view, i);
        this.eIc.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eIc.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            a aVar = new a();
            aVar.mSW = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            aVar.titleText = (TextView) inflate.findViewById(R.id.title_text);
            aVar.jBZ = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(aVar);
            return inflate;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.eventStat(g.this.eIc.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                        g.this.dII();
                    }
                });
                return inflate2;
            }
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.jQV = (TextView) inflate3.findViewById(R.id.forum_name);
            aVar2.mSQ = (BarImageView) inflate3.findViewById(R.id.forum_image);
            aVar2.mSR = (TextView) inflate3.findViewById(R.id.forum_rank);
            aVar2.mSS = (TextView) inflate3.findViewById(R.id.forum_intro);
            aVar2.mST = (TextView) inflate3.findViewById(R.id.like_num_tv);
            aVar2.mSU = (TextView) inflate3.findViewById(R.id.thread_num_tv);
            aVar2.mSV = (TextView) inflate3.findViewById(R.id.category_name_tv);
            aVar2.iyd = inflate3.findViewById(R.id.vertical_line_view);
            aVar2.mSY = (TextView) inflate3.findViewById(R.id.enter_forum);
            aVar2.mSX = (LinearLayout) inflate3.findViewById(R.id.enter_forum_ll);
            inflate3.setTag(aVar2);
            return inflate3;
        }
    }

    private void z(View view, int i) {
        if (view != null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 1) {
                dH(view);
            } else if (itemViewType == 2) {
                Object item = getItem(i);
                if (item instanceof h.b) {
                    final h.b bVar = (h.b) item;
                    a aVar = (a) view.getTag();
                    if (bVar.mTi == 0) {
                        aVar.mSW.setPadding(this.eIc.getResources().getDimensionPixelSize(R.dimen.ds30), this.eIc.getResources().getDimensionPixelSize(R.dimen.ds26), this.eIc.getResources().getDimensionPixelSize(R.dimen.ds20), this.eIc.getResources().getDimensionPixelSize(R.dimen.ds10));
                    } else {
                        aVar.mSW.setPadding(this.eIc.getResources().getDimensionPixelSize(R.dimen.ds30), this.eIc.getResources().getDimensionPixelSize(R.dimen.ds6), this.eIc.getResources().getDimensionPixelSize(R.dimen.ds20), this.eIc.getResources().getDimensionPixelSize(R.dimen.ds10));
                    }
                    aVar.titleText.setText(bVar.title);
                    if (bVar.mTd) {
                        aVar.jBZ.setVisibility(8);
                        return;
                    }
                    aVar.jBZ.setVisibility(0);
                    aVar.jBZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TiebaStatic.eventStat(g.this.mActivity, "square_category_more", "click", 1, "loc", Integer.valueOf(bVar.mTi));
                            be.brr().b(g.this.eIc, new String[]{bVar.link});
                        }
                    });
                }
            } else if (itemViewType == 3) {
                Object item2 = getItem(i);
                if (item2 instanceof h.b) {
                    final h.b bVar2 = (h.b) item2;
                    final a aVar2 = (a) view.getTag();
                    if (aVar2 != null) {
                        aVar2.mSQ.startLoad(bVar2.lnP, 10, false);
                        aVar2.jQV.setText(bVar2.forumName);
                        aVar2.mSR.setText(bVar2.mTf);
                        aVar2.mSS.setText(bVar2.mTg);
                        long j = bVar2.mTh;
                        if (j < 0) {
                            j = 0;
                        }
                        long j2 = bVar2.threadNum;
                        long j3 = j2 >= 0 ? j2 : 0L;
                        aVar2.mST.setText(this.eIc.getString(R.string.attention) + at.numFormatOver10000wan(j));
                        aVar2.mSU.setText(this.eIc.getString(R.string.text_post) + at.numFormatOver10000wan(j3));
                        if (bVar2.mTd && !StringUtils.isNull(bVar2.mTe)) {
                            aVar2.mSV.setText(UtilHelper.getFixedText(bVar2.mTe, 5));
                            aVar2.mSV.setVisibility(0);
                            aVar2.iyd.setVisibility(0);
                        } else {
                            aVar2.mSV.setVisibility(8);
                            aVar2.iyd.setVisibility(8);
                        }
                        aVar2.mSV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_menu", "click", 1, "loc", Integer.valueOf(bVar2.mTk));
                                be.brr().b(g.this.eIc, new String[]{bVar2.link});
                            }
                        });
                        aVar2.mSY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(bVar2.mTi), "loc", Integer.valueOf(bVar2.mTk));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.eIc.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
                            }
                        });
                        aVar2.mSX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                aVar2.mSY.performClick();
                            }
                        });
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(bVar2.mTi), "loc", Integer.valueOf(bVar2.mTk));
                                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(g.this.eIc.getPageActivity(), bVar2.forumId + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                                } else {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.eIc.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE)));
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void dH(View view) {
        if (view != null) {
            if (this.mSJ == null || this.mSJ.size() == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int size = this.mSJ.size();
            int i = size > 4 ? 4 : size;
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < viewArr2.length; i2++) {
                if (i2 < i) {
                    final h.a aVar = this.mSJ.get(i2);
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
                                tbImageView.startLoad(aVar.mTb, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.title, 5, false));
                            }
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.7
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (aVar.jvj) {
                                        g.this.dII();
                                    } else {
                                        be.brr().b(g.this.eIc, new String[]{aVar.link});
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
    public void dII() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(this.eIc.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    public void onChangeSkinType(int i) {
        if (this.mSK != null) {
            this.mSK.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class a {
        View iyd;
        TextView jBZ;
        TextView jQV;
        BarImageView mSQ;
        TextView mSR;
        TextView mSS;
        TextView mST;
        TextView mSU;
        TextView mSV;
        RelativeLayout mSW;
        LinearLayout mSX;
        TextView mSY;
        TextView titleText;

        private a() {
        }
    }
}
