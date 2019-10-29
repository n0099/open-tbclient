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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    public boolean Ac;
    private CustomMessageListener bVR;
    private int hUA;
    private View.OnClickListener hUB;
    private com.baidu.tieba.pb.data.i hUC;
    private BdUniqueId hUD;
    private BdUniqueId hUE;
    private View.OnClickListener hUF;
    private View.OnClickListener hUG;
    private CustomMessageListener hUH;
    public TextLineView hUp;
    public TextLineView hUq;
    public TextView hUr;
    public TextView hUs;
    public View hUt;
    public View hUu;
    public View hUv;
    public TextLineView hUw;
    public View hUx;
    private com.baidu.tieba.pb.pb.godreply.usertips.a hUy;
    private List<TextLineView> hUz;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.hUy = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.hUA = 0;
        this.Ac = true;
        this.hUF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hUB != null) {
                    al.this.hUB.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.hUz) {
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
        this.hUG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.hUB != null) {
                    al.this.hUB.onClick(view2);
                }
            }
        };
        this.bVR = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hUC != null && al.this.hUC.xL == com.baidu.tieba.pb.data.i.hJH && customResponsedMessage != null && getTag() == al.this.hUD && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).hXU = al.this;
                }
            }
        };
        this.hUH = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.hUC != null && al.this.hUC.xL == com.baidu.tieba.pb.data.i.hJI && customResponsedMessage != null && getTag() == al.this.hUE && (customResponsedMessage.getData() instanceof aq.a) && al.this.mRootView != null && al.this.hUy.bRQ() && al.this.hUs != null && al.this.hUs.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.hUy.hideTip();
                        return;
                    }
                    if (!al.this.hUy.bRQ() && !com.baidu.tieba.pb.pb.godreply.usertips.b.dS(al.this.mRootView.getContext())) {
                        al.this.hUy.showTip(al.this.hUs);
                    }
                    if (al.this.hUy.bRQ()) {
                        al.this.hUy.cr(al.this.hUs);
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
            this.hUp = (TextLineView) view.findViewById(R.id.reply_title);
            this.hUp.setOnClickListener(this.hUF);
            this.hUv = view.findViewById(R.id.reply_god_title_group);
            this.hUw = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.hUw.setSelected(false);
            this.hUx = view.findViewById(R.id.reply_all_title);
            this.hUq = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.hUq.setOnClickListener(this.hUF);
            this.hUr = (TextView) view.findViewById(R.id.pb_sort);
            this.hUr.setOnClickListener(this.hUG);
            this.hUs = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.hUp.setSelected(true);
            this.hUq.setSelected(false);
            this.hUz = new ArrayList();
            this.hUz.add(this.hUp);
            this.hUz.add(this.hUq);
            this.hUt = view.findViewById(R.id.divider_with_reply_title);
            this.hUu = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.axp().aoP()) {
                aB(2, "");
            } else {
                aB(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aB(int i, String str) {
        this.hUA = i;
        this.hUr.setVisibility(0);
        if (str.length() > 0) {
            this.hUr.setText(str);
        } else if (this.hUA == 0) {
            this.hUr.setText(R.string.default_sort);
        } else if (this.hUA == 1) {
            this.hUr.setText(R.string.view_reverse);
        } else if (this.hUA == 2) {
            this.hUr.setText(R.string.view_hot);
        }
    }

    public void oz(boolean z) {
        if (z) {
            this.hUq.setSelected(true);
            this.hUp.setSelected(false);
            return;
        }
        this.hUq.setSelected(false);
        this.hUp.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.i iVar) {
        this.hUC = iVar;
        if (iVar != null) {
            if (iVar.xL == com.baidu.tieba.pb.data.i.hJI) {
                final Context context = this.hUv.getContext();
                if (TextUtils.isEmpty(iVar.hJK)) {
                    this.hUx.setVisibility(0);
                    this.hUv.setVisibility(8);
                    this.hUp.setVisibility(0);
                    this.hUp.setSelected(false);
                    this.hUp.setClickable(false);
                    this.hUp.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.hUx.setVisibility(8);
                    this.hUp.setVisibility(8);
                    this.hUv.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.j(context, true);
                            al.this.hUy.hideTip();
                            if (al.this.hUB != null) {
                                al.this.hUB.onClick(al.this.hUv);
                            }
                        }
                    };
                    this.hUv.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.dS(context) && this.hUs != null && this.hUs.getVisibility() == 0 && !this.hUy.bRQ()) {
                        this.hUy.P(onClickListener);
                        this.hUy.showTip(this.hUs);
                    }
                }
                this.hUr.setVisibility(8);
                this.hUq.setVisibility(8);
                this.hUu.setVisibility(8);
            } else if (iVar.xL == com.baidu.tieba.pb.data.i.hJH) {
                this.hUv.setVisibility(8);
                this.hUx.setVisibility(0);
                this.hUp.setClickable(true);
                this.hUp.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.hUr.setVisibility(0);
                this.hUq.setVisibility(0);
                oz(iVar.hJM);
                aB(iVar.sortType, iVar.hJL);
                this.hUu.setVisibility(0);
            }
            if (this.Ac) {
                this.hUu.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hUx, R.color.cp_bg_line_h);
            } else {
                this.hUu.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hUx, R.color.cp_bg_line_e);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hUx, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hUv, R.color.cp_bg_line_d);
            this.hUp.onChangeSkinType(i);
            this.hUq.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hUw, (int) R.color.cp_cont_b);
            if (this.hUC != null && this.hUC.xL == com.baidu.tieba.pb.data.i.hJI) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hUp, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hUs, (int) R.color.cp_cont_j);
            this.hUs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hUr, (int) R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hUt, R.color.cp_bg_line_c);
            this.hUr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            this.hUy.onChangeSkinType(i);
            if (this.Ac) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hUu, R.drawable.top_shadow);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hUx, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hUx, R.color.cp_bg_line_e);
            }
        }
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.hUD = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.bVR.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bVR);
    }

    public void r(BdUniqueId bdUniqueId) {
        this.hUE = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.hUH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hUH);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.hUB = onClickListener;
    }
}
