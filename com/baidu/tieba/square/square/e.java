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
    private TbPageContext<Object> ceu;
    private f jdA;
    private ArrayList<be> jdB;
    private ArrayList<f.b> jdC;
    private ArrayList<f.a> jdD;
    private com.baidu.tieba.square.view.a jdE;
    private Activity mActivity;

    public e(TbPageContext<Object> tbPageContext) {
        this.jdE = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.ceu = tbPageContext;
            this.mActivity = tbPageContext.getPageActivity();
            this.jdE = new com.baidu.tieba.square.view.a(tbPageContext);
            CoverFlowView<g> cng = this.jdE.cng();
            if (tbPageContext.getOrignalPage() instanceof SquareActivity) {
                cng.setSwipeControlInterface((SquareActivity) tbPageContext.getOrignalPage());
            }
            cng.setDisableParentEvent(false);
        }
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.jdA = fVar;
            this.jdB = this.jdA.cmX();
            this.jdC = this.jdA.cmV();
            this.jdD = this.jdA.cmW();
            this.jdE.setData(this.jdB);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.jdC != null && this.jdC.size() != 0) {
            i = 0 + this.jdC.size();
        }
        if (this.jdB != null && this.jdB.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        if (this.jdD != null && this.jdD.size() > 0) {
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
            return this.jdB;
        }
        if (itemViewType == 1) {
            return this.jdD;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            if (this.jdB == null || this.jdB.size() == 0) {
                i2 = 0;
            }
            if (this.jdD != null && this.jdD.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.jdC.size()) {
                return null;
            }
            return this.jdC.get(i - i2);
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
            if (this.jdB != null && this.jdB.size() != 0) {
                return 0;
            }
            if (this.jdD != null && this.jdD.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || this.jdB == null || this.jdB.size() == 0 || this.jdD == null || this.jdD.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            if (this.jdB == null || this.jdB.size() == 0) {
                i2 = 0;
            }
            if (this.jdD != null && this.jdD.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.jdC.size()) {
                return -1;
            }
            f.b bVar = this.jdC.get(i - i2);
            if (bVar == null) {
                return -1;
            }
            if (bVar.jdX) {
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
            return this.jdE.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
        }
        w(view, i);
        this.ceu.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ceu.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            a aVar = new a();
            aVar.jdP = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            aVar.titleText = (TextView) inflate.findViewById(R.id.title_text);
            aVar.jdQ = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(aVar);
            return inflate;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.eventStat(e.this.ceu.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                        e.this.cmT();
                    }
                });
                return inflate2;
            }
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.fcG = (TextView) inflate3.findViewById(R.id.forum_name);
            aVar2.jdJ = (BarImageView) inflate3.findViewById(R.id.forum_image);
            aVar2.jdK = (TextView) inflate3.findViewById(R.id.forum_rank);
            aVar2.jdL = (TextView) inflate3.findViewById(R.id.forum_intro);
            aVar2.jdM = (TextView) inflate3.findViewById(R.id.like_num_tv);
            aVar2.jdN = (TextView) inflate3.findViewById(R.id.thread_num_tv);
            aVar2.jdO = (TextView) inflate3.findViewById(R.id.category_name_tv);
            aVar2.flz = inflate3.findViewById(R.id.vertical_line_view);
            aVar2.jdS = (TextView) inflate3.findViewById(R.id.enter_forum);
            aVar2.jdR = (LinearLayout) inflate3.findViewById(R.id.enter_forum_ll);
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
                    if (bVar.jee == 0) {
                        aVar.jdP.setPadding(this.ceu.getResources().getDimensionPixelSize(R.dimen.ds30), this.ceu.getResources().getDimensionPixelSize(R.dimen.ds26), this.ceu.getResources().getDimensionPixelSize(R.dimen.ds20), this.ceu.getResources().getDimensionPixelSize(R.dimen.ds10));
                    } else {
                        aVar.jdP.setPadding(this.ceu.getResources().getDimensionPixelSize(R.dimen.ds30), this.ceu.getResources().getDimensionPixelSize(R.dimen.ds6), this.ceu.getResources().getDimensionPixelSize(R.dimen.ds20), this.ceu.getResources().getDimensionPixelSize(R.dimen.ds10));
                    }
                    aVar.titleText.setText(bVar.title);
                    if (bVar.jdY) {
                        aVar.jdQ.setVisibility(8);
                        return;
                    }
                    aVar.jdQ.setVisibility(0);
                    aVar.jdQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TiebaStatic.eventStat(e.this.mActivity, "square_category_more", "click", 1, "loc", Integer.valueOf(bVar.jee));
                            ba.amO().b(e.this.ceu, new String[]{bVar.link});
                        }
                    });
                }
            } else if (itemViewType == 3) {
                Object item2 = getItem(i);
                if (item2 instanceof f.b) {
                    final f.b bVar2 = (f.b) item2;
                    final a aVar2 = (a) view.getTag();
                    if (aVar2 != null) {
                        aVar2.jdJ.startLoad(bVar2.jdZ, 10, false);
                        aVar2.fcG.setText(bVar2.forumName);
                        aVar2.jdK.setText(bVar2.jeb);
                        aVar2.jdL.setText(bVar2.jec);
                        long j = bVar2.jed;
                        if (j < 0) {
                            j = 0;
                        }
                        long j2 = bVar2.threadNum;
                        long j3 = j2 >= 0 ? j2 : 0L;
                        aVar2.jdM.setText(this.ceu.getString(R.string.attention) + aq.numFormatOver10000wan(j));
                        aVar2.jdN.setText(this.ceu.getString(R.string.text_post) + aq.numFormatOver10000wan(j3));
                        if (bVar2.jdY && !StringUtils.isNull(bVar2.jea)) {
                            aVar2.jdO.setText(UtilHelper.getFixedText(bVar2.jea, 5));
                            aVar2.jdO.setVisibility(0);
                            aVar2.flz.setVisibility(0);
                        } else {
                            aVar2.jdO.setVisibility(8);
                            aVar2.flz.setVisibility(8);
                        }
                        aVar2.jdO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_menu", "click", 1, "loc", Integer.valueOf(bVar2.jef));
                                ba.amO().b(e.this.ceu, new String[]{bVar2.link});
                            }
                        });
                        aVar2.jdS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(bVar2.jee), "loc", Integer.valueOf(bVar2.jef));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.ceu.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
                            }
                        });
                        aVar2.jdR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                aVar2.jdS.performClick();
                            }
                        });
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(bVar2.jee), "loc", Integer.valueOf(bVar2.jef));
                                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(e.this.ceu.getPageActivity(), bVar2.forumId + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                                } else {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.ceu.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE)));
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
            if (this.jdD == null || this.jdD.size() == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int size = this.jdD.size();
            int i = size > 4 ? 4 : size;
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < viewArr2.length; i2++) {
                if (i2 < i) {
                    final f.a aVar = this.jdD.get(i2);
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
                                tbImageView.startLoad(aVar.jdV, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.title, 5, false));
                            }
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.7
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (aVar.jdW) {
                                        e.this.cmT();
                                    } else {
                                        ba.amO().b(e.this.ceu, new String[]{aVar.link});
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
    public void cmT() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(this.ceu.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    public void onChangeSkinType(int i) {
        if (this.jdE != null) {
            this.jdE.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        TextView fcG;
        View flz;
        BarImageView jdJ;
        TextView jdK;
        TextView jdL;
        TextView jdM;
        TextView jdN;
        TextView jdO;
        RelativeLayout jdP;
        TextView jdQ;
        LinearLayout jdR;
        TextView jdS;
        TextView titleText;

        private a() {
        }
    }
}
