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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class al extends v.a {
    public boolean Si;
    private CustomMessageListener bvr;
    private View.OnClickListener hvA;
    private com.baidu.tieba.pb.data.h hvB;
    private BdUniqueId hvC;
    private BdUniqueId hvD;
    private View.OnClickListener hvE;
    private View.OnClickListener hvF;
    private CustomMessageListener hvG;
    public TextLineView hvo;
    public TextLineView hvp;
    public TextView hvq;
    public TextView hvr;
    public View hvs;
    public View hvt;
    public View hvu;
    public TextLineView hvv;
    public View hvw;
    private com.baidu.tieba.pb.pb.godreply.usertips.a hvx;
    private List<TextLineView> hvy;
    private int hvz;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hvx = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.hvz = 0;
        this.Si = true;
        this.hvE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hvA != null) {
                    al.this.hvA.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kY()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.hvy) {
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
        this.hvF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hvA != null) {
                    al.this.hvA.onClick(view2);
                }
            }
        };
        this.bvr = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hvB != null && al.this.hvB.mType == com.baidu.tieba.pb.data.h.hkH && customResponsedMessage != null && getTag() == al.this.hvC && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).hyL = al.this;
                }
            }
        };
        this.hvG = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hvB != null && al.this.hvB.mType == com.baidu.tieba.pb.data.h.hkI && customResponsedMessage != null && getTag() == al.this.hvD && (customResponsedMessage.getData() instanceof aq.a) && al.this.mRootView != null && al.this.hvx.bJl() && al.this.hvr != null && al.this.hvr.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.hvx.hideTip();
                        return;
                    }
                    if (!al.this.hvx.bJl() && !com.baidu.tieba.pb.pb.godreply.usertips.b.eo(al.this.mRootView.getContext())) {
                        al.this.hvx.showTip(al.this.hvr);
                    }
                    if (al.this.hvx.bJl()) {
                        al.this.hvx.cj(al.this.hvr);
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
            this.hvo = (TextLineView) view.findViewById(d.g.reply_title);
            this.hvo.setOnClickListener(this.hvE);
            this.hvu = view.findViewById(d.g.reply_god_title_group);
            this.hvv = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.hvv.setSelected(false);
            this.hvw = view.findViewById(d.g.reply_all_title);
            this.hvp = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.hvp.setOnClickListener(this.hvE);
            this.hvq = (TextView) view.findViewById(d.g.pb_sort);
            this.hvq.setOnClickListener(this.hvF);
            this.hvr = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.hvo.setSelected(true);
            this.hvp.setSelected(false);
            this.hvy = new ArrayList();
            this.hvy.add(this.hvo);
            this.hvy.add(this.hvp);
            this.hvs = view.findViewById(d.g.divider_with_reply_title);
            this.hvt = view.findViewById(d.g.divider_bottom);
            if (com.baidu.tbadk.util.a.apN().afN()) {
                aw(2, "");
            } else {
                aw(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aw(int i, String str) {
        this.hvz = i;
        this.hvq.setVisibility(0);
        if (str.length() > 0) {
            this.hvq.setText(str);
        } else if (this.hvz == 0) {
            this.hvq.setText(d.j.default_sort);
        } else if (this.hvz == 1) {
            this.hvq.setText(d.j.view_reverse);
        } else if (this.hvz == 2) {
            this.hvq.setText(d.j.view_hot);
        }
    }

    public void nI(boolean z) {
        if (z) {
            this.hvp.setSelected(true);
            this.hvo.setSelected(false);
            return;
        }
        this.hvp.setSelected(false);
        this.hvo.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.hvB = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.hkI) {
                final Context context = this.hvu.getContext();
                if (TextUtils.isEmpty(hVar.hkK)) {
                    this.hvw.setVisibility(0);
                    this.hvu.setVisibility(8);
                    this.hvo.setVisibility(0);
                    this.hvo.setSelected(false);
                    this.hvo.setClickable(false);
                    this.hvo.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.hvw.setVisibility(8);
                    this.hvo.setVisibility(8);
                    this.hvu.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.l(context, true);
                            al.this.hvx.hideTip();
                            if (al.this.hvA != null) {
                                al.this.hvA.onClick(al.this.hvu);
                            }
                        }
                    };
                    this.hvu.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.eo(context) && this.hvr != null && this.hvr.getVisibility() == 0 && !this.hvx.bJl()) {
                        this.hvx.K(onClickListener);
                        this.hvx.showTip(this.hvr);
                    }
                }
                this.hvq.setVisibility(8);
                this.hvp.setVisibility(8);
                this.hvt.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.hkH) {
                this.hvu.setVisibility(8);
                this.hvw.setVisibility(0);
                this.hvo.setClickable(true);
                this.hvo.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.hvq.setVisibility(0);
                this.hvp.setVisibility(0);
                nI(hVar.hkM);
                aw(hVar.sortType, hVar.hkL);
                this.hvt.setVisibility(0);
            }
            if (this.Si) {
                this.hvt.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds16);
            } else {
                this.hvt.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds2);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.l(this.hvw, d.C0236d.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.l(this.hvu, d.C0236d.cp_bg_line_d);
            this.hvo.onChangeSkinType(i);
            this.hvp.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.j(this.hvv, d.C0236d.cp_cont_b);
            if (this.hvB != null && this.hvB.mType == com.baidu.tieba.pb.data.h.hkI) {
                com.baidu.tbadk.core.util.al.d(this.hvo, d.C0236d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.j(this.hvr, d.C0236d.cp_cont_j);
            this.hvr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.j(this.hvq, d.C0236d.cp_cont_j);
            com.baidu.tbadk.core.util.al.l(this.hvs, d.C0236d.cp_bg_line_e);
            this.hvq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.hvx.onChangeSkinType(i);
            if (this.Si) {
                com.baidu.tbadk.core.util.al.k(this.hvt, d.f.top_shadow);
            } else {
                com.baidu.tbadk.core.util.al.l(this.hvt, d.C0236d.cp_bg_line_c);
            }
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.hvC = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.bvr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bvr);
    }

    public void o(BdUniqueId bdUniqueId) {
        this.hvD = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.hvG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hvG);
    }

    public void L(View.OnClickListener onClickListener) {
        this.hvA = onClickListener;
    }
}
