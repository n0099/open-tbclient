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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ak extends q.a {
    private CustomMessageListener UN;
    public TextLineView fmZ;
    public TextLineView fna;
    public TextView fnb;
    public TextView fnc;
    public View fnd;
    public View fne;
    public View fnf;
    public TextLineView fng;
    public View fnh;
    private com.baidu.tieba.pb.pb.godreply.usertips.a fni;
    private List<TextLineView> fnj;
    private int fnk;
    private View.OnClickListener fnl;
    private com.baidu.tieba.pb.data.h fnm;
    private BdUniqueId fnn;
    private BdUniqueId fno;
    private View.OnClickListener fnp;
    private View.OnClickListener fnq;
    private CustomMessageListener fnr;
    private View mRootView;
    public int mSkinType;

    public ak(TbPageContext tbPageContext, View view2) {
        super(view2);
        this.mSkinType = 3;
        this.fni = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.fnk = 0;
        this.fnp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (ak.this.fnl != null) {
                    ak.this.fnl.onClick(view3);
                }
                if (com.baidu.adp.lib.util.j.gP()) {
                    if (view3 == null || !(view3.getTag() instanceof Boolean) || ((Boolean) view3.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ak.this.fnj) {
                            if (textLineView != null) {
                                if (textLineView != view3) {
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
        this.fnq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (ak.this.fnl != null) {
                    ak.this.fnl.onClick(view3);
                }
                if (com.baidu.adp.lib.util.j.gP() && view3 != null && (view3.getTag() instanceof Boolean)) {
                    ak.this.jZ(!((Boolean) view3.getTag()).booleanValue());
                }
            }
        };
        this.UN = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fnm != null && ak.this.fnm.mType == com.baidu.tieba.pb.data.h.fcy && customResponsedMessage != null && getTag() == ak.this.fnn && (customResponsedMessage.getData() instanceof as.a)) {
                    ((as.a) customResponsedMessage.getData()).fqN = ak.this;
                }
            }
        };
        this.fnr = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fnm != null && ak.this.fnm.mType == com.baidu.tieba.pb.data.h.fcz && customResponsedMessage != null && getTag() == ak.this.fno && (customResponsedMessage.getData() instanceof as.a) && ak.this.mRootView != null && ak.this.fni.aWH() && ak.this.fnc != null && ak.this.fnc.getVisibility() == 0) {
                    if (ak.this.mRootView == null || ak.this.mRootView.getParent() == null) {
                        ak.this.fni.hideTip();
                        return;
                    }
                    if (!ak.this.fni.aWH() && !com.baidu.tieba.pb.pb.godreply.usertips.b.bP(ak.this.mRootView.getContext())) {
                        ak.this.fni.showTip(ak.this.fnc);
                    }
                    if (ak.this.fni.aWH()) {
                        ak.this.fni.aU(ak.this.fnc);
                    }
                }
            }
        };
        if (view2 != null) {
            this.mRootView = view2;
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                }
            });
            this.fmZ = (TextLineView) view2.findViewById(d.g.reply_title);
            this.fmZ.setOnClickListener(this.fnp);
            this.fnf = view2.findViewById(d.g.reply_god_title_group);
            this.fng = (TextLineView) view2.findViewById(d.g.reply_god_title);
            this.fng.setSelected(false);
            this.fnh = view2.findViewById(d.g.reply_all_title);
            this.fna = (TextLineView) view2.findViewById(d.g.floor_owner_reply);
            this.fna.setOnClickListener(this.fnp);
            this.fnb = (TextView) view2.findViewById(d.g.pb_sort);
            this.fnb.setOnClickListener(this.fnq);
            this.fnc = (TextView) view2.findViewById(d.g.pb_god_reply_entrance_text);
            this.fmZ.setSelected(true);
            this.fna.setSelected(false);
            this.fnj = new ArrayList();
            this.fnj.add(this.fmZ);
            this.fnj.add(this.fna);
            this.fnd = view2.findViewById(d.g.divider_with_reply_title);
            this.fne = view2.findViewById(d.g.divider_bottom);
            jZ(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void jZ(boolean z) {
        this.fnk = z ? 0 : 1;
        this.fnb.setVisibility(0);
        if (this.fnk == 1) {
            this.fnb.setText(d.k.default_sort);
        } else if (this.fnk == 0) {
            this.fnb.setText(d.k.view_reverse);
        }
    }

    public void ka(boolean z) {
        if (z) {
            this.fna.setSelected(true);
            this.fmZ.setSelected(false);
            return;
        }
        this.fna.setSelected(false);
        this.fmZ.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fnm = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fcz) {
                final Context context = this.fnf.getContext();
                if (TextUtils.isEmpty(hVar.fcB)) {
                    this.fnh.setVisibility(0);
                    this.fnf.setVisibility(8);
                    this.fmZ.setVisibility(0);
                    this.fmZ.setSelected(false);
                    this.fmZ.setClickable(false);
                    this.fmZ.setText(TbadkCoreApplication.getInst().getString(d.k.god_reply));
                } else {
                    this.fnh.setVisibility(8);
                    this.fmZ.setVisibility(8);
                    this.fnf.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.u(context, true);
                            ak.this.fni.hideTip();
                            if (ak.this.fnl != null) {
                                ak.this.fnl.onClick(ak.this.fnf);
                            }
                        }
                    };
                    this.fnf.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.bP(context) && this.fnc != null && this.fnc.getVisibility() == 0 && !this.fni.aWH()) {
                        this.fni.G(onClickListener);
                        this.fni.showTip(this.fnc);
                    }
                }
                this.fnb.setVisibility(8);
                this.fna.setVisibility(8);
                this.fne.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fcy) {
                this.fnf.setVisibility(8);
                this.fnh.setVisibility(0);
                this.fmZ.setClickable(true);
                this.fmZ.setText(TbadkCoreApplication.getInst().getString(d.k.all_reply));
                this.fnb.setVisibility(0);
                this.fna.setVisibility(0);
                ka(hVar.fcC);
                jZ(hVar.isNew);
                this.fne.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ak.j(getView(), d.C0126d.cp_bg_line_d);
            this.fmZ.onChangeSkinType(i);
            this.fna.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ak.h(this.fng, d.C0126d.cp_cont_b);
            if (this.fnm != null && this.fnm.mType == com.baidu.tieba.pb.data.h.fcz) {
                com.baidu.tbadk.core.util.ak.c(this.fmZ, d.C0126d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.ak.h(this.fnc, d.C0126d.cp_cont_j);
            this.fnc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.ak.h(this.fnb, d.C0126d.cp_cont_j);
            com.baidu.tbadk.core.util.ak.j(this.fnd, d.C0126d.cp_bg_line_e);
            com.baidu.tbadk.core.util.ak.j(this.fne, d.C0126d.cp_bg_line_c);
            this.fnb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fni.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fnn = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.UN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.UN);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fno = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fnr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fnr);
    }

    public void H(View.OnClickListener onClickListener) {
        this.fnl = onClickListener;
    }
}
