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
/* loaded from: classes22.dex */
public class au extends af.a {
    public boolean Yi;
    private CustomMessageListener eiR;
    private SortSwitchButton.a kYg;
    private SortSwitchButton.a lcp;
    public TextLineView lhS;
    public TextLineView lhT;
    public SortSwitchButton lhU;
    public TextView lhV;
    public View lhW;
    public View lhX;
    public View lhY;
    public TextLineView lhZ;
    private View lia;
    private View lib;
    private TextView lic;
    private List<TextLineView> lid;
    private int lie;
    private View.OnClickListener lif;
    private com.baidu.tieba.pb.data.n lig;
    private BdUniqueId lih;
    private BdUniqueId lii;
    private View.OnClickListener lij;
    private View.OnClickListener lik;
    private CustomMessageListener lil;
    private View mRootView;
    public int mSkinType;

    public au(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.lie = 0;
        this.Yi = true;
        this.lcp = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.au.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean yQ(int i) {
                if (au.this.kYg != null) {
                    return au.this.kYg.yQ(i);
                }
                return true;
            }
        };
        this.lij = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.lif != null) {
                    au.this.lif.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : au.this.lid) {
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
        this.lik = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.lif != null) {
                    au.this.lif.onClick(view2);
                }
            }
        };
        this.eiR = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.lig != null && au.this.lig.Vv == com.baidu.tieba.pb.data.n.kVN && customResponsedMessage != null && getTag() == au.this.lih && (customResponsedMessage.getData() instanceof az.a)) {
                    ((az.a) customResponsedMessage.getData()).lkM = au.this;
                }
            }
        };
        this.lil = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.lig == null || au.this.lig.Vv != com.baidu.tieba.pb.data.n.kVO || customResponsedMessage == null || getTag() != au.this.lii || !(customResponsedMessage.getData() instanceof az.a)) {
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
            this.lhS = (TextLineView) view.findViewById(R.id.reply_title);
            this.lhS.setOnClickListener(this.lij);
            this.lhY = view.findViewById(R.id.reply_god_title_group);
            this.lhZ = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.lhZ.setSelected(false);
            this.lib = view.findViewById(R.id.reply_all_title_frame);
            this.lia = view.findViewById(R.id.reply_all_title);
            this.lic = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.lhT = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.lhT.setOnClickListener(this.lij);
            this.lhU = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.lhU.setOnSwitchChangeListener(this.lcp);
            this.lhU.setVisibility(0);
            this.lhV = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.lhS.setSelected(true);
            this.lhT.setSelected(false);
            this.lid = new ArrayList();
            this.lid.add(this.lhS);
            this.lid.add(this.lhT);
            this.lhW = view.findViewById(R.id.divider_with_reply_title);
            this.lhX = view.findViewById(R.id.divider_bottom);
            this.lhU.ju(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void uf(boolean z) {
        if (z) {
            this.lhT.setSelected(true);
            this.lhS.setSelected(false);
            return;
        }
        this.lhT.setSelected(false);
        this.lhS.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            this.lhU.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.p pVar = new com.baidu.tieba.tbadkCore.data.p();
            pVar.IZ(pbSortType.sort_type.intValue());
            pVar.Sc(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.lhU.setVisibility(0);
        this.lhU.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.lig = nVar;
        if (nVar != null) {
            if (nVar.Vv == com.baidu.tieba.pb.data.n.kVO) {
                this.lhY.getContext();
                if (TextUtils.isEmpty(nVar.kVQ)) {
                    this.lib.setVisibility(0);
                    this.lhY.setVisibility(8);
                    this.lhS.setVisibility(0);
                    this.lhS.setSelected(false);
                    this.lhS.setClickable(false);
                    this.lhS.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.lib.setVisibility(8);
                    this.lhS.setVisibility(8);
                    this.lhY.setVisibility(0);
                    this.lhY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (au.this.lif != null) {
                                au.this.lif.onClick(au.this.lhY);
                            }
                        }
                    });
                }
                this.lhU.setVisibility(8);
                this.lhT.setVisibility(8);
                this.lhX.setVisibility(8);
            } else if (nVar.Vv == com.baidu.tieba.pb.data.n.kVN) {
                this.lhY.setVisibility(8);
                this.lib.setVisibility(0);
                this.lhS.setClickable(true);
                this.lhS.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lhT.setVisibility(0);
                uf(nVar.kVS);
                if (nVar.kVT != null) {
                    this.lhU.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.kVT.size()) {
                            i = 0;
                            break;
                        } else if (nVar.kVT.get(i) != null && nVar.sortType == nVar.kVT.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.kVT, i);
                }
                this.lhX.setVisibility(0);
            }
            if (this.Yi) {
                this.lhX.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lib, R.color.cp_bg_line_h);
            } else {
                this.lhX.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lib, R.color.cp_bg_line_e);
            }
            if (nVar.isDynamic) {
                this.lic.setVisibility(0);
                this.lia.setVisibility(8);
            } else {
                this.lic.setVisibility(8);
                this.lia.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lib, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lhY, R.color.cp_bg_line_d);
            this.lhS.onChangeSkinType(i);
            this.lhT.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lhZ, R.color.cp_cont_b);
            if (this.lig != null && this.lig.Vv == com.baidu.tieba.pb.data.n.kVO) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lhS, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lhV, R.color.cp_cont_j);
            this.lhV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.lhU.onChangeSkinType();
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lhW, R.color.cp_bg_line_c);
            if (this.Yi) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lhX, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lib, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lib, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lic, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void l(BdUniqueId bdUniqueId) {
        this.lih = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.eiR.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eiR);
    }

    public void u(BdUniqueId bdUniqueId) {
        this.lii = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.lil.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lil);
    }

    public void U(View.OnClickListener onClickListener) {
        this.lif = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kYg = aVar;
    }

    public void v(BdUniqueId bdUniqueId) {
        if (this.lhU != null) {
            this.lhU.setListenerTag(bdUniqueId);
            this.lhU.setCommenId(bdUniqueId);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void Fe(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
