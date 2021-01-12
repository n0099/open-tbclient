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
import com.baidu.tbadk.core.data.bw;
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
/* loaded from: classes7.dex */
public class g extends BaseAdapter {
    private TbPageContext<Object> eSJ;
    private Activity mActivity;
    private h niE;
    private ArrayList<bw> niF;
    private ArrayList<h.b> niG;
    private ArrayList<h.a> niH;
    private com.baidu.tieba.square.view.a niI;

    public g(TbPageContext<Object> tbPageContext) {
        this.niI = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.eSJ = tbPageContext;
            this.mActivity = tbPageContext.getPageActivity();
            this.niI = new com.baidu.tieba.square.view.a(tbPageContext);
            CoverFlowView<i> dKe = this.niI.dKe();
            if (tbPageContext.getOrignalPage() instanceof f) {
                dKe.setSwipeControlInterface((f) tbPageContext.getOrignalPage());
            }
            dKe.setDisableParentEvent(false);
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.niE = hVar;
            this.niF = this.niE.dJV();
            this.niG = this.niE.dJT();
            this.niH = this.niE.dJU();
            this.niI.setData(this.niF);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.niG != null && this.niG.size() != 0) {
            i = 0 + this.niG.size();
        }
        if (this.niF != null && this.niF.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        if (this.niH != null && this.niH.size() > 0) {
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
            return this.niF;
        }
        if (itemViewType == 1) {
            return this.niH;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            if (this.niF == null || this.niF.size() == 0) {
                i2 = 0;
            }
            if (this.niH != null && this.niH.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.niG.size()) {
                return null;
            }
            return this.niG.get(i - i2);
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
            if (this.niF != null && this.niF.size() != 0) {
                return 0;
            }
            if (this.niH != null && this.niH.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || this.niF == null || this.niF.size() == 0 || this.niH == null || this.niH.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            if (this.niF == null || this.niF.size() == 0) {
                i2 = 0;
            }
            if (this.niH != null && this.niH.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.niG.size()) {
                return -1;
            }
            h.b bVar = this.niG.get(i - i2);
            if (bVar == null) {
                return -1;
            }
            if (bVar.niZ) {
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
            return this.niI.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
        }
        E(view, i);
        this.eSJ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eSJ.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            a aVar = new a();
            aVar.niT = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            aVar.titleText = (TextView) inflate.findViewById(R.id.title_text);
            aVar.jZj = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(aVar);
            return inflate;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.eventStat(g.this.eSJ.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                        g.this.dJR();
                    }
                });
                return inflate2;
            }
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.knS = (TextView) inflate3.findViewById(R.id.forum_name);
            aVar2.niN = (BarImageView) inflate3.findViewById(R.id.forum_image);
            aVar2.niO = (TextView) inflate3.findViewById(R.id.forum_rank);
            aVar2.niP = (TextView) inflate3.findViewById(R.id.forum_intro);
            aVar2.niQ = (TextView) inflate3.findViewById(R.id.like_num_tv);
            aVar2.niR = (TextView) inflate3.findViewById(R.id.thread_num_tv);
            aVar2.niS = (TextView) inflate3.findViewById(R.id.category_name_tv);
            aVar2.iRq = inflate3.findViewById(R.id.vertical_line_view);
            aVar2.niV = (TextView) inflate3.findViewById(R.id.enter_forum);
            aVar2.niU = (LinearLayout) inflate3.findViewById(R.id.enter_forum_ll);
            inflate3.setTag(aVar2);
            return inflate3;
        }
    }

    private void E(View view, int i) {
        if (view != null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 1) {
                ej(view);
            } else if (itemViewType == 2) {
                Object item = getItem(i);
                if (item instanceof h.b) {
                    final h.b bVar = (h.b) item;
                    a aVar = (a) view.getTag();
                    if (bVar.njf == 0) {
                        aVar.niT.setPadding(this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds30), this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds26), this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds20), this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds10));
                    } else {
                        aVar.niT.setPadding(this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds30), this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds6), this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds20), this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds10));
                    }
                    aVar.titleText.setText(bVar.title);
                    if (bVar.nja) {
                        aVar.jZj.setVisibility(8);
                        return;
                    }
                    aVar.jZj.setVisibility(0);
                    aVar.jZj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TiebaStatic.eventStat(g.this.mActivity, "square_category_more", "click", 1, "loc", Integer.valueOf(bVar.njf));
                            be.bsB().b(g.this.eSJ, new String[]{bVar.link});
                        }
                    });
                }
            } else if (itemViewType == 3) {
                Object item2 = getItem(i);
                if (item2 instanceof h.b) {
                    final h.b bVar2 = (h.b) item2;
                    final a aVar2 = (a) view.getTag();
                    if (aVar2 != null) {
                        aVar2.niN.startLoad(bVar2.lCh, 10, false);
                        aVar2.knS.setText(bVar2.forumName);
                        aVar2.niO.setText(bVar2.njc);
                        aVar2.niP.setText(bVar2.njd);
                        long j = bVar2.nje;
                        if (j < 0) {
                            j = 0;
                        }
                        long j2 = bVar2.threadNum;
                        long j3 = j2 >= 0 ? j2 : 0L;
                        aVar2.niQ.setText(this.eSJ.getString(R.string.attention) + at.numFormatOver10000wan(j));
                        aVar2.niR.setText(this.eSJ.getString(R.string.text_post) + at.numFormatOver10000wan(j3));
                        if (bVar2.nja && !StringUtils.isNull(bVar2.njb)) {
                            aVar2.niS.setText(UtilHelper.getFixedText(bVar2.njb, 5));
                            aVar2.niS.setVisibility(0);
                            aVar2.iRq.setVisibility(0);
                        } else {
                            aVar2.niS.setVisibility(8);
                            aVar2.iRq.setVisibility(8);
                        }
                        aVar2.niS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_menu", "click", 1, "loc", Integer.valueOf(bVar2.njg));
                                be.bsB().b(g.this.eSJ, new String[]{bVar2.link});
                            }
                        });
                        aVar2.niV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(bVar2.njf), "loc", Integer.valueOf(bVar2.njg));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.eSJ.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
                            }
                        });
                        aVar2.niU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                aVar2.niV.performClick();
                            }
                        });
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(bVar2.njf), "loc", Integer.valueOf(bVar2.njg));
                                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(g.this.eSJ.getPageActivity(), bVar2.forumId + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                                } else {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.eSJ.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE)));
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void ej(View view) {
        if (view != null) {
            if (this.niH == null || this.niH.size() == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int size = this.niH.size();
            int i = size > 4 ? 4 : size;
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < viewArr2.length; i2++) {
                if (i2 < i) {
                    final h.a aVar = this.niH.get(i2);
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
                                tbImageView.startLoad(aVar.niY, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.title, 5, false));
                            }
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.7
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (aVar.jSd) {
                                        g.this.dJR();
                                    } else {
                                        be.bsB().b(g.this.eSJ, new String[]{aVar.link});
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
    public void dJR() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(this.eSJ.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    public void onChangeSkinType(int i) {
        if (this.niI != null) {
            this.niI.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        View iRq;
        TextView jZj;
        TextView knS;
        BarImageView niN;
        TextView niO;
        TextView niP;
        TextView niQ;
        TextView niR;
        TextView niS;
        RelativeLayout niT;
        LinearLayout niU;
        TextView niV;
        TextView titleText;

        private a() {
        }
    }
}
