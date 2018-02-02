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
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class al extends r.a {
    private CustomMessageListener aIi;
    public TextLineView fPO;
    public TextLineView fPP;
    public TextView fPQ;
    public TextView fPR;
    public View fPS;
    public View fPT;
    public View fPU;
    public TextLineView fPV;
    public View fPW;
    private com.baidu.tieba.pb.pb.godreply.a.a fPX;
    private List<TextLineView> fPY;
    private int fPZ;
    private View.OnClickListener fQa;
    private com.baidu.tieba.pb.data.j fQb;
    private View.OnClickListener fQc;
    private View.OnClickListener fQd;
    private CustomMessageListener fQe;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fPX = new com.baidu.tieba.pb.pb.godreply.a.a();
        this.fPZ = 0;
        this.fQc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fQa != null) {
                    al.this.fQa.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.oJ()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.fPY) {
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
        this.fQd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fQa != null) {
                    al.this.fQa.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.oJ() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    al.this.kp(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.aIi = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fQb != null && al.this.fQb.mType == com.baidu.tieba.pb.data.j.fEv && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.fEv && (customResponsedMessage.getData() instanceof as.a)) {
                    ((as.a) customResponsedMessage.getData()).fTu = al.this;
                }
            }
        };
        this.fQe = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fQb != null && al.this.fQb.mType == com.baidu.tieba.pb.data.j.fEw && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.fEw && (customResponsedMessage.getData() instanceof as.a) && al.this.mRootView != null && al.this.fPX.bad() && al.this.fPR != null && al.this.fPR.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.fPX.hideTip();
                        return;
                    }
                    if (!al.this.fPX.bad() && !com.baidu.tieba.pb.pb.godreply.a.c.bX(al.this.mRootView.getContext())) {
                        al.this.fPX.showTip(al.this.fPR);
                    }
                    if (al.this.fPX.bad()) {
                        al.this.fPX.cp(al.this.fPR);
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
            this.fPO = (TextLineView) view.findViewById(d.g.reply_title);
            this.fPO.setOnClickListener(this.fQc);
            this.fPU = view.findViewById(d.g.reply_god_title_group);
            this.fPV = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.fPV.setSelected(false);
            this.fPW = view.findViewById(d.g.reply_all_title);
            this.fPP = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.fPP.setOnClickListener(this.fQc);
            this.fPQ = (TextView) view.findViewById(d.g.pb_sort);
            this.fPQ.setOnClickListener(this.fQd);
            this.fPR = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.fPO.setSelected(true);
            this.fPP.setSelected(false);
            this.fPY = new ArrayList();
            this.fPY.add(this.fPO);
            this.fPY.add(this.fPP);
            this.fPS = view.findViewById(d.g.divider_with_reply_title);
            this.fPT = view.findViewById(d.g.divider_bottom);
            kp(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void kp(boolean z) {
        this.fPZ = z ? 0 : 1;
        this.fPQ.setVisibility(0);
        if (this.fPZ == 1) {
            this.fPQ.setText(d.j.default_sort);
        } else if (this.fPZ == 0) {
            this.fPQ.setText(d.j.view_reverse);
        }
    }

    public void kq(boolean z) {
        if (z) {
            this.fPP.setSelected(true);
            this.fPO.setSelected(false);
            return;
        }
        this.fPP.setSelected(false);
        this.fPO.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.fQb = jVar;
        if (jVar != null) {
            if (jVar.mType == com.baidu.tieba.pb.data.j.fEw) {
                final Context context = this.fPU.getContext();
                if (TextUtils.isEmpty(jVar.fEy)) {
                    this.fPW.setVisibility(0);
                    this.fPU.setVisibility(8);
                    this.fPO.setVisibility(0);
                    this.fPO.setSelected(false);
                    this.fPO.setClickable(false);
                    this.fPO.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.fPW.setVisibility(8);
                    this.fPO.setVisibility(8);
                    this.fPU.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.a.c.u(context, true);
                            al.this.fPX.hideTip();
                            if (al.this.fQa != null) {
                                al.this.fQa.onClick(al.this.fPU);
                            }
                        }
                    };
                    this.fPU.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.a.c.bX(context) && this.fPR != null && this.fPR.getVisibility() == 0 && !this.fPX.bad()) {
                        this.fPX.F(onClickListener);
                        this.fPX.showTip(this.fPR);
                    }
                }
                this.fPQ.setVisibility(8);
                this.fPP.setVisibility(8);
                this.fPT.setVisibility(8);
            } else if (jVar.mType == com.baidu.tieba.pb.data.j.fEv) {
                this.fPU.setVisibility(8);
                this.fPW.setVisibility(0);
                this.fPO.setClickable(true);
                this.fPO.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.fPQ.setVisibility(0);
                this.fPP.setVisibility(0);
                kq(jVar.fEz);
                kp(jVar.bud);
                this.fPT.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.t(getView(), d.C0108d.cp_bg_line_d);
            this.fPO.onChangeSkinType(i);
            this.fPP.onChangeSkinType(i);
            com.baidu.tbadk.core.util.aj.r(this.fPV, d.C0108d.cp_cont_b);
            if (this.fQb != null && this.fQb.mType == com.baidu.tieba.pb.data.j.fEw) {
                com.baidu.tbadk.core.util.aj.e(this.fPO, d.C0108d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.r(this.fPR, d.C0108d.cp_cont_j);
            this.fPR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.aj.r(this.fPQ, d.C0108d.cp_cont_j);
            com.baidu.tbadk.core.util.aj.t(this.fPS, d.C0108d.cp_bg_line_e);
            com.baidu.tbadk.core.util.aj.t(this.fPT, d.C0108d.cp_bg_line_c);
            this.fPQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fPX.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.aIi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aIi);
    }

    public void n(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fQe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fQe);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fQa = onClickListener;
    }
}
