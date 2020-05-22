package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.av;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes9.dex */
public class aq extends aa.a {
    public boolean Wt;
    private CustomMessageListener dzd;
    private SortSwitchButton.a jHF;
    private SortSwitchButton.a jLw;
    public TextView jQA;
    public View jQB;
    public View jQC;
    public View jQD;
    public TextLineView jQE;
    private View jQF;
    private View jQG;
    private TextView jQH;
    private List<TextLineView> jQI;
    private int jQJ;
    private View.OnClickListener jQK;
    private com.baidu.tieba.pb.data.l jQL;
    private BdUniqueId jQM;
    private BdUniqueId jQN;
    public boolean jQO;
    private View.OnClickListener jQP;
    private View.OnClickListener jQQ;
    private CustomMessageListener jQR;
    public TextLineView jQw;
    public TextLineView jQx;
    public TextView jQy;
    public SortSwitchButton jQz;
    private View mRootView;
    public int mSkinType;

    public aq(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.jQJ = 0;
        this.jQO = com.baidu.tbadk.a.d.aMn();
        this.Wt = true;
        this.jLw = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean ut(int i) {
                if (aq.this.jHF != null) {
                    return aq.this.jHF.ut(i);
                }
                return true;
            }
        };
        this.jQP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aq.this.jQK != null) {
                    aq.this.jQK.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : aq.this.jQI) {
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
        this.jQQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aq.this.jQK != null) {
                    aq.this.jQK.onClick(view2);
                }
            }
        };
        this.dzd = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aq.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aq.this.jQL != null && aq.this.jQL.TK == com.baidu.tieba.pb.data.l.jFi && customResponsedMessage != null && getTag() == aq.this.jQM && (customResponsedMessage.getData() instanceof av.a)) {
                    ((av.a) customResponsedMessage.getData()).jTr = aq.this;
                }
            }
        };
        this.jQR = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aq.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aq.this.jQL == null || aq.this.jQL.TK != com.baidu.tieba.pb.data.l.jFj || customResponsedMessage == null || getTag() != aq.this.jQN || !(customResponsedMessage.getData() instanceof av.a)) {
                }
            }
        };
        if (view != null) {
            this.mRootView = view;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.jQw = (TextLineView) view.findViewById(R.id.reply_title);
            this.jQw.setOnClickListener(this.jQP);
            this.jQD = view.findViewById(R.id.reply_god_title_group);
            this.jQE = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.jQE.setSelected(false);
            this.jQG = view.findViewById(R.id.reply_all_title_frame);
            this.jQF = view.findViewById(R.id.reply_all_title);
            this.jQH = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.jQx = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.jQx.setOnClickListener(this.jQP);
            this.jQz = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.jQy = (TextView) view.findViewById(R.id.pb_sort);
            if (this.jQO) {
                this.jQz.setOnSwitchChangeListener(this.jLw);
                this.jQz.setVisibility(0);
            } else {
                this.jQy.setOnClickListener(this.jQQ);
                this.jQy.setVisibility(0);
            }
            this.jQA = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.jQw.setSelected(true);
            this.jQx.setSelected(false);
            this.jQI = new ArrayList();
            this.jQI.add(this.jQw);
            this.jQI.add(this.jQx);
            this.jQB = view.findViewById(R.id.divider_with_reply_title);
            this.jQC = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.bgh().aXE()) {
                if (this.jQO) {
                    this.jQz.changeState(2);
                } else {
                    bp(2, "");
                }
            } else if (this.jQO) {
                this.jQz.changeState(0);
            } else {
                bp(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bp(int i, String str) {
        this.jQJ = i;
        this.jQy.setVisibility(0);
        if (str.length() > 0) {
            this.jQy.setText(str);
        } else if (this.jQJ == 0) {
            this.jQy.setText(R.string.default_sort);
        } else if (this.jQJ == 1) {
            this.jQy.setText(R.string.view_reverse);
        } else if (this.jQJ == 2) {
            this.jQy.setText(R.string.view_hot);
        }
    }

    public void rN(boolean z) {
        if (z) {
            this.jQx.setSelected(true);
            this.jQw.setSelected(false);
            return;
        }
        this.jQx.setSelected(false);
        this.jQw.setSelected(true);
    }

    public void n(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            this.jQz.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.q qVar = new com.baidu.tieba.tbadkCore.data.q();
            qVar.DT(pbSortType.sort_type.intValue());
            qVar.MD(pbSortType.sort_name);
            arrayList.add(qVar);
        }
        this.jQz.setVisibility(0);
        this.jQz.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.l lVar) {
        this.jQL = lVar;
        if (lVar != null) {
            if (lVar.TK == com.baidu.tieba.pb.data.l.jFj) {
                this.jQD.getContext();
                if (TextUtils.isEmpty(lVar.jFl)) {
                    this.jQG.setVisibility(0);
                    this.jQD.setVisibility(8);
                    this.jQw.setVisibility(0);
                    this.jQw.setSelected(false);
                    this.jQw.setClickable(false);
                    this.jQw.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.jQG.setVisibility(8);
                    this.jQw.setVisibility(8);
                    this.jQD.setVisibility(0);
                    this.jQD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (aq.this.jQK != null) {
                                aq.this.jQK.onClick(aq.this.jQD);
                            }
                        }
                    });
                }
                if (this.jQO) {
                    this.jQz.setVisibility(8);
                } else {
                    this.jQy.setVisibility(8);
                }
                this.jQx.setVisibility(8);
                this.jQC.setVisibility(8);
            } else if (lVar.TK == com.baidu.tieba.pb.data.l.jFi) {
                this.jQD.setVisibility(8);
                this.jQG.setVisibility(0);
                this.jQw.setClickable(true);
                this.jQw.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.jQx.setVisibility(0);
                rN(lVar.jFn);
                if (this.jQO) {
                    if (lVar.jFo != null) {
                        this.jQz.setVisibility(0);
                        int i = 0;
                        while (true) {
                            if (i >= lVar.jFo.size()) {
                                i = 0;
                                break;
                            } else if (lVar.jFo.get(i) != null && lVar.sortType == lVar.jFo.get(i).sort_type.intValue()) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        n(lVar.jFo, i);
                    }
                } else {
                    this.jQy.setVisibility(0);
                    bp(lVar.sortType, lVar.jFm);
                }
                this.jQC.setVisibility(0);
            }
            if (this.Wt) {
                this.jQC.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jQG, R.color.cp_bg_line_h);
            } else {
                this.jQC.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jQG, R.color.cp_bg_line_e);
            }
            if (lVar.isDynamic) {
                this.jQH.setVisibility(0);
                this.jQF.setVisibility(8);
            } else {
                this.jQH.setVisibility(8);
                this.jQF.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jQG, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jQD, R.color.cp_bg_line_d);
            this.jQw.onChangeSkinType(i);
            this.jQx.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jQE, (int) R.color.cp_cont_b);
            if (this.jQL != null && this.jQL.TK == com.baidu.tieba.pb.data.l.jFj) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jQw, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jQA, (int) R.color.cp_cont_j);
            this.jQA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            if (this.jQO) {
                this.jQz.onChangeSkinType();
            } else {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jQy, (int) R.color.cp_cont_j);
                this.jQy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jQB, R.color.cp_bg_line_b);
            if (this.Wt) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jQC, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jQG, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jQG, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jQH, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.jQM = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.dzd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dzd);
    }

    public void u(BdUniqueId bdUniqueId) {
        this.jQN = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.jQR.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jQR);
    }

    public void R(View.OnClickListener onClickListener) {
        this.jQK = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.jHF = aVar;
    }

    public void v(BdUniqueId bdUniqueId) {
        if (this.jQz != null && this.jQO) {
            this.jQz.setCommenId(bdUniqueId);
        }
    }
}
