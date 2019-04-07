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
    private CustomMessageListener bvw;
    public TextLineView huU;
    public TextLineView huV;
    public TextView huW;
    public TextView huX;
    public View huY;
    public View huZ;
    public View hva;
    public TextLineView hvb;
    public View hvc;
    private com.baidu.tieba.pb.pb.godreply.usertips.a hvd;
    private List<TextLineView> hve;
    private int hvf;
    private View.OnClickListener hvg;
    private com.baidu.tieba.pb.data.h hvh;
    private BdUniqueId hvi;
    private BdUniqueId hvj;
    private View.OnClickListener hvk;
    private View.OnClickListener hvl;
    private CustomMessageListener hvm;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hvd = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.hvf = 0;
        this.Sj = true;
        this.hvk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hvg != null) {
                    al.this.hvg.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kY()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.hve) {
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
        this.hvl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hvg != null) {
                    al.this.hvg.onClick(view2);
                }
            }
        };
        this.bvw = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hvh != null && al.this.hvh.mType == com.baidu.tieba.pb.data.h.hkt && customResponsedMessage != null && getTag() == al.this.hvi && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).hyr = al.this;
                }
            }
        };
        this.hvm = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hvh != null && al.this.hvh.mType == com.baidu.tieba.pb.data.h.hku && customResponsedMessage != null && getTag() == al.this.hvj && (customResponsedMessage.getData() instanceof aq.a) && al.this.mRootView != null && al.this.hvd.bJh() && al.this.huX != null && al.this.huX.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.hvd.hideTip();
                        return;
                    }
                    if (!al.this.hvd.bJh() && !com.baidu.tieba.pb.pb.godreply.usertips.b.en(al.this.mRootView.getContext())) {
                        al.this.hvd.showTip(al.this.huX);
                    }
                    if (al.this.hvd.bJh()) {
                        al.this.hvd.cj(al.this.huX);
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
            this.huU = (TextLineView) view.findViewById(d.g.reply_title);
            this.huU.setOnClickListener(this.hvk);
            this.hva = view.findViewById(d.g.reply_god_title_group);
            this.hvb = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.hvb.setSelected(false);
            this.hvc = view.findViewById(d.g.reply_all_title);
            this.huV = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.huV.setOnClickListener(this.hvk);
            this.huW = (TextView) view.findViewById(d.g.pb_sort);
            this.huW.setOnClickListener(this.hvl);
            this.huX = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.huU.setSelected(true);
            this.huV.setSelected(false);
            this.hve = new ArrayList();
            this.hve.add(this.huU);
            this.hve.add(this.huV);
            this.huY = view.findViewById(d.g.divider_with_reply_title);
            this.huZ = view.findViewById(d.g.divider_bottom);
            if (com.baidu.tbadk.util.a.apJ().afK()) {
                ay(2, "");
            } else {
                ay(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ay(int i, String str) {
        this.hvf = i;
        this.huW.setVisibility(0);
        if (str.length() > 0) {
            this.huW.setText(str);
        } else if (this.hvf == 0) {
            this.huW.setText(d.j.default_sort);
        } else if (this.hvf == 1) {
            this.huW.setText(d.j.view_reverse);
        } else if (this.hvf == 2) {
            this.huW.setText(d.j.view_hot);
        }
    }

    public void nI(boolean z) {
        if (z) {
            this.huV.setSelected(true);
            this.huU.setSelected(false);
            return;
        }
        this.huV.setSelected(false);
        this.huU.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.hvh = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.hku) {
                final Context context = this.hva.getContext();
                if (TextUtils.isEmpty(hVar.hkw)) {
                    this.hvc.setVisibility(0);
                    this.hva.setVisibility(8);
                    this.huU.setVisibility(0);
                    this.huU.setSelected(false);
                    this.huU.setClickable(false);
                    this.huU.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.hvc.setVisibility(8);
                    this.huU.setVisibility(8);
                    this.hva.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.l(context, true);
                            al.this.hvd.hideTip();
                            if (al.this.hvg != null) {
                                al.this.hvg.onClick(al.this.hva);
                            }
                        }
                    };
                    this.hva.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.en(context) && this.huX != null && this.huX.getVisibility() == 0 && !this.hvd.bJh()) {
                        this.hvd.K(onClickListener);
                        this.hvd.showTip(this.huX);
                    }
                }
                this.huW.setVisibility(8);
                this.huV.setVisibility(8);
                this.huZ.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.hkt) {
                this.hva.setVisibility(8);
                this.hvc.setVisibility(0);
                this.huU.setClickable(true);
                this.huU.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.huW.setVisibility(0);
                this.huV.setVisibility(0);
                nI(hVar.hky);
                ay(hVar.sortType, hVar.hkx);
                this.huZ.setVisibility(0);
            }
            if (this.Sj) {
                this.huZ.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds16);
            } else {
                this.huZ.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds2);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.l(this.hvc, d.C0277d.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.l(this.hva, d.C0277d.cp_bg_line_d);
            this.huU.onChangeSkinType(i);
            this.huV.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.j(this.hvb, d.C0277d.cp_cont_b);
            if (this.hvh != null && this.hvh.mType == com.baidu.tieba.pb.data.h.hku) {
                com.baidu.tbadk.core.util.al.d(this.huU, d.C0277d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.j(this.huX, d.C0277d.cp_cont_j);
            this.huX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.j(this.huW, d.C0277d.cp_cont_j);
            com.baidu.tbadk.core.util.al.l(this.huY, d.C0277d.cp_bg_line_e);
            this.huW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.hvd.onChangeSkinType(i);
            if (this.Sj) {
                com.baidu.tbadk.core.util.al.k(this.huZ, d.f.top_shadow);
            } else {
                com.baidu.tbadk.core.util.al.l(this.huZ, d.C0277d.cp_bg_line_c);
            }
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.hvi = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.bvw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bvw);
    }

    public void o(BdUniqueId bdUniqueId) {
        this.hvj = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.hvm.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hvm);
    }

    public void L(View.OnClickListener onClickListener) {
        this.hvg = onClickListener;
    }
}
