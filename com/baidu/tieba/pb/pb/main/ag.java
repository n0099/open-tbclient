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
    private CustomMessageListener SH;
    public TextLineView eIj;
    public TextLineView eIk;
    public TextView eIl;
    public View eIm;
    public View eIn;
    private List<TextLineView> eIo;
    private int eIp;
    private View.OnClickListener eIq;
    private com.baidu.tieba.pb.data.j eIr;
    private int eIs;
    private View.OnClickListener eIt;
    private View.OnClickListener eIu;
    private TbPageContext mH;
    public int mSkinType;

    public ag(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eIp = 0;
        this.eIt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ag.this.eIq != null) {
                    ag.this.eIq.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ag.this.eIo) {
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
        this.eIu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ag.this.eIq != null) {
                    ag.this.eIq.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    ag.this.jm(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.SH = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.ag.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ag.this.eIr != null && ag.this.eIr.mType == com.baidu.tieba.pb.data.j.eyN && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.eyN && (customResponsedMessage.getData() instanceof an.a)) {
                    ((an.a) customResponsedMessage.getData()).eLF = ag.this;
                }
            }
        };
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.mH = tbPageContext;
            this.eIj = (TextLineView) view.findViewById(d.h.reply_title);
            this.eIj.setOnClickListener(this.eIt);
            this.eIk = (TextLineView) view.findViewById(d.h.floor_owner_reply);
            this.eIk.setOnClickListener(this.eIt);
            this.eIl = (TextView) view.findViewById(d.h.pb_sort);
            this.eIl.setOnClickListener(this.eIu);
            this.eIj.setSelected(true);
            this.eIk.setSelected(false);
            this.eIo = new ArrayList();
            this.eIo.add(this.eIj);
            this.eIo.add(this.eIk);
            this.eIm = view.findViewById(d.h.divider_with_reply_title);
            this.eIn = view.findViewById(d.h.divider_bottom);
            this.eIs = UtilHelper.getLightStatusBarHeight();
            jm(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void jm(boolean z) {
        this.eIp = z ? 0 : 1;
        this.eIl.setVisibility(0);
        if (this.eIp == 1) {
            this.eIl.setText(d.l.pb_sort_old);
        } else if (this.eIp == 0) {
            this.eIl.setText(d.l.pb_sort_new);
        }
    }

    public void jn(boolean z) {
        if (z) {
            this.eIk.setSelected(true);
            this.eIj.setSelected(false);
            return;
        }
        this.eIk.setSelected(false);
        this.eIj.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.eIr = jVar;
        if (jVar != null) {
            if (jVar.mType == com.baidu.tieba.pb.data.j.eyO) {
                this.eIj.setSelected(false);
                this.eIj.setClickable(false);
                this.eIj.setText(TbadkCoreApplication.getInst().getString(d.l.god_reply));
                this.eIl.setVisibility(8);
                this.eIk.setVisibility(8);
                this.eIn.setVisibility(8);
            } else if (jVar.mType == com.baidu.tieba.pb.data.j.eyN) {
                this.eIj.setClickable(true);
                this.eIj.setText(TbadkCoreApplication.getInst().getString(d.l.all_reply));
                this.eIl.setVisibility(0);
                this.eIk.setVisibility(0);
                jn(jVar.eyQ);
                jm(jVar.aEt);
                this.eIn.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.k(getView(), d.e.cp_bg_line_d);
            this.eIj.onChangeSkinType(i);
            this.eIk.onChangeSkinType(i);
            if (this.eIr != null && this.eIr.mType == com.baidu.tieba.pb.data.j.eyO) {
                com.baidu.tbadk.core.util.aj.c(this.eIj, d.e.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.i(this.eIl, d.e.cp_cont_d);
            com.baidu.tbadk.core.util.aj.k(this.eIm, d.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aj.k(this.eIn, d.e.cp_bg_line_c);
            this.eIl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.g.icon_pb_sort), (Drawable) null);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.SH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.SH);
    }

    public void D(View.OnClickListener onClickListener) {
        this.eIq = onClickListener;
    }
}
