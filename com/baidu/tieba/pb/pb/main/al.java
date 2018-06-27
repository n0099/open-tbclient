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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class al extends q.a {
    private CustomMessageListener acM;
    public TextLineView fDB;
    public TextLineView fDC;
    public TextView fDD;
    public TextView fDE;
    public View fDF;
    public View fDG;
    public View fDH;
    public TextLineView fDI;
    public View fDJ;
    private com.baidu.tieba.pb.pb.godreply.usertips.a fDK;
    private List<TextLineView> fDL;
    private int fDM;
    private View.OnClickListener fDN;
    private com.baidu.tieba.pb.data.h fDO;
    private BdUniqueId fDP;
    private BdUniqueId fDQ;
    private View.OnClickListener fDR;
    private View.OnClickListener fDS;
    private CustomMessageListener fDT;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fDK = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.fDM = 0;
        this.fDR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fDN != null) {
                    al.this.fDN.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.jD()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.fDL) {
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
        this.fDS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fDN != null) {
                    al.this.fDN.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.jD() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    al.this.kq(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.acM = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fDO != null && al.this.fDO.mType == com.baidu.tieba.pb.data.h.fsV && customResponsedMessage != null && getTag() == al.this.fDP && (customResponsedMessage.getData() instanceof at.a)) {
                    ((at.a) customResponsedMessage.getData()).fHn = al.this;
                }
            }
        };
        this.fDT = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fDO != null && al.this.fDO.mType == com.baidu.tieba.pb.data.h.fsW && customResponsedMessage != null && getTag() == al.this.fDQ && (customResponsedMessage.getData() instanceof at.a) && al.this.mRootView != null && al.this.fDK.bck() && al.this.fDE != null && al.this.fDE.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.fDK.hideTip();
                        return;
                    }
                    if (!al.this.fDK.bck() && !com.baidu.tieba.pb.pb.godreply.usertips.b.bZ(al.this.mRootView.getContext())) {
                        al.this.fDK.showTip(al.this.fDE);
                    }
                    if (al.this.fDK.bck()) {
                        al.this.fDK.aY(al.this.fDE);
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
            this.fDB = (TextLineView) view.findViewById(d.g.reply_title);
            this.fDB.setOnClickListener(this.fDR);
            this.fDH = view.findViewById(d.g.reply_god_title_group);
            this.fDI = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.fDI.setSelected(false);
            this.fDJ = view.findViewById(d.g.reply_all_title);
            this.fDC = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.fDC.setOnClickListener(this.fDR);
            this.fDD = (TextView) view.findViewById(d.g.pb_sort);
            this.fDD.setOnClickListener(this.fDS);
            this.fDE = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.fDB.setSelected(true);
            this.fDC.setSelected(false);
            this.fDL = new ArrayList();
            this.fDL.add(this.fDB);
            this.fDL.add(this.fDC);
            this.fDF = view.findViewById(d.g.divider_with_reply_title);
            this.fDG = view.findViewById(d.g.divider_bottom);
            kq(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void kq(boolean z) {
        this.fDM = z ? 0 : 1;
        this.fDD.setVisibility(0);
        if (this.fDM == 1) {
            this.fDD.setText(d.k.default_sort);
        } else if (this.fDM == 0) {
            this.fDD.setText(d.k.view_reverse);
        }
    }

    public void kr(boolean z) {
        if (z) {
            this.fDC.setSelected(true);
            this.fDB.setSelected(false);
            return;
        }
        this.fDC.setSelected(false);
        this.fDB.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fDO = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fsW) {
                final Context context = this.fDH.getContext();
                if (TextUtils.isEmpty(hVar.fsY)) {
                    this.fDJ.setVisibility(0);
                    this.fDH.setVisibility(8);
                    this.fDB.setVisibility(0);
                    this.fDB.setSelected(false);
                    this.fDB.setClickable(false);
                    this.fDB.setText(TbadkCoreApplication.getInst().getString(d.k.god_reply));
                } else {
                    this.fDJ.setVisibility(8);
                    this.fDB.setVisibility(8);
                    this.fDH.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.u(context, true);
                            al.this.fDK.hideTip();
                            if (al.this.fDN != null) {
                                al.this.fDN.onClick(al.this.fDH);
                            }
                        }
                    };
                    this.fDH.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.bZ(context) && this.fDE != null && this.fDE.getVisibility() == 0 && !this.fDK.bck()) {
                        this.fDK.J(onClickListener);
                        this.fDK.showTip(this.fDE);
                    }
                }
                this.fDD.setVisibility(8);
                this.fDC.setVisibility(8);
                this.fDG.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fsV) {
                this.fDH.setVisibility(8);
                this.fDJ.setVisibility(0);
                this.fDB.setClickable(true);
                this.fDB.setText(TbadkCoreApplication.getInst().getString(d.k.all_reply));
                this.fDD.setVisibility(0);
                this.fDC.setVisibility(0);
                kr(hVar.fsZ);
                kq(hVar.isNew);
                this.fDG.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.j(getView(), d.C0142d.cp_bg_line_d);
            this.fDB.onChangeSkinType(i);
            this.fDC.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.h(this.fDI, d.C0142d.cp_cont_b);
            if (this.fDO != null && this.fDO.mType == com.baidu.tieba.pb.data.h.fsW) {
                com.baidu.tbadk.core.util.am.c(this.fDB, d.C0142d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.h(this.fDE, d.C0142d.cp_cont_j);
            this.fDE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.h(this.fDD, d.C0142d.cp_cont_j);
            com.baidu.tbadk.core.util.am.j(this.fDF, d.C0142d.cp_bg_line_e);
            com.baidu.tbadk.core.util.am.j(this.fDG, d.C0142d.cp_bg_line_c);
            this.fDD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fDK.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fDP = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.acM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.acM);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fDQ = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fDT.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fDT);
    }

    public void L(View.OnClickListener onClickListener) {
        this.fDN = onClickListener;
    }
}
