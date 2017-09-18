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
    public TextLineView eOH;
    public TextLineView eOI;
    public TextView eOJ;
    public View eOK;
    public View eOL;
    private List<TextLineView> eOM;
    private int eON;
    private View.OnClickListener eOO;
    private com.baidu.tieba.pb.data.j eOP;
    private int eOQ;
    private View.OnClickListener eOR;
    private View.OnClickListener eOS;
    private TbPageContext mF;
    public int mSkinType;

    public ah(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eON = 0;
        this.eOR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ah.this.eOO != null) {
                    ah.this.eOO.onClick(view2);
                }
                if (com.baidu.adp.lib.util.i.hi()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ah.this.eOM) {
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
        this.eOS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ah.this.eOO != null) {
                    ah.this.eOO.onClick(view2);
                }
                if (com.baidu.adp.lib.util.i.hi() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    ah.this.jB(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.SH = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.ah.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ah.this.eOP != null && ah.this.eOP.mType == com.baidu.tieba.pb.data.j.eFF && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.eFF && (customResponsedMessage.getData() instanceof an.a)) {
                    ((an.a) customResponsedMessage.getData()).eSj = ah.this;
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
            this.eOH = (TextLineView) view.findViewById(d.h.reply_title);
            this.eOH.setOnClickListener(this.eOR);
            this.eOI = (TextLineView) view.findViewById(d.h.floor_owner_reply);
            this.eOI.setOnClickListener(this.eOR);
            this.eOJ = (TextView) view.findViewById(d.h.pb_sort);
            this.eOJ.setOnClickListener(this.eOS);
            this.eOH.setSelected(true);
            this.eOI.setSelected(false);
            this.eOM = new ArrayList();
            this.eOM.add(this.eOH);
            this.eOM.add(this.eOI);
            this.eOK = view.findViewById(d.h.divider_with_reply_title);
            this.eOL = view.findViewById(d.h.divider_bottom);
            this.eOQ = UtilHelper.getLightStatusBarHeight();
            jB(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void jB(boolean z) {
        this.eON = z ? 0 : 1;
        this.eOJ.setVisibility(0);
        if (this.eON == 1) {
            this.eOJ.setText(d.l.pb_sort_old);
        } else if (this.eON == 0) {
            this.eOJ.setText(d.l.pb_sort_new);
        }
    }

    public void jC(boolean z) {
        if (z) {
            this.eOI.setSelected(true);
            this.eOH.setSelected(false);
            return;
        }
        this.eOI.setSelected(false);
        this.eOH.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.eOP = jVar;
        if (jVar != null) {
            if (jVar.mType == com.baidu.tieba.pb.data.j.eFG) {
                this.eOH.setSelected(false);
                this.eOH.setClickable(false);
                this.eOH.setText(TbadkCoreApplication.getInst().getString(d.l.god_reply));
                this.eOJ.setVisibility(8);
                this.eOI.setVisibility(8);
                this.eOL.setVisibility(8);
            } else if (jVar.mType == com.baidu.tieba.pb.data.j.eFF) {
                this.eOH.setClickable(true);
                this.eOH.setText(TbadkCoreApplication.getInst().getString(d.l.all_reply));
                this.eOJ.setVisibility(0);
                this.eOI.setVisibility(0);
                jC(jVar.eFI);
                jB(jVar.aFm);
                this.eOL.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.k(getView(), d.e.cp_bg_line_d);
            if (this.eOP != null && this.eOP.mType == com.baidu.tieba.pb.data.j.eFG) {
                com.baidu.tbadk.core.util.aj.c(this.eOH, d.e.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.i(this.eOJ, d.e.cp_cont_d);
            com.baidu.tbadk.core.util.aj.k(this.eOK, d.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aj.k(this.eOL, d.e.cp_bg_line_c);
            this.eOJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_pb_sort), (Drawable) null);
        }
        this.mSkinType = i;
    }

    public void i(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.SH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.SH);
    }

    public void B(View.OnClickListener onClickListener) {
        this.eOO = onClickListener;
    }
}
