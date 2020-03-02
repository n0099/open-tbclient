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
    private CustomMessageListener cLG;
    private CustomMessageListener iNA;
    public TextLineView iNh;
    public TextLineView iNi;
    public TextView iNj;
    public TextView iNk;
    public View iNl;
    public View iNm;
    public View iNn;
    public TextLineView iNo;
    private View iNp;
    private View iNq;
    private TextView iNr;
    private List<TextLineView> iNs;
    private int iNt;
    private View.OnClickListener iNu;
    private com.baidu.tieba.pb.data.j iNv;
    private BdUniqueId iNw;
    private BdUniqueId iNx;
    private View.OnClickListener iNy;
    private View.OnClickListener iNz;
    private View mRootView;
    public int mSkinType;

    public aj(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.iNt = 0;
        this.CF = true;
        this.iNy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aj.this.iNu != null) {
                    aj.this.iNu.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : aj.this.iNs) {
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
        this.iNz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aj.this.iNu != null) {
                    aj.this.iNu.onClick(view2);
                }
            }
        };
        this.cLG = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aj.this.iNv != null && aj.this.iNv.Ag == com.baidu.tieba.pb.data.j.iCD && customResponsedMessage != null && getTag() == aj.this.iNw && (customResponsedMessage.getData() instanceof an.a)) {
                    ((an.a) customResponsedMessage.getData()).iPV = aj.this;
                }
            }
        };
        this.iNA = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aj.this.iNv == null || aj.this.iNv.Ag != com.baidu.tieba.pb.data.j.iCE || customResponsedMessage == null || getTag() != aj.this.iNx || !(customResponsedMessage.getData() instanceof an.a)) {
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
            this.iNh = (TextLineView) view.findViewById(R.id.reply_title);
            this.iNh.setOnClickListener(this.iNy);
            this.iNn = view.findViewById(R.id.reply_god_title_group);
            this.iNo = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.iNo.setSelected(false);
            this.iNq = view.findViewById(R.id.reply_all_title_frame);
            this.iNp = view.findViewById(R.id.reply_all_title);
            this.iNr = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.iNi = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.iNi.setOnClickListener(this.iNy);
            this.iNj = (TextView) view.findViewById(R.id.pb_sort);
            this.iNj.setOnClickListener(this.iNz);
            this.iNk = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.iNh.setSelected(true);
            this.iNi.setSelected(false);
            this.iNs = new ArrayList();
            this.iNs.add(this.iNh);
            this.iNs.add(this.iNi);
            this.iNl = view.findViewById(R.id.divider_with_reply_title);
            this.iNm = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.aRL().aIY()) {
                aV(2, "");
            } else {
                aV(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aV(int i, String str) {
        this.iNt = i;
        this.iNj.setVisibility(0);
        if (str.length() > 0) {
            this.iNj.setText(str);
        } else if (this.iNt == 0) {
            this.iNj.setText(R.string.default_sort);
        } else if (this.iNt == 1) {
            this.iNj.setText(R.string.view_reverse);
        } else if (this.iNt == 2) {
            this.iNj.setText(R.string.view_hot);
        }
    }

    public void qe(boolean z) {
        if (z) {
            this.iNi.setSelected(true);
            this.iNh.setSelected(false);
            return;
        }
        this.iNi.setSelected(false);
        this.iNh.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.iNv = jVar;
        if (jVar != null) {
            if (jVar.Ag == com.baidu.tieba.pb.data.j.iCE) {
                this.iNn.getContext();
                if (TextUtils.isEmpty(jVar.iCG)) {
                    this.iNq.setVisibility(0);
                    this.iNn.setVisibility(8);
                    this.iNh.setVisibility(0);
                    this.iNh.setSelected(false);
                    this.iNh.setClickable(false);
                    this.iNh.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.iNq.setVisibility(8);
                    this.iNh.setVisibility(8);
                    this.iNn.setVisibility(0);
                    this.iNn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (aj.this.iNu != null) {
                                aj.this.iNu.onClick(aj.this.iNn);
                            }
                        }
                    });
                }
                this.iNj.setVisibility(8);
                this.iNi.setVisibility(8);
                this.iNm.setVisibility(8);
            } else if (jVar.Ag == com.baidu.tieba.pb.data.j.iCD) {
                this.iNn.setVisibility(8);
                this.iNq.setVisibility(0);
                this.iNh.setClickable(true);
                this.iNh.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.iNj.setVisibility(0);
                this.iNi.setVisibility(0);
                qe(jVar.iCI);
                aV(jVar.sortType, jVar.iCH);
                this.iNm.setVisibility(0);
            }
            if (this.CF) {
                this.iNm.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNq, R.color.cp_bg_line_h);
            } else {
                this.iNm.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNq, R.color.cp_bg_line_e);
            }
            if (jVar.isDynamic) {
                this.iNr.setVisibility(0);
                this.iNp.setVisibility(8);
            } else {
                this.iNr.setVisibility(8);
                this.iNp.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNq, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNn, R.color.cp_bg_line_d);
            this.iNh.onChangeSkinType(i);
            this.iNi.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNo, (int) R.color.cp_cont_b);
            if (this.iNv != null && this.iNv.Ag == com.baidu.tieba.pb.data.j.iCE) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iNh, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNk, (int) R.color.cp_cont_j);
            this.iNk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNj, (int) R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNl, R.color.cp_bg_line_b);
            this.iNj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            if (this.CF) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iNm, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNq, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNq, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNr, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.iNw = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.cLG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cLG);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.iNx = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.iNA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iNA);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.iNu = onClickListener;
    }
}
