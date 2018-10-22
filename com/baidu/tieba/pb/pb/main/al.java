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
    public TextLineView fST;
    public TextLineView fSU;
    public TextView fSV;
    public TextView fSW;
    public View fSX;
    public View fSY;
    public View fSZ;
    public TextLineView fTa;
    public View fTb;
    private com.baidu.tieba.pb.pb.godreply.usertips.a fTc;
    private List<TextLineView> fTd;
    private int fTe;
    private View.OnClickListener fTf;
    private com.baidu.tieba.pb.data.h fTg;
    private BdUniqueId fTh;
    private BdUniqueId fTi;
    private View.OnClickListener fTj;
    private View.OnClickListener fTk;
    private CustomMessageListener fTl;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fTc = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.fTe = 0;
        this.fTj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fTf != null) {
                    al.this.fTf.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kX()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.fTd) {
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
        this.fTk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fTf != null) {
                    al.this.fTf.onClick(view2);
                }
            }
        };
        this.ajQ = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fTg != null && al.this.fTg.mType == com.baidu.tieba.pb.data.h.fIq && customResponsedMessage != null && getTag() == al.this.fTh && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).fWw = al.this;
                }
            }
        };
        this.fTl = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fTg != null && al.this.fTg.mType == com.baidu.tieba.pb.data.h.fIr && customResponsedMessage != null && getTag() == al.this.fTi && (customResponsedMessage.getData() instanceof ar.a) && al.this.mRootView != null && al.this.fTc.bgk() && al.this.fSW != null && al.this.fSW.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.fTc.hideTip();
                        return;
                    }
                    if (!al.this.fTc.bgk() && !com.baidu.tieba.pb.pb.godreply.usertips.b.cT(al.this.mRootView.getContext())) {
                        al.this.fTc.showTip(al.this.fSW);
                    }
                    if (al.this.fTc.bgk()) {
                        al.this.fTc.bp(al.this.fSW);
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
            this.fST = (TextLineView) view.findViewById(e.g.reply_title);
            this.fST.setOnClickListener(this.fTj);
            this.fSZ = view.findViewById(e.g.reply_god_title_group);
            this.fTa = (TextLineView) view.findViewById(e.g.reply_god_title);
            this.fTa.setSelected(false);
            this.fTb = view.findViewById(e.g.reply_all_title);
            this.fSU = (TextLineView) view.findViewById(e.g.floor_owner_reply);
            this.fSU.setOnClickListener(this.fTj);
            this.fSV = (TextView) view.findViewById(e.g.pb_sort);
            this.fSV.setOnClickListener(this.fTk);
            this.fSW = (TextView) view.findViewById(e.g.pb_god_reply_entrance_text);
            this.fST.setSelected(true);
            this.fSU.setSelected(false);
            this.fTd = new ArrayList();
            this.fTd.add(this.fST);
            this.fTd.add(this.fSU);
            this.fSX = view.findViewById(e.g.divider_with_reply_title);
            this.fSY = view.findViewById(e.g.divider_bottom);
            if (com.baidu.tbadk.util.a.Os().EQ()) {
                ah(2, "");
            } else {
                ah(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ah(int i, String str) {
        this.fTe = i;
        this.fSV.setVisibility(0);
        if (str.length() > 0) {
            this.fSV.setText(str);
        } else if (this.fTe == 0) {
            this.fSV.setText(e.j.default_sort);
        } else if (this.fTe == 1) {
            this.fSV.setText(e.j.view_reverse);
        } else if (this.fTe == 2) {
            this.fSV.setText(e.j.view_hot);
        }
    }

    public void kR(boolean z) {
        if (z) {
            this.fSU.setSelected(true);
            this.fST.setSelected(false);
            return;
        }
        this.fSU.setSelected(false);
        this.fST.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fTg = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fIr) {
                final Context context = this.fSZ.getContext();
                if (TextUtils.isEmpty(hVar.fIt)) {
                    this.fTb.setVisibility(0);
                    this.fSZ.setVisibility(8);
                    this.fST.setVisibility(0);
                    this.fST.setSelected(false);
                    this.fST.setClickable(false);
                    this.fST.setText(TbadkCoreApplication.getInst().getString(e.j.god_reply));
                } else {
                    this.fTb.setVisibility(8);
                    this.fST.setVisibility(8);
                    this.fSZ.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.l(context, true);
                            al.this.fTc.hideTip();
                            if (al.this.fTf != null) {
                                al.this.fTf.onClick(al.this.fSZ);
                            }
                        }
                    };
                    this.fSZ.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.cT(context) && this.fSW != null && this.fSW.getVisibility() == 0 && !this.fTc.bgk()) {
                        this.fTc.H(onClickListener);
                        this.fTc.showTip(this.fSW);
                    }
                }
                this.fSV.setVisibility(8);
                this.fSU.setVisibility(8);
                this.fSY.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fIq) {
                this.fSZ.setVisibility(8);
                this.fTb.setVisibility(0);
                this.fST.setClickable(true);
                this.fST.setText(TbadkCoreApplication.getInst().getString(e.j.all_reply));
                this.fSV.setVisibility(0);
                this.fSU.setVisibility(0);
                kR(hVar.fIv);
                ah(hVar.sortType, hVar.fIu);
                this.fSY.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.j(getView(), e.d.cp_bg_line_d);
            this.fST.onChangeSkinType(i);
            this.fSU.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.h(this.fTa, e.d.cp_cont_b);
            if (this.fTg != null && this.fTg.mType == com.baidu.tieba.pb.data.h.fIr) {
                com.baidu.tbadk.core.util.al.c(this.fST, e.d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.h(this.fSW, e.d.cp_cont_j);
            this.fSW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.h(this.fSV, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.j(this.fSX, e.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.al.j(this.fSY, e.d.cp_bg_line_c);
            this.fSV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_sort), (Drawable) null);
            this.fTc.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fTh = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.ajQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ajQ);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fTi = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fTl.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fTl);
    }

    public void J(View.OnClickListener onClickListener) {
        this.fTf = onClickListener;
    }
}
