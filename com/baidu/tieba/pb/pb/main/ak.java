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
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ak extends j.a {
    private CustomMessageListener TG;
    public TextLineView fbb;
    public TextLineView fbc;
    public TextView fbd;
    public TextView fbe;
    public View fbf;
    public View fbg;
    public View fbh;
    public TextLineView fbi;
    public View fbj;
    private com.baidu.tieba.pb.pb.godreply.a.a fbk;
    private List<TextLineView> fbl;
    private int fbm;
    private View.OnClickListener fbn;
    private com.baidu.tieba.pb.data.j fbo;
    private View.OnClickListener fbp;
    private View.OnClickListener fbq;
    private CustomMessageListener fbr;
    private View mRootView;
    public int mSkinType;

    public ak(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fbk = new com.baidu.tieba.pb.pb.godreply.a.a();
        this.fbm = 0;
        this.fbp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.fbn != null) {
                    ak.this.fbn.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ak.this.fbl) {
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
        this.fbq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.fbn != null) {
                    ak.this.fbn.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    ak.this.jI(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.TG = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.ak.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fbo != null && ak.this.fbo.mType == com.baidu.tieba.pb.data.j.eQa && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.eQa && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).feG = ak.this;
                }
            }
        };
        this.fbr = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.ak.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fbo != null && ak.this.fbo.mType == com.baidu.tieba.pb.data.j.eQb && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.eQb && (customResponsedMessage.getData() instanceof ar.a) && ak.this.mRootView != null && ak.this.fbk.aSI() && ak.this.fbe != null && ak.this.fbe.getVisibility() == 0) {
                    if (ak.this.mRootView == null || ak.this.mRootView.getParent() == null) {
                        ak.this.fbk.hideTip();
                        return;
                    }
                    if (!ak.this.fbk.aSI() && !com.baidu.tieba.pb.pb.godreply.a.c.bP(ak.this.mRootView.getContext())) {
                        ak.this.fbk.showTip(ak.this.fbe);
                    }
                    if (ak.this.fbk.aSI()) {
                        ak.this.fbk.bc(ak.this.fbe);
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
            this.fbb = (TextLineView) view.findViewById(d.g.reply_title);
            this.fbb.setOnClickListener(this.fbp);
            this.fbh = view.findViewById(d.g.reply_god_title_group);
            this.fbi = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.fbi.setSelected(false);
            this.fbj = view.findViewById(d.g.reply_all_title);
            this.fbc = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.fbc.setOnClickListener(this.fbp);
            this.fbd = (TextView) view.findViewById(d.g.pb_sort);
            this.fbd.setOnClickListener(this.fbq);
            this.fbe = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.fbb.setSelected(true);
            this.fbc.setSelected(false);
            this.fbl = new ArrayList();
            this.fbl.add(this.fbb);
            this.fbl.add(this.fbc);
            this.fbf = view.findViewById(d.g.divider_with_reply_title);
            this.fbg = view.findViewById(d.g.divider_bottom);
            jI(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void jI(boolean z) {
        this.fbm = z ? 0 : 1;
        this.fbd.setVisibility(0);
        if (this.fbm == 1) {
            this.fbd.setText(d.j.default_sort);
        } else if (this.fbm == 0) {
            this.fbd.setText(d.j.view_reverse);
        }
    }

    public void jJ(boolean z) {
        if (z) {
            this.fbc.setSelected(true);
            this.fbb.setSelected(false);
            return;
        }
        this.fbc.setSelected(false);
        this.fbb.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.fbo = jVar;
        if (jVar != null) {
            if (jVar.mType == com.baidu.tieba.pb.data.j.eQb) {
                final Context context = this.fbh.getContext();
                if (TextUtils.isEmpty(jVar.eQd)) {
                    this.fbj.setVisibility(0);
                    this.fbh.setVisibility(8);
                    this.fbb.setVisibility(0);
                    this.fbb.setSelected(false);
                    this.fbb.setClickable(false);
                    this.fbb.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.fbj.setVisibility(8);
                    this.fbb.setVisibility(8);
                    this.fbh.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.a.c.t(context, true);
                            ak.this.fbk.hideTip();
                            if (ak.this.fbn != null) {
                                ak.this.fbn.onClick(ak.this.fbh);
                            }
                        }
                    };
                    this.fbh.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.a.c.bP(context) && this.fbe != null && this.fbe.getVisibility() == 0 && !this.fbk.aSI()) {
                        this.fbk.E(onClickListener);
                        this.fbk.showTip(this.fbe);
                    }
                }
                this.fbd.setVisibility(8);
                this.fbc.setVisibility(8);
                this.fbg.setVisibility(8);
            } else if (jVar.mType == com.baidu.tieba.pb.data.j.eQa) {
                this.fbh.setVisibility(8);
                this.fbj.setVisibility(0);
                this.fbb.setClickable(true);
                this.fbb.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.fbd.setVisibility(0);
                this.fbc.setVisibility(0);
                jJ(jVar.eQe);
                jI(jVar.aFS);
                this.fbg.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.k(getView(), d.C0095d.cp_bg_line_d);
            this.fbb.onChangeSkinType(i);
            this.fbc.onChangeSkinType(i);
            com.baidu.tbadk.core.util.aj.i(this.fbi, d.C0095d.cp_cont_b);
            if (this.fbo != null && this.fbo.mType == com.baidu.tieba.pb.data.j.eQb) {
                com.baidu.tbadk.core.util.aj.c(this.fbb, d.C0095d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.i(this.fbe, d.C0095d.cp_cont_j);
            this.fbe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.aj.i(this.fbd, d.C0095d.cp_cont_j);
            com.baidu.tbadk.core.util.aj.k(this.fbf, d.C0095d.cp_bg_line_e);
            com.baidu.tbadk.core.util.aj.k(this.fbg, d.C0095d.cp_bg_line_c);
            this.fbd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fbk.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.TG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.TG);
    }

    public void p(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fbr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fbr);
    }

    public void F(View.OnClickListener onClickListener) {
        this.fbn = onClickListener;
    }
}
