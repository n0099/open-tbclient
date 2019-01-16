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
    private CustomMessageListener aoH;
    public TextLineView gfe;
    public TextLineView gff;
    public TextView gfg;
    public TextView gfh;
    public View gfi;
    public View gfj;
    public View gfk;
    public TextLineView gfl;
    public View gfm;
    private com.baidu.tieba.pb.pb.godreply.usertips.a gfn;
    private List<TextLineView> gfo;
    private int gfp;
    private View.OnClickListener gfq;
    private com.baidu.tieba.pb.data.h gfr;
    private BdUniqueId gfs;
    private BdUniqueId gft;
    private View.OnClickListener gfu;
    private View.OnClickListener gfv;
    private CustomMessageListener gfw;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.gfn = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.gfp = 0;
        this.gfu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.gfq != null) {
                    al.this.gfq.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kV()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.gfo) {
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
        this.gfv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.gfq != null) {
                    al.this.gfq.onClick(view2);
                }
            }
        };
        this.aoH = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.gfr != null && al.this.gfr.mType == com.baidu.tieba.pb.data.h.fUt && customResponsedMessage != null && getTag() == al.this.gfs && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).giI = al.this;
                }
            }
        };
        this.gfw = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.gfr != null && al.this.gfr.mType == com.baidu.tieba.pb.data.h.fUu && customResponsedMessage != null && getTag() == al.this.gft && (customResponsedMessage.getData() instanceof ar.a) && al.this.mRootView != null && al.this.gfn.biN() && al.this.gfh != null && al.this.gfh.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.gfn.hideTip();
                        return;
                    }
                    if (!al.this.gfn.biN() && !com.baidu.tieba.pb.pb.godreply.usertips.b.cS(al.this.mRootView.getContext())) {
                        al.this.gfn.showTip(al.this.gfh);
                    }
                    if (al.this.gfn.biN()) {
                        al.this.gfn.bu(al.this.gfh);
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
            this.gfe = (TextLineView) view.findViewById(e.g.reply_title);
            this.gfe.setOnClickListener(this.gfu);
            this.gfk = view.findViewById(e.g.reply_god_title_group);
            this.gfl = (TextLineView) view.findViewById(e.g.reply_god_title);
            this.gfl.setSelected(false);
            this.gfm = view.findViewById(e.g.reply_all_title);
            this.gff = (TextLineView) view.findViewById(e.g.floor_owner_reply);
            this.gff.setOnClickListener(this.gfu);
            this.gfg = (TextView) view.findViewById(e.g.pb_sort);
            this.gfg.setOnClickListener(this.gfv);
            this.gfh = (TextView) view.findViewById(e.g.pb_god_reply_entrance_text);
            this.gfe.setSelected(true);
            this.gff.setSelected(false);
            this.gfo = new ArrayList();
            this.gfo.add(this.gfe);
            this.gfo.add(this.gff);
            this.gfi = view.findViewById(e.g.divider_with_reply_title);
            this.gfj = view.findViewById(e.g.divider_bottom);
            if (com.baidu.tbadk.util.a.Qb().Gt()) {
                ag(2, "");
            } else {
                ag(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ag(int i, String str) {
        this.gfp = i;
        this.gfg.setVisibility(0);
        if (str.length() > 0) {
            this.gfg.setText(str);
        } else if (this.gfp == 0) {
            this.gfg.setText(e.j.default_sort);
        } else if (this.gfp == 1) {
            this.gfg.setText(e.j.view_reverse);
        } else if (this.gfp == 2) {
            this.gfg.setText(e.j.view_hot);
        }
    }

    public void li(boolean z) {
        if (z) {
            this.gff.setSelected(true);
            this.gfe.setSelected(false);
            return;
        }
        this.gff.setSelected(false);
        this.gfe.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.gfr = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fUu) {
                final Context context = this.gfk.getContext();
                if (TextUtils.isEmpty(hVar.fUw)) {
                    this.gfm.setVisibility(0);
                    this.gfk.setVisibility(8);
                    this.gfe.setVisibility(0);
                    this.gfe.setSelected(false);
                    this.gfe.setClickable(false);
                    this.gfe.setText(TbadkCoreApplication.getInst().getString(e.j.god_reply));
                } else {
                    this.gfm.setVisibility(8);
                    this.gfe.setVisibility(8);
                    this.gfk.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.l(context, true);
                            al.this.gfn.hideTip();
                            if (al.this.gfq != null) {
                                al.this.gfq.onClick(al.this.gfk);
                            }
                        }
                    };
                    this.gfk.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.cS(context) && this.gfh != null && this.gfh.getVisibility() == 0 && !this.gfn.biN()) {
                        this.gfn.J(onClickListener);
                        this.gfn.showTip(this.gfh);
                    }
                }
                this.gfg.setVisibility(8);
                this.gff.setVisibility(8);
                this.gfj.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fUt) {
                this.gfk.setVisibility(8);
                this.gfm.setVisibility(0);
                this.gfe.setClickable(true);
                this.gfe.setText(TbadkCoreApplication.getInst().getString(e.j.all_reply));
                this.gfg.setVisibility(0);
                this.gff.setVisibility(0);
                li(hVar.fUy);
                ag(hVar.sortType, hVar.fUx);
                this.gfj.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.j(getView(), e.d.cp_bg_line_d);
            this.gfe.onChangeSkinType(i);
            this.gff.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.h(this.gfl, e.d.cp_cont_b);
            if (this.gfr != null && this.gfr.mType == com.baidu.tieba.pb.data.h.fUu) {
                com.baidu.tbadk.core.util.al.c(this.gfe, e.d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.h(this.gfh, e.d.cp_cont_j);
            this.gfh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.h(this.gfg, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.j(this.gfi, e.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.al.j(this.gfj, e.d.cp_bg_line_c);
            this.gfg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_sort), (Drawable) null);
            this.gfn.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.gfs = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.aoH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aoH);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.gft = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.gfw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gfw);
    }

    public void L(View.OnClickListener onClickListener) {
        this.gfq = onClickListener;
    }
}
