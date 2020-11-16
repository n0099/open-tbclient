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
    public boolean Yo;
    private CustomMessageListener evz;
    public TextLineView lAK;
    public TextLineView lAL;
    public SortSwitchButton lAM;
    public TextView lAN;
    public View lAO;
    public View lAP;
    public View lAQ;
    public TextLineView lAR;
    private View lAS;
    private View lAT;
    private TextView lAU;
    private List<TextLineView> lAV;
    private int lAW;
    private View.OnClickListener lAX;
    private com.baidu.tieba.pb.data.n lAY;
    private BdUniqueId lAZ;
    private BdUniqueId lBa;
    private View.OnClickListener lBb;
    private View.OnClickListener lBc;
    private CustomMessageListener lBd;
    private SortSwitchButton.a lqV;
    private SortSwitchButton.a lvf;
    private View mRootView;
    public int mSkinType;

    public au(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.lAW = 0;
        this.Yo = true;
        this.lvf = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.au.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean zU(int i) {
                if (au.this.lqV != null) {
                    return au.this.lqV.zU(i);
                }
                return true;
            }
        };
        this.lBb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.lAX != null) {
                    au.this.lAX.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : au.this.lAV) {
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
        this.lBc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.lAX != null) {
                    au.this.lAX.onClick(view2);
                }
            }
        };
        this.evz = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.lAY != null && au.this.lAY.Vx == com.baidu.tieba.pb.data.n.loE && customResponsedMessage != null && getTag() == au.this.lAZ && (customResponsedMessage.getData() instanceof az.a)) {
                    ((az.a) customResponsedMessage.getData()).lDE = au.this;
                }
            }
        };
        this.lBd = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.lAY == null || au.this.lAY.Vx != com.baidu.tieba.pb.data.n.loF || customResponsedMessage == null || getTag() != au.this.lBa || !(customResponsedMessage.getData() instanceof az.a)) {
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
            this.lAK = (TextLineView) view.findViewById(R.id.reply_title);
            this.lAK.setOnClickListener(this.lBb);
            this.lAQ = view.findViewById(R.id.reply_god_title_group);
            this.lAR = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.lAR.setSelected(false);
            this.lAT = view.findViewById(R.id.reply_all_title_frame);
            this.lAS = view.findViewById(R.id.reply_all_title);
            this.lAU = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.lAL = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.lAL.setOnClickListener(this.lBb);
            this.lAM = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.lAM.setOnSwitchChangeListener(this.lvf);
            this.lAM.setVisibility(0);
            this.lAN = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.lAK.setSelected(true);
            this.lAL.setSelected(false);
            this.lAV = new ArrayList();
            this.lAV.add(this.lAK);
            this.lAV.add(this.lAL);
            this.lAO = view.findViewById(R.id.divider_with_reply_title);
            this.lAP = view.findViewById(R.id.divider_bottom);
            this.lAM.jL(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void uI(boolean z) {
        if (z) {
            this.lAL.setSelected(true);
            this.lAK.setSelected(false);
            return;
        }
        this.lAL.setSelected(false);
        this.lAK.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            this.lAM.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.p pVar = new com.baidu.tieba.tbadkCore.data.p();
            pVar.Kg(pbSortType.sort_type.intValue());
            pVar.St(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.lAM.setVisibility(0);
        this.lAM.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.lAY = nVar;
        if (nVar != null) {
            if (nVar.Vx == com.baidu.tieba.pb.data.n.loF) {
                this.lAQ.getContext();
                if (TextUtils.isEmpty(nVar.loH)) {
                    this.lAT.setVisibility(0);
                    this.lAQ.setVisibility(8);
                    this.lAK.setVisibility(0);
                    this.lAK.setSelected(false);
                    this.lAK.setClickable(false);
                    this.lAK.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.lAT.setVisibility(8);
                    this.lAK.setVisibility(8);
                    this.lAQ.setVisibility(0);
                    this.lAQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (au.this.lAX != null) {
                                au.this.lAX.onClick(au.this.lAQ);
                            }
                        }
                    });
                }
                this.lAM.setVisibility(8);
                this.lAL.setVisibility(8);
                this.lAP.setVisibility(8);
            } else if (nVar.Vx == com.baidu.tieba.pb.data.n.loE) {
                this.lAQ.setVisibility(8);
                this.lAT.setVisibility(0);
                this.lAK.setClickable(true);
                this.lAK.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lAL.setVisibility(0);
                uI(nVar.loJ);
                if (nVar.loK != null) {
                    this.lAM.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.loK.size()) {
                            i = 0;
                            break;
                        } else if (nVar.loK.get(i) != null && nVar.sortType == nVar.loK.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.loK, i);
                }
                this.lAP.setVisibility(0);
            }
            if (this.Yo) {
                this.lAP.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAT, R.color.CAM_X0207);
            } else {
                this.lAP.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAT, R.color.CAM_X0205);
            }
            if (nVar.isDynamic) {
                this.lAU.setVisibility(0);
                this.lAS.setVisibility(8);
            } else {
                this.lAU.setVisibility(8);
                this.lAS.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAT, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAQ, R.color.CAM_X0201);
            this.lAK.onChangeSkinType(i);
            this.lAL.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAR, R.color.CAM_X0105);
            if (this.lAY != null && this.lAY.Vx == com.baidu.tieba.pb.data.n.loF) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAK, R.color.CAM_X0107, 1);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAN, R.color.CAM_X0107);
            this.lAN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.lAM.onChangeSkinType();
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAO, R.color.CAM_X0204);
            if (this.Yo) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAP, R.color.CAM_X0203);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAT, R.color.CAM_X0207);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lAT, R.color.CAM_X0205);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAU, R.color.CAM_X0105, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.lAZ = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.evz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.evz);
    }

    public void u(BdUniqueId bdUniqueId) {
        this.lBa = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.lBd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lBd);
    }

    public void U(View.OnClickListener onClickListener) {
        this.lAX = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lqV = aVar;
    }

    public void v(BdUniqueId bdUniqueId) {
        if (this.lAM != null) {
            this.lAM.setListenerTag(bdUniqueId);
            this.lAM.setCommenId(bdUniqueId);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void Gi(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
