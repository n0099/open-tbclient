package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.ad;
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
public class aq extends ad.a {
    public boolean WY;
    private CustomMessageListener dFw;
    private SortSwitchButton.a kcv;
    private SortSwitchButton.a kgn;
    public TextLineView klA;
    private View klB;
    private View klC;
    private TextView klD;
    private List<TextLineView> klE;
    private int klF;
    private View.OnClickListener klG;
    private com.baidu.tieba.pb.data.l klH;
    private BdUniqueId klI;
    private BdUniqueId klJ;
    public boolean klK;
    private View.OnClickListener klL;
    private View.OnClickListener klM;
    private CustomMessageListener klN;
    public TextLineView kls;
    public TextLineView klt;
    public TextView klu;
    public SortSwitchButton klv;
    public TextView klw;
    public View klx;
    public View kly;
    public View klz;
    private View mRootView;
    public int mSkinType;

    public aq(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.klF = 0;
        this.klK = com.baidu.tbadk.a.d.aNQ();
        this.WY = true;
        this.kgn = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean va(int i) {
                if (aq.this.kcv != null) {
                    return aq.this.kcv.va(i);
                }
                return true;
            }
        };
        this.klL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aq.this.klG != null) {
                    aq.this.klG.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : aq.this.klE) {
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
        this.klM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aq.this.klG != null) {
                    aq.this.klG.onClick(view2);
                }
            }
        };
        this.dFw = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aq.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aq.this.klH != null && aq.this.klH.Un == com.baidu.tieba.pb.data.l.jZY && customResponsedMessage != null && getTag() == aq.this.klI && (customResponsedMessage.getData() instanceof av.a)) {
                    ((av.a) customResponsedMessage.getData()).kon = aq.this;
                }
            }
        };
        this.klN = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.aq.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (aq.this.klH == null || aq.this.klH.Un != com.baidu.tieba.pb.data.l.jZZ || customResponsedMessage == null || getTag() != aq.this.klJ || !(customResponsedMessage.getData() instanceof av.a)) {
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
            this.kls = (TextLineView) view.findViewById(R.id.reply_title);
            this.kls.setOnClickListener(this.klL);
            this.klz = view.findViewById(R.id.reply_god_title_group);
            this.klA = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.klA.setSelected(false);
            this.klC = view.findViewById(R.id.reply_all_title_frame);
            this.klB = view.findViewById(R.id.reply_all_title);
            this.klD = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.klt = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.klt.setOnClickListener(this.klL);
            this.klv = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.klu = (TextView) view.findViewById(R.id.pb_sort);
            if (this.klK) {
                this.klv.setOnSwitchChangeListener(this.kgn);
                this.klv.setVisibility(0);
            } else {
                this.klu.setOnClickListener(this.klM);
                this.klu.setVisibility(0);
            }
            this.klw = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.kls.setSelected(true);
            this.klt.setSelected(false);
            this.klE = new ArrayList();
            this.klE.add(this.kls);
            this.klE.add(this.klt);
            this.klx = view.findViewById(R.id.divider_with_reply_title);
            this.kly = view.findViewById(R.id.divider_bottom);
            if (this.klK) {
                this.klv.changeState(2);
            } else {
                bt(2, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bt(int i, String str) {
        this.klF = i;
        this.klu.setVisibility(0);
        if (str.length() > 0) {
            this.klu.setText(str);
        } else if (this.klF == 0) {
            this.klu.setText(R.string.default_sort);
        } else if (this.klF == 1) {
            this.klu.setText(R.string.view_reverse);
        } else if (this.klF == 2) {
            this.klu.setText(R.string.view_hot);
        }
    }

    public void sb(boolean z) {
        if (z) {
            this.klt.setSelected(true);
            this.kls.setSelected(false);
            return;
        }
        this.klt.setSelected(false);
        this.kls.setSelected(true);
    }

    public void o(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.w.isEmpty(list)) {
            this.klv.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.p pVar = new com.baidu.tieba.tbadkCore.data.p();
            pVar.EX(pbSortType.sort_type.intValue());
            pVar.Ng(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.klv.setVisibility(0);
        this.klv.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.l lVar) {
        this.klH = lVar;
        if (lVar != null) {
            if (lVar.Un == com.baidu.tieba.pb.data.l.jZZ) {
                this.klz.getContext();
                if (TextUtils.isEmpty(lVar.kab)) {
                    this.klC.setVisibility(0);
                    this.klz.setVisibility(8);
                    this.kls.setVisibility(0);
                    this.kls.setSelected(false);
                    this.kls.setClickable(false);
                    this.kls.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.klC.setVisibility(8);
                    this.kls.setVisibility(8);
                    this.klz.setVisibility(0);
                    this.klz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (aq.this.klG != null) {
                                aq.this.klG.onClick(aq.this.klz);
                            }
                        }
                    });
                }
                if (this.klK) {
                    this.klv.setVisibility(8);
                } else {
                    this.klu.setVisibility(8);
                }
                this.klt.setVisibility(8);
                this.kly.setVisibility(8);
            } else if (lVar.Un == com.baidu.tieba.pb.data.l.jZY) {
                this.klz.setVisibility(8);
                this.klC.setVisibility(0);
                this.kls.setClickable(true);
                this.kls.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.klt.setVisibility(0);
                sb(lVar.kad);
                if (this.klK) {
                    if (lVar.kae != null) {
                        this.klv.setVisibility(0);
                        int i = 0;
                        while (true) {
                            if (i >= lVar.kae.size()) {
                                i = 0;
                                break;
                            } else if (lVar.kae.get(i) != null && lVar.sortType == lVar.kae.get(i).sort_type.intValue()) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        o(lVar.kae, i);
                    }
                } else {
                    this.klu.setVisibility(0);
                    bt(lVar.sortType, lVar.kac);
                }
                this.kly.setVisibility(0);
            }
            if (this.WY) {
                this.kly.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.an.setBackgroundColor(this.klC, R.color.cp_bg_line_h);
            } else {
                this.kly.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.an.setBackgroundColor(this.klC, R.color.cp_bg_line_e);
            }
            if (lVar.isDynamic) {
                this.klD.setVisibility(0);
                this.klB.setVisibility(8);
            } else {
                this.klD.setVisibility(8);
                this.klB.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.klC, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.klz, R.color.cp_bg_line_d);
            this.kls.onChangeSkinType(i);
            this.klt.onChangeSkinType(i);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.klA, (int) R.color.cp_cont_b);
            if (this.klH != null && this.klH.Un == com.baidu.tieba.pb.data.l.jZZ) {
                com.baidu.tbadk.core.util.an.setViewTextColor(this.kls, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.an.setViewTextColor(this.klw, (int) R.color.cp_cont_j);
            this.klw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.an.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            if (this.klK) {
                this.klv.onChangeSkinType();
            } else {
                com.baidu.tbadk.core.util.an.setViewTextColor(this.klu, (int) R.color.cp_cont_j);
                this.klu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
            }
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.klx, R.color.cp_bg_line_b);
            if (this.WY) {
                com.baidu.tbadk.core.util.an.setBackgroundResource(this.kly, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.an.setBackgroundColor(this.klC, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.an.setBackgroundColor(this.klC, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.an.setViewTextColor(this.klD, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.klI = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.dFw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dFw);
    }

    public void u(BdUniqueId bdUniqueId) {
        this.klJ = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.klN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.klN);
    }

    public void S(View.OnClickListener onClickListener) {
        this.klG = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kcv = aVar;
    }

    public void v(BdUniqueId bdUniqueId) {
        if (this.klv != null && this.klK) {
            this.klv.setCommenId(bdUniqueId);
        }
    }
}
