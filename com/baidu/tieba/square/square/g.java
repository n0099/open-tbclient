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
/* loaded from: classes22.dex */
public class g extends BaseAdapter {
    private TbPageContext<Object> ehG;
    private Activity mActivity;
    private h mkv;
    private ArrayList<bt> mkw;
    private ArrayList<h.b> mkx;
    private ArrayList<h.a> mky;
    private com.baidu.tieba.square.view.a mkz;

    public g(TbPageContext<Object> tbPageContext) {
        this.mkz = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.ehG = tbPageContext;
            this.mActivity = tbPageContext.getPageActivity();
            this.mkz = new com.baidu.tieba.square.view.a(tbPageContext);
            CoverFlowView<i> dzA = this.mkz.dzA();
            if (tbPageContext.getOrignalPage() instanceof f) {
                dzA.setSwipeControlInterface((f) tbPageContext.getOrignalPage());
            }
            dzA.setDisableParentEvent(false);
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.mkv = hVar;
            this.mkw = this.mkv.dzr();
            this.mkx = this.mkv.dzp();
            this.mky = this.mkv.dzq();
            this.mkz.setData(this.mkw);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.mkx != null && this.mkx.size() != 0) {
            i = 0 + this.mkx.size();
        }
        if (this.mkw != null && this.mkw.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        if (this.mky != null && this.mky.size() > 0) {
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
            return this.mkw;
        }
        if (itemViewType == 1) {
            return this.mky;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            if (this.mkw == null || this.mkw.size() == 0) {
                i2 = 0;
            }
            if (this.mky != null && this.mky.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.mkx.size()) {
                return null;
            }
            return this.mkx.get(i - i2);
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
            if (this.mkw != null && this.mkw.size() != 0) {
                return 0;
            }
            if (this.mky != null && this.mky.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || this.mkw == null || this.mkw.size() == 0 || this.mky == null || this.mky.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            if (this.mkw == null || this.mkw.size() == 0) {
                i2 = 0;
            }
            if (this.mky != null && this.mky.size() != 0) {
                i2++;
            }
            if (i - i2 < 0 || i - i2 >= this.mkx.size()) {
                return -1;
            }
            h.b bVar = this.mkx.get(i - i2);
            if (bVar == null) {
                return -1;
            }
            if (bVar.mkQ) {
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
            return this.mkz.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
        }
        x(view, i);
        this.ehG.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ehG.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            a aVar = new a();
            aVar.mkK = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            aVar.titleText = (TextView) inflate.findViewById(R.id.title_text);
            aVar.iUH = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(aVar);
            return inflate;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.eventStat(g.this.ehG.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                        g.this.dzn();
                    }
                });
                return inflate2;
            }
            return null;
        } else {
            View inflate3 = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.jjA = (TextView) inflate3.findViewById(R.id.forum_name);
            aVar2.mkE = (BarImageView) inflate3.findViewById(R.id.forum_image);
            aVar2.mkF = (TextView) inflate3.findViewById(R.id.forum_rank);
            aVar2.mkG = (TextView) inflate3.findViewById(R.id.forum_intro);
            aVar2.mkH = (TextView) inflate3.findViewById(R.id.like_num_tv);
            aVar2.mkI = (TextView) inflate3.findViewById(R.id.thread_num_tv);
            aVar2.mkJ = (TextView) inflate3.findViewById(R.id.category_name_tv);
            aVar2.hQJ = inflate3.findViewById(R.id.vertical_line_view);
            aVar2.mkM = (TextView) inflate3.findViewById(R.id.enter_forum);
            aVar2.mkL = (LinearLayout) inflate3.findViewById(R.id.enter_forum_ll);
            inflate3.setTag(aVar2);
            return inflate3;
        }
    }

    private void x(View view, int i) {
        if (view != null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 1) {
                du(view);
            } else if (itemViewType == 2) {
                Object item = getItem(i);
                if (item instanceof h.b) {
                    final h.b bVar = (h.b) item;
                    a aVar = (a) view.getTag();
                    if (bVar.mkW == 0) {
                        aVar.mkK.setPadding(this.ehG.getResources().getDimensionPixelSize(R.dimen.ds30), this.ehG.getResources().getDimensionPixelSize(R.dimen.ds26), this.ehG.getResources().getDimensionPixelSize(R.dimen.ds20), this.ehG.getResources().getDimensionPixelSize(R.dimen.ds10));
                    } else {
                        aVar.mkK.setPadding(this.ehG.getResources().getDimensionPixelSize(R.dimen.ds30), this.ehG.getResources().getDimensionPixelSize(R.dimen.ds6), this.ehG.getResources().getDimensionPixelSize(R.dimen.ds20), this.ehG.getResources().getDimensionPixelSize(R.dimen.ds10));
                    }
                    aVar.titleText.setText(bVar.title);
                    if (bVar.mkR) {
                        aVar.iUH.setVisibility(8);
                        return;
                    }
                    aVar.iUH.setVisibility(0);
                    aVar.iUH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TiebaStatic.eventStat(g.this.mActivity, "square_category_more", "click", 1, "loc", Integer.valueOf(bVar.mkW));
                            be.bkp().b(g.this.ehG, new String[]{bVar.link});
                        }
                    });
                }
            } else if (itemViewType == 3) {
                Object item2 = getItem(i);
                if (item2 instanceof h.b) {
                    final h.b bVar2 = (h.b) item2;
                    final a aVar2 = (a) view.getTag();
                    if (aVar2 != null) {
                        aVar2.mkE.startLoad(bVar2.kGi, 10, false);
                        aVar2.jjA.setText(bVar2.forumName);
                        aVar2.mkF.setText(bVar2.mkT);
                        aVar2.mkG.setText(bVar2.mkU);
                        long j = bVar2.mkV;
                        if (j < 0) {
                            j = 0;
                        }
                        long j2 = bVar2.threadNum;
                        long j3 = j2 >= 0 ? j2 : 0L;
                        aVar2.mkH.setText(this.ehG.getString(R.string.attention) + at.numFormatOver10000wan(j));
                        aVar2.mkI.setText(this.ehG.getString(R.string.text_post) + at.numFormatOver10000wan(j3));
                        if (bVar2.mkR && !StringUtils.isNull(bVar2.mkS)) {
                            aVar2.mkJ.setText(UtilHelper.getFixedText(bVar2.mkS, 5));
                            aVar2.mkJ.setVisibility(0);
                            aVar2.hQJ.setVisibility(0);
                        } else {
                            aVar2.mkJ.setVisibility(8);
                            aVar2.hQJ.setVisibility(8);
                        }
                        aVar2.mkJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_menu", "click", 1, "loc", Integer.valueOf(bVar2.mkX));
                                be.bkp().b(g.this.ehG, new String[]{bVar2.link});
                            }
                        });
                        aVar2.mkM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(bVar2.mkW), "loc", Integer.valueOf(bVar2.mkX));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.ehG.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
                            }
                        });
                        aVar2.mkL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                aVar2.mkM.performClick();
                            }
                        });
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                TiebaStatic.eventStat(g.this.mActivity, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(bVar2.mkW), "loc", Integer.valueOf(bVar2.mkX));
                                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(g.this.ehG.getPageActivity(), bVar2.forumId + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                                } else {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(g.this.ehG.getPageActivity()).createNormalCfg(bVar2.forumName, FrsActivityConfig.FRS_FROM_SQUARE)));
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void du(View view) {
        if (view != null) {
            if (this.mky == null || this.mky.size() == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int size = this.mky.size();
            int i = size > 4 ? 4 : size;
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < viewArr2.length; i2++) {
                if (i2 < i) {
                    final h.a aVar = this.mky.get(i2);
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
                                tbImageView.startLoad(aVar.mkP, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.title, 5, false));
                            }
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.square.g.7
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (aVar.iNY) {
                                        g.this.dzn();
                                    } else {
                                        be.bkp().b(g.this.ehG, new String[]{aVar.link});
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
    public void dzn() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(this.ehG.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    public void onChangeSkinType(int i) {
        if (this.mkz != null) {
            this.mkz.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a {
        View hQJ;
        TextView iUH;
        TextView jjA;
        BarImageView mkE;
        TextView mkF;
        TextView mkG;
        TextView mkH;
        TextView mkI;
        TextView mkJ;
        RelativeLayout mkK;
        LinearLayout mkL;
        TextView mkM;
        TextView titleText;

        private a() {
        }
    }
}
