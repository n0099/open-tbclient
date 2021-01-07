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
    public boolean ZU;
    private CustomMessageListener eMe;
    private SortSwitchButton.a lJS;
    private SortSwitchButton.a lOi;
    public TextLineView lTL;
    public TextLineView lTM;
    public SortSwitchButton lTN;
    public TextView lTO;
    public View lTP;
    public View lTQ;
    public View lTR;
    public TextLineView lTS;
    private View lTT;
    private View lTU;
    private TextView lTV;
    private List<TextLineView> lTW;
    private int lTX;
    private View.OnClickListener lTY;
    private com.baidu.tieba.pb.data.n lTZ;
    private BdUniqueId lUa;
    private BdUniqueId lUb;
    private View.OnClickListener lUc;
    private View.OnClickListener lUd;
    private CustomMessageListener lUe;
    private TbPageContext mPageContext;
    private View mRootView;
    public int mSkinType;

    public PbReplyTitleViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.lTX = 0;
        this.ZU = true;
        this.lOi = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean AL(int i) {
                if (PbReplyTitleViewHolder.this.lJS != null) {
                    return PbReplyTitleViewHolder.this.lJS.AL(i);
                }
                return true;
            }
        };
        this.lUc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbReplyTitleViewHolder.this.lTY != null) {
                    PbReplyTitleViewHolder.this.lTY.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : PbReplyTitleViewHolder.this.lTW) {
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
        this.lUd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbReplyTitleViewHolder.this.lTY != null) {
                    PbReplyTitleViewHolder.this.lTY.onClick(view2);
                }
            }
        };
        this.eMe = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PbReplyTitleViewHolder.this.lTZ != null && PbReplyTitleViewHolder.this.lTZ.Ws == com.baidu.tieba.pb.data.n.lHh && customResponsedMessage != null && getTag() == PbReplyTitleViewHolder.this.lUa && (customResponsedMessage.getData() instanceof ap.a)) {
                    ((ap.a) customResponsedMessage.getData()).lWI = PbReplyTitleViewHolder.this;
                }
            }
        };
        this.lUe = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PbReplyTitleViewHolder.this.lTZ == null || PbReplyTitleViewHolder.this.lTZ.Ws != com.baidu.tieba.pb.data.n.lHi || customResponsedMessage == null || getTag() != PbReplyTitleViewHolder.this.lUb || !(customResponsedMessage.getData() instanceof ap.a)) {
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
            this.lTL = (TextLineView) view.findViewById(R.id.reply_title);
            this.lTL.setOnClickListener(this.lUc);
            this.lTR = view.findViewById(R.id.reply_god_title_group);
            this.lTS = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.lTS.setSelected(false);
            this.lTU = view.findViewById(R.id.reply_all_title_frame);
            this.lTT = view.findViewById(R.id.reply_all_title);
            this.lTV = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.lTM = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.lTM.setOnClickListener(this.lUc);
            this.lTN = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.lTN.setOnSwitchChangeListener(this.lOi);
            this.lTN.setVisibility(0);
            this.lTO = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.lTL.setSelected(true);
            this.lTM.setSelected(false);
            this.lTW = new ArrayList();
            this.lTW.add(this.lTL);
            this.lTW.add(this.lTM);
            this.lTP = view.findViewById(R.id.divider_with_reply_title);
            this.lTQ = view.findViewById(R.id.divider_bottom);
            this.lTN.ki(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vl(boolean z) {
        if (z) {
            this.lTM.setSelected(true);
            this.lTL.setSelected(false);
            return;
        }
        this.lTM.setSelected(false);
        this.lTL.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.x.isEmpty(list)) {
            this.lTN.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.q qVar = new com.baidu.tieba.tbadkCore.data.q();
            qVar.KS(pbSortType.sort_type.intValue());
            qVar.Tp(pbSortType.sort_name);
            arrayList.add(qVar);
        }
        this.lTN.setVisibility(0);
        this.lTN.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.lTZ = nVar;
        if (nVar != null) {
            if (nVar.Ws == com.baidu.tieba.pb.data.n.lHi) {
                this.lTR.getContext();
                if (TextUtils.isEmpty(nVar.lHk)) {
                    this.lTU.setVisibility(0);
                    this.lTR.setVisibility(8);
                    this.lTL.setVisibility(0);
                    this.lTL.setSelected(false);
                    this.lTL.setClickable(false);
                    this.lTL.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.lTU.setVisibility(8);
                    this.lTL.setVisibility(8);
                    this.lTR.setVisibility(0);
                    this.lTR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PbReplyTitleViewHolder.this.lTY != null) {
                                PbReplyTitleViewHolder.this.lTY.onClick(PbReplyTitleViewHolder.this.lTR);
                            }
                        }
                    });
                }
                this.lTN.setVisibility(8);
                this.lTM.setVisibility(8);
                this.lTQ.setVisibility(8);
            } else if (nVar.Ws == com.baidu.tieba.pb.data.n.lHh) {
                this.lTR.setVisibility(8);
                this.lTU.setVisibility(0);
                this.lTL.setClickable(true);
                this.lTL.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lTM.setVisibility(0);
                vl(nVar.lHm);
                if (nVar.lHn != null) {
                    this.lTN.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.lHn.size()) {
                            i = 0;
                            break;
                        } else if (nVar.lHn.get(i) != null && nVar.sortType == nVar.lHn.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.lHn, i);
                }
                this.lTQ.setVisibility(0);
            }
            if (this.ZU) {
                this.lTQ.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTU, R.color.CAM_X0207);
            } else {
                this.lTQ.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTU, R.color.CAM_X0205);
            }
            if (nVar.isDynamic) {
                this.lTV.setVisibility(0);
                this.lTT.setVisibility(8);
            } else {
                this.lTV.setVisibility(8);
                this.lTT.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTU, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTR, R.color.CAM_X0201);
            this.lTL.onChangeSkinType(i);
            this.lTM.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTS, R.color.CAM_X0105);
            if (this.lTZ != null && this.lTZ.Ws == com.baidu.tieba.pb.data.n.lHi) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTL, R.color.CAM_X0107, 1);
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTO, R.color.CAM_X0107);
            this.lTO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.lTN.onChangeSkinType();
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTP, R.color.CAM_X0204);
            if (this.ZU) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTQ, R.color.CAM_X0203);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTU, R.color.CAM_X0207);
            } else {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTU, R.color.CAM_X0205);
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTV, R.color.CAM_X0105, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.lUa = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.eMe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eMe);
    }

    public void u(BdUniqueId bdUniqueId) {
        this.lUb = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.lUe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lUe);
    }

    public void W(View.OnClickListener onClickListener) {
        this.lTY = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lJS = aVar;
    }

    public void v(BdUniqueId bdUniqueId) {
        if (this.lTN != null) {
            this.lTN.setListenerTag(bdUniqueId);
            this.lTN.setCommenId(bdUniqueId);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void GP(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void vm(boolean z) {
        if (z) {
            this.lTV.setText(R.string.hot_recommendation);
            this.lTV.setTypeface(Typeface.defaultFromStyle(1));
            this.lTV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.T_X07));
            this.lTV.setVisibility(0);
            this.lTT.setVisibility(8);
            return;
        }
        this.lTV.setVisibility(8);
        this.lTT.setVisibility(0);
        this.lTV.setTypeface(Typeface.defaultFromStyle(0));
        this.lTV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbfontsize42));
    }
}
