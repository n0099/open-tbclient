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
    public boolean Sk;
    private CustomMessageListener bvx;
    public TextLineView huV;
    public TextLineView huW;
    public TextView huX;
    public TextView huY;
    public View huZ;
    public View hva;
    public View hvb;
    public TextLineView hvc;
    public View hvd;
    private com.baidu.tieba.pb.pb.godreply.usertips.a hve;
    private List<TextLineView> hvf;
    private int hvg;
    private View.OnClickListener hvh;
    private com.baidu.tieba.pb.data.h hvi;
    private BdUniqueId hvj;
    private BdUniqueId hvk;
    private View.OnClickListener hvl;
    private View.OnClickListener hvm;
    private CustomMessageListener hvn;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hve = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.hvg = 0;
        this.Sk = true;
        this.hvl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hvh != null) {
                    al.this.hvh.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kY()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.hvf) {
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
        this.hvm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hvh != null) {
                    al.this.hvh.onClick(view2);
                }
            }
        };
        this.bvx = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hvi != null && al.this.hvi.mType == com.baidu.tieba.pb.data.h.hku && customResponsedMessage != null && getTag() == al.this.hvj && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).hys = al.this;
                }
            }
        };
        this.hvn = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hvi != null && al.this.hvi.mType == com.baidu.tieba.pb.data.h.hkv && customResponsedMessage != null && getTag() == al.this.hvk && (customResponsedMessage.getData() instanceof aq.a) && al.this.mRootView != null && al.this.hve.bJh() && al.this.huY != null && al.this.huY.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.hve.hideTip();
                        return;
                    }
                    if (!al.this.hve.bJh() && !com.baidu.tieba.pb.pb.godreply.usertips.b.en(al.this.mRootView.getContext())) {
                        al.this.hve.showTip(al.this.huY);
                    }
                    if (al.this.hve.bJh()) {
                        al.this.hve.cj(al.this.huY);
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
            this.huV = (TextLineView) view.findViewById(d.g.reply_title);
            this.huV.setOnClickListener(this.hvl);
            this.hvb = view.findViewById(d.g.reply_god_title_group);
            this.hvc = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.hvc.setSelected(false);
            this.hvd = view.findViewById(d.g.reply_all_title);
            this.huW = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.huW.setOnClickListener(this.hvl);
            this.huX = (TextView) view.findViewById(d.g.pb_sort);
            this.huX.setOnClickListener(this.hvm);
            this.huY = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.huV.setSelected(true);
            this.huW.setSelected(false);
            this.hvf = new ArrayList();
            this.hvf.add(this.huV);
            this.hvf.add(this.huW);
            this.huZ = view.findViewById(d.g.divider_with_reply_title);
            this.hva = view.findViewById(d.g.divider_bottom);
            if (com.baidu.tbadk.util.a.apJ().afK()) {
                ay(2, "");
            } else {
                ay(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ay(int i, String str) {
        this.hvg = i;
        this.huX.setVisibility(0);
        if (str.length() > 0) {
            this.huX.setText(str);
        } else if (this.hvg == 0) {
            this.huX.setText(d.j.default_sort);
        } else if (this.hvg == 1) {
            this.huX.setText(d.j.view_reverse);
        } else if (this.hvg == 2) {
            this.huX.setText(d.j.view_hot);
        }
    }

    public void nI(boolean z) {
        if (z) {
            this.huW.setSelected(true);
            this.huV.setSelected(false);
            return;
        }
        this.huW.setSelected(false);
        this.huV.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.hvi = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.hkv) {
                final Context context = this.hvb.getContext();
                if (TextUtils.isEmpty(hVar.hkx)) {
                    this.hvd.setVisibility(0);
                    this.hvb.setVisibility(8);
                    this.huV.setVisibility(0);
                    this.huV.setSelected(false);
                    this.huV.setClickable(false);
                    this.huV.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.hvd.setVisibility(8);
                    this.huV.setVisibility(8);
                    this.hvb.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.l(context, true);
                            al.this.hve.hideTip();
                            if (al.this.hvh != null) {
                                al.this.hvh.onClick(al.this.hvb);
                            }
                        }
                    };
                    this.hvb.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.en(context) && this.huY != null && this.huY.getVisibility() == 0 && !this.hve.bJh()) {
                        this.hve.K(onClickListener);
                        this.hve.showTip(this.huY);
                    }
                }
                this.huX.setVisibility(8);
                this.huW.setVisibility(8);
                this.hva.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.hku) {
                this.hvb.setVisibility(8);
                this.hvd.setVisibility(0);
                this.huV.setClickable(true);
                this.huV.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.huX.setVisibility(0);
                this.huW.setVisibility(0);
                nI(hVar.hkz);
                ay(hVar.sortType, hVar.hky);
                this.hva.setVisibility(0);
            }
            if (this.Sk) {
                this.hva.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds16);
            } else {
                this.hva.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds2);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.l(this.hvd, d.C0277d.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.l(this.hvb, d.C0277d.cp_bg_line_d);
            this.huV.onChangeSkinType(i);
            this.huW.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.j(this.hvc, d.C0277d.cp_cont_b);
            if (this.hvi != null && this.hvi.mType == com.baidu.tieba.pb.data.h.hkv) {
                com.baidu.tbadk.core.util.al.d(this.huV, d.C0277d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.j(this.huY, d.C0277d.cp_cont_j);
            this.huY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.j(this.huX, d.C0277d.cp_cont_j);
            com.baidu.tbadk.core.util.al.l(this.huZ, d.C0277d.cp_bg_line_e);
            this.huX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.hve.onChangeSkinType(i);
            if (this.Sk) {
                com.baidu.tbadk.core.util.al.k(this.hva, d.f.top_shadow);
            } else {
                com.baidu.tbadk.core.util.al.l(this.hva, d.C0277d.cp_bg_line_c);
            }
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.hvj = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.bvx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bvx);
    }

    public void o(BdUniqueId bdUniqueId) {
        this.hvk = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.hvn.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hvn);
    }

    public void L(View.OnClickListener onClickListener) {
        this.hvh = onClickListener;
    }
}
