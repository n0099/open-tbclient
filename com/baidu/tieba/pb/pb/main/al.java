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
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class al extends v.a {
    public boolean Ql;
    private CustomMessageListener bDy;
    public TextLineView hSO;
    public TextLineView hSP;
    public TextView hSQ;
    public TextView hSR;
    public View hSS;
    public View hST;
    public View hSU;
    public TextLineView hSV;
    public View hSW;
    private com.baidu.tieba.pb.pb.godreply.usertips.a hSX;
    private List<TextLineView> hSY;
    private int hSZ;
    private View.OnClickListener hTa;
    private com.baidu.tieba.pb.data.i hTb;
    private BdUniqueId hTc;
    private BdUniqueId hTd;
    private View.OnClickListener hTe;
    private View.OnClickListener hTf;
    private CustomMessageListener hTg;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hSX = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.hSZ = 0;
        this.Ql = true;
        this.hTe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hTa != null) {
                    al.this.hTa.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kc()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.hSY) {
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
        this.hTf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hTa != null) {
                    al.this.hTa.onClick(view2);
                }
            }
        };
        this.bDy = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hTb != null && al.this.hTb.mType == com.baidu.tieba.pb.data.i.hIl && customResponsedMessage != null && getTag() == al.this.hTc && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).hWt = al.this;
                }
            }
        };
        this.hTg = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hTb != null && al.this.hTb.mType == com.baidu.tieba.pb.data.i.hIm && customResponsedMessage != null && getTag() == al.this.hTd && (customResponsedMessage.getData() instanceof aq.a) && al.this.mRootView != null && al.this.hSX.bTO() && al.this.hSR != null && al.this.hSR.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.hSX.hideTip();
                        return;
                    }
                    if (!al.this.hSX.bTO() && !com.baidu.tieba.pb.pb.godreply.usertips.b.ee(al.this.mRootView.getContext())) {
                        al.this.hSX.showTip(al.this.hSR);
                    }
                    if (al.this.hSX.bTO()) {
                        al.this.hSX.cu(al.this.hSR);
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
            this.hSO = (TextLineView) view.findViewById(R.id.reply_title);
            this.hSO.setOnClickListener(this.hTe);
            this.hSU = view.findViewById(R.id.reply_god_title_group);
            this.hSV = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.hSV.setSelected(false);
            this.hSW = view.findViewById(R.id.reply_all_title);
            this.hSP = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.hSP.setOnClickListener(this.hTe);
            this.hSQ = (TextView) view.findViewById(R.id.pb_sort);
            this.hSQ.setOnClickListener(this.hTf);
            this.hSR = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.hSO.setSelected(true);
            this.hSP.setSelected(false);
            this.hSY = new ArrayList();
            this.hSY.add(this.hSO);
            this.hSY.add(this.hSP);
            this.hSS = view.findViewById(R.id.divider_with_reply_title);
            this.hST = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.avW().alO()) {
                aB(2, "");
            } else {
                aB(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aB(int i, String str) {
        this.hSZ = i;
        this.hSQ.setVisibility(0);
        if (str.length() > 0) {
            this.hSQ.setText(str);
        } else if (this.hSZ == 0) {
            this.hSQ.setText(R.string.default_sort);
        } else if (this.hSZ == 1) {
            this.hSQ.setText(R.string.view_reverse);
        } else if (this.hSZ == 2) {
            this.hSQ.setText(R.string.view_hot);
        }
    }

    public void oM(boolean z) {
        if (z) {
            this.hSP.setSelected(true);
            this.hSO.setSelected(false);
            return;
        }
        this.hSP.setSelected(false);
        this.hSO.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.i iVar) {
        this.hTb = iVar;
        if (iVar != null) {
            if (iVar.mType == com.baidu.tieba.pb.data.i.hIm) {
                final Context context = this.hSU.getContext();
                if (TextUtils.isEmpty(iVar.hIo)) {
                    this.hSW.setVisibility(0);
                    this.hSU.setVisibility(8);
                    this.hSO.setVisibility(0);
                    this.hSO.setSelected(false);
                    this.hSO.setClickable(false);
                    this.hSO.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.hSW.setVisibility(8);
                    this.hSO.setVisibility(8);
                    this.hSU.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.j(context, true);
                            al.this.hSX.hideTip();
                            if (al.this.hTa != null) {
                                al.this.hTa.onClick(al.this.hSU);
                            }
                        }
                    };
                    this.hSU.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.ee(context) && this.hSR != null && this.hSR.getVisibility() == 0 && !this.hSX.bTO()) {
                        this.hSX.O(onClickListener);
                        this.hSX.showTip(this.hSR);
                    }
                }
                this.hSQ.setVisibility(8);
                this.hSP.setVisibility(8);
                this.hST.setVisibility(8);
            } else if (iVar.mType == com.baidu.tieba.pb.data.i.hIl) {
                this.hSU.setVisibility(8);
                this.hSW.setVisibility(0);
                this.hSO.setClickable(true);
                this.hSO.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.hSQ.setVisibility(0);
                this.hSP.setVisibility(0);
                oM(iVar.hIq);
                aB(iVar.sortType, iVar.hIp);
                this.hST.setVisibility(0);
            }
            if (this.Ql) {
                this.hST.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
            } else {
                this.hST.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds2);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.l(this.hSW, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.l(this.hSU, R.color.cp_bg_line_d);
            this.hSO.onChangeSkinType(i);
            this.hSP.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.j(this.hSV, R.color.cp_cont_b);
            if (this.hTb != null && this.hTb.mType == com.baidu.tieba.pb.data.i.hIm) {
                com.baidu.tbadk.core.util.am.f(this.hSO, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.j(this.hSR, R.color.cp_cont_j);
            this.hSR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.j(this.hSQ, R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.l(this.hSS, R.color.cp_bg_line_e);
            this.hSQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_sort), (Drawable) null);
            this.hSX.onChangeSkinType(i);
            if (this.Ql) {
                com.baidu.tbadk.core.util.am.k(this.hST, R.drawable.top_shadow);
            } else {
                com.baidu.tbadk.core.util.am.l(this.hST, R.color.cp_bg_line_c);
            }
        }
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.hTc = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.bDy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bDy);
    }

    public void q(BdUniqueId bdUniqueId) {
        this.hTd = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.hTg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hTg);
    }

    public void P(View.OnClickListener onClickListener) {
        this.hTa = onClickListener;
    }
}
