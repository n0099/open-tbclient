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
    private CustomMessageListener akD;
    public View fUA;
    private com.baidu.tieba.pb.pb.godreply.usertips.a fUB;
    private List<TextLineView> fUC;
    private int fUD;
    private View.OnClickListener fUE;
    private com.baidu.tieba.pb.data.h fUF;
    private BdUniqueId fUG;
    private BdUniqueId fUH;
    private View.OnClickListener fUI;
    private View.OnClickListener fUJ;
    private CustomMessageListener fUK;
    public TextLineView fUs;
    public TextLineView fUt;
    public TextView fUu;
    public TextView fUv;
    public View fUw;
    public View fUx;
    public View fUy;
    public TextLineView fUz;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fUB = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.fUD = 0;
        this.fUI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fUE != null) {
                    al.this.fUE.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kV()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.fUC) {
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
        this.fUJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fUE != null) {
                    al.this.fUE.onClick(view2);
                }
            }
        };
        this.akD = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fUF != null && al.this.fUF.mType == com.baidu.tieba.pb.data.h.fJO && customResponsedMessage != null && getTag() == al.this.fUG && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).fXV = al.this;
                }
            }
        };
        this.fUK = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fUF != null && al.this.fUF.mType == com.baidu.tieba.pb.data.h.fJP && customResponsedMessage != null && getTag() == al.this.fUH && (customResponsedMessage.getData() instanceof ar.a) && al.this.mRootView != null && al.this.fUB.bfH() && al.this.fUv != null && al.this.fUv.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.fUB.hideTip();
                        return;
                    }
                    if (!al.this.fUB.bfH() && !com.baidu.tieba.pb.pb.godreply.usertips.b.cO(al.this.mRootView.getContext())) {
                        al.this.fUB.showTip(al.this.fUv);
                    }
                    if (al.this.fUB.bfH()) {
                        al.this.fUB.br(al.this.fUv);
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
            this.fUs = (TextLineView) view.findViewById(e.g.reply_title);
            this.fUs.setOnClickListener(this.fUI);
            this.fUy = view.findViewById(e.g.reply_god_title_group);
            this.fUz = (TextLineView) view.findViewById(e.g.reply_god_title);
            this.fUz.setSelected(false);
            this.fUA = view.findViewById(e.g.reply_all_title);
            this.fUt = (TextLineView) view.findViewById(e.g.floor_owner_reply);
            this.fUt.setOnClickListener(this.fUI);
            this.fUu = (TextView) view.findViewById(e.g.pb_sort);
            this.fUu.setOnClickListener(this.fUJ);
            this.fUv = (TextView) view.findViewById(e.g.pb_god_reply_entrance_text);
            this.fUs.setSelected(true);
            this.fUt.setSelected(false);
            this.fUC = new ArrayList();
            this.fUC.add(this.fUs);
            this.fUC.add(this.fUt);
            this.fUw = view.findViewById(e.g.divider_with_reply_title);
            this.fUx = view.findViewById(e.g.divider_bottom);
            if (com.baidu.tbadk.util.a.OB().Fb()) {
                ad(2, "");
            } else {
                ad(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ad(int i, String str) {
        this.fUD = i;
        this.fUu.setVisibility(0);
        if (str.length() > 0) {
            this.fUu.setText(str);
        } else if (this.fUD == 0) {
            this.fUu.setText(e.j.default_sort);
        } else if (this.fUD == 1) {
            this.fUu.setText(e.j.view_reverse);
        } else if (this.fUD == 2) {
            this.fUu.setText(e.j.view_hot);
        }
    }

    public void lc(boolean z) {
        if (z) {
            this.fUt.setSelected(true);
            this.fUs.setSelected(false);
            return;
        }
        this.fUt.setSelected(false);
        this.fUs.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fUF = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fJP) {
                final Context context = this.fUy.getContext();
                if (TextUtils.isEmpty(hVar.fJR)) {
                    this.fUA.setVisibility(0);
                    this.fUy.setVisibility(8);
                    this.fUs.setVisibility(0);
                    this.fUs.setSelected(false);
                    this.fUs.setClickable(false);
                    this.fUs.setText(TbadkCoreApplication.getInst().getString(e.j.god_reply));
                } else {
                    this.fUA.setVisibility(8);
                    this.fUs.setVisibility(8);
                    this.fUy.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.l(context, true);
                            al.this.fUB.hideTip();
                            if (al.this.fUE != null) {
                                al.this.fUE.onClick(al.this.fUy);
                            }
                        }
                    };
                    this.fUy.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.cO(context) && this.fUv != null && this.fUv.getVisibility() == 0 && !this.fUB.bfH()) {
                        this.fUB.J(onClickListener);
                        this.fUB.showTip(this.fUv);
                    }
                }
                this.fUu.setVisibility(8);
                this.fUt.setVisibility(8);
                this.fUx.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fJO) {
                this.fUy.setVisibility(8);
                this.fUA.setVisibility(0);
                this.fUs.setClickable(true);
                this.fUs.setText(TbadkCoreApplication.getInst().getString(e.j.all_reply));
                this.fUu.setVisibility(0);
                this.fUt.setVisibility(0);
                lc(hVar.fJT);
                ad(hVar.sortType, hVar.fJS);
                this.fUx.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.j(getView(), e.d.cp_bg_line_d);
            this.fUs.onChangeSkinType(i);
            this.fUt.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.h(this.fUz, e.d.cp_cont_b);
            if (this.fUF != null && this.fUF.mType == com.baidu.tieba.pb.data.h.fJP) {
                com.baidu.tbadk.core.util.al.c(this.fUs, e.d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.h(this.fUv, e.d.cp_cont_j);
            this.fUv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.h(this.fUu, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.j(this.fUw, e.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.al.j(this.fUx, e.d.cp_bg_line_c);
            this.fUu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_sort), (Drawable) null);
            this.fUB.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fUG = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.akD.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.akD);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fUH = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fUK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fUK);
    }

    public void L(View.OnClickListener onClickListener) {
        this.fUE = onClickListener;
    }
}
