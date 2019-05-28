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
    public TextLineView hMA;
    public TextLineView hMB;
    public TextView hMC;
    public TextView hMD;
    public View hME;
    public View hMF;
    public View hMG;
    public TextLineView hMH;
    public View hMI;
    private com.baidu.tieba.pb.pb.godreply.usertips.a hMJ;
    private List<TextLineView> hMK;
    private int hML;
    private View.OnClickListener hMM;
    private com.baidu.tieba.pb.data.i hMN;
    private BdUniqueId hMO;
    private BdUniqueId hMP;
    private View.OnClickListener hMQ;
    private View.OnClickListener hMR;
    private CustomMessageListener hMS;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hMJ = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.hML = 0;
        this.PU = true;
        this.hMQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hMM != null) {
                    al.this.hMM.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.jS()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.hMK) {
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
        this.hMR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hMM != null) {
                    al.this.hMM.onClick(view2);
                }
            }
        };
        this.bCA = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hMN != null && al.this.hMN.mType == com.baidu.tieba.pb.data.i.hBX && customResponsedMessage != null && getTag() == al.this.hMO && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).hQf = al.this;
                }
            }
        };
        this.hMS = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hMN != null && al.this.hMN.mType == com.baidu.tieba.pb.data.i.hBY && customResponsedMessage != null && getTag() == al.this.hMP && (customResponsedMessage.getData() instanceof aq.a) && al.this.mRootView != null && al.this.hMJ.bRb() && al.this.hMD != null && al.this.hMD.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.hMJ.hideTip();
                        return;
                    }
                    if (!al.this.hMJ.bRb() && !com.baidu.tieba.pb.pb.godreply.usertips.b.ed(al.this.mRootView.getContext())) {
                        al.this.hMJ.showTip(al.this.hMD);
                    }
                    if (al.this.hMJ.bRb()) {
                        al.this.hMJ.cr(al.this.hMD);
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
            this.hMA = (TextLineView) view.findViewById(R.id.reply_title);
            this.hMA.setOnClickListener(this.hMQ);
            this.hMG = view.findViewById(R.id.reply_god_title_group);
            this.hMH = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.hMH.setSelected(false);
            this.hMI = view.findViewById(R.id.reply_all_title);
            this.hMB = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.hMB.setOnClickListener(this.hMQ);
            this.hMC = (TextView) view.findViewById(R.id.pb_sort);
            this.hMC.setOnClickListener(this.hMR);
            this.hMD = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.hMA.setSelected(true);
            this.hMB.setSelected(false);
            this.hMK = new ArrayList();
            this.hMK.add(this.hMA);
            this.hMK.add(this.hMB);
            this.hME = view.findViewById(R.id.divider_with_reply_title);
            this.hMF = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.auN().akJ()) {
                aB(2, "");
            } else {
                aB(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aB(int i, String str) {
        this.hML = i;
        this.hMC.setVisibility(0);
        if (str.length() > 0) {
            this.hMC.setText(str);
        } else if (this.hML == 0) {
            this.hMC.setText(R.string.default_sort);
        } else if (this.hML == 1) {
            this.hMC.setText(R.string.view_reverse);
        } else if (this.hML == 2) {
            this.hMC.setText(R.string.view_hot);
        }
    }

    public void ox(boolean z) {
        if (z) {
            this.hMB.setSelected(true);
            this.hMA.setSelected(false);
            return;
        }
        this.hMB.setSelected(false);
        this.hMA.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.i iVar) {
        this.hMN = iVar;
        if (iVar != null) {
            if (iVar.mType == com.baidu.tieba.pb.data.i.hBY) {
                final Context context = this.hMG.getContext();
                if (TextUtils.isEmpty(iVar.hCa)) {
                    this.hMI.setVisibility(0);
                    this.hMG.setVisibility(8);
                    this.hMA.setVisibility(0);
                    this.hMA.setSelected(false);
                    this.hMA.setClickable(false);
                    this.hMA.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.hMI.setVisibility(8);
                    this.hMA.setVisibility(8);
                    this.hMG.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.j(context, true);
                            al.this.hMJ.hideTip();
                            if (al.this.hMM != null) {
                                al.this.hMM.onClick(al.this.hMG);
                            }
                        }
                    };
                    this.hMG.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.ed(context) && this.hMD != null && this.hMD.getVisibility() == 0 && !this.hMJ.bRb()) {
                        this.hMJ.M(onClickListener);
                        this.hMJ.showTip(this.hMD);
                    }
                }
                this.hMC.setVisibility(8);
                this.hMB.setVisibility(8);
                this.hMF.setVisibility(8);
            } else if (iVar.mType == com.baidu.tieba.pb.data.i.hBX) {
                this.hMG.setVisibility(8);
                this.hMI.setVisibility(0);
                this.hMA.setClickable(true);
                this.hMA.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.hMC.setVisibility(0);
                this.hMB.setVisibility(0);
                ox(iVar.hCc);
                aB(iVar.sortType, iVar.hCb);
                this.hMF.setVisibility(0);
            }
            if (this.PU) {
                this.hMF.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
            } else {
                this.hMF.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds2);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.l(this.hMI, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.l(this.hMG, R.color.cp_bg_line_d);
            this.hMA.onChangeSkinType(i);
            this.hMB.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.j(this.hMH, R.color.cp_cont_b);
            if (this.hMN != null && this.hMN.mType == com.baidu.tieba.pb.data.i.hBY) {
                com.baidu.tbadk.core.util.al.f(this.hMA, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.j(this.hMD, R.color.cp_cont_j);
            this.hMD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.j(this.hMC, R.color.cp_cont_j);
            com.baidu.tbadk.core.util.al.l(this.hME, R.color.cp_bg_line_e);
            this.hMC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_pb_sort), (Drawable) null);
            this.hMJ.onChangeSkinType(i);
            if (this.PU) {
                com.baidu.tbadk.core.util.al.k(this.hMF, R.drawable.top_shadow);
            } else {
                com.baidu.tbadk.core.util.al.l(this.hMF, R.color.cp_bg_line_c);
            }
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.hMO = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.bCA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bCA);
    }

    public void q(BdUniqueId bdUniqueId) {
        this.hMP = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.hMS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hMS);
    }

    public void N(View.OnClickListener onClickListener) {
        this.hMM = onClickListener;
    }
}
