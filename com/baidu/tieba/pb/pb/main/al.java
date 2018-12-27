package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class al extends q.a {
    private CustomMessageListener aof;
    public TextLineView gea;
    public TextLineView geb;
    public TextView gec;
    public TextView ged;
    public View gee;
    public View gef;
    public View geg;
    public TextLineView geh;
    public View gei;
    private com.baidu.tieba.pb.pb.godreply.usertips.a gej;
    private List<TextLineView> gek;
    private int gel;
    private View.OnClickListener gem;
    private com.baidu.tieba.pb.data.h gen;
    private BdUniqueId gep;
    private BdUniqueId geq;
    private View.OnClickListener ger;
    private View.OnClickListener ges;
    private CustomMessageListener get;
    private View mRootView;
    public int mSkinType;

    public al(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.gej = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.gel = 0;
        this.ger = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.gem != null) {
                    al.this.gem.onClick(view2);
                }
                if (com.baidu.adp.lib.util.j.kV()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        for (TextLineView textLineView : al.this.gek) {
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
        this.ges = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (al.this.gem != null) {
                    al.this.gem.onClick(view2);
                }
            }
        };
        this.aof = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.gen != null && al.this.gen.mType == com.baidu.tieba.pb.data.h.fTw && customResponsedMessage != null && getTag() == al.this.gep && (customResponsedMessage.getData() instanceof ar.a)) {
                    ((ar.a) customResponsedMessage.getData()).ghE = al.this;
                }
            }
        };
        this.get = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.al.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (al.this.gen != null && al.this.gen.mType == com.baidu.tieba.pb.data.h.fTx && customResponsedMessage != null && getTag() == al.this.geq && (customResponsedMessage.getData() instanceof ar.a) && al.this.mRootView != null && al.this.gej.bij() && al.this.ged != null && al.this.ged.getVisibility() == 0) {
                    if (al.this.mRootView == null || al.this.mRootView.getParent() == null) {
                        al.this.gej.hideTip();
                        return;
                    }
                    if (!al.this.gej.bij() && !com.baidu.tieba.pb.pb.godreply.usertips.b.cS(al.this.mRootView.getContext())) {
                        al.this.gej.showTip(al.this.ged);
                    }
                    if (al.this.gej.bij()) {
                        al.this.gej.bu(al.this.ged);
                    }
                }
            }
        };
        if (view != null) {
            this.mRootView = view;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            this.gea = (TextLineView) view.findViewById(e.g.reply_title);
            this.gea.setOnClickListener(this.ger);
            this.geg = view.findViewById(e.g.reply_god_title_group);
            this.geh = (TextLineView) view.findViewById(e.g.reply_god_title);
            this.geh.setSelected(false);
            this.gei = view.findViewById(e.g.reply_all_title);
            this.geb = (TextLineView) view.findViewById(e.g.floor_owner_reply);
            this.geb.setOnClickListener(this.ger);
            this.gec = (TextView) view.findViewById(e.g.pb_sort);
            this.gec.setOnClickListener(this.ges);
            this.ged = (TextView) view.findViewById(e.g.pb_god_reply_entrance_text);
            this.gea.setSelected(true);
            this.geb.setSelected(false);
            this.gek = new ArrayList();
            this.gek.add(this.gea);
            this.gek.add(this.geb);
            this.gee = view.findViewById(e.g.divider_with_reply_title);
            this.gef = view.findViewById(e.g.divider_bottom);
            if (com.baidu.tbadk.util.a.PJ().Gg()) {
                ae(2, "");
            } else {
                ae(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ae(int i, String str) {
        this.gel = i;
        this.gec.setVisibility(0);
        if (str.length() > 0) {
            this.gec.setText(str);
        } else if (this.gel == 0) {
            this.gec.setText(e.j.default_sort);
        } else if (this.gel == 1) {
            this.gec.setText(e.j.view_reverse);
        } else if (this.gel == 2) {
            this.gec.setText(e.j.view_hot);
        }
    }

    public void li(boolean z) {
        if (z) {
            this.geb.setSelected(true);
            this.gea.setSelected(false);
            return;
        }
        this.geb.setSelected(false);
        this.gea.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.gen = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fTx) {
                final Context context = this.geg.getContext();
                if (TextUtils.isEmpty(hVar.fTz)) {
                    this.gei.setVisibility(0);
                    this.geg.setVisibility(8);
                    this.gea.setVisibility(0);
                    this.gea.setSelected(false);
                    this.gea.setClickable(false);
                    this.gea.setText(TbadkCoreApplication.getInst().getString(e.j.god_reply));
                } else {
                    this.gei.setVisibility(8);
                    this.gea.setVisibility(8);
                    this.geg.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.al.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.l(context, true);
                            al.this.gej.hideTip();
                            if (al.this.gem != null) {
                                al.this.gem.onClick(al.this.geg);
                            }
                        }
                    };
                    this.geg.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.cS(context) && this.ged != null && this.ged.getVisibility() == 0 && !this.gej.bij()) {
                        this.gej.J(onClickListener);
                        this.gej.showTip(this.ged);
                    }
                }
                this.gec.setVisibility(8);
                this.geb.setVisibility(8);
                this.gef.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fTw) {
                this.geg.setVisibility(8);
                this.gei.setVisibility(0);
                this.gea.setClickable(true);
                this.gea.setText(TbadkCoreApplication.getInst().getString(e.j.all_reply));
                this.gec.setVisibility(0);
                this.geb.setVisibility(0);
                li(hVar.fTB);
                ae(hVar.sortType, hVar.fTA);
                this.gef.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.j(getView(), e.d.cp_bg_line_d);
            this.gea.onChangeSkinType(i);
            this.geb.onChangeSkinType(i);
            com.baidu.tbadk.core.util.al.h(this.geh, e.d.cp_cont_b);
            if (this.gen != null && this.gen.mType == com.baidu.tieba.pb.data.h.fTx) {
                com.baidu.tbadk.core.util.al.c(this.gea, e.d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.al.h(this.ged, e.d.cp_cont_j);
            this.ged.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.al.h(this.gec, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.j(this.gee, e.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.al.j(this.gef, e.d.cp_bg_line_c);
            this.gec.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_sort), (Drawable) null);
            this.gej.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.gep = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.aof.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aof);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.geq = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.get.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.get);
    }

    public void L(View.OnClickListener onClickListener) {
        this.gem = onClickListener;
    }
}
