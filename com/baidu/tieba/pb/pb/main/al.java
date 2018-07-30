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
    private CustomMessageListener acq;
    public TextLineView fDO;
    public TextLineView fDP;
    public TextView fDQ;
    public TextView fDR;
    public View fDS;
    public View fDT;
    public View fDU;
    public TextLineView fDV;
    public View fDW;
    private com.baidu.tieba.pb.pb.godreply.usertips.a fDX;
    private List<TextLineView> fDY;
    private int fDZ;
    private View.OnClickListener fEa;
    private com.baidu.tieba.pb.data.h fEb;
    private BdUniqueId fEc;
    private BdUniqueId fEd;
    private View.OnClickListener fEe;
    private View.OnClickListener fEf;
    private CustomMessageListener fEg;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fDX = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.fDZ = 0;
        this.fEe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fEa != null) {
                    al.this.fEa.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.jE()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.fDY) {
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
        this.fEf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fEa != null) {
                    al.this.fEa.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.jE() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    al.this.kc(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.acq = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fEb != null && al.this.fEb.mType == com.baidu.tieba.pb.data.h.fth && customResponsedMessage != null && getTag() == al.this.fEc && (customResponsedMessage.getData() instanceof at.a)) {
                    ((at.a) customResponsedMessage.getData()).fHC = al.this;
                }
            }
        };
        this.fEg = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fEb != null && al.this.fEb.mType == com.baidu.tieba.pb.data.h.fti && customResponsedMessage != null && getTag() == al.this.fEd && (customResponsedMessage.getData() instanceof at.a) && al.this.mRootView != null && al.this.fDX.baD() && al.this.fDR != null && al.this.fDR.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.fDX.hideTip();
                        return;
                    }
                    if (!al.this.fDX.baD() && !com.baidu.tieba.pb.pb.godreply.usertips.b.ca(al.this.mRootView.getContext())) {
                        al.this.fDX.showTip(al.this.fDR);
                    }
                    if (al.this.fDX.baD()) {
                        al.this.fDX.bb(al.this.fDR);
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
            this.fDO = (TextLineView) view.findViewById(d.g.reply_title);
            this.fDO.setOnClickListener(this.fEe);
            this.fDU = view.findViewById(d.g.reply_god_title_group);
            this.fDV = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.fDV.setSelected(false);
            this.fDW = view.findViewById(d.g.reply_all_title);
            this.fDP = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.fDP.setOnClickListener(this.fEe);
            this.fDQ = (TextView) view.findViewById(d.g.pb_sort);
            this.fDQ.setOnClickListener(this.fEf);
            this.fDR = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.fDO.setSelected(true);
            this.fDP.setSelected(false);
            this.fDY = new ArrayList();
            this.fDY.add(this.fDO);
            this.fDY.add(this.fDP);
            this.fDS = view.findViewById(d.g.divider_with_reply_title);
            this.fDT = view.findViewById(d.g.divider_bottom);
            kc(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void kc(boolean z) {
        this.fDZ = z ? 0 : 1;
        this.fDQ.setVisibility(0);
        if (this.fDZ == 1) {
            this.fDQ.setText(d.j.default_sort);
        } else if (this.fDZ == 0) {
            this.fDQ.setText(d.j.view_reverse);
        }
    }

    public void kd(boolean z) {
        if (z) {
            this.fDP.setSelected(true);
            this.fDO.setSelected(false);
            return;
        }
        this.fDP.setSelected(false);
        this.fDO.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fEb = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fti) {
                final Context context = this.fDU.getContext();
                if (TextUtils.isEmpty(hVar.ftk)) {
                    this.fDW.setVisibility(0);
                    this.fDU.setVisibility(8);
                    this.fDO.setVisibility(0);
                    this.fDO.setSelected(false);
                    this.fDO.setClickable(false);
                    this.fDO.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.fDW.setVisibility(8);
                    this.fDO.setVisibility(8);
                    this.fDU.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.u(context, true);
                            al.this.fDX.hideTip();
                            if (al.this.fEa != null) {
                                al.this.fEa.onClick(al.this.fDU);
                            }
                        }
                    };
                    this.fDU.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.ca(context) && this.fDR != null && this.fDR.getVisibility() == 0 && !this.fDX.baD()) {
                        this.fDX.H(onClickListener);
                        this.fDX.showTip(this.fDR);
                    }
                }
                this.fDQ.setVisibility(8);
                this.fDP.setVisibility(8);
                this.fDT.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fth) {
                this.fDU.setVisibility(8);
                this.fDW.setVisibility(0);
                this.fDO.setClickable(true);
                this.fDO.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.fDQ.setVisibility(0);
                this.fDP.setVisibility(0);
                kd(hVar.ftl);
                kc(hVar.isNew);
                this.fDT.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.j(getView(), d.C0140d.cp_bg_line_d);
            this.fDO.onChangeSkinType(i);
            this.fDP.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.h(this.fDV, d.C0140d.cp_cont_b);
            if (this.fEb != null && this.fEb.mType == com.baidu.tieba.pb.data.h.fti) {
                com.baidu.tbadk.core.util.am.c(this.fDO, d.C0140d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.h(this.fDR, d.C0140d.cp_cont_j);
            this.fDR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.h(this.fDQ, d.C0140d.cp_cont_j);
            com.baidu.tbadk.core.util.am.j(this.fDS, d.C0140d.cp_bg_line_e);
            com.baidu.tbadk.core.util.am.j(this.fDT, d.C0140d.cp_bg_line_c);
            this.fDQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fDX.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fEc = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.acq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.acq);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fEd = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fEg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fEg);
    }

    public void J(View.OnClickListener onClickListener) {
        this.fEa = onClickListener;
    }
}
