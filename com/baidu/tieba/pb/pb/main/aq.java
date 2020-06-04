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
    private SortSwitchButton.a jIL;
    private SortSwitchButton.a jMC;
    public TextLineView jRC;
    public TextLineView jRD;
    public TextView jRE;
    public SortSwitchButton jRF;
    public TextView jRG;
    public View jRH;
    public View jRI;
    public View jRJ;
    public TextLineView jRK;
    private View jRL;
    private View jRM;
    private TextView jRN;
    private List<TextLineView> jRO;
    private int jRP;
    private View.OnClickListener jRQ;
    private com.baidu.tieba.pb.data.l jRR;
    private BdUniqueId jRS;
    private BdUniqueId jRT;
    public boolean jRU;
    private View.OnClickListener jRV;
    private View.OnClickListener jRW;
    private CustomMessageListener jRX;
    private View mRootView;
    public int mSkinType;

    public aq(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.jRP = 0;
        this.jRU = com.baidu.tbadk.a.d.aMn();
        this.Wt = true;
        this.jMC = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean uv(int i) {
                if (aq.this.jIL != null) {
                    return aq.this.jIL.uv(i);
                }
                return true;
            }
        };
        this.jRV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aq.this.jRQ != null) {
                    aq.this.jRQ.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : aq.this.jRO) {
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
        this.jRW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aq.this.jRQ != null) {
                    aq.this.jRQ.onClick(view2);
                }
            }
        };
        this.dzd = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aq.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aq.this.jRR != null && aq.this.jRR.TK == com.baidu.tieba.pb.data.l.jGo && customResponsedMessage != null && getTag() == aq.this.jRS && (customResponsedMessage.getData() instanceof av.a)) {
                    ((av.a) customResponsedMessage.getData()).jUx = aq.this;
                }
            }
        };
        this.jRX = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aq.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aq.this.jRR == null || aq.this.jRR.TK != com.baidu.tieba.pb.data.l.jGp || customResponsedMessage == null || getTag() != aq.this.jRT || !(customResponsedMessage.getData() instanceof av.a)) {
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
            this.jRC = (TextLineView) view.findViewById(R.id.reply_title);
            this.jRC.setOnClickListener(this.jRV);
            this.jRJ = view.findViewById(R.id.reply_god_title_group);
            this.jRK = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.jRK.setSelected(false);
            this.jRM = view.findViewById(R.id.reply_all_title_frame);
            this.jRL = view.findViewById(R.id.reply_all_title);
            this.jRN = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.jRD = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.jRD.setOnClickListener(this.jRV);
            this.jRF = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.jRE = (TextView) view.findViewById(R.id.pb_sort);
            if (this.jRU) {
                this.jRF.setOnSwitchChangeListener(this.jMC);
                this.jRF.setVisibility(0);
            } else {
                this.jRE.setOnClickListener(this.jRW);
                this.jRE.setVisibility(0);
            }
            this.jRG = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.jRC.setSelected(true);
            this.jRD.setSelected(false);
            this.jRO = new ArrayList();
            this.jRO.add(this.jRC);
            this.jRO.add(this.jRD);
            this.jRH = view.findViewById(R.id.divider_with_reply_title);
            this.jRI = view.findViewById(R.id.divider_bottom);
            if (com.baidu.tbadk.util.a.bgi().aXF()) {
                if (this.jRU) {
                    this.jRF.changeState(2);
                } else {
                    bp(2, "");
                }
            } else if (this.jRU) {
                this.jRF.changeState(0);
            } else {
                bp(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bp(int i, String str) {
        this.jRP = i;
        this.jRE.setVisibility(0);
        if (str.length() > 0) {
            this.jRE.setText(str);
        } else if (this.jRP == 0) {
            this.jRE.setText(R.string.default_sort);
        } else if (this.jRP == 1) {
            this.jRE.setText(R.string.view_reverse);
        } else if (this.jRP == 2) {
            this.jRE.setText(R.string.view_hot);
        }
    }

    public void rN(boolean z) {
        if (z) {
            this.jRD.setSelected(true);
            this.jRC.setSelected(false);
            return;
        }
        this.jRD.setSelected(false);
        this.jRC.setSelected(true);
    }

    public void n(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            this.jRF.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.q qVar = new com.baidu.tieba.tbadkCore.data.q();
            qVar.DV(pbSortType.sort_type.intValue());
            qVar.ME(pbSortType.sort_name);
            arrayList.add(qVar);
        }
        this.jRF.setVisibility(0);
        this.jRF.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.l lVar) {
        this.jRR = lVar;
        if (lVar != null) {
            if (lVar.TK == com.baidu.tieba.pb.data.l.jGp) {
                this.jRJ.getContext();
                if (TextUtils.isEmpty(lVar.jGr)) {
                    this.jRM.setVisibility(0);
                    this.jRJ.setVisibility(8);
                    this.jRC.setVisibility(0);
                    this.jRC.setSelected(false);
                    this.jRC.setClickable(false);
                    this.jRC.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.jRM.setVisibility(8);
                    this.jRC.setVisibility(8);
                    this.jRJ.setVisibility(0);
                    this.jRJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (aq.this.jRQ != null) {
                                aq.this.jRQ.onClick(aq.this.jRJ);
                            }
                        }
                    });
                }
                if (this.jRU) {
                    this.jRF.setVisibility(8);
                } else {
                    this.jRE.setVisibility(8);
                }
                this.jRD.setVisibility(8);
                this.jRI.setVisibility(8);
            } else if (lVar.TK == com.baidu.tieba.pb.data.l.jGo) {
                this.jRJ.setVisibility(8);
                this.jRM.setVisibility(0);
                this.jRC.setClickable(true);
                this.jRC.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.jRD.setVisibility(0);
                rN(lVar.jGt);
                if (this.jRU) {
                    if (lVar.jGu != null) {
                        this.jRF.setVisibility(0);
                        int i = 0;
                        while (true) {
                            if (i >= lVar.jGu.size()) {
                                i = 0;
                                break;
                            } else if (lVar.jGu.get(i) != null && lVar.sortType == lVar.jGu.get(i).sort_type.intValue()) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        n(lVar.jGu, i);
                    }
                } else {
                    this.jRE.setVisibility(0);
                    bp(lVar.sortType, lVar.jGs);
                }
                this.jRI.setVisibility(0);
            }
            if (this.Wt) {
                this.jRI.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jRM, R.color.cp_bg_line_h);
            } else {
                this.jRI.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jRM, R.color.cp_bg_line_e);
            }
            if (lVar.isDynamic) {
                this.jRN.setVisibility(0);
                this.jRL.setVisibility(8);
            } else {
                this.jRN.setVisibility(8);
                this.jRL.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jRM, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jRJ, R.color.cp_bg_line_d);
            this.jRC.onChangeSkinType(i);
            this.jRD.onChangeSkinType(i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jRK, (int) R.color.cp_cont_b);
            if (this.jRR != null && this.jRR.TK == com.baidu.tieba.pb.data.l.jGp) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jRC, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jRG, (int) R.color.cp_cont_j);
            this.jRG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            if (this.jRU) {
                this.jRF.onChangeSkinType();
            } else {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jRE, (int) R.color.cp_cont_j);
                this.jRE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jRH, R.color.cp_bg_line_b);
            if (this.Wt) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jRI, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jRM, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.jRM, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jRN, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.jRS = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.dzd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dzd);
    }

    public void u(BdUniqueId bdUniqueId) {
        this.jRT = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.jRX.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jRX);
    }

    public void R(View.OnClickListener onClickListener) {
        this.jRQ = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.jIL = aVar;
    }

    public void v(BdUniqueId bdUniqueId) {
        if (this.jRF != null && this.jRU) {
            this.jRF.setCommenId(bdUniqueId);
        }
    }
}
