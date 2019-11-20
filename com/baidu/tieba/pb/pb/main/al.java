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
/* loaded from: classes4.dex */
public class al extends v.a {
    private CustomMessageListener bVa;
    public TextView hTA;
    public TextView hTB;
    public View hTC;
    public View hTD;
    public View hTE;
    public TextLineView hTF;
    public View hTG;
    private com.baidu.tieba.pb.pb.godreply.usertips.a hTH;
    private List<TextLineView> hTI;
    private int hTJ;
    private View.OnClickListener hTK;
    private com.baidu.tieba.pb.data.i hTL;
    private BdUniqueId hTM;
    private BdUniqueId hTN;
    private View.OnClickListener hTO;
    private View.OnClickListener hTP;
    private CustomMessageListener hTQ;
    public TextLineView hTy;
    public TextLineView hTz;
    private View mRootView;
    public int mSkinType;
    public boolean zC;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hTH = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.hTJ = 0;
        this.zC = true;
        this.hTO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hTK != null) {
                    al.this.hTK.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.hTI) {
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
        this.hTP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hTK != null) {
                    al.this.hTK.onClick(view2);
                }
            }
        };
        this.bVa = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hTL != null && al.this.hTL.xl == com.baidu.tieba.pb.data.i.hIQ && customResponsedMessage != null && getTag() == al.this.hTM && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).hXd = al.this;
                }
            }
        };
        this.hTQ = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hTL != null && al.this.hTL.xl == com.baidu.tieba.pb.data.i.hIR && customResponsedMessage != null && getTag() == al.this.hTN && (customResponsedMessage.getData() instanceof aq.a) && al.this.mRootView != null && al.this.hTH.bRO() && al.this.hTB != null && al.this.hTB.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.hTH.hideTip();
                        return;
                    }
                    if (!al.this.hTH.bRO() && !com.baidu.tieba.pb.pb.godreply.usertips.b.dS(al.this.mRootView.getContext())) {
                        al.this.hTH.showTip(al.this.hTB);
                    }
                    if (al.this.hTH.bRO()) {
                        al.this.hTH.cr(al.this.hTB);
                    }
                }
            }
        };
        if (view != null) {
            this.mRootView = view;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.hTy = (TextLineView) view.findViewById(R.id.reply_title);
            this.hTy.setOnClickListener(this.hTO);
            this.hTE = view.findViewById(R.id.reply_god_title_group);
            this.hTF = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.hTF.setSelected(false);
            this.hTG = view.findViewById(R.id.reply_all_title);
            this.hTz = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.hTz.setOnClickListener(this.hTO);
            this.hTA = (TextView) view.findViewById(R.id.pb_sort);
            this.hTA.setOnClickListener(this.hTP);
            this.hTB = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.hTy.setSelected(true);
            this.hTz.setSelected(false);
            this.hTI = new ArrayList();
            this.hTI.add(this.hTy);
            this.hTI.add(this.hTz);
            this.hTC = view.findViewById(R.id.divider_with_reply_title);
            this.hTD = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.axn().aoN()) {
                aA(2, "");
            } else {
                aA(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aA(int i, String str) {
        this.hTJ = i;
        this.hTA.setVisibility(0);
        if (str.length() > 0) {
            this.hTA.setText(str);
        } else if (this.hTJ == 0) {
            this.hTA.setText(R.string.default_sort);
        } else if (this.hTJ == 1) {
            this.hTA.setText(R.string.view_reverse);
        } else if (this.hTJ == 2) {
            this.hTA.setText(R.string.view_hot);
        }
    }

    public void oz(boolean z) {
        if (z) {
            this.hTz.setSelected(true);
            this.hTy.setSelected(false);
            return;
        }
        this.hTz.setSelected(false);
        this.hTy.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.i iVar) {
        this.hTL = iVar;
        if (iVar != null) {
            if (iVar.xl == com.baidu.tieba.pb.data.i.hIR) {
                final Context context = this.hTE.getContext();
                if (TextUtils.isEmpty(iVar.hIT)) {
                    this.hTG.setVisibility(0);
                    this.hTE.setVisibility(8);
                    this.hTy.setVisibility(0);
                    this.hTy.setSelected(false);
                    this.hTy.setClickable(false);
                    this.hTy.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.hTG.setVisibility(8);
                    this.hTy.setVisibility(8);
                    this.hTE.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.j(context, true);
                            al.this.hTH.hideTip();
                            if (al.this.hTK != null) {
                                al.this.hTK.onClick(al.this.hTE);
                            }
                        }
                    };
                    this.hTE.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.dS(context) && this.hTB != null && this.hTB.getVisibility() == 0 && !this.hTH.bRO()) {
                        this.hTH.P(onClickListener);
                        this.hTH.showTip(this.hTB);
                    }
                }
                this.hTA.setVisibility(8);
                this.hTz.setVisibility(8);
                this.hTD.setVisibility(8);
            } else if (iVar.xl == com.baidu.tieba.pb.data.i.hIQ) {
                this.hTE.setVisibility(8);
                this.hTG.setVisibility(0);
                this.hTy.setClickable(true);
                this.hTy.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.hTA.setVisibility(0);
                this.hTz.setVisibility(0);
                oz(iVar.hIV);
                aA(iVar.sortType, iVar.hIU);
                this.hTD.setVisibility(0);
            }
            if (this.zC) {
                this.hTD.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hTG, R.color.cp_bg_line_h);
            } else {
                this.hTD.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hTG, R.color.cp_bg_line_e);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hTG, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hTE, R.color.cp_bg_line_d);
            this.hTy.onChangeSkinType(i);
            this.hTz.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTF, (int) R.color.cp_cont_b);
            if (this.hTL != null && this.hTL.xl == com.baidu.tieba.pb.data.i.hIR) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hTy, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTB, (int) R.color.cp_cont_j);
            this.hTB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTA, (int) R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hTC, R.color.cp_bg_line_c);
            this.hTA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            this.hTH.onChangeSkinType(i);
            if (this.zC) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hTD, R.drawable.top_shadow);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hTG, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hTG, R.color.cp_bg_line_e);
            }
        }
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.hTM = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.bVa.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bVa);
    }

    public void r(BdUniqueId bdUniqueId) {
        this.hTN = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.hTQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hTQ);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.hTK = onClickListener;
    }
}
