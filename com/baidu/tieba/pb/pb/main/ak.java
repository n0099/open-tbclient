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
    private CustomMessageListener UJ;
    public TextLineView fog;
    public TextLineView foh;
    public TextView foi;
    public TextView foj;
    public View fok;
    public View fol;
    public View fom;
    public TextLineView fon;
    public View foo;
    private com.baidu.tieba.pb.pb.godreply.usertips.a fop;
    private List<TextLineView> foq;

    /* renamed from: for  reason: not valid java name */
    private int f0for;
    private View.OnClickListener fot;
    private com.baidu.tieba.pb.data.h fou;
    private BdUniqueId fov;
    private BdUniqueId fow;
    private View.OnClickListener fox;
    private View.OnClickListener foy;
    private CustomMessageListener foz;
    private View mRootView;
    public int mSkinType;

    public ak(TbPageContext tbPageContext, View view2) {
        super(view2);
        this.mSkinType = 3;
        this.fop = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.f0for = 0;
        this.fox = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (ak.this.fot != null) {
                    ak.this.fot.onClick(view3);
                }
                if (com.baidu.adp.lib.util.j.gP()) {
                    if (view3 == null || !(view3.getTag() instanceof Boolean) || ((Boolean) view3.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ak.this.foq) {
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
        this.foy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (ak.this.fot != null) {
                    ak.this.fot.onClick(view3);
                }
                if (com.baidu.adp.lib.util.j.gP() && view3 != null && (view3.getTag() instanceof Boolean)) {
                    ak.this.ka(!((Boolean) view3.getTag()).booleanValue());
                }
            }
        };
        this.UJ = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fou != null && ak.this.fou.mType == com.baidu.tieba.pb.data.h.fdF && customResponsedMessage != null && getTag() == ak.this.fov && (customResponsedMessage.getData() instanceof as.a)) {
                    ((as.a) customResponsedMessage.getData()).frV = ak.this;
                }
            }
        };
        this.foz = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fou != null && ak.this.fou.mType == com.baidu.tieba.pb.data.h.fdG && customResponsedMessage != null && getTag() == ak.this.fow && (customResponsedMessage.getData() instanceof as.a) && ak.this.mRootView != null && ak.this.fop.aWH() && ak.this.foj != null && ak.this.foj.getVisibility() == 0) {
                    if (ak.this.mRootView == null || ak.this.mRootView.getParent() == null) {
                        ak.this.fop.hideTip();
                        return;
                    }
                    if (!ak.this.fop.aWH() && !com.baidu.tieba.pb.pb.godreply.usertips.b.bP(ak.this.mRootView.getContext())) {
                        ak.this.fop.showTip(ak.this.foj);
                    }
                    if (ak.this.fop.aWH()) {
                        ak.this.fop.aU(ak.this.foj);
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
            this.fog = (TextLineView) view2.findViewById(d.g.reply_title);
            this.fog.setOnClickListener(this.fox);
            this.fom = view2.findViewById(d.g.reply_god_title_group);
            this.fon = (TextLineView) view2.findViewById(d.g.reply_god_title);
            this.fon.setSelected(false);
            this.foo = view2.findViewById(d.g.reply_all_title);
            this.foh = (TextLineView) view2.findViewById(d.g.floor_owner_reply);
            this.foh.setOnClickListener(this.fox);
            this.foi = (TextView) view2.findViewById(d.g.pb_sort);
            this.foi.setOnClickListener(this.foy);
            this.foj = (TextView) view2.findViewById(d.g.pb_god_reply_entrance_text);
            this.fog.setSelected(true);
            this.foh.setSelected(false);
            this.foq = new ArrayList();
            this.foq.add(this.fog);
            this.foq.add(this.foh);
            this.fok = view2.findViewById(d.g.divider_with_reply_title);
            this.fol = view2.findViewById(d.g.divider_bottom);
            ka(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ka(boolean z) {
        this.f0for = z ? 0 : 1;
        this.foi.setVisibility(0);
        if (this.f0for == 1) {
            this.foi.setText(d.k.default_sort);
        } else if (this.f0for == 0) {
            this.foi.setText(d.k.view_reverse);
        }
    }

    public void kb(boolean z) {
        if (z) {
            this.foh.setSelected(true);
            this.fog.setSelected(false);
            return;
        }
        this.foh.setSelected(false);
        this.fog.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fou = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fdG) {
                final Context context = this.fom.getContext();
                if (TextUtils.isEmpty(hVar.fdI)) {
                    this.foo.setVisibility(0);
                    this.fom.setVisibility(8);
                    this.fog.setVisibility(0);
                    this.fog.setSelected(false);
                    this.fog.setClickable(false);
                    this.fog.setText(TbadkCoreApplication.getInst().getString(d.k.god_reply));
                } else {
                    this.foo.setVisibility(8);
                    this.fog.setVisibility(8);
                    this.fom.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.u(context, true);
                            ak.this.fop.hideTip();
                            if (ak.this.fot != null) {
                                ak.this.fot.onClick(ak.this.fom);
                            }
                        }
                    };
                    this.fom.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.bP(context) && this.foj != null && this.foj.getVisibility() == 0 && !this.fop.aWH()) {
                        this.fop.G(onClickListener);
                        this.fop.showTip(this.foj);
                    }
                }
                this.foi.setVisibility(8);
                this.foh.setVisibility(8);
                this.fol.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fdF) {
                this.fom.setVisibility(8);
                this.foo.setVisibility(0);
                this.fog.setClickable(true);
                this.fog.setText(TbadkCoreApplication.getInst().getString(d.k.all_reply));
                this.foi.setVisibility(0);
                this.foh.setVisibility(0);
                kb(hVar.fdJ);
                ka(hVar.isNew);
                this.fol.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ak.j(getView(), d.C0126d.cp_bg_line_d);
            this.fog.onChangeSkinType(i);
            this.foh.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ak.h(this.fon, d.C0126d.cp_cont_b);
            if (this.fou != null && this.fou.mType == com.baidu.tieba.pb.data.h.fdG) {
                com.baidu.tbadk.core.util.ak.c(this.fog, d.C0126d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.ak.h(this.foj, d.C0126d.cp_cont_j);
            this.foj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.ak.h(this.foi, d.C0126d.cp_cont_j);
            com.baidu.tbadk.core.util.ak.j(this.fok, d.C0126d.cp_bg_line_e);
            com.baidu.tbadk.core.util.ak.j(this.fol, d.C0126d.cp_bg_line_c);
            this.foi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fop.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fov = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.UJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.UJ);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fow = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.foz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.foz);
    }

    public void H(View.OnClickListener onClickListener) {
        this.fot = onClickListener;
    }
}
