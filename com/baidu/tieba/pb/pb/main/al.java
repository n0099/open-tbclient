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
    public boolean Sj;
    private CustomMessageListener bvt;
    public TextLineView hvh;
    public TextLineView hvi;
    public TextView hvj;
    public TextView hvk;
    public View hvl;
    public View hvm;
    public View hvn;
    public TextLineView hvo;
    public View hvp;
    private com.baidu.tieba.pb.pb.godreply.usertips.a hvq;
    private List<TextLineView> hvr;
    private int hvs;
    private View.OnClickListener hvt;
    private com.baidu.tieba.pb.data.h hvu;
    private BdUniqueId hvv;
    private BdUniqueId hvw;
    private View.OnClickListener hvx;
    private View.OnClickListener hvy;
    private CustomMessageListener hvz;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hvq = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.hvs = 0;
        this.Sj = true;
        this.hvx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hvt != null) {
                    al.this.hvt.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kY()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.hvr) {
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
        this.hvy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hvt != null) {
                    al.this.hvt.onClick(view2);
                }
            }
        };
        this.bvt = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hvu != null && al.this.hvu.mType == com.baidu.tieba.pb.data.h.hkG && customResponsedMessage != null && getTag() == al.this.hvv && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).hyF = al.this;
                }
            }
        };
        this.hvz = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hvu != null && al.this.hvu.mType == com.baidu.tieba.pb.data.h.hkH && customResponsedMessage != null && getTag() == al.this.hvw && (customResponsedMessage.getData() instanceof aq.a) && al.this.mRootView != null && al.this.hvq.bJk() && al.this.hvk != null && al.this.hvk.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.hvq.hideTip();
                        return;
                    }
                    if (!al.this.hvq.bJk() && !com.baidu.tieba.pb.pb.godreply.usertips.b.en(al.this.mRootView.getContext())) {
                        al.this.hvq.showTip(al.this.hvk);
                    }
                    if (al.this.hvq.bJk()) {
                        al.this.hvq.cj(al.this.hvk);
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
            this.hvh = (TextLineView) view.findViewById(d.g.reply_title);
            this.hvh.setOnClickListener(this.hvx);
            this.hvn = view.findViewById(d.g.reply_god_title_group);
            this.hvo = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.hvo.setSelected(false);
            this.hvp = view.findViewById(d.g.reply_all_title);
            this.hvi = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.hvi.setOnClickListener(this.hvx);
            this.hvj = (TextView) view.findViewById(d.g.pb_sort);
            this.hvj.setOnClickListener(this.hvy);
            this.hvk = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.hvh.setSelected(true);
            this.hvi.setSelected(false);
            this.hvr = new ArrayList();
            this.hvr.add(this.hvh);
            this.hvr.add(this.hvi);
            this.hvl = view.findViewById(d.g.divider_with_reply_title);
            this.hvm = view.findViewById(d.g.divider_bottom);
            if (com.baidu.tbadk.util.a.apM().afN()) {
                aw(2, "");
            } else {
                aw(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aw(int i, String str) {
        this.hvs = i;
        this.hvj.setVisibility(0);
        if (str.length() > 0) {
            this.hvj.setText(str);
        } else if (this.hvs == 0) {
            this.hvj.setText(d.j.default_sort);
        } else if (this.hvs == 1) {
            this.hvj.setText(d.j.view_reverse);
        } else if (this.hvs == 2) {
            this.hvj.setText(d.j.view_hot);
        }
    }

    public void nI(boolean z) {
        if (z) {
            this.hvi.setSelected(true);
            this.hvh.setSelected(false);
            return;
        }
        this.hvi.setSelected(false);
        this.hvh.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.hvu = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.hkH) {
                final Context context = this.hvn.getContext();
                if (TextUtils.isEmpty(hVar.hkJ)) {
                    this.hvp.setVisibility(0);
                    this.hvn.setVisibility(8);
                    this.hvh.setVisibility(0);
                    this.hvh.setSelected(false);
                    this.hvh.setClickable(false);
                    this.hvh.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.hvp.setVisibility(8);
                    this.hvh.setVisibility(8);
                    this.hvn.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.l(context, true);
                            al.this.hvq.hideTip();
                            if (al.this.hvt != null) {
                                al.this.hvt.onClick(al.this.hvn);
                            }
                        }
                    };
                    this.hvn.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.en(context) && this.hvk != null && this.hvk.getVisibility() == 0 && !this.hvq.bJk()) {
                        this.hvq.K(onClickListener);
                        this.hvq.showTip(this.hvk);
                    }
                }
                this.hvj.setVisibility(8);
                this.hvi.setVisibility(8);
                this.hvm.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.hkG) {
                this.hvn.setVisibility(8);
                this.hvp.setVisibility(0);
                this.hvh.setClickable(true);
                this.hvh.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.hvj.setVisibility(0);
                this.hvi.setVisibility(0);
                nI(hVar.hkL);
                aw(hVar.sortType, hVar.hkK);
                this.hvm.setVisibility(0);
            }
            if (this.Sj) {
                this.hvm.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds16);
            } else {
                this.hvm.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds2);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.l(this.hvp, d.C0277d.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.l(this.hvn, d.C0277d.cp_bg_line_d);
            this.hvh.onChangeSkinType(i);
            this.hvi.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.j(this.hvo, d.C0277d.cp_cont_b);
            if (this.hvu != null && this.hvu.mType == com.baidu.tieba.pb.data.h.hkH) {
                com.baidu.tbadk.core.util.al.d(this.hvh, d.C0277d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.j(this.hvk, d.C0277d.cp_cont_j);
            this.hvk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.j(this.hvj, d.C0277d.cp_cont_j);
            com.baidu.tbadk.core.util.al.l(this.hvl, d.C0277d.cp_bg_line_e);
            this.hvj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.hvq.onChangeSkinType(i);
            if (this.Sj) {
                com.baidu.tbadk.core.util.al.k(this.hvm, d.f.top_shadow);
            } else {
                com.baidu.tbadk.core.util.al.l(this.hvm, d.C0277d.cp_bg_line_c);
            }
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.hvv = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.bvt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bvt);
    }

    public void o(BdUniqueId bdUniqueId) {
        this.hvw = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.hvz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hvz);
    }

    public void L(View.OnClickListener onClickListener) {
        this.hvt = onClickListener;
    }
}
