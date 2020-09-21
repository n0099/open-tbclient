package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.az;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes21.dex */
public class au extends af.a {
    public boolean XR;
    private CustomMessageListener dWP;
    private SortSwitchButton.a kIV;
    private SortSwitchButton.a kNd;
    public TextLineView kSF;
    public TextLineView kSG;
    public SortSwitchButton kSH;
    public TextView kSI;
    public View kSJ;
    public View kSK;
    public View kSL;
    public TextLineView kSM;
    private View kSN;
    private View kSO;
    private TextView kSP;
    private List<TextLineView> kSQ;
    private int kSR;
    private View.OnClickListener kSS;
    private com.baidu.tieba.pb.data.n kST;
    private BdUniqueId kSU;
    private BdUniqueId kSV;
    private View.OnClickListener kSW;
    private View.OnClickListener kSX;
    private CustomMessageListener kSY;
    private View mRootView;
    public int mSkinType;

    public au(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.kSR = 0;
        this.XR = true;
        this.kNd = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.au.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean yk(int i) {
                if (au.this.kIV != null) {
                    return au.this.kIV.yk(i);
                }
                return true;
            }
        };
        this.kSW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.kSS != null) {
                    au.this.kSS.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : au.this.kSQ) {
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
        this.kSX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.kSS != null) {
                    au.this.kSS.onClick(view2);
                }
            }
        };
        this.dWP = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.kST != null && au.this.kST.Vf == com.baidu.tieba.pb.data.n.kGC && customResponsedMessage != null && getTag() == au.this.kSU && (customResponsedMessage.getData() instanceof az.a)) {
                    ((az.a) customResponsedMessage.getData()).kVz = au.this;
                }
            }
        };
        this.kSY = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.kST == null || au.this.kST.Vf != com.baidu.tieba.pb.data.n.kGD || customResponsedMessage == null || getTag() != au.this.kSV || !(customResponsedMessage.getData() instanceof az.a)) {
                }
            }
        };
        if (view != null) {
            this.mRootView = view;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.kSF = (TextLineView) view.findViewById(R.id.reply_title);
            this.kSF.setOnClickListener(this.kSW);
            this.kSL = view.findViewById(R.id.reply_god_title_group);
            this.kSM = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.kSM.setSelected(false);
            this.kSO = view.findViewById(R.id.reply_all_title_frame);
            this.kSN = view.findViewById(R.id.reply_all_title);
            this.kSP = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.kSG = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.kSG.setOnClickListener(this.kSW);
            this.kSH = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.kSH.setOnSwitchChangeListener(this.kNd);
            this.kSH.setVisibility(0);
            this.kSI = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.kSF.setSelected(true);
            this.kSG.setSelected(false);
            this.kSQ = new ArrayList();
            this.kSQ.add(this.kSF);
            this.kSQ.add(this.kSG);
            this.kSJ = view.findViewById(R.id.divider_with_reply_title);
            this.kSK = view.findViewById(R.id.divider_bottom);
            this.kSH.iX(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ty(boolean z) {
        if (z) {
            this.kSG.setSelected(true);
            this.kSF.setSelected(false);
            return;
        }
        this.kSG.setSelected(false);
        this.kSF.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            this.kSH.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.p pVar = new com.baidu.tieba.tbadkCore.data.p();
            pVar.It(pbSortType.sort_type.intValue());
            pVar.Ro(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.kSH.setVisibility(0);
        this.kSH.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.kST = nVar;
        if (nVar != null) {
            if (nVar.Vf == com.baidu.tieba.pb.data.n.kGD) {
                this.kSL.getContext();
                if (TextUtils.isEmpty(nVar.kGF)) {
                    this.kSO.setVisibility(0);
                    this.kSL.setVisibility(8);
                    this.kSF.setVisibility(0);
                    this.kSF.setSelected(false);
                    this.kSF.setClickable(false);
                    this.kSF.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.kSO.setVisibility(8);
                    this.kSF.setVisibility(8);
                    this.kSL.setVisibility(0);
                    this.kSL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (au.this.kSS != null) {
                                au.this.kSS.onClick(au.this.kSL);
                            }
                        }
                    });
                }
                this.kSH.setVisibility(8);
                this.kSG.setVisibility(8);
                this.kSK.setVisibility(8);
            } else if (nVar.Vf == com.baidu.tieba.pb.data.n.kGC) {
                this.kSL.setVisibility(8);
                this.kSO.setVisibility(0);
                this.kSF.setClickable(true);
                this.kSF.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.kSG.setVisibility(0);
                ty(nVar.kGH);
                if (nVar.kGI != null) {
                    this.kSH.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.kGI.size()) {
                            i = 0;
                            break;
                        } else if (nVar.kGI.get(i) != null && nVar.sortType == nVar.kGI.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.kGI, i);
                }
                this.kSK.setVisibility(0);
            }
            if (this.XR) {
                this.kSK.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kSO, R.color.cp_bg_line_h);
            } else {
                this.kSK.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kSO, R.color.cp_bg_line_e);
            }
            if (nVar.isDynamic) {
                this.kSP.setVisibility(0);
                this.kSN.setVisibility(8);
            } else {
                this.kSP.setVisibility(8);
                this.kSN.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kSO, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kSL, R.color.cp_bg_line_d);
            this.kSF.onChangeSkinType(i);
            this.kSG.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kSM, R.color.cp_cont_b);
            if (this.kST != null && this.kST.Vf == com.baidu.tieba.pb.data.n.kGD) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kSF, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kSI, R.color.cp_cont_j);
            this.kSI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.kSH.onChangeSkinType();
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kSJ, R.color.cp_bg_line_c);
            if (this.XR) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kSK, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kSO, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kSO, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kSP, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.kSU = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.dWP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dWP);
    }

    public void u(BdUniqueId bdUniqueId) {
        this.kSV = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.kSY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kSY);
    }

    public void U(View.OnClickListener onClickListener) {
        this.kSS = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kIV = aVar;
    }

    public void v(BdUniqueId bdUniqueId) {
        if (this.kSH != null) {
            this.kSH.setListenerTag(bdUniqueId);
            this.kSH.setCommenId(bdUniqueId);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void Ey(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
