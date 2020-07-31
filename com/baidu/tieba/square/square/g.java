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
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.h;
import java.util.ArrayList;
/* loaded from: classes17.dex */
public class g extends BaseAdapter {
    private TbPageContext<Object> dVN;
    private h lIU;
    private ArrayList<bs> lIV;
    private ArrayList<h.b> lIW;
    private ArrayList<h.a> lIX;
    private com.baidu.tieba.square.view.a lIY;
    private Activity mActivity;

    public g(TbPageContext<Object> tbPageContext) {
        this.lIY = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.dVN = tbPageContext;
            this.mActivity = tbPageContext.getPageActivity();
            this.lIY = new com.baidu.tieba.square.view.a(tbPageContext);
            CoverFlowView<i> dkf = this.lIY.dkf();
            if (tbPageContext.getOrignalPage() instanceof f) {
                dkf.setSwipeControlInterface((f) tbPageContext.getOrignalPage());
            }
            dkf.setDisableParentEvent(false);
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.lIU = hVar;
            this.lIV = this.lIU.djW();
            this.lIW = this.lIU.djU();
            this.lIX = this.lIU.djV();
            this.lIY.setData(this.lIV);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.lIW != null && this.lIW.size() != 0) {
            i = 0 + this.lIW.size();
        }
        if (this.lIV != null && this.lIV.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        if (this.lIX != null && this.lIX.size() > 0) {
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
            return this.lIV;
        }
        if (itemViewType == 1) {
            return this.lIX;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            if (this.lIV == null || this.lIV.size() == 0) {
                i2 = 0;
            }
            if (this.lIX != null && this.lIX.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.lIW.size()) {
                return null;
            }
            return this.lIW.get(i - i2);
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
            if (this.lIV != null && this.lIV.size() != 0) {
                return 0;
            }
            if (this.lIX != null && this.lIX.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || this.lIV == null || this.lIV.size() == 0 || this.lIX == null || this.lIX.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            if (this.lIV == null || this.lIV.size() == 0) {
                i2 = 0;
            }
            if (this.lIX != null && this.lIX.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.lIW.size()) {
                return -1;
            }
            h.b bVar = this.lIW.get(i - i2);
            if (bVar == null) {
                return -1;
            }
            if (bVar.lJq) {
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
            return this.lIY.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
        }
        w(view, i);
        this.dVN.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.dVN.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            a aVar = new a();
            aVar.lJj = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            aVar.titleText = (TextView) inflate.findViewById(R.id.title_text);
            aVar.ixi = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(aVar);
            return inflate;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.eventStat(g.this.dVN.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                        g.this.djS();
                    }
                });
                return inflate2;
            }
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.iLO = (TextView) inflate3.findViewById(R.id.forum_name);
            aVar2.lJd = (BarImageView) inflate3.findViewById(R.id.forum_image);
            aVar2.lJe = (TextView) inflate3.findViewById(R.id.forum_rank);
            aVar2.lJf = (TextView) inflate3.findViewById(R.id.forum_intro);
            aVar2.lJg = (TextView) inflate3.findViewById(R.id.like_num_tv);
            aVar2.lJh = (TextView) inflate3.findViewById(R.id.thread_num_tv);
            aVar2.lJi = (TextView) inflate3.findViewById(R.id.category_name_tv);
            aVar2.hwn = inflate3.findViewById(R.id.vertical_line_view);
            aVar2.lJl = (TextView) inflate3.findViewById(R.id.enter_forum);
            aVar2.lJk = (LinearLayout) inflate3.findViewById(R.id.enter_forum_ll);
            inflate3.setTag(aVar2);
            return inflate3;
        }
    }

    private void w(View view, int i) {
        if (view != null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 1) {
                dh(view);
            } else if (itemViewType == 2) {
                Object item = getItem(i);
                if (item instanceof h.b) {
                    final h.b bVar = (h.b) item;
                    a aVar = (a) view.getTag();
                    if (bVar.lJw == 0) {
                        aVar.lJj.setPadding(this.dVN.getResources().getDimensionPixelSize(R.dimen.ds30), this.dVN.getResources().getDimensionPixelSize(R.dimen.ds26), this.dVN.getResources().getDimensionPixelSize(R.dimen.ds20), this.dVN.getResources().getDimensionPixelSize(R.dimen.ds10));
                    } else {
                        aVar.lJj.setPadding(this.dVN.getResources().getDimensionPixelSize(R.dimen.ds30), this.dVN.getResources().getDimensionPixelSize(R.dimen.ds6), this.dVN.getResources().getDimensionPixelSize(R.dimen.ds20), this.dVN.getResources().getDimensionPixelSize(R.dimen.ds10));
                    }
                    aVar.titleText.setText(bVar.title);
                    if (bVar.lJr) {
                        aVar.ixi.setVisibility(8);
                        return;
                    }
                    aVar.ixi.setVisibility(0);
                    aVar.ixi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TiebaStatic.eventStat(g.this.mActivity, "square_category_more", "click", 1, "loc", Integer.valueOf(bVar.lJw));
                            bd.baV().b(g.this.dVN, new String[]{bVar.link});
                        }
                    });
                }
            } else if (itemViewType == 3) {
                Object item2 = getItem(i);
                if (item2 instanceof h.b) {
                    final h.b bVar2 = (h.b) item2;
                    final a aVar2 = (a) view.getTag();
                    if (aVar2 != null) {
                        aVar2.lJd.startLoad(bVar2.kij, 10, false);
                        aVar2.iLO.setText(bVar2.forumName);
                        aVar2.lJe.setText(bVar2.lJt);
                        aVar2.lJf.setText(bVar2.lJu);
                        long j = bVar2.lJv;
                        if (j < 0) {
                            j = 0;
                        }
                        long j2 = bVar2.threadNum;
                        long j3 = j2 >= 0 ? j2 : 0L;
                        aVar2.lJg.setText(this.dVN.getString(R.string.attention) + as.numFormatOver10000wan(j));
                        aVar2.lJh.setText(this.dVN.getString(R.string.text_post) + as.numFormatOver10000wan(j3));
                        if (bVar2.lJr && !StringUtils.isNull(bVar2.lJs)) {
                            aVar2.lJi.setText(UtilHelper.getFixedText(bVar2.lJs, 5));
                            aVar2.lJi.setVisibility(0);
                            aVar2.hwn.setVisibility(0);
                        } else {
                            aVar2.lJi.setVisibility(8);
                            aVar2.hwn.setVisibility(8);
                        }
                        aVar2.lJi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_menu", "click", 1, "loc", Integer.valueOf(bVar2.lJx));
                                bd.baV().b(g.this.dVN, new String[]{bVar2.link});
                            }
                        });
                        aVar2.lJl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(bVar2.lJw), "loc", Integer.valueOf(bVar2.lJx));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.dVN.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
                            }
                        });
                        aVar2.lJk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                aVar2.lJl.performClick();
                            }
                        });
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(bVar2.lJw), "loc", Integer.valueOf(bVar2.lJx));
                                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(g.this.dVN.getPageActivity(), bVar2.forumId + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                                } else {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.dVN.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE)));
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void dh(View view) {
        if (view != null) {
            if (this.lIX == null || this.lIX.size() == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int size = this.lIX.size();
            int i = size > 4 ? 4 : size;
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < viewArr2.length; i2++) {
                if (i2 < i) {
                    final h.a aVar = this.lIX.get(i2);
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
                                tbImageView.startLoad(aVar.lJo, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.title, 5, false));
                            }
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.7
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (aVar.lJp) {
                                        g.this.djS();
                                    } else {
                                        bd.baV().b(g.this.dVN, new String[]{aVar.link});
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
    public void djS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(this.dVN.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", SchemeCollecter.CLASSIFY_ALL))));
    }

    public void onChangeSkinType(int i) {
        if (this.lIY != null) {
            this.lIY.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class a {
        View hwn;
        TextView iLO;
        TextView ixi;
        BarImageView lJd;
        TextView lJe;
        TextView lJf;
        TextView lJg;
        TextView lJh;
        TextView lJi;
        RelativeLayout lJj;
        LinearLayout lJk;
        TextView lJl;
        TextView titleText;

        private a() {
        }
    }
}
