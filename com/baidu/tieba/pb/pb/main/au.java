package com.baidu.tieba.pb.pb.main;

import android.graphics.Typeface;
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
    public boolean Zl;
    private CustomMessageListener eCA;
    private SortSwitchButton.a lEE;
    private SortSwitchButton.a lIS;
    public TextView lOA;
    public View lOB;
    public View lOC;
    public View lOD;
    public TextLineView lOE;
    private View lOF;
    private View lOG;
    private TextView lOH;
    private List<TextLineView> lOI;
    private int lOJ;
    private View.OnClickListener lOK;
    private com.baidu.tieba.pb.data.n lOL;
    private BdUniqueId lOM;
    private BdUniqueId lON;
    private View.OnClickListener lOO;
    private View.OnClickListener lOP;
    private CustomMessageListener lOQ;
    public TextLineView lOx;
    public TextLineView lOy;
    public SortSwitchButton lOz;
    private TbPageContext mPageContext;
    private View mRootView;
    public int mSkinType;

    public au(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.lOJ = 0;
        this.Zl = true;
        this.lIS = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.au.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean Az(int i) {
                if (au.this.lEE != null) {
                    return au.this.lEE.Az(i);
                }
                return true;
            }
        };
        this.lOO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.lOK != null) {
                    au.this.lOK.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : au.this.lOI) {
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
        this.lOP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.lOK != null) {
                    au.this.lOK.onClick(view2);
                }
            }
        };
        this.eCA = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.lOL != null && au.this.lOL.Wv == com.baidu.tieba.pb.data.n.lCa && customResponsedMessage != null && getTag() == au.this.lOM && (customResponsedMessage.getData() instanceof az.a)) {
                    ((az.a) customResponsedMessage.getData()).lRv = au.this;
                }
            }
        };
        this.lOQ = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.lOL == null || au.this.lOL.Wv != com.baidu.tieba.pb.data.n.lCb || customResponsedMessage == null || getTag() != au.this.lON || !(customResponsedMessage.getData() instanceof az.a)) {
                }
            }
        };
        if (view != null) {
            this.mRootView = view;
            this.mPageContext = tbPageContext;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.lOx = (TextLineView) view.findViewById(R.id.reply_title);
            this.lOx.setOnClickListener(this.lOO);
            this.lOD = view.findViewById(R.id.reply_god_title_group);
            this.lOE = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.lOE.setSelected(false);
            this.lOG = view.findViewById(R.id.reply_all_title_frame);
            this.lOF = view.findViewById(R.id.reply_all_title);
            this.lOH = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.lOy = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.lOy.setOnClickListener(this.lOO);
            this.lOz = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.lOz.setOnSwitchChangeListener(this.lIS);
            this.lOz.setVisibility(0);
            this.lOA = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.lOx.setSelected(true);
            this.lOy.setSelected(false);
            this.lOI = new ArrayList();
            this.lOI.add(this.lOx);
            this.lOI.add(this.lOy);
            this.lOB = view.findViewById(R.id.divider_with_reply_title);
            this.lOC = view.findViewById(R.id.divider_bottom);
            this.lOz.kj(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vk(boolean z) {
        if (z) {
            this.lOy.setSelected(true);
            this.lOx.setSelected(false);
            return;
        }
        this.lOy.setSelected(false);
        this.lOx.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            this.lOz.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.p pVar = new com.baidu.tieba.tbadkCore.data.p();
            pVar.KW(pbSortType.sort_type.intValue());
            pVar.TH(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.lOz.setVisibility(0);
        this.lOz.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.lOL = nVar;
        if (nVar != null) {
            if (nVar.Wv == com.baidu.tieba.pb.data.n.lCb) {
                this.lOD.getContext();
                if (TextUtils.isEmpty(nVar.lCd)) {
                    this.lOG.setVisibility(0);
                    this.lOD.setVisibility(8);
                    this.lOx.setVisibility(0);
                    this.lOx.setSelected(false);
                    this.lOx.setClickable(false);
                    this.lOx.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.lOG.setVisibility(8);
                    this.lOx.setVisibility(8);
                    this.lOD.setVisibility(0);
                    this.lOD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (au.this.lOK != null) {
                                au.this.lOK.onClick(au.this.lOD);
                            }
                        }
                    });
                }
                this.lOz.setVisibility(8);
                this.lOy.setVisibility(8);
                this.lOC.setVisibility(8);
            } else if (nVar.Wv == com.baidu.tieba.pb.data.n.lCa) {
                this.lOD.setVisibility(8);
                this.lOG.setVisibility(0);
                this.lOx.setClickable(true);
                this.lOx.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lOy.setVisibility(0);
                vk(nVar.lCf);
                if (nVar.lCg != null) {
                    this.lOz.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.lCg.size()) {
                            i = 0;
                            break;
                        } else if (nVar.lCg.get(i) != null && nVar.sortType == nVar.lCg.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.lCg, i);
                }
                this.lOC.setVisibility(0);
            }
            if (this.Zl) {
                this.lOC.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOG, R.color.CAM_X0207);
            } else {
                this.lOC.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOG, R.color.CAM_X0205);
            }
            if (nVar.isDynamic) {
                this.lOH.setVisibility(0);
                this.lOF.setVisibility(8);
            } else {
                this.lOH.setVisibility(8);
                this.lOF.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOG, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOD, R.color.CAM_X0201);
            this.lOx.onChangeSkinType(i);
            this.lOy.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOE, R.color.CAM_X0105);
            if (this.lOL != null && this.lOL.Wv == com.baidu.tieba.pb.data.n.lCb) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOx, R.color.CAM_X0107, 1);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOA, R.color.CAM_X0107);
            this.lOA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.lOz.onChangeSkinType();
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOB, R.color.CAM_X0204);
            if (this.Zl) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOC, R.color.CAM_X0203);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOG, R.color.CAM_X0207);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOG, R.color.CAM_X0205);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOH, R.color.CAM_X0105, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.lOM = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.eCA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eCA);
    }

    public void u(BdUniqueId bdUniqueId) {
        this.lON = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.lOQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lOQ);
    }

    public void U(View.OnClickListener onClickListener) {
        this.lOK = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lEE = aVar;
    }

    public void v(BdUniqueId bdUniqueId) {
        if (this.lOz != null) {
            this.lOz.setListenerTag(bdUniqueId);
            this.lOz.setCommenId(bdUniqueId);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void GX(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void vl(boolean z) {
        if (z) {
            this.lOH.setText(R.string.hot_recommendation);
            this.lOH.setTypeface(Typeface.defaultFromStyle(1));
            this.lOH.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.T_X07));
            this.lOH.setVisibility(0);
            this.lOF.setVisibility(8);
            return;
        }
        this.lOH.setVisibility(8);
        this.lOF.setVisibility(0);
        this.lOH.setTypeface(Typeface.defaultFromStyle(0));
        this.lOH.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbfontsize42));
    }
}
