package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.y;
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
public class aj extends y.a {
    public boolean Wf;
    private CustomMessageListener dld;
    private CustomMessageListener jzA;
    public TextLineView jzh;
    public TextLineView jzi;
    public TextView jzj;
    public TextView jzk;
    public View jzl;
    public View jzm;
    public View jzn;
    public TextLineView jzo;
    private View jzp;
    private View jzq;
    private TextView jzr;
    private List<TextLineView> jzs;
    private int jzt;
    private View.OnClickListener jzu;
    private com.baidu.tieba.pb.data.j jzv;
    private BdUniqueId jzw;
    private BdUniqueId jzx;
    private View.OnClickListener jzy;
    private View.OnClickListener jzz;
    private View mRootView;
    public int mSkinType;

    public aj(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.jzt = 0;
        this.Wf = true;
        this.jzy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aj.this.jzu != null) {
                    aj.this.jzu.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : aj.this.jzs) {
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
        this.jzz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aj.this.jzu != null) {
                    aj.this.jzu.onClick(view2);
                }
            }
        };
        this.dld = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aj.this.jzv != null && aj.this.jzv.Ty == com.baidu.tieba.pb.data.j.joA && customResponsedMessage != null && getTag() == aj.this.jzw && (customResponsedMessage.getData() instanceof an.a)) {
                    ((an.a) customResponsedMessage.getData()).jBV = aj.this;
                }
            }
        };
        this.jzA = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aj.this.jzv == null || aj.this.jzv.Ty != com.baidu.tieba.pb.data.j.joB || customResponsedMessage == null || getTag() != aj.this.jzx || !(customResponsedMessage.getData() instanceof an.a)) {
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
            this.jzh = (TextLineView) view.findViewById(R.id.reply_title);
            this.jzh.setOnClickListener(this.jzy);
            this.jzn = view.findViewById(R.id.reply_god_title_group);
            this.jzo = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.jzo.setSelected(false);
            this.jzq = view.findViewById(R.id.reply_all_title_frame);
            this.jzp = view.findViewById(R.id.reply_all_title);
            this.jzr = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.jzi = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.jzi.setOnClickListener(this.jzy);
            this.jzj = (TextView) view.findViewById(R.id.pb_sort);
            this.jzj.setOnClickListener(this.jzz);
            this.jzk = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.jzh.setSelected(true);
            this.jzi.setSelected(false);
            this.jzs = new ArrayList();
            this.jzs.add(this.jzh);
            this.jzs.add(this.jzi);
            this.jzl = view.findViewById(R.id.divider_with_reply_title);
            this.jzm = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.aZX().aRx()) {
                bk(2, "");
            } else {
                bk(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bk(int i, String str) {
        this.jzt = i;
        this.jzj.setVisibility(0);
        if (str.length() > 0) {
            this.jzj.setText(str);
        } else if (this.jzt == 0) {
            this.jzj.setText(R.string.default_sort);
        } else if (this.jzt == 1) {
            this.jzj.setText(R.string.view_reverse);
        } else if (this.jzt == 2) {
            this.jzj.setText(R.string.view_hot);
        }
    }

    public void ro(boolean z) {
        if (z) {
            this.jzi.setSelected(true);
            this.jzh.setSelected(false);
            return;
        }
        this.jzi.setSelected(false);
        this.jzh.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.jzv = jVar;
        if (jVar != null) {
            if (jVar.Ty == com.baidu.tieba.pb.data.j.joB) {
                this.jzn.getContext();
                if (TextUtils.isEmpty(jVar.joD)) {
                    this.jzq.setVisibility(0);
                    this.jzn.setVisibility(8);
                    this.jzh.setVisibility(0);
                    this.jzh.setSelected(false);
                    this.jzh.setClickable(false);
                    this.jzh.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.jzq.setVisibility(8);
                    this.jzh.setVisibility(8);
                    this.jzn.setVisibility(0);
                    this.jzn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (aj.this.jzu != null) {
                                aj.this.jzu.onClick(aj.this.jzn);
                            }
                        }
                    });
                }
                this.jzj.setVisibility(8);
                this.jzi.setVisibility(8);
                this.jzm.setVisibility(8);
            } else if (jVar.Ty == com.baidu.tieba.pb.data.j.joA) {
                this.jzn.setVisibility(8);
                this.jzq.setVisibility(0);
                this.jzh.setClickable(true);
                this.jzh.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.jzj.setVisibility(0);
                this.jzi.setVisibility(0);
                ro(jVar.joF);
                bk(jVar.sortType, jVar.joE);
                this.jzm.setVisibility(0);
            }
            if (this.Wf) {
                this.jzm.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzq, R.color.cp_bg_line_h);
            } else {
                this.jzm.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzq, R.color.cp_bg_line_e);
            }
            if (jVar.isDynamic) {
                this.jzr.setVisibility(0);
                this.jzp.setVisibility(8);
            } else {
                this.jzr.setVisibility(8);
                this.jzp.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzq, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzn, R.color.cp_bg_line_d);
            this.jzh.onChangeSkinType(i);
            this.jzi.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jzo, (int) R.color.cp_cont_b);
            if (this.jzv != null && this.jzv.Ty == com.baidu.tieba.pb.data.j.joB) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jzh, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jzk, (int) R.color.cp_cont_j);
            this.jzk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jzj, (int) R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzl, R.color.cp_bg_line_b);
            this.jzj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            if (this.Wf) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jzm, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzq, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzq, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jzr, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.jzw = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.dld.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dld);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.jzx = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.jzA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jzA);
    }

    public void R(View.OnClickListener onClickListener) {
        this.jzu = onClickListener;
    }
}
