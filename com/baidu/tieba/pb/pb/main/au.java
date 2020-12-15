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
    private SortSwitchButton.a lEG;
    private SortSwitchButton.a lIU;
    public TextLineView lOA;
    public SortSwitchButton lOB;
    public TextView lOC;
    public View lOD;
    public View lOE;
    public View lOF;
    public TextLineView lOG;
    private View lOH;
    private View lOI;
    private TextView lOJ;
    private List<TextLineView> lOK;
    private int lOL;
    private View.OnClickListener lOM;
    private com.baidu.tieba.pb.data.n lON;
    private BdUniqueId lOO;
    private BdUniqueId lOP;
    private View.OnClickListener lOQ;
    private View.OnClickListener lOR;
    private CustomMessageListener lOS;
    public TextLineView lOz;
    private TbPageContext mPageContext;
    private View mRootView;
    public int mSkinType;

    public au(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.lOL = 0;
        this.Zl = true;
        this.lIU = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.au.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean Az(int i) {
                if (au.this.lEG != null) {
                    return au.this.lEG.Az(i);
                }
                return true;
            }
        };
        this.lOQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.lOM != null) {
                    au.this.lOM.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : au.this.lOK) {
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
        this.lOR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.lOM != null) {
                    au.this.lOM.onClick(view2);
                }
            }
        };
        this.eCA = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.lON != null && au.this.lON.Wv == com.baidu.tieba.pb.data.n.lCc && customResponsedMessage != null && getTag() == au.this.lOO && (customResponsedMessage.getData() instanceof az.a)) {
                    ((az.a) customResponsedMessage.getData()).lRx = au.this;
                }
            }
        };
        this.lOS = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.lON == null || au.this.lON.Wv != com.baidu.tieba.pb.data.n.lCd || customResponsedMessage == null || getTag() != au.this.lOP || !(customResponsedMessage.getData() instanceof az.a)) {
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
            this.lOz = (TextLineView) view.findViewById(R.id.reply_title);
            this.lOz.setOnClickListener(this.lOQ);
            this.lOF = view.findViewById(R.id.reply_god_title_group);
            this.lOG = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.lOG.setSelected(false);
            this.lOI = view.findViewById(R.id.reply_all_title_frame);
            this.lOH = view.findViewById(R.id.reply_all_title);
            this.lOJ = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.lOA = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.lOA.setOnClickListener(this.lOQ);
            this.lOB = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.lOB.setOnSwitchChangeListener(this.lIU);
            this.lOB.setVisibility(0);
            this.lOC = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.lOz.setSelected(true);
            this.lOA.setSelected(false);
            this.lOK = new ArrayList();
            this.lOK.add(this.lOz);
            this.lOK.add(this.lOA);
            this.lOD = view.findViewById(R.id.divider_with_reply_title);
            this.lOE = view.findViewById(R.id.divider_bottom);
            this.lOB.kj(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vk(boolean z) {
        if (z) {
            this.lOA.setSelected(true);
            this.lOz.setSelected(false);
            return;
        }
        this.lOA.setSelected(false);
        this.lOz.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            this.lOB.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.p pVar = new com.baidu.tieba.tbadkCore.data.p();
            pVar.KW(pbSortType.sort_type.intValue());
            pVar.TH(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.lOB.setVisibility(0);
        this.lOB.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.lON = nVar;
        if (nVar != null) {
            if (nVar.Wv == com.baidu.tieba.pb.data.n.lCd) {
                this.lOF.getContext();
                if (TextUtils.isEmpty(nVar.lCf)) {
                    this.lOI.setVisibility(0);
                    this.lOF.setVisibility(8);
                    this.lOz.setVisibility(0);
                    this.lOz.setSelected(false);
                    this.lOz.setClickable(false);
                    this.lOz.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.lOI.setVisibility(8);
                    this.lOz.setVisibility(8);
                    this.lOF.setVisibility(0);
                    this.lOF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (au.this.lOM != null) {
                                au.this.lOM.onClick(au.this.lOF);
                            }
                        }
                    });
                }
                this.lOB.setVisibility(8);
                this.lOA.setVisibility(8);
                this.lOE.setVisibility(8);
            } else if (nVar.Wv == com.baidu.tieba.pb.data.n.lCc) {
                this.lOF.setVisibility(8);
                this.lOI.setVisibility(0);
                this.lOz.setClickable(true);
                this.lOz.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lOA.setVisibility(0);
                vk(nVar.lCh);
                if (nVar.lCi != null) {
                    this.lOB.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.lCi.size()) {
                            i = 0;
                            break;
                        } else if (nVar.lCi.get(i) != null && nVar.sortType == nVar.lCi.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.lCi, i);
                }
                this.lOE.setVisibility(0);
            }
            if (this.Zl) {
                this.lOE.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOI, R.color.CAM_X0207);
            } else {
                this.lOE.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOI, R.color.CAM_X0205);
            }
            if (nVar.isDynamic) {
                this.lOJ.setVisibility(0);
                this.lOH.setVisibility(8);
            } else {
                this.lOJ.setVisibility(8);
                this.lOH.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOI, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOF, R.color.CAM_X0201);
            this.lOz.onChangeSkinType(i);
            this.lOA.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOG, R.color.CAM_X0105);
            if (this.lON != null && this.lON.Wv == com.baidu.tieba.pb.data.n.lCd) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOz, R.color.CAM_X0107, 1);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOC, R.color.CAM_X0107);
            this.lOC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.lOB.onChangeSkinType();
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOD, R.color.CAM_X0204);
            if (this.Zl) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOE, R.color.CAM_X0203);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOI, R.color.CAM_X0207);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lOI, R.color.CAM_X0205);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOJ, R.color.CAM_X0105, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.lOO = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.eCA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eCA);
    }

    public void u(BdUniqueId bdUniqueId) {
        this.lOP = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.lOS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lOS);
    }

    public void U(View.OnClickListener onClickListener) {
        this.lOM = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lEG = aVar;
    }

    public void v(BdUniqueId bdUniqueId) {
        if (this.lOB != null) {
            this.lOB.setListenerTag(bdUniqueId);
            this.lOB.setCommenId(bdUniqueId);
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
            this.lOJ.setText(R.string.hot_recommendation);
            this.lOJ.setTypeface(Typeface.defaultFromStyle(1));
            this.lOJ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.T_X07));
            this.lOJ.setVisibility(0);
            this.lOH.setVisibility(8);
            return;
        }
        this.lOJ.setVisibility(8);
        this.lOH.setVisibility(0);
        this.lOJ.setTypeface(Typeface.defaultFromStyle(0));
        this.lOJ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbfontsize42));
    }
}
