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
    private SortSwitchButton.a lJT;
    private SortSwitchButton.a lOj;
    public TextLineView lTM;
    public TextLineView lTN;
    public SortSwitchButton lTO;
    public TextView lTP;
    public View lTQ;
    public View lTR;
    public View lTS;
    public TextLineView lTT;
    private View lTU;
    private View lTV;
    private TextView lTW;
    private List<TextLineView> lTX;
    private int lTY;
    private View.OnClickListener lTZ;
    private com.baidu.tieba.pb.data.n lUa;
    private BdUniqueId lUb;
    private BdUniqueId lUc;
    private View.OnClickListener lUd;
    private View.OnClickListener lUe;
    private CustomMessageListener lUf;
    private TbPageContext mPageContext;
    private View mRootView;
    public int mSkinType;

    public PbReplyTitleViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.lTY = 0;
        this.ZU = true;
        this.lOj = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean AL(int i) {
                if (PbReplyTitleViewHolder.this.lJT != null) {
                    return PbReplyTitleViewHolder.this.lJT.AL(i);
                }
                return true;
            }
        };
        this.lUd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbReplyTitleViewHolder.this.lTZ != null) {
                    PbReplyTitleViewHolder.this.lTZ.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : PbReplyTitleViewHolder.this.lTX) {
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
        this.lUe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbReplyTitleViewHolder.this.lTZ != null) {
                    PbReplyTitleViewHolder.this.lTZ.onClick(view2);
                }
            }
        };
        this.eMe = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PbReplyTitleViewHolder.this.lUa != null && PbReplyTitleViewHolder.this.lUa.Ws == com.baidu.tieba.pb.data.n.lHi && customResponsedMessage != null && getTag() == PbReplyTitleViewHolder.this.lUb && (customResponsedMessage.getData() instanceof ap.a)) {
                    ((ap.a) customResponsedMessage.getData()).lWJ = PbReplyTitleViewHolder.this;
                }
            }
        };
        this.lUf = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PbReplyTitleViewHolder.this.lUa == null || PbReplyTitleViewHolder.this.lUa.Ws != com.baidu.tieba.pb.data.n.lHj || customResponsedMessage == null || getTag() != PbReplyTitleViewHolder.this.lUc || !(customResponsedMessage.getData() instanceof ap.a)) {
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
            this.lTM = (TextLineView) view.findViewById(R.id.reply_title);
            this.lTM.setOnClickListener(this.lUd);
            this.lTS = view.findViewById(R.id.reply_god_title_group);
            this.lTT = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.lTT.setSelected(false);
            this.lTV = view.findViewById(R.id.reply_all_title_frame);
            this.lTU = view.findViewById(R.id.reply_all_title);
            this.lTW = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.lTN = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.lTN.setOnClickListener(this.lUd);
            this.lTO = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.lTO.setOnSwitchChangeListener(this.lOj);
            this.lTO.setVisibility(0);
            this.lTP = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.lTM.setSelected(true);
            this.lTN.setSelected(false);
            this.lTX = new ArrayList();
            this.lTX.add(this.lTM);
            this.lTX.add(this.lTN);
            this.lTQ = view.findViewById(R.id.divider_with_reply_title);
            this.lTR = view.findViewById(R.id.divider_bottom);
            this.lTO.ki(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vl(boolean z) {
        if (z) {
            this.lTN.setSelected(true);
            this.lTM.setSelected(false);
            return;
        }
        this.lTN.setSelected(false);
        this.lTM.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.x.isEmpty(list)) {
            this.lTO.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.q qVar = new com.baidu.tieba.tbadkCore.data.q();
            qVar.KS(pbSortType.sort_type.intValue());
            qVar.Tq(pbSortType.sort_name);
            arrayList.add(qVar);
        }
        this.lTO.setVisibility(0);
        this.lTO.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.lUa = nVar;
        if (nVar != null) {
            if (nVar.Ws == com.baidu.tieba.pb.data.n.lHj) {
                this.lTS.getContext();
                if (TextUtils.isEmpty(nVar.lHl)) {
                    this.lTV.setVisibility(0);
                    this.lTS.setVisibility(8);
                    this.lTM.setVisibility(0);
                    this.lTM.setSelected(false);
                    this.lTM.setClickable(false);
                    this.lTM.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.lTV.setVisibility(8);
                    this.lTM.setVisibility(8);
                    this.lTS.setVisibility(0);
                    this.lTS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PbReplyTitleViewHolder.this.lTZ != null) {
                                PbReplyTitleViewHolder.this.lTZ.onClick(PbReplyTitleViewHolder.this.lTS);
                            }
                        }
                    });
                }
                this.lTO.setVisibility(8);
                this.lTN.setVisibility(8);
                this.lTR.setVisibility(8);
            } else if (nVar.Ws == com.baidu.tieba.pb.data.n.lHi) {
                this.lTS.setVisibility(8);
                this.lTV.setVisibility(0);
                this.lTM.setClickable(true);
                this.lTM.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lTN.setVisibility(0);
                vl(nVar.lHn);
                if (nVar.lHo != null) {
                    this.lTO.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.lHo.size()) {
                            i = 0;
                            break;
                        } else if (nVar.lHo.get(i) != null && nVar.sortType == nVar.lHo.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.lHo, i);
                }
                this.lTR.setVisibility(0);
            }
            if (this.ZU) {
                this.lTR.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTV, R.color.CAM_X0207);
            } else {
                this.lTR.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTV, R.color.CAM_X0205);
            }
            if (nVar.isDynamic) {
                this.lTW.setVisibility(0);
                this.lTU.setVisibility(8);
            } else {
                this.lTW.setVisibility(8);
                this.lTU.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTV, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTS, R.color.CAM_X0201);
            this.lTM.onChangeSkinType(i);
            this.lTN.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTT, R.color.CAM_X0105);
            if (this.lUa != null && this.lUa.Ws == com.baidu.tieba.pb.data.n.lHj) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTM, R.color.CAM_X0107, 1);
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTP, R.color.CAM_X0107);
            this.lTP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.lTO.onChangeSkinType();
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTQ, R.color.CAM_X0204);
            if (this.ZU) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTR, R.color.CAM_X0203);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTV, R.color.CAM_X0207);
            } else {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lTV, R.color.CAM_X0205);
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTW, R.color.CAM_X0105, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.lUb = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.eMe.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eMe);
    }

    public void u(BdUniqueId bdUniqueId) {
        this.lUc = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.lUf.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lUf);
    }

    public void W(View.OnClickListener onClickListener) {
        this.lTZ = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lJT = aVar;
    }

    public void v(BdUniqueId bdUniqueId) {
        if (this.lTO != null) {
            this.lTO.setListenerTag(bdUniqueId);
            this.lTO.setCommenId(bdUniqueId);
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
            this.lTW.setText(R.string.hot_recommendation);
            this.lTW.setTypeface(Typeface.defaultFromStyle(1));
            this.lTW.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.T_X07));
            this.lTW.setVisibility(0);
            this.lTU.setVisibility(8);
            return;
        }
        this.lTW.setVisibility(8);
        this.lTU.setVisibility(0);
        this.lTW.setTypeface(Typeface.defaultFromStyle(0));
        this.lTW.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbfontsize42));
    }
}
