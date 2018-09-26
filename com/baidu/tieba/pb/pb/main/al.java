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
/* loaded from: classes2.dex */
public class al extends q.a {
    private CustomMessageListener aeT;
    private com.baidu.tieba.pb.pb.godreply.usertips.a fLA;
    private List<TextLineView> fLB;
    private int fLC;
    private View.OnClickListener fLD;
    private com.baidu.tieba.pb.data.h fLE;
    private BdUniqueId fLF;
    private BdUniqueId fLG;
    private View.OnClickListener fLH;
    private View.OnClickListener fLI;
    private CustomMessageListener fLJ;
    public TextLineView fLr;
    public TextLineView fLs;
    public TextView fLt;
    public TextView fLu;
    public View fLv;
    public View fLw;
    public View fLx;
    public TextLineView fLy;
    public View fLz;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fLA = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.fLC = 0;
        this.fLH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fLD != null) {
                    al.this.fLD.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kK()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.fLB) {
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
        this.fLI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fLD != null) {
                    al.this.fLD.onClick(view2);
                }
            }
        };
        this.aeT = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fLE != null && al.this.fLE.mType == com.baidu.tieba.pb.data.h.fAN && customResponsedMessage != null && getTag() == al.this.fLF && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).fOV = al.this;
                }
            }
        };
        this.fLJ = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fLE != null && al.this.fLE.mType == com.baidu.tieba.pb.data.h.fAO && customResponsedMessage != null && getTag() == al.this.fLG && (customResponsedMessage.getData() instanceof ar.a) && al.this.mRootView != null && al.this.fLA.bcY() && al.this.fLu != null && al.this.fLu.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.fLA.hideTip();
                        return;
                    }
                    if (!al.this.fLA.bcY() && !com.baidu.tieba.pb.pb.godreply.usertips.b.cG(al.this.mRootView.getContext())) {
                        al.this.fLA.showTip(al.this.fLu);
                    }
                    if (al.this.fLA.bcY()) {
                        al.this.fLA.bp(al.this.fLu);
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
            this.fLr = (TextLineView) view.findViewById(e.g.reply_title);
            this.fLr.setOnClickListener(this.fLH);
            this.fLx = view.findViewById(e.g.reply_god_title_group);
            this.fLy = (TextLineView) view.findViewById(e.g.reply_god_title);
            this.fLy.setSelected(false);
            this.fLz = view.findViewById(e.g.reply_all_title);
            this.fLs = (TextLineView) view.findViewById(e.g.floor_owner_reply);
            this.fLs.setOnClickListener(this.fLH);
            this.fLt = (TextView) view.findViewById(e.g.pb_sort);
            this.fLt.setOnClickListener(this.fLI);
            this.fLu = (TextView) view.findViewById(e.g.pb_god_reply_entrance_text);
            this.fLr.setSelected(true);
            this.fLs.setSelected(false);
            this.fLB = new ArrayList();
            this.fLB.add(this.fLr);
            this.fLB.add(this.fLs);
            this.fLv = view.findViewById(e.g.divider_with_reply_title);
            this.fLw = view.findViewById(e.g.divider_bottom);
            if (com.baidu.tbadk.util.a.Mu().CM()) {
                ah(2, "");
            } else {
                ah(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ah(int i, String str) {
        this.fLC = i;
        this.fLt.setVisibility(0);
        if (str.length() > 0) {
            this.fLt.setText(str);
        } else if (this.fLC == 0) {
            this.fLt.setText(e.j.default_sort);
        } else if (this.fLC == 1) {
            this.fLt.setText(e.j.view_reverse);
        } else if (this.fLC == 2) {
            this.fLt.setText(e.j.view_hot);
        }
    }

    public void kA(boolean z) {
        if (z) {
            this.fLs.setSelected(true);
            this.fLr.setSelected(false);
            return;
        }
        this.fLs.setSelected(false);
        this.fLr.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fLE = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fAO) {
                final Context context = this.fLx.getContext();
                if (TextUtils.isEmpty(hVar.fAQ)) {
                    this.fLz.setVisibility(0);
                    this.fLx.setVisibility(8);
                    this.fLr.setVisibility(0);
                    this.fLr.setSelected(false);
                    this.fLr.setClickable(false);
                    this.fLr.setText(TbadkCoreApplication.getInst().getString(e.j.god_reply));
                } else {
                    this.fLz.setVisibility(8);
                    this.fLr.setVisibility(8);
                    this.fLx.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.k(context, true);
                            al.this.fLA.hideTip();
                            if (al.this.fLD != null) {
                                al.this.fLD.onClick(al.this.fLx);
                            }
                        }
                    };
                    this.fLx.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.cG(context) && this.fLu != null && this.fLu.getVisibility() == 0 && !this.fLA.bcY()) {
                        this.fLA.H(onClickListener);
                        this.fLA.showTip(this.fLu);
                    }
                }
                this.fLt.setVisibility(8);
                this.fLs.setVisibility(8);
                this.fLw.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fAN) {
                this.fLx.setVisibility(8);
                this.fLz.setVisibility(0);
                this.fLr.setClickable(true);
                this.fLr.setText(TbadkCoreApplication.getInst().getString(e.j.all_reply));
                this.fLt.setVisibility(0);
                this.fLs.setVisibility(0);
                kA(hVar.fAS);
                ah(hVar.sortType, hVar.fAR);
                this.fLw.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.j(getView(), e.d.cp_bg_line_d);
            this.fLr.onChangeSkinType(i);
            this.fLs.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.h(this.fLy, e.d.cp_cont_b);
            if (this.fLE != null && this.fLE.mType == com.baidu.tieba.pb.data.h.fAO) {
                com.baidu.tbadk.core.util.al.c(this.fLr, e.d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.h(this.fLu, e.d.cp_cont_j);
            this.fLu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.h(this.fLt, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.j(this.fLv, e.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.al.j(this.fLw, e.d.cp_bg_line_c);
            this.fLt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_sort), (Drawable) null);
            this.fLA.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fLF = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.aeT.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aeT);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fLG = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fLJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fLJ);
    }

    public void J(View.OnClickListener onClickListener) {
        this.fLD = onClickListener;
    }
}
