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
    private CustomMessageListener TF;
    public TextLineView faW;
    public TextLineView faX;
    public TextView faY;
    public TextView faZ;
    public View fba;
    public View fbb;
    public View fbc;
    public TextLineView fbd;
    public View fbe;
    private com.baidu.tieba.pb.pb.godreply.a.a fbf;
    private List<TextLineView> fbg;
    private int fbh;
    private View.OnClickListener fbi;
    private com.baidu.tieba.pb.data.j fbj;
    private View.OnClickListener fbk;
    private View.OnClickListener fbl;
    private CustomMessageListener fbm;
    private View mRootView;
    public int mSkinType;

    public ak(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fbf = new com.baidu.tieba.pb.pb.godreply.a.a();
        this.fbh = 0;
        this.fbk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.fbi != null) {
                    ak.this.fbi.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ak.this.fbg) {
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
        this.fbl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.fbi != null) {
                    ak.this.fbi.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    ak.this.jI(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.TF = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.ak.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fbj != null && ak.this.fbj.mType == com.baidu.tieba.pb.data.j.ePV && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.ePV && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).feB = ak.this;
                }
            }
        };
        this.fbm = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.ak.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fbj != null && ak.this.fbj.mType == com.baidu.tieba.pb.data.j.ePW && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.ePW && (customResponsedMessage.getData() instanceof ar.a) && ak.this.mRootView != null && ak.this.fbf.aSH() && ak.this.faZ != null && ak.this.faZ.getVisibility() == 0) {
                    if (ak.this.mRootView == null || ak.this.mRootView.getParent() == null) {
                        ak.this.fbf.hideTip();
                        return;
                    }
                    if (!ak.this.fbf.aSH() && !com.baidu.tieba.pb.pb.godreply.a.c.bP(ak.this.mRootView.getContext())) {
                        ak.this.fbf.showTip(ak.this.faZ);
                    }
                    if (ak.this.fbf.aSH()) {
                        ak.this.fbf.bc(ak.this.faZ);
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
            this.faW = (TextLineView) view.findViewById(d.g.reply_title);
            this.faW.setOnClickListener(this.fbk);
            this.fbc = view.findViewById(d.g.reply_god_title_group);
            this.fbd = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.fbd.setSelected(false);
            this.fbe = view.findViewById(d.g.reply_all_title);
            this.faX = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.faX.setOnClickListener(this.fbk);
            this.faY = (TextView) view.findViewById(d.g.pb_sort);
            this.faY.setOnClickListener(this.fbl);
            this.faZ = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.faW.setSelected(true);
            this.faX.setSelected(false);
            this.fbg = new ArrayList();
            this.fbg.add(this.faW);
            this.fbg.add(this.faX);
            this.fba = view.findViewById(d.g.divider_with_reply_title);
            this.fbb = view.findViewById(d.g.divider_bottom);
            jI(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void jI(boolean z) {
        this.fbh = z ? 0 : 1;
        this.faY.setVisibility(0);
        if (this.fbh == 1) {
            this.faY.setText(d.j.default_sort);
        } else if (this.fbh == 0) {
            this.faY.setText(d.j.view_reverse);
        }
    }

    public void jJ(boolean z) {
        if (z) {
            this.faX.setSelected(true);
            this.faW.setSelected(false);
            return;
        }
        this.faX.setSelected(false);
        this.faW.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.fbj = jVar;
        if (jVar != null) {
            if (jVar.mType == com.baidu.tieba.pb.data.j.ePW) {
                final Context context = this.fbc.getContext();
                if (TextUtils.isEmpty(jVar.ePY)) {
                    this.fbe.setVisibility(0);
                    this.fbc.setVisibility(8);
                    this.faW.setVisibility(0);
                    this.faW.setSelected(false);
                    this.faW.setClickable(false);
                    this.faW.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.fbe.setVisibility(8);
                    this.faW.setVisibility(8);
                    this.fbc.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.a.c.t(context, true);
                            ak.this.fbf.hideTip();
                            if (ak.this.fbi != null) {
                                ak.this.fbi.onClick(ak.this.fbc);
                            }
                        }
                    };
                    this.fbc.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.a.c.bP(context) && this.faZ != null && this.faZ.getVisibility() == 0 && !this.fbf.aSH()) {
                        this.fbf.E(onClickListener);
                        this.fbf.showTip(this.faZ);
                    }
                }
                this.faY.setVisibility(8);
                this.faX.setVisibility(8);
                this.fbb.setVisibility(8);
            } else if (jVar.mType == com.baidu.tieba.pb.data.j.ePV) {
                this.fbc.setVisibility(8);
                this.fbe.setVisibility(0);
                this.faW.setClickable(true);
                this.faW.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.faY.setVisibility(0);
                this.faX.setVisibility(0);
                jJ(jVar.ePZ);
                jI(jVar.aFP);
                this.fbb.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.k(getView(), d.C0096d.cp_bg_line_d);
            this.faW.onChangeSkinType(i);
            this.faX.onChangeSkinType(i);
            com.baidu.tbadk.core.util.aj.i(this.fbd, d.C0096d.cp_cont_b);
            if (this.fbj != null && this.fbj.mType == com.baidu.tieba.pb.data.j.ePW) {
                com.baidu.tbadk.core.util.aj.c(this.faW, d.C0096d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.i(this.faZ, d.C0096d.cp_cont_j);
            this.faZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.aj.i(this.faY, d.C0096d.cp_cont_j);
            com.baidu.tbadk.core.util.aj.k(this.fba, d.C0096d.cp_bg_line_e);
            com.baidu.tbadk.core.util.aj.k(this.fbb, d.C0096d.cp_bg_line_c);
            this.faY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fbf.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.TF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.TF);
    }

    public void p(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fbm.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fbm);
    }

    public void F(View.OnClickListener onClickListener) {
        this.fbi = onClickListener;
    }
}
