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
/* loaded from: classes16.dex */
public class au extends af.a {
    public boolean Xz;
    private CustomMessageListener dUF;
    private SortSwitchButton.a kAy;
    private SortSwitchButton.a kEE;
    public TextLineView kKf;
    public TextLineView kKg;
    public SortSwitchButton kKh;
    public TextView kKi;
    public View kKj;
    public View kKk;
    public View kKl;
    public TextLineView kKm;
    private View kKn;
    private View kKo;
    private TextView kKp;
    private List<TextLineView> kKq;
    private int kKr;
    private View.OnClickListener kKs;
    private com.baidu.tieba.pb.data.n kKt;
    private BdUniqueId kKu;
    private BdUniqueId kKv;
    private View.OnClickListener kKw;
    private View.OnClickListener kKx;
    private CustomMessageListener kKy;
    private View mRootView;
    public int mSkinType;

    public au(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.kKr = 0;
        this.Xz = true;
        this.kEE = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.au.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean xL(int i) {
                if (au.this.kAy != null) {
                    return au.this.kAy.xL(i);
                }
                return true;
            }
        };
        this.kKw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.kKs != null) {
                    au.this.kKs.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : au.this.kKq) {
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
        this.kKx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.kKs != null) {
                    au.this.kKs.onClick(view2);
                }
            }
        };
        this.dUF = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.kKt != null && au.this.kKt.UM == com.baidu.tieba.pb.data.n.kyf && customResponsedMessage != null && getTag() == au.this.kKu && (customResponsedMessage.getData() instanceof az.a)) {
                    ((az.a) customResponsedMessage.getData()).kMZ = au.this;
                }
            }
        };
        this.kKy = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.kKt == null || au.this.kKt.UM != com.baidu.tieba.pb.data.n.kyg || customResponsedMessage == null || getTag() != au.this.kKv || !(customResponsedMessage.getData() instanceof az.a)) {
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
            this.kKf = (TextLineView) view.findViewById(R.id.reply_title);
            this.kKf.setOnClickListener(this.kKw);
            this.kKl = view.findViewById(R.id.reply_god_title_group);
            this.kKm = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.kKm.setSelected(false);
            this.kKo = view.findViewById(R.id.reply_all_title_frame);
            this.kKn = view.findViewById(R.id.reply_all_title);
            this.kKp = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.kKg = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.kKg.setOnClickListener(this.kKw);
            this.kKh = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.kKh.setOnSwitchChangeListener(this.kEE);
            this.kKh.setVisibility(0);
            this.kKi = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.kKf.setSelected(true);
            this.kKg.setSelected(false);
            this.kKq = new ArrayList();
            this.kKq.add(this.kKf);
            this.kKq.add(this.kKg);
            this.kKj = view.findViewById(R.id.divider_with_reply_title);
            this.kKk = view.findViewById(R.id.divider_bottom);
            this.kKh.changeState(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void tr(boolean z) {
        if (z) {
            this.kKg.setSelected(true);
            this.kKf.setSelected(false);
            return;
        }
        this.kKg.setSelected(false);
        this.kKf.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            this.kKh.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.p pVar = new com.baidu.tieba.tbadkCore.data.p();
            pVar.HQ(pbSortType.sort_type.intValue());
            pVar.QO(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.kKh.setVisibility(0);
        this.kKh.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.kKt = nVar;
        if (nVar != null) {
            if (nVar.UM == com.baidu.tieba.pb.data.n.kyg) {
                this.kKl.getContext();
                if (TextUtils.isEmpty(nVar.kyi)) {
                    this.kKo.setVisibility(0);
                    this.kKl.setVisibility(8);
                    this.kKf.setVisibility(0);
                    this.kKf.setSelected(false);
                    this.kKf.setClickable(false);
                    this.kKf.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.kKo.setVisibility(8);
                    this.kKf.setVisibility(8);
                    this.kKl.setVisibility(0);
                    this.kKl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (au.this.kKs != null) {
                                au.this.kKs.onClick(au.this.kKl);
                            }
                        }
                    });
                }
                this.kKh.setVisibility(8);
                this.kKg.setVisibility(8);
                this.kKk.setVisibility(8);
            } else if (nVar.UM == com.baidu.tieba.pb.data.n.kyf) {
                this.kKl.setVisibility(8);
                this.kKo.setVisibility(0);
                this.kKf.setClickable(true);
                this.kKf.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.kKg.setVisibility(0);
                tr(nVar.kyk);
                if (nVar.kyl != null) {
                    this.kKh.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.kyl.size()) {
                            i = 0;
                            break;
                        } else if (nVar.kyl.get(i) != null && nVar.sortType == nVar.kyl.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.kyl, i);
                }
                this.kKk.setVisibility(0);
            }
            if (this.Xz) {
                this.kKk.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKo, R.color.cp_bg_line_h);
            } else {
                this.kKk.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKo, R.color.cp_bg_line_e);
            }
            if (nVar.isDynamic) {
                this.kKp.setVisibility(0);
                this.kKn.setVisibility(8);
            } else {
                this.kKp.setVisibility(8);
                this.kKn.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKo, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKl, R.color.cp_bg_line_d);
            this.kKf.onChangeSkinType(i);
            this.kKg.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kKm, R.color.cp_cont_b);
            if (this.kKt != null && this.kKt.UM == com.baidu.tieba.pb.data.n.kyg) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kKf, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kKi, R.color.cp_cont_j);
            this.kKi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.kKh.onChangeSkinType();
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKj, R.color.cp_bg_line_c);
            if (this.Xz) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kKk, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKo, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKo, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kKp, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void m(BdUniqueId bdUniqueId) {
        this.kKu = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.dUF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dUF);
    }

    public void v(BdUniqueId bdUniqueId) {
        this.kKv = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.kKy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kKy);
    }

    public void U(View.OnClickListener onClickListener) {
        this.kKs = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kAy = aVar;
    }

    public void w(BdUniqueId bdUniqueId) {
        if (this.kKh != null) {
            this.kKh.setListenerTag(bdUniqueId);
            this.kKh.setCommenId(bdUniqueId);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void DX(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
