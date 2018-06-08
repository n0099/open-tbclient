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
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ak extends q.a {
    private CustomMessageListener acJ;
    public TextLineView fzA;
    public TextLineView fzB;
    public TextView fzC;
    public TextView fzD;
    public View fzE;
    public View fzF;
    public View fzG;
    public TextLineView fzH;
    public View fzI;
    private com.baidu.tieba.pb.pb.godreply.usertips.a fzJ;
    private List<TextLineView> fzK;
    private int fzL;
    private View.OnClickListener fzM;
    private com.baidu.tieba.pb.data.h fzN;
    private BdUniqueId fzO;
    private BdUniqueId fzP;
    private View.OnClickListener fzQ;
    private View.OnClickListener fzR;
    private CustomMessageListener fzS;
    private View mRootView;
    public int mSkinType;

    public ak(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fzJ = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.fzL = 0;
        this.fzQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.fzM != null) {
                    ak.this.fzM.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.jD()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ak.this.fzK) {
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
        this.fzR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.fzM != null) {
                    ak.this.fzM.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.jD() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    ak.this.kg(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.acJ = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fzN != null && ak.this.fzN.mType == com.baidu.tieba.pb.data.h.fpb && customResponsedMessage != null && getTag() == ak.this.fzO && (customResponsedMessage.getData() instanceof as.a)) {
                    ((as.a) customResponsedMessage.getData()).fDm = ak.this;
                }
            }
        };
        this.fzS = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fzN != null && ak.this.fzN.mType == com.baidu.tieba.pb.data.h.fpc && customResponsedMessage != null && getTag() == ak.this.fzP && (customResponsedMessage.getData() instanceof as.a) && ak.this.mRootView != null && ak.this.fzJ.bbD() && ak.this.fzD != null && ak.this.fzD.getVisibility() == 0) {
                    if (ak.this.mRootView == null || ak.this.mRootView.getParent() == null) {
                        ak.this.fzJ.hideTip();
                        return;
                    }
                    if (!ak.this.fzJ.bbD() && !com.baidu.tieba.pb.pb.godreply.usertips.b.ca(ak.this.mRootView.getContext())) {
                        ak.this.fzJ.showTip(ak.this.fzD);
                    }
                    if (ak.this.fzJ.bbD()) {
                        ak.this.fzJ.aX(ak.this.fzD);
                    }
                }
            }
        };
        if (view != null) {
            this.mRootView = view;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.fzA = (TextLineView) view.findViewById(d.g.reply_title);
            this.fzA.setOnClickListener(this.fzQ);
            this.fzG = view.findViewById(d.g.reply_god_title_group);
            this.fzH = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.fzH.setSelected(false);
            this.fzI = view.findViewById(d.g.reply_all_title);
            this.fzB = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.fzB.setOnClickListener(this.fzQ);
            this.fzC = (TextView) view.findViewById(d.g.pb_sort);
            this.fzC.setOnClickListener(this.fzR);
            this.fzD = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.fzA.setSelected(true);
            this.fzB.setSelected(false);
            this.fzK = new ArrayList();
            this.fzK.add(this.fzA);
            this.fzK.add(this.fzB);
            this.fzE = view.findViewById(d.g.divider_with_reply_title);
            this.fzF = view.findViewById(d.g.divider_bottom);
            kg(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void kg(boolean z) {
        this.fzL = z ? 0 : 1;
        this.fzC.setVisibility(0);
        if (this.fzL == 1) {
            this.fzC.setText(d.k.default_sort);
        } else if (this.fzL == 0) {
            this.fzC.setText(d.k.view_reverse);
        }
    }

    public void kh(boolean z) {
        if (z) {
            this.fzB.setSelected(true);
            this.fzA.setSelected(false);
            return;
        }
        this.fzB.setSelected(false);
        this.fzA.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fzN = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fpc) {
                final Context context = this.fzG.getContext();
                if (TextUtils.isEmpty(hVar.fpe)) {
                    this.fzI.setVisibility(0);
                    this.fzG.setVisibility(8);
                    this.fzA.setVisibility(0);
                    this.fzA.setSelected(false);
                    this.fzA.setClickable(false);
                    this.fzA.setText(TbadkCoreApplication.getInst().getString(d.k.god_reply));
                } else {
                    this.fzI.setVisibility(8);
                    this.fzA.setVisibility(8);
                    this.fzG.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.u(context, true);
                            ak.this.fzJ.hideTip();
                            if (ak.this.fzM != null) {
                                ak.this.fzM.onClick(ak.this.fzG);
                            }
                        }
                    };
                    this.fzG.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.ca(context) && this.fzD != null && this.fzD.getVisibility() == 0 && !this.fzJ.bbD()) {
                        this.fzJ.G(onClickListener);
                        this.fzJ.showTip(this.fzD);
                    }
                }
                this.fzC.setVisibility(8);
                this.fzB.setVisibility(8);
                this.fzF.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fpb) {
                this.fzG.setVisibility(8);
                this.fzI.setVisibility(0);
                this.fzA.setClickable(true);
                this.fzA.setText(TbadkCoreApplication.getInst().getString(d.k.all_reply));
                this.fzC.setVisibility(0);
                this.fzB.setVisibility(0);
                kh(hVar.fpf);
                kg(hVar.isNew);
                this.fzF.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.j(getView(), d.C0141d.cp_bg_line_d);
            this.fzA.onChangeSkinType(i);
            this.fzB.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.h(this.fzH, d.C0141d.cp_cont_b);
            if (this.fzN != null && this.fzN.mType == com.baidu.tieba.pb.data.h.fpc) {
                com.baidu.tbadk.core.util.al.c(this.fzA, d.C0141d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.h(this.fzD, d.C0141d.cp_cont_j);
            this.fzD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.h(this.fzC, d.C0141d.cp_cont_j);
            com.baidu.tbadk.core.util.al.j(this.fzE, d.C0141d.cp_bg_line_e);
            com.baidu.tbadk.core.util.al.j(this.fzF, d.C0141d.cp_bg_line_c);
            this.fzC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fzJ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fzO = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.acJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.acJ);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fzP = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fzS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fzS);
    }

    public void H(View.OnClickListener onClickListener) {
        this.fzM = onClickListener;
    }
}
