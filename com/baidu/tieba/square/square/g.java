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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.h;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class g extends BaseAdapter {
    private TbPageContext<Object> eUY;
    private Activity mActivity;
    private h nsm;
    private ArrayList<by> nsn;
    private ArrayList<h.b> nso;
    private ArrayList<h.a> nsp;
    private com.baidu.tieba.square.view.a nsq;

    public g(TbPageContext<Object> tbPageContext) {
        this.nsq = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.eUY = tbPageContext;
            this.mActivity = tbPageContext.getPageActivity();
            this.nsq = new com.baidu.tieba.square.view.a(tbPageContext);
            CoverFlowView<i> dMp = this.nsq.dMp();
            if (tbPageContext.getOrignalPage() instanceof f) {
                dMp.setSwipeControlInterface((f) tbPageContext.getOrignalPage());
            }
            dMp.setDisableParentEvent(false);
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.nsm = hVar;
            this.nsn = this.nsm.dMg();
            this.nso = this.nsm.dMe();
            this.nsp = this.nsm.dMf();
            this.nsq.setData(this.nsn);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.nso != null && this.nso.size() != 0) {
            i = 0 + this.nso.size();
        }
        if (this.nsn != null && this.nsn.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        if (this.nsp != null && this.nsp.size() > 0) {
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
            return this.nsn;
        }
        if (itemViewType == 1) {
            return this.nsp;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            if (this.nsn == null || this.nsn.size() == 0) {
                i2 = 0;
            }
            if (this.nsp != null && this.nsp.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.nso.size()) {
                return null;
            }
            return this.nso.get(i - i2);
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
            if (this.nsn != null && this.nsn.size() != 0) {
                return 0;
            }
            if (this.nsp != null && this.nsp.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || this.nsn == null || this.nsn.size() == 0 || this.nsp == null || this.nsp.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            if (this.nsn == null || this.nsn.size() == 0) {
                i2 = 0;
            }
            if (this.nsp != null && this.nsp.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.nso.size()) {
                return -1;
            }
            h.b bVar = this.nso.get(i - i2);
            if (bVar == null) {
                return -1;
            }
            if (bVar.nsH) {
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
            return this.nsq.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
        }
        E(view, i);
        this.eUY.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eUY.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            a aVar = new a();
            aVar.nsB = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            aVar.titleText = (TextView) inflate.findViewById(R.id.title_text);
            aVar.kgM = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(aVar);
            return inflate;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.eventStat(g.this.eUY.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                        g.this.dMc();
                    }
                });
                return inflate2;
            }
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.kvZ = (TextView) inflate3.findViewById(R.id.forum_name);
            aVar2.nsv = (BarImageView) inflate3.findViewById(R.id.forum_image);
            aVar2.nsw = (TextView) inflate3.findViewById(R.id.forum_rank);
            aVar2.nsx = (TextView) inflate3.findViewById(R.id.forum_intro);
            aVar2.nsy = (TextView) inflate3.findViewById(R.id.like_num_tv);
            aVar2.nsz = (TextView) inflate3.findViewById(R.id.thread_num_tv);
            aVar2.nsA = (TextView) inflate3.findViewById(R.id.category_name_tv);
            aVar2.iWX = inflate3.findViewById(R.id.vertical_line_view);
            aVar2.nsD = (TextView) inflate3.findViewById(R.id.enter_forum);
            aVar2.nsC = (LinearLayout) inflate3.findViewById(R.id.enter_forum_ll);
            inflate3.setTag(aVar2);
            return inflate3;
        }
    }

    private void E(View view, int i) {
        if (view != null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 1) {
                eh(view);
            } else if (itemViewType == 2) {
                Object item = getItem(i);
                if (item instanceof h.b) {
                    final h.b bVar = (h.b) item;
                    a aVar = (a) view.getTag();
                    if (bVar.nsN == 0) {
                        aVar.nsB.setPadding(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds30), this.eUY.getResources().getDimensionPixelSize(R.dimen.ds26), this.eUY.getResources().getDimensionPixelSize(R.dimen.ds20), this.eUY.getResources().getDimensionPixelSize(R.dimen.ds10));
                    } else {
                        aVar.nsB.setPadding(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds30), this.eUY.getResources().getDimensionPixelSize(R.dimen.ds6), this.eUY.getResources().getDimensionPixelSize(R.dimen.ds20), this.eUY.getResources().getDimensionPixelSize(R.dimen.ds10));
                    }
                    aVar.titleText.setText(bVar.title);
                    if (bVar.nsI) {
                        aVar.kgM.setVisibility(8);
                        return;
                    }
                    aVar.kgM.setVisibility(0);
                    aVar.kgM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TiebaStatic.eventStat(g.this.mActivity, "square_category_more", "click", 1, "loc", Integer.valueOf(bVar.nsN));
                            bf.bsV().b(g.this.eUY, new String[]{bVar.link});
                        }
                    });
                }
            } else if (itemViewType == 3) {
                Object item2 = getItem(i);
                if (item2 instanceof h.b) {
                    final h.b bVar2 = (h.b) item2;
                    final a aVar2 = (a) view.getTag();
                    if (aVar2 != null) {
                        aVar2.nsv.startLoad(bVar2.lKV, 10, false);
                        aVar2.kvZ.setText(bVar2.forumName);
                        aVar2.nsw.setText(bVar2.nsK);
                        aVar2.nsx.setText(bVar2.nsL);
                        long j = bVar2.nsM;
                        if (j < 0) {
                            j = 0;
                        }
                        long j2 = bVar2.threadNum;
                        long j3 = j2 >= 0 ? j2 : 0L;
                        aVar2.nsy.setText(this.eUY.getString(R.string.attention) + au.numFormatOver10000wan(j));
                        aVar2.nsz.setText(this.eUY.getString(R.string.text_post) + au.numFormatOver10000wan(j3));
                        if (bVar2.nsI && !StringUtils.isNull(bVar2.nsJ)) {
                            aVar2.nsA.setText(UtilHelper.getFixedText(bVar2.nsJ, 5));
                            aVar2.nsA.setVisibility(0);
                            aVar2.iWX.setVisibility(0);
                        } else {
                            aVar2.nsA.setVisibility(8);
                            aVar2.iWX.setVisibility(8);
                        }
                        aVar2.nsA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_menu", "click", 1, "loc", Integer.valueOf(bVar2.nsO));
                                bf.bsV().b(g.this.eUY, new String[]{bVar2.link});
                            }
                        });
                        aVar2.nsD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(bVar2.nsN), "loc", Integer.valueOf(bVar2.nsO));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.eUY.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
                            }
                        });
                        aVar2.nsC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                aVar2.nsD.performClick();
                            }
                        });
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(bVar2.nsN), "loc", Integer.valueOf(bVar2.nsO));
                                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(g.this.eUY.getPageActivity(), bVar2.forumId + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                                } else {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.eUY.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE)));
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void eh(View view) {
        if (view != null) {
            if (this.nsp == null || this.nsp.size() == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int size = this.nsp.size();
            int i = size > 4 ? 4 : size;
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < viewArr2.length; i2++) {
                if (i2 < i) {
                    final h.a aVar = this.nsp.get(i2);
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
                                tbImageView.startLoad(aVar.nsG, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.title, 5, false));
                            }
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.7
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (aVar.jZE) {
                                        g.this.dMc();
                                    } else {
                                        bf.bsV().b(g.this.eUY, new String[]{aVar.link});
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
    public void dMc() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(this.eUY.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    public void onChangeSkinType(int i) {
        if (this.nsq != null) {
            this.nsq.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        View iWX;
        TextView kgM;
        TextView kvZ;
        TextView nsA;
        RelativeLayout nsB;
        LinearLayout nsC;
        TextView nsD;
        BarImageView nsv;
        TextView nsw;
        TextView nsx;
        TextView nsy;
        TextView nsz;
        TextView titleText;

        private a() {
        }
    }
}
