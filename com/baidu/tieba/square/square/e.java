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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.f;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e extends BaseAdapter {
    private f jbb;
    private ArrayList<bd> jbc;
    private ArrayList<f.b> jbd;
    private ArrayList<f.a> jbe;
    private com.baidu.tieba.square.view.a jbf;
    private Activity mActivity;
    private TbPageContext<Object> mContext;

    public e(TbPageContext<Object> tbPageContext) {
        this.jbf = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.mContext = tbPageContext;
            this.mActivity = tbPageContext.getPageActivity();
            this.jbf = new com.baidu.tieba.square.view.a(tbPageContext);
            CoverFlowView<g> com2 = this.jbf.com();
            if (tbPageContext.getOrignalPage() instanceof SquareActivity) {
                com2.setSwipeControlInterface((SquareActivity) tbPageContext.getOrignalPage());
            }
            com2.setDisableParentEvent(false);
        }
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.jbb = fVar;
            this.jbc = this.jbb.coe();
            this.jbd = this.jbb.coc();
            this.jbe = this.jbb.cod();
            this.jbf.setData(this.jbc);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.jbd != null && this.jbd.size() != 0) {
            i = 0 + this.jbd.size();
        }
        if (this.jbc != null && this.jbc.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        if (this.jbe != null && this.jbe.size() > 0) {
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
            return this.jbc;
        }
        if (itemViewType == 1) {
            return this.jbe;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            if (this.jbc == null || this.jbc.size() == 0) {
                i2 = 0;
            }
            if (this.jbe != null && this.jbe.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.jbd.size()) {
                return null;
            }
            return this.jbd.get(i - i2);
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
            if (this.jbc != null && this.jbc.size() != 0) {
                return 0;
            }
            if (this.jbe != null && this.jbe.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || this.jbc == null || this.jbc.size() == 0 || this.jbe == null || this.jbe.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            if (this.jbc == null || this.jbc.size() == 0) {
                i2 = 0;
            }
            if (this.jbe != null && this.jbe.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.jbd.size()) {
                return -1;
            }
            f.b bVar = this.jbd.get(i - i2);
            if (bVar == null) {
                return -1;
            }
            if (bVar.jby) {
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
            return this.jbf.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
        }
        H(view, i);
        this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            a aVar = new a();
            aVar.jbq = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            aVar.titleText = (TextView) inflate.findViewById(R.id.title_text);
            aVar.jbr = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(aVar);
            return inflate;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                        e.this.coa();
                    }
                });
                return inflate2;
            }
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.eYS = (TextView) inflate3.findViewById(R.id.forum_name);
            aVar2.jbk = (BarImageView) inflate3.findViewById(R.id.forum_image);
            aVar2.jbl = (TextView) inflate3.findViewById(R.id.forum_rank);
            aVar2.jbm = (TextView) inflate3.findViewById(R.id.forum_intro);
            aVar2.jbn = (TextView) inflate3.findViewById(R.id.like_num_tv);
            aVar2.jbo = (TextView) inflate3.findViewById(R.id.thread_num_tv);
            aVar2.jbp = (TextView) inflate3.findViewById(R.id.category_name_tv);
            aVar2.fhq = inflate3.findViewById(R.id.vertical_line_view);
            aVar2.jbt = (TextView) inflate3.findViewById(R.id.enter_forum);
            aVar2.jbs = (LinearLayout) inflate3.findViewById(R.id.enter_forum_ll);
            inflate3.setTag(aVar2);
            return inflate3;
        }
    }

    private void H(View view, int i) {
        if (view != null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 1) {
                cQ(view);
            } else if (itemViewType == 2) {
                Object item = getItem(i);
                if (item instanceof f.b) {
                    final f.b bVar = (f.b) item;
                    a aVar = (a) view.getTag();
                    if (bVar.jbF == 0) {
                        aVar.jbq.setPadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10));
                    } else {
                        aVar.jbq.setPadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds6), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10));
                    }
                    aVar.titleText.setText(bVar.title);
                    if (bVar.jbz) {
                        aVar.jbr.setVisibility(8);
                        return;
                    }
                    aVar.jbr.setVisibility(0);
                    aVar.jbr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TiebaStatic.eventStat(e.this.mActivity, "square_category_more", "click", 1, "loc", Integer.valueOf(bVar.jbF));
                            bb.ajC().c(e.this.mContext, new String[]{bVar.link});
                        }
                    });
                }
            } else if (itemViewType == 3) {
                Object item2 = getItem(i);
                if (item2 instanceof f.b) {
                    final f.b bVar2 = (f.b) item2;
                    final a aVar2 = (a) view.getTag();
                    if (aVar2 != null) {
                        aVar2.jbk.startLoad(bVar2.jbA, 10, false);
                        aVar2.eYS.setText(bVar2.forumName);
                        aVar2.jbl.setText(bVar2.jbC);
                        aVar2.jbm.setText(bVar2.jbD);
                        long j = bVar2.jbE;
                        if (j < 0) {
                            j = 0;
                        }
                        long j2 = bVar2.threadNum;
                        long j3 = j2 >= 0 ? j2 : 0L;
                        aVar2.jbn.setText(this.mContext.getString(R.string.attention) + aq.aQ(j));
                        aVar2.jbo.setText(this.mContext.getString(R.string.text_post) + aq.aQ(j3));
                        if (bVar2.jbz && !StringUtils.isNull(bVar2.jbB)) {
                            aVar2.jbp.setText(UtilHelper.getFixedText(bVar2.jbB, 5));
                            aVar2.jbp.setVisibility(0);
                            aVar2.fhq.setVisibility(0);
                        } else {
                            aVar2.jbp.setVisibility(8);
                            aVar2.fhq.setVisibility(8);
                        }
                        aVar2.jbp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_menu", "click", 1, "loc", Integer.valueOf(bVar2.jbG));
                                bb.ajC().c(e.this.mContext, new String[]{bVar2.link});
                            }
                        });
                        aVar2.jbt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(bVar2.jbF), "loc", Integer.valueOf(bVar2.jbG));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.mContext.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
                            }
                        });
                        aVar2.jbs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                aVar2.jbt.performClick();
                            }
                        });
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(bVar2.jbF), "loc", Integer.valueOf(bVar2.jbG));
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

    private void cQ(View view) {
        if (view != null) {
            if (this.jbe == null || this.jbe.size() == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int size = this.jbe.size();
            int i = size > 4 ? 4 : size;
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < viewArr2.length; i2++) {
                if (i2 < i) {
                    final f.a aVar = this.jbe.get(i2);
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
                                tbImageView.startLoad(aVar.jbw, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.title, 5, false));
                            }
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.7
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (aVar.jbx) {
                                        e.this.coa();
                                    } else {
                                        bb.ajC().c(e.this.mContext, new String[]{aVar.link});
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
    public void coa() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902026, new BarFolderFirstDirActivityConfig(this.mContext.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    public void onChangeSkinType(int i) {
        if (this.jbf != null) {
            this.jbf.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        TextView eYS;
        View fhq;
        BarImageView jbk;
        TextView jbl;
        TextView jbm;
        TextView jbn;
        TextView jbo;
        TextView jbp;
        RelativeLayout jbq;
        TextView jbr;
        LinearLayout jbs;
        TextView jbt;
        TextView titleText;

        private a() {
        }
    }
}
