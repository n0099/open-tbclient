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
    private CustomMessageListener erp;
    private SortSwitchButton.a lkF;
    private SortSwitchButton.a loS;
    public View luA;
    public View luB;
    public TextLineView luC;
    private View luD;
    private View luE;
    private TextView luF;
    private List<TextLineView> luG;
    private int luH;
    private View.OnClickListener luI;
    private com.baidu.tieba.pb.data.n luJ;
    private BdUniqueId luK;
    private BdUniqueId luL;
    private View.OnClickListener luM;
    private View.OnClickListener luN;
    private CustomMessageListener luO;
    public TextLineView luv;
    public TextLineView luw;
    public SortSwitchButton lux;
    public TextView luy;
    public View luz;
    private View mRootView;
    public int mSkinType;

    public au(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.luH = 0;
        this.Yj = true;
        this.loS = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.au.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean zj(int i) {
                if (au.this.lkF != null) {
                    return au.this.lkF.zj(i);
                }
                return true;
            }
        };
        this.luM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.luI != null) {
                    au.this.luI.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : au.this.luG) {
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
        this.luN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.luI != null) {
                    au.this.luI.onClick(view2);
                }
            }
        };
        this.erp = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.luJ != null && au.this.luJ.Vw == com.baidu.tieba.pb.data.n.lim && customResponsedMessage != null && getTag() == au.this.luK && (customResponsedMessage.getData() instanceof az.a)) {
                    ((az.a) customResponsedMessage.getData()).lxp = au.this;
                }
            }
        };
        this.luO = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.luJ == null || au.this.luJ.Vw != com.baidu.tieba.pb.data.n.lin || customResponsedMessage == null || getTag() != au.this.luL || !(customResponsedMessage.getData() instanceof az.a)) {
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
            this.luv = (TextLineView) view.findViewById(R.id.reply_title);
            this.luv.setOnClickListener(this.luM);
            this.luB = view.findViewById(R.id.reply_god_title_group);
            this.luC = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.luC.setSelected(false);
            this.luE = view.findViewById(R.id.reply_all_title_frame);
            this.luD = view.findViewById(R.id.reply_all_title);
            this.luF = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.luw = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.luw.setOnClickListener(this.luM);
            this.lux = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.lux.setOnSwitchChangeListener(this.loS);
            this.lux.setVisibility(0);
            this.luy = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.luv.setSelected(true);
            this.luw.setSelected(false);
            this.luG = new ArrayList();
            this.luG.add(this.luv);
            this.luG.add(this.luw);
            this.luz = view.findViewById(R.id.divider_with_reply_title);
            this.luA = view.findViewById(R.id.divider_bottom);
            this.lux.jF(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void uw(boolean z) {
        if (z) {
            this.luw.setSelected(true);
            this.luv.setSelected(false);
            return;
        }
        this.luw.setSelected(false);
        this.luv.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            this.lux.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.p pVar = new com.baidu.tieba.tbadkCore.data.p();
            pVar.Jr(pbSortType.sort_type.intValue());
            pVar.SB(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.lux.setVisibility(0);
        this.lux.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.luJ = nVar;
        if (nVar != null) {
            if (nVar.Vw == com.baidu.tieba.pb.data.n.lin) {
                this.luB.getContext();
                if (TextUtils.isEmpty(nVar.lip)) {
                    this.luE.setVisibility(0);
                    this.luB.setVisibility(8);
                    this.luv.setVisibility(0);
                    this.luv.setSelected(false);
                    this.luv.setClickable(false);
                    this.luv.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.luE.setVisibility(8);
                    this.luv.setVisibility(8);
                    this.luB.setVisibility(0);
                    this.luB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (au.this.luI != null) {
                                au.this.luI.onClick(au.this.luB);
                            }
                        }
                    });
                }
                this.lux.setVisibility(8);
                this.luw.setVisibility(8);
                this.luA.setVisibility(8);
            } else if (nVar.Vw == com.baidu.tieba.pb.data.n.lim) {
                this.luB.setVisibility(8);
                this.luE.setVisibility(0);
                this.luv.setClickable(true);
                this.luv.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.luw.setVisibility(0);
                uw(nVar.lir);
                if (nVar.lis != null) {
                    this.lux.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.lis.size()) {
                            i = 0;
                            break;
                        } else if (nVar.lis.get(i) != null && nVar.sortType == nVar.lis.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.lis, i);
                }
                this.luA.setVisibility(0);
            }
            if (this.Yj) {
                this.luA.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.luE, R.color.cp_bg_line_h);
            } else {
                this.luA.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.luE, R.color.cp_bg_line_e);
            }
            if (nVar.isDynamic) {
                this.luF.setVisibility(0);
                this.luD.setVisibility(8);
            } else {
                this.luF.setVisibility(8);
                this.luD.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.luE, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.luB, R.color.cp_bg_line_d);
            this.luv.onChangeSkinType(i);
            this.luw.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.luC, R.color.cp_cont_b);
            if (this.luJ != null && this.luJ.Vw == com.baidu.tieba.pb.data.n.lin) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.luv, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.luy, R.color.cp_cont_j);
            this.luy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.lux.onChangeSkinType();
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.luz, R.color.cp_bg_line_c);
            if (this.Yj) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.luA, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.luE, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.luE, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.luF, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.luK = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.erp.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.erp);
    }

    public void u(BdUniqueId bdUniqueId) {
        this.luL = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.luO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.luO);
    }

    public void U(View.OnClickListener onClickListener) {
        this.luI = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lkF = aVar;
    }

    public void v(BdUniqueId bdUniqueId) {
        if (this.lux != null) {
            this.lux.setListenerTag(bdUniqueId);
            this.lux.setCommenId(bdUniqueId);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void Fx(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
