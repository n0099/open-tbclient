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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.f;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e extends BaseAdapter {
    private TbPageContext<Object> cfl;
    private f jer;
    private ArrayList<be> jes;
    private ArrayList<f.b> jet;
    private ArrayList<f.a> jeu;
    private com.baidu.tieba.square.view.a jev;
    private Activity mActivity;

    public e(TbPageContext<Object> tbPageContext) {
        this.jev = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.cfl = tbPageContext;
            this.mActivity = tbPageContext.getPageActivity();
            this.jev = new com.baidu.tieba.square.view.a(tbPageContext);
            CoverFlowView<g> cni = this.jev.cni();
            if (tbPageContext.getOrignalPage() instanceof SquareActivity) {
                cni.setSwipeControlInterface((SquareActivity) tbPageContext.getOrignalPage());
            }
            cni.setDisableParentEvent(false);
        }
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.jer = fVar;
            this.jes = this.jer.cmZ();
            this.jet = this.jer.cmX();
            this.jeu = this.jer.cmY();
            this.jev.setData(this.jes);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.jet != null && this.jet.size() != 0) {
            i = 0 + this.jet.size();
        }
        if (this.jes != null && this.jes.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        if (this.jeu != null && this.jeu.size() > 0) {
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
            return this.jes;
        }
        if (itemViewType == 1) {
            return this.jeu;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            if (this.jes == null || this.jes.size() == 0) {
                i2 = 0;
            }
            if (this.jeu != null && this.jeu.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.jet.size()) {
                return null;
            }
            return this.jet.get(i - i2);
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
            if (this.jes != null && this.jes.size() != 0) {
                return 0;
            }
            if (this.jeu != null && this.jeu.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || this.jes == null || this.jes.size() == 0 || this.jeu == null || this.jeu.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            if (this.jes == null || this.jes.size() == 0) {
                i2 = 0;
            }
            if (this.jeu != null && this.jeu.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.jet.size()) {
                return -1;
            }
            f.b bVar = this.jet.get(i - i2);
            if (bVar == null) {
                return -1;
            }
            if (bVar.jeO) {
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
            return this.jev.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
        }
        w(view, i);
        this.cfl.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cfl.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            a aVar = new a();
            aVar.jeG = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            aVar.titleText = (TextView) inflate.findViewById(R.id.title_text);
            aVar.jeH = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(aVar);
            return inflate;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.eventStat(e.this.cfl.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                        e.this.cmV();
                    }
                });
                return inflate2;
            }
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.fdx = (TextView) inflate3.findViewById(R.id.forum_name);
            aVar2.jeA = (BarImageView) inflate3.findViewById(R.id.forum_image);
            aVar2.jeB = (TextView) inflate3.findViewById(R.id.forum_rank);
            aVar2.jeC = (TextView) inflate3.findViewById(R.id.forum_intro);
            aVar2.jeD = (TextView) inflate3.findViewById(R.id.like_num_tv);
            aVar2.jeE = (TextView) inflate3.findViewById(R.id.thread_num_tv);
            aVar2.jeF = (TextView) inflate3.findViewById(R.id.category_name_tv);
            aVar2.fmq = inflate3.findViewById(R.id.vertical_line_view);
            aVar2.jeJ = (TextView) inflate3.findViewById(R.id.enter_forum);
            aVar2.jeI = (LinearLayout) inflate3.findViewById(R.id.enter_forum_ll);
            inflate3.setTag(aVar2);
            return inflate3;
        }
    }

    private void w(View view, int i) {
        if (view != null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 1) {
                cO(view);
            } else if (itemViewType == 2) {
                Object item = getItem(i);
                if (item instanceof f.b) {
                    final f.b bVar = (f.b) item;
                    a aVar = (a) view.getTag();
                    if (bVar.jeV == 0) {
                        aVar.jeG.setPadding(this.cfl.getResources().getDimensionPixelSize(R.dimen.ds30), this.cfl.getResources().getDimensionPixelSize(R.dimen.ds26), this.cfl.getResources().getDimensionPixelSize(R.dimen.ds20), this.cfl.getResources().getDimensionPixelSize(R.dimen.ds10));
                    } else {
                        aVar.jeG.setPadding(this.cfl.getResources().getDimensionPixelSize(R.dimen.ds30), this.cfl.getResources().getDimensionPixelSize(R.dimen.ds6), this.cfl.getResources().getDimensionPixelSize(R.dimen.ds20), this.cfl.getResources().getDimensionPixelSize(R.dimen.ds10));
                    }
                    aVar.titleText.setText(bVar.title);
                    if (bVar.jeP) {
                        aVar.jeH.setVisibility(8);
                        return;
                    }
                    aVar.jeH.setVisibility(0);
                    aVar.jeH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TiebaStatic.eventStat(e.this.mActivity, "square_category_more", "click", 1, "loc", Integer.valueOf(bVar.jeV));
                            ba.amQ().b(e.this.cfl, new String[]{bVar.link});
                        }
                    });
                }
            } else if (itemViewType == 3) {
                Object item2 = getItem(i);
                if (item2 instanceof f.b) {
                    final f.b bVar2 = (f.b) item2;
                    final a aVar2 = (a) view.getTag();
                    if (aVar2 != null) {
                        aVar2.jeA.startLoad(bVar2.jeQ, 10, false);
                        aVar2.fdx.setText(bVar2.forumName);
                        aVar2.jeB.setText(bVar2.jeS);
                        aVar2.jeC.setText(bVar2.jeT);
                        long j = bVar2.jeU;
                        if (j < 0) {
                            j = 0;
                        }
                        long j2 = bVar2.threadNum;
                        long j3 = j2 >= 0 ? j2 : 0L;
                        aVar2.jeD.setText(this.cfl.getString(R.string.attention) + aq.numFormatOver10000wan(j));
                        aVar2.jeE.setText(this.cfl.getString(R.string.text_post) + aq.numFormatOver10000wan(j3));
                        if (bVar2.jeP && !StringUtils.isNull(bVar2.jeR)) {
                            aVar2.jeF.setText(UtilHelper.getFixedText(bVar2.jeR, 5));
                            aVar2.jeF.setVisibility(0);
                            aVar2.fmq.setVisibility(0);
                        } else {
                            aVar2.jeF.setVisibility(8);
                            aVar2.fmq.setVisibility(8);
                        }
                        aVar2.jeF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_menu", "click", 1, "loc", Integer.valueOf(bVar2.jeW));
                                ba.amQ().b(e.this.cfl, new String[]{bVar2.link});
                            }
                        });
                        aVar2.jeJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(bVar2.jeV), "loc", Integer.valueOf(bVar2.jeW));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.cfl.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
                            }
                        });
                        aVar2.jeI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                aVar2.jeJ.performClick();
                            }
                        });
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(bVar2.jeV), "loc", Integer.valueOf(bVar2.jeW));
                                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(e.this.cfl.getPageActivity(), bVar2.forumId + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                                } else {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.cfl.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE)));
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void cO(View view) {
        if (view != null) {
            if (this.jeu == null || this.jeu.size() == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int size = this.jeu.size();
            int i = size > 4 ? 4 : size;
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < viewArr2.length; i2++) {
                if (i2 < i) {
                    final f.a aVar = this.jeu.get(i2);
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
                                tbImageView.startLoad(aVar.jeM, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.title, 5, false));
                            }
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.7
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (aVar.jeN) {
                                        e.this.cmV();
                                    } else {
                                        ba.amQ().b(e.this.cfl, new String[]{aVar.link});
                                    }
                                    if (view2.getTag() instanceof Integer) {
                                        TiebaStatic.eventStat(e.this.mActivity, "square_entry_content", "click", 1, "loc", "" + ((Integer) view2.getTag()).intValue());
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
    public void cmV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(this.cfl.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    public void onChangeSkinType(int i) {
        if (this.jev != null) {
            this.jev.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        TextView fdx;
        View fmq;
        BarImageView jeA;
        TextView jeB;
        TextView jeC;
        TextView jeD;
        TextView jeE;
        TextView jeF;
        RelativeLayout jeG;
        TextView jeH;
        LinearLayout jeI;
        TextView jeJ;
        TextView titleText;

        private a() {
        }
    }
}
