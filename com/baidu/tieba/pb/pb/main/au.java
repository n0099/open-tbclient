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
/* loaded from: classes22.dex */
public class au extends af.a {
    public boolean Yj;
    private CustomMessageListener exi;
    private View lAA;
    private View lAB;
    private TextView lAC;
    private List<TextLineView> lAD;
    private int lAE;
    private View.OnClickListener lAF;
    private com.baidu.tieba.pb.data.n lAG;
    private BdUniqueId lAH;
    private BdUniqueId lAI;
    private View.OnClickListener lAJ;
    private View.OnClickListener lAK;
    private CustomMessageListener lAL;
    public TextLineView lAs;
    public TextLineView lAt;
    public SortSwitchButton lAu;
    public TextView lAv;
    public View lAw;
    public View lAx;
    public View lAy;
    public TextLineView lAz;
    private SortSwitchButton.a lqG;
    private SortSwitchButton.a luP;
    private View mRootView;
    public int mSkinType;

    public au(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.lAE = 0;
        this.Yj = true;
        this.luP = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.au.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean zw(int i) {
                if (au.this.lqG != null) {
                    return au.this.lqG.zw(i);
                }
                return true;
            }
        };
        this.lAJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.lAF != null) {
                    au.this.lAF.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : au.this.lAD) {
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
        this.lAK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.lAF != null) {
                    au.this.lAF.onClick(view2);
                }
            }
        };
        this.exi = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.lAG != null && au.this.lAG.Vw == com.baidu.tieba.pb.data.n.lol && customResponsedMessage != null && getTag() == au.this.lAH && (customResponsedMessage.getData() instanceof az.a)) {
                    ((az.a) customResponsedMessage.getData()).lDm = au.this;
                }
            }
        };
        this.lAL = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.lAG == null || au.this.lAG.Vw != com.baidu.tieba.pb.data.n.lom || customResponsedMessage == null || getTag() != au.this.lAI || !(customResponsedMessage.getData() instanceof az.a)) {
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
            this.lAs = (TextLineView) view.findViewById(R.id.reply_title);
            this.lAs.setOnClickListener(this.lAJ);
            this.lAy = view.findViewById(R.id.reply_god_title_group);
            this.lAz = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.lAz.setSelected(false);
            this.lAB = view.findViewById(R.id.reply_all_title_frame);
            this.lAA = view.findViewById(R.id.reply_all_title);
            this.lAC = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.lAt = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.lAt.setOnClickListener(this.lAJ);
            this.lAu = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.lAu.setOnSwitchChangeListener(this.luP);
            this.lAu.setVisibility(0);
            this.lAv = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.lAs.setSelected(true);
            this.lAt.setSelected(false);
            this.lAD = new ArrayList();
            this.lAD.add(this.lAs);
            this.lAD.add(this.lAt);
            this.lAw = view.findViewById(R.id.divider_with_reply_title);
            this.lAx = view.findViewById(R.id.divider_bottom);
            this.lAu.jP(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void uF(boolean z) {
        if (z) {
            this.lAt.setSelected(true);
            this.lAs.setSelected(false);
            return;
        }
        this.lAt.setSelected(false);
        this.lAs.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            this.lAu.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.p pVar = new com.baidu.tieba.tbadkCore.data.p();
            pVar.JE(pbSortType.sort_type.intValue());
            pVar.SS(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.lAu.setVisibility(0);
        this.lAu.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.lAG = nVar;
        if (nVar != null) {
            if (nVar.Vw == com.baidu.tieba.pb.data.n.lom) {
                this.lAy.getContext();
                if (TextUtils.isEmpty(nVar.lop)) {
                    this.lAB.setVisibility(0);
                    this.lAy.setVisibility(8);
                    this.lAs.setVisibility(0);
                    this.lAs.setSelected(false);
                    this.lAs.setClickable(false);
                    this.lAs.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.lAB.setVisibility(8);
                    this.lAs.setVisibility(8);
                    this.lAy.setVisibility(0);
                    this.lAy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (au.this.lAF != null) {
                                au.this.lAF.onClick(au.this.lAy);
                            }
                        }
                    });
                }
                this.lAu.setVisibility(8);
                this.lAt.setVisibility(8);
                this.lAx.setVisibility(8);
            } else if (nVar.Vw == com.baidu.tieba.pb.data.n.lol) {
                this.lAy.setVisibility(8);
                this.lAB.setVisibility(0);
                this.lAs.setClickable(true);
                this.lAs.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lAt.setVisibility(0);
                uF(nVar.lor);
                if (nVar.los != null) {
                    this.lAu.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.los.size()) {
                            i = 0;
                            break;
                        } else if (nVar.los.get(i) != null && nVar.sortType == nVar.los.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.los, i);
                }
                this.lAx.setVisibility(0);
            }
            if (this.Yj) {
                this.lAx.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAB, R.color.cp_bg_line_h);
            } else {
                this.lAx.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAB, R.color.cp_bg_line_e);
            }
            if (nVar.isDynamic) {
                this.lAC.setVisibility(0);
                this.lAA.setVisibility(8);
            } else {
                this.lAC.setVisibility(8);
                this.lAA.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAB, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAy, R.color.cp_bg_line_d);
            this.lAs.onChangeSkinType(i);
            this.lAt.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAz, R.color.cp_cont_b);
            if (this.lAG != null && this.lAG.Vw == com.baidu.tieba.pb.data.n.lom) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAs, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAv, R.color.cp_cont_j);
            this.lAv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.lAu.onChangeSkinType();
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAw, R.color.cp_bg_line_c);
            if (this.Yj) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lAx, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAB, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAB, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAC, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.lAH = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.exi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.exi);
    }

    public void u(BdUniqueId bdUniqueId) {
        this.lAI = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.lAL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lAL);
    }

    public void V(View.OnClickListener onClickListener) {
        this.lAF = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lqG = aVar;
    }

    public void v(BdUniqueId bdUniqueId) {
        if (this.lAu != null) {
            this.lAu.setListenerTag(bdUniqueId);
            this.lAu.setCommenId(bdUniqueId);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void FK(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
