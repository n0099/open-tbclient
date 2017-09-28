package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.an;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends j.a {
    private CustomMessageListener SV;
    public View eIA;
    public View eIB;
    private List<TextLineView> eIC;
    private int eID;
    private View.OnClickListener eIE;
    private com.baidu.tieba.pb.data.j eIF;
    private int eIG;
    private View.OnClickListener eIH;
    private View.OnClickListener eII;
    public TextLineView eIx;
    public TextLineView eIy;
    public TextView eIz;
    private TbPageContext mG;
    public int mSkinType;

    public ag(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eID = 0;
        this.eIH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ag.this.eIE != null) {
                    ag.this.eIE.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ag.this.eIC) {
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
        this.eII = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ag.this.eIE != null) {
                    ag.this.eIE.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    ag.this.jn(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.SV = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.ag.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ag.this.eIF != null && ag.this.eIF.mType == com.baidu.tieba.pb.data.j.ezb && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.ezb && (customResponsedMessage.getData() instanceof an.a)) {
                    ((an.a) customResponsedMessage.getData()).eLT = ag.this;
                }
            }
        };
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.mG = tbPageContext;
            this.eIx = (TextLineView) view.findViewById(d.h.reply_title);
            this.eIx.setOnClickListener(this.eIH);
            this.eIy = (TextLineView) view.findViewById(d.h.floor_owner_reply);
            this.eIy.setOnClickListener(this.eIH);
            this.eIz = (TextView) view.findViewById(d.h.pb_sort);
            this.eIz.setOnClickListener(this.eII);
            this.eIx.setSelected(true);
            this.eIy.setSelected(false);
            this.eIC = new ArrayList();
            this.eIC.add(this.eIx);
            this.eIC.add(this.eIy);
            this.eIA = view.findViewById(d.h.divider_with_reply_title);
            this.eIB = view.findViewById(d.h.divider_bottom);
            this.eIG = UtilHelper.getLightStatusBarHeight();
            jn(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void jn(boolean z) {
        this.eID = z ? 0 : 1;
        this.eIz.setVisibility(0);
        if (this.eID == 1) {
            this.eIz.setText(d.l.pb_sort_old);
        } else if (this.eID == 0) {
            this.eIz.setText(d.l.pb_sort_new);
        }
    }

    public void jo(boolean z) {
        if (z) {
            this.eIy.setSelected(true);
            this.eIx.setSelected(false);
            return;
        }
        this.eIy.setSelected(false);
        this.eIx.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.eIF = jVar;
        if (jVar != null) {
            if (jVar.mType == com.baidu.tieba.pb.data.j.ezc) {
                this.eIx.setSelected(false);
                this.eIx.setClickable(false);
                this.eIx.setText(TbadkCoreApplication.getInst().getString(d.l.god_reply));
                this.eIz.setVisibility(8);
                this.eIy.setVisibility(8);
                this.eIB.setVisibility(8);
            } else if (jVar.mType == com.baidu.tieba.pb.data.j.ezb) {
                this.eIx.setClickable(true);
                this.eIx.setText(TbadkCoreApplication.getInst().getString(d.l.all_reply));
                this.eIz.setVisibility(0);
                this.eIy.setVisibility(0);
                jo(jVar.eze);
                jn(jVar.aEG);
                this.eIB.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.k(getView(), d.e.cp_bg_line_d);
            this.eIx.onChangeSkinType(i);
            this.eIy.onChangeSkinType(i);
            if (this.eIF != null && this.eIF.mType == com.baidu.tieba.pb.data.j.ezc) {
                com.baidu.tbadk.core.util.aj.c(this.eIx, d.e.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.i(this.eIz, d.e.cp_cont_d);
            com.baidu.tbadk.core.util.aj.k(this.eIA, d.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aj.k(this.eIB, d.e.cp_bg_line_c);
            this.eIz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_pb_sort), (Drawable) null);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.SV.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.SV);
    }

    public void D(View.OnClickListener onClickListener) {
        this.eIE = onClickListener;
    }
}
