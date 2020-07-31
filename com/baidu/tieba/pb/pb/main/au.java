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
    private SortSwitchButton.a kkX;
    private SortSwitchButton.a kpe;
    private View kuA;
    private TextView kuB;
    private List<TextLineView> kuC;
    private int kuD;
    private View.OnClickListener kuE;
    private com.baidu.tieba.pb.data.n kuF;
    private BdUniqueId kuG;
    private BdUniqueId kuH;
    private View.OnClickListener kuI;
    private View.OnClickListener kuJ;
    private CustomMessageListener kuK;
    public TextLineView kur;
    public TextLineView kus;
    public SortSwitchButton kut;
    public TextView kuu;
    public View kuv;
    public View kuw;
    public View kux;
    public TextLineView kuy;
    private View kuz;
    private View mRootView;
    public int mSkinType;

    public au(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.kuD = 0;
        this.WR = true;
        this.kpe = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.au.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean vs(int i) {
                if (au.this.kkX != null) {
                    return au.this.kkX.vs(i);
                }
                return true;
            }
        };
        this.kuI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.kuE != null) {
                    au.this.kuE.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : au.this.kuC) {
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
        this.kuJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.kuE != null) {
                    au.this.kuE.onClick(view2);
                }
            }
        };
        this.dLt = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.kuF != null && au.this.kuF.Uh == com.baidu.tieba.pb.data.n.kiE && customResponsedMessage != null && getTag() == au.this.kuG && (customResponsedMessage.getData() instanceof az.a)) {
                    ((az.a) customResponsedMessage.getData()).kxl = au.this;
                }
            }
        };
        this.kuK = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.kuF == null || au.this.kuF.Uh != com.baidu.tieba.pb.data.n.kiF || customResponsedMessage == null || getTag() != au.this.kuH || !(customResponsedMessage.getData() instanceof az.a)) {
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
            this.kur = (TextLineView) view.findViewById(R.id.reply_title);
            this.kur.setOnClickListener(this.kuI);
            this.kux = view.findViewById(R.id.reply_god_title_group);
            this.kuy = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.kuy.setSelected(false);
            this.kuA = view.findViewById(R.id.reply_all_title_frame);
            this.kuz = view.findViewById(R.id.reply_all_title);
            this.kuB = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.kus = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.kus.setOnClickListener(this.kuI);
            this.kut = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.kut.setOnSwitchChangeListener(this.kpe);
            this.kut.setVisibility(0);
            this.kuu = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.kur.setSelected(true);
            this.kus.setSelected(false);
            this.kuC = new ArrayList();
            this.kuC.add(this.kur);
            this.kuC.add(this.kus);
            this.kuv = view.findViewById(R.id.divider_with_reply_title);
            this.kuw = view.findViewById(R.id.divider_bottom);
            this.kut.changeState(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void sG(boolean z) {
        if (z) {
            this.kus.setSelected(true);
            this.kur.setSelected(false);
            return;
        }
        this.kus.setSelected(false);
        this.kur.setSelected(true);
    }

    public void m(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.x.isEmpty(list)) {
            this.kut.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.p pVar = new com.baidu.tieba.tbadkCore.data.p();
            pVar.Ft(pbSortType.sort_type.intValue());
            pVar.NO(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.kut.setVisibility(0);
        this.kut.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.kuF = nVar;
        if (nVar != null) {
            if (nVar.Uh == com.baidu.tieba.pb.data.n.kiF) {
                this.kux.getContext();
                if (TextUtils.isEmpty(nVar.kiH)) {
                    this.kuA.setVisibility(0);
                    this.kux.setVisibility(8);
                    this.kur.setVisibility(0);
                    this.kur.setSelected(false);
                    this.kur.setClickable(false);
                    this.kur.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.kuA.setVisibility(8);
                    this.kur.setVisibility(8);
                    this.kux.setVisibility(0);
                    this.kux.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (au.this.kuE != null) {
                                au.this.kuE.onClick(au.this.kux);
                            }
                        }
                    });
                }
                this.kut.setVisibility(8);
                this.kus.setVisibility(8);
                this.kuw.setVisibility(8);
            } else if (nVar.Uh == com.baidu.tieba.pb.data.n.kiE) {
                this.kux.setVisibility(8);
                this.kuA.setVisibility(0);
                this.kur.setClickable(true);
                this.kur.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.kus.setVisibility(0);
                sG(nVar.kiJ);
                if (nVar.kiK != null) {
                    this.kut.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.kiK.size()) {
                            i = 0;
                            break;
                        } else if (nVar.kiK.get(i) != null && nVar.sortType == nVar.kiK.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    m(nVar.kiK, i);
                }
                this.kuw.setVisibility(0);
            }
            if (this.WR) {
                this.kuw.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kuA, R.color.cp_bg_line_h);
            } else {
                this.kuw.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kuA, R.color.cp_bg_line_e);
            }
            if (nVar.isDynamic) {
                this.kuB.setVisibility(0);
                this.kuz.setVisibility(8);
            } else {
                this.kuB.setVisibility(8);
                this.kuz.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kuA, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kux, R.color.cp_bg_line_d);
            this.kur.onChangeSkinType(i);
            this.kus.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kuy, R.color.cp_cont_b);
            if (this.kuF != null && this.kuF.Uh == com.baidu.tieba.pb.data.n.kiF) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kur, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kuu, R.color.cp_cont_j);
            this.kuu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.kut.onChangeSkinType();
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kuv, R.color.cp_bg_line_c);
            if (this.WR) {
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.kuw, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kuA, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kuA, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kuB, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void m(BdUniqueId bdUniqueId) {
        this.kuG = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.dLt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dLt);
    }

    public void v(BdUniqueId bdUniqueId) {
        this.kuH = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.kuK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kuK);
    }

    public void T(View.OnClickListener onClickListener) {
        this.kuE = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kkX = aVar;
    }

    public void w(BdUniqueId bdUniqueId) {
        if (this.kut != null) {
            this.kut.setListenerTag(bdUniqueId);
            this.kut.setCommenId(bdUniqueId);
        }
    }
}
