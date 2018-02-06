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
    private CustomMessageListener aJC;
    public TextLineView fSY;
    public TextLineView fSZ;
    public TextView fTa;
    public TextView fTb;
    public View fTc;
    public View fTd;
    public View fTe;
    public TextLineView fTf;
    public View fTg;
    private com.baidu.tieba.pb.pb.godreply.a.a fTh;
    private List<TextLineView> fTi;
    private int fTj;
    private View.OnClickListener fTk;
    private com.baidu.tieba.pb.data.h fTl;
    private BdUniqueId fTm;
    private BdUniqueId fTn;
    private View.OnClickListener fTo;
    private View.OnClickListener fTp;
    private CustomMessageListener fTq;
    private View mRootView;
    public int mSkinType;

    public ak(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fTh = new com.baidu.tieba.pb.pb.godreply.a.a();
        this.fTj = 0;
        this.fTo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.fTk != null) {
                    ak.this.fTk.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.oJ()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ak.this.fTi) {
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
        this.fTp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.fTk != null) {
                    ak.this.fTk.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.oJ() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    ak.this.ky(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.aJC = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fTl != null && ak.this.fTl.mType == com.baidu.tieba.pb.data.h.fHS && customResponsedMessage != null && getTag() == ak.this.fTm && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).fWG = ak.this;
                }
            }
        };
        this.fTq = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fTl != null && ak.this.fTl.mType == com.baidu.tieba.pb.data.h.fHT && customResponsedMessage != null && getTag() == ak.this.fTn && (customResponsedMessage.getData() instanceof ar.a) && ak.this.mRootView != null && ak.this.fTh.bbK() && ak.this.fTb != null && ak.this.fTb.getVisibility() == 0) {
                    if (ak.this.mRootView == null || ak.this.mRootView.getParent() == null) {
                        ak.this.fTh.hideTip();
                        return;
                    }
                    if (!ak.this.fTh.bbK() && !com.baidu.tieba.pb.pb.godreply.a.c.cb(ak.this.mRootView.getContext())) {
                        ak.this.fTh.showTip(ak.this.fTb);
                    }
                    if (ak.this.fTh.bbK()) {
                        ak.this.fTh.co(ak.this.fTb);
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
            this.fSY = (TextLineView) view.findViewById(d.g.reply_title);
            this.fSY.setOnClickListener(this.fTo);
            this.fTe = view.findViewById(d.g.reply_god_title_group);
            this.fTf = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.fTf.setSelected(false);
            this.fTg = view.findViewById(d.g.reply_all_title);
            this.fSZ = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.fSZ.setOnClickListener(this.fTo);
            this.fTa = (TextView) view.findViewById(d.g.pb_sort);
            this.fTa.setOnClickListener(this.fTp);
            this.fTb = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.fSY.setSelected(true);
            this.fSZ.setSelected(false);
            this.fTi = new ArrayList();
            this.fTi.add(this.fSY);
            this.fTi.add(this.fSZ);
            this.fTc = view.findViewById(d.g.divider_with_reply_title);
            this.fTd = view.findViewById(d.g.divider_bottom);
            ky(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ky(boolean z) {
        this.fTj = z ? 0 : 1;
        this.fTa.setVisibility(0);
        if (this.fTj == 1) {
            this.fTa.setText(d.j.default_sort);
        } else if (this.fTj == 0) {
            this.fTa.setText(d.j.view_reverse);
        }
    }

    public void kz(boolean z) {
        if (z) {
            this.fSZ.setSelected(true);
            this.fSY.setSelected(false);
            return;
        }
        this.fSZ.setSelected(false);
        this.fSY.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fTl = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fHT) {
                final Context context = this.fTe.getContext();
                if (TextUtils.isEmpty(hVar.fHV)) {
                    this.fTg.setVisibility(0);
                    this.fTe.setVisibility(8);
                    this.fSY.setVisibility(0);
                    this.fSY.setSelected(false);
                    this.fSY.setClickable(false);
                    this.fSY.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.fTg.setVisibility(8);
                    this.fSY.setVisibility(8);
                    this.fTe.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.a.c.v(context, true);
                            ak.this.fTh.hideTip();
                            if (ak.this.fTk != null) {
                                ak.this.fTk.onClick(ak.this.fTe);
                            }
                        }
                    };
                    this.fTe.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.a.c.cb(context) && this.fTb != null && this.fTb.getVisibility() == 0 && !this.fTh.bbK()) {
                        this.fTh.F(onClickListener);
                        this.fTh.showTip(this.fTb);
                    }
                }
                this.fTa.setVisibility(8);
                this.fSZ.setVisibility(8);
                this.fTd.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fHS) {
                this.fTe.setVisibility(8);
                this.fTg.setVisibility(0);
                this.fSY.setClickable(true);
                this.fSY.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.fTa.setVisibility(0);
                this.fSZ.setVisibility(0);
                kz(hVar.fHW);
                ky(hVar.isNew);
                this.fTd.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.t(getView(), d.C0140d.cp_bg_line_d);
            this.fSY.onChangeSkinType(i);
            this.fSZ.onChangeSkinType(i);
            com.baidu.tbadk.core.util.aj.r(this.fTf, d.C0140d.cp_cont_b);
            if (this.fTl != null && this.fTl.mType == com.baidu.tieba.pb.data.h.fHT) {
                com.baidu.tbadk.core.util.aj.e(this.fSY, d.C0140d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.r(this.fTb, d.C0140d.cp_cont_j);
            this.fTb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.aj.r(this.fTa, d.C0140d.cp_cont_j);
            com.baidu.tbadk.core.util.aj.t(this.fTc, d.C0140d.cp_bg_line_e);
            com.baidu.tbadk.core.util.aj.t(this.fTd, d.C0140d.cp_bg_line_c);
            this.fTa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fTh.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fTm = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.aJC.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aJC);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fTn = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fTq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fTq);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fTk = onClickListener;
    }
}
