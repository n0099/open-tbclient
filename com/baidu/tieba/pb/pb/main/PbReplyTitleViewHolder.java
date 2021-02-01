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
    private SortSwitchButton.a lOe;
    private SortSwitchButton.a lSB;
    public TextLineView lYd;
    public TextLineView lYe;
    public SortSwitchButton lYf;
    public TextView lYg;
    public View lYh;
    public View lYi;
    public View lYj;
    public TextLineView lYk;
    private View lYl;
    private View lYm;
    private TextView lYn;
    private List<TextLineView> lYo;
    private int lYp;
    private View.OnClickListener lYq;
    private com.baidu.tieba.pb.data.o lYr;
    private BdUniqueId lYs;
    private BdUniqueId lYt;
    private View.OnClickListener lYu;
    private View.OnClickListener lYv;
    private CustomMessageListener lYw;
    private TbPageContext mPageContext;
    private View mRootView;
    public int mSkinType;

    public PbReplyTitleViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.lYp = 0;
        this.ZO = true;
        this.lSB = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean zp(int i) {
                if (PbReplyTitleViewHolder.this.lOe != null) {
                    return PbReplyTitleViewHolder.this.lOe.zp(i);
                }
                return true;
            }
        };
        this.lYu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbReplyTitleViewHolder.this.lYq != null) {
                    PbReplyTitleViewHolder.this.lYq.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : PbReplyTitleViewHolder.this.lYo) {
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
        this.lYv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PbReplyTitleViewHolder.this.lYq != null) {
                    PbReplyTitleViewHolder.this.lYq.onClick(view2);
                }
            }
        };
        this.eJz = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PbReplyTitleViewHolder.this.lYr != null && PbReplyTitleViewHolder.this.lYr.Wm == com.baidu.tieba.pb.data.o.lLq && customResponsedMessage != null && getTag() == PbReplyTitleViewHolder.this.lYs && (customResponsedMessage.getData() instanceof ap.a)) {
                    ((ap.a) customResponsedMessage.getData()).mbd = PbReplyTitleViewHolder.this;
                }
            }
        };
        this.lYw = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (PbReplyTitleViewHolder.this.lYr == null || PbReplyTitleViewHolder.this.lYr.Wm != com.baidu.tieba.pb.data.o.lLr || customResponsedMessage == null || getTag() != PbReplyTitleViewHolder.this.lYt || !(customResponsedMessage.getData() instanceof ap.a)) {
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
            this.lYd = (TextLineView) view.findViewById(R.id.reply_title);
            this.lYd.setOnClickListener(this.lYu);
            this.lYj = view.findViewById(R.id.reply_god_title_group);
            this.lYk = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.lYk.setSelected(false);
            this.lYm = view.findViewById(R.id.reply_all_title_frame);
            this.lYl = view.findViewById(R.id.reply_all_title);
            this.lYn = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.lYe = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.lYe.setOnClickListener(this.lYu);
            this.lYf = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.lYf.setOnSwitchChangeListener(this.lSB);
            this.lYf.setVisibility(0);
            this.lYg = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.lYd.setSelected(true);
            this.lYe.setSelected(false);
            this.lYo = new ArrayList();
            this.lYo.add(this.lYd);
            this.lYo.add(this.lYe);
            this.lYh = view.findViewById(R.id.divider_with_reply_title);
            this.lYi = view.findViewById(R.id.divider_bottom);
            this.lYf.iF(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vw(boolean z) {
        if (z) {
            this.lYe.setSelected(true);
            this.lYd.setSelected(false);
            return;
        }
        this.lYe.setSelected(false);
        this.lYd.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            this.lYf.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.r rVar = new com.baidu.tieba.tbadkCore.data.r();
            rVar.JF(pbSortType.sort_type.intValue());
            rVar.Tf(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.lYf.setVisibility(0);
        this.lYf.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.o oVar) {
        this.lYr = oVar;
        if (oVar != null) {
            if (oVar.Wm == com.baidu.tieba.pb.data.o.lLr) {
                this.lYj.getContext();
                if (TextUtils.isEmpty(oVar.lLt)) {
                    this.lYm.setVisibility(0);
                    this.lYj.setVisibility(8);
                    this.lYd.setVisibility(0);
                    this.lYd.setSelected(false);
                    this.lYd.setClickable(false);
                    this.lYd.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.lYm.setVisibility(8);
                    this.lYd.setVisibility(8);
                    this.lYj.setVisibility(0);
                    this.lYj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PbReplyTitleViewHolder.this.lYq != null) {
                                PbReplyTitleViewHolder.this.lYq.onClick(PbReplyTitleViewHolder.this.lYj);
                            }
                        }
                    });
                }
                this.lYf.setVisibility(8);
                this.lYe.setVisibility(8);
                this.lYi.setVisibility(8);
            } else if (oVar.Wm == com.baidu.tieba.pb.data.o.lLq) {
                this.lYj.setVisibility(8);
                this.lYm.setVisibility(0);
                this.lYd.setClickable(true);
                this.lYd.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lYe.setVisibility(0);
                vw(oVar.lLv);
                if (oVar.lLw != null) {
                    this.lYf.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= oVar.lLw.size()) {
                            i = 0;
                            break;
                        } else if (oVar.lLw.get(i) != null && oVar.sortType == oVar.lLw.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(oVar.lLw, i);
                }
                this.lYi.setVisibility(0);
            }
            if (this.ZO) {
                this.lYi.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYm, R.color.CAM_X0207);
            } else {
                this.lYi.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYm, R.color.CAM_X0205);
            }
            if (oVar.isDynamic) {
                this.lYn.setVisibility(0);
                this.lYl.setVisibility(8);
            } else {
                this.lYn.setVisibility(8);
                this.lYl.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYm, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYj, R.color.CAM_X0201);
            this.lYd.onChangeSkinType(i);
            this.lYe.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYk, R.color.CAM_X0105);
            if (this.lYr != null && this.lYr.Wm == com.baidu.tieba.pb.data.o.lLr) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYd, R.color.CAM_X0107, 1);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYg, R.color.CAM_X0107);
            this.lYg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.lYf.onChangeSkinType();
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYh, R.color.CAM_X0204);
            if (this.ZO) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYi, R.color.CAM_X0203);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYm, R.color.CAM_X0207);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lYm, R.color.CAM_X0205);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYn, R.color.CAM_X0105, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.lYs = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.eJz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eJz);
    }

    public void v(BdUniqueId bdUniqueId) {
        this.lYt = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.lYw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lYw);
    }

    public void W(View.OnClickListener onClickListener) {
        this.lYq = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lOe = aVar;
    }

    public void w(BdUniqueId bdUniqueId) {
        if (this.lYf != null) {
            this.lYf.setListenerTag(bdUniqueId);
            this.lYf.setCommenId(bdUniqueId);
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
            this.lYn.setText(R.string.hot_recommendation);
            this.lYn.setTypeface(Typeface.defaultFromStyle(1));
            this.lYn.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.T_X07));
            this.lYn.setVisibility(0);
            this.lYl.setVisibility(8);
            return;
        }
        this.lYn.setVisibility(8);
        this.lYl.setVisibility(0);
        this.lYn.setTypeface(Typeface.defaultFromStyle(0));
        this.lYn.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbfontsize42));
    }
}
