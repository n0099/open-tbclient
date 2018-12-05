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
    private CustomMessageListener aof;
    private CustomMessageListener gbA;
    public TextLineView gbi;
    public TextLineView gbj;
    public TextView gbk;
    public TextView gbl;
    public View gbm;
    public View gbn;
    public View gbo;
    public TextLineView gbp;
    public View gbq;
    private com.baidu.tieba.pb.pb.godreply.usertips.a gbr;
    private List<TextLineView> gbs;
    private int gbt;
    private View.OnClickListener gbu;
    private com.baidu.tieba.pb.data.h gbv;
    private BdUniqueId gbw;
    private BdUniqueId gbx;
    private View.OnClickListener gby;
    private View.OnClickListener gbz;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.gbr = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.gbt = 0;
        this.gby = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.gbu != null) {
                    al.this.gbu.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kV()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.gbs) {
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
        this.gbz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.gbu != null) {
                    al.this.gbu.onClick(view2);
                }
            }
        };
        this.aof = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.gbv != null && al.this.gbv.mType == com.baidu.tieba.pb.data.h.fQE && customResponsedMessage != null && getTag() == al.this.gbw && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).geM = al.this;
                }
            }
        };
        this.gbA = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.gbv != null && al.this.gbv.mType == com.baidu.tieba.pb.data.h.fQF && customResponsedMessage != null && getTag() == al.this.gbx && (customResponsedMessage.getData() instanceof ar.a) && al.this.mRootView != null && al.this.gbr.bhy() && al.this.gbl != null && al.this.gbl.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.gbr.hideTip();
                        return;
                    }
                    if (!al.this.gbr.bhy() && !com.baidu.tieba.pb.pb.godreply.usertips.b.cS(al.this.mRootView.getContext())) {
                        al.this.gbr.showTip(al.this.gbl);
                    }
                    if (al.this.gbr.bhy()) {
                        al.this.gbr.br(al.this.gbl);
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
            this.gbi = (TextLineView) view.findViewById(e.g.reply_title);
            this.gbi.setOnClickListener(this.gby);
            this.gbo = view.findViewById(e.g.reply_god_title_group);
            this.gbp = (TextLineView) view.findViewById(e.g.reply_god_title);
            this.gbp.setSelected(false);
            this.gbq = view.findViewById(e.g.reply_all_title);
            this.gbj = (TextLineView) view.findViewById(e.g.floor_owner_reply);
            this.gbj.setOnClickListener(this.gby);
            this.gbk = (TextView) view.findViewById(e.g.pb_sort);
            this.gbk.setOnClickListener(this.gbz);
            this.gbl = (TextView) view.findViewById(e.g.pb_god_reply_entrance_text);
            this.gbi.setSelected(true);
            this.gbj.setSelected(false);
            this.gbs = new ArrayList();
            this.gbs.add(this.gbi);
            this.gbs.add(this.gbj);
            this.gbm = view.findViewById(e.g.divider_with_reply_title);
            this.gbn = view.findViewById(e.g.divider_bottom);
            if (com.baidu.tbadk.util.a.PH().Gf()) {
                ad(2, "");
            } else {
                ad(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ad(int i, String str) {
        this.gbt = i;
        this.gbk.setVisibility(0);
        if (str.length() > 0) {
            this.gbk.setText(str);
        } else if (this.gbt == 0) {
            this.gbk.setText(e.j.default_sort);
        } else if (this.gbt == 1) {
            this.gbk.setText(e.j.view_reverse);
        } else if (this.gbt == 2) {
            this.gbk.setText(e.j.view_hot);
        }
    }

    public void lf(boolean z) {
        if (z) {
            this.gbj.setSelected(true);
            this.gbi.setSelected(false);
            return;
        }
        this.gbj.setSelected(false);
        this.gbi.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.gbv = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fQF) {
                final Context context = this.gbo.getContext();
                if (TextUtils.isEmpty(hVar.fQH)) {
                    this.gbq.setVisibility(0);
                    this.gbo.setVisibility(8);
                    this.gbi.setVisibility(0);
                    this.gbi.setSelected(false);
                    this.gbi.setClickable(false);
                    this.gbi.setText(TbadkCoreApplication.getInst().getString(e.j.god_reply));
                } else {
                    this.gbq.setVisibility(8);
                    this.gbi.setVisibility(8);
                    this.gbo.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.l(context, true);
                            al.this.gbr.hideTip();
                            if (al.this.gbu != null) {
                                al.this.gbu.onClick(al.this.gbo);
                            }
                        }
                    };
                    this.gbo.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.cS(context) && this.gbl != null && this.gbl.getVisibility() == 0 && !this.gbr.bhy()) {
                        this.gbr.J(onClickListener);
                        this.gbr.showTip(this.gbl);
                    }
                }
                this.gbk.setVisibility(8);
                this.gbj.setVisibility(8);
                this.gbn.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fQE) {
                this.gbo.setVisibility(8);
                this.gbq.setVisibility(0);
                this.gbi.setClickable(true);
                this.gbi.setText(TbadkCoreApplication.getInst().getString(e.j.all_reply));
                this.gbk.setVisibility(0);
                this.gbj.setVisibility(0);
                lf(hVar.fQJ);
                ad(hVar.sortType, hVar.fQI);
                this.gbn.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.j(getView(), e.d.cp_bg_line_d);
            this.gbi.onChangeSkinType(i);
            this.gbj.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.h(this.gbp, e.d.cp_cont_b);
            if (this.gbv != null && this.gbv.mType == com.baidu.tieba.pb.data.h.fQF) {
                com.baidu.tbadk.core.util.al.c(this.gbi, e.d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.h(this.gbl, e.d.cp_cont_j);
            this.gbl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.h(this.gbk, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.j(this.gbm, e.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.al.j(this.gbn, e.d.cp_bg_line_c);
            this.gbk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_sort), (Drawable) null);
            this.gbr.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.gbw = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.aof.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aof);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.gbx = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.gbA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gbA);
    }

    public void L(View.OnClickListener onClickListener) {
        this.gbu = onClickListener;
    }
}
