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
    public boolean Xx;
    private CustomMessageListener dUB;
    private SortSwitchButton.a kAr;
    private SortSwitchButton.a kEx;
    public TextLineView kJY;
    public TextLineView kJZ;
    public SortSwitchButton kKa;
    public TextView kKb;
    public View kKc;
    public View kKd;
    public View kKe;
    public TextLineView kKf;
    private View kKg;
    private View kKh;
    private TextView kKi;
    private List<TextLineView> kKj;
    private int kKk;
    private View.OnClickListener kKl;
    private com.baidu.tieba.pb.data.n kKm;
    private BdUniqueId kKn;
    private BdUniqueId kKo;
    private View.OnClickListener kKp;
    private View.OnClickListener kKq;
    private CustomMessageListener kKr;
    private View mRootView;
    public int mSkinType;

    public au(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.kKk = 0;
        this.Xx = true;
        this.kEx = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.au.1
            @Override // com.baidu.tieba.view.SortSwitchButton.a
            public boolean xL(int i) {
                if (au.this.kAr != null) {
                    return au.this.kAr.xL(i);
                }
                return true;
            }
        };
        this.kKp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.kKl != null) {
                    au.this.kKl.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : au.this.kKj) {
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
        this.kKq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (au.this.kKl != null) {
                    au.this.kKl.onClick(view2);
                }
            }
        };
        this.dUB = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.kKm != null && au.this.kKm.UM == com.baidu.tieba.pb.data.n.kxY && customResponsedMessage != null && getTag() == au.this.kKn && (customResponsedMessage.getData() instanceof az.a)) {
                    ((az.a) customResponsedMessage.getData()).kMS = au.this;
                }
            }
        };
        this.kKr = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.au.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (au.this.kKm == null || au.this.kKm.UM != com.baidu.tieba.pb.data.n.kxZ || customResponsedMessage == null || getTag() != au.this.kKo || !(customResponsedMessage.getData() instanceof az.a)) {
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
            this.kJY = (TextLineView) view.findViewById(R.id.reply_title);
            this.kJY.setOnClickListener(this.kKp);
            this.kKe = view.findViewById(R.id.reply_god_title_group);
            this.kKf = (TextLineView) view.findViewById(R.id.reply_god_title);
            this.kKf.setSelected(false);
            this.kKh = view.findViewById(R.id.reply_all_title_frame);
            this.kKg = view.findViewById(R.id.reply_all_title);
            this.kKi = (TextView) view.findViewById(R.id.reply_title_dynamic);
            this.kJZ = (TextLineView) view.findViewById(R.id.floor_owner_reply);
            this.kJZ.setOnClickListener(this.kKp);
            this.kKa = (SortSwitchButton) view.findViewById(R.id.pb_sort_switch_btn);
            this.kKa.setOnSwitchChangeListener(this.kEx);
            this.kKa.setVisibility(0);
            this.kKb = (TextView) view.findViewById(R.id.pb_god_reply_entrance_text);
            this.kJY.setSelected(true);
            this.kJZ.setSelected(false);
            this.kKj = new ArrayList();
            this.kKj.add(this.kJY);
            this.kKj.add(this.kJZ);
            this.kKc = view.findViewById(R.id.divider_with_reply_title);
            this.kKd = view.findViewById(R.id.divider_bottom);
            this.kKa.changeState(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void tp(boolean z) {
        if (z) {
            this.kJZ.setSelected(true);
            this.kJY.setSelected(false);
            return;
        }
        this.kJZ.setSelected(false);
        this.kJY.setSelected(true);
    }

    public void p(List<PbSortType> list, int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            this.kKa.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            com.baidu.tieba.tbadkCore.data.p pVar = new com.baidu.tieba.tbadkCore.data.p();
            pVar.HQ(pbSortType.sort_type.intValue());
            pVar.QO(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.kKa.setVisibility(0);
        this.kKa.setData(arrayList, i);
    }

    public void a(com.baidu.tieba.pb.data.n nVar) {
        this.kKm = nVar;
        if (nVar != null) {
            if (nVar.UM == com.baidu.tieba.pb.data.n.kxZ) {
                this.kKe.getContext();
                if (TextUtils.isEmpty(nVar.kyb)) {
                    this.kKh.setVisibility(0);
                    this.kKe.setVisibility(8);
                    this.kJY.setVisibility(0);
                    this.kJY.setSelected(false);
                    this.kJY.setClickable(false);
                    this.kJY.setText(TbadkCoreApplication.getInst().getString(R.string.god_reply));
                } else {
                    this.kKh.setVisibility(8);
                    this.kJY.setVisibility(8);
                    this.kKe.setVisibility(0);
                    this.kKe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.au.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (au.this.kKl != null) {
                                au.this.kKl.onClick(au.this.kKe);
                            }
                        }
                    });
                }
                this.kKa.setVisibility(8);
                this.kJZ.setVisibility(8);
                this.kKd.setVisibility(8);
            } else if (nVar.UM == com.baidu.tieba.pb.data.n.kxY) {
                this.kKe.setVisibility(8);
                this.kKh.setVisibility(0);
                this.kJY.setClickable(true);
                this.kJY.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.kJZ.setVisibility(0);
                tp(nVar.kyd);
                if (nVar.kye != null) {
                    this.kKa.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.kye.size()) {
                            i = 0;
                            break;
                        } else if (nVar.kye.get(i) != null && nVar.sortType == nVar.kye.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.kye, i);
                }
                this.kKd.setVisibility(0);
            }
            if (this.Xx) {
                this.kKd.getLayoutParams().height = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds16);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKh, R.color.cp_bg_line_h);
            } else {
                this.kKd.getLayoutParams().height = 0;
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKh, R.color.cp_bg_line_e);
            }
            if (nVar.isDynamic) {
                this.kKi.setVisibility(0);
                this.kKg.setVisibility(8);
            } else {
                this.kKi.setVisibility(8);
                this.kKg.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKh, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKe, R.color.cp_bg_line_d);
            this.kJY.onChangeSkinType(i);
            this.kJZ.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kKf, R.color.cp_cont_b);
            if (this.kKm != null && this.kKm.UM == com.baidu.tieba.pb.data.n.kxZ) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJY, R.color.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kKb, R.color.cp_cont_j);
            this.kKb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
            this.kKa.onChangeSkinType();
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKc, R.color.cp_bg_line_c);
            if (this.Xx) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kKd, R.drawable.personalize_tab_shadow);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKh, R.color.cp_bg_line_h);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kKh, R.color.cp_bg_line_e);
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kKi, R.color.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    public void m(BdUniqueId bdUniqueId) {
        this.kKn = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.dUB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dUB);
    }

    public void v(BdUniqueId bdUniqueId) {
        this.kKo = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.kKr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kKr);
    }

    public void U(View.OnClickListener onClickListener) {
        this.kKl = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kAr = aVar;
    }

    public void w(BdUniqueId bdUniqueId) {
        if (this.kKa != null) {
            this.kKa.setListenerTag(bdUniqueId);
            this.kKa.setCommenId(bdUniqueId);
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
