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
    private CustomMessageListener aIf;
    public TextLineView fPA;
    public View fPB;
    private com.baidu.tieba.pb.pb.godreply.a.a fPC;
    private List<TextLineView> fPD;
    private int fPE;
    private View.OnClickListener fPF;
    private com.baidu.tieba.pb.data.j fPG;
    private View.OnClickListener fPH;
    private View.OnClickListener fPI;
    private CustomMessageListener fPJ;
    public TextLineView fPt;
    public TextLineView fPu;
    public TextView fPv;
    public TextView fPw;
    public View fPx;
    public View fPy;
    public View fPz;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fPC = new com.baidu.tieba.pb.pb.godreply.a.a();
        this.fPE = 0;
        this.fPH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fPF != null) {
                    al.this.fPF.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.oI()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.fPD) {
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
        this.fPI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.fPF != null) {
                    al.this.fPF.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.oI() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    al.this.km(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.aIf = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fPG != null && al.this.fPG.mType == com.baidu.tieba.pb.data.j.fEa && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.fEa && (customResponsedMessage.getData() instanceof as.a)) {
                    ((as.a) customResponsedMessage.getData()).fSZ = al.this;
                }
            }
        };
        this.fPJ = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.fPG != null && al.this.fPG.mType == com.baidu.tieba.pb.data.j.fEb && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.fEb && (customResponsedMessage.getData() instanceof as.a) && al.this.mRootView != null && al.this.fPC.aZY() && al.this.fPw != null && al.this.fPw.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.fPC.hideTip();
                        return;
                    }
                    if (!al.this.fPC.aZY() && !com.baidu.tieba.pb.pb.godreply.a.c.ca(al.this.mRootView.getContext())) {
                        al.this.fPC.showTip(al.this.fPw);
                    }
                    if (al.this.fPC.aZY()) {
                        al.this.fPC.cp(al.this.fPw);
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
            this.fPt = (TextLineView) view.findViewById(d.g.reply_title);
            this.fPt.setOnClickListener(this.fPH);
            this.fPz = view.findViewById(d.g.reply_god_title_group);
            this.fPA = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.fPA.setSelected(false);
            this.fPB = view.findViewById(d.g.reply_all_title);
            this.fPu = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.fPu.setOnClickListener(this.fPH);
            this.fPv = (TextView) view.findViewById(d.g.pb_sort);
            this.fPv.setOnClickListener(this.fPI);
            this.fPw = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.fPt.setSelected(true);
            this.fPu.setSelected(false);
            this.fPD = new ArrayList();
            this.fPD.add(this.fPt);
            this.fPD.add(this.fPu);
            this.fPx = view.findViewById(d.g.divider_with_reply_title);
            this.fPy = view.findViewById(d.g.divider_bottom);
            km(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void km(boolean z) {
        this.fPE = z ? 0 : 1;
        this.fPv.setVisibility(0);
        if (this.fPE == 1) {
            this.fPv.setText(d.j.default_sort);
        } else if (this.fPE == 0) {
            this.fPv.setText(d.j.view_reverse);
        }
    }

    public void kn(boolean z) {
        if (z) {
            this.fPu.setSelected(true);
            this.fPt.setSelected(false);
            return;
        }
        this.fPu.setSelected(false);
        this.fPt.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.fPG = jVar;
        if (jVar != null) {
            if (jVar.mType == com.baidu.tieba.pb.data.j.fEb) {
                final Context context = this.fPz.getContext();
                if (TextUtils.isEmpty(jVar.fEd)) {
                    this.fPB.setVisibility(0);
                    this.fPz.setVisibility(8);
                    this.fPt.setVisibility(0);
                    this.fPt.setSelected(false);
                    this.fPt.setClickable(false);
                    this.fPt.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.fPB.setVisibility(8);
                    this.fPt.setVisibility(8);
                    this.fPz.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.a.c.u(context, true);
                            al.this.fPC.hideTip();
                            if (al.this.fPF != null) {
                                al.this.fPF.onClick(al.this.fPz);
                            }
                        }
                    };
                    this.fPz.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.a.c.ca(context) && this.fPw != null && this.fPw.getVisibility() == 0 && !this.fPC.aZY()) {
                        this.fPC.F(onClickListener);
                        this.fPC.showTip(this.fPw);
                    }
                }
                this.fPv.setVisibility(8);
                this.fPu.setVisibility(8);
                this.fPy.setVisibility(8);
            } else if (jVar.mType == com.baidu.tieba.pb.data.j.fEa) {
                this.fPz.setVisibility(8);
                this.fPB.setVisibility(0);
                this.fPt.setClickable(true);
                this.fPt.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.fPv.setVisibility(0);
                this.fPu.setVisibility(0);
                kn(jVar.fEe);
                km(jVar.btU);
                this.fPy.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.t(getView(), d.C0107d.cp_bg_line_d);
            this.fPt.onChangeSkinType(i);
            this.fPu.onChangeSkinType(i);
            com.baidu.tbadk.core.util.aj.r(this.fPA, d.C0107d.cp_cont_b);
            if (this.fPG != null && this.fPG.mType == com.baidu.tieba.pb.data.j.fEb) {
                com.baidu.tbadk.core.util.aj.e(this.fPt, d.C0107d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.r(this.fPw, d.C0107d.cp_cont_j);
            this.fPw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.aj.r(this.fPv, d.C0107d.cp_cont_j);
            com.baidu.tbadk.core.util.aj.t(this.fPx, d.C0107d.cp_bg_line_e);
            com.baidu.tbadk.core.util.aj.t(this.fPy, d.C0107d.cp_bg_line_c);
            this.fPv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fPC.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.aIf.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aIf);
    }

    public void n(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fPJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fPJ);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fPF = onClickListener;
    }
}
