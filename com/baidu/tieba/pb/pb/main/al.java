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
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class al extends q.a {
    private CustomMessageListener acr;
    public TextLineView fDH;
    public TextLineView fDI;
    public TextView fDJ;
    public TextView fDK;
    public View fDL;
    public View fDM;
    public View fDN;
    public TextLineView fDO;
    public View fDP;
    private com.baidu.tieba.pb.pb.godreply.usertips.a fDQ;
    private List<TextLineView> fDR;
    private int fDS;
    private View.OnClickListener fDT;
    private com.baidu.tieba.pb.data.h fDU;
    private BdUniqueId fDV;
    private BdUniqueId fDW;
    private View.OnClickListener fDX;
    private View.OnClickListener fDY;
    private CustomMessageListener fDZ;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fDQ = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.fDS = 0;
        this.fDX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fDT != null) {
                    al.this.fDT.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.jE()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.fDR) {
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
        this.fDY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fDT != null) {
                    al.this.fDT.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.jE() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    al.this.kc(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.acr = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fDU != null && al.this.fDU.mType == com.baidu.tieba.pb.data.h.fta && customResponsedMessage != null && getTag() == al.this.fDV && (customResponsedMessage.getData() instanceof at.a)) {
                    ((at.a) customResponsedMessage.getData()).fHv = al.this;
                }
            }
        };
        this.fDZ = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fDU != null && al.this.fDU.mType == com.baidu.tieba.pb.data.h.ftb && customResponsedMessage != null && getTag() == al.this.fDW && (customResponsedMessage.getData() instanceof at.a) && al.this.mRootView != null && al.this.fDQ.bay() && al.this.fDK != null && al.this.fDK.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.fDQ.hideTip();
                        return;
                    }
                    if (!al.this.fDQ.bay() && !com.baidu.tieba.pb.pb.godreply.usertips.b.bZ(al.this.mRootView.getContext())) {
                        al.this.fDQ.showTip(al.this.fDK);
                    }
                    if (al.this.fDQ.bay()) {
                        al.this.fDQ.bb(al.this.fDK);
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
            this.fDH = (TextLineView) view.findViewById(f.g.reply_title);
            this.fDH.setOnClickListener(this.fDX);
            this.fDN = view.findViewById(f.g.reply_god_title_group);
            this.fDO = (TextLineView) view.findViewById(f.g.reply_god_title);
            this.fDO.setSelected(false);
            this.fDP = view.findViewById(f.g.reply_all_title);
            this.fDI = (TextLineView) view.findViewById(f.g.floor_owner_reply);
            this.fDI.setOnClickListener(this.fDX);
            this.fDJ = (TextView) view.findViewById(f.g.pb_sort);
            this.fDJ.setOnClickListener(this.fDY);
            this.fDK = (TextView) view.findViewById(f.g.pb_god_reply_entrance_text);
            this.fDH.setSelected(true);
            this.fDI.setSelected(false);
            this.fDR = new ArrayList();
            this.fDR.add(this.fDH);
            this.fDR.add(this.fDI);
            this.fDL = view.findViewById(f.g.divider_with_reply_title);
            this.fDM = view.findViewById(f.g.divider_bottom);
            kc(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void kc(boolean z) {
        this.fDS = z ? 0 : 1;
        this.fDJ.setVisibility(0);
        if (this.fDS == 1) {
            this.fDJ.setText(f.j.default_sort);
        } else if (this.fDS == 0) {
            this.fDJ.setText(f.j.view_reverse);
        }
    }

    public void kd(boolean z) {
        if (z) {
            this.fDI.setSelected(true);
            this.fDH.setSelected(false);
            return;
        }
        this.fDI.setSelected(false);
        this.fDH.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fDU = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.ftb) {
                final Context context = this.fDN.getContext();
                if (TextUtils.isEmpty(hVar.ftd)) {
                    this.fDP.setVisibility(0);
                    this.fDN.setVisibility(8);
                    this.fDH.setVisibility(0);
                    this.fDH.setSelected(false);
                    this.fDH.setClickable(false);
                    this.fDH.setText(TbadkCoreApplication.getInst().getString(f.j.god_reply));
                } else {
                    this.fDP.setVisibility(8);
                    this.fDH.setVisibility(8);
                    this.fDN.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.i(context, true);
                            al.this.fDQ.hideTip();
                            if (al.this.fDT != null) {
                                al.this.fDT.onClick(al.this.fDN);
                            }
                        }
                    };
                    this.fDN.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.bZ(context) && this.fDK != null && this.fDK.getVisibility() == 0 && !this.fDQ.bay()) {
                        this.fDQ.H(onClickListener);
                        this.fDQ.showTip(this.fDK);
                    }
                }
                this.fDJ.setVisibility(8);
                this.fDI.setVisibility(8);
                this.fDM.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fta) {
                this.fDN.setVisibility(8);
                this.fDP.setVisibility(0);
                this.fDH.setClickable(true);
                this.fDH.setText(TbadkCoreApplication.getInst().getString(f.j.all_reply));
                this.fDJ.setVisibility(0);
                this.fDI.setVisibility(0);
                kd(hVar.fte);
                kc(hVar.isNew);
                this.fDM.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.j(getView(), f.d.cp_bg_line_d);
            this.fDH.onChangeSkinType(i);
            this.fDI.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.h(this.fDO, f.d.cp_cont_b);
            if (this.fDU != null && this.fDU.mType == com.baidu.tieba.pb.data.h.ftb) {
                com.baidu.tbadk.core.util.am.c(this.fDH, f.d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.h(this.fDK, f.d.cp_cont_j);
            this.fDK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.h(this.fDJ, f.d.cp_cont_j);
            com.baidu.tbadk.core.util.am.j(this.fDL, f.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.am.j(this.fDM, f.d.cp_bg_line_c);
            this.fDJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_pb_sort), (Drawable) null);
            this.fDQ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fDV = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.acr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.acr);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fDW = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fDZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fDZ);
    }

    public void J(View.OnClickListener onClickListener) {
        this.fDT = onClickListener;
    }
}
