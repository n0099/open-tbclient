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
    private CustomMessageListener cLF;
    public TextLineView iNf;
    public TextLineView iNg;
    public TextView iNh;
    public TextView iNi;
    public View iNj;
    public View iNk;
    public View iNl;
    public TextLineView iNm;
    private View iNn;
    private View iNo;
    private TextView iNp;
    private List<TextLineView> iNq;
    private int iNr;
    private View.OnClickListener iNs;
    private com.baidu.tieba.pb.data.j iNt;
    private BdUniqueId iNu;
    private BdUniqueId iNv;
    private View.OnClickListener iNw;
    private View.OnClickListener iNx;
    private CustomMessageListener iNy;
    private View mRootView;
    public int mSkinType;

    public aj(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.iNr = 0;
        this.CF = true;
        this.iNw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aj.this.iNs != null) {
                    aj.this.iNs.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : aj.this.iNq) {
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
        this.iNx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aj.this.iNs != null) {
                    aj.this.iNs.onClick(view2);
                }
            }
        };
        this.cLF = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aj.this.iNt != null && aj.this.iNt.Ag == com.baidu.tieba.pb.data.j.iCB && customResponsedMessage != null && getTag() == aj.this.iNu && (customResponsedMessage.getData() instanceof an.a)) {
                    ((an.a) customResponsedMessage.getData()).iPT = aj.this;
                }
            }
        };
        this.iNy = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aj.this.iNt == null || aj.this.iNt.Ag != com.baidu.tieba.pb.data.j.iCC || customResponsedMessage == null || getTag() != aj.this.iNv || !(customResponsedMessage.getData() instanceof an.a)) {
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
            this.iNf = (TextLineView) view.findViewById(R.id.reply_title);
            this.iNf.setOnClickListener(this.iNw);
            this.iNl = view.findViewById(R.id.reply_god_title_group);
            this.iNm = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.iNm.setSelected(false);
            this.iNo = view.findViewById(R.id.reply_all_title_frame);
            this.iNn = view.findViewById(R.id.reply_all_title);
            this.iNp = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.iNg = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.iNg.setOnClickListener(this.iNw);
            this.iNh = (TextView) view.findViewById(R.id.pb_sort);
            this.iNh.setOnClickListener(this.iNx);
            this.iNi = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.iNf.setSelected(true);
            this.iNg.setSelected(false);
            this.iNq = new ArrayList();
            this.iNq.add(this.iNf);
            this.iNq.add(this.iNg);
            this.iNj = view.findViewById(R.id.divider_with_reply_title);
            this.iNk = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.aRJ().aIW()) {
                aV(2, "");
            } else {
                aV(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aV(int i, String str) {
        this.iNr = i;
        this.iNh.setVisibility(0);
        if (str.length() > 0) {
            this.iNh.setText(str);
        } else if (this.iNr == 0) {
            this.iNh.setText(R.string.default_sort);
        } else if (this.iNr == 1) {
            this.iNh.setText(R.string.view_reverse);
        } else if (this.iNr == 2) {
            this.iNh.setText(R.string.view_hot);
        }
    }

    public void qe(boolean z) {
        if (z) {
            this.iNg.setSelected(true);
            this.iNf.setSelected(false);
            return;
        }
        this.iNg.setSelected(false);
        this.iNf.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.iNt = jVar;
        if (jVar != null) {
            if (jVar.Ag == com.baidu.tieba.pb.data.j.iCC) {
                this.iNl.getContext();
                if (TextUtils.isEmpty(jVar.iCE)) {
                    this.iNo.setVisibility(0);
                    this.iNl.setVisibility(8);
                    this.iNf.setVisibility(0);
                    this.iNf.setSelected(false);
                    this.iNf.setClickable(false);
                    this.iNf.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.iNo.setVisibility(8);
                    this.iNf.setVisibility(8);
                    this.iNl.setVisibility(0);
                    this.iNl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (aj.this.iNs != null) {
                                aj.this.iNs.onClick(aj.this.iNl);
                            }
                        }
                    });
                }
                this.iNh.setVisibility(8);
                this.iNg.setVisibility(8);
                this.iNk.setVisibility(8);
            } else if (jVar.Ag == com.baidu.tieba.pb.data.j.iCB) {
                this.iNl.setVisibility(8);
                this.iNo.setVisibility(0);
                this.iNf.setClickable(true);
                this.iNf.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.iNh.setVisibility(0);
                this.iNg.setVisibility(0);
                qe(jVar.iCG);
                aV(jVar.sortType, jVar.iCF);
                this.iNk.setVisibility(0);
            }
            if (this.CF) {
                this.iNk.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNo, R.color.cp_bg_line_h);
            } else {
                this.iNk.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNo, R.color.cp_bg_line_e);
            }
            if (jVar.isDynamic) {
                this.iNp.setVisibility(0);
                this.iNn.setVisibility(8);
            } else {
                this.iNp.setVisibility(8);
                this.iNn.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNo, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNl, R.color.cp_bg_line_d);
            this.iNf.onChangeSkinType(i);
            this.iNg.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNm, (int) R.color.cp_cont_b);
            if (this.iNt != null && this.iNt.Ag == com.baidu.tieba.pb.data.j.iCC) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iNf, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNi, (int) R.color.cp_cont_j);
            this.iNi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNh, (int) R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNj, R.color.cp_bg_line_b);
            this.iNh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            if (this.CF) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iNk, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNo, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNo, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNp, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.iNu = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.cLF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cLF);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.iNv = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.iNy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iNy);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.iNs = onClickListener;
    }
}
