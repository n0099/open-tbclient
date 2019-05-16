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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class al extends v.a {
    public boolean PU;
    private CustomMessageListener bCA;
    public TextView hMA;
    public View hMB;
    public View hMC;
    public View hMD;
    public TextLineView hME;
    public View hMF;
    private com.baidu.tieba.pb.pb.godreply.usertips.a hMG;
    private List<TextLineView> hMH;
    private int hMI;
    private View.OnClickListener hMJ;
    private com.baidu.tieba.pb.data.i hMK;
    private BdUniqueId hML;
    private BdUniqueId hMM;
    private View.OnClickListener hMN;
    private View.OnClickListener hMO;
    private CustomMessageListener hMP;
    public TextLineView hMx;
    public TextLineView hMy;
    public TextView hMz;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hMG = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.hMI = 0;
        this.PU = true;
        this.hMN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hMJ != null) {
                    al.this.hMJ.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.jS()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.hMH) {
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
        this.hMO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hMJ != null) {
                    al.this.hMJ.onClick(view2);
                }
            }
        };
        this.bCA = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hMK != null && al.this.hMK.mType == com.baidu.tieba.pb.data.i.hBU && customResponsedMessage != null && getTag() == al.this.hML && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).hQc = al.this;
                }
            }
        };
        this.hMP = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hMK != null && al.this.hMK.mType == com.baidu.tieba.pb.data.i.hBV && customResponsedMessage != null && getTag() == al.this.hMM && (customResponsedMessage.getData() instanceof aq.a) && al.this.mRootView != null && al.this.hMG.bQY() && al.this.hMA != null && al.this.hMA.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.hMG.hideTip();
                        return;
                    }
                    if (!al.this.hMG.bQY() && !com.baidu.tieba.pb.pb.godreply.usertips.b.ed(al.this.mRootView.getContext())) {
                        al.this.hMG.showTip(al.this.hMA);
                    }
                    if (al.this.hMG.bQY()) {
                        al.this.hMG.cr(al.this.hMA);
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
            this.hMx = (TextLineView) view.findViewById(R.id.reply_title);
            this.hMx.setOnClickListener(this.hMN);
            this.hMD = view.findViewById(R.id.reply_god_title_group);
            this.hME = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.hME.setSelected(false);
            this.hMF = view.findViewById(R.id.reply_all_title);
            this.hMy = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.hMy.setOnClickListener(this.hMN);
            this.hMz = (TextView) view.findViewById(R.id.pb_sort);
            this.hMz.setOnClickListener(this.hMO);
            this.hMA = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.hMx.setSelected(true);
            this.hMy.setSelected(false);
            this.hMH = new ArrayList();
            this.hMH.add(this.hMx);
            this.hMH.add(this.hMy);
            this.hMB = view.findViewById(R.id.divider_with_reply_title);
            this.hMC = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.auN().akJ()) {
                aB(2, "");
            } else {
                aB(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aB(int i, String str) {
        this.hMI = i;
        this.hMz.setVisibility(0);
        if (str.length() > 0) {
            this.hMz.setText(str);
        } else if (this.hMI == 0) {
            this.hMz.setText(R.string.default_sort);
        } else if (this.hMI == 1) {
            this.hMz.setText(R.string.view_reverse);
        } else if (this.hMI == 2) {
            this.hMz.setText(R.string.view_hot);
        }
    }

    public void ox(boolean z) {
        if (z) {
            this.hMy.setSelected(true);
            this.hMx.setSelected(false);
            return;
        }
        this.hMy.setSelected(false);
        this.hMx.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.i iVar) {
        this.hMK = iVar;
        if (iVar != null) {
            if (iVar.mType == com.baidu.tieba.pb.data.i.hBV) {
                final Context context = this.hMD.getContext();
                if (TextUtils.isEmpty(iVar.hBX)) {
                    this.hMF.setVisibility(0);
                    this.hMD.setVisibility(8);
                    this.hMx.setVisibility(0);
                    this.hMx.setSelected(false);
                    this.hMx.setClickable(false);
                    this.hMx.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.hMF.setVisibility(8);
                    this.hMx.setVisibility(8);
                    this.hMD.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.j(context, true);
                            al.this.hMG.hideTip();
                            if (al.this.hMJ != null) {
                                al.this.hMJ.onClick(al.this.hMD);
                            }
                        }
                    };
                    this.hMD.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.ed(context) && this.hMA != null && this.hMA.getVisibility() == 0 && !this.hMG.bQY()) {
                        this.hMG.M(onClickListener);
                        this.hMG.showTip(this.hMA);
                    }
                }
                this.hMz.setVisibility(8);
                this.hMy.setVisibility(8);
                this.hMC.setVisibility(8);
            } else if (iVar.mType == com.baidu.tieba.pb.data.i.hBU) {
                this.hMD.setVisibility(8);
                this.hMF.setVisibility(0);
                this.hMx.setClickable(true);
                this.hMx.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.hMz.setVisibility(0);
                this.hMy.setVisibility(0);
                ox(iVar.hBZ);
                aB(iVar.sortType, iVar.hBY);
                this.hMC.setVisibility(0);
            }
            if (this.PU) {
                this.hMC.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
            } else {
                this.hMC.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds2);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.l(this.hMF, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.l(this.hMD, R.color.cp_bg_line_d);
            this.hMx.onChangeSkinType(i);
            this.hMy.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.j(this.hME, R.color.cp_cont_b);
            if (this.hMK != null && this.hMK.mType == com.baidu.tieba.pb.data.i.hBV) {
                com.baidu.tbadk.core.util.al.f(this.hMx, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.j(this.hMA, R.color.cp_cont_j);
            this.hMA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.j(this.hMz, R.color.cp_cont_j);
            com.baidu.tbadk.core.util.al.l(this.hMB, R.color.cp_bg_line_e);
            this.hMz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_pb_sort), (Drawable) null);
            this.hMG.onChangeSkinType(i);
            if (this.PU) {
                com.baidu.tbadk.core.util.al.k(this.hMC, R.drawable.top_shadow);
            } else {
                com.baidu.tbadk.core.util.al.l(this.hMC, R.color.cp_bg_line_c);
            }
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.hML = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.bCA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bCA);
    }

    public void q(BdUniqueId bdUniqueId) {
        this.hMM = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.hMP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hMP);
    }

    public void N(View.OnClickListener onClickListener) {
        this.hMJ = onClickListener;
    }
}
