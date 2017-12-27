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
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class al extends r.a {
    private CustomMessageListener aIh;
    public TextLineView fNT;
    public TextLineView fNU;
    public TextView fNV;
    public TextView fNW;
    public View fNX;
    public View fNY;
    public View fNZ;
    public TextLineView fOa;
    public View fOb;
    private com.baidu.tieba.pb.pb.godreply.a.a fOc;
    private List<TextLineView> fOd;
    private int fOe;
    private View.OnClickListener fOf;
    private com.baidu.tieba.pb.data.j fOg;
    private View.OnClickListener fOh;
    private View.OnClickListener fOi;
    private CustomMessageListener fOj;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fOc = new com.baidu.tieba.pb.pb.godreply.a.a();
        this.fOe = 0;
        this.fOh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fOf != null) {
                    al.this.fOf.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.oI()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.fOd) {
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
        this.fOi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fOf != null) {
                    al.this.fOf.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.oI() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    al.this.kk(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.aIh = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fOg != null && al.this.fOg.mType == com.baidu.tieba.pb.data.j.fCA && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.fCA && (customResponsedMessage.getData() instanceof as.a)) {
                    ((as.a) customResponsedMessage.getData()).fRz = al.this;
                }
            }
        };
        this.fOj = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fOg != null && al.this.fOg.mType == com.baidu.tieba.pb.data.j.fCB && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.fCB && (customResponsedMessage.getData() instanceof as.a) && al.this.mRootView != null && al.this.fOc.aZU() && al.this.fNW != null && al.this.fNW.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.fOc.hideTip();
                        return;
                    }
                    if (!al.this.fOc.aZU() && !com.baidu.tieba.pb.pb.godreply.a.c.ca(al.this.mRootView.getContext())) {
                        al.this.fOc.showTip(al.this.fNW);
                    }
                    if (al.this.fOc.aZU()) {
                        al.this.fOc.cn(al.this.fNW);
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
            this.fNT = (TextLineView) view.findViewById(d.g.reply_title);
            this.fNT.setOnClickListener(this.fOh);
            this.fNZ = view.findViewById(d.g.reply_god_title_group);
            this.fOa = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.fOa.setSelected(false);
            this.fOb = view.findViewById(d.g.reply_all_title);
            this.fNU = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.fNU.setOnClickListener(this.fOh);
            this.fNV = (TextView) view.findViewById(d.g.pb_sort);
            this.fNV.setOnClickListener(this.fOi);
            this.fNW = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.fNT.setSelected(true);
            this.fNU.setSelected(false);
            this.fOd = new ArrayList();
            this.fOd.add(this.fNT);
            this.fOd.add(this.fNU);
            this.fNX = view.findViewById(d.g.divider_with_reply_title);
            this.fNY = view.findViewById(d.g.divider_bottom);
            kk(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void kk(boolean z) {
        this.fOe = z ? 0 : 1;
        this.fNV.setVisibility(0);
        if (this.fOe == 1) {
            this.fNV.setText(d.j.default_sort);
        } else if (this.fOe == 0) {
            this.fNV.setText(d.j.view_reverse);
        }
    }

    public void kl(boolean z) {
        if (z) {
            this.fNU.setSelected(true);
            this.fNT.setSelected(false);
            return;
        }
        this.fNU.setSelected(false);
        this.fNT.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.fOg = jVar;
        if (jVar != null) {
            if (jVar.mType == com.baidu.tieba.pb.data.j.fCB) {
                final Context context = this.fNZ.getContext();
                if (TextUtils.isEmpty(jVar.fCD)) {
                    this.fOb.setVisibility(0);
                    this.fNZ.setVisibility(8);
                    this.fNT.setVisibility(0);
                    this.fNT.setSelected(false);
                    this.fNT.setClickable(false);
                    this.fNT.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.fOb.setVisibility(8);
                    this.fNT.setVisibility(8);
                    this.fNZ.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.a.c.u(context, true);
                            al.this.fOc.hideTip();
                            if (al.this.fOf != null) {
                                al.this.fOf.onClick(al.this.fNZ);
                            }
                        }
                    };
                    this.fNZ.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.a.c.ca(context) && this.fNW != null && this.fNW.getVisibility() == 0 && !this.fOc.aZU()) {
                        this.fOc.E(onClickListener);
                        this.fOc.showTip(this.fNW);
                    }
                }
                this.fNV.setVisibility(8);
                this.fNU.setVisibility(8);
                this.fNY.setVisibility(8);
            } else if (jVar.mType == com.baidu.tieba.pb.data.j.fCA) {
                this.fNZ.setVisibility(8);
                this.fOb.setVisibility(0);
                this.fNT.setClickable(true);
                this.fNT.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.fNV.setVisibility(0);
                this.fNU.setVisibility(0);
                kl(jVar.fCE);
                kk(jVar.btL);
                this.fNY.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.t(getView(), d.C0108d.cp_bg_line_d);
            this.fNT.onChangeSkinType(i);
            this.fNU.onChangeSkinType(i);
            com.baidu.tbadk.core.util.aj.r(this.fOa, d.C0108d.cp_cont_b);
            if (this.fOg != null && this.fOg.mType == com.baidu.tieba.pb.data.j.fCB) {
                com.baidu.tbadk.core.util.aj.e(this.fNT, d.C0108d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.r(this.fNW, d.C0108d.cp_cont_j);
            this.fNW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.aj.r(this.fNV, d.C0108d.cp_cont_j);
            com.baidu.tbadk.core.util.aj.t(this.fNX, d.C0108d.cp_bg_line_e);
            com.baidu.tbadk.core.util.aj.t(this.fNY, d.C0108d.cp_bg_line_c);
            this.fNV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fOc.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.aIh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aIh);
    }

    public void n(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fOj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fOj);
    }

    public void F(View.OnClickListener onClickListener) {
        this.fOf = onClickListener;
    }
}
