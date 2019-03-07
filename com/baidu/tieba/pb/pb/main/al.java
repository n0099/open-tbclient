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
    private com.baidu.tieba.pb.data.h hvA;
    private BdUniqueId hvB;
    private BdUniqueId hvC;
    private View.OnClickListener hvD;
    private View.OnClickListener hvE;
    private CustomMessageListener hvF;
    public TextLineView hvn;
    public TextLineView hvo;
    public TextView hvp;
    public TextView hvq;
    public View hvr;
    public View hvs;
    public View hvt;
    public TextLineView hvu;
    public View hvv;
    private com.baidu.tieba.pb.pb.godreply.usertips.a hvw;
    private List<TextLineView> hvx;
    private int hvy;
    private View.OnClickListener hvz;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hvw = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.hvy = 0;
        this.Si = true;
        this.hvD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hvz != null) {
                    al.this.hvz.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kY()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.hvx) {
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
        this.hvE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hvz != null) {
                    al.this.hvz.onClick(view2);
                }
            }
        };
        this.bvr = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hvA != null && al.this.hvA.mType == com.baidu.tieba.pb.data.h.hkG && customResponsedMessage != null && getTag() == al.this.hvB && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).hyK = al.this;
                }
            }
        };
        this.hvF = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hvA != null && al.this.hvA.mType == com.baidu.tieba.pb.data.h.hkH && customResponsedMessage != null && getTag() == al.this.hvC && (customResponsedMessage.getData() instanceof aq.a) && al.this.mRootView != null && al.this.hvw.bJk() && al.this.hvq != null && al.this.hvq.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.hvw.hideTip();
                        return;
                    }
                    if (!al.this.hvw.bJk() && !com.baidu.tieba.pb.pb.godreply.usertips.b.eo(al.this.mRootView.getContext())) {
                        al.this.hvw.showTip(al.this.hvq);
                    }
                    if (al.this.hvw.bJk()) {
                        al.this.hvw.cj(al.this.hvq);
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
            this.hvn = (TextLineView) view.findViewById(d.g.reply_title);
            this.hvn.setOnClickListener(this.hvD);
            this.hvt = view.findViewById(d.g.reply_god_title_group);
            this.hvu = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.hvu.setSelected(false);
            this.hvv = view.findViewById(d.g.reply_all_title);
            this.hvo = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.hvo.setOnClickListener(this.hvD);
            this.hvp = (TextView) view.findViewById(d.g.pb_sort);
            this.hvp.setOnClickListener(this.hvE);
            this.hvq = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.hvn.setSelected(true);
            this.hvo.setSelected(false);
            this.hvx = new ArrayList();
            this.hvx.add(this.hvn);
            this.hvx.add(this.hvo);
            this.hvr = view.findViewById(d.g.divider_with_reply_title);
            this.hvs = view.findViewById(d.g.divider_bottom);
            if (com.baidu.tbadk.util.a.apM().afN()) {
                aw(2, "");
            } else {
                aw(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aw(int i, String str) {
        this.hvy = i;
        this.hvp.setVisibility(0);
        if (str.length() > 0) {
            this.hvp.setText(str);
        } else if (this.hvy == 0) {
            this.hvp.setText(d.j.default_sort);
        } else if (this.hvy == 1) {
            this.hvp.setText(d.j.view_reverse);
        } else if (this.hvy == 2) {
            this.hvp.setText(d.j.view_hot);
        }
    }

    public void nI(boolean z) {
        if (z) {
            this.hvo.setSelected(true);
            this.hvn.setSelected(false);
            return;
        }
        this.hvo.setSelected(false);
        this.hvn.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.hvA = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.hkH) {
                final Context context = this.hvt.getContext();
                if (TextUtils.isEmpty(hVar.hkJ)) {
                    this.hvv.setVisibility(0);
                    this.hvt.setVisibility(8);
                    this.hvn.setVisibility(0);
                    this.hvn.setSelected(false);
                    this.hvn.setClickable(false);
                    this.hvn.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.hvv.setVisibility(8);
                    this.hvn.setVisibility(8);
                    this.hvt.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.l(context, true);
                            al.this.hvw.hideTip();
                            if (al.this.hvz != null) {
                                al.this.hvz.onClick(al.this.hvt);
                            }
                        }
                    };
                    this.hvt.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.eo(context) && this.hvq != null && this.hvq.getVisibility() == 0 && !this.hvw.bJk()) {
                        this.hvw.K(onClickListener);
                        this.hvw.showTip(this.hvq);
                    }
                }
                this.hvp.setVisibility(8);
                this.hvo.setVisibility(8);
                this.hvs.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.hkG) {
                this.hvt.setVisibility(8);
                this.hvv.setVisibility(0);
                this.hvn.setClickable(true);
                this.hvn.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.hvp.setVisibility(0);
                this.hvo.setVisibility(0);
                nI(hVar.hkL);
                aw(hVar.sortType, hVar.hkK);
                this.hvs.setVisibility(0);
            }
            if (this.Si) {
                this.hvs.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds16);
            } else {
                this.hvs.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds2);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.l(this.hvv, d.C0236d.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.l(this.hvt, d.C0236d.cp_bg_line_d);
            this.hvn.onChangeSkinType(i);
            this.hvo.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.j(this.hvu, d.C0236d.cp_cont_b);
            if (this.hvA != null && this.hvA.mType == com.baidu.tieba.pb.data.h.hkH) {
                com.baidu.tbadk.core.util.al.d(this.hvn, d.C0236d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.j(this.hvq, d.C0236d.cp_cont_j);
            this.hvq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.j(this.hvp, d.C0236d.cp_cont_j);
            com.baidu.tbadk.core.util.al.l(this.hvr, d.C0236d.cp_bg_line_e);
            this.hvp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.hvw.onChangeSkinType(i);
            if (this.Si) {
                com.baidu.tbadk.core.util.al.k(this.hvs, d.f.top_shadow);
            } else {
                com.baidu.tbadk.core.util.al.l(this.hvs, d.C0236d.cp_bg_line_c);
            }
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.hvB = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.bvr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bvr);
    }

    public void o(BdUniqueId bdUniqueId) {
        this.hvC = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.hvF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hvF);
    }

    public void L(View.OnClickListener onClickListener) {
        this.hvz = onClickListener;
    }
}
