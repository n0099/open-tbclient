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
    private f iBQ;
    private ArrayList<bd> iBR;
    private ArrayList<f.b> iBS;
    private ArrayList<f.a> iBT;
    private com.baidu.tieba.square.view.a iBU;
    private Activity mActivity;
    private TbPageContext<Object> mContext;

    public e(TbPageContext<Object> tbPageContext) {
        this.iBU = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.mContext = tbPageContext;
            this.mActivity = tbPageContext.getPageActivity();
            this.iBU = new com.baidu.tieba.square.view.a(tbPageContext);
            CoverFlowView<g> cdn = this.iBU.cdn();
            if (tbPageContext.getOrignalPage() instanceof SquareActivity) {
                cdn.setSwipeControlInterface((SquareActivity) tbPageContext.getOrignalPage());
            }
            cdn.setDisableParentEvent(false);
        }
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.iBQ = fVar;
            this.iBR = this.iBQ.cdf();
            this.iBS = this.iBQ.cdd();
            this.iBT = this.iBQ.cde();
            this.iBU.setData(this.iBR);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.iBS != null && this.iBS.size() != 0) {
            i = 0 + this.iBS.size();
        }
        if (this.iBR != null && this.iBR.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        if (this.iBT != null && this.iBT.size() > 0) {
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
            return this.iBR;
        }
        if (itemViewType == 1) {
            return this.iBT;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            if (this.iBR == null || this.iBR.size() == 0) {
                i2 = 0;
            }
            if (this.iBT != null && this.iBT.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.iBS.size()) {
                return null;
            }
            return this.iBS.get(i - i2);
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
            if (this.iBR != null && this.iBR.size() != 0) {
                return 0;
            }
            if (this.iBT != null && this.iBT.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || this.iBR == null || this.iBR.size() == 0 || this.iBT == null || this.iBT.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            if (this.iBR == null || this.iBR.size() == 0) {
                i2 = 0;
            }
            if (this.iBT != null && this.iBT.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.iBS.size()) {
                return -1;
            }
            f.b bVar = this.iBS.get(i - i2);
            if (bVar == null) {
                return -1;
            }
            if (bVar.iCn) {
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
            return this.iBU.getView(i, view, viewGroup);
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
            aVar.iCf = (RelativeLayout) inflate.findViewById(d.g.title_layout);
            aVar.titleText = (TextView) inflate.findViewById(d.g.title_text);
            aVar.iCg = (TextView) inflate.findViewById(d.g.more_text);
            inflate.setTag(aVar);
            return inflate;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                        e.this.cdb();
                    }
                });
                return inflate2;
            }
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.square_forum_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.eDV = (TextView) inflate3.findViewById(d.g.forum_name);
            aVar2.iBZ = (BarImageView) inflate3.findViewById(d.g.forum_image);
            aVar2.iCa = (TextView) inflate3.findViewById(d.g.forum_rank);
            aVar2.iCb = (TextView) inflate3.findViewById(d.g.forum_intro);
            aVar2.iCc = (TextView) inflate3.findViewById(d.g.like_num_tv);
            aVar2.iCd = (TextView) inflate3.findViewById(d.g.thread_num_tv);
            aVar2.iCe = (TextView) inflate3.findViewById(d.g.category_name_tv);
            aVar2.eMg = inflate3.findViewById(d.g.vertical_line_view);
            aVar2.iCi = (TextView) inflate3.findViewById(d.g.enter_forum);
            aVar2.iCh = (LinearLayout) inflate3.findViewById(d.g.enter_forum_ll);
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
                    if (bVar.iCu == 0) {
                        aVar.iCf.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds26), this.mContext.getResources().getDimensionPixelSize(d.e.ds20), this.mContext.getResources().getDimensionPixelSize(d.e.ds10));
                    } else {
                        aVar.iCf.setPadding(this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds6), this.mContext.getResources().getDimensionPixelSize(d.e.ds20), this.mContext.getResources().getDimensionPixelSize(d.e.ds10));
                    }
                    aVar.titleText.setText(bVar.title);
                    if (bVar.iCo) {
                        aVar.iCg.setVisibility(8);
                        return;
                    }
                    aVar.iCg.setVisibility(0);
                    aVar.iCg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TiebaStatic.eventStat(e.this.mActivity, "square_category_more", "click", 1, "loc", Integer.valueOf(bVar.iCu));
                            ba.adA().c(e.this.mContext, new String[]{bVar.link});
                        }
                    });
                }
            } else if (itemViewType == 3) {
                Object item2 = getItem(i);
                if (item2 instanceof f.b) {
                    final f.b bVar2 = (f.b) item2;
                    final a aVar2 = (a) view.getTag();
                    if (aVar2 != null) {
                        aVar2.iBZ.startLoad(bVar2.iCp, 10, false);
                        aVar2.eDV.setText(bVar2.forumName);
                        aVar2.iCa.setText(bVar2.iCr);
                        aVar2.iCb.setText(bVar2.iCs);
                        long j = bVar2.iCt;
                        if (j < 0) {
                            j = 0;
                        }
                        long j2 = bVar2.threadNum;
                        long j3 = j2 >= 0 ? j2 : 0L;
                        aVar2.iCc.setText(this.mContext.getString(d.j.attention) + ap.aA(j));
                        aVar2.iCd.setText(this.mContext.getString(d.j.text_post) + ap.aA(j3));
                        if (bVar2.iCo && !StringUtils.isNull(bVar2.iCq)) {
                            aVar2.iCe.setText(UtilHelper.getFixedText(bVar2.iCq, 5));
                            aVar2.iCe.setVisibility(0);
                            aVar2.eMg.setVisibility(0);
                        } else {
                            aVar2.iCe.setVisibility(8);
                            aVar2.eMg.setVisibility(8);
                        }
                        aVar2.iCe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_menu", "click", 1, "loc", Integer.valueOf(bVar2.iCv));
                                ba.adA().c(e.this.mContext, new String[]{bVar2.link});
                            }
                        });
                        aVar2.iCi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(bVar2.iCu), "loc", Integer.valueOf(bVar2.iCv));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.mContext.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
                            }
                        });
                        aVar2.iCh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                aVar2.iCi.performClick();
                            }
                        });
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(e.this.mActivity, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(bVar2.iCu), "loc", Integer.valueOf(bVar2.iCv));
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
            if (this.iBT == null || this.iBT.size() == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int size = this.iBT.size();
            int i = size > 4 ? 4 : size;
            View[] viewArr = {view.findViewById(d.g.empty_view_01), view.findViewById(d.g.empty_view_02), view.findViewById(d.g.empty_view_03), view.findViewById(d.g.empty_view_04), view.findViewById(d.g.empty_view_05)};
            View[] viewArr2 = {view.findViewById(d.g.entry_ll_01), view.findViewById(d.g.entry_ll_02), view.findViewById(d.g.entry_ll_03), view.findViewById(d.g.entry_ll_04)};
            for (int i2 = 0; i2 < viewArr2.length; i2++) {
                if (i2 < i) {
                    final f.a aVar = this.iBT.get(i2);
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
                                tbImageView.startLoad(aVar.iCl, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.title, 5, false));
                            }
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.e.7
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (aVar.iCm) {
                                        e.this.cdb();
                                    } else {
                                        ba.adA().c(e.this.mContext, new String[]{aVar.link});
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
    public void cdb() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902026, new BarFolderFirstDirActivityConfig(this.mContext.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    public void onChangeSkinType(int i) {
        if (this.iBU != null) {
            this.iBU.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        TextView eDV;
        View eMg;
        BarImageView iBZ;
        TextView iCa;
        TextView iCb;
        TextView iCc;
        TextView iCd;
        TextView iCe;
        RelativeLayout iCf;
        TextView iCg;
        LinearLayout iCh;
        TextView iCi;
        TextView titleText;

        private a() {
        }
    }
}
