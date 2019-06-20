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
    public boolean PT;
    private CustomMessageListener bCB;
    public TextLineView hMB;
    public TextLineView hMC;
    public TextView hMD;
    public TextView hME;
    public View hMF;
    public View hMG;
    public View hMH;
    public TextLineView hMI;
    public View hMJ;
    private com.baidu.tieba.pb.pb.godreply.usertips.a hMK;
    private List<TextLineView> hML;
    private int hMM;
    private View.OnClickListener hMN;
    private com.baidu.tieba.pb.data.i hMO;
    private BdUniqueId hMP;
    private BdUniqueId hMQ;
    private View.OnClickListener hMR;
    private View.OnClickListener hMS;
    private CustomMessageListener hMT;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hMK = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.hMM = 0;
        this.PT = true;
        this.hMR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hMN != null) {
                    al.this.hMN.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.jS()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.hML) {
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
        this.hMS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hMN != null) {
                    al.this.hMN.onClick(view2);
                }
            }
        };
        this.bCB = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hMO != null && al.this.hMO.mType == com.baidu.tieba.pb.data.i.hBY && customResponsedMessage != null && getTag() == al.this.hMP && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).hQg = al.this;
                }
            }
        };
        this.hMT = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hMO != null && al.this.hMO.mType == com.baidu.tieba.pb.data.i.hBZ && customResponsedMessage != null && getTag() == al.this.hMQ && (customResponsedMessage.getData() instanceof aq.a) && al.this.mRootView != null && al.this.hMK.bRc() && al.this.hME != null && al.this.hME.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.hMK.hideTip();
                        return;
                    }
                    if (!al.this.hMK.bRc() && !com.baidu.tieba.pb.pb.godreply.usertips.b.ed(al.this.mRootView.getContext())) {
                        al.this.hMK.showTip(al.this.hME);
                    }
                    if (al.this.hMK.bRc()) {
                        al.this.hMK.cr(al.this.hME);
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
            this.hMB = (TextLineView) view.findViewById(R.id.reply_title);
            this.hMB.setOnClickListener(this.hMR);
            this.hMH = view.findViewById(R.id.reply_god_title_group);
            this.hMI = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.hMI.setSelected(false);
            this.hMJ = view.findViewById(R.id.reply_all_title);
            this.hMC = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.hMC.setOnClickListener(this.hMR);
            this.hMD = (TextView) view.findViewById(R.id.pb_sort);
            this.hMD.setOnClickListener(this.hMS);
            this.hME = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.hMB.setSelected(true);
            this.hMC.setSelected(false);
            this.hML = new ArrayList();
            this.hML.add(this.hMB);
            this.hML.add(this.hMC);
            this.hMF = view.findViewById(R.id.divider_with_reply_title);
            this.hMG = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.auN().akJ()) {
                aB(2, "");
            } else {
                aB(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aB(int i, String str) {
        this.hMM = i;
        this.hMD.setVisibility(0);
        if (str.length() > 0) {
            this.hMD.setText(str);
        } else if (this.hMM == 0) {
            this.hMD.setText(R.string.default_sort);
        } else if (this.hMM == 1) {
            this.hMD.setText(R.string.view_reverse);
        } else if (this.hMM == 2) {
            this.hMD.setText(R.string.view_hot);
        }
    }

    public void oy(boolean z) {
        if (z) {
            this.hMC.setSelected(true);
            this.hMB.setSelected(false);
            return;
        }
        this.hMC.setSelected(false);
        this.hMB.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.i iVar) {
        this.hMO = iVar;
        if (iVar != null) {
            if (iVar.mType == com.baidu.tieba.pb.data.i.hBZ) {
                final Context context = this.hMH.getContext();
                if (TextUtils.isEmpty(iVar.hCb)) {
                    this.hMJ.setVisibility(0);
                    this.hMH.setVisibility(8);
                    this.hMB.setVisibility(0);
                    this.hMB.setSelected(false);
                    this.hMB.setClickable(false);
                    this.hMB.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.hMJ.setVisibility(8);
                    this.hMB.setVisibility(8);
                    this.hMH.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.j(context, true);
                            al.this.hMK.hideTip();
                            if (al.this.hMN != null) {
                                al.this.hMN.onClick(al.this.hMH);
                            }
                        }
                    };
                    this.hMH.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.ed(context) && this.hME != null && this.hME.getVisibility() == 0 && !this.hMK.bRc()) {
                        this.hMK.M(onClickListener);
                        this.hMK.showTip(this.hME);
                    }
                }
                this.hMD.setVisibility(8);
                this.hMC.setVisibility(8);
                this.hMG.setVisibility(8);
            } else if (iVar.mType == com.baidu.tieba.pb.data.i.hBY) {
                this.hMH.setVisibility(8);
                this.hMJ.setVisibility(0);
                this.hMB.setClickable(true);
                this.hMB.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.hMD.setVisibility(0);
                this.hMC.setVisibility(0);
                oy(iVar.hCd);
                aB(iVar.sortType, iVar.hCc);
                this.hMG.setVisibility(0);
            }
            if (this.PT) {
                this.hMG.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
            } else {
                this.hMG.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds2);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.l(this.hMJ, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.l(this.hMH, R.color.cp_bg_line_d);
            this.hMB.onChangeSkinType(i);
            this.hMC.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.j(this.hMI, R.color.cp_cont_b);
            if (this.hMO != null && this.hMO.mType == com.baidu.tieba.pb.data.i.hBZ) {
                com.baidu.tbadk.core.util.al.f(this.hMB, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.j(this.hME, R.color.cp_cont_j);
            this.hME.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.j(this.hMD, R.color.cp_cont_j);
            com.baidu.tbadk.core.util.al.l(this.hMF, R.color.cp_bg_line_e);
            this.hMD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_pb_sort), (Drawable) null);
            this.hMK.onChangeSkinType(i);
            if (this.PT) {
                com.baidu.tbadk.core.util.al.k(this.hMG, R.drawable.top_shadow);
            } else {
                com.baidu.tbadk.core.util.al.l(this.hMG, R.color.cp_bg_line_c);
            }
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.hMP = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.bCB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bCB);
    }

    public void q(BdUniqueId bdUniqueId) {
        this.hMQ = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.hMT.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hMT);
    }

    public void N(View.OnClickListener onClickListener) {
        this.hMN = onClickListener;
    }
}
