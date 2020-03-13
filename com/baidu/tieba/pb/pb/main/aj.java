package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.an;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class aj extends v.a {
    public boolean CF;
    private CustomMessageListener cLH;
    public TextLineView iNA;
    private View iNB;
    private View iNC;
    private TextView iND;
    private List<TextLineView> iNE;
    private int iNF;
    private View.OnClickListener iNG;
    private com.baidu.tieba.pb.data.j iNH;
    private BdUniqueId iNI;
    private BdUniqueId iNJ;
    private View.OnClickListener iNK;
    private View.OnClickListener iNL;
    private CustomMessageListener iNM;
    public TextLineView iNt;
    public TextLineView iNu;
    public TextView iNv;
    public TextView iNw;
    public View iNx;
    public View iNy;
    public View iNz;
    private View mRootView;
    public int mSkinType;

    public aj(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.iNF = 0;
        this.CF = true;
        this.iNK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aj.this.iNG != null) {
                    aj.this.iNG.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : aj.this.iNE) {
                            if (textLineView != null) {
                                if (textLineView != view2) {
                                    textLineView.setSelected(false);
                                } else {
                                    textLineView.setSelected(true);
                                }
                            }
                        }
                    }
                }
            }
        };
        this.iNL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aj.this.iNG != null) {
                    aj.this.iNG.onClick(view2);
                }
            }
        };
        this.cLH = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aj.this.iNH != null && aj.this.iNH.Ag == com.baidu.tieba.pb.data.j.iCP && customResponsedMessage != null && getTag() == aj.this.iNI && (customResponsedMessage.getData() instanceof an.a)) {
                    ((an.a) customResponsedMessage.getData()).iQh = aj.this;
                }
            }
        };
        this.iNM = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aj.this.iNH == null || aj.this.iNH.Ag != com.baidu.tieba.pb.data.j.iCQ || customResponsedMessage == null || getTag() != aj.this.iNJ || !(customResponsedMessage.getData() instanceof an.a)) {
                }
            }
        };
        if (view != null) {
            this.mRootView = view;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.iNt = (TextLineView) view.findViewById(R.id.reply_title);
            this.iNt.setOnClickListener(this.iNK);
            this.iNz = view.findViewById(R.id.reply_god_title_group);
            this.iNA = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.iNA.setSelected(false);
            this.iNC = view.findViewById(R.id.reply_all_title_frame);
            this.iNB = view.findViewById(R.id.reply_all_title);
            this.iND = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.iNu = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.iNu.setOnClickListener(this.iNK);
            this.iNv = (TextView) view.findViewById(R.id.pb_sort);
            this.iNv.setOnClickListener(this.iNL);
            this.iNw = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.iNt.setSelected(true);
            this.iNu.setSelected(false);
            this.iNE = new ArrayList();
            this.iNE.add(this.iNt);
            this.iNE.add(this.iNu);
            this.iNx = view.findViewById(R.id.divider_with_reply_title);
            this.iNy = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.aRM().aIZ()) {
                aV(2, "");
            } else {
                aV(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aV(int i, String str) {
        this.iNF = i;
        this.iNv.setVisibility(0);
        if (str.length() > 0) {
            this.iNv.setText(str);
        } else if (this.iNF == 0) {
            this.iNv.setText(R.string.default_sort);
        } else if (this.iNF == 1) {
            this.iNv.setText(R.string.view_reverse);
        } else if (this.iNF == 2) {
            this.iNv.setText(R.string.view_hot);
        }
    }

    public void qe(boolean z) {
        if (z) {
            this.iNu.setSelected(true);
            this.iNt.setSelected(false);
            return;
        }
        this.iNu.setSelected(false);
        this.iNt.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.iNH = jVar;
        if (jVar != null) {
            if (jVar.Ag == com.baidu.tieba.pb.data.j.iCQ) {
                this.iNz.getContext();
                if (TextUtils.isEmpty(jVar.iCS)) {
                    this.iNC.setVisibility(0);
                    this.iNz.setVisibility(8);
                    this.iNt.setVisibility(0);
                    this.iNt.setSelected(false);
                    this.iNt.setClickable(false);
                    this.iNt.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.iNC.setVisibility(8);
                    this.iNt.setVisibility(8);
                    this.iNz.setVisibility(0);
                    this.iNz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (aj.this.iNG != null) {
                                aj.this.iNG.onClick(aj.this.iNz);
                            }
                        }
                    });
                }
                this.iNv.setVisibility(8);
                this.iNu.setVisibility(8);
                this.iNy.setVisibility(8);
            } else if (jVar.Ag == com.baidu.tieba.pb.data.j.iCP) {
                this.iNz.setVisibility(8);
                this.iNC.setVisibility(0);
                this.iNt.setClickable(true);
                this.iNt.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.iNv.setVisibility(0);
                this.iNu.setVisibility(0);
                qe(jVar.iCU);
                aV(jVar.sortType, jVar.iCT);
                this.iNy.setVisibility(0);
            }
            if (this.CF) {
                this.iNy.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNC, R.color.cp_bg_line_h);
            } else {
                this.iNy.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNC, R.color.cp_bg_line_e);
            }
            if (jVar.isDynamic) {
                this.iND.setVisibility(0);
                this.iNB.setVisibility(8);
            } else {
                this.iND.setVisibility(8);
                this.iNB.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNC, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNz, R.color.cp_bg_line_d);
            this.iNt.onChangeSkinType(i);
            this.iNu.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNA, (int) R.color.cp_cont_b);
            if (this.iNH != null && this.iNH.Ag == com.baidu.tieba.pb.data.j.iCQ) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iNt, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNw, (int) R.color.cp_cont_j);
            this.iNw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNv, (int) R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNx, R.color.cp_bg_line_b);
            this.iNv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            if (this.CF) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iNy, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNC, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNC, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iND, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.iNI = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.cLH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cLH);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.iNJ = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.iNM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iNM);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.iNG = onClickListener;
    }
}
