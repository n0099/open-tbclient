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
public class ah extends j.a {
    private CustomMessageListener SH;
    public TextLineView eNN;
    public TextLineView eNO;
    public TextView eNP;
    public View eNQ;
    public View eNR;
    private List<TextLineView> eNS;
    private int eNT;
    private View.OnClickListener eNU;
    private com.baidu.tieba.pb.data.j eNV;
    private int eNW;
    private View.OnClickListener eNX;
    private View.OnClickListener eNY;
    private TbPageContext mF;
    public int mSkinType;

    public ah(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eNT = 0;
        this.eNX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ah.this.eNU != null) {
                    ah.this.eNU.onClick(view2);
                }
                if (com.baidu.adp.lib.util.i.hi()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ah.this.eNS) {
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
        this.eNY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ah.this.eNU != null) {
                    ah.this.eNU.onClick(view2);
                }
                if (com.baidu.adp.lib.util.i.hi() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    ah.this.jA(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.SH = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.ah.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ah.this.eNV != null && ah.this.eNV.mType == com.baidu.tieba.pb.data.j.eEL && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.eEL && (customResponsedMessage.getData() instanceof an.a)) {
                    ((an.a) customResponsedMessage.getData()).eRp = ah.this;
                }
            }
        };
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.mF = tbPageContext;
            this.eNN = (TextLineView) view.findViewById(d.h.reply_title);
            this.eNN.setOnClickListener(this.eNX);
            this.eNO = (TextLineView) view.findViewById(d.h.floor_owner_reply);
            this.eNO.setOnClickListener(this.eNX);
            this.eNP = (TextView) view.findViewById(d.h.pb_sort);
            this.eNP.setOnClickListener(this.eNY);
            this.eNN.setSelected(true);
            this.eNO.setSelected(false);
            this.eNS = new ArrayList();
            this.eNS.add(this.eNN);
            this.eNS.add(this.eNO);
            this.eNQ = view.findViewById(d.h.divider_with_reply_title);
            this.eNR = view.findViewById(d.h.divider_bottom);
            this.eNW = UtilHelper.getLightStatusBarHeight();
            jA(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void jA(boolean z) {
        this.eNT = z ? 0 : 1;
        this.eNP.setVisibility(0);
        if (this.eNT == 1) {
            this.eNP.setText(d.l.pb_sort_old);
        } else if (this.eNT == 0) {
            this.eNP.setText(d.l.pb_sort_new);
        }
    }

    public void jB(boolean z) {
        if (z) {
            this.eNO.setSelected(true);
            this.eNN.setSelected(false);
            return;
        }
        this.eNO.setSelected(false);
        this.eNN.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.eNV = jVar;
        if (jVar != null) {
            if (jVar.mType == com.baidu.tieba.pb.data.j.eEM) {
                this.eNN.setSelected(false);
                this.eNN.setClickable(false);
                this.eNN.setText(TbadkCoreApplication.getInst().getString(d.l.god_reply));
                this.eNP.setVisibility(8);
                this.eNO.setVisibility(8);
                this.eNR.setVisibility(8);
            } else if (jVar.mType == com.baidu.tieba.pb.data.j.eEL) {
                this.eNN.setClickable(true);
                this.eNN.setText(TbadkCoreApplication.getInst().getString(d.l.all_reply));
                this.eNP.setVisibility(0);
                this.eNO.setVisibility(0);
                jB(jVar.eEO);
                jA(jVar.aFp);
                this.eNR.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.k(getView(), d.e.cp_bg_line_d);
            if (this.eNV != null && this.eNV.mType == com.baidu.tieba.pb.data.j.eEM) {
                com.baidu.tbadk.core.util.aj.c(this.eNN, d.e.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.i(this.eNP, d.e.cp_cont_d);
            com.baidu.tbadk.core.util.aj.k(this.eNQ, d.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aj.k(this.eNR, d.e.cp_bg_line_c);
            this.eNP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_pb_sort), (Drawable) null);
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.SH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.SH);
    }

    public void B(View.OnClickListener onClickListener) {
        this.eNU = onClickListener;
    }
}
