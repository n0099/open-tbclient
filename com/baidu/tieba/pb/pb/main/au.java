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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.az;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes16.dex */
public class au extends ad.a {
    public boolean WR;
    private CustomMessageListener dLt;
    private SortSwitchButton.a kkZ;
    private SortSwitchButton.a kpg;
    public TextLineView kuA;
    private View kuB;
    private View kuC;
    private TextView kuD;
    private List<TextLineView> kuE;
    private int kuF;
    private View.OnClickListener kuG;
    private com.baidu.tieba.pb.data.n kuH;
    private BdUniqueId kuI;
    private BdUniqueId kuJ;
    private View.OnClickListener kuK;
    private View.OnClickListener kuL;
    private CustomMessageListener kuM;
    public TextLineView kut;
    public TextLineView kuu;
    public SortSwitchButton kuv;
    public TextView kuw;
    public View kux;
    public View kuy;
    public View kuz;
    private View mRootView;
    public int mSkinType;

    public au(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.kuF = 0;
        this.WR = true;
        this.kpg = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.au.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean vs(int i) {
                if (au.this.kkZ != null) {
                    return au.this.kkZ.vs(i);
                }
                return true;
            }
        };
        this.kuK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.kuG != null) {
                    au.this.kuG.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : au.this.kuE) {
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
        this.kuL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.kuG != null) {
                    au.this.kuG.onClick(view2);
                }
            }
        };
        this.dLt = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.kuH != null && au.this.kuH.Uh == com.baidu.tieba.pb.data.n.kiG && customResponsedMessage != null && getTag() == au.this.kuI && (customResponsedMessage.getData() instanceof az.a)) {
                    ((az.a) customResponsedMessage.getData()).kxn = au.this;
                }
            }
        };
        this.kuM = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.kuH == null || au.this.kuH.Uh != com.baidu.tieba.pb.data.n.kiH || customResponsedMessage == null || getTag() != au.this.kuJ || !(customResponsedMessage.getData() instanceof az.a)) {
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
            this.kut = (TextLineView) view.findViewById(R.id.reply_title);
            this.kut.setOnClickListener(this.kuK);
            this.kuz = view.findViewById(R.id.reply_god_title_group);
            this.kuA = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.kuA.setSelected(false);
            this.kuC = view.findViewById(R.id.reply_all_title_frame);
            this.kuB = view.findViewById(R.id.reply_all_title);
            this.kuD = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.kuu = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.kuu.setOnClickListener(this.kuK);
            this.kuv = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.kuv.setOnSwitchChangeListener(this.kpg);
            this.kuv.setVisibility(0);
            this.kuw = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.kut.setSelected(true);
            this.kuu.setSelected(false);
            this.kuE = new ArrayList();
            this.kuE.add(this.kut);
            this.kuE.add(this.kuu);
            this.kux = view.findViewById(R.id.divider_with_reply_title);
            this.kuy = view.findViewById(R.id.divider_bottom);
            this.kuv.changeState(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void sG(boolean z) {
        if (z) {
            this.kuu.setSelected(true);
            this.kut.setSelected(false);
            return;
        }
        this.kuu.setSelected(false);
        this.kut.setSelected(true);
    }

    public void m(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.x.isEmpty(list)) {
            this.kuv.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.p pVar = new com.baidu.tieba.tbadkCore.data.p();
            pVar.Ft(pbSortType.sort_type.intValue());
            pVar.NO(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.kuv.setVisibility(0);
        this.kuv.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.kuH = nVar;
        if (nVar != null) {
            if (nVar.Uh == com.baidu.tieba.pb.data.n.kiH) {
                this.kuz.getContext();
                if (TextUtils.isEmpty(nVar.kiJ)) {
                    this.kuC.setVisibility(0);
                    this.kuz.setVisibility(8);
                    this.kut.setVisibility(0);
                    this.kut.setSelected(false);
                    this.kut.setClickable(false);
                    this.kut.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.kuC.setVisibility(8);
                    this.kut.setVisibility(8);
                    this.kuz.setVisibility(0);
                    this.kuz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (au.this.kuG != null) {
                                au.this.kuG.onClick(au.this.kuz);
                            }
                        }
                    });
                }
                this.kuv.setVisibility(8);
                this.kuu.setVisibility(8);
                this.kuy.setVisibility(8);
            } else if (nVar.Uh == com.baidu.tieba.pb.data.n.kiG) {
                this.kuz.setVisibility(8);
                this.kuC.setVisibility(0);
                this.kut.setClickable(true);
                this.kut.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.kuu.setVisibility(0);
                sG(nVar.kiL);
                if (nVar.kiM != null) {
                    this.kuv.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.kiM.size()) {
                            i = 0;
                            break;
                        } else if (nVar.kiM.get(i) != null && nVar.sortType == nVar.kiM.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    m(nVar.kiM, i);
                }
                this.kuy.setVisibility(0);
            }
            if (this.WR) {
                this.kuy.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kuC, R.color.cp_bg_line_h);
            } else {
                this.kuy.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kuC, R.color.cp_bg_line_e);
            }
            if (nVar.isDynamic) {
                this.kuD.setVisibility(0);
                this.kuB.setVisibility(8);
            } else {
                this.kuD.setVisibility(8);
                this.kuB.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kuC, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kuz, R.color.cp_bg_line_d);
            this.kut.onChangeSkinType(i);
            this.kuu.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kuA, R.color.cp_cont_b);
            if (this.kuH != null && this.kuH.Uh == com.baidu.tieba.pb.data.n.kiH) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kut, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kuw, R.color.cp_cont_j);
            this.kuw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.kuv.onChangeSkinType();
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kux, R.color.cp_bg_line_c);
            if (this.WR) {
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.kuy, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kuC, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kuC, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kuD, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void m(BdUniqueId bdUniqueId) {
        this.kuI = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.dLt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dLt);
    }

    public void v(BdUniqueId bdUniqueId) {
        this.kuJ = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.kuM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kuM);
    }

    public void T(View.OnClickListener onClickListener) {
        this.kuG = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kkZ = aVar;
    }

    public void w(BdUniqueId bdUniqueId) {
        if (this.kuv != null) {
            this.kuv.setListenerTag(bdUniqueId);
            this.kuv.setCommenId(bdUniqueId);
        }
    }
}
