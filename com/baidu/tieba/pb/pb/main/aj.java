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
    public boolean Wb;
    private CustomMessageListener dkZ;
    public TextLineView jzd;
    public TextLineView jze;
    public TextView jzf;
    public TextView jzg;
    public View jzh;
    public View jzi;
    public View jzj;
    public TextLineView jzk;
    private View jzl;
    private View jzm;
    private TextView jzn;
    private List<TextLineView> jzo;
    private int jzp;
    private View.OnClickListener jzq;
    private com.baidu.tieba.pb.data.j jzr;
    private BdUniqueId jzs;
    private BdUniqueId jzt;
    private View.OnClickListener jzu;
    private View.OnClickListener jzv;
    private CustomMessageListener jzw;
    private View mRootView;
    public int mSkinType;

    public aj(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.jzp = 0;
        this.Wb = true;
        this.jzu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aj.this.jzq != null) {
                    aj.this.jzq.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : aj.this.jzo) {
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
        this.jzv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aj.this.jzq != null) {
                    aj.this.jzq.onClick(view2);
                }
            }
        };
        this.dkZ = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aj.this.jzr != null && aj.this.jzr.Tv == com.baidu.tieba.pb.data.j.jow && customResponsedMessage != null && getTag() == aj.this.jzs && (customResponsedMessage.getData() instanceof an.a)) {
                    ((an.a) customResponsedMessage.getData()).jBR = aj.this;
                }
            }
        };
        this.jzw = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aj.this.jzr == null || aj.this.jzr.Tv != com.baidu.tieba.pb.data.j.jox || customResponsedMessage == null || getTag() != aj.this.jzt || !(customResponsedMessage.getData() instanceof an.a)) {
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
            this.jzd = (TextLineView) view.findViewById(R.id.reply_title);
            this.jzd.setOnClickListener(this.jzu);
            this.jzj = view.findViewById(R.id.reply_god_title_group);
            this.jzk = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.jzk.setSelected(false);
            this.jzm = view.findViewById(R.id.reply_all_title_frame);
            this.jzl = view.findViewById(R.id.reply_all_title);
            this.jzn = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.jze = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.jze.setOnClickListener(this.jzu);
            this.jzf = (TextView) view.findViewById(R.id.pb_sort);
            this.jzf.setOnClickListener(this.jzv);
            this.jzg = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.jzd.setSelected(true);
            this.jze.setSelected(false);
            this.jzo = new ArrayList();
            this.jzo.add(this.jzd);
            this.jzo.add(this.jze);
            this.jzh = view.findViewById(R.id.divider_with_reply_title);
            this.jzi = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.aZZ().aRA()) {
                bk(2, "");
            } else {
                bk(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bk(int i, String str) {
        this.jzp = i;
        this.jzf.setVisibility(0);
        if (str.length() > 0) {
            this.jzf.setText(str);
        } else if (this.jzp == 0) {
            this.jzf.setText(R.string.default_sort);
        } else if (this.jzp == 1) {
            this.jzf.setText(R.string.view_reverse);
        } else if (this.jzp == 2) {
            this.jzf.setText(R.string.view_hot);
        }
    }

    public void ro(boolean z) {
        if (z) {
            this.jze.setSelected(true);
            this.jzd.setSelected(false);
            return;
        }
        this.jze.setSelected(false);
        this.jzd.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.jzr = jVar;
        if (jVar != null) {
            if (jVar.Tv == com.baidu.tieba.pb.data.j.jox) {
                this.jzj.getContext();
                if (TextUtils.isEmpty(jVar.joz)) {
                    this.jzm.setVisibility(0);
                    this.jzj.setVisibility(8);
                    this.jzd.setVisibility(0);
                    this.jzd.setSelected(false);
                    this.jzd.setClickable(false);
                    this.jzd.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.jzm.setVisibility(8);
                    this.jzd.setVisibility(8);
                    this.jzj.setVisibility(0);
                    this.jzj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (aj.this.jzq != null) {
                                aj.this.jzq.onClick(aj.this.jzj);
                            }
                        }
                    });
                }
                this.jzf.setVisibility(8);
                this.jze.setVisibility(8);
                this.jzi.setVisibility(8);
            } else if (jVar.Tv == com.baidu.tieba.pb.data.j.jow) {
                this.jzj.setVisibility(8);
                this.jzm.setVisibility(0);
                this.jzd.setClickable(true);
                this.jzd.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.jzf.setVisibility(0);
                this.jze.setVisibility(0);
                ro(jVar.joB);
                bk(jVar.sortType, jVar.joA);
                this.jzi.setVisibility(0);
            }
            if (this.Wb) {
                this.jzi.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzm, R.color.cp_bg_line_h);
            } else {
                this.jzi.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzm, R.color.cp_bg_line_e);
            }
            if (jVar.isDynamic) {
                this.jzn.setVisibility(0);
                this.jzl.setVisibility(8);
            } else {
                this.jzn.setVisibility(8);
                this.jzl.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzm, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzj, R.color.cp_bg_line_d);
            this.jzd.onChangeSkinType(i);
            this.jze.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jzk, (int) R.color.cp_cont_b);
            if (this.jzr != null && this.jzr.Tv == com.baidu.tieba.pb.data.j.jox) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jzd, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jzg, (int) R.color.cp_cont_j);
            this.jzg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jzf, (int) R.color.cp_cont_j);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzh, R.color.cp_bg_line_b);
            this.jzf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            if (this.Wb) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jzi, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzm, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jzm, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jzn, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.jzs = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.dkZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dkZ);
    }

    public void s(BdUniqueId bdUniqueId) {
        this.jzt = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.jzw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jzw);
    }

    public void R(View.OnClickListener onClickListener) {
        this.jzq = onClickListener;
    }
}
