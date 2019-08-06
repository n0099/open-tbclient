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
    public TextLineView hTK;
    public TextLineView hTL;
    public TextView hTM;
    public TextView hTN;
    public View hTO;
    public View hTP;
    public View hTQ;
    public TextLineView hTR;
    public View hTS;
    private com.baidu.tieba.pb.pb.godreply.usertips.a hTT;
    private List<TextLineView> hTU;
    private int hTV;
    private View.OnClickListener hTW;
    private com.baidu.tieba.pb.data.i hTX;
    private BdUniqueId hTY;
    private BdUniqueId hTZ;
    private View.OnClickListener hUa;
    private View.OnClickListener hUb;
    private CustomMessageListener hUc;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hTT = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.hTV = 0;
        this.Ql = true;
        this.hUa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hTW != null) {
                    al.this.hTW.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kc()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.hTU) {
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
        this.hUb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hTW != null) {
                    al.this.hTW.onClick(view2);
                }
            }
        };
        this.bDy = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hTX != null && al.this.hTX.mType == com.baidu.tieba.pb.data.i.hJe && customResponsedMessage != null && getTag() == al.this.hTY && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).hXp = al.this;
                }
            }
        };
        this.hUc = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hTX != null && al.this.hTX.mType == com.baidu.tieba.pb.data.i.hJf && customResponsedMessage != null && getTag() == al.this.hTZ && (customResponsedMessage.getData() instanceof aq.a) && al.this.mRootView != null && al.this.hTT.bUc() && al.this.hTN != null && al.this.hTN.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.hTT.hideTip();
                        return;
                    }
                    if (!al.this.hTT.bUc() && !com.baidu.tieba.pb.pb.godreply.usertips.b.ef(al.this.mRootView.getContext())) {
                        al.this.hTT.showTip(al.this.hTN);
                    }
                    if (al.this.hTT.bUc()) {
                        al.this.hTT.cv(al.this.hTN);
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
            this.hTK = (TextLineView) view.findViewById(R.id.reply_title);
            this.hTK.setOnClickListener(this.hUa);
            this.hTQ = view.findViewById(R.id.reply_god_title_group);
            this.hTR = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.hTR.setSelected(false);
            this.hTS = view.findViewById(R.id.reply_all_title);
            this.hTL = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.hTL.setOnClickListener(this.hUa);
            this.hTM = (TextView) view.findViewById(R.id.pb_sort);
            this.hTM.setOnClickListener(this.hUb);
            this.hTN = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.hTK.setSelected(true);
            this.hTL.setSelected(false);
            this.hTU = new ArrayList();
            this.hTU.add(this.hTK);
            this.hTU.add(this.hTL);
            this.hTO = view.findViewById(R.id.divider_with_reply_title);
            this.hTP = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.avY().alQ()) {
                aB(2, "");
            } else {
                aB(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aB(int i, String str) {
        this.hTV = i;
        this.hTM.setVisibility(0);
        if (str.length() > 0) {
            this.hTM.setText(str);
        } else if (this.hTV == 0) {
            this.hTM.setText(R.string.default_sort);
        } else if (this.hTV == 1) {
            this.hTM.setText(R.string.view_reverse);
        } else if (this.hTV == 2) {
            this.hTM.setText(R.string.view_hot);
        }
    }

    public void oM(boolean z) {
        if (z) {
            this.hTL.setSelected(true);
            this.hTK.setSelected(false);
            return;
        }
        this.hTL.setSelected(false);
        this.hTK.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.i iVar) {
        this.hTX = iVar;
        if (iVar != null) {
            if (iVar.mType == com.baidu.tieba.pb.data.i.hJf) {
                final Context context = this.hTQ.getContext();
                if (TextUtils.isEmpty(iVar.hJh)) {
                    this.hTS.setVisibility(0);
                    this.hTQ.setVisibility(8);
                    this.hTK.setVisibility(0);
                    this.hTK.setSelected(false);
                    this.hTK.setClickable(false);
                    this.hTK.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.hTS.setVisibility(8);
                    this.hTK.setVisibility(8);
                    this.hTQ.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.j(context, true);
                            al.this.hTT.hideTip();
                            if (al.this.hTW != null) {
                                al.this.hTW.onClick(al.this.hTQ);
                            }
                        }
                    };
                    this.hTQ.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.ef(context) && this.hTN != null && this.hTN.getVisibility() == 0 && !this.hTT.bUc()) {
                        this.hTT.O(onClickListener);
                        this.hTT.showTip(this.hTN);
                    }
                }
                this.hTM.setVisibility(8);
                this.hTL.setVisibility(8);
                this.hTP.setVisibility(8);
            } else if (iVar.mType == com.baidu.tieba.pb.data.i.hJe) {
                this.hTQ.setVisibility(8);
                this.hTS.setVisibility(0);
                this.hTK.setClickable(true);
                this.hTK.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.hTM.setVisibility(0);
                this.hTL.setVisibility(0);
                oM(iVar.hJj);
                aB(iVar.sortType, iVar.hJi);
                this.hTP.setVisibility(0);
            }
            if (this.Ql) {
                this.hTP.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
            } else {
                this.hTP.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds2);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.l(this.hTS, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.l(this.hTQ, R.color.cp_bg_line_d);
            this.hTK.onChangeSkinType(i);
            this.hTL.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.j(this.hTR, R.color.cp_cont_b);
            if (this.hTX != null && this.hTX.mType == com.baidu.tieba.pb.data.i.hJf) {
                com.baidu.tbadk.core.util.am.f(this.hTK, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.j(this.hTN, R.color.cp_cont_j);
            this.hTN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.j(this.hTM, R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.l(this.hTO, R.color.cp_bg_line_e);
            this.hTM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_sort), (Drawable) null);
            this.hTT.onChangeSkinType(i);
            if (this.Ql) {
                com.baidu.tbadk.core.util.am.k(this.hTP, R.drawable.top_shadow);
            } else {
                com.baidu.tbadk.core.util.am.l(this.hTP, R.color.cp_bg_line_c);
            }
        }
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.hTY = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.bDy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bDy);
    }

    public void q(BdUniqueId bdUniqueId) {
        this.hTZ = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.hUc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hUc);
    }

    public void P(View.OnClickListener onClickListener) {
        this.hTW = onClickListener;
    }
}
