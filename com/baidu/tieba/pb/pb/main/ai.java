package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ai extends j.a {
    private CustomMessageListener Tc;
    private View.OnClickListener eRA;
    private View.OnClickListener eRB;
    public TextLineView eRn;
    public TextLineView eRo;
    public TextView eRp;
    public TextView eRq;
    public View eRr;
    public View eRs;
    public View eRt;
    public TextLineView eRu;
    public View eRv;
    private List<TextLineView> eRw;
    private int eRx;
    private View.OnClickListener eRy;
    private com.baidu.tieba.pb.data.j eRz;
    public int mSkinType;

    public ai(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eRx = 0;
        this.eRA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ai.this.eRy != null) {
                    ai.this.eRy.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ai.this.eRw) {
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
        this.eRB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ai.this.eRy != null) {
                    ai.this.eRy.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    ai.this.jm(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.Tc = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.ai.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ai.this.eRz != null && ai.this.eRz.mType == com.baidu.tieba.pb.data.j.eHi && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.eHi && (customResponsedMessage.getData() instanceof ap.a)) {
                    ((ap.a) customResponsedMessage.getData()).eUP = ai.this;
                }
            }
        };
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.eRn = (TextLineView) view.findViewById(d.g.reply_title);
            this.eRn.setOnClickListener(this.eRA);
            this.eRt = view.findViewById(d.g.reply_god_title_group);
            this.eRu = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.eRu.setSelected(false);
            this.eRv = view.findViewById(d.g.reply_all_title);
            this.eRo = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.eRo.setOnClickListener(this.eRA);
            this.eRp = (TextView) view.findViewById(d.g.pb_sort);
            this.eRp.setOnClickListener(this.eRB);
            this.eRq = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.eRn.setSelected(true);
            this.eRo.setSelected(false);
            this.eRw = new ArrayList();
            this.eRw.add(this.eRn);
            this.eRw.add(this.eRo);
            this.eRr = view.findViewById(d.g.divider_with_reply_title);
            this.eRs = view.findViewById(d.g.divider_bottom);
            jm(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void jm(boolean z) {
        this.eRx = z ? 0 : 1;
        this.eRp.setVisibility(0);
        if (this.eRx == 1) {
            this.eRp.setText(d.j.default_sort);
        } else if (this.eRx == 0) {
            this.eRp.setText(d.j.view_reverse);
        }
    }

    public void jn(boolean z) {
        if (z) {
            this.eRo.setSelected(true);
            this.eRn.setSelected(false);
            return;
        }
        this.eRo.setSelected(false);
        this.eRn.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.eRz = jVar;
        if (jVar != null) {
            if (jVar.mType == com.baidu.tieba.pb.data.j.eHj) {
                if (TextUtils.isEmpty(jVar.eHl)) {
                    this.eRv.setVisibility(0);
                    this.eRt.setVisibility(8);
                    this.eRn.setVisibility(0);
                    this.eRn.setSelected(false);
                    this.eRn.setClickable(false);
                    this.eRn.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.eRv.setVisibility(8);
                    this.eRn.setVisibility(8);
                    this.eRt.setVisibility(0);
                    this.eRt.setOnClickListener(this.eRy);
                }
                this.eRp.setVisibility(8);
                this.eRo.setVisibility(8);
                this.eRs.setVisibility(8);
            } else if (jVar.mType == com.baidu.tieba.pb.data.j.eHi) {
                this.eRt.setVisibility(8);
                this.eRv.setVisibility(0);
                this.eRn.setClickable(true);
                this.eRn.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.eRp.setVisibility(0);
                this.eRo.setVisibility(0);
                jn(jVar.eHm);
                jm(jVar.aFk);
                this.eRs.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.k(getView(), d.C0080d.cp_bg_line_d);
            this.eRn.onChangeSkinType(i);
            this.eRo.onChangeSkinType(i);
            this.eRu.onChangeSkinType(i);
            if (this.eRz != null && this.eRz.mType == com.baidu.tieba.pb.data.j.eHj) {
                com.baidu.tbadk.core.util.aj.c(this.eRn, d.C0080d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.i(this.eRq, d.C0080d.cp_cont_d);
            this.eRq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_arrow_more_gray), (Drawable) null);
            com.baidu.tbadk.core.util.aj.i(this.eRp, d.C0080d.cp_cont_j);
            com.baidu.tbadk.core.util.aj.k(this.eRr, d.C0080d.cp_bg_line_c);
            com.baidu.tbadk.core.util.aj.k(this.eRs, d.C0080d.cp_bg_line_c);
            this.eRp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_sort), (Drawable) null);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.Tc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Tc);
    }

    public void E(View.OnClickListener onClickListener) {
        this.eRy = onClickListener;
    }
}
