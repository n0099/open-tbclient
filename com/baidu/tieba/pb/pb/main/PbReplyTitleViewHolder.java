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
    public boolean ZS;
    private CustomMessageListener eHt;
    private SortSwitchButton.a lFo;
    private SortSwitchButton.a lJE;
    private CustomMessageListener lPA;
    public TextLineView lPh;
    public TextLineView lPi;
    public SortSwitchButton lPj;
    public TextView lPk;
    public View lPl;
    public View lPm;
    public View lPn;
    public TextLineView lPo;
    private View lPp;
    private View lPq;
    private TextView lPr;
    private List<TextLineView> lPs;
    private int lPt;
    private View.OnClickListener lPu;
    private com.baidu.tieba.pb.data.n lPv;
    private BdUniqueId lPw;
    private BdUniqueId lPx;
    private View.OnClickListener lPy;
    private View.OnClickListener lPz;
    private TbPageContext mPageContext;
    private View mRootView;
    public int mSkinType;

    public PbReplyTitleViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.lPt = 0;
        this.ZS = true;
        this.lJE = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean zf(int i) {
                if (PbReplyTitleViewHolder.this.lFo != null) {
                    return PbReplyTitleViewHolder.this.lFo.zf(i);
                }
                return true;
            }
        };
        this.lPy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbReplyTitleViewHolder.this.lPu != null) {
                    PbReplyTitleViewHolder.this.lPu.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : PbReplyTitleViewHolder.this.lPs) {
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
        this.lPz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbReplyTitleViewHolder.this.lPu != null) {
                    PbReplyTitleViewHolder.this.lPu.onClick(view2);
                }
            }
        };
        this.eHt = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PbReplyTitleViewHolder.this.lPv != null && PbReplyTitleViewHolder.this.lPv.Wq == com.baidu.tieba.pb.data.n.lCC && customResponsedMessage != null && getTag() == PbReplyTitleViewHolder.this.lPw && (customResponsedMessage.getData() instanceof ap.a)) {
                    ((ap.a) customResponsedMessage.getData()).lSe = PbReplyTitleViewHolder.this;
                }
            }
        };
        this.lPA = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PbReplyTitleViewHolder.this.lPv == null || PbReplyTitleViewHolder.this.lPv.Wq != com.baidu.tieba.pb.data.n.lCD || customResponsedMessage == null || getTag() != PbReplyTitleViewHolder.this.lPx || !(customResponsedMessage.getData() instanceof ap.a)) {
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
            this.lPh = (TextLineView) view.findViewById(R.id.reply_title);
            this.lPh.setOnClickListener(this.lPy);
            this.lPn = view.findViewById(R.id.reply_god_title_group);
            this.lPo = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.lPo.setSelected(false);
            this.lPq = view.findViewById(R.id.reply_all_title_frame);
            this.lPp = view.findViewById(R.id.reply_all_title);
            this.lPr = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.lPi = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.lPi.setOnClickListener(this.lPy);
            this.lPj = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.lPj.setOnSwitchChangeListener(this.lJE);
            this.lPj.setVisibility(0);
            this.lPk = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.lPh.setSelected(true);
            this.lPi.setSelected(false);
            this.lPs = new ArrayList();
            this.lPs.add(this.lPh);
            this.lPs.add(this.lPi);
            this.lPl = view.findViewById(R.id.divider_with_reply_title);
            this.lPm = view.findViewById(R.id.divider_bottom);
            this.lPj.iC(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vh(boolean z) {
        if (z) {
            this.lPi.setSelected(true);
            this.lPh.setSelected(false);
            return;
        }
        this.lPi.setSelected(false);
        this.lPh.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.x.isEmpty(list)) {
            this.lPj.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.q qVar = new com.baidu.tieba.tbadkCore.data.q();
            qVar.Jl(pbSortType.sort_type.intValue());
            qVar.Si(pbSortType.sort_name);
            arrayList.add(qVar);
        }
        this.lPj.setVisibility(0);
        this.lPj.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.lPv = nVar;
        if (nVar != null) {
            if (nVar.Wq == com.baidu.tieba.pb.data.n.lCD) {
                this.lPn.getContext();
                if (TextUtils.isEmpty(nVar.lCF)) {
                    this.lPq.setVisibility(0);
                    this.lPn.setVisibility(8);
                    this.lPh.setVisibility(0);
                    this.lPh.setSelected(false);
                    this.lPh.setClickable(false);
                    this.lPh.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.lPq.setVisibility(8);
                    this.lPh.setVisibility(8);
                    this.lPn.setVisibility(0);
                    this.lPn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PbReplyTitleViewHolder.this.lPu != null) {
                                PbReplyTitleViewHolder.this.lPu.onClick(PbReplyTitleViewHolder.this.lPn);
                            }
                        }
                    });
                }
                this.lPj.setVisibility(8);
                this.lPi.setVisibility(8);
                this.lPm.setVisibility(8);
            } else if (nVar.Wq == com.baidu.tieba.pb.data.n.lCC) {
                this.lPn.setVisibility(8);
                this.lPq.setVisibility(0);
                this.lPh.setClickable(true);
                this.lPh.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lPi.setVisibility(0);
                vh(nVar.lCH);
                if (nVar.lCI != null) {
                    this.lPj.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.lCI.size()) {
                            i = 0;
                            break;
                        } else if (nVar.lCI.get(i) != null && nVar.sortType == nVar.lCI.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.lCI, i);
                }
                this.lPm.setVisibility(0);
            }
            if (this.ZS) {
                this.lPm.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lPq, R.color.CAM_X0207);
            } else {
                this.lPm.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lPq, R.color.CAM_X0205);
            }
            if (nVar.isDynamic) {
                this.lPr.setVisibility(0);
                this.lPp.setVisibility(8);
            } else {
                this.lPr.setVisibility(8);
                this.lPp.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lPq, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lPn, R.color.CAM_X0201);
            this.lPh.onChangeSkinType(i);
            this.lPi.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPo, R.color.CAM_X0105);
            if (this.lPv != null && this.lPv.Wq == com.baidu.tieba.pb.data.n.lCD) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPh, R.color.CAM_X0107, 1);
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPk, R.color.CAM_X0107);
            this.lPk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.lPj.onChangeSkinType();
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lPl, R.color.CAM_X0204);
            if (this.ZS) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lPm, R.color.CAM_X0203);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lPq, R.color.CAM_X0207);
            } else {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lPq, R.color.CAM_X0205);
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPr, R.color.CAM_X0105, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.lPw = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.eHt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eHt);
    }

    public void u(BdUniqueId bdUniqueId) {
        this.lPx = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.lPA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lPA);
    }

    public void W(View.OnClickListener onClickListener) {
        this.lPu = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lFo = aVar;
    }

    public void v(BdUniqueId bdUniqueId) {
        if (this.lPj != null) {
            this.lPj.setListenerTag(bdUniqueId);
            this.lPj.setCommenId(bdUniqueId);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void Fj(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void vi(boolean z) {
        if (z) {
            this.lPr.setText(R.string.hot_recommendation);
            this.lPr.setTypeface(Typeface.defaultFromStyle(1));
            this.lPr.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.T_X07));
            this.lPr.setVisibility(0);
            this.lPp.setVisibility(8);
            return;
        }
        this.lPr.setVisibility(8);
        this.lPp.setVisibility(0);
        this.lPr.setTypeface(Typeface.defaultFromStyle(0));
        this.lPr.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbfontsize42));
    }
}
