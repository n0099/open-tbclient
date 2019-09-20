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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class al extends v.a {
    public boolean Qk;
    private CustomMessageListener bDW;
    public TextLineView hVH;
    public TextLineView hVI;
    public TextView hVJ;
    public TextView hVK;
    public View hVL;
    public View hVM;
    public View hVN;
    public TextLineView hVO;
    public View hVP;
    private com.baidu.tieba.pb.pb.godreply.usertips.a hVQ;
    private List<TextLineView> hVR;
    private int hVS;
    private View.OnClickListener hVT;
    private com.baidu.tieba.pb.data.i hVU;
    private BdUniqueId hVV;
    private BdUniqueId hVW;
    private View.OnClickListener hVX;
    private View.OnClickListener hVY;
    private CustomMessageListener hVZ;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hVQ = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.hVS = 0;
        this.Qk = true;
        this.hVX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hVT != null) {
                    al.this.hVT.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kc()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.hVR) {
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
        this.hVY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hVT != null) {
                    al.this.hVT.onClick(view2);
                }
            }
        };
        this.bDW = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hVU != null && al.this.hVU.mType == com.baidu.tieba.pb.data.i.hLb && customResponsedMessage != null && getTag() == al.this.hVV && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).hZm = al.this;
                }
            }
        };
        this.hVZ = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hVU != null && al.this.hVU.mType == com.baidu.tieba.pb.data.i.hLc && customResponsedMessage != null && getTag() == al.this.hVW && (customResponsedMessage.getData() instanceof aq.a) && al.this.mRootView != null && al.this.hVQ.bUP() && al.this.hVK != null && al.this.hVK.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.hVQ.hideTip();
                        return;
                    }
                    if (!al.this.hVQ.bUP() && !com.baidu.tieba.pb.pb.godreply.usertips.b.eg(al.this.mRootView.getContext())) {
                        al.this.hVQ.showTip(al.this.hVK);
                    }
                    if (al.this.hVQ.bUP()) {
                        al.this.hVQ.cv(al.this.hVK);
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
            this.hVH = (TextLineView) view.findViewById(R.id.reply_title);
            this.hVH.setOnClickListener(this.hVX);
            this.hVN = view.findViewById(R.id.reply_god_title_group);
            this.hVO = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.hVO.setSelected(false);
            this.hVP = view.findViewById(R.id.reply_all_title);
            this.hVI = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.hVI.setOnClickListener(this.hVX);
            this.hVJ = (TextView) view.findViewById(R.id.pb_sort);
            this.hVJ.setOnClickListener(this.hVY);
            this.hVK = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.hVH.setSelected(true);
            this.hVI.setSelected(false);
            this.hVR = new ArrayList();
            this.hVR.add(this.hVH);
            this.hVR.add(this.hVI);
            this.hVL = view.findViewById(R.id.divider_with_reply_title);
            this.hVM = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.awk().amc()) {
                aB(2, "");
            } else {
                aB(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aB(int i, String str) {
        this.hVS = i;
        this.hVJ.setVisibility(0);
        if (str.length() > 0) {
            this.hVJ.setText(str);
        } else if (this.hVS == 0) {
            this.hVJ.setText(R.string.default_sort);
        } else if (this.hVS == 1) {
            this.hVJ.setText(R.string.view_reverse);
        } else if (this.hVS == 2) {
            this.hVJ.setText(R.string.view_hot);
        }
    }

    public void oQ(boolean z) {
        if (z) {
            this.hVI.setSelected(true);
            this.hVH.setSelected(false);
            return;
        }
        this.hVI.setSelected(false);
        this.hVH.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.i iVar) {
        this.hVU = iVar;
        if (iVar != null) {
            if (iVar.mType == com.baidu.tieba.pb.data.i.hLc) {
                final Context context = this.hVN.getContext();
                if (TextUtils.isEmpty(iVar.hLe)) {
                    this.hVP.setVisibility(0);
                    this.hVN.setVisibility(8);
                    this.hVH.setVisibility(0);
                    this.hVH.setSelected(false);
                    this.hVH.setClickable(false);
                    this.hVH.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.hVP.setVisibility(8);
                    this.hVH.setVisibility(8);
                    this.hVN.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.j(context, true);
                            al.this.hVQ.hideTip();
                            if (al.this.hVT != null) {
                                al.this.hVT.onClick(al.this.hVN);
                            }
                        }
                    };
                    this.hVN.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.eg(context) && this.hVK != null && this.hVK.getVisibility() == 0 && !this.hVQ.bUP()) {
                        this.hVQ.O(onClickListener);
                        this.hVQ.showTip(this.hVK);
                    }
                }
                this.hVJ.setVisibility(8);
                this.hVI.setVisibility(8);
                this.hVM.setVisibility(8);
            } else if (iVar.mType == com.baidu.tieba.pb.data.i.hLb) {
                this.hVN.setVisibility(8);
                this.hVP.setVisibility(0);
                this.hVH.setClickable(true);
                this.hVH.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.hVJ.setVisibility(0);
                this.hVI.setVisibility(0);
                oQ(iVar.hLg);
                aB(iVar.sortType, iVar.hLf);
                this.hVM.setVisibility(0);
            }
            if (this.Qk) {
                this.hVM.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.am.l(this.hVP, R.color.cp_bg_line_h);
            } else {
                this.hVM.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.am.l(this.hVP, R.color.cp_bg_line_e);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.l(this.hVP, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.l(this.hVN, R.color.cp_bg_line_d);
            this.hVH.onChangeSkinType(i);
            this.hVI.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.j(this.hVO, R.color.cp_cont_b);
            if (this.hVU != null && this.hVU.mType == com.baidu.tieba.pb.data.i.hLc) {
                com.baidu.tbadk.core.util.am.f(this.hVH, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.j(this.hVK, R.color.cp_cont_j);
            this.hVK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.j(this.hVJ, R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.l(this.hVL, R.color.cp_bg_line_c);
            this.hVJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            this.hVQ.onChangeSkinType(i);
            if (this.Qk) {
                com.baidu.tbadk.core.util.am.k(this.hVM, R.drawable.top_shadow);
                com.baidu.tbadk.core.util.am.l(this.hVP, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.am.l(this.hVP, R.color.cp_bg_line_e);
            }
        }
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.hVV = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.bDW.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bDW);
    }

    public void q(BdUniqueId bdUniqueId) {
        this.hVW = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.hVZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hVZ);
    }

    public void P(View.OnClickListener onClickListener) {
        this.hVT = onClickListener;
    }
}
