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
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes2.dex */
public class PbReplyTitleViewHolder extends TypeAdapter.ViewHolder {
    public boolean abh;
    private CustomMessageListener eLa;
    private SortSwitchButton.a lQv;
    private SortSwitchButton.a lUS;
    private TbPageContext mPageContext;
    private View mRootView;
    public int mSkinType;
    public TextView maA;
    public View maB;
    public View maC;
    public View maD;
    public TextLineView maE;
    private View maF;
    private View maG;
    private TextView maH;
    private List<TextLineView> maI;
    private int maJ;
    private View.OnClickListener maK;
    private com.baidu.tieba.pb.data.o maL;
    private BdUniqueId maM;
    private BdUniqueId maN;
    private View.OnClickListener maO;
    private View.OnClickListener maP;
    private CustomMessageListener maQ;
    public TextLineView maw;
    public TextLineView may;
    public SortSwitchButton maz;

    public PbReplyTitleViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.maJ = 0;
        this.abh = true;
        this.lUS = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean zq(int i) {
                if (PbReplyTitleViewHolder.this.lQv != null) {
                    return PbReplyTitleViewHolder.this.lQv.zq(i);
                }
                return true;
            }
        };
        this.maO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbReplyTitleViewHolder.this.maK != null) {
                    PbReplyTitleViewHolder.this.maK.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : PbReplyTitleViewHolder.this.maI) {
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
        this.maP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbReplyTitleViewHolder.this.maK != null) {
                    PbReplyTitleViewHolder.this.maK.onClick(view2);
                }
            }
        };
        this.eLa = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PbReplyTitleViewHolder.this.maL != null && PbReplyTitleViewHolder.this.maL.XG == com.baidu.tieba.pb.data.o.lNH && customResponsedMessage != null && getTag() == PbReplyTitleViewHolder.this.maM && (customResponsedMessage.getData() instanceof ap.a)) {
                    ((ap.a) customResponsedMessage.getData()).mdu = PbReplyTitleViewHolder.this;
                }
            }
        };
        this.maQ = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PbReplyTitleViewHolder.this.maL == null || PbReplyTitleViewHolder.this.maL.XG != com.baidu.tieba.pb.data.o.lNI || customResponsedMessage == null || getTag() != PbReplyTitleViewHolder.this.maN || !(customResponsedMessage.getData() instanceof ap.a)) {
                }
            }
        };
        if (view != null) {
            this.mRootView = view;
            this.mPageContext = tbPageContext;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.maw = (TextLineView) view.findViewById(R.id.reply_title);
            this.maw.setOnClickListener(this.maO);
            this.maD = view.findViewById(R.id.reply_god_title_group);
            this.maE = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.maE.setSelected(false);
            this.maG = view.findViewById(R.id.reply_all_title_frame);
            this.maF = view.findViewById(R.id.reply_all_title);
            this.maH = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.may = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.may.setOnClickListener(this.maO);
            this.maz = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.maz.setOnSwitchChangeListener(this.lUS);
            this.maz.setVisibility(0);
            this.maA = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.maw.setSelected(true);
            this.may.setSelected(false);
            this.maI = new ArrayList();
            this.maI.add(this.maw);
            this.maI.add(this.may);
            this.maB = view.findViewById(R.id.divider_with_reply_title);
            this.maC = view.findViewById(R.id.divider_bottom);
            this.maz.iG(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vw(boolean z) {
        if (z) {
            this.may.setSelected(true);
            this.maw.setSelected(false);
            return;
        }
        this.may.setSelected(false);
        this.maw.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            this.maz.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.r rVar = new com.baidu.tieba.tbadkCore.data.r();
            rVar.JK(pbSortType.sort_type.intValue());
            rVar.Ty(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.maz.setVisibility(0);
        this.maz.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.o oVar) {
        this.maL = oVar;
        if (oVar != null) {
            if (oVar.XG == com.baidu.tieba.pb.data.o.lNI) {
                this.maD.getContext();
                if (TextUtils.isEmpty(oVar.lNK)) {
                    this.maG.setVisibility(0);
                    this.maD.setVisibility(8);
                    this.maw.setVisibility(0);
                    this.maw.setSelected(false);
                    this.maw.setClickable(false);
                    this.maw.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.maG.setVisibility(8);
                    this.maw.setVisibility(8);
                    this.maD.setVisibility(0);
                    this.maD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PbReplyTitleViewHolder.this.maK != null) {
                                PbReplyTitleViewHolder.this.maK.onClick(PbReplyTitleViewHolder.this.maD);
                            }
                        }
                    });
                }
                this.maz.setVisibility(8);
                this.may.setVisibility(8);
                this.maC.setVisibility(8);
            } else if (oVar.XG == com.baidu.tieba.pb.data.o.lNH) {
                this.maD.setVisibility(8);
                this.maG.setVisibility(0);
                this.maw.setClickable(true);
                this.maw.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.may.setVisibility(0);
                vw(oVar.lNM);
                if (oVar.lNN != null) {
                    this.maz.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= oVar.lNN.size()) {
                            i = 0;
                            break;
                        } else if (oVar.lNN.get(i) != null && oVar.sortType == oVar.lNN.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(oVar.lNN, i);
                }
                this.maC.setVisibility(0);
            }
            if (this.abh) {
                this.maC.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.maG, R.color.CAM_X0207);
            } else {
                this.maC.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.maG, R.color.CAM_X0205);
            }
            if (oVar.isDynamic) {
                this.maH.setVisibility(0);
                this.maF.setVisibility(8);
            } else {
                this.maH.setVisibility(8);
                this.maF.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.maG, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.maD, R.color.CAM_X0201);
            this.maw.onChangeSkinType(i);
            this.may.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.maE, R.color.CAM_X0105);
            if (this.maL != null && this.maL.XG == com.baidu.tieba.pb.data.o.lNI) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.maw, R.color.CAM_X0107, 1);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.maA, R.color.CAM_X0107);
            this.maA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.maz.onChangeSkinType();
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.maB, R.color.CAM_X0204);
            if (this.abh) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.maC, R.color.CAM_X0203);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.maG, R.color.CAM_X0207);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.maG, R.color.CAM_X0205);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.maH, R.color.CAM_X0105, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.maM = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.eLa.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eLa);
    }

    public void w(BdUniqueId bdUniqueId) {
        this.maN = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.maQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.maQ);
    }

    public void X(View.OnClickListener onClickListener) {
        this.maK = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lQv = aVar;
    }

    public void x(BdUniqueId bdUniqueId) {
        if (this.maz != null) {
            this.maz.setListenerTag(bdUniqueId);
            this.maz.setCommenId(bdUniqueId);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void FF(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void vx(boolean z) {
        if (z) {
            this.maH.setText(R.string.hot_recommendation);
            this.maH.setTypeface(Typeface.defaultFromStyle(1));
            this.maH.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.T_X07));
            this.maH.setVisibility(0);
            this.maF.setVisibility(8);
            return;
        }
        this.maH.setVisibility(8);
        this.maF.setVisibility(0);
        this.maH.setTypeface(Typeface.defaultFromStyle(0));
        this.maH.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbfontsize42));
    }
}
