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
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.f;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e extends BaseAdapter {
    private f iUL;
    private ArrayList<bd> iUM;
    private ArrayList<f.b> iUN;
    private ArrayList<f.a> iUO;
    private com.baidu.tieba.square.view.a iUP;
    private Activity mActivity;
    private TbPageContext<Object> mContext;

    public e(TbPageContext<Object> tbPageContext) {
        this.iUP = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.mContext = tbPageContext;
            this.mActivity = tbPageContext.getPageActivity();
            this.iUP = new com.baidu.tieba.square.view.a(tbPageContext);
            CoverFlowView<g> clu = this.iUP.clu();
            if (tbPageContext.getOrignalPage() instanceof SquareActivity) {
                clu.setSwipeControlInterface((SquareActivity) tbPageContext.getOrignalPage());
            }
            clu.setDisableParentEvent(false);
        }
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.iUL = fVar;
            this.iUM = this.iUL.clm();
            this.iUN = this.iUL.clk();
            this.iUO = this.iUL.cll();
            this.iUP.setData(this.iUM);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.iUN != null && this.iUN.size() != 0) {
            i = 0 + this.iUN.size();
        }
        if (this.iUM != null && this.iUM.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        if (this.iUO != null && this.iUO.size() > 0) {
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
            return this.iUM;
        }
        if (itemViewType == 1) {
            return this.iUO;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            if (this.iUM == null || this.iUM.size() == 0) {
                i2 = 0;
            }
            if (this.iUO != null && this.iUO.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.iUN.size()) {
                return null;
            }
            return this.iUN.get(i - i2);
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
            if (this.iUM != null && this.iUM.size() != 0) {
                return 0;
            }
            if (this.iUO != null && this.iUO.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || this.iUM == null || this.iUM.size() == 0 || this.iUO == null || this.iUO.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            if (this.iUM == null || this.iUM.size() == 0) {
                i2 = 0;
            }
            if (this.iUO != null && this.iUO.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.iUN.size()) {
                return -1;
            }
            f.b bVar = this.iUN.get(i - i2);
            if (bVar == null) {
                return -1;
            }
            if (bVar.iVi) {
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
            return this.iUP.getView(i, view, viewGroup);
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
            aVar.iVa = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            aVar.titleText = (TextView) inflate.findViewById(R.id.title_text);
            aVar.iVb = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(aVar);
            return inflate;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                        e.this.cli();
                    }
                });
                return inflate2;
            }
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.eTR = (TextView) inflate3.findViewById(R.id.forum_name);
            aVar2.iUU = (BarImageView) inflate3.findViewById(R.id.forum_image);
            aVar2.iUV = (TextView) inflate3.findViewById(R.id.forum_rank);
            aVar2.iUW = (TextView) inflate3.findViewById(R.id.forum_intro);
            aVar2.iUX = (TextView) inflate3.findViewById(R.id.like_num_tv);
            aVar2.iUY = (TextView) inflate3.findViewById(R.id.thread_num_tv);
            aVar2.iUZ = (TextView) inflate3.findViewById(R.id.category_name_tv);
            aVar2.fcq = inflate3.findViewById(R.id.vertical_line_view);
            aVar2.iVd = (TextView) inflate3.findViewById(R.id.enter_forum);
            aVar2.iVc = (LinearLayout) inflate3.findViewById(R.id.enter_forum_ll);
            inflate3.setTag(aVar2);
            return inflate3;
        }
    }

    private void H(View view, int i) {
        if (view != null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 1) {
                cN(view);
            } else if (itemViewType == 2) {
                Object item = getItem(i);
                if (item instanceof f.b) {
                    final f.b bVar = (f.b) item;
                    a aVar = (a) view.getTag();
                    if (bVar.iVp == 0) {
                        aVar.iVa.setPadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10));
                    } else {
                        aVar.iVa.setPadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds6), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10));
                    }
                    aVar.titleText.setText(bVar.title);
                    if (bVar.iVj) {
                        aVar.iVb.setVisibility(8);
                        return;
                    }
                    aVar.iVb.setVisibility(0);
                    aVar.iVb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TiebaStatic.eventStat(e.this.mActivity, "square_category_more", "click", 1, "loc", Integer.valueOf(bVar.iVp));
                            ba.aiz().c(e.this.mContext, new String[]{bVar.link});
                        }
                    });
                }
            } else if (itemViewType == 3) {
                Object item2 = getItem(i);
                if (item2 instanceof f.b) {
                    final f.b bVar2 = (f.b) item2;
                    final a aVar2 = (a) view.getTag();
                    if (aVar2 != null) {
                        aVar2.iUU.startLoad(bVar2.iVk, 10, false);
                        aVar2.eTR.setText(bVar2.forumName);
                        aVar2.iUV.setText(bVar2.iVm);
                        aVar2.iUW.setText(bVar2.iVn);
                        long j = bVar2.iVo;
                        if (j < 0) {
                            j = 0;
                        }
                        long j2 = bVar2.threadNum;
                        long j3 = j2 >= 0 ? j2 : 0L;
                        aVar2.iUX.setText(this.mContext.getString(R.string.attention) + ap.aP(j));
                        aVar2.iUY.setText(this.mContext.getString(R.string.text_post) + ap.aP(j3));
                        if (bVar2.iVj && !StringUtils.isNull(bVar2.iVl)) {
                            aVar2.iUZ.setText(UtilHelper.getFixedText(bVar2.iVl, 5));
                            aVar2.iUZ.setVisibility(0);
                            aVar2.fcq.setVisibility(0);
                        } else {
                            aVar2.iUZ.setVisibility(8);
                            aVar2.fcq.setVisibility(8);
                        }
                        aVar2.iUZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_menu", "click", 1, "loc", Integer.valueOf(bVar2.iVq));
                                ba.aiz().c(e.this.mContext, new String[]{bVar2.link});
                            }
                        });
                        aVar2.iVd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(bVar2.iVp), "loc", Integer.valueOf(bVar2.iVq));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.mContext.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
                            }
                        });
                        aVar2.iVc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                aVar2.iVd.performClick();
                            }
                        });
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(bVar2.iVp), "loc", Integer.valueOf(bVar2.iVq));
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

    private void cN(View view) {
        if (view != null) {
            if (this.iUO == null || this.iUO.size() == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int size = this.iUO.size();
            int i = size > 4 ? 4 : size;
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < viewArr2.length; i2++) {
                if (i2 < i) {
                    final f.a aVar = this.iUO.get(i2);
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
                                tbImageView.startLoad(aVar.iVg, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.title, 5, false));
                            }
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.7
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (aVar.iVh) {
                                        e.this.cli();
                                    } else {
                                        ba.aiz().c(e.this.mContext, new String[]{aVar.link});
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
    public void cli() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902026, new BarFolderFirstDirActivityConfig(this.mContext.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    public void onChangeSkinType(int i) {
        if (this.iUP != null) {
            this.iUP.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        TextView eTR;
        View fcq;
        BarImageView iUU;
        TextView iUV;
        TextView iUW;
        TextView iUX;
        TextView iUY;
        TextView iUZ;
        RelativeLayout iVa;
        TextView iVb;
        LinearLayout iVc;
        TextView iVd;
        TextView titleText;

        private a() {
        }
    }
}
