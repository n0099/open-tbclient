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
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class al extends q.a {
    private CustomMessageListener ajQ;
    public TextLineView fSS;
    public TextLineView fST;
    public TextView fSU;
    public TextView fSV;
    public View fSW;
    public View fSX;
    public View fSY;
    public TextLineView fSZ;
    public View fTa;
    private com.baidu.tieba.pb.pb.godreply.usertips.a fTb;
    private List<TextLineView> fTc;
    private int fTd;
    private View.OnClickListener fTe;
    private com.baidu.tieba.pb.data.h fTf;
    private BdUniqueId fTg;
    private BdUniqueId fTh;
    private View.OnClickListener fTi;
    private View.OnClickListener fTj;
    private CustomMessageListener fTk;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fTb = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.fTd = 0;
        this.fTi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fTe != null) {
                    al.this.fTe.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kX()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.fTc) {
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
        this.fTj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fTe != null) {
                    al.this.fTe.onClick(view2);
                }
            }
        };
        this.ajQ = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fTf != null && al.this.fTf.mType == com.baidu.tieba.pb.data.h.fIp && customResponsedMessage != null && getTag() == al.this.fTg && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).fWv = al.this;
                }
            }
        };
        this.fTk = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fTf != null && al.this.fTf.mType == com.baidu.tieba.pb.data.h.fIq && customResponsedMessage != null && getTag() == al.this.fTh && (customResponsedMessage.getData() instanceof ar.a) && al.this.mRootView != null && al.this.fTb.bgk() && al.this.fSV != null && al.this.fSV.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.fTb.hideTip();
                        return;
                    }
                    if (!al.this.fTb.bgk() && !com.baidu.tieba.pb.pb.godreply.usertips.b.cT(al.this.mRootView.getContext())) {
                        al.this.fTb.showTip(al.this.fSV);
                    }
                    if (al.this.fTb.bgk()) {
                        al.this.fTb.bp(al.this.fSV);
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
            this.fSS = (TextLineView) view.findViewById(e.g.reply_title);
            this.fSS.setOnClickListener(this.fTi);
            this.fSY = view.findViewById(e.g.reply_god_title_group);
            this.fSZ = (TextLineView) view.findViewById(e.g.reply_god_title);
            this.fSZ.setSelected(false);
            this.fTa = view.findViewById(e.g.reply_all_title);
            this.fST = (TextLineView) view.findViewById(e.g.floor_owner_reply);
            this.fST.setOnClickListener(this.fTi);
            this.fSU = (TextView) view.findViewById(e.g.pb_sort);
            this.fSU.setOnClickListener(this.fTj);
            this.fSV = (TextView) view.findViewById(e.g.pb_god_reply_entrance_text);
            this.fSS.setSelected(true);
            this.fST.setSelected(false);
            this.fTc = new ArrayList();
            this.fTc.add(this.fSS);
            this.fTc.add(this.fST);
            this.fSW = view.findViewById(e.g.divider_with_reply_title);
            this.fSX = view.findViewById(e.g.divider_bottom);
            if (com.baidu.tbadk.util.a.Os().EQ()) {
                ah(2, "");
            } else {
                ah(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ah(int i, String str) {
        this.fTd = i;
        this.fSU.setVisibility(0);
        if (str.length() > 0) {
            this.fSU.setText(str);
        } else if (this.fTd == 0) {
            this.fSU.setText(e.j.default_sort);
        } else if (this.fTd == 1) {
            this.fSU.setText(e.j.view_reverse);
        } else if (this.fTd == 2) {
            this.fSU.setText(e.j.view_hot);
        }
    }

    public void kR(boolean z) {
        if (z) {
            this.fST.setSelected(true);
            this.fSS.setSelected(false);
            return;
        }
        this.fST.setSelected(false);
        this.fSS.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fTf = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fIq) {
                final Context context = this.fSY.getContext();
                if (TextUtils.isEmpty(hVar.fIs)) {
                    this.fTa.setVisibility(0);
                    this.fSY.setVisibility(8);
                    this.fSS.setVisibility(0);
                    this.fSS.setSelected(false);
                    this.fSS.setClickable(false);
                    this.fSS.setText(TbadkCoreApplication.getInst().getString(e.j.god_reply));
                } else {
                    this.fTa.setVisibility(8);
                    this.fSS.setVisibility(8);
                    this.fSY.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.l(context, true);
                            al.this.fTb.hideTip();
                            if (al.this.fTe != null) {
                                al.this.fTe.onClick(al.this.fSY);
                            }
                        }
                    };
                    this.fSY.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.cT(context) && this.fSV != null && this.fSV.getVisibility() == 0 && !this.fTb.bgk()) {
                        this.fTb.H(onClickListener);
                        this.fTb.showTip(this.fSV);
                    }
                }
                this.fSU.setVisibility(8);
                this.fST.setVisibility(8);
                this.fSX.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fIp) {
                this.fSY.setVisibility(8);
                this.fTa.setVisibility(0);
                this.fSS.setClickable(true);
                this.fSS.setText(TbadkCoreApplication.getInst().getString(e.j.all_reply));
                this.fSU.setVisibility(0);
                this.fST.setVisibility(0);
                kR(hVar.fIu);
                ah(hVar.sortType, hVar.fIt);
                this.fSX.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.j(getView(), e.d.cp_bg_line_d);
            this.fSS.onChangeSkinType(i);
            this.fST.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.h(this.fSZ, e.d.cp_cont_b);
            if (this.fTf != null && this.fTf.mType == com.baidu.tieba.pb.data.h.fIq) {
                com.baidu.tbadk.core.util.al.c(this.fSS, e.d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.h(this.fSV, e.d.cp_cont_j);
            this.fSV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.h(this.fSU, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.j(this.fSW, e.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.al.j(this.fSX, e.d.cp_bg_line_c);
            this.fSU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_sort), (Drawable) null);
            this.fTb.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fTg = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.ajQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ajQ);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fTh = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fTk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fTk);
    }

    public void J(View.OnClickListener onClickListener) {
        this.fTe = onClickListener;
    }
}
