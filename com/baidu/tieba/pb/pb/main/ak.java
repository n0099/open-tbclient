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
    private CustomMessageListener TJ;
    public TextLineView eZT;
    public TextLineView eZU;
    public TextView eZV;
    public TextView eZW;
    public View eZX;
    public View eZY;
    public View eZZ;
    public TextLineView faa;
    public View fab;
    private com.baidu.tieba.pb.pb.godreply.a.a fac;
    private List<TextLineView> fad;
    private int fae;
    private View.OnClickListener faf;
    private com.baidu.tieba.pb.data.j fag;
    private View.OnClickListener fah;
    private View.OnClickListener fai;
    private CustomMessageListener faj;
    private View mRootView;
    public int mSkinType;

    public ak(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fac = new com.baidu.tieba.pb.pb.godreply.a.a();
        this.fae = 0;
        this.fah = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.faf != null) {
                    ak.this.faf.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ak.this.fad) {
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
        this.fai = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.faf != null) {
                    ak.this.faf.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    ak.this.jH(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.TJ = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.ak.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fag != null && ak.this.fag.mType == com.baidu.tieba.pb.data.j.eOS && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.eOS && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).fdA = ak.this;
                }
            }
        };
        this.faj = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.ak.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fag != null && ak.this.fag.mType == com.baidu.tieba.pb.data.j.eOT && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.eOT && (customResponsedMessage.getData() instanceof ar.a) && ak.this.mRootView != null && ak.this.fac.aSz() && ak.this.eZW != null && ak.this.eZW.getVisibility() == 0) {
                    if (ak.this.mRootView == null || ak.this.mRootView.getParent() == null) {
                        ak.this.fac.hideTip();
                        return;
                    }
                    if (!ak.this.fac.aSz() && !com.baidu.tieba.pb.pb.godreply.a.c.bS(ak.this.mRootView.getContext())) {
                        ak.this.fac.showTip(ak.this.eZW);
                    }
                    if (ak.this.fac.aSz()) {
                        ak.this.fac.aY(ak.this.eZW);
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
            this.eZT = (TextLineView) view.findViewById(d.g.reply_title);
            this.eZT.setOnClickListener(this.fah);
            this.eZZ = view.findViewById(d.g.reply_god_title_group);
            this.faa = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.faa.setSelected(false);
            this.fab = view.findViewById(d.g.reply_all_title);
            this.eZU = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.eZU.setOnClickListener(this.fah);
            this.eZV = (TextView) view.findViewById(d.g.pb_sort);
            this.eZV.setOnClickListener(this.fai);
            this.eZW = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.eZT.setSelected(true);
            this.eZU.setSelected(false);
            this.fad = new ArrayList();
            this.fad.add(this.eZT);
            this.fad.add(this.eZU);
            this.eZX = view.findViewById(d.g.divider_with_reply_title);
            this.eZY = view.findViewById(d.g.divider_bottom);
            jH(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void jH(boolean z) {
        this.fae = z ? 0 : 1;
        this.eZV.setVisibility(0);
        if (this.fae == 1) {
            this.eZV.setText(d.j.default_sort);
        } else if (this.fae == 0) {
            this.eZV.setText(d.j.view_reverse);
        }
    }

    public void jI(boolean z) {
        if (z) {
            this.eZU.setSelected(true);
            this.eZT.setSelected(false);
            return;
        }
        this.eZU.setSelected(false);
        this.eZT.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.fag = jVar;
        if (jVar != null) {
            if (jVar.mType == com.baidu.tieba.pb.data.j.eOT) {
                final Context context = this.eZZ.getContext();
                if (TextUtils.isEmpty(jVar.eOV)) {
                    this.fab.setVisibility(0);
                    this.eZZ.setVisibility(8);
                    this.eZT.setVisibility(0);
                    this.eZT.setSelected(false);
                    this.eZT.setClickable(false);
                    this.eZT.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.fab.setVisibility(8);
                    this.eZT.setVisibility(8);
                    this.eZZ.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.a.c.t(context, true);
                            ak.this.fac.hideTip();
                            if (ak.this.faf != null) {
                                ak.this.faf.onClick(ak.this.eZZ);
                            }
                        }
                    };
                    this.eZZ.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.a.c.bS(context) && this.eZW != null && this.eZW.getVisibility() == 0 && !this.fac.aSz()) {
                        this.fac.E(onClickListener);
                        this.fac.showTip(this.eZW);
                    }
                }
                this.eZV.setVisibility(8);
                this.eZU.setVisibility(8);
                this.eZY.setVisibility(8);
            } else if (jVar.mType == com.baidu.tieba.pb.data.j.eOS) {
                this.eZZ.setVisibility(8);
                this.fab.setVisibility(0);
                this.eZT.setClickable(true);
                this.eZT.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.eZV.setVisibility(0);
                this.eZU.setVisibility(0);
                jI(jVar.eOW);
                jH(jVar.aFL);
                this.eZY.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.k(getView(), d.C0082d.cp_bg_line_d);
            this.eZT.onChangeSkinType(i);
            this.eZU.onChangeSkinType(i);
            com.baidu.tbadk.core.util.aj.i(this.faa, d.C0082d.cp_cont_b);
            if (this.fag != null && this.fag.mType == com.baidu.tieba.pb.data.j.eOT) {
                com.baidu.tbadk.core.util.aj.c(this.eZT, d.C0082d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.i(this.eZW, d.C0082d.cp_cont_j);
            this.eZW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.aj.i(this.eZV, d.C0082d.cp_cont_j);
            com.baidu.tbadk.core.util.aj.k(this.eZX, d.C0082d.cp_bg_line_e);
            com.baidu.tbadk.core.util.aj.k(this.eZY, d.C0082d.cp_bg_line_c);
            this.eZV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fac.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.TJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.TJ);
    }

    public void p(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.faj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.faj);
    }

    public void F(View.OnClickListener onClickListener) {
        this.faf = onClickListener;
    }
}
