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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.square.square.f;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e extends BaseAdapter {
    private f iCg;
    private ArrayList<bd> iCh;
    private ArrayList<f.b> iCi;
    private ArrayList<f.a> iCj;
    private com.baidu.tieba.square.view.a iCk;
    private Activity mActivity;
    private TbPageContext<Object> mContext;

    public e(TbPageContext<Object> tbPageContext) {
        this.iCk = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.mContext = tbPageContext;
            this.mActivity = tbPageContext.getPageActivity();
            this.iCk = new com.baidu.tieba.square.view.a(tbPageContext);
            CoverFlowView<g> cdr = this.iCk.cdr();
            if (tbPageContext.getOrignalPage() instanceof SquareActivity) {
                cdr.setSwipeControlInterface((SquareActivity) tbPageContext.getOrignalPage());
            }
            cdr.setDisableParentEvent(false);
        }
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.iCg = fVar;
            this.iCh = this.iCg.cdj();
            this.iCi = this.iCg.cdh();
            this.iCj = this.iCg.cdi();
            this.iCk.setData(this.iCh);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.iCi != null && this.iCi.size() != 0) {
            i = 0 + this.iCi.size();
        }
        if (this.iCh != null && this.iCh.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        if (this.iCj != null && this.iCj.size() > 0) {
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
            return this.iCh;
        }
        if (itemViewType == 1) {
            return this.iCj;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            if (this.iCh == null || this.iCh.size() == 0) {
                i2 = 0;
            }
            if (this.iCj != null && this.iCj.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.iCi.size()) {
                return null;
            }
            return this.iCi.get(i - i2);
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
            if (this.iCh != null && this.iCh.size() != 0) {
                return 0;
            }
            if (this.iCj != null && this.iCj.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || this.iCh == null || this.iCh.size() == 0 || this.iCj == null || this.iCj.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            if (this.iCh == null || this.iCh.size() == 0) {
                i2 = 0;
            }
            if (this.iCj != null && this.iCj.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.iCi.size()) {
                return -1;
            }
            f.b bVar = this.iCi.get(i - i2);
            if (bVar == null) {
                return -1;
            }
            if (bVar.iCD) {
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
            return this.iCk.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
        }
        F(view, i);
        this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.square_list_entry_view, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.square_list_title_view, (ViewGroup) null);
            a aVar = new a();
            aVar.iCv = (RelativeLayout) inflate.findViewById(d.g.title_layout);
            aVar.titleText = (TextView) inflate.findViewById(d.g.title_text);
            aVar.iCw = (TextView) inflate.findViewById(d.g.more_text);
            inflate.setTag(aVar);
            return inflate;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                        e.this.cdf();
                    }
                });
                return inflate2;
            }
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.square_forum_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.eEk = (TextView) inflate3.findViewById(d.g.forum_name);
            aVar2.iCp = (BarImageView) inflate3.findViewById(d.g.forum_image);
            aVar2.iCq = (TextView) inflate3.findViewById(d.g.forum_rank);
            aVar2.iCr = (TextView) inflate3.findViewById(d.g.forum_intro);
            aVar2.iCs = (TextView) inflate3.findViewById(d.g.like_num_tv);
            aVar2.iCt = (TextView) inflate3.findViewById(d.g.thread_num_tv);
            aVar2.iCu = (TextView) inflate3.findViewById(d.g.category_name_tv);
            aVar2.eMu = inflate3.findViewById(d.g.vertical_line_view);
            aVar2.iCy = (TextView) inflate3.findViewById(d.g.enter_forum);
            aVar2.iCx = (LinearLayout) inflate3.findViewById(d.g.enter_forum_ll);
            inflate3.setTag(aVar2);
            return inflate3;
        }
    }

    private void F(View view, int i) {
        if (view != null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 1) {
                cF(view);
            } else if (itemViewType == 2) {
                Object item = getItem(i);
                if (item instanceof f.b) {
                    final f.b bVar = (f.b) item;
                    a aVar = (a) view.getTag();
                    if (bVar.iCK == 0) {
                        aVar.iCv.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds26), this.mContext.getResources().getDimensionPixelSize(d.e.ds20), this.mContext.getResources().getDimensionPixelSize(d.e.ds10));
                    } else {
                        aVar.iCv.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds6), this.mContext.getResources().getDimensionPixelSize(d.e.ds20), this.mContext.getResources().getDimensionPixelSize(d.e.ds10));
                    }
                    aVar.titleText.setText(bVar.title);
                    if (bVar.iCE) {
                        aVar.iCw.setVisibility(8);
                        return;
                    }
                    aVar.iCw.setVisibility(0);
                    aVar.iCw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TiebaStatic.eventStat(e.this.mActivity, "square_category_more", "click", 1, "loc", Integer.valueOf(bVar.iCK));
                            ba.adD().c(e.this.mContext, new String[]{bVar.link});
                        }
                    });
                }
            } else if (itemViewType == 3) {
                Object item2 = getItem(i);
                if (item2 instanceof f.b) {
                    final f.b bVar2 = (f.b) item2;
                    final a aVar2 = (a) view.getTag();
                    if (aVar2 != null) {
                        aVar2.iCp.startLoad(bVar2.iCF, 10, false);
                        aVar2.eEk.setText(bVar2.forumName);
                        aVar2.iCq.setText(bVar2.iCH);
                        aVar2.iCr.setText(bVar2.iCI);
                        long j = bVar2.iCJ;
                        if (j < 0) {
                            j = 0;
                        }
                        long j2 = bVar2.threadNum;
                        long j3 = j2 >= 0 ? j2 : 0L;
                        aVar2.iCs.setText(this.mContext.getString(d.j.attention) + ap.aA(j));
                        aVar2.iCt.setText(this.mContext.getString(d.j.text_post) + ap.aA(j3));
                        if (bVar2.iCE && !StringUtils.isNull(bVar2.iCG)) {
                            aVar2.iCu.setText(UtilHelper.getFixedText(bVar2.iCG, 5));
                            aVar2.iCu.setVisibility(0);
                            aVar2.eMu.setVisibility(0);
                        } else {
                            aVar2.iCu.setVisibility(8);
                            aVar2.eMu.setVisibility(8);
                        }
                        aVar2.iCu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_menu", "click", 1, "loc", Integer.valueOf(bVar2.iCL));
                                ba.adD().c(e.this.mContext, new String[]{bVar2.link});
                            }
                        });
                        aVar2.iCy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(bVar2.iCK), "loc", Integer.valueOf(bVar2.iCL));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.mContext.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
                            }
                        });
                        aVar2.iCx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                aVar2.iCy.performClick();
                            }
                        });
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(bVar2.iCK), "loc", Integer.valueOf(bVar2.iCL));
                                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(e.this.mContext.getPageActivity(), bVar2.forumId + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                                } else {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.mContext.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE)));
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void cF(View view) {
        if (view != null) {
            if (this.iCj == null || this.iCj.size() == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int size = this.iCj.size();
            int i = size > 4 ? 4 : size;
            View[] viewArr = {view.findViewById(d.g.empty_view_01), view.findViewById(d.g.empty_view_02), view.findViewById(d.g.empty_view_03), view.findViewById(d.g.empty_view_04), view.findViewById(d.g.empty_view_05)};
            View[] viewArr2 = {view.findViewById(d.g.entry_ll_01), view.findViewById(d.g.entry_ll_02), view.findViewById(d.g.entry_ll_03), view.findViewById(d.g.entry_ll_04)};
            for (int i2 = 0; i2 < viewArr2.length; i2++) {
                if (i2 < i) {
                    final f.a aVar = this.iCj.get(i2);
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
                                tbImageView.startLoad(aVar.iCB, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.title, 5, false));
                            }
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.7
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (aVar.iCC) {
                                        e.this.cdf();
                                    } else {
                                        ba.adD().c(e.this.mContext, new String[]{aVar.link});
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
    public void cdf() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902026, new BarFolderFirstDirActivityConfig(this.mContext.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    public void onChangeSkinType(int i) {
        if (this.iCk != null) {
            this.iCk.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        TextView eEk;
        View eMu;
        BarImageView iCp;
        TextView iCq;
        TextView iCr;
        TextView iCs;
        TextView iCt;
        TextView iCu;
        RelativeLayout iCv;
        TextView iCw;
        LinearLayout iCx;
        TextView iCy;
        TextView titleText;

        private a() {
        }
    }
}
