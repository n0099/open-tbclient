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
    private CustomMessageListener aoI;
    public TextLineView gff;
    public TextLineView gfg;
    public TextView gfh;
    public TextView gfi;
    public View gfj;
    public View gfk;
    public View gfl;
    public TextLineView gfm;
    public View gfn;
    private com.baidu.tieba.pb.pb.godreply.usertips.a gfo;
    private List<TextLineView> gfp;
    private int gfq;
    private View.OnClickListener gfr;
    private com.baidu.tieba.pb.data.h gfs;
    private BdUniqueId gft;
    private BdUniqueId gfu;
    private View.OnClickListener gfv;
    private View.OnClickListener gfw;
    private CustomMessageListener gfx;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.gfo = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.gfq = 0;
        this.gfv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.gfr != null) {
                    al.this.gfr.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kV()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.gfp) {
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
        this.gfw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.gfr != null) {
                    al.this.gfr.onClick(view2);
                }
            }
        };
        this.aoI = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.gfs != null && al.this.gfs.mType == com.baidu.tieba.pb.data.h.fUu && customResponsedMessage != null && getTag() == al.this.gft && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).giJ = al.this;
                }
            }
        };
        this.gfx = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.gfs != null && al.this.gfs.mType == com.baidu.tieba.pb.data.h.fUv && customResponsedMessage != null && getTag() == al.this.gfu && (customResponsedMessage.getData() instanceof ar.a) && al.this.mRootView != null && al.this.gfo.biN() && al.this.gfi != null && al.this.gfi.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.gfo.hideTip();
                        return;
                    }
                    if (!al.this.gfo.biN() && !com.baidu.tieba.pb.pb.godreply.usertips.b.cS(al.this.mRootView.getContext())) {
                        al.this.gfo.showTip(al.this.gfi);
                    }
                    if (al.this.gfo.biN()) {
                        al.this.gfo.bu(al.this.gfi);
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
            this.gff = (TextLineView) view.findViewById(e.g.reply_title);
            this.gff.setOnClickListener(this.gfv);
            this.gfl = view.findViewById(e.g.reply_god_title_group);
            this.gfm = (TextLineView) view.findViewById(e.g.reply_god_title);
            this.gfm.setSelected(false);
            this.gfn = view.findViewById(e.g.reply_all_title);
            this.gfg = (TextLineView) view.findViewById(e.g.floor_owner_reply);
            this.gfg.setOnClickListener(this.gfv);
            this.gfh = (TextView) view.findViewById(e.g.pb_sort);
            this.gfh.setOnClickListener(this.gfw);
            this.gfi = (TextView) view.findViewById(e.g.pb_god_reply_entrance_text);
            this.gff.setSelected(true);
            this.gfg.setSelected(false);
            this.gfp = new ArrayList();
            this.gfp.add(this.gff);
            this.gfp.add(this.gfg);
            this.gfj = view.findViewById(e.g.divider_with_reply_title);
            this.gfk = view.findViewById(e.g.divider_bottom);
            if (com.baidu.tbadk.util.a.Qb().Gt()) {
                ag(2, "");
            } else {
                ag(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ag(int i, String str) {
        this.gfq = i;
        this.gfh.setVisibility(0);
        if (str.length() > 0) {
            this.gfh.setText(str);
        } else if (this.gfq == 0) {
            this.gfh.setText(e.j.default_sort);
        } else if (this.gfq == 1) {
            this.gfh.setText(e.j.view_reverse);
        } else if (this.gfq == 2) {
            this.gfh.setText(e.j.view_hot);
        }
    }

    public void li(boolean z) {
        if (z) {
            this.gfg.setSelected(true);
            this.gff.setSelected(false);
            return;
        }
        this.gfg.setSelected(false);
        this.gff.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.gfs = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fUv) {
                final Context context = this.gfl.getContext();
                if (TextUtils.isEmpty(hVar.fUx)) {
                    this.gfn.setVisibility(0);
                    this.gfl.setVisibility(8);
                    this.gff.setVisibility(0);
                    this.gff.setSelected(false);
                    this.gff.setClickable(false);
                    this.gff.setText(TbadkCoreApplication.getInst().getString(e.j.god_reply));
                } else {
                    this.gfn.setVisibility(8);
                    this.gff.setVisibility(8);
                    this.gfl.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.l(context, true);
                            al.this.gfo.hideTip();
                            if (al.this.gfr != null) {
                                al.this.gfr.onClick(al.this.gfl);
                            }
                        }
                    };
                    this.gfl.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.cS(context) && this.gfi != null && this.gfi.getVisibility() == 0 && !this.gfo.biN()) {
                        this.gfo.J(onClickListener);
                        this.gfo.showTip(this.gfi);
                    }
                }
                this.gfh.setVisibility(8);
                this.gfg.setVisibility(8);
                this.gfk.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fUu) {
                this.gfl.setVisibility(8);
                this.gfn.setVisibility(0);
                this.gff.setClickable(true);
                this.gff.setText(TbadkCoreApplication.getInst().getString(e.j.all_reply));
                this.gfh.setVisibility(0);
                this.gfg.setVisibility(0);
                li(hVar.fUz);
                ag(hVar.sortType, hVar.fUy);
                this.gfk.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.j(getView(), e.d.cp_bg_line_d);
            this.gff.onChangeSkinType(i);
            this.gfg.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.h(this.gfm, e.d.cp_cont_b);
            if (this.gfs != null && this.gfs.mType == com.baidu.tieba.pb.data.h.fUv) {
                com.baidu.tbadk.core.util.al.c(this.gff, e.d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.h(this.gfi, e.d.cp_cont_j);
            this.gfi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.h(this.gfh, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.j(this.gfj, e.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.al.j(this.gfk, e.d.cp_bg_line_c);
            this.gfh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_sort), (Drawable) null);
            this.gfo.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.gft = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.aoI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aoI);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.gfu = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.gfx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gfx);
    }

    public void L(View.OnClickListener onClickListener) {
        this.gfr = onClickListener;
    }
}
