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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ak extends r.a {
    private CustomMessageListener aJr;
    public TextLineView fSN;
    public TextLineView fSO;
    public TextView fSP;
    public TextView fSQ;
    public View fSR;
    public View fSS;
    public View fST;
    public TextLineView fSU;
    public View fSV;
    private com.baidu.tieba.pb.pb.godreply.a.a fSW;
    private List<TextLineView> fSX;
    private int fSY;
    private View.OnClickListener fSZ;
    private com.baidu.tieba.pb.data.h fTa;
    private BdUniqueId fTb;
    private BdUniqueId fTc;
    private View.OnClickListener fTd;
    private View.OnClickListener fTe;
    private CustomMessageListener fTf;
    private View mRootView;
    public int mSkinType;

    public ak(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fSW = new com.baidu.tieba.pb.pb.godreply.a.a();
        this.fSY = 0;
        this.fTd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.fSZ != null) {
                    ak.this.fSZ.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.oJ()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ak.this.fSX) {
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
        this.fTe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.fSZ != null) {
                    ak.this.fSZ.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.oJ() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    ak.this.ky(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.aJr = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fTa != null && ak.this.fTa.mType == com.baidu.tieba.pb.data.h.fHH && customResponsedMessage != null && getTag() == ak.this.fTb && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).fWv = ak.this;
                }
            }
        };
        this.fTf = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fTa != null && ak.this.fTa.mType == com.baidu.tieba.pb.data.h.fHI && customResponsedMessage != null && getTag() == ak.this.fTc && (customResponsedMessage.getData() instanceof ar.a) && ak.this.mRootView != null && ak.this.fSW.bbJ() && ak.this.fSQ != null && ak.this.fSQ.getVisibility() == 0) {
                    if (ak.this.mRootView == null || ak.this.mRootView.getParent() == null) {
                        ak.this.fSW.hideTip();
                        return;
                    }
                    if (!ak.this.fSW.bbJ() && !com.baidu.tieba.pb.pb.godreply.a.c.cb(ak.this.mRootView.getContext())) {
                        ak.this.fSW.showTip(ak.this.fSQ);
                    }
                    if (ak.this.fSW.bbJ()) {
                        ak.this.fSW.co(ak.this.fSQ);
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
            this.fSN = (TextLineView) view.findViewById(d.g.reply_title);
            this.fSN.setOnClickListener(this.fTd);
            this.fST = view.findViewById(d.g.reply_god_title_group);
            this.fSU = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.fSU.setSelected(false);
            this.fSV = view.findViewById(d.g.reply_all_title);
            this.fSO = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.fSO.setOnClickListener(this.fTd);
            this.fSP = (TextView) view.findViewById(d.g.pb_sort);
            this.fSP.setOnClickListener(this.fTe);
            this.fSQ = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.fSN.setSelected(true);
            this.fSO.setSelected(false);
            this.fSX = new ArrayList();
            this.fSX.add(this.fSN);
            this.fSX.add(this.fSO);
            this.fSR = view.findViewById(d.g.divider_with_reply_title);
            this.fSS = view.findViewById(d.g.divider_bottom);
            ky(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ky(boolean z) {
        this.fSY = z ? 0 : 1;
        this.fSP.setVisibility(0);
        if (this.fSY == 1) {
            this.fSP.setText(d.j.default_sort);
        } else if (this.fSY == 0) {
            this.fSP.setText(d.j.view_reverse);
        }
    }

    public void kz(boolean z) {
        if (z) {
            this.fSO.setSelected(true);
            this.fSN.setSelected(false);
            return;
        }
        this.fSO.setSelected(false);
        this.fSN.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fTa = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fHI) {
                final Context context = this.fST.getContext();
                if (TextUtils.isEmpty(hVar.fHK)) {
                    this.fSV.setVisibility(0);
                    this.fST.setVisibility(8);
                    this.fSN.setVisibility(0);
                    this.fSN.setSelected(false);
                    this.fSN.setClickable(false);
                    this.fSN.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.fSV.setVisibility(8);
                    this.fSN.setVisibility(8);
                    this.fST.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.a.c.v(context, true);
                            ak.this.fSW.hideTip();
                            if (ak.this.fSZ != null) {
                                ak.this.fSZ.onClick(ak.this.fST);
                            }
                        }
                    };
                    this.fST.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.a.c.cb(context) && this.fSQ != null && this.fSQ.getVisibility() == 0 && !this.fSW.bbJ()) {
                        this.fSW.F(onClickListener);
                        this.fSW.showTip(this.fSQ);
                    }
                }
                this.fSP.setVisibility(8);
                this.fSO.setVisibility(8);
                this.fSS.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fHH) {
                this.fST.setVisibility(8);
                this.fSV.setVisibility(0);
                this.fSN.setClickable(true);
                this.fSN.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.fSP.setVisibility(0);
                this.fSO.setVisibility(0);
                kz(hVar.fHL);
                ky(hVar.isNew);
                this.fSS.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.t(getView(), d.C0141d.cp_bg_line_d);
            this.fSN.onChangeSkinType(i);
            this.fSO.onChangeSkinType(i);
            com.baidu.tbadk.core.util.aj.r(this.fSU, d.C0141d.cp_cont_b);
            if (this.fTa != null && this.fTa.mType == com.baidu.tieba.pb.data.h.fHI) {
                com.baidu.tbadk.core.util.aj.e(this.fSN, d.C0141d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.r(this.fSQ, d.C0141d.cp_cont_j);
            this.fSQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.aj.r(this.fSP, d.C0141d.cp_cont_j);
            com.baidu.tbadk.core.util.aj.t(this.fSR, d.C0141d.cp_bg_line_e);
            com.baidu.tbadk.core.util.aj.t(this.fSS, d.C0141d.cp_bg_line_c);
            this.fSP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fSW.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fTb = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.aJr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aJr);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fTc = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fTf.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fTf);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fSZ = onClickListener;
    }
}
