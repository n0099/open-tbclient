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
    public TextLineView eQT;
    public TextLineView eQU;
    public TextView eQV;
    public TextView eQW;
    public View eQX;
    public View eQY;
    public View eQZ;
    public TextLineView eRa;
    public View eRb;
    private List<TextLineView> eRc;
    private int eRd;
    private View.OnClickListener eRe;
    private com.baidu.tieba.pb.data.j eRf;
    private View.OnClickListener eRg;
    private View.OnClickListener eRh;
    public int mSkinType;

    public ai(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.eRd = 0;
        this.eRg = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ai.this.eRe != null) {
                    ai.this.eRe.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ai.this.eRc) {
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
        this.eRh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ai.this.eRe != null) {
                    ai.this.eRe.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.hh() && view2 != null && (view2.getTag() instanceof Boolean)) {
                    ai.this.jg(!((Boolean) view2.getTag()).booleanValue());
                }
            }
        };
        this.Tc = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.pb.pb.main.ai.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ai.this.eRf != null && ai.this.eRf.mType == com.baidu.tieba.pb.data.j.eGO && customResponsedMessage != null && getTag() == com.baidu.tieba.pb.data.j.eGO && (customResponsedMessage.getData() instanceof ap.a)) {
                    ((ap.a) customResponsedMessage.getData()).eUu = ai.this;
                }
            }
        };
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.eQT = (TextLineView) view.findViewById(d.g.reply_title);
            this.eQT.setOnClickListener(this.eRg);
            this.eQZ = view.findViewById(d.g.reply_god_title_group);
            this.eRa = (TextLineView) view.findViewById(d.g.reply_god_title);
            this.eRa.setSelected(false);
            this.eRb = view.findViewById(d.g.reply_all_title);
            this.eQU = (TextLineView) view.findViewById(d.g.floor_owner_reply);
            this.eQU.setOnClickListener(this.eRg);
            this.eQV = (TextView) view.findViewById(d.g.pb_sort);
            this.eQV.setOnClickListener(this.eRh);
            this.eQW = (TextView) view.findViewById(d.g.pb_god_reply_entrance_text);
            this.eQT.setSelected(true);
            this.eQU.setSelected(false);
            this.eRc = new ArrayList();
            this.eRc.add(this.eQT);
            this.eRc.add(this.eQU);
            this.eQX = view.findViewById(d.g.divider_with_reply_title);
            this.eQY = view.findViewById(d.g.divider_bottom);
            jg(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void jg(boolean z) {
        this.eRd = z ? 0 : 1;
        this.eQV.setVisibility(0);
        if (this.eRd == 1) {
            this.eQV.setText(d.j.default_sort);
        } else if (this.eRd == 0) {
            this.eQV.setText(d.j.view_reverse);
        }
    }

    public void jh(boolean z) {
        if (z) {
            this.eQU.setSelected(true);
            this.eQT.setSelected(false);
            return;
        }
        this.eQU.setSelected(false);
        this.eQT.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.j jVar) {
        this.eRf = jVar;
        if (jVar != null) {
            if (jVar.mType == com.baidu.tieba.pb.data.j.eGP) {
                if (TextUtils.isEmpty(jVar.eGR)) {
                    this.eRb.setVisibility(0);
                    this.eQZ.setVisibility(8);
                    this.eQT.setVisibility(0);
                    this.eQT.setSelected(false);
                    this.eQT.setClickable(false);
                    this.eQT.setText(TbadkCoreApplication.getInst().getString(d.j.god_reply));
                } else {
                    this.eRb.setVisibility(8);
                    this.eQT.setVisibility(8);
                    this.eQZ.setVisibility(0);
                    this.eQZ.setOnClickListener(this.eRe);
                }
                this.eQV.setVisibility(8);
                this.eQU.setVisibility(8);
                this.eQY.setVisibility(8);
            } else if (jVar.mType == com.baidu.tieba.pb.data.j.eGO) {
                this.eQZ.setVisibility(8);
                this.eRb.setVisibility(0);
                this.eQT.setClickable(true);
                this.eQT.setText(TbadkCoreApplication.getInst().getString(d.j.all_reply));
                this.eQV.setVisibility(0);
                this.eQU.setVisibility(0);
                jh(jVar.eGS);
                jg(jVar.aFc);
                this.eQY.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.k(getView(), d.C0080d.cp_bg_line_d);
            this.eQT.onChangeSkinType(i);
            this.eQU.onChangeSkinType(i);
            this.eRa.onChangeSkinType(i);
            if (this.eRf != null && this.eRf.mType == com.baidu.tieba.pb.data.j.eGP) {
                com.baidu.tbadk.core.util.aj.c(this.eQT, d.C0080d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.aj.i(this.eQW, d.C0080d.cp_cont_d);
            this.eQW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_arrow_more_gray), (Drawable) null);
            com.baidu.tbadk.core.util.aj.i(this.eQV, d.C0080d.cp_cont_j);
            com.baidu.tbadk.core.util.aj.k(this.eQX, d.C0080d.cp_bg_line_c);
            com.baidu.tbadk.core.util.aj.k(this.eQY, d.C0080d.cp_bg_line_c);
            this.eQV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_sort), (Drawable) null);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.Tc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Tc);
    }

    public void E(View.OnClickListener onClickListener) {
        this.eRe = onClickListener;
    }
}
