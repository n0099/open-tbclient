package com.baidu.tieba.pb.pb.main;

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
import com.baidu.tieba.pb.pb.main.an;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class aj extends v.a {
    public boolean CF;
    private CustomMessageListener cLS;
    public TextLineView iOU;
    public TextLineView iOV;
    public TextView iOW;
    public TextView iOX;
    public View iOY;
    public View iOZ;
    public View iPa;
    public TextLineView iPb;
    private View iPc;
    private View iPd;
    private TextView iPe;
    private List<TextLineView> iPf;
    private int iPg;
    private View.OnClickListener iPh;
    private com.baidu.tieba.pb.data.j iPi;
    private BdUniqueId iPj;
    private BdUniqueId iPk;
    private View.OnClickListener iPl;
    private View.OnClickListener iPm;
    private CustomMessageListener iPn;
    private View mRootView;
    public int mSkinType;

    public aj(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.iPg = 0;
        this.CF = true;
        this.iPl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aj.this.iPh != null) {
                    aj.this.iPh.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : aj.this.iPf) {
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
        this.iPm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aj.this.iPh != null) {
                    aj.this.iPh.onClick(view2);
                }
            }
        };
        this.cLS = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aj.this.iPi != null && aj.this.iPi.Ag == com.baidu.tieba.pb.data.j.iEq && customResponsedMessage != null && getTag() == aj.this.iPj && (customResponsedMessage.getData() instanceof an.a)) {
                    ((an.a) customResponsedMessage.getData()).iRI = aj.this;
                }
            }
        };
        this.iPn = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aj.this.iPi == null || aj.this.iPi.Ag != com.baidu.tieba.pb.data.j.iEr || customResponsedMessage == null || getTag() != aj.this.iPk || !(customResponsedMessage.getData() instanceof an.a)) {
                }
            }
        };
        if (view != null) {
            this.mRootView = view;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.iOU = (TextLineView) view.findViewById(R.id.reply_title);
            this.iOU.setOnClickListener(this.iPl);
            this.iPa = view.findViewById(R.id.reply_god_title_group);
            this.iPb = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.iPb.setSelected(false);
            this.iPd = view.findViewById(R.id.reply_all_title_frame);
            this.iPc = view.findViewById(R.id.reply_all_title);
            this.iPe = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.iOV = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.iOV.setOnClickListener(this.iPl);
            this.iOW = (TextView) view.findViewById(R.id.pb_sort);
            this.iOW.setOnClickListener(this.iPm);
            this.iOX = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.iOU.setSelected(true);
            this.iOV.setSelected(false);
            this.iPf = new ArrayList();
            this.iPf.add(this.iOU);
            this.iPf.add(this.iOV);
            this.iOY = view.findViewById(R.id.divider_with_reply_title);
            this.iOZ = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.aRQ().aJd()) {
                aV(2, "");
            } else {
                aV(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aV(int i, String str) {
        this.iPg = i;
        this.iOW.setVisibility(0);
        if (str.length() > 0) {
            this.iOW.setText(str);
        } else if (this.iPg == 0) {
            this.iOW.setText(R.string.default_sort);
        } else if (this.iPg == 1) {
            this.iOW.setText(R.string.view_reverse);
        } else if (this.iPg == 2) {
            this.iOW.setText(R.string.view_hot);
        }
    }

    public void qk(boolean z) {
        if (z) {
            this.iOV.setSelected(true);
            this.iOU.setSelected(false);
            return;
        }
        this.iOV.setSelected(false);
        this.iOU.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.iPi = jVar;
        if (jVar != null) {
            if (jVar.Ag == com.baidu.tieba.pb.data.j.iEr) {
                this.iPa.getContext();
                if (TextUtils.isEmpty(jVar.iEt)) {
                    this.iPd.setVisibility(0);
                    this.iPa.setVisibility(8);
                    this.iOU.setVisibility(0);
                    this.iOU.setSelected(false);
                    this.iOU.setClickable(false);
                    this.iOU.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.iPd.setVisibility(8);
                    this.iOU.setVisibility(8);
                    this.iPa.setVisibility(0);
                    this.iPa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (aj.this.iPh != null) {
                                aj.this.iPh.onClick(aj.this.iPa);
                            }
                        }
                    });
                }
                this.iOW.setVisibility(8);
                this.iOV.setVisibility(8);
                this.iOZ.setVisibility(8);
            } else if (jVar.Ag == com.baidu.tieba.pb.data.j.iEq) {
                this.iPa.setVisibility(8);
                this.iPd.setVisibility(0);
                this.iOU.setClickable(true);
                this.iOU.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.iOW.setVisibility(0);
                this.iOV.setVisibility(0);
                qk(jVar.iEv);
                aV(jVar.sortType, jVar.iEu);
                this.iOZ.setVisibility(0);
            }
            if (this.CF) {
                this.iOZ.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iPd, R.color.cp_bg_line_h);
            } else {
                this.iOZ.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iPd, R.color.cp_bg_line_e);
            }
            if (jVar.isDynamic) {
                this.iPe.setVisibility(0);
                this.iPc.setVisibility(8);
            } else {
                this.iPe.setVisibility(8);
                this.iPc.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iPd, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iPa, R.color.cp_bg_line_d);
            this.iOU.onChangeSkinType(i);
            this.iOV.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iPb, (int) R.color.cp_cont_b);
            if (this.iPi != null && this.iPi.Ag == com.baidu.tieba.pb.data.j.iEr) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iOU, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iOX, (int) R.color.cp_cont_j);
            this.iOX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iOW, (int) R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iOY, R.color.cp_bg_line_b);
            this.iOW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            if (this.CF) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iOZ, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iPd, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iPd, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iPe, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.iPj = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.cLS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cLS);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.iPk = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.iPn.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iPn);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.iPh = onClickListener;
    }
}
