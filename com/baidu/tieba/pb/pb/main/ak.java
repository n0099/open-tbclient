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
    private CustomMessageListener aJs;
    public TextLineView fTd;
    public TextLineView fTe;
    public TextView fTf;
    public TextView fTg;
    public View fTh;
    public View fTi;
    public View fTj;
    public TextLineView fTk;
    public View fTl;
    private com.baidu.tieba.pb.pb.godreply.a.a fTm;
    private List<TextLineView> fTn;
    private int fTo;
    private View.OnClickListener fTp;
    private com.baidu.tieba.pb.data.h fTq;
    private BdUniqueId fTr;
    private BdUniqueId fTs;
    private View.OnClickListener fTt;
    private View.OnClickListener fTu;
    private CustomMessageListener fTv;
    private View mRootView;
    public int mSkinType;

    public ak(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.fTm = new com.baidu.tieba.pb.pb.godreply.a.a();
        this.fTo = 0;
        this.fTt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.fTp != null) {
                    ak.this.fTp.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.oJ()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ak.this.fTn) {
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
        this.fTu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ak.this.fTp != null) {
                    ak.this.fTp.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.oJ() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    ak.this.kD(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.aJs = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fTq != null && ak.this.fTq.mType == com.baidu.tieba.pb.data.h.fHX && customResponsedMessage != null && getTag() == ak.this.fTr && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).fWL = ak.this;
                }
            }
        };
        this.fTv = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fTq != null && ak.this.fTq.mType == com.baidu.tieba.pb.data.h.fHY && customResponsedMessage != null && getTag() == ak.this.fTs && (customResponsedMessage.getData() instanceof ar.a) && ak.this.mRootView != null && ak.this.fTm.bbK() && ak.this.fTg != null && ak.this.fTg.getVisibility() == 0) {
                    if (ak.this.mRootView == null || ak.this.mRootView.getParent() == null) {
                        ak.this.fTm.hideTip();
                        return;
                    }
                    if (!ak.this.fTm.bbK() && !com.baidu.tieba.pb.pb.godreply.a.c.cb(ak.this.mRootView.getContext())) {
                        ak.this.fTm.showTip(ak.this.fTg);
                    }
                    if (ak.this.fTm.bbK()) {
                        ak.this.fTm.co(ak.this.fTg);
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
            this.fTd = (TextLineView) view.findViewById(d.g.reply_title);
            this.fTd.setOnClickListener(this.fTt);
            this.fTj = view.findViewById(d.g.reply_god_title_group);
            this.fTk = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.fTk.setSelected(false);
            this.fTl = view.findViewById(d.g.reply_all_title);
            this.fTe = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.fTe.setOnClickListener(this.fTt);
            this.fTf = (TextView) view.findViewById(d.g.pb_sort);
            this.fTf.setOnClickListener(this.fTu);
            this.fTg = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.fTd.setSelected(true);
            this.fTe.setSelected(false);
            this.fTn = new ArrayList();
            this.fTn.add(this.fTd);
            this.fTn.add(this.fTe);
            this.fTh = view.findViewById(d.g.divider_with_reply_title);
            this.fTi = view.findViewById(d.g.divider_bottom);
            kD(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void kD(boolean z) {
        this.fTo = z ? 0 : 1;
        this.fTf.setVisibility(0);
        if (this.fTo == 1) {
            this.fTf.setText(d.j.default_sort);
        } else if (this.fTo == 0) {
            this.fTf.setText(d.j.view_reverse);
        }
    }

    public void kE(boolean z) {
        if (z) {
            this.fTe.setSelected(true);
            this.fTd.setSelected(false);
            return;
        }
        this.fTe.setSelected(false);
        this.fTd.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fTq = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fHY) {
                final Context context = this.fTj.getContext();
                if (TextUtils.isEmpty(hVar.fIa)) {
                    this.fTl.setVisibility(0);
                    this.fTj.setVisibility(8);
                    this.fTd.setVisibility(0);
                    this.fTd.setSelected(false);
                    this.fTd.setClickable(false);
                    this.fTd.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.fTl.setVisibility(8);
                    this.fTd.setVisibility(8);
                    this.fTj.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.a.c.v(context, true);
                            ak.this.fTm.hideTip();
                            if (ak.this.fTp != null) {
                                ak.this.fTp.onClick(ak.this.fTj);
                            }
                        }
                    };
                    this.fTj.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.a.c.cb(context) && this.fTg != null && this.fTg.getVisibility() == 0 && !this.fTm.bbK()) {
                        this.fTm.F(onClickListener);
                        this.fTm.showTip(this.fTg);
                    }
                }
                this.fTf.setVisibility(8);
                this.fTe.setVisibility(8);
                this.fTi.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fHX) {
                this.fTj.setVisibility(8);
                this.fTl.setVisibility(0);
                this.fTd.setClickable(true);
                this.fTd.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.fTf.setVisibility(0);
                this.fTe.setVisibility(0);
                kE(hVar.fIb);
                kD(hVar.isNew);
                this.fTi.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.t(getView(), d.C0141d.cp_bg_line_d);
            this.fTd.onChangeSkinType(i);
            this.fTe.onChangeSkinType(i);
            com.baidu.tbadk.core.util.aj.r(this.fTk, d.C0141d.cp_cont_b);
            if (this.fTq != null && this.fTq.mType == com.baidu.tieba.pb.data.h.fHY) {
                com.baidu.tbadk.core.util.aj.e(this.fTd, d.C0141d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.r(this.fTg, d.C0141d.cp_cont_j);
            this.fTg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.aj.r(this.fTf, d.C0141d.cp_cont_j);
            com.baidu.tbadk.core.util.aj.t(this.fTh, d.C0141d.cp_bg_line_e);
            com.baidu.tbadk.core.util.aj.t(this.fTi, d.C0141d.cp_bg_line_c);
            this.fTf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fTm.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fTr = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.aJs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aJs);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fTs = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fTv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fTv);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fTp = onClickListener;
    }
}
