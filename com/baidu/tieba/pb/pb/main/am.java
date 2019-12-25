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
/* loaded from: classes6.dex */
public class am extends v.a {
    public boolean Ch;
    private CustomMessageListener cHq;
    private CustomMessageListener iIA;
    public TextLineView iIg;
    public TextLineView iIh;
    public TextView iIi;
    public TextView iIj;
    public View iIk;
    public View iIl;
    public View iIm;
    public TextLineView iIn;
    private View iIo;
    private View iIp;
    private TextView iIq;
    private com.baidu.tieba.pb.pb.godreply.usertips.a iIr;
    private List<TextLineView> iIs;
    private int iIt;
    private View.OnClickListener iIu;
    private com.baidu.tieba.pb.data.k iIv;
    private BdUniqueId iIw;
    private BdUniqueId iIx;
    private View.OnClickListener iIy;
    private View.OnClickListener iIz;
    private View mRootView;
    public int mSkinType;

    public am(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.iIr = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.iIt = 0;
        this.Ch = true;
        this.iIy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.am.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (am.this.iIu != null) {
                    am.this.iIu.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : am.this.iIs) {
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
        this.iIz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.am.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (am.this.iIu != null) {
                    am.this.iIu.onClick(view2);
                }
            }
        };
        this.cHq = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.am.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (am.this.iIv != null && am.this.iIv.zJ == com.baidu.tieba.pb.data.k.ixe && customResponsedMessage != null && getTag() == am.this.iIw && (customResponsedMessage.getData() instanceof aq.a)) {
                    ((aq.a) customResponsedMessage.getData()).iKU = am.this;
                }
            }
        };
        this.iIA = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.am.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (am.this.iIv != null && am.this.iIv.zJ == com.baidu.tieba.pb.data.k.ixf && customResponsedMessage != null && getTag() == am.this.iIx && (customResponsedMessage.getData() instanceof aq.a) && am.this.mRootView != null && am.this.iIr.cje() && am.this.iIj != null && am.this.iIj.getVisibility() == 0) {
                    if (am.this.mRootView == null || am.this.mRootView.getParent() == null) {
                        am.this.iIr.hideTip();
                        return;
                    }
                    if (!am.this.iIr.cje() && !com.baidu.tieba.pb.pb.godreply.usertips.b.fj(am.this.mRootView.getContext())) {
                        am.this.iIr.showTip(am.this.iIj);
                    }
                    if (am.this.iIr.cje()) {
                        am.this.iIr.cn(am.this.iIj);
                    }
                }
            }
        };
        if (view != null) {
            this.mRootView = view;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.am.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.iIg = (TextLineView) view.findViewById(R.id.reply_title);
            this.iIg.setOnClickListener(this.iIy);
            this.iIm = view.findViewById(R.id.reply_god_title_group);
            this.iIn = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.iIn.setSelected(false);
            this.iIp = view.findViewById(R.id.reply_all_title_frame);
            this.iIo = view.findViewById(R.id.reply_all_title);
            this.iIq = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.iIh = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.iIh.setOnClickListener(this.iIy);
            this.iIi = (TextView) view.findViewById(R.id.pb_sort);
            this.iIi.setOnClickListener(this.iIz);
            this.iIj = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.iIg.setSelected(true);
            this.iIh.setSelected(false);
            this.iIs = new ArrayList();
            this.iIs.add(this.iIg);
            this.iIs.add(this.iIh);
            this.iIk = view.findViewById(R.id.divider_with_reply_title);
            this.iIl = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.aPa().aGp()) {
                aP(2, "");
            } else {
                aP(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aP(int i, String str) {
        this.iIt = i;
        this.iIi.setVisibility(0);
        if (str.length() > 0) {
            this.iIi.setText(str);
        } else if (this.iIt == 0) {
            this.iIi.setText(R.string.default_sort);
        } else if (this.iIt == 1) {
            this.iIi.setText(R.string.view_reverse);
        } else if (this.iIt == 2) {
            this.iIi.setText(R.string.view_hot);
        }
    }

    public void pP(boolean z) {
        if (z) {
            this.iIh.setSelected(true);
            this.iIg.setSelected(false);
            return;
        }
        this.iIh.setSelected(false);
        this.iIg.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.k kVar) {
        this.iIv = kVar;
        if (kVar != null) {
            if (kVar.zJ == com.baidu.tieba.pb.data.k.ixf) {
                final Context context = this.iIm.getContext();
                if (TextUtils.isEmpty(kVar.ixh)) {
                    this.iIp.setVisibility(0);
                    this.iIm.setVisibility(8);
                    this.iIg.setVisibility(0);
                    this.iIg.setSelected(false);
                    this.iIg.setClickable(false);
                    this.iIg.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.iIp.setVisibility(8);
                    this.iIg.setVisibility(8);
                    this.iIm.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.am.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.k(context, true);
                            am.this.iIr.hideTip();
                            if (am.this.iIu != null) {
                                am.this.iIu.onClick(am.this.iIm);
                            }
                        }
                    };
                    this.iIm.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.fj(context) && this.iIj != null && this.iIj.getVisibility() == 0 && !this.iIr.cje()) {
                        this.iIr.Q(onClickListener);
                        this.iIr.showTip(this.iIj);
                    }
                }
                this.iIi.setVisibility(8);
                this.iIh.setVisibility(8);
                this.iIl.setVisibility(8);
            } else if (kVar.zJ == com.baidu.tieba.pb.data.k.ixe) {
                this.iIm.setVisibility(8);
                this.iIp.setVisibility(0);
                this.iIg.setClickable(true);
                this.iIg.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.iIi.setVisibility(0);
                this.iIh.setVisibility(0);
                pP(kVar.ixj);
                aP(kVar.sortType, kVar.ixi);
                this.iIl.setVisibility(0);
            }
            if (this.Ch) {
                this.iIl.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iIp, R.color.cp_bg_line_h);
            } else {
                this.iIl.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iIp, R.color.cp_bg_line_e);
            }
            if (kVar.isDynamic) {
                this.iIq.setVisibility(0);
                this.iIo.setVisibility(8);
            } else {
                this.iIq.setVisibility(8);
                this.iIo.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iIp, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iIm, R.color.cp_bg_line_d);
            this.iIg.onChangeSkinType(i);
            this.iIh.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iIn, (int) R.color.cp_cont_b);
            if (this.iIv != null && this.iIv.zJ == com.baidu.tieba.pb.data.k.ixf) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iIg, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iIj, (int) R.color.cp_cont_j);
            this.iIj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iIi, (int) R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iIk, R.color.cp_bg_line_b);
            this.iIi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            this.iIr.onChangeSkinType(i);
            if (this.Ch) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iIl, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iIp, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.iIp, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iIq, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.iIw = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.cHq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cHq);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.iIx = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.iIA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iIA);
    }

    public void R(View.OnClickListener onClickListener) {
        this.iIu = onClickListener;
    }
}
