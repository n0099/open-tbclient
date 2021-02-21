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
    public boolean ZO;
    private CustomMessageListener eJz;
    private SortSwitchButton.a lOt;
    private SortSwitchButton.a lSQ;
    private View lYA;
    private View lYB;
    private TextView lYC;
    private List<TextLineView> lYD;
    private int lYE;
    private View.OnClickListener lYF;
    private com.baidu.tieba.pb.data.o lYG;
    private BdUniqueId lYH;
    private BdUniqueId lYI;
    private View.OnClickListener lYJ;
    private View.OnClickListener lYK;
    private CustomMessageListener lYL;
    public TextLineView lYs;
    public TextLineView lYt;
    public SortSwitchButton lYu;
    public TextView lYv;
    public View lYw;
    public View lYx;
    public View lYy;
    public TextLineView lYz;
    private TbPageContext mPageContext;
    private View mRootView;
    public int mSkinType;

    public PbReplyTitleViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.lYE = 0;
        this.ZO = true;
        this.lSQ = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean zp(int i) {
                if (PbReplyTitleViewHolder.this.lOt != null) {
                    return PbReplyTitleViewHolder.this.lOt.zp(i);
                }
                return true;
            }
        };
        this.lYJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbReplyTitleViewHolder.this.lYF != null) {
                    PbReplyTitleViewHolder.this.lYF.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : PbReplyTitleViewHolder.this.lYD) {
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
        this.lYK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbReplyTitleViewHolder.this.lYF != null) {
                    PbReplyTitleViewHolder.this.lYF.onClick(view2);
                }
            }
        };
        this.eJz = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PbReplyTitleViewHolder.this.lYG != null && PbReplyTitleViewHolder.this.lYG.Wm == com.baidu.tieba.pb.data.o.lLF && customResponsedMessage != null && getTag() == PbReplyTitleViewHolder.this.lYH && (customResponsedMessage.getData() instanceof ap.a)) {
                    ((ap.a) customResponsedMessage.getData()).mbs = PbReplyTitleViewHolder.this;
                }
            }
        };
        this.lYL = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PbReplyTitleViewHolder.this.lYG == null || PbReplyTitleViewHolder.this.lYG.Wm != com.baidu.tieba.pb.data.o.lLG || customResponsedMessage == null || getTag() != PbReplyTitleViewHolder.this.lYI || !(customResponsedMessage.getData() instanceof ap.a)) {
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
            this.lYs = (TextLineView) view.findViewById(R.id.reply_title);
            this.lYs.setOnClickListener(this.lYJ);
            this.lYy = view.findViewById(R.id.reply_god_title_group);
            this.lYz = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.lYz.setSelected(false);
            this.lYB = view.findViewById(R.id.reply_all_title_frame);
            this.lYA = view.findViewById(R.id.reply_all_title);
            this.lYC = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.lYt = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.lYt.setOnClickListener(this.lYJ);
            this.lYu = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.lYu.setOnSwitchChangeListener(this.lSQ);
            this.lYu.setVisibility(0);
            this.lYv = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.lYs.setSelected(true);
            this.lYt.setSelected(false);
            this.lYD = new ArrayList();
            this.lYD.add(this.lYs);
            this.lYD.add(this.lYt);
            this.lYw = view.findViewById(R.id.divider_with_reply_title);
            this.lYx = view.findViewById(R.id.divider_bottom);
            this.lYu.iF(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vw(boolean z) {
        if (z) {
            this.lYt.setSelected(true);
            this.lYs.setSelected(false);
            return;
        }
        this.lYt.setSelected(false);
        this.lYs.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            this.lYu.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.r rVar = new com.baidu.tieba.tbadkCore.data.r();
            rVar.JF(pbSortType.sort_type.intValue());
            rVar.Tr(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.lYu.setVisibility(0);
        this.lYu.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.o oVar) {
        this.lYG = oVar;
        if (oVar != null) {
            if (oVar.Wm == com.baidu.tieba.pb.data.o.lLG) {
                this.lYy.getContext();
                if (TextUtils.isEmpty(oVar.lLI)) {
                    this.lYB.setVisibility(0);
                    this.lYy.setVisibility(8);
                    this.lYs.setVisibility(0);
                    this.lYs.setSelected(false);
                    this.lYs.setClickable(false);
                    this.lYs.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.lYB.setVisibility(8);
                    this.lYs.setVisibility(8);
                    this.lYy.setVisibility(0);
                    this.lYy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PbReplyTitleViewHolder.this.lYF != null) {
                                PbReplyTitleViewHolder.this.lYF.onClick(PbReplyTitleViewHolder.this.lYy);
                            }
                        }
                    });
                }
                this.lYu.setVisibility(8);
                this.lYt.setVisibility(8);
                this.lYx.setVisibility(8);
            } else if (oVar.Wm == com.baidu.tieba.pb.data.o.lLF) {
                this.lYy.setVisibility(8);
                this.lYB.setVisibility(0);
                this.lYs.setClickable(true);
                this.lYs.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lYt.setVisibility(0);
                vw(oVar.lLK);
                if (oVar.lLL != null) {
                    this.lYu.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= oVar.lLL.size()) {
                            i = 0;
                            break;
                        } else if (oVar.lLL.get(i) != null && oVar.sortType == oVar.lLL.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(oVar.lLL, i);
                }
                this.lYx.setVisibility(0);
            }
            if (this.ZO) {
                this.lYx.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYB, R.color.CAM_X0207);
            } else {
                this.lYx.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYB, R.color.CAM_X0205);
            }
            if (oVar.isDynamic) {
                this.lYC.setVisibility(0);
                this.lYA.setVisibility(8);
            } else {
                this.lYC.setVisibility(8);
                this.lYA.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYB, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYy, R.color.CAM_X0201);
            this.lYs.onChangeSkinType(i);
            this.lYt.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYz, R.color.CAM_X0105);
            if (this.lYG != null && this.lYG.Wm == com.baidu.tieba.pb.data.o.lLG) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYs, R.color.CAM_X0107, 1);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYv, R.color.CAM_X0107);
            this.lYv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.lYu.onChangeSkinType();
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYw, R.color.CAM_X0204);
            if (this.ZO) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYx, R.color.CAM_X0203);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYB, R.color.CAM_X0207);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYB, R.color.CAM_X0205);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYC, R.color.CAM_X0105, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.lYH = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.eJz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eJz);
    }

    public void v(BdUniqueId bdUniqueId) {
        this.lYI = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.lYL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lYL);
    }

    public void W(View.OnClickListener onClickListener) {
        this.lYF = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lOt = aVar;
    }

    public void w(BdUniqueId bdUniqueId) {
        if (this.lYu != null) {
            this.lYu.setListenerTag(bdUniqueId);
            this.lYu.setCommenId(bdUniqueId);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void FC(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }

    public void vx(boolean z) {
        if (z) {
            this.lYC.setText(R.string.hot_recommendation);
            this.lYC.setTypeface(Typeface.defaultFromStyle(1));
            this.lYC.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.T_X07));
            this.lYC.setVisibility(0);
            this.lYA.setVisibility(8);
            return;
        }
        this.lYC.setVisibility(8);
        this.lYA.setVisibility(0);
        this.lYC.setTypeface(Typeface.defaultFromStyle(0));
        this.lYC.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbfontsize42));
    }
}
