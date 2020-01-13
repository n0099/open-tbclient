package com.baidu.tieba.pb.pb.main;

import android.content.Context;
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
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class am extends v.a {
    public boolean Cm;
    private CustomMessageListener cHC;
    public TextLineView iLK;
    public TextLineView iLL;
    public TextView iLM;
    public TextView iLN;
    public View iLO;
    public View iLP;
    public View iLQ;
    public TextLineView iLR;
    private View iLS;
    private View iLT;
    private TextView iLU;
    private com.baidu.tieba.pb.pb.godreply.usertips.a iLV;
    private List<TextLineView> iLW;
    private int iLX;
    private View.OnClickListener iLY;
    private com.baidu.tieba.pb.data.k iLZ;
    private BdUniqueId iMa;
    private BdUniqueId iMb;
    private View.OnClickListener iMc;
    private View.OnClickListener iMd;
    private CustomMessageListener iMe;
    private View mRootView;
    public int mSkinType;

    public am(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.iLV = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.iLX = 0;
        this.Cm = true;
        this.iMc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.am.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (am.this.iLY != null) {
                    am.this.iLY.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : am.this.iLW) {
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
        this.iMd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.am.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (am.this.iLY != null) {
                    am.this.iLY.onClick(view2);
                }
            }
        };
        this.cHC = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.am.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (am.this.iLZ != null && am.this.iLZ.zN == com.baidu.tieba.pb.data.k.iAI && customResponsedMessage != null && getTag() == am.this.iMa && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).iOy = am.this;
                }
            }
        };
        this.iMe = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.am.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (am.this.iLZ != null && am.this.iLZ.zN == com.baidu.tieba.pb.data.k.iAJ && customResponsedMessage != null && getTag() == am.this.iMb && (customResponsedMessage.getData() instanceof aq.a) && am.this.mRootView != null && am.this.iLV.ckm() && am.this.iLN != null && am.this.iLN.getVisibility() == 0) {
                    if (am.this.mRootView == null || am.this.mRootView.getParent() == null) {
                        am.this.iLV.hideTip();
                        return;
                    }
                    if (!am.this.iLV.ckm() && !com.baidu.tieba.pb.pb.godreply.usertips.b.fj(am.this.mRootView.getContext())) {
                        am.this.iLV.showTip(am.this.iLN);
                    }
                    if (am.this.iLV.ckm()) {
                        am.this.iLV.cs(am.this.iLN);
                    }
                }
            }
        };
        if (view != null) {
            this.mRootView = view;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.am.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.iLK = (TextLineView) view.findViewById(R.id.reply_title);
            this.iLK.setOnClickListener(this.iMc);
            this.iLQ = view.findViewById(R.id.reply_god_title_group);
            this.iLR = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.iLR.setSelected(false);
            this.iLT = view.findViewById(R.id.reply_all_title_frame);
            this.iLS = view.findViewById(R.id.reply_all_title);
            this.iLU = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.iLL = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.iLL.setOnClickListener(this.iMc);
            this.iLM = (TextView) view.findViewById(R.id.pb_sort);
            this.iLM.setOnClickListener(this.iMd);
            this.iLN = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.iLK.setSelected(true);
            this.iLL.setSelected(false);
            this.iLW = new ArrayList();
            this.iLW.add(this.iLK);
            this.iLW.add(this.iLL);
            this.iLO = view.findViewById(R.id.divider_with_reply_title);
            this.iLP = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.aPt().aGI()) {
                aV(2, "");
            } else {
                aV(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aV(int i, String str) {
        this.iLX = i;
        this.iLM.setVisibility(0);
        if (str.length() > 0) {
            this.iLM.setText(str);
        } else if (this.iLX == 0) {
            this.iLM.setText(R.string.default_sort);
        } else if (this.iLX == 1) {
            this.iLM.setText(R.string.view_reverse);
        } else if (this.iLX == 2) {
            this.iLM.setText(R.string.view_hot);
        }
    }

    public void qb(boolean z) {
        if (z) {
            this.iLL.setSelected(true);
            this.iLK.setSelected(false);
            return;
        }
        this.iLL.setSelected(false);
        this.iLK.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.k kVar) {
        this.iLZ = kVar;
        if (kVar != null) {
            if (kVar.zN == com.baidu.tieba.pb.data.k.iAJ) {
                final Context context = this.iLQ.getContext();
                if (TextUtils.isEmpty(kVar.iAL)) {
                    this.iLT.setVisibility(0);
                    this.iLQ.setVisibility(8);
                    this.iLK.setVisibility(0);
                    this.iLK.setSelected(false);
                    this.iLK.setClickable(false);
                    this.iLK.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.iLT.setVisibility(8);
                    this.iLK.setVisibility(8);
                    this.iLQ.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.am.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.k(context, true);
                            am.this.iLV.hideTip();
                            if (am.this.iLY != null) {
                                am.this.iLY.onClick(am.this.iLQ);
                            }
                        }
                    };
                    this.iLQ.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.fj(context) && this.iLN != null && this.iLN.getVisibility() == 0 && !this.iLV.ckm()) {
                        this.iLV.P(onClickListener);
                        this.iLV.showTip(this.iLN);
                    }
                }
                this.iLM.setVisibility(8);
                this.iLL.setVisibility(8);
                this.iLP.setVisibility(8);
            } else if (kVar.zN == com.baidu.tieba.pb.data.k.iAI) {
                this.iLQ.setVisibility(8);
                this.iLT.setVisibility(0);
                this.iLK.setClickable(true);
                this.iLK.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.iLM.setVisibility(0);
                this.iLL.setVisibility(0);
                qb(kVar.iAN);
                aV(kVar.sortType, kVar.iAM);
                this.iLP.setVisibility(0);
            }
            if (this.Cm) {
                this.iLP.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iLT, R.color.cp_bg_line_h);
            } else {
                this.iLP.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iLT, R.color.cp_bg_line_e);
            }
            if (kVar.isDynamic) {
                this.iLU.setVisibility(0);
                this.iLS.setVisibility(8);
            } else {
                this.iLU.setVisibility(8);
                this.iLS.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iLT, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iLQ, R.color.cp_bg_line_d);
            this.iLK.onChangeSkinType(i);
            this.iLL.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iLR, (int) R.color.cp_cont_b);
            if (this.iLZ != null && this.iLZ.zN == com.baidu.tieba.pb.data.k.iAJ) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iLK, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iLN, (int) R.color.cp_cont_j);
            this.iLN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iLM, (int) R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iLO, R.color.cp_bg_line_b);
            this.iLM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            this.iLV.onChangeSkinType(i);
            if (this.Cm) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iLP, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iLT, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iLT, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iLU, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.iMa = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.cHC.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cHC);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.iMb = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.iMe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iMe);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.iLY = onClickListener;
    }
}
